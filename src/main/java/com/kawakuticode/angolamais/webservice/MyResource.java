package com.kawakuticode.angolamais.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



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
        return "Hello,welcome to  angola mais app webservice!";
    }
    

    @GET
    @Path("/history")
    @Produces(MediaType.APPLICATION_JSON)
    public HistorySnippet historyContentJson() {
 
    HistorySnippet history_temp = new HistorySnippet(); 
   
    history_temp.setTitle("Origin");
    history_temp.setContent("O nome Angola é uma derivação portuguesa do termo bantu N’gola, "
    		+ "título dos reis do Reino do Ndongo exisdtente "
    		+ "na altura em que os portugueses se estabeleceram em Luanda, no século XVI.");
        
        return history_temp;
    }
    
    @GET
    @Path("/testerjson")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject testArray(){
    	JSONObject obj = new JSONObject();
		obj.put("name", "Military");
		obj.put("content", "military dasdasdasd");
		
		JSONObject obj2 = new JSONObject();
		obj2.put("name", "police");
		obj2.put("content","police dasdasdasd");
		
		JSONObject obj3 = new JSONObject();
		obj3.put("name", "justice");
		obj3.put("content", "justice dasdasdasd");

		
		JSONArray list_topics = new JSONArray();
		list_topics.add(obj);
		list_topics.add(obj2);
		list_topics.add(obj3);
		
		
		
		
		JSONObject objx = new JSONObject();
		objx.put("name", "mkyong.com");
		objx.put("content", new Integer(100));
		
		JSONObject obj2x = new JSONObject();
		obj2x.put("name", "matrix");
		obj2x.put("content", new Integer(101));

		
		JSONArray list_topicsx = new JSONArray();
		list_topicsx.add(objx);
		list_topicsx.add(obj2x);
		
		
		
		JSONObject obj_topic = new JSONObject();
		obj_topic.put("etmology", list_topics);
		obj_topic.put("history", list_topics);
		
		
		return obj_topic; 
    	
    }
}
