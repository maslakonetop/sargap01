package id.co.gesangmultimedia.sergap;
/*
    Create by Antony Tri Susanto Itran for Gesang Multimedia
    Sergap Project 2019
    Sargap01 Project Februari 2020
    SAR Polres Cilacap Oktober 2020
    Client menelpon, menyimpan data Lat Long di Firebase
    Dialog box alert muncul, simpan ke Firebase
    Dilanjutkan dengan menelpon ke nomor yang sudah ditentukan
 */

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.lang.reflect.Method;

import static id.co.gesangmultimedia.sergap.R.drawable.ic_twotone_phone_android_24;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager  tm=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);

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
        }
        ImageButton imb_popupMenu = findViewById(R.id.popup);
        imb_popupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
        imb_popupMenu = findViewById(R.id.popup);
        imb_popupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
        imb_popupMenu = findViewById(R.id.home);
        imb_popupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBeranda(v);
            }
        });
        imb_popupMenu = findViewById(R.id.exit);
        imb_popupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMetu(v);
            }
        });
    }

    private void showMetu(View v) {
        finish();
        System.exit(0);
    }

    private void showBeranda(View v) {
        Intent beranda = new Intent(MainActivity.this, MainActivity.class);
        startActivity(beranda);
    }
    private void showPopupMenu(View v) {
        Intent abud = new Intent(MainActivity.this, About.class);
        startActivity(abud);
    }

    private void tampilDialog() {
        DialogInterface.OnClickListener dialogClickListener = (dialog, which) -> {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    panggil(null);
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Anda yakin akan menelpon, \nAnda akan dikenakan biaya standar")
                .setPositiveButton("Ya", dialogClickListener)
                .setNegativeButton("Tidak", dialogClickListener).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    public void panggil(View view) {
        String nomor = "+62282541110";
        Intent telpon = new Intent(Intent.ACTION_CALL)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        telpon.setData(Uri.fromParts("tel", nomor, null));
        final int simSlotIndex = 1; //Second sim slot

        try {
            final Method getSubIdMethod = SubscriptionManager.class.getDeclaredMethod("getSubId", int.class);
            getSubIdMethod.setAccessible(true);
            final long subIdForSlot = ((long[]) getSubIdMethod.invoke(SubscriptionManager.class, simSlotIndex))[0];

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

    public void info(View view) {
        Intent buka = new Intent(MainActivity.this, info.class);
        startActivity(buka);
    }

    public void telpon(View view) {
        tampilDialog();
    }
}