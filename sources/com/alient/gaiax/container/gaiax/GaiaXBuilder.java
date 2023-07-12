package com.alient.gaiax.container.gaiax;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alibaba.fastjson.JSONObject;
import com.alient.gaiax.container.gaiax.GaiaXBuilder;
import com.alient.gaiax.container.util.Utils;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.LoadType;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.middlewareservice.provider.info.DeviceInfoProviderProxy;
import com.youku.uplayer.FileUtils;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hh1;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ8\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J^\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0014H\u0007J\u0088\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0007¨\u0006 "}, d2 = {"Lcom/alient/gaiax/container/gaiax/GaiaXBuilder;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/view/View;", "gaiaxContainerView", "", "bizIdTemp", "templateId", "version", "", "viewWidth", "Ltb/wt2;", "gaiaxModelInfo", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "pos", "Lcom/alient/gaiax/container/gaiax/PictureGaiaXDelegate;", "yyDelegate", "", "autoUtEnable", "autoEventEnable", "Lcom/youku/gaiax/GaiaX$Params;", "renderGaiaXSimple", hh1.DIMEN_BIZ, "pageName", "Lcom/youku/gaiax/LoadType;", "mode", "renderGaiaX", "<init>", "()V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class GaiaXBuilder {
    private final void gaiaxModelInfo(final Context context, View view, String str, final String str2, String str3, float f) {
        View childAt;
        ViewGroup.LayoutParams layoutParams;
        int intValue;
        View childAt2;
        ViewGroup.LayoutParams layoutParams2;
        if (AppInfoProviderProxy.isDebuggable()) {
            Utils utils = Utils.INSTANCE;
            if (b41.d("1", utils.getString("picture_gaiax_layer_info")) && (view instanceof ViewGroup)) {
                TextView textView = new TextView(context);
                textView.setText("业务id: " + str + "  模版id:  " + str2 + "  模版version:  " + str3);
                int screenWidth = utils.screenWidth(context);
                int dip2px = utils.dip2px(context, 35.0f);
                ViewGroup viewGroup = (ViewGroup) view;
                Integer num = null;
                Integer valueOf = (viewGroup == null || (childAt = viewGroup.getChildAt(0)) == null || (layoutParams = childAt.getLayoutParams()) == null) ? null : Integer.valueOf(layoutParams.width);
                if (viewGroup != null && (childAt2 = viewGroup.getChildAt(0)) != null && (layoutParams2 = childAt2.getLayoutParams()) != null) {
                    num = Integer.valueOf(layoutParams2.height);
                }
                if (valueOf != null && (intValue = valueOf.intValue()) > 0) {
                    int intValue2 = valueOf.intValue();
                    if (num != null) {
                        num.intValue();
                        if (num.intValue() > 0 && intValue < screenWidth) {
                            dip2px = num.intValue();
                        }
                    }
                    screenWidth = intValue2;
                }
                textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: tb.ct0
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view2) {
                        boolean m194gaiaxModelInfo$lambda4;
                        m194gaiaxModelInfo$lambda4 = GaiaXBuilder.m194gaiaxModelInfo$lambda4(context, str2, view2);
                        return m194gaiaxModelInfo$lambda4;
                    }
                });
                textView.setClickable(false);
                textView.setWidth(screenWidth);
                textView.setMaxHeight(dip2px);
                textView.setTextColor(Color.parseColor("#ff00ee"));
                viewGroup.addView(textView);
            }
        }
    }

    /* renamed from: gaiaxModelInfo$lambda-4 */
    public static final boolean m194gaiaxModelInfo$lambda4(Context context, String str, View view) {
        b41.i(context, "$context");
        b41.i(str, "$templateId");
        Utils.INSTANCE.copyAction(context, str, "已复制至剪切板");
        return false;
    }

    public static /* synthetic */ GaiaX.Params renderGaiaX$default(GaiaXBuilder gaiaXBuilder, View view, Context context, String str, String str2, String str3, String str4, JSONObject jSONObject, float f, int i, PictureGaiaXDelegate pictureGaiaXDelegate, boolean z, boolean z2, LoadType loadType, int i2, Object obj) {
        Context context2;
        if ((i2 & 2) != 0) {
            Context context3 = view.getContext();
            b41.h(context3, "fun renderGaiaX(\n       …idth)\n            }\n    }");
            context2 = context3;
        } else {
            context2 = context;
        }
        return gaiaXBuilder.renderGaiaX(view, context2, (i2 & 4) != 0 ? "" : str, str2, (i2 & 16) != 0 ? "" : str3, (i2 & 32) != 0 ? "" : str4, jSONObject, (i2 & 128) != 0 ? DeviceInfoProviderProxy.getWindowWidth() : f, (i2 & 256) != 0 ? -1 : i, (i2 & 512) != 0 ? new PictureGaiaXEventProvider(context2) : pictureGaiaXDelegate, (i2 & 1024) != 0 ? true : z, (i2 & 2048) != 0 ? true : z2, (i2 & 4096) != 0 ? LoadType.SYNC_NORMAL : loadType);
    }

    /* renamed from: renderGaiaX$lambda-1$lambda-0 */
    public static final void m195renderGaiaX$lambda1$lambda0(PictureGaiaXDelegate pictureGaiaXDelegate, View view, JSONObject jSONObject, int i, View view2) {
        b41.i(pictureGaiaXDelegate, "$yyDelegate");
        b41.i(view, "$gaiaxContainerView");
        pictureGaiaXDelegate.onItemViewClick(view, jSONObject, i);
    }

    public static /* synthetic */ GaiaX.Params renderGaiaXSimple$default(GaiaXBuilder gaiaXBuilder, View view, Context context, String str, JSONObject jSONObject, float f, int i, PictureGaiaXDelegate pictureGaiaXDelegate, boolean z, boolean z2, int i2, Object obj) {
        return gaiaXBuilder.renderGaiaXSimple(view, context, str, jSONObject, (i2 & 16) != 0 ? DeviceInfoProviderProxy.getWindowWidth() : f, (i2 & 32) != 0 ? -1 : i, (i2 & 64) != 0 ? new PictureGaiaXEventProvider(context) : pictureGaiaXDelegate, (i2 & 128) != 0 ? true : z, (i2 & 256) != 0 ? true : z2);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull Context context, @NotNull String str, @Nullable JSONObject jSONObject) {
        b41.i(view, "gaiaxContainerView");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "templateId");
        return renderGaiaX$default(this, view, context, null, str, null, null, jSONObject, 0.0f, 0, null, false, false, null, 8116, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable JSONObject jSONObject) {
        b41.i(view, "gaiaxContainerView");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        return renderGaiaX$default(this, view, context, str, str2, null, null, jSONObject, 0.0f, 0, null, false, false, null, 8112, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable JSONObject jSONObject) {
        b41.i(view, "gaiaxContainerView");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        b41.i(str3, "version");
        return renderGaiaX$default(this, view, context, str, str2, str3, null, jSONObject, 0.0f, 0, null, false, false, null, 8096, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable JSONObject jSONObject) {
        b41.i(view, "gaiaxContainerView");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        b41.i(str3, "version");
        b41.i(str4, "pageName");
        return renderGaiaX$default(this, view, context, str, str2, str3, str4, jSONObject, 0.0f, 0, null, false, false, null, 8064, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable JSONObject jSONObject, float f) {
        b41.i(view, "gaiaxContainerView");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        b41.i(str3, "version");
        b41.i(str4, "pageName");
        return renderGaiaX$default(this, view, context, str, str2, str3, str4, jSONObject, f, 0, null, false, false, null, 7936, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable JSONObject jSONObject, float f, int i) {
        b41.i(view, "gaiaxContainerView");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        b41.i(str3, "version");
        b41.i(str4, "pageName");
        return renderGaiaX$default(this, view, context, str, str2, str3, str4, jSONObject, f, i, null, false, false, null, 7680, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable JSONObject jSONObject, float f, int i, @NotNull PictureGaiaXDelegate pictureGaiaXDelegate) {
        b41.i(view, "gaiaxContainerView");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        b41.i(str3, "version");
        b41.i(str4, "pageName");
        b41.i(pictureGaiaXDelegate, "yyDelegate");
        return renderGaiaX$default(this, view, context, str, str2, str3, str4, jSONObject, f, i, pictureGaiaXDelegate, false, false, null, 7168, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable JSONObject jSONObject, float f, int i, @NotNull PictureGaiaXDelegate pictureGaiaXDelegate, boolean z) {
        b41.i(view, "gaiaxContainerView");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        b41.i(str3, "version");
        b41.i(str4, "pageName");
        b41.i(pictureGaiaXDelegate, "yyDelegate");
        return renderGaiaX$default(this, view, context, str, str2, str3, str4, jSONObject, f, i, pictureGaiaXDelegate, z, false, null, 6144, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable JSONObject jSONObject, float f, int i, @NotNull PictureGaiaXDelegate pictureGaiaXDelegate, boolean z, boolean z2) {
        b41.i(view, "gaiaxContainerView");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        b41.i(str3, "version");
        b41.i(str4, "pageName");
        b41.i(pictureGaiaXDelegate, "yyDelegate");
        return renderGaiaX$default(this, view, context, str, str2, str3, str4, jSONObject, f, i, pictureGaiaXDelegate, z, z2, null, 4096, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0069 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    @kotlin.jvm.JvmOverloads
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.youku.gaiax.GaiaX.Params renderGaiaX(@org.jetbrains.annotations.NotNull final android.view.View r17, @org.jetbrains.annotations.NotNull android.content.Context r18, @org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.NotNull java.lang.String r20, @org.jetbrains.annotations.NotNull java.lang.String r21, @org.jetbrains.annotations.NotNull java.lang.String r22, @org.jetbrains.annotations.Nullable final com.alibaba.fastjson.JSONObject r23, float r24, final int r25, @org.jetbrains.annotations.NotNull final com.alient.gaiax.container.gaiax.PictureGaiaXDelegate r26, final boolean r27, final boolean r28, @org.jetbrains.annotations.NotNull com.youku.gaiax.LoadType r29) {
        /*
            r16 = this;
            r7 = r17
            r8 = r20
            r9 = r21
            r10 = r23
            r11 = r25
            r12 = r26
            r0 = r29
            java.lang.String r1 = "gaiaxContainerView"
            tb.b41.i(r7, r1)
            java.lang.String r1 = "context"
            r13 = r18
            tb.b41.i(r13, r1)
            java.lang.String r1 = "bizId"
            r2 = r19
            tb.b41.i(r2, r1)
            java.lang.String r1 = "templateId"
            tb.b41.i(r8, r1)
            java.lang.String r1 = "version"
            tb.b41.i(r9, r1)
            java.lang.String r1 = "pageName"
            r3 = r22
            tb.b41.i(r3, r1)
            java.lang.String r1 = "yyDelegate"
            tb.b41.i(r12, r1)
            java.lang.String r1 = "mode"
            tb.b41.i(r0, r1)
            com.alient.gaiax.container.util.ChannelUtil r1 = com.alient.gaiax.container.util.ChannelUtil.INSTANCE
            boolean r3 = r1.isDamaiApp()
            if (r3 == 0) goto L48
            java.lang.String r1 = "damai"
        L46:
            r14 = r1
            goto L63
        L48:
            boolean r1 = r1.isTppApp()
            if (r1 == 0) goto L51
            java.lang.String r1 = "tpp"
            goto L46
        L51:
            boolean r1 = kotlin.text.g.s(r19)
            if (r1 != 0) goto L59
            r14 = r2
            goto L63
        L59:
            java.lang.String r1 = "[GaiaX][GaiaXBuilder]"
            java.lang.String r2 = "bizId为null，需要检查传入参数"
            android.util.Log.e(r1, r2)
            java.lang.String r1 = ""
            goto L46
        L63:
            boolean r1 = kotlin.text.g.s(r14)
            if (r1 == 0) goto L6b
            r0 = 0
            return r0
        L6b:
            com.youku.gaiax.GaiaX$Params$Builder r1 = new com.youku.gaiax.GaiaX$Params$Builder
            r1.<init>()
            com.youku.gaiax.GaiaX$Params$Builder r1 = r1.templateBiz(r14)
            com.youku.gaiax.GaiaX$Params$Builder r1 = r1.templateId(r8)
            com.youku.gaiax.GaiaX$Params$Builder r1 = r1.templateVersion(r9)
            com.youku.gaiax.GaiaX$Params$Builder r1 = r1.container(r7)
            com.youku.gaiax.GaiaX$Params$Builder r0 = r1.mode(r0)
            com.youku.gaiax.GaiaX$Params$Builder r0 = r0.data(r10)
            r15 = r24
            com.youku.gaiax.GaiaX$Params$Builder r0 = r0.width(r15)
            com.youku.gaiax.GaiaX$Params r6 = r0.build()
            com.alient.gaiax.container.gaiax.GaiaXBuilder$renderGaiaX$1$1 r5 = new com.alient.gaiax.container.gaiax.GaiaXBuilder$renderGaiaX$1$1
            r0 = r5
            r1 = r26
            r2 = r17
            r3 = r23
            r4 = r25
            r8 = r5
            r5 = r28
            r9 = r6
            r6 = r27
            r0.<init>()
            r9.setEventDelegate(r8)
            com.alient.gaiax.container.gaiax.GaiaXBuilder$renderGaiaX$1$2 r0 = new com.alient.gaiax.container.gaiax.GaiaXBuilder$renderGaiaX$1$2
            r1 = r27
            r0.<init>()
            r9.setTrackDelegate3(r0)
            com.alient.gaiax.container.gaiax.GaiaXBuilder$renderGaiaX$1$3 r0 = new com.alient.gaiax.container.gaiax.GaiaXBuilder$renderGaiaX$1$3
            r0.<init>()
            r9.setStatusDelegate(r0)
            com.alient.gaiax.container.gaiax.GaiaXBuilder$renderGaiaX$1$4 r0 = new com.alient.gaiax.container.gaiax.GaiaXBuilder$renderGaiaX$1$4
            r0.<init>()
            r9.setMessage(r0)
            tb.bt0 r0 = new tb.bt0
            r0.<init>()
            r7.setOnClickListener(r0)
            r12.onItemViewExpose(r7, r10, r11)
            com.youku.gaiax.GaiaX$Companion r0 = com.youku.gaiax.GaiaX.Companion
            com.youku.gaiax.GaiaX r0 = r0.getInstance()
            r0.bindView(r9)
            r0 = r16
            r1 = r18
            r3 = r14
            r4 = r20
            r5 = r21
            r6 = r24
            r0.gaiaxModelInfo(r1, r2, r3, r4, r5, r6)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alient.gaiax.container.gaiax.GaiaXBuilder.renderGaiaX(android.view.View, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.alibaba.fastjson.JSONObject, float, int, com.alient.gaiax.container.gaiax.PictureGaiaXDelegate, boolean, boolean, com.youku.gaiax.LoadType):com.youku.gaiax.GaiaX$Params");
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull String str, @Nullable JSONObject jSONObject) {
        b41.i(view, "gaiaxContainerView");
        b41.i(str, "templateId");
        return renderGaiaX$default(this, view, null, null, str, null, null, jSONObject, 0.0f, 0, null, false, false, null, 8118, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaXSimple(@NotNull View view, @NotNull Context context, @NotNull String str, @Nullable JSONObject jSONObject) {
        b41.i(view, "gaiaxContainerView");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "templateId");
        return renderGaiaXSimple$default(this, view, context, str, jSONObject, 0.0f, 0, null, false, false, 496, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaXSimple(@NotNull View view, @NotNull Context context, @NotNull String str, @Nullable JSONObject jSONObject, float f) {
        b41.i(view, "gaiaxContainerView");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "templateId");
        return renderGaiaXSimple$default(this, view, context, str, jSONObject, f, 0, null, false, false, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaXSimple(@NotNull View view, @NotNull Context context, @NotNull String str, @Nullable JSONObject jSONObject, float f, int i) {
        b41.i(view, "gaiaxContainerView");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "templateId");
        return renderGaiaXSimple$default(this, view, context, str, jSONObject, f, i, null, false, false, FileUtils.S_IRWXU, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaXSimple(@NotNull View view, @NotNull Context context, @NotNull String str, @Nullable JSONObject jSONObject, float f, int i, @NotNull PictureGaiaXDelegate pictureGaiaXDelegate) {
        b41.i(view, "gaiaxContainerView");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "templateId");
        b41.i(pictureGaiaXDelegate, "yyDelegate");
        return renderGaiaXSimple$default(this, view, context, str, jSONObject, f, i, pictureGaiaXDelegate, false, false, 384, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaXSimple(@NotNull View view, @NotNull Context context, @NotNull String str, @Nullable JSONObject jSONObject, float f, int i, @NotNull PictureGaiaXDelegate pictureGaiaXDelegate, boolean z) {
        b41.i(view, "gaiaxContainerView");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "templateId");
        b41.i(pictureGaiaXDelegate, "yyDelegate");
        return renderGaiaXSimple$default(this, view, context, str, jSONObject, f, i, pictureGaiaXDelegate, z, false, 256, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaXSimple(@NotNull View view, @NotNull Context context, @NotNull String str, @Nullable JSONObject jSONObject, float f, int i, @NotNull PictureGaiaXDelegate pictureGaiaXDelegate, boolean z, boolean z2) {
        b41.i(view, "gaiaxContainerView");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "templateId");
        b41.i(pictureGaiaXDelegate, "yyDelegate");
        return renderGaiaX$default(this, view, context, "", str, "", "", jSONObject, f, i, pictureGaiaXDelegate, z, z2, null, 4096, null);
    }
}
