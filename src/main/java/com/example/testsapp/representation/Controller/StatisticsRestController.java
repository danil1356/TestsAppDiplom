package com.example.testsapp.representation.Controller;

import com.example.testsapp.data.Entity.Statistics;
import com.example.testsapp.representation.DTO.StatisticsDto;
import com.example.testsapp.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/Statistics")
public class StatisticsRestController {

    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<StatisticsDto> get(@PathVariable Long id)
    {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }

        StatisticsDto statisticsDto = this.statisticsService.getById(id);

        if (statisticsDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(statisticsDto);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<StatisticsDto>> getAll()
    {
        List<StatisticsDto> list = this.statisticsService.getAll();

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);
    }


    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<StatisticsDto> post(@RequestBody StatisticsDto statisticsDto)
    {
        if (statisticsDto == null) {
            return ResponseEntity.badRequest().build();
        }

        this.statisticsService.save(statisticsDto.toEntity());
        return ResponseEntity.ok().build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<StatisticsDto> delete(@PathVariable Long id)
    {
        StatisticsDto statisticsDto = this.statisticsService.getById(id);
        if (statisticsDto == null) {
            return ResponseEntity.notFound().build();
        }

        this.statisticsService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<StatisticsDto> update(@RequestBody @Validated StatisticsDto statisticsDto, UriComponentsBuilder builder)
    {
        if(statisticsDto == null) {
            return ResponseEntity.badRequest().build();
        }

        this.statisticsService.save(statisticsDto.toEntity());
        return ResponseEntity.ok().build();
    }
}
