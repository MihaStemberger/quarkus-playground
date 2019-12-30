package org.acme.util;


import org.acme.User;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/users")
@ApplicationScoped
public class UserResource {

    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User("test", "user"));
    }

    @GET
    @Produces(MediaType.APPLICATION_ATOM_XML)
    public List<User> list() {
        return users;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(@Valid User user){
        users.add(user);
        return Response.ok(users).build();
    }
}
