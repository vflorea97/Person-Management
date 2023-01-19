package com.mycode.personmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Entity(name="Persoana")
@Table(name="persoane")
public class Persoana implements Comparable<Persoana>{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String nume;
    private String prenume;
    private int anNastere;
    private double inaltime;
    private String email;
    private double greutate;


    @Override
    public int compareTo(Persoana o) {
        if (this.email.compareTo(o.email) > 0){
            return 1;
        }
        else if(this.email.compareTo(o.email) < 0){
            return -1;
        }else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o){
        Persoana p = (Persoana) o;
        return this.email.equals(p.email);
    }
}
