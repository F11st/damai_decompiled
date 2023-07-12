package tb;

import com.ali.alihadeviceevaluator.old.CalScore;
import com.ali.alihadeviceevaluator.old.HardWareInfo;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class pv0 implements CalScore {
    @Override // com.ali.alihadeviceevaluator.old.CalScore
    public int getScore(HardWareInfo hardWareInfo) {
        if (hardWareInfo == null) {
            return 0;
        }
        int i = hardWareInfo.f;
        if (i >= 16) {
            return 10;
        }
        if (i >= 8) {
            return 9;
        }
        if (i >= 6) {
            return 8;
        }
        if (i >= 4) {
            return 6;
        }
        return i >= 2 ? 4 : 2;
    }
}
