/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compact.packtpub.javaee8;

import java.util.Collections;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author VMC027
 */
@Path("version")
@RequestScoped
public class VersionResource {
    
    public static final MediaType V1=new MediaType("application", "vnd.version.v1+json");
    
    public static final MediaType V2=new MediaType("application", "vnd.version.v2+json");;
    
    @GET
    @Produces("application/vnd.version.v1+json")
    public Response v1(){
        Map<String,String> version=Collections.singletonMap("version", "v1");
        return Response.ok(version).build();
    }
    
    @GET
    @Produces({"application/json","application/vnd.version.v2+json"})
    public Response v2(){
        Map<String,String> version=Collections.singletonMap("version", "v2");
        return Response.ok(version).build();
    }
    
}
