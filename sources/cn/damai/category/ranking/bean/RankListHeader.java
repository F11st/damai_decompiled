package cn.damai.category.ranking.bean;

import cn.damai.tetris.component.rank.bean.RankItemBean;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RankListHeader implements Serializable {
    private static final long serialVersionUID = 4166342391058408881L;
    public String categoryId;
    public String desc;
    public int followStatus;
    public List<RankItemBean> list;
    public String name;
    public String shareUrl;
    public int type;
    public String updateDesc;
}
