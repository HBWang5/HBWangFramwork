package com.hbwang.player.servce;


import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * ----------Dragon be here!----------/
 * ━━━━━━神兽出没━━━━━━
 * Created by HBWang on 2019/3/19-17:18
 */
public abstract class HBWangBaseService extends Service implements IMideoPlayer {
    private static IMideoPlayer mIMideoPlayer;

    @Nullable
    @Override
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public final void onCreate() {
        super.onCreate();
        mIMideoPlayer = this;
        initMideoPlayer();
    }

    @Override
    public final void unbindService(ServiceConnection conn) {
        super.unbindService(conn);
    }

    @Override
    public final boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public final int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    protected abstract void initMideoPlayer();

    public static IMideoPlayer getMideoPlayerServic() {
        return mIMideoPlayer;
    }
}
