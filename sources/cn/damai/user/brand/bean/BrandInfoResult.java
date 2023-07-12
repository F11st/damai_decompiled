package cn.damai.user.brand.bean;

import cn.damai.commonbusiness.brand.BrandOptimizationDO;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class BrandInfoResult implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long serialVersionUID = 2359580200504254192L;
    public List<UdpBrandBannerDO> banner;
    public List<VipCard> brandCouponList;
    public List<BrandOptimizationDO> brandOptimization;
    public List<CommonCard> commonCouponList;
    public JSONObject errorMsg;
    public List<ProjectItemBean> excellentRepresentation;
    public List<BrandCommentProjectDO> projectComments;
    public List<BrandWonderfulDO> wonderfulMoment;

    public void addErrorMsg(JSONObject jSONObject, Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "515564468")) {
            ipChange.ipc$dispatch("515564468", new Object[]{this, jSONObject, bool});
        } else if (bool.booleanValue()) {
            JSONObject jSONObject2 = this.errorMsg;
            if (jSONObject2 != null) {
                jSONObject2.putAll(jSONObject);
            } else {
                this.errorMsg = jSONObject;
            }
        }
    }
}
