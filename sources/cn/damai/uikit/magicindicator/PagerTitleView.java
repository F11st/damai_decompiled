package cn.damai.uikit.magicindicator;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;
import tb.wr2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PagerTitleView extends SimplePagerTitleView {
    private static transient /* synthetic */ IpChange $ipChange;

    public PagerTitleView(Context context) {
        super(context);
        int a = wr2.a(context, 5.0d);
        setPadding(a, a, a, a);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
    public void onDeselected(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "867006873")) {
            ipChange.ipc$dispatch("867006873", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onDeselected(i, i2);
        setTextSize(16.0f);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
    public void onSelected(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "589550714")) {
            ipChange.ipc$dispatch("589550714", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onSelected(i, i2);
        setTextSize(16.0f);
    }
}
