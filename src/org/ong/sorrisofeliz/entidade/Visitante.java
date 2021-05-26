package org.ong.sorrisofeliz.entidade;

public class Visitante extends Pessoa {

    private Long numero;
    private boolean paciente = false;

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public boolean isPaciente() {
        return paciente;
    }

    public void setPaciente(boolean paciente) {
        this.paciente = paciente;
    }
}
