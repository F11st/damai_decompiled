package ntk.dns;

import androidx.annotation.Keep;
import com.taobao.tao.log.TLog;
import com.youku.arch.beast.apas.remote.ApasServiceManager;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public class Util {
    private static final String MODULE = "NTK";
    private static boolean sEnableAps = true;

    public static String getRemoteConfig(String str, String str2, String str3) {
        return sEnableAps ? ApasServiceManager.getInstance().getConfig(str, str2, str3) : str3;
    }

    public static void sendTLog(int i, String str, String str2) {
        if (i > 6) {
            i = 6;
        }
        if (i == 2) {
            TLog.logv(MODULE, str, str2);
        } else if (i == 3) {
            TLog.logd(MODULE, str, str2);
        } else if (i == 4) {
            TLog.logi(MODULE, str, str2);
        } else if (i == 5) {
            TLog.logw(MODULE, str, str2);
        } else if (i != 6) {
        } else {
            TLog.loge(MODULE, str, str2);
        }
    }

    public static void setEnableAps(boolean z) {
        sEnableAps = z;
    }
}
