package id.co.gesangmultimedia.sergap;
/*
    Create by Antony Tri Susanto Itran for Gesang Multimedia
    Sergap Project 2019
    Sargap01 Project Februari 2020
    SAR Polres Cilacap Oktober 2020
    SAR Polres Cilacap with SAR Operator web version
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
    }
}