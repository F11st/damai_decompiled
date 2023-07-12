package cn.damai.search.contract;

import cn.damai.common.app.base.AbstractC0470a;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.BaseView;
import cn.damai.commonbusiness.search.bean.SearchResultBean;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface SearchResultContract {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static abstract class Presenter extends AbstractC0470a<View, Model> {
        public abstract void getSearchList(String str, String str2, int i, String str3, String str4);
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface View extends BaseView {
        void error(String str, String str2, String str3, String str4, int i);

        void returnSearchList(SearchResultBean searchResultBean, String str);
    }
}
