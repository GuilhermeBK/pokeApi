package com.br.desafiopokeapi.vo;

import org.springframework.stereotype.Component;

import java.util.List;

//Usado para formatarar e envolver o resultado em uma lista de nome "result", conforme requerido no desafio
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
