package com.example.laismenini.phraseyourday;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by laismenini on 26/03/15.
 */
public class Data
{
    private static final String filename = "phrase_your_day_data.bin";
    public static ArrayList<Category> categories;
    public static Category selectedCategory;


    public static void initData( Context context )
    {
        Data.categories = new ArrayList<Category>();



        // Tries to load the data from a file
        try {
            Data.categories = Data.loadData( context );
            System.out.println("Data loaded from file");
        } catch (Exception e) {
            // Loads predefined data if an error occurs
            Data.loadPredefinedData();
            e.printStackTrace();
        }

        // If no data was loaded, then get it from predefined data (Protection).
        if ( Data.categories.size() == 0 ) {
            Data.loadPredefinedData();
        }
    }

    public static ArrayList<Category> loadData( Context context ) throws Exception
    {
        FileInputStream fis = context.openFileInput( Data.filename );
        ObjectInputStream is = new ObjectInputStream(fis);
        ArrayList<Category> categories = (ArrayList<Category>) is.readObject();
        is.close();
        fis.close();
        return categories;
    }

    public static void saveData( Context context ) throws Exception
    {
        FileOutputStream fos = context.openFileOutput( Data.filename , Context.MODE_PRIVATE);
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject( Data.categories );
        os.close();
        fos.close();
    }

    public static void loadPredefinedData()
    {
        // Adds the categories to the categories array.
        Data.categories.add(new Category("Missing Home"));
        Data.categories.add(new Category("Feeling Frustrated"));
        Data.categories.add(new Category("Needing a Challenge"));
        Data.categories.add(new Category("Jedi Mode"));

        // Adds phrases to the category 0 ( Missing Home )
        Data.categories.get(0).phrases.add(new Phrase("Be shapeless. Be water, my friend.", "Bruce Lee"));
        Data.categories.get(0).phrases.add(new Phrase("Home is wherever my dogs are.", "Skinner Lane"));
        Data.categories.get(0).phrases.add(new Phrase("A man's homeland is wherever he prospers.", "Aristophanes"));
        Data.categories.get(0).phrases.add(new Phrase("Whether it is a friend or a romantic relationship, we try to make ourselves at home in somebody else's home.", "Skinner Lane"));
        Data.categories.get(0).phrases.add(new Phrase("Ya gotta live somewhere, but as you GET to live somewhere.", "John Green"));
        Data.categories.get(0).phrases.add(new Phrase("My home is not a place, it is people.", "Lois McMaster Bujold"));
        Data.categories.get(1).phrases.add(new Phrase("Patience you must have, my young Padawan.", "Yoda"));
        Data.categories.get(1).phrases.add(new Phrase("Be shapeless. Be water, my friend.", "Bruce Lee"));
        Data.categories.get(1).phrases.add(new Phrase("To hell with Circumstances; I create opportunities.", "Bruce Lee"));
        Data.categories.get(1).phrases.add(new Phrase("The universe is not hostile, nor yet is it friendly. It is simply indifferent.", "J.H. Holmes"));
        Data.categories.get(1).phrases.add(new Phrase("I'm not in this world to live up to your expectations and you're not in this world to live up to mine.", "Bruce Lee"));
        Data.categories.get(1).phrases.add(new Phrase("It's not that some people have willpower and some do not, it's that some people are ready to change and others are not.", "James Gordon"));
        Data.categories.get(1).phrases.add(new Phrase("All fixed set patterns are incapable of adaptability, of pliability, only offer a better cage The truth is outside of all fixed patterns.", "Bruce Lee"));
        Data.categories.get(2).phrases.add(new Phrase("Good ideas are not ADOPTED automatically. They must be driven into practice with courageous patience.", "Hyman Rickover"));
        Data.categories.get(2).phrases.add(new Phrase("Knowing is not enough, we must apply. Willing is not enough, we must do.", "Bruce Lee"));
        Data.categories.get(2).phrases.add(new Phrase("Any one who afflicts the human race with ideas must be prepare to see them misunderstood.", "H. L. Mencken"));
        Data.categories.get(2).phrases.add(new Phrase("Always be yourself, express yourself, have faith in yourself, do not go out and look for a successful personality and duplicate it.", "Bruce Lee"));
        Data.categories.get(2).phrases.add(new Phrase("Do not fear failure. Not failure, but low aim, is the crime. In great attempts it is glorious even to fail.", "Bruce Lee"));
        Data.categories.get(3).phrases.add(new Phrase("Patience you must have, my young Padawan.", "Yoda"));
        Data.categories.get(3).phrases.add(new Phrase("Train yourself to let go of everything you fear to lose.", "Yoda"));
        Data.categories.get(3).phrases.add(new Phrase("A wise man can learn more from a foolish question than a fool can learn from a wise answer.", "Bruce Lee"));
        Data.categories.get(3).phrases.add(new Phrase("Fear is the path to the dark side. Fear leads to anger. Anger leads to hate. Hate leads to suffering.", "Yoda"));
        Data.categories.get(3).phrases.add(new Phrase("Notice that the stiffest tree is most easily cracked, while the bamboo or willow survives by bending with the wind.", "Yoda"));
        Data.categories.get(3).phrases.add(new Phrase("[Luke:] I can not believe it. [Yoda:] That is why you fail.", "Star Wars"));
    }
}
