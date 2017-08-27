/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.cfm.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author eugenio
 */
public class Lancamento implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private Tipo tipo;
    
    private String descricao;
    
    private int frequencia;
    
    private Date inclusao;
    
    private BigDecimal quantidade;
    
    private BigDecimal valor;
    
    private String link;
    
    private String categorias;
    
    private int usuario;
    
    private boolean local;
    
    public Lancamento() {
        this.inclusao = Date.from( LocalDate.now().atStartOfDay( ZoneId.systemDefault() ).toInstant() );
        this.tipo = Tipo.DEBITO;
        this.quantidade = BigDecimal.ONE;
        this.valor = BigDecimal.ZERO;
        this.descricao = "";
        this.link = "";
        this.categorias = "";
    }
    
    public Lancamento( Integer id ) {
        this();
        this.id = id;
    }
    
    public Lancamento( Tipo tipo, String descricao, String inclusao, String quantidade, String valor, int usuario ) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.inclusao = Date.from( LocalDate.parse( inclusao, DateTimeFormatter.ISO_DATE ).atStartOfDay( ZoneId.systemDefault() ).toInstant() );
        this.quantidade = new BigDecimal( quantidade );
        this.valor = new BigDecimal( valor );
        this.usuario = usuario;
        this.local = true;
    }
    
    public Integer getId() {
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
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao( String descricao ) {
        this.descricao = descricao;
    }
    
    public int getFrequencia() {
        return frequencia;
    }
    
    public void setFrequencia( int frequencia ) {
        this.frequencia = frequencia;
    }
    
    public Date getInclusao() {
        return inclusao;
    }
    
    public void setInclusao( Date inclusao ) {
        this.inclusao = inclusao;
    }
    
    public BigDecimal getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade( BigDecimal quantidade ) {
        this.quantidade = quantidade;
    }
    
    public BigDecimal getValor() {
        return valor;
    }
    
    public void setValor( BigDecimal valor ) {
        this.valor = valor;
    }
    
    public BigDecimal getValorTotal() {
        return valor.multiply( quantidade );
    }
    
    public String getLink() {
        return link;
    }
    
    public void setLink( String link ) {
        this.link = link;
    }
    
    public String getCategorias() {
        return categorias;
    }
    
    public void setCategorias( String categorias ) {
        this.categorias = categorias;
    }
    
    public int getUsuario() {
        return usuario;
    }
    
    public void setUsuario( int usuario ) {
        this.usuario = usuario;
    }
    
    public int getMes() {
        return inclusao.toInstant().atZone( ZoneId.systemDefault() ).toLocalDate().getMonthValue();
    }
    
    public int getAno() {
        return inclusao.toInstant().atZone( ZoneId.systemDefault() ).toLocalDate().getYear();
    }
    
    public int getDia() {
        return inclusao.toInstant().atZone( ZoneId.systemDefault() ).toLocalDate().getDayOfMonth();
    }

    public boolean isLocal() {
        return local;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode( this.tipo );
        hash = 97 * hash + Objects.hashCode( this.descricao );
        hash = 97 * hash + Objects.hashCode( this.inclusao );
        hash = 97 * hash + Objects.hashCode( this.quantidade );
        hash = 97 * hash + Objects.hashCode( this.valor );
        hash = 97 * hash + this.usuario;
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
        final Lancamento other = (Lancamento) obj;
        if ( this.usuario != other.usuario ) {
            return false;
        }
        if ( !Objects.equals( this.descricao, other.descricao ) ) {
            return false;
        }
        if ( this.tipo != other.tipo ) {
            return false;
        }
        if ( !Objects.equals( this.inclusao, other.inclusao ) ) {
            return false;
        }
        if ( !Objects.equals( this.quantidade, other.quantidade ) ) {
            return false;
        }
        return Objects.equals( this.valor, other.valor );
    }

    
    
    @Override
    public String toString() {
        return String.format( "%s - %s - %s - %.2f", this.tipo.getDescricao(),
                this.descricao, String.format( "%d-%d-%d", getAno(), getMes(),
                        getDia() ), this.getValorTotal() );
    }
    
    
}
