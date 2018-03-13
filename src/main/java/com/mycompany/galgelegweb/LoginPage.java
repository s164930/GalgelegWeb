/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.galgelegweb;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import static com.mycompany.galgelegweb.Startside.spil;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author viktor
 */
@Path("loginpage")
public class LoginPage {
    
    @GET
    public String loginScreen() throws IOException{
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache m = mf.compile("loginpage.mustache");
        
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("tekst", "Indtast brugernavn og adgangskode til saluton serveren.");
        
        StringWriter writer = new StringWriter();
        m.execute(writer, data).flush();
        return writer.toString();
    }
    
    public String loginScreen(String tekst) throws IOException{
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache m = mf.compile("loginpage.mustache");
        
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("tekst", tekst);
        
        StringWriter writer = new StringWriter();
        m.execute(writer, data).flush();
        return writer.toString();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String checkLogin(@FormParam("brugernavn") String bn,
          @FormParam("adgangskode") String kode) throws IOException{
        if(spil.login(bn, kode)){
            spil.nulstil();
            Spil spil = new Spil();
            return spil.spilSide();
        } else {
            return loginScreen("Forkert, prøv igen");
        }
    }
    
}
