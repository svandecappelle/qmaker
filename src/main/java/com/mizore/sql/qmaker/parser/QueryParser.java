package com.mizore.sql.qmaker.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.mizore.sql.qmaker.query.Field;
import com.mizore.sql.qmaker.query.JoinType;
import com.mizore.sql.qmaker.query.Query;

/**
 * @author svandecappelle
 *
 * @since 0.0.1
 *
 *        An XML query parser. Giving the file the parser returns the query
 *        found in file. (see documentation for xml file exemple)
 */
public class QueryParser extends DefaultHandler {
    private Query query;

    /**
     * Create a new parser xml.
     */
    public QueryParser() {
    }

    // Event Handlers
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // reset
        if (qName.equalsIgnoreCase(XmlParserField.QUERY.name())) {
            query = new Query();
        } else if (qName.equalsIgnoreCase(XmlParserField.FIELD.name())) {
            Field field = query.select(attributes.getValue(XmlParserField.NAME.name().toLowerCase()));
            if (attributes.getValue(XmlParserField.AS.name().toLowerCase()) != null) {
                field.as(attributes.getValue(XmlParserField.AS.name().toLowerCase()));
            }
        } else if (qName.equalsIgnoreCase(XmlParserField.TABLE.name())) {
            query.from(attributes.getValue(XmlParserField.NAME.name().toLowerCase()));
        } else if (qName.equalsIgnoreCase(XmlParserField.JOIN.name())) {
            query.join(JoinType.valueOf(attributes.getValue(XmlParserField.TYPE.name().toLowerCase()).toUpperCase()), attributes.getValue(XmlParserField.TABLE.name().toLowerCase())).on(attributes.getValue(XmlParserField.ON.name().toLowerCase()))
                    .equalsTo(attributes.getValue(XmlParserField.EQUALS.name().toLowerCase()));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Nothing to do here because of dynamic insert into query.
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Nothing to do at now
        // Could be useful to parse multiples query. If yes.. do that feature
        // here.
    }

    /**
     * Get the last query parsed.
     * 
     * @return last query pared.
     */
    public Query getQuery() {
        return query;
    }
}
