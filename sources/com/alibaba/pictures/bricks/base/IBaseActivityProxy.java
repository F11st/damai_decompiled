package com.alibaba.pictures.bricks.base;

import android.view.ViewGroup;
import com.alibaba.pictures.bricks.base.BricksBaseFragment;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface IBaseActivityProxy {
    void hideLoading();

    void hideLoadingDialog();

    void removeErrorView(@NotNull ViewGroup viewGroup);

    void showErrorView(int i, @NotNull String str, @NotNull String str2, @NotNull ViewGroup viewGroup, boolean z, boolean z2, boolean z3, @NotNull BricksBaseFragment.IClickListener iClickListener);

    void showErrorView(@NotNull String str, @NotNull String str2, @NotNull ViewGroup viewGroup, @NotNull BricksBaseFragment.IClickListener iClickListener);

    void showLoading(@NotNull String... strArr);

    void showLoadingDialog(@NotNull String... strArr);
}
