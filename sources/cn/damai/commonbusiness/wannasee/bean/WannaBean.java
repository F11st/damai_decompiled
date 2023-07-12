package cn.damai.commonbusiness.wannasee.bean;

import cn.damai.common.bean.RankBean;
import cn.damai.commonbusiness.scriptmurder.bean.ScriptBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.tetris.component.discover.bean.NoteBean;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WannaBean implements Serializable {
    public List<NoteBean> cards;
    public boolean hasNext;
    public List<ProjectItemBean> items;
    public List<RankBean> rankings;
    public RecommendProjects recommendProjects;
    public List<ScriptBean> scriptInfos;
    public long serverTime = -1;
    public String totalCard;
    public String totalItem;
    public String totalPurchasableItem;
    public String totalRanking;
    public String totalScriptInfo;
}
