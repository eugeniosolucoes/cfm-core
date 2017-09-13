/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.cfm;

import br.com.eugeniosolucoes.cfm.model.Lancamento;
import br.com.eugeniosolucoes.cfm.model.Tipo;
import br.com.eugeniosolucoes.cfm.service.IControleFinanceiro;
import br.com.eugeniosolucoes.cfm.service.impl.ControleFinanceiroImpl;
import java.util.List;

/**
 *
 * @author eugenio
 */
public class Main {

    public static void main( String[] args ) {

        IControleFinanceiro icf = new ControleFinanceiroImpl();

        Lancamento lancamento = new Lancamento( Tipo.DEBITO, "teste1", "2017-08-01", "1", "30", 1 );
        icf.salvarLancamento( lancamento );
        Lancamento lancamento1 = new Lancamento( Tipo.DEBITO, "teste1", "2017-08-01", "1", "35", 1 );
        icf.salvarLancamento( lancamento1 );

        icf.excluirLancamento( lancamento );

        System.out.println( icf.getLancamentos() );

    }

}
