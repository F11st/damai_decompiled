package com.alipay.auth.mobile;

import android.content.Context;
import com.alipay.auth.mobile.api.IAlipayAuthAPI;
import com.alipay.auth.mobile.api.IAlipayAuthMonitor;
import com.alipay.auth.mobile.common.LoggerUtils;
import com.alipay.auth.mobile.common.MonitorAlipayAuth;
import com.alipay.auth.mobile.exception.AlipayAuthIllegalArgumentException;
import com.alipay.auth.mobile.impl.AlipayAuthApiImpl;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AlipayAuthAPIFactory {
    public static IAlipayAuthAPI createAlipayAuthApi(Context context, IAlipayAuthMonitor iAlipayAuthMonitor) throws AlipayAuthIllegalArgumentException {
        if (context != null && iAlipayAuthMonitor != null) {
            LoggerUtils.d("AlipayAuthAPIFactory", "createAlipayAuthApi normal");
            MonitorAlipayAuth.getInstance().monitorAlipayAuth(iAlipayAuthMonitor, "AliPayAuth_Init");
            return new AlipayAuthApiImpl(context, iAlipayAuthMonitor);
        }
        LoggerUtils.d("AlipayAuthAPIFactory", "createAlipayAuthApi param is null");
        throw new AlipayAuthIllegalArgumentException("createAlipayAuthApi param context or monitor is null");
    }
}
