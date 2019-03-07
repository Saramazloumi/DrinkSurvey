package com.example.saramazloumi.drinksurvey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import model.Survey;

public class StartActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText editTextClientNumber, editTextNbOfCups;
    RadioGroup rbGroup;
    Button btnAdd, btnNew, btnResult;
    RadioButton rbFirstDrink, rbSecondDrink, rbThirdDrink;
    Spinner spinnerDrinks;
    ArrayList<Survey> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initialize();
    }

    private void initialize() {
        editTextClientNumber = findViewById(R.id.editTextClientNumber);
        editTextNbOfCups = findViewById(R.id.editTextNbOfCups);
        rbFirstDrink = findViewById(R.id.rbFirstDrink);
        rbSecondDrink = findViewById(R.id.rbSecondDrink);
        rbThirdDrink = findViewById(R.id.rbThirdDrink);
        rbGroup = findViewById(R.id.rbGroup);
        btnAdd = findViewById(R.id.btnAdd);
        btnNew = findViewById(R.id.btnNew);
        btnResult = findViewById(R.id.btnResult);
        spinnerDrinks = findViewById(R.id.spinnerDrinks);
        spinnerDrinks.setOnItemSelectedListener(this);
        btnAdd.setOnClickListener(this);
        btnNew.setOnClickListener(this);
        btnResult.setOnClickListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        TextView textRb = (TextView)view;

        switch (textRb.getText().toString()) {
            case "Juice":
                rbFirstDrink.setText("Apple");
                rbSecondDrink.setText("Orange");
                rbThirdDrink.setText("Mixed");
                break;

            case "Lemonade":
                rbFirstDrink.setText("Coca");
                rbSecondDrink.setText("Sprite");
                rbThirdDrink.setText("7-Up");
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
       int drinkOption = 0;
       int cNumber = Integer.valueOf(editTextClientNumber.getText().toString());
       int nbOfCups = Integer.valueOf(editTextNbOfCups.getText().toString());
       int drinkType = 0;
        switch (v.getId()){

            case R.id.btnAdd:

                switch (spinnerDrinks.getSelectedItem().toString()) {
                    case "Juice":
                        drinkOption = 1;
                        int rbId = rbGroup.getCheckedRadioButtonId();
                        switch (rbId) {
                            case R.id.rbFirstDrink:
                                drinkType = 1;
                                break;
                            case R.id.rbSecondDrink:
                                drinkType = 2;
                                break;
                            case R.id.rbThirdDrink:
                                drinkType = 3;
                                break;
                        }
                        break;
                    case "Lemonade":
                        drinkOption = 2;
                        int rbId2 = rbGroup.getCheckedRadioButtonId();
                        switch (rbId2) {
                            case R.id.rbFirstDrink:
                                drinkType = 1;
                                break;
                            case R.id.rbSecondDrink:
                                drinkType = 2;
                                break;
                            case R.id.rbThirdDrink:
                                drinkType = 3;
                                break;
                        }
                        break;

                }

             Survey survey = new Survey(cNumber,drinkOption,drinkType, nbOfCups);
                list.add(survey);
                break;
            case R.id.btnNew:
                editTextClientNumber.setText(null);
                rbGroup.clearCheck();
                editTextNbOfCups.setText(null);
                editTextClientNumber.requestFocus();
                break;
            case R.id.btnResult:
                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra("tag", list);
                startActivity(intent);
                break;



        }


    }
}
