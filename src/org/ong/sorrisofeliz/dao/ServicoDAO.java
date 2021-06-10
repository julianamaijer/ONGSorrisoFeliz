package org.ong.sorrisofeliz.dao;

import org.ong.sorrisofeliz.entidade.Servico;

import java.util.List;

public interface ServicoDAO {
    void adicionar(Servico servico);
    List<Servico> pesquisarPorServico(String nome);

}
