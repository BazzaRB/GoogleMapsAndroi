package org.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.Circle
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import org.example.project.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // ...

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        square(mMap)
        circleZone(mMap, 1000.0)
    }

    private fun square(googleMap: GoogleMap){

        val radius = 12

        val polylineOptions = PolylineOptions()
            .add(LatLng(37.35, -122.0))
            .add(LatLng(37.45, -122.0)) // North of the previous point, but at the same longitude
            .add(LatLng(37.45, -122.2)) // Same latitude, and 30km to the west
            .add(LatLng(37.35, -122.2)) // Same longitude, and 16km to the south
            .add(LatLng(37.35, -122.0)) // Closes the polyline.

// Get back the mutable Polyline
        val polyline = mMap.addPolyline(polylineOptions)
    }

    private fun circleZone(googleMap: GoogleMap, radius: Double){
        val circleOptions = CircleOptions()
            .center(LatLng(63.42326019410603, 10.43650804090511))
            .radius(radius)

        val circleZone = mMap.addCircle(circleOptions)
    }

    fun buttonClick(v: View?){
        println("SO THE FUCKING BUTTON WAS CLICKED!?!?!")
    }




}