
package poc.portlet.accessresources; 

import java.io.IOException;
import java.io.InputStream;
import org.apache.log4j.Logger;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class AccessResourcesPortlet extends GenericPortlet{

    Logger logger = Logger.getLogger(AccessResourcesPortlet.class);
    
	 public void init(PortletConfig config) throws PortletException {
	        super.init(config);
	    }
	 
	    public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException{
	        System.out.println("Got File :: "+this.getPortletContext().getResource("/index.jsp"));
	        System.out.println("Got File :: "+this.getPortletContext().getRealPath("file:///c:/index.jsp"));
	        
	        this.getPortletContext().log("Got File :: "+this.getPortletContext().getResource("/index.jsp"));
	        this.getPortletContext().log("Got File :: "+this.getPortletContext().getRealPath("file:///c:/index.jsp"));
	        
	        logger.debug("Got File :: "+this.getPortletContext().getResource("/index.jsp"));
	        logger.debug("Got File :: "+this.getPortletContext().getRealPath("file:///c:/index.jsp"));
	        
	        
	        InputStream input = this.getPortletContext().getResourceAsStream("/index.jsp");
	        byte [] bytes = new byte[input.available()];
	        input.read(bytes, 0, input.available());
	        response.getPortletOutputStream().write(bytes);
	    }
	    
}
