package com.youku.arch.v3;

import android.taobao.windvane.connect.api.ApiResponse;
import com.youku.arch.v3.adapter.ContentAdapter;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.parser.IParser;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.io.RequestClient;
import com.youku.arch.v3.loader.PageLoader;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\t\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\bJ:\u0010\u0011\u001a\u00020\u001020\u0010\u000f\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\u000e0\r0\n0\tH&J\b\u0010\u0012\u001a\u00020\u0010H&J\b\u0010\u0013\u001a\u00020\u0010H&J\b\u0010\u0014\u001a\u00020\u0010H&R\u0016\u0010\u0017\u001a\u00028\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010!\u001a\u00020\u001c8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010(\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00028\u00000\"8&@&X¦\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010,\u001a\u00020\u00188&@&X¦\u000e¢\u0006\f\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010+R\u001c\u00102\u001a\u00020-8&@&X¦\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R^\u0010;\u001aD\u0012*\u0012(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\u000e0\r\u0018\u00010\n\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u000205\u0012\u0006\u0012\u0004\u0018\u00010604\u0018\u0001038&@&X¦\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R@\u0010>\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\u000e0\r0\n0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006?"}, d2 = {"Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", ApiResponse.VALUE, "Lcom/youku/arch/v3/IModuleManager;", "Lcom/youku/arch/v3/event/EventHandler;", "Lcom/youku/arch/v3/io/RequestClient;", "Lcom/youku/arch/v3/Addressable;", "Lcom/youku/arch/v3/DomainObject;", "Ljava/io/Serializable;", "", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "adapters", "Ltb/wt2;", "addChildAdapters", "reload", "updateContentAdapter", "updateChildIndex", "getProperty", "()Lcom/youku/arch/v3/core/ModelValue;", "property", "", "getType", "()I", "type", "Lcom/youku/arch/v3/loader/PageLoader;", "getPageLoader", "()Lcom/youku/arch/v3/loader/PageLoader;", "setPageLoader", "(Lcom/youku/arch/v3/loader/PageLoader;)V", "pageLoader", "Lcom/youku/arch/v3/core/parser/IParser;", "Lcom/youku/arch/v3/core/Node;", "getParser", "()Lcom/youku/arch/v3/core/parser/IParser;", "setParser", "(Lcom/youku/arch/v3/core/parser/IParser;)V", "parser", "getRefreshThreshold", "setRefreshThreshold", "(I)V", "refreshThreshold", "Lcom/youku/arch/v3/adapter/ContentAdapter;", "getContentAdapter", "()Lcom/youku/arch/v3/adapter/ContentAdapter;", "setContentAdapter", "(Lcom/youku/arch/v3/adapter/ContentAdapter;)V", "contentAdapter", "Lcom/youku/arch/v3/GenericFactory;", "", "", "", "getAdapterFactory", "()Lcom/youku/arch/v3/GenericFactory;", "setAdapterFactory", "(Lcom/youku/arch/v3/GenericFactory;)V", "adapterFactory", "getChildAdapters", "()Ljava/util/List;", "childAdapters", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IContainer<VALUE extends ModelValue> extends IModuleManager, EventHandler, RequestClient, Addressable, DomainObject, Serializable {
    void addChildAdapters(@NotNull List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> list);

    @Nullable
    GenericFactory<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>, Map<String, Object>> getAdapterFactory();

    @NotNull
    List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> getChildAdapters();

    @NotNull
    ContentAdapter getContentAdapter();

    @NotNull
    PageLoader getPageLoader();

    @NotNull
    IParser<Node, VALUE> getParser();

    @NotNull
    VALUE getProperty();

    int getRefreshThreshold();

    int getType();

    void reload();

    void setAdapterFactory(@Nullable GenericFactory<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>, Map<String, Object>> genericFactory);

    void setContentAdapter(@NotNull ContentAdapter contentAdapter);

    void setPageLoader(@NotNull PageLoader pageLoader);

    void setParser(@NotNull IParser<Node, VALUE> iParser);

    void setRefreshThreshold(int i);

    void updateChildIndex();

    void updateContentAdapter();
}
