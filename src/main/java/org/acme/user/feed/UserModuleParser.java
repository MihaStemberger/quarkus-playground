package org.acme.user.feed;

import com.rometools.rome.feed.module.Module;
import com.rometools.rome.io.ModuleParser;
import org.jdom2.Element;
import org.jdom2.Namespace;

import java.util.Locale;

public class UserModuleParser implements ModuleParser {


    @Override
    public String getNamespaceUri() {
        return "http://test.miha.si";
    }

    @Override
    public Module parse(Element element, Locale locale) {
        boolean foundSomething = false;
        UserModuleIf userModuleIf = new UserModuleImpl();

        Element e = element.getChild("name", Namespace.getNamespace("test", getNamespaceUri()));
        if (e != null) {
            foundSomething = true;
            userModuleIf.setName(e.getText());
        }

        e = element.getChild("surname", Namespace.getNamespace("test", getNamespaceUri()));
        if (e != null) {
            foundSomething = true;
            userModuleIf.setSurname(e.getText());
        }

        return foundSomething ? userModuleIf : null;
    }
}
