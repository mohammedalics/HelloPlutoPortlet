# HelloPlutoPortlet

references 
http://www.journaldev.com/4562/introduction-into-apache-pluto-ri-portal-portlet-container-example-tutorial#intro


Pluto adds to the simple portlet (ref. https://github.com/mohammedalics/HelloPortlet) 
- ContextDefinition.xml: name must be <artifact-id>.xml, location src/main/resources. as said, this is a Tomcat context deployment descriptor. This deployment descriptor will allow Pluto web application to access any required resources from your deployed Portlet application. 
- pom.xml file update to include maven-pluto-plugin in the build plugins. This plugin will read your portlet.xml and web.xml and injects required lines. 
- pom.xml file update to configure maven-war-plugin to use updated web.xml. 
- pom.xml file update to exclude portlet-api*.jar, as the jar already in pluto bundled tomcat. 
