package org.ong.sorrisofeliz.control;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.ong.sorrisofeliz.entidade.Funcionario;
import org.ong.sorrisofeliz.entidade.Servico;

import java.time.LocalDate;

public class CadastroServicoControl {

    private static final String URL = "jdbc:mariadb://localhost:3306/ongdb?allowMultiQueries=true";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    private ObservableList<Servico> servicos = FXCollections.observableArrayList();
    private TableView<Servico> table = new TableView<>();

    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty descricao = new SimpleStringProperty("");

    public void setEntity(Servico servico) {
        if (servico != null) {
            nome.set(servico.getNome());
            descricao.set(servico.getDescricao());
        }
    }

    public Servico getEntity() {
        Servico servico = new Servico();
        servico.setNome(nome.get());
        servico.setDescricao(descricao.get());
        return servico;
    }

    public void adicionar(){
        Servico servico = getEntity();
        servicos.add(servico);
    }

    public void pesquisarPorNome(){
        for (Servico servico : servicos){
            if(servico.getNome().contains(nome.get())){
                this.setEntity(servico);
            }
        }
    }

    public ObservableList<Servico> getServicos() {
        return servicos;
    }

    public TableView<Servico> getTable() {
        return table;
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
        TableColumn<Servico, String> columnNome = new TableColumn<>("Nome do serviço");
        columnNome.setCellValueFactory(new PropertyValueFactory<Servico, String>("nome"));
        TableColumn<Servico, String> columnDescricao = new TableColumn<>("Descrição");
        columnDescricao.setCellValueFactory(new PropertyValueFactory<Servico, String>("descricao"));

        table.getColumns().addAll(columnNome,columnDescricao);

        table.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
            setEntity(novo);
        });

        table.setItems(servicos);

    }
}
