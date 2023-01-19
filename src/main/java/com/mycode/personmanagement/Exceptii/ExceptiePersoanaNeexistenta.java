package com.mycode.personmanagement.Exceptii;

public class ExceptiePersoanaNeexistenta extends Exception{

    public ExceptiePersoanaNeexistenta(){
        super("Persoana nu exista in baza de date");
    }
}
