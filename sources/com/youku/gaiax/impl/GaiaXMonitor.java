package com.youku.gaiax.impl;

import android.os.SystemClock;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.uc.webview.export.extension.UCCore;
import com.youku.gaiax.api.proxy.IProxyMonitor;
import com.youku.gaiax.impl.GaiaXExpression;
import com.youku.gaiax.impl.GaiaXProxy;
import com.youku.gaiax.impl.register.GXExtensionExpression;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.ns0;
import tb.os0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b#\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019J\u001e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019J\u001e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010 \u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\"\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004¨\u0006%"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXMonitor;", "", "Lcom/youku/gaiax/impl/GaiaXContext;", "gaiaXContext", "", "type", "Ltb/wt2;", "onCreateB", "onRefreshB", "onCreateA", "onCreateBSync", "onCreateBAsync", "onRefreshA", "onRefreshBAsync", "onRefreshBSync", "onStep1A", "onStep1B", "onStep2A", "onStep2B", "onStep3A", "onStep3B", "onStep4A", "onStep4B", "Lcom/alibaba/gaiax/GXTemplateEngine$i;", "gxTemplateItem", "", "time", "onCreateC", "templateBizId", "templateId", "onContainerA", "onContainerB", "onExpressionTimeUpLoad", "moduleId", "onComponent", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXMonitor {
    @NotNull
    public static final GaiaXMonitor INSTANCE = new GaiaXMonitor();

    private GaiaXMonitor() {
    }

    private final void onCreateB(GaiaXContext gaiaXContext, String str) {
        GXTemplateInfo q;
        ns0 s;
        String g;
        GaiaXProxy.Companion companion = GaiaXProxy.Companion;
        IProxyMonitor monitor = companion.getInstance().getMonitor();
        if (monitor != null) {
            IProxyMonitor.DefaultImpls.monitor$default(monitor, "template_createview", gaiaXContext.getParams().getTemplateBiz(), gaiaXContext.getParams().getTemplateId(), null, "success", 0L, null, null, null, 488, null);
        }
        IProxyMonitor monitor2 = companion.getInstance().getMonitor();
        if (monitor2 != null) {
            IProxyMonitor.DefaultImpls.monitor$default(monitor2, "template_time", gaiaXContext.getParams().getTemplateBiz(), gaiaXContext.getParams().getTemplateId(), str, null, SystemClock.elapsedRealtime() - gaiaXContext.getCreateTime$GaiaX_Android(), null, null, null, 464, null);
        }
        os0 gxTemplateContext = gaiaXContext.getGxTemplateContext();
        String str2 = "";
        if (gxTemplateContext != null && (q = gxTemplateContext.q()) != null && (s = q.s()) != null && (g = s.g()) != null) {
            str2 = g;
        }
        IProxyMonitor monitor3 = companion.getInstance().getMonitor();
        if (monitor3 == null) {
            return;
        }
        String templateBiz = gaiaXContext.getParams().getTemplateBiz();
        String templateId = gaiaXContext.getParams().getTemplateId();
        if (b41.d(str2, "assets")) {
            str2 = "local";
        }
        IProxyMonitor.DefaultImpls.monitor$default(monitor3, "template_exposure", templateBiz, templateId, str2, null, 0L, null, null, null, 496, null);
    }

    private final void onRefreshB(GaiaXContext gaiaXContext, String str) {
        IProxyMonitor monitor = GaiaXProxy.Companion.getInstance().getMonitor();
        if (monitor == null) {
            return;
        }
        IProxyMonitor.DefaultImpls.monitor$default(monitor, "template_time", gaiaXContext.getParams().getTemplateBiz(), gaiaXContext.getParams().getTemplateId(), str, null, SystemClock.elapsedRealtime() - gaiaXContext.getRefreshTime$GaiaX_Android(), null, null, null, 464, null);
    }

    public final void onComponent(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        b41.i(str, "templateBizId");
        b41.i(str2, "templateId");
        b41.i(str3, "moduleId");
        IProxyMonitor monitor = GaiaXProxy.Companion.getInstance().getMonitor();
        if (monitor == null) {
            return;
        }
        IProxyMonitor.DefaultImpls.monitor$default(monitor, "template_component", str, str2, str3, null, 0L, null, null, null, 496, null);
    }

    public final void onContainerA(@NotNull String str, @NotNull String str2, long j) {
        b41.i(str, "templateBizId");
        b41.i(str2, "templateId");
        IProxyMonitor monitor = GaiaXProxy.Companion.getInstance().getMonitor();
        if (monitor == null) {
            return;
        }
        IProxyMonitor.DefaultImpls.monitor$default(monitor, "template_time", str, str2, "1051", null, SystemClock.elapsedRealtime() - j, null, null, null, 464, null);
    }

    public final void onContainerB(@NotNull String str, @NotNull String str2, long j) {
        b41.i(str, "templateBizId");
        b41.i(str2, "templateId");
        IProxyMonitor monitor = GaiaXProxy.Companion.getInstance().getMonitor();
        if (monitor == null) {
            return;
        }
        IProxyMonitor.DefaultImpls.monitor$default(monitor, "template_time", str, str2, "1052", null, SystemClock.elapsedRealtime() - j, null, null, null, 464, null);
    }

    public final void onCreateA(@NotNull GaiaXContext gaiaXContext) {
        b41.i(gaiaXContext, "gaiaXContext");
        gaiaXContext.setCreateTime$GaiaX_Android(SystemClock.elapsedRealtime());
        IProxyMonitor monitor = GaiaXProxy.Companion.getInstance().getMonitor();
        if (monitor == null) {
            return;
        }
        IProxyMonitor.DefaultImpls.monitor$default(monitor, "template_createview", gaiaXContext.getParams().getTemplateBiz(), gaiaXContext.getParams().getTemplateId(), null, UCCore.LEGACY_EVENT_INIT, 0L, null, null, null, 488, null);
    }

    public final void onCreateBAsync(@NotNull GaiaXContext gaiaXContext) {
        b41.i(gaiaXContext, "gaiaXContext");
        onCreateB(gaiaXContext, "1019");
    }

    public final void onCreateBSync(@NotNull GaiaXContext gaiaXContext) {
        b41.i(gaiaXContext, "gaiaXContext");
        onCreateB(gaiaXContext, "1020");
    }

    public final void onCreateC(@NotNull GXTemplateEngine.i iVar, long j) {
        b41.i(iVar, "gxTemplateItem");
        IProxyMonitor monitor = GaiaXProxy.Companion.getInstance().getMonitor();
        if (monitor == null) {
            return;
        }
        IProxyMonitor.DefaultImpls.monitor$default(monitor, "template_time", iVar.a(), iVar.d(), "1031", null, SystemClock.elapsedRealtime() - j, null, null, null, 464, null);
    }

    public final void onExpressionTimeUpLoad(@NotNull GaiaXContext gaiaXContext) {
        b41.i(gaiaXContext, "gaiaXContext");
        GXExtensionExpression.Companion companion = GXExtensionExpression.Companion;
        if (companion.getExpressionCount() != 0) {
            IProxyMonitor monitor = GaiaXProxy.Companion.getInstance().getMonitor();
            if (monitor != null) {
                IProxyMonitor.DefaultImpls.monitor$default(monitor, "expression_time", gaiaXContext.getParams().getTemplateBiz(), gaiaXContext.getParams().getTemplateId(), "1053", null, companion.getExpressionV2Time() / companion.getExpressionCount(), null, null, null, 464, null);
            }
            companion.setExpressionV2Time(0L);
            companion.setExpressionCount(0);
            return;
        }
        IProxyMonitor monitor2 = GaiaXProxy.Companion.getInstance().getMonitor();
        if (monitor2 != null) {
            String templateBiz = gaiaXContext.getParams().getTemplateBiz();
            String templateId = gaiaXContext.getParams().getTemplateId();
            GaiaXExpression.Companion companion2 = GaiaXExpression.Companion;
            IProxyMonitor.DefaultImpls.monitor$default(monitor2, "expression_time", templateBiz, templateId, "1054", null, companion2.getExpressionV1Time() / companion2.getExpressionV1Count(), null, null, null, 464, null);
        }
        GaiaXExpression.Companion companion3 = GaiaXExpression.Companion;
        companion3.setExpressionV1Time(0L);
        companion3.setExpressionV1Count(0);
    }

    public final void onRefreshA(@NotNull GaiaXContext gaiaXContext) {
        b41.i(gaiaXContext, "gaiaXContext");
        gaiaXContext.setRefreshTime$GaiaX_Android(SystemClock.elapsedRealtime());
    }

    public final void onRefreshBAsync(@NotNull GaiaXContext gaiaXContext) {
        b41.i(gaiaXContext, "gaiaXContext");
        onRefreshB(gaiaXContext, "1018");
    }

    public final void onRefreshBSync(@NotNull GaiaXContext gaiaXContext) {
        b41.i(gaiaXContext, "gaiaXContext");
        onRefreshB(gaiaXContext, "1021");
    }

    public final void onStep1A(@NotNull GaiaXContext gaiaXContext) {
        b41.i(gaiaXContext, "gaiaXContext");
        gaiaXContext.setStepTime$GaiaX_Android(SystemClock.elapsedRealtime());
    }

    public final void onStep1B(@NotNull GaiaXContext gaiaXContext) {
        b41.i(gaiaXContext, "gaiaXContext");
        IProxyMonitor monitor = GaiaXProxy.Companion.getInstance().getMonitor();
        if (monitor == null) {
            return;
        }
        IProxyMonitor.DefaultImpls.monitor$default(monitor, "template_time", gaiaXContext.getParams().getTemplateBiz(), gaiaXContext.getParams().getTemplateId(), "1011", null, SystemClock.elapsedRealtime() - gaiaXContext.getStepTime$GaiaX_Android(), null, null, null, 464, null);
    }

    public final void onStep2A(@NotNull GaiaXContext gaiaXContext) {
        b41.i(gaiaXContext, "gaiaXContext");
        gaiaXContext.setStepTime$GaiaX_Android(SystemClock.elapsedRealtime());
    }

    public final void onStep2B(@NotNull GaiaXContext gaiaXContext) {
        b41.i(gaiaXContext, "gaiaXContext");
        IProxyMonitor monitor = GaiaXProxy.Companion.getInstance().getMonitor();
        if (monitor == null) {
            return;
        }
        IProxyMonitor.DefaultImpls.monitor$default(monitor, "template_time", gaiaXContext.getParams().getTemplateBiz(), gaiaXContext.getParams().getTemplateId(), "1012", null, SystemClock.elapsedRealtime() - gaiaXContext.getStepTime$GaiaX_Android(), null, null, null, 464, null);
    }

    public final void onStep3A(@NotNull GaiaXContext gaiaXContext) {
        b41.i(gaiaXContext, "gaiaXContext");
        gaiaXContext.setStepTime$GaiaX_Android(SystemClock.elapsedRealtime());
    }

    public final void onStep3B(@NotNull GaiaXContext gaiaXContext) {
        b41.i(gaiaXContext, "gaiaXContext");
        IProxyMonitor monitor = GaiaXProxy.Companion.getInstance().getMonitor();
        if (monitor == null) {
            return;
        }
        IProxyMonitor.DefaultImpls.monitor$default(monitor, "template_time", gaiaXContext.getParams().getTemplateBiz(), gaiaXContext.getParams().getTemplateId(), "1013", null, SystemClock.elapsedRealtime() - gaiaXContext.getStepTime$GaiaX_Android(), null, null, null, 464, null);
    }

    public final void onStep4A(@NotNull GaiaXContext gaiaXContext) {
        b41.i(gaiaXContext, "gaiaXContext");
        gaiaXContext.setStepTime$GaiaX_Android(SystemClock.elapsedRealtime());
    }

    public final void onStep4B(@NotNull GaiaXContext gaiaXContext) {
        b41.i(gaiaXContext, "gaiaXContext");
        IProxyMonitor monitor = GaiaXProxy.Companion.getInstance().getMonitor();
        if (monitor == null) {
            return;
        }
        IProxyMonitor.DefaultImpls.monitor$default(monitor, "template_time", gaiaXContext.getParams().getTemplateBiz(), gaiaXContext.getParams().getTemplateId(), "1014", null, SystemClock.elapsedRealtime() - gaiaXContext.getStepTime$GaiaX_Android(), null, null, null, 464, null);
    }
}
