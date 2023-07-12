package cn.damai.category.calendar.bean;

import cn.damai.category.category.bean.CategoryItemRankBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ProjectItem implements Serializable {
    private static final long serialVersionUID = -8894216253807048222L;
    public int index;
    public ProjectItemBean projectItemBean;
    public CategoryItemRankBean rankBean;
    public boolean hasCurrentCity = true;
    public int type = 4;
    public boolean isCurrentCity = true;
}
