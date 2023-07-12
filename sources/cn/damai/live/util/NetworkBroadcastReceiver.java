package cn.damai.live.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import tb.cb1;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class NetworkBroadcastReceiver extends BroadcastReceiver {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private OnNetworkChangeListener b;
    private boolean c = true;
    private final long d = SystemClock.elapsedRealtime();

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnNetworkChangeListener {
        void onNetworkChange();
    }

    public NetworkBroadcastReceiver(Context context) {
        this.a = context;
    }

    private boolean a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1872535948")) {
            return ((Boolean) ipChange.ipc$dispatch("1872535948", new Object[]{this})).booleanValue();
        }
        if (this.c) {
            this.c = false;
            if (SystemClock.elapsedRealtime() - this.d < DanmakuFactory.DEFAULT_DANMAKU_DURATION_V) {
                cb1.b("NetworkBroadcastReceiver", "短时间内首次回调,认为无效");
                return true;
            }
        }
        return false;
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1496178402")) {
            ipChange.ipc$dispatch("-1496178402", new Object[]{this});
            return;
        }
        cb1.b("NetworkBroadcastReceiver", "registerNetworkChangeBroadcast");
        try {
            this.a.registerReceiver(this, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(OnNetworkChangeListener onNetworkChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-340425608")) {
            ipChange.ipc$dispatch("-340425608", new Object[]{this, onNetworkChangeListener});
        } else {
            this.b = onNetworkChangeListener;
        }
    }

    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2018471483")) {
            ipChange.ipc$dispatch("-2018471483", new Object[]{this});
            return;
        }
        cb1.b("NetworkBroadcastReceiver", "unRegisterNetworkChangeBroadcast");
        try {
            this.a.unregisterReceiver(this);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        OnNetworkChangeListener onNetworkChangeListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2062300931")) {
            ipChange.ipc$dispatch("2062300931", new Object[]{this, context, intent});
        } else if (a() || (onNetworkChangeListener = this.b) == null) {
        } else {
            onNetworkChangeListener.onNetworkChange();
        }
    }
}
