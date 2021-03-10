package id.co.gesangmultimedia.sergap;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class FragmentUtama extends Fragment {
    Button btnSargap;
   EditText edtNomerku;
    String strNoHape;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_utama, container, false);
        Button btnSargap = view.findViewById(R.id.btnSargap);
        btnSargap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtNomerku = view.findViewById(R.id.edtNomerku);
                String strNoHape =  edtNomerku.getText().toString();
                if (strNoHape.equals("")){
                    Toast.makeText(getActivity(),"Kolom Nomor Tidak Boleh Kosong",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(getContext().getApplicationContext(), PanggilActivity.class);
                    intent.putExtra("NomerHP", strNoHape);
                    getActivity().startActivity(intent);
                }
            }
        });
        return view;
    }

}