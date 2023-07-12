package com.youku.gaiax.impl;

import android.content.Context;
import android.os.Trace;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.taobao.weex.common.Constants;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.IExperiment;
import com.youku.gaiax.IGaiaXApi;
import com.youku.gaiax.IStable;
import com.youku.gaiax.LoadType;
import com.youku.gaiax.common.utils.Log;
import com.youku.gaiax.impl.js.GaiaXJSDelegate;
import com.youku.gaiax.impl.utils.ExceptionUtils;
import com.youku.gaiax.impl.utils.PropUtils;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.os0;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u001a\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010,R\u0018\u0010#\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010.¨\u00061"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXImpl;", "Lcom/youku/gaiax/IGaiaXApi;", "Lcom/youku/gaiax/impl/GaiaXContext;", "gaiaXContext", "Ltb/wt2;", "onViewPrepareRefresh", "Lcom/youku/gaiax/GaiaX$Params;", "params", "onViewReload", "onViewPrepareCreate", "onPageVisible", "onPageInvisible", "onViewVisible", "onViewInvisible", WPKFactory.INIT_KEY_CONTEXT, "onBindViewDispatcher", "gxContext", "onViewRefreshing", "onViewCreating", "onViewDestroy", "onViewDestroyByReload", "onViewCreateSync", "onViewRefreshSync", "onViewCreateAsync", "onViewRefreshAsync", "onViewRefreshResultDispatcher", "Landroid/view/View;", "gxView", "onViewCreateResultDispatcher", "Landroid/view/ViewGroup;", "container", "fixContainerSize", "Lcom/youku/gaiax/IExperiment;", "experiment", "Lcom/youku/gaiax/IStable;", Constants.Name.STABLE, "visibleView", "invisibleView", "visiblePage", "invisiblePage", "reloadView", "bindView", "unbindView", "Lcom/youku/gaiax/impl/GaiaXExperimentApiImpl;", "Lcom/youku/gaiax/impl/GaiaXExperimentApiImpl;", "Lcom/youku/gaiax/impl/GaiaXStableApiImpl;", "Lcom/youku/gaiax/impl/GaiaXStableApiImpl;", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXImpl implements IGaiaXApi {
    @Nullable
    private GaiaXExperimentApiImpl experiment;
    @Nullable
    private GaiaXStableApiImpl stable;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            iArr[LoadType.SYNC_NORMAL.ordinal()] = 1;
            iArr[LoadType.ASYNC_NORMAL.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void fixContainerSize(ViewGroup viewGroup, View view) {
        ViewGroup.LayoutParams layoutParams = viewGroup == null ? null : viewGroup.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.width = view.getLayoutParams().width;
    }

    private final void onBindViewDispatcher(GaiaXContext gaiaXContext, GaiaX.Params params) {
        boolean isInvalidContainer = gaiaXContext.isInvalidContainer();
        boolean isInvalidStatus = gaiaXContext.isInvalidStatus();
        boolean isInvalidGXRootView = gaiaXContext.isInvalidGXRootView();
        if (isInvalidContainer || isInvalidStatus || isInvalidGXRootView) {
            if (isInvalidContainer) {
                ExceptionUtils.INSTANCE.throwExceptionOrAlarm(params, new IllegalArgumentException(b41.r("渲染状态异常 onBindViewDispatcher invalidContainer ", params)));
            }
            if (isInvalidStatus) {
                ExceptionUtils.INSTANCE.throwExceptionOrAlarm(params, new IllegalArgumentException(b41.r("渲染状态异常 onBindViewDispatcher invalidStatus ", params)));
            }
            if (isInvalidGXRootView) {
                ExceptionUtils.INSTANCE.throwExceptionOrAlarm(params, new IllegalArgumentException(b41.r("渲染状态异常 onBindViewDispatcher invalidGXRootView ", params)));
            }
            onViewDestroyByReload(params);
            gaiaXContext = GaiaXContext.Companion.forceInitContext(params);
            Log log = Log.INSTANCE;
            if (log.isLog()) {
                log.trace(gaiaXContext, "onBindViewDispatcher", "forceInitContext");
            }
        }
        View rootView = gaiaXContext.getRootView();
        int typeStatus = gaiaXContext.getTypeStatus();
        if (typeStatus == 0 && rootView == null) {
            Log log2 = Log.INSTANCE;
            if (log2.isLog()) {
                log2.trace(gaiaXContext, "onBindViewDispatcher", "st = 状态1：创建UI");
            }
            onViewPrepareCreate(gaiaXContext);
        } else if ((2 == typeStatus || 4 == typeStatus) && rootView != null) {
            Log log3 = Log.INSTANCE;
            if (log3.isLog()) {
                log3.trace(gaiaXContext, "onBindViewDispatcher", "st = 状态2：重建UI");
            }
            onViewPrepareRefresh(gaiaXContext);
        } else if (1 == typeStatus && rootView == null) {
            Log log4 = Log.INSTANCE;
            if (log4.isLog()) {
                log4.trace(gaiaXContext, "onBindViewDispatcher", "st = 状态3：创建UI中");
            }
            onViewCreating(gaiaXContext);
        } else if (3 == typeStatus && rootView != null) {
            Log log5 = Log.INSTANCE;
            if (log5.isLog()) {
                log5.trace(gaiaXContext, "onBindViewDispatcher", "st = 状态4：更新UI中");
            }
            onViewRefreshing(gaiaXContext);
        } else {
            Log log6 = Log.INSTANCE;
            if (log6.isLog()) {
                log6.trace(gaiaXContext, "onBindViewDispatcher", "st = 状态5：异常");
            }
            throw new IllegalArgumentException("渲染状态异常 onBindViewDispatcher status = " + typeStatus + " rootView = " + rootView);
        }
    }

    private final void onPageInvisible(GaiaX.Params params) {
        GaiaXContext containerContext = GaiaXContext.Companion.getContainerContext(params);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.traceStack$default(log, containerContext, "onPageInvisible", null, 4, null);
        }
        if (containerContext == null) {
            return;
        }
        containerContext.setLifeStatus(2);
        GaiaXJSDelegate.INSTANCE.onHiddenComponent(containerContext);
        View rootView = containerContext.getRootView();
        if (rootView == null) {
            return;
        }
        GXTemplateEngine.Companion.a().t(rootView);
    }

    private final void onPageVisible(GaiaX.Params params) {
        GaiaXContext containerContext = GaiaXContext.Companion.getContainerContext(params);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.traceStack$default(log, containerContext, "onPageVisible", null, 4, null);
        }
        if (containerContext == null) {
            return;
        }
        containerContext.setLifeStatus(1);
        GaiaXJSDelegate.INSTANCE.onShowComponent(containerContext);
        View rootView = containerContext.getRootView();
        if (rootView == null) {
            return;
        }
        GXTemplateEngine.Companion.a().s(rootView);
    }

    private final void onViewCreateAsync(final GaiaXContext gaiaXContext) {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, gaiaXContext, "onViewCreateAsync", null, 4, null);
        }
        GaiaXMonitor.INSTANCE.onCreateA(gaiaXContext);
        gaiaXContext.setTypeStatus(1);
        gaiaXContext.workerTask(new Function0<wt2>() { // from class: com.youku.gaiax.impl.GaiaXImpl$onViewCreateAsync$1
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
                PropUtils propUtils = PropUtils.INSTANCE;
                if (propUtils.isTrace()) {
                    Trace.beginSection("GX onViewCreateAsync workerTask");
                }
                if (GaiaXContext.this.getParams().isReleased$GaiaX_Android()) {
                    ExceptionUtils.INSTANCE.throwParamsReleaseAlarm(GaiaXContext.this.getParams());
                    return;
                }
                Context context = GaiaXContext.this.getParams().getContext();
                if (context != null) {
                    GXTemplateEngine.C3347i c3347i = new GXTemplateEngine.C3347i(context, GaiaXContext.this.getParams().getTemplateBiz(), GaiaXContext.this.getParams().getTemplateId());
                    c3347i.g(GaiaXContext.this.getParams().getForceLocalTemplate());
                    final GXTemplateEngine.C3343f c3343f = new GXTemplateEngine.C3343f(GaiaXContext.this.getParams().getViewPort().b(), GaiaXContext.this.getParams().getViewPort().a());
                    JSONObject data = GaiaXContext.this.getParams().getData();
                    if (data == null) {
                        data = new JSONObject();
                    }
                    final GXTemplateEngine.C3346h c3346h = new GXTemplateEngine.C3346h(data);
                    GaiaXContext gaiaXContext2 = GaiaXContext.this;
                    c3346h.j(gaiaXContext2.getParams());
                    c3346h.g(gaiaXContext2.getGxDataListener());
                    c3346h.i(gaiaXContext2.getParams().getScrollPosition$GaiaX_Android());
                    c3346h.h(gaiaXContext2.getGxEventListener());
                    c3346h.k(gaiaXContext2.getGxTrackListener());
                    GXTemplateEngine.C3337a c3337a = GXTemplateEngine.Companion;
                    GXTemplateEngine.v(c3337a.a(), c3347i, c3343f, null, 4, null);
                    GaiaXMonitor gaiaXMonitor = GaiaXMonitor.INSTANCE;
                    gaiaXMonitor.onStep1A(GaiaXContext.this);
                    os0 e = c3337a.a().e(c3347i, c3343f, GaiaXContext.this.getParams().getGxExtendParams());
                    if (e != null) {
                        GaiaXContext.this.setGXTemplateContext(e);
                        gaiaXMonitor.onStep1B(GaiaXContext.this);
                        gaiaXMonitor.onStep2A(GaiaXContext.this);
                        final View f = c3337a.a().f(e);
                        if (f != null) {
                            f.setTag(GaiaXContext.this);
                            gaiaXMonitor.onStep2B(GaiaXContext.this);
                            gaiaXMonitor.onStep3A(GaiaXContext.this);
                            c3337a.a().b(f, c3346h, c3343f);
                            gaiaXMonitor.onStep3B(GaiaXContext.this);
                            if (propUtils.isTrace()) {
                                Trace.endSection();
                            }
                            final GaiaXContext gaiaXContext3 = GaiaXContext.this;
                            final GaiaXImpl gaiaXImpl = this;
                            gaiaXContext3.uiTask(new Function0<wt2>() { // from class: com.youku.gaiax.impl.GaiaXImpl$onViewCreateAsync$1.1
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
                                    PropUtils propUtils2 = PropUtils.INSTANCE;
                                    if (propUtils2.isTrace()) {
                                        Trace.beginSection("GX onViewCreateAsync uiTask");
                                    }
                                    GaiaXMonitor gaiaXMonitor2 = GaiaXMonitor.INSTANCE;
                                    gaiaXMonitor2.onStep4A(GaiaXContext.this);
                                    GXTemplateEngine.Companion.a().c(f, c3346h, c3343f);
                                    gaiaXMonitor2.onStep4B(GaiaXContext.this);
                                    gaiaXImpl.onViewCreateResultDispatcher(GaiaXContext.this, f);
                                    gaiaXMonitor2.onCreateBAsync(GaiaXContext.this);
                                    gaiaXMonitor2.onExpressionTimeUpLoad(GaiaXContext.this);
                                    GaiaXContext.this.hookTask();
                                    if (propUtils2.isTrace()) {
                                        Trace.endSection();
                                    }
                                }
                            });
                            return;
                        }
                        throw new IllegalArgumentException("GXView create fail");
                    }
                    throw new IllegalArgumentException("GXTemplateContext create fail");
                }
                throw new IllegalArgumentException("context null");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onViewCreateResultDispatcher(GaiaXContext gaiaXContext, View view) {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, gaiaXContext, "onViewCreateResultDispatcher", null, 4, null);
        }
        gaiaXContext.setRootView(view);
        gaiaXContext.setTypeStatus(2);
        gaiaXContext.setLifeStatus(4);
        View container = gaiaXContext.getParams().getContainer();
        ViewGroup viewGroup = container instanceof ViewGroup ? (ViewGroup) container : null;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        if (viewGroup != null) {
            viewGroup.addView(view);
        }
        GaiaXJSDelegate gaiaXJSDelegate = GaiaXJSDelegate.INSTANCE;
        gaiaXJSDelegate.registerComponent(gaiaXContext);
        gaiaXJSDelegate.onReadyComponent(gaiaXContext);
        int indexPosition$GaiaX_Android = gaiaXContext.getParams().getIndexPosition$GaiaX_Android();
        if (indexPosition$GaiaX_Android != -1) {
            fixContainerSize(viewGroup, view);
            GaiaX.IScrollItemStatusDelegate scrollItemStatusDelegate = gaiaXContext.getParams().getScrollItemStatusDelegate();
            if (scrollItemStatusDelegate != null) {
                scrollItemStatusDelegate.onViewInjected(gaiaXContext.getParams(), view, indexPosition$GaiaX_Android);
            }
        } else {
            GaiaX.IStatusDelegate statusDelegate = gaiaXContext.getParams().getStatusDelegate();
            if (statusDelegate != null) {
                statusDelegate.onViewInjected(gaiaXContext.getParams(), view);
            }
        }
        if (viewGroup == null) {
            return;
        }
        viewGroup.setMinimumHeight(0);
    }

    private final void onViewCreateSync(GaiaXContext gaiaXContext) {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, gaiaXContext, "onViewCreateSync", null, 4, null);
        }
        GaiaXMonitor gaiaXMonitor = GaiaXMonitor.INSTANCE;
        gaiaXMonitor.onCreateA(gaiaXContext);
        Context context = gaiaXContext.getParams().getContext();
        if (context != null) {
            gaiaXContext.setTypeStatus(1);
            GXTemplateEngine.C3347i c3347i = new GXTemplateEngine.C3347i(context, gaiaXContext.getParams().getTemplateBiz(), gaiaXContext.getParams().getTemplateId());
            c3347i.g(gaiaXContext.getParams().getForceLocalTemplate());
            GXTemplateEngine.C3343f c3343f = new GXTemplateEngine.C3343f(gaiaXContext.getParams().getViewPort().b(), gaiaXContext.getParams().getViewPort().a());
            JSONObject data = gaiaXContext.getParams().getData();
            if (data == null) {
                data = new JSONObject();
            }
            GXTemplateEngine.C3346h c3346h = new GXTemplateEngine.C3346h(data);
            c3346h.j(gaiaXContext.getParams());
            c3346h.g(gaiaXContext.getGxDataListener());
            c3346h.i(gaiaXContext.getParams().getScrollPosition$GaiaX_Android());
            c3346h.h(gaiaXContext.getGxEventListener());
            c3346h.k(gaiaXContext.getGxTrackListener());
            GXTemplateEngine.C3337a c3337a = GXTemplateEngine.Companion;
            GXTemplateEngine.v(c3337a.a(), c3347i, c3343f, null, 4, null);
            gaiaXMonitor.onStep1A(gaiaXContext);
            os0 e = c3337a.a().e(c3347i, c3343f, gaiaXContext.getParams().getGxExtendParams());
            if (e != null) {
                gaiaXContext.setGXTemplateContext(e);
                gaiaXMonitor.onStep1B(gaiaXContext);
                gaiaXMonitor.onStep2A(gaiaXContext);
                View f = c3337a.a().f(e);
                if (f != null) {
                    f.setTag(gaiaXContext);
                    gaiaXMonitor.onStep2B(gaiaXContext);
                    gaiaXMonitor.onStep3A(gaiaXContext);
                    c3337a.a().b(f, c3346h, c3343f);
                    gaiaXMonitor.onStep3B(gaiaXContext);
                    gaiaXMonitor.onStep4A(gaiaXContext);
                    c3337a.a().c(f, c3346h, c3343f);
                    gaiaXMonitor.onStep4B(gaiaXContext);
                    onViewCreateResultDispatcher(gaiaXContext, f);
                    gaiaXMonitor.onCreateBSync(gaiaXContext);
                    gaiaXMonitor.onExpressionTimeUpLoad(gaiaXContext);
                    return;
                }
                throw new IllegalArgumentException("GXView create fail");
            }
            throw new IllegalArgumentException("GXTemplateContext create fail");
        }
        throw new IllegalArgumentException("context null");
    }

    private final void onViewCreating(final GaiaXContext gaiaXContext) {
        int i = WhenMappings.$EnumSwitchMapping$0[gaiaXContext.getParams().getMode().ordinal()];
        if (i == 1) {
            onViewPrepareRefresh(gaiaXContext);
        } else if (i != 2) {
        } else {
            gaiaXContext.setHook$GaiaX_Android(new Runnable() { // from class: com.youku.gaiax.impl.GaiaXImpl$onViewCreating$1
                @Override // java.lang.Runnable
                public final void run() {
                    GaiaXContext.this.setHook$GaiaX_Android(null);
                    this.onViewPrepareRefresh(GaiaXContext.this);
                }
            });
        }
    }

    private final void onViewDestroy(GaiaX.Params params) {
        GaiaXContext containerContext = GaiaXContext.Companion.getContainerContext(params);
        if (containerContext == null) {
            return;
        }
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, containerContext, "onViewDestroy", null, 4, null);
        }
        GaiaXJSDelegate gaiaXJSDelegate = GaiaXJSDelegate.INSTANCE;
        gaiaXJSDelegate.onDestroyComponent(containerContext);
        gaiaXJSDelegate.unregisterComponent(containerContext);
        containerContext.releaseCanAsync();
    }

    private final void onViewDestroyByReload(GaiaX.Params params) {
        GaiaXContext containerContext = GaiaXContext.Companion.getContainerContext(params);
        if (containerContext == null) {
            return;
        }
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, containerContext, "onViewDestroyByReload", null, 4, null);
        }
        GaiaXJSDelegate gaiaXJSDelegate = GaiaXJSDelegate.INSTANCE;
        gaiaXJSDelegate.onDestroyComponent(containerContext);
        gaiaXJSDelegate.unregisterComponent(containerContext);
        containerContext.releaseCanAsync();
    }

    private final void onViewInvisible(GaiaX.Params params) {
        GaiaXContext containerContext = GaiaXContext.Companion.getContainerContext(params);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.traceStack$default(log, containerContext, "onViewInvisible", null, 4, null);
        }
        if (containerContext == null) {
            return;
        }
        containerContext.setLifeStatus(2);
        GaiaXJSDelegate.INSTANCE.onHiddenComponent(containerContext);
        View rootView = containerContext.getRootView();
        if (rootView == null) {
            return;
        }
        GXTemplateEngine.Companion.a().t(rootView);
    }

    private final void onViewPrepareCreate(GaiaXContext gaiaXContext) {
        int i = WhenMappings.$EnumSwitchMapping$0[gaiaXContext.getParams().getMode().ordinal()];
        if (i == 1) {
            PropUtils propUtils = PropUtils.INSTANCE;
            if (propUtils.isTrace()) {
                Trace.beginSection("GX onViewCreateSync");
            }
            onViewCreateSync(gaiaXContext);
            if (propUtils.isTrace()) {
                Trace.endSection();
            }
        } else if (i != 2) {
        } else {
            PropUtils propUtils2 = PropUtils.INSTANCE;
            if (propUtils2.isTrace()) {
                Trace.beginSection("GX onViewCreateAsync");
            }
            onViewCreateAsync(gaiaXContext);
            if (propUtils2.isTrace()) {
                Trace.endSection();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onViewPrepareRefresh(GaiaXContext gaiaXContext) {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, gaiaXContext, "onViewPrepareRefresh", null, 4, null);
        }
        if (gaiaXContext.getJsStatus() == 10 || gaiaXContext.isChanged()) {
            gaiaXContext.setJsStatus(0);
            onViewReload(gaiaXContext.getParams());
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[gaiaXContext.getParams().getMode().ordinal()];
        if (i == 1) {
            PropUtils propUtils = PropUtils.INSTANCE;
            if (propUtils.isTrace()) {
                Trace.beginSection("GX onViewRefreshSync");
            }
            onViewRefreshSync(gaiaXContext);
            if (propUtils.isTrace()) {
                Trace.endSection();
            }
        } else if (i != 2) {
        } else {
            PropUtils propUtils2 = PropUtils.INSTANCE;
            if (propUtils2.isTrace()) {
                Trace.beginSection("GX onViewRefreshAsync");
            }
            onViewRefreshAsync(gaiaXContext);
            if (propUtils2.isTrace()) {
                Trace.endSection();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onViewRefreshAsync(final GaiaXContext gaiaXContext) {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, gaiaXContext, "onViewRefreshAsync", null, 4, null);
        }
        GaiaXMonitor.INSTANCE.onRefreshA(gaiaXContext);
        gaiaXContext.setTypeStatus(3);
        gaiaXContext.workerTask(new Function0<wt2>() { // from class: com.youku.gaiax.impl.GaiaXImpl$onViewRefreshAsync$1
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
                PropUtils propUtils = PropUtils.INSTANCE;
                if (propUtils.isTrace()) {
                    Trace.beginSection("GX onViewRefreshAsync workerTask");
                }
                final View rootView = GaiaXContext.this.getRootView();
                if (rootView != null) {
                    final GXTemplateEngine.C3343f c3343f = new GXTemplateEngine.C3343f(GaiaXContext.this.getParams().getViewPort().b(), GaiaXContext.this.getParams().getViewPort().a());
                    JSONObject data = GaiaXContext.this.getParams().getData();
                    if (data == null) {
                        data = new JSONObject();
                    }
                    final GXTemplateEngine.C3346h c3346h = new GXTemplateEngine.C3346h(data);
                    GaiaXContext gaiaXContext2 = GaiaXContext.this;
                    c3346h.j(gaiaXContext2.getParams());
                    c3346h.g(gaiaXContext2.getGxDataListener());
                    c3346h.i(gaiaXContext2.getParams().getScrollPosition$GaiaX_Android());
                    c3346h.h(gaiaXContext2.getGxEventListener());
                    c3346h.k(gaiaXContext2.getGxTrackListener());
                    GaiaXMonitor gaiaXMonitor = GaiaXMonitor.INSTANCE;
                    gaiaXMonitor.onStep3A(GaiaXContext.this);
                    GXTemplateEngine.Companion.a().b(rootView, c3346h, c3343f);
                    gaiaXMonitor.onStep3B(GaiaXContext.this);
                    if (propUtils.isTrace()) {
                        Trace.endSection();
                    }
                    final GaiaXContext gaiaXContext3 = GaiaXContext.this;
                    final GaiaXImpl gaiaXImpl = this;
                    gaiaXContext3.uiTask(new Function0<wt2>() { // from class: com.youku.gaiax.impl.GaiaXImpl$onViewRefreshAsync$1.1
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
                            PropUtils propUtils2 = PropUtils.INSTANCE;
                            if (propUtils2.isTrace()) {
                                Trace.beginSection("GX onViewRefreshAsync uiTask");
                            }
                            GaiaXMonitor gaiaXMonitor2 = GaiaXMonitor.INSTANCE;
                            gaiaXMonitor2.onStep4A(GaiaXContext.this);
                            GXTemplateEngine.Companion.a().c(rootView, c3346h, c3343f);
                            gaiaXMonitor2.onStep4B(GaiaXContext.this);
                            gaiaXImpl.onViewRefreshResultDispatcher(GaiaXContext.this);
                            gaiaXMonitor2.onRefreshBAsync(GaiaXContext.this);
                            gaiaXMonitor2.onExpressionTimeUpLoad(GaiaXContext.this);
                            GaiaXContext.this.hookTask();
                            if (propUtils2.isTrace()) {
                                Trace.endSection();
                            }
                        }
                    });
                    return;
                }
                throw new IllegalArgumentException("GXRootView null");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onViewRefreshResultDispatcher(GaiaXContext gaiaXContext) {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, gaiaXContext, "onViewRefreshResultDispatcher", null, 4, null);
        }
        View rootView = gaiaXContext.getRootView();
        if (rootView != null) {
            gaiaXContext.setTypeStatus(4);
            GaiaXJSDelegate.INSTANCE.onReuseComponent(gaiaXContext);
            View container = gaiaXContext.getParams().getContainer();
            ViewGroup viewGroup = container instanceof ViewGroup ? (ViewGroup) container : null;
            int indexPosition$GaiaX_Android = gaiaXContext.getParams().getIndexPosition$GaiaX_Android();
            if (indexPosition$GaiaX_Android != -1) {
                fixContainerSize(viewGroup, rootView);
                GaiaX.IScrollItemStatusDelegate scrollItemStatusDelegate = gaiaXContext.getParams().getScrollItemStatusDelegate();
                if (scrollItemStatusDelegate == null) {
                    return;
                }
                scrollItemStatusDelegate.onViewUpdated(gaiaXContext.getParams(), rootView, indexPosition$GaiaX_Android);
                return;
            }
            GaiaX.IStatusDelegate statusDelegate = gaiaXContext.getParams().getStatusDelegate();
            if (statusDelegate == null) {
                return;
            }
            statusDelegate.onViewUpdated(gaiaXContext.getParams(), rootView);
            return;
        }
        throw new IllegalArgumentException(b41.r("rootView null, gaiaXContext = ", gaiaXContext));
    }

    private final void onViewRefreshSync(GaiaXContext gaiaXContext) {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, gaiaXContext, "onViewRefreshSync", null, 4, null);
        }
        GaiaXMonitor gaiaXMonitor = GaiaXMonitor.INSTANCE;
        gaiaXMonitor.onRefreshA(gaiaXContext);
        gaiaXContext.setTypeStatus(3);
        View rootView = gaiaXContext.getRootView();
        if (rootView != null) {
            GXTemplateEngine.C3343f c3343f = new GXTemplateEngine.C3343f(gaiaXContext.getParams().getViewPort().b(), gaiaXContext.getParams().getViewPort().a());
            JSONObject data = gaiaXContext.getParams().getData();
            if (data == null) {
                data = new JSONObject();
            }
            GXTemplateEngine.C3346h c3346h = new GXTemplateEngine.C3346h(data);
            c3346h.j(gaiaXContext.getParams());
            c3346h.g(gaiaXContext.getGxDataListener());
            c3346h.i(gaiaXContext.getParams().getScrollPosition$GaiaX_Android());
            c3346h.h(gaiaXContext.getGxEventListener());
            c3346h.k(gaiaXContext.getGxTrackListener());
            gaiaXMonitor.onStep3A(gaiaXContext);
            GXTemplateEngine.C3337a c3337a = GXTemplateEngine.Companion;
            c3337a.a().b(rootView, c3346h, c3343f);
            gaiaXMonitor.onStep3B(gaiaXContext);
            gaiaXMonitor.onStep4A(gaiaXContext);
            c3337a.a().c(rootView, c3346h, c3343f);
            gaiaXMonitor.onStep4B(gaiaXContext);
            onViewRefreshResultDispatcher(gaiaXContext);
            gaiaXMonitor.onRefreshBSync(gaiaXContext);
            gaiaXMonitor.onExpressionTimeUpLoad(gaiaXContext);
            return;
        }
        throw new IllegalArgumentException(b41.r("rootView null, gaiaXContext = ", gaiaXContext));
    }

    private final void onViewRefreshing(final GaiaXContext gaiaXContext) {
        int i = WhenMappings.$EnumSwitchMapping$0[gaiaXContext.getParams().getMode().ordinal()];
        if (i == 1) {
            onViewRefreshSync(gaiaXContext);
        } else if (i != 2) {
        } else {
            if (gaiaXContext.getHook$GaiaX_Android() != null) {
                Log log = Log.INSTANCE;
                if (log.isLog()) {
                    log.trace(gaiaXContext, "onViewRefreshing", "st = drop hook");
                }
            }
            gaiaXContext.setHook$GaiaX_Android(new Runnable() { // from class: com.youku.gaiax.impl.GaiaXImpl$onViewRefreshing$1
                @Override // java.lang.Runnable
                public final void run() {
                    GaiaXContext.this.setHook$GaiaX_Android(null);
                    this.onViewRefreshAsync(GaiaXContext.this);
                }
            });
        }
    }

    private final void onViewReload(GaiaX.Params params) {
        onViewInvisible(params);
        GaiaXContext initContext = GaiaXContext.Companion.initContext(params);
        initContext.setTypeStatus(5);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, initContext, "onViewReload", null, 4, null);
        }
        onBindViewDispatcher(initContext, params);
    }

    private final void onViewVisible(GaiaX.Params params) {
        GaiaXContext containerContext = GaiaXContext.Companion.getContainerContext(params);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.traceStack$default(log, containerContext, "onViewVisible", null, 4, null);
        }
        if (containerContext == null) {
            return;
        }
        containerContext.setLifeStatus(1);
        GaiaXJSDelegate.INSTANCE.onShowComponent(containerContext);
        View rootView = containerContext.getRootView();
        if (rootView == null) {
            return;
        }
        GXTemplateEngine.Companion.a().s(rootView);
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void bindView(@NotNull GaiaX.Params params) {
        b41.i(params, "params");
        try {
            if (params.isReleased$GaiaX_Android()) {
                ExceptionUtils.INSTANCE.throwParamsReleaseAlarm(params);
                return;
            }
            PropUtils propUtils = PropUtils.INSTANCE;
            if (propUtils.isTrace()) {
                Trace.beginSection("GX bindView");
            }
            GaiaXContext initContext = GaiaXContext.Companion.initContext(params);
            Log log = Log.INSTANCE;
            if (log.isLog()) {
                Log.traceStack$default(log, initContext, "bindView", null, 4, null);
            }
            onBindViewDispatcher(initContext, params);
            if (propUtils.isTrace()) {
                Trace.endSection();
            }
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(params, e);
        }
    }

    @Override // com.youku.gaiax.IGaiaXApi
    @NotNull
    public IExperiment experiment() {
        if (this.experiment == null) {
            this.experiment = new GaiaXExperimentApiImpl();
        }
        GaiaXExperimentApiImpl gaiaXExperimentApiImpl = this.experiment;
        if (gaiaXExperimentApiImpl != null) {
            return gaiaXExperimentApiImpl;
        }
        throw new IllegalArgumentException("GaiaXExperimentApiImpl not exist");
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void invisiblePage(@NotNull GaiaX.Params params) {
        b41.i(params, "params");
        try {
            onPageInvisible(params);
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(params, e);
        }
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void invisibleView(@NotNull GaiaX.Params params) {
        b41.i(params, "params");
        try {
            onViewInvisible(params);
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(params, e);
        }
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void reloadView(@NotNull GaiaX.Params params) {
        b41.i(params, "params");
        try {
            GaiaXContext containerContext = GaiaXContext.Companion.getContainerContext(params);
            if (containerContext == null) {
                return;
            }
            if (containerContext.getLifeStatus() == 1 || containerContext.getLifeStatus() == 4) {
                onViewReload(params);
            }
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(params, e);
        }
    }

    @Override // com.youku.gaiax.IGaiaXApi
    @NotNull
    public IStable stable() {
        if (this.stable == null) {
            this.stable = new GaiaXStableApiImpl();
        }
        GaiaXStableApiImpl gaiaXStableApiImpl = this.stable;
        if (gaiaXStableApiImpl != null) {
            return gaiaXStableApiImpl;
        }
        throw new IllegalArgumentException("GaiaXStableApiImpl not exist");
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void unbindView(@NotNull GaiaX.Params params) {
        b41.i(params, "params");
        try {
            onViewDestroy(params);
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(params, e);
        }
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void visiblePage(@NotNull GaiaX.Params params) {
        b41.i(params, "params");
        try {
            onPageVisible(params);
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(params, e);
        }
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void visibleView(@NotNull GaiaX.Params params) {
        b41.i(params, "params");
        try {
            onViewVisible(params);
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(params, e);
        }
    }
}
