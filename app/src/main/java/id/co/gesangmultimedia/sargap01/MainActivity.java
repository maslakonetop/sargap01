package id.co.gesangmultimedia.sargap01;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Method;

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
}