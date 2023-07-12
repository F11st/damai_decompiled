package com.youku.arch.v3;

import android.os.Bundle;
import android.taobao.windvane.connect.api.ApiResponse;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.core.parser.IParser;
import com.youku.arch.v3.event.EventHandler;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00000\u0006R\u001c\u0010\f\u001a\u00020\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0011\u001a\u00028\u00008&@&X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001e\u0010*\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030'8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", ApiResponse.VALUE, "Lcom/youku/arch/v3/event/EventHandler;", "Lcom/youku/arch/v3/Addressable;", "Lcom/youku/arch/v3/DomainObject;", "Lcom/youku/arch/v3/Diff;", "", "getType", "()I", "setType", "(I)V", "type", "getProperty", "()Lcom/youku/arch/v3/core/ItemValue;", "setProperty", "(Lcom/youku/arch/v3/core/ItemValue;)V", "property", "Lcom/youku/arch/v3/IComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "getComponent", "()Lcom/youku/arch/v3/IComponent;", "setComponent", "(Lcom/youku/arch/v3/IComponent;)V", "component", "Lcom/youku/arch/v3/IModule;", "Lcom/youku/arch/v3/core/ModuleValue;", "getModule", "()Lcom/youku/arch/v3/IModule;", "module", "Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "getContainer", "()Lcom/youku/arch/v3/IContainer;", "container", "Landroid/os/Bundle;", "getExtra", "()Landroid/os/Bundle;", "extra", "Lcom/youku/arch/v3/core/parser/IParser;", "getParser", "()Lcom/youku/arch/v3/core/parser/IParser;", "parser", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IItem<VALUE extends ItemValue> extends EventHandler, Addressable, DomainObject, Diff<IItem<ItemValue>> {
    @NotNull
    IComponent<ComponentValue> getComponent();

    @Nullable
    IContainer<ModelValue> getContainer();

    @NotNull
    Bundle getExtra();

    @NotNull
    IModule<ModuleValue> getModule();

    @NotNull
    IParser<?, ?> getParser();

    @NotNull
    VALUE getProperty();

    int getType();

    void setComponent(@NotNull IComponent<ComponentValue> iComponent);

    void setProperty(@NotNull VALUE value);

    void setType(int i);
}
