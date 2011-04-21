import org.mortbay.jetty.Server
import org.mortbay.jetty.webapp.WebAppContext

log.info("[STARTING] PRE INTEGRATION TEST SETUP")


Server server = new Server(8989)

server.handler = new WebAppContext("${project.basedir}/src/main/webapp", "/")

try {
  project.setContextValue("server", server)
} catch (ex) {
  log.error("Maven 2 not supported")
}


try {
  server.start()
} catch (ex) {
  log.error(ex.message)
}


log.info("[FINISHED] PRE INTEGRATION TEST SETUP")

