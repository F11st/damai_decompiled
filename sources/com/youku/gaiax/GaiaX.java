package com.youku.gaiax;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.DiffUtil;
import com.ali.user.open.core.util.ParamsConstants;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.view.basic.GXView;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.taobao.weex.WXGlobalEventReceiver;
import com.taobao.weex.common.Constants;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.media.MessageID;
import com.youku.gaiax.api.context.IContextParams;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.api.data.PipelineParams;
import com.youku.gaiax.api.data.TrackParams;
import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.api.proxy.IProxyViews;
import com.youku.gaiax.common.utils.Log;
import com.youku.gaiax.common.utils.ScreenUtils;
import com.youku.gaiax.impl.GaiaXImpl;
import com.youku.gaiax.impl.GaiaXProxy;
import com.youku.gaiax.impl.register.GXExtensionColor;
import com.youku.gaiax.impl.register.GXExtensionContainerDataUpdate;
import com.youku.gaiax.impl.register.GXExtensionContainerItemBind;
import com.youku.gaiax.impl.register.GXExtensionDataBinding;
import com.youku.gaiax.impl.register.GXExtensionDynamicProperty;
import com.youku.gaiax.impl.register.GXExtensionException;
import com.youku.gaiax.impl.register.GXExtensionExpression;
import com.youku.gaiax.impl.register.GXExtensionGrid;
import com.youku.gaiax.impl.register.GXExtensionLottieAnimation;
import com.youku.gaiax.impl.register.GXExtensionNodeEvent;
import com.youku.gaiax.impl.register.GXExtensionScroll;
import com.youku.gaiax.impl.register.GXExtensionSize;
import com.youku.gaiax.impl.register.GXExtensionStaticProperty;
import com.youku.gaiax.impl.register.GXExtensionTemplateAssetsSource;
import com.youku.gaiax.impl.register.GXExtensionTemplateInfoSource;
import com.youku.gaiax.impl.register.GXExtensionTemplateRealTimeSource;
import com.youku.gaiax.impl.register.GXExtensionTemplateRemoteSource;
import com.youku.gaiax.impl.register.remote.GaiaXRemoteSourceUtils;
import com.youku.gaiax.impl.utils.GaiaXUtils;
import com.youku.gaiax.impl.utils.PropUtils;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C8177b;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.ld2;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u00142\u00020\u0001:\u000e\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !B\u0011\b\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0016\u0010\u0010\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Lcom/youku/gaiax/GaiaX;", "Lcom/youku/gaiax/IGaiaXApi;", "Lcom/youku/gaiax/GaiaX$Params;", "params", "Ltb/wt2;", "reloadView", "bindView", "unbindView", "visibleView", "invisibleView", "visiblePage", "invisiblePage", "Lcom/youku/gaiax/IExperiment;", "experiment", "Lcom/youku/gaiax/IStable;", Constants.Name.STABLE, "impl", "Lcom/youku/gaiax/IGaiaXApi;", "<init>", "(Lcom/youku/gaiax/IGaiaXApi;)V", "Companion", "IAnimationDelegate", "IDataPipeline5", "IErrorDelegate", "IEventDelegate", "IHostMessage", "IRouterDelegate2", "IRule", "IScrollDataDiffCallBack", "IScrollDelegate", "IScrollItemStatusDelegate", "IStatusDelegate", "ITrackDelegate3", "Params", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaX implements IGaiaXApi {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "[GaiaX]";
    @NotNull
    private static final Lazy<GaiaX> instance$delegate;
    @NotNull
    private final IGaiaXApi impl;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\f\u001a\u00020\u00078F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/youku/gaiax/GaiaX$Companion;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Ltb/wt2;", "injectImpl", UCCore.LEGACY_EVENT_INIT, "Lcom/youku/gaiax/GaiaX;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/gaiax/GaiaX;", "instance", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        private final void injectImpl(Context context) {
            Log log = Log.INSTANCE;
            if (log.isLaunchLog()) {
                log.d("[GaiaX]", "GaiaX初始化逻辑 - 开始");
                log.d("[GaiaX]", b41.r("GaiaX初始化逻辑 - 应用上下文 = ", context));
            }
            if (log.isLaunchLog()) {
                log.d("[GaiaX]", "GaiaX初始化逻辑 - GaiaXProxy - start");
            }
            GaiaXProxy.Companion companion = GaiaXProxy.Companion;
            companion.getInstance().initModules();
            if (log.isLaunchLog()) {
                log.d("[GaiaX]", "GaiaX初始化逻辑 - GaiaXProxy - end");
            }
            if (log.isLaunchLog()) {
                log.d("[GaiaX]", "GaiaX初始化逻辑 - GXTemplateEngine - start");
            }
            GXTemplateEngine.Companion.a().m(context);
            GXRegisterCenter.C3333a c3333a = GXRegisterCenter.Companion;
            GXRegisterCenter D = c3333a.a().v(new GXExtensionDataBinding()).y(GXExtensionExpression.Companion.getInstance()).r(new GXExtensionColor()).D(new GXExtensionSize());
            GXRegisterCenter.C3334b c3334b = new GXRegisterCenter.C3334b();
            c3334b.i(true);
            c3334b.j(true);
            c3334b.n(true);
            c3334b.p(true);
            c3334b.m(true);
            c3334b.o(true);
            c3334b.k(true);
            c3334b.l(true);
            wt2 wt2Var = wt2.INSTANCE;
            D.s(c3334b).w(new GXExtensionDynamicProperty()).E(new GXExtensionStaticProperty()).C(new GXExtensionScroll()).z(new GXExtensionGrid()).B(new GXExtensionNodeEvent()).t(new GXExtensionContainerDataUpdate()).u(new GXExtensionContainerItemBind()).F(GXExtensionTemplateInfoSource.Companion.getInstance(), 0).G(GXExtensionTemplateAssetsSource.Companion.assetsInstance(), 1).G(GXExtensionTemplateRemoteSource.Companion.remoteInstance(), 2).G(GXExtensionTemplateRealTimeSource.Companion.getInstance(), 15).A(new GXExtensionLottieAnimation()).x(new GXExtensionException());
            c3333a.a().H("image", new Function1<Context, View>() { // from class: com.youku.gaiax.GaiaX$Companion$injectImpl$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final View invoke(@NotNull Context context2) {
                    b41.i(context2, AdvanceSetting.NETWORK_TYPE);
                    IProxyViews views = GaiaXProxy.Companion.getInstance().getViews();
                    View createView = views == null ? null : views.createView("image", context2);
                    return createView == null ? new GXView(context2) : createView;
                }
            });
            c3333a.a().H("lottie", new Function1<Context, View>() { // from class: com.youku.gaiax.GaiaX$Companion$injectImpl$3
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final View invoke(@NotNull Context context2) {
                    b41.i(context2, AdvanceSetting.NETWORK_TYPE);
                    IProxyViews views = GaiaXProxy.Companion.getInstance().getViews();
                    View createView = views == null ? null : views.createView("lottie", context2);
                    return createView == null ? new GXView(context2) : createView;
                }
            });
            if (log.isLaunchLog()) {
                log.d("[GaiaX]", "GaiaX初始化逻辑 - GXTemplateEngine - end");
            }
            if (log.isLaunchLog()) {
                IProxyApp app2 = companion.getInstance().getApp();
                log.e("[GaiaX]", b41.r("GaiaX初始化逻辑 - 基础信息[UTDID] = ", app2 == null ? null : app2.getUtdid()));
                GaiaXRemoteSourceUtils gaiaXRemoteSourceUtils = GaiaXRemoteSourceUtils.INSTANCE;
                log.e("[GaiaX]", b41.r("GaiaX初始化逻辑 - 基础信息[环境] = ", gaiaXRemoteSourceUtils.getOnlineStatusText()));
                log.e("[GaiaX]", b41.r("GaiaX初始化逻辑 - 基础信息[环境-转义]= ", gaiaXRemoteSourceUtils.getOnlineStatus()));
                IProxyApp app3 = companion.getInstance().getApp();
                log.e("[GaiaX]", b41.r("GaiaX初始化逻辑 - 基础信息[应用版本] = ", app3 != null ? app3.getAppVersionName() : null));
                log.e("[GaiaX]", b41.r("GaiaX初始化逻辑 - 基础信息[应用版本-转义] = ", Long.valueOf(gaiaXRemoteSourceUtils.getAppVersion())));
                log.e("[GaiaX]", b41.r("GaiaX初始化逻辑 - 基础信息[是否正式版] = ", Boolean.valueOf(GaiaXUtils.INSTANCE.isAppPublishVersion())));
                PropUtils propUtils = PropUtils.INSTANCE;
                log.e("[GaiaX]", b41.r("GaiaX初始化逻辑 - 开关状态[日志] = ", Boolean.valueOf(propUtils.isLog())));
                log.e("[GaiaX]", b41.r("GaiaX初始化逻辑 - 开关状态[远程模板] = ", Boolean.valueOf(propUtils.m1260isRemote())));
                log.e("[GaiaX]", b41.r("GaiaX初始化逻辑 - 开关状态[JSLog] = ", Boolean.valueOf(propUtils.isJSLog())));
            }
            if (log.isLaunchLog()) {
                log.d("[GaiaX]", "GaiaX初始化逻辑 - 结束");
            }
        }

        @NotNull
        public final GaiaX getInstance() {
            return (GaiaX) GaiaX.instance$delegate.getValue();
        }

        public final void init(@NotNull Context context) {
            b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
            PropUtils.INSTANCE.init(context);
            Log log = Log.INSTANCE;
            if (log.isLaunchLog()) {
                log.d("[GaiaX]", b41.r("GaiaX初始化逻辑 - init ", context));
            }
            injectImpl(context);
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/GaiaX$IAnimationDelegate;", "", "", "targetId", "Landroid/view/View;", "targetView", "Lcom/alibaba/fastjson/JSONObject;", "animationData", "Ltb/wt2;", "onAnimationStart", "onAnimationFinish", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface IAnimationDelegate {
        void onAnimationFinish(@NotNull String str, @NotNull View view, @NotNull JSONObject jSONObject);

        void onAnimationStart(@NotNull String str, @NotNull View view, @NotNull JSONObject jSONObject);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0005"}, d2 = {"Lcom/youku/gaiax/GaiaX$IDataPipeline5;", "", "Lcom/youku/gaiax/api/data/PipelineParams;", "pipelineParams", "process", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface IDataPipeline5 {
        @Nullable
        Object process(@NotNull PipelineParams pipelineParams);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/youku/gaiax/GaiaX$IErrorDelegate;", "", "", "msg", "Ltb/wt2;", MessageID.onError, "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface IErrorDelegate {

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class DefaultImpls {
            public static void onError(@NotNull IErrorDelegate iErrorDelegate, @NotNull String str) {
                b41.i(iErrorDelegate, "this");
                b41.i(str, "msg");
            }

            public static /* synthetic */ void onError$default(IErrorDelegate iErrorDelegate, String str, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onError");
                }
                if ((i & 1) != 0) {
                    str = "";
                }
                iErrorDelegate.onError(str);
            }
        }

        void onError(@NotNull String str);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/youku/gaiax/GaiaX$IEventDelegate;", "", "Lcom/youku/gaiax/api/data/EventParams;", WXGlobalEventReceiver.EVENT_PARAMS, "Ltb/wt2;", "onEvent", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface IEventDelegate {
        void onEvent(@NotNull EventParams eventParams);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/youku/gaiax/GaiaX$IHostMessage;", "", "", "type", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "onMessage", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface IHostMessage {
        boolean onMessage(@NotNull String str, @NotNull JSONObject jSONObject);
    }

    /* compiled from: Taobao */
    @Deprecated(message = "")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&¨\u0006\u000e"}, d2 = {"Lcom/youku/gaiax/GaiaX$IRouterDelegate2;", "", "Landroid/view/View;", "targetView", "", "targetViewId", "", "targetPosition", "Lcom/alibaba/fastjson/JSONObject;", "targetData", "Lcom/youku/gaiax/GaiaX$Params;", "targetParams", "Ltb/wt2;", "onAction", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface IRouterDelegate2 {
        void onAction(@NotNull View view, @NotNull String str, int i, @NotNull JSONObject jSONObject, @NotNull Params params);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/youku/gaiax/GaiaX$IRule;", "", "", "targetViewId", "Landroid/view/View;", "targetView", "", "isRule", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface IRule {
        boolean isRule(@NotNull String str, @NotNull View view);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¨\u0006\t"}, d2 = {"Lcom/youku/gaiax/GaiaX$IScrollDataDiffCallBack;", "", "", "templateId", "Lcom/alibaba/fastjson/JSONArray;", "oldDatas", "newDatas", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "doDiff", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface IScrollDataDiffCallBack {
        @Nullable
        DiffUtil.Callback doDiff(@NotNull String str, @NotNull JSONArray jSONArray, @NotNull JSONArray jSONArray2);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H&¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/GaiaX$IScrollDelegate;", "", "Landroid/view/View;", "view", "", "newState", "Ltb/wt2;", GXTemplateEngine.C3344g.TYPE_ON_SCROLL_STATE_CHANGED, "dx", Constants.Name.DISTANCE_Y, GXTemplateEngine.C3344g.TYPE_ON_SCROLLED, "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface IScrollDelegate {
        void onScrollStateChanged(@NotNull View view, int i);

        void onScrolled(@NotNull View view, int i, int i2);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/GaiaX$IScrollItemStatusDelegate;", "", "Lcom/youku/gaiax/GaiaX$Params;", "params", "Landroid/view/View;", "resultView", "", "position", "Ltb/wt2;", "onViewInjected", "onViewUpdated", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface IScrollItemStatusDelegate {
        void onViewInjected(@NotNull Params params, @NotNull View view, int i);

        void onViewUpdated(@NotNull Params params, @NotNull View view, int i);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/youku/gaiax/GaiaX$IStatusDelegate;", "", "Lcom/youku/gaiax/GaiaX$Params;", "params", "Landroid/view/View;", "resultView", "Ltb/wt2;", "onViewInjected", "onViewUpdated", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface IStatusDelegate {

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class DefaultImpls {
            public static void onViewInjected(@NotNull IStatusDelegate iStatusDelegate, @NotNull Params params, @NotNull View view) {
                b41.i(iStatusDelegate, "this");
                b41.i(params, "params");
                b41.i(view, "resultView");
            }

            public static void onViewUpdated(@NotNull IStatusDelegate iStatusDelegate, @NotNull Params params, @NotNull View view) {
                b41.i(iStatusDelegate, "this");
                b41.i(params, "params");
                b41.i(view, "resultView");
            }
        }

        void onViewInjected(@NotNull Params params, @NotNull View view);

        void onViewUpdated(@NotNull Params params, @NotNull View view);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/youku/gaiax/GaiaX$ITrackDelegate3;", "", "Lcom/youku/gaiax/api/data/TrackParams;", "trackParams", "Ltb/wt2;", "onTrack", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface ITrackDelegate3 {
        void onTrack(@NotNull TrackParams trackParams);
    }

    static {
        Lazy<GaiaX> b;
        b = C8177b.b(new Function0<GaiaX>() { // from class: com.youku.gaiax.GaiaX$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GaiaX invoke() {
                return new GaiaX(new GaiaXImpl(), null);
            }
        });
        instance$delegate = b;
    }

    private GaiaX(IGaiaXApi iGaiaXApi) {
        this.impl = iGaiaXApi;
    }

    public /* synthetic */ GaiaX(IGaiaXApi iGaiaXApi, k50 k50Var) {
        this(iGaiaXApi);
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void bindView(@NotNull Params params) {
        b41.i(params, "params");
        this.impl.bindView(params);
    }

    @Override // com.youku.gaiax.IGaiaXApi
    @Nullable
    public IExperiment experiment() {
        return this.impl.experiment();
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void invisiblePage(@NotNull Params params) {
        b41.i(params, "params");
        this.impl.invisiblePage(params);
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void invisibleView(@NotNull Params params) {
        b41.i(params, "params");
        this.impl.invisibleView(params);
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void reloadView(@NotNull Params params) {
        b41.i(params, "params");
        this.impl.reloadView(params);
    }

    @Override // com.youku.gaiax.IGaiaXApi
    @Nullable
    public IStable stable() {
        return this.impl.stable();
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void unbindView(@NotNull Params params) {
        b41.i(params, "params");
        this.impl.unbindView(params);
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void visiblePage(@NotNull Params params) {
        b41.i(params, "params");
        this.impl.visiblePage(params);
    }

    @Override // com.youku.gaiax.IGaiaXApi
    public void visibleView(@NotNull Params params) {
        b41.i(params, "params");
        this.impl.visibleView(params);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u0000 ¯\u00012\u00020\u0001:\u0004°\u0001¯\u0001BX\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\u0013\b\u0002\u0010§\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010¦\u00010¥\u0001¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u00106\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R\"\u0010>\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u00106\u001a\u0004\b?\u00108\"\u0004\b@\u0010:R$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010I\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010P\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR*\u0010W\u001a\u0004\u0018\u00010V8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bW\u0010X\u0012\u0004\b]\u0010^\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R$\u0010`\u001a\u0004\u0018\u00010_8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR$\u0010g\u001a\u0004\u0018\u00010f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u0010n\u001a\u0004\u0018\u00010m8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR$\u0010u\u001a\u0004\u0018\u00010t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR&\u0010|\u001a\u0004\u0018\u00010{8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R,\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R*\u0010\u008a\u0001\u001a\u00030\u0089\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R,\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u008b\u0001\u001a\u0006\b\u0091\u0001\u0010\u008d\u0001\"\u0006\b\u0092\u0001\u0010\u008f\u0001R&\u0010\u0093\u0001\u001a\u00020&8\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0005\b\u0093\u0001\u0010(\u001a\u0005\b\u0094\u0001\u0010*\"\u0005\b\u0095\u0001\u0010,R&\u0010\u0096\u0001\u001a\u00020&8\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0005\b\u0096\u0001\u0010(\u001a\u0005\b\u0097\u0001\u0010*\"\u0005\b\u0098\u0001\u0010,R&\u0010\u0099\u0001\u001a\u0002048\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0005\b\u0099\u0001\u00106\u001a\u0005\b\u009a\u0001\u00108\"\u0005\b\u009b\u0001\u0010:R8\u0010\u009f\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u009d\u0001\u0012\u0005\u0012\u00030\u009e\u00010\u009c\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R3\u0010§\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010¦\u00010¥\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b§\u0001\u0010¨\u0001\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001¨\u0006±\u0001"}, d2 = {"Lcom/youku/gaiax/GaiaX$Params;", "Lcom/youku/gaiax/api/context/IContextParams;", "Ltb/wt2;", "release", "", "templateId", "Ljava/lang/String;", "getTemplateId", "()Ljava/lang/String;", "setTemplateId", "(Ljava/lang/String;)V", "templateVersion", "getTemplateVersion", "setTemplateVersion", "templateBiz", "getTemplateBiz", "setTemplateBiz", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "Landroid/view/View;", "container", "Landroid/view/View;", "getContainer", "()Landroid/view/View;", "setContainer", "(Landroid/view/View;)V", "Lcom/alibaba/fastjson/JSONObject;", "data", "Lcom/alibaba/fastjson/JSONObject;", "getData", "()Lcom/alibaba/fastjson/JSONObject;", "setData", "(Lcom/alibaba/fastjson/JSONObject;)V", "", ParamsConstants.Key.PARAM_TRACE_ID, "I", "getTraceId", "()I", "setTraceId", "(I)V", "Lcom/alibaba/gaiax/GXTemplateEngine$d;", "gxExtendParams", "Lcom/alibaba/gaiax/GXTemplateEngine$d;", "getGxExtendParams", "()Lcom/alibaba/gaiax/GXTemplateEngine$d;", "setGxExtendParams", "(Lcom/alibaba/gaiax/GXTemplateEngine$d;)V", "", "openMinHeight", "Z", "getOpenMinHeight", "()Z", "setOpenMinHeight", "(Z)V", "forceCreate", "getForceCreate", "setForceCreate", "forceLocalTemplate", "getForceLocalTemplate", "setForceLocalTemplate", "Lcom/youku/gaiax/GaiaX$IScrollDataDiffCallBack;", "scrollDataDiffCallBackDelegate", "Lcom/youku/gaiax/GaiaX$IScrollDataDiffCallBack;", "getScrollDataDiffCallBackDelegate", "()Lcom/youku/gaiax/GaiaX$IScrollDataDiffCallBack;", "setScrollDataDiffCallBackDelegate", "(Lcom/youku/gaiax/GaiaX$IScrollDataDiffCallBack;)V", "Lcom/youku/gaiax/GaiaX$IScrollDelegate;", "scrollDelegate", "Lcom/youku/gaiax/GaiaX$IScrollDelegate;", "getScrollDelegate", "()Lcom/youku/gaiax/GaiaX$IScrollDelegate;", "setScrollDelegate", "(Lcom/youku/gaiax/GaiaX$IScrollDelegate;)V", "Lcom/youku/gaiax/GaiaX$IHostMessage;", "message", "Lcom/youku/gaiax/GaiaX$IHostMessage;", "getMessage", "()Lcom/youku/gaiax/GaiaX$IHostMessage;", "setMessage", "(Lcom/youku/gaiax/GaiaX$IHostMessage;)V", "Lcom/youku/gaiax/GaiaX$IRouterDelegate2;", "routerDelegate2", "Lcom/youku/gaiax/GaiaX$IRouterDelegate2;", "getRouterDelegate2", "()Lcom/youku/gaiax/GaiaX$IRouterDelegate2;", "setRouterDelegate2", "(Lcom/youku/gaiax/GaiaX$IRouterDelegate2;)V", "getRouterDelegate2$annotations", "()V", "Lcom/youku/gaiax/GaiaX$IEventDelegate;", "eventDelegate", "Lcom/youku/gaiax/GaiaX$IEventDelegate;", "getEventDelegate", "()Lcom/youku/gaiax/GaiaX$IEventDelegate;", "setEventDelegate", "(Lcom/youku/gaiax/GaiaX$IEventDelegate;)V", "Lcom/youku/gaiax/GaiaX$ITrackDelegate3;", "trackDelegate3", "Lcom/youku/gaiax/GaiaX$ITrackDelegate3;", "getTrackDelegate3", "()Lcom/youku/gaiax/GaiaX$ITrackDelegate3;", "setTrackDelegate3", "(Lcom/youku/gaiax/GaiaX$ITrackDelegate3;)V", "Lcom/youku/gaiax/GaiaX$IStatusDelegate;", "statusDelegate", "Lcom/youku/gaiax/GaiaX$IStatusDelegate;", "getStatusDelegate", "()Lcom/youku/gaiax/GaiaX$IStatusDelegate;", "setStatusDelegate", "(Lcom/youku/gaiax/GaiaX$IStatusDelegate;)V", "Lcom/youku/gaiax/GaiaX$IErrorDelegate;", "errorDelegate", "Lcom/youku/gaiax/GaiaX$IErrorDelegate;", "getErrorDelegate", "()Lcom/youku/gaiax/GaiaX$IErrorDelegate;", "setErrorDelegate", "(Lcom/youku/gaiax/GaiaX$IErrorDelegate;)V", "Lcom/youku/gaiax/GaiaX$IScrollItemStatusDelegate;", "scrollItemStatusDelegate", "Lcom/youku/gaiax/GaiaX$IScrollItemStatusDelegate;", "getScrollItemStatusDelegate", "()Lcom/youku/gaiax/GaiaX$IScrollItemStatusDelegate;", "setScrollItemStatusDelegate", "(Lcom/youku/gaiax/GaiaX$IScrollItemStatusDelegate;)V", "Lcom/youku/gaiax/GaiaX$IAnimationDelegate;", "animationDelegate", "Lcom/youku/gaiax/GaiaX$IAnimationDelegate;", "getAnimationDelegate", "()Lcom/youku/gaiax/GaiaX$IAnimationDelegate;", "setAnimationDelegate", "(Lcom/youku/gaiax/GaiaX$IAnimationDelegate;)V", "Lcom/youku/gaiax/LoadType;", "mode", "Lcom/youku/gaiax/LoadType;", "getMode", "()Lcom/youku/gaiax/LoadType;", "setMode", "(Lcom/youku/gaiax/LoadType;)V", "childLoadMode", "getChildLoadMode$GaiaX_Android", "setChildLoadMode$GaiaX_Android", "indexPosition", "getIndexPosition$GaiaX_Android", "setIndexPosition$GaiaX_Android", "scrollPosition", "getScrollPosition$GaiaX_Android", "setScrollPosition$GaiaX_Android", "isReleased", "isReleased$GaiaX_Android", "setReleased$GaiaX_Android", "", "Lcom/youku/gaiax/GaiaX$IRule;", "Lcom/youku/gaiax/GaiaX$IDataPipeline5;", "dataPipelines5", "Ljava/util/Map;", "getDataPipelines5", "()Ljava/util/Map;", "setDataPipelines5", "(Ljava/util/Map;)V", "Ltb/ld2;", "", "viewPort", "Ltb/ld2;", "getViewPort", "()Ltb/ld2;", "setViewPort", "(Ltb/ld2;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;Landroid/view/View;Lcom/alibaba/fastjson/JSONObject;Ltb/ld2;)V", "Companion", "Builder", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Params implements IContextParams {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @Nullable
        private IAnimationDelegate animationDelegate;
        @Nullable
        private LoadType childLoadMode;
        @Nullable
        private View container;
        @Nullable
        private Context context;
        @Nullable
        private JSONObject data;
        @NotNull
        private Map<IRule, IDataPipeline5> dataPipelines5;
        @Nullable
        private IErrorDelegate errorDelegate;
        @Nullable
        private IEventDelegate eventDelegate;
        private boolean forceCreate;
        private boolean forceLocalTemplate;
        @Nullable
        private GXTemplateEngine.C3341d gxExtendParams;
        private int indexPosition;
        private boolean isReleased;
        @Nullable
        private IHostMessage message;
        @NotNull
        private LoadType mode;
        private boolean openMinHeight;
        @Nullable
        private IRouterDelegate2 routerDelegate2;
        @Nullable
        private IScrollDataDiffCallBack scrollDataDiffCallBackDelegate;
        @Nullable
        private IScrollDelegate scrollDelegate;
        @Nullable
        private IScrollItemStatusDelegate scrollItemStatusDelegate;
        private int scrollPosition;
        @Nullable
        private IStatusDelegate statusDelegate;
        @NotNull
        private String templateBiz;
        @NotNull
        private String templateId;
        @NotNull
        private String templateVersion;
        private int traceId;
        @Nullable
        private ITrackDelegate3 trackDelegate3;
        @NotNull
        private ld2<Float> viewPort;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u001dR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001dR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001eR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u001fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010 R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010!R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010!R\u0016\u0010\u0014\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\"R\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\"R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\"R\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010$R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010&¨\u0006)"}, d2 = {"Lcom/youku/gaiax/GaiaX$Params$Builder;", "", "", "id", "templateId", "templateBiz", "templateVersion", "Landroid/view/View;", "container", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/alibaba/fastjson/JSONObject;", "data", "Lcom/youku/gaiax/LoadType;", "mode", "childMode", "", "state", "forceCreate", "forceLocalTemplate", "openMinHeight", "", "scrollPosition", "Lcom/youku/gaiax/GaiaX$Params;", "buildWithScreenWidth", "", "width", "height", "build", "Ljava/lang/String;", "Landroid/view/View;", "Landroid/content/Context;", "Lcom/alibaba/fastjson/JSONObject;", "Ljava/lang/Float;", "Z", "loadMode", "Lcom/youku/gaiax/LoadType;", "childLoadMode", "I", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Builder {
            @Nullable
            private LoadType childLoadMode;
            @Nullable
            private View container;
            @Nullable
            private Context context;
            @Nullable
            private JSONObject data;
            private boolean forceCreate;
            private boolean forceLocalTemplate;
            @Nullable
            private Float height;
            @NotNull
            private LoadType loadMode = LoadType.ASYNC_NORMAL;
            private boolean openMinHeight;
            private int scrollPosition;
            @Nullable
            private String templateBiz;
            @Nullable
            private String templateId;
            @Nullable
            private String templateVersion;
            @Nullable
            private Float width;

            @NotNull
            public final Params build() {
                View view = this.container;
                if (view != null) {
                    String str = this.templateId;
                    if (str != null) {
                        String str2 = this.templateBiz;
                        if (str2 != null) {
                            String str3 = this.templateVersion;
                            if (str3 == null) {
                                str3 = "";
                            }
                            Params newInstance$GaiaX_Android = Params.Companion.newInstance$GaiaX_Android(str, str3, str2, view, this.data, this.width, this.height);
                            newInstance$GaiaX_Android.setForceCreate(this.forceCreate);
                            newInstance$GaiaX_Android.setOpenMinHeight(this.openMinHeight);
                            newInstance$GaiaX_Android.setForceLocalTemplate(this.forceLocalTemplate);
                            newInstance$GaiaX_Android.setMode(this.loadMode);
                            newInstance$GaiaX_Android.setChildLoadMode$GaiaX_Android(this.childLoadMode);
                            newInstance$GaiaX_Android.setScrollPosition$GaiaX_Android(this.scrollPosition);
                            return newInstance$GaiaX_Android;
                        }
                        throw new IllegalArgumentException("param templateBiz is null");
                    }
                    throw new IllegalArgumentException("param templateId is null");
                }
                throw new IllegalArgumentException("param container is null");
            }

            @NotNull
            public final Params buildWithScreenWidth() {
                if (this.container != null) {
                    this.width = Float.valueOf(ScreenUtils.INSTANCE.getScreenWidthPx());
                }
                return build();
            }

            @NotNull
            public final Builder childMode(@Nullable LoadType loadType) {
                this.childLoadMode = loadType;
                return this;
            }

            @NotNull
            public final Builder container(@Nullable View view) {
                this.container = view;
                return this;
            }

            @NotNull
            public final Builder context(@Nullable Context context) {
                this.context = context;
                return this;
            }

            @NotNull
            public final Builder data(@Nullable JSONObject jSONObject) {
                this.data = jSONObject;
                return this;
            }

            @NotNull
            public final Builder forceCreate(boolean z) {
                this.forceCreate = z;
                return this;
            }

            @NotNull
            public final Builder forceLocalTemplate(boolean z) {
                this.forceLocalTemplate = z;
                return this;
            }

            @NotNull
            public final Builder height(float f) {
                this.height = Float.valueOf(f);
                return this;
            }

            @Deprecated(message = "")
            @NotNull
            public final Builder id(@Nullable String str) {
                this.templateId = str;
                return this;
            }

            @NotNull
            public final Builder mode(@NotNull LoadType loadType) {
                b41.i(loadType, "mode");
                this.loadMode = loadType;
                return this;
            }

            @NotNull
            public final Builder openMinHeight(boolean z) {
                this.openMinHeight = z;
                return this;
            }

            @NotNull
            public final Builder scrollPosition(int i) {
                this.scrollPosition = i;
                return this;
            }

            @NotNull
            public final Builder templateBiz(@Nullable String str) {
                this.templateBiz = str;
                return this;
            }

            @NotNull
            public final Builder templateId(@Nullable String str) {
                this.templateId = str;
                return this;
            }

            @NotNull
            public final Builder templateVersion(@Nullable String str) {
                this.templateVersion = str;
                return this;
            }

            @NotNull
            public final Builder width(float f) {
                this.width = Float.valueOf(f);
                return this;
            }
        }

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016JK\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJS\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/youku/gaiax/GaiaX$Params$Companion;", "", "", "templateId", "templateBiz", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/alibaba/fastjson/JSONObject;", "data", "", "viewWidth", Constants.Name.VIEW_HEIGHT, "Lcom/youku/gaiax/GaiaX$Params;", "newPreLoadInstance", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;Lcom/alibaba/fastjson/JSONObject;Ljava/lang/Float;Ljava/lang/Float;)Lcom/youku/gaiax/GaiaX$Params;", "templateVersion", "Landroid/view/View;", "container", "newInstance$GaiaX_Android", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/alibaba/fastjson/JSONObject;Ljava/lang/Float;Ljava/lang/Float;)Lcom/youku/gaiax/GaiaX$Params;", "newInstance", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final Params newPreLoadInstance(String str, String str2, Context context, JSONObject jSONObject, Float f, Float f2) {
                return new Params(str, "", str2, context, null, jSONObject, new ld2(f, f2), null);
            }

            @NotNull
            public final Params newInstance$GaiaX_Android(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull View view, @Nullable JSONObject jSONObject, @Nullable Float f, @Nullable Float f2) {
                b41.i(str, "templateId");
                b41.i(str2, "templateVersion");
                b41.i(str3, "templateBiz");
                b41.i(view, "container");
                return new Params(str, str2, str3, view.getContext(), view, jSONObject, new ld2(f, f2), null);
            }
        }

        private Params(String str, String str2, String str3, Context context, View view, JSONObject jSONObject, ld2<Float> ld2Var) {
            this.templateId = str;
            this.templateVersion = str2;
            this.templateBiz = str3;
            this.context = context;
            this.container = view;
            this.data = jSONObject;
            this.viewPort = ld2Var;
            this.traceId = -1;
            LoadType loadType = LoadType.ASYNC_NORMAL;
            this.mode = loadType;
            this.childLoadMode = loadType;
            this.indexPosition = -1;
            this.dataPipelines5 = new ConcurrentHashMap();
        }

        public /* synthetic */ Params(String str, String str2, String str3, Context context, View view, JSONObject jSONObject, ld2 ld2Var, k50 k50Var) {
            this(str, str2, str3, context, view, jSONObject, ld2Var);
        }

        @Deprecated(message = "")
        public static /* synthetic */ void getRouterDelegate2$annotations() {
        }

        @Nullable
        public final IAnimationDelegate getAnimationDelegate() {
            return this.animationDelegate;
        }

        @Nullable
        public final LoadType getChildLoadMode$GaiaX_Android() {
            return this.childLoadMode;
        }

        @Nullable
        public final View getContainer() {
            return this.container;
        }

        @Nullable
        public final Context getContext() {
            return this.context;
        }

        @Nullable
        public final JSONObject getData() {
            return this.data;
        }

        @NotNull
        public final Map<IRule, IDataPipeline5> getDataPipelines5() {
            return this.dataPipelines5;
        }

        @Nullable
        public final IErrorDelegate getErrorDelegate() {
            return this.errorDelegate;
        }

        @Nullable
        public final IEventDelegate getEventDelegate() {
            return this.eventDelegate;
        }

        public final boolean getForceCreate() {
            return this.forceCreate;
        }

        public final boolean getForceLocalTemplate() {
            return this.forceLocalTemplate;
        }

        @Nullable
        public final GXTemplateEngine.C3341d getGxExtendParams() {
            return this.gxExtendParams;
        }

        public final int getIndexPosition$GaiaX_Android() {
            return this.indexPosition;
        }

        @Nullable
        public final IHostMessage getMessage() {
            return this.message;
        }

        @NotNull
        public final LoadType getMode() {
            return this.mode;
        }

        public final boolean getOpenMinHeight() {
            return this.openMinHeight;
        }

        @Nullable
        public final IRouterDelegate2 getRouterDelegate2() {
            return this.routerDelegate2;
        }

        @Nullable
        public final IScrollDataDiffCallBack getScrollDataDiffCallBackDelegate() {
            return this.scrollDataDiffCallBackDelegate;
        }

        @Nullable
        public final IScrollDelegate getScrollDelegate() {
            return this.scrollDelegate;
        }

        @Nullable
        public final IScrollItemStatusDelegate getScrollItemStatusDelegate() {
            return this.scrollItemStatusDelegate;
        }

        public final int getScrollPosition$GaiaX_Android() {
            return this.scrollPosition;
        }

        @Nullable
        public final IStatusDelegate getStatusDelegate() {
            return this.statusDelegate;
        }

        @NotNull
        public final String getTemplateBiz() {
            return this.templateBiz;
        }

        @NotNull
        public final String getTemplateId() {
            return this.templateId;
        }

        @NotNull
        public final String getTemplateVersion() {
            return this.templateVersion;
        }

        public final int getTraceId() {
            return this.traceId;
        }

        @Nullable
        public final ITrackDelegate3 getTrackDelegate3() {
            return this.trackDelegate3;
        }

        @NotNull
        public final ld2<Float> getViewPort() {
            return this.viewPort;
        }

        public final boolean isReleased$GaiaX_Android() {
            return this.isReleased;
        }

        public final void release() {
            this.context = null;
            this.container = null;
            this.data = null;
            this.viewPort = new ld2<>(null, null);
            this.dataPipelines5.clear();
            this.scrollItemStatusDelegate = null;
            this.scrollDataDiffCallBackDelegate = null;
            this.scrollDelegate = null;
            this.scrollPosition = 0;
            this.indexPosition = -1;
            this.isReleased = true;
            this.gxExtendParams = null;
        }

        public final void setAnimationDelegate(@Nullable IAnimationDelegate iAnimationDelegate) {
            this.animationDelegate = iAnimationDelegate;
        }

        public final void setChildLoadMode$GaiaX_Android(@Nullable LoadType loadType) {
            this.childLoadMode = loadType;
        }

        public final void setContainer(@Nullable View view) {
            this.container = view;
        }

        public final void setContext(@Nullable Context context) {
            this.context = context;
        }

        public final void setData(@Nullable JSONObject jSONObject) {
            this.data = jSONObject;
        }

        public final void setDataPipelines5(@NotNull Map<IRule, IDataPipeline5> map) {
            b41.i(map, "<set-?>");
            this.dataPipelines5 = map;
        }

        public final void setErrorDelegate(@Nullable IErrorDelegate iErrorDelegate) {
            this.errorDelegate = iErrorDelegate;
        }

        public final void setEventDelegate(@Nullable IEventDelegate iEventDelegate) {
            this.eventDelegate = iEventDelegate;
        }

        public final void setForceCreate(boolean z) {
            this.forceCreate = z;
        }

        public final void setForceLocalTemplate(boolean z) {
            this.forceLocalTemplate = z;
        }

        public final void setGxExtendParams(@Nullable GXTemplateEngine.C3341d c3341d) {
            this.gxExtendParams = c3341d;
        }

        public final void setIndexPosition$GaiaX_Android(int i) {
            this.indexPosition = i;
        }

        public final void setMessage(@Nullable IHostMessage iHostMessage) {
            this.message = iHostMessage;
        }

        public final void setMode(@NotNull LoadType loadType) {
            b41.i(loadType, "<set-?>");
            this.mode = loadType;
        }

        public final void setOpenMinHeight(boolean z) {
            this.openMinHeight = z;
        }

        public final void setReleased$GaiaX_Android(boolean z) {
            this.isReleased = z;
        }

        public final void setRouterDelegate2(@Nullable IRouterDelegate2 iRouterDelegate2) {
            this.routerDelegate2 = iRouterDelegate2;
        }

        public final void setScrollDataDiffCallBackDelegate(@Nullable IScrollDataDiffCallBack iScrollDataDiffCallBack) {
            this.scrollDataDiffCallBackDelegate = iScrollDataDiffCallBack;
        }

        public final void setScrollDelegate(@Nullable IScrollDelegate iScrollDelegate) {
            this.scrollDelegate = iScrollDelegate;
        }

        public final void setScrollItemStatusDelegate(@Nullable IScrollItemStatusDelegate iScrollItemStatusDelegate) {
            this.scrollItemStatusDelegate = iScrollItemStatusDelegate;
        }

        public final void setScrollPosition$GaiaX_Android(int i) {
            this.scrollPosition = i;
        }

        public final void setStatusDelegate(@Nullable IStatusDelegate iStatusDelegate) {
            this.statusDelegate = iStatusDelegate;
        }

        public final void setTemplateBiz(@NotNull String str) {
            b41.i(str, "<set-?>");
            this.templateBiz = str;
        }

        public final void setTemplateId(@NotNull String str) {
            b41.i(str, "<set-?>");
            this.templateId = str;
        }

        public final void setTemplateVersion(@NotNull String str) {
            b41.i(str, "<set-?>");
            this.templateVersion = str;
        }

        public final void setTraceId(int i) {
            this.traceId = i;
        }

        public final void setTrackDelegate3(@Nullable ITrackDelegate3 iTrackDelegate3) {
            this.trackDelegate3 = iTrackDelegate3;
        }

        public final void setViewPort(@NotNull ld2<Float> ld2Var) {
            b41.i(ld2Var, "<set-?>");
            this.viewPort = ld2Var;
        }

        /* synthetic */ Params(String str, String str2, String str3, Context context, View view, JSONObject jSONObject, ld2 ld2Var, int i, k50 k50Var) {
            this(str, str2, str3, context, view, (i & 32) != 0 ? null : jSONObject, (i & 64) != 0 ? new ld2(null, null) : ld2Var);
        }
    }
}
