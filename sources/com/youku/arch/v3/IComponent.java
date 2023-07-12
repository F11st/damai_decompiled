package com.youku.arch.v3;

import android.taobao.windvane.connect.api.ApiResponse;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.Render;
import com.youku.arch.v3.core.parser.ComponentParser;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.io.RequestClient;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00000\bJ\b\u0010\n\u001a\u00020\tH&J\u0016\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&J\b\u0010\u000e\u001a\u00020\tH&R\u0016\u0010\u0012\u001a\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00028\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\u001d8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0011R<\u00109\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020403\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020403\u0012\u0004\u0012\u00020605\u0018\u0001028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u00108RB\u0010=\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020403\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020403\u0012\u0004\u0012\u00020605\u0018\u0001028&@&X¦\u000e¢\u0006\f\u001a\u0004\b:\u00108\"\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lcom/youku/arch/v3/IComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", ApiResponse.VALUE, "Lcom/youku/arch/v3/IItemManager;", "Lcom/youku/arch/v3/io/RequestClient;", "Lcom/youku/arch/v3/event/EventHandler;", "Lcom/youku/arch/v3/Addressable;", "Lcom/youku/arch/v3/DomainObject;", "Lcom/youku/arch/v3/Diff;", "Ltb/wt2;", "createItems", "", "Lcom/youku/arch/v3/core/Node;", "nodes", "clearItems", "", "getType", "()I", "type", "getProperty", "()Lcom/youku/arch/v3/core/ComponentValue;", "property", "Lcom/youku/arch/v3/IModule;", "Lcom/youku/arch/v3/core/ModuleValue;", "getModule", "()Lcom/youku/arch/v3/IModule;", "setModule", "(Lcom/youku/arch/v3/IModule;)V", "module", "Lcom/youku/arch/v3/core/parser/ComponentParser;", "getParser", "()Lcom/youku/arch/v3/core/parser/ComponentParser;", "setParser", "(Lcom/youku/arch/v3/core/parser/ComponentParser;)V", "parser", "Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "getContainer", "()Lcom/youku/arch/v3/IContainer;", "container", "Lcom/youku/arch/v3/core/Render;", "getRenders", "()Ljava/util/List;", "renders", "", "getRawJson", "()Ljava/lang/String;", "rawJson", "getPosInRenderList", "posInRenderList", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "getAdapter", "()Lcom/youku/arch/v3/adapter/VBaseAdapter;", "adapter", "getInnerAdapter", "setInnerAdapter", "(Lcom/youku/arch/v3/adapter/VBaseAdapter;)V", "innerAdapter", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IComponent<VALUE extends ComponentValue> extends IItemManager, RequestClient, EventHandler, Addressable, DomainObject, Diff<IComponent<ComponentValue>> {
    void clearItems();

    void createItems();

    void createItems(@NotNull List<? extends Node> list);

    @Nullable
    VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> getAdapter();

    @NotNull
    IContainer<ModelValue> getContainer();

    @Nullable
    VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> getInnerAdapter();

    @NotNull
    IModule<ModuleValue> getModule();

    @NotNull
    ComponentParser<Node, VALUE> getParser();

    int getPosInRenderList();

    @NotNull
    VALUE getProperty();

    @Nullable
    String getRawJson();

    @Nullable
    List<Render> getRenders();

    int getType();

    void setInnerAdapter(@Nullable VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter);

    void setModule(@NotNull IModule<ModuleValue> iModule);

    void setParser(@NotNull ComponentParser<Node, VALUE> componentParser);
}
