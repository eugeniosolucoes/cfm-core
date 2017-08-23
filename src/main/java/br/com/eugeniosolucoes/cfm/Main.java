/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.cfm;

import br.com.eugeniosolucoes.cfm.model.Balanco;
import br.com.eugeniosolucoes.cfm.model.Lancamento;
import br.com.eugeniosolucoes.cfm.model.Tipo;
import br.com.eugeniosolucoes.cfm.service.IControleFinanceiro;
import br.com.eugeniosolucoes.cfm.service.impl.ControleFinanceiroImpl;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author eugenio
 */
public class Main {

    public static void main( String[] args ) {

        IControleFinanceiro icf = new ControleFinanceiroImpl();

        Balanco balanco = icf.getBalanco( 7, 2017, 1 );

        Lancamento lancamento = new Lancamento();
        lancamento.setInclusao( Date.from( LocalDate.of( 2017, Month.JULY, 10 )
                .atStartOfDay( ZoneId.systemDefault() ).toInstant() ) );
        lancamento.setUsuario( 1 );
        lancamento.setValor( new BigDecimal( "10" ) );
        lancamento.setTipo( Tipo.CREDITO );
        
        icf.salvarLancamento( lancamento );

        //icf.excluirLancamento( lancamento );
        System.out.printf( "%.2f%n", balanco.getBalanco() );
    }
}
