package anet.channel.entity;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public enum ENV {
    ONLINE(0),
    PREPARE(1),
    TEST(2);
    
    private int envMode;

    ENV(int i) {
        this.envMode = i;
    }

    public int getEnvMode() {
        return this.envMode;
    }

    public void setEnvMode(int i) {
        this.envMode = i;
    }

    public static ENV valueOf(int i) {
        if (i != 1) {
            if (i != 2) {
                return ONLINE;
            }
            return TEST;
        }
        return PREPARE;
    }
}
