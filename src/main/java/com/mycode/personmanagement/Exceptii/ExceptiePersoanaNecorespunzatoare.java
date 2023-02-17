package com.mycode.personmanagement.Exceptii;

public class ExceptiePersoanaNecorespunzatoare extends RuntimeException{

    public ExceptiePersoanaNecorespunzatoare(){
        super("Nu exista nici o persoana care corespunde cu aceste standarde");
    }
}
