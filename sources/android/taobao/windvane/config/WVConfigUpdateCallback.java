package android.taobao.windvane.config;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface WVConfigUpdateCallback {

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum CONFIG_UPDATE_STATUS {
        SUCCESS,
        UPDATE_DISABLED,
        UPDATE_CANCELED,
        NULL_DATA,
        ENCODING_ERROR,
        NOT_AVAIABLE,
        NO_VERSION,
        UNKNOWN_ERROR,
        UPDATE_COUNT_LIMIT,
        NETWORK_NOT_SUPPORT
    }

    void updateError(String str, String str2);

    void updateStatus(CONFIG_UPDATE_STATUS config_update_status, int i);
}
