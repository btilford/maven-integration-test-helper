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
class PreIntegrationTestMojoTests extends AbstractMojoTestCase {


  void testPreIntegrationTest() {
    def pomPath = getClass().getResource("/testcasepom.xml")?.path
    assert pomPath
    def pom = new File(pomPath)
    assert pom.exists()

    def mojo = new PreIntegrationTestMojo()

//    def mojo = lookupMojo("pre-integration-test",pomPath)
//    def conf = extractPluginConfiguration("maven-integration-test-helper",pom)
//    def confMojo = configureMojo(mojo,conf)
    configureMojo(mojo, "maven-integration-test-helper", pom)
    mojo.project = new MavenProject()
    mojo.execute()




  }
}
