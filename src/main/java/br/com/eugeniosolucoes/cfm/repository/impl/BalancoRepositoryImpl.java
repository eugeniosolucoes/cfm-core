/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.cfm.repository.impl;

import br.com.eugeniosolucoes.cfm.model.Balanco;
import br.com.eugeniosolucoes.cfm.model.Categoria;
import br.com.eugeniosolucoes.cfm.model.Frequencia;
import br.com.eugeniosolucoes.cfm.repository.IBalancoRepository;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eugenio
 */
public class BalancoRepositoryImpl implements IBalancoRepository {

    static final String URL = "http://localhost/layout/dados/json.php?comando=%s&usuario=%d&ano=%d&mes=%d";

    @Override
    public Balanco getBalanco( int usuario, int ano, int mes ) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = getJSON( "balanco", usuario, ano, mes );
            json = String.format( "{\"balancos\": %s}", json );
            // Convert JSON string from file to Object
            mapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false );
            return mapper.readValue( json, Balancos.class ).balancos.get( 0 );
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

    @Override
    public Balanco getPeriodo( int usuario, int ano, int mes ) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = getJSON( "periodo", usuario, ano, mes );
            json = String.format( "{\"balancos\": %s}", json );
            // Convert JSON string from file to Object
            DateFormat df = new SimpleDateFormat( "yyyy-MM-dd" );
            mapper.setDateFormat( df );
            mapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false );
            return mapper.readValue( json, Balancos.class ).balancos.get( 0 );
        } catch ( JsonGenerationException e ) {
            e.printStackTrace();
        } catch ( JsonMappingException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Categoria> getCategorias( int usuario ) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = getJSON( "categorias", usuario, 0, 0 );
            json = String.format( "{\"categorias\": %s}", json );
            // Convert JSON string from file to Object
            mapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false );
            return mapper.readValue( json, Categorias.class ).categorias;
        } catch ( JsonGenerationException e ) {
            e.printStackTrace();
        } catch ( JsonMappingException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Frequencia> getFrequencias( int usuario ) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = getJSON( "frequencias", usuario, 0, 0 );
            json = String.format( "{\"frequencias\": %s}", json );
            // Convert JSON string from file to Object
            mapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false );
            return mapper.readValue( json, Frequencias.class ).frequencias;
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

    @Override
    public <E> void serializar( E element, String fileName ) throws Exception {
        try ( ObjectOutput output = new ObjectOutputStream( new FileOutputStream( fileName ) ) ) {
            output.writeObject( element );
        }
    }

    @Override
    public <E> E deserializar( String fileName ) throws Exception {
        ObjectInput input = new ObjectInputStream( new FileInputStream( fileName ) );
        return (E) input.readObject();
    }

    private static class Categorias {

        List<Categoria> categorias = new ArrayList<>();

        public Categorias() {
        }

        public List<Categoria> getCategorias() {
            return categorias;
        }
        List<Balanco> balancos = new ArrayList<>();

        public void setCategorias( List<Categoria> categorias ) {
            this.categorias = categorias;
        }

    }

    private static class Frequencias {

        List<Frequencia> frequencias = new ArrayList<>();

        public Frequencias() {
        }

        public List<Frequencia> getFrequencias() {
            return frequencias;
        }

        public void setFrequencias( List<Frequencia> frequencias ) {
            this.frequencias = frequencias;
        }
        
        
    }

    private static class Balancos {

        List<Balanco> balancos = new ArrayList<>();
        
        public Balancos() {
        }

        public List<Balanco> getBalancos() {
            return balancos;
        }

        public void setBalancos( List<Balanco> balancos ) {
            this.balancos = balancos;
        }
    }
}
