package cn.damai.launcher.splash.model.listener;

import android.os.Handler;
import android.os.Looper;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.downloader.request.C6703a;
import com.taobao.downloader.request.DownloadListener;
import tb.jq1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class OnAdMainThreadFileListener extends C6703a {
    private static transient /* synthetic */ IpChange $ipChange;
    private final OnBizListener<String> mListener;

    public OnAdMainThreadFileListener(OnBizListener<String> onBizListener) {
        this.mListener = onBizListener;
    }

    private boolean isMainThread() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1480394558") ? ((Boolean) ipChange.ipc$dispatch("-1480394558", new Object[]{this})).booleanValue() : Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    @Override // com.taobao.downloader.request.C6703a, com.taobao.downloader.request.DownloadListener
    public void onDownloadError(String str, final int i, final String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1042876475")) {
            ipChange.ipc$dispatch("-1042876475", new Object[]{this, str, Integer.valueOf(i), str2});
        } else if (isMainThread()) {
            OnBizListener<String> onBizListener = this.mListener;
            onBizListener.onBizFail(i + "", str2);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: cn.damai.launcher.splash.model.listener.OnAdMainThreadFileListener.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2080275591")) {
                        ipChange2.ipc$dispatch("2080275591", new Object[]{this});
                        return;
                    }
                    OnBizListener onBizListener2 = OnAdMainThreadFileListener.this.mListener;
                    onBizListener2.onBizFail(i + "", str2);
                }
            });
        }
    }

    @Override // com.taobao.downloader.request.C6703a, com.taobao.downloader.request.DownloadListener
    public void onDownloadFinish(String str, final String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1085550043")) {
            ipChange.ipc$dispatch("-1085550043", new Object[]{this, str, str2});
        } else if (isMainThread()) {
            this.mListener.onBizSuccess(str2);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: cn.damai.launcher.splash.model.listener.OnAdMainThreadFileListener.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1883762086")) {
                        ipChange2.ipc$dispatch("1883762086", new Object[]{this});
                    } else {
                        OnAdMainThreadFileListener.this.mListener.onBizSuccess(str2);
                    }
                }
            });
        }
    }

    @Override // com.taobao.downloader.request.C6703a, com.taobao.downloader.request.DownloadListener
    public void onNetworkLimit(int i, jq1 jq1Var, DownloadListener.NetworkLimitCallback networkLimitCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1019682537")) {
            ipChange.ipc$dispatch("-1019682537", new Object[]{this, Integer.valueOf(i), jq1Var, networkLimitCallback});
        } else if (isMainThread()) {
            this.mListener.onBizFail("-1", "network_limit");
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: cn.damai.launcher.splash.model.listener.OnAdMainThreadFileListener.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1687248581")) {
                        ipChange2.ipc$dispatch("1687248581", new Object[]{this});
                    } else {
                        OnAdMainThreadFileListener.this.mListener.onBizFail("-1", "network_limit");
                    }
                }
            });
        }
    }
}
