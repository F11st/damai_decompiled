package com.youku.gaiax.impl.utils;

import com.youku.gaiax.GaiaX;
import com.youku.gaiax.api.proxy.IProxyMonitor;
import com.youku.gaiax.common.utils.Log;
import com.youku.gaiax.impl.GaiaXContext;
import com.youku.gaiax.impl.GaiaXProxy;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0012\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¨\u0006\u0012"}, d2 = {"Lcom/youku/gaiax/impl/utils/ExceptionUtils;", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "", "code", "Ltb/wt2;", "throwExceptionOrAlarm", "Lcom/youku/gaiax/GaiaX$Params;", "params", "Lcom/youku/gaiax/impl/GaiaXContext;", "gaiaXContext", "throwWorkerAlarm", "throwUiAlarm", "throwParamsReleaseAlarm", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ExceptionUtils {
    @NotNull
    public static final ExceptionUtils INSTANCE = new ExceptionUtils();

    private ExceptionUtils() {
    }

    public final void throwExceptionOrAlarm(@NotNull Exception exc, @NotNull String str) {
        b41.i(exc, "e");
        b41.i(str, "code");
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        String writer = stringWriter.toString();
        IProxyMonitor monitor = GaiaXProxy.Companion.getInstance().getMonitor();
        if (monitor != null) {
            IProxyMonitor.DefaultImpls.alarm$default(monitor, str, null, null, null, b41.r("碰到异常，无法继续任务 message=", writer), null, 46, null);
        }
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", b41.r("碰到异常，无法继续任务 message=", writer));
        }
    }

    public final void throwParamsReleaseAlarm(@NotNull GaiaX.Params params) {
        b41.i(params, "params");
        IProxyMonitor monitor = GaiaXProxy.Companion.getInstance().getMonitor();
        if (monitor != null) {
            IProxyMonitor.DefaultImpls.alarm$default(monitor, "5001", null, null, null, "GaiaX.Params已经被释放，无法继续执行bindView", null, 46, null);
        }
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", "GaiaX.Params已经被释放，无法继续执行bindView");
        }
        GaiaX.IErrorDelegate errorDelegate = params.getErrorDelegate();
        if (errorDelegate == null) {
            return;
        }
        errorDelegate.onError("GaiaX.Params已经被释放，无法继续执行bindView");
    }

    public final void throwUiAlarm(@NotNull GaiaXContext gaiaXContext) {
        b41.i(gaiaXContext, "gaiaXContext");
        IProxyMonitor monitor = GaiaXProxy.Companion.getInstance().getMonitor();
        if (monitor != null) {
            IProxyMonitor.DefaultImpls.alarm$default(monitor, "5001", gaiaXContext.getParams().getTemplateBiz(), gaiaXContext.getParams().getTemplateId(), gaiaXContext.getParams().getTemplateVersion(), "GaiaXContext已经被释放，无法继续执行UI任务", null, 32, null);
        }
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", "GaiaXContext已经被释放，无法继续执行UI任务");
        }
        GaiaX.IErrorDelegate errorDelegate = gaiaXContext.getParams().getErrorDelegate();
        if (errorDelegate == null) {
            return;
        }
        errorDelegate.onError("GaiaXContext已经被释放，无法继续执行UI任务");
    }

    public final void throwWorkerAlarm(@NotNull GaiaXContext gaiaXContext) {
        b41.i(gaiaXContext, "gaiaXContext");
        IProxyMonitor monitor = GaiaXProxy.Companion.getInstance().getMonitor();
        if (monitor != null) {
            IProxyMonitor.DefaultImpls.alarm$default(monitor, "5001", gaiaXContext.getParams().getTemplateBiz(), gaiaXContext.getParams().getTemplateId(), gaiaXContext.getParams().getTemplateVersion(), "GaiaXContext已经被释放，无法继续执行Worker任务", null, 32, null);
        }
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", "GaiaXContext已经被释放，无法继续执行Worker任务");
        }
        GaiaX.IErrorDelegate errorDelegate = gaiaXContext.getParams().getErrorDelegate();
        if (errorDelegate == null) {
            return;
        }
        errorDelegate.onError("GaiaXContext已经被释放，无法继续执行Worker任务");
    }

    public final void throwExceptionOrAlarm(@NotNull Exception exc) {
        b41.i(exc, "e");
        throwExceptionOrAlarm(exc, "5002");
    }

    public final void throwExceptionOrAlarm(@NotNull GaiaX.Params params, @NotNull Exception exc) {
        b41.i(params, "params");
        b41.i(exc, "e");
        GaiaXContext containerContext = GaiaXContext.Companion.getContainerContext(params);
        if (containerContext == null) {
            return;
        }
        INSTANCE.throwExceptionOrAlarm(containerContext, exc);
    }

    public final void throwExceptionOrAlarm(@NotNull GaiaXContext gaiaXContext, @NotNull Exception exc) {
        b41.i(gaiaXContext, "gaiaXContext");
        b41.i(exc, "e");
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        String writer = stringWriter.toString();
        IProxyMonitor monitor = GaiaXProxy.Companion.getInstance().getMonitor();
        if (monitor != null) {
            String templateId = gaiaXContext.getParams().getTemplateId();
            String templateBiz = gaiaXContext.getParams().getTemplateBiz();
            String templateVersion = gaiaXContext.getParams().getTemplateVersion();
            IProxyMonitor.DefaultImpls.alarm$default(monitor, "5001", templateBiz, templateId, templateVersion, "碰到异常，无法继续任务 isRelease=" + gaiaXContext.isReleased() + " message=" + writer + ' ', null, 32, null);
        }
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX]", "碰到异常，无法继续任务 isRelease=" + gaiaXContext.isReleased() + " message=" + writer);
        }
        GaiaX.IErrorDelegate errorDelegate = gaiaXContext.getParams().getErrorDelegate();
        if (errorDelegate == null) {
            return;
        }
        errorDelegate.onError("碰到异常，无法继续任务 message=" + writer + ' ');
    }
}
