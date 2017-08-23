/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.cfm.service.impl;

import br.com.eugeniosolucoes.cfm.model.Balanco;
import br.com.eugeniosolucoes.cfm.model.Lancamento;
import br.com.eugeniosolucoes.cfm.repository.BalancoRepository;
import br.com.eugeniosolucoes.cfm.service.IControleFinanceiro;
import java.util.ArrayList;
import java.util.List;

public class ControleFinanceiroImpl implements IControleFinanceiro {

    private final BalancoRepository repository = new BalancoRepository();

    private final List<Balanco> lista = new ArrayList<>();

    @Override
    public Balanco getBalanco( int mes, int ano, int usuario ) {
        try {
            Balanco balanco = repository.getFromJson( usuario, ano, mes );
            if ( balanco != null ) {
                adicionarBalanco( balanco );
                return balanco;
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        Balanco balanco = new Balanco( mes, ano );
        adicionarBalanco( balanco );
        return balanco;
    }

    private void adicionarBalanco( Balanco balanco ) {
        int index = lista.indexOf( balanco );
        if ( index == -1 ) {
            lista.add( balanco );
        } else {
            lista.add( index, balanco );
        }
    }

    @Override
    public Balanco salvarLancamento( Lancamento lancamento ) {
        Balanco balanco = new Balanco( lancamento.getMes(), lancamento.getAno() );
        if ( lista.contains( balanco ) ) {
            int index = lista.indexOf( balanco );
            balanco = lista.get( index );
            balanco.getLancamentos().add( lancamento );
            switch ( lancamento.getTipo() ) {
                case CREDITO:
                    balanco.creditar( lancamento.getValorTotal() );
                    break;
                default:
                    balanco.debitar( lancamento.getValorTotal() );
            }

        } else {
            lista.add( new Balanco( lancamento.getMes(), lancamento.getAno() ) );
            salvarLancamento( lancamento );
        }
        return lista.get( lista.indexOf( balanco ) );
    }

    @Override
    public Balanco excluirLancamento( Lancamento lancamento ) {
        Balanco balanco = new Balanco( lancamento.getMes(), lancamento.getAno() );
        if ( lista.contains( balanco ) ) {
            int index = lista.indexOf( balanco );
            balanco = lista.get( index );
            balanco.debitar( lancamento.getValorTotal().negate() );
            balanco.getLancamentos().remove( lancamento );
        }
        return balanco;
    }

}
