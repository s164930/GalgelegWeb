/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.galgelegweb;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
/**
 *
 * @author viktor
 */
@Path("")
public class Startside {
    public static galgeleg.GalgelogikImplService service;
    public static galgeleg.Galgelogik spil;
    @GET
    public String getIndexHtml() throws IOException {
        service = new galgeleg.GalgelogikImplService();
        spil = service.getGalgelogikImplPort();
        //Initialize Mustache renderer
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache m = mf.compile("startside.mustache");
        
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("lol", "lol");
        
        StringWriter writer = new StringWriter();
        m.execute(writer, data).flush();
        String html = writer.toString();
        return html;
    }
}