package android.taobao.windvane.packageapp.zipapp.utils;

import com.taobao.zcache.ResourceResponse;
import com.taobao.zcache.model.ZCacheResourceResponse;
import java.io.ByteArrayInputStream;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ZCacheResourceWrapper {
    public ZCacheResourceResponse zCacheResourceResponse = null;

    public ZCacheResourceResponse wrapZCacheResourceResponse(ResourceResponse resourceResponse) {
        ZCacheResourceResponse zCacheResourceResponse = new ZCacheResourceResponse();
        this.zCacheResourceResponse = zCacheResourceResponse;
        if (resourceResponse == null) {
            zCacheResourceResponse.isSuccess = false;
            zCacheResourceResponse.status = 0;
            zCacheResourceResponse.zcacheInfo = ZCacheResourceResponse.ZCACHE_NO_RESPONSE;
        } else {
            zCacheResourceResponse.headers = resourceResponse.getHeader();
            Map<String, String> map = this.zCacheResourceResponse.headers;
            if (map != null && map.containsKey("X-ZCache-Info")) {
                ZCacheResourceResponse zCacheResourceResponse2 = this.zCacheResourceResponse;
                zCacheResourceResponse2.zcacheInfo = zCacheResourceResponse2.headers.get("X-ZCache-Info");
            } else {
                this.zCacheResourceResponse.zcacheInfo = ZCacheResourceResponse.ZCACHE_NO_HEADER;
            }
            if (resourceResponse.getError() == null && resourceResponse.getData() != null) {
                this.zCacheResourceResponse.inputStream = new ByteArrayInputStream(resourceResponse.getData());
                ZCacheResourceResponse zCacheResourceResponse3 = this.zCacheResourceResponse;
                zCacheResourceResponse3.isSuccess = true;
                zCacheResourceResponse3.status = 2;
            } else {
                ZCacheResourceResponse zCacheResourceResponse4 = this.zCacheResourceResponse;
                zCacheResourceResponse4.isSuccess = false;
                zCacheResourceResponse4.status = 1;
            }
        }
        return this.zCacheResourceResponse;
    }
}
