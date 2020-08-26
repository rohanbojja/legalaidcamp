package org.legalaidcamp.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.legalaidcamp.server.models.*;
import org.legalaidcamp.server.services.LawyerService;
import org.legalaidcamp.server.services.UserService;
import org.legalaidcamp.server.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableJpaAuditing
public class ServerApplication implements CommandLineRunner {
    protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    UtilityService utilityService;

    @Autowired
    UserService userService;

    @Autowired
    LawyerService lawyerService;

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    //TODO: Command line runner to populate the DB for dev;
    @Override
    public void run(String... args) throws Exception {
        logger.info("Populating users/lawyers");
        for(int i=1;i<11;i++){
            UserData userData = new UserData(utilityService.getRandomString(3)+" USER", "rohanbojja@gmail.com", "90302", "yourMom.jpeg");
            //Assign values or initialize
            String uid = utilityService.getRandomString(6);
            User user = userService.createUser(uid,userData);
            Set<Long> longs = new HashSet<>();
            longs.add(1L);
            longs.add(2L);
            LawyerData lawyerData = new LawyerData(longs,0L,utilityService.getRandomString(3)+"Address",utilityService.getRandomString(2)+"500036",true,true,true, longs, ((long) i),"Hyderabad", (long) i);
            lawyerService.createLawyer(uid,lawyerData);
        }

        logger.info("DONE");
        logger.info("Popuylating with users/cases");
        for(int i=1;i<11;i++){
            UserData userData = new UserData(utilityService.getRandomString(3)+"Client", "sd@gmail.com", "90302", "asdasd.jpeg");
            //Assign values or initialize
            String uid = utilityService.getRandomString(6);
            User user = userService.createUser(uid,userData);

            //Create a case
            CourtCaseData courtCaseData = new CourtCaseData("A offended me.", 2L, "Meerut", (long) i, 7L, 0L,uid);
            CourtCase courtCase = userService.createCase(uid, courtCaseData);
        }

    }
}
