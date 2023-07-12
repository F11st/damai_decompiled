package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectRatingBean implements Serializable {
    private static final long serialVersionUID = -9012170560266356739L;
    public String commentTitle;
    public String commentUrl;
    @Deprecated
    public String content;
    public List<ProjectRatingContentLabelBean> contentLabelDOS;
    @Deprecated
    public List<String> contentTags;
    public String name;
    public double rating;
    public String ratingNumDesc;
    public String ratingSource;
    public int star;
    public String starDesc;
    @Deprecated
    public String userId;
    @Deprecated
    public String userImg;
    public List<ProjectRatingUserBean> userRatingVOS;
}
