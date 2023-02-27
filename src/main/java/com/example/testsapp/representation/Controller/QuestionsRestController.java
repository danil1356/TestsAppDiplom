package com.example.testsapp.representation.Controller;

import com.example.testsapp.representation.DTO.QuestionsDto;
import com.example.testsapp.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/Questions")
public class QuestionsRestController {

    @Autowired
    private QuestionsService questionsService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<QuestionsDto> get(@PathVariable Long id)
    {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }

        QuestionsDto questionsDto = this.questionsService.getById(id);

        if (questionsDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(questionsDto);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<QuestionsDto>> getAll()
    {
        List<QuestionsDto> list = this.questionsService.getAll();

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);
    }


    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<QuestionsDto> post(@RequestBody QuestionsDto questionsDto)
    {
        if (questionsDto == null) {
            return ResponseEntity.badRequest().build();
        }

        this.questionsService.save(questionsDto.toEntity());
        return ResponseEntity.ok().build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<QuestionsDto> delete(@PathVariable Long id)
    {
        QuestionsDto questionsDto = this.questionsService.getById(id);
        if (questionsDto == null) {
            return ResponseEntity.notFound().build();
        }

        this.questionsService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<QuestionsDto> update(@RequestBody @Validated QuestionsDto questionsDto, UriComponentsBuilder builder)
    {
        if(questionsDto == null) {
            return ResponseEntity.badRequest().build();
        }

        this.questionsService.save(questionsDto.toEntity());
        return ResponseEntity.ok().build();
    }
}
