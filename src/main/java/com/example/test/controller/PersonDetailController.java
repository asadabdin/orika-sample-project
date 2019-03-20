package com.example.test.controller;

import com.example.test.model.RequestDto;
import com.example.test.model.ResponseDto;
import com.example.test.service.PersonDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"v1/persons"})
public class PersonDetailController {

    private final PersonDetailsService personDetailsService;

    @PostMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto post(@RequestBody RequestDto requestDto) {
        return personDetailsService.convertRequestDto(requestDto);
    }

    @PostMapping(path = "/test-inverse", produces = MediaType.APPLICATION_JSON_VALUE)
    public RequestDto postInverse(@RequestBody ResponseDto responseDto) {
        return personDetailsService.convertResponseDto(responseDto);
    }

}
