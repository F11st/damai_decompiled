package cn.damai.tetris.component.home.bean;

import cn.damai.tetris.mvp.CommonBean;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HomeStarTourBean extends CommonBean {
    private static final long serialVersionUID = 5121058330141611346L;
    public List<HomeStarTourItem> content;
    public String mainTitle;
    public String moreText;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class HomeStarTourItem {
        public String artistHeadPic;
        public String artistId;
        public String artistName;
        public String cityName;
        public boolean isSelected;
        public int position;
        public String priceLow;
        public String projectDatetime;
        public String projectId;
        public String projectName;
        public String projectPic;
        public String schema;
        public String total;
        public List<String> tourCityNames;
        public String venueName;
    }
}
