package org.tietoevry;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestPath;

import java.util.List;

@Path("/users")
public class UserResource {

    @RestClient
    UserServiceClient userServiceClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return userServiceClient.getUsers();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@RestPath Integer id) {
        return getAllUsers().stream().filter(user -> user.id() == id).findFirst().orElseThrow(NotFoundException::new);
    }

}
