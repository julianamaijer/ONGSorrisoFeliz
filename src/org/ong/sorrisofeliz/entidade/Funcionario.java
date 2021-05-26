package org.ong.sorrisofeliz.entidade;

public class Funcionario extends Pessoa {

    private Long numeroFuncional;
    private String funcao = "";


    public Long getNumeroFuncional() {
        return numeroFuncional;
    }

    public void setNumeroFuncional(Long numeroFuncional) {
        this.numeroFuncional = numeroFuncional;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
