package com.mycode.personmanagement.service;

import com.mycode.personmanagement.Exceptii.ExceptiePersoanaExistenta;
import com.mycode.personmanagement.Exceptii.ExceptiePersoanaNeexistenta;
import com.mycode.personmanagement.model.Persoana;
import com.mycode.personmanagement.repository.PersoanaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersoanaServiceTest {

    @Mock
    private PersoanaRepository persoanaRepository;

    @InjectMocks
    private PersoanaService persoanaService;

    @Captor
    ArgumentCaptor<Persoana> persoanaArgumentCaptor;
    @Captor
    ArgumentCaptor<String> persoanaField;


    @Test
    void getAllPersoane() {
        Persoana persoana = Persoana.builder().anNastere(2005).email("rprichard0@ezinearticles.com").greutate(79.0).inaltime(1.89).nume("Rogerio").prenume("Prichard").build();
        Persoana persoana2 = Persoana.builder().anNastere(1993).email("lfoxhall1@skype.com").greutate(45.1).inaltime(1.33).nume("Lavinie").prenume("Foxhall").build();
        Persoana persoana3 = Persoana.builder().anNastere(1989).email("jbaddam2@sfgate.com").greutate(49.0).inaltime(1.13).nume("Jacquie").prenume("Baddam").build();
        Persoana persoana4 = Persoana.builder().anNastere(2002).email("bstathor3@patch.com").greutate(88.1).inaltime(1.66).nume("Burnaby").prenume("Stathor").build();
        Persoana persoana5 = Persoana.builder().anNastere(1992).email("hbearcroft4@indiatimes.com").greutate(84.8).inaltime(1.13).nume("Heda").prenume("Bearcroft").build();
        Persoana persoana6 = Persoana.builder().anNastere(1984).email("adudson5@shutterfly.com").greutate(70.8).inaltime(1.88).nume("Annadiane").prenume("Dudson").build();
        Persoana persoana7 = Persoana.builder().anNastere(2005).email("eiceton6@java.com").greutate(62.1).inaltime(1.39).nume("Evan").prenume("Iceton").build();

        List<Persoana> persoanas = new ArrayList<>();
        persoanas.add(persoana);
        persoanas.add(persoana2);
        persoanas.add(persoana3);
        persoanas.add(persoana4);
        persoanas.add(persoana5);
        persoanas.add(persoana6);
        persoanas.add(persoana7);

        doReturn(persoanas).when(persoanaRepository).findAll();

        assertEquals(7, persoanaService.getAllPersoane().size());
    }

    @Test
    void add() {
        Persoana persoana = Persoana.builder().anNastere(2005).email("rprichard0@ezinearticles.com").greutate(79.0).inaltime(1.89).nume("Rogerio").prenume("Prichard").build();

        doReturn(Optional.empty()).when(persoanaRepository).findByEmail("rprichard0@ezinearticles.com");

        persoanaService.add(persoana);

        verify(persoanaRepository,times(1)).saveAndFlush(persoanaArgumentCaptor.capture());

        assertEquals(persoanaArgumentCaptor.getValue(),persoana);

    }
    @Test
    public void addStudentExceptie(){
        Persoana persoana = Persoana.builder().anNastere(2005).email("rprichard0@ezinearticles.com").greutate(79.0).inaltime(1.89).nume("Rogerio").prenume("Prichard").build();

        doReturn(Optional.of(persoana)).when(persoanaRepository).findByEmail("rprichard0@ezinearticles.com");

        assertThrows(ExceptiePersoanaExistenta.class, () ->{
            persoanaService.add(persoana);
        });
    }

    @Test
    void getPersoaneAnNastereMaiMareCa() {
        Persoana persoana = Persoana.builder().anNastere(2005).email("rprichard0@ezinearticles.com").greutate(79.0).inaltime(1.89).nume("Rogerio").prenume("Prichard").build();

        doReturn(Optional.of(persoana)).when(persoanaRepository).getPersoaneAnNastereMaiMareCa(2000);

        assertEquals(Optional.of(persoana), persoanaRepository.findByEmail("rprichard0@ezinearticles.com"));
    }

    @Test
    void getCeaMaiInaltaPersoana() {
    }

    @Test
    void getPersoaneCuVarstaInaltimeaPeste() {
    }

    @Test
    void getNumeDeFamilieCuA() {
    }

    @Test
    void remove() {
        Persoana persoana = Persoana.builder().anNastere(2005).email("rprichard0@ezinearticles.com").greutate(79.0).inaltime(1.89).nume("Rogerio").prenume("Prichard").build();

        doReturn(Optional.of(persoana)).when(persoanaRepository).findByEmail("rprichard0@ezinearticles.com");

        persoanaService.remove("rprichard0@ezinearticles.com");

        verify(persoanaRepository,times(1)).removePersoanaByEmail(persoanaField.capture());

        assertEquals("rprichard0@ezinearticles.com", persoanaField.getValue());
    }

    @Test
    public void removeStudentExceptie() {
        doReturn(Optional.empty()).when(persoanaRepository).findByEmail("rprichard0@ezinearticles.com");

        assertThrows(ExceptiePersoanaNeexistenta.class, () ->{
            persoanaService.remove("rprichard0@ezinearticles.com");
        });
    }

    @Test
    void updateAnNastere() {
    }

}