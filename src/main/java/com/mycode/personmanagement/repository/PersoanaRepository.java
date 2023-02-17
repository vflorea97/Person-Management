package com.mycode.personmanagement.repository;

import com.mycode.personmanagement.model.Persoana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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

    @Query("select p from Persoana p where p.anNastere > ?1 and p.inaltime > ?2")
    Optional<List<Persoana>> getPersoaneCuVarstaInaltimeaPeste(int anNastere, double inaltime);

    Optional<Persoana> findByEmail(String email);

    @Transactional
    Optional<Persoana> removePersoanaByEmail(String email);

    @Query("update Persoana p set p.anNastere = ?1 where p.email = ?2")
    void updatePersonByEmailUpdateAn(int anNastere, String email);

    @Query("update Persoana p set p.greutate = ?1 where p.email = ?2")
    void updatePersonByEmailUpdateGreutate(double greutate, String email);

    @Query("update Persoana p set p.inaltime = ?1 where p.email = ?2")
    void updatePersonByEmailUpdateInaltime(int inaltime, String email);


}






