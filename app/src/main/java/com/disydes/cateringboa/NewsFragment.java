package com.disydes.cateringboa;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {


    private ListView mListView;

    private List<Vuelos> mVuelosList;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView =  inflater.inflate(R.layout.fragment_news, container, false);
        mListView = (ListView)fragmentView.findViewById(R.id.myListView);


        mVuelosList = new ArrayList<Vuelos>();


        ParseQuery<ParseObject> query = ParseQuery.getQuery("Vuelos");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> vuelosParseList, com.parse.ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + vuelosParseList.size() + " scores");

                    for(ParseObject parseObject : vuelosParseList){

                        String numero = (String) parseObject.get("numeroVuelo");
                        String origen = (String) parseObject.get("origen");
                        String destino = (String) parseObject.get("destino");

                        Vuelos vuelos = new Vuelos(numero,origen,destino);
                        mVuelosList.add(vuelos);



                    }

                    mListView.setAdapter(new MyAdapter());




                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Vuelos vuelos = mVuelosList.get(position);
                String numero_vuelo  = vuelos.getNroVuelo();
                Intent intent = new Intent(getActivity(), VerVuelo.class);

                intent.putExtra("NUMERO_VUELO", numero_vuelo);
                startActivity(intent);



            }
        });

        mListView.setAdapter(new MyAdapter());


        return fragmentView;
    }

    public void openBrowser(String numero_vuelo){


        //Log.d("favio",numero_vuelo);
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mVuelosList.size();
        }

        @Override
        public Object getItem(int position) {
            return mVuelosList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View rowView = getActivity().getLayoutInflater().inflate(R.layout.row,null);

            Vuelos rowVuelos = mVuelosList.get(position);


            TextView textViewRow = (TextView)rowView.findViewById(R.id.textView);
            textViewRow.setText(rowVuelos.getNroVuelo());

            TextView textViewOR = (TextView)rowView.findViewById(R.id.textViewOrigen);
            textViewOR.setText(rowVuelos.getOrigen());

            TextView textViewDE = (TextView)rowView.findViewById(R.id.textViewDestino);
            textViewDE.setText(rowVuelos.getDestino());

            //ImageView imageView = (ImageView) rowView.findViewById(R.id.imageViewPicasso);

           // Picasso.with(getActivity()).load("http://i.imgur.com/DvpvklR.png").into(imageView);


            return rowView;
        }


    }


}
