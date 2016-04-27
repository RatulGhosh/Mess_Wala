package com.androidbegin.parselogintutorial;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParsePush;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class ParseApplication extends Application {


    private static String TAG = ParseApplication.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
 
        // Add your initialization code here
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "AqlGYPXUjLaUp5tkit5WBgsdo5heAaF9HrYP06np", "wQfx9rpR43AjEDu15jJuNUcC9hK2SBNrj7ZUyHuh");


        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this
        // line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);
        ParsePush.subscribeInBackground("Mess", new SaveCallback() {
            @Override
            public void done(ParseException e) {
                Log.e(TAG, "Successfully subscribed to Parse!");
            }


        });
    }

}