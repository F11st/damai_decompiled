package tb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import cn.damai.projectfiltercopy.filterbtn.FilterBtn;
import cn.damai.projectfiltercopy.floatcontainer.FloatContainer;
import cn.damai.projectfiltercopy.floatview.FloatLayer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class gk0 implements FloatContainer {
    private static transient /* synthetic */ IpChange $ipChange;
    private ViewGroup a;
    private FrameLayout b;
    private FilterBtn c;
    private FloatLayer d;

    /* compiled from: Taobao */
    /* renamed from: tb.gk0$a */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC9177a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC9177a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "282146398")) {
                ipChange.ipc$dispatch("282146398", new Object[]{this, view});
            } else {
                gk0.this.hide();
            }
        }
    }

    public gk0(Context context, ViewGroup viewGroup) {
        this.a = viewGroup;
        FrameLayout frameLayout = new FrameLayout(context);
        this.b = frameLayout;
        this.a.addView(frameLayout, -1, -1);
        this.b.setBackgroundColor(jh0.C_A30_000000);
        viewGroup.setOnClickListener(new View$OnClickListenerC9177a());
    }

    @Override // cn.damai.projectfiltercopy.floatcontainer.FloatContainer
    @Nullable
    public FilterBtn getShowAnchor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-518284338") ? (FilterBtn) ipChange.ipc$dispatch("-518284338", new Object[]{this}) : this.c;
    }

    @Override // cn.damai.projectfiltercopy.floatcontainer.FloatContainer
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1698725026")) {
            ipChange.ipc$dispatch("-1698725026", new Object[]{this});
            return;
        }
        FilterBtn filterBtn = this.c;
        if (filterBtn != null) {
            filterBtn.setState(false);
        }
        this.c = null;
        FloatLayer floatLayer = this.d;
        if (floatLayer != null) {
            floatLayer.hide();
        }
        this.d = null;
        this.a.setVisibility(8);
    }

    @Override // cn.damai.projectfiltercopy.floatcontainer.FloatContainer
    public boolean isShowing() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-525177645") ? ((Boolean) ipChange.ipc$dispatch("-525177645", new Object[]{this})).booleanValue() : this.a.getVisibility() == 0;
    }

    @Override // cn.damai.projectfiltercopy.floatcontainer.FloatContainer
    public void show(FilterBtn filterBtn, FloatLayer floatLayer, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1602808186")) {
            ipChange.ipc$dispatch("-1602808186", new Object[]{this, filterBtn, floatLayer, Integer.valueOf(i)});
            return;
        }
        View view = floatLayer.getView();
        if (view == null) {
            return;
        }
        FilterBtn filterBtn2 = this.c;
        if (filterBtn2 != null) {
            filterBtn2.setState(false);
        }
        FloatLayer floatLayer2 = this.d;
        if (floatLayer2 != null) {
            floatLayer2.hide();
        }
        this.c = filterBtn;
        this.d = floatLayer;
        filterBtn.setState(true);
        if (view.getParent() == null) {
            this.b.addView(view);
        }
        int childCount = this.b.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.b.getChildAt(i2);
            if (childAt == view) {
                childAt.setVisibility(0);
            } else {
                childAt.setVisibility(8);
            }
        }
        if (this.a.getPaddingTop() != i) {
            this.a.setPadding(this.a.getPaddingLeft(), i, this.a.getPaddingRight(), this.a.getPaddingBottom());
        }
        this.a.setVisibility(0);
    }
}
