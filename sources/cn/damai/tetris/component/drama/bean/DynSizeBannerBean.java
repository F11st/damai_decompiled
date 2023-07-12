package cn.damai.tetris.component.drama.bean;

import cn.damai.uikit.banner.sub.BannerItem;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DynSizeBannerBean implements BannerItem {
    private static transient /* synthetic */ IpChange $ipChange;
    public int height;
    public String pic;
    public String url;
    public int width;

    @Override // cn.damai.uikit.banner.sub.BannerItem
    public String bannerPicUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-397851504") ? (String) ipChange.ipc$dispatch("-397851504", new Object[]{this}) : this.pic;
    }

    @Override // cn.damai.uikit.banner.sub.BannerItem
    public String bannerUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "656110074") ? (String) ipChange.ipc$dispatch("656110074", new Object[]{this}) : this.url;
    }
}
