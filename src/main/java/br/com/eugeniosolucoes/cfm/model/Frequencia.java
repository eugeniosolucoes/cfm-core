/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.cfm.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author eugenio
 */
public class Frequencia implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String descricao;

    public Frequencia() {
    }

    public Frequencia( String descricao ) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao( String descricao ) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode( this.descricao );
        return hash;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final Frequencia other = (Frequencia) obj;
        return Objects.equals( this.descricao, other.descricao );
    }

    @Override
    public String toString() {
        return "Frequencia{" + "descricao=" + descricao + '}';
    }

}
