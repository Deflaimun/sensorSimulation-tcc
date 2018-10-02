package ServicosExternos;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace = "http://envioabadi.servicos.visao.custos.aci.ipp/", portName = "iniciarSensorPort", serviceName = "iniciarSensor")
public class iniciarSensorDelegate {

    private EnviaSensor enviaSensor;

    public iniciarSensorDelegate (){ this.enviaSensor = new EnviaSensor();}

    @WebMethod
    public void iniciaSensorTemperatura (){this.enviaSensor.enviaDadosSensor();}


}
