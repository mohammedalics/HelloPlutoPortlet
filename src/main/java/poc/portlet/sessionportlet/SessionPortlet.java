package poc.portlet.sessionportlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

public class SessionPortlet extends GenericPortlet{
	Logger logger = Logger.getLogger(SessionPortlet.class);
	 
    public void init(PortletConfig config) throws PortletException {
        super.init(config);
    }
 
    public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException{
        Enumeration<String> names = request.getPortletSession().getAttributeNames();
        StringBuffer buffer = new StringBuffer();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            buffer.append(name+" :: "+request.getPortletSession().getAttribute(name)+"\n");
        }
        response.getWriter().print("<form action="+response.createActionURL()+">"
                + "<p>Portlet Session Attributes</p>"
                + buffer
                + "<input type='submit' value='Just Do Action'/>"
                + "</form>");
    }
 
    public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException{

            request.getPortletSession().setAttribute("anonymousObject", "PortletSession Attribute");

    }
}
