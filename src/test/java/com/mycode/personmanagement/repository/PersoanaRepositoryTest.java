package com.mycode.personmanagement.repository;

import com.mycode.personmanagement.PersonManagementApplication;
import com.mycode.personmanagement.model.Persoana;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = PersonManagementApplication.class)
@Transactional
class PersoanaRepositoryTest {

    @Autowired
    PersoanaRepository persoanaRepository;

    @BeforeEach
    public void clean(){
        persoanaRepository.deleteAll();
    }

    @Test
    void getPersoaneAnNastereMaiMareCa() {
        Persoana persoana = Persoana.builder().anNastere(2005).email("rprichard0@ezinearticles.com").greutate(79.0).inaltime(1.89).nume("Rogerio").prenume("Prichard").build();
        Persoana persoana2 = Persoana.builder().anNastere(1993).email("lfoxhall1@skype.com").greutate(45.1).inaltime(1.33).nume("Lavinie").prenume("Foxhall").build();
        Persoana persoana3 = Persoana.builder().anNastere(1989).email("jbaddam2@sfgate.com").greutate(49.0).inaltime(1.13).nume("Jacquie").prenume("Baddam").build();
        Persoana persoana4 = Persoana.builder().anNastere(2002).email("bstathor3@patch.com").greutate(88.1).inaltime(1.66).nume("Burnaby").prenume("Stathor").build();
        Persoana persoana5 = Persoana.builder().anNastere(1992).email("hbearcroft4@indiatimes.com").greutate(84.8).inaltime(1.13).nume("Heda").prenume("Bearcroft").build();
        Persoana persoana6 = Persoana.builder().anNastere(1984).email("adudson5@shutterfly.com").greutate(70.8).inaltime(1.88).nume("Annadiane").prenume("Dudson").build();
        Persoana persoana7 = Persoana.builder().anNastere(2005).email("eiceton6@java.com").greutate(62.1).inaltime(1.39).nume("Evan").prenume("Iceton").build();

        persoanaRepository.saveAndFlush(persoana);
        persoanaRepository.saveAndFlush(persoana2);
        persoanaRepository.saveAndFlush(persoana3);
        persoanaRepository.saveAndFlush(persoana4);
        persoanaRepository.saveAndFlush(persoana5);
        persoanaRepository.saveAndFlush(persoana6);
        persoanaRepository.saveAndFlush(persoana7);

        List<Persoana> persoane = persoanaRepository.getPersoaneAnNastereMaiMareCa(2000).get();

        assertEquals(3, persoane.size());
    }

    @Test
    void getCeaMaiInaltaPersoana() {
        Persoana persoana = Persoana.builder().anNastere(2005).email("rprichard0@ezinearticles.com").greutate(79.0).inaltime(1.89).nume("Rogerio").prenume("Prichard").build();
        Persoana persoana2 = Persoana.builder().anNastere(1993).email("lfoxhall1@skype.com").greutate(45.1).inaltime(1.33).nume("Lavinie").prenume("Foxhall").build();
        Persoana persoana3 = Persoana.builder().anNastere(1989).email("jbaddam2@sfgate.com").greutate(49.0).inaltime(1.13).nume("Jacquie").prenume("Baddam").build();
        Persoana persoana4 = Persoana.builder().anNastere(2002).email("bstathor3@patch.com").greutate(88.1).inaltime(1.66).nume("Burnaby").prenume("Stathor").build();
        Persoana persoana5 = Persoana.builder().anNastere(1992).email("hbearcroft4@indiatimes.com").greutate(84.8).inaltime(1.13).nume("Heda").prenume("Bearcroft").build();
        Persoana persoana6 = Persoana.builder().anNastere(1984).email("adudson5@shutterfly.com").greutate(70.8).inaltime(1.88).nume("Annadiane").prenume("Dudson").build();
        Persoana persoana7 = Persoana.builder().anNastere(2005).email("eiceton6@java.com").greutate(62.1).inaltime(1.39).nume("Evan").prenume("Iceton").build();

        persoanaRepository.saveAndFlush(persoana);
        persoanaRepository.saveAndFlush(persoana2);
        persoanaRepository.saveAndFlush(persoana3);
        persoanaRepository.saveAndFlush(persoana4);
        persoanaRepository.saveAndFlush(persoana5);
        persoanaRepository.saveAndFlush(persoana6);
        persoanaRepository.saveAndFlush(persoana7);

        List<Persoana> persoane = persoanaRepository.getCeaMaiInaltaPersoana().get();

        assertEquals(persoana, persoane.get(0));
    }

    @Test
    void getNumeDeFamilieCuA() {
        Persoana persoana = Persoana.builder().anNastere(2005).email("rprichard0@ezinearticles.com").greutate(79.0).inaltime(1.89).nume("Rogerio").prenume("Prichard").build();
        Persoana persoana2 = Persoana.builder().anNastere(1993).email("lfoxhall1@skype.com").greutate(45.1).inaltime(1.33).nume("Lavinie").prenume("Foxhall").build();
        Persoana persoana3 = Persoana.builder().anNastere(1989).email("jbaddam2@sfgate.com").greutate(49.0).inaltime(1.13).nume("Jacquie").prenume("Baddam").build();
        Persoana persoana4 = Persoana.builder().anNastere(2002).email("bstathor3@patch.com").greutate(88.1).inaltime(1.66).nume("Burnaby").prenume("Stathor").build();
        Persoana persoana5 = Persoana.builder().anNastere(1992).email("hbearcroft4@indiatimes.com").greutate(84.8).inaltime(1.13).nume("Heda").prenume("Bearcroft").build();
        Persoana persoana6 = Persoana.builder().anNastere(1984).email("adudson5@shutterfly.com").greutate(70.8).inaltime(1.88).nume("Annadiane").prenume("Dudson").build();
        Persoana persoana7 = Persoana.builder().anNastere(2005).email("eiceton6@java.com").greutate(62.1).inaltime(1.39).nume("Evan").prenume("Iceton").build();

        persoanaRepository.saveAndFlush(persoana);
        persoanaRepository.saveAndFlush(persoana2);
        persoanaRepository.saveAndFlush(persoana3);
        persoanaRepository.saveAndFlush(persoana4);
        persoanaRepository.saveAndFlush(persoana5);
        persoanaRepository.saveAndFlush(persoana6);
        persoanaRepository.saveAndFlush(persoana7);

        List<Persoana> persoane = persoanaRepository.getNumeDeFamilieCuA("A").get();

        assertEquals(persoana6, persoane.get(0));
    }

    @Test
    void getPersoaneCuVarstaInaltimeaPeste() {
        Persoana persoana = Persoana.builder().anNastere(2005).email("rprichard0@ezinearticles.com").greutate(79.0).inaltime(1.89).nume("Rogerio").prenume("Prichard").build();
        Persoana persoana2 = Persoana.builder().anNastere(1993).email("lfoxhall1@skype.com").greutate(45.1).inaltime(1.33).nume("Lavinie").prenume("Foxhall").build();
        Persoana persoana3 = Persoana.builder().anNastere(1989).email("jbaddam2@sfgate.com").greutate(49.0).inaltime(1.13).nume("Jacquie").prenume("Baddam").build();
        Persoana persoana4 = Persoana.builder().anNastere(2002).email("bstathor3@patch.com").greutate(88.1).inaltime(1.66).nume("Burnaby").prenume("Stathor").build();
        Persoana persoana5 = Persoana.builder().anNastere(1992).email("hbearcroft4@indiatimes.com").greutate(84.8).inaltime(1.13).nume("Heda").prenume("Bearcroft").build();
        Persoana persoana6 = Persoana.builder().anNastere(1984).email("adudson5@shutterfly.com").greutate(70.8).inaltime(1.88).nume("Annadiane").prenume("Dudson").build();
        Persoana persoana7 = Persoana.builder().anNastere(2005).email("eiceton6@java.com").greutate(62.1).inaltime(1.39).nume("Evan").prenume("Iceton").build();

        persoanaRepository.saveAndFlush(persoana);
        persoanaRepository.saveAndFlush(persoana2);
        persoanaRepository.saveAndFlush(persoana3);
        persoanaRepository.saveAndFlush(persoana4);
        persoanaRepository.saveAndFlush(persoana5);
        persoanaRepository.saveAndFlush(persoana6);
        persoanaRepository.saveAndFlush(persoana7);

        List<Persoana> persoane = persoanaRepository.getPersoaneCuVarstaInaltimeaPeste(2000,1.50).get();

        assertEquals(2, persoane.size());
    }

    @Test
    void updatePersonByEmailUpdateAn() {
        Persoana persoana = Persoana.builder().anNastere(2005).email("rprichard0@ezinearticles.com").greutate(79.0).inaltime(1.89).nume("Rogerio").prenume("Prichard").build();

        persoanaRepository.saveAndFlush(persoana);

        persoanaRepository.updatePersonByEmailUpdateAn(2000,"rprichard0@ezinearticles.com");

        assertNotEquals(Optional.empty(), persoanaRepository.findPersoanaByEmailAndAnNastere("rprichard0@ezinearticles.com", 2000));
    }

    @Test
    void updatePersonByEmailUpdateGreutate() {
        Persoana persoana = Persoana.builder().anNastere(2005).email("rprichard0@ezinearticles.com").greutate(79.0).inaltime(1.89).nume("Rogerio").prenume("Prichard").build();

        persoanaRepository.saveAndFlush(persoana);

        persoanaRepository.updatePersonByEmailUpdateGreutate(75.5,"rprichard0@ezinearticles.com");

        assertNotEquals(Optional.empty(), persoanaRepository.findPersoanaByEmailAndGreutate("rprichard0@ezinearticles.com", 75.5));
    }

    @Test
    void updatePersonByEmailUpdateInaltime() {
        Persoana persoana = Persoana.builder().anNastere(2005).email("rprichard0@ezinearticles.com").greutate(79.0).inaltime(1.89).nume("Rogerio").prenume("Prichard").build();

        persoanaRepository.saveAndFlush(persoana);

        persoanaRepository.updatePersonByEmailUpdateInaltime(1.75,"rprichard0@ezinearticles.com");

        assertNotEquals(Optional.empty(), persoanaRepository.findPersoanaByEmailAndInaltime("rprichard0@ezinearticles.com", 1.75));
    }
}