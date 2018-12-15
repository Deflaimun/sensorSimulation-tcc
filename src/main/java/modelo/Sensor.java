package modelo;

import java.util.List;

public class Sensor {

    private String nome;
    private List<String> data;
    private String unidade;
    private Object canal;
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Sensor(String nome, List<String> data, String unidade, Object canal) {
        this.nome = nome;
        this.data = data;
        this.unidade = unidade;
        this.canal = canal;
    }

    public Sensor(String nome, List<String> data, String unidade, Object canal, String tipo) {
        this.nome = nome;
        this.data = data;
        this.unidade = unidade;
        this.canal = canal;
        this.tipo = tipo;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }


    public Sensor(Object canal) {
        this.canal = canal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Object getCanal() {
        return canal;
    }

    public void setCanal(Object canal) {
        this.canal = canal;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
