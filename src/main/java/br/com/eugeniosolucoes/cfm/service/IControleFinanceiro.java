/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.cfm.service;

import br.com.eugeniosolucoes.cfm.model.Balanco;
import br.com.eugeniosolucoes.cfm.model.Categoria;
import br.com.eugeniosolucoes.cfm.model.Frequencia;
import br.com.eugeniosolucoes.cfm.model.Lancamento;
import java.util.List;

/**
 *
 * @author eugenio
 */
public interface IControleFinanceiro {

    void autenticar( String usuario, String senha );

    List<Lancamento> getLancamentos();

    List<Categoria> getCategorias();

    List<Frequencia> getFrequencias();

    void salvarLancamento( Lancamento lancamento );

    void excluirLancamento( Lancamento lancamento );

    void sincronizar();
}
