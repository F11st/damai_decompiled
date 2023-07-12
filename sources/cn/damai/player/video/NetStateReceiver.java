package cn.damai.player.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import cn.damai.network.NetworkType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import tb.mu0;
import tb.wj1;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class NetStateReceiver extends BroadcastReceiver {
    private static transient /* synthetic */ IpChange $ipChange;
    private static NetStateReceiver b;
    private HashMap<Integer, WeakReference<OnNetStateChangeListener>> a = new HashMap<>();

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnNetStateChangeListener {
        void onNetWorkChanged();
    }

    private synchronized void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1948777874")) {
            ipChange.ipc$dispatch("-1948777874", new Object[]{this});
            return;
        }
        for (WeakReference<OnNetStateChangeListener> weakReference : this.a.values()) {
            OnNetStateChangeListener onNetStateChangeListener = weakReference.get();
            if (onNetStateChangeListener != null) {
                onNetStateChangeListener.onNetWorkChanged();
            }
        }
    }

    public static synchronized NetStateReceiver b() {
        synchronized (NetStateReceiver.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1685028453")) {
                return (NetStateReceiver) ipChange.ipc$dispatch("-1685028453", new Object[0]);
            }
            if (b == null) {
                b = new NetStateReceiver();
                mu0.a().registerReceiver(b, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
            }
            return b;
        }
    }

    public synchronized void c(OnNetStateChangeListener onNetStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1502952780")) {
            ipChange.ipc$dispatch("-1502952780", new Object[]{this, onNetStateChangeListener});
            return;
        }
        if (onNetStateChangeListener != null) {
            this.a.remove(Integer.valueOf(onNetStateChangeListener.hashCode()));
            this.a.put(Integer.valueOf(onNetStateChangeListener.hashCode()), new WeakReference<>(onNetStateChangeListener));
        }
    }

    public synchronized void d(OnNetStateChangeListener onNetStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1470966195")) {
            ipChange.ipc$dispatch("-1470966195", new Object[]{this, onNetStateChangeListener});
            return;
        }
        if (onNetStateChangeListener != null) {
            this.a.remove(Integer.valueOf(onNetStateChangeListener.hashCode()));
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1524802494")) {
            ipChange.ipc$dispatch("1524802494", new Object[]{this, context, intent});
        } else if (ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(intent.getAction()) && wj1.c(context) == NetworkType.NETWORK_MOBILE) {
            a();
        }
    }
}
