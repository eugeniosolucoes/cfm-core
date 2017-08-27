/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.cfm;

import br.com.eugeniosolucoes.cfm.model.Balanco;
import br.com.eugeniosolucoes.cfm.model.Categoria;
import br.com.eugeniosolucoes.cfm.model.Frequencia;
import br.com.eugeniosolucoes.cfm.repository.IBalancoRepository;
import br.com.eugeniosolucoes.cfm.repository.impl.BalancoRepositoryImpl;
import java.util.List;

/**
 *
 * @author eugenio
 */
public class Main {

    public static void main( String[] args ) {

        IBalancoRepository repository = new BalancoRepositoryImpl();

        Balanco periodo = repository.getPeriodo( 1, 2017, 8 );
        
        System.out.println( periodo );

    }
}
