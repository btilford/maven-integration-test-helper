package integration.helper

import org.apache.maven.plugin.logging.Log
import org.apache.maven.project.MavenProject

/**
 *
 *
 * @author btilford
 *
 *
 */
class ScriptRunner {


  static void execute(String script, MavenProject project, Log log) {
    URL preIntegrationScript = getClass().getResource("/$script")
    Util.withURLStream(preIntegrationScript) {

      Binding binding = Util.createBinding(project, log)
      def engine = Util.createEngine(project)
      engine.run(preIntegrationScript.toString(), binding)
    }
  }
}
