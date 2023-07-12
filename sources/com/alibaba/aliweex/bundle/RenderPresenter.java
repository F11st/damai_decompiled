package com.alibaba.aliweex.bundle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.alibaba.aliweex.AliWXSDKEngine;
import com.alibaba.aliweex.IConfigAdapter;
import com.alibaba.aliweex.bundle.WeexPageContract;
import com.alibaba.aliweex.bundle.f;
import com.alibaba.aliweex.utils.MemoryMonitor;
import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.RenderContainer;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.render.WXAbstractRenderContainer;
import com.taobao.weex.ui.component.NestedContainer;
import com.taobao.weex.utils.WXLogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import tb.ev2;
import tb.sz2;
import tb.uz2;
import tb.xz2;
import tb.zz2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class RenderPresenter implements WeexPageContract.IRenderPresenter {
    private static String r = "weex_sandbox";
    private Activity a;
    private WXSDKInstance b;
    private String c;
    private Map<String, Object> d;
    private String e;
    private String f;
    private String g;
    private String h;
    protected String i;
    protected f j;
    private WeexPageContract.IUTPresenter k;
    private WeexPageContract.IDynamicUrlPresenter l;
    private WeexPageContract.IProgressBar m;
    private IWXRenderListener n;
    private WeexPageContract.IUrlValidate o;
    protected sz2 p;
    private WXAbstractRenderContainer q = null;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class a implements MemoryMonitor.MemoryListener {
        a() {
        }

        @Override // com.alibaba.aliweex.utils.MemoryMonitor.MemoryListener
        public void onChange(String str) {
            ArrayList<f.b> c;
            WXSDKInstance c2;
            HashMap hashMap = new HashMap(1);
            hashMap.put("evaluatedStatus", str);
            RenderPresenter renderPresenter = RenderPresenter.this;
            renderPresenter.e(renderPresenter.b, "memoryevaluated", hashMap);
            f fVar = RenderPresenter.this.j;
            if (fVar == null || (c = fVar.c()) == null || c.size() == 0) {
                return;
            }
            Iterator<f.b> it = c.iterator();
            while (it.hasNext()) {
                f.a aVar = it.next().b;
                if (aVar != null && (c2 = aVar.c()) != null) {
                    RenderPresenter.this.e(c2, "memoryevaluated", hashMap);
                }
            }
        }
    }

    public RenderPresenter(Activity activity, String str, IWXRenderListener iWXRenderListener, WeexPageContract.IUTPresenter iUTPresenter, WeexPageContract.IDynamicUrlPresenter iDynamicUrlPresenter, WeexPageContract.IProgressBar iProgressBar, sz2 sz2Var, WeexPageContract.IUrlValidate iUrlValidate) {
        this.a = activity;
        this.i = str;
        this.n = iWXRenderListener;
        this.k = iUTPresenter;
        this.l = iDynamicUrlPresenter;
        this.m = iProgressBar;
        this.o = iUrlValidate;
        this.j = new f(activity, iUrlValidate.getHandler());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(WXSDKInstance wXSDKInstance, String str, Map<String, Object> map) {
        if (wXSDKInstance == null || wXSDKInstance.getRootComponent() == null) {
            return;
        }
        wXSDKInstance.fireEvent(wXSDKInstance.getRootComponent().getRef(), str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final WXSDKInstance wXSDKInstance, final String str, final Map<String, Object> map) {
        if (wXSDKInstance != null) {
            wXSDKInstance.runOnUiThread(new Runnable() { // from class: com.alibaba.aliweex.bundle.RenderPresenter.1
                @Override // java.lang.Runnable
                public void run() {
                    RenderPresenter.this.d(wXSDKInstance, str, map);
                }
            });
        }
    }

    private int f(ViewGroup viewGroup) {
        int f;
        if (viewGroup == null) {
            return -1;
        }
        if (viewGroup.getChildCount() == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt != null && (childAt instanceof ViewGroup) && (f = f((ViewGroup) childAt)) > i) {
                i = f;
            }
        }
        return i + 1;
    }

    @NonNull
    private WXRenderStrategy g(Map<String, Object> map) {
        WXRenderStrategy wXRenderStrategy = WXRenderStrategy.APPEND_ASYNC;
        if (map != null) {
            try {
                return map.containsKey(WeexPageFragment.WX_RENDER_STRATEGY) ? WXRenderStrategy.valueOf(map.get(WeexPageFragment.WX_RENDER_STRATEGY).toString()) : wXRenderStrategy;
            } catch (Exception e) {
                WXLogUtils.e("RenderPresenter", WXLogUtils.getStackTrace(e));
                return wXRenderStrategy;
            }
        }
        return wXRenderStrategy;
    }

    private void h(Context context) {
        if (this.b == null) {
            AliWXSDKEngine.n();
            WXSDKInstance createWXSDKInstance = createWXSDKInstance(context);
            this.b = createWXSDKInstance;
            AliWXSDKEngine.m(createWXSDKInstance.getInstanceId());
            if (com.alibaba.aliweex.a.l().c() != null) {
                if ("false".equals(com.alibaba.aliweex.a.l().c().getConfig(r, "enableSanbox", "true"))) {
                    this.b.setUseSandBox(false);
                } else {
                    this.b.setUseSandBox(true);
                }
            }
            WeexPageContract.IUTPresenter iUTPresenter = this.k;
            if (iUTPresenter != null) {
                iUTPresenter.viewAutoExposure(this.b);
            }
            this.b.registerRenderListener(this.n);
            f fVar = this.j;
            if (fVar != null) {
                this.b.setNestedInstanceInterceptor(fVar);
            }
            this.b.onInstanceReady();
        }
    }

    private synchronized boolean i() {
        IConfigAdapter c = com.alibaba.aliweex.a.l().c();
        if (c != null) {
            return Boolean.parseBoolean(c.getConfig("wx_namespace_ext_config", "get_deep_view_layer", Boolean.toString(true)));
        }
        return false;
    }

    private void j(Map<String, Object> map, String str, WXRenderStrategy wXRenderStrategy) {
        String renderUrl = getRenderUrl();
        String str2 = (ev2.d(renderUrl) || WXEnvironment.isApkDebugable()) ? renderUrl : zz2.ERROR_RENDER_URL;
        if (this.b.isPreDownLoad()) {
            return;
        }
        this.b.renderByUrl(str2, str2, map, str, wXRenderStrategy);
        try {
            xz2.d(this.b, renderUrl);
        } catch (Throwable unused) {
        }
    }

    private void k(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = false;
        if (!TextUtils.equals(this.c, str)) {
            if (TextUtils.isEmpty(this.c)) {
                this.c = str;
            }
            if (this.a != null && z) {
                this.c = Uri.parse(str).buildUpon().appendQueryParameter("activity", this.a.getClass().getName()).build().toString();
            }
            AliWXSDKEngine.l(this.c);
        }
        z = true;
        if (this.a != null) {
            this.c = Uri.parse(str).buildUpon().appendQueryParameter("activity", this.a.getClass().getName()).build().toString();
        }
        AliWXSDKEngine.l(this.c);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.taobao.weex.WXSDKInstance createWXSDKInstance(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = r3.getRenderUrl()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "RenderPresenter"
            if (r1 != 0) goto L25
            tb.tz2 r1 = tb.tz2.a()
            com.taobao.weex.WXSDKInstance r0 = r1.b(r0, r4)
            boolean r1 = r0 instanceof com.alibaba.aliweex.AliWXSDKInstance
            if (r1 == 0) goto L25
            com.alibaba.aliweex.AliWXSDKInstance r0 = (com.alibaba.aliweex.AliWXSDKInstance) r0
            java.lang.String r1 = r3.i
            r0.c(r1)
            java.lang.String r1 = "preinit -> use preinitInstance "
            android.util.Log.e(r2, r1)
            goto L26
        L25:
            r0 = 0
        L26:
            if (r0 != 0) goto L34
            java.lang.String r0 = "preinit -> failed ,and  new AliWXSDKInstance "
            android.util.Log.e(r2, r0)
            com.alibaba.aliweex.AliWXSDKInstance r0 = new com.alibaba.aliweex.AliWXSDKInstance
            java.lang.String r1 = r3.i
            r0.<init>(r4, r1)
        L34:
            tb.sz2 r4 = r3.p
            r0.d(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.aliweex.bundle.RenderPresenter.createWXSDKInstance(android.content.Context):com.taobao.weex.WXSDKInstance");
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void destroySDKInstance() {
        WXSDKInstance wXSDKInstance = this.b;
        if (wXSDKInstance != null) {
            MemoryMonitor.e(wXSDKInstance.getInstanceId());
            this.b.destroy();
            this.b = null;
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void fireEvent(String str, Map<String, Object> map) {
        d(this.b, str, map);
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public NestedContainer getNestedContainer(WXSDKInstance wXSDKInstance) {
        f fVar = this.j;
        if (fVar == null || wXSDKInstance == null) {
            return null;
        }
        return fVar.b(wXSDKInstance);
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public String getOriginalRenderUrl() {
        WeexPageContract.IDynamicUrlPresenter iDynamicUrlPresenter = this.l;
        return iDynamicUrlPresenter != null ? iDynamicUrlPresenter.getOriginalRenderUrl() : this.h;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public String getOriginalUrl() {
        WeexPageContract.IDynamicUrlPresenter iDynamicUrlPresenter = this.l;
        return iDynamicUrlPresenter != null ? iDynamicUrlPresenter.getOriginalUrl() : this.g;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public String getRenderUrl() {
        WeexPageContract.IDynamicUrlPresenter iDynamicUrlPresenter = this.l;
        return iDynamicUrlPresenter != null ? iDynamicUrlPresenter.getRenderUrl() : this.h;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public String getUrl() {
        WeexPageContract.IDynamicUrlPresenter iDynamicUrlPresenter = this.l;
        return iDynamicUrlPresenter != null ? iDynamicUrlPresenter.getUrl() : this.g;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public WXSDKInstance getWXSDKInstance() {
        if (this.b == null) {
            h(this.a);
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(WXAbstractRenderContainer wXAbstractRenderContainer, boolean z) {
        this.q = wXAbstractRenderContainer;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void onActivityCreate(ViewGroup viewGroup, Map<String, Object> map, String str, String str2, String str3, String str4, String str5) {
        if (this.q == null) {
            this.q = new RenderContainer(this.a);
        }
        viewGroup.addView(this.q);
        h(this.a);
        this.q.createInstanceRenderView(this.b.getInstanceId());
        this.b.setWXAbstractRenderContainer(this.q);
        if (!TextUtils.isEmpty(str2)) {
            startRenderByTemplate(str2, str3, map, str);
        } else if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            startRenderByUrl(map, str, str3, str4);
        } else if (!TextUtils.isEmpty(str5)) {
            startRenderByUrl(map, str, str5, str5);
        }
        this.b.onActivityCreate();
        MemoryMonitor.a(this.b.getInstanceId(), new a());
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void onActivityDestroy() {
        if (this.b != null) {
            WXSDKInstance wXSDKInstance = getWXSDKInstance();
            if (wXSDKInstance != null) {
                MemoryMonitor.e(wXSDKInstance.getInstanceId());
            }
            this.b.onActivityDestroy();
        }
        f fVar = this.j;
        if (fVar != null) {
            fVar.a();
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void onActivityPause() {
        WXSDKInstance wXSDKInstance = this.b;
        if (wXSDKInstance != null) {
            if (wXSDKInstance.getContainerView() != null && i()) {
                this.b.setMaxDeepLayer(f((ViewGroup) this.b.getContainerView()));
            }
            this.b.onActivityPause();
        }
        AliWXSDKEngine.l("");
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void onActivityResult(int i, int i2, Intent intent) {
        WXSDKInstance wXSDKInstance = this.b;
        if (wXSDKInstance != null) {
            wXSDKInstance.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void onActivityResume() {
        WXSDKInstance wXSDKInstance = this.b;
        if (wXSDKInstance != null) {
            wXSDKInstance.onActivityResume();
        }
        k(getUrl());
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void onActivityStart() {
        WXSDKInstance wXSDKInstance = this.b;
        if (wXSDKInstance != null) {
            wXSDKInstance.onActivityStart();
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void onActivityStop() {
        WXSDKInstance wXSDKInstance = this.b;
        if (wXSDKInstance != null) {
            wXSDKInstance.onActivityStop();
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public boolean onBackPressed() {
        WXSDKInstance wXSDKInstance = this.b;
        if (wXSDKInstance != null) {
            return wXSDKInstance.onBackPressed();
        }
        return false;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void onCreateOptionsMenu(Menu menu) {
        WXSDKInstance wXSDKInstance = this.b;
        if (wXSDKInstance != null) {
            wXSDKInstance.onCreateOptionsMenu(menu);
        }
        ArrayList<f.b> c = this.j.c();
        if (c != null) {
            Iterator<f.b> it = c.iterator();
            while (it.hasNext()) {
                f.b next = it.next();
                if (next.b.c() != null) {
                    next.b.c().onCreateOptionsMenu(menu);
                }
            }
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public boolean onSupportNavigateUp() {
        WXSDKInstance wXSDKInstance = this.b;
        if (wXSDKInstance != null) {
            return wXSDKInstance.onSupportNavigateUp();
        }
        return false;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void reload() {
        WeexPageContract.IUTPresenter iUTPresenter = this.k;
        if (iUTPresenter != null) {
            iUTPresenter.refreshUT(getUrl());
        }
        if (!TextUtils.isEmpty(getOriginalUrl()) && !TextUtils.isEmpty(getOriginalRenderUrl())) {
            destroySDKInstance();
            startRenderByUrl(this.d, this.e, getOriginalUrl(), getOriginalRenderUrl());
        } else if (TextUtils.isEmpty(this.f)) {
        } else {
            destroySDKInstance();
            startRenderByTemplate(this.f, this.g, this.d, this.e);
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void replace(String str, String str2) {
        destroySDKInstance();
        transformUrl(str, str2);
        WeexPageContract.IUTPresenter iUTPresenter = this.k;
        if (iUTPresenter != null) {
            iUTPresenter.refreshUT(getUrl());
        }
        startRenderByUrl(this.d, this.e, str, str2);
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void startRenderByTemplate(String str, String str2, Map<String, Object> map, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.m.showProgressBar(true);
        h(this.a);
        this.d = map;
        this.e = str3;
        this.f = str;
        this.g = str2;
        WXSDKInstance wXSDKInstance = this.b;
        if (TextUtils.isEmpty(str2)) {
            str2 = "AliWeex";
        }
        wXSDKInstance.render(str2, str, map, str3, g(this.d));
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void startRenderByUrl(Map<String, Object> map, String str, String str2, String str3) {
        Log.w("test ->", "startRenderByUrl in renderListener");
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        WeexPageContract.IUrlValidate iUrlValidate = this.o;
        if (iUrlValidate != null) {
            iUrlValidate.checkUrlValidate(str3);
        }
        this.m.showProgressBar(!Uri.parse(str3).getBooleanQueryParameter("wx_mute_loading_indicator", false));
        h(this.a);
        transformUrl(str2, str3);
        k(getUrl());
        if (!this.b.isPreInitMode() && !this.b.isPreDownLoad()) {
            str2 = uz2.o(this.b, getOriginalUrl());
        }
        this.d = map;
        this.e = str;
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            str3 = str2;
        }
        hashMap.put("bundleUrl", str3);
        if (map != null) {
            for (String str4 : map.keySet()) {
                hashMap.put(str4, map.get(str4));
            }
        }
        WeexPageContract.IUTPresenter iUTPresenter = this.k;
        if (iUTPresenter != null) {
            iUTPresenter.updatePageName(getUrl());
        }
        j(hashMap, str, g(this.d));
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IRenderPresenter
    public void transformUrl(String str, String str2) {
        WeexPageContract.IDynamicUrlPresenter iDynamicUrlPresenter = this.l;
        if (iDynamicUrlPresenter != null) {
            iDynamicUrlPresenter.transformUrl(str, str2);
            return;
        }
        this.g = str;
        this.h = str2;
    }
}
