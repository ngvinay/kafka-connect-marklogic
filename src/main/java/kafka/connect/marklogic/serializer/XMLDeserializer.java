package kafka.connect.marklogic.serializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.kafka.common.serialization.Deserializer;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * 
 * @author Sanju Thomas
 *
 */
public class XMLDeserializer implements Deserializer<Document> {

	@Override
	public void configure(final Map<String, ?> configs, final boolean isKey) {}

	@Override
	public Document deserialize(final String topic, final byte[] data) {

		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			return builder.parse(new ByteArrayInputStream(data));
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new RuntimeException("Failed to convert data to XML", e);
		}
	}

	@Override
	public void close() {}

}
