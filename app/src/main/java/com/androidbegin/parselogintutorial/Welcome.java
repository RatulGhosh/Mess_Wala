package com.androidbegin.parselogintutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.parse.ParseUser;


public class Welcome extends Activity {
	
	// Declare Variable
	ImageButton menuButtton;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		ParseUser currentUser = ParseUser.getCurrentUser();

		final String struser = currentUser.get("Name").toString();
		String mail=currentUser.getEmail().toString();
		final String hostel=currentUser.get("Hostel").toString();
		String enroll=currentUser.get("Enrollment").toString().toUpperCase();
		String room_no=currentUser.get("Room_No").toString();
		String mobile=currentUser.get("Mobile_No").toString();
		TextView txtuser = (TextView) findViewById(R.id.txtuser);
		TextView h=(TextView)findViewById(R.id.hostel);
		TextView enrol=(TextView)findViewById(R.id.enroll);
		TextView email=(TextView)findViewById(R.id.e_mail);
		TextView mobile_no=(TextView)findViewById(R.id.mobile);
		TextView  room=(TextView)findViewById(R.id.room);
		TextView  noti=(TextView)findViewById(R.id.noti);
		menuButtton=(ImageButton)findViewById(R.id.menu);

		email.setText("E-mail : "+mail);
		txtuser.setText("Username : " + struser);
		h.setText("Hostel : "+hostel);
		enrol.setText("Enrollment ID : "+enroll);
		h.setText("Hostel : " + hostel);
		room.setText("Room No : "+room_no);
		mobile_no.setText("Mobile No : "+mobile);
        noti.setText("Notification : "+CustomPushNotification.message_noti);

		//Toast.makeText(this,CustomPushNotification.message_noti,Toast.LENGTH_LONG).show();

		menuButtton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(Welcome.this,Menu.class);
				intent.putExtra("Hostel", hostel);
				startActivity(intent);
			}
		});

	}

	@Override
	protected void onPause() {
		super.onPause();
		finish();
	}
}