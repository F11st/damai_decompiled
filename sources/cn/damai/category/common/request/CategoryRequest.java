package cn.damai.category.common.request;

import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CategoryRequest extends DMBaseMtopRequest implements Serializable, Cloneable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 4326435736917912092L;
    public String categoryId;
    public String cityName;
    public int cityOption;
    public int dateType;
    public String endDate;
    public String latitude;
    public String longitude;
    public String startDate;
    public String subcategoryId;
    public String currentCityId = z20.c();
    public String channel = "10001";
    public String returnItemOption = "4";
    public int sortType = 3;
    public int pageIndex = 1;
    public String pageSize = "15";
    public List<String> projectIdList = new ArrayList();
    public String userId = z20.E();
    public String apiVersion = "1.2";
    public String dmChannel = AppConfig.p();

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1619816055") ? (String) ipChange.ipc$dispatch("1619816055", new Object[]{this}) : "mtop.damai.wireless.search.project.classify";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "51433110")) {
            return ((Boolean) ipChange.ipc$dispatch("51433110", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-897496686")) {
            return ((Boolean) ipChange.ipc$dispatch("-897496686", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-507414518") ? (String) ipChange.ipc$dispatch("-507414518", new Object[]{this}) : this.apiVersion;
    }

    /* renamed from: clone */
    public CategoryRequest m8clone() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1342703731")) {
            return (CategoryRequest) ipChange.ipc$dispatch("-1342703731", new Object[]{this});
        }
        try {
            return (CategoryRequest) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
