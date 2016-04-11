package com.red.lifka.rpc_android;

import android.util.Log;

import RPC.JSONRPCClient;
import RPC.JSONRPCException;
import RPC.JSONRPCParams;

public class Client {

    private JSONRPCClient client;
    private String host;

    Client(String host){
        Log.d("Info:", "Va a enlazar"); //Debug

        // Inicializar cliente
        // create(java.lang.String uri, JSONRPCParams.Versions version Create a JSONRPCClient from a given uri
        client = JSONRPCClient.create(host, JSONRPCParams.Versions.VERSION_2);

        Log.d("Info:", "Enlazado"); //Debug
    }


    public double launch(double v1, double v2, int operation){

        // Set the connection timeout
        // setConnectionTimeout(int connectionTimeout)
        client.setConnectionTimeout(2000);
        client.setSoTimeout(2000);
        double result;

        // operation => SIEMPRE VA A SUMAR EN ESTE EJEMPLO
        // Intentamos lanzar la petición
        try {
            // Petición de Double
            result = client.callDouble("suma", v1, v2);
        } catch (JSONRPCException e) {
            e.printStackTrace();
            result = -1;
        }

        return result;
    }
}
