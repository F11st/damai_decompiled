package mtopsdk.mtop.stat;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IMtopMonitor {
    public static final String DATA_REQUEST = "key_data_request";
    public static final String DATA_RESPONSE = "key_data_response";
    public static final String DATA_SEQ = "key_data_seq";

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface MtopMonitorType {
        public static final String TYPE_CALLBACK = "TYPE_CALLBACK";
        public static final String TYPE_ERROR_CALLBACK = "TYPE_ERROR_CALLBACK";
        public static final String TYPE_ERROR_REQUEST = "TYPE_ERROR_REQUEST";
        public static final String TYPE_ERROR_RESPONSE = "TYPE_ERROR_RESPONSE";
        public static final String TYPE_REQUEST = "TYPE_REQUEST";
        public static final String TYPE_RESPONSE = "TYPE_RESPONSE";

        /* compiled from: Taobao */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes11.dex */
        public @interface Definition {
        }
    }

    void onCommit(String str, HashMap<String, String> hashMap);
}
