package com.alibaba.aliweex.adapter.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.aliweex.IConfigAdapter;
import com.alibaba.aliweex.adapter.IGodEyeStageAdapter;
import com.alibaba.aliweex.interceptor.phenix.PhenixTracker;
import com.alibaba.aliweex.utils.BlurTool;
import com.alibaba.gaiax.GXTemplateEngine;
import com.taobao.phenix.animate.AnimatedImageDrawable;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.tao.image.ImageStrategyConfig;
import com.taobao.tao.util.ImageStrategyDecider;
import com.taobao.tao.util.TaobaoImageUrlStrategy;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXImageStrategy;
import com.taobao.weex.dom.WXImageQuality;
import com.taobao.weex.ui.view.WXImageView;
import com.taobao.weex.utils.WXLogUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import tb.ds1;
import tb.nh0;
import tb.oz2;
import tb.ui2;
import tb.ur1;
import tb.wr1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXImgLoaderAdapter implements IWXImgLoaderAdapter {
    public static final String TRUE = "true";
    public static final String WX_ALLOW_RELEASE_DOMAIN = "allow_active_release";
    public static final String WX_IMAGE_RELEASE_CONFIG = "android_aliweex_image_release";
    private static boolean b = true;
    private PhenixTracker a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[WXImageQuality.values().length];
            a = iArr;
            try {
                iArr[WXImageQuality.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[WXImageQuality.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[WXImageQuality.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class b implements IPhenixListener<nh0> {
        private WXImageStrategy a;
        private WeakReference<ImageView> b;
        private String c;
        private PhenixTracker d;

        b(WXImageStrategy wXImageStrategy, ImageView imageView, String str, PhenixTracker phenixTracker) {
            this.a = wXImageStrategy;
            this.b = new WeakReference<>(imageView);
            this.c = str;
            this.d = phenixTracker;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0092  */
        @Override // com.taobao.phenix.intf.event.IPhenixListener
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onHappen(tb.nh0 r6) {
            /*
                r5 = this;
                com.taobao.weex.WXSDKManager r0 = com.taobao.weex.WXSDKManager.v()
                com.taobao.weex.common.WXImageStrategy r1 = r5.a
                java.lang.String r1 = r1.instanceId
                com.taobao.weex.WXSDKInstance r0 = r0.y(r1)
                r1 = 0
                if (r0 == 0) goto L1e
                com.taobao.weex.performance.WXInstanceApm r0 = r0.getApmForInstance()
                int r2 = r6.f()
                java.lang.String r2 = java.lang.String.valueOf(r2)
                r0.b(r1, r2)
            L1e:
                java.lang.ref.WeakReference<android.widget.ImageView> r0 = r5.b
                java.lang.Object r0 = r0.get()
                android.widget.ImageView r0 = (android.widget.ImageView) r0
                if (r0 != 0) goto L29
                return r1
            L29:
                boolean r2 = com.alibaba.aliweex.adapter.adapter.WXImgLoaderAdapter.d()
                if (r2 == 0) goto L6a
                if (r6 == 0) goto L6a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L67
                r2.<init>()     // Catch: java.lang.Throwable -> L67
                java.lang.String r3 = "resultCode:"
                r2.append(r3)     // Catch: java.lang.Throwable -> L67
                int r3 = r6.f()     // Catch: java.lang.Throwable -> L67
                r2.append(r3)     // Catch: java.lang.Throwable -> L67
                r3 = 44
                r2.append(r3)     // Catch: java.lang.Throwable -> L67
                java.lang.String r4 = "httpCode:"
                r2.append(r4)     // Catch: java.lang.Throwable -> L67
                int r4 = r6.d()     // Catch: java.lang.Throwable -> L67
                r2.append(r4)     // Catch: java.lang.Throwable -> L67
                r2.append(r3)     // Catch: java.lang.Throwable -> L67
                java.lang.String r3 = "httpMessage"
                r2.append(r3)     // Catch: java.lang.Throwable -> L67
                java.lang.String r3 = r6.e()     // Catch: java.lang.Throwable -> L67
                r2.append(r3)     // Catch: java.lang.Throwable -> L67
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L67
                goto L6c
            L67:
                com.alibaba.aliweex.adapter.adapter.WXImgLoaderAdapter.e(r1)
            L6a:
                java.lang.String r2 = ""
            L6c:
                java.lang.String r3 = r5.c
                java.lang.String r4 = "weex-image-Fail"
                com.alibaba.aliweex.adapter.adapter.WXImgLoaderAdapter.c(r4, r3, r2)
                r2 = -308(0xfffffffffffffecc, float:NaN)
                java.lang.String r3 = "ERROR"
                r0.setTag(r2, r3)
                com.taobao.weex.common.WXImageStrategy r2 = r5.a
                com.taobao.weex.common.WXImageStrategy$ImageListener r2 = r2.getImageListener()
                if (r2 == 0) goto L8e
                com.taobao.weex.common.WXImageStrategy r2 = r5.a
                com.taobao.weex.common.WXImageStrategy$ImageListener r2 = r2.getImageListener()
                java.lang.String r3 = r5.c
                r4 = 0
                r2.onImageFinish(r3, r0, r1, r4)
            L8e:
                com.alibaba.aliweex.interceptor.phenix.PhenixTracker r0 = r5.d
                if (r0 == 0) goto L95
                r0.k(r6)
            L95:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.aliweex.adapter.adapter.WXImgLoaderAdapter.b.onHappen(tb.nh0):boolean");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class c implements IPhenixListener<ui2> {
        private WXImageStrategy a;
        private WeakReference<ImageView> b;
        private String c;
        private PhenixTracker d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes5.dex */
        public class a implements BlurTool.OnBlurCompleteListener {
            final /* synthetic */ ImageView a;
            final /* synthetic */ Drawable b;

            a(c cVar, ImageView imageView, Drawable drawable) {
                this.a = imageView;
                this.b = drawable;
            }

            @Override // com.alibaba.aliweex.utils.BlurTool.OnBlurCompleteListener
            public void onBlurComplete(@NonNull Bitmap bitmap) {
                try {
                    this.a.setImageDrawable(new BitmapDrawable(this.a.getContext().getResources(), bitmap));
                } catch (Exception e) {
                    try {
                        WXLogUtils.e(e.getMessage());
                        this.a.setImageDrawable(this.b);
                    } catch (Exception e2) {
                        WXLogUtils.e(e2.getMessage());
                    }
                }
            }
        }

        c(WXImageStrategy wXImageStrategy, ImageView imageView, String str, PhenixTracker phenixTracker) {
            this.a = wXImageStrategy;
            this.b = new WeakReference<>(imageView);
            this.c = str;
            this.d = phenixTracker;
        }

        @Override // com.taobao.phenix.intf.event.IPhenixListener
        /* renamed from: a */
        public boolean onHappen(ui2 ui2Var) {
            WXSDKInstance y = WXSDKManager.v().y(this.a.instanceId);
            if (y != null) {
                y.getApmForInstance().b(true, null);
            }
            BitmapDrawable f = ui2Var.f();
            ImageView imageView = this.b.get();
            if (imageView == null) {
                return false;
            }
            String str = this.c;
            StringBuilder sb = new StringBuilder();
            sb.append("drawable is null?");
            sb.append(f == null);
            WXImgLoaderAdapter.i("weex-image-success", str, sb.toString());
            imageView.setTag(-308, GXTemplateEngine.b.STATE_END);
            if (f != null) {
                if ((imageView instanceof WXImageView) && (f instanceof AnimatedImageDrawable)) {
                    ((WXImageView) imageView).setImageDrawable(f, true);
                } else if (this.a.blurRadius <= 0) {
                    imageView.setImageDrawable(f);
                } else if (f.getBitmap() != null) {
                    BlurTool.b(f.getBitmap(), this.a.blurRadius, new a(this, imageView, f));
                } else {
                    try {
                        imageView.setImageDrawable(f);
                    } catch (Exception e) {
                        WXLogUtils.e(e.getMessage());
                    }
                }
                if (!ui2Var.i() && this.a.getImageListener() != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("drawable", new WeakReference(f));
                    this.a.getImageListener().onImageFinish(this.c, imageView, true, hashMap);
                }
            }
            PhenixTracker phenixTracker = this.d;
            if (phenixTracker != null) {
                phenixTracker.l(ui2Var);
            }
            return false;
        }
    }

    private ImageStrategyConfig g(boolean z, WXImageQuality wXImageQuality) {
        ImageStrategyConfig.b p = ImageStrategyConfig.p(z ? ImageStrategyConfig.WEAPPSHARPEN : ImageStrategyConfig.WEAPP, 70);
        if (wXImageQuality != null) {
            int i = a.a[wXImageQuality.ordinal()];
            if (i == 1) {
                p.c(TaobaoImageUrlStrategy.ImageQuality.q50);
            } else if (i == 2) {
                p.c(TaobaoImageUrlStrategy.ImageQuality.q75);
            } else if (i == 3) {
                p.c(TaobaoImageUrlStrategy.ImageQuality.q90);
            }
        }
        return p.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(String str, String str2, String str3) {
        IGodEyeStageAdapter h;
        IConfigAdapter c2 = com.alibaba.aliweex.a.l().c();
        if ((c2 == null || Boolean.valueOf(c2.getConfig(oz2.WXAPM_CONFIG_GROUP, "recordImageState", "true")).booleanValue()) && (h = com.alibaba.aliweex.a.l().h()) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str2);
            hashMap.put("msg", str3);
            h.onStage(str, hashMap);
        }
    }

    public String f(ImageView imageView, String str, boolean z, WXImageQuality wXImageQuality) {
        int height;
        int width;
        ImageStrategyConfig g = g(z, wXImageQuality);
        if (g == null) {
            return str;
        }
        if (imageView.getLayoutParams() != null) {
            height = imageView.getLayoutParams().height;
            width = imageView.getLayoutParams().width;
        } else {
            height = imageView.getHeight();
            width = imageView.getWidth();
        }
        return ImageStrategyDecider.decideUrl(str, Integer.valueOf(width), Integer.valueOf(height), g);
    }

    public String h(ImageView imageView, String str, WXImageQuality wXImageQuality, WXImageStrategy wXImageStrategy) {
        return (imageView == null || TextUtils.isEmpty(str) || wXImageQuality == WXImageQuality.ORIGINAL) ? str : f(imageView, str, wXImageStrategy.isSharpen, wXImageQuality);
    }

    @Override // com.taobao.weex.adapter.IWXImgLoaderAdapter
    public void setImage(@Nullable final String str, @Nullable final ImageView imageView, final WXImageQuality wXImageQuality, final WXImageStrategy wXImageStrategy) {
        WXSDKManager.v().N(new Runnable() { // from class: com.alibaba.aliweex.adapter.adapter.WXImgLoaderAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                ImageView imageView2 = imageView;
                if (imageView2 != null) {
                    if (imageView2.getTag() instanceof ds1) {
                        ((ds1) imageView.getTag()).cancel();
                    }
                    if (TextUtils.isEmpty(str)) {
                        imageView.setImageDrawable(null);
                        return;
                    }
                    WXSDKInstance y = WXSDKManager.v().y(wXImageStrategy.instanceId);
                    if (y != null) {
                        y.getApmForInstance().a();
                        str2 = y.getBundleUrl();
                    } else {
                        str2 = null;
                    }
                    String h = WXImgLoaderAdapter.this.h(imageView, str, wXImageQuality, wXImageStrategy);
                    if (!TextUtils.isEmpty(wXImageStrategy.placeHolder)) {
                        ur1.o().s(wXImageStrategy.placeHolder).n();
                    }
                    if (WXEnvironment.isApkDebugable() && WXImgLoaderAdapter.this.a == null) {
                        WXImgLoaderAdapter.this.a = PhenixTracker.j();
                    }
                    wr1 f = ur1.o().s(h).O(wXImageStrategy.placeHolder).A(imageView).K(true).f("bundle_biz_code", Integer.toString(70));
                    if (!TextUtils.isEmpty(str2)) {
                        f.f("pageURL", str2);
                    }
                    IConfigAdapter c2 = com.alibaba.aliweex.a.l().c();
                    if (c2 != null) {
                        String config = c2.getConfig(WXImgLoaderAdapter.WX_IMAGE_RELEASE_CONFIG, WXImgLoaderAdapter.WX_ALLOW_RELEASE_DOMAIN, "");
                        if (TextUtils.isEmpty(config) || !TextUtils.equals("true", config)) {
                            f.K(false);
                        }
                    }
                    WXImgLoaderAdapter.i("weex-image-start", str, null);
                    f.Q(new c(wXImageStrategy, imageView, str, WXImgLoaderAdapter.this.a));
                    f.m(new b(wXImageStrategy, imageView, str, WXImgLoaderAdapter.this.a));
                    imageView.setTag(-308, GXTemplateEngine.b.STATE_START);
                    if (WXImgLoaderAdapter.this.a != null) {
                        HashMap hashMap = new HashMap();
                        if (WXEnvironment.isApkDebugable()) {
                            hashMap.put(Constants.Name.QUALITY, wXImageQuality.name());
                            hashMap.put("bundle_biz_code", String.valueOf(70));
                            hashMap.put(Constants.Name.SHARPEN, String.valueOf(wXImageStrategy.isSharpen));
                            hashMap.put("blurRaduis", String.valueOf(wXImageStrategy.blurRadius));
                            hashMap.put(Constants.Name.PLACE_HOLDER, wXImageStrategy.placeHolder);
                        }
                        WXImgLoaderAdapter.this.a.m(f, hashMap);
                    }
                    imageView.setTag(f.n());
                }
            }
        }, 0L);
    }
}
