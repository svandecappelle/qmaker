package com.mizore.sql.qmaker.parser;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class QueryXmlParser {

    public QueryXmlParser() {
    }

    private void parseDocument() {

        // get a factory
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {

            // get a new instance of parser
            SAXParser sp = spf.newSAXParser();

            // parse the file and also register this class for call backs
            QueryParser parser = new QueryParser();
            sp.parse("/home/svandecappelle/sheets.xml", parser);

            System.out.println(parser.getQuery());
            
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(String[] args) {
        QueryXmlParser parser = new QueryXmlParser();
        parser.parseDocument();
    }

}
