package com.youku.arch.v3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006\n"}, d2 = {"Lcom/youku/arch/v3/IViewCreator;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "layoutId", "Landroid/view/ViewGroup;", "viewGroup", "Landroid/view/View;", "createView", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IViewCreator {
    @Nullable
    View createView(@NotNull Context context, int i, @Nullable ViewGroup viewGroup);
}
