package com.youku.arch.v3.loader;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0002H&J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u000b\u001a\u00020\u0002H&J\b\u0010\f\u001a\u00020\u0002H&J\b\u0010\r\u001a\u00020\u0002H&J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¨\u0006\u000f"}, d2 = {"Lcom/youku/arch/v3/loader/ILoadingViewListener;", "", "Ltb/wt2;", "onNextPageLoading", "", "message", "onLoadNextFailure", "onLoadNextSuccess", "onAllPageLoaded", "onLoading", "onFailure", "onNoData", "onNoNetwork", "onSuccess", "onFailureWithData", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface ILoadingViewListener {
    void onAllPageLoaded();

    void onFailure(@Nullable String str);

    void onFailureWithData(@Nullable String str);

    void onLoadNextFailure(@Nullable String str);

    void onLoadNextSuccess();

    void onLoading();

    void onNextPageLoading();

    void onNoData();

    void onNoNetwork();

    void onSuccess();
}
