package com.alibaba.aliweex.adapter.module.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.aliweex.adapter.module.net.IWXConnection;
import com.taobao.weex.utils.WXLogUtils;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class DefaultWXConnection implements IWXConnection {
    private Context a;
    private ConnectivityManager b;
    private List<IWXConnection.OnNetworkChangeListener> d;
    private boolean e = false;
    private String f = "";
    private ConnectivityReceiver c = new ConnectivityReceiver();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class ConnectivityReceiver extends BroadcastReceiver {
        private ConnectivityReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(intent.getAction())) {
                try {
                    DefaultWXConnection.this.b();
                } catch (Exception e) {
                    WXLogUtils.e("WXConnectionModule", e.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultWXConnection(@NonNull Context context) {
        this.a = context.getApplicationContext();
        this.b = (ConnectivityManager) context.getSystemService("connectivity");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        List<IWXConnection.OnNetworkChangeListener> list = this.d;
        if (list == null || list.isEmpty()) {
            return;
        }
        String type = getType();
        if (type.equals(IWXConnection.TYPE_CELLULAR)) {
            type = getNetworkType();
        }
        if (type.equalsIgnoreCase(this.f)) {
            return;
        }
        this.f = type;
        WXLogUtils.d("WXConnectionModule", "network type changed to " + this.f);
        for (IWXConnection.OnNetworkChangeListener onNetworkChangeListener : this.d) {
            onNetworkChangeListener.onNetworkChange();
        }
    }

    private void c() {
        if (this.a != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            this.a.registerReceiver(this.c, intentFilter);
        }
    }

    private void d() {
        Context context = this.a;
        if (context != null) {
            try {
                context.unregisterReceiver(this.c);
            } catch (Exception e) {
                WXLogUtils.e("WXConnectionModule", e.getMessage());
            }
        }
    }

    @Override // com.alibaba.aliweex.adapter.module.net.IWXConnection
    public void addNetworkChangeListener(@Nullable IWXConnection.OnNetworkChangeListener onNetworkChangeListener) {
        if (onNetworkChangeListener == null) {
            return;
        }
        if (this.d == null) {
            this.d = new ArrayList(4);
        }
        this.d.add(onNetworkChangeListener);
        if (this.e) {
            return;
        }
        this.e = true;
        c();
    }

    @Override // com.alibaba.aliweex.adapter.module.net.IWXConnection
    public void destroy() {
        if (this.e) {
            d();
        }
        List<IWXConnection.OnNetworkChangeListener> list = this.d;
        if (list != null) {
            list.clear();
            this.d = null;
        }
        this.e = false;
    }

    @Override // com.alibaba.aliweex.adapter.module.net.IWXConnection
    public double getDownlinkMax() {
        String type = getType();
        type.hashCode();
        char c = 65535;
        switch (type.hashCode()) {
            case -1419358249:
                if (type.equals(IWXConnection.TYPE_ETHERNET)) {
                    c = 0;
                    break;
                }
                break;
            case -916596374:
                if (type.equals(IWXConnection.TYPE_CELLULAR)) {
                    c = 1;
                    break;
                }
                break;
            case -284840886:
                if (type.equals("unknown")) {
                    c = 2;
                    break;
                }
                break;
            case 3649301:
                if (type.equals("wifi")) {
                    c = 3;
                    break;
                }
                break;
            case 106069776:
                if (type.equals("other")) {
                    c = 4;
                    break;
                }
                break;
            case 113134930:
                if (type.equals(IWXConnection.TYPE_WIMAX)) {
                    c = 5;
                    break;
                }
                break;
            case 1968882350:
                if (type.equals(IWXConnection.TYPE_BLUETOOTH)) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 10000.0d;
            case 1:
                String networkType = getNetworkType();
                if ("2g".equals(networkType)) {
                    return 0.384d;
                }
                if ("3g".equals(networkType)) {
                    return 42.0d;
                }
                return "4g".equals(networkType) ? 100.0d : Double.MAX_VALUE;
            case 2:
                return Double.MAX_VALUE;
            case 3:
                return 7000.0d;
            case 4:
                return Double.MAX_VALUE;
            case 5:
                return 365.0d;
            case 6:
                return 24.0d;
            default:
                return 0.0d;
        }
    }

    @Override // com.alibaba.aliweex.adapter.module.net.IWXConnection
    @NonNull
    public String getNetworkType() {
        try {
            NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(this.b);
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (ConnectivityManager.isNetworkTypeValid(type)) {
                    if (type == 1) {
                        return "wifi";
                    }
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "2g";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return "3g";
                        case 13:
                            return "4g";
                        default:
                            return "other";
                    }
                }
                return "unknown";
            }
            return "none";
        } catch (Exception e) {
            WXLogUtils.e("WXConnectionModule", e.getMessage());
            return "unknown";
        }
    }

    @Override // com.alibaba.aliweex.adapter.module.net.IWXConnection
    @NonNull
    public String getType() {
        try {
            NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(this.b);
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                return !ConnectivityManager.isNetworkTypeValid(type) ? "unknown" : type == 1 ? "wifi" : type == 7 ? IWXConnection.TYPE_BLUETOOTH : type == 6 ? IWXConnection.TYPE_WIMAX : type == 9 ? IWXConnection.TYPE_ETHERNET : type == 0 ? IWXConnection.TYPE_CELLULAR : "other";
            }
            return "none";
        } catch (SecurityException e) {
            WXLogUtils.e("WXConnectionModule", e.getMessage());
            return "unknown";
        }
    }
}
