package com.youku.gaiax.js.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&¨\u0006\u0005"}, d2 = {"Lcom/youku/gaiax/js/api/IGaiaXPromise;", "", "Lcom/youku/gaiax/js/api/IGaiaXCallback;", "resolve", "reject", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IGaiaXPromise {
    @NotNull
    IGaiaXCallback reject();

    @NotNull
    IGaiaXCallback resolve();
}
