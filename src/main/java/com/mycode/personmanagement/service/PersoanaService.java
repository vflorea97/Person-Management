package com.mycode.personmanagement.service;

import com.mycode.personmanagement.Exceptii.ExceptiePersoanaExistenta;
import com.mycode.personmanagement.Exceptii.ExceptiePersoanaNecorespunzatoare;
import com.mycode.personmanagement.Exceptii.ExceptiePersoanaNeexistenta;
import com.mycode.personmanagement.dto.PersonDTO;
import com.mycode.personmanagement.model.Persoana;
import com.mycode.personmanagement.repository.PersoanaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersoanaService {
    private PersoanaRepository persoanaRepository;

    public PersoanaService(PersoanaRepository persoanaRepository) {
        this.persoanaRepository = persoanaRepository;
    }


    public void afisare(){
        List<Persoana> persoane= persoanaRepository.findAll();
        persoane.forEach(b-> System.out.println(b));
    }

    public List<Persoana> getAllPersoane(){
        List<Persoana> persoanas = persoanaRepository.findAll();
        return persoanas;
    }

    public Optional<Persoana> getPersoanaByEmail(String email) throws ExceptiePersoanaNeexistenta  {
        Optional<Persoana> persoana = persoanaRepository.findByEmail(email);
        if (persoana.isPresent()){
            return persoana;
        }else {
            throw new ExceptiePersoanaNeexistenta();
        }
    }

    public void add(Persoana persoana) throws ExceptiePersoanaExistenta {
        Optional<Persoana> pers = persoanaRepository.findByEmail(persoana.getEmail());
        if(pers.isEmpty()){
            persoanaRepository.saveAndFlush(persoana);
        }else{
            throw  new ExceptiePersoanaExistenta();
        }
    }

    public List<Persoana> getPersoaneAnNastereMaiMareCa(int an) throws ExceptiePersoanaNeexistenta{
        List<Persoana> persoane = persoanaRepository.getPersoaneAnNastereMaiMareCa(an).get();
        if (persoane.size() > 0){
            return persoane;
        }else {
            throw new ExceptiePersoanaNeexistenta();
        }
    }

    public  List<Persoana> getCeaMaiInaltaPersoana(){
        return persoanaRepository.getCeaMaiInaltaPersoana().get();
    }

    public List<Persoana> getPersoaneCuVarstaInaltimeaPeste(int anNastere, double inaltime) throws ExceptiePersoanaNecorespunzatoare{
        List<Persoana> persoane = persoanaRepository.getPersoaneCuVarstaInaltimeaPeste(anNastere, inaltime).get();
        if (persoane.size() > 0){
            return persoane;
        }else {
            throw new ExceptiePersoanaNecorespunzatoare();
        }
    }

    public List<Persoana> getNumeDeFamilieCuA(String nume) throws ExceptiePersoanaNeexistenta{
        List<Persoana> persoane = persoanaRepository.getNumeDeFamilieCuA(nume).get();
        if (persoane.size() > 0){
            return persoane;
        }else {
            throw new ExceptiePersoanaNeexistenta();
        }
    }

    public void remove (String email) throws ExceptiePersoanaNeexistenta {
        Optional<Persoana> persoana = persoanaRepository.findByEmail(email);
        if (persoana.isPresent()){
            persoanaRepository.removePersoanaByEmail(email);
            System.out.println("Ai ster o persoana cu succes");
        }else {
            throw new ExceptiePersoanaNeexistenta();
        }
    }

    @Transactional
    @Modifying
    public void updateAnNastere(int anNastere, String email) throws ExceptiePersoanaNeexistenta {
        Optional<Persoana> persoana = persoanaRepository.findByEmail(email);
        if (persoana.isPresent()) {
            persoanaRepository.updatePersonByEmailUpdateAn(anNastere, email);
        } else {
            throw new ExceptiePersoanaNeexistenta();
        }
    }

    public void verificareMail(String email) throws ExceptiePersoanaNeexistenta {
        Optional<Persoana> persoana = persoanaRepository.findByEmail(email);
        if (persoana.isEmpty()){
            throw new ExceptiePersoanaNeexistenta();
        }
    }

    public void updatePersoana(PersonDTO personDTO) throws ExceptiePersoanaNeexistenta {
        Optional<Persoana> persoana = persoanaRepository.findById(personDTO.getId());
        if (persoana.isPresent()) {
            Persoana p = persoana.get();

            if (!personDTO.getNume().equals("")) {
                p.setNume(personDTO.getNume());
            }
            if (personDTO.getInaltime() != 0) {
                p.setInaltime(personDTO.getInaltime());
            }
            if (!personDTO.getEmail().equals("")) {
                p.setEmail(personDTO.getEmail());
            }
            if (personDTO.getGreutate() != 0) {
                p.setGreutate(personDTO.getGreutate());
            }
            persoanaRepository.saveAndFlush(p);
        } else {
            throw new ExceptiePersoanaNeexistenta();
        }
    }
}
