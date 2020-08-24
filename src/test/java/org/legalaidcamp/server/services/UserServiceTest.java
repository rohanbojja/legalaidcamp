package org.legalaidcamp.server.services;

import org.junit.jupiter.api.Test;
import org.legalaidcamp.server.models.User;
import org.legalaidcamp.server.models.UserData;
import org.legalaidcamp.server.repositories.UserRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UserServiceTest {
    /*
    Unit tests
     */
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    void createCase() {
    }

    @Test
    void deleteCase() {
    }

    @Test
    void createUserReturnsUser() {


    }

    @Test
    void getLawyer() {
    }
}