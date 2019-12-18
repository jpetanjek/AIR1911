package com.example.fitapp.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fitapp.ExerciseConfiguration;
import com.example.fitapp.R;

import java.util.ArrayList;

public class ExerciseConfAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ExerciseConfItem> lista = new ArrayList<ExerciseConfItem>();

    public ExerciseConfAdapter(Context context, ArrayList<ExerciseConfItem> lista)
    {
        this.context = context;

        if(lista == null){
            for (int i=0; i<3; i++){
                ExerciseConfItem item = new ExerciseConfItem(i+1,12, 10);
                this.lista.add(item);
            }
        }
        else
            this.lista = lista;


        // Dodavanje 3 zapisa konfiguracije (početna)

    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public ArrayList<ExerciseConfItem> getLista(){
        return lista;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.exercise_conf_item, parent, false);

        // get current item to be displayed
        ExerciseConfItem currentItem = (ExerciseConfItem) getItem(position);

        // get the TextView for item name and item description
        TextView tvRedniBroj = (TextView) convertView.findViewById(R.id.tvRedniBroj);
        EditText tvMasa = (EditText) convertView.findViewById(R.id.tvMasa);
        EditText tvBrojPonavljanja = (EditText) convertView.findViewById(R.id.tvBrojPonavljanja);

        //sets the text for item name and item description from the current item object
        tvRedniBroj.setText( Integer.toString( currentItem.getRedniBroj() ) );
        tvMasa.setText( Float.toString( currentItem.getMasa() ) );
        tvBrojPonavljanja.setText( Integer.toString( currentItem.getBrojPonavljanja() ) );

        return convertView;
    }

    public class ExerciseConfItem{
        private int RedniBroj;
        private int BrojPonavljanja;
        private float Masa;

        public ExerciseConfItem(int RedniBroj, int BrojPonavljanja, float Masa){
            this.RedniBroj = RedniBroj;
            this.BrojPonavljanja = BrojPonavljanja;
            this.Masa = Masa;
        }

        public int getRedniBroj() {
            return RedniBroj;
        }

        public int getBrojPonavljanja() {
            return BrojPonavljanja;
        }

        public float getMasa() {
            return Masa;
        }
    }
}
