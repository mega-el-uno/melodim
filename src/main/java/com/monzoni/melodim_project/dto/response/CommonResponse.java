package com.monzoni.melodim_project.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class CommonResponse<T> {

    private Integer code;
    private String message;
    private T content;

    public CommonResponse(T content){
        this.code = HttpStatus.OK.value();
        this.message = HttpStatus.OK.name();
        this.content = content;
    }

    public CommonResponse(T content, HttpStatus code){
        this.code = code.value();
        this.message = HttpStatus.OK.name();
        this.content = content;
    }

    public CommonResponse(T content, HttpStatus code, String message){
        this.code = HttpStatus.OK.value();
        this.message = message;
        this.content = content;
    }
}
