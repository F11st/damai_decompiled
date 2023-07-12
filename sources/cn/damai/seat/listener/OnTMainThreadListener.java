package cn.damai.seat.listener;

import android.os.Handler;
import android.os.Looper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.r92;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class OnTMainThreadListener<T> implements OnTListener<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final OnTListener<T> a;

    public OnTMainThreadListener(OnTListener<T> onTListener) {
        this.a = onTListener;
    }

    @Override // cn.damai.seat.listener.OnTListener
    public void call(final T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-700075053")) {
            ipChange.ipc$dispatch("-700075053", new Object[]{this, t});
        } else if (this.a == null) {
        } else {
            if (r92.a()) {
                this.a.call(t);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: cn.damai.seat.listener.OnTMainThreadListener.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1429579075")) {
                            ipChange2.ipc$dispatch("-1429579075", new Object[]{this});
                        } else {
                            OnTMainThreadListener.this.a.call(t);
                        }
                    }
                });
            }
        }
    }
}
