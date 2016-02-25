package org.nikhil.SampleCode.core.json;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.jcr.JsonItemWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sample servlet which easily converts a Node as JSON to the PrintWriter.
 */
@SlingServlet(
		//paths={"/aem/services/unicom/v1"},
		resourceTypes = {"sling/servlet/default"},
	    selectors={"nikhil"}, 
	    extensions = {"json"}, 
	    metatype	= true
	)
public class ConvertResourceToJSONServlet extends SlingSafeMethodsServlet {

    /** The logger */ 
    private static final Logger logger = LoggerFactory.getLogger(ConvertResourceToJSONServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json"); 

        final PrintWriter out = response.getWriter();
        final ResourceResolver resolver = request.getResourceResolver();
        final Resource resource = resolver.getResource("/content/samplecode/en");
        //final Resource resource = request.getResource();
        final Node node = resource.adaptTo(Node.class);

        /* Node properties to exclude from the JSON object. */
        final Set<String> propertiesToIgnore = new HashSet<String>() {{
            add("jcr:created");
            add("jcr:createdBy");
            add("jcr:versionHistory");
            add("jcr:predecessors");
            add("jcr:baseVersion");
            add("jcr:uuid");
            add("jcr:primaryType");
            add("sling:resourceType");
        }};

        JsonItemWriter jsonWriter = new JsonItemWriter(propertiesToIgnore);

        try {
            /* Write the JSON to the PrintWriter with max recursion of 1 level and tidy formatting. */
            jsonWriter.dump(node, out, -1, true);
            response.setStatus(SlingHttpServletResponse.SC_OK);
        } catch (RepositoryException e) {
            logger.error("Could not get JSON", e);
            response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (JSONException e) {
        	 logger.error("Could not get JSON", e);
             response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
