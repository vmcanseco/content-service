/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compact.packtpub.javaee8;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

/**
 *
 * @author VMC027
 */
@ApplicationPath("api")
public class JAXRSConfiguration extends Application{
    
        @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();

        classes.add(DocumentsResource.class);
        classes.add(MultiPartFeature.class);
        classes.add(JsonbResource.class);
        classes.add(JsonpResource.class);
        return classes;
    }
    
}
