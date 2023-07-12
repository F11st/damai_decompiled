package anet.channel.heartbeat;

/* compiled from: Taobao */
/* renamed from: anet.channel.heartbeat.a */
/* loaded from: classes.dex */
public class C0182a {
    public static IHeartbeat a() {
        return new DefaultBgAccsHeartbeatImpl();
    }

    public static IHeartbeat b() {
        return new DefaultHeartbeatImpl();
    }
}
