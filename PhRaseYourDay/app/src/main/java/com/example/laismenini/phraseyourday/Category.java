package com.example.laismenini.phraseyourday;

import android.app.Activity;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by laismenini on 25/03/15.
 */
public class Category implements Serializable
{
    String name;
    public ArrayList<Phrase> phrases;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Category ( String name )
    {
        setName( name );
        this.phrases = new ArrayList<Phrase>();
    }

}

