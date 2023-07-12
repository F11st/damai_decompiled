package com.youku.arch.v3;

import android.taobao.windvane.connect.api.ApiResponse;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.parser.IParser;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.io.RequestClient;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\bJ2\u0010\u000f\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\u000e0\r0\n0\tH&J\u0016\u0010\u0014\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&R\u0016\u0010\u0018\u001a\u00020\u00158&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00028\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00028\u00000#8&@&X¦\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010.\u001a\u00020)8&@&X¦\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/youku/arch/v3/IModule;", "Lcom/youku/arch/v3/core/ModuleValue;", ApiResponse.VALUE, "Lcom/youku/arch/v3/IComponentManager;", "Lcom/youku/arch/v3/event/EventHandler;", "Lcom/youku/arch/v3/io/RequestClient;", "Lcom/youku/arch/v3/Addressable;", "Lcom/youku/arch/v3/DomainObject;", "Lcom/youku/arch/v3/Diff;", "", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "getAdapters", "", "Lcom/youku/arch/v3/core/Node;", "nodes", "Ltb/wt2;", "createComponents", "", "getType", "()I", "type", "getProperty", "()Lcom/youku/arch/v3/core/ModuleValue;", "property", "Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "getContainer", "()Lcom/youku/arch/v3/IContainer;", "setContainer", "(Lcom/youku/arch/v3/IContainer;)V", "container", "Lcom/youku/arch/v3/core/parser/IParser;", "getParser", "()Lcom/youku/arch/v3/core/parser/IParser;", "setParser", "(Lcom/youku/arch/v3/core/parser/IParser;)V", "parser", "Lcom/youku/arch/v3/ChildState;", "getChildState", "()Lcom/youku/arch/v3/ChildState;", "setChildState", "(Lcom/youku/arch/v3/ChildState;)V", "childState", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IModule<VALUE extends ModuleValue> extends IComponentManager, EventHandler, RequestClient, Addressable, DomainObject, Diff<IModule<VALUE>> {
    void createComponents(@NotNull List<? extends Node> list);

    @NotNull
    List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> getAdapters();

    @NotNull
    ChildState getChildState();

    @NotNull
    IContainer<ModelValue> getContainer();

    @NotNull
    IParser<Node, VALUE> getParser();

    @NotNull
    VALUE getProperty();

    int getType();

    void setChildState(@NotNull ChildState childState);

    void setContainer(@NotNull IContainer<ModelValue> iContainer);

    void setParser(@NotNull IParser<Node, VALUE> iParser);
}
