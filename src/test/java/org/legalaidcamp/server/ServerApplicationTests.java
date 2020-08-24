package org.legalaidcamp.server;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.legalaidcamp.server.models.*;
import org.legalaidcamp.server.repositories.AreaOfLawRepository;
import org.legalaidcamp.server.repositories.LanguageRepository;
import org.legalaidcamp.server.repositories.LawyerRepository;
import org.legalaidcamp.server.repositories.UserRepository;
import org.legalaidcamp.server.services.LawyerService;
import org.legalaidcamp.server.services.UserService;
import org.legalaidcamp.server.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ServerApplicationTests {

	/*
	Integration tests
	 */
	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UtilityService utilityService;

	@Autowired
	AreaOfLawRepository areaOfLawRepository;

	@Autowired
	LanguageRepository languageRepository;

	@Autowired
	LawyerService lawyerService;

	@Autowired
	LawyerRepository lawyerRepository;


	@Test
	void contextLoads() {
	}


	@Test
	void createAndDeleteUserTest() {
		UserData userData = new UserData("Rohan Bojja", "rohanbojja@gmail.com", "90302", "yourMom.jpeg");
		//Assign values or initialize
		String uid = "696969";
		User user = userService.createUser(uid,userData);
		assertThat(user.getUid()).isEqualTo(uid);
		assertThat(user.getDisplayName()).isSameAs(userData.getDisplayName());
		userRepository.findById("696969").map(
				value ->{
					assertThat(value.getDisplayName()).isEqualTo(userData.getDisplayName());
					assertThat(value.getPhoneNumber()).isEqualTo(userData.getPhoneNumber());
					return null;
				}
		);
		userRepository.deleteById(uid);
		userRepository.findById("696969").ifPresent(
				value -> {
					assert false;
				}
		);
	}

	@Test
	void createUserAndApplyForLawyer(){
		UserData userData = new UserData("Rohan Bojja", "rohanbojja@gmail.com", "90302", "yourMom.jpeg");
		//Assign values or initialize
		String uid = "696969";
		User user = userService.createUser(uid,userData);
		assertThat(user.getUid()).isSameAs(uid);
		assertThat(user.getDisplayName()).isSameAs(userData.getDisplayName());
		List<Long> longs = new ArrayList<>();
		longs.add(1L);
		longs.add(2L);
		LawyerData lawyerData = new LawyerData(longs,0L,"Address","500036",true,true,true, longs, 2L,"Hyderabad", 2L);
		lawyerService.createLawyer(uid,lawyerData).ifPresentOrElse(
				value ->{
					assertThat(value.getUid()).isEqualTo(uid);
					assertThat(value.getCity()).isEqualTo("Hyderabad");
					assertThat(value.getAllowCalls()).isTrue();
					assertThat(value.getVerified()).isFalse();
		}, () ->{
					assert false;
				});
		lawyerRepository.findById(uid).ifPresentOrElse(
				value -> {
					assertThat(value.getUid()).isEqualTo(uid);
					assertThat(value.getCity()).isEqualTo("Hyderabad");
					assertThat(value.getAllowCalls()).isTrue();
					assertThat(value.getVerified()).isFalse();
				},() -> {
					assert false;
				}
		);
		lawyerRepository.deleteById(uid);
		lawyerRepository.findById(uid).ifPresentOrElse(
				value -> {
					assert false;
				},() -> {
					assert true;
				}
		);
	}
}
