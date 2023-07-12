package com.youku.gaiax.provider.module.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.Keep;
import androidx.core.content.res.ResourcesCompat;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.render.view.basic.GXIImageView;
import com.alibaba.pictures.moimage.MoImageView;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.util.LogUtil;
import com.youku.gaiax.common.utils.Log;
import com.youku.gaiax.provider.module.proxy.PictureGaiaXProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.C8604o;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.bs0;
import tb.k50;
import tb.os0;
import tb.pq0;
import tb.pr0;
import tb.wt2;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GB\u0011\u0012\b\u0010D\u001a\u0004\u0018\u00010C¢\u0006\u0004\bE\u0010FJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0005J´\u0002\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u000326\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u000f0\u001526\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u000f0\u001526\u0010\u001a\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u000f0\u001526\u0010\u001b\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u000f0\u00152:\b\u0002\u0010\u001c\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0005J\u0018\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eJ\u0016\u0010!\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\"\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J(\u0010'\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u001eH\u0014J\u0018\u0010,\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*H\u0016J\u0012\u0010/\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\u0012\u00100\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010-H\u0014J\u0010\u00103\u001a\u00020\u000f2\u0006\u00102\u001a\u000201H\u0016J&\u00103\u001a\u00020\u000f2\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u0002042\u0006\u00107\u001a\u0002042\u0006\u00108\u001a\u000204J \u0010;\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u0002042\u0006\u00102\u001a\u000201H\u0016J\u0018\u0010<\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003R$\u0010=\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006H"}, d2 = {"Lcom/youku/gaiax/provider/module/views/GaiaXPicImageView;", "Lcom/alibaba/pictures/moimage/MoImageView;", "Lcom/alibaba/gaiax/render/view/basic/GXIImageView;", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "getUriByCompatibility", "uri", "getLocalUri", "getResUri", "getGaiaxResUri", "Landroid/widget/ImageView;", "imageView", "Landroid/graphics/drawable/Drawable;", "drawable", "Ltb/wt2;", "updateMatrix", "", "isNetUri", "isResUri", "isLocalUri", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "dispatchNet", "dispatchLocal", "dispatchRes", "dispatchDefault", "dispatchPlaceholder", "doBindUri", "", "resId", "getDrawableByResId", "getResIdByUri", "onBindData", NotifyType.LIGHTS, "t", UploadQueueMgr.MSGTYPE_REALTIME, "b", "setFrame", "Ltb/os0;", "gxTemplateContext", "Ltb/pq0;", "gxCss", "setImageStyle", "Landroid/graphics/Canvas;", "canvas", "draw", "onDraw", "", BQCCameraParam.FOCUS_AREA_RADIUS, "setRoundCornerRadius", "", "topLeft", "topRight", "bottomLeft", "bottomRight", "borderColor", Constants.Name.BORDER_WIDTH, "setRoundCornerBorder", "imageLoader", "placeHolderResId", "Ljava/lang/Integer;", "getPlaceHolderResId", "()Ljava/lang/Integer;", "setPlaceHolderResId", "(Ljava/lang/Integer;)V", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Companion", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXPicImageView extends MoImageView implements GXIImageView {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String GAIAX_RES_PREFIX = "gaiax_res:";
    @NotNull
    public static final String LOCAL_PREFIX = "local:";
    @NotNull
    public static final String NET_HTTPS_PREFIX = "https:";
    @NotNull
    public static final String NET_HTTP_PREFIX = "http:";
    @NotNull
    public static final String RES_PREFIX = "res:";
    @Nullable
    private bs0 delegate;
    @Nullable
    private os0 gxTemplateContext;
    @Nullable
    private pr0 mode;
    @Nullable
    private Integer placeHolderResId;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/provider/module/views/GaiaXPicImageView$Companion;", "", "", "GAIAX_RES_PREFIX", "Ljava/lang/String;", "LOCAL_PREFIX", "NET_HTTPS_PREFIX", "NET_HTTP_PREFIX", "RES_PREFIX", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    public GaiaXPicImageView(@Nullable Context context) {
        super(context, null, 0, 6, null);
        setImageDrawable(new ColorDrawable(0));
        setBackgroundDrawable(new ColorDrawable(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getGaiaxResUri(String str) {
        String z;
        z = C8604o.z(str, GAIAX_RES_PREFIX, "", false, 4, null);
        return z;
    }

    private final String getLocalUri(String str) {
        String z;
        z = C8604o.z(str, "local:", "", false, 4, null);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getResUri(String str) {
        String z;
        z = C8604o.z(str, RES_PREFIX, "", false, 4, null);
        return z;
    }

    private final String getUriByCompatibility(JSONObject jSONObject) {
        CharSequence M0;
        CharSequence M02;
        String string = jSONObject == null ? null : jSONObject.getString("url");
        String string2 = jSONObject != null ? jSONObject.getString("value") : null;
        if (string != null) {
            if (string.length() > 0) {
                M02 = StringsKt__StringsKt.M0(string);
                return M02.toString();
            }
        }
        if (string2 != null) {
            if (string2.length() > 0) {
                M0 = StringsKt__StringsKt.M0(string2);
                return M0.toString();
            }
        }
        return "";
    }

    private final void updateMatrix(ImageView imageView, Drawable drawable) {
        if (drawable == null || imageView.getScaleType() != ImageView.ScaleType.MATRIX) {
            return;
        }
        int paddingLeft = (imageView.getLayoutParams().width - imageView.getPaddingLeft()) - imageView.getPaddingRight();
        int paddingTop = (imageView.getLayoutParams().height - imageView.getPaddingTop()) - imageView.getPaddingBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return;
        }
        pr0 pr0Var = this.mode;
        imageView.setImageMatrix(pr0Var == null ? null : pr0Var.j(paddingLeft, paddingTop, intrinsicWidth, intrinsicHeight));
    }

    @Nullable
    public final Drawable dispatchRes(@NotNull ImageView imageView, @NotNull String str) {
        b41.i(imageView, "imageView");
        b41.i(str, "uri");
        try {
            int identifier = imageView.getResources().getIdentifier(str, "drawable", imageView.getContext().getPackageName());
            Resources.Theme theme = imageView.getContext().getTheme();
            b41.h(theme, "imageView.context.theme");
            Drawable drawable = ResourcesCompat.getDrawable(imageView.getResources(), identifier, theme);
            imageView.setImageDrawable(drawable);
            return drawable;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void doBindUri(@NotNull ImageView imageView, @Nullable JSONObject jSONObject, @NotNull Function2<? super ImageView, ? super String, wt2> function2, @NotNull Function2<? super ImageView, ? super String, wt2> function22, @NotNull Function2<? super ImageView, ? super String, wt2> function23, @NotNull Function2<? super ImageView, ? super String, wt2> function24, @Nullable Function2<? super ImageView, ? super String, wt2> function25) {
        b41.i(imageView, "imageView");
        b41.i(function2, "dispatchNet");
        b41.i(function22, "dispatchLocal");
        b41.i(function23, "dispatchRes");
        b41.i(function24, "dispatchDefault");
        String uriByCompatibility = getUriByCompatibility(jSONObject);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX][Image]", b41.r("doBindUri() called with: uri = ", uriByCompatibility));
        }
        if (isNetUri(uriByCompatibility)) {
            function2.invoke(imageView, uriByCompatibility);
        } else if (isLocalUri(uriByCompatibility)) {
            function22.invoke(imageView, getLocalUri(uriByCompatibility));
        } else if (isResUri(uriByCompatibility)) {
            function23.invoke(imageView, uriByCompatibility);
        } else if (!TextUtils.isEmpty(uriByCompatibility)) {
            function23.invoke(imageView, uriByCompatibility);
        } else {
            function24.invoke(imageView, "");
        }
    }

    @Override // android.view.View
    public void draw(@Nullable final Canvas canvas) {
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        bs0 bs0Var = this.delegate;
        boolean z = false;
        if (bs0Var != null && bs0Var.d(canvas, measuredWidth, measuredHeight)) {
            z = true;
        }
        if (z) {
            bs0 bs0Var2 = this.delegate;
            if (bs0Var2 == null) {
                return;
            }
            bs0Var2.a(canvas, measuredWidth, measuredHeight, new Function0<wt2>() { // from class: com.youku.gaiax.provider.module.views.GaiaXPicImageView$draw$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ wt2 invoke() {
                    invoke2();
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    super/*android.widget.ImageView*/.draw(canvas);
                }
            });
            return;
        }
        super.draw(canvas);
    }

    @Nullable
    public final Drawable getDrawableByResId(@NotNull ImageView imageView, int i) {
        b41.i(imageView, "imageView");
        Resources.Theme theme = imageView.getContext().getTheme();
        b41.h(theme, "imageView.context.theme");
        return ResourcesCompat.getDrawable(imageView.getResources(), i, theme);
    }

    @Nullable
    public final Integer getPlaceHolderResId() {
        return this.placeHolderResId;
    }

    public final int getResIdByUri(@NotNull ImageView imageView, @NotNull String str) {
        b41.i(imageView, "imageView");
        b41.i(str, "uri");
        try {
            return imageView.getResources().getIdentifier(str, "drawable", imageView.getContext().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final void imageLoader(@NotNull final String str, @Nullable JSONObject jSONObject) {
        int resIdByUri;
        String string;
        b41.i(str, "uri");
        Integer num = null;
        if (jSONObject != null && (string = jSONObject.getString(Constants.Name.PLACEHOLDER)) != null) {
            num = Integer.valueOf(getResIdByUri(this, string));
        }
        if (num == null) {
            PictureGaiaXProviderProxy.Companion companion = PictureGaiaXProviderProxy.Companion;
            if (companion.isDamaiApp()) {
                resIdByUri = getResIdByUri(this, "bricks_uikit_default_image_bg_gradient_radius3");
            } else if (companion.isTppApp()) {
                resIdByUri = getResIdByUri(this, "uikit_default_image_bg_grey");
            } else {
                resIdByUri = getResIdByUri(this, "uikit_default_image_bg_grey");
            }
            num = Integer.valueOf(resIdByUri);
        }
        this.placeHolderResId = num;
        if (num != null) {
            int intValue = num.intValue();
            getViewState().B(intValue);
            getViewState().K(intValue);
        }
        setRequestListener(new MoImageView.SimpleRequestListener() { // from class: com.youku.gaiax.provider.module.views.GaiaXPicImageView$imageLoader$4
            @Override // com.alibaba.pictures.moimage.MoImageView.SimpleRequestListener
            public boolean onLoadFailed(@Nullable Exception exc, @Nullable String str2) {
                wt2 wt2Var;
                Object[] objArr = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append("onLoadFailed：");
                sb.append((Object) str2);
                sb.append(" +   ");
                if (exc == null) {
                    wt2Var = null;
                } else {
                    exc.printStackTrace();
                    wt2Var = wt2.INSTANCE;
                }
                sb.append(wt2Var);
                objArr[0] = sb.toString();
                LogUtil.d("[GaiaX][Image]", objArr);
                return false;
            }

            @Override // com.alibaba.pictures.moimage.MoImageView.SimpleRequestListener
            public boolean onResourceReady(@Nullable Object obj, @Nullable String str2, int i, int i2) {
                os0 os0Var;
                LogUtil.d("[GaiaX][Image]", b41.r("onResourceReady：", str));
                os0Var = this.gxTemplateContext;
                if (os0Var != null) {
                    os0Var.E(os0Var.c() + 1);
                }
                return false;
            }
        });
        setUrl(str);
    }

    public final boolean isLocalUri(@NotNull String str) {
        boolean F;
        b41.i(str, "uri");
        F = C8604o.F(str, "local:", false, 2, null);
        return F;
    }

    public final boolean isNetUri(@NotNull String str) {
        boolean F;
        boolean F2;
        b41.i(str, "uri");
        F = C8604o.F(str, "http:", false, 2, null);
        if (!F) {
            F2 = C8604o.F(str, "https:", false, 2, null);
            if (!F2) {
                return false;
            }
        }
        return true;
    }

    public final boolean isResUri(@NotNull String str) {
        boolean F;
        b41.i(str, "uri");
        F = C8604o.F(str, RES_PREFIX, false, 2, null);
        return F;
    }

    @Override // com.alibaba.gaiax.render.view.basic.GXIImageView, com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(@Nullable final JSONObject jSONObject) {
        doBindUri(this, jSONObject, new Function2<ImageView, String, wt2>() { // from class: com.youku.gaiax.provider.module.views.GaiaXPicImageView$onBindData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ wt2 invoke(ImageView imageView, String str) {
                invoke2(imageView, str);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ImageView imageView, @NotNull String str) {
                b41.i(imageView, "imageView");
                b41.i(str, "uri");
                GaiaXPicImageView.this.imageLoader(str, jSONObject);
                LogUtil.d("[GaiaX][Image]", b41.r("dispatchNet：", str));
            }
        }, new Function2<ImageView, String, wt2>() { // from class: com.youku.gaiax.provider.module.views.GaiaXPicImageView$onBindData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ wt2 invoke(ImageView imageView, String str) {
                invoke2(imageView, str);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ImageView imageView, @NotNull String str) {
                b41.i(imageView, "imageView");
                b41.i(str, "uri");
                GaiaXPicImageView.this.imageLoader(str, jSONObject);
                LogUtil.d("[GaiaX][Image]", b41.r("dispatchLocal：", str));
            }
        }, new Function2<ImageView, String, wt2>() { // from class: com.youku.gaiax.provider.module.views.GaiaXPicImageView$onBindData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ wt2 invoke(ImageView imageView, String str) {
                invoke2(imageView, str);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ImageView imageView, @NotNull String str) {
                boolean F;
                boolean F2;
                String resUri;
                String gaiaxResUri;
                b41.i(imageView, "imageView");
                b41.i(str, "uri");
                GaiaXPicImageView gaiaXPicImageView = GaiaXPicImageView.this;
                JSONObject jSONObject2 = jSONObject;
                F = C8604o.F(str, GaiaXPicImageView.GAIAX_RES_PREFIX, false, 2, null);
                if (F) {
                    gaiaxResUri = gaiaXPicImageView.getGaiaxResUri(str);
                    gaiaXPicImageView.dispatchRes(imageView, gaiaxResUri);
                    LogUtil.d("[GaiaX][Image]", b41.r("dispatchRes：", str));
                    return;
                }
                F2 = C8604o.F(str, GaiaXPicImageView.RES_PREFIX, false, 2, null);
                if (F2) {
                    resUri = gaiaXPicImageView.getResUri(str);
                    gaiaXPicImageView.dispatchRes(imageView, resUri);
                    LogUtil.d("[GaiaX][Image]", b41.r("dispatchRes：", str));
                    return;
                }
                gaiaXPicImageView.imageLoader(str, jSONObject2);
                LogUtil.d("[GaiaX][Image]", b41.r("dispatchRes uri：", str));
            }
        }, new Function2<ImageView, String, wt2>() { // from class: com.youku.gaiax.provider.module.views.GaiaXPicImageView$onBindData$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ wt2 invoke(ImageView imageView, String str) {
                invoke2(imageView, str);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ImageView imageView, @NotNull String str) {
                b41.i(imageView, "imageView");
                b41.i(str, "uri");
                GaiaXPicImageView.this.imageLoader(str, jSONObject);
                if (str.length() == 0) {
                    GaiaXPicImageView.this.setImageDrawable(new ColorDrawable(0));
                }
                LogUtil.d("[GaiaX][Image]", b41.r("dispatchDefault：", str));
            }
        }, new Function2<ImageView, String, wt2>() { // from class: com.youku.gaiax.provider.module.views.GaiaXPicImageView$onBindData$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ wt2 invoke(ImageView imageView, String str) {
                invoke2(imageView, str);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ImageView imageView, @NotNull String str) {
                b41.i(imageView, "imageView");
                b41.i(str, "uri");
                GaiaXPicImageView gaiaXPicImageView = GaiaXPicImageView.this;
                gaiaXPicImageView.setPlaceHolderResId(Integer.valueOf(gaiaXPicImageView.getResIdByUri(imageView, str)));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.pictures.moimage.MoImageView, android.widget.ImageView, android.view.View
    public void onDraw(@Nullable Canvas canvas) {
        bs0 bs0Var;
        super.onDraw(canvas);
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        bs0 bs0Var2 = this.delegate;
        boolean z = false;
        if (bs0Var2 != null && bs0Var2.d(canvas, measuredWidth, measuredHeight)) {
            z = true;
        }
        if (!z || (bs0Var = this.delegate) == null) {
            return;
        }
        bs0Var.e(canvas, measuredWidth, measuredHeight);
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onResetData() {
        GXIImageView.C3362a.a(this);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        updateMatrix(this, getDrawable());
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // com.alibaba.gaiax.render.view.basic.GXIImageView
    public void setImageStyle(@NotNull os0 os0Var, @NotNull pq0 pq0Var) {
        b41.i(os0Var, "gxTemplateContext");
        b41.i(pq0Var, "gxCss");
        pr0 M = pq0Var.b().M();
        if (M != null) {
            this.mode = M;
            setScaleType(M.p());
        } else {
            setScaleType(ImageView.ScaleType.FIT_XY);
        }
        this.gxTemplateContext = os0Var;
    }

    public final void setPlaceHolderResId(@Nullable Integer num) {
        this.placeHolderResId = num;
    }

    @Override // com.alibaba.gaiax.render.view.basic.GXIImageView, com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerBorder(int i, float f, @NotNull float[] fArr) {
        b41.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
        if (this.delegate == null) {
            this.delegate = new bs0();
        }
        bs0 bs0Var = this.delegate;
        if (bs0Var == null) {
            return;
        }
        bs0Var.g(i, f, fArr);
    }

    @Override // com.alibaba.gaiax.render.view.basic.GXIImageView, com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerRadius(@NotNull float[] fArr) {
        b41.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
        if (this.delegate == null) {
            this.delegate = new bs0();
        }
        bs0 bs0Var = this.delegate;
        if (bs0Var == null) {
            return;
        }
        bs0Var.i(fArr);
    }

    public final void setRoundCornerRadius(float f, float f2, float f3, float f4) {
        if (this.delegate == null) {
            this.delegate = new bs0();
        }
        bs0 bs0Var = this.delegate;
        if (bs0Var == null) {
            return;
        }
        bs0Var.h(f, f2, f3, f4);
    }
}
