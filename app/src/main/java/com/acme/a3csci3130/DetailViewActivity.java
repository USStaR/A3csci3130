package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class DetailViewActivity extends Activity {

    Business receivedPersonInfo;
    private EditText nameField, provinceField, businessNuberField, primaryBusinessField, addressField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appState = ((MyApplicationData) getApplicationContext());
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Business) getIntent().getSerializableExtra("Business");

        nameField = (EditText) findViewById(R.id.detailname);
        provinceField = (EditText) findViewById(R.id.detail_province);
        businessNuberField = (EditText) findViewById(R.id.detail_business_number);
        primaryBusinessField = (EditText) findViewById(R.id.detail_primary_business);
        addressField = (EditText) findViewById(R.id.detail_address);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            provinceField.setText(receivedPersonInfo.province);
            businessNuberField.setText(String.valueOf(receivedPersonInfo.businessNumber));
            primaryBusinessField.setText(receivedPersonInfo.primaryBusiness);
            addressField.setText(receivedPersonInfo.address);
        }
    }

    /**
     * Updates the contact, sends the update to Firebase
     *
     * @param v view clicked on
     */
    public void updateContact(View v){
        receivedPersonInfo.updateData(addressField.getText().toString(),
                nameField.getText().toString(),
                provinceField.getText().toString(),
                Integer.parseInt(businessNuberField.getText().toString()),
                primaryBusinessField.getText().toString());
        Map<String, Object> postValues = receivedPersonInfo.toMap();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put(receivedPersonInfo.id, postValues);

        appState.firebaseReference.updateChildren(childUpdates);
        Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
    }

    /**
     * Erases the business from the database
     * Clears the UI to reflect this
     *
     * @param v view clicked on
     */
    public void eraseContact(View v)
    {
        appState.firebaseReference.child(receivedPersonInfo.id).removeValue();
        nameField.getText().clear();
        provinceField.getText().clear();
        businessNuberField.getText().clear();
        primaryBusinessField.getText().clear();
        addressField.getText().clear();
    }
}
