package poc.portlet.titlechangedportlet;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class TitleChangedPortlet extends GenericPortlet {

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		response.getWriter().println("My Name Is:" + this.getPortletName());

	}

	@Override
	protected String getTitle(RenderRequest request) {
		// Check whether the name of the portlet is
		// programmaticTitleChangePortlet
		if (this.getPortletName().equals("ProgrammaticTitleChangePortlet")) {
			// If it's like that, just get the defined bundle
			ResourceBundle bundle = this.getPortletConfig().getResourceBundle(
					new Locale("en"));
			// Retrun the string that's corresponded for anyTitle property
			return (String) bundle.getObject("anyTitle");
		}
		// else return the default, either that's defined in the portlet.xml or
		// that's overrided in the bundle "javax.portlet.title"
		return super.getTitle(request);
	}
}
