package cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener;

import tb.kn1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface RequestListener<T, E> {
    void onFail(kn1<E> kn1Var, String str, String str2);

    void onSuccess(kn1<E> kn1Var, T t);
}
