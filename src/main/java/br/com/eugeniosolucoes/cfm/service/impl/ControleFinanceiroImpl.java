/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.cfm.service.impl;

import br.com.eugeniosolucoes.cfm.model.Balanco;
import br.com.eugeniosolucoes.cfm.model.Categoria;
import br.com.eugeniosolucoes.cfm.model.Frequencia;
import br.com.eugeniosolucoes.cfm.model.Lancamento;
import br.com.eugeniosolucoes.cfm.repository.IBalancoRepository;
import br.com.eugeniosolucoes.cfm.repository.impl.BalancoRepositoryImpl;
import br.com.eugeniosolucoes.cfm.service.IControleFinanceiro;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ControleFinanceiroImpl implements IControleFinanceiro {


    private static final String CATEGORIAS_BIN = "categorias.bin";

    private static final String FREQUENCIAS_BIN = "frequencias.bin";

    private static final String LANCAMENTOS_BIN = "lancamentos.bin";

    private static final Logger LOGGER = Logger.getLogger( ControleFinanceiroImpl.class.getName() );

    private final IBalancoRepository repository = new BalancoRepositoryImpl();

    private int usuario;

    private final List<Categoria> categorias;

    private final List<Frequencia> frequencias;

    private final List<Lancamento> lancamentos;

    public ControleFinanceiroImpl() {
        this.lancamentos = new ArrayList<>();
        this.frequencias = new ArrayList<>();
        this.categorias = new ArrayList<>();
    }

    @Override
    public void salvarLancamento( Lancamento lancamento ) {
        try {
            validarLancamento( lancamento );
            if ( lancamentos.contains( lancamento ) ) {
                lancamentos.remove( lancamento );
            }
            lancamentos.add( lancamento );
            repository.serializar( lancamentos, LANCAMENTOS_BIN );
        } catch ( Exception ex ) {
            LOGGER.log( Level.SEVERE, ex.getMessage(), ex );
        }
    }

    @Override
    public void excluirLancamento( Lancamento lancamento ) {
        try {
            if ( lancamentos.remove( lancamento ) ) {
                repository.serializar( lancamentos, LANCAMENTOS_BIN );
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

    @Override
    public List<Categoria> getCategorias() {
        try {
            List<Categoria> result = repository.getCategorias( usuario );
            repository.serializar( result, CATEGORIAS_BIN );
            return result;
        } catch ( Exception e ) {
            LOGGER.log( Level.INFO, e.getMessage() );
            try {
                return repository.deserializar( CATEGORIAS_BIN );
            } catch ( Exception ex ) {
                LOGGER.log( Level.INFO, ex.getMessage() );
            }
        }
        return Collections.emptyList();
    }

    @Override
    public List<Frequencia> getFrequencias() {
        try {
            return repository.getFrequencias( usuario );
        } catch ( Exception e ) {
            LOGGER.log( Level.INFO, e.getMessage() );
        }
        return Collections.emptyList();
    }

    @Override
    public void autenticar( String usuario, String senha ) {
        this.usuario = 1;
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
