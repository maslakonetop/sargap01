package id.co.gesangmultimedia.sergap;

import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;

public class Sosmed extends Fragment {
   Button btnLogo, btnFacebook, btnInstagram, btnTwitter;
   WebView browser;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sosmed, container, false);
        final WebView browser = (WebView) view.findViewById(R.id.wvTribrata);
        browser.loadUrl("https://tribratanews.jateng.polri.go.id/");
        browser.getSettings().setUseWideViewPort(true);
        browser.getSettings().setLoadWithOverviewMode(true);

        Button btnLogo = (Button) view.findViewById(R.id.btnLogo);
        btnLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final WebView browser = (WebView) view.findViewById(R.id.wvTribrata);
                browser.loadUrl("https://tribratanews.jateng.polri.go.id/");
                browser.getSettings().setUseWideViewPort(true);
                browser.getSettings().setLoadWithOverviewMode(true);
            }
        });

        Button btnFacebook = (Button) view.findViewById(R.id.btnFacebook);
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final WebView browser = (WebView) view.findViewById(R.id.wvTribrata);
                browser.loadUrl("https://www.facebook.com/polrescilacap");
                browser.getSettings().setUseWideViewPort(true);
                browser.getSettings().setLoadWithOverviewMode(true);
            }
        });

        Button btnInstagram = (Button) view.findViewById(R.id.btnInstagram);
        btnInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final WebView browser = (WebView) view.findViewById(R.id.wvTribrata);
                browser.loadUrl("https://www.instagram.com/team_terkam_polrescilacap/");
                browser.getSettings().setUseWideViewPort(true);
                browser.getSettings().setLoadWithOverviewMode(true);
            }
        });

        Button btnTwitter = (Button) view.findViewById(R.id.btnTwitter);
        btnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final WebView browser = (WebView) view.findViewById(R.id.wvTribrata);
                browser.loadUrl("https://twitter.com/BinmasCilacap");
                browser.getSettings().setUseWideViewPort(true);
                browser.getSettings().setLoadWithOverviewMode(true);
            }
        });
        return view;
    }
}