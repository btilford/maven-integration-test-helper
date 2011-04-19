maven-integration-test-helper
========


Allows running a groovy script during `pre-integration-test` and `post-integration-test`.

To use configure the plugin executions.

    <plugin>
      <groupId>maven-integration-test-helper</groupId>
      <artifactId>maven-integration-test-helper</artifactId>
      <version>1.0-SNAPSHOT</version>
      <configuration/>
      <executions>
        <execution>
          <id>pre</id>
          <phase>pre-integration-test</phase>
          <goals>
            <goal>pre-integration-test</goal>
          </goals>
        </execution>
        <execution>
          <id>post</id>
          <phase>post-integration-test</phase>
          <goals>
            <goal>post-integration-test</goal>
          </goals>
        </execution>

      </executions>
    </plugin>

Then create a groovy script called **_preIntegration.groovy** and **_postIntegration.groovy**
that will be copied to the root classpath of your testing classpath. e.g.
`src/test/resources/_preIntegration.groovy`.


Provided variables:

*     The maven logger will be available as **log**
*     The active profiles will be available as **profiles**
*     Maven properties will be available as **properties**
*     The script's classpath will be relative to where your build places it. And will
      have access to that location's classpath. (most likely your test classpath + compile classpath)
