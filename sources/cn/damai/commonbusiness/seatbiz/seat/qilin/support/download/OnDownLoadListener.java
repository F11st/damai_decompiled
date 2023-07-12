package cn.damai.commonbusiness.seatbiz.seat.qilin.support.download;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface OnDownLoadListener<T> {
    T callSubThread(byte[] bArr) throws Exception;

    void onFail(int i, String str);

    void onLimit();

    void onSuccess(T t);
}
