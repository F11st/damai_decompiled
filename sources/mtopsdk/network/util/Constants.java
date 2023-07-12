package mtopsdk.network.util;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface Constants {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface Error {
        public static final int CONNECT_EXCEPTION = -6;
        public static final int CONNECT_TIMEOUT_EXCEPTION = -3;
        public static final int NETWORK_EXCEPTION = -7;
        public static final int REQUEST_CANCEL = -8;
        public static final int SOCKET_TIMEOUT_EXCEPTION = -2;
        public static final int SSL_EXCEPTION_EXCEPTION = -5;
        public static final int SSL_HANDSHAKE_EXCEPTION = -4;
        public static final int UNKNOWN_HOST_EXCEPTION = -1;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface Protocol {
        public static final String CONTENT_ENCODING = "Content-Encoding";
        public static final String CONTENT_LENGTH = "Content-Length";
        public static final String CONTENT_TYPE = "Content-Type";
        public static final String GZIP = "gzip";
        public static final String POST = "POST";
    }
}
