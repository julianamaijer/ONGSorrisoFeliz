package org.ong.sorrisofeliz.dao;

import org.ong.sorrisofeliz.entidade.Funcionario;
import org.ong.sorrisofeliz.entidade.Servico;

import java.util.List;

public interface FuncionarioDAO {
    void adicionar(Funcionario funcionario);
    List<Funcionario> pesquisarPorNome(String nome);
}
