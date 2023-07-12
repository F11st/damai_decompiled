package com.youku.arch.v3.view.render;

import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0007\u001a\u00020\u00062\u0010\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J4\u0010\f\u001a\u00020\u00062\u0010\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&J.\u0010\u000f\u001a\u00020\u00062\u0010\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J4\u0010\u0010\u001a\u00020\u00062\u0010\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&JB\u0010\u0015\u001a\u00020\u00062\u0010\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013H&J4\u0010\f\u001a\u00020\u00062\u0010\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&J\b\u0010\u0018\u001a\u00020\u0006H&¨\u0006\u0019"}, d2 = {"Lcom/youku/arch/v3/view/render/OnRenderListener;", "", "Lcom/youku/arch/v3/view/render/AbsRenderPlugin;", "renderPlugin", "Landroid/view/View;", "instance", "Ltb/wt2;", "onRenderStart", "renderView", "", "width", "height", "onRenderSuccess", "Lcom/youku/arch/v3/view/render/RenderError;", "error", "onRenderFailed", "onLayoutChanged", "", "eventName", "", "params", "onReceiveEvent", "Landroidx/fragment/app/Fragment;", "renderFragment", "onRenderDestroy", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface OnRenderListener {
    void onLayoutChanged(@Nullable AbsRenderPlugin<?, ?> absRenderPlugin, @Nullable View view, int i, int i2);

    void onReceiveEvent(@Nullable AbsRenderPlugin<?, ?> absRenderPlugin, @Nullable View view, @NotNull String str, @Nullable Map<String, ? extends Object> map);

    void onRenderDestroy();

    void onRenderFailed(@Nullable AbsRenderPlugin<?, ?> absRenderPlugin, @Nullable View view, @Nullable RenderError renderError);

    void onRenderStart(@Nullable AbsRenderPlugin<?, ?> absRenderPlugin, @Nullable View view);

    void onRenderSuccess(@Nullable AbsRenderPlugin<?, ?> absRenderPlugin, @Nullable View view, int i, int i2);

    void onRenderSuccess(@Nullable AbsRenderPlugin<?, ?> absRenderPlugin, @Nullable Fragment fragment, int i, int i2);
}
