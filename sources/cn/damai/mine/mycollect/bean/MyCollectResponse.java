package cn.damai.mine.mycollect.bean;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class MyCollectResponse implements Serializable {
    public String errorCode;
    public String errorMsg;
    public boolean hasNext;
    public List<ProjectItemBean> items;
    public int pageNo;
    public List<cn.damai.common.bean.RankBean> rankings;
    public boolean requestSuccess;
    public String totalCard;
    public String totalItem;
    public String totalRanking;
}
