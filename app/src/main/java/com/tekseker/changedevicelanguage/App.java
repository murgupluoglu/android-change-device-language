package com.tekseker.changedevicelanguage;

import android.app.Application;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import java.util.Locale;

/**
 * Created by mustafa.urgupluoglu on 5/10/18.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String lang = preferences.getString("LANGUAGE", "en");
        switch (lang) {
            case "en":
                LanguageUtil.changeLanguage(this, Locale.ENGLISH);
                break;
            case "tr":
                LanguageUtil.changeLanguage(this, new Locale("tr"));
                break;
            case "zh":
                LanguageUtil.changeLanguage(this, Locale.CHINESE);
                break;
        }
    }
}
