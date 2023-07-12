package cn.damai.homepage.show.bean;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class ShowBean implements Serializable {
    private static final long serialVersionUID = -6332897664382964511L;
    public String abBucket;
    public List<ShowBannerBean> banners;
    public List<ShowItemBean> currentCity;
    public long currentTime;
    public String discountInfo;
    public List<ProjectItemBean> nearByCity;
    public int total;
}
