package org.acme.UserFeed;


import com.sun.syndication.feed.module.Module;
import com.sun.syndication.io.ModuleParser;
import org.jdom.Element;
import org.jdom.Namespace;

public class UserModuleParser implements ModuleParser {

    private static final Namespace USER_NS = Namespace.getNamespace("user", UserModuleIf.URI);

    @Override
    public String getNamespaceUri() {
        return UserModuleIf.URI;
    }

    @Override
    public Module parse(Element element) {
        boolean foundSomething = false;
        UserModuleIf userModuleIf = new UserModuleImpl();

        Element e = element.getChild("name", USER_NS);
        if (e != null) {
            foundSomething = true;
            userModuleIf.setName(e.getText());
        }

        e = element.getChild("surname", USER_NS);
        if (e != null) {
            foundSomething = true;
            userModuleIf.setSurname(e.getText());
        }

        return foundSomething ? userModuleIf : null;
    }


}
