package cn.damai.launcher.splash.model.request;

import android.os.Handler;
import android.os.Looper;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public abstract class TimeSensitiveRequest<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int mPresetTimeOutMills;
    private Runnable mTimeOutTask;
    private final AtomicBoolean willNotCallTimeOut = new AtomicBoolean(false);
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnResultListener<T> {
        void onFail(String str, String str2);

        void onSuccess(boolean z, T t);

        void onTimeOutPreset();
    }

    public TimeSensitiveRequest(int i) {
        this.mPresetTimeOutMills = Math.max(i, 0);
    }

    protected abstract void callRequest(OnBizListener<T> onBizListener);

    public void request(final OnResultListener<T> onResultListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-23440263")) {
            ipChange.ipc$dispatch("-23440263", new Object[]{this, onResultListener});
            return;
        }
        callRequest(new OnBizListener<T>() { // from class: cn.damai.launcher.splash.model.request.TimeSensitiveRequest.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
            public void onBizFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1851396862")) {
                    ipChange2.ipc$dispatch("-1851396862", new Object[]{this, str, str2});
                    return;
                }
                TimeSensitiveRequest.this.willNotCallTimeOut.set(true);
                if (TimeSensitiveRequest.this.mTimeOutTask != null) {
                    TimeSensitiveRequest.this.mMainHandler.removeCallbacks(TimeSensitiveRequest.this.mTimeOutTask);
                }
                onResultListener.onFail(str, str2);
            }

            @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
            public void onBizSuccess(T t) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1065081609")) {
                    ipChange2.ipc$dispatch("-1065081609", new Object[]{this, t});
                    return;
                }
                boolean z = TimeSensitiveRequest.this.willNotCallTimeOut.get();
                TimeSensitiveRequest.this.willNotCallTimeOut.set(true);
                if (TimeSensitiveRequest.this.mTimeOutTask != null) {
                    TimeSensitiveRequest.this.mMainHandler.removeCallbacks(TimeSensitiveRequest.this.mTimeOutTask);
                }
                onResultListener.onSuccess(z, t);
            }
        });
        Runnable runnable = new Runnable() { // from class: cn.damai.launcher.splash.model.request.TimeSensitiveRequest.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-68567276")) {
                    ipChange2.ipc$dispatch("-68567276", new Object[]{this});
                } else if (TimeSensitiveRequest.this.willNotCallTimeOut.compareAndSet(false, true)) {
                    onResultListener.onTimeOutPreset();
                }
            }
        };
        this.mTimeOutTask = runnable;
        this.mMainHandler.postDelayed(runnable, this.mPresetTimeOutMills);
    }
}
