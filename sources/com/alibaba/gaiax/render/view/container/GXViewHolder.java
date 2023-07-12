package com.alibaba.gaiax.render.view.container;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.GXTemplateEngine;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/render/view/container/GXViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes6.dex */
public final class GXViewHolder extends RecyclerView.ViewHolder {
    @Nullable
    private Object a;
    @Nullable
    private GXTemplateEngine.C3347i b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXViewHolder(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
    }

    @Nullable
    public final GXTemplateEngine.C3347i a() {
        return this.b;
    }

    public final void b(@Nullable Object obj) {
        this.a = obj;
    }

    public final void c(@Nullable GXTemplateEngine.C3347i c3347i) {
        this.b = c3347i;
    }
}
