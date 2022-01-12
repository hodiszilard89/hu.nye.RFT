package com.example.service;

import com.example.hunyerft.domain.User;
import com.example.hunyerft.domain.Vizsga;
import com.example.hunyerft.repository.UserRepository;

import com.example.hunyerft.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;

import org.mockito.Mockito;

import org.testng.annotations.AfterMethod;



public class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl underTest;
    private UserRepository userRepository;
    private Vizsga testVizsga;
    private String TEST_USER_NEV="testszilard";
    private String TEST_USER_KERNEV="Test";
    private String TEST_USER_VEZNEV="Szilard";
    private String TEST_USER_PASS="1234";
    private User user;

    @Before
    public void init(){
         userRepository= Mockito.mock(UserRepository.class);
         user = createUser();
         testVizsga = new Vizsga();
         underTest=new UserServiceImpl(userRepository);

    }

    @AfterMethod
    public void tearDown() {
        underTest = null;
    }



    @Test
    public void haUserTorolEgyVizsgatKisebbLegyenATombMerete(){
        //give
        int torlesElotte;
        int torlesUtan;
        for(int i=0; i<5; i++){
            user.addVizsga(new Vizsga());
        }
        user.addVizsga(testVizsga);
        torlesElotte=underTest.getVizsgak(user).size();
        //when
        underTest.deleteFelvettVizsga(user,testVizsga);
        torlesUtan=underTest.getVizsgak(user).size();
        //then
        Assertions.assertTrue((torlesElotte>torlesUtan));
        Assertions.assertTrue((user.getVizsgak().size()==5));
        }



    public User createUser(){
        User user = new User();
            user.setNev(TEST_USER_NEV);
            user.setPassword(TEST_USER_PASS);
            user.setVezNev(TEST_USER_VEZNEV);
            user.setKerNev(TEST_USER_KERNEV);
        return user;
    }
}
