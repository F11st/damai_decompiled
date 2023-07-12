package cn.damai.category.category.bean;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class StarAndBrandItem implements Serializable {
    private static final long serialVersionUID = 7161508618746284983L;
    public List<BrandBean> brandList;
    public int index;
    public int position;
    public ProjectItemBean projectItemBean;
    public StarBean starBean;
    public ToursBean toursBean;
    public int type = 4;
}
