package org.freedu.topgamesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView gameName, companyName;
    private ImageView gameImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        gameName = findViewById(R.id.gameName);
        companyName = findViewById(R.id.companyName);
        gameImg = findViewById(R.id.gameImg);

        Intent intent = getIntent();

        String game = intent.getStringExtra("game");
        String comany = intent.getStringExtra("company");
        int img = intent.getIntExtra("img", 0);

        gameName.setText(game);
        companyName.setText(comany);
        gameImg.setImageResource(img);

    }
}