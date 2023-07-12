package cn.damai.category.categorygirl.model;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import cn.damai.category.categorygirl.repository.CategoryGirlRepository;
import cn.damai.category.categorygirl.request.SearchListRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.search.bean.SearchResultBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CategoryGirlModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private MutableLiveData<SearchResultBean> mSearchResultBean = new MutableLiveData<>();
    private CategoryGirlRepository mRepository = new CategoryGirlRepository();

    public CategoryGirlModel(Context context) {
        this.mContext = context;
    }

    public MutableLiveData<SearchResultBean> getSearchListBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1650509845") ? (MutableLiveData) ipChange.ipc$dispatch("1650509845", new Object[]{this}) : this.mSearchResultBean;
    }

    public void searchRequest(SearchListRequest searchListRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1054311977")) {
            ipChange.ipc$dispatch("1054311977", new Object[]{this, searchListRequest});
        } else {
            this.mRepository.getSearch(searchListRequest, new DMMtopRequestListener<SearchResultBean>(SearchResultBean.class) { // from class: cn.damai.category.categorygirl.model.CategoryGirlModel.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "414782915")) {
                        ipChange2.ipc$dispatch("414782915", new Object[]{this, str, str2});
                    } else {
                        CategoryGirlModel.this.mSearchResultBean.setValue(null);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(SearchResultBean searchResultBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1026416659")) {
                        ipChange2.ipc$dispatch("1026416659", new Object[]{this, searchResultBean});
                    } else {
                        CategoryGirlModel.this.mSearchResultBean.setValue(searchResultBean);
                    }
                }
            });
        }
    }
}
