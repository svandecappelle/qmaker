package com.mizore.sql.qmaker.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.mizore.sql.qmaker.query.JoinType;
import com.mizore.sql.qmaker.query.Query;

public class QueryParser extends DefaultHandler {
    private String tempVal;
    private Query query;

    public QueryParser() {
    }

    // Event Handlers
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // reset
        tempVal = "";
        if (qName.equalsIgnoreCase("query")) {
            query = new Query();
        } else if (qName.equalsIgnoreCase("field")) {
            query.select(attributes.getValue("name"));
        } else if (qName.equalsIgnoreCase("table")) {
            query.from(attributes.getValue("name"));
        } else if (qName.equalsIgnoreCase("join")) {
            query.join(JoinType.valueOf(attributes.getValue("type").toUpperCase()), attributes.getValue("table")).on(attributes.getValue("on")).equalsTo(attributes.getValue("equals"));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    }

    public Query getQuery() {
        return query;
    }
}
