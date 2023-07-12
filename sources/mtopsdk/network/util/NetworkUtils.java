package mtopsdk.network.util;

import anet.channel.request.a;
import java.io.Closeable;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.network.util.Constants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class NetworkUtils {
    private NetworkUtils() {
    }

    public static boolean checkContentEncodingGZip(Map<String, List<String>> map) {
        try {
            return "gzip".equalsIgnoreCase(HeaderHandlerUtil.getSingleHeaderFieldByKey(map, Constants.Protocol.CONTENT_ENCODING));
        } catch (Exception unused) {
            return false;
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean requiresRequestBody(String str) {
        return str.equals("POST") || str.equals(a.c.PUT) || str.equals("PATCH");
    }
}
