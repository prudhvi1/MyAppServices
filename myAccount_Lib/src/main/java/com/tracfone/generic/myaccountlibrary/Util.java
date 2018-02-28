package com.tracfone.generic.myaccountlibrary;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

/**
 * Util class for non specific helper methods or tools.
 */
public class Util{

    private static ObjectMapper m = new ObjectMapper();
    private static JsonFactory jf = new JsonFactory();

    public static <T> Object fromJson(String reponse, Class<T> pojo)
            throws JsonParseException, JsonMappingException, IOException {
        return m.readValue(reponse, pojo);
    }

    public static String toJson(Object pojo) throws JsonGenerationException,
            JsonMappingException, IOException {
        StringWriter writer = new StringWriter();
        JsonGenerator jg = jf.createGenerator(writer);
        m.writeValue(jg, pojo);
        return writer.toString();
    }

    public static String streamToString(InputStream is) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        is.close();
        return stringBuilder.toString();
    }
}
