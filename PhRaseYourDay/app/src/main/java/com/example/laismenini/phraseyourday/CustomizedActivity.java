package com.example.laismenini.phraseyourday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.laismenini.phraseyourday.R;

import java.util.ArrayList;
import java.util.List;

public class CustomizedActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customized);

        // Fills up the layout spinner with categories names using the adapter
        String[] categoriesNames = new String[ Data.categories.size() ];
        for ( int i = 0; i < Data.categories.size(); i++ )
        {
            categoriesNames[i] = Data.categories.get( i ).getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, categoriesNames );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner sItems = (Spinner) findViewById(R.id.customized_category_spinner );
        sItems.setAdapter(adapter);


        final Button sendButton = (Button) findViewById(R.id.customized_button_send);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Gets the reference to the layout elements
                EditText phraseTextView = (EditText) findViewById( R.id.customized_phrase_input );
                EditText authorTextView = (EditText) findViewById( R.id.customized_author_input );
                int selectedCategoryIndex = sItems.getSelectedItemPosition();

                Phrase customPhrase = new Phrase( phraseTextView.getText().toString(), authorTextView.getText().toString() );
                Data.categories.get( selectedCategoryIndex ).phrases.add( customPhrase );



                // Tries to save the data
                boolean savedSuccessfully = true;
                try{
                    Data.saveData( view.getContext() );
                }catch (Exception e ){
                    savedSuccessfully = false;
                    e.printStackTrace();
                }

                if ( savedSuccessfully )
                    Toast.makeText( view.getContext(), "Thank you! You're awesome!", Toast.LENGTH_LONG ).show();
                else
                    Toast.makeText( view.getContext(), "Error while saving, please try again.", Toast.LENGTH_LONG ).show();

                startActivity(new Intent(view.getContext(), CategoryActivity.class));
                finish();
            }
        };

        sendButton.setOnClickListener(listener);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.customized, menu);
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
