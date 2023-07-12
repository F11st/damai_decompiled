package com.youku.arch.v3;

import android.view.View;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JO\u0010\u000e\u001a\u00020\r\"\u000e\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00020\u00030\u0002\"\n\b\u0001\u0010\u0006*\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJO\u0010\u0010\u001a\u00020\r\"\u000e\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00020\u00030\u0002\"\n\b\u0001\u0010\u0006*\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/youku/arch/v3/IViewDataBinder;", "", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "DATA", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "CONFIG", "Landroid/view/View;", "view", Constants.CONFIG, "data", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", "Ltb/wt2;", "preBindData", "(Landroid/view/View;Lcom/youku/arch/v3/view/render/GenericRenderConfig;Lcom/youku/arch/v3/IItem;Lcom/youku/arch/v3/event/EventHandler;)V", "bindData", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IViewDataBinder {
    <DATA extends IItem<ItemValue>, CONFIG extends GenericRenderConfig> void bindData(@Nullable View view, CONFIG config, @NotNull DATA data, @Nullable EventHandler eventHandler);

    <DATA extends IItem<ItemValue>, CONFIG extends GenericRenderConfig> void preBindData(@Nullable View view, CONFIG config, @NotNull DATA data, @Nullable EventHandler eventHandler);
}
