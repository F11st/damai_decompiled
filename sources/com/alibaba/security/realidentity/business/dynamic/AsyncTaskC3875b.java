package com.alibaba.security.realidentity.business.dynamic;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.common.d.C3801a;
import com.alibaba.security.common.d.C3805b;
import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.a.AbstractC3840a;
import com.alibaba.security.realidentity.a.C3847g;
import com.alibaba.security.realidentity.a.C3850i;
import com.alibaba.security.realidentity.business.dynamic.model.BcConfig;
import com.alibaba.security.realidentity.business.dynamic.model.DynamicResponse;
import com.alibaba.security.realidentity.d.C3890b;
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
/* renamed from: com.alibaba.security.realidentity.business.dynamic.b */
/* loaded from: classes8.dex */
public class AsyncTaskC3875b extends AbstractAsyncTaskC3874a<DynamicResponse> {
    public static final String f = "1";
    private long i;
    private Object j;
    private DynamicHttpRequest k;
    private static final String h = AsyncTaskC3875b.class.getSimpleName();
    public static final String[] g = {AbstractC3840a.U, AbstractC3840a.V, AbstractC3840a.W, AbstractC3840a.X, AbstractC3840a.T};

    public AsyncTaskC3875b(Context context, String str, RPEventListener rPEventListener, Runnable runnable, C3890b c3890b) {
        super(context, str, rPEventListener, runnable, c3890b);
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
        if (!TextUtils.isEmpty(result) && (a = C3801a.a(result)) != null) {
            String dp = ALBiometricsJni.dp(a);
            if (!TextUtils.isEmpty(dp)) {
                str = dp;
            }
        }
        String str2 = h;
        C3800a.a(str2, str);
        DynamicResponse dynamicResponse = (DynamicResponse) C3811h.a(str, DynamicResponse.class, true);
        if (dynamicResponse != null && (h5_domain = dynamicResponse.getH5_DOMAIN()) != null) {
            C3847g.C3848a.a.f = h5_domain;
            C3800a.a(str2, "h5_domain:".concat(h5_domain));
        }
        a("success", obj, dynamicResponse);
        return dynamicResponse;
    }

    private void c(DynamicResponse dynamicResponse) {
        if (dynamicResponse == null) {
            C3800a.e(h, "Null response data found on result");
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        C3847g.C3848a.a.n = dynamicResponse.getSC();
        C3847g.C3848a.a.p = dynamicResponse.getCTID();
        Runnable runnable2 = this.d;
        if (runnable2 != null) {
            runnable2.run();
        }
        BcConfig bc = dynamicResponse.getBC();
        if (bc != null && !TextUtils.isEmpty(bc.getBcContent())) {
            if (this.e == null) {
                C3800a.e(h, "Cannot find SecurityGuardManager instance");
                return;
            }
            String rpsdkUseLiteVM = dynamicResponse.getBASIC().getRpsdkUseLiteVM();
            boolean z = false;
            boolean z2 = TextUtils.isEmpty(rpsdkUseLiteVM) || rpsdkUseLiteVM.equals("1");
            GetCacheDataManager.getInstance().setUseLiteVm(z2);
            C3890b c3890b = this.e;
            c3890b.g = bc;
            c3890b.h = z2;
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
        C3800a.e(h, "Cannot process data with null BC");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.security.realidentity.business.dynamic.AbstractAsyncTaskC3874a, android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((DynamicResponse) obj);
    }

    @Override // com.alibaba.security.realidentity.business.dynamic.AbstractAsyncTaskC3874a
    public final /* synthetic */ void a(DynamicResponse dynamicResponse) {
        DynamicResponse dynamicResponse2 = dynamicResponse;
        if (dynamicResponse2 == null) {
            C3800a.e(h, "Null response data found on result");
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        C3847g.C3848a.a.n = dynamicResponse2.getSC();
        C3847g.C3848a.a.p = dynamicResponse2.getCTID();
        Runnable runnable2 = this.d;
        if (runnable2 != null) {
            runnable2.run();
        }
        BcConfig bc = dynamicResponse2.getBC();
        if (bc != null && !TextUtils.isEmpty(bc.getBcContent())) {
            if (this.e == null) {
                C3800a.e(h, "Cannot find SecurityGuardManager instance");
                return;
            }
            String rpsdkUseLiteVM = dynamicResponse2.getBASIC().getRpsdkUseLiteVM();
            boolean z = false;
            boolean z2 = TextUtils.isEmpty(rpsdkUseLiteVM) || rpsdkUseLiteVM.equals("1");
            GetCacheDataManager.getInstance().setUseLiteVm(z2);
            C3890b c3890b = this.e;
            c3890b.g = bc;
            c3890b.h = z2;
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
        C3800a.e(h, "Cannot process data with null BC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.alibaba.security.realidentity.business.dynamic.AbstractAsyncTaskC3874a, android.os.AsyncTask
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
        dynamicHttpRequest.setKeys(C3811h.a(arrayList));
        this.k = dynamicHttpRequest;
        C3847g.C3848a.a.a(TrackLog.createDynamicBegin("", C3811h.a(dynamicHttpRequest), ""));
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
        if (!TextUtils.isEmpty(result) && (a = C3801a.a(result)) != null) {
            String dp = ALBiometricsJni.dp(a);
            if (!TextUtils.isEmpty(dp)) {
                str = dp;
            }
        }
        String str2 = h;
        C3800a.a(str2, str);
        DynamicResponse dynamicResponse = (DynamicResponse) C3811h.a(str, DynamicResponse.class, true);
        if (dynamicResponse != null && (h5_domain = dynamicResponse.getH5_DOMAIN()) != null) {
            C3847g.C3848a.a.f = h5_domain;
            C3800a.a(str2, "h5_domain:".concat(h5_domain));
        }
        a("success", a2, dynamicResponse);
        return dynamicResponse;
    }

    private DynamicHttpRequest a(List<String> list) {
        DynamicHttpRequest dynamicHttpRequest = new DynamicHttpRequest(this.b);
        dynamicHttpRequest.setKeys(C3811h.a(list));
        return dynamicHttpRequest;
    }

    private Object a(DynamicHttpRequest dynamicHttpRequest) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            C3850i.C3851a.a.e().dynamic(new BusinessHttpWrapper(DynamicHttpResponse.class, new BusinessRequest(DynamicHttpRequest.class, dynamicHttpRequest)), new RetrofitHttpCallback() { // from class: com.alibaba.security.realidentity.business.dynamic.b.1
                @Override // com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
                public final void onFailure(HttpResponse httpResponse) {
                    AsyncTaskC3875b.this.j = httpResponse;
                    countDownLatch.countDown();
                }

                @Override // com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
                public final void onNetError(Exception exc) {
                    AsyncTaskC3875b asyncTaskC3875b = AsyncTaskC3875b.this;
                    asyncTaskC3875b.j = "onNetError:" + C3805b.b(exc);
                    countDownLatch.countDown();
                }

                @Override // com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
                public final void onSuccess(HttpResponse httpResponse) {
                    AsyncTaskC3875b.this.j = httpResponse;
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await(15L, TimeUnit.SECONDS);
        } catch (Throwable th) {
            C3847g.C3848a.a.a(TrackLog.createSimpleSdk(h, "dynamicRequest", th.getMessage()));
            C3800a.b();
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
        C3847g.C3848a.a.f = h5_domain;
        C3800a.a(h, "h5_domain:".concat(h5_domain));
    }

    private static void a(HttpRequest httpRequest) {
        C3847g.C3848a.a.a(TrackLog.createDynamicBegin("", C3811h.a(httpRequest), ""));
    }

    private void a(String str, Object obj, DynamicResponse dynamicResponse) {
        TrackLog createDynamicEnd = TrackLog.createDynamicEnd(str, C3811h.a(this.k), dynamicResponse == null ? C3811h.a(obj) : C3811h.a(dynamicResponse));
        createDynamicEnd.setRt(System.currentTimeMillis() - this.i);
        C3847g.C3848a.a.a(createDynamicEnd);
    }

    private static String a(String str) {
        byte[] a;
        if (TextUtils.isEmpty(str) || (a = C3801a.a(str)) == null) {
            return null;
        }
        String dp = ALBiometricsJni.dp(a);
        if (TextUtils.isEmpty(dp)) {
            return null;
        }
        return dp;
    }
}
