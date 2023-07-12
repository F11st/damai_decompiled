package cn.damai.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import tb.wj1;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class NetStateChangeReceiver extends BroadcastReceiver {
    private static transient /* synthetic */ IpChange $ipChange;
    private static NetStateChangeReceiver b;
    private OnNetWorkChangeListener a;

    private NetStateChangeReceiver() {
    }

    public static NetStateChangeReceiver a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1077060011")) {
            return (NetStateChangeReceiver) ipChange.ipc$dispatch("-1077060011", new Object[0]);
        }
        if (b == null) {
            synchronized (NetStateChangeReceiver.class) {
                if (b == null) {
                    b = new NetStateChangeReceiver();
                }
            }
        }
        return b;
    }

    public void b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1826671634")) {
            ipChange.ipc$dispatch("-1826671634", new Object[]{this, context});
        } else {
            context.registerReceiver(this, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
        }
    }

    public void c(OnNetWorkChangeListener onNetWorkChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "854578752")) {
            ipChange.ipc$dispatch("854578752", new Object[]{this, onNetWorkChangeListener});
        } else {
            this.a = onNetWorkChangeListener;
        }
    }

    public void d(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-664819993")) {
            ipChange.ipc$dispatch("-664819993", new Object[]{this, context});
            return;
        }
        try {
            context.unregisterReceiver(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        OnNetWorkChangeListener onNetWorkChangeListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-925784437")) {
            ipChange.ipc$dispatch("-925784437", new Object[]{this, context, intent});
        } else if (ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(intent.getAction()) && wj1.c(context) == NetworkType.NETWORK_MOBILE && (onNetWorkChangeListener = this.a) != null) {
            onNetWorkChangeListener.onNetWorkChanged();
        }
    }
}
