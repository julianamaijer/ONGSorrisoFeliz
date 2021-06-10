package org.ong.sorrisofeliz.boundary;

import javafx.application.Application;
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
import org.ong.sorrisofeliz.control.CadastroVisitanteControl;
import org.ong.sorrisofeliz.entidade.Funcionario;
import org.ong.sorrisofeliz.entidade.Visitante;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastroVisitanteBoundary extends Application {

    private TextField txtId = new TextField();
    private TextField txtNome = new TextField();
    private TextField txtCpf = new TextField();
    private TextField txtRg = new TextField();
    private TextField txtTelefone = new TextField();
    private TextField txtDataNascimento = new TextField();
    private TextField txtNumero = new TextField();
    private TextField txtPaciente = new TextField();

    private Button btnAdicionar = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");
    private Button btnRemover = new Button("Remover");
    private Button btnAlterar = new Button("Alterar");

    private CadastroVisitanteControl cadastroFuncionarioControl = new CadastroVisitanteControl();

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gp = new GridPane();
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 700, 500);
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
        gp.add(txtNumero, 3,17);
        gp.add(new Label("Função:"), 0, 19);
        gp.add(txtPaciente,3,19);
        gp.add(btnAdicionar,0,21);
        gp.add(btnPesquisar,1,21);
        gp.add(btnRemover,2,21);
        gp.add(btnAlterar,3,21);

        cadastroFuncionarioControl.generatedTable();
        borderPane.setTop(gp);
        borderPane.setCenter(cadastroFuncionarioControl.getTable());

        btnAdicionar.setStyle("-fx-border-color:  #00cec9; -fx-background-color:  white; -fx-color:  #00cec9");
        btnPesquisar.setStyle("-fx-border-color:  #00cec9; -fx-background-color:  white; -fx-color:  #00cec9");
        btnRemover.setStyle("-fx-border-color:  #00cec9; -fx-background-color:  white; -fx-color:  #00cec9");
        btnAlterar.setStyle("-fx-border-color:  #00cec9; -fx-background-color:  white; -fx-color:  #00cec9");

        btnAdicionar.setOnAction((e) -> {cadastroFuncionarioControl.adicionar();});
        btnPesquisar.setOnAction((e) -> {cadastroFuncionarioControl.pesquisarPorNome();});
        //btnRemover.setOnAction(this);

        stage.setScene(scene);
        stage.setTitle("Cadastro Visitante");
        stage.show();

    }


    public static void main(String[] args) {
        Application.launch(CadastroVisitanteBoundary.class, args);
    }


}
