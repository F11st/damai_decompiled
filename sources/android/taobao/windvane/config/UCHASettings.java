package android.taobao.windvane.config;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class UCHASettings {
    public String appSecret;
    public String appid;
    public int configUpdateMode;
    public boolean debug;
    public int logUploadMode;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class ConfigRate {
        public boolean u4CollectUrlQuery = true;
        public boolean u4CollectUrlRef = true;
        public int u4BkpgSamplingRate = 100;
        public int u4T1t3detailSamplingRate = 30;
        public int u4ResloadfailSamplingRate = 10;
        public int u4XhrSamplingRate = 1;
        public int u4JserrSamplingRate = 100;
        public double u4HarSamplingRate = 0.01d;
        public int u4InteractionJsErrorSamplingRate = 100;
        public int u4WebglErrorStateApiSamplingRate = 100;
        public float u4MapsGroupsSamplingRate = 1.0f;
        public int u4MapsGroupsTpuploadDefine = 20;
        public int u4MapsGroupsMaxScriptMemory = 100;
        public int u4MapsGroupsMaxGlMemory = 100;
        public int u4UcLargeAllocSize = 50;
    }

    public UCHASettings() {
        this.appid = "";
        this.appSecret = "";
        this.debug = false;
        this.logUploadMode = 0;
        this.configUpdateMode = 0;
    }

    public UCHASettings(String str, String str2) {
        this.appid = "";
        this.appSecret = "";
        this.debug = false;
        this.logUploadMode = 0;
        this.configUpdateMode = 0;
        this.appid = str;
        this.appSecret = str2;
    }
}
