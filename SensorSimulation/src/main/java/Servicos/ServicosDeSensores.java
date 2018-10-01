package Servicos;

import Modelo.Sensor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Util.Constantes.TEMPO_SIMULACAO;

@Service
public class ServicosDeSensores {


    public void geraDadosString(Sensor sensor){

    }

    public void geraDadosDouble(Sensor sensor,int base,int variacao){
        // tempo de simulação, 1 hora, logo 3600s

        Random rand = new Random();
        double valor;
        List<Double> dados = new ArrayList<>();
        for (int i = 0; i < TEMPO_SIMULACAO; i++) {
            valor = base;
            valor += rand.nextInt(variacao);
            valor +=rand.nextDouble();
            dados.add(valor);

        }
        sensor.setData(dados);

    }
}
