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
    String path = project?.build?.testOutputDirectory ?: ""
    path += "/$script"
    File scriptFile = new File(path)
    if(!scriptFile.exists()) {
      log.warn("Missing script [$path] (ignoring)")
    } else {
      Binding binding = Util.createBinding(project, log)
      GroovyScriptEngine engine = Util.createEngine(project,log)
      if(engine == null) {
        log.error("Unable to start script engine!")
      } else {
        log.info("Running $script")
        engine.run(path, binding)
      }
    }
  }
}
