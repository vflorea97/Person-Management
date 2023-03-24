package com.mycode.personmanagement.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycode.personmanagement.dto.PersonDTO;
import com.mycode.personmanagement.model.Persoana;
import com.mycode.personmanagement.service.PersoanaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class PersoanaResourceTest {

    @Mock
    private PersoanaService persoanaService;

    @InjectMocks
    private PersoanaResource persoanaResource;

    private ObjectMapper mapper = new ObjectMapper();

    private MockMvc restMockMvc;

    @BeforeEach
    void initialConfig() {
        restMockMvc = MockMvcBuilders.standaloneSetup(persoanaResource).build();
    }
    @Captor
    ArgumentCaptor<Persoana> persoanaArgumentCaptor;
    @Captor
    ArgumentCaptor<PersonDTO> persoanaDTOArgumentCaptor;


    @Test
    void getAllPersoane() throws Exception {
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

        doReturn(persoanas).when(persoanaService).getAllPersoane();

        restMockMvc.perform(get("http://localhost:3001/api/v1/persoane/getAllPersoane")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(persoanas)));
    }

    @Test
    void getPersoaneAnNastereMaiMareCa() throws Exception {
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

        doReturn(persoanas).when(persoanaService).getPersoaneAnNastereMaiMareCa(2000);

        restMockMvc.perform(get("http://localhost:3001/api/v1/persoane/getPersoaneAnNastereMaiMareCa")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(persoanas)));
    }

    @Test
    void getCeaMaiInaltaPersoana() throws Exception{
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

        doReturn(persoanas).when(persoanaService).getCeaMaiInaltaPersoana();

        restMockMvc.perform(get("http://localhost:3001/api/v1/persoane/getCeaMaiInaltaPersoana")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(persoanas)));
    }

    @Test
    void getNumeDeFamilieCuA() throws Exception {
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

        doReturn(persoanas).when(persoanaService).getNumeDeFamilieCuA("A");

        restMockMvc.perform(get("http://localhost:3001/api/v1/persoane/getNumeDeFamilieCuA")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(persoanas)));

    }

    @Test
    void getPersoaneCuVarstaInaltimeaPeste() throws Exception{
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

        doReturn(persoanas).when(persoanaService).getPersoaneCuVarstaInaltimeaPeste(2000,1.5);

        restMockMvc.perform(get("http://localhost:3001/api/v1/persoane/getPersoaneCuVarstaInaltimeaPeste")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(persoanas)));
    }

    @Test
    void addPersona() throws Exception{
        Persoana persoana = Persoana.builder().anNastere(2005).email("rprichard0@ezinearticles.com").greutate(79.0).inaltime(1.89).nume("Rogerio").prenume("Prichard").build();

        restMockMvc.perform(post("http://localhost:3001/api/v1/persoane/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsBytes(persoana)))
                .andExpect(status().isCreated())
                .andExpect(content().string(mapper.writeValueAsString(persoana)));

        verify(persoanaService, times(1)).add(persoanaArgumentCaptor.capture());

        assertEquals(persoana, persoanaArgumentCaptor.getValue());
    }

    @Test
    void removePersoana() throws Exception{
        Persoana persoana = Persoana.builder().anNastere(2005).email("test@gmail.com").greutate(79.0).inaltime(1.89).nume("Rogerio").prenume("Prichard").build();

        restMockMvc.perform(delete("http://localhost:3001/api/v1/persoane/remove?email=jbaddam2@sfgate.com")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsBytes(persoana)))
                .andExpect(status().isOk())
                .andExpect(content().string("Ai sters cu succes o persoana"));

        assertEquals(Optional.empty(), persoanaService.getPersoanaByEmail("test@gmail.com") );
    }

    @Test
    void updateStudent() throws Exception{
        PersonDTO personDTO = new PersonDTO(1L,"Popa",1.75,"rprichard0@ezinearticles.com",70.3);
        Persoana persoana = Persoana.builder().anNastere(2005).prenume("Alex").nume("Popa").greutate(75.3).inaltime(1.83).email("rprichard0@ezinearticles.com").build();

        restMockMvc.perform(put("http://localhost:3001/api/v1/persoane/update")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(mapper.writeValueAsBytes(personDTO)))
                .andExpect(content().string("Ai updata atributul cu succes"))
                .andExpect(status().isOk());

        verify(persoanaService, times(1)).updatePersoana(persoanaDTOArgumentCaptor.capture());

        assertEquals(persoanaDTOArgumentCaptor.getValue(), personDTO);
    }
}