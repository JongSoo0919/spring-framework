package org.example;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws Exception{
        String webappDirection = "webapps/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        tomcat.addWebapp("/", new File(webappDirection).getAbsolutePath());
        log.info("configuration app with baseDir : {}", new File("./", webappDirection).getAbsolutePath());
        tomcat.start();
        tomcat.getServer().await();
    }
}