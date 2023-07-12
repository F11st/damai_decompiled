package cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener;

import android.os.Handler;
import android.os.Looper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.kn1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class MainThreadRequestListener<T, E> implements RequestListener<T, E> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Handler a;
    private final RequestListener<T, E> b;

    public MainThreadRequestListener(RequestListener<T, E> requestListener) {
        this.b = requestListener;
    }

    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-940031490")) {
            ipChange.ipc$dispatch("-940031490", new Object[]{this});
        } else if (this.a == null) {
            this.a = new Handler(Looper.getMainLooper());
        }
    }

    private boolean c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1783826281") ? ((Boolean) ipChange.ipc$dispatch("-1783826281", new Object[]{this})).booleanValue() : Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    private void d(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "781584480")) {
            ipChange.ipc$dispatch("781584480", new Object[]{this, runnable});
            return;
        }
        b();
        this.a.post(runnable);
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
    public void onFail(final kn1<E> kn1Var, final String str, final String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-452434807")) {
            ipChange.ipc$dispatch("-452434807", new Object[]{this, kn1Var, str, str2});
        } else if (this.b == null) {
        } else {
            if (c()) {
                this.b.onFail(kn1Var, str, str2);
            } else {
                d(new Runnable() { // from class: cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.MainThreadRequestListener.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1696523121")) {
                            ipChange2.ipc$dispatch("1696523121", new Object[]{this});
                        } else {
                            MainThreadRequestListener.this.b.onFail(kn1Var, str, str2);
                        }
                    }
                });
            }
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
    public void onSuccess(final kn1<E> kn1Var, final T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671146830")) {
            ipChange.ipc$dispatch("671146830", new Object[]{this, kn1Var, t});
        } else if (this.b == null) {
        } else {
            if (c()) {
                this.b.onSuccess(kn1Var, t);
            } else {
                d(new Runnable() { // from class: cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.MainThreadRequestListener.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1893036626")) {
                            ipChange2.ipc$dispatch("1893036626", new Object[]{this});
                        } else {
                            MainThreadRequestListener.this.b.onSuccess(kn1Var, t);
                        }
                    }
                });
            }
        }
    }
}
