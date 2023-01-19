package com.mycode.personmanagement.Exceptii;

public class ExceptiePersoanaNecorespunzatoare extends Exception{

    public ExceptiePersoanaNecorespunzatoare(){
        super("Nu exista nici o persoana care corespunde cu aceste standarde");
    }
}
