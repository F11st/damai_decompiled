package com.alibaba.aliweex.adapter.module;

import android.taobao.windvane.jsbridge.IJsApiFailedCallBack;
import android.taobao.windvane.jsbridge.IJsApiSucceedCallBack;
import com.alibaba.aliweex.interceptor.mtop.MtopTracker;
import com.alibaba.fastjson.JSON;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.performance.WXStateRecord;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class a implements IJsApiFailedCallBack, IJsApiSucceedCallBack {
    private String a;
    private String b;
    private boolean c;
    private boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, String str2, boolean z, boolean z2) {
        this.c = true;
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = z2;
    }

    @Override // android.taobao.windvane.jsbridge.IJsApiFailedCallBack
    public void fail(String str) {
        MtopTracker popMtopTracker;
        if (this.c) {
            try {
                if (this.d) {
                    WXStateRecord d = WXStateRecord.d();
                    String str2 = this.a;
                    d.i(str2, "windvane mtop failed,callBack" + this.b + ",result" + str);
                }
                WXBridgeManager.getInstance().callback(this.a, this.b, JSON.parse(str), false);
            } catch (Exception unused) {
            }
        } else {
            WXBridgeManager.getInstance().callback(this.a, this.b, str);
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("WXWindVaneModule", "call fail s:" + str);
        }
        if (!WXEnvironment.isApkDebugable() || (popMtopTracker = WXWindVaneModule.popMtopTracker(this.b)) == null) {
            return;
        }
        popMtopTracker.n(null, str);
    }

    @Override // android.taobao.windvane.jsbridge.IJsApiSucceedCallBack
    public void succeed(String str) {
        MtopTracker popMtopTracker;
        if (this.c) {
            try {
                if (this.d) {
                    WXStateRecord d = WXStateRecord.d();
                    String str2 = this.a;
                    d.i(str2, "windvane mtop succeed,calllBack:" + this.b);
                }
                WXBridgeManager.getInstance().callback(this.a, this.b, JSON.parse(str), false);
            } catch (Exception unused) {
            }
        } else {
            WXBridgeManager.getInstance().callback(this.a, this.b, str);
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("WXWindVaneModule", "call succeed s:" + str);
        }
        if (!WXEnvironment.isApkDebugable() || (popMtopTracker = WXWindVaneModule.popMtopTracker(this.b)) == null) {
            return;
        }
        popMtopTracker.o(str);
    }
}
