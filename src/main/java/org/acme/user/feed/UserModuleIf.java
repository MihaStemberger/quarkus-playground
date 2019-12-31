package org.acme.user.feed;

import com.rometools.rome.feed.module.Module;
import org.jdom2.Namespace;

public interface UserModuleIf extends Module {

    String URI = "http://example-uri.com";
    String PREFIX = "ex";
    Namespace NAMESPACE = Namespace.getNamespace(PREFIX, URI);

    String getName();

    void setName(String name);

    String getSurname();

    void setSurname(String surname);

}
