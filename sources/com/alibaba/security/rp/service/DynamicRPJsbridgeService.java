package com.alibaba.security.rp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.taobao.windvane.jsbridge.IJsBridgeService;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.text.TextUtils;
import com.alibaba.security.realidentity.jsbridge.RP;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DynamicRPJsbridgeService extends Service implements IJsBridgeService {
    @Override // android.taobao.windvane.jsbridge.IJsBridgeService
    public Class<? extends WVApiPlugin> getBridgeClass(String str) {
        if (!TextUtils.isEmpty(str) && str.equals("RP")) {
            return RP.class;
        }
        return null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
