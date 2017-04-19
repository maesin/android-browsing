package jp.renjaku.examples.browsing;

import android.content.Intent;
import android.os.Build;
import android.service.quicksettings.TileService;
import android.support.annotation.RequiresApi;
import android.util.Log;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MyTileService extends TileService {

    static final String TAG = "####";

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate is called");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand is called");
        return START_STICKY;
    }

    @Override
    public void onClick() {
        Log.d(TAG, "onClick is called");
    }

    @Override
    public void onTileAdded(){
        Log.d(TAG, "onTileAdded is called");
    }

    @Override
    public void onTileRemoved(){
        Log.d(TAG, "onTileRemoved is called");
    }

    @Override
    public void onStartListening(){
        Log.d(TAG, "onStartListening is called");
    }

    @Override
    public void onStopListening(){
        Log.d(TAG, "onStopListening is called");
    }
}
