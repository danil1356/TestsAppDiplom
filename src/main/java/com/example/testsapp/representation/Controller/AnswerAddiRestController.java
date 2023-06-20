package com.example.testsapp.representation.Controller;


import com.example.testsapp.data.Entity.AnswerAddi;
import com.example.testsapp.representation.DTO.AnswerAddiDto;
import com.example.testsapp.service.AnswerAddiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/AnswerAddi")
public class AnswerAddiRestController {

    @Autowired
    private AnswerAddiService answerAddiService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AnswerAddiDto> get (@PathVariable Long id)
    {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }

        AnswerAddiDto answerAddiDTO = this.answerAddiService.getById(id);

        if (answerAddiDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(answerAddiDTO);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<AnswerAddiDto>> getAllUser ()
    {
        List<AnswerAddiDto> list = this.answerAddiService.getAll();

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);
    }


    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<AnswerAddiDto> post(@RequestBody AnswerAddiDto answerAddiDTO)
    {
        if (answerAddiDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        // TODO: 21.04.2023 верная реализация возврата сохраненного (id перестает быть null)
        AnswerAddi addi = this.answerAddiService.save(answerAddiDTO.toEntity());
        return ResponseEntity.ok(AnswerAddiDto.toDto(addi));
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<AnswerAddiDto> delete(@PathVariable Long id)
    {
        AnswerAddiDto answerAddiDTO = this.answerAddiService.getById(id);
        if (answerAddiDTO == null) {
            return ResponseEntity.notFound().build();
        }

        this.answerAddiService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<AnswerAddiDto> update(@RequestBody @Validated AnswerAddiDto answerAddiDTO, UriComponentsBuilder builder)
    {
        if(answerAddiDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        this.answerAddiService.save(answerAddiDTO.toEntity());
        return ResponseEntity.ok(answerAddiDTO);
    }
}
