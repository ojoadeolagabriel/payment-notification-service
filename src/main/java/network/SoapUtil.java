package network;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.io.IOException;


public class SoapUtil {

    //http://www.webserviceX.NET/GetQuote
    public final static String _serviceHost = "http://www.webserviceX.NET/";
    public final static String _serviceAction = "GetQuote";
    public final static String _serviceEndPoint = "stockquote.asmx";
    public final static String _stockSymbol = "IBM";

    /**
     * Call
     *
     * @param overrideStockQuote
     * @throws SOAPException
     */
    public static void call(String overrideStockQuote) throws SOAPException {

        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
        String selectedQuote = overrideStockQuote != null ? overrideStockQuote : _stockSymbol;

        try {
            SOAPMessage soapResponse = soapConnection.call(createSoapRequest(selectedQuote), _serviceHost + _serviceEndPoint);
            System.out.println("received response:");
            soapResponse.writeTo(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        soapConnection.close();
    }

    /**
     * Create new soap request
     *
     * @param selectedQuote
     * @return
     * @throws SOAPException
     * @throws IOException
     */
    private static SOAPMessage createSoapRequest(String selectedQuote) throws SOAPException, IOException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", _serviceHost + _serviceAction);
        headers.removeHeader("Accept");

        SOAPBody body = soapMessage.getSOAPBody();
        QName bodyname = new QName(_serviceHost, _serviceAction);
        SOAPBodyElement bodyElement = body.addBodyElement(bodyname);
        SOAPElement soapBodyArgument1 = bodyElement.addChildElement("symbol");
        soapBodyArgument1.addTextNode(selectedQuote);

        soapMessage.saveChanges();

        System.out.println(String.format("sending out soap-request: %s", "now"));
        soapMessage.writeTo(System.out);
        return soapMessage;
    }
}
