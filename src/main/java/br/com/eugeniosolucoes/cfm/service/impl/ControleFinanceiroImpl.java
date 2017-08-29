/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.cfm.service.impl;

import br.com.eugeniosolucoes.cfm.model.Balanco;
import br.com.eugeniosolucoes.cfm.model.Lancamento;
import br.com.eugeniosolucoes.cfm.repository.IBalancoRepository;
import br.com.eugeniosolucoes.cfm.repository.impl.BalancoRepositoryImpl;
import br.com.eugeniosolucoes.cfm.service.IControleFinanceiro;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControleFinanceiroImpl implements IControleFinanceiro {

    private static final String ARQUIVO_LOCAL = "lancamentos.bin";

    private static final Logger LOGGER = Logger.getLogger( ControleFinanceiroImpl.class.getName() );

    private final IBalancoRepository repository = new BalancoRepositoryImpl();

    private Set<Lancamento> lancamentos;

    public ControleFinanceiroImpl() {
        try {
            lancamentos = repository.deserializar( ARQUIVO_LOCAL );
        } catch ( Exception e ) {
            LOGGER.log( Level.INFO, e.getMessage() );
            lancamentos = new HashSet<>();
        }
    }
   

    @Override
    public Balanco getBalanco( int mes, int ano, int usuario ) {
        Balanco balanco = new Balanco( mes, ano );
        try {
            balanco = repository.getBalanco( usuario, ano, mes );
        } catch ( Exception e ) {
            LOGGER.log( Level.INFO, e.getMessage() );
        }
        return balanco;
    }

    @Override
    public void salvarLancamento( Lancamento lancamento ) {
        try {
            validarLancamento( lancamento );
            lancamentos.add( lancamento );
            repository.serializar( lancamentos, ARQUIVO_LOCAL );
        } catch ( Exception ex ) {
            LOGGER.log( Level.SEVERE, ex.getMessage(), ex );
        }
    }

    @Override
    public void excluirLancamento( Lancamento lancamento ) {
        try {
            if ( lancamentos.remove( lancamento ) ) {
                repository.serializar( lancamentos, ARQUIVO_LOCAL );
            }
        } catch ( Exception ex ) {
            LOGGER.log( Level.SEVERE, ex.getMessage(), ex );
        }
    }

    @Override
    public void sincronizar() {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Lancamento> getLancamentos() {
        return new ArrayList<>( lancamentos );
    }

    private void validarLancamento( Lancamento lancamento ) {
        if ( lancamento.getDescricao() == null || lancamento.getDescricao().isEmpty() ) {
            throw new IllegalArgumentException( "A descrição é requerida!" );
        }
        if ( lancamento.getTipo() == null ) {
            throw new IllegalArgumentException( "O tipo é requerido!" );
        }
        if ( lancamento.getInclusao() == null ) {
            throw new IllegalArgumentException( "A inclusão é requerida!" );
        }
        if ( lancamento.getUsuario() <= 0 ) {
            throw new IllegalArgumentException( "O usuário é requerido!" );
        }
    }

}
