package org.example.orika.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.example.orika.model.RequestDto;
import org.example.orika.model.ResponseDto;
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
