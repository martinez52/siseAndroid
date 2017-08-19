package pe.edu.sise.actcontrolentradacine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ActMainActivity extends AppCompatActivity {

    EditText editNombres,editApellidos,editedad;
    CheckBox chkda,chkdni;
    RadioButton rbtsi,rbtno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_activity_main);

        editNombres=(EditText)findViewById(R.id.editNombres);
        editApellidos=(EditText)findViewById(R.id.editApellidos);
        editedad=(EditText)findViewById(R.id.editEdad);
        chkda=(CheckBox)findViewById(R.id.chkDocAutorizacion);
        chkdni=(CheckBox)findViewById(R.id.chkDni);
        rbtsi=(RadioButton)findViewById(R.id.rbtsi);
        rbtno=(RadioButton)findViewById(R.id.rbtno);



    }
    public void validarIngreso(View view){
        String nombres=editNombres.getText().toString();
        String apellidos=editApellidos.getText().toString();
        int edad=Integer.parseInt(editedad.getText().toString());

        if(edad<18){
            if(chkda.isChecked()){
                Toast.makeText(this,"Puede Ingresar",Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(this,"Requiere un documento",Toast.LENGTH_SHORT).show();
            }

        }else{
            if(chkdni.isChecked()&& rbtsi.isChecked()){
                Toast.makeText(this, "Ingreso a la Sala", Toast.LENGTH_SHORT).show();
            }


    }

    }
}
