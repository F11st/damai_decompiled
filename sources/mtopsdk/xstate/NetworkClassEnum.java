package mtopsdk.xstate;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public enum NetworkClassEnum {
    NET_WIFI("WIFI"),
    NET_2G("2G"),
    NET_3G("3G"),
    NET_4G("4G"),
    NET_UNKONWN("UNKONWN"),
    NET_NO("NET_NO"),
    NET_ETHERNET("NET_ETHERNET");
    
    private String netClass;

    NetworkClassEnum(String str) {
        this.netClass = str;
    }

    public String getNetClass() {
        return this.netClass;
    }
}
