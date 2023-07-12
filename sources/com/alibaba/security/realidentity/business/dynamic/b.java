package com.alibaba.security.realidentity.business.dynamic;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.common.d.h;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.a.i;
import com.alibaba.security.realidentity.business.dynamic.model.BcConfig;
import com.alibaba.security.realidentity.business.dynamic.model.DynamicResponse;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;
import com.alibaba.security.realidentity.http.base.BusinessRequest;
import com.alibaba.security.realidentity.http.base.RetrofitHttpCallback;
import com.alibaba.security.realidentity.http.model.HttpRequest;
import com.alibaba.security.realidentity.http.model.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class b extends a<DynamicResponse> {
    public static final String f = "1";
    private long i;
    private Object j;
    private DynamicHttpRequest k;
    private static final String h = b.class.getSimpleName();
    public static final String[] g = {com.alibaba.security.realidentity.a.a.U, com.alibaba.security.realidentity.a.a.V, com.alibaba.security.realidentity.a.a.W, com.alibaba.security.realidentity.a.a.X, com.alibaba.security.realidentity.a.a.T};

    public b(Context context, String str, RPEventListener rPEventListener, Runnable runnable, com.alibaba.security.realidentity.d.b bVar) {
        super(context, str, rPEventListener, runnable, bVar);
    }

    private DynamicResponse b(Object obj) {
        String h5_domain;
        byte[] a;
        String str = null;
        if (!(obj instanceof DynamicHttpResponse)) {
            a("response is error", obj, null);
            return null;
        }
        String result = ((DynamicHttpResponse) obj).getResult();
        if (result == null) {
            a("result is null", obj, null);
            return null;
        }
        if (!TextUtils.isEmpty(result) && (a = com.alibaba.security.common.d.a.a(result)) != null) {
            String dp = ALBiometricsJni.dp(a);
            if (!TextUtils.isEmpty(dp)) {
                str = dp;
            }
        }
        String str2 = h;
        com.alibaba.security.common.c.a.a(str2, str);
        DynamicResponse dynamicResponse = (DynamicResponse) h.a(str, DynamicResponse.class, true);
        if (dynamicResponse != null && (h5_domain = dynamicResponse.getH5_DOMAIN()) != null) {
            g.a.a.f = h5_domain;
            com.alibaba.security.common.c.a.a(str2, "h5_domain:".concat(h5_domain));
        }
        a("success", obj, dynamicResponse);
        return dynamicResponse;
    }

    private void c(DynamicResponse dynamicResponse) {
        if (dynamicResponse == null) {
            com.alibaba.security.common.c.a.e(h, "Null response data found on result");
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        g.a.a.n = dynamicResponse.getSC();
        g.a.a.p = dynamicResponse.getCTID();
        Runnable runnable2 = this.d;
        if (runnable2 != null) {
            runnable2.run();
        }
        BcConfig bc = dynamicResponse.getBC();
        if (bc != null && !TextUtils.isEmpty(bc.getBcContent())) {
            if (this.e == null) {
                com.alibaba.security.common.c.a.e(h, "Cannot find SecurityGuardManager instance");
                return;
            }
            String rpsdkUseLiteVM = dynamicResponse.getBASIC().getRpsdkUseLiteVM();
            boolean z = false;
            boolean z2 = TextUtils.isEmpty(rpsdkUseLiteVM) || rpsdkUseLiteVM.equals("1");
            GetCacheDataManager.getInstance().setUseLiteVm(z2);
            com.alibaba.security.realidentity.d.b bVar = this.e;
            bVar.g = bc;
            bVar.h = z2;
            String rpsdkUseHwMagicWindow = dynamicResponse.getBASIC().getRpsdkUseHwMagicWindow();
            GetCacheDataManager.getInstance().setUseHwMagicWindow(TextUtils.isEmpty(rpsdkUseHwMagicWindow) || rpsdkUseHwMagicWindow.equals("1"));
            String rpArupTimeOut = dynamicResponse.getBASIC().getRpArupTimeOut();
            if (!TextUtils.isEmpty(rpArupTimeOut)) {
                GetCacheDataManager.getInstance().setUploadTimeOut(rpArupTimeOut);
            }
            String rpsdkCollectLocalImage = dynamicResponse.getBASIC().getRpsdkCollectLocalImage();
            GetCacheDataManager.getInstance().setNeedCollectLocalImage((rpsdkCollectLocalImage == null || "1".equals(rpsdkCollectLocalImage)) ? true : true);
            return;
        }
        com.alibaba.security.common.c.a.e(h, "Cannot process data with null BC");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.security.realidentity.business.dynamic.a, android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((DynamicResponse) obj);
    }

    @Override // com.alibaba.security.realidentity.business.dynamic.a
    public final /* synthetic */ void a(DynamicResponse dynamicResponse) {
        DynamicResponse dynamicResponse2 = dynamicResponse;
        if (dynamicResponse2 == null) {
            com.alibaba.security.common.c.a.e(h, "Null response data found on result");
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        g.a.a.n = dynamicResponse2.getSC();
        g.a.a.p = dynamicResponse2.getCTID();
        Runnable runnable2 = this.d;
        if (runnable2 != null) {
            runnable2.run();
        }
        BcConfig bc = dynamicResponse2.getBC();
        if (bc != null && !TextUtils.isEmpty(bc.getBcContent())) {
            if (this.e == null) {
                com.alibaba.security.common.c.a.e(h, "Cannot find SecurityGuardManager instance");
                return;
            }
            String rpsdkUseLiteVM = dynamicResponse2.getBASIC().getRpsdkUseLiteVM();
            boolean z = false;
            boolean z2 = TextUtils.isEmpty(rpsdkUseLiteVM) || rpsdkUseLiteVM.equals("1");
            GetCacheDataManager.getInstance().setUseLiteVm(z2);
            com.alibaba.security.realidentity.d.b bVar = this.e;
            bVar.g = bc;
            bVar.h = z2;
            String rpsdkUseHwMagicWindow = dynamicResponse2.getBASIC().getRpsdkUseHwMagicWindow();
            GetCacheDataManager.getInstance().setUseHwMagicWindow(TextUtils.isEmpty(rpsdkUseHwMagicWindow) || rpsdkUseHwMagicWindow.equals("1"));
            String rpArupTimeOut = dynamicResponse2.getBASIC().getRpArupTimeOut();
            if (!TextUtils.isEmpty(rpArupTimeOut)) {
                GetCacheDataManager.getInstance().setUploadTimeOut(rpArupTimeOut);
            }
            String rpsdkCollectLocalImage = dynamicResponse2.getBASIC().getRpsdkCollectLocalImage();
            GetCacheDataManager.getInstance().setNeedCollectLocalImage((rpsdkCollectLocalImage == null || "1".equals(rpsdkCollectLocalImage)) ? true : true);
            return;
        }
        com.alibaba.security.common.c.a.e(h, "Cannot process data with null BC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.alibaba.security.realidentity.business.dynamic.a, android.os.AsyncTask
    /* renamed from: b */
    public DynamicResponse doInBackground(String... strArr) {
        String h5_domain;
        byte[] a;
        this.i = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        if (strArr != null && strArr.length > 0) {
            arrayList.addAll(Arrays.asList(strArr));
        }
        DynamicHttpRequest dynamicHttpRequest = new DynamicHttpRequest(this.b);
        dynamicHttpRequest.setKeys(h.a(arrayList));
        this.k = dynamicHttpRequest;
        g.a.a.a(TrackLog.createDynamicBegin("", h.a(dynamicHttpRequest), ""));
        Object a2 = a(this.k);
        String str = null;
        if (!(a2 instanceof DynamicHttpResponse)) {
            a("response is error", a2, null);
            return null;
        }
        String result = ((DynamicHttpResponse) a2).getResult();
        if (result == null) {
            a("result is null", a2, null);
            return null;
        }
        if (!TextUtils.isEmpty(result) && (a = com.alibaba.security.common.d.a.a(result)) != null) {
            String dp = ALBiometricsJni.dp(a);
            if (!TextUtils.isEmpty(dp)) {
                str = dp;
            }
        }
        String str2 = h;
        com.alibaba.security.common.c.a.a(str2, str);
        DynamicResponse dynamicResponse = (DynamicResponse) h.a(str, DynamicResponse.class, true);
        if (dynamicResponse != null && (h5_domain = dynamicResponse.getH5_DOMAIN()) != null) {
            g.a.a.f = h5_domain;
            com.alibaba.security.common.c.a.a(str2, "h5_domain:".concat(h5_domain));
        }
        a("success", a2, dynamicResponse);
        return dynamicResponse;
    }

    private DynamicHttpRequest a(List<String> list) {
        DynamicHttpRequest dynamicHttpRequest = new DynamicHttpRequest(this.b);
        dynamicHttpRequest.setKeys(h.a(list));
        return dynamicHttpRequest;
    }

    private Object a(DynamicHttpRequest dynamicHttpRequest) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            i.a.a.e().dynamic(new BusinessHttpWrapper(DynamicHttpResponse.class, new BusinessRequest(DynamicHttpRequest.class, dynamicHttpRequest)), new RetrofitHttpCallback() { // from class: com.alibaba.security.realidentity.business.dynamic.b.1
                @Override // com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
                public final void onFailure(HttpResponse httpResponse) {
                    b.this.j = httpResponse;
                    countDownLatch.countDown();
                }

                @Override // com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
                public final void onNetError(Exception exc) {
                    b bVar = b.this;
                    bVar.j = "onNetError:" + com.alibaba.security.common.d.b.b(exc);
                    countDownLatch.countDown();
                }

                @Override // com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
                public final void onSuccess(HttpResponse httpResponse) {
                    b.this.j = httpResponse;
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await(15L, TimeUnit.SECONDS);
        } catch (Throwable th) {
            g.a.a.a(TrackLog.createSimpleSdk(h, "dynamicRequest", th.getMessage()));
            com.alibaba.security.common.c.a.b();
        }
        return this.j;
    }

    private void b(DynamicResponse dynamicResponse) {
        super.onPostExecute(dynamicResponse);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(DynamicResponse dynamicResponse) {
        String h5_domain;
        if (dynamicResponse == null || (h5_domain = dynamicResponse.getH5_DOMAIN()) == null) {
            return;
        }
        g.a.a.f = h5_domain;
        com.alibaba.security.common.c.a.a(h, "h5_domain:".concat(h5_domain));
    }

    private static void a(HttpRequest httpRequest) {
        g.a.a.a(TrackLog.createDynamicBegin("", h.a(httpRequest), ""));
    }

    private void a(String str, Object obj, DynamicResponse dynamicResponse) {
        TrackLog createDynamicEnd = TrackLog.createDynamicEnd(str, h.a(this.k), dynamicResponse == null ? h.a(obj) : h.a(dynamicResponse));
        createDynamicEnd.setRt(System.currentTimeMillis() - this.i);
        g.a.a.a(createDynamicEnd);
    }

    private static String a(String str) {
        byte[] a;
        if (TextUtils.isEmpty(str) || (a = com.alibaba.security.common.d.a.a(str)) == null) {
            return null;
        }
        String dp = ALBiometricsJni.dp(a);
        if (TextUtils.isEmpty(dp)) {
            return null;
        }
        return dp;
    }
}
