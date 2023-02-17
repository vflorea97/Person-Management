package com.mycode.personmanagement.rest;

import com.mycode.personmanagement.model.Persoana;
import com.mycode.personmanagement.service.PersoanaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j

public class persoanaResource {

    private PersoanaService persoanaService;

    public persoanaResource(PersoanaService persoanaService){
        this.persoanaService = persoanaService;
    }

    @GetMapping("api/v1/persoane/getAllPersoane")
    public ResponseEntity<List<Persoana>> getAllPersoane(){
        log.info("Rest request to get all Persoane");
        List<Persoana> persoane = persoanaService.getAllPersoane();
        return new ResponseEntity<>(persoane, HttpStatus.OK);
    }

    @GetMapping("api/v1/persoane/getPersoaneAnNastereMaiMareCa")
    public ResponseEntity<List<Persoana>> getPersoaneAnNastereMaiMareCa(){
        log.info("REST request to get all persoane nascute dupa anul 2000");
        List<Persoana> persoane = persoanaService.getPersoaneAnNastereMaiMareCa(2000);
        return new ResponseEntity<>(persoane, HttpStatus.OK);
    }

    @GetMapping("api/v1/persoane/getCeaMaiInaltaPersoana")
    public ResponseEntity<List<Persoana>> getCeaMaiInaltaPersoana(){
        log.info("REST request to get cea mai inalta persoana");
        List<Persoana> persoane = persoanaService.getCeaMaiInaltaPersoana();
        return new ResponseEntity<>(persoane, HttpStatus.OK);
    }

    @GetMapping("api/v1/persoane/getNumeDeFamilieCuA")
    public ResponseEntity<List<Persoana>> getNumeDeFamilieCuA(){
        log.info("REST request to get all persoane unde prima litera din nume este 'A'");
        List<Persoana> persoane = persoanaService.getNumeDeFamilieCuA("A");
        return new ResponseEntity<>(persoane, HttpStatus.OK);
    }

    @GetMapping("api/v1/persoane/getPersoaneCuVarstaInaltimeaPeste")
    public ResponseEntity<List<Persoana>> getPersoaneCuVarstaInaltimeaPeste(){
        log.info("REST request to get all persoane nascute dupa 2000 si cu inaltime peste 1.50");
        List<Persoana> persoanas = persoanaService.getPersoaneCuVarstaInaltimeaPeste(2000,1.50);
        return new ResponseEntity<>(persoanas, HttpStatus.OK);
    }

}
