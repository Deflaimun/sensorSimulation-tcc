package ServicosExternos;

public class IniciaSensor {

    private EnviaSensor enviaSensor;

    public String iniciar(){
        enviaSensor = new EnviaSensor();
        return this.enviaSensor.enviaDadosSensor();

    }
}
