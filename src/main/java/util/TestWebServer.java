package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.http.MimeTypes;
import org.mortbay.jetty.handler.*;
import org.mortbay.jetty.Server;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TestWebServer {

    public static void init() throws Exception {

        Server server = new Server(7039);

        ContextHandler context = new ContextHandler();
        context.setContextPath("/hello");
        context.setResourceBase(".");
        context.setClassLoader(Thread.currentThread().getContextClassLoader());
        server.setHandler(context);
        context.setHandler(new JsonServlet());

        server.start();
        server.join();
    }

    public static class AuthResponse {
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

    /**
     * JsonServlet
     */
    public static class JsonServlet extends AbstractHandler {

        @Override
        public void handle(String s, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, int i)
                throws IOException, ServletException {
            ObjectMapper mapper = new ObjectMapper();
            AuthResponse resp = new AuthResponse();
            resp.setResponseCode("90000");
            resp.setResponseMessage("Successful");
            String jsonMsg = mapper.writeValueAsString(resp);

            HttpServletResponse response = httpServletResponse;
            response.setContentType("application/json");
            response.getOutputStream().write(jsonMsg.getBytes(StandardCharsets.ISO_8859_1));
        }
    }

    /**
     * @param request
     * @return
     * @throws IOException
     */
    public String getBody(ServletRequest request) throws IOException {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        String data = buffer.toString();
        return data;
    }

    /**
     * PlainTextServlet
     */
    public class PlainTextServlet extends HttpServlet {

        byte[] msg = "Initiating!".getBytes(StandardCharsets.ISO_8859_1);

        public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
            String payload = getBody(servletRequest);
            if (payload != null && !payload.isEmpty()) {
                System.out.println(payload);
            }

            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setContentType(MimeTypes.Type.TEXT_PLAIN.asString());

            response.setHeader("ProtocolCategory", "1");
            response.setHeader("Claim-Reward", "SmsOnly");
            response.getOutputStream().write(msg);
        }
    }

}
