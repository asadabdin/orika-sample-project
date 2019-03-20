package com.example.test.service;

import com.example.test.model.RequestDto;
import com.example.test.model.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonDetailsService {

    private final MapperFacade mapperFacade;

    public ResponseDto convertRequestDto(RequestDto requestDto) {
        ResponseDto responseDto = mapperFacade.map(requestDto, ResponseDto.class);
        log.info(responseDto.toString());
        return responseDto;
    }

    public RequestDto convertResponseDto(ResponseDto responseDto) {
        RequestDto requestDto = mapperFacade.map(responseDto, RequestDto.class);
        log.info(requestDto.toString());
        return requestDto;
    }

}
