package movesht.com.movesht.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.PolylineOptions;

import java.text.DecimalFormat;
import java.util.List;

import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;

public class MapFragment extends BaseFragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, OnMapReadyCallback {

    private static final float MINIMAL_DISTANCE_FOR_LINE = 500;
    GoogleApiClient mGoogleApiClient;
    private static final int TIME_FOR_CREATE_LINE =1800000;
    LatLng latLngFirst;
    private MapView mapView;
    private GoogleMap mGoogleMap;
    private int flag;
    private DecimalFormat df = new DecimalFormat("#.##");
    private DecimalFormat dfSpeed = new DecimalFormat("#.#");
    private int count = 0;
    private float course = 0;
    private LocationRequest mLocationRequest;
    private long firstLocationTime=0;
//    protected PowerManager.WakeLock mWakeLock;
    private boolean isGreenPolyLine = false;


//    @Override
//    public int setLayout() {
//        return R.layout.fragment_map;
//    }
//
//    @Override
//    public void init(Bundle savedInstanceState, View rootView) {
//        mapView = (MapView) rootView.findViewById(R.id.map);
//        mapView.onCreate(savedInstanceState);
//        mapView.onResume();
////        mapView.getMapAsync(this);//when you already implement OnMapReadyCallback in your fragment
////        Glide.with(ivPeoplePolyline.getContext()).load(R.drawable.red_man).into(ivPeoplePolyline);
////        ivPeoplePolyline.setTag(R.drawable.red_man);
////
////        if(MemoryPref.getInstance().getMode()==1) {
////            Glide.with(ivDynamicPolyLine.getContext()).load(R.drawable.aron_red).into(ivDynamicPolyLine);
////            ivDynamicPolyLine.setTag(R.drawable.aron_red);
////        }else ivDynamicPolyLine.setVisibility(View.GONE);
////        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
//    }

    @Override
    public void onStart() {
        super.onStart();
//        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        mGoogleApiClient.disconnect();
        mapView.onStop();
        super.onStop();
//        EventBus.getDefault().unregister(this);
    }

    @Override
    public int getLayout() {
        return 0;
    }

    @Override
    public <T extends BaseActivity> T getAct() {
        return null;
    }

    @Override
    public void onDestroyView() {
            mapView.onDestroy();
        super.onDestroyView();

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

    }

//    private void peoplePolyLine() {
//        List<DayLocObject> latLngList = null;
//        try {
//            if (HelperFactory.getHelper().getDayLocationDAO().isTableExists())
//                latLngList = HelperFactory.getHelper().getDayLocationDAO().getAllRoles();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        if (latLngList != null && latLngList.size() > 0) {
//            List<LatLng> list = new ArrayList<>();
////            for (DayLocObject loc : latLngList) {
////                list.add(new LatLng(loc.getLatitude(), loc.getLongitude()));
////            }
//            long firstLocTime =0;
//            Location firstLocation = new Location("") ;
//            Location currentLocation = new Location("");
//            for (DayLocObject loc : latLngList) {
//                if(firstLocTime==0) {
//                    firstLocTime = loc.getTime();
//                    firstLocation.setLatitude(loc.getLatitude());
//                    firstLocation.setLongitude(loc.getLongitude());
//                }
//                    currentLocation.setLatitude(loc.getLatitude());
//                    currentLocation.setLongitude(loc.getLongitude());
//                if(Math.abs(firstLocTime- loc.getTime())< TIME_FOR_CREATE_LINE){
//                   if( firstLocation.distanceTo(currentLocation)< MINIMAL_DISTANCE_FOR_LINE) {
//                       list.add(new LatLng(loc.getLatitude(), loc.getLongitude()));
//                   }else {
//                       showSingleLine(list);
//                       list.clear();
//                   }
//                }else {
//                    showSingleLine(list);
//                    list.clear();
//                }
//                firstLocTime = loc.getTime();
//                firstLocation.setLatitude(loc.getLatitude());
//                firstLocation.setLongitude(loc.getLongitude());
//            }
//            if(list.size()>0)
//            showSingleLine(list);
//
//        } else {
//            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                return;
//            }
//            Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
//                    mGoogleApiClient);
//            if (mLastLocation != null) {
//                double lat = mLastLocation.getLatitude();
//                double lng = mLastLocation.getLongitude();
//
//                LatLng loc = new LatLng(lat, lng);
//                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(loc, 15);
//                mGoogleMap.animateCamera(update);
//            }
//        }
//    }

    private void showSingleLine(List<LatLng> list) {
        PolylineOptions polyOptions = new PolylineOptions();
//        polyOptions.color(Color.RED);
//        polyOptions.width(5);
//        polyOptions.addAll(list);
//        mGoogleMap.clear();
        mGoogleMap.addPolyline(polyOptions);
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng latLng : list) {
            builder.include(latLng);
        }
        LatLngBounds bounds = builder.build();
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 100);
        mGoogleMap.animateCamera(cu);
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(getContext())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mGoogleMap = googleMap;
//        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//
//            return;
//        }
//        buildGoogleApiClient();
//
//        mGoogleMap.setMyLocationEnabled(true);
//    }





//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void locationEventListener(LocationEvent event) {
//        if (event.getMessage() == MainActivity.CHANGE_LOCATION) {
//            Location location = event.getLocation();
//            double speed = location.getSpeed() * 3600/1000;
//            String str = dfSpeed.format(speed);
////            tvSpeed.setText("Speed: " + str);
////            tvLatitude.setText("Latitude: " + df.format(location.getLatitude()));
////            tvLongtitude.setText("Longtitude: " + df.format(location.getLongitude()));
////            tvAltitude.setText("Altitude: " + location.getAltitude());
////            tvAccuracy.setText("Accuracy: " + location.getAccuracy());
//            LatLng current = new LatLng(location.getLatitude(), location.getLongitude());
//
//            if (flag == 0)  //when the first update comes, we have no previous points,hence this
//            {
//                latLngFirst = current;
////                firstLocationTime = location.getTime();
//                flag = 1;
//            }
////            if(Math.abs(firstLocationTime- location.getTime())< TIME_FOR_CREATE_LINE) {
//                count++;
//                course += location.getBearing();
//                if (count == 5) {
//                    course = course / 5;
//
//                    CameraPosition cameraPosition = new CameraPosition.Builder()
//                            .target(current)      // Sets the center of the map to Mountain View
//                            .zoom(15)                   // Sets the zoom
//                            .bearing(course)                // Sets the orientation of the camera to east 90degree
//                            .tilt(30)                   // Sets the tilt of the camera to 30 degrees
//                            .build();                   // Creates a CameraPosition from the builder
//                    mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//                    count = 0;
//                    course = 0;
//                }
//
//
//                if (isGreenPolyLine) {
//                    mGoogleMap.addPolyline((new PolylineOptions())
//                            .add(latLngFirst, current).width(6).color(Color.GREEN)
//                            .visible(true));
//                }
////            }
//            latLngFirst = current;
////            firstLocationTime = location.getTime();
//        }
//    }

}
