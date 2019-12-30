package org.acme.UserFeed;

import com.sun.syndication.feed.module.Module;
import com.sun.syndication.io.ModuleGenerator;
import org.jdom.Element;
import org.jdom.Namespace;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UserModuleGenerator implements ModuleGenerator {

    private static final Namespace USER_NS = Namespace.getNamespace("user", UserModuleIf.URI);

    private static final Set NAMESPACES;

    static {
        Set nss = new HashSet();
        nss.add(USER_NS);
        NAMESPACES = Collections.unmodifiableSet(nss);
    }


    @Override
    public String getNamespaceUri() {
        return UserModuleIf.URI;
    }

    @Override
    public Set getNamespaces() {
        return NAMESPACES;
    }

    @Override
    public void generate(Module module, Element element) {
        UserModuleIf userModuleIf = (UserModuleIf) module;
        if (userModuleIf.getName() != null) {
            element.addContent(generateSimpleElement("name", userModuleIf.getName()));
        }
        if (userModuleIf.getSurname() != null) {
            element.addContent(generateSimpleElement("surname", userModuleIf.getSurname()));
        }
    }


    protected Element generateSimpleElement(String name, String value) {
        Element element = new Element(name, USER_NS);
        element.addContent(value);
        return element;
    }


}
