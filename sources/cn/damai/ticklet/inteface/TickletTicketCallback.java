package cn.damai.ticklet.inteface;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface TickletTicketCallback {
    void cardCorrespondingNumRequest(String str, String str2, String str3, String str4);

    void renderFailXflush(String str);

    void showTickletDialog(String str, int i);

    void viewPageSlide(int i);

    void viewPageViewType(int i);
}
