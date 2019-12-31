package org.acme.util;


import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndEntryImpl;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedOutput;
import org.acme.user.User;
import org.acme.user.feed.UserModuleIf;
import org.acme.user.feed.UserModuleImpl;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

@Provider
@Produces(MediaType.APPLICATION_ATOM_XML)
public class AtomResponseWriter implements MessageBodyWriter<List<User>> {

    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    // All MessageBodyWriter implementations are advised to return -1 from the method.
    // Responsibility to compute the actual Content-Length header value has been delegated to JAX-RS runtime.
    @Override
    public long getSize(List<User> users, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(List<User> users, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws IOException, WebApplicationException {
        SyndFeed feed = new SyndFeedImpl();
        feed.setTitle("test-title");
        feed.setDescription("test-description");
        feed.setLink("https://example.org");
        feed.setFeedType("atom_1.0");

        for (User user : users) {
            SyndEntry entry = new SyndEntryImpl();
            UserModuleIf userModule = new UserModuleImpl();
            userModule.setName(user.getName());
            userModule.setSurname(user.getSurname());
            entry.getModules().add(userModule);
            feed.getEntries().add(entry);
        }
        try {
            outputStream.write(new SyndFeedOutput().outputString(feed).getBytes());
        } catch (FeedException e) {
            e.printStackTrace();
        }

    }
}