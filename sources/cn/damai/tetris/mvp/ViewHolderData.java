package cn.damai.tetris.mvp;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ViewHolderData<T> implements Serializable {
    public Class<T> bean;
    public Class<T> viewHolder;

    public ViewHolderData(Class<T> cls, Class<T> cls2) {
        this.viewHolder = cls;
        this.bean = cls2;
    }
}
