package com.backend.desafio.controller;

import com.backend.desafio.model.Hospede;
import com.backend.desafio.repository.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/get")
public class HospedeGetService {

    @Autowired
    private HospedeRepository repository;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAll(){
        List<Hospede> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/nome", method = RequestMethod.GET)
    public ResponseEntity getByNome(@RequestParam String nome) {

        List<Hospede> h = repository.findByNome(nome);
        return ResponseEntity.ok(h);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/documento", method = RequestMethod.GET)
    public ResponseEntity getByDocumento(@RequestParam Long id) {

        List<Hospede> h = repository.findByDocumento(id);

        return ResponseEntity.ok(h);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/telefone", method = RequestMethod.GET)
    public ResponseEntity getByTelefone(@RequestParam String telefone) {

        List<Hospede> h = repository.findByTelefone(telefone);

        return ResponseEntity.ok(h);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/hospedados", method = RequestMethod.GET)
    public ResponseEntity getHospedados() {

        List<Hospede> list = repository.findHospedados();

        return ResponseEntity.ok(list);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/naoHospedados", method = RequestMethod.GET)
    public ResponseEntity getNaoHospedados() {

        List<Hospede> list = repository.findNaoHospedados();

        return ResponseEntity.ok(list);
    }
}
