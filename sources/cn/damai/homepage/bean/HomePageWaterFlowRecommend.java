package cn.damai.homepage.bean;

import cn.damai.tetris.component.home.bean.HomeTitleBean;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class HomePageWaterFlowRecommend implements Serializable {
    private static final long serialVersionUID = -5933555963626460974L;
    public List<WaterFlowRecommendItem> content;
    public String isLast;
    public String lastPage;
    public String mainTitle;
    public List<HomeTitleBean.Title> mainTitles;
    public String offset;
}
