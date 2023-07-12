package com.youku.arch.v3.core.component;

import android.taobao.windvane.connect.api.ApiResponse;
import android.util.SparseArray;
import com.alibaba.android.vlayout.layout.C3299b;
import com.alibaba.android.vlayout.layout.C3302c;
import com.alibaba.android.vlayout.layout.C3308h;
import com.alibaba.android.vlayout.layout.FixAreaLayoutHelper;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.arch.v3.Addressable;
import com.youku.arch.v3.DomainObject;
import com.youku.arch.v3.GenericFactory;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.adapter.ContentAdapter;
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
import com.youku.arch.v3.core.Render;
import com.youku.arch.v3.core.parser.ComponentParser;
import com.youku.arch.v3.core.parser.DefaultComponentParser;
import com.youku.arch.v3.core.parser.IParser;
import com.youku.arch.v3.data.Repository;
import com.youku.arch.v3.event.ArchExceptionEvent;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.PagingLoader;
import com.youku.arch.v3.recyclerview.layouthelper.GridFixAutoStatLayoutHelper;
import com.youku.arch.v3.typeconvert.TypeConvertManager;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.util.PageUtil;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 ³\u0001*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002³\u0001B\u0019\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010>\u001a\u00020\u000b¢\u0006\u0006\b±\u0001\u0010²\u0001J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0016J\u001e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J&\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J(\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0016\u0010\u0018\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u001e\u0010\u0018\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J \u0010\u0018\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u001a\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nH\u0016J\u001e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J.\u0010\u001f\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u001e0\u001d\u0018\u00010\u001cH\u0016J\u0018\u0010!\u001a\u00020\b2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\u0014H\u0016J\b\u0010%\u001a\u00020\u0014H\u0016J\u001e\u0010)\u001a\u0004\u0018\u00010 2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0&H\u0016J\u0010\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u000bH\u0016J\b\u0010,\u001a\u00020\bH\u0016J\b\u0010-\u001a\u00020\bH\u0016J\b\u0010.\u001a\u00020\bH\u0016J\b\u0010/\u001a\u00020\bH\u0016J&\u00102\u001a\u00020\u00142\u0006\u00100\u001a\u00020'2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(\u0018\u00010&H\u0016J\u001a\u00104\u001a\u00020\b2\u0012\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nJ\u0016\u00106\u001a\u00020\u00142\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0016R\"\u00108\u001a\u0002078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010>\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u00100\u001a\u00020\u00108F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010I\u001a\u00028\u00008\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR(\u0010Q\u001a\b\u0012\u0004\u0012\u00020P0O8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\"\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bY\u0010XR*\u0010[\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b[\u0010X\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001e\u0010`\u001a\u0004\u0018\u00010'8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cRC\u0010h\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u001e0\u001d\u0018\u00010\u001c8V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gRH\u0010i\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u001e0\u001d\u0018\u00010\u001c8V@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010g\"\u0004\bl\u0010mR6\u0010o\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010n8V@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR$\u0010v\u001a\u0004\u0018\u00010u8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R1\u0010}\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000|8\u0016@\u0016X\u0096.¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R6\u0010\u0084\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0083\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R$\u0010\u0011\u001a\u00020\u00108V@\u0016X\u0096\u000e¢\u0006\u0014\n\u0004\b\u0011\u0010D\u001a\u0005\b\u008a\u0001\u0010F\"\u0005\b\u008b\u0001\u0010HR,\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R)\u0010\u0093\u0001\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0093\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R,\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0098\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R!\u0010£\u0001\u001a\n\u0012\u0005\u0012\u00030 \u00010\u009f\u00018V@\u0016X\u0096\u0004¢\u0006\b\u001a\u0006\b¡\u0001\u0010¢\u0001R#\u0010¥\u0001\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\n8F@\u0006¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010]R\u0018\u0010¨\u0001\u001a\u0004\u0018\u00010\u00108F@\u0006¢\u0006\b\u001a\u0006\b¦\u0001\u0010§\u0001R\u0018\u0010ª\u0001\u001a\u00020\u00108V@\u0016X\u0096\u0004¢\u0006\u0007\u001a\u0005\b©\u0001\u0010FR\u0018\u0010¬\u0001\u001a\u00020\u00108V@\u0016X\u0096\u0004¢\u0006\u0007\u001a\u0005\b«\u0001\u0010FR\u001a\u0010°\u0001\u001a\u00030\u00ad\u00018V@\u0016X\u0096\u0004¢\u0006\b\u001a\u0006\b®\u0001\u0010¯\u0001¨\u0006´\u0001"}, d2 = {"Lcom/youku/arch/v3/core/component/GenericComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", ApiResponse.VALUE, "Lcom/youku/arch/v3/IComponent;", "", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "getItems", "Ltb/wt2;", "createItems", "", "Lcom/youku/arch/v3/core/Node;", "nodes", "Lcom/youku/arch/v3/core/Config;", Constants.CONFIG, "createItem", "", "index", "item", "addItem", "", "notifyUiUpdate", "Lcom/youku/arch/v3/core/OnChildAttachStateChangeListener;", "listener", "removeItem", "items", "updateItems", "replaceItem", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "createAdapter", "Lcom/youku/arch/v3/io/IRequest;", "request", "Lcom/youku/arch/v3/io/Callback;", WXBridgeManager.METHOD_CALLBACK, "loadMore", xl2.HAS_NEXT, "", "", "", "createRequest", "data", "initProperties", "updateChildIndex", "clearItems", "onAdd", "onRemove", "type", "params", "onMessage", "newList", "notifyLocalDataSetChanged", "target", "diff", "Lcom/youku/arch/v3/core/IContext;", com.youku.arch.v3.data.Constants.PAGE_CONTEXT, "Lcom/youku/arch/v3/core/IContext;", "getPageContext", "()Lcom/youku/arch/v3/core/IContext;", "setPageContext", "(Lcom/youku/arch/v3/core/IContext;)V", "node", "Lcom/youku/arch/v3/core/Node;", "getNode", "()Lcom/youku/arch/v3/core/Node;", "setNode", "(Lcom/youku/arch/v3/core/Node;)V", "I", "getType", "()I", "setType", "(I)V", "property", "Lcom/youku/arch/v3/core/ComponentValue;", "getProperty", "()Lcom/youku/arch/v3/core/ComponentValue;", "setProperty", "(Lcom/youku/arch/v3/core/ComponentValue;)V", "Lcom/youku/arch/v3/IModule;", "Lcom/youku/arch/v3/core/ModuleValue;", "module", "Lcom/youku/arch/v3/IModule;", "getModule", "()Lcom/youku/arch/v3/IModule;", "setModule", "(Lcom/youku/arch/v3/IModule;)V", "childItems", "Ljava/util/List;", "unmodifiableChildItems", "Lcom/youku/arch/v3/core/Render;", "renders", "getRenders", "()Ljava/util/List;", "setRenders", "(Ljava/util/List;)V", "rawJson", "Ljava/lang/String;", "getRawJson", "()Ljava/lang/String;", "adapter$delegate", "Lkotlin/Lazy;", "getAdapter", "()Lcom/youku/arch/v3/adapter/VBaseAdapter;", "adapter", "innerAdapter", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "getInnerAdapter", "setInnerAdapter", "(Lcom/youku/arch/v3/adapter/VBaseAdapter;)V", "Lcom/youku/arch/v3/GenericFactory;", "itemFactory", "Lcom/youku/arch/v3/GenericFactory;", "getItemFactory", "()Lcom/youku/arch/v3/GenericFactory;", "setItemFactory", "(Lcom/youku/arch/v3/GenericFactory;)V", "Lcom/youku/arch/v3/io/RequestBuilder;", "requestBuilder", "Lcom/youku/arch/v3/io/RequestBuilder;", "getRequestBuilder", "()Lcom/youku/arch/v3/io/RequestBuilder;", "setRequestBuilder", "(Lcom/youku/arch/v3/io/RequestBuilder;)V", "Lcom/youku/arch/v3/core/parser/ComponentParser;", "parser", "Lcom/youku/arch/v3/core/parser/ComponentParser;", "getParser", "()Lcom/youku/arch/v3/core/parser/ComponentParser;", "setParser", "(Lcom/youku/arch/v3/core/parser/ComponentParser;)V", "Lcom/youku/arch/v3/core/ChildIndexUpdater;", "childIndexUpdater", "Lcom/youku/arch/v3/core/ChildIndexUpdater;", "getChildIndexUpdater", "()Lcom/youku/arch/v3/core/ChildIndexUpdater;", "setChildIndexUpdater", "(Lcom/youku/arch/v3/core/ChildIndexUpdater;)V", "getIndex", "setIndex", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", "Lcom/youku/arch/v3/event/EventHandler;", "getEventHandler", "()Lcom/youku/arch/v3/event/EventHandler;", "setEventHandler", "(Lcom/youku/arch/v3/event/EventHandler;)V", "isDataBound", "Z", "()Z", "setDataBound", "(Z)V", "Lcom/youku/arch/v3/loader/PagingLoader;", "componentLoader", "Lcom/youku/arch/v3/loader/PagingLoader;", "getComponentLoader", "()Lcom/youku/arch/v3/loader/PagingLoader;", "setComponentLoader", "(Lcom/youku/arch/v3/loader/PagingLoader;)V", "Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "getContainer", "()Lcom/youku/arch/v3/IContainer;", "container", "getRenderChildItems", "renderChildItems", "getRenderChildCount", "()Ljava/lang/Integer;", "renderChildCount", "getChildCount", "childCount", "getPosInRenderList", "posInRenderList", "Lcom/youku/arch/v3/core/Coordinate;", "getCoordinate", "()Lcom/youku/arch/v3/core/Coordinate;", "coordinate", "<init>", "(Lcom/youku/arch/v3/core/IContext;Lcom/youku/arch/v3/core/Node;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class GenericComponent<VALUE extends ComponentValue> implements IComponent<VALUE> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "OneArch.GenericComponent";
    @NotNull
    private final Lazy adapter$delegate;
    @NotNull
    private ChildIndexUpdater<IItem<ItemValue>> childIndexUpdater;
    @JvmField
    @NotNull
    public List<IItem<ItemValue>> childItems;
    @Nullable
    private PagingLoader componentLoader;
    @Nullable
    private EventHandler eventHandler;
    private volatile int index;
    @Nullable
    private VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter;
    private boolean isDataBound;
    @Nullable
    private GenericFactory<IItem<ItemValue>, Node> itemFactory;
    public IModule<ModuleValue> module;
    @NotNull
    private Node node;
    @NotNull
    private IContext pageContext;
    public ComponentParser<Node, VALUE> parser;
    public VALUE property;
    @Nullable
    private final String rawJson;
    @Nullable
    private List<? extends Render> renders;
    @Nullable
    private RequestBuilder requestBuilder;
    private int type;
    @JvmField
    @NotNull
    public List<IItem<ItemValue>> unmodifiableChildItems;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/core/component/GenericComponent$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    public GenericComponent(@NotNull IContext iContext, @NotNull Node node) {
        Lazy a;
        b41.i(iContext, com.youku.arch.v3.data.Constants.PAGE_CONTEXT);
        b41.i(node, "node");
        this.pageContext = iContext;
        this.node = node;
        this.type = -1;
        ArrayList arrayList = new ArrayList();
        this.childItems = arrayList;
        List<IItem<ItemValue>> unmodifiableList = Collections.unmodifiableList(arrayList);
        b41.h(unmodifiableList, "unmodifiableList(childItems)");
        this.unmodifiableChildItems = unmodifiableList;
        JSONObject data = this.node.getData();
        this.rawJson = data == null ? null : data.toJSONString();
        a = C8177b.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>>(this) { // from class: com.youku.arch.v3.core.component.GenericComponent$adapter$2
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ GenericComponent<VALUE> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> invoke() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-791897897") ? (VBaseAdapter) ipChange.ipc$dispatch("-791897897", new Object[]{this}) : this.this$0.createAdapter();
            }
        });
        this.adapter$delegate = a;
        this.childIndexUpdater = new ChildIndexUpdater<>();
        this.index = -1;
    }

    @Override // com.youku.arch.v3.IItemManager
    public void addItem(int i, @NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-928615347")) {
            ipChange.ipc$dispatch("-928615347", new Object[]{this, Integer.valueOf(i), iItem});
            return;
        }
        b41.i(iItem, "item");
        addItem(i, iItem, false);
    }

    @Override // com.youku.arch.v3.IComponent
    public void clearItems() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1088667")) {
            ipChange.ipc$dispatch("-1088667", new Object[]{this});
        } else {
            getPageContext().runOnLoaderThreadLocked(new Function0<wt2>(this) { // from class: com.youku.arch.v3.core.component.GenericComponent$clearItems$1
                private static transient /* synthetic */ IpChange $ipChange;
                final /* synthetic */ GenericComponent<VALUE> this$0;

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
                    if (AndroidInstantRuntime.support(ipChange2, "-1421182298")) {
                        ipChange2.ipc$dispatch("-1421182298", new Object[]{this});
                        return;
                    }
                    Iterator<IItem<ItemValue>> it = this.this$0.childItems.iterator();
                    DomainObject domainObject = this.this$0;
                    while (domainObject.hasNext()) {
                        it.remove();
                        it.next().onRemove();
                    }
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0075  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.youku.arch.v3.adapter.VBaseAdapter<com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>, com.youku.arch.v3.adapter.VBaseHolder<com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>, com.youku.arch.v3.view.render.GenericRenderConfig>> createAdapter() {
        /*
            r9 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.arch.v3.core.component.GenericComponent.$ipChange
            java.lang.String r1 = "-1598039215"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L17
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r9
            java.lang.Object r0 = r0.ipc$dispatch(r1, r2)
            com.youku.arch.v3.adapter.VBaseAdapter r0 = (com.youku.arch.v3.adapter.VBaseAdapter) r0
            return r0
        L17:
            java.util.HashMap r4 = new java.util.HashMap
            r0 = 8
            r4.<init>(r0)
            java.util.List<com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>> r0 = r9.childItems
            java.lang.String r1 = "data"
            r4.put(r1, r0)
            java.util.List r0 = r9.getRenders()
            java.lang.String r1 = "render"
            r4.put(r1, r0)
            com.youku.arch.v3.core.IContext r0 = r9.getPageContext()
            java.lang.String r0 = r0.getPageName()
            java.lang.String r1 = "pageName"
            r4.put(r1, r0)
            com.youku.arch.v3.core.IContext r0 = r9.getPageContext()
            java.lang.String r1 = "pageContext"
            r4.put(r1, r0)
            com.youku.arch.v3.core.Config r0 = new com.youku.arch.v3.core.Config
            com.youku.arch.v3.core.IContext r2 = r9.getPageContext()
            int r3 = r9.getType()
            r5 = 0
            r6 = 0
            r7 = 24
            r8 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r1 = 0
            com.youku.arch.v3.IContainer r2 = r9.getContainer()     // Catch: java.lang.Exception -> L6a
            com.youku.arch.v3.GenericFactory r2 = r2.getAdapterFactory()     // Catch: java.lang.Exception -> L6a
            if (r2 != 0) goto L63
            goto L71
        L63:
            java.lang.Object r0 = r2.create(r0)     // Catch: java.lang.Exception -> L6a
            com.youku.arch.v3.adapter.VBaseAdapter r0 = (com.youku.arch.v3.adapter.VBaseAdapter) r0     // Catch: java.lang.Exception -> L6a
            goto L72
        L6a:
            r0 = move-exception
            boolean r2 = com.youku.middlewareservice.provider.info.AppInfoProviderProxy.isDebuggable()
            if (r2 != 0) goto La6
        L71:
            r0 = r1
        L72:
            if (r0 != 0) goto L75
            goto L79
        L75:
            com.alibaba.android.vlayout.a r1 = r0.getLayoutHelper()
        L79:
            if (r1 == 0) goto La5
            com.alibaba.android.vlayout.a r1 = r0.getLayoutHelper()
            boolean r1 = r1 instanceof com.youku.arch.v3.recyclerview.layouthelper.GridFixAutoStatLayoutHelper
            if (r1 != 0) goto L8b
            com.alibaba.android.vlayout.a r1 = r0.getLayoutHelper()
            boolean r1 = r1 instanceof com.alibaba.android.vlayout.layout.C3302c
            if (r1 == 0) goto La5
        L8b:
            com.youku.arch.v3.core.ComponentValue r1 = r9.getProperty()
            com.alibaba.fastjson.JSONObject r1 = r1.getData()
            if (r1 != 0) goto L96
            goto La5
        L96:
            java.lang.String r2 = "displayNum"
            boolean r3 = r1.containsKey(r2)
            if (r3 == 0) goto La5
            int r1 = r1.getIntValue(r2)
            r0.setRenderCount(r1)
        La5:
            return r0
        La6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.v3.core.component.GenericComponent.createAdapter():com.youku.arch.v3.adapter.VBaseAdapter");
    }

    @Override // com.youku.arch.v3.IItemManager
    @Nullable
    public IItem<ItemValue> createItem(@NotNull Config<Node> config) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1859826763")) {
            return (IItem) ipChange.ipc$dispatch("-1859826763", new Object[]{this, config});
        }
        b41.i(config, Constants.CONFIG);
        GenericFactory<IItem<ItemValue>, Node> itemFactory = getItemFactory();
        IItem<ItemValue> create = itemFactory == null ? null : itemFactory.create(config);
        if (create != null) {
            create.setComponent(this);
            create.initProperties(config.getData());
        }
        return create;
    }

    @Override // com.youku.arch.v3.IComponent
    public void createItems() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1307566830")) {
            ipChange.ipc$dispatch("1307566830", new Object[]{this});
        } else {
            getPageContext().runOnLoaderThreadLocked(new Function0<wt2>(this) { // from class: com.youku.arch.v3.core.component.GenericComponent$createItems$1
                private static transient /* synthetic */ IpChange $ipChange;
                final /* synthetic */ GenericComponent<VALUE> this$0;

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
                    if (AndroidInstantRuntime.support(ipChange2, "-772326388")) {
                        return (wt2) ipChange2.ipc$dispatch("-772326388", new Object[]{this});
                    }
                    List<? extends Node> children = this.this$0.getProperty().getChildren();
                    if (children == null) {
                        return null;
                    }
                    this.this$0.createItems(children);
                    return wt2.INSTANCE;
                }
            });
        }
    }

    @Override // com.youku.arch.v3.DomainObject
    @Nullable
    public IRequest createRequest(@NotNull Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "782022357")) {
            return (IRequest) ipChange.ipc$dispatch("782022357", new Object[]{this, map});
        }
        b41.i(map, Constants.CONFIG);
        RequestBuilder requestBuilder = getRequestBuilder();
        if (requestBuilder == null) {
            return null;
        }
        return requestBuilder.build(map);
    }

    @Override // com.youku.arch.v3.Diff
    public boolean diff(@NotNull IComponent<ComponentValue> iComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-413560571")) {
            return ((Boolean) ipChange.ipc$dispatch("-413560571", new Object[]{this, iComponent})).booleanValue();
        }
        b41.i(iComponent, "target");
        return true;
    }

    @Override // com.youku.arch.v3.IComponent
    @Nullable
    public VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> getAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-286863855") ? (VBaseAdapter) ipChange.ipc$dispatch("-286863855", new Object[]{this}) : (VBaseAdapter) this.adapter$delegate.getValue();
    }

    @Override // com.youku.arch.v3.DomainObject
    public int getChildCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1902731172") ? ((Integer) ipChange.ipc$dispatch("-1902731172", new Object[]{this})).intValue() : this.childItems.size();
    }

    @NotNull
    public final ChildIndexUpdater<IItem<ItemValue>> getChildIndexUpdater() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1738184134") ? (ChildIndexUpdater) ipChange.ipc$dispatch("-1738184134", new Object[]{this}) : this.childIndexUpdater;
    }

    @Nullable
    public final PagingLoader getComponentLoader() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1920525343") ? (PagingLoader) ipChange.ipc$dispatch("-1920525343", new Object[]{this}) : this.componentLoader;
    }

    @Override // com.youku.arch.v3.IComponent
    @NotNull
    public IContainer<ModelValue> getContainer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1693242003") ? (IContainer) ipChange.ipc$dispatch("1693242003", new Object[]{this}) : getModule().getContainer();
    }

    @Override // com.youku.arch.v3.Addressable
    @NotNull
    public Coordinate getCoordinate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2050346822") ? (Coordinate) ipChange.ipc$dispatch("-2050346822", new Object[]{this}) : new Coordinate(getModule().getIndex(), getIndex(), -2);
    }

    @Override // com.youku.arch.v3.DomainObject
    @Nullable
    public EventHandler getEventHandler() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "871033031") ? (EventHandler) ipChange.ipc$dispatch("871033031", new Object[]{this}) : this.eventHandler;
    }

    @Override // com.youku.arch.v3.Addressable
    public int getIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1778722255")) {
            return ((Integer) ipChange.ipc$dispatch("1778722255", new Object[]{this})).intValue();
        }
        getModule().updateChildIndex();
        return this.index;
    }

    @Override // com.youku.arch.v3.IComponent
    @Nullable
    public VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> getInnerAdapter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1159741587")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-1159741587", new Object[]{this});
        }
        if (this.innerAdapter == null) {
            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = getAdapter();
            this.innerAdapter = adapter == null ? null : adapter.getInnerAdapter();
        }
        return this.innerAdapter;
    }

    @Override // com.youku.arch.v3.IItemManager
    @Nullable
    public GenericFactory<IItem<ItemValue>, Node> getItemFactory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2055554574")) {
            return (GenericFactory) ipChange.ipc$dispatch("2055554574", new Object[]{this});
        }
        if (this.itemFactory == null) {
            this.itemFactory = PageUtil.INSTANCE.getDefaultItemFactory(getPageContext());
        }
        return this.itemFactory;
    }

    @Override // com.youku.arch.v3.IItemManager
    @NotNull
    public List<IItem<ItemValue>> getItems() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1187174489") ? (List) ipChange.ipc$dispatch("1187174489", new Object[]{this}) : this.unmodifiableChildItems;
    }

    @Override // com.youku.arch.v3.IComponent
    @NotNull
    public IModule<ModuleValue> getModule() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "544303705")) {
            return (IModule) ipChange.ipc$dispatch("544303705", new Object[]{this});
        }
        IModule<ModuleValue> iModule = this.module;
        if (iModule != null) {
            return iModule;
        }
        b41.A("module");
        return null;
    }

    @NotNull
    public final Node getNode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1833848358") ? (Node) ipChange.ipc$dispatch("1833848358", new Object[]{this}) : this.node;
    }

    @Override // com.youku.arch.v3.DomainObject
    @NotNull
    public IContext getPageContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1437860970") ? (IContext) ipChange.ipc$dispatch("-1437860970", new Object[]{this}) : this.pageContext;
    }

    @Override // com.youku.arch.v3.IComponent
    @NotNull
    public ComponentParser<Node, VALUE> getParser() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1061064863")) {
            return (ComponentParser) ipChange.ipc$dispatch("1061064863", new Object[]{this});
        }
        ComponentParser<Node, VALUE> componentParser = this.parser;
        if (componentParser != null) {
            return componentParser;
        }
        b41.A("parser");
        return null;
    }

    @Override // com.youku.arch.v3.IComponent
    public int getPosInRenderList() {
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> next;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "742847156")) {
            return ((Integer) ipChange.ipc$dispatch("742847156", new Object[]{this})).intValue();
        }
        if (getAdapter() == null) {
            return -1;
        }
        if (getContainer().isChildStateDirty()) {
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.d(TAG, b41.r("isChildStateDirty getPosInRenderList pos ", 0));
            }
            getPageContext().runOnUIThreadLocked(new Function0<wt2>(this) { // from class: com.youku.arch.v3.core.component.GenericComponent$posInRenderList$1
                private static transient /* synthetic */ IpChange $ipChange;
                final /* synthetic */ GenericComponent<VALUE> this$0;

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
                    if (AndroidInstantRuntime.support(ipChange2, "-1733161610")) {
                        ipChange2.ipc$dispatch("-1733161610", new Object[]{this});
                    } else {
                        this.this$0.getContainer().updateContentAdapter();
                    }
                }
            });
        }
        Iterator<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> it = getContainer().getChildAdapters().iterator();
        int i = 0;
        while (it.hasNext() && getAdapter() != (next = it.next())) {
            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = getAdapter();
            b41.f(adapter);
            if (adapter.data == next.data) {
                break;
            }
            if (!(next.getLayoutHelper() instanceof C3299b) && !(next.getLayoutHelper() instanceof GridFixAutoStatLayoutHelper)) {
                next.getLayoutHelper();
                if (!(next.getLayoutHelper() instanceof C3302c)) {
                    if ((next.getLayoutHelper() instanceof C3308h) || (next.getLayoutHelper() instanceof FixAreaLayoutHelper)) {
                        i++;
                    }
                }
            }
            i += next.getItemCount();
        }
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.d(TAG, b41.r("getPosInRenderList pos ", Integer.valueOf(i)));
        }
        return i;
    }

    @Override // com.youku.arch.v3.IComponent
    @NotNull
    public VALUE getProperty() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "675416513")) {
            return (VALUE) ipChange.ipc$dispatch("675416513", new Object[]{this});
        }
        VALUE value = this.property;
        if (value != null) {
            return value;
        }
        b41.A("property");
        return null;
    }

    @Override // com.youku.arch.v3.IComponent
    @Nullable
    public String getRawJson() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "82900450") ? (String) ipChange.ipc$dispatch("82900450", new Object[]{this}) : this.rawJson;
    }

    @Nullable
    public final Integer getRenderChildCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-936840806")) {
            return (Integer) ipChange.ipc$dispatch("-936840806", new Object[]{this});
        }
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = getAdapter();
        if (adapter == null) {
            return null;
        }
        return Integer.valueOf(adapter.getItemCount());
    }

    @Nullable
    public final List<IItem<ItemValue>> getRenderChildItems() {
        int renderStart;
        int itemCount;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1203796261")) {
            return (List) ipChange.ipc$dispatch("1203796261", new Object[]{this});
        }
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = getAdapter();
        if (adapter != null && this.unmodifiableChildItems.size() >= (itemCount = adapter.getItemCount() + (renderStart = adapter.getRenderStart()))) {
            return this.unmodifiableChildItems.subList(renderStart, itemCount);
        }
        return null;
    }

    @Override // com.youku.arch.v3.IComponent
    @Nullable
    public List<Render> getRenders() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2048325834") ? (List) ipChange.ipc$dispatch("-2048325834", new Object[]{this}) : this.renders;
    }

    @Override // com.youku.arch.v3.DomainObject
    @Nullable
    public RequestBuilder getRequestBuilder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1164863961") ? (RequestBuilder) ipChange.ipc$dispatch("1164863961", new Object[]{this}) : this.requestBuilder;
    }

    @Override // com.youku.arch.v3.IComponent
    public final int getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "586078805") ? ((Integer) ipChange.ipc$dispatch("586078805", new Object[]{this})).intValue() : TypeConvertManager.INSTANCE.convertType(this.type, getProperty(), this.node.getData());
    }

    @Override // com.youku.arch.v3.DomainObject
    public boolean hasNext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-13197239") ? ((Boolean) ipChange.ipc$dispatch("-13197239", new Object[]{this})).booleanValue() : getProperty().getMore();
    }

    public void initProperties(@NotNull Node node) {
        ConfigManager.ParserConfig parserConfig;
        SparseArray<IParser<?, ?>> parsers;
        IParser<?, ?> iParser;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "407141895")) {
            ipChange.ipc$dispatch("407141895", new Object[]{this, node});
            return;
        }
        b41.i(node, "data");
        ConfigManager configManager = getPageContext().getConfigManager();
        if (configManager == null || (parserConfig = configManager.getParserConfig(2)) == null || (parsers = parserConfig.getParsers()) == null || (iParser = parsers.get(0)) == null) {
            iParser = null;
        } else {
            setParser((ComponentParser) iParser);
        }
        if (iParser == null) {
            setParser(new DefaultComponentParser());
        }
        setProperty(getParser().parseElement(node));
        this.type = node.getType();
        setRenders(getParser().parseConfig(node));
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
        eventDispatcher.dispatchEvent(ArchExceptionEvent.COMPONENT_CHILDREN_EMPTY, hashMap);
    }

    public final boolean isDataBound() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1952121708") ? ((Boolean) ipChange.ipc$dispatch("1952121708", new Object[]{this})).booleanValue() : this.isDataBound;
    }

    @Override // com.youku.arch.v3.DomainObject
    public boolean loadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "315410241")) {
            return ((Boolean) ipChange.ipc$dispatch("315410241", new Object[]{this})).booleanValue();
        }
        PagingLoader pagingLoader = this.componentLoader;
        if (pagingLoader == null) {
            return false;
        }
        if (getRequestBuilder() != null && pagingLoader.canLoadNextPage() && hasNext()) {
            pagingLoader.loadNextPage();
            return true;
        }
        return pagingLoader.isLoading();
    }

    public final void notifyLocalDataSetChanged(@NotNull List<? extends IItem<ItemValue>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1753759109")) {
            ipChange.ipc$dispatch("1753759109", new Object[]{this, list});
            return;
        }
        b41.i(list, "newList");
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = getAdapter();
        if (adapter == null) {
            return;
        }
        adapter.notifyLocalDataSetChanged(this.childItems, list);
    }

    public void onAdd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-766754352")) {
            ipChange.ipc$dispatch("-766754352", new Object[]{this});
        }
    }

    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1802573589")) {
            return ((Boolean) ipChange.ipc$dispatch("1802573589", new Object[]{this, str, map})).booleanValue();
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

    public void onRemove() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "839901269")) {
            ipChange.ipc$dispatch("839901269", new Object[]{this});
        } else {
            setIndex(getIndex() - 1);
        }
    }

    @Override // com.youku.arch.v3.IItemManager
    public void removeItem(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1720777295")) {
            ipChange.ipc$dispatch("-1720777295", new Object[]{this, iItem});
            return;
        }
        b41.i(iItem, "item");
        removeItem(iItem, (OnChildAttachStateChangeListener) null);
    }

    @Override // com.youku.arch.v3.IItemManager
    public void replaceItem(final int i, @NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1664586266")) {
            ipChange.ipc$dispatch("1664586266", new Object[]{this, Integer.valueOf(i), iItem});
            return;
        }
        b41.i(iItem, "item");
        iItem.setComponent(this);
        this.childItems.set(i, iItem);
        getPageContext().runOnUIThreadLocked(new Function0<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>>(this) { // from class: com.youku.arch.v3.core.component.GenericComponent$replaceItem$1
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ GenericComponent<VALUE> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> invoke() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-359606688")) {
                    return (VBaseAdapter) ipChange2.ipc$dispatch("-359606688", new Object[]{this});
                }
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = this.this$0.getAdapter();
                if (adapter == null) {
                    return null;
                }
                int i2 = i;
                if (adapter.getInnerAdapter() != null) {
                    VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter = adapter.getInnerAdapter();
                    b41.f(innerAdapter);
                    if (i2 < innerAdapter.getItemCount()) {
                        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter2 = adapter.getInnerAdapter();
                        b41.f(innerAdapter2);
                        innerAdapter2.notifyItemChanged(i2);
                        return adapter;
                    }
                    return adapter;
                } else if (i2 < adapter.getItemCount()) {
                    adapter.notifyItemChanged(i2);
                    return adapter;
                } else {
                    return adapter;
                }
            }
        });
    }

    @Override // com.youku.arch.v3.io.RequestClient
    public void request(@NotNull final IRequest iRequest, @NotNull final Callback callback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1428051268")) {
            ipChange.ipc$dispatch("1428051268", new Object[]{this, iRequest, callback});
            return;
        }
        b41.i(iRequest, "request");
        b41.i(callback, WXBridgeManager.METHOD_CALLBACK);
        getPageContext().runOnLoaderThread(new Function0<wt2>() { // from class: com.youku.arch.v3.core.component.GenericComponent$request$1
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
                if (AndroidInstantRuntime.support(ipChange2, "774712504")) {
                    ipChange2.ipc$dispatch("774712504", new Object[]{this});
                } else {
                    Repository.Companion.getInstance().request(IRequest.this, callback);
                }
            }
        });
    }

    public final void setChildIndexUpdater(@NotNull ChildIndexUpdater<IItem<ItemValue>> childIndexUpdater) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1397937286")) {
            ipChange.ipc$dispatch("1397937286", new Object[]{this, childIndexUpdater});
            return;
        }
        b41.i(childIndexUpdater, "<set-?>");
        this.childIndexUpdater = childIndexUpdater;
    }

    public final void setComponentLoader(@Nullable PagingLoader pagingLoader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "106608489")) {
            ipChange.ipc$dispatch("106608489", new Object[]{this, pagingLoader});
        } else {
            this.componentLoader = pagingLoader;
        }
    }

    public final void setDataBound(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "455216526")) {
            ipChange.ipc$dispatch("455216526", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isDataBound = z;
        }
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setEventHandler(@Nullable EventHandler eventHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-587805251")) {
            ipChange.ipc$dispatch("-587805251", new Object[]{this, eventHandler});
        } else {
            this.eventHandler = eventHandler;
        }
    }

    @Override // com.youku.arch.v3.Addressable
    public void setIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "854837531")) {
            ipChange.ipc$dispatch("854837531", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.index = i;
        }
    }

    @Override // com.youku.arch.v3.IComponent
    public void setInnerAdapter(@Nullable VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1339008783")) {
            ipChange.ipc$dispatch("-1339008783", new Object[]{this, vBaseAdapter});
        } else {
            this.innerAdapter = vBaseAdapter;
        }
    }

    @Override // com.youku.arch.v3.IItemManager
    public void setItemFactory(@Nullable GenericFactory<IItem<ItemValue>, Node> genericFactory) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1968676078")) {
            ipChange.ipc$dispatch("-1968676078", new Object[]{this, genericFactory});
        } else {
            this.itemFactory = genericFactory;
        }
    }

    @Override // com.youku.arch.v3.IComponent
    public void setModule(@NotNull IModule<ModuleValue> iModule) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1203490517")) {
            ipChange.ipc$dispatch("1203490517", new Object[]{this, iModule});
            return;
        }
        b41.i(iModule, "<set-?>");
        this.module = iModule;
    }

    public final void setNode(@NotNull Node node) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1460125582")) {
            ipChange.ipc$dispatch("1460125582", new Object[]{this, node});
            return;
        }
        b41.i(node, "<set-?>");
        this.node = node;
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setPageContext(@NotNull IContext iContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "76372606")) {
            ipChange.ipc$dispatch("76372606", new Object[]{this, iContext});
            return;
        }
        b41.i(iContext, "<set-?>");
        this.pageContext = iContext;
    }

    @Override // com.youku.arch.v3.IComponent
    public void setParser(@NotNull ComponentParser<Node, VALUE> componentParser) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1855957599")) {
            ipChange.ipc$dispatch("-1855957599", new Object[]{this, componentParser});
            return;
        }
        b41.i(componentParser, "<set-?>");
        this.parser = componentParser;
    }

    public void setProperty(@NotNull VALUE value) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-195425937")) {
            ipChange.ipc$dispatch("-195425937", new Object[]{this, value});
            return;
        }
        b41.i(value, "<set-?>");
        this.property = value;
    }

    public void setRenders(@Nullable List<? extends Render> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "28355566")) {
            ipChange.ipc$dispatch("28355566", new Object[]{this, list});
        } else {
            this.renders = list;
        }
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setRequestBuilder(@Nullable RequestBuilder requestBuilder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "86195413")) {
            ipChange.ipc$dispatch("86195413", new Object[]{this, requestBuilder});
        } else {
            this.requestBuilder = requestBuilder;
        }
    }

    public final void setType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "900023789")) {
            ipChange.ipc$dispatch("900023789", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.type = i;
        }
    }

    @Override // com.youku.arch.v3.IItemManager
    public void updateChildIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1755052121")) {
            ipChange.ipc$dispatch("1755052121", new Object[]{this});
        } else if (this.childIndexUpdater.hasChanged()) {
            this.childIndexUpdater.updateChildIndex(this.childItems);
        }
    }

    @Override // com.youku.arch.v3.IItemManager
    public void updateItems(@NotNull List<? extends IItem<ItemValue>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-142994260")) {
            ipChange.ipc$dispatch("-142994260", new Object[]{this, list});
            return;
        }
        b41.i(list, "items");
        if (list.size() < this.childItems.size()) {
            List<IItem<ItemValue>> list2 = this.childItems;
            list2.removeAll(list2.subList(list.size(), this.childItems.size()));
        }
        int size = list.size() - 1;
        if (size < 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (this.childItems.size() <= i) {
                addItem(i, list.get(i), true);
            } else if (list.get(i).diff(this.childItems.get(i))) {
                replaceItem(i, list.get(i));
            } else {
                LogUtil.v(TAG, b41.r("same item type:", Integer.valueOf(list.get(i).getType())));
            }
            if (i2 > size) {
                return;
            }
            i = i2;
        }
    }

    @Override // com.youku.arch.v3.IItemManager
    public void addItem(final int i, @NotNull IItem<ItemValue> iItem, final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1277741095")) {
            ipChange.ipc$dispatch("1277741095", new Object[]{this, Integer.valueOf(i), iItem, Boolean.valueOf(z)});
            return;
        }
        b41.i(iItem, "item");
        addItem(i, iItem, new OnChildAttachStateChangeListener() { // from class: com.youku.arch.v3.core.component.GenericComponent$addItem$1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.arch.v3.core.OnChildAttachStateChangeListener
            public void onChildAdded(@NotNull Addressable addressable) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "683162158")) {
                    ipChange2.ipc$dispatch("683162158", new Object[]{this, addressable});
                    return;
                }
                b41.i(addressable, "addressable");
                if (z) {
                    IContext pageContext = this.getPageContext();
                    final GenericComponent<VALUE> genericComponent = this;
                    final int i2 = i;
                    pageContext.runOnUIThreadLocked(new Function0<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>>() { // from class: com.youku.arch.v3.core.component.GenericComponent$addItem$1$onChildAdded$1
                        private static transient /* synthetic */ IpChange $ipChange;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @Nullable
                        public final VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> invoke() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "-385614089")) {
                                return (VBaseAdapter) ipChange3.ipc$dispatch("-385614089", new Object[]{this});
                            }
                            ContentAdapter contentAdapter = genericComponent.getContainer().getContentAdapter();
                            List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> childAdapters = genericComponent.getContainer().getChildAdapters();
                            if (!(childAdapters instanceof List)) {
                                childAdapters = null;
                            }
                            contentAdapter.setAdapters(childAdapters);
                            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = genericComponent.getAdapter();
                            if (adapter == null) {
                                return null;
                            }
                            int i3 = i2;
                            if (adapter.getInnerAdapter() != null) {
                                try {
                                    VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter = adapter.getInnerAdapter();
                                    if (innerAdapter != null) {
                                        innerAdapter.notifyItemInserted(i3);
                                    }
                                } catch (Exception e) {
                                    if (AppInfoProviderProxy.isDebuggable()) {
                                        e.printStackTrace();
                                    }
                                }
                            } else {
                                adapter.notifyItemInserted(i3);
                            }
                            return adapter;
                        }
                    });
                }
            }

            @Override // com.youku.arch.v3.core.OnChildAttachStateChangeListener
            public void onChildRemoved(@NotNull Addressable addressable) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "194127054")) {
                    ipChange2.ipc$dispatch("194127054", new Object[]{this, addressable});
                } else {
                    b41.i(addressable, "addressable");
                }
            }
        });
    }

    @Override // com.youku.arch.v3.IComponent
    public void createItems(@NotNull final List<? extends Node> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "784782303")) {
            ipChange.ipc$dispatch("784782303", new Object[]{this, list});
            return;
        }
        b41.i(list, "nodes");
        getPageContext().runOnLoaderThreadLocked(new Function0<wt2>() { // from class: com.youku.arch.v3.core.component.GenericComponent$createItems$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                if (AndroidInstantRuntime.support(ipChange2, "-195072370")) {
                    ipChange2.ipc$dispatch("-195072370", new Object[]{this});
                    return;
                }
                for (Node node : list) {
                    try {
                        IComponent iComponent = this;
                        IItem<ItemValue> createItem = iComponent.createItem(new Config<>(iComponent.getPageContext(), node.getType(), node, 0, false, 24, null));
                        if (createItem != null) {
                            GenericComponent<VALUE> genericComponent = this;
                            genericComponent.addItem(genericComponent.childItems.size(), createItem, false);
                        }
                    } catch (Exception e) {
                        LogUtil.e("OneArch.GenericComponent", "create item error " + node.getType() + ((Object) e.getMessage()));
                        if (AppInfoProviderProxy.isDebuggable()) {
                            throw e;
                        }
                    }
                }
            }
        });
    }

    @Override // com.youku.arch.v3.IItemManager
    public void removeItem(@NotNull final IItem<ItemValue> iItem, final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1804442813")) {
            ipChange.ipc$dispatch("-1804442813", new Object[]{this, iItem, Boolean.valueOf(z)});
            return;
        }
        b41.i(iItem, "item");
        removeItem(iItem, new OnChildAttachStateChangeListener() { // from class: com.youku.arch.v3.core.component.GenericComponent$removeItem$1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.arch.v3.core.OnChildAttachStateChangeListener
            public void onChildAdded(@NotNull Addressable addressable) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-889766111")) {
                    ipChange2.ipc$dispatch("-889766111", new Object[]{this, addressable});
                } else {
                    b41.i(addressable, "addressable");
                }
            }

            @Override // com.youku.arch.v3.core.OnChildAttachStateChangeListener
            public void onChildRemoved(@NotNull Addressable addressable) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "438548737")) {
                    ipChange2.ipc$dispatch("438548737", new Object[]{this, addressable});
                    return;
                }
                b41.i(addressable, "addressable");
                if (z) {
                    IContext pageContext = this.getPageContext();
                    final IItem<ItemValue> iItem2 = iItem;
                    final GenericComponent<VALUE> genericComponent = this;
                    pageContext.runOnUIThreadLocked(new Function0<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>>() { // from class: com.youku.arch.v3.core.component.GenericComponent$removeItem$1$onChildRemoved$1
                        private static transient /* synthetic */ IpChange $ipChange;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @Nullable
                        public final VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> invoke() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "-638212476")) {
                                return (VBaseAdapter) ipChange3.ipc$dispatch("-638212476", new Object[]{this});
                            }
                            int index = iItem2.getIndex();
                            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = genericComponent.getAdapter();
                            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter = null;
                            if (adapter == null) {
                                return null;
                            }
                            IItem<ItemValue> iItem3 = iItem2;
                            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter = adapter.getInnerAdapter();
                            if (!(innerAdapter != null)) {
                                innerAdapter = null;
                            }
                            if (innerAdapter != null) {
                                try {
                                    innerAdapter.notifyItemRemoved(index);
                                    innerAdapter.notifyItemRangeChanged(index, iItem3.getComponent().getChildCount() - index);
                                } catch (Exception e) {
                                    if (AppInfoProviderProxy.isDebuggable()) {
                                        throw e;
                                    }
                                }
                                vBaseAdapter = innerAdapter;
                            }
                            if (vBaseAdapter == null) {
                                try {
                                    adapter.notifyItemRemoved(index);
                                    adapter.notifyItemRangeChanged(index, iItem3.getComponent().getChildCount() - index);
                                    return adapter;
                                } catch (Exception e2) {
                                    if (AppInfoProviderProxy.isDebuggable()) {
                                        throw e2;
                                    }
                                    return adapter;
                                }
                            }
                            return adapter;
                        }
                    });
                }
            }
        });
    }

    @Override // com.youku.arch.v3.IItemManager
    public void addItem(int i, @NotNull IItem<ItemValue> iItem, @Nullable OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "246462366")) {
            ipChange.ipc$dispatch("246462366", new Object[]{this, Integer.valueOf(i), iItem, onChildAttachStateChangeListener});
            return;
        }
        b41.i(iItem, "item");
        iItem.setComponent(this);
        this.childItems.add(i, iItem);
        iItem.setIndex(i);
        iItem.onAdd();
        this.childIndexUpdater.onChildAdded(iItem);
        if (onChildAttachStateChangeListener == null) {
            return;
        }
        onChildAttachStateChangeListener.onChildAdded(iItem);
    }

    @Override // com.youku.arch.v3.IItemManager
    public void removeItem(@NotNull final IItem<ItemValue> iItem, @Nullable final OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1516351814")) {
            ipChange.ipc$dispatch("-1516351814", new Object[]{this, iItem, onChildAttachStateChangeListener});
            return;
        }
        b41.i(iItem, "item");
        getPageContext().runOnLoaderThreadLocked(new Function0<wt2>(this) { // from class: com.youku.arch.v3.core.component.GenericComponent$removeItem$2
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ GenericComponent<VALUE> this$0;

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
                if (AndroidInstantRuntime.support(ipChange2, "-1369387670")) {
                    return (wt2) ipChange2.ipc$dispatch("-1369387670", new Object[]{this});
                }
                this.this$0.childItems.remove(iItem);
                iItem.onRemove();
                this.this$0.getChildIndexUpdater().onChildRemoved(iItem);
                OnChildAttachStateChangeListener onChildAttachStateChangeListener2 = onChildAttachStateChangeListener;
                if (onChildAttachStateChangeListener2 == null) {
                    return null;
                }
                onChildAttachStateChangeListener2.onChildRemoved(iItem);
                return wt2.INSTANCE;
            }
        });
    }
}
