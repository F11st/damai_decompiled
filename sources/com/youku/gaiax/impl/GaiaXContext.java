package com.youku.gaiax.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ali.user.open.core.util.ParamsConstants;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.LoadType;
import com.youku.gaiax.common.utils.Log;
import com.youku.gaiax.impl.register.GXExtensionTemplateInfoSource;
import com.youku.gaiax.impl.utils.ExceptionUtils;
import com.youku.gaiax.impl.utils.GaiaXUiExecutor;
import com.youku.gaiax.impl.utils.GaiaXWorkerExecutor;
import com.youku.gaiax.impl.utils.TraceId;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.os0;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010#\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 \u0086\u00012\u00020\u0001:\u0002\u0086\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\n\u001a\u00020\tJ\u0014\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0002J\u0014\u0010\u000f\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\tJ\u0006\u0010\u0017\u001a\u00020\tJ\u0006\u0010\u0018\u001a\u00020\tJ\u0006\u0010\u0019\u001a\u00020\u0002R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b-\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010(\u001a\u0004\b3\u0010*\"\u0004\b4\u0010,R\"\u00105\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010(\u001a\u0004\b6\u0010*\"\u0004\b7\u0010,R\"\u00108\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010(\u001a\u0004\b9\u0010*\"\u0004\b:\u0010,R*\u0010=\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010D\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010K\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010R\u001a\u0004\u0018\u00010Q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR$\u0010Y\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010_\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010.\u001a\u0004\b_\u0010/\"\u0004\b`\u00101R$\u0010b\u001a\u0004\u0018\u00010a8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001e\u0010i\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010jR\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010jR\"\u0010k\u001a\u00020<8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010q\u001a\u00020<8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bq\u0010l\u001a\u0004\br\u0010n\"\u0004\bs\u0010pR\"\u0010t\u001a\u00020<8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bt\u0010l\u001a\u0004\bu\u0010n\"\u0004\bv\u0010pR\"\u0010w\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010.\u001a\u0004\bw\u0010/\"\u0004\bx\u00101R$\u0010y\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R(\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0004\b\u0014\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001¨\u0006\u0087\u0001"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXContext;", "", "Ltb/wt2;", "releaseTask", "releaseSync", "removeOldTask", "Lcom/youku/gaiax/GaiaX$Params;", "params", "updateContext", "", "isJsExist", "Lkotlin/Function0;", "task", "workerTask", "hookTask", "uiTask", "releaseCanAsync", "", "getTemplateId", "Ltb/os0;", "gxTemplateContext", "setGXTemplateContext", "isInvalidGXRootView", "isInvalidContainer", "isInvalidStatus", "initCall", "Lcom/youku/gaiax/GaiaX$Params;", "getParams", "()Lcom/youku/gaiax/GaiaX$Params;", "setParams", "(Lcom/youku/gaiax/GaiaX$Params;)V", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "", ParamsConstants.Key.PARAM_TRACE_ID, "I", "getTraceId", "()I", "setTraceId", "(I)V", "isReleased", "Z", "()Z", "setReleased", "(Z)V", "typeStatus", "getTypeStatus", "setTypeStatus", "lifeStatus", "getLifeStatus", "setLifeStatus", "jsStatus", "getJsStatus", "setJsStatus", "", "", "jsComponentIds", "Ljava/util/Set;", "getJsComponentIds", "()Ljava/util/Set;", "setJsComponentIds", "(Ljava/util/Set;)V", "Lcom/alibaba/gaiax/GXTemplateEngine$GXITrackListener;", "gxTrackListener", "Lcom/alibaba/gaiax/GXTemplateEngine$GXITrackListener;", "getGxTrackListener", "()Lcom/alibaba/gaiax/GXTemplateEngine$GXITrackListener;", "setGxTrackListener", "(Lcom/alibaba/gaiax/GXTemplateEngine$GXITrackListener;)V", "Lcom/alibaba/gaiax/GXTemplateEngine$GXIEventListener;", "gxEventListener", "Lcom/alibaba/gaiax/GXTemplateEngine$GXIEventListener;", "getGxEventListener", "()Lcom/alibaba/gaiax/GXTemplateEngine$GXIEventListener;", "setGxEventListener", "(Lcom/alibaba/gaiax/GXTemplateEngine$GXIEventListener;)V", "Lcom/alibaba/gaiax/GXTemplateEngine$GXIDataListener;", "gxDataListener", "Lcom/alibaba/gaiax/GXTemplateEngine$GXIDataListener;", "getGxDataListener", "()Lcom/alibaba/gaiax/GXTemplateEngine$GXIDataListener;", "setGxDataListener", "(Lcom/alibaba/gaiax/GXTemplateEngine$GXIDataListener;)V", "Landroid/view/View;", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "isChanged", "setChanged", "Ljava/lang/Runnable;", "hook", "Ljava/lang/Runnable;", "getHook$GaiaX_Android", "()Ljava/lang/Runnable;", "setHook$GaiaX_Android", "(Ljava/lang/Runnable;)V", "Ljava/util/concurrent/FutureTask;", "workTask", "Ljava/util/concurrent/FutureTask;", "createTime", "J", "getCreateTime$GaiaX_Android", "()J", "setCreateTime$GaiaX_Android", "(J)V", "refreshTime", "getRefreshTime$GaiaX_Android", "setRefreshTime$GaiaX_Android", "stepTime", "getStepTime$GaiaX_Android", "setStepTime$GaiaX_Android", "isIgnoreJSReuse", "setIgnoreJSReuse", "callStack", "Ljava/lang/String;", "getCallStack", "()Ljava/lang/String;", "setCallStack", "(Ljava/lang/String;)V", "Ltb/os0;", "getGxTemplateContext", "()Ltb/os0;", "setGxTemplateContext", "(Ltb/os0;)V", "<init>", "(Lcom/youku/gaiax/GaiaX$Params;Landroid/content/Context;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXContext {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int TEMPLATE_ASYNC_NORMAL = 1;
    public static final int TEMPLATE_ASYNC_NORMAL_SUPER_MERGE = 2;
    public static final int TEMPLATE_JS_LIFE_ON_DESTROY = 6;
    public static final int TEMPLATE_JS_LIFE_ON_HIDDEN = 5;
    public static final int TEMPLATE_JS_LIFE_ON_LOAD_MORE = 11;
    public static final int TEMPLATE_JS_LIFE_ON_NEED_RELOAD = 10;
    public static final int TEMPLATE_JS_LIFE_ON_NONE = 0;
    public static final int TEMPLATE_JS_LIFE_ON_READY = 2;
    public static final int TEMPLATE_JS_LIFE_ON_REGISTER = 1;
    public static final int TEMPLATE_JS_LIFE_ON_REUSE = 4;
    public static final int TEMPLATE_JS_LIFE_ON_SHOW = 3;
    public static final int TEMPLATE_JS_LIFE_ON_UNREGISTER = 7;
    public static final int TEMPLATE_LIFE_ON_CREATED = 4;
    public static final int TEMPLATE_LIFE_ON_DESTROY = 3;
    public static final int TEMPLATE_LIFE_ON_INVISIBLE = 2;
    public static final int TEMPLATE_LIFE_ON_NONE = 0;
    public static final int TEMPLATE_LIFE_ON_VISIBLE = 1;
    public static final int TEMPLATE_SYNC_NORMAL = 0;
    public static final int TEMPLATE_TYPE_CREATED = 2;
    public static final int TEMPLATE_TYPE_CREATING = 1;
    public static final int TEMPLATE_TYPE_NEED_RELOAD = 5;
    public static final int TEMPLATE_TYPE_NONE = 0;
    public static final int TEMPLATE_TYPE_REFRESHED = 4;
    public static final int TEMPLATE_TYPE_REFRESHING = 3;
    @Nullable
    private String callStack;
    @NotNull
    private Context context;
    private long createTime;
    @Nullable
    private GXTemplateEngine.GXIDataListener gxDataListener;
    @Nullable
    private GXTemplateEngine.GXIEventListener gxEventListener;
    @Nullable
    private os0 gxTemplateContext;
    @Nullable
    private GXTemplateEngine.GXITrackListener gxTrackListener;
    @Nullable
    private Runnable hook;
    private boolean isChanged;
    private boolean isIgnoreJSReuse;
    private volatile boolean isReleased;
    @Nullable
    private Set<Long> jsComponentIds;
    private int jsStatus;
    private int lifeStatus;
    @NotNull
    private GaiaX.Params params;
    private long refreshTime;
    @Nullable
    private FutureTask<wt2> releaseTask;
    @Nullable
    private View rootView;
    private long stepTime;
    private int traceId;
    private int typeStatus;
    @Nullable
    private FutureTask<wt2> uiTask;
    @Nullable
    private FutureTask<wt2> workTask;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0004R\u0016\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0014\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000eR\u0016\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u000eR\u0016\u0010\u0017\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u000eR\u0016\u0010\u0018\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u000eR\u0016\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u000eR\u0016\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u000eR\u0016\u0010\u001b\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u000eR\u0016\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u000eR\u0016\u0010\u001d\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u000eR\u0016\u0010\u001e\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u000eR\u0016\u0010\u001f\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u000eR\u0016\u0010 \u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u000eR\u0016\u0010!\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u000eR\u0016\u0010\"\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\u000eR\u0016\u0010#\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\u000eR\u0016\u0010$\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\u000eR\u0016\u0010%\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\u000e¨\u0006("}, d2 = {"Lcom/youku/gaiax/impl/GaiaXContext$Companion;", "", "Lcom/youku/gaiax/GaiaX$Params;", "params", "Lcom/youku/gaiax/impl/GaiaXContext;", "createContext", "forceInitContext", "initContext", "getContainerContext", WPKFactory.INIT_KEY_CONTEXT, "Ltb/wt2;", "setContextToContainer", "", "TEMPLATE_ASYNC_NORMAL", "I", "TEMPLATE_ASYNC_NORMAL_SUPER_MERGE", "TEMPLATE_JS_LIFE_ON_DESTROY", "TEMPLATE_JS_LIFE_ON_HIDDEN", "TEMPLATE_JS_LIFE_ON_LOAD_MORE", "TEMPLATE_JS_LIFE_ON_NEED_RELOAD", "TEMPLATE_JS_LIFE_ON_NONE", "TEMPLATE_JS_LIFE_ON_READY", "TEMPLATE_JS_LIFE_ON_REGISTER", "TEMPLATE_JS_LIFE_ON_REUSE", "TEMPLATE_JS_LIFE_ON_SHOW", "TEMPLATE_JS_LIFE_ON_UNREGISTER", "TEMPLATE_LIFE_ON_CREATED", "TEMPLATE_LIFE_ON_DESTROY", "TEMPLATE_LIFE_ON_INVISIBLE", "TEMPLATE_LIFE_ON_NONE", "TEMPLATE_LIFE_ON_VISIBLE", "TEMPLATE_SYNC_NORMAL", "TEMPLATE_TYPE_CREATED", "TEMPLATE_TYPE_CREATING", "TEMPLATE_TYPE_NEED_RELOAD", "TEMPLATE_TYPE_NONE", "TEMPLATE_TYPE_REFRESHED", "TEMPLATE_TYPE_REFRESHING", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        private final GaiaXContext createContext(GaiaX.Params params) {
            Context context = params.getContext();
            if (context != null) {
                GaiaXContext gaiaXContext = new GaiaXContext(params, context);
                if (params.getTraceId() == -1) {
                    gaiaXContext.setTraceId(TraceId.INSTANCE.generateTraceId());
                } else {
                    gaiaXContext.setTraceId(params.getTraceId());
                }
                return gaiaXContext;
            }
            throw new IllegalArgumentException("GaiaX.Params must be have an android context");
        }

        @NotNull
        public final GaiaXContext forceInitContext(@NotNull GaiaX.Params params) {
            b41.i(params, "params");
            GaiaXContext createContext = createContext(params);
            createContext.updateContext(params);
            setContextToContainer(params, createContext);
            return createContext;
        }

        @Nullable
        public final GaiaXContext getContainerContext(@NotNull GaiaX.Params params) {
            b41.i(params, "params");
            View container = params.getContainer();
            if (container != null) {
                Object tag = container.getTag();
                if (tag instanceof GaiaXContext) {
                    return (GaiaXContext) tag;
                }
                return null;
            }
            return null;
        }

        @NotNull
        public final GaiaXContext initContext(@NotNull GaiaX.Params params) {
            b41.i(params, "params");
            GaiaXContext containerContext = getContainerContext(params);
            if (containerContext != null) {
                containerContext.updateContext(params);
                return containerContext;
            }
            GaiaXContext createContext = createContext(params);
            createContext.updateContext(params);
            setContextToContainer(params, createContext);
            return createContext;
        }

        public final void setContextToContainer(@NotNull GaiaX.Params params, @Nullable GaiaXContext gaiaXContext) {
            b41.i(params, "params");
            View container = params.getContainer();
            if (container != null) {
                container.setTag(gaiaXContext);
            }
        }
    }

    public GaiaXContext(@NotNull GaiaX.Params params, @NotNull Context context) {
        b41.i(params, "params");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.params = params;
        this.context = context;
        this.traceId = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseSync() {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, this, "releaseSync", null, 4, null);
        }
        synchronized (this) {
            setReleased(true);
            Companion.setContextToContainer(getParams(), null);
            os0 gxTemplateContext = getGxTemplateContext();
            if (gxTemplateContext != null) {
                gxTemplateContext.B();
            }
            setGxTemplateContext(null);
            View rootView = getRootView();
            if (rootView != null) {
                rootView.setTag(null);
            }
            setRootView(null);
            setGxEventListener(null);
            setGxTrackListener(null);
            setTypeStatus(0);
            setLifeStatus(3);
            setLifeStatus(0);
            setJsStatus(0);
            this.workTask = null;
            this.releaseTask = null;
            this.uiTask = null;
            setChanged(false);
            setJsComponentIds(null);
            setCallStack(null);
            wt2 wt2Var = wt2.INSTANCE;
        }
    }

    private final void releaseTask() {
        FutureTask<wt2> futureTask = new FutureTask<>(new Callable() { // from class: com.youku.gaiax.impl.GaiaXContext$releaseTask$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return wt2.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                GaiaXContext.this.releaseSync();
                GaiaXContext.this.releaseTask = null;
            }
        });
        this.releaseTask = futureTask;
        GaiaXWorkerExecutor.INSTANCE.action(futureTask);
    }

    private final void removeOldTask() {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, this, "removeOldTask", null, 4, null);
        }
        FutureTask<wt2> futureTask = this.workTask;
        if (futureTask != null) {
            GaiaXWorkerExecutor.INSTANCE.removeAction(futureTask);
            futureTask.cancel(true);
            this.workTask = null;
        }
        FutureTask<wt2> futureTask2 = this.uiTask;
        if (futureTask2 != null) {
            GaiaXUiExecutor.INSTANCE.removeAction(futureTask2);
            futureTask2.cancel(true);
            this.uiTask = null;
        }
        FutureTask<wt2> futureTask3 = this.releaseTask;
        if (futureTask3 == null) {
            return;
        }
        GaiaXWorkerExecutor.INSTANCE.removeAction(futureTask3);
        futureTask3.cancel(true);
        this.releaseTask = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateContext(GaiaX.Params params) {
        GaiaX.Params params2 = this.params;
        this.params = params;
        boolean z = true;
        if (!params.getDataPipelines5().isEmpty()) {
            this.gxDataListener = new GXDataListener(this);
        }
        if (this.params.getEventDelegate() != null || this.params.getRouterDelegate2() != null) {
            this.gxEventListener = new GXEventListener(this);
        }
        if (this.params.getTrackDelegate3() != null) {
            setGxTrackListener(new GXTrackListener(this));
        }
        if (params.getForceCreate()) {
            GXExtensionTemplateInfoSource.Companion.getInstance().clear();
        }
        boolean forceCreate = params.getForceCreate();
        boolean z2 = !b41.d(params.getTemplateId(), params2.getTemplateId());
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.trace(this, "onUpdateContext", "forceCreate=" + forceCreate + " isSameTemplateId=" + z2);
        }
        if (!forceCreate && !z2) {
            z = false;
        }
        this.isChanged = z;
        if (!b41.d(params2, params)) {
            if (log.isLog()) {
                StringBuilder sb = new StringBuilder();
                sb.append("oldParams.data = ");
                JSONObject data = params2.getData();
                sb.append(data != null ? data.hashCode() : 0);
                sb.append(" params.data = ");
                JSONObject data2 = params.getData();
                sb.append(data2 != null ? data2.hashCode() : 0);
                log.trace(this, "onUpdateContext", sb.toString());
            }
            params2.release();
        }
        this.isReleased = false;
    }

    @Nullable
    public final String getCallStack() {
        return this.callStack;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public final long getCreateTime$GaiaX_Android() {
        return this.createTime;
    }

    @Nullable
    public final GXTemplateEngine.GXIDataListener getGxDataListener() {
        return this.gxDataListener;
    }

    @Nullable
    public final GXTemplateEngine.GXIEventListener getGxEventListener() {
        return this.gxEventListener;
    }

    @Nullable
    public final os0 getGxTemplateContext() {
        return this.gxTemplateContext;
    }

    @Nullable
    public final GXTemplateEngine.GXITrackListener getGxTrackListener() {
        return this.gxTrackListener;
    }

    @Nullable
    public final Runnable getHook$GaiaX_Android() {
        return this.hook;
    }

    @Nullable
    public final Set<Long> getJsComponentIds() {
        return this.jsComponentIds;
    }

    public final int getJsStatus() {
        return this.jsStatus;
    }

    public final int getLifeStatus() {
        return this.lifeStatus;
    }

    @NotNull
    public final GaiaX.Params getParams() {
        return this.params;
    }

    public final long getRefreshTime$GaiaX_Android() {
        return this.refreshTime;
    }

    @Nullable
    public final View getRootView() {
        return this.rootView;
    }

    public final long getStepTime$GaiaX_Android() {
        return this.stepTime;
    }

    @NotNull
    public final String getTemplateId() {
        return this.params.getTemplateId();
    }

    public final int getTraceId() {
        return this.traceId;
    }

    public final int getTypeStatus() {
        return this.typeStatus;
    }

    public final void hookTask() {
        Runnable runnable = this.hook;
        if (runnable == null) {
            return;
        }
        runnable.run();
    }

    public final void initCall() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 15) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 15;
        while (true) {
            int i2 = i - 1;
            if (i != 15) {
                sb.append("\t\t\t\t");
            } else {
                sb.append("\t");
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append((Object) stackTrace[i].getClassName());
            sb2.append('.');
            sb2.append((Object) stackTrace[i].getMethodName());
            sb.append(sb2.toString());
            if (i != 5) {
                sb.append(StringUtils.LF);
            }
            if (5 > i2) {
                this.callStack = sb.toString();
                return;
            }
            i = i2;
        }
    }

    public final boolean isChanged() {
        return this.isChanged;
    }

    public final boolean isIgnoreJSReuse() {
        return this.isIgnoreJSReuse;
    }

    public final boolean isInvalidContainer() {
        View container = this.params.getContainer();
        ViewGroup viewGroup = container instanceof ViewGroup ? (ViewGroup) container : null;
        if ((viewGroup == null ? 0 : viewGroup.getChildCount()) == 0) {
            int i = this.typeStatus;
            return i == 2 || i == 4;
        }
        return false;
    }

    public final boolean isInvalidGXRootView() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        View view = this.rootView;
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if ((viewGroup == null ? 0 : viewGroup.getChildCount()) == 0) {
            View view2 = this.rootView;
            if ((view2 == null || (layoutParams = view2.getLayoutParams()) == null || layoutParams.width != 0) ? false : true) {
                View view3 = this.rootView;
                return view3 != null && (layoutParams2 = view3.getLayoutParams()) != null && layoutParams2.height == 0;
            }
            return false;
        }
        return false;
    }

    public final boolean isInvalidStatus() {
        return this.typeStatus == 5;
    }

    public final boolean isJsExist() {
        GXTemplateInfo q;
        os0 os0Var = this.gxTemplateContext;
        return (os0Var == null || (q = os0Var.q()) == null || !q.t()) ? false : true;
    }

    public final boolean isReleased() {
        return this.isReleased;
    }

    public final void releaseCanAsync() {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, this, "releaseCanAsync", null, 4, null);
        }
        if (this.params.getMode() != LoadType.ASYNC_NORMAL && this.params.getMode() != LoadType.ASYNC_NORMAL_SUPER_MERGE) {
            releaseSync();
            return;
        }
        removeOldTask();
        releaseTask();
    }

    public final void setCallStack(@Nullable String str) {
        this.callStack = str;
    }

    public final void setChanged(boolean z) {
        this.isChanged = z;
    }

    public final void setContext(@NotNull Context context) {
        b41.i(context, "<set-?>");
        this.context = context;
    }

    public final void setCreateTime$GaiaX_Android(long j) {
        this.createTime = j;
    }

    public final void setGXTemplateContext(@NotNull os0 os0Var) {
        b41.i(os0Var, "gxTemplateContext");
        this.gxTemplateContext = os0Var;
    }

    public final void setGxDataListener(@Nullable GXTemplateEngine.GXIDataListener gXIDataListener) {
        this.gxDataListener = gXIDataListener;
    }

    public final void setGxEventListener(@Nullable GXTemplateEngine.GXIEventListener gXIEventListener) {
        this.gxEventListener = gXIEventListener;
    }

    public final void setGxTemplateContext(@Nullable os0 os0Var) {
        this.gxTemplateContext = os0Var;
    }

    public final void setGxTrackListener(@Nullable GXTemplateEngine.GXITrackListener gXITrackListener) {
        this.gxTrackListener = gXITrackListener;
    }

    public final void setHook$GaiaX_Android(@Nullable Runnable runnable) {
        this.hook = runnable;
    }

    public final void setIgnoreJSReuse(boolean z) {
        this.isIgnoreJSReuse = z;
    }

    public final void setJsComponentIds(@Nullable Set<Long> set) {
        this.jsComponentIds = set;
    }

    public final void setJsStatus(int i) {
        this.jsStatus = i;
    }

    public final void setLifeStatus(int i) {
        this.lifeStatus = i;
    }

    public final void setParams(@NotNull GaiaX.Params params) {
        b41.i(params, "<set-?>");
        this.params = params;
    }

    public final void setRefreshTime$GaiaX_Android(long j) {
        this.refreshTime = j;
    }

    public final void setReleased(boolean z) {
        this.isReleased = z;
    }

    public final void setRootView(@Nullable View view) {
        this.rootView = view;
    }

    public final void setStepTime$GaiaX_Android(long j) {
        this.stepTime = j;
    }

    public final void setTraceId(int i) {
        this.traceId = i;
    }

    public final void setTypeStatus(int i) {
        this.typeStatus = i;
    }

    public final void uiTask(@NotNull final Function0<wt2> function0) {
        b41.i(function0, "task");
        FutureTask<wt2> futureTask = new FutureTask<>(new Callable() { // from class: com.youku.gaiax.impl.GaiaXContext$uiTask$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return wt2.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                GaiaXContext gaiaXContext = GaiaXContext.this;
                Function0<wt2> function02 = function0;
                synchronized (gaiaXContext) {
                    if (gaiaXContext.isReleased()) {
                        ExceptionUtils.INSTANCE.throwUiAlarm(gaiaXContext);
                    } else {
                        try {
                            function02.invoke();
                        } catch (Exception e) {
                            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(gaiaXContext, e);
                        }
                    }
                    wt2 wt2Var = wt2.INSTANCE;
                }
                GaiaXContext.this.uiTask = null;
            }
        });
        this.uiTask = futureTask;
        GaiaXUiExecutor.INSTANCE.action(futureTask);
    }

    public final void workerTask(@NotNull final Function0<wt2> function0) {
        b41.i(function0, "task");
        FutureTask<wt2> futureTask = new FutureTask<>(new Callable() { // from class: com.youku.gaiax.impl.GaiaXContext$workerTask$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return wt2.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                GaiaXContext gaiaXContext = GaiaXContext.this;
                Function0<wt2> function02 = function0;
                synchronized (gaiaXContext) {
                    if (gaiaXContext.isReleased()) {
                        ExceptionUtils.INSTANCE.throwWorkerAlarm(gaiaXContext);
                    } else {
                        try {
                            function02.invoke();
                        } catch (Exception e) {
                            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(gaiaXContext, e);
                        }
                    }
                    wt2 wt2Var = wt2.INSTANCE;
                }
                GaiaXContext.this.workTask = null;
            }
        });
        this.workTask = futureTask;
        GaiaXWorkerExecutor.INSTANCE.action(futureTask);
    }
}
