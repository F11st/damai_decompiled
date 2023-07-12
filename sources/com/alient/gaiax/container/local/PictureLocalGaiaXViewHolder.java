package com.alient.gaiax.container.local;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alient.gaiax.container.gaiax.GaiaXBuilder;
import com.alient.gaiax.container.gaiax.PictureGaiaXDelegate;
import com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider;
import com.alient.gaiax.container.gaiax.PictureGxTemplate;
import com.youku.arch.v3.data.Constants;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.LoadType;
import com.youku.middlewareservice.provider.info.DeviceInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hh1;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b(\u0010)Jt\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0007J8\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007R\u0019\u0010\u0019\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/alient/gaiax/container/local/PictureLocalGaiaXViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", hh1.DIMEN_BIZ, "templateId", "version", "pageName", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "viewWidth", "", "pos", "Lcom/alient/gaiax/container/gaiax/PictureGaiaXDelegate;", "yyDelegate", "", "autoUtEnable", "autoEventEnable", "Lcom/youku/gaiax/LoadType;", "mode", "Ltb/wt2;", "renderGaiaX", "Lcom/alient/gaiax/container/gaiax/PictureGxTemplate;", Constants.TEMPLATE, "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/alient/gaiax/container/gaiax/PictureGaiaXDelegate;", "Lcom/youku/gaiax/GaiaX$Params;", "params", "Lcom/youku/gaiax/GaiaX$Params;", "Landroid/view/ViewGroup$LayoutParams;", "layoutParam", "Landroid/view/ViewGroup$LayoutParams;", "getLayoutParam", "()Landroid/view/ViewGroup$LayoutParams;", "setLayoutParam", "(Landroid/view/ViewGroup$LayoutParams;)V", "<init>", "(Landroid/content/Context;)V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public final class PictureLocalGaiaXViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final Context context;
    @NotNull
    private ViewGroup.LayoutParams layoutParam;
    @Nullable
    private GaiaX.Params params;
    @Nullable
    private PictureGaiaXDelegate yyDelegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureLocalGaiaXViewHolder(@NotNull Context context) {
        super(new FrameLayout(context));
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.context = context;
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
        b41.h(layoutParams, "itemView.layoutParams");
        this.layoutParam = layoutParams;
    }

    public static /* synthetic */ void renderGaiaX$default(PictureLocalGaiaXViewHolder pictureLocalGaiaXViewHolder, String str, String str2, String str3, String str4, JSONObject jSONObject, float f, int i, PictureGaiaXDelegate pictureGaiaXDelegate, boolean z, boolean z2, LoadType loadType, int i2, Object obj) {
        pictureLocalGaiaXViewHolder.renderGaiaX((i2 & 1) != 0 ? "" : str, str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, jSONObject, (i2 & 32) != 0 ? DeviceInfoProviderProxy.getWindowWidth() : f, (i2 & 64) != 0 ? -1 : i, (i2 & 128) != 0 ? new PictureGaiaXEventProvider(pictureLocalGaiaXViewHolder.context) : pictureGaiaXDelegate, (i2 & 256) != 0 ? true : z, (i2 & 512) != 0 ? true : z2, (i2 & 1024) != 0 ? LoadType.SYNC_NORMAL : loadType);
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final ViewGroup.LayoutParams getLayoutParam() {
        return this.layoutParam;
    }

    @JvmOverloads
    public final void renderGaiaX(@NotNull PictureGxTemplate pictureGxTemplate, @Nullable JSONObject jSONObject) {
        b41.i(pictureGxTemplate, Constants.TEMPLATE);
        renderGaiaX$default(this, pictureGxTemplate, jSONObject, 0.0f, 0, null, 28, null);
    }

    @JvmOverloads
    public final void renderGaiaX(@NotNull PictureGxTemplate pictureGxTemplate, @Nullable JSONObject jSONObject, float f) {
        b41.i(pictureGxTemplate, Constants.TEMPLATE);
        renderGaiaX$default(this, pictureGxTemplate, jSONObject, f, 0, null, 24, null);
    }

    @JvmOverloads
    public final void renderGaiaX(@NotNull PictureGxTemplate pictureGxTemplate, @Nullable JSONObject jSONObject, float f, int i) {
        b41.i(pictureGxTemplate, Constants.TEMPLATE);
        renderGaiaX$default(this, pictureGxTemplate, jSONObject, f, i, null, 16, null);
    }

    @JvmOverloads
    public final void renderGaiaX(@NotNull String str, @Nullable JSONObject jSONObject) {
        b41.i(str, "templateId");
        renderGaiaX$default(this, null, str, null, null, jSONObject, 0.0f, 0, null, false, false, null, 2029, null);
    }

    @JvmOverloads
    public final void renderGaiaX(@NotNull String str, @NotNull String str2, @Nullable JSONObject jSONObject) {
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        renderGaiaX$default(this, str, str2, null, null, jSONObject, 0.0f, 0, null, false, false, null, 2028, null);
    }

    @JvmOverloads
    public final void renderGaiaX(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable JSONObject jSONObject) {
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        b41.i(str3, "version");
        renderGaiaX$default(this, str, str2, str3, null, jSONObject, 0.0f, 0, null, false, false, null, 2024, null);
    }

    @JvmOverloads
    public final void renderGaiaX(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable JSONObject jSONObject) {
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        b41.i(str3, "version");
        b41.i(str4, "pageName");
        renderGaiaX$default(this, str, str2, str3, str4, jSONObject, 0.0f, 0, null, false, false, null, 2016, null);
    }

    @JvmOverloads
    public final void renderGaiaX(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable JSONObject jSONObject, float f) {
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        b41.i(str3, "version");
        b41.i(str4, "pageName");
        renderGaiaX$default(this, str, str2, str3, str4, jSONObject, f, 0, null, false, false, null, 1984, null);
    }

    @JvmOverloads
    public final void renderGaiaX(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable JSONObject jSONObject, float f, int i) {
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        b41.i(str3, "version");
        b41.i(str4, "pageName");
        renderGaiaX$default(this, str, str2, str3, str4, jSONObject, f, i, null, false, false, null, 1920, null);
    }

    @JvmOverloads
    public final void renderGaiaX(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable JSONObject jSONObject, float f, int i, @NotNull PictureGaiaXDelegate pictureGaiaXDelegate) {
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        b41.i(str3, "version");
        b41.i(str4, "pageName");
        b41.i(pictureGaiaXDelegate, "yyDelegate");
        renderGaiaX$default(this, str, str2, str3, str4, jSONObject, f, i, pictureGaiaXDelegate, false, false, null, 1792, null);
    }

    @JvmOverloads
    public final void renderGaiaX(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable JSONObject jSONObject, float f, int i, @NotNull PictureGaiaXDelegate pictureGaiaXDelegate, boolean z) {
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        b41.i(str3, "version");
        b41.i(str4, "pageName");
        b41.i(pictureGaiaXDelegate, "yyDelegate");
        renderGaiaX$default(this, str, str2, str3, str4, jSONObject, f, i, pictureGaiaXDelegate, z, false, null, 1536, null);
    }

    @JvmOverloads
    public final void renderGaiaX(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable JSONObject jSONObject, float f, int i, @NotNull PictureGaiaXDelegate pictureGaiaXDelegate, boolean z, boolean z2) {
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        b41.i(str3, "version");
        b41.i(str4, "pageName");
        b41.i(pictureGaiaXDelegate, "yyDelegate");
        renderGaiaX$default(this, str, str2, str3, str4, jSONObject, f, i, pictureGaiaXDelegate, z, z2, null, 1024, null);
    }

    @JvmOverloads
    public final void renderGaiaX(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable JSONObject jSONObject, float f, int i, @NotNull PictureGaiaXDelegate pictureGaiaXDelegate, boolean z, boolean z2, @NotNull LoadType loadType) {
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        b41.i(str3, "version");
        b41.i(str4, "pageName");
        b41.i(pictureGaiaXDelegate, "yyDelegate");
        b41.i(loadType, "mode");
        this.yyDelegate = pictureGaiaXDelegate;
        GaiaXBuilder gaiaXBuilder = new GaiaXBuilder();
        View view = this.itemView;
        b41.h(view, "itemView");
        this.params = gaiaXBuilder.renderGaiaX(view, this.context, str, str2, str3, str4, jSONObject, f, i, pictureGaiaXDelegate, z, z2, loadType);
    }

    public final void setLayoutParam(@NotNull ViewGroup.LayoutParams layoutParams) {
        b41.i(layoutParams, "<set-?>");
        this.layoutParam = layoutParams;
    }

    @JvmOverloads
    public final void renderGaiaX(@NotNull PictureGxTemplate pictureGxTemplate, @Nullable JSONObject jSONObject, float f, int i, @NotNull PictureGaiaXDelegate pictureGaiaXDelegate) {
        b41.i(pictureGxTemplate, Constants.TEMPLATE);
        b41.i(pictureGaiaXDelegate, "yyDelegate");
        String bizId = pictureGxTemplate.getBizId();
        if (bizId == null) {
            bizId = "";
        }
        String templateVersion = pictureGxTemplate.getTemplateVersion();
        String str = templateVersion == null ? "" : templateVersion;
        String pageName = pictureGxTemplate.getPageName();
        renderGaiaX$default(this, bizId, pictureGxTemplate.getTemplateId(), str, pageName == null ? "" : pageName, jSONObject, f, i, pictureGaiaXDelegate, false, false, null, 1792, null);
    }

    public static /* synthetic */ void renderGaiaX$default(PictureLocalGaiaXViewHolder pictureLocalGaiaXViewHolder, PictureGxTemplate pictureGxTemplate, JSONObject jSONObject, float f, int i, PictureGaiaXDelegate pictureGaiaXDelegate, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = DeviceInfoProviderProxy.getWindowWidth();
        }
        float f2 = f;
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            pictureGaiaXDelegate = new PictureGaiaXEventProvider(pictureLocalGaiaXViewHolder.context);
        }
        pictureLocalGaiaXViewHolder.renderGaiaX(pictureGxTemplate, jSONObject, f2, i3, pictureGaiaXDelegate);
    }
}
