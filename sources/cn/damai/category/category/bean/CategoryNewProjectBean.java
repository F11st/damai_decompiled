package cn.damai.category.category.bean;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CategoryNewProjectBean implements Serializable {
    private static final long serialVersionUID = 2692441815448706503L;
    public String abBucket;
    public List<CategoryBannerBean> banners;
    public List<CategoryItemBean> currentCity;
    public long currentTime;
    public String discountInfo;
    public List<ProjectItemBean> nearByCity;
    public int total;
}
