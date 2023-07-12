package com.youku.gaiax.impl;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.api.data.PipelineParams;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\u0007\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/youku/gaiax/impl/GXDataListener;", "Lcom/alibaba/gaiax/GXTemplateEngine$GXIDataListener;", "Lcom/alibaba/gaiax/GXTemplateEngine$j;", "gxTextData", "", "onTextProcess", "Lcom/youku/gaiax/impl/GaiaXContext;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/youku/gaiax/impl/GaiaXContext;", "getContext", "()Lcom/youku/gaiax/impl/GaiaXContext;", "<init>", "(Lcom/youku/gaiax/impl/GaiaXContext;)V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GXDataListener implements GXTemplateEngine.GXIDataListener {
    @NotNull
    private final GaiaXContext context;

    public GXDataListener(@NotNull GaiaXContext gaiaXContext) {
        b41.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        this.context = gaiaXContext;
    }

    @NotNull
    public final GaiaXContext getContext() {
        return this.context;
    }

    @Override // com.alibaba.gaiax.GXTemplateEngine.GXIDataListener
    @Nullable
    public CharSequence onTextProcess(@NotNull GXTemplateEngine.C3348j c3348j) {
        Object process;
        b41.i(c3348j, "gxTextData");
        View c = c3348j.c();
        String b = c3348j.b();
        CharSequence i = c3348j.i();
        Integer a = c3348j.a();
        JSONObject h = c3348j.h();
        if (c == null || b == null || i == null) {
            return null;
        }
        PipelineParams pipelineParams = new PipelineParams();
        pipelineParams.setData(i);
        pipelineParams.setView(c);
        pipelineParams.setViewId(b);
        if (h == null) {
            h = new JSONObject();
        }
        pipelineParams.setExtend(h);
        pipelineParams.setPosition(a);
        if (!this.context.getParams().getDataPipelines5().isEmpty()) {
            for (Map.Entry<GaiaX.IRule, GaiaX.IDataPipeline5> entry : this.context.getParams().getDataPipelines5().entrySet()) {
                if (entry.getKey().isRule(b, c) && (process = entry.getValue().process(pipelineParams)) != null) {
                    if (process instanceof CharSequence) {
                        return (CharSequence) process;
                    }
                    return null;
                }
            }
            return null;
        }
        return null;
    }
}
