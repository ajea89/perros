package com.example.pyb.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.pyb.Adapters.PlaceAdapter;
import com.example.pyb.Beans.Place;
import com.example.pyb.R;
import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan on 13/04/15.
 */
public class PlacesFragment extends BaseFragment {

    public static PlacesFragment newInstance(){
        PlacesFragment placesFragment = new PlacesFragment();
        return placesFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.places_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        ListView listView = (ListView) findViewById(R.id.list_places);
        List<Place> places = fillPlaces();

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(adapter);
        animationAdapter.setAbsListView(listView);
        listView.setAdapter(animationAdapter);
    }

    private List<Place> fillPlaces() {

        List<Place> places = new ArrayList<>();
        Place place = new Place();

        place.setName("SAN MATEO");
        place.setAddrees("Mega Comercial Jardines de San Mateo, Av. López Mateos 201 terraza suroeste, Santa Cruz Acatlán, Naucalpan.");
        place.setPhone("Tel. 53 60 62 73");
        places.add(place);
        place = null;

        place = new Place();
        place.setName("CONDESA");
        place.setAddrees("Alfonso reyes 117, Col. Hipódromo Condesa, delegación Cuauhtémoc.");
        place.setPhone("Tel. 62 67 85 00");
        places.add(place);
        place = null;

        place = new Place();
        place.setName("CABAÑA");
        place.setAddrees("Mega Comercial Jardines de San Mateo, Av. López Mateos 201 terraza suroeste, Santa Cruz Acatlán, Naucalpan.");
        place.setPhone("Tel. 53 60 62 73");
        places.add(place);
        place = null;

        place = new Place();
        place.setName("ROSARIO");
        place.setAddrees("Town Center Rosario Av. Aquiles Serdan esquina Av. El Rosario,  Local V-03 junto a cinépolis.");
        place.setPhone("Tel. 26 26 18 46");
        places.add(place);
        place = null;

        place = new Place();
        place.setName("IZCALLI 2");
        place.setAddrees("Av.Los Perales Mz. 14 LT 11, Col. Arcos del Alba, Cuautitlán Izcalli.");
        place.setPhone("Tel. 58 81 07 00");
        places.add(place);
        place = null;

        return places;
    }
}
