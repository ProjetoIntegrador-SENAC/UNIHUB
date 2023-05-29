package br.com.projetopi.redesocial.util;

import br.com.projetopi.redesocial.model.Curso;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class ApiUtils {
    public static String ObjectToJsonString(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(object);
        return json;
    }
    public static Object StringJsonToObject(String json, Object object){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, object.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
