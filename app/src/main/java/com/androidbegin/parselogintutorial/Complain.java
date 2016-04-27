package com.androidbegin.parselogintutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.ArrayList;

public class Complain extends Activity implements AdapterView.OnItemSelectedListener{

    EditText complain;
    Button submit;
    Spinner cat;
    String what;
    String hostel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);
        cat=(Spinner)findViewById(R.id.cat);
        submit=(Button)findViewById(R.id.submit);
        complain=(EditText)findViewById(R.id.com);
        Intent intent=getIntent();
        hostel=intent.getStringExtra("Hostel");
        cat.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ParseUser  parseUser=ParseUser.getCurrentUser();
        ArrayList<String> category = new ArrayList<String>();
        category.add("Complain");
        category.add("Feedback");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, category);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        cat.setAdapter(dataAdapter);
        final String email=parseUser.getEmail();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String text=complain.getText().toString();
                ParseObject parseObject=new ParseObject("Complain");
                parseObject.put("Category", what);
                parseObject.put("Email",email);
                parseObject.put("complain", text);
                parseObject.saveInBackground();
                Intent intent=new Intent(Complain.this,Menu.class);
                intent.putExtra("Hostel", hostel);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        what=parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
