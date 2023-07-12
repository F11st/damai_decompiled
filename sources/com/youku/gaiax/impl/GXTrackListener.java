package com.youku.gaiax.impl;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.api.data.TrackParams;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\u0007\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/youku/gaiax/impl/GXTrackListener;", "Lcom/alibaba/gaiax/GXTemplateEngine$GXITrackListener;", "Lcom/alibaba/gaiax/GXTemplateEngine$k;", "gxTrack", "Ltb/wt2;", "onTrackEvent", "Lcom/youku/gaiax/impl/GaiaXContext;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/youku/gaiax/impl/GaiaXContext;", "getContext", "()Lcom/youku/gaiax/impl/GaiaXContext;", "<init>", "(Lcom/youku/gaiax/impl/GaiaXContext;)V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GXTrackListener implements GXTemplateEngine.GXITrackListener {
    @NotNull
    private final GaiaXContext context;

    public GXTrackListener(@NotNull GaiaXContext gaiaXContext) {
        b41.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        this.context = gaiaXContext;
    }

    @NotNull
    public final GaiaXContext getContext() {
        return this.context;
    }

    @Override // com.alibaba.gaiax.GXTemplateEngine.GXITrackListener
    public void onManualClickTrackEvent(@NotNull GXTemplateEngine.k kVar) {
        GXTemplateEngine.GXITrackListener.a.a(this, kVar);
    }

    @Override // com.alibaba.gaiax.GXTemplateEngine.GXITrackListener
    public void onManualExposureTrackEvent(@NotNull GXTemplateEngine.k kVar) {
        GXTemplateEngine.GXITrackListener.a.b(this, kVar);
    }

    @Override // com.alibaba.gaiax.GXTemplateEngine.GXITrackListener
    public void onTrackEvent(@NotNull GXTemplateEngine.k kVar) {
        b41.i(kVar, "gxTrack");
        GXTemplateEngine.GXITrackListener.a.c(this, kVar);
        View d = kVar.d();
        String b = kVar.b();
        Integer a = kVar.a();
        JSONObject c = kVar.c();
        GaiaX.ITrackDelegate3 trackDelegate3 = this.context.getParams().getTrackDelegate3();
        if (trackDelegate3 == null) {
            return;
        }
        TrackParams trackParams = new TrackParams();
        trackParams.setView(d);
        trackParams.setData(c);
        trackParams.setViewId(b);
        trackParams.setPosition(a);
        trackParams.setParams(getContext().getParams());
        trackDelegate3.onTrack(trackParams);
    }
}
