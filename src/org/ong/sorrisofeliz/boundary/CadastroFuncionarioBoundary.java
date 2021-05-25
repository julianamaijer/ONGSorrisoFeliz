package org.ong.sorrisofeliz.boundary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class CadastroFuncionarioBoundary extends Application implements EventHandler<ActionEvent> {

    private TextField txtId = new TextField();
    private TextField txtNome = new TextField();
    private TextField txtCpf = new TextField();
    private TextField txtRg = new TextField();
    private TextField txtTelefone = new TextField();
    private TextField txtDataNascimento = new TextField();


}
