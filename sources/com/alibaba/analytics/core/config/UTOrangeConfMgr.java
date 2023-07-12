package com.alibaba.analytics.core.config;

import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListenerV1;
import java.util.Map;
import tb.hl2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class UTOrangeConfMgr extends d {
    private static final String[] g = {"ut_sample", "ut_stream", "ut_bussiness", "utap_system", "ap_alarm", "ap_counter", "ap_stat", "ut_realtime"};

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    final class OrangeGetConfigsRunnable implements Runnable {
        private final int[] mSleepIntervalList = {1, 1, 2, 2, 4, 4, 8, 8};

        OrangeGetConfigsRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] strArr = UTOrangeConfMgr.g;
            UTOrangeConfMgr.super.k();
            UTOrangeConfMgr.super.i();
            d.m("0");
            int i = 0;
            int i2 = 0;
            do {
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    if (strArr[i3] != null && OrangeConfig.getInstance().getConfigs(UTOrangeConfMgr.g[i3]) != null) {
                        strArr[i3] = null;
                        i++;
                    }
                }
                if (i == strArr.length) {
                    break;
                }
                try {
                    Thread.sleep(this.mSleepIntervalList[i2] * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i2++;
            } while (i2 <= this.mSleepIntervalList.length);
            for (String str : strArr) {
                if (str != null) {
                    UTOrangeConfMgr.super.h(str);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class a implements OrangeConfigListenerV1 {
        a() {
        }

        @Override // com.taobao.orange.OrangeConfigListenerV1
        public void onConfigUpdate(String str, boolean z) {
            Logger.f(null, "aGroupname", str, "aIsCached", Boolean.valueOf(z));
            Map<String, String> configs = OrangeConfig.getInstance().getConfigs(str);
            if (configs != null) {
                UTOrangeConfMgr.super.o(str, configs);
                d.m("2");
            }
        }
    }

    @Override // com.alibaba.analytics.core.config.d
    public void l() {
        try {
            OrangeConfig.getInstance().init(Variables.n().j());
            hl2.c().f(new OrangeGetConfigsRunnable());
            OrangeConfig.getInstance().registerListener(g, new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
