package com.tekseker.changedevicelanguage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.Locale;

/**
 * Created by mustafa.urgupluoglu on 5/10/18.
 */
public class SecondActivity extends AppCompatActivity {

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        Locale languageType = LanguageUtil.getCurrentLocale(newBase);
        super.attachBaseContext(LanguageUtil.changeLanguage(newBase, languageType));
    }


    public void setLanguage(View view){
        if(view.getId() == R.id.button_english){
            LanguageUtil.changeLanguage(this, Locale.ENGLISH);
            preferences.edit().putString("LANGUAGE", "en").apply();
        }else if(view.getId() == R.id.button_turkish){
            LanguageUtil.changeLanguage(this, new Locale("tr"));
            preferences.edit().putString("LANGUAGE", "tr").apply();
        }else if(view.getId() == R.id.button_chinese){
            LanguageUtil.changeLanguage(this, Locale.CHINESE);
            preferences.edit().putString("LANGUAGE", "zh").apply();
        }

        recreate();
    }
}
