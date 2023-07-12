package tb;

import com.ali.alihadeviceevaluator.old.CalScore;
import com.ali.alihadeviceevaluator.old.HardWareInfo;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class sv0 implements CalScore {
    public float a = 2.0f;

    @Override // com.ali.alihadeviceevaluator.old.CalScore
    public int getScore(HardWareInfo hardWareInfo) {
        float f = this.a;
        if (f > 4.0d) {
            return 10;
        }
        if (f >= 4.0d) {
            return 9;
        }
        if (f >= 3.2d) {
            return 8;
        }
        if (f >= 3.1d) {
            return 7;
        }
        if (f >= 3.0d) {
            return 6;
        }
        return ((double) f) >= 2.0d ? 3 : 8;
    }
}
