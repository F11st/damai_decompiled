package cn.damai.discover.main.bean;

import cn.damai.tetris.component.discover.bean.VideoInfo;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class FollowRecommendBean implements Serializable {
    private static final long serialVersionUID = 5274911782591023306L;
    public List<String> contentImage;
    public String contentText;
    public int index;
    public String publishTime;
    public FollowRelateThemeBean relateTheme;
    public FollowUserInfoBean userInfo;
    public VideoInfo videoInfo;
}
