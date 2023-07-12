package com.youku.live.dsl.config;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class OptConfigUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final boolean DEFAULT_OPEN_STATUS = true;
    public static final String KEY_OPEN_OPT = "open_opt";
    public static final String NAMESAPCE = "yklive_optimization_config";
    public static final String TAG = "yklive_opt";

    public static boolean getConfig(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1564265113")) {
            return ((Boolean) ipChange.ipc$dispatch("1564265113", new Object[]{str, Boolean.valueOf(z)})).booleanValue();
        }
        IRemoteConfig iRemoteConfig = (IRemoteConfig) Dsl.getService(IRemoteConfig.class);
        if (iRemoteConfig == null) {
            return z;
        }
        boolean z2 = iRemoteConfig.getBoolean(NAMESAPCE, str, z);
        Log.e(TAG, str + ":" + z2);
        return z2;
    }

    public static int getConfigInt(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1191277958")) {
            return ((Integer) ipChange.ipc$dispatch("1191277958", new Object[]{str, Integer.valueOf(i)})).intValue();
        }
        IRemoteConfig iRemoteConfig = (IRemoteConfig) Dsl.getService(IRemoteConfig.class);
        if (iRemoteConfig == null) {
            return i;
        }
        int i2 = iRemoteConfig.getInt(NAMESAPCE, str, i);
        Log.e(TAG, str + ":" + i2);
        return i2;
    }

    public static long getConfigLong(String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2142944277")) {
            return ((Long) ipChange.ipc$dispatch("2142944277", new Object[]{str, Long.valueOf(j)})).longValue();
        }
        IRemoteConfig iRemoteConfig = (IRemoteConfig) Dsl.getService(IRemoteConfig.class);
        if (iRemoteConfig == null) {
            return j;
        }
        long j2 = iRemoteConfig.getLong(NAMESAPCE, str, j);
        Log.e(TAG, str + ":" + j2);
        return j2;
    }

    public static boolean isOpenOpt() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1396387570") ? ((Boolean) ipChange.ipc$dispatch("1396387570", new Object[0])).booleanValue() : getConfig(KEY_OPEN_OPT, true);
    }
}
