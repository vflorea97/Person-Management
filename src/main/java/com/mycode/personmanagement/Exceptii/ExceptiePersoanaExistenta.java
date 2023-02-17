package com.mycode.personmanagement.Exceptii;

public class ExceptiePersoanaExistenta extends RuntimeException{

    public ExceptiePersoanaExistenta(){
        super("Persoana deja exista in baza de date");
    }
}
