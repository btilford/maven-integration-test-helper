maven-integration-test-helper
========


Allows running a groovy script during `pre-integration-test` and `post-integration-test`.

Example plugin config
---

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
      <dependencies>
        <!-- dependencies needed to run jetty -->
        <dependencies>
          <dependency>
            <groupId>org.mortbay.jetty</groupId>
            <artifactId>jetty</artifactId>
            <version>6.1.26</version>
          </dependency>
          <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>servlet-api</artifactId>
            <version>2.5</version>
          </dependency>
          <dependency>
            <groupId>org.mortbay.jetty</groupId>
            <artifactId>jsp-api-2.1</artifactId>
            <version>6.1.14</version>
          </dependency>
          <dependency>
            <groupId>org.mortbay.jetty</groupId>
            <artifactId>jsp-2.1</artifactId>
            <version>6.1.14</version>
          </dependency>
        </dependencies>
      </dependencies>
    </plugin>

Then create a groovy script called **_preIntegration.groovy** and **_postIntegration.groovy**
that will be copied to the root classpath of your testing classpath. e.g.
`src/test/resources/_preIntegration.groovy`.

You will most likely want to add dependencies used in your **pre/post**  scrips to the plugin




Injected variables:
-----

*     The `MavenProject` will be available as **project**
*     The maven logger will be available as **log**
*     The active profiles will be available as **profiles**
*     Maven properties will be available as **properties**
*     The script's classpath will be relative to where your build places it. And will
      have access to that location's classpath. (most likely your test classpath + compile classpath)
