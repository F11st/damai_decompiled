package cn.damai.search.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SearchFindWordList implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<SearchFindWord> hotWords;
    public SearchTip searchTip;
    public String top;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class SearchTip implements Serializable {
        public String alg;
        public String keyword;

        public SearchTip() {
        }
    }

    public String getSearchTip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1400806364")) {
            return (String) ipChange.ipc$dispatch("-1400806364", new Object[]{this});
        }
        SearchTip searchTip = this.searchTip;
        return (searchTip == null || TextUtils.isEmpty(searchTip.keyword)) ? "" : this.searchTip.keyword;
    }

    public boolean isFindTop() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1140690013") ? ((Boolean) ipChange.ipc$dispatch("-1140690013", new Object[]{this})).booleanValue() : TextUtils.isEmpty(this.top) || !"history".equals(this.top);
    }
}
