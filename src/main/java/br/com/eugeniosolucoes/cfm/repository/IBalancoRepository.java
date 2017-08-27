/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.cfm.repository;

import br.com.eugeniosolucoes.cfm.model.Balanco;
import br.com.eugeniosolucoes.cfm.model.Categoria;
import br.com.eugeniosolucoes.cfm.model.Frequencia;
import java.util.List;

/**
 *
 * @author eugenio
 */
public interface IBalancoRepository {

    Balanco getBalanco( int usuario, int ano, int mes );

    Balanco getPeriodo( int usuario, int ano, int mes );

    List<Categoria> getCategorias( int usuario );
    
    List<Frequencia> getFrequencias( int usuario );
    /**
     * 
     * @param <E>
     * @param file
     * @return
     * @throws Exception 
     */
    <E> E deserializar( String file ) throws Exception;

    /**
     *
     * @param <E>
     * @param element
     * @param file
     * @throws Exception
     */
    <E> void serializar( E element, String file ) throws Exception;
    
}
