package cn.damai.category.categorygirl.repository;

import cn.damai.category.categorygirl.request.SearchListRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.search.bean.SearchResultBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CategoryGirlRepository implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -7515839936326335569L;

    public void getSearch(SearchListRequest searchListRequest, DMMtopRequestListener<SearchResultBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1867314284")) {
            ipChange.ipc$dispatch("1867314284", new Object[]{this, searchListRequest, dMMtopRequestListener});
        } else {
            searchListRequest.request(dMMtopRequestListener);
        }
    }
}
