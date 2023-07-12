package cn.damai.projectfilter.listener;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import cn.damai.projectfilter.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class FilterBtnClickProxyHListener implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Type a;
    private FilterBtnClickListener b;
    private FilterBtnAction c;
    private Handler d = new Handler(Looper.getMainLooper());

    public FilterBtnClickProxyHListener(Type type, FilterBtnClickListener filterBtnClickListener, FilterBtnAction filterBtnAction) {
        this.a = type;
        this.b = filterBtnClickListener;
        this.c = filterBtnAction;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-697275878")) {
            ipChange.ipc$dispatch("-697275878", new Object[]{this, view});
            return;
        }
        FilterBtnAction filterBtnAction = this.c;
        if (filterBtnAction != null) {
            filterBtnAction.doBeforeFilterBtnClick(this.a);
        }
        if (this.b == null) {
            return;
        }
        this.d.post(new Runnable() { // from class: cn.damai.projectfilter.listener.FilterBtnClickProxyHListener.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1741541609")) {
                    ipChange2.ipc$dispatch("1741541609", new Object[]{this});
                } else {
                    FilterBtnClickProxyHListener.this.b.onFilterBtnClick(view, FilterBtnClickProxyHListener.this.c != null ? FilterBtnClickProxyHListener.this.c.computeFloatTopPadding() : 0);
                }
            }
        });
    }
}
