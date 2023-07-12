package anet.channel;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface IAuth {

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface AuthCallback {
        void onAuthFail(int i, String str);

        void onAuthSuccess();
    }

    void auth(Session session, AuthCallback authCallback);
}
