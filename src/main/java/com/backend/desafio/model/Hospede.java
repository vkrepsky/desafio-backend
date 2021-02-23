package com.backend.desafio.model;


import com.backend.desafio.util.Utils;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name="hospede")
public class Hospede implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documento; //id
    private String nome;
    private String telefone;

    //checkIn
    //como a relação hospede - checkIn é one to one, não vi necessidade de criar uma tabela adicional,
    // considerando que desta forma a performance é melhor e o código mais simples
    private LocalDateTime dataCheckIn;
    private LocalDateTime dataCheckOut;
    private boolean adicionalVeiculo;


    public Hospede(){}

    public Hospede(String nome, String telefone, LocalDateTime dataCheckIn, LocalDateTime dataCheckOut, boolean adicionalVeiculo) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.adicionalVeiculo = adicionalVeiculo;
    }

    public Hospede(Long documento, String nome, String telefone, LocalDateTime dataCheckIn, LocalDateTime dataCheckOut, boolean adicionalVeiculo) {
        this.documento = documento;
        this.nome = nome;
        this.telefone = telefone;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.adicionalVeiculo = adicionalVeiculo;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public LocalDateTime getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(LocalDateTime dataCheckIn) {
        this.dataCheckIn = parseDate(dataCheckIn);
    }

    public LocalDateTime getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(LocalDateTime dataCheckOut) {
        this.dataCheckOut = parseDate(dataCheckOut);
    }

    public boolean isAdicionalVeiculo() {
        return adicionalVeiculo;
    }

    public void setAdicionalVeiculo(boolean adicionalVeiculo) {
        this.adicionalVeiculo = adicionalVeiculo;
    }

    public Integer getValor() {
        int valor;

        Map<String,Integer> map= Utils.getDias(dataCheckIn,dataCheckOut);

        int diaSemana = map.get("diasDeSemana");
        int fimDeSemana = map.get("fimDeSemana");

        if(adicionalVeiculo){
            valor = (120+15)*diaSemana + (150+20)*fimDeSemana;
        }else {
            valor = 120*diaSemana + 150*fimDeSemana;
        }
        return valor;
    }

    public boolean isHospedado(){
        return LocalDateTime.now().isBefore(dataCheckOut);
    }

    private LocalDateTime parseDate(LocalDateTime date){

       if (date.toString().length() ==19){
           return date;
       }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss").withZone(ZoneId.of("UTC"));

        return  LocalDateTime.parse(date.toString()+":00", formatter);
    }

}
