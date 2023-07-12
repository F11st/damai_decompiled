package com.taobao.zcache.api;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.taobao.zcache.core.IZCacheCore;
import com.taobao.zcache.core.ZCacheCoreProxy;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ZCacheAPI extends WVApiPlugin {
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (TextUtils.equals(str, "prefetch")) {
            IZCacheCore core = ZCacheCoreProxy.core();
            WVResult wVResult = new WVResult();
            if (core == null) {
                wVCallBackContext.error(wVResult);
                return true;
            }
            ArrayList arrayList = new ArrayList();
            try {
                Iterator<String> keys = new JSONObject(str2).keys();
                while (keys.hasNext()) {
                    arrayList.add(keys.next());
                }
            } catch (JSONException unused) {
            }
            core.prefetch(arrayList);
            wVCallBackContext.success(wVResult);
            return true;
        }
        return false;
    }
}
