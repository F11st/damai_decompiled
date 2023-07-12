package android.taobao.windvane.extra.uc;

import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVThread extends HandlerThread {
    private Handler mHandler;

    public WVThread(String str) {
        super(str);
        start();
        this.mHandler = new Handler(getLooper());
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        return super.quit();
    }

    public WVThread(String str, int i) {
        super(str, i);
        start();
        this.mHandler = new Handler(getLooper());
    }

    public WVThread(String str, Handler.Callback callback) {
        super(str);
        start();
        this.mHandler = new Handler(getLooper(), callback);
    }

    public WVThread(String str, int i, Handler.Callback callback) {
        super(str, i);
        start();
        this.mHandler = new Handler(getLooper(), callback);
    }
}
