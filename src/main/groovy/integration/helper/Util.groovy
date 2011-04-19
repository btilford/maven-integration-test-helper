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

  static void withURLStream(URL url, Closure closure) {
    InputStream istream = null
    try {
      if (url != null) {
        istream = url.openStream()
        closure(istream)
      }
    } finally {
      if (istream != null) {
        istream.close()
      }
    }
  }


  static Binding createBinding(MavenProject project, Log log) {
    Binding binding = new Binding()

    binding.setVariable("log", log)
    binding.setVariable("properties", project.properties)
    binding.setVariable("profiles", project.activeProfiles)

    return binding
  }


  static GroovyScriptEngine createEngine(MavenProject project) {
    String[] args = [
        project.properties.getProperty("build.testOutputDirectory") ?: "",
        project.properties.getProperty("build.outputDirectory") ?: ""
    ]

    def engine = new GroovyScriptEngine(args)
    return engine
  }
}
