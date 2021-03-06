package servicos;

import modelo.Sensor;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

import static util.Constantes.*;

@Service
public class ServicosDeMQTT {

    private static MqttClient sampleClient;
    private final AtomicInteger contador = new AtomicInteger();

    public ServicosDeMQTT() {
        MemoryPersistence persistence = new MemoryPersistence();
        MqttConnectOptions connOpts;

        try {
            sampleClient = new MqttClient(BROKER, CLIENTID, persistence);
            connOpts = new MqttConnectOptions();
            connOpts.setUserName(CLIENTID);
            connOpts.setPassword(PASSWORDBROKER);
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: " + BROKER);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }

    public boolean enviaMQTT(Sensor sensor) {
        String topic = "sensor/" + sensor.getTipo()
                + "/" + contador.getAndIncrement();
        int qos = 2;

        try {
            MqttMessage message;

            for (int i = 0; i < sensor.getData().size(); i++) {
                message = new MqttMessage(sensor.getData().get(i).getBytes());
                message.setQos(qos);
                sampleClient.publish(topic, message);
            }
            return true;
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
            return false;
        } catch (Exception e) {
            return false;

        }
    }
}
