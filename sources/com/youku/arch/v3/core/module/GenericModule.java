package com.youku.arch.v3.core.module;

import android.app.Activity;
import android.taobao.windvane.connect.api.ApiResponse;
import android.util.SparseArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.arch.v3.Addressable;
import com.youku.arch.v3.ChildState;
import com.youku.arch.v3.GenericFactory;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ChildIndexUpdater;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.Coordinate;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.OnChildAttachStateChangeListener;
import com.youku.arch.v3.core.parser.DefaultModuleParser;
import com.youku.arch.v3.core.parser.IParser;
import com.youku.arch.v3.data.Repository;
import com.youku.arch.v3.event.ArchExceptionEvent;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.PagingLoader;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.util.PageUtil;
import com.youku.arch.v3.util.PerformanceLogUtil;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.wt2;
import tb.xl2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u0096\u0001*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002\u0096\u0001B\u0019\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010B\u001a\u00020\u0005¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001e\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\u0007J2\u0010\u001c\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0004\u0012\u00020\u001b0\u001a0\u00170\u0016H\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u0004H\u0016J\u0016\u0010 \u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050!H\u0016J\b\u0010#\u001a\u00020\u0007H\u0014J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0014J\u001e\u0010(\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J&\u0010(\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010)\u001a\u00020\u0012H\u0016J(\u0010(\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0016\u0010,\u001a\u00020\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\u001e\u0010,\u001a\u00020\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010)\u001a\u00020\u0012H\u0016J \u0010,\u001a\u00020\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u001c\u0010.\u001a\u00020\u00072\u0012\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u0004H\u0016J\u001e\u0010/\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\u0010\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0005H\u0016J\b\u00102\u001a\u00020\u0007H\u0016J\b\u00103\u001a\u00020\u0007H\u0016J\b\u00104\u001a\u00020\u0007H\u0016J\b\u00105\u001a\u00020\u0007H\u0016J&\u00108\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u000e2\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0016J\u0016\u0010:\u001a\u00020\u00122\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016R\"\u0010<\u001a\u00020;8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010B\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u00106\u001a\u00020%8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b6\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010M\u001a\u00028\u00008\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR(\u0010U\u001a\b\u0012\u0004\u0012\u00020T0S8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR.\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000[8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u0010c\u001a\u0004\u0018\u00010b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR6\u0010j\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0012\u0004\u0012\u00020\u0005\u0018\u00010i8V@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u00168\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b-\u0010pR\"\u0010q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bq\u0010pR@\u0010r\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0004\u0012\u00020\u001b0\u001a0\u00170\u00168\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\br\u0010pR@\u0010s\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0004\u0012\u00020\u001b0\u001a0\u00170\u00168\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bs\u0010pR\"\u0010u\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\"\u0010&\u001a\u00020%8V@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u0010H\u001a\u0004\bw\u0010J\"\u0004\bx\u0010LR\"\u0010z\u001a\u00020y8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR\u001f\u0010\u0080\u0001\u001a\u00020%8\u0016@\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b\u0080\u0001\u0010H\u001a\u0005\b\u0081\u0001\u0010JR,\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R,\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001a\u0010\u0093\u0001\u001a\u00030\u0090\u00018V@\u0016X\u0096\u0004¢\u0006\b\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001¨\u0006\u0097\u0001"}, d2 = {"Lcom/youku/arch/v3/core/module/GenericModule;", "Lcom/youku/arch/v3/core/ModuleValue;", ApiResponse.VALUE, "Lcom/youku/arch/v3/IModule;", "", "Lcom/youku/arch/v3/core/Node;", "nodes", "Ltb/wt2;", "createComponentsImpl", "Lcom/youku/arch/v3/io/IRequest;", "request", "Lcom/youku/arch/v3/io/Callback;", WXBridgeManager.METHOD_CALLBACK, "", "", "", Constants.CONFIG, "createRequest", "", "loadMore", xl2.HAS_NEXT, "reload", "", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "getAdapters", "Lcom/youku/arch/v3/IComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "getComponents", "createComponents", "Lcom/youku/arch/v3/core/Config;", "createComponent", "handleTitleComponent", "washData", "", "index", "component", "addComponent", "notifyUiUpdate", "Lcom/youku/arch/v3/core/OnChildAttachStateChangeListener;", "listener", "removeComponent", com.youku.arch.v3.data.Constants.COMPONENT, "updateComponents", "replaceComponent", "data", "initProperties", "updateChildIndex", "clearComponents", "onAdd", "onRemove", "type", "params", "onMessage", "target", "diff", "Lcom/youku/arch/v3/core/IContext;", com.youku.arch.v3.data.Constants.PAGE_CONTEXT, "Lcom/youku/arch/v3/core/IContext;", "getPageContext", "()Lcom/youku/arch/v3/core/IContext;", "setPageContext", "(Lcom/youku/arch/v3/core/IContext;)V", "node", "Lcom/youku/arch/v3/core/Node;", "getNode", "()Lcom/youku/arch/v3/core/Node;", "setNode", "(Lcom/youku/arch/v3/core/Node;)V", "I", "getType", "()I", "setType", "(I)V", "property", "Lcom/youku/arch/v3/core/ModuleValue;", "getProperty", "()Lcom/youku/arch/v3/core/ModuleValue;", "setProperty", "(Lcom/youku/arch/v3/core/ModuleValue;)V", "Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "container", "Lcom/youku/arch/v3/IContainer;", "getContainer", "()Lcom/youku/arch/v3/IContainer;", "setContainer", "(Lcom/youku/arch/v3/IContainer;)V", "Lcom/youku/arch/v3/core/parser/IParser;", "parser", "Lcom/youku/arch/v3/core/parser/IParser;", "getParser", "()Lcom/youku/arch/v3/core/parser/IParser;", "setParser", "(Lcom/youku/arch/v3/core/parser/IParser;)V", "Lcom/youku/arch/v3/loader/PagingLoader;", "moduleLoader", "Lcom/youku/arch/v3/loader/PagingLoader;", "getModuleLoader", "()Lcom/youku/arch/v3/loader/PagingLoader;", "setModuleLoader", "(Lcom/youku/arch/v3/loader/PagingLoader;)V", "Lcom/youku/arch/v3/GenericFactory;", "componentFactory", "Lcom/youku/arch/v3/GenericFactory;", "getComponentFactory", "()Lcom/youku/arch/v3/GenericFactory;", "setComponentFactory", "(Lcom/youku/arch/v3/GenericFactory;)V", "Ljava/util/List;", "unmodifiableComponents", "adapters", "unmodifiableAdapters", "Lcom/youku/arch/v3/core/ChildIndexUpdater;", "childIndexUpdater", "Lcom/youku/arch/v3/core/ChildIndexUpdater;", "getIndex", "setIndex", "Lcom/youku/arch/v3/ChildState;", "childState", "Lcom/youku/arch/v3/ChildState;", "getChildState", "()Lcom/youku/arch/v3/ChildState;", "setChildState", "(Lcom/youku/arch/v3/ChildState;)V", "childCount", "getChildCount", "Lcom/youku/arch/v3/io/RequestBuilder;", "requestBuilder", "Lcom/youku/arch/v3/io/RequestBuilder;", "getRequestBuilder", "()Lcom/youku/arch/v3/io/RequestBuilder;", "setRequestBuilder", "(Lcom/youku/arch/v3/io/RequestBuilder;)V", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", "Lcom/youku/arch/v3/event/EventHandler;", "getEventHandler", "()Lcom/youku/arch/v3/event/EventHandler;", "setEventHandler", "(Lcom/youku/arch/v3/event/EventHandler;)V", "Lcom/youku/arch/v3/core/Coordinate;", "getCoordinate", "()Lcom/youku/arch/v3/core/Coordinate;", "coordinate", "<init>", "(Lcom/youku/arch/v3/core/IContext;Lcom/youku/arch/v3/core/Node;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class GenericModule<VALUE extends ModuleValue> implements IModule<VALUE> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "OneArch.GenericModule";
    @JvmField
    @NotNull
    public final List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> adapters;
    private final int childCount;
    @NotNull
    private final ChildIndexUpdater<IComponent<ComponentValue>> childIndexUpdater;
    public ChildState childState;
    @Nullable
    private GenericFactory<IComponent<ComponentValue>, Node> componentFactory;
    @JvmField
    @NotNull
    public final List<IComponent<ComponentValue>> components;
    public IContainer<ModelValue> container;
    @Nullable
    private EventHandler eventHandler;
    private volatile int index;
    @Nullable
    private PagingLoader moduleLoader;
    @NotNull
    private Node node;
    @NotNull
    private IContext pageContext;
    public IParser<Node, VALUE> parser;
    public VALUE property;
    @Nullable
    private RequestBuilder requestBuilder;
    private int type;
    @JvmField
    @NotNull
    public final List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> unmodifiableAdapters;
    @JvmField
    @NotNull
    public final List<IComponent<ComponentValue>> unmodifiableComponents;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/core/module/GenericModule$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    public GenericModule(@NotNull IContext iContext, @NotNull Node node) {
        b41.i(iContext, com.youku.arch.v3.data.Constants.PAGE_CONTEXT);
        b41.i(node, "node");
        this.pageContext = iContext;
        this.node = node;
        this.type = -1;
        ArrayList arrayList = new ArrayList();
        this.components = arrayList;
        List<IComponent<ComponentValue>> unmodifiableList = Collections.unmodifiableList(arrayList);
        b41.h(unmodifiableList, "unmodifiableList(components)");
        this.unmodifiableComponents = unmodifiableList;
        ArrayList arrayList2 = new ArrayList();
        this.adapters = arrayList2;
        List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> unmodifiableList2 = Collections.unmodifiableList(arrayList2);
        b41.h(unmodifiableList2, "unmodifiableList(adapters)");
        this.unmodifiableAdapters = unmodifiableList2;
        this.childIndexUpdater = new ChildIndexUpdater<>();
        this.index = -1;
        this.childCount = arrayList.size();
    }

    private final void createComponentsImpl(List<? extends Node> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "166414143")) {
            ipChange.ipc$dispatch("166414143", new Object[]{this, list});
            return;
        }
        PerformanceLogUtil performanceLogUtil = PerformanceLogUtil.INSTANCE;
        performanceLogUtil.markStartPoint(getClass().getSimpleName() + ' ' + this + " createComponents");
        handleTitleComponent();
        int size = list.size() + (-1);
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                Node node = list.get(i);
                try {
                    IComponent<ComponentValue> createComponent = createComponent(new Config<>(getPageContext(), node.getType(), node, 0, false, 24, null));
                    if (createComponent != null) {
                        addComponent(this.components.size(), createComponent, false);
                    }
                } catch (Exception e) {
                    LogUtil.e(TAG, b41.r("createComponent exception ", e.getMessage()));
                    if (AppInfoProviderProxy.isDebuggable()) {
                        throw new RuntimeException(e);
                    }
                }
                if (i2 > size) {
                    break;
                }
                i = i2;
            }
        }
        PerformanceLogUtil performanceLogUtil2 = PerformanceLogUtil.INSTANCE;
        performanceLogUtil2.markEndPoint(getClass().getSimpleName() + ' ' + this + " createComponents");
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void addComponent(int i, @NotNull IComponent<ComponentValue> iComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-891235443")) {
            ipChange.ipc$dispatch("-891235443", new Object[]{this, Integer.valueOf(i), iComponent});
            return;
        }
        b41.i(iComponent, "component");
        addComponent(i, iComponent, (OnChildAttachStateChangeListener) null);
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void clearComponents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "676831719")) {
            ipChange.ipc$dispatch("676831719", new Object[]{this});
        } else {
            getPageContext().runOnLoaderThreadLocked(new Function0<wt2>(this) { // from class: com.youku.arch.v3.core.module.GenericModule$clearComponents$1
                private static transient /* synthetic */ IpChange $ipChange;
                final /* synthetic */ GenericModule<VALUE> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ wt2 invoke() {
                    invoke2();
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1532591756")) {
                        ipChange2.ipc$dispatch("-1532591756", new Object[]{this});
                        return;
                    }
                    GenericModule<VALUE> genericModule = this.this$0;
                    synchronized (genericModule.components) {
                        genericModule.components.clear();
                        wt2 wt2Var = wt2.INSTANCE;
                    }
                }
            });
        }
    }

    @Override // com.youku.arch.v3.IComponentManager
    @Nullable
    public IComponent<ComponentValue> createComponent(@NotNull Config<Node> config) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1433942193")) {
            return (IComponent) ipChange.ipc$dispatch("1433942193", new Object[]{this, config});
        }
        b41.i(config, Constants.CONFIG);
        GenericFactory<IComponent<ComponentValue>, Node> componentFactory = getComponentFactory();
        IComponent<ComponentValue> create = componentFactory == null ? null : componentFactory.create(config);
        if (create != null) {
            create.initProperties(config.getData());
            create.setModule(this);
            create.createItems();
        }
        return create;
    }

    @Override // com.youku.arch.v3.IModule
    public void createComponents(@NotNull List<? extends Node> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1950500353")) {
            ipChange.ipc$dispatch("-1950500353", new Object[]{this, list});
            return;
        }
        b41.i(list, "nodes");
        createComponentsImpl(washData(list));
    }

    @Override // com.youku.arch.v3.DomainObject
    @Nullable
    public IRequest createRequest(@NotNull Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1849403613")) {
            return (IRequest) ipChange.ipc$dispatch("1849403613", new Object[]{this, map});
        }
        b41.i(map, Constants.CONFIG);
        RequestBuilder requestBuilder = getRequestBuilder();
        if (requestBuilder == null) {
            return null;
        }
        return requestBuilder.build(map);
    }

    @Override // com.youku.arch.v3.Diff
    public /* bridge */ /* synthetic */ boolean diff(Object obj) {
        return diff((IModule) ((IModule) obj));
    }

    @Override // com.youku.arch.v3.IModule
    @NotNull
    public List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> getAdapters() {
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "666848887")) {
            return (List) ipChange.ipc$dispatch("666848887", new Object[]{this});
        }
        synchronized (this.components) {
            this.adapters.clear();
            Iterator<T> it = this.components.iterator();
            while (it.hasNext()) {
                IComponent iComponent = (IComponent) it.next();
                if (iComponent.getChildCount() > 0 && (adapter = iComponent.getAdapter()) != null) {
                    this.adapters.add(adapter);
                }
            }
            wt2 wt2Var = wt2.INSTANCE;
        }
        return this.unmodifiableAdapters;
    }

    @Override // com.youku.arch.v3.DomainObject
    public int getChildCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "410050900") ? ((Integer) ipChange.ipc$dispatch("410050900", new Object[]{this})).intValue() : this.childCount;
    }

    @Override // com.youku.arch.v3.IModule
    @NotNull
    public ChildState getChildState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1171076764")) {
            return (ChildState) ipChange.ipc$dispatch("-1171076764", new Object[]{this});
        }
        ChildState childState = this.childState;
        if (childState != null) {
            return childState;
        }
        b41.A("childState");
        return null;
    }

    @Override // com.youku.arch.v3.IComponentManager
    @Nullable
    public GenericFactory<IComponent<ComponentValue>, Node> getComponentFactory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1388149630")) {
            return (GenericFactory) ipChange.ipc$dispatch("1388149630", new Object[]{this});
        }
        if (this.componentFactory == null) {
            this.componentFactory = PageUtil.INSTANCE.getDefaultComponentFactory(getPageContext());
        }
        return this.componentFactory;
    }

    @Override // com.youku.arch.v3.IComponentManager
    @NotNull
    public List<IComponent<ComponentValue>> getComponents() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-522691127") ? (List) ipChange.ipc$dispatch("-522691127", new Object[]{this}) : this.unmodifiableComponents;
    }

    @Override // com.youku.arch.v3.IModule
    @NotNull
    public IContainer<ModelValue> getContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "38563723")) {
            return (IContainer) ipChange.ipc$dispatch("38563723", new Object[]{this});
        }
        IContainer<ModelValue> iContainer = this.container;
        if (iContainer != null) {
            return iContainer;
        }
        b41.A("container");
        return null;
    }

    @Override // com.youku.arch.v3.Addressable
    @NotNull
    public Coordinate getCoordinate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-351390798") ? (Coordinate) ipChange.ipc$dispatch("-351390798", new Object[]{this}) : new Coordinate(getIndex(), -2, -2);
    }

    @Override // com.youku.arch.v3.DomainObject
    @Nullable
    public EventHandler getEventHandler() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1979055921") ? (EventHandler) ipChange.ipc$dispatch("-1979055921", new Object[]{this}) : this.eventHandler;
    }

    @Override // com.youku.arch.v3.Addressable
    public int getIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1030477353")) {
            return ((Integer) ipChange.ipc$dispatch("-1030477353", new Object[]{this})).intValue();
        }
        getContainer().updateChildIndex();
        return this.index;
    }

    @Nullable
    public PagingLoader getModuleLoader() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1122322120") ? (PagingLoader) ipChange.ipc$dispatch("-1122322120", new Object[]{this}) : this.moduleLoader;
    }

    @NotNull
    public final Node getNode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-33225442") ? (Node) ipChange.ipc$dispatch("-33225442", new Object[]{this}) : this.node;
    }

    @Override // com.youku.arch.v3.DomainObject
    @NotNull
    public IContext getPageContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1803532702") ? (IContext) ipChange.ipc$dispatch("1803532702", new Object[]{this}) : this.pageContext;
    }

    @Override // com.youku.arch.v3.IModule
    @NotNull
    public IParser<Node, VALUE> getParser() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1010458965")) {
            return (IParser) ipChange.ipc$dispatch("-1010458965", new Object[]{this});
        }
        IParser<Node, VALUE> iParser = this.parser;
        if (iParser != null) {
            return iParser;
        }
        b41.A("parser");
        return null;
    }

    @Override // com.youku.arch.v3.IModule
    @NotNull
    public VALUE getProperty() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "953948484")) {
            return (VALUE) ipChange.ipc$dispatch("953948484", new Object[]{this});
        }
        VALUE value = this.property;
        if (value != null) {
            return value;
        }
        b41.A("property");
        return null;
    }

    @Override // com.youku.arch.v3.DomainObject
    @Nullable
    public RequestBuilder getRequestBuilder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1288547631") ? (RequestBuilder) ipChange.ipc$dispatch("-1288547631", new Object[]{this}) : this.requestBuilder;
    }

    @Override // com.youku.arch.v3.IModule
    public int getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1444203187") ? ((Integer) ipChange.ipc$dispatch("-1444203187", new Object[]{this})).intValue() : this.type;
    }

    protected void handleTitleComponent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2043189997")) {
            ipChange.ipc$dispatch("-2043189997", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.DomainObject
    public boolean hasNext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2043479231") ? ((Boolean) ipChange.ipc$dispatch("-2043479231", new Object[]{this})).booleanValue() : getProperty().getMore();
    }

    @Override // com.youku.arch.v3.DomainObject
    public void initProperties(@NotNull Node node) {
        ConfigManager.ParserConfig parserConfig;
        SparseArray<IParser<?, ?>> parsers;
        IParser<?, ?> iParser;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-600785665")) {
            ipChange.ipc$dispatch("-600785665", new Object[]{this, node});
            return;
        }
        b41.i(node, "data");
        ConfigManager configManager = getPageContext().getConfigManager();
        if (configManager == null || (parserConfig = configManager.getParserConfig(1)) == null || (parsers = parserConfig.getParsers()) == null || (iParser = parsers.get(0)) == null) {
            iParser = null;
        } else {
            setParser(iParser);
        }
        if (iParser == null) {
            setParser(new DefaultModuleParser());
        }
        setProperty(getParser().parseElement(node));
        setType(node.getType());
        List<Node> children = getProperty().getChildren();
        if (children != null && !children.isEmpty()) {
            z = false;
        }
        if ((z ? children : null) == null) {
            return;
        }
        VALUE property = getProperty();
        HashMap hashMap = new HashMap();
        hashMap.put("id", Long.valueOf(property.getId()));
        hashMap.put("type", Integer.valueOf(property.getType()));
        JSONObject data = property.getData();
        if (data != null) {
            hashMap.put("data", data);
        }
        JSONObject rawJson = property.getRawJson();
        if (rawJson != null) {
            hashMap.put("rawJson", rawJson);
        }
        EventDispatcher eventDispatcher = getPageContext().getEventDispatcher();
        if (eventDispatcher == null) {
            return;
        }
        eventDispatcher.dispatchEvent(ArchExceptionEvent.MODULE_CHILDREN_EMPTY, hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0035, code lost:
        if (r0.get(r0.size() - 1).loadMore() != false) goto L10;
     */
    @Override // com.youku.arch.v3.DomainObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean loadMore() {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.arch.v3.core.module.GenericModule.$ipChange
            java.lang.String r1 = "1801177929"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L1b
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r5
            java.lang.Object r0 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            return r0
        L1b:
            java.util.List<com.youku.arch.v3.IComponent<com.youku.arch.v3.core.ComponentValue>> r0 = r5.components
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r4
            if (r0 == 0) goto L39
            java.util.List<com.youku.arch.v3.IComponent<com.youku.arch.v3.core.ComponentValue>> r0 = r5.components
            int r1 = r0.size()
            int r1 = r1 - r4
            java.lang.Object r0 = r0.get(r1)
            com.youku.arch.v3.IComponent r0 = (com.youku.arch.v3.IComponent) r0
            boolean r0 = r0.loadMore()
            if (r0 == 0) goto L39
        L37:
            r3 = 1
            goto L77
        L39:
            com.youku.arch.v3.io.RequestBuilder r0 = r5.getRequestBuilder()
            if (r0 == 0) goto L63
            com.youku.arch.v3.loader.PagingLoader r0 = r5.getModuleLoader()
            if (r0 == 0) goto L63
            com.youku.arch.v3.loader.PagingLoader r0 = r5.getModuleLoader()
            tb.b41.f(r0)
            boolean r0 = r0.canLoadNextPage()
            if (r0 == 0) goto L63
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L63
            com.youku.arch.v3.loader.PagingLoader r0 = r5.getModuleLoader()
            tb.b41.f(r0)
            r0.loadNextPage()
            goto L37
        L63:
            com.youku.arch.v3.loader.PagingLoader r0 = r5.getModuleLoader()
            if (r0 == 0) goto L77
            com.youku.arch.v3.loader.PagingLoader r0 = r5.getModuleLoader()
            tb.b41.f(r0)
            boolean r0 = r0.isLoading()
            if (r0 == 0) goto L77
            goto L37
        L77:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.v3.core.module.GenericModule.loadMore():boolean");
    }

    @Override // com.youku.arch.v3.DomainObject
    public void onAdd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1340933432")) {
            ipChange.ipc$dispatch("-1340933432", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.event.EventHandler
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2047154461")) {
            return ((Boolean) ipChange.ipc$dispatch("2047154461", new Object[]{this, str, map})).booleanValue();
        }
        b41.i(str, "type");
        if (getEventHandler() != null) {
            EventHandler eventHandler = getEventHandler();
            b41.f(eventHandler);
            if (eventHandler.onMessage(str, map)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.youku.arch.v3.DomainObject
    public void onRemove() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1969298339")) {
            ipChange.ipc$dispatch("-1969298339", new Object[]{this});
        } else {
            setIndex(getIndex() - 1);
        }
    }

    public final void reload() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1569804551")) {
            ipChange.ipc$dispatch("1569804551", new Object[]{this});
            return;
        }
        PagingLoader moduleLoader = getModuleLoader();
        if (moduleLoader == null) {
            return;
        }
        moduleLoader.reload();
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void removeComponent(@NotNull IComponent<ComponentValue> iComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "951063871")) {
            ipChange.ipc$dispatch("951063871", new Object[]{this, iComponent});
            return;
        }
        b41.i(iComponent, "component");
        removeComponent(iComponent, (OnChildAttachStateChangeListener) null);
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void replaceComponent(int i, @NotNull final IComponent<ComponentValue> iComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-387147494")) {
            ipChange.ipc$dispatch("-387147494", new Object[]{this, Integer.valueOf(i), iComponent});
            return;
        }
        b41.i(iComponent, "component");
        iComponent.setIndex(this.components.get(i).getIndex());
        this.components.get(i).onRemove();
        this.components.set(i, iComponent);
        this.components.get(i).setModule(this);
        this.components.get(i).getModule().setPageContext(iComponent.getPageContext());
        iComponent.onAdd();
        getPageContext().runOnUIThreadLocked(new Function0<wt2>(this) { // from class: com.youku.arch.v3.core.module.GenericModule$replaceComponent$1
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ GenericModule<VALUE> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final wt2 invoke() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-37078509")) {
                    return (wt2) ipChange2.ipc$dispatch("-37078509", new Object[]{this});
                }
                this.this$0.getContainer().updateContentAdapter();
                iComponent.getModule().setIndex(this.this$0.getIndex());
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = iComponent.getAdapter();
                if (adapter == null) {
                    return null;
                }
                adapter.notifyItemRangeChanged(0, adapter.getItemCount());
                return wt2.INSTANCE;
            }
        });
    }

    @Override // com.youku.arch.v3.io.RequestClient
    public void request(@NotNull final IRequest iRequest, @NotNull final Callback callback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-224309700")) {
            ipChange.ipc$dispatch("-224309700", new Object[]{this, iRequest, callback});
            return;
        }
        b41.i(iRequest, "request");
        b41.i(callback, WXBridgeManager.METHOD_CALLBACK);
        getPageContext().runOnLoaderThread(new Function0<wt2>() { // from class: com.youku.arch.v3.core.module.GenericModule$request$1
            private static transient /* synthetic */ IpChange $ipChange;

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
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1000057024")) {
                    ipChange2.ipc$dispatch("1000057024", new Object[]{this});
                } else {
                    Repository.Companion.getInstance().request(IRequest.this, callback);
                }
            }
        });
    }

    @Override // com.youku.arch.v3.IModule
    public void setChildState(@NotNull ChildState childState) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2020417952")) {
            ipChange.ipc$dispatch("-2020417952", new Object[]{this, childState});
            return;
        }
        b41.i(childState, "<set-?>");
        this.childState = childState;
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void setComponentFactory(@Nullable GenericFactory<IComponent<ComponentValue>, Node> genericFactory) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1652729590")) {
            ipChange.ipc$dispatch("-1652729590", new Object[]{this, genericFactory});
        } else {
            this.componentFactory = genericFactory;
        }
    }

    @Override // com.youku.arch.v3.IModule
    public void setContainer(@NotNull IContainer<ModelValue> iContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1760407797")) {
            ipChange.ipc$dispatch("-1760407797", new Object[]{this, iContainer});
            return;
        }
        b41.i(iContainer, "<set-?>");
        this.container = iContainer;
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setEventHandler(@Nullable EventHandler eventHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1253750453")) {
            ipChange.ipc$dispatch("1253750453", new Object[]{this, eventHandler});
        } else {
            this.eventHandler = eventHandler;
        }
    }

    @Override // com.youku.arch.v3.Addressable
    public void setIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-331004397")) {
            ipChange.ipc$dispatch("-331004397", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.index = i;
        }
    }

    public void setModuleLoader(@Nullable PagingLoader pagingLoader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1140697226")) {
            ipChange.ipc$dispatch("1140697226", new Object[]{this, pagingLoader});
        } else {
            this.moduleLoader = pagingLoader;
        }
    }

    public final void setNode(@NotNull Node node) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-584587370")) {
            ipChange.ipc$dispatch("-584587370", new Object[]{this, node});
            return;
        }
        b41.i(node, "<set-?>");
        this.node = node;
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setPageContext(@NotNull IContext iContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1775328630")) {
            ipChange.ipc$dispatch("1775328630", new Object[]{this, iContext});
            return;
        }
        b41.i(iContext, "<set-?>");
        this.pageContext = iContext;
    }

    @Override // com.youku.arch.v3.IModule
    public void setParser(@NotNull IParser<Node, VALUE> iParser) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "196250813")) {
            ipChange.ipc$dispatch("196250813", new Object[]{this, iParser});
            return;
        }
        b41.i(iParser, "<set-?>");
        this.parser = iParser;
    }

    public void setProperty(@NotNull VALUE value) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1596683904")) {
            ipChange.ipc$dispatch("-1596683904", new Object[]{this, value});
            return;
        }
        b41.i(value, "<set-?>");
        this.property = value;
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setRequestBuilder(@Nullable RequestBuilder requestBuilder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1339847389")) {
            ipChange.ipc$dispatch("1339847389", new Object[]{this, requestBuilder});
        } else {
            this.requestBuilder = requestBuilder;
        }
    }

    public void setType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1909175819")) {
            ipChange.ipc$dispatch("-1909175819", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.type = i;
        }
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void updateChildIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1980396641")) {
            ipChange.ipc$dispatch("1980396641", new Object[]{this});
        } else if (this.childIndexUpdater.hasChanged()) {
            this.childIndexUpdater.updateChildIndex(this.components);
        }
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void updateComponents(@NotNull List<? extends IComponent<ComponentValue>> list) {
        int size;
        int size2;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-823922350")) {
            ipChange.ipc$dispatch("-823922350", new Object[]{this, list});
            return;
        }
        b41.i(list, com.youku.arch.v3.data.Constants.COMPONENT);
        if (list.size() < this.components.size() && (size2 = list.size()) <= (size = this.components.size() - 1)) {
            while (true) {
                int i2 = size - 1;
                removeComponent(this.components.get(size), true);
                if (size == size2) {
                    break;
                }
                size = i2;
            }
        }
        Activity activity = getPageContext().getActivity();
        if (activity != null) {
            Iterator<T> it = this.components.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                IComponent iComponent = (IComponent) it.next();
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = iComponent.getAdapter();
                if (adapter != null) {
                    adapter.setContext(activity);
                }
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter2 = iComponent.getAdapter();
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter = adapter2 != null ? adapter2.getInnerAdapter() : null;
                if (innerAdapter != null) {
                    innerAdapter.setContext(activity);
                }
            }
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                IComponent iComponent2 = (IComponent) it2.next();
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter3 = iComponent2.getAdapter();
                if (adapter3 != null) {
                    adapter3.setContext(activity);
                }
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter4 = iComponent2.getAdapter();
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter2 = adapter4 == null ? null : adapter4.getInnerAdapter();
                if (innerAdapter2 != null) {
                    innerAdapter2.setContext(activity);
                }
            }
        }
        int size3 = list.size() - 1;
        if (size3 < 0) {
            return;
        }
        while (true) {
            int i3 = i + 1;
            if (this.components.size() <= i) {
                PerformanceLogUtil performanceLogUtil = PerformanceLogUtil.INSTANCE;
                performanceLogUtil.markStartPoint(b41.r("add component for type: ", Integer.valueOf(list.get(i).getType())));
                addComponent(i, list.get(i), true);
                performanceLogUtil.markEndPoint(b41.r("add component for type: ", Integer.valueOf(list.get(i).getType())));
            } else if (list.get(i).diff(this.components.get(i))) {
                PerformanceLogUtil performanceLogUtil2 = PerformanceLogUtil.INSTANCE;
                performanceLogUtil2.markStartPoint(b41.r("diff component to replaceComponent for type: ", Integer.valueOf(list.get(i).getType())));
                replaceComponent(i, list.get(i));
                performanceLogUtil2.markEndPoint(b41.r("diff component to replaceComponent for type: ", Integer.valueOf(list.get(i).getType())));
            } else {
                PerformanceLogUtil performanceLogUtil3 = PerformanceLogUtil.INSTANCE;
                performanceLogUtil3.markStartPoint(b41.r("same component to updateItems for type: ", Integer.valueOf(list.get(i).getType())));
                this.components.get(i).updateItems(list.get(i).getItems());
                performanceLogUtil3.markEndPoint(b41.r("same component to updateItems for type: ", Integer.valueOf(list.get(i).getType())));
            }
            if (i3 > size3) {
                return;
            }
            i = i3;
        }
    }

    @NotNull
    protected List<Node> washData(@NotNull List<? extends Node> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1328008031")) {
            return (List) ipChange.ipc$dispatch("1328008031", new Object[]{this, list});
        }
        b41.i(list, "nodes");
        return list;
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void addComponent(int i, @NotNull final IComponent<ComponentValue> iComponent, final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1858449177")) {
            ipChange.ipc$dispatch("-1858449177", new Object[]{this, Integer.valueOf(i), iComponent, Boolean.valueOf(z)});
            return;
        }
        b41.i(iComponent, "component");
        addComponent(i, iComponent, new OnChildAttachStateChangeListener() { // from class: com.youku.arch.v3.core.module.GenericModule$addComponent$1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.arch.v3.core.OnChildAttachStateChangeListener
            public void onChildAdded(@NotNull Addressable addressable) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-585591132")) {
                    ipChange2.ipc$dispatch("-585591132", new Object[]{this, addressable});
                    return;
                }
                b41.i(addressable, "addressable");
                if (z) {
                    IContext pageContext = this.getPageContext();
                    final GenericModule<VALUE> genericModule = this;
                    final IComponent<ComponentValue> iComponent2 = iComponent;
                    pageContext.runOnUIThreadLocked(new Function0<wt2>() { // from class: com.youku.arch.v3.core.module.GenericModule$addComponent$1$onChildAdded$1
                        private static transient /* synthetic */ IpChange $ipChange;

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
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "462645967")) {
                                ipChange3.ipc$dispatch("462645967", new Object[]{this});
                                return;
                            }
                            genericModule.getContainer().updateContentAdapter();
                            if (iComponent2.getAdapter() != null) {
                                if (AppInfoProviderProxy.isDebuggable()) {
                                    LogUtil.v("OneArch.GenericModule", "notifyItemRangeInserted onAdd child " + genericModule.getChildCount() + AVFSCacheConstants.COMMA_SEP + genericModule.getCoordinate());
                                }
                                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = iComponent2.getAdapter();
                                if (adapter == null) {
                                    return;
                                }
                                adapter.notifyItemRangeInserted(0, iComponent2.getChildCount());
                            }
                        }
                    });
                }
            }

            @Override // com.youku.arch.v3.core.OnChildAttachStateChangeListener
            public void onChildRemoved(@NotNull Addressable addressable) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "692927428")) {
                    ipChange2.ipc$dispatch("692927428", new Object[]{this, addressable});
                } else {
                    b41.i(addressable, "addressable");
                }
            }
        });
    }

    public boolean diff(@NotNull IModule<VALUE> iModule) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1145704258")) {
            return ((Boolean) ipChange.ipc$dispatch("1145704258", new Object[]{this, iModule})).booleanValue();
        }
        b41.i(iModule, "target");
        return !b41.d(getProperty(), iModule.getProperty());
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void removeComponent(@NotNull final IComponent<ComponentValue> iComponent, final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-581745291")) {
            ipChange.ipc$dispatch("-581745291", new Object[]{this, iComponent, Boolean.valueOf(z)});
            return;
        }
        b41.i(iComponent, "component");
        removeComponent(iComponent, new OnChildAttachStateChangeListener() { // from class: com.youku.arch.v3.core.module.GenericModule$removeComponent$1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.arch.v3.core.OnChildAttachStateChangeListener
            public void onChildAdded(@NotNull Addressable addressable) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1639042943")) {
                    ipChange2.ipc$dispatch("-1639042943", new Object[]{this, addressable});
                } else {
                    b41.i(addressable, "addressable");
                }
            }

            @Override // com.youku.arch.v3.core.OnChildAttachStateChangeListener
            public void onChildRemoved(@NotNull Addressable addressable) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1938018913")) {
                    ipChange2.ipc$dispatch("1938018913", new Object[]{this, addressable});
                    return;
                }
                b41.i(addressable, "addressable");
                if (z) {
                    IContext pageContext = this.getPageContext();
                    final IComponent<ComponentValue> iComponent2 = iComponent;
                    final GenericModule<VALUE> genericModule = this;
                    pageContext.runOnUIThreadLocked(new Function0<wt2>() { // from class: com.youku.arch.v3.core.module.GenericModule$removeComponent$1$onChildRemoved$1
                        private static transient /* synthetic */ IpChange $ipChange;

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
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "203213900")) {
                                ipChange3.ipc$dispatch("203213900", new Object[]{this});
                                return;
                            }
                            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = iComponent2.getAdapter();
                            if (adapter != null) {
                                GenericModule<VALUE> genericModule2 = genericModule;
                                if (AppInfoProviderProxy.isDebuggable()) {
                                    LogUtil.v("OneArch.GenericModule", "notifyItemRangeRemoved removeComponent " + genericModule2.getChildCount() + " , " + genericModule2.getCoordinate());
                                }
                                adapter.notifyItemRangeRemoved(0, adapter.getItemCount());
                            }
                            genericModule.getContainer().updateContentAdapter();
                            if (genericModule.getChildState().hasChanged()) {
                                genericModule.getChildState().clearChanged();
                            }
                        }
                    });
                }
            }
        });
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void addComponent(final int i, @NotNull final IComponent<ComponentValue> iComponent, @Nullable final OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1064239010")) {
            ipChange.ipc$dispatch("-1064239010", new Object[]{this, Integer.valueOf(i), iComponent, onChildAttachStateChangeListener});
            return;
        }
        b41.i(iComponent, "component");
        getPageContext().runOnLoaderThreadLocked(new Function0<wt2>(this) { // from class: com.youku.arch.v3.core.module.GenericModule$addComponent$2
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ GenericModule<VALUE> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final wt2 invoke() {
                wt2 wt2Var;
                ChildIndexUpdater childIndexUpdater;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-122339193")) {
                    return (wt2) ipChange2.ipc$dispatch("-122339193", new Object[]{this});
                }
                GenericModule<VALUE> genericModule = this.this$0;
                List<IComponent<ComponentValue>> list = genericModule.components;
                int i2 = i;
                IComponent<ComponentValue> iComponent2 = iComponent;
                synchronized (list) {
                    genericModule.components.add(i2, iComponent2);
                    genericModule.components.get(i2).setModule(genericModule);
                    genericModule.components.get(i2).getModule().setPageContext(iComponent2.getPageContext());
                    wt2Var = wt2.INSTANCE;
                }
                childIndexUpdater = ((GenericModule) this.this$0).childIndexUpdater;
                childIndexUpdater.onChildAdded(iComponent);
                this.this$0.getChildState().setChanged();
                iComponent.onAdd();
                OnChildAttachStateChangeListener onChildAttachStateChangeListener2 = onChildAttachStateChangeListener;
                if (onChildAttachStateChangeListener2 == null) {
                    return null;
                }
                onChildAttachStateChangeListener2.onChildAdded(iComponent);
                return wt2Var;
            }
        });
    }

    @Override // com.youku.arch.v3.IComponentManager
    public void removeComponent(@NotNull final IComponent<ComponentValue> iComponent, @Nullable final OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-715459860")) {
            ipChange.ipc$dispatch("-715459860", new Object[]{this, iComponent, onChildAttachStateChangeListener});
            return;
        }
        b41.i(iComponent, "component");
        getPageContext().runOnLoaderThreadLocked(new Function0<wt2>(this) { // from class: com.youku.arch.v3.core.module.GenericModule$removeComponent$2
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ GenericModule<VALUE> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final wt2 invoke() {
                ChildIndexUpdater childIndexUpdater;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "615256074")) {
                    return (wt2) ipChange2.ipc$dispatch("615256074", new Object[]{this});
                }
                GenericModule<VALUE> genericModule = this.this$0;
                List<IComponent<ComponentValue>> list = genericModule.components;
                IComponent<ComponentValue> iComponent2 = iComponent;
                synchronized (list) {
                    genericModule.components.remove(iComponent2);
                }
                iComponent.onRemove();
                childIndexUpdater = ((GenericModule) this.this$0).childIndexUpdater;
                childIndexUpdater.onChildRemoved(iComponent);
                this.this$0.getChildState().setChanged();
                OnChildAttachStateChangeListener onChildAttachStateChangeListener2 = onChildAttachStateChangeListener;
                if (onChildAttachStateChangeListener2 == null) {
                    return null;
                }
                onChildAttachStateChangeListener2.onChildRemoved(iComponent);
                return wt2.INSTANCE;
            }
        });
    }
}
