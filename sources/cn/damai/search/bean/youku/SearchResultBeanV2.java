package cn.damai.search.bean.youku;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.bean.SearchResultBean;
import cn.damai.tetris.component.discover.bean.NoteBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cb2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchResultBeanV2 extends SearchResultBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<? extends ArtificialProxy> artificialImageTextList;
    public List<? extends ArtificialProxy> artificialThemeList;
    public List<NoteBean> contentNoteList;
    public boolean isEnd;
    public boolean isImageTextEnd;
    public List<ProjectItemBean> recommendProjectList;

    public boolean isShowCombineHeadItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1644261655") ? ((Boolean) ipChange.ipc$dispatch("1644261655", new Object[]{this})).booleanValue() : !cb2.d(this.baccountInfo) || this.tour != null || wh2.e(this.brandOptimization) >= 3 || wh2.e(this.artificialThemeList) + wh2.e(this.artificialImageTextList) > 0;
    }
}
