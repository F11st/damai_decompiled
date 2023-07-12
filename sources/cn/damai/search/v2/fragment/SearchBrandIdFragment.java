package cn.damai.search.v2.fragment;

import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import cn.damai.search.bean.SearchResultTabEnum;
import cn.damai.search.v2.bean.InputInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchBrandIdFragment extends SearchBaseFragment {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment, cn.damai.search.v2.listener.SearchInputObserver
    public void dispatchInputWord(InputInfo inputInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-927337920")) {
            ipChange.ipc$dispatch("-927337920", new Object[]{this, inputInfo});
        } else if (inputInfo == null) {
        } else {
            this.noMoreNodeData.put("content", (Object) ("\"" + inputInfo.inputText + "\"相关厂牌只有这么多啦"));
            super.dispatchInputWord(inputInfo);
        }
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    protected String getEmptyPageDesSuffix() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1582970462") ? (String) ipChange.ipc$dispatch("-1582970462", new Object[]{this}) : ErrControlViewInfo.TYPE_BRAND_IP;
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    protected int getRequestPageSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1788323225")) {
            return ((Integer) ipChange.ipc$dispatch("1788323225", new Object[]{this})).intValue();
        }
        return 15;
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    protected String getRequestPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-485085849") ? (String) ipChange.ipc$dispatch("-485085849", new Object[]{this}) : "searchBrandIP";
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    protected String getRequestPatternVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1387751538") ? (String) ipChange.ipc$dispatch("1387751538", new Object[]{this}) : "1.0";
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.ITab
    public String getTabTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1962936190") ? (String) ipChange.ipc$dispatch("1962936190", new Object[]{this}) : SearchResultTabEnum.BRAND.content;
    }
}
