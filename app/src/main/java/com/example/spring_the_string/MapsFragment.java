package com.example.spring_the_string;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {
    Button button;
    GoogleMap googleMap1;


    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            googleMap1 = googleMap;
            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            LatLng sydney = new LatLng(25.4358, 81.8463);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in India"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);


        }
    };



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,

                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.fragment_maps, container, false);

        Button myButton = v.findViewById(R.id.zoomin);
        Button myButton1 = v.findViewById(R.id.zoomout);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleMap1.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });
        myButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleMap1.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        });

        return v;














    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);


        }
    }
}