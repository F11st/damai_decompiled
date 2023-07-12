package com.alibaba.pictures.bricks.bean;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ArtistTopBean implements Serializable {
    public String artistName = "";
    public String followStatus = "";
    public ShareBean shareVO = null;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class ShareBean implements Serializable {
        public String id;
        public String sharePic;
        public String shareSubTitle;
        public String shareTitle;
        public String shareUrl;
        public String targetType;
    }
}
