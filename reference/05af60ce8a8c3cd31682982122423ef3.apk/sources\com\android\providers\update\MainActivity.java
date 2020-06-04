package com.android.providers.update;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import com.ninepvi.shield.R;

public class MainActivity extends Activity {
    Button a = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main);
        System.out.println("user_agent:" + new WebView(this).getSettings().getUserAgentString());
        this.a.setOnClickListener(new g(this));
    }
}
