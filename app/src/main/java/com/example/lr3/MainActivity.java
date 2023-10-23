package com.example.lr3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Games> states = new ArrayList<Games>();
    ListView countriesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // начальная инициализация списка
        setInitialData();
        // получаем элемент ListView
        countriesList = findViewById(R.id.gamelist);
        // создаем адаптер
        GamesAdapter gamesAdapter = new GamesAdapter(this, R.layout.listitem, states);
        // устанавливаем адаптер
        countriesList.setAdapter(gamesAdapter);
        // слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                Games selectedState = (Games) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), " " + selectedState.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        countriesList.setOnItemClickListener(itemListener);
    }
    private void setInitialData(){

        states.add(new Games ("Darksiders II",  R.drawable.darksiders));
        states.add(new Games ("Футбол",  R.drawable.futbol));

    }
}