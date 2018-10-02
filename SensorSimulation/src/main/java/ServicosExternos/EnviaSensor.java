package ServicosExternos;

import Modelo.Sensor;
import Servicos.ServicosDeMQTT;
import Servicos.ServicosDeSensores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.util.ArrayList;

import static Util.Constantes.*;

public class EnviaSensor extends SpringBeanAutowiringSupport {

    @Autowired
    private ServicosDeSensores servicosDeSensores;

    @Autowired
    private ServicosDeMQTT servicosdeMQTT;

    public void enviaDadosSensor(){
        Sensor sensor = new Sensor(SENSOR_TEMPERATURA, new ArrayList<>(), "MQTT");
        servicosDeSensores.geraDadosDouble(sensor,BASE_TEMPERATURA_CORPO,VARIACAO_TEMPERATURA_CORPO);
        servicosdeMQTT.enviaMQTT(sensor);

    }
}
