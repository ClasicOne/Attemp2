package lt.kvk.i12_2.tvakarastis;

import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import lt.kvk.i12_2.tvakarastis.R;

/**
 * Created by Meskius on 3/12/2018.
 */

public class WebViewControls {
    public static void click(WebView ww, String jsClick) {
        ww.loadUrl(jsClick);
    }

    public static void hide(WebView ww, String str) {
        switch (str) {
            case "group":
                //ww.loadUrl("javascript:$(document.querySelector(\"#data_form\")).hide()");
                ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[0]).hide()");
                ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[1]).hide()");
                ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[2]).hide()");
                ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[3]).hide()");
                ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr td\")[8]).hide()");
                ww.loadUrl("javascript:$(document.querySelectorAll(\"tbody tr button\")[0]).hide()");
                ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[5]).hide()");
                ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[6]).hide()");
                ww.loadUrl("javascript:$(document.querySelector(\".main_menu\")).hide()");
                ww.loadUrl("javascript:$(document.querySelector(\"#customMessage\")).hide()");
                ww.loadUrl("javascript:$(document.querySelector(\"#adminError\")).hide()");
                ww.loadUrl("javascript:$(\"html\").css(\"margin-top\", 0);");
                ww.loadUrl("javascript:document.body.style.marginTop=-10");
                ww.loadUrl("javascript:$(document.querySelectorAll(\"div\")[4]).hide()");
                ww.loadUrl("javascript:$(document.querySelectorAll(\"div\")[3]).hide()");
                break;
            case "classroom":
                //ww.loadUrl("javascript:$(document.querySelector(\"#data_form\")).hide()");
                ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[0]).hide()");
                ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[2]).hide()");
                ww.loadUrl("javascript:$(document.querySelectorAll(\"table td\")[3]).hide()");
                ww.loadUrl("javascript:$(document.querySelectorAll(\"table button\")[0]).hide()");
                ww.loadUrl("javascript:$(document.querySelectorAll(\"tbody tr\")[4]).hide()");
                ww.loadUrl("javascript:$(document.querySelector(\".main_menu\")).hide()");
                ww.loadUrl("javascript:$(document.querySelector(\"#customMessage\")).hide()");
                ww.loadUrl("javascript:$(document.querySelector(\"#adminError\")).hide()");
                ww.loadUrl("javascript:$(\"html\").css(\"margin-top\", 0);");
                ww.loadUrl("javascript:document.body.style.marginTop=-10");
                ww.loadUrl("javascript:$(document.querySelectorAll(\"div\")[3]).hide()");
                ww.loadUrl("javascript:$(document.querySelectorAll(\"div\")[2]).hide()");
                break;
            case "prof":
                break;
            default:
                break;
        }

    }

    public static void webViewSetting(WebView ww) {

        WebSettings webSettings = ww.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ww.getSettings().setSupportZoom(true);
        ww.getSettings().setBuiltInZoomControls(true);
        ww.getSettings().setDisplayZoomControls(false);
        ww.setWebChromeClient(new WebChromeClient());
        //ww.loadUrl("http://google.com");

    }

    public static void selectionOption(String pasirinkimas, String val, WebView ww) {

        ww.loadUrl("javascript:$('#" + pasirinkimas + "').val('" + val + "').change();");

    }

}
