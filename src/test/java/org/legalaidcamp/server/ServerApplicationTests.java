package org.legalaidcamp.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.*;
import org.legalaidcamp.server.models.*;
import org.legalaidcamp.server.repositories.*;
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

	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	UtilityService utilityService;

	@Autowired
	UserService userService;

	@Autowired
	LawyerService lawyerService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CourtCaseRepository courtCaseRepository;

	@Autowired
	AreaOfLawRepository areaOfLawRepository;

	@Autowired
	LanguageRepository languageRepository;


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
	void createUserAndApplyForLawyerTest(){
		UserData userData = new UserData("Rohan Bojja", "rohanbojja@gmail.com", "90302", "yourMom.jpeg");
		//Assign values or initialize
		String uid = "696969";
		User user = userService.createUser(uid,userData);
		assertThat(user.getUid()).isSameAs(uid);
		assertThat(user.getDisplayName()).isSameAs(userData.getDisplayName());
		Set<Long> longs = new HashSet<>();
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

	@Test
	void createCase(){
		UserData userData = new UserData("Client", "sd@gmail.com", "90302", "asdasd.jpeg");
		//Assign values or initialize
		String uid = "1234";
		User user = userService.createUser(uid,userData);
		assertThat(user.getUid()).isSameAs(uid);
		assertThat(user.getDisplayName()).isSameAs(userData.getDisplayName());

		//Create a case
		CourtCaseData courtCaseData = new CourtCaseData("A offended me.", 2L, "Meerut", 3L, 7L, 0L, "1234");
		CourtCase courtCase = userService.createCase("1234", courtCaseData);
		assertThat(courtCase.getCity()).isNotNull();
		assertThat(courtCase.getAssignedLawyers().isEmpty()).isFalse();
	}

	@Test
	void createLawyerUserCaseTest(){
		//Create a lawyer
		UserData userData = new UserData("Lawyer", "lawyer@gmail.com", "90302", "yourMom.jpeg");
		//Assign values or initialize
		String uid = "6969";
		User user = userService.createUser(uid,userData);
		assertThat(user.getUid()).isSameAs(uid);
		assertThat(user.getDisplayName()).isSameAs(userData.getDisplayName());
		Set<Long> longs = new HashSet<>();
		longs.add(1L);
		longs.add(2L);
		LawyerData lawyerData = new LawyerData(longs,1L,"Address","500036",true,true,true, longs, 3L,"Hyderabad", 2L);
		Lawyer lawyer = lawyerService.createLawyer(uid,lawyerData).orElseThrow();

		//Create second user
		UserData userData2 = new UserData("Client", "sd@gmail.com", "90302", "asdasd.jpeg");
		//Assign values or initialize
		String uid2 = "1234";
		User user2 = userService.createUser(uid2,userData2);
		assertThat(user2.getUid()).isSameAs(uid2);
		assertThat(user2.getDisplayName()).isSameAs(userData2.getDisplayName());

		//Create a case
		CourtCaseData courtCaseData = new CourtCaseData("A offended me.", 2L, "Meerut", 3L, 7L, 0L, "1234");


		lawyerRepository.findById(uid).ifPresentOrElse(
				value -> {
					assertThat(value.getGender()).isEqualTo(1L);
					assertThat(value.getAssignedCases()).isEmpty();


				},() -> {
					assert false;
				}
		);
		CourtCase courtCase = userService.createCase("1234", courtCaseData);
		assertThat(courtCase.getCity()).isEqualTo("Meerut");
		assertThat(courtCase.getAssignedLawyers().isEmpty()).isFalse();

		lawyerRepository.findById(uid).ifPresentOrElse(
				value -> {
					assertThat(value.getGender()).isEqualTo(1L);
					assertThat(value.getAssignedCases().size()).isGreaterThan(0);
				},() -> {
					assert false;
				}
		);

		courtCaseRepository.findById(courtCase.getId()).ifPresent(
				value -> {
						assertThat(value.getCity()).isEqualTo("Meerut");
						assertThat(value.getAssignedLawyers().get(0).getUid()).isEqualTo(lawyer.getUid());

				}
		);
	}
}
