package com.youku.uplayer.bridging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import androidx.annotation.Keep;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
@Keep
/* loaded from: classes3.dex */
public class SystemDelegate {
    private static Context sContext;
    static int sCurrentNetworkType;
    private static ConcurrentHashMap<String, IPlayerBridge> sDelegates = new ConcurrentHashMap<>();
    static String sWifiSSID = "";

    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes3.dex */
    public static class BridgeParam {
        public static final int TYPE_DOUBLE = 4;
        public static final int TYPE_FLOAT = 3;
        public static final int TYPE_INT = 1;
        public static final int TYPE_LONG = 2;
        public static final int TYPE_STRING = 6;
        long mPtr;

        public BridgeParam(long j) {
            this.mPtr = j;
        }

        public native double getDouble();

        public native float getFloat();

        public native int getInt();

        public native long getLong();

        public native String getString();

        public native int getType();

        public native boolean putDouble(double d);

        public native boolean putFloat(float f);

        public native boolean putInt(int i);

        public native boolean putLong(long j);

        public native boolean putString(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface IPlayerBridge {
        void handle(BridgeParam bridgeParam);
    }

    static int getCurrentNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context != null && (activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"))) != null) {
            if (activeNetworkInfo.getType() == 1) {
                return 1;
            }
            if (activeNetworkInfo.getType() == 0) {
                return 2;
            }
        }
        return 0;
    }

    public static String getNetworkName() {
        int i = sCurrentNetworkType;
        return i == 0 ? "unknown" : i == 1 ? sWifiSSID : "wwan";
    }

    static String getWifiSSID(Context context) {
        WifiInfo connectionInfo = ((WifiManager) sContext.getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getSSID() : "";
    }

    public static void init(Context context) {
        if (sContext == null) {
            sContext = context.getApplicationContext();
            register("metrics.send", new AppMonitorDelegate());
            registerHandler();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            sContext.registerReceiver(new BroadcastReceiver() { // from class: com.youku.uplayer.bridging.SystemDelegate.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    if (ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(intent.getAction())) {
                        SystemDelegate.sCurrentNetworkType = SystemDelegate.getCurrentNetworkType(context2);
                        SystemDelegate.sWifiSSID = SystemDelegate.getWifiSSID(context2);
                    }
                }
            }, intentFilter);
            sCurrentNetworkType = getCurrentNetworkType(context);
            sWifiSSID = getWifiSSID(context);
        }
    }

    private static void onCall(String str, BridgeParam bridgeParam) {
        float f;
        if (sContext == null) {
            bridgeParam.putInt(-1);
            bridgeParam.putString("SystemDelegate is not initialized");
            return;
        }
        IPlayerBridge iPlayerBridge = sDelegates.get(str);
        if (iPlayerBridge != null) {
            iPlayerBridge.handle(bridgeParam);
        } else if ("system.network_type".equals(str)) {
            bridgeParam.putInt(0);
            bridgeParam.putInt(sCurrentNetworkType);
        } else if ("system.wifi_ssid".equals(str)) {
            bridgeParam.putInt(0);
            bridgeParam.putString(sWifiSSID);
        } else if ("system.file_dir".equals(str)) {
            bridgeParam.putInt(0);
            bridgeParam.putString(sContext.getFilesDir().getAbsolutePath());
        } else if ("system.preference.get".equals(str)) {
            bridgeParam.putInt(0);
            String string = bridgeParam.getString();
            SharedPreferences sharedPreferences = sContext.getSharedPreferences(string, 0);
            for (int i = bridgeParam.getInt(); i > 0; i--) {
                String string2 = bridgeParam.getString();
                int type = bridgeParam.getType();
                if (type == 1) {
                    bridgeParam.putInt(sharedPreferences.getInt(string2, bridgeParam.getInt()));
                } else if (type == 2) {
                    bridgeParam.putLong(sharedPreferences.getLong(string2, bridgeParam.getLong()));
                } else if (type == 3) {
                    bridgeParam.putFloat(sharedPreferences.getFloat(string2, bridgeParam.getFloat()));
                } else if (type == 4) {
                    bridgeParam.putDouble(sharedPreferences.getFloat(string2, (float) bridgeParam.getDouble()));
                } else if (type == 6) {
                    bridgeParam.putString(sharedPreferences.getString(string2, bridgeParam.getString()));
                }
            }
        } else if (!"system.preference.set".equals(str)) {
            bridgeParam.putInt(-1);
            bridgeParam.putString("Unsupoprted bridge API: " + str);
        } else {
            bridgeParam.putInt(0);
            String string3 = bridgeParam.getString();
            SharedPreferences.Editor edit = sContext.getSharedPreferences(string3, 0).edit();
            for (int i2 = bridgeParam.getInt(); i2 > 0; i2--) {
                String string4 = bridgeParam.getString();
                int type2 = bridgeParam.getType();
                if (type2 == 1) {
                    edit.putInt(string4, bridgeParam.getInt());
                } else if (type2 != 2) {
                    if (type2 == 3) {
                        f = bridgeParam.getFloat();
                    } else if (type2 == 4) {
                        f = (float) bridgeParam.getDouble();
                    } else if (type2 == 6) {
                        edit.putString(string4, bridgeParam.getString());
                    }
                    edit.putFloat(string4, f);
                } else {
                    edit.putLong(string4, bridgeParam.getLong());
                }
            }
            edit.commit();
        }
    }

    public static void register(String str, IPlayerBridge iPlayerBridge) {
        sDelegates.put(str, iPlayerBridge);
    }

    private static native void registerHandler();
}
