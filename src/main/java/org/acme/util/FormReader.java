package org.acme.util;

import org.acme.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class FormReader implements MessageBodyReader<User> {
    @Override
    public boolean isReadable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return (type == User.class);
    }

    @Override
    public User readFrom(Class<User> aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> multivaluedMap, InputStream inputStream) throws IOException, WebApplicationException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        return new User("just a new user", "new");
    }

}
