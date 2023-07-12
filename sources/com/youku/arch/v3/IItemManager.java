package com.youku.arch.v3;

import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.OnChildAttachStateChangeListener;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000e\u001a\u00020\rH&J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\u0016\u0010\u0011\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u001e\u0010\u0011\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000e\u001a\u00020\rH&J \u0010\u0011\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\u001c\u0010\u0014\u001a\u00020\u000b2\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0012H&J\u001e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0016H&J\b\u0010\u0018\u001a\u00020\u000bH&R0\u0010\u001e\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00198&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/youku/arch/v3/IItemManager;", "", "Lcom/youku/arch/v3/core/Config;", "Lcom/youku/arch/v3/core/Node;", Constants.CONFIG, "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "createItem", "", "index", "item", "Ltb/wt2;", "addItem", "", "notifyUiUpdate", "Lcom/youku/arch/v3/core/OnChildAttachStateChangeListener;", "listener", "removeItem", "", "items", "updateItems", "replaceItem", "", "getItems", "updateChildIndex", "Lcom/youku/arch/v3/GenericFactory;", "getItemFactory", "()Lcom/youku/arch/v3/GenericFactory;", "setItemFactory", "(Lcom/youku/arch/v3/GenericFactory;)V", "itemFactory", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IItemManager {
    void addItem(int i, @NotNull IItem<ItemValue> iItem);

    void addItem(int i, @NotNull IItem<ItemValue> iItem, @Nullable OnChildAttachStateChangeListener onChildAttachStateChangeListener);

    void addItem(int i, @NotNull IItem<ItemValue> iItem, boolean z);

    @Nullable
    IItem<ItemValue> createItem(@NotNull Config<Node> config) throws Exception;

    @Nullable
    GenericFactory<IItem<ItemValue>, Node> getItemFactory();

    @NotNull
    List<IItem<ItemValue>> getItems();

    void removeItem(@NotNull IItem<ItemValue> iItem);

    void removeItem(@NotNull IItem<ItemValue> iItem, @Nullable OnChildAttachStateChangeListener onChildAttachStateChangeListener);

    void removeItem(@NotNull IItem<ItemValue> iItem, boolean z);

    void replaceItem(int i, @NotNull IItem<ItemValue> iItem);

    void setItemFactory(@Nullable GenericFactory<IItem<ItemValue>, Node> genericFactory);

    void updateChildIndex();

    void updateItems(@NotNull List<? extends IItem<ItemValue>> list);
}
