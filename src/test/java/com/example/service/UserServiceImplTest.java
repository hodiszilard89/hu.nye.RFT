package com.example.service;

import com.example.hunyerft.domain.User;
import com.example.hunyerft.domain.Vizsga;
import com.example.hunyerft.repository.UserRepository;
import com.example.hunyerft.service.UserService;
import com.example.hunyerft.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.Assertion;

import java.util.Optional;

import static org.mockito.BDDMockito.given;


public class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl underTest;
    private UserRepository userRepository;
    private Vizsga testVizsga;
    private String TEST_USER_NEV="testszilard";
    private User user;

    @Before
    public void init(){
         userRepository= Mockito.mock(UserRepository.class);
         user = Mockito.mock(User.class);
         testVizsga = Mockito.mock(Vizsga.class);
         underTest=new UserServiceImpl(userRepository);
        // user = createUser();
    }


    @AfterMethod
    public void tearDown() {
        underTest = null;
    }

    @Test
    public void testUserPickUpExamThenNumberOfExamIsOneMore(){

        //give
        given(userRepository.findByNev(TEST_USER_NEV)).willReturn(createUser());
        //when
        //then
    }


    @Test
    public void testGetVizsgak(){
        testVizsga=createVizsga();
        user.addVizsga(testVizsga);
        Assertions.assertNotEquals(user.getVizsgak(),null);
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

    private Vizsga createVizsga(){
        Vizsga vizsga = new Vizsga();
        vizsga.setId(1);
        vizsga.setVizsgaNev("Zh1");
        vizsga.setHelySzin("Nyíregyháza");
        vizsga.setDatum("2022-01-12");
        vizsga.setIdoPont("12:30");
        vizsga.setTargyNev("Analizis");
        return vizsga;
    }
    private Optional<User> createOptionalUser(){
        return Optional.of(createUser());
    }
}
