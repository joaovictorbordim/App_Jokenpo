package com.example.app_jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //configuração de itens clicados.
    public void selecionadoPedra(View view){
        this.opcaoSelecionado("pedra");
    }
    public void selecionadPapel (View view){
        this.opcaoSelecionado("papel");
    }
    public void selecionadoTesoura (View view){
        this.opcaoSelecionado("tesoura");
    }
    public void opcaoSelecionado (String opcaoUser){

        ImageView imagemResultado = findViewById(R.id.selecaoApp);
        TextView textresult = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);//0,1,2
        String[] opcoes = {"pedra","papel","tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp){
            case "pedra" : imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel" : imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura" : imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if( opcaoApp == "tesoura" && opcaoUser == "papel" ||
                opcaoApp == "papel" && opcaoUser == "pedra" ||
                    opcaoApp == "pedra" && opcaoUser == "tesoura"){
            textresult.setText("Você PERDEUUU ¬¬ ");
        }else if (  opcaoUser == "tesoura" && opcaoApp == "papel" ||
                        opcaoUser == "papel" && opcaoApp == "pedra" ||
                            opcaoUser == "pedra" && opcaoApp == "tesoura"){
            textresult.setText( "VOCÊ GANHOOOOUUUUU");
        }else {
            textresult.setText("Empate técnico, jogue novamente !");
        }

        System.out.println("Item selecionado: " +opcaoApp);

    }
}