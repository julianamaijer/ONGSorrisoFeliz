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

public class CadastroVisitanteControl {

    private static final String URL = "jdbc:mariadb://localhost:3306/ongdb?allowMultiQueries=true";
    private static final String USER = "root";
    private static final String PASSWORD = "maijer1245";

    private ObservableList<Visitante> visitantes = FXCollections.observableArrayList();
    private TableView<Visitante> table = new TableView<>();

    private LongProperty id = new SimpleLongProperty(0);
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty cpf = new SimpleStringProperty("");
    private StringProperty rg = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> dataNascimento = new SimpleObjectProperty<>(LocalDate.now());
    private LongProperty numero = new SimpleLongProperty(0);
    private BooleanProperty paciente = new SimpleBooleanProperty(false);

    public void setEntity(Visitante visitante) {
        if (visitante != null) {
            id.set(visitante.getId());
            nome.set(visitante.getNome());
            cpf.set(visitante.getCpf());
            rg.set(visitante.getRg());
            telefone.set(visitante.getTelefone());
            dataNascimento.set(visitante.getDataNascimento());
            numero.set(visitante.getNumero());
            paciente.set(visitante.isPaciente());
        }
    }

    public Visitante getEntity() {
        Visitante visitante = new Visitante();
        visitante.setId(id.get());
        visitante.setNome(nome.get());
        visitante.setCpf(cpf.get());
        visitante.setRg(rg.get());
        visitante.setTelefone(telefone.get());
        visitante.setDataNascimento(dataNascimento.get());
        visitante.setNumero(numero.get());
        visitante.setPaciente(paciente.get());
        return visitante;
    }

    public ObservableList<Visitante> getVisitantes() {
        return visitantes;
    }

    public TableView<Visitante> getTable() {
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

    public long getNumero() {
        return numero.get();
    }

    public LongProperty numeroProperty() {
        return numero;
    }

    public boolean isPaciente() {
        return paciente.get();
    }

    public BooleanProperty pacienteProperty() {
        return paciente;
    }


    public void adicionar(){
        Visitante visitante = getEntity();
        visitantes.add(visitante);
    }

    public void pesquisarPorNome(){
        for (Visitante visitante : visitantes){
            if(visitante.getNome().contains(nome.get())){
                this.setEntity(visitante);
            }
        }
    }

    public void generatedTable(){
        TableColumn<Visitante, Long> columnId = new TableColumn<>("Id");
        columnId.setCellValueFactory(new PropertyValueFactory<Visitante, Long>("id"));
        TableColumn<Visitante, String> columnNome = new TableColumn<>("Nome");
        columnNome.setCellValueFactory(new PropertyValueFactory<Visitante, String>("nome"));
        TableColumn<Visitante, String> columnCpf = new TableColumn<>("CPF");
        columnCpf.setCellValueFactory(new PropertyValueFactory<Visitante, String>("cpf"));
        TableColumn<Visitante, String> columnRg = new TableColumn<>("RG");
        columnRg.setCellValueFactory(new PropertyValueFactory<Visitante, String>("rg"));
        TableColumn<Visitante, String> columnTelefone = new TableColumn<>("Telefone");
        columnTelefone.setCellValueFactory(new PropertyValueFactory<Visitante, String>("telefone"));
        TableColumn<Visitante, LocalDate> columnDataNascimento = new TableColumn<>("Data de Nascimento");
        columnDataNascimento.setCellValueFactory(new PropertyValueFactory<Visitante, LocalDate>("telefone"));
        TableColumn<Visitante, Long> columnNumero = new TableColumn<>("Número");
        columnNumero.setCellValueFactory(new PropertyValueFactory<Visitante, Long>("numero"));
        TableColumn<Visitante, Boolean> columnPaciente = new TableColumn<>("É paciente?");
        columnPaciente.setCellValueFactory(new PropertyValueFactory<Visitante, Boolean>("nome"));

        table.getColumns().addAll(columnId,columnNome,columnCpf,columnRg,columnTelefone,columnDataNascimento,columnNumero,columnPaciente);

        table.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
                setEntity(novo);
        });

        table.setItems(visitantes);

    }

/*    public void removerPeloNome(String nome){
        Visitante visitante = pesquisarPorNome(nome);
        visitantes.remove(visitante);
    }*/
}
