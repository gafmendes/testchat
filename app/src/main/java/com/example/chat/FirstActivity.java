package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    static final String TAG = FirstActivity.class.getSimpleName();


    private EditText editText = null;

    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Log.i(TAG, "onCreate");

        editText = findViewById(R.id.etEntradaDeTexto1);



    }

    public void enviarMensagem(View view) {
        String mensagemCapturada = editText.getText().toString();

        Intent mensageiro = new Intent(this, SecondActivity.class);
        mensageiro.putExtra("IDENTIFICADOR_DA_MENSAGEM_ENVIADA", mensagemCapturada);
        startActivityForResult(mensageiro, SECOND_ACTIVITY_REQUEST_CODE);

    }

    // This method is called when the second activity finishes
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
    super.onActivityResult(requestCode, resultCode, data);

        // Check that it is the SecondActivity with an OK result
    if(requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
        if(resultCode == RESULT_OK){
            // get String data from Intent
            String returnString = data.getStringExtra(Intent.EXTRA_TEXT);

            // set text view with string
            TextView textView = (TextView) findViewById(R.id.tvMensagemRecebida2);
            textView.setText(returnString);
        }
    }
    }

}