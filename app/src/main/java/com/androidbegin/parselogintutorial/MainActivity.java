package com.androidbegin.parselogintutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.parse.ParseAnonymousUtils;
import com.parse.ParseUser;

public class MainActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_login_opt);
		// Determine whether the current user is an anonymous user

		if (ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())) {
			Intent intent = new Intent(MainActivity.this,
					LoginOpt.class);
			startActivity(intent);
			finish();
		} else {
			// If current user is NOT anonymous user
			// Get current user data from Parse.com
			ParseUser currentUser = ParseUser.getCurrentUser();
			boolean verify=currentUser.getBoolean("emailVerified");
			if(verify){
				if (currentUser != null) {
					// Send logged in users to Welcome.class
					Intent intent = new Intent(MainActivity.this, Welcome.class);
					startActivity(intent);
					finish();
				} else {
					Intent intent = new Intent(MainActivity.this,
							Login.class);
					startActivity(intent);
					finish();
				}
			}
			else {
				Intent intent = new Intent(MainActivity.this,
						Login.class);
				startActivity(intent);
				finish();
			}

		}
	}
}
