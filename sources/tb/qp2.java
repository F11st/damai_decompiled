package tb;

import android.net.TrafficStats;
import android.os.Process;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class qp2 {
    private static boolean a = false;
    private static int b = -1;
    private static long[] c = new long[2];

    static {
        int myUid = Process.myUid();
        b = myUid;
        long[] jArr = c;
        long uidRxBytes = TrafficStats.getUidRxBytes(myUid);
        boolean z = false;
        jArr[0] = uidRxBytes;
        c[1] = TrafficStats.getUidTxBytes(b);
        long[] jArr2 = c;
        if (jArr2[0] >= 0 && jArr2[1] >= 0) {
            z = true;
        }
        a = z;
    }

    public static long[] a() {
        int i;
        if (a && (i = b) > 0) {
            c[0] = TrafficStats.getUidRxBytes(i);
            c[1] = TrafficStats.getUidTxBytes(b);
            return c;
        }
        return c;
    }
}
