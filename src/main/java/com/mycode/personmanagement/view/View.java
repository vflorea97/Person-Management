package com.mycode.personmanagement.view;

import com.mycode.personmanagement.Exceptii.ExceptiePersoanaExistenta;
import com.mycode.personmanagement.Exceptii.ExceptiePersoanaNeexistenta;
import com.mycode.personmanagement.model.Persoana;
import com.mycode.personmanagement.repository.PersoanaRepository;
import org.springframework.stereotype.Component;
import com.mycode.personmanagement.service.PersoanaService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class View {

    private PersoanaService persoanaService;
    private Scanner scanner;
    private final PersoanaRepository persoanaRepository;


    public View(PersoanaService personaService, PersoanaRepository persoanaRepository) {
        this.persoanaRepository = persoanaRepository;
        scanner = new Scanner(System.in);
        this.persoanaService = personaService;
    }

    public void meniu() {
        System.out.println("Apasa 1 pentru a afisa toate persoanele");
        System.out.println("Apasa 2 penru a adauga o persoana");
        System.out.println("Apasa 3 pentru a afisa persoane nascute dupa 2000");
        System.out.println("Apasa 4 pentru a afisa ce mai inalta persoana");
        System.out.println("Apasa 5 pentru a afisa persoane cu inaltime peste 1.5m si sunt nascute dupa 2010");
        System.out.println("Apasa 6 pentru a afisa persoanele ale caror nume de familie incep cu litera 'Y'");
    }

    public void play() throws ExceptiePersoanaNeexistenta {
        boolean run = true;
        meniu();
        while (run) {
            int buton = Integer.parseInt(scanner.nextLine());
            switch (buton) {
                case 1:
                    persoanaService.afisare();
                    break;
                case 2:
                    addPersoana();
                    break;
                case 3:
                    getPersoaneAnNastereMaiMareCa();
                    break;
                case 4:
                    getCeaMaiInaltaPersoana();
                    break;
                case 5:
                    getPersoaneCuVarstaInaltimeaPeste();
                    break;
                case 6:
                    getNumeDeFamilieCuA();
                    break;
                default:
                    run = false;
                    break;
            }
        }
    }
    public void addPersoana(){
        System.out.println("Introdu numele:");
        String nume = scanner.nextLine();
        System.out.println("Introdu prenumele:");
        String prenume = scanner.nextLine();
        System.out.println("Introdu anul nasterii: ");
        int an = Integer.parseInt(scanner.nextLine());
        System.out.println("Introdu inaltimea: ");
        double inaltime = Double.parseDouble(scanner.nextLine());
        System.out.println("Intorfu emailul: ");
        String email = scanner.nextLine();
        System.out.println("Introdu greutatea: ");
        double greutate = Double.parseDouble(scanner.nextLine());
        try{
            Persoana persoana = Persoana.builder().nume(nume).prenume(prenume).anNastere(an).inaltime(inaltime).email(email).greutate(greutate).build();
            persoanaService.add(persoana);
            System.out.println("Ai adaugat o noua persoana!!");
        }catch (ExceptiePersoanaExistenta p){
            System.err.println(p.getMessage());
        }
    }
    public void getPersoaneAnNastereMaiMareCa(){
        Optional<List<Persoana>> persoane = persoanaRepository.getPersoaneAnNastereMaiMareCa(2000);
        for (int i = 0; i < persoane.get().size(); i++){
            System.out.println(persoane.get().get(i));
        }
    }
    public void getCeaMaiInaltaPersoana(){
        Optional<List<Persoana>> persoane = persoanaRepository.getCeaMaiInaltaPersoana();
        for (int i = 0; i < persoane.get().size(); i++){
            System.out.println(persoane.get().get(i));
        }
    }
    public void getPersoaneCuVarstaInaltimeaPeste(){
        Optional<List<Persoana>> persoane = persoanaRepository.getPersoaneCuVarstaInaltimeaPeste(2000,1.5);
        for (int i = 0; i < persoane.get().size(); i++){
            System.out.println(persoane.get().get(i));
        }
    }
    public void getNumeDeFamilieCuA() throws ExceptiePersoanaNeexistenta {
        Optional<List<Persoana>> persoane = persoanaRepository.getNumeDeFamilieCuA("X");
        if (!persoane.isEmpty()){
            persoane.get();
        }else {
            throw new ExceptiePersoanaNeexistenta();
        }

    }

}

