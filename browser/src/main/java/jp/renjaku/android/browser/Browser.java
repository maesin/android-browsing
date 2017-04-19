package jp.renjaku.android.browser;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;

import static android.provider.Browser.EXTRA_HEADERS;

public class Browser {

    public static void open(Context context, String url) {
        open(context, url, null);
    }

    public static void open(Context context, String url, Bundle headers) {
        CustomTabsIntent customTabsIntent =
                new CustomTabsIntent.Builder()
                        .setShowTitle(true)
                        .addDefaultShareMenuItem()
                        .build();

        customTabsIntent.intent.putExtra(EXTRA_HEADERS, headers);
        customTabsIntent.launchUrl(context, Uri.parse(url));
    }
}
