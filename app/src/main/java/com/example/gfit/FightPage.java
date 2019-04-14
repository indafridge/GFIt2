package com.example.gfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FightPage extends AppCompatActivity {
    private Button Lift;
    private TextView Info;
    private TextView Details;
    private String WinTxt;
    private String LossTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_page);
        Lift = findViewById(R.id.btnLift);
        Info = findViewById(R.id.txtInfo);
        Details = findViewById(R.id.txtExplanation);
        WinTxt = "You Won!";
        LossTxt = "You Lost!";
    }

    public void clickLift(View view) {
        int randomOpp = (int) (Math.random() * 50 + 1);
        int randomUser = (int) (Math.random() * 50 + 1);
        String both = ("Your opponent lifts " + randomOpp + " kilos in the competition. /n You lift " + randomUser + " kilos in the competition.");
        Details.setText(both);

        if (randomUser >= randomOpp) {
            Info.setText(WinTxt);
        } else {
            Info.setText(LossTxt);
        }

    }

    public void clickSprint(View view) {
        int randomOpp = (int) (Math.random() * 50 + 1);
        int randomUser = (int) (Math.random() * 50 + 1);
        String both = ("Your opponent runs " + randomOpp + " metres in 5 seconds. /n You ran " + randomUser + " metres in 5 seconds.");
        Details.setText(both);

        if (randomUser >= randomOpp) {
            Info.setText(WinTxt);
        } else {
            Info.setText(LossTxt);
        }

    }

    public void clickEat(View view) {
        int randomOpp = (int) (Math.random() * 50 + 1);
        int randomUser = (int) (Math.random() * 50 + 1);
        String both = ("Your opponent ate " + randomOpp + " hotdogs. /n You ate " + randomUser + " hotdogs in 5 seconds.");
        Details.setText(both);

        if (randomUser >= randomOpp) {
            Info.setText(WinTxt);
        } else {
            Info.setText(LossTxt);
        }
    }

    public void clickStats(View view) {
        Intent intent = new Intent(this, StatsPage.class);
        startActivity(intent);
    }

    public void clickGoals(View view) {
        Intent intent = new Intent(this, GoalsPage.class);
        startActivity(intent);
    }

    public void clickGroups(View view) {
        Intent intent = new Intent(this, GroupsPage.class);
        startActivity(intent);
    }


}
