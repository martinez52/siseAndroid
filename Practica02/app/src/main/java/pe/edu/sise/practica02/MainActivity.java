package pe.edu.sise.practica02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editn1,editn2;
    int suma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editn1=(EditText)findViewById(R.id.edtn1);
        editn2=(EditText)findViewById(R.id.edtn2);
    }


    public void CalculaSuma(View view){

        int n1=Integer.parseInt(editn1.getText().toString());
        int n2=Integer.parseInt(editn2.getText().toString());
        suma=n1+n2;

        Toast.makeText(this, "Resultado, "+suma, Toast.LENGTH_LONG).show();
    }
    public void Limpiar(View view){
        editn1.setText("");
        editn2.setText("");

    }
}
