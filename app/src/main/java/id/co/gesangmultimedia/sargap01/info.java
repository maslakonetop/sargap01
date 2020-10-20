package id.co.gesangmultimedia.sargap01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import android.telephony.SubscriptionManager;
import android.view.View;

import java.lang.reflect.Method;

public class info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    public void callpolres(View view) {
        String nomor = "0282541110";
        Intent telpolres = new Intent(Intent.ACTION_CALL)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        telpolres.setData(Uri.fromParts("tel", nomor, null));
        final int simSlotIndex = 1; //Second sim slot

        try {
            final Method getSubIdMethod = SubscriptionManager.class.getDeclaredMethod("getSubId", int.class);
            getSubIdMethod.setAccessible(true);
            final long subIdForSlot = ((long[]) getSubIdMethod.invoke(SubscriptionManager.class, simSlotIndex))[0];

            final ComponentName componentName = new ComponentName("com.android.phone", "com.android.services.telephony.TelephonyConnectionService");
            final PhoneAccountHandle phoneAccountHandle = new PhoneAccountHandle(componentName, String.valueOf(subIdForSlot));
            telpolres.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        telpolres.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(telpolres);
    }

    public void calljashar(View view) {
        String nomor = "0281633961";
        Intent teljashar = new Intent(Intent.ACTION_CALL)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        teljashar.setData(Uri.fromParts("tel", nomor, null));
        final int simSlotIndex = 1; //Second sim slot

        try {
            final Method getSubIdMethod = SubscriptionManager.class.getDeclaredMethod("getSubId", int.class);
            getSubIdMethod.setAccessible(true);
            final long subIdForSlot = ((long[]) getSubIdMethod.invoke(SubscriptionManager.class, simSlotIndex))[0];

            final ComponentName componentName = new ComponentName("com.android.phone", "com.android.services.telephony.TelephonyConnectionService");
            final PhoneAccountHandle phoneAccountHandle = new PhoneAccountHandle(componentName, String.valueOf(subIdForSlot));
            teljashar.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        teljashar.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(teljashar);
    }

    public void calldishub(View view) {
        String nomor = "0282534725";
        Intent teldishub = new Intent(Intent.ACTION_CALL)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        teldishub.setData(Uri.fromParts("tel", nomor, null));
        final int simSlotIndex = 1; //Second sim slot

        try {
            final Method getSubIdMethod = SubscriptionManager.class.getDeclaredMethod("getSubId", int.class);
            getSubIdMethod.setAccessible(true);
            final long subIdForSlot = ((long[]) getSubIdMethod.invoke(SubscriptionManager.class, simSlotIndex))[0];

            final ComponentName componentName = new ComponentName("com.android.phone", "com.android.services.telephony.TelephonyConnectionService");
            final PhoneAccountHandle phoneAccountHandle = new PhoneAccountHandle(componentName, String.valueOf(subIdForSlot));
            teldishub.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        teldishub.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(teldishub);
    }

    public void calldpu(View view) {
        String nomor = "0282545603";
        Intent teldpu = new Intent(Intent.ACTION_CALL)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        teldpu.setData(Uri.fromParts("tel", nomor, null));
        final int simSlotIndex = 1; //Second sim slot

        try {
            final Method getSubIdMethod = SubscriptionManager.class.getDeclaredMethod("getSubId", int.class);
            getSubIdMethod.setAccessible(true);
            final long subIdForSlot = ((long[]) getSubIdMethod.invoke(SubscriptionManager.class, simSlotIndex))[0];

            final ComponentName componentName = new ComponentName("com.android.phone", "com.android.services.telephony.TelephonyConnectionService");
            final PhoneAccountHandle phoneAccountHandle = new PhoneAccountHandle(componentName, String.valueOf(subIdForSlot));
            teldpu.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        teldpu.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(teldpu);
    }

    public void calldinkes(View view) {
        String nomor = "119";
        Intent teldinkes = new Intent(Intent.ACTION_CALL)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        teldinkes.setData(Uri.fromParts("tel", nomor, null));
        final int simSlotIndex = 1; //Second sim slot

        try {
            final Method getSubIdMethod = SubscriptionManager.class.getDeclaredMethod("getSubId", int.class);
            getSubIdMethod.setAccessible(true);
            final long subIdForSlot = ((long[]) getSubIdMethod.invoke(SubscriptionManager.class, simSlotIndex))[0];

            final ComponentName componentName = new ComponentName("com.android.phone", "com.android.services.telephony.TelephonyConnectionService");
            final PhoneAccountHandle phoneAccountHandle = new PhoneAccountHandle(componentName, String.valueOf(subIdForSlot));
            teldinkes.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        teldinkes.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(teldinkes);
    }

    public void callbpbd(View view) {
        String nomor = "0282533520";
        Intent telbpbd = new Intent(Intent.ACTION_CALL)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        telbpbd.setData(Uri.fromParts("tel", nomor, null));
        final int simSlotIndex = 1; //Second sim slot

        try {
            final Method getSubIdMethod = SubscriptionManager.class.getDeclaredMethod("getSubId", int.class);
            getSubIdMethod.setAccessible(true);
            final long subIdForSlot = ((long[]) getSubIdMethod.invoke(SubscriptionManager.class, simSlotIndex))[0];

            final ComponentName componentName = new ComponentName("com.android.phone", "com.android.services.telephony.TelephonyConnectionService");
            final PhoneAccountHandle phoneAccountHandle = new PhoneAccountHandle(componentName, String.valueOf(subIdForSlot));
            telbpbd.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        telbpbd.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(telbpbd);
    }

    public void callpmi(View view) {
        String nomor = "0282531706";
        Intent telpmi = new Intent(Intent.ACTION_CALL)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        telpmi.setData(Uri.fromParts("tel", nomor, null));
        final int simSlotIndex = 1; //Second sim slot

        try {
            final Method getSubIdMethod = SubscriptionManager.class.getDeclaredMethod("getSubId", int.class);
            getSubIdMethod.setAccessible(true);
            final long subIdForSlot = ((long[]) getSubIdMethod.invoke(SubscriptionManager.class, simSlotIndex))[0];

            final ComponentName componentName = new ComponentName("com.android.phone", "com.android.services.telephony.TelephonyConnectionService");
            final PhoneAccountHandle phoneAccountHandle = new PhoneAccountHandle(componentName, String.valueOf(subIdForSlot));
            telpmi.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        telpmi.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(telpmi);
    }

    public void callrsi(View view) {
        String nomor = "0282542396";
        Intent telrsi = new Intent(Intent.ACTION_CALL)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        telrsi.setData(Uri.fromParts("tel", nomor, null));
        final int simSlotIndex = 1; //Second sim slot

        try {
            final Method getSubIdMethod = SubscriptionManager.class.getDeclaredMethod("getSubId", int.class);
            getSubIdMethod.setAccessible(true);
            final long subIdForSlot = ((long[]) getSubIdMethod.invoke(SubscriptionManager.class, simSlotIndex))[0];

            final ComponentName componentName = new ComponentName("com.android.phone", "com.android.services.telephony.TelephonyConnectionService");
            final PhoneAccountHandle phoneAccountHandle = new PhoneAccountHandle(componentName, String.valueOf(subIdForSlot));
            telrsi.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        telrsi.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(telrsi);
    }

    public void calldamkar(View view) {
        String nomor = "0282537431";
        Intent teldamkar = new Intent(Intent.ACTION_CALL)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        teldamkar.setData(Uri.fromParts("tel", nomor, null));
        final int simSlotIndex = 1; //Second sim slot

        try {
            final Method getSubIdMethod = SubscriptionManager.class.getDeclaredMethod("getSubId", int.class);
            getSubIdMethod.setAccessible(true);
            final long subIdForSlot = ((long[]) getSubIdMethod.invoke(SubscriptionManager.class, simSlotIndex))[0];

            final ComponentName componentName = new ComponentName("com.android.phone", "com.android.services.telephony.TelephonyConnectionService");
            final PhoneAccountHandle phoneAccountHandle = new PhoneAccountHandle(componentName, String.valueOf(subIdForSlot));
            teldamkar.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        teldamkar.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(teldamkar);
    }

    public void callpolpp(View view) {
        String nomor = "0282534093";
        Intent telpolpp = new Intent(Intent.ACTION_CALL)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        telpolpp.setData(Uri.fromParts("tel", nomor, null));
        final int simSlotIndex = 1; //Second sim slot

        try {
            final Method getSubIdMethod = SubscriptionManager.class.getDeclaredMethod("getSubId", int.class);
            getSubIdMethod.setAccessible(true);
            final long subIdForSlot = ((long[]) getSubIdMethod.invoke(SubscriptionManager.class, simSlotIndex))[0];

            final ComponentName componentName = new ComponentName("com.android.phone", "com.android.services.telephony.TelephonyConnectionService");
            final PhoneAccountHandle phoneAccountHandle = new PhoneAccountHandle(componentName, String.valueOf(subIdForSlot));
            telpolpp.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        telpolpp.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(telpolpp);
    }
    public void callsargap(View view) {
        String nomor = "0282534093";
        Intent telpsargap = new Intent(Intent.ACTION_CALL)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        telpsargap.setData(Uri.fromParts("tel", nomor, null));
        final int simSlotIndex = 1; //Second sim slot

        try {
            final Method getSubIdMethod = SubscriptionManager.class.getDeclaredMethod("getSubId", int.class);
            getSubIdMethod.setAccessible(true);
            final long subIdForSlot = ((long[]) getSubIdMethod.invoke(SubscriptionManager.class, simSlotIndex))[0];

            final ComponentName componentName = new ComponentName("com.android.phone", "com.android.services.telephony.TelephonyConnectionService");
            final PhoneAccountHandle phoneAccountHandle = new PhoneAccountHandle(componentName, String.valueOf(subIdForSlot));
            telpsargap.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        telpsargap.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(telpsargap);
    }
}
