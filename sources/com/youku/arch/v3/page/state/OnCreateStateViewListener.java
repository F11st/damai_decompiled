package com.youku.arch.v3.page.state;

import android.view.ViewGroup;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/youku/arch/v3/page/state/OnCreateStateViewListener;", "", "Landroid/view/ViewGroup;", "parent", "Lcom/youku/arch/v3/page/state/State;", "state", "Lcom/youku/arch/v3/page/state/IStateView;", "onCreateStateView", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface OnCreateStateViewListener {
    @Nullable
    IStateView onCreateStateView(@NotNull ViewGroup viewGroup, @NotNull State state);
}
