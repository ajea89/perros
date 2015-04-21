package com.example.pyb.Fragments;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pyb.Adapters.PlaceAdapter;
import com.example.pyb.Beans.Place;
import com.example.pyb.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nhaarman.listviewanimations.appearance.simple.ScaleInAnimationAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan on 13/04/15.
 */
public class PlacesFragment extends BaseFragment{

    public static PlacesFragment newInstance(){
        PlacesFragment placesFragment = new PlacesFragment();
        return placesFragment;
    }

    GoogleMap googleMap;
    MapView mapView;
    boolean firstTime = true;
    private static LocationManager _locationManager;
    private Location _userLocation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.places_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);

        MapsInitializer.initialize(getActivity());
        googleMap = mapView.getMap();
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setMyLocationEnabled(true);

        //setUserLocation();

//        googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
//            @Override
//            public void onMyLocationChange(Location location) {
//                if (firstTime = true){
//                    //locacion actual
//                    LocationManager service = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
//                    Location actLocation = service.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//
//                    if (location != null){
//                        LatLng userLocation = new LatLng(actLocation.getLatitude(),actLocation.getLongitude());
//                        CameraUpdate actualLocation = CameraUpdateFactory.newLatLngZoom(userLocation,16);
//                        googleMap.animateCamera(actualLocation);
//                    }
//
//                    firstTime = false;
//                }
//            }
//        });
//        //locacion actual
        LocationManager service = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        Location location = service.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        if (location != null){
            LatLng userLocation = new LatLng(location.getLatitude(),location.getLongitude());
            CameraUpdate actualLocation = CameraUpdateFactory.newLatLngZoom(userLocation,16);
            googleMap.animateCamera(actualLocation);
        }

        ListView listView = (ListView) findViewById(R.id.list_places);
        final List<Place> places = fillPlaces();

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        ScaleInAnimationAdapter animationAdapter = new ScaleInAnimationAdapter(adapter);
        animationAdapter.setAbsListView(listView);
        listView.setAdapter(animationAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Place placeSelected = places.get(position);

                if(placeSelected.getLatitud() != 0 && placeSelected.getLongitud() != 0){
                    LatLng coordinate = new LatLng(placeSelected.getLatitud(), placeSelected.getLongitud());
                    CameraUpdate location = CameraUpdateFactory.newLatLngZoom(coordinate,16);
                    googleMap.addMarker(new MarkerOptions().position(coordinate).title("Perros y Burros "+ placeSelected.getName()));
                    googleMap.animateCamera(location);
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    private void centraMapa(Location _userLocation) {

        LatLng posicion = new LatLng(_userLocation.getLatitude(),
                _userLocation.getLongitude());
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(posicion, 13));
    }

    private void setUserLocation() {
        // TODO: Siempre regresa Nulo
        /*
         * try{ _locationManager = (LocationManager)
         * this.getActivity().getSystemService(Context.LOCATION_SERVICE); if
         * (_locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
         * _locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
         * MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this); if
         * (locationManager != null){ userLocation =
         * _locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
         * } } else {
         * _locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER
         * , MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this); if
         * (locationManager != null){ userLocation =
         * _locationManager.getLastKnownLocation
         * (LocationManager.NETWORK_PROVIDER); } } }catch(Exception ex){
         * ex.printStackTrace(); }
         */


        // flag for GPS status
        boolean isGPSEnabled = false;
        // flag for network status
        boolean isNetworkEnabled = false;
        boolean canGetLocation = false;

        Location location = null; // location
        double latitude; // latitude
        double longitude; // longitude

        // The minimum distance to change Updates in meters
        final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters
        // The minimum time between updates in milliseconds
        final long MIN_TIME_BW_UPDATES = 1000*60*1;

        // Declaring a Location Manager
        LocationManager locationManager;

        try {
            _locationManager = (LocationManager) this.getActivity()
                    .getSystemService(Context.LOCATION_SERVICE);

            isGPSEnabled = _locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);
            isNetworkEnabled = _locationManager
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!isGPSEnabled && !isNetworkEnabled) {
                Toast.makeText(this.getActivity(),
                        "Por favor encienda su GPS.", Toast.LENGTH_LONG).show();
                // Log.d("Localizacion", "No hay GPS");
            } else {
                canGetLocation = true;
                // First get location from Network Provider
                if (isNetworkEnabled) {
                    _locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,MIN_TIME_BW_UPDATES,MIN_DISTANCE_CHANGE_FOR_UPDATES, (LocationListener) getActivity());
                    // Log.d("Network", "Network");
                    if (_locationManager != null) {
                        location = _locationManager
                                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (location != null) {
                            // latitude = location.getLatitude();
                            // longitude = location.getLongitude();
                            centraMapa(location);
                        } else {
                            Toast.makeText(this.getActivity(),
                                    "Por favor encienda su GPS.",
                                    Toast.LENGTH_LONG).show();

                        }
                    }
                }
                // if GPS Enabled get lat/long using GPS Services
                if (isGPSEnabled) {
                    if (location == null) {
                        _locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES, (LocationListener) getActivity());
                        // Log.d("GPS Enabled", "GPS Enabled");
                        if (_locationManager != null) {
                            location = _locationManager
                                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location != null) {
                                Toast.makeText(getActivity(),location.getLatitude()+" , "+location.getLongitude(), Toast.LENGTH_SHORT).show();
                                // latitude = location.getLatitude();
                                // longitude = location.getLongitude();
                                centraMapa(location);
                            } else {
                                Toast.makeText(this.getActivity(),
                                        "Por favor encienda su GPS.",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // userLocation = mapa.getMyLocation();
    }

    private List<Place> fillPlaces() {

        List<Place> places = new ArrayList<>();
        Place place = new Place();

        place.setName("SAN MATEO");
        place.setAddrees("Mega Comercial Jardines de San Mateo, Av. López Mateos 201 terraza suroeste, Santa Cruz Acatlán, Naucalpan.");
        place.setPhone("Tel. 53 60 62 73");
        place.setLatitud(19.482078);
        place.setLongitud(-99.24924);
        places.add(place);
        place = null;

        place = new Place();
        place.setName("CONDESA");
        place.setAddrees("Alfonso reyes 117, Col. Hipódromo Condesa, delegación Cuauhtémoc.");
        place.setPhone("Tel. 62 67 85 00");
        place.setLatitud(19.4092651);
        place.setLongitud(-99.1774706);
        places.add(place);
        place = null;

        place = new Place();
        place.setName("ROSARIO");
        place.setAddrees("Town Center Rosario Av. Aquiles Serdan esquina Av. El Rosario,  Local V-03 junto a cinépolis.");
        place.setPhone("Tel. 26 26 18 46");
        place.setLatitud(19.5036857);
        place.setLongitud(-99.2039387);
        places.add(place);
        place = null;

        place = new Place();
        place.setName("CABAÑA");
        place.setAddrees("Mega Comercial Jardines de San Mateo, Av. López Mateos 201 terraza suroeste, Santa Cruz Acatlán, Naucalpan.");
        place.setPhone("Tel. 53 60 62 73");
        places.add(place);
        place = null;

        place = new Place();
        place.setName("IZCALLI 2");
        place.setAddrees("Av.Los Perales Mz. 14 LT 11, Col. Arcos del Alba, Cuautitlán Izcalli.");
        place.setPhone("Tel. 58 81 07 00");
        places.add(place);
        place = null;

        place = new Place();
        place.setName("SAN JERÓNIMO");
        place.setAddrees("Luis Cabrera S/N esquina Héroes de Padierna Colonia San Jerónimo Ládice, Miguel Hidalgo, 10200 Ciudad de México, D.F");
        place.setPhone("Tel. 62 68 33 09");
        places.add(place);
        place = null;

        place = new Place();
        place.setName("FUENTES");
        place.setAddrees("Av. Fuentes de Satálite # 1 Int. 7  Loc. 112 y 113 Col. Jardines de Bellavista Estado de México.");
        place.setPhone("Tel. 55 72 18 60");
        places.add(place);
        place = null;

        place = new Place();
        place.setName("NEZA");
        place.setAddrees("Plaza Ciudad Jardín Neza Av Bordo de Xochiaca El Sol, 57205 Ciudad Nezahualcóyotl, Estado de México");
        place.setPhone("Tel. 15 58 41 67");
        places.add(place);
        place = null;

        place = new Place();
        place.setName("ARBOLEDAS");
        place.setAddrees("City Shops, Blvd. Manuel Avila Camacho No. 3130 local 117 PB, Tlalnepanta.");
        place.setPhone("Tel. 53 79 02 48");
        places.add(place);
        place = null;

        place = new Place();
        place.setName("TLALNEPANTLA");
        place.setAddrees("Plaza Steren. Sor Juana Inés de la Cruz Esquina Francisco Javier Mina, Tlalnepantla Centro.");
        place.setPhone("Tel. 53 84 00 01");
        places.add(place);
        place = null;

        return places;
    }
}