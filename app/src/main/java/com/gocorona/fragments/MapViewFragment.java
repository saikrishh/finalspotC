package com.gocorona.fragments;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.gocorona.R;
import com.gocorona.model.response.login.UserData;
import com.gocorona.ui.home.HomeFragment;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;

import simplifii.framework.utility.GPSTracker;
import simplifii.framework.widgets.styleabletoast.StyleableToast;

import static android.content.Context.LOCATION_SERVICE;

public class MapViewFragment extends Fragment {

    MapView mMapView;
    private GoogleMap googleMap;
    LatLng myPosition;
    public static MapViewFragment instance;

    public static MapViewFragment getInstance() {
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
            mMapView = (MapView) rootView.findViewById(R.id.mapView);
            mMapView.onCreate(savedInstanceState);
            mMapView.onResume(); // needed to get the map to display immediately
            mMapView.getMapAsync(new OnMapReadyCallback() {

             @Override
             public void onMapReady(GoogleMap mMap) {
                 googleMap = mMap;

                 // For showing a move to my location button

                 googleMap.setMyLocationEnabled(true);
                 googleMap.getUiSettings().setMyLocationButtonEnabled(false);

                 LocationManager locationManager = (LocationManager) getActivity().getSystemService(LOCATION_SERVICE);
                 Criteria criteria = new Criteria();
                 String provider = locationManager.getBestProvider(criteria, true);
                 if ((ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) && (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
                     // TODO: Consider calling
                     //    ActivityCompat#requestPermissions
                     // here to request the missing permissions, and then overriding


                     //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                     //                                          int[] grantResults)
                     // to handle the case where the user grants the permission. See the documentation
                     // for ActivityCompat#requestPermissions for more details.
                     return;
                 }

                 Location location = locationManager.getLastKnownLocation(provider);
                 if (location != null) {
                     double latitude = location.getLatitude();
                     double longitude = location.getLongitude();
                     myPosition = new LatLng(latitude, longitude);
                 }

                 // For dropping a marker at a point on the Map
                 //googleMap.addMarker(new MarkerOptions().position(myPosition).title("Marker Title").snippet("Marker Description"));

                 // For zooming automatically to the location of the marker
                 mylocationzone();
             }


             public void mylocationzone() {
                 //    CameraPosition cameraPosition = new CameraPosition.Builder().target(myPosition).zoom(16).build();
                 //googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myPosition,16 ));

                 googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myPosition, 16));
                 googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myPosition, 16));
             }//newCameraPosition


         });
     }
     catch (Exception e){
         e.printStackTrace();
     }
        return rootView;
    }



    @Override
    public void onResume() {
        super.onResume();
        //checkRunTimePermission();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

}