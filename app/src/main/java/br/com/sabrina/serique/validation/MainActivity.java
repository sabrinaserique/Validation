package br.com.sabrina.serique.validation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.sabrina.serique.validation.util.EditMask;
import br.com.sabrina.serique.validation.util.ValidarCPF;
import br.com.sabrina.serique.validation.util.ValidarData;
import br.com.sabrina.serique.validation.util.ValidarSenha;

public class MainActivity extends AppCompatActivity {
    private EditText editTextCPF, editTextNasc, editTextSenha;
    private Button btCPF, btNasc, btSenha;
    String cpf;
    String data;
    String senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCPF = (EditText)findViewById(R.id.edtCPF);
        editTextNasc = (EditText) findViewById(R.id.edtNasc);
        editTextSenha = (EditText) findViewById(R.id.edtSenha);
        btCPF = (Button) findViewById(R.id.btCPF);
        btNasc = (Button) findViewById(R.id.btNasc);
        btSenha = (Button) findViewById(R.id.btSenha);

        editTextCPF.addTextChangedListener(EditMask.insert(EditMask.CPF_MASK, editTextCPF));
        editTextNasc.addTextChangedListener(EditMask.insert(EditMask.NASC_MASK, editTextNasc));

        btCPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cpf = editTextCPF.getText().toString();

                if(cpf.length()>0) {
                    if (ValidarCPF.validar(cpf)) {
                        Toast.makeText(getApplicationContext(), R.string.msgValCPF, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), R.string.msgInvCPF, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        btNasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data =   editTextNasc.getText().toString();

                if(data.length()>0) {
                    if (ValidarData.validar(data)) {
                        Toast.makeText(getApplicationContext(), R.string.msgValData, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), R.string.msgInvData, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        btSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cpf = editTextCPF.getText().toString();
                data =   editTextNasc.getText().toString();
                senha =   editTextSenha.getText().toString();

                if(cpf.length()>0 && data.length()>0 && senha.length()>0){
                    if(ValidarSenha.validar(senha, cpf, data)){
                        Toast.makeText(getApplicationContext(), R.string.msgValSenha, Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(), R.string.msgInvSenha, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}
