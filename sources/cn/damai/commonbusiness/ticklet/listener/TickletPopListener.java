package cn.damai.commonbusiness.ticklet.listener;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface TickletPopListener {
    void doNotShowTickletPopWindow();

    void popWindowClickListener(String str);

    void showPopFailed();

    void showPopWindow(String str);
}
