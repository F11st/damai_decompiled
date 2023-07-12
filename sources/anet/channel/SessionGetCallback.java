package anet.channel;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface SessionGetCallback {
    void onSessionGetFail();

    void onSessionGetSuccess(Session session);
}
