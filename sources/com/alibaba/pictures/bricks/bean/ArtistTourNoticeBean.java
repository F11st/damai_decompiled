package com.alibaba.pictures.bricks.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ArtistTourNoticeBean implements Serializable {
    public List<BaseArtistDataMo> desc;
    public String status;
    public String statusDesc;
    public List<BaseArtistDataMo> subTitle;
    public String title;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public enum Status {
        NO_INFO("0"),
        NOTICE_NO_CITY("1"),
        NOTICE_PART_CITY("2"),
        PRODUCT_ALREADY("3");
        
        public String value;

        Status(String str) {
            this.value = str;
        }
    }
}
