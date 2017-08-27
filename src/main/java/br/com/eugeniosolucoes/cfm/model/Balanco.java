/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.cfm.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eugenio
 */
public class Balanco implements Serializable {


    private static final long serialVersionUID = 1L;
    
    private int mes;

    private int ano;

    private BigDecimal creditos;

    private BigDecimal debitos;

    private List<Lancamento> lancamentos;
    
    public Balanco() {
        this.creditos = BigDecimal.ZERO;
        this.debitos = BigDecimal.ZERO;
    }

    public Balanco( int mes, int ano ) {
        this();
        this.mes = mes;
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes( int mes ) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno( int ano ) {
        this.ano = ano;
    }

    public BigDecimal getCreditos() {
        return creditos;
    }

    public void creditar( BigDecimal valor ) {
        this.creditos = this.creditos.add( valor );
    }

    public BigDecimal getDebitos() {
        return debitos;
    }

    public void debitar( BigDecimal valor ) {
        this.debitos = this.debitos.add( valor );
    }

    public BigDecimal getBalanco() {
        return this.creditos.subtract( this.debitos );
    }

    public List<Lancamento> getLancamentos() {
        if ( lancamentos == null ) {
            lancamentos = new ArrayList<>();
        }
        return lancamentos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.mes;
        hash = 97 * hash + this.ano;
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
        final Balanco other = (Balanco) obj;
        if ( this.mes != other.mes ) {
            return false;
        }
        return this.ano == other.ano;
    }

    @Override
    public String toString() {
        return String.format( "Ano: %s Mês: %s - Créditos: %.2f Débitos: %.2f Balanço: %.2f", 
                this.ano, this.mes, this.creditos, this.debitos, 
                this.getBalanco() );
    }

}
