package me.whiteship;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Application {

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context context = tomcat.addContext("/", "/");

        //servlet - 클라이언트의 요청을 처리하고, 그 결과를 반환하는 클래스의 구현 규칙을 지킨 자바 웹 프로그래밍 기술
        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                PrintWriter writer = resp.getWriter();
                writer.println("<html><head><title>");
                writer.println("Hey, Tomcat");
                writer.println("</title></head>");
                writer.println("<body><h1>hello Tomcat</h1></body>");
                writer.println("</html>");
            }
        };

        String servletName = "helloServlet";
        tomcat.addServlet("/",servletName, servlet);
        context.addServletMappingDecoded("/hello",servletName); // go 요청이 오면 해당 servletName을 보여주겠다.

        tomcat.start();
        tomcat.getServer().await();
    }

}
