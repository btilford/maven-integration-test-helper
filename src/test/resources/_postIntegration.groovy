import integration.helper.SomethingOnMavensClasspath

/**
 * 
 * 
 * @author btilford
 * 
 * 
 */

log.info("Log was added")
log.info("properties:$properties")
log.info("profiles:$profiles")


def somethingFromClasspath = new SomethingOnMavensClasspath()
log.info(somethingFromClasspath.val)
new File("target").mkdirs()
new File("target/post.file").createNewFile()