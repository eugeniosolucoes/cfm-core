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
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
  
    private int id;
    
    private Tipo tipo;
    
    private String descricao;

    public Categoria() {
    }

    public Categoria( Tipo tipo, String descricao ) {
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public Categoria( int id, Tipo tipo, String descricao ) {
        this.id = id;
        this.tipo = tipo;
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

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo( Tipo tipo ) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode( this.tipo );
        hash = 97 * hash + Objects.hashCode( this.descricao );
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
        final Categoria other = (Categoria) obj;
        if ( !Objects.equals( this.descricao, other.descricao ) ) {
            return false;
        }
        return this.tipo == other.tipo;
    }

    @Override
    public String toString() {
        return "Categoria{" + "tipo=" + tipo + ", descricao=" + descricao + '}';
    }

}
