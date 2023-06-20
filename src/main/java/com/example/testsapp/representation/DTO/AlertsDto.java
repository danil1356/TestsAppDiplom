package com.example.testsapp.representation.DTO;

import com.example.testsapp.data.Entity.Alerts;
import com.example.testsapp.data.Entity.Statistics;
import com.example.testsapp.data.Entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.testsapp.data.Entity.Alerts} entity
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlertsDto implements Serializable {
    private final Long id;
    private final String name;
    private final String user_login;
    private final Long user_id;

    private final Long user_sender_id;

    private final Boolean is_hide;


    public Alerts toEntity()
    {
        return new Alerts(
                this.id,
                this.name,
                this.user_login,
                new Users(this.user_id),
                new Users(this.user_sender_id),
                this.is_hide
        );
    }

    public static AlertsDto toDto(Alerts alerts)
    {
        return new AlertsDto(
                alerts.getId(),
                alerts.getName(),
                alerts.getUser_login(),
                alerts.getUser_id().getId(),
                alerts.getUser_sender_id().getId(),
                alerts.getIs_hide()
        );
    }
}