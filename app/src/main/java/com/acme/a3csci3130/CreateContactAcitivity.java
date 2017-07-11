package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField, provinceField;
    private MyApplicationData appState;
    private EditText businessNumberField;
    private EditText primaryBusinessField;
    private EditText addressField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);
        provinceField = (EditText) findViewById(R.id.province);
        businessNumberField = (EditText) findViewById(R.id.business_number);
        primaryBusinessField = (EditText) findViewById(R.id.primary_business);
        addressField = (EditText) findViewById(R.id.address);

    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String province = provinceField.getText().toString();
        int businessNumber = Integer.parseInt(businessNumberField.getText().toString());
        String primaryBusiness = primaryBusinessField.getText().toString();
        String address = addressField.getText().toString();
        Business person = new Business(personID, address, name, province, businessNumber, primaryBusiness);

        appState.firebaseReference.child(personID).setValue(person);
        finish();
    }
}
