package action;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import figures.Node;
import figures.Way;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class OsmParser {

    private Map<Long, Node> nodes = new HashMap<Long, Node>();
    private Map<Long,Way> ways = new HashMap<>();
    private Way actual = null;

    class OsmHandler extends DefaultHandler {


        @Override
        public void startElement(String namespaceURI, String localName,
                                 String qName, Attributes atts) {
            if (qName.equalsIgnoreCase("node")) {
                long id = Long.valueOf(atts.getValue("id"));
                double lat = Double.valueOf(atts.getValue("lat"));
                double lon = Double.valueOf(atts.getValue("lon"));
                nodes.put(id, new Node(id, lat, lon));
            }
            else if (qName.equalsIgnoreCase("way")) {
                if(actual==null)
                    actual = new Way(Long.valueOf(atts.getValue("id")));
            }
            else if (qName.equalsIgnoreCase("nd")){
                actual.addNodes(nodes.get(Long.valueOf(atts.getValue("ref"))));
            }
            else if (qName.equalsIgnoreCase("tag") && actual!= null) {
                if (atts.getValue("k").equalsIgnoreCase("highway")) {
                    actual.setHighway(atts.getValue("v"));
                } else if (atts.getValue("k").equalsIgnoreCase("name")) {
                    actual.setName(atts.getValue("v"));
                } else if (atts.getValue("k").equalsIgnoreCase("maxspeed")) {
                    actual.setMaxSpeed(Integer.valueOf(atts.getValue("v")));
                }
            }
        }
        @Override
        public void endElement(String namespaceURI, String localName,
                               String qName) throws SAXException{
            if (qName.equalsIgnoreCase("way")) {
                ways.put(actual.getId(),actual);
                actual = null;
            }
        }
    }

        public void parsingOsmFile() {
            try {
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser saxParser = factory.newSAXParser();
                DefaultHandler handler = new OsmHandler();
                //File directory = new File("./");
                //System.out.println(directory.getAbsolutePath());
                saxParser.parse(new File("fhws.osm"), handler);
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        public Map<Long,Way> getWays(){
            return this.ways;
        }
        public Map<Long,Node> getNodes(){
            return this.nodes;
        }

}

