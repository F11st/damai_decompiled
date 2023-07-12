package com.alipay.mobile;

import com.alipay.ma.MaLogger;
import com.alipay.mobile.bqcscanservice.MPaasLogger;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class MaAlipayLogger implements MaLogger.MaEngineLogger {
    @Override // com.alipay.ma.MaLogger.MaEngineLogger
    public void d(String str, String str2) {
        MPaasLogger.d(str, new Object[]{str2});
    }

    @Override // com.alipay.ma.MaLogger.MaEngineLogger
    public void e(String str, String str2) {
        MPaasLogger.e(str, new Object[]{str2});
    }

    @Override // com.alipay.ma.MaLogger.MaEngineLogger
    public void i(String str, String str2) {
        MPaasLogger.i(str, new Object[]{str2});
    }

    @Override // com.alipay.ma.MaLogger.MaEngineLogger
    public boolean isDebuggable() {
        return MPaasLogger.isDebuggable();
    }

    @Override // com.alipay.ma.MaLogger.MaEngineLogger
    public void v(String str, String str2) {
        MPaasLogger.d(str, new Object[]{str2});
    }

    @Override // com.alipay.ma.MaLogger.MaEngineLogger
    public void w(String str, String str2) {
        MPaasLogger.w(str, new Object[]{str2});
    }

    @Override // com.alipay.ma.MaLogger.MaEngineLogger
    public void e(String str, String str2, Throwable th) {
        MPaasLogger.e(str, new Object[]{str2}, th);
    }
}
