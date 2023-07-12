package cn.damai.tetris.component.drama.bean;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class CategoryItemListBean implements Serializable {
    private static final long serialVersionUID = 2692111111706503L;
    public String abBucket;
    public List<CategoryItemBean> currentCity;
    public long currentTime;
    public String discountInfo;
    public List<ProjectItemBean> nearByCity;
    public int total;
}
