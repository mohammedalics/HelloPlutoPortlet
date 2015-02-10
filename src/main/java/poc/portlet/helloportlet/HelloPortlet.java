package poc.portlet.helloportlet;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Hello world!
 *
 */
public class HelloPortlet extends GenericPortlet {

	@Override
	
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		// TODO Auto-generated method stub
//		super.doView(request, response);
		response.setContentType("text/html");
		String user = request.getRemoteUser(); 
		if (user != null) {
			response.getWriter().println("Welcome " + user + "!");

		} else {
			response.getWriter().println("Log in to welcome you ;)");

		}
	}

}
