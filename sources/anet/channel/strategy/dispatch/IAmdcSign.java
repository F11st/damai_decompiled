package anet.channel.strategy.dispatch;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface IAmdcSign {
    String getAppkey();

    String sign(String str);

    boolean useSecurityGuard();
}
