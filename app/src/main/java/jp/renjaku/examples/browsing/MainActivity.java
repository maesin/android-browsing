package jp.renjaku.examples.browsing;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Browser;
import android.support.customtabs.CustomTabsIntent;
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

        final Uri uri = Uri.parse("http://httpbin.org/headers");

        final Bundle headers = new Bundle();
        headers.putString("X-Token", "mine");

        findViewById(R.id.open_in_browser).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // リクエストヘッダを指定してブラウザを開く.
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        intent.putExtra(Browser.EXTRA_APPLICATION_ID, BuildConfig.APPLICATION_ID);
                        intent.putExtra(Browser.EXTRA_CREATE_NEW_TAB, true);
                        intent.putExtra(Browser.EXTRA_HEADERS, headers);
                        startActivity(intent);
                    }
                });

        findViewById(R.id.open_in_app).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // カスタムタブで開く.
                        CustomTabsIntent customTabsIntent =
                                new CustomTabsIntent.Builder()
                                        .setShowTitle(true)
                                        .addDefaultShareMenuItem()
                                        .build();

                        customTabsIntent.intent.putExtra(Browser.EXTRA_HEADERS, headers);

                        customTabsIntent.launchUrl(MainActivity.this, uri);
                    }
                });
    }
}
