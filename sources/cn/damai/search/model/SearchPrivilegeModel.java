package cn.damai.search.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.bean.SearchResultBean;
import cn.damai.search.bean.SearchAccountBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SearchPrivilegeModel {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int INDEX_FIRST_PAGE = 1;
    private static final int INDEX_NO_REQUEST_YET = -1;
    private int countBAccount;
    private int countProject;
    boolean isBAccountHasMore;
    boolean isProjectHasMore;
    private int pageIndexProject = 1;
    private int pageIndexPastProject = 1;
    private int countPastProject = -1;
    private int pageIndexBAccount = -1;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class CombineBean {
        public List<BaccountInfo> bAccountList;
        public boolean isFirstPage;
        public boolean isHasMore;
        public String keyWord;
        public List<ProjectItemBean> pastshowList;
        public List<ProjectItemBean> showList;

        public CombineBean(List<ProjectItemBean> list, List<BaccountInfo> list2, List<ProjectItemBean> list3, String str, boolean z, boolean z2) {
            this.showList = list;
            this.bAccountList = list2;
            this.keyWord = str;
            this.isFirstPage = z;
            this.isHasMore = z2;
            this.pastshowList = list3;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnCombineListener {
        void onFail(boolean z, String str, String str2);

        void onSuccess(@NonNull CombineBean combineBean);
    }

    static /* synthetic */ int access$012(SearchPrivilegeModel searchPrivilegeModel, int i) {
        int i2 = searchPrivilegeModel.countProject + i;
        searchPrivilegeModel.countProject = i2;
        return i2;
    }

    static /* synthetic */ int access$108(SearchPrivilegeModel searchPrivilegeModel) {
        int i = searchPrivilegeModel.pageIndexBAccount;
        searchPrivilegeModel.pageIndexBAccount = i + 1;
        return i;
    }

    static /* synthetic */ int access$308(SearchPrivilegeModel searchPrivilegeModel) {
        int i = searchPrivilegeModel.pageIndexProject;
        searchPrivilegeModel.pageIndexProject = i + 1;
        return i;
    }

    static /* synthetic */ int access$412(SearchPrivilegeModel searchPrivilegeModel, int i) {
        int i2 = searchPrivilegeModel.countBAccount + i;
        searchPrivilegeModel.countBAccount = i2;
        return i2;
    }

    static /* synthetic */ int access$612(SearchPrivilegeModel searchPrivilegeModel, int i) {
        int i2 = searchPrivilegeModel.countPastProject + i;
        searchPrivilegeModel.countPastProject = i2;
        return i2;
    }

    static /* synthetic */ int access$708(SearchPrivilegeModel searchPrivilegeModel) {
        int i = searchPrivilegeModel.pageIndexPastProject;
        searchPrivilegeModel.pageIndexPastProject = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadBAccount(final boolean z, final boolean z2, final String str, @Nullable final List<ProjectItemBean> list, final OnCombineListener onCombineListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "326979902")) {
            ipChange.ipc$dispatch("326979902", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), str, list, onCombineListener});
            return;
        }
        SearchBAccountRequest searchBAccountRequest = new SearchBAccountRequest();
        searchBAccountRequest.keyword = str;
        searchBAccountRequest.baccountType = "5";
        searchBAccountRequest.pageNumber = this.pageIndexBAccount;
        searchBAccountRequest.request(new DMMtopRequestListener<SearchAccountBean>(SearchAccountBean.class) { // from class: cn.damai.search.model.SearchPrivilegeModel.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "592047372")) {
                    ipChange2.ipc$dispatch("592047372", new Object[]{this, str2, str3});
                    return;
                }
                if (z2) {
                    SearchPrivilegeModel.this.pageIndexBAccount = -1;
                }
                onCombineListener.onFail(z, str2, str3);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(SearchAccountBean searchAccountBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1068745858")) {
                    ipChange2.ipc$dispatch("-1068745858", new Object[]{this, searchAccountBean});
                    return;
                }
                if (z2) {
                    SearchPrivilegeModel.access$308(SearchPrivilegeModel.this);
                    SearchPrivilegeModel.access$012(SearchPrivilegeModel.this, wh2.e(list));
                }
                SearchPrivilegeModel.access$108(SearchPrivilegeModel.this);
                List<BaccountInfo> list2 = null;
                if (searchAccountBean == null) {
                    SearchPrivilegeModel.this.isBAccountHasMore = false;
                } else {
                    list2 = searchAccountBean.baccounts;
                    SearchPrivilegeModel.access$412(SearchPrivilegeModel.this, wh2.e(list2));
                    SearchPrivilegeModel searchPrivilegeModel = SearchPrivilegeModel.this;
                    searchPrivilegeModel.isBAccountHasMore = searchPrivilegeModel.countBAccount < searchAccountBean.total;
                }
                SearchPrivilegeModel searchPrivilegeModel2 = SearchPrivilegeModel.this;
                boolean z3 = searchPrivilegeModel2.isBAccountHasMore;
                if (!z3) {
                    searchPrivilegeModel2.loadPast(z, str, onCombineListener, list, list2);
                } else {
                    onCombineListener.onSuccess(new CombineBean(list, list2, null, str, z, z3));
                }
            }
        });
    }

    private void loadCombine(final boolean z, final String str, final OnCombineListener onCombineListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2062841183")) {
            ipChange.ipc$dispatch("-2062841183", new Object[]{this, Boolean.valueOf(z), str, onCombineListener});
            return;
        }
        SearchListRequest searchListRequest = new SearchListRequest();
        searchListRequest.keyword = str;
        searchListRequest.pageIndex = this.pageIndexProject;
        searchListRequest.option = "1073741824";
        searchListRequest.returnItemOption = "3";
        searchListRequest.sourceType = "";
        searchListRequest.sortType = "";
        searchListRequest.cityId = "";
        searchListRequest.distanceCityId = "";
        searchListRequest.request(new DMMtopRequestListener<SearchResultBean>(SearchResultBean.class) { // from class: cn.damai.search.model.SearchPrivilegeModel.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "599806731")) {
                    ipChange2.ipc$dispatch("599806731", new Object[]{this, str2, str3});
                } else {
                    onCombineListener.onFail(z, str2, str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(SearchResultBean searchResultBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-543473717")) {
                    ipChange2.ipc$dispatch("-543473717", new Object[]{this, searchResultBean});
                    return;
                }
                List<ProjectItemBean> list = null;
                if (searchResultBean == null) {
                    SearchPrivilegeModel.this.isProjectHasMore = false;
                } else {
                    list = searchResultBean.projectInfo;
                    int e = SearchPrivilegeModel.this.countProject + wh2.e(list);
                    SearchPrivilegeModel.this.isProjectHasMore = e < searchResultBean.total;
                }
                List<ProjectItemBean> list2 = list;
                SearchPrivilegeModel searchPrivilegeModel = SearchPrivilegeModel.this;
                if (!searchPrivilegeModel.isProjectHasMore) {
                    searchPrivilegeModel.pageIndexBAccount = 1;
                    SearchPrivilegeModel.this.loadBAccount(z, true, str, list2, onCombineListener);
                    return;
                }
                SearchPrivilegeModel.access$308(searchPrivilegeModel);
                SearchPrivilegeModel.access$012(SearchPrivilegeModel.this, wh2.e(list2));
                onCombineListener.onSuccess(new CombineBean(searchResultBean.projectInfo, null, null, str, z, true));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadPast(final boolean z, final String str, final OnCombineListener onCombineListener, final List<ProjectItemBean> list, final List<BaccountInfo> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1812535426")) {
            ipChange.ipc$dispatch("-1812535426", new Object[]{this, Boolean.valueOf(z), str, onCombineListener, list, list2});
            return;
        }
        if (z) {
            this.pageIndexPastProject = 1;
        }
        SearchListRequest searchListRequest = new SearchListRequest();
        searchListRequest.keyword = str;
        searchListRequest.pageIndex = this.pageIndexPastProject;
        searchListRequest.option = "1073741824";
        searchListRequest.returnItemOption = "3";
        searchListRequest.sourceType = "";
        searchListRequest.sortType = "";
        searchListRequest.returnItemStatusOption = "3";
        searchListRequest.cityId = "";
        searchListRequest.distanceCityId = "";
        searchListRequest.request(new DMMtopRequestListener<SearchResultBean>(SearchResultBean.class) { // from class: cn.damai.search.model.SearchPrivilegeModel.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "584288013")) {
                    ipChange2.ipc$dispatch("584288013", new Object[]{this, str2, str3});
                } else {
                    onCombineListener.onFail(z, str2, str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(SearchResultBean searchResultBean) {
                List<ProjectItemBean> list3;
                boolean z2;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1364984073")) {
                    ipChange2.ipc$dispatch("1364984073", new Object[]{this, searchResultBean});
                    return;
                }
                if (searchResultBean == null) {
                    list3 = null;
                    z2 = false;
                } else {
                    List<ProjectItemBean> list4 = searchResultBean.projectInfo;
                    list3 = list4;
                    z2 = SearchPrivilegeModel.this.countPastProject + wh2.e(list4) < searchResultBean.total;
                }
                SearchPrivilegeModel.access$708(SearchPrivilegeModel.this);
                SearchPrivilegeModel.access$612(SearchPrivilegeModel.this, wh2.e(list3));
                onCombineListener.onSuccess(new CombineBean(list, list2, list3, str, z, z2));
            }
        });
    }

    public void load(boolean z, String str, OnCombineListener onCombineListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-921477526")) {
            ipChange.ipc$dispatch("-921477526", new Object[]{this, Boolean.valueOf(z), str, onCombineListener});
            return;
        }
        if (z) {
            this.pageIndexProject = 1;
            this.pageIndexBAccount = -1;
            this.pageIndexPastProject = 1;
            this.countProject = 0;
            this.countBAccount = 0;
            this.countPastProject = 0;
            this.isBAccountHasMore = true;
            this.isProjectHasMore = true;
        }
        if (!this.isBAccountHasMore && !this.isProjectHasMore) {
            loadPast(false, str, onCombineListener, null, null);
        } else if (this.pageIndexBAccount > -1) {
            loadBAccount(false, false, str, null, onCombineListener);
        } else {
            loadCombine(z, str, onCombineListener);
        }
    }
}
