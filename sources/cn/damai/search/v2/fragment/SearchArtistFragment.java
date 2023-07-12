package cn.damai.search.v2.fragment;

import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import cn.damai.search.bean.SearchResultTabEnum;
import cn.damai.search.v2.bean.InputInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchArtistFragment extends SearchBaseFragment {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment, cn.damai.search.v2.listener.SearchInputObserver
    public void dispatchInputWord(InputInfo inputInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2045230429")) {
            ipChange.ipc$dispatch("2045230429", new Object[]{this, inputInfo});
        } else if (inputInfo == null) {
        } else {
            this.noMoreNodeData.put("content", (Object) ("\"" + inputInfo.inputText + "\"相关艺人只有这么多啦"));
            super.dispatchInputWord(inputInfo);
        }
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    protected String getEmptyPageDesSuffix() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-173368449") ? (String) ipChange.ipc$dispatch("-173368449", new Object[]{this}) : ErrControlViewInfo.TYPE_ARTIST;
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    protected int getRequestPageSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-609204234")) {
            return ((Integer) ipChange.ipc$dispatch("-609204234", new Object[]{this})).intValue();
        }
        return 15;
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    protected String getRequestPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "924516164") ? (String) ipChange.ipc$dispatch("924516164", new Object[]{this}) : "searchArtist";
    }

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    protected String getRequestPatternVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1348899467") ? (String) ipChange.ipc$dispatch("-1348899467", new Object[]{this}) : "1.0";
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.ITab
    public String getTabTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "944445851") ? (String) ipChange.ipc$dispatch("944445851", new Object[]{this}) : SearchResultTabEnum.ARTIST.content;
    }
}
