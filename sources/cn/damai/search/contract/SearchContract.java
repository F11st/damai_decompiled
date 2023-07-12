package cn.damai.search.contract;

import cn.damai.common.app.base.AbstractC0470a;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.BaseView;
import cn.damai.commonbusiness.artist.ArtistFollowResultBean;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.search.bean.PageIndexParams;
import cn.damai.search.bean.SearchEggs;
import cn.damai.search.bean.SearchFindWordList;
import cn.damai.search.bean.SearchTourUT;
import cn.damai.search.bean.SearchWord;
import cn.damai.search.bean.youku.SearchResultBeanV2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface SearchContract {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static abstract class Presenter extends AbstractC0470a<View, Model> {
        public abstract void getSearchEggs(String str);

        public abstract void getSearchFindList();

        public abstract void getSearchListV2(String str, PageIndexParams.Params params);

        public abstract void getSearchSuggest(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface View extends BaseView {
        void error(String str, String str2, String str3, String str4, int i);

        void jumpAccountMainPage(BaccountInfo baccountInfo);

        void pageRefresh(int i);

        void requestAccountFollow(BaccountInfo baccountInfo);

        void returnSearchEggs(SearchEggs searchEggs, String str);

        void returnSearchFindList(SearchFindWordList searchFindWordList);

        void returnSearchListV2(SearchResultBeanV2 searchResultBeanV2, String str, PageIndexParams.Params params);

        void returnSearchSuggest(SearchWord searchWord, String str);

        void tourCityJumpProject(SearchTourUT searchTourUT);

        void updateAccountFollowState(ArtistFollowResultBean artistFollowResultBean);
    }
}
