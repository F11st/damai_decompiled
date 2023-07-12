package cn.damai.category.common.bean;

import cn.damai.category.category.bean.CategoryBannerBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CategoryProjectBean implements Serializable {
    private static final long serialVersionUID = -4157155277393806962L;
    public List<CategoryBannerBean> banners;
    public List<ProjectItemBean> currentCity;
    public long currentTime;
    public String discountInfo;
    public List<ProjectItemBean> nearByCity;
    public int total;
}
