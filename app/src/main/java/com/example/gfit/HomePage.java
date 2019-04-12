package com.example.gfit;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomePage extends AppCompatActivity {
    private ImageButton Camera;
    private Button Stats;
    private Button Fight;
    private Button Goals;
    private Button Groups;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Stats = findViewById(R.id.btnStats);
        Fight = findViewById(R.id.btnFight);
        Goals = findViewById(R.id.btnGoals);
        Groups = findViewById(R.id.btnGroups);
    }
    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    /** Called when the user touches the button */
    public void sendMessage(View view) {
        // Do something in response to button click
        dispatchTakePictureIntent();
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

    public void clickGroups(View view) {
        Intent intent = new Intent(this, GroupsPage.class);
        startActivity(intent);
    }

}
