package com.example.laismenini.phraseyourday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.laismenini.phraseyourday.R;

public class CategoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);

        // Gets the missing home button and sets its text and its listener
        final Button missingHome = (Button) findViewById(R.id.missing_home);
        missingHome.setText( Data.categories.get(0).getName() );


        // Creates the listener to the button 0
        View.OnClickListener listener0 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClicked( 0 );
            }
        };
        // Sets the listener0 to be the listener of the button 0
        missingHome.setOnClickListener(listener0);

        final Button feelingFrustrated = (Button) findViewById(R.id.feeling_frustrated);
        feelingFrustrated.setText( Data.categories.get(1).getName() );


        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClicked( 1 );
            }
        };

        feelingFrustrated.setOnClickListener(listener1);

        final Button needingChallenge = (Button) findViewById(R.id.needing_challenge);
        needingChallenge.setText( Data.categories.get(2).getName() );


        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClicked( 2 );
            }
        };

        needingChallenge.setOnClickListener(listener2);


        final Button jediMode = (Button) findViewById(R.id.jedi_mode);
        jediMode.setText( Data.categories.get(3).getName() );


        View.OnClickListener listener3 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClicked( 3 );
            }
        };

        jediMode.setOnClickListener(listener3);


        final Button customizedQuote = (Button) findViewById(R.id.customize);
        customizedQuote.setText( "Customize your own phrase" );


        View.OnClickListener listener4 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( view.getContext(), CustomizedActivity.class ) );
                finish();
            }
        };

        customizedQuote.setOnClickListener(listener4);
    }



    public void onButtonClicked( int index )
    {
        Data.selectedCategory = Data.categories.get( index );
        startActivity( new Intent( this, PhraseYourDayActivity.class ) );
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.category, menu);
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
