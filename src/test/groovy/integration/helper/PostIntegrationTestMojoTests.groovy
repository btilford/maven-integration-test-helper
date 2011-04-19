package integration.helper

import org.apache.maven.plugin.testing.AbstractMojoTestCase
import org.apache.maven.project.MavenProject

/**
 * 
 * 
 * @author btilford
 * 
 * 
 */
class PostIntegrationTestMojoTests extends AbstractMojoTestCase {


  void testPreIntegrationTest() {
    def pomPath = getClass().getResource("/testcasepom.xml")?.path
    assert pomPath
    def pom = new File(pomPath)
    assert pom.exists()

    def mojo = new PostIntegrationTestMojo()
    configureMojo(mojo, "maven-integration-test-helper", pom)
    mojo.project = new MavenProject()
    mojo.execute()




  }
}
