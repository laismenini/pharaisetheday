package com.example.laismenini.phraseyourday;

import java.io.Serializable;

/**
 * Created by laismenini on 25/03/15.
 */
public class Phrase implements Serializable {
    String phraseText;
    String authorText;

    public void setAuthorText(String authorText) {
        this.authorText = authorText;
    }

    public void setPhraseText(String phraseText) {
        this.phraseText = phraseText;
    }

    public String getAuthorText() {
        return authorText;
    }

    public String getPhraseText() {
        return phraseText;
    }

    public Phrase (String phraseText, String authorText){
        setAuthorText(authorText);
        setPhraseText(phraseText);
    }
}
