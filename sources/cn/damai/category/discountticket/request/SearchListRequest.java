package cn.damai.category.discountticket.request;

import cn.damai.category.discountticket.model.BaseListener;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.search.bean.SearchResultBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import tb.o90;
import tb.y72;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SearchListRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String distanceCityId;
    public String marketTag;
    public String pageIndex;
    public String pageSize;
    public String sortType = "7";
    public String cityId = "0";
    public String returnItemOption = "4";
    public String channel = "10001";
    public String option = "1042";

    public SearchListRequest(String str, String str2, int i, int i2) {
        this.distanceCityId = o90.a(str);
        this.marketTag = str2;
        this.pageIndex = i + "";
        this.pageSize = i2 + "";
    }

    public static MtopBusiness request(String str, boolean z, int i, final BaseListener<SearchResultBean> baseListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-617269332")) {
            return (MtopBusiness) ipChange.ipc$dispatch("-617269332", new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i), baseListener});
        }
        return new SearchListRequest(str, z ? "318" : "1", i, z ? 12 : 10).request(new DMMtopRequestListener<SearchResultBean>(SearchResultBean.class) { // from class: cn.damai.category.discountticket.request.SearchListRequest.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1563638038")) {
                    ipChange2.ipc$dispatch("1563638038", new Object[]{this, str2, str3});
                } else {
                    baseListener.onFail(str2, str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(SearchResultBean searchResultBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1322458784")) {
                    ipChange2.ipc$dispatch("1322458784", new Object[]{this, searchResultBean});
                } else {
                    baseListener.onSuccess(searchResultBean);
                }
            }
        });
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-874964355") ? (String) ipChange.ipc$dispatch("-874964355", new Object[]{this}) : y72.a;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1577167024")) {
            return ((Boolean) ipChange.ipc$dispatch("-1577167024", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1680837580")) {
            return ((Boolean) ipChange.ipc$dispatch("1680837580", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1292772368") ? (String) ipChange.ipc$dispatch("1292772368", new Object[]{this}) : y72.b;
    }
}
