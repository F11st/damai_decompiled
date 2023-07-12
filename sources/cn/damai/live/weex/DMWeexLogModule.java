package cn.damai.live.weex;

import android.os.Handler;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import tb.xr;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMWeexLogModule extends WXModule {
    private static transient /* synthetic */ IpChange $ipChange;

    @JSMethod
    public void log(final String str, JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1555805491")) {
            ipChange.ipc$dispatch("-1555805491", new Object[]{this, str, jSCallback});
            return;
        }
        Log.d("DMWeexLog", str);
        new Handler().postDelayed(new Runnable() { // from class: cn.damai.live.weex.DMWeexLogModule.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1508275389")) {
                    ipChange2.ipc$dispatch("1508275389", new Object[]{this});
                } else {
                    xr.c("weexLog", str);
                }
            }
        }, 200L);
    }
}
