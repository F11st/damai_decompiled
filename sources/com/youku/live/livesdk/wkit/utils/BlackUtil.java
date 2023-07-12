package com.youku.live.livesdk.wkit.utils;

import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.config.IConfig;
import com.youku.live.widgets.WidgetSDKEngine;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class BlackUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    static Boolean sIsBlack;

    public static synchronized boolean isBlack() {
        int i;
        synchronized (BlackUtil.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2006960537")) {
                return ((Boolean) ipChange.ipc$dispatch("2006960537", new Object[0])).booleanValue();
            }
            Boolean bool = sIsBlack;
            if (bool == null) {
                String string = ((IConfig) Dsl.getService(IConfig.class)).getString("dago_liveconfig", "immerseBlacklist", "");
                try {
                    if (!TextUtils.isEmpty(string)) {
                        String[] split = string.split(",");
                        int length = split.length;
                        while (i < length) {
                            String str = split[i];
                            i = (Build.getMODEL().equals(str) || RomUtil.check(str)) ? 0 : i + 1;
                            sIsBlack = Boolean.TRUE;
                            return true;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                sIsBlack = Boolean.FALSE;
                return false;
            }
            return bool != null ? bool.booleanValue() : false;
        }
    }

    public static void prefetchIsBlack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1379051028")) {
            ipChange.ipc$dispatch("-1379051028", new Object[0]);
        } else {
            WidgetSDKEngine.getInstance().getRenderMananger().postOnWorkerThread(new Runnable() { // from class: com.youku.live.livesdk.wkit.utils.BlackUtil.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-711177582")) {
                        ipChange2.ipc$dispatch("-711177582", new Object[]{this});
                    } else {
                        BlackUtil.isBlack();
                    }
                }
            });
        }
    }
}
