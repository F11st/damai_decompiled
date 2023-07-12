package ntk.cellular;

import android.content.Context;
import android.os.Build;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.youku.core.context.YoukuContext;
import java.util.ArrayList;
import ntk.dns.NetworkUtil;
import ntk.dns.Util;
import tb.bh0;
import tb.pb0;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
final class ChannelProxy {
    private static a celluarManager;
    private static a extManager;

    ChannelProxy() {
    }

    public static String GetAppVersion() {
        return NetworkUtil.a();
    }

    public static int checkNetConn() {
        return NetworkUtil.c();
    }

    public static void closeChannel(String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            getManagerForType(str).b(getContext());
        }
    }

    public static synchronized void closeSocketFd(String str, int i) {
        synchronized (ChannelProxy.class) {
            if (Build.VERSION.SDK_INT >= 21) {
                a aVar = celluarManager;
                boolean c = aVar != null ? aVar.c(i) : false;
                a aVar2 = extManager;
                if (aVar2 != null && !c) {
                    aVar2.c(i);
                }
            }
        }
    }

    public static int createSocketFd(String str, String str2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return getManagerForType(str).d(str2);
        }
        return 0;
    }

    public static int createSocketFdAndConnect(String str, String str2, String str3) {
        if (Build.VERSION.SDK_INT >= 21) {
            return getManagerForType(str).e(str2, str3);
        }
        return 0;
    }

    public static String getConfigFilePath() {
        return Build.VERSION.SDK_INT >= 21 ? a.g(getContext()) : "/sdcard/ntk.cfg";
    }

    @Nullable
    private static Context getContext() {
        try {
            return YoukuContext.getApplicationContext();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    public static String[] getIpFromHttpDns(String str) {
        return pb0.b(str);
    }

    public static String[] getIpFromLocalDns(String str) {
        return pb0.c(str);
    }

    @RequiresApi(api = 21)
    private static synchronized a getManagerForType(String str) {
        synchronized (ChannelProxy.class) {
            if (str.equals("ext")) {
                if (extManager == null) {
                    extManager = new bh0();
                }
                return extManager;
            }
            if (celluarManager == null) {
                celluarManager = new a();
            }
            return celluarManager;
        }
    }

    public static int getNetworkStatus() {
        return NetworkUtil.d();
    }

    public static String getRemoteConfig(String str, String str2, String str3) {
        return Util.getRemoteConfig(str, str2, str3);
    }

    public static int isChannelReady(String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            return getManagerForType(str).h(getContext());
        }
        return -1;
    }

    public static void openChannel(String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            getManagerForType(str).i(getContext());
        }
    }

    public static ArrayList<String> resolveCellularDns(String str, String str2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return getManagerForType(str).j(str2);
        }
        return null;
    }

    public static void sendInfo(int i, String str, String str2) {
        Util.sendTLog(i, str, str2);
    }

    public static void sendTLog(int i, String str, String str2) {
        Util.sendTLog(i, str, str2);
    }
}
