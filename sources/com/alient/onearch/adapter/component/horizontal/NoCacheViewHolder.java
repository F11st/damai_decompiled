package com.alient.onearch.adapter.component.horizontal;

import android.view.View;
import com.youku.arch.v3.view.render.DefaultViewHolder;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/alient/onearch/adapter/component/horizontal/NoCacheViewHolder;", "Lcom/youku/arch/v3/view/render/DefaultViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public final class NoCacheViewHolder extends DefaultViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoCacheViewHolder(@Nullable View view) {
        super(view);
        b41.f(view);
        setIsRecyclable(false);
    }
}
