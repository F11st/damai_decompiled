package anetwork.channel.monitor.speed;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public enum NetworkSpeed {
    Slow("弱网络", 1),
    Fast("强网络", 5);
    
    private final int code;
    private final String desc;

    NetworkSpeed(String str, int i) {
        this.desc = str;
        this.code = i;
    }

    public static NetworkSpeed valueOfCode(int i) {
        return i == 1 ? Slow : Fast;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
