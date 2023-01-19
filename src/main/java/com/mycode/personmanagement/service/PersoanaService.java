package com.mycode.personmanagement.service;

import com.mycode.personmanagement.Exceptii.ExceptiePersoanaExistenta;
import com.mycode.personmanagement.Exceptii.ExceptiePersoanaNecorespunzatoare;
import com.mycode.personmanagement.Exceptii.ExceptiePersoanaNeexistenta;
import com.mycode.personmanagement.model.Persoana;
import com.mycode.personmanagement.repository.PersoanaRepository;
import org.springframework.stereotype.Service;

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

    public void add(Persoana persoana) throws ExceptiePersoanaExistenta {
        Optional<Persoana> pers = persoanaRepository.findByEmail(persoana.getEmail());
        if(pers.equals(Optional.empty())){
            persoanaRepository.save(persoana);
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

    public List<Persoana> getNumeDeFamilieCuA(String nume){
        return persoanaRepository.getNumeDeFamilieCuA("X").get();
    }

}
