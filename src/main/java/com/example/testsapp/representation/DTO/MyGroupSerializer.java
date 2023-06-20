package com.example.testsapp.representation.DTO;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class MyGroupSerializer extends JsonSerializer<GroupsDTO> {
    @Override
    public void serialize(GroupsDTO groupsDTO, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name", groupsDTO.getName());
        jsonGenerator.writeArrayFieldStart("usersDtos");
        for (UsersDto user : groupsDTO.getUsersDtos()){
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", user.getId());
            jsonGenerator.writeStringField("login", user.getLogin());
            jsonGenerator.writeStringField("password", user.getPassword());
            jsonGenerator.writeStringField("name", user.getName());
            jsonGenerator.writeStringField("second_name", user.getSecond_name());
            jsonGenerator.writeStringField("mail", user.getMail());
            jsonGenerator.writeStringField("status", String.valueOf(user.getStatus()));
            jsonGenerator.writeStringField("patronymic", user.getPatronymic());
            jsonGenerator.writeStringField("date_birth", String.valueOf(user.getDate_birth()));
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndArray();
    }
}
