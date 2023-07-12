package com.youku.phone.xcdnengine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class NetworkBroadcastReceiver extends BroadcastReceiver {
    private List<NetWorkCallBack> callBackList = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum NetType {
        WIFI,
        MOBILE,
        NONE
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface NetWorkCallBack {
        void netWorkChange(NetType netType);
    }

    private void notifyCallBack(NetType netType) {
        List<NetWorkCallBack> list = this.callBackList;
        if (list != null) {
            for (NetWorkCallBack netWorkCallBack : list) {
                netWorkCallBack.netWorkChange(netType);
            }
        }
    }

    public void addNetWorkCallBack(NetWorkCallBack netWorkCallBack) {
        this.callBackList.add(netWorkCallBack);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            if (NetworkUtils.isNetworkAvailable(context)) {
                if (NetworkUtils.isWifi(context)) {
                    notifyCallBack(NetType.WIFI);
                    return;
                } else {
                    notifyCallBack(NetType.MOBILE);
                    return;
                }
            }
            notifyCallBack(NetType.NONE);
        }
    }
}
