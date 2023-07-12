package com.alibaba.pictures.bricks.channel.bridge;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface OnBizListener<T> {
    void onBizFail(String str, String str2);

    void onBizSuccess(T t);
}
