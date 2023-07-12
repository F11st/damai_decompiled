package tb;

import com.ali.alihadeviceevaluator.old.CalScore;
import com.ali.alihadeviceevaluator.old.HardWareInfo;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class uv0 implements CalScore {
    @Override // com.ali.alihadeviceevaluator.old.CalScore
    public int getScore(HardWareInfo hardWareInfo) {
        int i;
        if (hardWareInfo == null) {
            return 0;
        }
        int i2 = hardWareInfo.a;
        if (i2 == 0 || (i = hardWareInfo.b) == 0) {
            return 5;
        }
        float f = hardWareInfo.c;
        float f2 = 8.0f;
        float f3 = f <= 1.4f ? 1.0f : f <= 1.5f ? 2.0f : f <= 2.0f ? 4.0f : f <= 2.5f ? 6.0f : f <= 3.0f ? 8.0f : f <= 3.5f ? 9.0f : 10.0f;
        int i3 = i2 * i;
        if (i3 >= 8847360) {
            f2 = 10.0f;
        } else if (i3 >= 3686400) {
            f2 = 9.0f;
        } else if (i3 <= 2073600) {
            f2 = i3 == 2073600 ? 7.0f : i3 > 921600 ? 6.0f : i3 >= 921600 ? 4.0f : i3 >= 786432 ? 3.0f : i3 >= 614400 ? 2.0f : 1.0f;
        }
        return Math.round((f3 + f2) / 2.0f);
    }
}
