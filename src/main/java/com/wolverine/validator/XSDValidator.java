package com.wolverine.validator;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XSDValidator {
	private final String schema_path="src/main/resources/Wolverine.xsd";
	public boolean validate(File file)
	{
		try {
            SchemaFactory factory = 
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(schema_path));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(file));
        } catch (IOException e) {
            new Throwable(e);
            return false;
        } catch (SAXException e) {
            new Throwable(e);
            return false;
		}
        return true;
    }
	}


