package com.alibaba.pictures.bricks.bean;

import com.alibaba.pictures.bricks.view.FollowView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class FollowBox {
    public final String artistId;
    public boolean isFollowed;
    public final String key;
    public final List<FollowView> mFollowViews = new ArrayList();

    public FollowBox(String str, String str2) {
        this.key = str;
        this.artistId = str2;
    }
}
