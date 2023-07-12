package com.alibaba.analytics.core.config;

import tb.hl2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class UTDefaultConfMgr extends AbstractC3111d {
    @Override // com.alibaba.analytics.core.config.AbstractC3111d
    public void l() {
        try {
            hl2.c().f(new Runnable() { // from class: com.alibaba.analytics.core.config.UTDefaultConfMgr.1
                @Override // java.lang.Runnable
                public void run() {
                    UTDefaultConfMgr.this.k();
                    UTDefaultConfMgr.this.i();
                    AbstractC3111d.m("0");
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
