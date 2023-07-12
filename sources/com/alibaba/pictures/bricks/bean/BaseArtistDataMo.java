package com.alibaba.pictures.bricks.bean;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BaseArtistDataMo implements Serializable {
    public String value;
    public ValueType valueType;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public enum ValueType {
        TEXT,
        PIC,
        NUM
    }
}
