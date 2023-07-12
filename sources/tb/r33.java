package tb;

import android.os.HandlerThread;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class r33 {
    public static HandlerThread a;

    static {
        HandlerThread handlerThread = new HandlerThread("efs-base", 10);
        a = handlerThread;
        handlerThread.start();
    }
}
