package android.taobao.windvane.connect;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface WebListener {
    public static final int TOKEN_CHECK_UPDATE = 6;
    public static final int TOKEN_DO_UPDATE = 7;
    public static final int TOKEON_WAP_MODULE = 4;
    public static final int TOKEON_WAP_MODULE_SILENT = 5;

    void callback(byte[] bArr, Map<String, String> map, int i);
}
