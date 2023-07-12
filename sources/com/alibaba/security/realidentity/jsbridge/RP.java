package com.alibaba.security.realidentity.jsbridge;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RP extends WVApiPlugin {
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, final WVCallBackContext wVCallBackContext) {
        return C3905g.a(this.mContext, str, str2, new AbstractC3907h() { // from class: com.alibaba.security.realidentity.jsbridge.RP.1
            @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3907h
            public final void a(WVResult wVResult) {
                WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                if (wVCallBackContext2 != null) {
                    wVCallBackContext2.error(wVResult);
                }
            }

            @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3907h
            public final void b(WVResult wVResult) {
                WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                if (wVCallBackContext2 != null) {
                    wVCallBackContext2.success(wVResult);
                }
            }

            @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3907h
            public final void a(String str3) {
                WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                if (wVCallBackContext2 != null) {
                    wVCallBackContext2.error(str3);
                }
            }

            @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3907h
            public final void b() {
                WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                if (wVCallBackContext2 != null) {
                    wVCallBackContext2.success();
                }
            }

            @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3907h
            public final void a() {
                WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                if (wVCallBackContext2 != null) {
                    wVCallBackContext2.error();
                }
            }

            @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3907h
            public final void b(String str3) {
                WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                if (wVCallBackContext2 != null) {
                    wVCallBackContext2.success(str3);
                }
            }

            @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3907h
            public final void a(String str3, String str4) {
                WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                if (wVCallBackContext2 != null) {
                    wVCallBackContext2.fireEvent(str3, str4);
                }
            }
        });
    }
}
