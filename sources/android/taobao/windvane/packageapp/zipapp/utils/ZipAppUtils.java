package android.taobao.windvane.packageapp.zipapp.utils;

import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVUrlUtil;
import com.taobao.zcache.ZCacheInitTask;
import com.taobao.zcache.ZCacheManager;
import com.taobao.zcache.model.ZCacheResourceResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ZipAppUtils {
    public static InputStream getInputStreamByUrl(String str) {
        String force2HttpUrl = WVUrlUtil.force2HttpUrl(WVUrlUtil.removeQueryParam(str));
        ZCacheInitTask.getInstance().init();
        ZCacheResourceResponse zCacheResource = ZCacheManager.instance().getZCacheResource(force2HttpUrl);
        StringBuilder sb = new StringBuilder();
        sb.append("getInputStreamByUrl，url=[");
        sb.append(force2HttpUrl);
        sb.append("], with response=[");
        sb.append(zCacheResource != null && zCacheResource.isSuccess);
        sb.append(jn1.ARRAY_END_STR);
        TaoLog.i("ZCache", sb.toString());
        if (zCacheResource == null || !zCacheResource.isSuccess) {
            return null;
        }
        return zCacheResource.inputStream;
    }

    @Deprecated
    public static String getLocPathByUrl(String str, boolean z) {
        return "";
    }

    @Deprecated
    public static String getStreamByUrl(String str) {
        InputStream inputStreamByUrl = getInputStreamByUrl(str);
        if (inputStreamByUrl == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStreamByUrl.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    return byteArrayOutputStream.toString("UTF-8");
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    @Deprecated
    public static String getStreamByUrl(String str, String str2) {
        return null;
    }
}
