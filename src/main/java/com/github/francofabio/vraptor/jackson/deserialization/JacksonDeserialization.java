package com.github.francofabio.vraptor.jackson.deserialization;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import br.com.caelum.vraptor.deserialization.Deserializer;
import br.com.caelum.vraptor.deserialization.Deserializes;
import br.com.caelum.vraptor.http.ParameterNameProvider;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.view.ResultException;

@Deserializes({ "application/json", "json" })
public class JacksonDeserialization implements Deserializer {

    private final ParameterNameProvider paramNameProvider;
    
    public JacksonDeserialization(ParameterNameProvider paramNameProvider) {
        this.paramNameProvider = paramNameProvider;
    }
    
    @Override
    public Object[] deserialize(InputStream inputStream, ResourceMethod method) {
        Method jMethod = method.getMethod();
        Class<?>[] types = jMethod.getParameterTypes();
        if (types.length == 0) {
            throw new IllegalArgumentException("Methods that consumes representations must receive just one argument");
        }
        
        ObjectMapper mapper = getObjectMapper(); 
        Object[] params = new Object[types.length];
        String[] parameterNames = paramNameProvider.parameterNamesFor(jMethod);
        
        try {
            JsonNode root = mapper.readTree(inputStream);
            
            for (int i=0; i < types.length; i++) {
                String name = parameterNames[i];
                JsonNode node = root.get(name);
                if (node != null) {
                    params[i] = mapper.readValue(node, types[i]);
                }
            }
        } catch (Exception e) {
            throw new ResultException("Unable to deserialize data", e);
        }
        
        return params;
    }

    protected ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        mapper.configure(DeserializationConfig.Feature.READ_ENUMS_USING_TO_STRING, true);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        mapper.setDateFormat(sdf);
        
        return mapper;
    }

}
