package com.justanotherproject.botischileapi16;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment
{

    MapView mapView;
    GoogleMap map;
    public LatLng LatLngLocation=null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.map_layout, container, false);

        super.onActivityCreated(savedInstanceState);
        super.onCreate(savedInstanceState);

        // Gets the MapView from the XML layout and creates it
        mapView = (MapView) v.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        // Gets to GoogleMap from the MapView and does initialization stuff
        map = mapView.getMap();
        map.getUiSettings().setMyLocationButtonEnabled(true);
        map.setMyLocationEnabled(true);

        //Add a marker
        map.addMarker(new MarkerOptions().position(
                new LatLng(-33.4556327, -70.655571)).icon(
                BitmapDescriptorFactory.defaultMarker()).title("Test Title").snippet("Test Detail"));


        // Needs to call MapsInitializer before doing any CameraUpdateFactory calls
            MapsInitializer.initialize(this.getActivity());


//        if (mLastLocation != null) {
//
//            // latitude and longitude
//            LatLng lat = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
//
//            //double latitude = 17.385044;
//            //double longitude = 78.486671;
//            //LatLng lat = new LatLng(latitude,longitude);
//
//            // create marker
//
//            MarkerOptions marker = new MarkerOptions().position(
//                    lat).title("Hello Maps");
//
//            // Changing marker icon
//            marker.icon(BitmapDescriptorFactory
//                    .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
//
//            // adding marker
//            map.addMarker(marker);
//
//            CameraPosition cameraPosition = new CameraPosition.Builder()
//                    .target(lat).zoom(12).build();
//
//
//            map.animateCamera(CameraUpdateFactory
//                    .newCameraPosition(cameraPosition));
//
//        }
        // Gets the Last location from the activity

//        MainActivity activity = (MainActivity) getActivity();
//        newLocation = activity.getLatLng();


//        //Starting position
//        map.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(-33.4556327, -70.655571), 12) );
       map.moveCamera( CameraUpdateFactory.newLatLngZoom( new LatLng(-33.4556327, -70.655571), 12) );
//
        //Move the camera to a determinate position
        // Updates the location and zoom of the MapView

//        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(LatLngLocation, 12);
//        map.animateCamera(cameraUpdate);

        return v;
    }

//    public void checkLatLng(){
//
//        MainActivity activity = (MainActivity) getActivity();
//        LatLngLocation = activity.getNewLatLng();
//        if(LatLngLocation!=null){
//            updateView();
//        }
//    }

//    public void updateView(){
//
//        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(LatLngLocation, 12);
//         map.animateCamera(cameraUpdate);
//    }

    @Override
    public void onResume() {


        MainActivity activity = (MainActivity) getActivity();
        LatLngLocation = activity.getNewLatLng();

        if(LatLngLocation!=null){

            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(LatLngLocation, 12);
            map.animateCamera(cameraUpdate);
        }

        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onPause() {

        MainActivity activity = (MainActivity) getActivity();
        LatLngLocation = activity.getNewLatLng();

        if(LatLngLocation!=null){

            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(LatLngLocation, 12);
            map.animateCamera(cameraUpdate);
        }

        mapView.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}