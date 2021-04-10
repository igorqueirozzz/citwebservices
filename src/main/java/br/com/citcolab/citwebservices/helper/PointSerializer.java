package br.com.citcolab.citwebservices.helper;

import br.com.citcolab.citwebservices.model.entity.PointRegister;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class PointSerializer extends StdSerializer<PointRegister> {

    public PointSerializer(){
        this(null);
    }

    public PointSerializer(Class<PointRegister> t) {
        super(t);
    }

    @Override
    public void serialize(PointRegister pointRegister, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", pointRegister.getId());
        jsonGenerator.writeStringField("register_local", pointRegister.getRegister_local());
        jsonGenerator.writeStringField("reference", pointRegister.getReference());
        jsonGenerator.writeObjectField("register_date", pointRegister.getRegister_date());
        jsonGenerator.writeObjectField("register_time", pointRegister.getRegister_time());
        jsonGenerator.writeNumberField("user_id", pointRegister.getUser_id().getId());
        jsonGenerator.writeEndObject();
    }
}
