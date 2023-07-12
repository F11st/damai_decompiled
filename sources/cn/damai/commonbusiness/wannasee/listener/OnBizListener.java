package cn.damai.commonbusiness.wannasee.listener;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface OnBizListener<T> {
    void onBizFail(String str, String str2);

    void onBizSuccess(T t);
}
