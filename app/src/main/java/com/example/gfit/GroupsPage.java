package com.example.gfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class GroupsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups_page);
    }

    public void clickStats(View view) {
        Intent intent = new Intent(this, StatsPage.class);
        startActivity(intent);
    }

    public void clickFight(View view) {
        Intent intent = new Intent(this, FightPage.class);
        startActivity(intent);
    }

    public void clickGoals(View view) {
        Intent intent = new Intent(this, GoalsPage.class);
        startActivity(intent);
    }

}
