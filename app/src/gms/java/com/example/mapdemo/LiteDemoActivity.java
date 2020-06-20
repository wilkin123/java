// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.


package com.example.mapdemo;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This demo shows some features supported in lite mode.
 * In particular it demonstrates the use of {@link com.google.android.gms.maps.model.Marker}s to
 * launch the Google Maps Mobile application, {@link com.google.android.gms.maps.CameraUpdate}s
 * and {@link com.google.android.gms.maps.model.Polygon}s.
 */
public class LiteDemoActivity extends AppCompatActivity implements
        OnMapAndViewReadyListener.OnGlobalLayoutAndMapReadyListener {
    private static final LatLng Klein = new LatLng(40.821640, -73.945170);

    private static final LatLng Key = new LatLng(40.821640, -73.945170);

    private static final LatLng Super= new LatLng(40.823879, -73.944382);

    private static final LatLng Pioneer = new LatLng(40.822790, -73.935540);


    /**
     * A Polygon with five points in the Norther Territory, Australia.
     */

    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout
        setContentView(R.layout.lite_demo);

        // Get the map and register for the ready callback
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        new OnMapAndViewReadyListener(mapFragment, this);
    }

    /**
     * Move the camera to center on Darwin.
     */
    public void showKlein(View v) {
        // Wait until map is ready
        if (map == null) {
            return;
        }

        // Center camera on Adelaide marker
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(Klein, 15f));
    }

    /**
     * Move the camera to center on Adelaide.
     */
    public void showKey(View v) {
        // Wait until map is ready
        if (map == null) {
            return;
        }

        // Center camera on Adelaide marker
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(Key, 15f));
    }
    public void showSuper(View v) {
        // Wait until map is ready
        if (map == null) {
            return;
        }

        // Center camera on Adelaide marker
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(Super, 15f));
    }
    public void showPioneer(View v) {
        // Wait until map is ready
        if (map == null) {
            return;
        }

        // Center camera on Adelaide marker
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(Pioneer, 15f));
    }

    /**
     * Move the camera to show all of Australia.
     * Construct a {@link com.google.android.gms.maps.model.LatLngBounds} from markers positions,
     * then move the camera.
     */
    public void showNY(View v) {
        // Wait until map is ready
        if (map == null) {
            return;
        }

        // Create bounds that include all locations of the map
        LatLngBounds.Builder boundsBuilder = LatLngBounds.builder()
                .include(Klein)
                .include(Key)
                .include(Super)
                .include(Pioneer);

        // Move camera to show all markers and locations
        map.moveCamera(CameraUpdateFactory.newLatLngBounds(boundsBuilder.build(), 20));
    }

    /**
     * Called when the map is ready to add all markers and objects to the map.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        addMarkers();
        showNY(null);
    }




    /**
     * Add Markers with default info windows to the map.
     */
    private void addMarkers() {
        map.addMarker(new MarkerOptions()
                .position(Klein)
                .title("Klein"));

        map.addMarker(new MarkerOptions()
                .position(Key)
                .title("Key Food Supermarket")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        map.addMarker(new MarkerOptions()
                .position(Super)
                .title("Super Foodtown")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        map.addMarker(new MarkerOptions()
                .position(Pioneer)
                .title("Pioneer Supermarket")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

    }
}
