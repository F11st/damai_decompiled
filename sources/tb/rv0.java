package tb;

import com.ali.alihadeviceevaluator.old.CalScore;
import com.ali.alihadeviceevaluator.old.HardWareInfo;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class rv0 implements CalScore {
    public int a = 0;
    public int b;

    @Override // com.ali.alihadeviceevaluator.old.CalScore
    public int getScore(HardWareInfo hardWareInfo) {
        int i = this.a;
        int i2 = 8;
        int i3 = i > 256 ? 10 : i >= 256 ? 8 : i >= 192 ? 7 : i >= 128 ? 5 : i >= 96 ? 3 : 4;
        int i4 = this.b;
        if (i4 >= 512) {
            i2 = 10;
        } else if (i4 < 256) {
            i2 = i4 >= 128 ? 6 : 1;
        }
        return (i2 + i3) / 2;
    }
}
