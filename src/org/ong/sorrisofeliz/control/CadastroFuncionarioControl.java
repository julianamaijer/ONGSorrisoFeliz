package org.ong.sorrisofeliz.control;

import org.ong.sorrisofeliz.entidade.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class CadastroFuncionarioControl {

    private List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionar(Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    public Funcionario pesquisarPorNome(String nome){
        for (Funcionario funcionario : funcionarios){
            if(funcionario.getNome().contains(nome)){
                return funcionario;
            }
        }
        return null;
    }



}
