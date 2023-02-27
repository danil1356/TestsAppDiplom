package com.example.testsapp.representation.Controller;

import com.example.testsapp.data.Entity.ImageData;
import com.example.testsapp.representation.DTO.ImageDataDto;
import com.example.testsapp.service.ImageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/ImageData")
public class ImageDataRestController {

    @Autowired
    private ImageDataService imageDataService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ImageDataDto> get(@PathVariable Long id)
    {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }

        ImageDataDto imageDataDto = this.imageDataService.getById(id);

        if (imageDataDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(imageDataDto);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<ImageDataDto>> getAll()
    {
        List<ImageDataDto> list = this.imageDataService.getAll();

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);
    }


    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ImageDataDto> post(@RequestBody ImageDataDto imageDataDto)
    {
        if (imageDataDto == null) {
            return ResponseEntity.badRequest().build();
        }

        this.imageDataService.save(imageDataDto.toEntity());
        return ResponseEntity.ok().build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ImageDataDto> delete(@PathVariable Long id)
    {
        ImageDataDto imageDataDto = this.imageDataService.getById(id);
        if (imageDataDto == null) {
            return ResponseEntity.notFound().build();
        }

        this.imageDataService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<ImageDataDto> update(@RequestBody @Validated ImageDataDto imageDataDto, UriComponentsBuilder builder)
    {
        if(imageDataDto == null) {
            return ResponseEntity.badRequest().build();
        }

        this.imageDataService.save(imageDataDto.toEntity());
        return ResponseEntity.ok().build();
    }
}
