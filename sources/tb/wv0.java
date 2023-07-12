package tb;

import com.ali.alihadeviceevaluator.old.CalScore;
import com.ali.alihadeviceevaluator.old.HardWareInfo;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class wv0 implements CalScore {
    public long a = 0;

    @Override // com.ali.alihadeviceevaluator.old.CalScore
    public int getScore(HardWareInfo hardWareInfo) {
        long j = this.a;
        if (j >= 6144) {
            return 10;
        }
        if (j >= 4096) {
            return 9;
        }
        if (j >= 3072) {
            return 7;
        }
        if (j >= 2048) {
            return 5;
        }
        if (j >= 1024) {
            return 3;
        }
        return j >= 512 ? 1 : 8;
    }
}
