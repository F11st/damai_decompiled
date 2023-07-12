package android.view;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¨\u0006\u0003"}, d2 = {"Landroid/view/View;", "Landroidx/savedstate/SavedStateRegistryOwner;", "findViewTreeSavedStateRegistryOwner", "savedstate-ktx_release"}, k = 2, mv = {1, 4, 1})
/* renamed from: androidx.savedstate.ViewKt  reason: from Kotlin metadata and invalid package and case insensitive filesystem */
/* loaded from: classes.dex */
public final class View {
    @Nullable
    public static final SavedStateRegistryOwner findViewTreeSavedStateRegistryOwner(@NotNull android.view.View view) {
        b41.i(view, "$this$findViewTreeSavedStateRegistryOwner");
        return ViewTreeSavedStateRegistryOwner.get(view);
    }
}
