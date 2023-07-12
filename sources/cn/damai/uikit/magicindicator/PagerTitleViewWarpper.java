package cn.damai.uikit.magicindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PagerTitleViewWarpper extends RelativeLayout implements IMeasurablePagerTitleView {
    private static transient /* synthetic */ IpChange $ipChange;
    PagerTitleView titleView;

    public PagerTitleViewWarpper(Context context) {
        super(context);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView
    public int getContentBottom() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1725302936")) {
            return ((Integer) ipChange.ipc$dispatch("1725302936", new Object[]{this})).intValue();
        }
        PagerTitleView pagerTitleView = this.titleView;
        if (pagerTitleView == null) {
            return 0;
        }
        return pagerTitleView.getContentBottom();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView
    public int getContentLeft() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1440118780")) {
            return ((Integer) ipChange.ipc$dispatch("1440118780", new Object[]{this})).intValue();
        }
        PagerTitleView pagerTitleView = this.titleView;
        if (pagerTitleView == null) {
            return 0;
        }
        return pagerTitleView.getContentLeft();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView
    public int getContentRight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1459174095")) {
            return ((Integer) ipChange.ipc$dispatch("-1459174095", new Object[]{this})).intValue();
        }
        PagerTitleView pagerTitleView = this.titleView;
        if (pagerTitleView == null) {
            return 0;
        }
        return pagerTitleView.getContentRight();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView
    public int getContentTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-961977192")) {
            return ((Integer) ipChange.ipc$dispatch("-961977192", new Object[]{this})).intValue();
        }
        PagerTitleView pagerTitleView = this.titleView;
        if (pagerTitleView == null) {
            return 0;
        }
        return pagerTitleView.getContentTop();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
    public void onDeselected(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2087178792")) {
            ipChange.ipc$dispatch("-2087178792", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        PagerTitleView pagerTitleView = this.titleView;
        if (pagerTitleView == null) {
            return;
        }
        pagerTitleView.onDeselected(i, i2);
        findViewById(R$id.tab_bg_shadow).setVisibility(8);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
    public void onEnter(int i, int i2, float f, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-119511278")) {
            ipChange.ipc$dispatch("-119511278", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Boolean.valueOf(z)});
            return;
        }
        PagerTitleView pagerTitleView = this.titleView;
        if (pagerTitleView == null) {
            return;
        }
        pagerTitleView.onEnter(i, i2, f, z);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
    public void onLeave(int i, int i2, float f, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1666864723")) {
            ipChange.ipc$dispatch("1666864723", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Boolean.valueOf(z)});
            return;
        }
        PagerTitleView pagerTitleView = this.titleView;
        if (pagerTitleView == null) {
            return;
        }
        pagerTitleView.onLeave(i, i2, f, z);
        findViewById(R$id.tab_bg_shadow).setVisibility(8);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
    public void onSelected(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1583123577")) {
            ipChange.ipc$dispatch("1583123577", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        PagerTitleView pagerTitleView = this.titleView;
        if (pagerTitleView == null) {
            return;
        }
        pagerTitleView.onSelected(i, i2);
        findViewById(R$id.tab_bg_shadow).setVisibility(0);
    }

    public void setTitleView(PagerTitleView pagerTitleView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-724903000")) {
            ipChange.ipc$dispatch("-724903000", new Object[]{this, pagerTitleView});
            return;
        }
        this.titleView = pagerTitleView;
        addView(LayoutInflater.from(getContext()).inflate(R$layout.tab_bg, (ViewGroup) this, false));
        ((ViewGroup) findViewById(R$id.tab_bg_subview)).addView(this.titleView);
    }

    public PagerTitleViewWarpper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PagerTitleViewWarpper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public PagerTitleViewWarpper(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
