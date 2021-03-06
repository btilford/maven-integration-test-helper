package integration.helper;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;

import java.util.List;


/**
 *
 *
 * @author btilford
 *
 * @goal pre-integration-test
 * @requiresProject
 */
public class PreIntegrationTestMojo extends AbstractMojo {

  /**
   * @parameter default-value="${project}"
   * @required
   * @readonly
   */
  private MavenProject project;


  /**
   * @component
   * @required
   * @readonly
   */
  private MavenProjectHelper projectHelper;


  /**
   * @parameter default-value="${project.compileSourceRoots}"
   * @required
   * @readonly
   */
  private List sourceRoots;


  @Override public void execute() {
    ScriptRunner.execute("_preIntegration.groovy",project,getLog());

  }


}
