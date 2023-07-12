package cn.damai.commonbusiness.poplayer;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.alibaba.poplayer.layermanager.ILayerMgrAdapter;
import com.alibaba.poplayer.layermanager.e;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListener;
import tb.pm;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class DMLayerMgrAdapter implements ILayerMgrAdapter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String GROUP_NAME = "android_layermanager";
    private final Handler a = new Handler(Looper.getMainLooper());

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a implements OrangeConfigListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ e a;

        a(DMLayerMgrAdapter dMLayerMgrAdapter, e eVar) {
            this.a = eVar;
        }

        @Override // com.taobao.orange.OrangeConfigListener
        public void onConfigUpdate(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1779354564")) {
                ipChange.ipc$dispatch("-1779354564", new Object[]{this, str});
            } else {
                this.a.n();
            }
        }
    }

    @Override // com.alibaba.poplayer.layermanager.ILayerMgrAdapter
    public void addConfigObserver(e eVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1504011281")) {
            ipChange.ipc$dispatch("1504011281", new Object[]{this, eVar});
        } else {
            OrangeConfig.getInstance().registerListener(new String[]{GROUP_NAME}, new a(this, eVar));
        }
    }

    @Override // com.alibaba.poplayer.layermanager.ILayerMgrAdapter
    public String getConfigByKey(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-920155272") ? (String) ipChange.ipc$dispatch("-920155272", new Object[]{this, str}) : OrangeConfig.getInstance().getConfig(GROUP_NAME, str, "");
    }

    @Override // com.alibaba.poplayer.layermanager.ILayerMgrAdapter
    public void initializeConfigContainer(final e eVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1605187291")) {
            ipChange.ipc$dispatch("1605187291", new Object[]{this, eVar});
        } else {
            this.a.postDelayed(new Runnable() { // from class: cn.damai.commonbusiness.poplayer.DMLayerMgrAdapter.1
                private static transient /* synthetic */ IpChange $ipChange;
                private int mRetryCount = 0;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-802250652")) {
                        ipChange2.ipc$dispatch("-802250652", new Object[]{this});
                        return;
                    }
                    try {
                        int i = this.mRetryCount;
                        this.mRetryCount = i + 1;
                        if (i > 10) {
                            Log.i("DMPopLayer", "TBFaceAdapter$Runnable.run.retry.upToLimit");
                        } else if ("orange_fucking_silly_bug".equals(OrangeConfig.getInstance().getConfig(DMLayerMgrAdapter.GROUP_NAME, pm.CONFIG_SET_KEY, "orange_fucking_silly_bug"))) {
                            DMLayerMgrAdapter.this.a.postDelayed(this, 1000L);
                            Log.e("DMPopLayer", "TBFaceAdapter$Runnable.run.retry");
                        } else {
                            eVar.n();
                            Log.i("DMPopLayer", "TBFaceAdapter$Runnable.run.configurationGetted:)");
                        }
                    } catch (Throwable unused) {
                        Log.e("DMPopLayer", "TBFaceAdapter$Runnable.run.continuousGetConfiguration.fail");
                    }
                }
            }, 1000L);
        }
    }
}
