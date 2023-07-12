package com.taobao.android.dinamicx.template;

import android.text.TextUtils;
import android.util.LruCache;
import com.alibaba.fastjson.JSON;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.template.download.DXTemplatePackageInfo;
import com.taobao.weex.annotation.JSMethod;
import java.util.Map;
import tb.dz;
import tb.nz;
import tb.ry;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXJSCacheManager {
    LruCache<String, byte[]> a = new LruCache<>(500);

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class DXLoadJSBytesTask implements Runnable {
        DXTemplateItem childTemplateInfo;
        boolean isMainTemplate;
        byte[] jsBytes;
        DXRuntimeContext runtimeContext;

        public DXLoadJSBytesTask(DXRuntimeContext dXRuntimeContext, boolean z) {
            this.runtimeContext = dXRuntimeContext;
            this.isMainTemplate = z;
        }

        public byte[] getJsBytes() {
            return this.jsBytes;
        }

        @Override // java.lang.Runnable
        public void run() {
            Map<String, String> map;
            String str;
            try {
                DXTemplateItem dxTemplateItem = this.runtimeContext.getDxTemplateItem();
                nz.a("isMainTemplate:" + this.isMainTemplate + ":" + JSON.toJSONString(dxTemplateItem) + " pack " + JSON.toJSONString(dxTemplateItem.packageInfo));
                DXTemplatePackageInfo dXTemplatePackageInfo = dxTemplateItem.packageInfo;
                if (dXTemplatePackageInfo != null && (map = dXTemplatePackageInfo.subFilePathDict) != null) {
                    if (this.isMainTemplate) {
                        str = map.get("index.dx");
                    } else {
                        str = map.get(dxTemplateItem.name + JSMethod.NOT_SET + dxTemplateItem.version + JSMethod.NOT_SET + "index.dx");
                    }
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    nz.a(str);
                    byte[] e = dz.c().e(str, this.runtimeContext);
                    this.jsBytes = e;
                    if (e != null) {
                        nz.a("isMainTemplate:" + this.isMainTemplate + ": 设置对应模版的js信息" + str);
                        DXJSCacheManager.c().d(this.childTemplateInfo, this.jsBytes);
                    }
                }
            } catch (Throwable th) {
                ry.b(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class a {
        private static final DXJSCacheManager a = new DXJSCacheManager();
    }

    private String a(DXTemplateItem dXTemplateItem) {
        if (dXTemplateItem == null) {
            return null;
        }
        return dXTemplateItem.getIdentifier();
    }

    public static DXJSCacheManager c() {
        return a.a;
    }

    public byte[] b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c().a.get(str);
    }

    public void d(DXTemplateItem dXTemplateItem, byte[] bArr) {
        e(a(dXTemplateItem), bArr);
    }

    public void e(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str) || bArr == null) {
            return;
        }
        c().a.put(str, bArr);
    }
}
