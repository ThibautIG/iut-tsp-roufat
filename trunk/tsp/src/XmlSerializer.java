import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;

public class XmlSerializer {
	/*
	 * configure the xml serializer
	 */
	private static XStream xStream = new XStream();
	static {
		
//		xStream.alias("match",MatchingInstance.class);
//		xStream.alias("scenario",Scenario.class);
//		xStream.alias("KB", KnowledgeBase.class);
//
//		xStream.omitField(ElementVertex.class, "id");
//		xStream.omitField(ElementVertex.class, "schema");
	}

	public synchronized static void save(Object o,String absolutePath)
	throws IOException {
		BufferedWriter writer = new BufferedWriter(new
				FileWriter(absolutePath,false));
		xStream.toXML(o, writer);
	}

	public synchronized static Object load(String absolutePath) throws
	FileNotFoundException {
		BufferedReader reader = new BufferedReader(new
				FileReader(absolutePath));
		return xStream.fromXML(reader);
	}
}