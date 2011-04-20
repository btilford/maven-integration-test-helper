import org.mortbay.jetty.Server
import org.mortbay.jetty.nio.SelectChannelConnector
import org.mortbay.jetty.webapp.WebAppContext

log.info("[STARTING] PRE INTEGRATION TEST SETUP")
log.info("properties: $properties")
log.info("baseDirectory: ${project.basedir}")

Server server = new Server()
SelectChannelConnector http = new SelectChannelConnector()
http.port = 8989

server.addConnector(http)

WebAppContext ctx = new WebAppContext()

ctx.classLoader = Thread.currentThread().contextClassLoader
ctx.contextPath = "/"
ctx.descriptor = "${project.basedir}/src/main/webapp/WEB-INF/web.xml"
ctx.resourceBase = "${project.basedir}/src/main/webapp"

project.setContextValue("server",server)

server.start()

log.info("[FINISHED] PRE INTEGRATION TEST SETUP")
