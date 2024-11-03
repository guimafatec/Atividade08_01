package br.edu.fateczl.atividade08_01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.edu.fateczl.atividade08_01.model.Ingresso;
import br.edu.fateczl.atividade08_01.model.IngressoVip;

public class InfoActivity extends AppCompatActivity {
    private TextView tvOut;
    private Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        tvOut = findViewById(R.id.tvOut);
        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(op -> back());
        
        show();
    }

    private void back() {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
        this.finish();
    }

    private void show() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String identificador = bundle.getString("identificador");
        float valorIngresso = bundle.getFloat("valor");
        boolean vip = bundle.getBoolean("vip");

        if (!vip) {
            Ingresso ingresso = new Ingresso(valorIngresso, identificador);
            tvOut.setText(ingresso.getSaida());
        } else {
            String funcao = bundle.getString("funcao");
            IngressoVip ingresso = new IngressoVip(valorIngresso, identificador, funcao);
            tvOut.setText(ingresso.getSaida());
        }
    }
}