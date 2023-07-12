package com.youku.arch.v3;

import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.OnChildAttachStateChangeListener;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\tH&J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&J\u0016\u0010\u0011\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\u001e\u0010\u0011\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\tH&J \u0010\u0011\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0012H&J\b\u0010\u0014\u001a\u00020\u0007H&J\b\u0010\u0015\u001a\u00020\u0007H&J\u001e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\u001c\u0010\u0018\u001a\u00020\u00072\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0012H&R0\u0010\u001e\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00198&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/youku/arch/v3/IComponentManager;", "", "", "index", "Lcom/youku/arch/v3/IComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "component", "Ltb/wt2;", "addComponent", "", "notifyUiUpdate", "Lcom/youku/arch/v3/core/OnChildAttachStateChangeListener;", "listener", "Lcom/youku/arch/v3/core/Config;", "Lcom/youku/arch/v3/core/Node;", Constants.CONFIG, "createComponent", "removeComponent", "", "getComponents", "updateChildIndex", "clearComponents", "replaceComponent", com.youku.arch.v3.data.Constants.COMPONENT, "updateComponents", "Lcom/youku/arch/v3/GenericFactory;", "getComponentFactory", "()Lcom/youku/arch/v3/GenericFactory;", "setComponentFactory", "(Lcom/youku/arch/v3/GenericFactory;)V", "componentFactory", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IComponentManager {
    void addComponent(int i, @NotNull IComponent<ComponentValue> iComponent);

    void addComponent(int i, @NotNull IComponent<ComponentValue> iComponent, @Nullable OnChildAttachStateChangeListener onChildAttachStateChangeListener);

    void addComponent(int i, @NotNull IComponent<ComponentValue> iComponent, boolean z);

    void clearComponents();

    @Nullable
    IComponent<ComponentValue> createComponent(@NotNull Config<Node> config) throws Exception;

    @Nullable
    GenericFactory<IComponent<ComponentValue>, Node> getComponentFactory();

    @NotNull
    List<IComponent<ComponentValue>> getComponents();

    void removeComponent(@NotNull IComponent<ComponentValue> iComponent);

    void removeComponent(@NotNull IComponent<ComponentValue> iComponent, @Nullable OnChildAttachStateChangeListener onChildAttachStateChangeListener);

    void removeComponent(@NotNull IComponent<ComponentValue> iComponent, boolean z);

    void replaceComponent(int i, @NotNull IComponent<ComponentValue> iComponent);

    void setComponentFactory(@Nullable GenericFactory<IComponent<ComponentValue>, Node> genericFactory);

    void updateChildIndex();

    void updateComponents(@NotNull List<? extends IComponent<ComponentValue>> list);
}
