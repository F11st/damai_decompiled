package cn.damai.commonbusiness.poplayer;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.alibaba.poplayer.layermanager.C3660e;
import com.alibaba.poplayer.layermanager.ILayerMgrAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListener;
import tb.C9556pm;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class DMLayerMgrAdapter implements ILayerMgrAdapter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String GROUP_NAME = "android_layermanager";
    private final Handler a = new Handler(Looper.getMainLooper());

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.poplayer.DMLayerMgrAdapter$a */
    /* loaded from: classes4.dex */
    public class C0773a implements OrangeConfigListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ C3660e a;

        C0773a(DMLayerMgrAdapter dMLayerMgrAdapter, C3660e c3660e) {
            this.a = c3660e;
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
    public void addConfigObserver(C3660e c3660e) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1504011281")) {
            ipChange.ipc$dispatch("1504011281", new Object[]{this, c3660e});
        } else {
            OrangeConfig.getInstance().registerListener(new String[]{GROUP_NAME}, new C0773a(this, c3660e));
        }
    }

    @Override // com.alibaba.poplayer.layermanager.ILayerMgrAdapter
    public String getConfigByKey(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-920155272") ? (String) ipChange.ipc$dispatch("-920155272", new Object[]{this, str}) : OrangeConfig.getInstance().getConfig(GROUP_NAME, str, "");
    }

    @Override // com.alibaba.poplayer.layermanager.ILayerMgrAdapter
    public void initializeConfigContainer(final C3660e c3660e) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1605187291")) {
            ipChange.ipc$dispatch("1605187291", new Object[]{this, c3660e});
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
                        } else if ("orange_fucking_silly_bug".equals(OrangeConfig.getInstance().getConfig(DMLayerMgrAdapter.GROUP_NAME, C9556pm.CONFIG_SET_KEY, "orange_fucking_silly_bug"))) {
                            DMLayerMgrAdapter.this.a.postDelayed(this, 1000L);
                            Log.e("DMPopLayer", "TBFaceAdapter$Runnable.run.retry");
                        } else {
                            c3660e.n();
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
