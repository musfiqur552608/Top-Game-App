package org.freedu.topgamesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ItemClickListener{
    private RecyclerView recyclerView;
    private  TopGameModel[] gameData;
    private TopGameAdaptar adaptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        gameData = new TopGameModel[]{
                new TopGameModel("Fifa 23", "EA Sports", R.drawable.fifa),
                new TopGameModel("eFootball 23", "Konami", R.drawable.efootball),
                new TopGameModel("Pokemon", "Pokemon", R.drawable.pokemon),
                new TopGameModel("Clash of Clans", "EA Sports", R.drawable.fifa),
                new TopGameModel("Warship", "EA Sports", R.drawable.fifa),
                new TopGameModel("NFL 23", "EA Sports", R.drawable.fifa),
                new TopGameModel("Angry Birds", "EA Sports", R.drawable.fifa),
                new TopGameModel("Tample Run", "EA Sports", R.drawable.fifa),
                new TopGameModel("Clash Royal", "EA Sports", R.drawable.fifa),
                new TopGameModel("Subway Surfers", "EA Sports", R.drawable.fifa),
                new TopGameModel("Real Cricket 23", "EA Sports", R.drawable.fifa),
                new TopGameModel("PUBG", "EA Sports", R.drawable.fifa),
                new TopGameModel("Free Fire", "EA Sports", R.drawable.fifa),
                new TopGameModel("Call of Duty", "EA Sports", R.drawable.fifa),
                new TopGameModel("GTA-V", "EA Sports", R.drawable.fifa),
                new TopGameModel("Minecraft", "EA Sports", R.drawable.fifa)
        };

        adaptar = new TopGameAdaptar(gameData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptar);

        adaptar.setClickListener(this);
    }

    @Override
    public void onClick(View view, int pos) {
        Toast.makeText(this, "Game: "+gameData[pos].getGameName()+", Company: "+gameData[pos].getCompanyName(), Toast.LENGTH_LONG).show();
    }
}