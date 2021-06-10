package org.ong.sorrisofeliz.boundary;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.LongStringConverter;
import org.ong.sorrisofeliz.control.CadastroFuncionarioControl;
import org.ong.sorrisofeliz.control.CadastroServicoControl;

import java.time.format.DateTimeFormatter;

public class CadastroServicoBoundary extends Application {

    private TextField txtNome = new TextField();
    private TextField txtDescricao = new TextField();
    private TextField txtId = new TextField();

    private Button btnAdicionar = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");
    private Button btnRemover = new Button("Remover");
    private Button btnAlterar = new Button("Alterar");

    private CadastroServicoControl control = new CadastroServicoControl();

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gp = new GridPane();
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 400, 400);
        gp.setAlignment(Pos.BASELINE_CENTER);

        gp.add(new Label("Id:"), 0, 5);
        gp.add(txtId,3,5);
        gp.add(new Label("Nome:"), 0, 7);
        gp.add(txtNome,3, 7);
        gp.add(new Label("Descrição:"), 0, 9);
        gp.add(txtDescricao,3, 9);
        gp.add(btnAdicionar,0,11);
        gp.add(btnPesquisar,1,11);
        gp.add(btnRemover,2,11);
        gp.add(btnAlterar,3,11);

        control.generatedTable();
        borderPane.setTop(gp);
        borderPane.setCenter(control.getTable());

        btnAdicionar.setStyle("-fx-border-color:  #00cec9; -fx-background-color:  white; -fx-color:  #00cec9");
        btnPesquisar.setStyle("-fx-border-color:  #00cec9; -fx-background-color:  white; -fx-color:  #00cec9");
        btnRemover.setStyle("-fx-border-color:  #00cec9; -fx-background-color:  white; -fx-color:  #00cec9");
        btnAlterar.setStyle("-fx-border-color:  #00cec9; -fx-background-color:  white; -fx-color:  #00cec9");

        btnAdicionar.setOnAction((e) -> {control.adicionar();});
        btnPesquisar.setOnAction((e) -> {control.pesquisarPorServico();});
        //btnRemover.setOnAction(this);

        StringConverter longToStringConverter = new LongStringConverter();

        Bindings.bindBidirectional(txtId.textProperty(), control.idProperty(), longToStringConverter);
        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
        Bindings.bindBidirectional(txtDescricao.textProperty(), control.descricaoProperty());

        stage.setScene(scene);
        stage.setTitle("Cadastro Serviço");
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(CadastroServicoBoundary.class, args);
    }

}
