package com.example.gfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class StatsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_page);
    }

    public void clickFight(View view) {
        Intent intent = new Intent(this, FightPage.class);
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
