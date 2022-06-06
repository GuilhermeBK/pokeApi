package com.br.desafiopokeapi.vo;

import org.springframework.stereotype.Component;

import java.util.List;

//Formata o resultado
@Component
public class ResultDto<Class> {

    private List<?> result;

    public List<?> getResult() {
        return result;
    }

    public void setResult(List<?> result) {
        this.result = result;
    }
}
