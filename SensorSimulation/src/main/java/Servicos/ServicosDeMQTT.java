package Servicos;

import Modelo.Sensor;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.stereotype.Service;

@Service
public class ServicosDeMQTT {

    public boolean enviaMQTT(Sensor sensor){

        String topic        = "MQTT Examples";
        String content      = "Message from MqttPublishSample";
        int qos             = 2;
        String broker       = "tcp://m15.cloudmqtt.com:19300";
        String clientId     = "bqsluijc";
        MemoryPersistence persistence = new MemoryPersistence();
        char[] password = {	'A','y','C','B','m','r','-','O','F','t','J','4'};

        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setUserName(clientId);
            connOpts.setPassword(password);
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: "+content);
            MqttMessage message;

            for (int i = 0; i < sensor.getData().size(); i++) {
                message = new MqttMessage(sensor.getData().get(i).getBytes());
                message.setQos(qos);

                sampleClient.publish(topic, message);
                System.out.println("Message published");
            }
            sampleClient.disconnect();
            System.out.println("Disconnected");
            System.exit(0);
            return true;
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
            return false;
        }
    }
}
