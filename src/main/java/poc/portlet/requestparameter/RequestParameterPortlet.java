package poc.portlet.requestparameter;

import javax.portlet.GenericPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class RequestParameterPortlet extends GenericPortlet {

	public void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		// Check if the loggedIn is null for initial state
		if (request.getParameter("loggedIn") == null) {
			response.getWriter()
					.println(
							"<form action="
									+ response.createActionURL()
									+ ">"
									+ "Enter Username : <input type='text' id='username' name='username'/>"
									+ "Enter Password : <input type='password' id='password' name='password'/>"
									+ "<input type='submit' value='Login'/>"
									+ "</form>");
		} else {
			// Get loggedIn value from the request parameter
			boolean loggedIn = Boolean.parseBoolean(request
					.getParameter("loggedIn"));
			if (loggedIn) {
				response.getWriter().println(
						"<form action=" + response.createActionURL() + ">"
								+ "<p>You're logged in</p>" + "</form>");
			} else {
				response.getWriter()
						.println(
								"<form action="
										+ response.createActionURL()
										+ ">"
										+ "<span style='color:red'>Try another</span><br/>"
										+ "Enter Username : <input type='text' id='username' name='username'/>"
										+ "Enter Password : <input type='password' id='password' name='password'/>"
										+ "<input type='submit' value='Login'/>"
										+ "</form>");
			}
		}
	}

	public void processAction(ActionRequest request, ActionResponse response)
			throws PortletException {
		// Fetch username and password from the request parameters of action
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Do some checking procedure
		if (username != null && username.equals("mohammedalics")
				&& password != null && password.equals("password")) {
			// Use render parameters to pass the result
			response.setRenderParameter("loggedIn", "true");
		} else {
			// Use render parameters to pass the result
			response.setRenderParameter("loggedIn", "false");
		}
	}
}
