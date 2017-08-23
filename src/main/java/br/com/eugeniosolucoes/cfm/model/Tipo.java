/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.cfm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author eugenio
 */
public enum Tipo {
   
    @JsonProperty(value = "debito")
    DEBITO( "débito" ), 
    @JsonProperty(value = "credito")
    CREDITO( "crédito" );

    private final String descricao;

    private Tipo( String descricao ) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
