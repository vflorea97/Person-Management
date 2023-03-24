package com.mycode.personmanagement.rest;

import com.mycode.personmanagement.dto.PersonDTO;
import com.mycode.personmanagement.model.Persoana;
import com.mycode.personmanagement.service.PersoanaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/v1/persoane")
public class PersoanaResource {

    private PersoanaService persoanaService;

    public PersoanaResource(PersoanaService persoanaService){
        this.persoanaService = persoanaService;
    }

    @GetMapping("/getAllPersoane")
    public ResponseEntity<List<Persoana>> getAllPersoane(){
        log.info("Rest request to get all Persoane");
        List<Persoana> persoane = persoanaService.getAllPersoane();
        return new ResponseEntity<>(persoane, HttpStatus.OK);
    }

    @GetMapping("/getPersoaneAnNastereMaiMareCa")
    public ResponseEntity<List<Persoana>> getPersoaneAnNastereMaiMareCa(){
        log.info("REST request to get all persoane nascute dupa anul 2000");
        List<Persoana> persoane = persoanaService.getPersoaneAnNastereMaiMareCa(2000);
        return new ResponseEntity<>(persoane, HttpStatus.OK);
    }

    @GetMapping("/getCeaMaiInaltaPersoana")
    public ResponseEntity<List<Persoana>> getCeaMaiInaltaPersoana(){
        log.info("REST request to get cea mai inalta persoana");
        List<Persoana> persoane = persoanaService.getCeaMaiInaltaPersoana();
        return new ResponseEntity<>(persoane, HttpStatus.OK);
    }

    @GetMapping("/getNumeDeFamilieCuA")
    public ResponseEntity<List<Persoana>> getNumeDeFamilieCuA(){
        log.info("REST request to get all persoane unde prima litera din nume este 'A'");
        List<Persoana> persoane = persoanaService.getNumeDeFamilieCuA("A");
        return new ResponseEntity<>(persoane, HttpStatus.OK);
    }

    @GetMapping("/getPersoaneCuVarstaInaltimeaPeste")
    public ResponseEntity<List<Persoana>> getPersoaneCuVarstaInaltimeaPeste(){
        log.info("REST request to get all persoane nascute dupa 2000 si cu inaltime peste 1.50");
        List<Persoana> persoanas = persoanaService.getPersoaneCuVarstaInaltimeaPeste(2000,1.50);
        return new ResponseEntity<>(persoanas, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Persoana> addPersona (@Valid @RequestBody Persoana persoana) {

        log.info("Rest api to add a new magain {}", persoana);
        this.persoanaService.add(persoana);
        return new ResponseEntity<>(persoana, HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removePersoana( @RequestParam String email){
        log.info("REST request to remove one student");
        persoanaService.remove(email);
        return new ResponseEntity<>("Ai sters cu succes o persoana", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateStudent(@Valid @RequestBody PersonDTO personDTO){
        log.info("REST request to update persoana{}", personDTO);
        persoanaService.updatePersoana(personDTO);
        return new ResponseEntity<>("Ai updata atributul cu succes", HttpStatus.OK);
    }

}
