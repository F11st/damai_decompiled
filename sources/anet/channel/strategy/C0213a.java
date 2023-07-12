package anet.channel.strategy;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.a */
/* loaded from: classes.dex */
public class C0213a {
    private static volatile IStrategyInstance a;

    private C0213a() {
    }

    public static IStrategyInstance a() {
        if (a == null) {
            synchronized (C0213a.class) {
                if (a == null) {
                    a = new StrategyInstance();
                }
            }
        }
        return a;
    }
}
