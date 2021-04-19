package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private EditText editText1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String mensagemRecebida = getIntent().getStringExtra("IDENTIFICADOR_DA_MENSAGEM_ENVIADA");


        TextView textView = findViewById(R.id.tvMensagemRecebida2);
        textView.setText(mensagemRecebida);



    }

    public void responderMensagem(View view) {
        // Get the text from the EditText
        EditText editText1 = (EditText) findViewById(R.id.etEntradaDeTexto2);
        String stringToPassBack = editText1.getText().toString();

        // Put the String to pass back into an Intent and close this activity
        Intent intent = new Intent();
        intent.putExtra(Intent.EXTRA_TEXT, stringToPassBack);
        setResult(RESULT_OK, intent);
        finish();
    }
}