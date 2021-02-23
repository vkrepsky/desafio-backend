package com.backend.desafio.repository;

import com.backend.desafio.model.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede,Long> {

    @Transactional(readOnly = true)
    List<Hospede> findByDocumento(Long id);

    @Transactional(readOnly = true)
    List<Hospede> findByNome(String nome);

    @Transactional(readOnly = true)
    List<Hospede>  findByTelefone(String telefone);

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM hospede WHERE hospede.data_check_out < NOW()", nativeQuery = true)
    List<Hospede> findNaoHospedados();

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM hospede WHERE hospede.data_check_out >= NOW()", nativeQuery = true)
    List<Hospede> findHospedados();

    @Transactional(readOnly = true)
    Optional<Hospede> deleteByDocumento(Long documento);
}
