package com.example.cisco.siselogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG=LoginActivity.class.getName();

    EditText _edtUserLogin ;
    EditText _edtUserPassword ;
    Button _btnLogin ;

    /**
     * se crea un activity
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _edtUserLogin =(EditText)findViewById(R.id.edtUserLogin);
        _edtUserPassword =(EditText)findViewById(R.id.edtPassword);
        _btnLogin=(Button)findViewById(R.id.btnLogin);

        SharedPreferences misPrefencias =getSharedPreferences("datos", Context.MODE_PRIVATE);

        _edtUserLogin.setText(misPrefencias.getString("login",null));
        _edtUserPassword.setText(misPrefencias.getString("password",null));

    }

    /**
     * Redicciona al metodo Bienvenido
     * @param v
     */

    public void goBienvenido(View v){

        Log.d(TAG,"Me dirijo a la pantalla de Bienvenida..");

         String login = _edtUserLogin.getText().toString();
        String password = _edtUserPassword.getText().toString();
        if (validar(login,password)){


        }

        Intent intent= new Intent(this,BienvenidoActivity.class);
        startActivity(intent);

    }

    public boolean validar (String login ,String password) {
        boolean rpta = false;
        String mensaje = "";

        if ("".equals(login)) {
            mensaje = "Ingrese Login";
        } else if ("".equals(password)) {
            mensaje = "Ingrese PASS";
        } else if ("dporras".equals(login) && "123".equals(password)) {
            Intent intent = new Intent(this, BienvenidoActivity.class);
            startActivity(intent);

            SharedPreferences misPrefencias =getSharedPreferences("datos", Context.MODE_PRIVATE);
           SharedPreferences.Editor editor =misPrefencias.edit();
            editor.putString("login", login);
            editor.putString("password", password);
            editor.commit();
        }



        if (!rpta) {
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
        }
        return rpta;
    }


    public void goNuevo(View view){
        Log.d(TAG,"Me dirijo a la pantalla de Registro..");
        Intent intent= new Intent(this,CreateUserActivity.class);
        startActivity(intent);

    }


}
