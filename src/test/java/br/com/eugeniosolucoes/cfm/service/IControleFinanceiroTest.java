/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.cfm.service;

import br.com.eugeniosolucoes.cfm.model.Balanco;
import br.com.eugeniosolucoes.cfm.model.Lancamento;
import br.com.eugeniosolucoes.cfm.model.Tipo;
import br.com.eugeniosolucoes.cfm.service.impl.ControleFinanceiroImpl;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eugenio
 */
public class IControleFinanceiroTest {
    

    /**
     * Test of getBalanco method, of class IControleFinanceiro.
     */
    @Test
    public void testGetBalanco() {
        System.out.println( "getBalanco" );
        int mes = 0;
        int ano = 0;
        int usuario = 0;
        IControleFinanceiro instance = new ControleFinanceiroImpl();
        Balanco result = instance.getBalanco( mes, ano, usuario );
        assertNotNull( result );
    }

    /**
     * Test of salvarLancamento method, of class IControleFinanceiro.
     */
    @Test
    public void testSalvarLancamento() {
        System.out.println( "salvarLancamento" );
        Lancamento lancamento = new Lancamento( Tipo.DEBITO, "teste", "2017-08-01", "1", "10.00", 1 );
        IControleFinanceiro instance = new ControleFinanceiroImpl();
        Balanco expResult = new Balanco( 8, 2017 );
        expResult.debitar( new BigDecimal( "10.00" ) );
        Balanco result = instance.salvarLancamento( lancamento );
        assertEquals( expResult.getBalanco(), result.getBalanco() );
    }

    
    
}
