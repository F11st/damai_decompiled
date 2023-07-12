package mtopsdk.xstate;

import android.content.Context;
import android.content.IntentFilter;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.xstate.network.NetworkStateReceiver;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class XStateDelegate {
    private static final String TAG = "mtopsdk.XStateDelegate";
    private static Context context;
    private static volatile boolean isInit;
    private static NetworkStateReceiver netReceiver;
    private static ConcurrentHashMap<String, String> stateIDs;

    private static void checkInit(Context context2) {
        try {
            if (isInit) {
                return;
            }
            if (context2 == null) {
                TBSdkLog.e(TAG, "[checkInit]parameter context for init(Context context) is null.");
                return;
            }
            if (stateIDs == null) {
                stateIDs = new ConcurrentHashMap<>();
            }
            context = context2;
            if (netReceiver == null) {
                netReceiver = new NetworkStateReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
                context2.registerReceiver(netReceiver, intentFilter);
            }
            isInit = true;
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, "[checkInit] init XState OK,isInit=" + isInit);
            }
        } catch (Throwable th) {
            TBSdkLog.e(TAG, "[checkInit] checkInit error --" + th.toString());
        }
    }

    public static Context getContext() {
        return context;
    }

    public static String getValue(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = stateIDs;
        if (concurrentHashMap == null || str == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public static void init(Context context2) {
        if (isInit) {
            return;
        }
        checkInit(context2);
    }

    public static String removeKey(String str) {
        if (stateIDs == null || str == null) {
            return null;
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.d(TAG, "remove XState key=" + str);
        }
        return stateIDs.remove(str);
    }

    public static void setValue(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap = stateIDs;
        if (concurrentHashMap != null && str != null && str2 != null) {
            concurrentHashMap.put(str, str2);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                TBSdkLog.d(TAG, "[setValue]set  XStateID succeed," + str + "=" + str2);
            }
        } else if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.d(TAG, "[setValue]set  XStateID failed,key=" + str + ",value=" + str2);
        }
    }

    public static void unInit() {
        if (isInit) {
            try {
                if (isInit) {
                    ConcurrentHashMap<String, String> concurrentHashMap = stateIDs;
                    if (concurrentHashMap != null) {
                        concurrentHashMap.clear();
                        stateIDs = null;
                    }
                    Context context2 = context;
                    if (context2 == null) {
                        TBSdkLog.e(TAG, "[unInit] context in Class XState is null.");
                        return;
                    }
                    NetworkStateReceiver networkStateReceiver = netReceiver;
                    if (networkStateReceiver != null) {
                        context2.unregisterReceiver(networkStateReceiver);
                        netReceiver = null;
                    }
                    isInit = false;
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                        TBSdkLog.i(TAG, "[unInit] unInit XState OK,isInit=" + isInit);
                    }
                }
            } catch (Exception e) {
                TBSdkLog.e(TAG, "[unInit] unInit error --" + e.toString());
            }
        }
    }
}
