package org.ong.sorrisofeliz.control;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.ong.sorrisofeliz.entidade.Funcionario;
import org.ong.sorrisofeliz.entidade.Visitante;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CadastroFuncionarioControl {

    private static final String URL = "jdbc:mariadb://localhost:3306/ongdb?allowMultiQueries=true";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    private ObservableList<Funcionario> funcionarios = FXCollections.observableArrayList();
    private TableView<Funcionario> table = new TableView<>();

    private LongProperty id = new SimpleLongProperty(0);
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty cpf = new SimpleStringProperty("");
    private StringProperty rg = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> dataNascimento = new SimpleObjectProperty<>(LocalDate.now());
    private LongProperty numeroFuncional = new SimpleLongProperty(0);
    private StringProperty funcao = new SimpleStringProperty("");

    public void setEntity(Funcionario funcionario) {
        if (funcionario != null) {
            id.set(funcionario.getId());
            nome.set(funcionario.getNome());
            cpf.set(funcionario.getCpf());
            rg.set(funcionario.getRg());
            telefone.set(funcionario.getTelefone());
            dataNascimento.set(funcionario.getDataNascimento());
            numeroFuncional.set(funcionario.getNumeroFuncional());
            funcao.set(funcionario.getFuncao());
        }
    }

    public Funcionario getEntity() {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(id.get());
        funcionario.setNome(nome.get());
        funcionario.setCpf(cpf.get());
        funcionario.setRg(rg.get());
        funcionario.setTelefone(telefone.get());
        funcionario.setDataNascimento(dataNascimento.get());
        funcionario.setNumeroFuncional(numeroFuncional.get());
        funcionario.setFuncao(funcao.get());
        return funcionario;
    }

    public void adicionar(){
        Funcionario funcionario = getEntity();
        funcionarios.add(funcionario);
    }

    public void pesquisarPorNome(){
        for (Funcionario funcionario : funcionarios){
            if(funcionario.getNome().contains(nome.get())){
                this.setEntity(funcionario);
            }
        }
    }

    public ObservableList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public TableView<Funcionario> getTable() {
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

    public String getCpf() {
        return cpf.get();
    }

    public StringProperty cpfProperty() {
        return cpf;
    }

    public String getRg() {
        return rg.get();
    }

    public StringProperty rgProperty() {
        return rg;
    }

    public String getTelefone() {
        return telefone.get();
    }

    public StringProperty telefoneProperty() {
        return telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento.get();
    }

    public ObjectProperty<LocalDate> dataNascimentoProperty() {
        return dataNascimento;
    }

    public long getNumeroFuncional() {
        return numeroFuncional.get();
    }

    public LongProperty numeroFuncionalProperty() {
        return numeroFuncional;
    }

    public String getFuncao() {
        return funcao.get();
    }

    public StringProperty funcaoProperty() {
        return funcao;
    }

    public void generatedTable(){
        TableColumn<Funcionario, Long> columnId = new TableColumn<>("Id");
        columnId.setCellValueFactory(new PropertyValueFactory<Funcionario, Long>("id"));
        TableColumn<Funcionario, String> columnNome = new TableColumn<>("Nome");
        columnNome.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nome"));
        TableColumn<Funcionario, String> columnCpf = new TableColumn<>("CPF");
        columnCpf.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("cpf"));
        TableColumn<Funcionario, String> columnRg = new TableColumn<>("RG");
        columnRg.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("rg"));
        TableColumn<Funcionario, String> columnTelefone = new TableColumn<>("Telefone");
        columnTelefone.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("telefone"));
        TableColumn<Funcionario, LocalDate> columnDataNascimento = new TableColumn<>("Data de Nascimento");
        columnDataNascimento.setCellValueFactory(new PropertyValueFactory<Funcionario, LocalDate>("telefone"));
        TableColumn<Funcionario, Long> columnNumeroFuncional = new TableColumn<>("Número Funcional");
        columnNumeroFuncional.setCellValueFactory(new PropertyValueFactory<Funcionario, Long>("numeroFuncional"));
        TableColumn<Funcionario, String> columnFuncao = new TableColumn<>("Função");
        columnFuncao.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("funcao"));

        table.getColumns().addAll(columnId,columnNome,columnCpf,columnRg,columnTelefone,columnDataNascimento,columnNumeroFuncional,columnFuncao);

        table.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
            setEntity(novo);
        });

        table.setItems(funcionarios);

    }

/*    public void removerPeloNome(String nome){
        Funcionario funcionario = pesquisarPorNome(nome);
        funcionarios.remove(funcionario);
    }*/

}
