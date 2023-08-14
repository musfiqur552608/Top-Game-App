package org.freedu.topgamesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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
                new TopGameModel("eFootball", "Konami", R.drawable.efootball),
                new TopGameModel("Clash of Clans", "Supercell", R.drawable.coc),
                new TopGameModel("Clash Royal", "Supercell", R.drawable.cr),
                new TopGameModel("PUBG", "PUBG", R.drawable.pubg),
                new TopGameModel("Free Fire", "Free file", R.drawable.freefire),
                new TopGameModel("Call of Duty", "Call of Duty", R.drawable.cod),
                new TopGameModel("Real Football", "Real", R.drawable.rfootball),
                new TopGameModel("Angry Birds", "Angry Birds", R.drawable.angrybird),
                new TopGameModel("Tample Run", "Tample Run", R.drawable.templerun),
                new TopGameModel("UNO", "UNO", R.drawable.uno),
                new TopGameModel("8 Ball Pool", "8 Ball Pool", R.drawable.ballpool),
                new TopGameModel("Ludo Star", "Ludo Star", R.drawable.ludostar),
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
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("game",gameData[pos].getGameName());
        intent.putExtra("company",gameData[pos].getCompanyName());
        intent.putExtra("img",gameData[pos].getGameImg());
        startActivity(intent);
    }
}