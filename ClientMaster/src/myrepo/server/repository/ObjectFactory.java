
package myrepo.server.repository;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the myrepo.server.repository package. 
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

    private final static QName _PairIn_QNAME = new QName("http://repository.server.myrepo/", "pairIn");
    private final static QName _PairOut_QNAME = new QName("http://repository.server.myrepo/", "pairOut");
    private final static QName _ReadPair_QNAME = new QName("http://repository.server.myrepo/", "readPair");
    private final static QName _PairOutResponse_QNAME = new QName("http://repository.server.myrepo/", "pairOutResponse");
    private final static QName _PairInResponse_QNAME = new QName("http://repository.server.myrepo/", "pairInResponse");
    private final static QName _ReadPairResponse_QNAME = new QName("http://repository.server.myrepo/", "readPairResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: myrepo.server.repository
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReadPairResponse }
     * 
     */
    public ReadPairResponse createReadPairResponse() {
        return new ReadPairResponse();
    }

    /**
     * Create an instance of {@link PairIn }
     * 
     */
    public PairIn createPairIn() {
        return new PairIn();
    }

    /**
     * Create an instance of {@link PairOut }
     * 
     */
    public PairOut createPairOut() {
        return new PairOut();
    }

    /**
     * Create an instance of {@link ReadPair }
     * 
     */
    public ReadPair createReadPair() {
        return new ReadPair();
    }

    /**
     * Create an instance of {@link PairInResponse }
     * 
     */
    public PairInResponse createPairInResponse() {
        return new PairInResponse();
    }

    /**
     * Create an instance of {@link PairOutResponse }
     * 
     */
    public PairOutResponse createPairOutResponse() {
        return new PairOutResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PairIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://repository.server.myrepo/", name = "pairIn")
    public JAXBElement<PairIn> createPairIn(PairIn value) {
        return new JAXBElement<PairIn>(_PairIn_QNAME, PairIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PairOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://repository.server.myrepo/", name = "pairOut")
    public JAXBElement<PairOut> createPairOut(PairOut value) {
        return new JAXBElement<PairOut>(_PairOut_QNAME, PairOut.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPair }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://repository.server.myrepo/", name = "readPair")
    public JAXBElement<ReadPair> createReadPair(ReadPair value) {
        return new JAXBElement<ReadPair>(_ReadPair_QNAME, ReadPair.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PairOutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://repository.server.myrepo/", name = "pairOutResponse")
    public JAXBElement<PairOutResponse> createPairOutResponse(PairOutResponse value) {
        return new JAXBElement<PairOutResponse>(_PairOutResponse_QNAME, PairOutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PairInResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://repository.server.myrepo/", name = "pairInResponse")
    public JAXBElement<PairInResponse> createPairInResponse(PairInResponse value) {
        return new JAXBElement<PairInResponse>(_PairInResponse_QNAME, PairInResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPairResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://repository.server.myrepo/", name = "readPairResponse")
    public JAXBElement<ReadPairResponse> createReadPairResponse(ReadPairResponse value) {
        return new JAXBElement<ReadPairResponse>(_ReadPairResponse_QNAME, ReadPairResponse.class, null, value);
    }

}
