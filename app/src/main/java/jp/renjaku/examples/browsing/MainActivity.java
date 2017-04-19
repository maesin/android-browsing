package jp.renjaku.examples.browsing;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Browser;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * ブラウザで開く.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String url = getString(R.string.endpoint);

        String auth = getString(
                R.string.authorization_header_value,
                getString(R.string.app_name),
                getString(R.string.access_token));

        final Bundle headers = new Bundle();
        headers.putString(getString(R.string.authorization_header_name), auth);

        findViewById(R.id.open_in_browser).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // リクエストヘッダを指定してブラウザを開く.
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.putExtra(Browser.EXTRA_APPLICATION_ID, BuildConfig.APPLICATION_ID);
                        intent.putExtra(Browser.EXTRA_CREATE_NEW_TAB, true);
                        intent.putExtra(Browser.EXTRA_HEADERS, headers);
                        startActivity(intent);
                    }
                });

        findViewById(R.id.open_in_custom_tabs).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Chrome Custom Tabs で開く.
                        // バージョンによっては、システム既定のブラウザで開かれる.
                        jp.renjaku.android.browser.Browser.open(MainActivity.this, url, headers);
                    }
                });

        findViewById(R.id.open_in_web_view).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // WebView で開く.
                        // Requires <uses-permission android:name="android.permission.INTERNET" />.
                        Intent intent = new Intent(getApplicationContext(),
                                WebViewActivity.class);
                        intent.putExtra("url", url);
                        intent.putExtra("headers", headers);
                        startActivity(intent);
                    }
                });
    }
}
