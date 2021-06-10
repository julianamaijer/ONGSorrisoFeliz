package org.ong.sorrisofeliz.boundary;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.LongStringConverter;
import org.ong.sorrisofeliz.control.CadastroFuncionarioControl;
import org.ong.sorrisofeliz.entidade.Funcionario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastroFuncionarioBoundary extends Application {

    private TextField txtId = new TextField();
    private TextField txtNome = new TextField();
    private TextField txtCpf = new TextField();
    private TextField txtRg = new TextField();
    private TextField txtTelefone = new TextField();
    private TextField txtDataNascimento = new TextField();
    private TextField txtNumeroFuncional = new TextField();
    private TextField txtFuncao = new TextField();

    private Button btnAdicionar = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");
    private Button btnRemover = new Button("Remover");
    private Button btnAlterar = new Button("Alterar");

    private CadastroFuncionarioControl control = new CadastroFuncionarioControl();

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gp = new GridPane();
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 600, 400);
        gp.setAlignment(Pos.BASELINE_CENTER);

        gp.add(new Label("Id:"), 0, 5);
        gp.add(txtId,3,5);
        gp.add(new Label("Nome:"), 0, 7);
        gp.add(txtNome,3, 7);
        gp.add(new Label("CPF:"), 0, 9);
        gp.add(txtCpf,3,9);
        gp.add(new Label("RG:"), 0, 11);
        gp.add(txtRg,3,11);
        gp.add(new Label("Telefone:"), 0, 13);
        gp.add(txtTelefone,3,13);
        gp.add(new Label("Data de Nascimento:"), 0, 15);
        gp.add(txtDataNascimento,3,15);
        gp.add(new Label("Funcional:"), 0, 17);
        gp.add(txtNumeroFuncional, 3,17);
        gp.add(new Label("Função:"), 0, 19);
        gp.add(txtFuncao,3,19);
        gp.add(btnAdicionar,0,21);
        gp.add(btnPesquisar,1,21);
        gp.add(btnRemover,2,21);
        gp.add(btnAlterar,3,21);

        control.generatedTable();
        borderPane.setTop(gp);
        borderPane.setCenter(control.getTable());

        btnAdicionar.setStyle("-fx-border-color:  #00cec9; -fx-background-color:  white; -fx-color:  #00cec9");
        btnPesquisar.setStyle("-fx-border-color:  #00cec9; -fx-background-color:  white; -fx-color:  #00cec9");
        btnRemover.setStyle("-fx-border-color:  #00cec9; -fx-background-color:  white; -fx-color:  #00cec9");
        btnAlterar.setStyle("-fx-border-color:  #00cec9; -fx-background-color:  white; -fx-color:  #00cec9");

        btnAdicionar.setOnAction((e) -> {control.adicionar();});
        btnPesquisar.setOnAction((e) -> {control.pesquisarPorNome();});
        //btnRemover.setOnAction(this);

        StringConverter longToStringConverter = new LongStringConverter();
        StringConverter localDateToStringConverter = new LocalDateStringConverter();

        Bindings.bindBidirectional(txtId.textProperty(), control.idProperty(), longToStringConverter);
        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
        Bindings.bindBidirectional(txtCpf.textProperty(), control.cpfProperty());
        Bindings.bindBidirectional(txtRg.textProperty(), control.rgProperty());
        Bindings.bindBidirectional(txtTelefone.textProperty(), control.telefoneProperty());
        Bindings.bindBidirectional(txtDataNascimento.textProperty(), control.dataNascimentoProperty(), localDateToStringConverter);
        Bindings.bindBidirectional(txtNumeroFuncional.textProperty(), control.numeroFuncionalProperty(), longToStringConverter);
        Bindings.bindBidirectional(txtFuncao.textProperty(), control.funcaoProperty());

        stage.setScene(scene);
        stage.setTitle("Cadastro Funcionário");
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(CadastroFuncionarioBoundary.class, args);
    }
}
