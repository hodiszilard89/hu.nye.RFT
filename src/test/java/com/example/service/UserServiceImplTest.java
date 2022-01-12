package com.example.service;

import com.example.hunyerft.domain.User;
import com.example.hunyerft.domain.Vizsga;
import com.example.hunyerft.repository.UserRepository;
import com.example.hunyerft.service.UserService;
import com.example.hunyerft.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Optional;

import static org.mockito.BDDMockito.given;


public class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl underTest;
    private UserRepository userRepository;
    private String TEST_USER_NEV="testszilard";

    @Before
    public void init(){
         userRepository= Mockito.mock(UserRepository.class);
         underTest=new UserServiceImpl(userRepository);
    }

    @Mock
    private Vizsga testVizsga;

    @AfterMethod
    public void tearDown() {
        underTest = null;
    }

    @Test
    public void testUserPickUpExamThenNumberOfExamIsOneMore(){

        //give
        User exceptid = createUser();
        given(userRepository.findByNev(TEST_USER_NEV)).willReturn(createUser());
        //when
        //then
    }


    private User createUser(){
        User user = new User();
        user.setId(1);
        user.setNev(TEST_USER_NEV);
        user.setVezNev("Hodi");
        user.setKerNev("Szilard");
        user.setPassword("1234");
        return user;
    }

    private Optional<User> createOptionalUser(){
        return Optional.of(createUser());
    }
}
