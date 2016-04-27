package com.androidbegin.parselogintutorial;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.ArrayList;

/**
 * Created by Rohit on 08-Apr-16.
 */
public class Register extends Activity implements AdapterView.OnItemSelectedListener{
    EditText name,email,roll_no,phone,password,room_no,c_password;
    Spinner hostel;
    Button register;
    String s_name;
    String s_email;
    String s_roll_no;
    String s_phone;
    String s_password;
    String s_room_no;
    String s_hostel;
    String sc_password;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginsignup);
        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.e_mail);
        roll_no=(EditText)findViewById(R.id.enrollment);
        password=(EditText)findViewById(R.id.pass);
        c_password=(EditText)findViewById(R.id.con_pass);
        phone=(EditText)findViewById(R.id.mobile);
        hostel=(Spinner)findViewById(R.id.hostel);
        room_no=(EditText)findViewById(R.id.room);
        register=(Button)findViewById(R.id.register_button);

        hostel.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        ArrayList<String> hostels = new ArrayList<String>();
        hostels.add("BH1");
        hostels.add("BH2");
        hostels.add("BH3");
        hostels.add("BH4");
        hostels.add("GH1");
        hostels.add("GH2");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, hostels);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        hostel.setAdapter(dataAdapter);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Retrieve the text entered from the EditText
                s_name = name.getText().toString().trim();
                s_password = password.getText().toString().trim();
                s_email=email.getText().toString().trim();
                s_roll_no=roll_no.getText().toString().trim();
                s_phone=phone.getText().toString().trim();
                sc_password=c_password.getText().toString().trim();
                s_room_no=room_no.getText().toString();
                final String e_mail_part[]=new String[2];
                int i=0;
                for (String retval: s_email.split("@", 2)){
                    e_mail_part[i]=retval;
                    i++;
                }
                // Force user to fill up the form
                if (s_name.equals("") || s_password.equals("")||s_email.equals("")||s_roll_no.equals("")||s_phone.equals("")||sc_password.equals("")||s_hostel.equals("")) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setTitle("Alert");

                    // set dialog message
                    alertDialogBuilder
                            .setMessage("Please complete the registration form!!!")
                            .setCancelable(false)
                            .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    name.requestFocus();
                                    dialog.cancel();
                                }
                            });


                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();


                }
                else
                if(!e_mail_part[1].equals("iiita.ac.in")){
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setTitle("Alert");

                    // set dialog message
                    alertDialogBuilder
                            .setMessage("Please enter College e-mail!!!")
                            .setCancelable(false)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    email.setText("");
                                    dialog.cancel();
                                }
                            });


                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();
                }else
                if(!e_mail_part[0].equalsIgnoreCase(s_roll_no)){
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setTitle("Alert");

                    // set dialog message
                    alertDialogBuilder
                            .setMessage("Invalid E-mail ID !!!")
                            .setCancelable(false)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    email.setText("");
                                    dialog.cancel();
                                }
                            });


                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();
                }else
                if(!s_password.equals(sc_password)){
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                        alertDialogBuilder.setTitle("Alert");

                        // set dialog message
                        alertDialogBuilder
                                .setMessage("Password doesn't match!!!")
                                .setCancelable(false)
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        password.setText("");
                                        c_password.setText("");
                                        password.requestFocus();
                                        dialog.cancel();
                                    }
                                });


                        // create alert dialog
                        AlertDialog alertDialog = alertDialogBuilder.create();

                        // show it
                        alertDialog.show();

                } else if(s_phone.length()!=10){
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setTitle("Alert");

                    // set dialog message
                    alertDialogBuilder
                            .setMessage("Enter a Valid Phone No.")
                            .setCancelable(false)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    phone.setText("");
                                    dialog.cancel();
                                }
                            });


                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();

                }
                else{
                    // Save new user data into Parse.com Data Storage
                    final Intent intent=new Intent(Register.this,Login.class);
                    ParseUser user = new ParseUser();
                        user.put("Name",s_name);
                        user.setUsername(s_email);
                        user.setPassword(s_password);
                        user.setEmail(s_email);
                    user.put("Hostel", s_hostel);
                    user.put("Enrollment", s_roll_no);
                    user.put("Mobile_No",s_phone);
                    user.put("Room_No", s_room_no);
                    user.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                                alertDialogBuilder.setTitle("Success");

                                // set dialog message
                                alertDialogBuilder
                                        .setMessage("Successfully Registered...Verify Your E mail!!!")
                                        .setCancelable(false)
                                        .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog,int id) {
                                                startActivity(intent);
                                                dialog.cancel();
                                            }
                                        });


                                // create alert dialog
                                AlertDialog alertDialog = alertDialogBuilder.create();

                                // show it
                                alertDialog.show();

                            } else {

                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                                alertDialogBuilder.setTitle("Alert");

                                // set dialog message
                                alertDialogBuilder
                                        .setMessage("Registration Failed...Check Internet Connectivity!!!")
                                        .setCancelable(false)
                                        .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog,int id) {
                                                name.setText("");
                                                roll_no.setText("");
                                                email.setText("");
                                                password.setText("");
                                                c_password.setText("");
                                                room_no.setText("");
                                                phone.setText("");
                                                dialog.cancel();
                                            }
                                        });


                                // create alert dialog
                                AlertDialog alertDialog = alertDialogBuilder.create();

                                // show it
                                alertDialog.show();
                            }
                        }
                    });


                }

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        s_hostel = parent.getItemAtPosition(position).toString();
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
