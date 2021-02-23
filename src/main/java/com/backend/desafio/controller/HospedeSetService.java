package com.backend.desafio.controller;

import com.backend.desafio.model.Hospede;
import com.backend.desafio.repository.HospedeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/set")
public class HospedeSetService {

    @Autowired
    private HospedeRepository repository;

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Hospede hospede) throws JsonProcessingException {


        try {
            repository.save(hospede);
        }catch (Exception e){
            return ResponseEntity.status(500).body("Erro ao persistir objeto, stack: "+e);
        }
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity delete(@RequestParam Long id){

        try {
            repository.deleteById(id);
        }catch (Exception e){
            return ResponseEntity.status(500).body("Erro ao deletar, stack: "+e);
        }
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Hospede hospede, @RequestParam Long id){

        hospede.setDocumento(id);
        try {
            repository.save(hospede);
        }catch (Exception e){
            return ResponseEntity.status(500).body("Erro ao fazer uupdate, stack: "+e);
        }
        return ResponseEntity.ok().build();
    }
}
