package com.youku.live.dago.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class BroadCastManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "BroadCastManager";

    public static void registerAttention(Context context, BroadcastReceiver broadcastReceiver) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1530596740")) {
            ipChange.ipc$dispatch("1530596740", new Object[]{context, broadcastReceiver});
        } else if (context == null || broadcastReceiver == null) {
        } else {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(BroadCastConstants.ACTION_ATTENTION);
            LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public static void registerUnAttention(Context context, BroadcastReceiver broadcastReceiver) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "670518205")) {
            ipChange.ipc$dispatch("670518205", new Object[]{context, broadcastReceiver});
        } else if (context == null || broadcastReceiver == null) {
        } else {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(BroadCastConstants.ACTION_UNATTENTTION);
            LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public static void sendAttention(Context context, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2135783194")) {
            ipChange.ipc$dispatch("-2135783194", new Object[]{context, Long.valueOf(j)});
        } else if (context != null) {
            Intent intent = new Intent();
            intent.setAction(BroadCastConstants.ACTION_ATTENTION);
            intent.putExtra(BroadCastConstants.KEY_TARGETUSERID, j);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }

    public static void sendUnAttention(Context context, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1196363807")) {
            ipChange.ipc$dispatch("1196363807", new Object[]{context, Long.valueOf(j)});
        } else if (context != null) {
            Intent intent = new Intent();
            intent.setAction(BroadCastConstants.ACTION_UNATTENTTION);
            intent.putExtra(BroadCastConstants.KEY_TARGETUSERID, j);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }

    public static void unregisterAttentionReciver(Context context, BroadcastReceiver broadcastReceiver) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-152255199")) {
            ipChange.ipc$dispatch("-152255199", new Object[]{context, broadcastReceiver});
        } else if (context == null || broadcastReceiver == null) {
        } else {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(broadcastReceiver);
        }
    }
}
