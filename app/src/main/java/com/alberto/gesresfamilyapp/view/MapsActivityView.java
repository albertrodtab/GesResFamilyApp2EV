package com.alberto.gesresfamilyapp.view;



import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.alberto.gesresfamilyapp.R;
import com.alberto.gesresfamilyapp.contract.centro.CentrosListMapsContract;
import com.alberto.gesresfamilyapp.domain.Centro;
import com.alberto.gesresfamilyapp.presenter.centro.CentrosListMapsPresenter;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mapbox.geojson.Point;
import com.mapbox.maps.CameraOptions;
import com.mapbox.maps.MapView;
import com.mapbox.maps.Style;
import com.mapbox.maps.plugin.annotation.AnnotationConfig;
import com.mapbox.maps.plugin.annotation.AnnotationPlugin;
import com.mapbox.maps.plugin.annotation.AnnotationPluginImplKt;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManagerKt;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions;


import java.util.ArrayList;
import java.util.List;

public class MapsActivityView extends AppCompatActivity implements CentrosListMapsContract.view, Style.OnStyleLoaded {

    private MapView mapView;

    private double gpsLatitude;
    private double gpsLongitude;

    private FusedLocationProviderClient fusedLocationClient;
    private PointAnnotationManager pointAnnotationManager;
    public static List<Centro> centroList = new ArrayList<>();
    private CentrosListMapsPresenter centrosListMapsPresenter;
    private FloatingActionButton btLotacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mapView = findViewById(R.id.mapView); //cargamos el mapa
        mapView.getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS, this);
        initializePointManager(); // inicializamos el pointmanager
//        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        MaterialToolbar topAppBar = findViewById(R.id.topAppBar);
        setSupportActionBar(topAppBar);

        topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción a realizar al hacer clic en el ícono de navegación
                // Por ejemplo, cerrar la actividad o realizar alguna acción específica
                onBackPressed(); // Ejemplo: retroceder a la actividad anterior
            }
        });

        centrosListMapsPresenter = new CentrosListMapsPresenter(this);
        gps();
    }

    @Override
    protected void onResume() {
        super.onResume();
        centrosListMapsPresenter.loadAllCentros();
    }

    /**
     * Inicializamos el pointmanager
     */
    private void initializePointManager() {
        AnnotationPlugin annotationPlugin = AnnotationPluginImplKt.getAnnotations(mapView);
        AnnotationConfig annotationConfig = new AnnotationConfig();
        pointAnnotationManager = PointAnnotationManagerKt.createPointAnnotationManager(annotationPlugin, annotationConfig);

    }

    /*
    *
     * Para poder crear un marker y que lo pinte por cada centro
     *
     * @param point  Pasamos el point
     * @param nombre el nombre del centro
     *//*
    private void addMarker(Point point, String nombre) {
        PointAnnotationOptions pointAnnotationOptions = new PointAnnotationOptions()
                .withPoint(point)
                .withTextField(nombre) //asi aparece el nombre en el mapa
                .withIconImage(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_centro_mayores_foreground));
        pointAnnotationManager.create(pointAnnotationOptions);
    }*/

    private void addMarker(double latitude, double longitude, String title, int id) {
        PointAnnotationOptions pointAnnotationOptions = new PointAnnotationOptions()
                .withPoint(Point.fromLngLat(longitude, latitude))
                .withIconImage(BitmapFactory.decodeResource(getResources(), id))
                .withTextField(title);
        pointAnnotationManager.create(pointAnnotationOptions);
    }

    /*public void onStyleLoaded(@NonNull Style style) {
        addMarker(inventory.getLatitude(), inventory.getLongitude(), String.valueOf(inventory.getId()), R.mipmap.ic_centro_mayores_foreground);
        setCameraPosition(inventory.getLatitude(), inventory.getLongitude());
        gps();


    }*/

    /**
     * Fija la camara del mapa donde nosotros queramos, asi el mapa arranca desde ese punto
     *
     * @param
     */
/*    private void setCameraPosition(Point point) {
        CameraOptions cameraPosition = new CameraOptions.Builder()
                .center(point)
                .pitch(0.0)
                .zoom(13.5)
                .bearing(-17.6)
                .build();
        mapView.getMapboxMap().setCamera(cameraPosition);

    }*/

    private void setCameraPosition(double latitude, double longitude) {
        CameraOptions cameraPosition = new CameraOptions.Builder()
                .center(Point.fromLngLat(longitude, latitude))
                .pitch(45.0)
                .zoom(15.5)
                .bearing(0.0)
                .build();
        mapView.getMapboxMap().setCamera(cameraPosition);
    }

    @SuppressLint("MissingPermission")
    private void gps() {
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, location -> {
                    // Got last known location. In some rare situations this can be null.
                    if (location != null) {
                        // Logic to handle location object
                        gpsLongitude = location.getLongitude();
                        gpsLatitude = location.getLatitude();
                        Log.i("gps: ", "+++++++++++");
                        Log.i("gps: ", String.valueOf(location.getLongitude()));
                        Log.i("gps: ", String.valueOf(location.getLatitude()));
                        Log.i("gps: ", String.valueOf(location));

                        setCameraPosition(gpsLatitude, gpsLongitude);



                        addMarker(gpsLatitude, gpsLongitude, "Estás Aquí", R.mipmap.ic_residente_foreground);

                    }
                });

    }

    /**
     * Metodo para sacar una lista de puuentes con un for para crear un point por cada puente con la longitude y latitude mas el nombre del puente
     *
     * @param
     */
    private void addCenterToMap(List<Centro> centros) {
        for (Centro centro : centros) {
            Point point = Point.fromLngLat(centro.getLongitude(), centro.getLatitude());
            //addMarker(point, centro.getNombre()); //le pasamos el metodo que crea el marker y ponemos el point y nombre del centro       }

            addMarker(centro.getLatitude(), centro.getLongitude(), centro.getNombre(), R.mipmap.ic_centro_mayores_foreground);


            Centro lastCentro = centros.get(centros.size() - 1); // recogemos el ultimo centro
            setCameraPosition(lastCentro.getLatitude(), lastCentro.getLongitude()); //Fijamos la camara del mapa en el ultimo centro
        }
    }

    @Override
    public void showCentros(List<Centro> centros) {
        centroList.addAll(centros);
        addCenterToMap(centroList);
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void onStyleLoaded(@NonNull Style style) {

    }
}





