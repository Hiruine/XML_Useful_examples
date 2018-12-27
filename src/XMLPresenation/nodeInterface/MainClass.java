package XMLPresenation.nodeInterface;
/*
DOCTYPE node:
        <!ELEMENT address (buildingnumber,street,city,state,zip)>
        <!ATTLIST address xmlns CDATA #IMPLIED>
        <!ELEMENT buildingnumber (#PCDATA)>
        <!ELEMENT street (#PCDATA)>
        <!ELEMENT city (#PCDATA)>
        <!ELEMENT state (#PCDATA)>
        <!ELEMENT zip (#PCDATA)>


        Document body contents are:
        Node: address
        Node Type: Element
        Child Nodes of address are:
        Node: buildingnumber
        Node Type: Element
        Child Nodes of buildingnumber are:
        Node: #text
        Node Type: Text
        Content is:  29
        Node: street
        Node Type: Element
        Child Nodes of street are:
        Node: #text
        Node Type: Text
        Content is:  South Street
        Node: city
        Node Type: Element
        Child Nodes of city are:
        Node: #text
        Node Type: Text
        Content is: Vancouver
        Node: state
        Node Type: Element
        Child Nodes of state are:
        Node: #text
        Node Type: Text
        Content is: BC
        Node: zip
        Node Type: Element
        Child Nodes of zip are:
        Node: #text
        Node Type: Text
        Content is: V6V 4U7
        */


import static org.w3c.dom.Node.ATTRIBUTE_NODE;
import static org.w3c.dom.Node.CDATA_SECTION_NODE;
import static org.w3c.dom.Node.COMMENT_NODE;
import static org.w3c.dom.Node.DOCUMENT_TYPE_NODE;
import static org.w3c.dom.Node.ELEMENT_NODE;
import static org.w3c.dom.Node.ENTITY_NODE;
import static org.w3c.dom.Node.ENTITY_REFERENCE_NODE;
import static org.w3c.dom.Node.NOTATION_NODE;
import static org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE;
import static org.w3c.dom.Node.TEXT_NODE;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class MainClass {
    public static void main(String args[]) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        // DocumentBuilderFactory - that is a factory API that enables applications to obtain a parser that produces DOM object trees from XML documents.
        builderFactory.setNamespaceAware(true);       // Set namespace aware
        builderFactory.setValidating(true);           // and validating parser.html feaures
        builderFactory.setIgnoringElementContentWhitespace(true);

        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();  // Create the parser.html
        } catch(ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document xmlDoc = null;

        try {
            xmlDoc = builder.parse(new InputSource(new StringReader(xmlString)));

        } catch(SAXException e) {
            e.printStackTrace();

        } catch(IOException e) {
            e.printStackTrace();
        }
        DocumentType doctype = xmlDoc.getDoctype();
        if(doctype == null) {
            System.out.println("DOCTYPE is null");
        } else {
            System.out.println("DOCTYPE node:\n" + doctype.getInternalSubset());
        }

        System.out.println("\nDocument body contents are:");
        listNodes(xmlDoc.getDocumentElement(),"");         // Root element & children
    }
    static void listNodes(Node node, String indent) {
        String nodeName = node.getNodeName();
        System.out.println(indent+" Node: " + nodeName);
        short type = node.getNodeType();
        System.out.println(indent+" Node Type: " + nodeType(type));
        if(type == TEXT_NODE){
            System.out.println(indent+" Content is: "+((Text)node).getWholeText());
        }

        NodeList list = node.getChildNodes();
        if(list.getLength() > 0) {
            System.out.println(indent+" Child Nodes of "+nodeName+" are:");
            for(int i = 0 ; i<list.getLength() ; i++) {
                listNodes(list.item(i),indent+"  ");
            }
        }
    }

    static String nodeType(short type) {
        switch(type) {
            case ELEMENT_NODE:                return "Element";
            case DOCUMENT_TYPE_NODE:          return "Document type";
            case ENTITY_NODE:                 return "Entity";
            case ENTITY_REFERENCE_NODE:       return "Entity reference";
            case NOTATION_NODE:               return "Notation";
            case TEXT_NODE:                   return "Text";
            case COMMENT_NODE:                return "Comment";
            case CDATA_SECTION_NODE:          return "CDATA Section";
            case ATTRIBUTE_NODE:              return "Attribute";
            case PROCESSING_INSTRUCTION_NODE: return "Attribute";
        }
        return "Unidentified";
    }

    static String xmlString ="<?xml version=\"1.0\"?>" +
            "  <!DOCTYPE address" +
            "  [" +
            "     <!ELEMENT address (buildingnumber, street, city, state, zip)>" +
            "     <!ATTLIST address xmlns CDATA #IMPLIED>" +
            "     <!ELEMENT buildingnumber (#PCDATA)>" +
            "     <!ELEMENT street (#PCDATA)>" +
            "     <!ELEMENT city (#PCDATA)>" +
            "     <!ELEMENT state (#PCDATA)>" +
            "     <!ELEMENT zip (#PCDATA)>" +
            "  ]>" +
            "" +
            "  <address>" +
            "    <buildingnumber> 29 </buildingnumber>" +
            "    <street> South Street</street>" +
            "    <city>Vancouver</city>" +
            "" +
            "    <state>BC</state>" +
            "    <zip>V6V 4U7</zip>" +
            "  </address>";
}