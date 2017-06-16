package kafka.connect.marklogic.serializer;

import java.nio.charset.Charset;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;
import org.w3c.dom.Document;

/**
 * 
 * @author Sanju Thomas
 *
 */
public class XMLSerializer implements Serializer<Document>{
	
	@Override
	public void configure(final Map<String, ?> configs, final boolean isKey) {}

	@Override
	public void close() {}

	@Override
	public byte[] serialize(final String topic, final Document data) {
		
		return data.getTextContent().getBytes(Charset.defaultCharset());
	}

}
