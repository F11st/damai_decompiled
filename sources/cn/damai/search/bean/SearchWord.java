package cn.damai.search.bean;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.search.bean.youku.SuggestBean;
import cn.damai.search.bean.youku.SuggestRes;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SearchWord {
    private static transient /* synthetic */ IpChange $ipChange;
    public long currentTime;
    @Deprecated
    public ProjectItemBean project;
    public List<SearchSuggest> words;

    public static SearchWord youKuSuggestToNative(SuggestRes suggestRes) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-793906173")) {
            return (SearchWord) ipChange.ipc$dispatch("-793906173", new Object[]{suggestRes});
        }
        SearchWord searchWord = new SearchWord();
        if (suggestRes != null && !cb2.d(suggestRes.resultList)) {
            List<SuggestBean> list = suggestRes.resultList;
            ArrayList arrayList = new ArrayList();
            searchWord.words = arrayList;
            for (SuggestBean suggestBean : list) {
                arrayList.add(new SearchSuggest(suggestBean.query, suggestBean.word));
            }
        }
        return searchWord;
    }
}
