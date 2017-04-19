package jp.renjaku.examples.browsing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import java.util.HashMap;
import java.util.Map;

/**
 * WebView Activity.
 */
public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Intent intent = getIntent();

        if (intent != null) {
            String url = intent.getStringExtra("url");

            if (url != null) {
                Bundle headers = intent.getBundleExtra("headers");
                Map<String, String> additional = new HashMap<>();

                if (headers != null) {
                    for (String key : headers.keySet()) {
                        additional.put(key, (String) headers.get(key));
                    }
                }

                ((WebView) findViewById(R.id.web_view)).loadUrl(url, additional);
            }
        }
    }
}
