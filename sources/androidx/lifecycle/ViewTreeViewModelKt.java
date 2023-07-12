package androidx.lifecycle;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¨\u0006\u0003"}, d2 = {"Landroid/view/View;", "Landroidx/lifecycle/ViewModelStoreOwner;", "findViewTreeViewModelStoreOwner", "lifecycle-viewmodel-ktx_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class ViewTreeViewModelKt {
    @Nullable
    public static final ViewModelStoreOwner findViewTreeViewModelStoreOwner(@NotNull View view) {
        b41.i(view, "$this$findViewTreeViewModelStoreOwner");
        return ViewTreeViewModelStoreOwner.get(view);
    }
}
