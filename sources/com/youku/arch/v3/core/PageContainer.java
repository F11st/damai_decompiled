package com.youku.arch.v3.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Looper;
import android.taobao.windvane.connect.api.ApiResponse;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.arch.v3.Addressable;
import com.youku.arch.v3.ChildState;
import com.youku.arch.v3.GenericFactory;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.ICreator;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.adapter.ContentAdapter;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.adapter.VDefaultAdapter;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.parser.DefaultModelParser;
import com.youku.arch.v3.core.parser.IParser;
import com.youku.arch.v3.data.Repository;
import com.youku.arch.v3.event.BusinessEvent;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.PageLoader;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.recyclerview.GenericRecycledViewPool;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.util.PageUtil;
import com.youku.arch.v3.util.PerformanceLogUtil;
import com.youku.arch.v3.util.Util;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$IntRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.wt2;
import tb.xl2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 ¤\u0001*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002¤\u0001B\u001b\u0012\u0006\u0010B\u001a\u00020A\u0012\b\u0010H\u001a\u0004\u0018\u00010'¢\u0006\u0006\b¢\u0001\u0010£\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J$\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u000eH\u0002JF\u0010\u0017\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u00160\u00150\u00120\u00112\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0011H\u0002J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u001e\u0010 \u001a\u0004\u0018\u00010\u00182\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\nH\u0016J\u0014\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0011H\u0016J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020'0&H\u0016J\u001e\u0010*\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J(\u0010*\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J&\u0010*\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010-\u001a\u00020!H\u0016J\u001e\u0010.\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J(\u0010.\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0016\u0010/\u001a\u00020\n2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J \u0010/\u001a\u00020\n2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u001e\u0010/\u001a\u00020\n2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010-\u001a\u00020!H\u0016J\u0016\u00100\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020'0\u0011H\u0016J\u0016\u00102\u001a\u00020\n2\f\u00101\u001a\b\u0012\u0004\u0012\u00020'0\u0011H\u0016J\u001c\u00103\u001a\u00020\n2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0011H\u0016J\b\u00104\u001a\u00020\nH\u0016J:\u00106\u001a\u00020\n20\u00105\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u00160\u00150\u00120\u0011H\u0016J\b\u00107\u001a\u00020\nH\u0016J\u0010\u00109\u001a\u00020\n2\u0006\u00108\u001a\u00020'H\u0016J&\u0010<\u001a\u00020!2\u0006\u0010:\u001a\u00020\u001d2\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001cH\u0016J\b\u0010=\u001a\u00020\nH\u0016J\b\u0010>\u001a\u00020\nH\u0016J\b\u0010?\u001a\u00020\nH\u0016J\b\u0010@\u001a\u00020\nH\u0017R\"\u0010B\u001a\u00020A8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010H\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010O\u001a\u00020N8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010V\u001a\u00020U8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[Rd\u0010]\u001aD\u0012*\u0012(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u0012\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001c\u0018\u00010\\8V@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR@\u00105\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u00160\u00150\u00120\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010cR/\u0010g\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020'0\\8V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010`R\"\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00118\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010cR\"\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00118\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bh\u0010cR$\u0010j\u001a\u0004\u0018\u00010i8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010p\u001a\u00028\u00008\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u0016\u0010w\u001a\u00020v8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\"\u0010z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R'\u0010}\u001a\u0004\u0018\u00010|8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R6\u0010\u0084\u0001\u001a\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00028\u00000\u0083\u00018\u0016@\u0016X\u0096.¢\u0006\u0018\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R)\u0010\u008a\u0001\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R'\u0010:\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0017\n\u0005\b:\u0010\u008b\u0001\u001a\u0006\b\u0090\u0001\u0010\u008d\u0001\"\u0006\b\u0091\u0001\u0010\u008f\u0001R'\u0010\u0005\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0017\n\u0005\b\u0005\u0010\u008b\u0001\u001a\u0006\b\u0092\u0001\u0010\u008d\u0001\"\u0006\b\u0093\u0001\u0010\u008f\u0001R\"\u0010\u0095\u0001\u001a\u00030\u0094\u00018\u0016@\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001RC\u0010\u009b\u0001\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u00160\u00150\u00120\u00118V@\u0016X\u0096\u0004¢\u0006\b\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R%\u0010\u009d\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00118V@\u0016X\u0096\u0004¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u009a\u0001R\u0019\u0010\u009f\u0001\u001a\u00020\u00048V@\u0016X\u0096\u0004¢\u0006\b\u001a\u0006\b\u009e\u0001\u0010\u008d\u0001R\u0019\u0010 \u0001\u001a\u00020!8V@\u0016X\u0096\u0004¢\u0006\b\u001a\u0006\b \u0001\u0010¡\u0001¨\u0006¥\u0001"}, d2 = {"Lcom/youku/arch/v3/core/PageContainer;", "Lcom/youku/arch/v3/core/ModelValue;", ApiResponse.VALUE, "Lcom/youku/arch/v3/IContainer;", "", "index", "Lcom/youku/arch/v3/IModule;", "Lcom/youku/arch/v3/core/ModuleValue;", "oldModule", "newModule", "Ltb/wt2;", "replaceModuleImpl", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "pool", "", "modules", "preLoadViewHolder", "", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "getAdapters", "Lcom/youku/arch/v3/io/IRequest;", "request", "Lcom/youku/arch/v3/io/Callback;", WXBridgeManager.METHOD_CALLBACK, "", "", "", Constants.CONFIG, "createRequest", "", "loadMore", xl2.HAS_NEXT, "reload", "getModules", "Lcom/youku/arch/v3/core/Config;", "Lcom/youku/arch/v3/core/Node;", "createModule", "module", "addModule", "Lcom/youku/arch/v3/core/OnChildAttachStateChangeListener;", "listener", "notifyUiUpdate", "replaceModule", "removeModule", "updateModules", "nodes", "createModules", "preAsyncLoadMVP", "clearModules", "adapters", "addChildAdapters", "updateContentAdapter", "data", "initProperties", "type", "params", "onMessage", "onAdd", "onRemove", "updateChildIndex", "notifyFirstScreenRender", "Lcom/youku/arch/v3/core/IContext;", com.youku.arch.v3.data.Constants.PAGE_CONTEXT, "Lcom/youku/arch/v3/core/IContext;", "getPageContext", "()Lcom/youku/arch/v3/core/IContext;", "setPageContext", "(Lcom/youku/arch/v3/core/IContext;)V", "node", "Lcom/youku/arch/v3/core/Node;", "getNode", "()Lcom/youku/arch/v3/core/Node;", "setNode", "(Lcom/youku/arch/v3/core/Node;)V", "Lcom/youku/arch/v3/loader/PageLoader;", "pageLoader", "Lcom/youku/arch/v3/loader/PageLoader;", "getPageLoader", "()Lcom/youku/arch/v3/loader/PageLoader;", "setPageLoader", "(Lcom/youku/arch/v3/loader/PageLoader;)V", "Lcom/youku/arch/v3/adapter/ContentAdapter;", "contentAdapter", "Lcom/youku/arch/v3/adapter/ContentAdapter;", "getContentAdapter", "()Lcom/youku/arch/v3/adapter/ContentAdapter;", "setContentAdapter", "(Lcom/youku/arch/v3/adapter/ContentAdapter;)V", "Lcom/youku/arch/v3/GenericFactory;", "adapterFactory", "Lcom/youku/arch/v3/GenericFactory;", "getAdapterFactory", "()Lcom/youku/arch/v3/GenericFactory;", "setAdapterFactory", "(Lcom/youku/arch/v3/GenericFactory;)V", "Ljava/util/List;", "moduleFactory$delegate", "Lkotlin/Lazy;", "getModuleFactory", "moduleFactory", "unmodifiableModules", "Lcom/youku/arch/v3/io/RequestBuilder;", "requestBuilder", "Lcom/youku/arch/v3/io/RequestBuilder;", "getRequestBuilder", "()Lcom/youku/arch/v3/io/RequestBuilder;", "setRequestBuilder", "(Lcom/youku/arch/v3/io/RequestBuilder;)V", "property", "Lcom/youku/arch/v3/core/ModelValue;", "getProperty", "()Lcom/youku/arch/v3/core/ModelValue;", "setProperty", "(Lcom/youku/arch/v3/core/ModelValue;)V", "Lcom/youku/arch/v3/ChildState;", "childState", "Lcom/youku/arch/v3/ChildState;", "Lcom/youku/arch/v3/core/ChildIndexUpdater;", "childIndexUpdater", "Lcom/youku/arch/v3/core/ChildIndexUpdater;", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", "Lcom/youku/arch/v3/event/EventHandler;", "getEventHandler", "()Lcom/youku/arch/v3/event/EventHandler;", "setEventHandler", "(Lcom/youku/arch/v3/event/EventHandler;)V", "Lcom/youku/arch/v3/core/parser/IParser;", "parser", "Lcom/youku/arch/v3/core/parser/IParser;", "getParser", "()Lcom/youku/arch/v3/core/parser/IParser;", "setParser", "(Lcom/youku/arch/v3/core/parser/IParser;)V", "refreshThreshold", "I", "getRefreshThreshold", "()I", "setRefreshThreshold", "(I)V", "getType", "setType", "getIndex", "setIndex", "Lcom/youku/arch/v3/core/Coordinate;", "coordinate", "Lcom/youku/arch/v3/core/Coordinate;", "getCoordinate", "()Lcom/youku/arch/v3/core/Coordinate;", "getChildAdapters", "()Ljava/util/List;", "childAdapters", "getCurrentModules", "currentModules", "getChildCount", "childCount", "isChildStateDirty", "()Z", "<init>", "(Lcom/youku/arch/v3/core/IContext;Lcom/youku/arch/v3/core/Node;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class PageContainer<VALUE extends ModelValue> implements IContainer<VALUE> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "OneArch.PageContainer";
    @Nullable
    private GenericFactory<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>, Map<String, Object>> adapterFactory;
    @NotNull
    private List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> adapters;
    @NotNull
    private ChildIndexUpdater<IModule<ModuleValue>> childIndexUpdater;
    @NotNull
    private ChildState childState;
    public ContentAdapter contentAdapter;
    @NotNull
    private final Coordinate coordinate;
    @Nullable
    private EventHandler eventHandler;
    private int index;
    @NotNull
    private final Lazy moduleFactory$delegate;
    @JvmField
    @NotNull
    public final List<IModule<ModuleValue>> modules;
    @Nullable
    private Node node;
    @NotNull
    private IContext pageContext;
    public PageLoader pageLoader;
    public IParser<Node, VALUE> parser;
    public VALUE property;
    private int refreshThreshold;
    @Nullable
    private RequestBuilder requestBuilder;
    private int type;
    @JvmField
    @NotNull
    public final List<IModule<ModuleValue>> unmodifiableModules;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/core/PageContainer$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    public PageContainer(@NotNull IContext iContext, @Nullable Node node) {
        Lazy b;
        b41.i(iContext, com.youku.arch.v3.data.Constants.PAGE_CONTEXT);
        this.pageContext = iContext;
        this.node = node;
        this.adapters = new ArrayList();
        b = C8177b.b(new Function0<GenericFactory<IModule<ModuleValue>, Node>>(this) { // from class: com.youku.arch.v3.core.PageContainer$moduleFactory$2
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ PageContainer<VALUE> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GenericFactory<IModule<ModuleValue>, Node> invoke() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-757509455") ? (GenericFactory) ipChange.ipc$dispatch("-757509455", new Object[]{this}) : PageUtil.INSTANCE.getDefaultModuleFactory(this.this$0.getPageContext());
            }
        });
        this.moduleFactory$delegate = b;
        ArrayList arrayList = new ArrayList();
        this.modules = arrayList;
        List<IModule<ModuleValue>> unmodifiableList = Collections.unmodifiableList(arrayList);
        b41.h(unmodifiableList, "unmodifiableList(modules)");
        this.unmodifiableModules = unmodifiableList;
        this.childState = new ChildState();
        this.childIndexUpdater = new ChildIndexUpdater<>();
        this.refreshThreshold = 7;
        this.coordinate = new Coordinate(-2, -2, -2);
    }

    private final List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> getAdapters(List<IModule<ModuleValue>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1953855626")) {
            return (List) ipChange.ipc$dispatch("1953855626", new Object[]{this, list});
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(((IModule) it.next()).getAdapters());
        }
        List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> unmodifiableList = Collections.unmodifiableList(arrayList);
        b41.h(unmodifiableList, "unmodifiableList(adapters)");
        return unmodifiableList;
    }

    private final void preLoadViewHolder(RecyclerView.RecycledViewPool recycledViewPool, List<? extends IModule<ModuleValue>> list) {
        IModule<ModuleValue> iModule;
        int i;
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> create;
        GenericFragment fragment;
        List<? extends IModule<ModuleValue>> list2 = list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-636532384")) {
            ipChange.ipc$dispatch("-636532384", new Object[]{this, recycledViewPool, list2});
            return;
        }
        final GenericRecycledViewPool genericRecycledViewPool = (GenericRecycledViewPool) recycledViewPool;
        int size = list.size();
        GenericFactory<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>, Map<String, Object>> adapterFactory = getAdapterFactory();
        ICreator<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>, Map<String, Object>> defaultCreator = adapterFactory == null ? null : adapterFactory.getDefaultCreator();
        final SparseArray sparseArray = new SparseArray();
        if (size > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                IModule<ModuleValue> iModule2 = list2.get(i2);
                int size2 = iModule2.getComponents().size() - 1;
                if (size2 >= 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        IComponent<ComponentValue> iComponent = iModule2.getComponents().get(i4);
                        int size3 = iComponent.getItems().size() - 1;
                        if (size3 >= 0) {
                            int i6 = 0;
                            while (true) {
                                int i7 = i6 + 1;
                                IItem<ItemValue> iItem = iComponent.getItems().get(i6);
                                int type = iItem.getType();
                                int viewHolderMaxSize = genericRecycledViewPool.getViewHolderMaxSize(type) - genericRecycledViewPool.getRecycledViewCount(type);
                                if (viewHolderMaxSize > 0) {
                                    HashMap hashMap = new HashMap(8);
                                    iModule = iModule2;
                                    hashMap.put("data", iComponent.getItems());
                                    hashMap.put("render", null);
                                    hashMap.put("pageName", getPageContext().getPageName());
                                    hashMap.put(com.youku.arch.v3.data.Constants.PAGE_CONTEXT, getPageContext());
                                    if (defaultCreator == null) {
                                        i = type;
                                        create = null;
                                    } else {
                                        i = type;
                                        create = defaultCreator.create(new Config<>(getPageContext(), i, hashMap, 0, false, 24, null));
                                    }
                                    if (create != null) {
                                        create.setData(iComponent.getItems());
                                        if ((create instanceof VDefaultAdapter) && (fragment = getPageContext().getFragment()) != null) {
                                            RecyclerView recyclerView = fragment.getRecyclerView();
                                            b41.f(recyclerView);
                                            VH createViewHolder = ((VDefaultAdapter) create).createViewHolder(recyclerView, i);
                                            VBaseHolder vBaseHolder = (VBaseHolder) createViewHolder;
                                            vBaseHolder.resetData(iItem);
                                            b41.h(createViewHolder, "adapter.createViewHolder…                        }");
                                            if (sparseArray.indexOfKey(i) < 0) {
                                                sparseArray.put(i, new ArrayList());
                                            }
                                            if (((List) sparseArray.get(i)).size() < viewHolderMaxSize) {
                                                ((List) sparseArray.get(i)).add(vBaseHolder);
                                            }
                                        }
                                    }
                                } else {
                                    iModule = iModule2;
                                }
                                if (i7 > size3) {
                                    break;
                                }
                                i6 = i7;
                                iModule2 = iModule;
                            }
                        } else {
                            iModule = iModule2;
                        }
                        if (i5 > size2) {
                            break;
                        }
                        i4 = i5;
                        iModule2 = iModule;
                    }
                }
                if (i3 >= size) {
                    break;
                }
                list2 = list;
                i2 = i3;
            }
        }
        getPageContext().runOnUIThreadLocked(new Function0<wt2>() { // from class: com.youku.arch.v3.core.PageContainer$preLoadViewHolder$2
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
                int i8 = 0;
                if (AndroidInstantRuntime.support(ipChange2, "978836624")) {
                    ipChange2.ipc$dispatch("978836624", new Object[]{this});
                    return;
                }
                int size4 = sparseArray.size();
                if (size4 <= 0) {
                    return;
                }
                while (true) {
                    int i9 = i8 + 1;
                    int keyAt = sparseArray.keyAt(i8);
                    for (RecyclerView.ViewHolder viewHolder : sparseArray.get(keyAt)) {
                        genericRecycledViewPool.putRecycledView(viewHolder);
                    }
                    if (AppInfoProviderProxy.isDebuggable()) {
                        Log.e("preLoadMVP", "==putRecycledView===type===" + keyAt + "==count==" + sparseArray.get(keyAt).size() + "==getRecycledViewCount==" + genericRecycledViewPool.getRecycledViewCount(keyAt) + "==getMaxSize===" + genericRecycledViewPool.getViewHolderMaxSize(keyAt));
                    }
                    if (i9 >= size4) {
                        return;
                    }
                    i8 = i9;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void replaceModuleImpl(final int i, final IModule<ModuleValue> iModule, final IModule<ModuleValue> iModule2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "326267837")) {
            ipChange.ipc$dispatch("326267837", new Object[]{this, Integer.valueOf(i), iModule, iModule2});
        } else {
            getPageContext().runOnLoaderThreadLocked(new Function0<wt2>(this) { // from class: com.youku.arch.v3.core.PageContainer$replaceModuleImpl$1
                private static transient /* synthetic */ IpChange $ipChange;
                final /* synthetic */ PageContainer<VALUE> this$0;

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
                    ChildState childState;
                    ChildIndexUpdater childIndexUpdater;
                    ChildIndexUpdater childIndexUpdater2;
                    List list;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "176858197")) {
                        ipChange2.ipc$dispatch("176858197", new Object[]{this});
                        return;
                    }
                    childState = ((PageContainer) this.this$0).childState;
                    childState.setChanged();
                    this.this$0.modules.remove(iModule);
                    iModule.onRemove();
                    childIndexUpdater = ((PageContainer) this.this$0).childIndexUpdater;
                    childIndexUpdater.onChildRemoved(iModule);
                    iModule2.setIndex(i);
                    this.this$0.modules.add(i, iModule2);
                    if (AppInfoProviderProxy.isDebuggable()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("addModule  index is ");
                        sb.append(i);
                        sb.append(", adapter size ");
                        list = ((PageContainer) this.this$0).adapters;
                        sb.append(list.size());
                        LogUtil.v("OneArch.PageContainer", sb.toString());
                    }
                    iModule2.onAdd();
                    childIndexUpdater2 = ((PageContainer) this.this$0).childIndexUpdater;
                    childIndexUpdater2.onChildAdded(iModule2);
                    IContext pageContext = this.this$0.getPageContext();
                    final PageContainer<VALUE> pageContainer = this.this$0;
                    final IModule<ModuleValue> iModule3 = iModule2;
                    pageContext.runOnUIThreadLocked(new Function0<wt2>() { // from class: com.youku.arch.v3.core.PageContainer$replaceModuleImpl$1.1
                        private static transient /* synthetic */ IpChange $ipChange;

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
                            if (AndroidInstantRuntime.support(ipChange3, "-1568486302")) {
                                ipChange3.ipc$dispatch("-1568486302", new Object[]{this});
                                return;
                            }
                            pageContainer.updateContentAdapter();
                            Iterator<T> it = iModule3.getComponents().iterator();
                            while (it.hasNext()) {
                                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = ((IComponent) it.next()).getAdapter();
                                if (adapter != null) {
                                    adapter.notifyItemRangeChanged(0, adapter.getItemCount());
                                }
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.youku.arch.v3.IContainer
    public void addChildAdapters(@NotNull final List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-821620458")) {
            ipChange.ipc$dispatch("-821620458", new Object[]{this, list});
            return;
        }
        b41.i(list, "adapters");
        getPageContext().runOnUIThreadLocked(new Function0<ContentAdapter>(this) { // from class: com.youku.arch.v3.core.PageContainer$addChildAdapters$1
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ PageContainer<VALUE> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ContentAdapter invoke() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "243747228")) {
                    return (ContentAdapter) ipChange2.ipc$dispatch("243747228", new Object[]{this});
                }
                this.this$0.getPageLoader().getLoadingViewManager().onLoadNextSuccess();
                ContentAdapter contentAdapter = this.this$0.getContentAdapter();
                List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> list2 = list;
                int adaptersCount = contentAdapter.getAdaptersCount();
                if (!(list2 instanceof List)) {
                    list2 = null;
                }
                contentAdapter.addAdapters(adaptersCount, list2);
                return contentAdapter;
            }
        });
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void addModule(int i, @NotNull IModule<ModuleValue> iModule) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "166495791")) {
            ipChange.ipc$dispatch("166495791", new Object[]{this, Integer.valueOf(i), iModule});
            return;
        }
        b41.i(iModule, "module");
        addModule(i, iModule, (OnChildAttachStateChangeListener) null);
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void clearModules() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-736633750")) {
            ipChange.ipc$dispatch("-736633750", new Object[]{this});
        } else {
            getPageContext().runOnLoaderThreadLocked(new Function0<wt2>(this) { // from class: com.youku.arch.v3.core.PageContainer$clearModules$1
                private static transient /* synthetic */ IpChange $ipChange;
                final /* synthetic */ PageContainer<VALUE> this$0;

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
                    ChildState childState;
                    ChildIndexUpdater childIndexUpdater;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1197886591")) {
                        ipChange2.ipc$dispatch("-1197886591", new Object[]{this});
                        return;
                    }
                    Iterator<IModule<ModuleValue>> it = this.this$0.modules.iterator();
                    PageContainer<VALUE> pageContainer = this.this$0;
                    while (it.hasNext()) {
                        IModule<ModuleValue> next = it.next();
                        it.remove();
                        next.onRemove();
                        childState = ((PageContainer) pageContainer).childState;
                        childState.setChanged();
                        childIndexUpdater = ((PageContainer) pageContainer).childIndexUpdater;
                        childIndexUpdater.onChildRemoved(next);
                    }
                    this.this$0.modules.clear();
                }
            });
        }
    }

    @Override // com.youku.arch.v3.IModuleManager
    @NotNull
    public IModule<ModuleValue> createModule(@NotNull Config<Node> config) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "597585193")) {
            return (IModule) ipChange.ipc$dispatch("597585193", new Object[]{this, config});
        }
        b41.i(config, Constants.CONFIG);
        IModule<ModuleValue> create = getModuleFactory().create(config);
        b41.f(create);
        IModule<ModuleValue> iModule = create;
        iModule.initProperties(config.getData());
        iModule.setChildState(this.childState);
        iModule.setContainer(this);
        iModule.setIndex(config.getIndex());
        List<Node> children = iModule.getProperty().getChildren();
        if (children != null) {
            iModule.createComponents(children);
        }
        return iModule;
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void createModules(@NotNull final List<Node> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "259145164")) {
            ipChange.ipc$dispatch("259145164", new Object[]{this, list});
            return;
        }
        b41.i(list, "nodes");
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        getPageContext().runOnLoaderThreadLocked(new Function0<wt2>(this) { // from class: com.youku.arch.v3.core.PageContainer$createModules$1
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ PageContainer<VALUE> this$0;

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
                IModule<ModuleValue> iModule;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-998930688")) {
                    ipChange2.ipc$dispatch("-998930688", new Object[]{this});
                    return;
                }
                final int size = this.this$0.modules.size();
                ref$IntRef.element = size - 1;
                int size2 = list.size() - 1;
                if (size2 >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        try {
                            IContainer iContainer = this.this$0;
                            iModule = iContainer.createModule(new Config<>(iContainer.getPageContext(), list.get(i).getType(), list.get(i), i + size, false, 16, null));
                        } catch (Exception e) {
                            Log.e("OneArch.PageContainer", "create module error " + list.get(i).getType() + ((Object) e.getMessage()));
                            if (AppInfoProviderProxy.isDebuggable()) {
                                throw new RuntimeException(e);
                            }
                            iModule = null;
                        }
                        if (iModule != null) {
                            int i3 = i + size;
                            this.this$0.addModule(i3, iModule, false);
                            if (i3 == this.this$0.getRefreshThreshold()) {
                                if (size == 0) {
                                    this.this$0.notifyFirstScreenRender();
                                } else {
                                    IContext pageContext = this.this$0.getPageContext();
                                    final PageContainer<VALUE> pageContainer = this.this$0;
                                    pageContext.runOnUIThreadLocked(new Function0<wt2>() { // from class: com.youku.arch.v3.core.PageContainer$createModules$1.1
                                        private static transient /* synthetic */ IpChange $ipChange;

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
                                            if (AndroidInstantRuntime.support(ipChange3, "-1925205939")) {
                                                ipChange3.ipc$dispatch("-1925205939", new Object[]{this});
                                                return;
                                            }
                                            pageContainer.updateContentAdapter();
                                            PageContainer<VALUE> pageContainer2 = pageContainer;
                                            for (IModule<ModuleValue> iModule2 : pageContainer2.modules.subList(size, pageContainer2.getRefreshThreshold() + 1)) {
                                                List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> adapters = iModule2.getAdapters();
                                                if (adapters.size() > 0) {
                                                    for (VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter : adapters) {
                                                        vBaseAdapter.notifyItemRangeInserted(0, vBaseAdapter.getItemCount());
                                                    }
                                                }
                                            }
                                        }
                                    });
                                }
                                ref$IntRef.element = i3;
                            }
                        }
                        if (i2 > size2) {
                            break;
                        }
                        i = i2;
                    }
                }
                if (ref$IntRef.element < this.this$0.modules.size()) {
                    if (ref$IntRef.element == -1) {
                        this.this$0.notifyFirstScreenRender();
                        return;
                    }
                    IContext pageContext2 = this.this$0.getPageContext();
                    final PageContainer<VALUE> pageContainer2 = this.this$0;
                    final Ref$IntRef ref$IntRef2 = ref$IntRef;
                    pageContext2.runOnUIThreadLocked(new Function0<wt2>() { // from class: com.youku.arch.v3.core.PageContainer$createModules$1.2
                        private static transient /* synthetic */ IpChange $ipChange;

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
                            if (AndroidInstantRuntime.support(ipChange3, "2076358350")) {
                                ipChange3.ipc$dispatch("2076358350", new Object[]{this});
                                return;
                            }
                            pageContainer2.updateContentAdapter();
                            List<IModule<ModuleValue>> list2 = pageContainer2.modules;
                            for (IModule<ModuleValue> iModule2 : list2.subList(ref$IntRef2.element + 1, list2.size())) {
                                for (VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter : iModule2.getAdapters()) {
                                    vBaseAdapter.notifyItemRangeInserted(0, vBaseAdapter.getItemCount());
                                }
                            }
                        }
                    });
                }
            }
        });
    }

    @Override // com.youku.arch.v3.DomainObject
    @Nullable
    public IRequest createRequest(@NotNull Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1009489921")) {
            return (IRequest) ipChange.ipc$dispatch("1009489921", new Object[]{this, map});
        }
        b41.i(map, Constants.CONFIG);
        RequestBuilder requestBuilder = getRequestBuilder();
        if (requestBuilder == null) {
            return null;
        }
        return requestBuilder.build(map);
    }

    @Override // com.youku.arch.v3.IContainer
    @Nullable
    public GenericFactory<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>, Map<String, Object>> getAdapterFactory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1342433968")) {
            return (GenericFactory) ipChange.ipc$dispatch("-1342433968", new Object[]{this});
        }
        if (this.adapterFactory == null) {
            this.adapterFactory = PageUtil.INSTANCE.getDefaultAdapterFactory(getPageContext());
        }
        return this.adapterFactory;
    }

    @Override // com.youku.arch.v3.IContainer
    @NotNull
    public List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> getChildAdapters() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1736177619")) {
            return (List) ipChange.ipc$dispatch("-1736177619", new Object[]{this});
        }
        Util.throwIf(!b41.d(Looper.getMainLooper(), Looper.myLooper()));
        if (this.childState.hasChanged()) {
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.d(TAG, "getChildAdapters update");
            }
            return getAdapters(this.modules);
        }
        return this.adapters;
    }

    @Override // com.youku.arch.v3.IModuleManager, com.youku.arch.v3.DomainObject
    public int getChildCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1746430032") ? ((Integer) ipChange.ipc$dispatch("-1746430032", new Object[]{this})).intValue() : this.modules.size();
    }

    @Override // com.youku.arch.v3.IContainer
    @NotNull
    public ContentAdapter getContentAdapter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-83579160")) {
            return (ContentAdapter) ipChange.ipc$dispatch("-83579160", new Object[]{this});
        }
        ContentAdapter contentAdapter = this.contentAdapter;
        if (contentAdapter != null) {
            return contentAdapter;
        }
        b41.A("contentAdapter");
        return null;
    }

    @Override // com.youku.arch.v3.Addressable
    @NotNull
    public Coordinate getCoordinate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "456938254") ? (Coordinate) ipChange.ipc$dispatch("456938254", new Object[]{this}) : this.coordinate;
    }

    @Override // com.youku.arch.v3.IModuleManager
    @NotNull
    public List<IModule<ModuleValue>> getCurrentModules() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1405067227") ? (List) ipChange.ipc$dispatch("-1405067227", new Object[]{this}) : this.modules;
    }

    @Override // com.youku.arch.v3.DomainObject
    @Nullable
    public EventHandler getEventHandler() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-908780813") ? (EventHandler) ipChange.ipc$dispatch("-908780813", new Object[]{this}) : this.eventHandler;
    }

    @Override // com.youku.arch.v3.Addressable
    public int getIndex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-328996357") ? ((Integer) ipChange.ipc$dispatch("-328996357", new Object[]{this})).intValue() : this.index;
    }

    @Override // com.youku.arch.v3.IModuleManager
    @NotNull
    public GenericFactory<IModule<ModuleValue>, Node> getModuleFactory() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1198521513") ? (GenericFactory) ipChange.ipc$dispatch("1198521513", new Object[]{this}) : (GenericFactory) this.moduleFactory$delegate.getValue();
    }

    @Override // com.youku.arch.v3.IModuleManager
    @NotNull
    public List<IModule<ModuleValue>> getModules() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1501302796") ? (List) ipChange.ipc$dispatch("-1501302796", new Object[]{this}) : this.unmodifiableModules;
    }

    @Nullable
    public final Node getNode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-842903942") ? (Node) ipChange.ipc$dispatch("-842903942", new Object[]{this}) : this.node;
    }

    @Override // com.youku.arch.v3.DomainObject
    @NotNull
    public IContext getPageContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1079886142") ? (IContext) ipChange.ipc$dispatch("-1079886142", new Object[]{this}) : this.pageContext;
    }

    @Override // com.youku.arch.v3.IContainer
    @NotNull
    public PageLoader getPageLoader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1360109394")) {
            return (PageLoader) ipChange.ipc$dispatch("-1360109394", new Object[]{this});
        }
        PageLoader pageLoader = this.pageLoader;
        if (pageLoader != null) {
            return pageLoader;
        }
        b41.A("pageLoader");
        return null;
    }

    @Override // com.youku.arch.v3.IContainer
    @NotNull
    public IParser<Node, VALUE> getParser() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-202129913")) {
            return (IParser) ipChange.ipc$dispatch("-202129913", new Object[]{this});
        }
        IParser<Node, VALUE> iParser = this.parser;
        if (iParser != null) {
            return iParser;
        }
        b41.A("parser");
        return null;
    }

    @Override // com.youku.arch.v3.IContainer
    @NotNull
    public VALUE getProperty() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1975716673")) {
            return (VALUE) ipChange.ipc$dispatch("1975716673", new Object[]{this});
        }
        VALUE value = this.property;
        if (value != null) {
            return value;
        }
        b41.A("property");
        return null;
    }

    @Override // com.youku.arch.v3.IContainer
    public int getRefreshThreshold() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1634592723") ? ((Integer) ipChange.ipc$dispatch("1634592723", new Object[]{this})).intValue() : this.refreshThreshold;
    }

    @Override // com.youku.arch.v3.DomainObject
    @Nullable
    public RequestBuilder getRequestBuilder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1825209645") ? (RequestBuilder) ipChange.ipc$dispatch("1825209645", new Object[]{this}) : this.requestBuilder;
    }

    @Override // com.youku.arch.v3.IContainer
    public int getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-590290775") ? ((Integer) ipChange.ipc$dispatch("-590290775", new Object[]{this})).intValue() : this.type;
    }

    @Override // com.youku.arch.v3.DomainObject
    public boolean hasNext() {
        boolean more;
        boolean z;
        IModule<ModuleValue> iModule;
        IpChange ipChange = $ipChange;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "-1189566819")) {
            return ((Boolean) ipChange.ipc$dispatch("-1189566819", new Object[]{this})).booleanValue();
        }
        try {
            more = getProperty().getMore();
        } catch (Exception e) {
            e = e;
        }
        if (more) {
            return more;
        }
        try {
            if (!this.modules.isEmpty()) {
                List<IModule<ModuleValue>> list = this.modules;
                iModule = list.get(list.size() - 1);
            } else {
                iModule = null;
            }
            if (iModule != null) {
                if (iModule.hasNext()) {
                    z2 = true;
                }
            }
            if (!z2 && iModule != null && (!iModule.getComponents().isEmpty())) {
                IComponent<ComponentValue> iComponent = iModule.getComponents().get(iModule.getComponents().size() - 1);
                if (iComponent.hasNext()) {
                    return iComponent.hasNext();
                }
            }
        } catch (Exception e2) {
            e = e2;
            z2 = z;
            if (AppInfoProviderProxy.isDebuggable()) {
                throw e;
            }
            return z2;
        }
        return z2;
    }

    @Override // com.youku.arch.v3.DomainObject
    public void initProperties(@NotNull Node node) {
        ConfigManager.ParserConfig parserConfig;
        SparseArray<IParser<?, ?>> parsers;
        IParser<?, ?> iParser;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1798105691")) {
            ipChange.ipc$dispatch("1798105691", new Object[]{this, node});
            return;
        }
        b41.i(node, "data");
        ConfigManager configManager = getPageContext().getConfigManager();
        IParser<Node, VALUE> iParser2 = null;
        if (configManager != null && (parserConfig = configManager.getParserConfig(0)) != null && (parsers = parserConfig.getParsers()) != null && (iParser = parsers.get(0)) != null) {
            setParser(iParser);
            iParser2 = iParser;
        }
        if (iParser2 == null) {
            setParser(new DefaultModelParser());
        }
        setProperty(getParser().parseElement(node));
        setType(node.getType());
    }

    @Override // com.youku.arch.v3.IModuleManager
    public boolean isChildStateDirty() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1675490007") ? ((Boolean) ipChange.ipc$dispatch("1675490007", new Object[]{this})).booleanValue() : this.childState.hasChanged();
    }

    @Override // com.youku.arch.v3.DomainObject
    public boolean loadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1792308371")) {
            return ((Boolean) ipChange.ipc$dispatch("-1792308371", new Object[]{this})).booleanValue();
        }
        if (!this.modules.isEmpty()) {
            List<IModule<ModuleValue>> list = this.modules;
            if (list.get(list.size() - 1).loadMore()) {
                return true;
            }
        }
        PageLoader pageLoader = getPageLoader();
        if (pageLoader.canLoadNextPage()) {
            pageLoader.loadNextPage();
        }
        return false;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    @MainThread
    public void notifyFirstScreenRender() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-503244771")) {
            ipChange.ipc$dispatch("-503244771", new Object[]{this});
        } else {
            getPageContext().runOnUIThreadLocked(new Function0<wt2>(this) { // from class: com.youku.arch.v3.core.PageContainer$notifyFirstScreenRender$1
                private static transient /* synthetic */ IpChange $ipChange;
                final /* synthetic */ PageContainer<VALUE> this$0;

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
                    EventBus eventBus;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-432775554")) {
                        ipChange2.ipc$dispatch("-432775554", new Object[]{this});
                        return;
                    }
                    this.this$0.updateContentAdapter();
                    PageContainer<VALUE> pageContainer = this.this$0;
                    if (pageContainer.contentAdapter != null) {
                        pageContainer.getContentAdapter().notifyDataSetChanged();
                        IContext baseContext = this.this$0.getPageContext().getBaseContext();
                        if (baseContext == null || (eventBus = baseContext.getEventBus()) == null) {
                            return;
                        }
                        eventBus.post(new Event(BusinessEvent.NOTIFY_FIRST_SCREEN_RENDER));
                    }
                }
            });
        }
    }

    @Override // com.youku.arch.v3.DomainObject
    public void onAdd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1813787356")) {
            ipChange.ipc$dispatch("-1813787356", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.event.EventHandler
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1985990721")) {
            return ((Boolean) ipChange.ipc$dispatch("1985990721", new Object[]{this, str, map})).booleanValue();
        }
        b41.i(str, "type");
        if (getEventHandler() == null) {
            setEventHandler(new EventHandler(this) { // from class: com.youku.arch.v3.core.PageContainer$onMessage$1
                private static transient /* synthetic */ IpChange $ipChange;
                final /* synthetic */ PageContainer<VALUE> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.this$0 = this;
                }

                @Override // com.youku.arch.v3.event.EventHandler
                public boolean onMessage(@NotNull String str2, @Nullable Map<String, ? extends Object> map2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2024089902")) {
                        return ((Boolean) ipChange2.ipc$dispatch("-2024089902", new Object[]{this, str2, map2})).booleanValue();
                    }
                    b41.i(str2, "type");
                    Event event = new Event(str2);
                    event.data = map2;
                    EventBus eventBus = this.this$0.getPageContext().getEventBus();
                    if (eventBus != null) {
                        eventBus.post(event);
                    }
                    return true;
                }
            });
        }
        EventHandler eventHandler = getEventHandler();
        b41.f(eventHandler);
        return eventHandler.onMessage(str, map);
    }

    @Override // com.youku.arch.v3.DomainObject
    public void onRemove() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1267817343")) {
            ipChange.ipc$dispatch("-1267817343", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void preAsyncLoadMVP(@NotNull List<IModule<ModuleValue>> list) {
        RecyclerView recyclerView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-522604529")) {
            ipChange.ipc$dispatch("-522604529", new Object[]{this, list});
            return;
        }
        b41.i(list, "modules");
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            if (list.isEmpty()) {
                return;
            }
            try {
                GenericFragment fragment = getPageContext().getFragment();
                RecyclerView.RecycledViewPool recycledViewPool = null;
                if (fragment != null && (recyclerView = fragment.getRecyclerView()) != null) {
                    recycledViewPool = recyclerView.getRecycledViewPool();
                }
                if (recycledViewPool != null && (recycledViewPool instanceof GenericRecycledViewPool)) {
                    PerformanceLogUtil performanceLogUtil = PerformanceLogUtil.INSTANCE;
                    performanceLogUtil.markStartPoint("preLoadMVP");
                    preLoadViewHolder(recycledViewPool, list);
                    performanceLogUtil.markEndPoint("preLoadMVP");
                    return;
                }
                return;
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw e;
                }
                return;
            }
        }
        throw new IllegalStateException("preAsyncLoadMVP should to be called in async thread".toString());
    }

    @Override // com.youku.arch.v3.IContainer
    public void reload() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-203765205")) {
            ipChange.ipc$dispatch("-203765205", new Object[]{this});
            return;
        }
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.d(TAG, this + " reload");
        }
        getPageLoader().reload();
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void removeModule(@NotNull IModule<ModuleValue> iModule) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-479425435")) {
            ipChange.ipc$dispatch("-479425435", new Object[]{this, iModule});
            return;
        }
        b41.i(iModule, "module");
        removeModule(iModule, (OnChildAttachStateChangeListener) null);
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void replaceModule(final int i, @NotNull final IModule<ModuleValue> iModule) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "427436924")) {
            ipChange.ipc$dispatch("427436924", new Object[]{this, Integer.valueOf(i), iModule});
            return;
        }
        b41.i(iModule, "module");
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.v(TAG, b41.r("replaceModule at index of ", Integer.valueOf(i)));
        }
        if (i < 0) {
            return;
        }
        getPageContext().runOnLoaderThreadLocked(new Function0<wt2>(this) { // from class: com.youku.arch.v3.core.PageContainer$replaceModule$1
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ PageContainer<VALUE> this$0;

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
                boolean isDebuggable;
                ChildState childState;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1174909333")) {
                    ipChange2.ipc$dispatch("1174909333", new Object[]{this});
                    return;
                }
                try {
                    IModule<ModuleValue> iModule2 = this.this$0.modules.get(i);
                    iModule.setIndex(iModule2.getIndex());
                    iModule.setContainer(iModule2.getContainer());
                    List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> adapters = iModule2.getAdapters();
                    List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> adapters2 = iModule.getAdapters();
                    boolean z = adapters.size() == adapters2.size();
                    if (z) {
                        try {
                            int size = adapters.size() - 1;
                            if (size >= 0) {
                                int i2 = 0;
                                while (true) {
                                    int i3 = i2 + 1;
                                    if (!b41.d(adapters2.get(i2).getClass(), adapters.get(i2).getClass())) {
                                        z = false;
                                    }
                                    if (i3 > size) {
                                        break;
                                    }
                                    i2 = i3;
                                }
                            }
                        } catch (IndexOutOfBoundsException e) {
                            int type = iModule2.getType();
                            int type2 = iModule.getType();
                            if (AppInfoProviderProxy.isDebuggable()) {
                                throw new IndexOutOfBoundsException("targetType = " + type + ",sourceType = " + type2 + AVFSCacheConstants.COMMA_SEP + ((Object) e.getMessage()));
                            }
                        }
                    }
                    if (z) {
                        childState = ((PageContainer) this.this$0).childState;
                        childState.setChanged();
                        iModule2.onRemove();
                        this.this$0.modules.set(i, iModule);
                        IModule<ModuleValue> iModule3 = iModule;
                        if (iModule2 == iModule3) {
                            iModule3.setIndex(i);
                        }
                        IContext pageContext = this.this$0.getPageContext();
                        final PageContainer<VALUE> pageContainer = this.this$0;
                        final IModule<ModuleValue> iModule4 = iModule;
                        pageContext.runOnUIThreadLocked(new Function0<wt2>() { // from class: com.youku.arch.v3.core.PageContainer$replaceModule$1.1
                            private static transient /* synthetic */ IpChange $ipChange;

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
                                boolean isDebuggable2;
                                RuntimeException runtimeException;
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "-219051614")) {
                                    ipChange3.ipc$dispatch("-219051614", new Object[]{this});
                                    return;
                                }
                                try {
                                    pageContainer.updateContentAdapter();
                                    if (AppInfoProviderProxy.isDebuggable()) {
                                        LogUtil.v("PageContainer", "replaceModule localNotifyChange");
                                    }
                                    int size2 = iModule4.getComponents().size() - 1;
                                    if (size2 < 0) {
                                        return;
                                    }
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4 + 1;
                                        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = iModule4.getComponents().get(i4).getAdapter();
                                        if (adapter != null) {
                                            adapter.notifyItemRangeChanged(0, adapter.getItemCount());
                                        }
                                        if (i5 > size2) {
                                            return;
                                        }
                                        i4 = i5;
                                    }
                                } finally {
                                    if (!isDebuggable2) {
                                    }
                                }
                            }
                        });
                        return;
                    }
                    this.this$0.replaceModuleImpl(i, iModule2, iModule);
                    if (AppInfoProviderProxy.isDebuggable()) {
                        LogUtil.v("PageContainer", "replaceModule not localNotifyChange");
                    }
                } finally {
                    if (!isDebuggable) {
                    }
                }
            }
        });
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void replaceModule(int i, @NotNull IModule<ModuleValue> iModule, @Nullable OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "676077391")) {
            ipChange.ipc$dispatch("676077391", new Object[]{this, Integer.valueOf(i), iModule, onChildAttachStateChangeListener});
        } else {
            b41.i(iModule, "module");
        }
    }

    @Override // com.youku.arch.v3.io.RequestClient
    public void request(@NotNull final IRequest iRequest, @NotNull final Callback callback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1471234200")) {
            ipChange.ipc$dispatch("1471234200", new Object[]{this, iRequest, callback});
            return;
        }
        b41.i(iRequest, "request");
        b41.i(callback, WXBridgeManager.METHOD_CALLBACK);
        getPageContext().runOnLoaderThread(new Function0<wt2>() { // from class: com.youku.arch.v3.core.PageContainer$request$1
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
                if (AndroidInstantRuntime.support(ipChange2, "1397425380")) {
                    ipChange2.ipc$dispatch("1397425380", new Object[]{this});
                } else {
                    Repository.Companion.getInstance().request(IRequest.this, callback);
                }
            }
        });
    }

    @Override // com.youku.arch.v3.IContainer
    public void setAdapterFactory(@Nullable GenericFactory<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>, Map<String, Object>> genericFactory) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "315623032")) {
            ipChange.ipc$dispatch("315623032", new Object[]{this, genericFactory});
        } else {
            this.adapterFactory = genericFactory;
        }
    }

    @Override // com.youku.arch.v3.IContainer
    public void setContentAdapter(@NotNull ContentAdapter contentAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-198466950")) {
            ipChange.ipc$dispatch("-198466950", new Object[]{this, contentAdapter});
            return;
        }
        b41.i(contentAdapter, "<set-?>");
        this.contentAdapter = contentAdapter;
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setEventHandler(@Nullable EventHandler eventHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "72540433")) {
            ipChange.ipc$dispatch("72540433", new Object[]{this, eventHandler});
        } else {
            this.eventHandler = eventHandler;
        }
    }

    @Override // com.youku.arch.v3.Addressable
    public void setIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-59930001")) {
            ipChange.ipc$dispatch("-59930001", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.index = i;
        }
    }

    public final void setNode(@Nullable Node node) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "85182906")) {
            ipChange.ipc$dispatch("85182906", new Object[]{this, node});
        } else {
            this.node = node;
        }
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setPageContext(@NotNull IContext iContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1711309614")) {
            ipChange.ipc$dispatch("-1711309614", new Object[]{this, iContext});
            return;
        }
        b41.i(iContext, "<set-?>");
        this.pageContext = iContext;
    }

    @Override // com.youku.arch.v3.IContainer
    public void setPageLoader(@NotNull PageLoader pageLoader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "798572142")) {
            ipChange.ipc$dispatch("798572142", new Object[]{this, pageLoader});
            return;
        }
        b41.i(pageLoader, "<set-?>");
        this.pageLoader = pageLoader;
    }

    @Override // com.youku.arch.v3.IContainer
    public void setParser(@NotNull IParser<Node, VALUE> iParser) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-515352351")) {
            ipChange.ipc$dispatch("-515352351", new Object[]{this, iParser});
            return;
        }
        b41.i(iParser, "<set-?>");
        this.parser = iParser;
    }

    public void setProperty(@NotNull VALUE value) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1715780537")) {
            ipChange.ipc$dispatch("-1715780537", new Object[]{this, value});
            return;
        }
        b41.i(value, "<set-?>");
        this.property = value;
    }

    @Override // com.youku.arch.v3.IContainer
    public void setRefreshThreshold(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1185068591")) {
            ipChange.ipc$dispatch("1185068591", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.refreshThreshold = i;
        }
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setRequestBuilder(@Nullable RequestBuilder requestBuilder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-917924863")) {
            ipChange.ipc$dispatch("-917924863", new Object[]{this, requestBuilder});
        } else {
            this.requestBuilder = requestBuilder;
        }
    }

    public void setType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1207694823")) {
            ipChange.ipc$dispatch("-1207694823", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.type = i;
        }
    }

    @Override // com.youku.arch.v3.IContainer
    public void updateChildIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1917202299")) {
            ipChange.ipc$dispatch("-1917202299", new Object[]{this});
        } else if (this.childIndexUpdater.hasChanged() || isChildStateDirty()) {
            this.childIndexUpdater.updateChildIndex(this.modules);
        }
    }

    @Override // com.youku.arch.v3.IContainer
    public void updateContentAdapter() {
        RecyclerView recyclerView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "429823493")) {
            ipChange.ipc$dispatch("429823493", new Object[]{this});
            return;
        }
        GenericFragment fragment = getPageContext().getFragment();
        if ((fragment == null || (recyclerView = fragment.getRecyclerView()) == null || !recyclerView.isComputingLayout()) ? false : true) {
            LogUtil.d("OneArch", "recyclerView isComputingLayout, ignore this refresh");
            return;
        }
        this.adapters = getChildAdapters();
        if (this.childState.hasChanged()) {
            this.childState.clearChanged();
        }
        Activity activity = getPageContext().getActivity();
        if (activity != null) {
            Iterator<T> it = this.adapters.iterator();
            while (it.hasNext()) {
                VBaseAdapter vBaseAdapter = (VBaseAdapter) it.next();
                vBaseAdapter.setContext(activity);
                VBaseAdapter innerAdapter = vBaseAdapter.getInnerAdapter();
                if (innerAdapter != null) {
                    innerAdapter.setContext(activity);
                }
            }
        }
        if (this.contentAdapter != null) {
            getContentAdapter().setAdapters(this.adapters);
        }
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void updateModules(@NotNull final List<Node> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2019065689")) {
            ipChange.ipc$dispatch("2019065689", new Object[]{this, list});
            return;
        }
        b41.i(list, "modules");
        getPageContext().runOnLoaderThreadLocked(new Function0<wt2>() { // from class: com.youku.arch.v3.core.PageContainer$updateModules$1
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
                boolean isDebuggable;
                RuntimeException runtimeException;
                IModule<ModuleValue> iModule;
                int size;
                int size2;
                IpChange ipChange2 = $ipChange;
                int i = 0;
                if (AndroidInstantRuntime.support(ipChange2, "1145422163")) {
                    ipChange2.ipc$dispatch("1145422163", new Object[]{this});
                    return;
                }
                try {
                    if (list.size() < this.modules.size() && (size2 = list.size()) <= (size = this.modules.size() - 1)) {
                        while (true) {
                            int i2 = size - 1;
                            PageContainer<VALUE> pageContainer = this;
                            pageContainer.removeModule(pageContainer.modules.get(size), true);
                            if (size == size2) {
                                break;
                            }
                            size = i2;
                        }
                    }
                    int size3 = this.modules.size();
                    if (size3 > 0) {
                        while (true) {
                            int i3 = i + 1;
                            try {
                                IContainer iContainer = this;
                                iModule = iContainer.createModule(new Config<>(iContainer.getPageContext(), list.get(i).getType(), list.get(i), i, false, 16, null));
                            } catch (Exception e) {
                                Log.e("OneArch.PageContainer", "create module error " + list.get(i).getType() + ((Object) e.getMessage()));
                                if (AppInfoProviderProxy.isDebuggable()) {
                                    throw new RuntimeException(e);
                                }
                                iModule = null;
                            }
                            if (iModule != null) {
                                IModule<ModuleValue> iModule2 = this.modules.get(i);
                                IContainer iContainer2 = this;
                                IModule<ModuleValue> iModule3 = iModule2;
                                if (iModule3.diff(iModule)) {
                                    PerformanceLogUtil performanceLogUtil = PerformanceLogUtil.INSTANCE;
                                    performanceLogUtil.markStartPoint("diff module to replaceModule");
                                    iContainer2.replaceModule(i, iModule);
                                    performanceLogUtil.markEndPoint("diff module to replaceModule");
                                } else {
                                    PerformanceLogUtil performanceLogUtil2 = PerformanceLogUtil.INSTANCE;
                                    performanceLogUtil2.markStartPoint("same module to updateComponents");
                                    iModule3.updateComponents(iModule.getComponents());
                                    performanceLogUtil2.markEndPoint("same module to updateComponents");
                                }
                            }
                            if (i3 >= size3) {
                                break;
                            }
                            i = i3;
                        }
                    }
                    if (list.size() > this.modules.size()) {
                        PageContainer<VALUE> pageContainer2 = this;
                        pageContainer2.createModules(list.subList(pageContainer2.modules.size(), list.size()));
                    }
                } finally {
                    if (!isDebuggable) {
                    }
                }
            }
        });
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void addModule(final int i, @NotNull final IModule<ModuleValue> iModule, @Nullable final OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1744973820")) {
            ipChange.ipc$dispatch("1744973820", new Object[]{this, Integer.valueOf(i), iModule, onChildAttachStateChangeListener});
            return;
        }
        b41.i(iModule, "module");
        getPageContext().runOnLoaderThreadLocked(new Function0<wt2>() { // from class: com.youku.arch.v3.core.PageContainer$addModule$1
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
                ChildState childState;
                ChildIndexUpdater childIndexUpdater;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-97791358")) {
                    ipChange2.ipc$dispatch("-97791358", new Object[]{this});
                } else if (i <= this.modules.size()) {
                    childState = ((PageContainer) this).childState;
                    childState.setChanged();
                    iModule.setIndex(i);
                    this.modules.add(i, iModule);
                    if (AppInfoProviderProxy.isDebuggable()) {
                        LogUtil.v("OneArch.PageContainer", "addModule  index is " + i + ", module size " + this.modules.size());
                    }
                    iModule.onAdd();
                    childIndexUpdater = ((PageContainer) this).childIndexUpdater;
                    childIndexUpdater.onChildAdded(iModule);
                    OnChildAttachStateChangeListener onChildAttachStateChangeListener2 = onChildAttachStateChangeListener;
                    if (onChildAttachStateChangeListener2 == null) {
                        return;
                    }
                    onChildAttachStateChangeListener2.onChildAdded(iModule);
                } else if (AppInfoProviderProxy.isDebuggable()) {
                    throw new IndexOutOfBoundsException("addModule error[index>=modules.size()]  index is " + i + ", module size " + this.modules.size());
                }
            }
        });
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void removeModule(@NotNull final IModule<ModuleValue> iModule, @Nullable final OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2029008250")) {
            ipChange.ipc$dispatch("-2029008250", new Object[]{this, iModule, onChildAttachStateChangeListener});
            return;
        }
        b41.i(iModule, "module");
        getPageContext().runOnLoaderThreadLocked(new Function0<wt2>(this) { // from class: com.youku.arch.v3.core.PageContainer$removeModule$1
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ PageContainer<VALUE> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final wt2 invoke() {
                ChildState childState;
                ChildIndexUpdater childIndexUpdater;
                List list;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1618978410")) {
                    return (wt2) ipChange2.ipc$dispatch("-1618978410", new Object[]{this});
                }
                childState = ((PageContainer) this.this$0).childState;
                childState.setChanged();
                this.this$0.modules.remove(iModule);
                if (AppInfoProviderProxy.isDebuggable()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("removeModule index is ");
                    sb.append(iModule.getIndex());
                    sb.append(", adapter size ");
                    list = ((PageContainer) this.this$0).adapters;
                    sb.append(list.size());
                    sb.append(", module size ");
                    sb.append(this.this$0.modules.size());
                    LogUtil.v("OneArch.PageContainer", sb.toString());
                }
                iModule.onRemove();
                childIndexUpdater = ((PageContainer) this.this$0).childIndexUpdater;
                childIndexUpdater.onChildRemoved(iModule);
                OnChildAttachStateChangeListener onChildAttachStateChangeListener2 = onChildAttachStateChangeListener;
                if (onChildAttachStateChangeListener2 == null) {
                    return null;
                }
                onChildAttachStateChangeListener2.onChildRemoved(iModule);
                return wt2.INSTANCE;
            }
        });
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void addModule(final int i, @NotNull final IModule<ModuleValue> iModule, final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "866448005")) {
            ipChange.ipc$dispatch("866448005", new Object[]{this, Integer.valueOf(i), iModule, Boolean.valueOf(z)});
            return;
        }
        b41.i(iModule, "module");
        addModule(i, iModule, new OnChildAttachStateChangeListener() { // from class: com.youku.arch.v3.core.PageContainer$addModule$2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.arch.v3.core.OnChildAttachStateChangeListener
            public void onChildAdded(@NotNull Addressable addressable) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1117855320")) {
                    ipChange2.ipc$dispatch("-1117855320", new Object[]{this, addressable});
                    return;
                }
                b41.i(addressable, "addressable");
                if (z) {
                    IContext pageContext = this.getPageContext();
                    final int i2 = i;
                    final PageContainer<VALUE> pageContainer = this;
                    final IModule<ModuleValue> iModule2 = iModule;
                    pageContext.runOnUIThreadLocked(new Function0<wt2>() { // from class: com.youku.arch.v3.core.PageContainer$addModule$2$onChildAdded$1
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
                            List list;
                            List list2;
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "67358931")) {
                                ipChange3.ipc$dispatch("67358931", new Object[]{this});
                                return;
                            }
                            if (AppInfoProviderProxy.isDebuggable()) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("addModule before ItemRangeInserted index is ");
                                sb.append(i2);
                                sb.append(", adapter size ");
                                list2 = ((PageContainer) pageContainer).adapters;
                                sb.append(list2.size());
                                sb.append(", module size ");
                                sb.append(pageContainer.modules.size());
                                LogUtil.v("OneArch.PageContainer", sb.toString());
                            }
                            pageContainer.updateContentAdapter();
                            for (IComponent<ComponentValue> iComponent : iModule2.getComponents()) {
                                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = iComponent.getAdapter();
                                if (adapter != null) {
                                    adapter.notifyLocalDataSetChanged(null, iComponent.getItems());
                                }
                            }
                            if (AppInfoProviderProxy.isDebuggable()) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("addModule after ItemRangeInserted index is ");
                                sb2.append(i2);
                                sb2.append(", adapter size ");
                                list = ((PageContainer) pageContainer).adapters;
                                sb2.append(list.size());
                                sb2.append(", module size ");
                                sb2.append(pageContainer.modules.size());
                                LogUtil.v("OneArch.PageContainer", sb2.toString());
                            }
                        }
                    });
                }
            }

            @Override // com.youku.arch.v3.core.OnChildAttachStateChangeListener
            public void onChildRemoved(@NotNull Addressable addressable) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "288150984")) {
                    ipChange2.ipc$dispatch("288150984", new Object[]{this, addressable});
                } else {
                    b41.i(addressable, "addressable");
                }
            }
        });
    }

    @Override // com.youku.arch.v3.IModuleManager
    public void removeModule(@NotNull final IModule<ModuleValue> iModule, final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1977240817")) {
            ipChange.ipc$dispatch("-1977240817", new Object[]{this, iModule, Boolean.valueOf(z)});
            return;
        }
        b41.i(iModule, "module");
        removeModule(iModule, new OnChildAttachStateChangeListener(this) { // from class: com.youku.arch.v3.core.PageContainer$removeModule$2
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ PageContainer<VALUE> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // com.youku.arch.v3.core.OnChildAttachStateChangeListener
            public void onChildAdded(@NotNull Addressable addressable) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "416991411")) {
                    ipChange2.ipc$dispatch("416991411", new Object[]{this, addressable});
                } else {
                    b41.i(addressable, "addressable");
                }
            }

            @Override // com.youku.arch.v3.core.OnChildAttachStateChangeListener
            public void onChildRemoved(@NotNull Addressable addressable) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2102076947")) {
                    ipChange2.ipc$dispatch("2102076947", new Object[]{this, addressable});
                    return;
                }
                b41.i(addressable, "addressable");
                IContext pageContext = this.this$0.getPageContext();
                final boolean z2 = z;
                final IModule<ModuleValue> iModule2 = iModule;
                final PageContainer<VALUE> pageContainer = this.this$0;
                pageContext.runOnUIThreadLocked(new Function0<wt2>() { // from class: com.youku.arch.v3.core.PageContainer$removeModule$2$onChildRemoved$1
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
                        if (AndroidInstantRuntime.support(ipChange3, "-1211240066")) {
                            ipChange3.ipc$dispatch("-1211240066", new Object[]{this});
                        } else if (z2) {
                            List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> adapters = iModule2.getAdapters();
                            int size = adapters.size() - 1;
                            if (size >= 0) {
                                while (true) {
                                    int i = size - 1;
                                    VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter = adapters.get(size);
                                    if (vBaseAdapter.getItemCount() > 0) {
                                        vBaseAdapter.notifyItemRangeRemoved(0, vBaseAdapter.getItemCount());
                                    }
                                    if (i < 0) {
                                        break;
                                    }
                                    size = i;
                                }
                            }
                            pageContainer.updateContentAdapter();
                        }
                    }
                });
            }
        });
    }
}
