package com.youku.resource.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.youku.middlewareservice.provider.kvdata.HighPerfSPProviderProxy;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DebugSwitchUtils {
    private static final String DOUBLE_FEED_DEBUG_KEY_ACTION = "double_feed_debug_action";
    private static final String SAVE_ITEM_DATA_KEY_ACTION = "save_item_data_key_action";
    private static final String SERVER_DEBUG_KEY_ACTION = "server_debug_action";
    private static final String TAG = "DebugSwitchUtils";
    private static BroadcastReceiver debugSwitchBroadcastReceiver;
    public static boolean isOpenArithmeticDebug;
    public static boolean isOpenServerDebug;
    public static boolean isSaveItemData;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static class DebugSwitchBroadcastReceiver extends BroadcastReceiver {
        DebugSwitchBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                action.hashCode();
                char c = 65535;
                switch (action.hashCode()) {
                    case -2144792290:
                        if (action.equals(DebugSwitchUtils.SERVER_DEBUG_KEY_ACTION)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1957691359:
                        if (action.equals(DebugSwitchUtils.SAVE_ITEM_DATA_KEY_ACTION)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 716519861:
                        if (action.equals(DebugSwitchUtils.DOUBLE_FEED_DEBUG_KEY_ACTION)) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        DebugSwitchUtils.isOpenServerDebug = intent.getBooleanExtra("isChecked", false);
                        return;
                    case 1:
                        DebugSwitchUtils.isSaveItemData = intent.getBooleanExtra("isSaveItemData", false);
                        return;
                    case 2:
                        DebugSwitchUtils.isOpenArithmeticDebug = intent.getBooleanExtra("isChecked", false);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static void initValue() {
        boolean z = true;
        isOpenArithmeticDebug = HighPerfSPProviderProxy.contains("egg_config_file", "doubleFeedDebug") && HighPerfSPProviderProxy.getBoolean("egg_config_file", "doubleFeedDebug", false);
        isOpenServerDebug = (HighPerfSPProviderProxy.contains("egg_config_file", "serverDebug") && HighPerfSPProviderProxy.getBoolean("egg_config_file", "serverDebug", false)) ? false : false;
    }

    public static boolean isOpenArithmeticDebug() {
        return isOpenArithmeticDebug;
    }

    public static boolean isOpenServerDebug() {
        return isOpenServerDebug;
    }

    public static boolean isSaveItemData() {
        return isSaveItemData;
    }

    public static boolean isWoodpeckerOpen() {
        return isSaveItemData();
    }

    public static void registerDebugReceiver(Context context) {
        initValue();
        if (debugSwitchBroadcastReceiver == null) {
            debugSwitchBroadcastReceiver = new DebugSwitchBroadcastReceiver();
        } else {
            unRegisterDebugReceiver(context);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SERVER_DEBUG_KEY_ACTION);
        intentFilter.addAction(DOUBLE_FEED_DEBUG_KEY_ACTION);
        intentFilter.addAction(SAVE_ITEM_DATA_KEY_ACTION);
        LocalBroadcastManager.getInstance(context).registerReceiver(debugSwitchBroadcastReceiver, intentFilter);
    }

    public static void unRegisterDebugReceiver(Context context) {
        try {
            if (debugSwitchBroadcastReceiver != null) {
                LocalBroadcastManager.getInstance(context).unregisterReceiver(debugSwitchBroadcastReceiver);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
