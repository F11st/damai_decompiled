package mtopsdk.common.util;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LocalConfig {
    private static final String TAG = "mtopsdk.LocalConfig";
    private static LocalConfig instance;
    public boolean enableErrorCodeMapping = true;
    public boolean enableBizErrorCodeMapping = true;
    public boolean enableSpdy = true;
    @Deprecated
    public boolean enableUnit = true;
    public boolean enableSsl = true;
    public boolean enableProperty = true;
    @Deprecated
    public boolean enableRemoteNetworkService = true;

    public static LocalConfig getInstance() {
        if (instance == null) {
            synchronized (LocalConfig.class) {
                if (instance == null) {
                    instance = new LocalConfig();
                }
            }
        }
        return instance;
    }
}
