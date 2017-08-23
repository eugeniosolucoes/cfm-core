/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.cfm.service;

import br.com.eugeniosolucoes.cfm.model.Balanco;
import br.com.eugeniosolucoes.cfm.model.Lancamento;

/**
 *
 * @author eugenio
 */
public interface IControleFinanceiro {

    Balanco getBalanco( int mes, int ano, int usuario );

    Balanco salvarLancamento( Lancamento lancamento );

    Balanco excluirLancamento( Lancamento lancamento );
}