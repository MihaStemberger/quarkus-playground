package org.acme.user.feed;

import com.rometools.rome.feed.module.Module;
import org.jdom2.Namespace;

public interface UserModuleIf extends Module {

    public static final String URI = "http://example-uri.com";
    public static final String PREFIX = "ex";
    public static final Namespace NAMESPACE = Namespace.getNamespace(PREFIX, URI);

    String getName();

    void setName(String name);

    String getSurname();

    void setSurname(String surname);

}
