package com.mycode.personmanagement.repository;

import com.mycode.personmanagement.model.Persoana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersoanaRepository extends JpaRepository<Persoana,Long> {
    @Query("select p from Persoana p where p.anNastere > ?1")
    Optional<List<Persoana>> getPersoaneAnNastereMaiMareCa(int an);

    @Query("select p from Persoana p order by p.inaltime desc")
    Optional<List<Persoana>> getCeaMaiInaltaPersoana();

    @Query("select p from Persoana p where substr(p.nume,1,1) in ?1")
    Optional<List<Persoana>> getNumeDeFamilieCuA(String nume);

    @Query("select p from Persoana p where p.anNastere > ?1 and p.inaltime > ?1")
    Optional<List<Persoana>> getPersoaneCuVarstaInaltimeaPeste(int anNastere, double inaltime);

    Optional<Persoana> findByEmail(String email);
}






