/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package compact.packtpub.javaee8;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author VMC027
 */
@ApplicationScoped
@Path("json-p")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JsonpResource {
    
    private static final Logger LOGGER=Logger.getAnonymousLogger();
    
    private JsonArray jsonArray;
    
    @HEAD
    @PostConstruct
    
    public void initialize(){
        this.jsonArray=Json.createArrayBuilder()
                .add(Json.createObjectBuilder()
                        .add("aString","Hello Json-P 1")
                        .add("aInteger",42)
                        .add("aBoolean",false)
                        .add("aNullValue",JsonValue.NULL))
                .add(Json.createObjectBuilder()
                        .add("aString","Hello Json-P 2")
                        .add("aInteger",23)
                        .add("aBoolean",false))
                .build();
                
    }
    
    @GET
    public JsonArray marshalling(){
        
        return  this.jsonArray;
    }
    
    @POST
    public void unmarshalling(InputStream jsonBody){
        JsonReader reader=Json.createReader(jsonBody);
        this.jsonArray=reader.readArray();
        
        LOGGER.log(Level.INFO, "Unmarshalled JSON-P {0}",jsonArray);

    }
}
    
    

