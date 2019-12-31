package org.acme.user.feed;


import com.rometools.rome.feed.module.Module;
import com.rometools.rome.io.ModuleGenerator;
import org.jdom2.Element;
import org.jdom2.Namespace;

import java.util.HashSet;
import java.util.Set;

public class UserModuleGenerator implements ModuleGenerator {

    @Override
    public String getNamespaceUri() {
        return UserModuleIf.NAMESPACE.getURI();
    }

    @Override
    public Set<Namespace> getNamespaces() {
        Set<Namespace> result = new HashSet<>();
        result.add(UserModuleIf.NAMESPACE);
        return result;
    }

    @Override
    public void generate(Module module, Element element) {
        UserModuleIf userModuleIf = (UserModuleIf) module;
        if (userModuleIf.getName() != null) {
            element.addContent(generateSimpleElement(UserTags.NAME.name(), userModuleIf.getName()));
        }
        if (userModuleIf.getSurname() != null) {
            element.addContent(generateSimpleElement(UserTags.SOMETHING_ELSE.name(), userModuleIf.getSurname()));
        }
    }

    protected Element generateSimpleElement(String name, String value) {
        Element element = new Element(name, UserModuleIf.NAMESPACE);
        element.addContent(value);
        return element;
    }


}
