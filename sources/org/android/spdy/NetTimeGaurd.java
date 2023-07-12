package org.android.spdy;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NetTimeGaurd {
    public static final int CREATE = 0;
    public static final int ERROR = 2;
    public static final int PING = 1;
    public static final int STREAM = 3;
    private static final long calltime = 10;
    private static final long total = 50;
    private static long[] totaltime = new long[4];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long begin() {
        if (SpdyAgent.enableTimeGaurd) {
            return System.currentTimeMillis();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void end(String str, int i, long j) {
        if (SpdyAgent.enableTimeGaurd) {
            long currentTimeMillis = System.currentTimeMillis() - j;
            long[] jArr = totaltime;
            jArr[i] = jArr[i] + currentTimeMillis;
            Log.i("NetTimeGaurd", "NetTimeGaurd[end]" + str + " time=" + currentTimeMillis + " total=" + totaltime[i]);
            if (currentTimeMillis <= 10) {
                return;
            }
            throw new SpdyErrorException("CallBack:" + str + " timeconsuming:" + currentTimeMillis + "  mustlessthan:10", -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void finish(int i) {
        if (SpdyAgent.enableTimeGaurd) {
            Log.i("NetTimeGaurd", "NetTimeGaurd[finish]:time=" + totaltime[i]);
            if (totaltime[i] <= 50) {
                return;
            }
            throw new SpdyErrorException("CallBack totaltimeconsuming:" + totaltime[i] + "  mustlessthan:50", -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void start(int i) {
        if (SpdyAgent.enableTimeGaurd) {
            totaltime[i] = 0;
        }
    }
}
