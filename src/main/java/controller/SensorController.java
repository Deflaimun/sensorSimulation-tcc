package controller;

import modelo.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import servicos.ServicosDeMQTT;
import servicos.ServicosDeSensores;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static util.Constantes.*;

@RestController
public class SensorController {

    @Autowired
    private ServicosDeSensores servicosDeSensores;

    @Autowired
    private ServicosDeMQTT servicosdeMQTT = new ServicosDeMQTT();


    @RequestMapping("/enviaDadosSensorTemperaturaMQTT")
    public String enviaDadosSensorTemperaturaMQTT(){
        Sensor sensor = new Sensor(SENSOR_TEMPERATURA, new ArrayList<>(),"Volts", "MQTT");
        servicosDeSensores.geraDadosTemperatura(sensor);
        if(servicosdeMQTT.enviaMQTT(sensor)){
            return SUCESSO;
        }
        else{
            return FALHA;
        }

    }

    @RequestMapping("/enviaDadosSensorLuminosidadeMQTT")
    public String enviaDadosSensorLuminosidadeMQTT(){
        Sensor sensor = new Sensor(SENSOR_LUMINOSIDADE, new ArrayList<>(), "Sem unidade","MQTT");
        servicosDeSensores.geraLuminosidadeUmDia(sensor);
        if(servicosdeMQTT.enviaMQTT(sensor)){
            return SUCESSO;
        }
        else{
            return FALHA;
        }

    }

    @RequestMapping("/enviaDadosSensorPoluicaoMQTT")
    public String enviaDadosSensorPoluicaoMQTT(){
        Sensor sensor = new Sensor(SENSOR_POLUICAO, new ArrayList<>(), "Sem unidade","MQTT");
        servicosDeSensores.geraDadoPoluicao(sensor);
        if(servicosdeMQTT.enviaMQTT(sensor)){
            return SUCESSO;
        }
        else{
            return FALHA;
        }

    }

}
