package cn.damai.launcher.splash.api;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class GetCouponResponse implements Serializable {
    public List<Coupon> coupons;
    public List<ProjectItemBean> projectDOList;
    public String projectSchema;
}
