package android.taobao.windvane.packageapp.zipapp.data;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public enum ZipAppTypeEnum {
    ZIP_APP_TYPE_PACKAGEAPP(0),
    ZIP_APP_TYPE_ZCACHE(16),
    ZIP_APP_TYPE_REACT(32),
    ZIP_APP_TYPE_ZCACHE2(48),
    ZIP_APP_TYPE_MINI_APP(64),
    ZIP_APP_TYPE_UNKNOWN(240);
    
    private long value;

    ZipAppTypeEnum(long j) {
        this.value = j;
    }

    public long getValue() {
        return this.value;
    }

    public void setValue(long j) {
        this.value = j;
    }
}
