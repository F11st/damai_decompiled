package mtopsdk.mtop.domain;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public enum EntranceEnum {
    GW_INNER("gw"),
    GW_OPEN("gw-open");
    
    private String entrance;

    EntranceEnum(String str) {
        this.entrance = str;
    }

    public String getEntrance() {
        return this.entrance;
    }
}
