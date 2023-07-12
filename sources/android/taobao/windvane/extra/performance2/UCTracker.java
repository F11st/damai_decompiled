package android.taobao.windvane.extra.performance2;

import android.taobao.windvane.extra.performance.WVAPMManager;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class UCTracker {
    public static void commitUCT2(String str, long j) {
        WVAPMManager wVAPMManager = new WVAPMManager("WindVane.UCT2");
        wVAPMManager.onStart();
        wVAPMManager.addProperty("url", str);
        wVAPMManager.onStage("T2", j);
        wVAPMManager.onEnd();
    }
}
