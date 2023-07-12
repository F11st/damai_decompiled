package cn.damai.projectfilter.floatview;

import android.content.Context;
import cn.damai.projectfilter.FloatListener;
import cn.damai.projectfilter.bean.FilterData;
import cn.damai.projectfilter.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.lj0;

/* compiled from: Taobao */
/* renamed from: cn.damai.projectfilter.floatview.a */
/* loaded from: classes6.dex */
public abstract class AbstractC1515a<T> implements FloatLayer<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    protected Context a;
    private FloatListener b;
    private lj0 c;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.projectfilter.floatview.a$a */
    /* loaded from: classes6.dex */
    public class C1516a implements FloatListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1516a(AbstractC1515a abstractC1515a) {
        }

        @Override // cn.damai.projectfilter.FloatListener
        public void onFloatCall(Type type, FilterData filterData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1273433309")) {
                ipChange.ipc$dispatch("-1273433309", new Object[]{this, type, filterData});
            }
        }
    }

    public AbstractC1515a(Context context) {
        this.a = context;
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public lj0 getFilterUt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-20837230")) {
            return (lj0) ipChange.ipc$dispatch("-20837230", new Object[]{this});
        }
        lj0 lj0Var = this.c;
        return lj0Var == null ? new lj0("default") : lj0Var;
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public FloatListener getListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-737537469")) {
            return (FloatListener) ipChange.ipc$dispatch("-737537469", new Object[]{this});
        }
        FloatListener floatListener = this.b;
        return floatListener == null ? new C1516a(this) : floatListener;
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public void setFilterUt(lj0 lj0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-308028224")) {
            ipChange.ipc$dispatch("-308028224", new Object[]{this, lj0Var});
        } else {
            this.c = lj0Var;
        }
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public void setListener(FloatListener floatListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-974668265")) {
            ipChange.ipc$dispatch("-974668265", new Object[]{this, floatListener});
        } else {
            this.b = floatListener;
        }
    }
}
