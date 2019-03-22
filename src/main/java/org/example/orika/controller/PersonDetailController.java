package org.example.orika.controller;

import lombok.RequiredArgsConstructor;
import org.example.orika.model.RequestDto;
import org.example.orika.model.ResponseDto;
import org.example.orika.service.PersonDetailsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
