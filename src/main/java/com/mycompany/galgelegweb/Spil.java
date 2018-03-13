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
@Path("spil")
public class Spil {

    @GET
    public String spilSide() throws IOException {
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache m = mf.compile("spil.mustache");

        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("synligtOrd", spil.getSynligtOrd());
        data.put("brugte", spil.getBrugteBogstaver());
        data.put("forsøg", spil.getAntalForkerteBogstaver());

        StringWriter writer = new StringWriter();
        m.execute(writer, data).flush();
        return writer.toString();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String gætBogstav(@FormParam("bogstav") String bogstav) throws IOException {
        spil.gætBogstav(bogstav);
        if (spil.erSpilletSlut()) {
            if (spil.erSpilletTabt()) {
                return "<p>Du har tabt</p>"+ "<a href=\"/\">Tilbage til start</a>";
            } else {
                return "<p>Du har vundet</p>" +
                        "<a href=\"/\">Tilbage til start</a>";
            }
        } else {
            return spilSide();
        }

    }
}
