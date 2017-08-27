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
import java.util.List;

public class ControleFinanceiroImpl implements IControleFinanceiro {

    private final IBalancoRepository repository = new BalancoRepositoryImpl();

    private final List<Balanco> periodos = new ArrayList<>();
    
    @Override
    public Balanco getBalanco( int mes, int ano, int usuario ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public Balanco salvarLancamento( Lancamento lancamento ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Balanco excluirLancamento( Lancamento lancamento ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sincronizar() {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

}
