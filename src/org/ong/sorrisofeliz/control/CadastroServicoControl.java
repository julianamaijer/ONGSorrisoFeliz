package org.ong.sorrisofeliz.control;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.ong.sorrisofeliz.dao.ServicoDAO;
import org.ong.sorrisofeliz.dao.ServicoDAOImpl;
import org.ong.sorrisofeliz.entidade.Funcionario;
import org.ong.sorrisofeliz.entidade.Servico;

import java.time.LocalDate;
import java.util.List;

public class CadastroServicoControl {

    private ObservableList<Servico> servicos = FXCollections.observableArrayList();
    private TableView<Servico> table = new TableView<>();

    private LongProperty id = new SimpleLongProperty(0);
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty descricao = new SimpleStringProperty("");
    private ServicoDAO servicoDAO = new ServicoDAOImpl();

    public void setEntity(Servico servico) {
        if (servico != null) {
            id.set(servico.getId());
            nome.set(servico.getNome());
            descricao.set(servico.getDescricao());
        }
    }

    public Servico getEntity() {
        Servico servico = new Servico();
        servico.setId(id.get());
        servico.setNome(nome.get());
        servico.setDescricao(descricao.get());
        return servico;
    }

    public void adicionar(){
        Servico servico = getEntity();
        servicoDAO.adicionar(servico);
    }

    public void pesquisarPorServico(){
        List<Servico> list = servicoDAO.pesquisarPorServico(nome.get());
        servicos.clear();
        servicos.addAll(list);
    }

    public ObservableList<Servico> getServicos() {
        return servicos;
    }

    public TableView<Servico> getTable() {
        return table;
    }

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public String getNome() {
        return nome.get();
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public String getDescricao() {
        return descricao.get();
    }

    public StringProperty descricaoProperty() {
        return descricao;
    }

    public void generatedTable(){
        TableColumn<Servico, Long> columnId = new TableColumn<>("Id");
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Servico, String> columnNome = new TableColumn<>("Nome do serviço");
        columnNome.setCellValueFactory(new PropertyValueFactory<Servico, String>("nome"));
        TableColumn<Servico, String> columnDescricao = new TableColumn<>("Descrição");
        columnDescricao.setCellValueFactory(new PropertyValueFactory<Servico, String>("descricao"));

        table.getColumns().addAll(columnId,columnNome,columnDescricao);

        table.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
            setEntity(novo);
        });

        table.setItems(servicos);

    }
}
