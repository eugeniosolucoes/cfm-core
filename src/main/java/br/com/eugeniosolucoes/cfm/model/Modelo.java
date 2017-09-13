/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.cfm.model;

import java.io.Serializable;

/**
 *
 * @author eugenio
 */
public class Modelo implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean online;

    public boolean isOnline() {
        return online;
    }

    public void setOnline( boolean online ) {
        this.online = online;
    }

}
