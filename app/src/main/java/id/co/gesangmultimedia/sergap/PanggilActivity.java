package id.co.gesangmultimedia.sergap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telecom.PhoneAccountHandle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.data.geojson.GeoJsonLayer;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static androidx.constraintlayout.motion.widget.Debug.getLocation;

public class PanggilActivity extends AppCompatActivity implements OnMapReadyCallback,
        LocationListener {
    SargapActivity sargapActivity = new SargapActivity();
    private static final int REQUEST_LOCATION = 99;
    private GoogleMap mymap;
    private GeoJsonLayer geoJsonLayer;
    ImageButton imbPanggil;
    ImageButton imbWeak;
    ImageButton imbEsemes;
    Button btnCekLokasi;
    private FusedLocationProviderClient sFusedLocationClient;

    LocationManager locationManager;
    String lattitude, longitude, phoneNo, message, strLatitude, strLongitude, strNoTelp;
    TextView tvLatitude, tvLongitude, tvNohp;

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    protected LocationListener locationListener;

    //public static String dburl = "https://gesangmultimedia.co.id/sar-operator/android/addlocation.php";

    private static final LatLng CILACAP = new LatLng(-7.488879, 108.839484);
    private static final LatLng POLRESCILACAP = new LatLng(-7.692961, 109.025561);
    private static final LatLng POLSEKADIPALA = new LatLng(-7.659355, 109.149612);
    private static final LatLng POLSEKBANTARSARI = new LatLng(-7.543571, 108.874165);
    private static final LatLng POLSEKBINANGUN = new LatLng(-7.666668, 109.267070);
    private static final LatLng POLSEKCILACAPSELATAN = new LatLng(-7.723462, 109.017102);
    private static final LatLng POLSEKCILACAPTENGAH = new LatLng(-7.718084, 109.005876);
    private static final LatLng POLSEKCILACAPUTARA = new LatLng(-7.684109, 109.038706);
    private static final LatLng POLSEKCIMANGGU = new LatLng(-7.345206, 108.83498);
    private static final LatLng POLSEKDAYEUHLUHUR = new LatLng(-7.256821, 108.608600);
    private static final LatLng POLSEKGANDRUNGMANGU = new LatLng(-7.523776, 108.853699);
    private static final LatLng POLSEKJERUKLEGI = new LatLng(-7.626037, 109.022181);
    // private static final LatLng POLSEKKAMPUNGLAUT = new LatLng(-7.692961, 109.025561);
    private static final LatLng POLSEKKARANGPUCUNG = new LatLng(-7.409812, 108.900115);
    private static final LatLng POLSEKKAWUNGANTEN = new LatLng(-7.590763, 108.916067);
    private static final LatLng POLSEKKEDUNGREJA = new LatLng(-7.501793, 108.786971);
    private static final LatLng POLSEKKROYA = new LatLng(-7.637435, 109.242955);
    private static final LatLng POLSEKMAOS = new LatLng(-7.620525, 109.143053);
    private static final LatLng POLSEKMAJENANG = new LatLng(-7.300909, 108.754759);
    private static final LatLng POLSEKNUSAWUNGU = new LatLng(-7.648117, 109.342332);
    private static final LatLng POLSEKPATIMUAN = new LatLng(-7.575756, 108.766031);
    private static final LatLng POLSEKSAMPANG = new LatLng(-7.568301, 109.184062);
    private static final LatLng POLSEKSIDAREJA = new LatLng(-7.484330, 108.791805);
    private static final LatLng POLSEKWANAREJA = new LatLng(-7.334269, 108.686585);
    private static final LatLng SATPOLAIR = new LatLng(-7.736404, 108.997158);
    private static final LatLng POSTERKAM = new LatLng(-7.728254, 109.009638);
    private static final LatLng POLSEKKHUSUSPELABUHAN = new LatLng(7.733034, 108.996473);
    private static final LatLng POLSEKCIPARI = new LatLng(-7.427822, 108.743022);
    private static final LatLng POLSEKKESUGIHAN = new LatLng(-7.625266, 109.113996);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panggil);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);

        TextView tvNoHp = findViewById(R.id.tvHpuser);
        Intent intent = getIntent();
        String nohape = intent.getStringExtra("NomerHP");
        tvNoHp.setText(nohape);

        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.CALL_PHONE)) {
                Toast.makeText(this, "Membutuhkan ijin Telepon", Toast.LENGTH_SHORT).show();
            } else {

                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.CALL_PHONE},
                        1);
            }
        }
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(this, "Membutuhkan ijin Telepon", Toast.LENGTH_SHORT).show();
            } else {

                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        1);
            }

            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION
                            , android.Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
                } else {

                    //Toast.makeText(MainActivity.this, "Alokasi GPS sudah diaktifkan", Toast.LENGTH_LONG).show();
                }
            } else {
                //Toast.makeText(MainActivity.this, "Aplikasi GPS dinon-aktifkan", Toast.LENGTH_LONG).show();
            }
        }
        Button btnCekLokasi = findViewById(R.id.btnCekLokasi);
        btnCekLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panggilLokasii();
                //detekNoTelp();
            }
        });

        ImageButton imbPanggil = findViewById(R.id.ibPanggil);
        imbPanggil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //simpanlokasi();
                panggiltelpon();
            }
        });
        ImageButton imbWeak = findViewById(R.id.ibWeak);
        imbWeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanlokasi();
                panggilWA();
            }
        });
        ImageButton imbEsemes = findViewById(R.id.ibEsemes);
        imbEsemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanlokasi();
                panggilSMS();
            }
        });
    }

    private void panggilLokasii() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();

        } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            getLocation();
        }
    }

    public void getLocation() {
        if (ActivityCompat.checkSelfPermission(PanggilActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (PanggilActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(PanggilActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        } else {
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            Location location1 = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            Location location2 = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

            if (location != null) {
                double latti = location.getLatitude();
                double longi = location.getLongitude();
                lattitude = String.valueOf(latti);
                longitude = String.valueOf(longi);
                TextView tvLatitude = findViewById(R.id.tvLatitude);
                TextView tvLongitude = findViewById(R.id.tvLongitude);
                tvLatitude.setText(lattitude);
                tvLongitude.setText(longitude);
                //TextView tvHpUser = findViewById(R.id.tvNoTelp);
                //tvHpUser.setText("6285870009919");

            } else if (location1 != null) {
                double latti = location1.getLatitude();
                double longi = location1.getLongitude();
                lattitude = String.valueOf(latti);
                longitude = String.valueOf(longi);
                TextView tvLatitude = findViewById(R.id.tvLatitude);
                TextView tvLongitude = findViewById(R.id.tvLongitude);
                tvLatitude.setText(lattitude);
                tvLongitude.setText(longitude);
                //TextView tvHpUser = findViewById(R.id.tvNoTelp);
                //tvHpUser.setText("6285870009919");


            } else if (location2 != null) {
                double latti = location2.getLatitude();
                double longi = location2.getLongitude();
                lattitude = String.valueOf(latti);
                longitude = String.valueOf(longi);

                TextView tvLatitude = findViewById(R.id.tvLatitude);
                TextView tvLongitude = findViewById(R.id.tvLongitude);
                tvLatitude.setText(lattitude);
                tvLongitude.setText(longitude);
                //TextView tvHpUser = findViewById(R.id.tvNoTelp);
                //tvHpUser.setText("6285870009919");


            } else {

                Toast.makeText(this, "Aktifkan Lokasi Anda", Toast.LENGTH_SHORT).show();

            }
        }
    }

    protected void buildAlertMessageNoGps() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Mohon Aktifkan Lokasi Anda")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    private void simpanlokasi() {
        TextView tvLatitude=findViewById(R.id.tvLatitude);
        String strLatitude = tvLatitude.getText().toString();
        TextView tvLongitude=findViewById(R.id.tvLongitude);
        String strLongitude = tvLongitude.getText().toString();
        TextView tvNohp=findViewById(R.id.tvHpuser);
        String strNoTelpon = tvNohp.getText().toString();
        System.out.println("Latitude: " + strLatitude +"Longitude : " + strLongitude +"NoTelp : " + strNoTelp);
        String laporan = sargapActivity.insertSargap(strLatitude, strLongitude, strNoTelp);
        Toast.makeText(PanggilActivity.this, laporan, Toast.LENGTH_SHORT).show();
        finish();
    }
    private void markerPolresCilacap() {
        mymap.addMarker(new MarkerOptions()
                .position(POLRESCILACAP)
                .title("Polres Cilacap")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerPosTerkan() {
        mymap.addMarker(new MarkerOptions()
                .position(POSTERKAM)
                .title("POS TERKAM")
                .snippet("Jl. A. Yani Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerAdipala() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKADIPALA)
                .title("Polsek Adipala")
                .snippet("Jl. A. Yani Adipala, Adipala, Kalikudi, Kec. Adipala, Kabupaten Cilacap, Jawa Tengah 53271")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerBinangun() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKBINANGUN)
                .title("Polsek Binangun")
                .snippet("Jl. Binangun, Binangun Kulon, Binangun, Kabupaten Cilacap, Jawa Tengah 53281")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerBantarsari() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKBANTARSARI)
                .title("Polsek Bantarsari")
                .snippet("Jl. Raya Bantarsari No.31A, Patengangan, Patenangan, Bantarsari, Kabupaten Cilacap, Jawa Tengah 53258")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerCilacapSelatan() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKCILACAPSELATAN)
                .title("Polsek Cilacap Selatan")
                .snippet("Jalan Dokter Soetomo, Sidakaya Dua, Sidakaya, Kec. Cilacap Sel., Kabupaten Cilacap, Jawa Tengah 53224")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerSatpolair() {
        mymap.addMarker(new MarkerOptions()
                .position(SATPOLAIR)
                .title("SATPOL AIR")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerCilacapTengah() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKCILACAPTENGAH)
                .title("POLSEK CILACAP TENGAH")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerCilacapUtara() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKCILACAPUTARA)
                .title("POLSEK CILACAP UTARA")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerCimanggu() {
        mymap.addMarker(new MarkerOptions()
                    .position(POLSEKCIMANGGU)
                .title("POLSEK CIMANGGU")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerCipari() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKCIPARI)
                .title("POLSEK CIPARI")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerDayeuhluhur() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKDAYEUHLUHUR)
                .title("POLSEK DAYEUHLUHUR")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerGandrungmangu() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKGANDRUNGMANGU)
                .title("POLSEK GANDRUNGMANGU")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerJeruklegi() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKJERUKLEGI)
                .title("POLSEK JERUKLEGI")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerKarangpucung() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKKARANGPUCUNG)
                .title("POlsek Karangpucung")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerKawunganten() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKKAWUNGANTEN)
                .title("POLSEK KAWUNGANTEN")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerKedungreja() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKKEDUNGREJA)
                .title("Polsek Kedungreja")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerKesugihan() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKKESUGIHAN)
                .title("POLSEK KESUGIHAN")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerKroya() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKKROYA)
                .title("POLSEK KROYA")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerMajenang() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKMAJENANG)
                .title("POLSEK MAJENANG")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerMaos() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKMAOS)
                .title("POLSEK MAOS")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerNusawungu() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKNUSAWUNGU)
                .title("POLSEK NUSAWUNGU")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerPatimuan() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKPATIMUAN)
                .title("POLSEK PATIMUAN")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerSampang() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKSAMPANG)
                .title("POLSEK SAMPANGp")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerSidareja() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKSIDAREJA)
                .title("POLSEK SIDAREJA")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerWanareja() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKWANAREJA)
                .title("POLSEK WANAREJA")
                .snippet("Jl. Juanda  Cilacap")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }
    private void markerPelabuhan() {
        mymap.addMarker(new MarkerOptions()
                .position(POLSEKKHUSUSPELABUHAN)
                .title("POLSEK KHUSUS PELABUHAN")
                .snippet("PELABHUHAN TANJUNG INTAN")
                .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.pinpolisi))
        );
    }

    private void panggiltelpon() {
        String nomor = "+62282541110";
        Intent telpon = new Intent(Intent.ACTION_CALL)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        telpon.setData(Uri.fromParts("tel", nomor, null));
        final int simSlotIndex = 1; //Second sim slot

        try {
            @SuppressLint("DiscouragedPrivateApi") final Method getSubIdMethod = SubscriptionManager.class.getDeclaredMethod("getSubId", int.class);
            getSubIdMethod.setAccessible(true);
            final long subIdForSlot = ((long[]) Objects.requireNonNull(getSubIdMethod.invoke(SubscriptionManager.class, simSlotIndex)))[0];

            final ComponentName componentName = new ComponentName("com.android.phone", "com.android.services.telephony.TelephonyConnectionService");
            PhoneAccountHandle phoneAccountHandle = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                phoneAccountHandle = new PhoneAccountHandle(componentName, String.valueOf(subIdForSlot));
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                telpon.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        telpon.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(telpon);
    }
    public void panggilWA(){
        String noWA = "6281235960575";
        boolean isWhatsappInstalled = whatsappInstalledOrNot("com.whatsapp");
        if (isWhatsappInstalled) {

            Intent sendIntent = new Intent("android.intent.action.MAIN");
            sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
            sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(noWA) + "@s.whatsapp.net");//phone number without "+" prefix

            startActivity(sendIntent);
        } else {
            Uri uri = Uri.parse("market://details?id=com.whatsapp");
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            Toast.makeText(this, "WhatsApp not Installed",
                    Toast.LENGTH_SHORT).show();
            startActivity(goToMarket);
        }
    }
    public void panggilSMS(){
        String phoneNo = "6281235960575";
        String message = "Saya membutuhkan bantuan emergency segera";

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, message, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }
    private boolean whatsappInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }

    public void showCilacap(View v) {
        if (mymap == null) {
            return;
        }
        mymap.moveCamera(CameraUpdateFactory.newLatLngZoom(CILACAP, 9f));

        GeoJsonLayer geoJsonLayer = null;
        try {
            geoJsonLayer = new GeoJsonLayer(mymap, R.raw.kabcilacap,
                    getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GeoJsonPolygonStyle styleCilacap = geoJsonLayer.getDefaultPolygonStyle();
        styleCilacap.setStrokeWidth(3f);
        styleCilacap.setFillColor(ContextCompat.getColor(this, R.color.kolorbapakkau));
        styleCilacap.setStrokeColor(ContextCompat.getColor(this, R.color.black));
        geoJsonLayer.addLayerToMap();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mymap = googleMap;
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mymap.setMyLocationEnabled(true);
        mymap.getUiSettings().setZoomControlsEnabled(true);
        mymap.getUiSettings().setZoomControlsEnabled(true);
        mymap.getUiSettings().setAllGesturesEnabled(true);
        showCilacap(null);
        markerPolresCilacap();
        markerAdipala();
        markerBantarsari();
        markerBinangun();
        markerCilacapSelatan();
        markerCilacapTengah();
        markerCilacapUtara();
        markerCimanggu();
        markerCipari();
        markerDayeuhluhur();
        markerGandrungmangu();
        markerJeruklegi();
        markerKarangpucung();
        markerKawunganten();
        markerKedungreja();
        markerKesugihan();
        markerKroya();
        markerMajenang();
        markerMaos();
        markerWanareja();
        markerNusawungu();
        markerPatimuan();
        markerSampang();
        markerSidareja();
        markerSatpolair();
        markerPosTerkan();
        markerPelabuhan();
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

    }
    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}