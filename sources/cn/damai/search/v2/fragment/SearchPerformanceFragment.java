package cn.damai.search.v2.fragment;

import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import cn.damai.search.bean.SearchResultTabEnum;
import cn.damai.search.v2.bean.InputInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class SearchPerformanceFragment extends SearchBaseFragment {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment, cn.damai.search.v2.listener.SearchInputObserver
    public void dispatchInputWord(InputInfo inputInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-850266642")) {
            ipChange.ipc$dispatch("-850266642", new Object[]{this, inputInfo});
        } else if (inputInfo == null) {
        } else {
            this.noMoreNodeData.put("content", (Object) ("\"" + inputInfo.inputText + "\"相关演出只有这么多啦"));
            super.dispatchInputWord(inputInfo);
        }
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    protected String getEmptyPageDesSuffix() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1759660592") ? (String) ipChange.ipc$dispatch("-1759660592", new Object[]{this}) : ErrControlViewInfo.TYPE_PROJECT;
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    protected int getRequestPageSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2136011975")) {
            return ((Integer) ipChange.ipc$dispatch("2136011975", new Object[]{this})).intValue();
        }
        return 15;
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    protected String getRequestPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-661775979") ? (String) ipChange.ipc$dispatch("-661775979", new Object[]{this}) : "searchPerformance";
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    protected String getRequestPatternVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1052973692") ? (String) ipChange.ipc$dispatch("-1052973692", new Object[]{this}) : "1.0";
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.ITab
    public String getTabTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "180008236") ? (String) ipChange.ipc$dispatch("180008236", new Object[]{this}) : SearchResultTabEnum.PERFORMANCE.content;
    }
}
