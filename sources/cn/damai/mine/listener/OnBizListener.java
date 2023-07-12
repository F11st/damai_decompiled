package cn.damai.mine.listener;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface OnBizListener<T> {
    void onBizFail(String str, String str2);

    void onBizSuccess(T t);
}
