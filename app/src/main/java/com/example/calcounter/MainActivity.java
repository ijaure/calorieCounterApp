package com.example.calcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declares a spinner and finds it by id
        final Spinner intro_age_spin = (Spinner) findViewById(R.id.intro_age_spin);

        /*Create an array adapter which will hold the array values and integrate
        them with the spinner.
       The container take:
         1. Context
         2. Resource file
         3. Actual data values*/

        ArrayAdapter<String> age_adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ages));

        //Specify that this adapter will be a dropdown list and give it a built-in android layout
        age_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Set the spinner to this created adapter
        intro_age_spin.setAdapter(age_adapter);


        //Setting up a listener to act on selection
        intro_age_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                 String selectedItem = intro_age_spin.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}