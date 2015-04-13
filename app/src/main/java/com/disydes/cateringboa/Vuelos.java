package com.disydes.cateringboa;

/**
 * Created by f on 12/04/2015.
 */
public class Vuelos {

    private String NroVuelo;
    private String Origen;
    private String Destino;

    public Vuelos(String nroVuelo, String origen, String destino) {
        NroVuelo = nroVuelo;
        Origen = origen;
        Destino = destino;
    }

    public String getNroVuelo() {
        return NroVuelo;
    }

    public String getOrigen() {
        return Origen;
    }

    public String getDestino() {
        return Destino;
    }
}
