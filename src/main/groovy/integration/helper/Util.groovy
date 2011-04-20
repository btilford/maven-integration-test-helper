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
class Util {


  static Binding createBinding(MavenProject project, Log log) {
    Binding binding = new Binding()

    binding.setVariable("log", log)
    binding.setVariable("properties", project.properties)
    binding.setVariable("profiles", project.activeProfiles)
    binding.setVariable("project",project)


    return binding
  }


  static GroovyScriptEngine createEngine(MavenProject project, Log log) {
    GroovyScriptEngine engine = null
    if (project == null) {
      log.error("No project!")
    } else {

      String[] args = [
          project?.build?.testOutputDirectory ?: "target/test-classes",
          project?.build?.outputDirectory ?: "target/classes"
      ]

      engine = new GroovyScriptEngine(args)
    }
    return engine
  }
}
