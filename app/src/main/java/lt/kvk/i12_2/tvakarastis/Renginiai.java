package lt.kvk.i12_2.tvakarastis;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by Meskius on 2017-12-03.
 */

public class Renginiai extends AppCompatActivity {
    WebView ww;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kalendoriuus);
        wwShit();
    }

    private void wwShit() {
        ww = (WebView)findViewById(R.id.ww);
        WebSettings webSettings = ww.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ww.getSettings().setSupportZoom(true);
        ww.getSettings().setBuiltInZoomControls(true);
        ww.getSettings().setDisplayZoomControls(false);
        ww.setWebChromeClient(new WebChromeClient());
        //ww.loadUrl("http://gmail.com/");
        ww.loadUrl("https://calendar.google.com/calendar/htmlembed?src=kvksadock@gmail.com&mode=MONTH");
        ww.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                ww.loadUrl("javascript:$(document.querySelectorAll(\"table tbody tr  td\")[5]).hide();");
                ww.loadUrl("javascript:$(document.querySelectorAll(\"table tbody tr  td\")[4]).hide();");
                ww.loadUrl("javascript:$(document.querySelector(\".tab-name\")).hide();");
            }
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Context context = getApplicationContext();
                Toast.makeText(context, "Oh no!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
