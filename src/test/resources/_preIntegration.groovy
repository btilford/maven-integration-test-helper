
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

new File("target").mkdirs()
new File("target/pre.file").createNewFile()