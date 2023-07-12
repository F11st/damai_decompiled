package cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request;

import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.MainThreadRequestListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.kn1;

/* compiled from: Taobao */
/* renamed from: cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a */
/* loaded from: classes.dex */
public abstract class AbstractC0818a<T, E> {
    private static transient /* synthetic */ IpChange $ipChange;
    protected final kn1<E> a;

    public AbstractC0818a(kn1<E> kn1Var) {
        this.a = kn1Var;
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671572647")) {
            ipChange.ipc$dispatch("671572647", new Object[]{this});
            return;
        }
        try {
            b();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract void b();

    public void c(@NonNull RequestListener<T, E> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-347390394")) {
            ipChange.ipc$dispatch("-347390394", new Object[]{this, requestListener});
            return;
        }
        MainThreadRequestListener mainThreadRequestListener = new MainThreadRequestListener(requestListener);
        try {
            d(mainThreadRequestListener);
        } catch (Exception e) {
            mainThreadRequestListener.onFail(this.a, e.getMessage(), "IRequest异常");
        }
    }

    public abstract void d(@NonNull RequestListener<T, E> requestListener);
}
