package Modelo;

import java.util.List;

public class Sensor {

    private String nome;
    private List<?> data;
    private Object canal;

    public Sensor(String nome, List<?> data, Object canal) {
        this.nome = nome;
        this.data = data;
        this.canal = canal;
    }

    public Sensor(String nome, Object canal) {
        this.nome = nome;
        this.canal = canal;
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

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}