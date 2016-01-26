package com.winguys.googlegeocodingexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.winguys.geocoding.api.constant.Language;
import com.winguys.geocoding.api.constant.Region;
import com.winguys.geocoding.api.constant.RequestMessage;
import com.winguys.geocoding.geocoding.Geocoding;
import com.winguys.geocoding.geocoding.OnGeocodingResultListener;
import com.winguys.geocoding.geocoding.ReverseGeocoding;
import com.winguys.geocoding.model.GeocodeResult;
import com.winguys.geocoding.model.Result;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.et_address)
    EditText etAddress;
    @Bind(R.id.et_lat)
    EditText etLatitude;
    @Bind(R.id.et_lng)
    EditText etLongitude;
    @Bind(R.id.tv_geocoding_result)
    TextView tvGeocodingResult;
    @Bind(R.id.tv_reverse_geocoding_result)
    TextView tvReverseGeocodingResult;

    private String latitude = "40,744061";
    private String longtitude = "-73,995561";
    private String address = "247 W 24th St,New York, NY 10011,USA";
    private String API_KEY = "AIzaSyBpprOpfgA6NOy5VYcIEGzA-g2oslXIcRY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        etLatitude.setText(latitude);
        etLongitude.setText(longtitude);
        etAddress.setText(address);
    }

    @OnClick(R.id.btn_address_geocoding)
    public void onGecodingClick() {
        if (!etAddress.getText().toString().isEmpty()) {
            Geocoding.newBuilder().setApiKey(API_KEY)
                    .setRegion(Region.UNITED_STATES)
                    .setLanguage(Language.ENGLISH)
                    .setAddress(etAddress.getText().toString())
                    .build().execute(new OnGeocodingResultListener() {
                @Override
                public void onGeocodingResultListener(GeocodeResult geocodeResult) {
                    if (geocodeResult.getStatus().equals(RequestMessage.OK)) {
                        Result result = geocodeResult.getResults().get(0);
                        tvGeocodingResult.setText(result.getGeometry().getLocation().getLat()
                                +", "+result.getGeometry().getLocation().getLng());
                    }
                }
            });
        }
    }

    @OnClick(R.id.btn_reverse_geocoding)
    public void onReverseGeocodingClick() {
        if (!etLatitude.getText().toString().isEmpty() & !etLongitude.getText().toString().isEmpty()) {
            String latitude = etLatitude.getText().toString().replaceAll(",", ".");
            String longitude = etLongitude.getText().toString().replaceAll(",", ".");
            Log.i("Latitude ", latitude);
            ReverseGeocoding.newBuilder().setApiKey(API_KEY)
                    .setLatLng(latitude + ", " + longitude)
                    .build()
                    .execute(new OnGeocodingResultListener() {
                        @Override
                        public void onGeocodingResultListener(GeocodeResult geocodeResult) {
                            Log.i("Status ",geocodeResult.getStatus());
                            if (geocodeResult.getStatus().equals(RequestMessage.OK)) {
                                Result result = geocodeResult.getResults().get(0);
                                tvReverseGeocodingResult.setText(result.getFormattedAddress());
                            }
                        }
                    });



        }
    }
}
