package com.kcrason.dynamicpagerindicatorlibrary;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/kcrason/dynamicpagerindicatorlibrary/IPagerTabView;", "", "Landroid/widget/TextView;", "getTabTextView", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/view/View;", "onCreateTabView", "dynamicpagerindicatorlibrary_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes10.dex */
public interface IPagerTabView {
    @Nullable
    TextView getTabTextView();

    @NotNull
    View onCreateTabView(@NotNull Context context);
}
