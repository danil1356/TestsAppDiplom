package com.example.testsapp.representation.Controller;

import com.example.testsapp.data.Entity.Alerts;
import com.example.testsapp.representation.DTO.AlertsDto;
import com.example.testsapp.service.AlertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/Alerts")
public class AlertsRestController {

    private final AlertsService alertsService;

    @Autowired
    public AlertsRestController(AlertsService alertsService) {
        this.alertsService = alertsService;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AlertsDto> get(@PathVariable Long id)
    {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }

        AlertsDto alertsDto = this.alertsService.getById(id);

        if (alertsDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(alertsDto);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<AlertsDto>> getAll()
    {
        List<AlertsDto> list = this.alertsService.getAll();

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);
    }


    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<AlertsDto> post(@RequestBody AlertsDto alertsDto)
    {
        if (alertsDto == null) {
            return ResponseEntity.badRequest().build();
        }

        Alerts alerts = this.alertsService.save(alertsDto.toEntity());
        return ResponseEntity.ok(AlertsDto.toDto(alerts));
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<AlertsDto> delete(@PathVariable Long id)
    {
        AlertsDto alertsDto = this.alertsService.getById(id);
        if (alertsDto == null) {
            return ResponseEntity.notFound().build();
        }

        this.alertsService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<AlertsDto> update(@RequestBody @Validated AlertsDto alertsDto, UriComponentsBuilder builder)
    {
        if(alertsDto == null) {
            return ResponseEntity.badRequest().build();
        }

        this.alertsService.save(alertsDto.toEntity());
        return ResponseEntity.ok().build();
    }
}
