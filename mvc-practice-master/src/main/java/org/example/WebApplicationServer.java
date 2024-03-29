package org.example;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class WebApplicationServer {
    private static final Logger log = LoggerFactory.getLogger(WebApplicationServer.class);
    public static void main(String[] args) throws Exception{
        String webDirLocation = "webapp/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        tomcat.addWebapp("/", new File(webDirLocation).getAbsolutePath());
        log.info("configuring app with baseDir : {}", new File("./" + webDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}
