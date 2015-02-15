package poc.portlet.portletcontext;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class HelloContextPortlet extends GenericPortlet {

	@Override
	public void init(PortletConfig config) throws PortletException {
		super.init(config);
		  config.getPortletContext().setAttribute("anonymousVariable", "Just Variable");
	}
	
	
	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
        response.getWriter().print("<p>Hello Context Portlet</p>");		
	}
}
