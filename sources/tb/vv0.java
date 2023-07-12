package tb;

import com.ali.alihadeviceevaluator.old.CalScore;
import com.ali.alihadeviceevaluator.old.HardWareInfo;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class vv0 implements CalScore {
    public int a = 48;
    public int b = 48;

    @Override // com.ali.alihadeviceevaluator.old.CalScore
    public int getScore(HardWareInfo hardWareInfo) {
        int i;
        if (this.a <= 0) {
            this.a = 48;
        }
        if (this.b <= 0) {
            this.b = 24;
        }
        int i2 = this.a;
        int i3 = 6;
        if (i2 >= 220) {
            i = 10;
        } else if (i2 >= 100) {
            i = 9;
        } else {
            if (i2 < 80) {
                if (i2 >= 48) {
                    i = 6;
                } else if (i2 >= 24) {
                    i = 5;
                } else if (i2 >= 10) {
                    i = 2;
                } else if (i2 >= 5) {
                    i = 1;
                }
            }
            i = 8;
        }
        int i4 = (this.b * 100) / i2;
        if (i4 >= 80) {
            i3 = 10;
        } else if (i4 >= 70) {
            i3 = 9;
        } else if (i4 >= 60) {
            i3 = 8;
        } else if (i4 >= 50) {
            i3 = 7;
        } else if (i4 < 40) {
            i3 = i4 >= 30 ? 5 : i4 >= 20 ? 4 : i4 >= 10 ? 3 : i4 >= 5 ? 2 : i4 >= 1 ? 1 : 0;
        }
        return (i + i3) / 2;
    }
}
