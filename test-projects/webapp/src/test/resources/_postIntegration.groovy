import org.mortbay.jetty.Server
import org.mortbay.jetty.nio.SelectChannelConnector
import org.mortbay.jetty.webapp.WebAppContext

log.info("[STARTING] POST INTEGRATION TEST TEARDOWN")

def server = project.getContextValue("server")


assert server && server instanceof Server
log.info("Found jetty server")


if(server.stopped) {
  log.info("Jetty was not running")
}

if(server.started) {
  log.info("Jetty is running preparing to shutdown")
//  server.stop()
  while(server.stopping) {
    Thread.sleep(30)
  }
  log.info("Stopped Jetty")
}

log.info("[FINISHED] POST INTEGRATION TEST TEARDOWN")
