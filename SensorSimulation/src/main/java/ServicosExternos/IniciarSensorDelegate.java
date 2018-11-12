package ServicosExternos;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "IniciarSensorService", portName = "iniciarSensorPort")
public class IniciarSensorDelegate {

    IniciaSensor _iniciaSensor = null;

    public IniciarSensorDelegate (){  _iniciaSensor = new IniciaSensor();}

    @WebMethod
    public String iniciaSensorTemperatura (){ return _iniciaSensor.iniciar();

    }


}

