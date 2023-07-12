package android.taobao.windvane.packageapp.zipapp.data;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public enum ZipUpdateTypeEnum {
    ZIP_UPDATE_TYPE_PASSIVE(0),
    ZIP_APP_TYPE_FORCE(256),
    ZIP_APP_TYPE_ONLINE(512);
    
    private long value;

    ZipUpdateTypeEnum(long j) {
        this.value = j;
    }

    public long getValue() {
        return this.value;
    }

    public void setValue(long j) {
        this.value = j;
    }
}
