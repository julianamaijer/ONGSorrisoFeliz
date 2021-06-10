package org.ong.sorrisofeliz.dao;

import org.ong.sorrisofeliz.entidade.Servico;
import org.ong.sorrisofeliz.entidade.Visitante;

import java.util.List;

public interface VisitanteDAO {
    void adicionar(Visitante visitante);
    List<Visitante> pesquisarPorNome(String nome);
}
