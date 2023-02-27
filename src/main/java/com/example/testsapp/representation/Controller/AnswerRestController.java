package com.example.testsapp.representation.Controller;

import com.example.testsapp.data.Entity.Answer;
import com.example.testsapp.representation.DTO.AnswerDto;
import com.example.testsapp.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/Answer")
public class AnswerRestController {

    @Autowired
    private AnswerService answerService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AnswerDto> get (@PathVariable Long id)
    {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }

        AnswerDto answerDTO = this.answerService.getById(id);

        if (answerDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(answerDTO);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<AnswerDto>> getAllUser ()
    {
        List<AnswerDto> list = this.answerService.getAll();

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);
    }


    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<AnswerDto> post(@RequestBody AnswerDto answerDTO)
    {
        if (answerDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        this.answerService.save(answerDTO.toEntity());
        return ResponseEntity.ok().build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<AnswerDto> delete(@PathVariable Long id)
    {
        AnswerDto answerDTO = this.answerService.getById(id);
        if (answerDTO == null) {
            return ResponseEntity.notFound().build();
        }

        this.answerService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<AnswerDto> update(@RequestBody @Validated AnswerDto answerDTO, UriComponentsBuilder builder)
    {
        if(answerDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        this.answerService.save(answerDTO.toEntity());
        return ResponseEntity.ok().build();
    }
}
