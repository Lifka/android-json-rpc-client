package com.red.lifka.rpc_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    private Button start_client;
    private EditText val1;
    private EditText val2;
    private TextView result_value;
    private Button launch;

    private Client client = null;
    private double x;
    private double y;
    private double result = 0.0;
    private int operation = 0;

    private String host = "localhost";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazar objetos del layout
        start_client = (Button)findViewById(R.id.startclient);
        val1 = (EditText)findViewById(R.id.value1);
        val2 = (EditText)findViewById(R.id.value2);
        result_value = (TextView)findViewById(R.id.resultvalue);
        launch = (Button)findViewById(R.id.launch);
        launch.setEnabled(false);

        // Iniciar cliente
        start_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clase cliente abstrae el uso del cliente que ofrece la biblioteca
                client = new Client(host);

                // Ajustar layout
                start_client.setEnabled(false);
                launch.setEnabled(true);
            }
        });

        // Request
        launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los números a sumar
                x =  new Double(val1.getText().toString());
                y =  new Double(val2.getText().toString());

                // Pedir a la clase cliente que lance la operación de suamr los dos números
                result = client.launch(x, y, operation);

                // Mostrar resultado en el layout
                result_value.setText(String.valueOf(result));
            }
        });

    }
}
