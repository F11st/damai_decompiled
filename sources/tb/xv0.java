package tb;

import android.taobao.windvane.cache.WVFileInfoParser;
import com.ali.alihadeviceevaluator.old.CalScore;
import com.ali.alihadeviceevaluator.old.HardWareInfo;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class xv0 implements CalScore {
    @Override // com.ali.alihadeviceevaluator.old.CalScore
    public int getScore(HardWareInfo hardWareInfo) {
        float f = 7.0f;
        try {
            File file = new File("/sdcard/Android/");
            if (file.exists()) {
                long abs = Math.abs(System.currentTimeMillis() - file.lastModified()) / WVFileInfoParser.DEFAULT_MAX_AGE;
                if (abs > 100) {
                    f = 5.0f;
                } else {
                    f = abs > 50 ? 0.0f : Math.round(10.0f - (((float) abs) * 0.2f));
                }
            }
        } catch (Throwable unused) {
        }
        return (int) (f >= 0.0f ? f : 5.0f);
    }
}
