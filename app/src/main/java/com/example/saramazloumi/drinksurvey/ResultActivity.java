package com.example.saramazloumi.drinksurvey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import model.Survey;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    int textViewTotalIds[] = {R.id.textViewTA, R.id.textViewTO, R.id.textViewTM, R.id.textViewTC, R.id.textViewTS, R.id.textViewT7};
    int textViewPercentageIds[] = {R.id.textViewPA, R.id.textViewPO, R.id.textViewPM, R.id.textViewPC, R.id.textViewPS, R.id.textViewP7};
    TextView []listOfTotal = new TextView[6];
    TextView[] listOfPercentage = new TextView[6];
    Button btnReturn;
    int apple, orange, mixed, coca, sprite,sevenUp;
    int total;

    ArrayList<Survey> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initialize();
    }

    private void initialize() {
        list = (ArrayList<Survey>) getIntent().getSerializableExtra("tag");

        for(int i = 0; i < textViewTotalIds.length; i ++ ){
            listOfTotal[i] = findViewById(textViewTotalIds[i]);
            listOfPercentage[i] = findViewById(textViewPercentageIds[i]);
        }
        getInformation();
        percentage();
        btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(this);
    }

    public void getInformation(){

        for (int i = 0; i < list.size(); i++){
            int drinkOption = list.get(i).getDrinkType();
           switch (drinkOption){

               case 1:
                   int drink = list.get(i).getDrink();
                   switch (drink){
                       case 1:
                           apple += list.get(i).getNbOfCups();
                           listOfTotal[0].setText(String.valueOf(apple));
                           break;
                       case 2:
                           orange += list.get(i).getNbOfCups();
                           listOfTotal[1].setText(String.valueOf(orange));
                           break;
                       case 3:
                           mixed += list.get(i).getNbOfCups();
                           listOfTotal[2].setText(String.valueOf(mixed));
                           break;
                   }
                   break;
               case 2:
                   int drink2 = list.get(i).getDrink();
                   switch (drink2){
                       case 1:
                           coca += list.get(i).getNbOfCups();
                           listOfTotal[3].setText(String.valueOf(coca));
                           break;
                       case 2:
                           sprite += list.get(i).getNbOfCups();
                           listOfTotal[4].setText(String.valueOf(sprite));
                           break;
                       case 3:
                           sevenUp += list.get(i).getNbOfCups();
                           listOfTotal[5].setText(String.valueOf(sevenUp));
                           break;
                   }
                   break;

           }
        }
    }

    public void percentage(){
        total = apple + orange + mixed + coca + sprite + sevenUp;
        double applePercentage = ((double)apple/(double)total)*100;
        listOfPercentage[0].setText(String.valueOf((int)applePercentage + "%"));
        double orangePercentage =((double)orange/(double)total)*100;
        listOfPercentage[1].setText(String.valueOf((int)orangePercentage + "%"));
        double mixedPercentage = ((double)mixed/(double)total)*100;
        listOfPercentage[2].setText(String.valueOf((int)mixedPercentage + "%"));
        double cocaPercentage = ((double)coca/(double)total)*100;
        listOfPercentage[3].setText(String.valueOf((int)cocaPercentage + "%"));
        double spritePercentage = ((double)sprite/(double)total)*100;
        listOfPercentage[4].setText(String.valueOf((int)spritePercentage + "%"));
        double sevenUpPercentage = ((double)sevenUp/(double)total)*100;
        listOfPercentage[5].setText(String.valueOf((int)sevenUpPercentage + "%"));
    }

    @Override
    public void onClick(View v) {
        finish();

    }
}
