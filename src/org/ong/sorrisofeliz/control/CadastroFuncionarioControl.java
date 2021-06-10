package org.ong.sorrisofeliz.control;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
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
    private TableView<Visitante> table = new TableView<>();

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

    public void removerPeloNome(String nome){
        Funcionario funcionario = pesquisarPorNome(nome);
        funcionarios.remove(funcionario);
    }

}
