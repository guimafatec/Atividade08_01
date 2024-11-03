package br.edu.fateczl.atividade08_01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.edu.fateczl.atividade08_01.model.Ingresso;
import br.edu.fateczl.atividade08_01.model.IngressoVip;

public class MainActivity extends AppCompatActivity {
    private EditText etIdentificador;
    private EditText etValorIngresso;
    private EditText etFuncao;
    private CheckBox cbxVip;
    private Button btnCalcular;
    private Ingresso ingresso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etIdentificador = findViewById(R.id.etIdentificador);
        etValorIngresso = findViewById(R.id.etValorIngresso);
        etFuncao = findViewById(R.id.etFuncao);
        cbxVip = findViewById(R.id.cbxVip);
        cbxVip.setChecked(false);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(op -> calc());
    }

    private void calc() {
        String identificador = etIdentificador.getText().toString();
        float valorIngresso = Float.parseFloat(etValorIngresso.getText().toString());
        boolean vip = cbxVip.isChecked();
        Bundle bundle = new Bundle();
        bundle.putString("identificador", identificador);
        bundle.putFloat("valor", valorIngresso);
        bundle.putBoolean("vip", vip);
        if (vip) {
            String funcao = etFuncao.getText().toString();
            bundle.putString("funcao", funcao);
        }
        troca(bundle);
    }

    private void troca(Bundle bundle) {
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtras(bundle);
        this.startActivity(intent);
        this.finish();
    }
}