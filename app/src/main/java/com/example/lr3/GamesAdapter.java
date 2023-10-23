package com.example.lr3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GamesAdapter extends ArrayAdapter<Games> {
    private LayoutInflater inflater;
    private int layout;
    private List<Games> games;

    public GamesAdapter(Context context, int resource, List<Games> games) {
        super(context, resource, games);
        this.games = games;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        ImageView flagView = view.findViewById(R.id.flag);
        TextView nameView = view.findViewById(R.id.name);


        Games game = games.get(position);

        flagView.setImageResource(game.getFlagResource());
        nameView.setText(game.getName());


        return view;
    }
}
