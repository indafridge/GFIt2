package com.example.gfit;


import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.Toast;


public class GoalsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals_page);
    }

    public void clickStats(View view) {
        Intent intent = new Intent(this, StatsPage.class);
        startActivity(intent);
    }

    public void clickFight(View view) {
        Intent intent = new Intent(this, FightPage.class);
        startActivity(intent);
    }

    public void clickGroups(View view) {
        Intent intent = new Intent(this, GroupsPage.class);
        startActivity(intent);
    }

    public void boxClicked(View view) {
        Toast.makeText(GoalsPage.this,"Goal accomplished ",Toast.LENGTH_SHORT);

    }
}



