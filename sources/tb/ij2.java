package tb;

import android.text.TextUtils;
import com.taobao.downloader.adpater.CloundConfigAdapter;
import com.taobao.downloader.download.protocol.DLConnection;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ij2 {
    private static boolean a(long j, qq qqVar) {
        CloundConfigAdapter cloundConfigAdapter = um.j;
        if (cloundConfigAdapter == null) {
            return true;
        }
        boolean equals = "".equals(cloundConfigAdapter.getConfig("dlconnection_anet"));
        String config = um.j.getConfig("sizeSwitch_anet");
        boolean z = !"".equals(um.j.getConfig("lastUseHuc_anet"));
        int intValue = (TextUtils.isEmpty(config) || !TextUtils.isDigitsOnly(config)) ? 0 : Integer.valueOf(config).intValue();
        if (equals && (0 == j || j > intValue)) {
            if (!z) {
                return true;
            }
            if (!qqVar.d() && !qqVar.e()) {
                return true;
            }
        }
        return false;
    }

    public static DLConnection b(l41 l41Var, qq qqVar) {
        if (um.l == null) {
            return new iv0();
        }
        if (a(l41Var.b, qqVar)) {
            try {
                return um.l.newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            }
        }
        return new iv0();
    }

    public static int c() {
        CloundConfigAdapter cloundConfigAdapter = um.j;
        if (cloundConfigAdapter == null) {
            return qq.f;
        }
        String config = cloundConfigAdapter.getConfig("dl_buffersize");
        if (!TextUtils.isEmpty(config) && TextUtils.isDigitsOnly(config)) {
            return Integer.valueOf(config).intValue();
        }
        return qq.f;
    }
}
