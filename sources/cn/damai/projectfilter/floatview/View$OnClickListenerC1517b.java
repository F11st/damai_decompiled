package cn.damai.projectfilter.floatview;

import android.view.View;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.R$id;
import cn.damai.projectfilter.adapter.CategoryAdapter;
import cn.damai.projectfilter.bean.CategoryBean;
import cn.damai.projectfilter.bean.FilterData;
import cn.damai.projectfilter.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
@Deprecated
/* renamed from: cn.damai.projectfilter.floatview.b */
/* loaded from: classes6.dex */
public class View$OnClickListenerC1517b extends AbstractC1515a<List<CategoryBean>> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private View d;
    private CategoryAdapter e;
    private View f;
    private final int g;
    private long h;

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    /* renamed from: b */
    public void show(@Nullable List<CategoryBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1451992693")) {
            ipChange.ipc$dispatch("-1451992693", new Object[]{this, list});
            return;
        }
        this.h = System.currentTimeMillis();
        this.e.g(list);
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public Type getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-896453502") ? (Type) ipChange.ipc$dispatch("-896453502", new Object[]{this}) : Type.CATEGORY;
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "18385978") ? (View) ipChange.ipc$dispatch("18385978", new Object[]{this}) : this.d;
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671308853")) {
            ipChange.ipc$dispatch("671308853", new Object[]{this});
        } else {
            getFilterUt().s(this.f, System.currentTimeMillis() - this.h);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "604917032")) {
            ipChange.ipc$dispatch("604917032", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.item_filter_reset) {
            this.e.f();
            getFilterUt().i("reset");
        } else if (id == R$id.item_filter_confirm) {
            getFilterUt().i("confirm");
            getListener().onFloatCall(getType(), new FilterData(this.e.b()));
        }
    }
}
