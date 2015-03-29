package com.example.laismenini.phraseyourday;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class PhraseYourDayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.phrase_your_day);

        Random r = new Random();
        int phraseIndex = r.nextInt( Data.selectedCategory.phrases.size() );

        // Pega a referência para a TextView da frase e atribui o texto
        // da primeira frase da categoria 1 à ele.
        final TextView phraselabel = (TextView) findViewById(R.id.phrasetextView);
        phraselabel.setText( Data.selectedCategory.phrases.get( phraseIndex ).getPhraseText() );

        // Pega a referência para a TextView do autor e atribui o nome
        // do autor da primeira frase da categoria 1 à ele.
        final TextView authorlabel = (TextView) findViewById(R.id.textView );
        authorlabel.setText( Data.selectedCategory.phrases.get( phraseIndex ).getAuthorText() );




        // Pega a referencia para o botão "boa frase"
        Button goodPhraseButton = (Button) findViewById(R.id.goodphrasebutton);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // The button was clicked, so update the good phrase label with a thank you note
                String goodphrase = "Thank you! Come back tomorrow for a new phrase!";
                phraselabel.setText(goodphrase);
                authorlabel.setText("");
            }
        };
        goodPhraseButton.setOnClickListener(listener);


        Button trashitButton = (Button) findViewById(R.id.trashitbutton);
        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // The button was clicked, so update the good phrase label with a thank you note
                String trashit = "Sorry! We'll make it up to you tomorrow!";
                phraselabel.setText(trashit);
                authorlabel.setText("");
            }
        };
        trashitButton.setOnClickListener(listener2);



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.phrase_your_day, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
