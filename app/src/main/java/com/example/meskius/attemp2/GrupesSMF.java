package com.example.meskius.attemp2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by Meskius on 10/24/2017.
 */

public class GrupesSMF extends AppCompatActivity {
    WebView ww;
    String programText[] = {"--pasirinkti--","Ištestinės","Nuolatinės"};
    String yearMetaiNL[] = {"--pasirinkti--", "1","2","3"};
    String yearMetaiIST[] = {"--pasirinkti--", "1","2","3","4"};
    String groupNL1[] = {"--pasirinkti--","A 16-1","As 15-1","As 15-1 1 pog","As 15-1 2 pog","BA 23-1","BA 23-1 1 pog","BA 23-1 2 pog","F 19-1","F 19-1 1 pog","F 19-1 2 pog","F 19-1 3 pog","F 19-1 4 pog","F 19-1 5 pog","IPP 7-1","IPP 7-1 1 pog","LV 20-1","LV 20-1 1 pog","LV 20-1 2 pog","LV 20-1 3 pog","LV 20-1 4 pog","LV 20-1 5 pog","LV 20-1 6 pog","SP 4-1","TA 19-1","TA 19-1 1 pog","TA 19-1 2 pog","TA-1"};
    String groupNL2[] = {"--pasirinkti--","A 15-2","A 15-2 1 pog","A 15-2 2 pog","A 15-2 3 pog","A 15-2 4 pog","BA 22-2","BA 22-2 1 pog","BA 22-2 2 pog","BA 22-2 3 pog","ERASMUS","F 18-2","F 18-2 1 pog","F 18-2 2 pog","F 18-2 3 pog","F 18-2 4 pog","IPP 6-2","IPP 6-2 3 pog","IPP 6-2 4 pog","IPP 6-2 5 pog","IPP 6-2 6 pog","IPP 6-2 7 pog","IPP 6-2 8 pog","IPP 6-2 9 pog","LV 19-2","LV 19-2 1 pog","LV 19-2 2 pog","LV 19-2 3 pog","LV 19-2 4 pog","LV 19-2 5 pog","LV 19-2 6 pog","LV 19-2 7 pog","SP 3-2","TA 18-2","TA 18-2 1 pog","TA 18-2 2 pog","TA 18-2 3 pog","TA 18-2 4 pog","TA-3","VV 23-2"};
    String groupNL3[] = {"--pasirinkti--","A 14-3","BA 21-3","BA 21-3 1 pog","BA 21-3 2 pog","F 17-3","F 17-3 1 pog","F 17-3 2 pog","IPP 5-3","KV 13-3","LV 18-3","SP 2-3","SPV 6-3","TA 17-3","TA 17-3 3 pog","TA 17-3 4 pog","TA 17-3 5 pog","TA 17-3 6 pog","VV 22-3"};
    String groupIST1[] = {"--pasirinkti--","BAi 18-1","BAi 18-1 1pog","BAi 18-1 2 pog","Fi 14-1","IPPi 6-1","IPPi 6-1 1 pog","IPPi 6-1 2 pog","IPPi 6-1 3 pog","IPPi 6-1 4 pog","LVi 15-1","LVi 15-1 1 pog","LVi 15-1 2 pog"};
    String groupIST2[] = {"--pasirinkti--","BAi 17-2","BAi 17-2 1 pog","BAi 17-2 2 pog","BAi 17-2 3 pog","BAi 17-2 4 pog","BAi 17-2 5 pog","Fi 13-2","Fi 13-2 1 pog","Fi 13-2 2 pog","IPPi 5-2","IPPi 5-2 1 pog","IPPi 5-2 2 pog","IPPi 5-2 3 pog","IPPi 5-2 4 pog","LVi 14-2","LVi 14-2 1 pog","LVi 14-2 2 pog"};
    String groupIST3[] = {"--pasirinkti--","Ai 14-3","BAi 16-3","Fi 12-3","LVi1 3-3","VVi 11-3","VVi 11-3 1 pog","VVi 11-3 2 pog"};
    String groupIST4[] = {"--pasirinkti--","Ai 13-4","BAi 15-4","Fi 11-4","LVi 12-4","LVi 12-4 1 pog","LVi 12-4 2 pog"};



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ww= (WebView)findViewById(R.id.ww);
        WebSettings webSettings = ww.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ww.getSettings().setSupportZoom(true);
        ww.getSettings().setBuiltInZoomControls(true);
        ww.getSettings().setDisplayZoomControls(false);
        ww.setWebChromeClient(new WebChromeClient());
        //ww.loadUrl("http://google.com");
        ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_smf/groups.php");




    }
}
