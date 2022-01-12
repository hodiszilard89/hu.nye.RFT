package com.example.service;

import com.example.hunyerft.domain.Vizsga;
import com.example.hunyerft.repository.UserRepository;
import com.example.hunyerft.repository.VizsgaRepository;
import com.example.hunyerft.service.UserServiceImpl;
import com.example.hunyerft.service.VizsgaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import static org.mockito.BDDMockito.given;

public class VizsgaServiceTest {
    private static final Long VIZSGA_ID=420L;
    private static final String VIZSGA_NEV="ZH1";
    private static final String VIZSGA_TARGYNEV="Analizis";
    private static final String VIZSGA_HELYSZIN="Nyíregyháza";
    private static final String VIZSGA_DATUM="2020-11-15";
    private static final String VIZSGA_IDOPOT="8:00";
    private static final String VIZSGA_IDOTARTALOM="90";


    private VizsgaService underTest;
    private VizsgaRepository vizsgaRepository;

    @Before
    public void init(){
        vizsgaRepository= Mockito.mock(VizsgaRepository.class);
        underTest=new VizsgaService();
        underTest.setVizsgaRepo(vizsgaRepository);

    }

    @Test
    public void testHaAHallgatoMegNemVettFelVizsgatAkkorNullTerVissza(){ //üres a vizsgák listája
        //given

        //when
        Assertions.assertNull(underTest.getVizsgak());

    }

    @Test
    public void testHaIdAlapjanKellVizsgatKeresni(){
        //given
        Vizsga expected = createVizsga();
        given(underTest.getVizsga(VIZSGA_ID)).willReturn(expected);
        //when
        Vizsga actual = underTest.getVizsga(VIZSGA_ID);
        //then
        Assertions.assertEquals(expected,actual);
    }


    public Vizsga createVizsga(){
        Vizsga vizsga = new Vizsga();
        vizsga.setId(VIZSGA_ID);
        vizsga.setVizsgaNev(VIZSGA_NEV);
        vizsga.setTargyNev(VIZSGA_TARGYNEV);
        vizsga.setHelySzin(VIZSGA_HELYSZIN);
        vizsga.setDatum(VIZSGA_DATUM);
        vizsga.setIdoPont(VIZSGA_IDOPOT);
        vizsga.setIdoTartalom(VIZSGA_IDOTARTALOM);
        return vizsga;
    }

}
