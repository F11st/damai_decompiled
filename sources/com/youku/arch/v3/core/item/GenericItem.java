package com.youku.arch.v3.core.item;

import android.os.Bundle;
import android.taobao.windvane.connect.api.ApiResponse;
import android.util.SparseArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.Coordinate;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.parser.DefaultItemParser;
import com.youku.arch.v3.core.parser.IParser;
import com.youku.arch.v3.event.ArchExceptionEvent;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.typeconvert.TypeConvertManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.xl2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0011\b\u0016\u0012\u0006\u00100\u001a\u00020/¢\u0006\u0004\bl\u00105B\u0019\b\u0016\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010[\u001a\u00020\u000e¢\u0006\u0004\bl\u0010mJ\u001c\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\u0018\u0010\n\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J&\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00052\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u0016\u0010\u001a\u001a\u00020\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0016R\"\u0010\u0011\u001a\u00020\u001b8V@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00028\u00008\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00107\u001a\u0004\u0018\u0001068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010>\u001a\u0004\u0018\u00010=8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010E\u001a\u00020D8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\"\u0010I\u001a\u00020\u001b8V@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bI\u0010\u001c\u001a\u0004\bJ\u0010\u001e\"\u0004\bK\u0010 R\u001c\u0010L\u001a\u00020\u001b8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\bL\u0010\u001c\u001a\u0004\bM\u0010\u001eR.\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00000N8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR$\u0010U\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010[\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010V\u001a\u0004\b\\\u0010X\"\u0004\b]\u0010ZR\u001c\u0010b\u001a\b\u0012\u0004\u0012\u00020_0^8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u001e\u0010g\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010c8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\be\u0010fR\u0016\u0010k\u001a\u00020h8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bi\u0010j¨\u0006n"}, d2 = {"Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", ApiResponse.VALUE, "Lcom/youku/arch/v3/IItem;", "", "", "", Constants.CONFIG, "Lcom/youku/arch/v3/io/IRequest;", "createRequest", "request", "Lcom/youku/arch/v3/io/Callback;", WXBridgeManager.METHOD_CALLBACK, "Ltb/wt2;", "Lcom/youku/arch/v3/core/Node;", "data", "initProperties", "type", "params", "", "onMessage", "onAdd", "onRemove", "loadMore", xl2.HAS_NEXT, "target", "diff", "", "I", "getType", "()I", "setType", "(I)V", "property", "Lcom/youku/arch/v3/core/ItemValue;", "getProperty", "()Lcom/youku/arch/v3/core/ItemValue;", "setProperty", "(Lcom/youku/arch/v3/core/ItemValue;)V", "Lcom/youku/arch/v3/IComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "component", "Lcom/youku/arch/v3/IComponent;", "getComponent", "()Lcom/youku/arch/v3/IComponent;", "setComponent", "(Lcom/youku/arch/v3/IComponent;)V", "Lcom/youku/arch/v3/core/IContext;", com.youku.arch.v3.data.Constants.PAGE_CONTEXT, "Lcom/youku/arch/v3/core/IContext;", "getPageContext", "()Lcom/youku/arch/v3/core/IContext;", "setPageContext", "(Lcom/youku/arch/v3/core/IContext;)V", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", "Lcom/youku/arch/v3/event/EventHandler;", "getEventHandler", "()Lcom/youku/arch/v3/event/EventHandler;", "setEventHandler", "(Lcom/youku/arch/v3/event/EventHandler;)V", "Lcom/youku/arch/v3/io/RequestBuilder;", "requestBuilder", "Lcom/youku/arch/v3/io/RequestBuilder;", "getRequestBuilder", "()Lcom/youku/arch/v3/io/RequestBuilder;", "setRequestBuilder", "(Lcom/youku/arch/v3/io/RequestBuilder;)V", "Landroid/os/Bundle;", "extra", "Landroid/os/Bundle;", "getExtra", "()Landroid/os/Bundle;", "index", "getIndex", "setIndex", "childCount", "getChildCount", "Lcom/youku/arch/v3/core/parser/IParser;", "parser", "Lcom/youku/arch/v3/core/parser/IParser;", "getParser", "()Lcom/youku/arch/v3/core/parser/IParser;", "setParser", "(Lcom/youku/arch/v3/core/parser/IParser;)V", "rawNode", "Lcom/youku/arch/v3/core/Node;", "getRawNode", "()Lcom/youku/arch/v3/core/Node;", "setRawNode", "(Lcom/youku/arch/v3/core/Node;)V", "node", "getNode", "setNode", "Lcom/youku/arch/v3/IModule;", "Lcom/youku/arch/v3/core/ModuleValue;", "getModule", "()Lcom/youku/arch/v3/IModule;", "module", "Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "getContainer", "()Lcom/youku/arch/v3/IContainer;", "container", "Lcom/youku/arch/v3/core/Coordinate;", "getCoordinate", "()Lcom/youku/arch/v3/core/Coordinate;", "coordinate", "<init>", "(Lcom/youku/arch/v3/core/IContext;Lcom/youku/arch/v3/core/Node;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class GenericItem<VALUE extends ItemValue> implements IItem<VALUE> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int childCount;
    public IComponent<ComponentValue> component;
    @Nullable
    private EventHandler eventHandler;
    @NotNull
    private final Bundle extra;
    private int index;
    @Nullable
    private Node node;
    @NotNull
    private IContext pageContext;
    public IParser<Node, VALUE> parser;
    public VALUE property;
    @Nullable
    private Node rawNode;
    @Nullable
    private RequestBuilder requestBuilder;
    private int type;

    public GenericItem(@NotNull IContext iContext) {
        b41.i(iContext, com.youku.arch.v3.data.Constants.PAGE_CONTEXT);
        this.type = -1;
        this.extra = new Bundle();
        setPageContext(iContext);
    }

    @Override // com.youku.arch.v3.DomainObject
    @NotNull
    public IRequest createRequest(@NotNull Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1265803221")) {
            return (IRequest) ipChange.ipc$dispatch("-1265803221", new Object[]{this, map});
        }
        b41.i(map, Constants.CONFIG);
        throw new UnsupportedOperationException();
    }

    @Override // com.youku.arch.v3.Diff
    public boolean diff(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189432915")) {
            return ((Boolean) ipChange.ipc$dispatch("-189432915", new Object[]{this, iItem})).booleanValue();
        }
        b41.i(iItem, "target");
        return true;
    }

    @Override // com.youku.arch.v3.DomainObject
    public int getChildCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1976937286") ? ((Integer) ipChange.ipc$dispatch("1976937286", new Object[]{this})).intValue() : this.childCount;
    }

    @Override // com.youku.arch.v3.IItem
    @NotNull
    public IComponent<ComponentValue> getComponent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1419303421")) {
            return (IComponent) ipChange.ipc$dispatch("1419303421", new Object[]{this});
        }
        IComponent<ComponentValue> iComponent = this.component;
        if (iComponent != null) {
            return iComponent;
        }
        b41.A("component");
        return null;
    }

    @Override // com.youku.arch.v3.IItem
    @Nullable
    public IContainer<ModelValue> getContainer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-375408003") ? (IContainer) ipChange.ipc$dispatch("-375408003", new Object[]{this}) : getComponent().getContainer();
    }

    @Override // com.youku.arch.v3.Addressable
    @NotNull
    public Coordinate getCoordinate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1457914148") ? (Coordinate) ipChange.ipc$dispatch("1457914148", new Object[]{this}) : new Coordinate(getModule().getIndex(), getComponent().getIndex(), getIndex());
    }

    @Override // com.youku.arch.v3.DomainObject
    @Nullable
    public EventHandler getEventHandler() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2137863523") ? (EventHandler) ipChange.ipc$dispatch("-2137863523", new Object[]{this}) : this.eventHandler;
    }

    @Override // com.youku.arch.v3.IItem
    @NotNull
    public Bundle getExtra() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1491561592") ? (Bundle) ipChange.ipc$dispatch("1491561592", new Object[]{this}) : this.extra;
    }

    @Override // com.youku.arch.v3.Addressable
    public int getIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-569282395")) {
            return ((Integer) ipChange.ipc$dispatch("-569282395", new Object[]{this})).intValue();
        }
        getComponent().updateChildIndex();
        return this.index;
    }

    @Override // com.youku.arch.v3.IItem
    @NotNull
    public IModule<ModuleValue> getModule() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1069746627") ? (IModule) ipChange.ipc$dispatch("1069746627", new Object[]{this}) : getComponent().getModule();
    }

    @Nullable
    public final Node getNode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1935676016") ? (Node) ipChange.ipc$dispatch("-1935676016", new Object[]{this}) : this.node;
    }

    @Override // com.youku.arch.v3.DomainObject
    @NotNull
    public IContext getPageContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "60782060") ? (IContext) ipChange.ipc$dispatch("60782060", new Object[]{this}) : this.pageContext;
    }

    @Override // com.youku.arch.v3.IItem
    @NotNull
    public IParser<Node, VALUE> getParser() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "798845981")) {
            return (IParser) ipChange.ipc$dispatch("798845981", new Object[]{this});
        }
        IParser<Node, VALUE> iParser = this.parser;
        if (iParser != null) {
            return iParser;
        }
        b41.A("parser");
        return null;
    }

    @Override // com.youku.arch.v3.IItem
    @NotNull
    public VALUE getProperty() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1199204345")) {
            return (VALUE) ipChange.ipc$dispatch("1199204345", new Object[]{this});
        }
        VALUE value = this.property;
        if (value != null) {
            return value;
        }
        b41.A("property");
        return null;
    }

    @Nullable
    public final Node getRawNode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "242335750") ? (Node) ipChange.ipc$dispatch("242335750", new Object[]{this}) : this.rawNode;
    }

    @Override // com.youku.arch.v3.DomainObject
    @Nullable
    public RequestBuilder getRequestBuilder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1916615997") ? (RequestBuilder) ipChange.ipc$dispatch("-1916615997", new Object[]{this}) : this.requestBuilder;
    }

    @Override // com.youku.arch.v3.IItem
    public int getType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-43852609")) {
            return ((Integer) ipChange.ipc$dispatch("-43852609", new Object[]{this})).intValue();
        }
        TypeConvertManager typeConvertManager = TypeConvertManager.INSTANCE;
        int i = this.type;
        VALUE property = getProperty();
        Node node = this.node;
        return typeConvertManager.convertType(i, property, node == null ? null : node.getData());
    }

    @Override // com.youku.arch.v3.DomainObject
    public boolean hasNext() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-643128653")) {
            return ((Boolean) ipChange.ipc$dispatch("-643128653", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.youku.arch.v3.DomainObject
    public void initProperties(@NotNull Node node) {
        ConfigManager.ParserConfig parserConfig;
        SparseArray<IParser<?, ?>> parsers;
        IParser<?, ?> iParser;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1004344177")) {
            ipChange.ipc$dispatch("1004344177", new Object[]{this, node});
            return;
        }
        b41.i(node, "data");
        ConfigManager configManager = getPageContext().getConfigManager();
        if (configManager == null || (parserConfig = configManager.getParserConfig(3)) == null || (parsers = parserConfig.getParsers()) == null || (iParser = parsers.get(0)) == null) {
            iParser = null;
        } else {
            setParser(iParser);
        }
        if (iParser == null) {
            setParser(new DefaultItemParser());
        }
        setProperty(getParser().parseElement(node));
        setType(getProperty().getType());
        this.rawNode = node;
        JSONObject data = getProperty().getData();
        if (data != null && !data.isEmpty()) {
            z = false;
        }
        if ((z ? data : null) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("id", Long.valueOf(getProperty().getId()));
        hashMap.put("type", Integer.valueOf(getProperty().getType()));
        JSONObject data2 = getProperty().getData();
        if (data2 != null) {
            hashMap.put("data", data2);
        }
        JSONObject rawJson = getProperty().getRawJson();
        if (rawJson != null) {
            hashMap.put("rawJson", rawJson);
        }
        EventDispatcher eventDispatcher = getPageContext().getEventDispatcher();
        if (eventDispatcher == null) {
            return;
        }
        eventDispatcher.dispatchEvent(ArchExceptionEvent.ITEM_DATA_EMPTY, hashMap);
    }

    @Override // com.youku.arch.v3.DomainObject
    public boolean loadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2032594409")) {
            return ((Boolean) ipChange.ipc$dispatch("-2032594409", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.youku.arch.v3.DomainObject
    public void onAdd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-137242950")) {
            ipChange.ipc$dispatch("-137242950", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.event.EventHandler
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2098932843")) {
            return ((Boolean) ipChange.ipc$dispatch("2098932843", new Object[]{this, str, map})).booleanValue();
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
        if (AndroidInstantRuntime.support(ipChange, "-1508103381")) {
            ipChange.ipc$dispatch("-1508103381", new Object[]{this});
        } else {
            setIndex(getIndex() - 1);
        }
    }

    @Override // com.youku.arch.v3.io.RequestClient
    public void request(@NotNull IRequest iRequest, @NotNull Callback callback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1794663890")) {
            ipChange.ipc$dispatch("-1794663890", new Object[]{this, iRequest, callback});
            return;
        }
        b41.i(iRequest, "request");
        b41.i(callback, WXBridgeManager.METHOD_CALLBACK);
        throw new UnsupportedOperationException();
    }

    @Override // com.youku.arch.v3.IItem
    public void setComponent(@NotNull IComponent<ComponentValue> iComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "940580705")) {
            ipChange.ipc$dispatch("940580705", new Object[]{this, iComponent});
            return;
        }
        b41.i(iComponent, "<set-?>");
        this.component = iComponent;
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setEventHandler(@Nullable EventHandler eventHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "625682087")) {
            ipChange.ipc$dispatch("625682087", new Object[]{this, eventHandler});
        } else {
            this.eventHandler = eventHandler;
        }
    }

    @Override // com.youku.arch.v3.Addressable
    public void setIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1081137413")) {
            ipChange.ipc$dispatch("1081137413", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.index = i;
        }
    }

    public final void setNode(@Nullable Node node) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "568986980")) {
            ipChange.ipc$dispatch("568986980", new Object[]{this, node});
        } else {
            this.node = node;
        }
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setPageContext(@NotNull IContext iContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-710333720")) {
            ipChange.ipc$dispatch("-710333720", new Object[]{this, iContext});
            return;
        }
        b41.i(iContext, "<set-?>");
        this.pageContext = iContext;
    }

    public void setParser(@NotNull IParser<Node, VALUE> iParser) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "450129291")) {
            ipChange.ipc$dispatch("450129291", new Object[]{this, iParser});
            return;
        }
        b41.i(iParser, "<set-?>");
        this.parser = iParser;
    }

    @Override // com.youku.arch.v3.IItem
    public void setProperty(@NotNull VALUE value) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1878193241")) {
            ipChange.ipc$dispatch("1878193241", new Object[]{this, value});
            return;
        }
        b41.i(value, "<set-?>");
        this.property = value;
    }

    public final void setRawNode(@Nullable Node node) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-955944938")) {
            ipChange.ipc$dispatch("-955944938", new Object[]{this, node});
        } else {
            this.rawNode = node;
        }
    }

    @Override // com.youku.arch.v3.DomainObject
    public void setRequestBuilder(@Nullable RequestBuilder requestBuilder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-950402773")) {
            ipChange.ipc$dispatch("-950402773", new Object[]{this, requestBuilder});
        } else {
            this.requestBuilder = requestBuilder;
        }
    }

    @Override // com.youku.arch.v3.IItem
    public void setType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1447980861")) {
            ipChange.ipc$dispatch("-1447980861", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.type = i;
        }
    }

    public GenericItem(@NotNull IContext iContext, @NotNull Node node) {
        b41.i(iContext, com.youku.arch.v3.data.Constants.PAGE_CONTEXT);
        b41.i(node, "node");
        this.type = -1;
        this.extra = new Bundle();
        setPageContext(iContext);
        this.node = node;
        setType(node.getType());
    }
}
