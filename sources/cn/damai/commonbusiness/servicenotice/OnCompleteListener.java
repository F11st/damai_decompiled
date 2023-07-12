package cn.damai.commonbusiness.servicenotice;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface OnCompleteListener {
    public static final int TYPE_CLOSE = 0;
    public static final int TYPE_CLOSE_PROMOTION = 5;
    public static final int TYPE_COMPLETE_NOTICE = 1;
    public static final int TYPE_COMPLETE_NOTIFICATION = 2;
    public static final int TYPE_COMPLETE_PRIVILEGE_VERIFY = 4;
    public static final int TYPE_COMPLETE_SUPPORT_SERVICE = 3;

    void onComplete(int i);
}
