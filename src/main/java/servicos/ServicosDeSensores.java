package servicos;

import modelo.Sensor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static util.Constantes.*;

@Service
public class ServicosDeSensores {


    /**
     * Gera os dados baseado no sensor LM-35
     *
     * @param sensor
     */
    public void geraDadosTemperatura(Sensor sensor) {
        // tempo de simulação, meia hora, logo 1800s
        //Volt inicial 10,6 = 0ºC
        //Volt Final 22.6 = 100ºC
        DecimalFormat df = new DecimalFormat(".##"); //precisão de duas casas decimais

        //se for em temperatura 1V = 8.6ºC
        double fatorVolt = 0.006;
        double dado = 10.6;
        List<String> dados = new ArrayList<>();
        dados.add(df.format(dado));
        for (int i = 1; i < MEIA_HORA; i++) {
            dado += fatorVolt;
            dados.add(df.format(dado));
        }
        sensor.setData(dados);
    }

    /**
     * Gera os dados baseado no sensor LDR
     *
     * @param sensor
     */
    public void geraLuminosidadeUmDia(Sensor sensor) {

        List<String> dados = new ArrayList<>();
        double fatorNoiteParaMeia = -0.027;
        double fatorMeiaParaDia = 0.031;
        double fatorDiaParaNoite = -0.018;

        double dado = 601;
        int dadoConvertido;

        // de 21 a 03, valor irá variar de 600 a 0, 6h de simulação
        for (int i = 0; i < SEIS_HORAS; i++) {
            dado += fatorNoiteParaMeia;
            dadoConvertido = (int) dado;
            dados.add(Integer.toString(dadoConvertido));
        }
        // de 03 a 12, valor irá variar de  0 a 1023,9h de simulação
        for (int i = 0; i < NOVE_HORAS; i++) {
            dado += fatorMeiaParaDia;
            dadoConvertido = (int) dado;
            dados.add(Integer.toString(dadoConvertido));
        }
        // de 12 a 21, valor irá variar de 1023 a 600, 9h de simulação
        for (int i = 0; i < NOVE_HORAS; i++) {
            dado += fatorDiaParaNoite;
            dadoConvertido = (int) dado;
            dados.add(Integer.toString(dadoConvertido));
        }

        sensor.setData(dados);

    }


    /**
     * Gera dados baseado no sensor MQ-135
     *
     * @param sensor
     */
    public void geraDadoPoluicao(Sensor sensor) {
        List<String> dados = new ArrayList<>();
        double dado = 35;
        Random r = new Random(5);
        DecimalFormat df = new DecimalFormat(".##");


        for (int i = 0; i < MEIA_HORA; i++) {
            dados.add(Double.toString(dado));
        }

        for (int i = 0; i < MEIA_HORA; i++) {
            dado = 500;
            dado += r.nextDouble() * 30;
            dados.add(df.format(dado));
        }
        sensor.setData(dados);
    }
}
