package com.mizore.sql.qmaker.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.mizore.sql.qmaker.query.JoinType;
import com.mizore.sql.qmaker.query.Query;

public class QueryParser extends DefaultHandler {
    private Query query;

    public QueryParser() {
    }

    // Event Handlers
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // reset
        if (qName.equalsIgnoreCase(XmlParserField.QUERY.name())) {
            query = new Query();
        } else if (qName.equalsIgnoreCase(XmlParserField.FIELD.name())) {
            query.select(attributes.getValue(XmlParserField.NAME.name().toLowerCase()));
        } else if (qName.equalsIgnoreCase(XmlParserField.TABLE.name())) {
            query.from(attributes.getValue(XmlParserField.NAME.name().toLowerCase()));
        } else if (qName.equalsIgnoreCase(XmlParserField.JOIN.name())) {
            query.join(JoinType.valueOf(attributes.getValue(XmlParserField.TYPE.name().toLowerCase()).toUpperCase()), attributes.getValue(XmlParserField.TABLE.name().toLowerCase())).on(attributes.getValue(XmlParserField.ON.name().toLowerCase()))
                    .equalsTo(attributes.getValue(XmlParserField.EQUALS.name().toLowerCase()));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    }

    public Query getQuery() {
        return query;
    }
}
