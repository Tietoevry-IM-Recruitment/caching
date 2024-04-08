package org.tietoevry;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(baseUri = "https://jsonplaceholder.typicode.com")
public interface UserServiceClient {

    @GET
    @Path("/users")
    List<User> getUsers();

}
