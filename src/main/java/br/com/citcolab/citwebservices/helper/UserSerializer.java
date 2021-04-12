package br.com.citcolab.citwebservices.helper;

import br.com.citcolab.citwebservices.model.entity.UserEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class UserSerializer extends StdSerializer<UserEntity> {

    public UserSerializer(){
        this(null);
    }

    public UserSerializer(Class<UserEntity> t) {
        super(t);
    }

    @Override
    public void serialize(UserEntity userEntity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", userEntity.getId());
        jsonGenerator.writeNumberField("employerId", userEntity.getEmployerId());
        jsonGenerator.writeStringField("cpf", userEntity.getCpf());
        jsonGenerator.writeStringField("user_name", userEntity.getUser_name());
        jsonGenerator.writeObjectField("gender", userEntity.getGender());
        jsonGenerator.writeStringField("email", userEntity.getEmail());
        jsonGenerator.writeStringField("user_password", userEntity.getUser_password());
        jsonGenerator.writeStringField("occupation", userEntity.getOccupation());
        jsonGenerator.writeStringField("local_office", userEntity.getLocal_office());
        jsonGenerator.writeObjectField("sector", userEntity.getSector());
        jsonGenerator.writeObjectField("access_level", userEntity.getAccess_level());
        jsonGenerator.writeStringField("photo_profile_url", userEntity.getPhoto_profile_url());
        jsonGenerator.writeEndObject();
    }
}
