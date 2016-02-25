## ServletWithOsgiConfig

ServletWithOsgiConfig is mainly meant for configuring properties for this bundle in admin web console and use that property inside the bundle as part of the response for the give Servlet Request. 

Open -> http://localhost:4502/services/unicom/v1.html in browser.

You will see the value entered in Admin Config Manager (/system/console/configMgr) for this bundle printed out in the browser.  

## Sample Servlet Annotations 

### Registering the servlet by path
@SlingServlet(
    paths={"/services/unicom/v1/"}
)

### Registering the servlet by resource type and extension
@SlingServlet(
    resourceTypes = {"rep:User"},
    methods = {"GET", "POST"}
)

### To handle all requests and filter on selector
@SlingServlet(
    resourceTypes = {"sling/servlet/default"},
    methods = {"GET"},
    selectors = {"report"},
    extensions = {"json"}
)

### To handle all requests for a Page with a special selector
http://www.fake.com/content/page.mycustomselector.html
@SlingServlet(
    resourceTypes = {"cq:Page"},
    methods = {"GET"},
    selectors = {"mycustomselector"}
)

### To handle all requests for a Page with a special extension.
http://www.fake.com/content/page.myfakeext
@SlingServlet(
    resourceTypes = {"cq:Page"},
    methods = {"GET"},
    extensions = {"myfakeext"}
)
