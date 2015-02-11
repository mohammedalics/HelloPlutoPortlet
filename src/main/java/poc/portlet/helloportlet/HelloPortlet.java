package poc.portlet.helloportlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Hello world!
 *
 */
public class HelloPortlet extends GenericPortlet {

	private static int renderCount = 0;
	private static int actionCount = 0;

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		synchronized (this) {
			renderCount++;
		}

		response.getWriter().print(
				"<form action=" + response.createActionURL() + ">"
						+ "<p>Render has executed " + renderCount + " times</p>"
						+ "<p>Action has executed " + actionCount + "times</p>"
						+ "<input type='submit'/>" + "</form>");		

	}

	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		synchronized (this) {
			actionCount++;
		}
	}

}
