package lt.bta.java2.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("Context attributeAdded " + event.getName() + "=" + event.getValue() + " in " + event.getServletContext().getServletContextName());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("Context attributeRemoved " + event.getName() + "=" + event.getValue() + " in " + event.getServletContext().getServletContextName());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("Context attributeReplaced " + event.getName() + "=" + event.getValue() + " in " + event.getServletContext().getServletContextName());
    }
}
