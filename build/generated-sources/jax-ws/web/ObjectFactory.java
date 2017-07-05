
package web;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the web package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DisplayResponse_QNAME = new QName("http://Web/", "displayResponse");
    private final static QName _Display_QNAME = new QName("http://Web/", "display");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: web
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Display }
     * 
     */
    public Display createDisplay() {
        return new Display();
    }

    /**
     * Create an instance of {@link DisplayResponse }
     * 
     */
    public DisplayResponse createDisplayResponse() {
        return new DisplayResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Web/", name = "displayResponse")
    public JAXBElement<DisplayResponse> createDisplayResponse(DisplayResponse value) {
        return new JAXBElement<DisplayResponse>(_DisplayResponse_QNAME, DisplayResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Display }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Web/", name = "display")
    public JAXBElement<Display> createDisplay(Display value) {
        return new JAXBElement<Display>(_Display_QNAME, Display.class, null, value);
    }

}
