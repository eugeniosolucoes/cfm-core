/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.cfm.repository;

import br.com.eugeniosolucoes.cfm.model.Balanco;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author eugenio
 */
public class BalancoRepository {

    static final String URL = "http://www.eugeniosolucoes.com.br/cfm3.0/dados/json.php?comando=%s&usuario=%d&ano=%d&mes=%d";

    public Balanco getFromJson( int usuario, int ano, int mes ) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = getJSON( "balanco", usuario, ano, mes );
            if ( json != null && !json.isEmpty() ) {
                json = json.substring( json.indexOf( '[' ) + 1, json.lastIndexOf( ']' ) );
            } else {
                return null;
            }
            if ( json.isEmpty() ) {
                return null;
            }
            // Convert JSON string from file to Object
            DateFormat df = new SimpleDateFormat( "yyyy-MM-dd" );
            mapper.setDateFormat( df );
            mapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false );
            return mapper.readValue( json, Balanco.class );
//            System.out.println( balanco );
//            //Pretty print
//            String balancoPrint = mapper.writerWithDefaultPrettyPrinter().writeValueAsString( balanco );
//            System.out.println( balancoPrint );
        } catch ( JsonGenerationException e ) {
            e.printStackTrace();
        } catch ( JsonMappingException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        return null;
    }

    private String getJSON( String comando, int usuario, int ano, int mes ) {
        HttpURLConnection c = null;
        try {
            URL u = new URL( String.format( URL, comando, usuario, ano, mes ) );
            c = (HttpURLConnection) u.openConnection();
            c.connect();
            int status = c.getResponseCode();
            switch ( status ) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader( new InputStreamReader( c.getInputStream() ) );
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ( (line = br.readLine()) != null ) {
                        sb.append( line + "\n" );
                    }
                    br.close();
                    return sb.toString();
            }

        } catch ( Exception ex ) {
            return ex.toString();
        } finally {
            if ( c != null ) {
                try {
                    c.disconnect();
                } catch ( Exception ex ) {
                    //disconnect error
                }
            }
        }
        return "";
    }

}
