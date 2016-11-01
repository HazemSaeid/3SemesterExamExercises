package rest;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nimbusds.jose.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import security.IUserFacade;
import security.UserFacadeFactory;

@Path("signup")
public class SignUp {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewUser(String jsonString) throws JOSEException {
        IUserFacade facade = UserFacadeFactory.getInstance();
        try {
            JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();
            String username = json.get("username").getAsString();
            String password = json.get("password").getAsString();
            JsonObject responseJson = new JsonObject();
            facade.addNewUser(username, password);
 
        } catch (Exception e) {
                 throw e;
                 }
        return Response.ok().build();
    }
}
