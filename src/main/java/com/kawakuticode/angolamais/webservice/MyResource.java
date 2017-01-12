package com.kawakuticode.angolamais.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Hello, Heroku!";
    }
    

    @GET
    @Path("/history")
    @Produces(MediaType.APPLICATION_JSON)
    public HistorySnippet historyContentJso() {
 
    HistorySnippet history_temp = new HistorySnippet(); 
   
    history_temp.setTitle("Origin");
    history_temp.setContent("O nome Angola é uma derivação portuguesa do termo bantu N’gola, "
    		+ "título dos reis do Reino do Ndongo exisdtente "
    		+ "na altura em que os portugueses se estabeleceram em Luanda, no século XVI.");
        
        return history_temp;
    }
}
