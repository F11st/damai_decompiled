package cn.damai.search.bean.youku;

import android.text.TextUtils;
import cn.damai.search.bean.youku.ArtificialProxy;
import cn.damai.search.bean.youku.SearchResultBeanYouKu;
import cn.damai.uikit.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;
import tb.ih2;
import tb.jm1;
import tb.m62;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchThemeBean implements ArtificialProxy {
    private static transient /* synthetic */ IpChange $ipChange;
    public String id;
    public String imgUrl;
    public int index;
    public String jumpUrl;
    public boolean show;
    public CharSequence title;

    public SearchThemeBean() {
    }

    public static List<? extends ArtificialProxy> transfer(List<SearchResultBeanYouKu.ListBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "379709524")) {
            return (List) ipChange.ipc$dispatch("379709524", new Object[]{list});
        }
        if (cb2.d(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (SearchResultBeanYouKu.ListBean listBean : list) {
            SearchThemeBean searchThemeBean = new SearchThemeBean(listBean);
            if (searchThemeBean.isValid()) {
                arrayList.add(searchThemeBean);
            }
        }
        return arrayList;
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1218987692") ? (String) ipChange.ipc$dispatch("-1218987692", new Object[]{this}) : this.id;
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public String getImgUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-787051163") ? (String) ipChange.ipc$dispatch("-787051163", new Object[]{this}) : this.imgUrl;
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public CharSequence getTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-79727921") ? (CharSequence) ipChange.ipc$dispatch("-79727921", new Object[]{this}) : this.title;
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public PageSpec getToPageSpec() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1749163536") ? (PageSpec) ipChange.ipc$dispatch("-1749163536", new Object[]{this}) : new PageSpec(this.jumpUrl, null);
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public ArtificialProxy.Type getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1188752037") ? (ArtificialProxy.Type) ipChange.ipc$dispatch("-1188752037", new Object[]{this}) : ArtificialProxy.Type.THEME;
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public int index() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1100512094") ? ((Integer) ipChange.ipc$dispatch("1100512094", new Object[]{this})).intValue() : this.index;
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public boolean isShowVideoTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "964008747") ? ((Boolean) ipChange.ipc$dispatch("964008747", new Object[]{this})).booleanValue() : this.show;
    }

    @Override // cn.damai.search.bean.youku.ArtificialProxy
    public boolean isValid() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1878519473")) {
            return ((Boolean) ipChange.ipc$dispatch("-1878519473", new Object[]{this})).booleanValue();
        }
        return true;
    }

    public SearchThemeBean(SearchResultBeanYouKu.ListBean listBean) {
        if (listBean == null) {
            return;
        }
        this.id = listBean.id;
        this.imgUrl = listBean.theme_image;
        this.index = jm1.j(listBean.idx, 0);
        this.jumpUrl = listBean.url;
        String str = listBean.recommend;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int a = m62.a(mu0.a(), 12.0f);
        this.title = ih2.c(mu0.a(), R$drawable.icon_theme_v2, str, a, a);
    }
}
