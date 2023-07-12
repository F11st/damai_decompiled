package cn.damai.tetris.component.drama.bean;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.tetris.component.category.RankListBean;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class CategoryProjectItem implements Serializable {
    private static final long serialVersionUID = -8894216253807048782L;
    public int index;
    public ProjectItemBean projectItemBean;
    public RankListBean rankBean;
    public boolean hasCurrentCity = true;
    public int type = 4;
    public boolean isCurrentCity = true;
}
