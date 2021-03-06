package com.mizore.sql.qmaker.parser;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        XML parser for Query.
 */
public class QueryXmlParser {

    private static final Logger LOGGER = Logger.getLogger("QueryXmlParser");
    private String fileLocation;

    /**
     * Create a new parser.
     * 
     * @param fileLocation
     *            the location file.
     */
    public QueryXmlParser(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    /**
     * Parse xml document.
     * 
     * @return the query parser after file is parsed.
     */
    public QueryParser parseDocument() {

        // get a factory
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {

            // get a new instance of parser
            SAXParser sp = spf.newSAXParser();

            // parse the file and also register this class for call backs
            QueryParser parser = new QueryParser();
            sp.parse(fileLocation, parser);
            return parser;

        } catch (SAXException se) {
            LOGGER.log(Level.SEVERE, "SAXException parsing query file", se);
        } catch (ParserConfigurationException pce) {
            LOGGER.log(Level.SEVERE, "ParserConfigurationException parsing query file", pce);
        } catch (IOException ie) {
            LOGGER.log(Level.SEVERE, "IOException parsing query file", ie);
        }
        return null;
    }
}
