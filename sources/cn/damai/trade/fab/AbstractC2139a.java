package cn.damai.trade.fab;

import android.widget.ScrollView;
import cn.damai.trade.fab.ObservableScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* renamed from: cn.damai.trade.fab.a */
/* loaded from: classes8.dex */
public abstract class AbstractC2139a implements ObservableScrollView.OnScrollChangedListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private int b;

    abstract void a();

    abstract void b();

    public void c(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1160405039")) {
            ipChange.ipc$dispatch("1160405039", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.b = i;
        }
    }

    @Override // cn.damai.trade.fab.ObservableScrollView.OnScrollChangedListener
    public void onScrollChanged(ScrollView scrollView, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2121676910")) {
            ipChange.ipc$dispatch("-2121676910", new Object[]{this, scrollView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        if (Math.abs(i2 - this.a) > this.b) {
            if (i2 > this.a) {
                b();
            } else {
                a();
            }
        }
        this.a = i2;
    }
}
