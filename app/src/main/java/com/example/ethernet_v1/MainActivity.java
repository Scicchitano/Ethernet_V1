package com.example.ethernet_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,eIP,ePort;
    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.et1);
        spinner1 = (Spinner)findViewById(R.id.spinner1);

        String [] opciones = {"Casa","Aula1","Aula2","Aula3"}; //Defino un vector de string

        // Linkeo el array opciones a un spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_uno, opciones);
        //El spinner que cree arriba lo linkeo al spinner del acivity
        spinner1.setAdapter(adapter);

        //eIP = (EditText) findViewById(R.id.etIP);
        //ePort = (EditText) findViewById(R.id.etPort);
    }


    public void sendON (View v){
        MessageSender messageSender = new MessageSender();


        String seleccion = spinner1.getSelectedItem().toString(); //Guardo en seleccion el item seleccionado en el spinner

        if (seleccion.equals("Casa")){ //.equals compara el argumento con la variable, osea se fija si el valor de seleccion es "sumar"
            messageSender.execute("ON","192.168.0.122","1234");
        }else if(seleccion.equals("Aula1")){
            messageSender.execute("ON","192.168.0.122","123");
        }else if(seleccion.equals("Aula2")){
            messageSender.execute("ON","192.168.0.122","456");
        }else if(seleccion.equals("Aula3")){
            messageSender.execute("ON","192.168.0.122","789");
        }

    }

    public void sendOFF (View v) {
        MessageSender messageSender = new MessageSender();


        String seleccion = spinner1.getSelectedItem().toString(); //Guardo en seleccion el item seleccionado en el spinner

        if (seleccion.equals("Casa")) { //.equals compara el argumento con la variable, osea se fija si el valor de seleccion es "sumar"
            messageSender.execute("OFF", "192.168.0.122", "1234");
        } else if (seleccion.equals("Aula1")) {
            messageSender.execute("OFF", "192.168.0.122", "123");
        } else if (seleccion.equals("Aula2")) {
            messageSender.execute("OFF", "192.168.0.122", "456");
        } else if (seleccion.equals("Aula3")) {
            messageSender.execute("OFF", "192.168.0.122", "789");

        }
    }

}