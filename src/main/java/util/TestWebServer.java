package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created by Adeola.Ojo on 7/19/2016.
 */
public class TestWebServer {

    public static void init() throws Exception {

        Server server = new Server(7056);
        ServerConnector serverConnector = server.getBean(ServerConnector.class);
        HttpConfiguration configuration = serverConnector.getBean(HttpConnectionFactory.class).getHttpConfiguration();
        configuration.setSendDateHeader(true);
        configuration.setSendServerVersion(true);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SECURITY | ServletContextHandler.NO_SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(DefaultServlet.class, "/");
        context.addServlet(JsonServlet.class, "/json");
        context.addServlet(PlainTextServlet.class, "/plain");

        server.start();
        server.join();
    }

    public class AuthResponse {
        private String responseCode;

        public String getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(String responseCode) {
            this.responseCode = responseCode;
        }

        public String getResponseMessage() {
            return responseMessage;
        }

        public void setResponseMessage(String responseMessage) {
            this.responseMessage = responseMessage;
        }

        private String responseMessage;
    }

    public class JsonServlet extends HttpServlet {

        public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

            ObjectMapper mapper = new ObjectMapper();
            AuthResponse resp = new AuthResponse();
            resp.setResponseCode("90000");
            resp.setResponseMessage("Successful");
            String jsonMsg = mapper.writeValueAsString(resp);

            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setContentType("application/json");
            response.getOutputStream().write(jsonMsg.getBytes(StandardCharsets.ISO_8859_1));
        }
    }

    public class PlainTextServlet extends HttpServlet {

        byte[] msg = "Hello, World!".getBytes(StandardCharsets.ISO_8859_1);

        public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setContentType(MimeTypes.Type.TEXT_PLAIN.asString());

            response.setHeader("Claim", "1");
            response.getOutputStream().write(msg);
        }
    }

}
