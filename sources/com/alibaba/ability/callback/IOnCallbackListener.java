package com.alibaba.ability.callback;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.hf0;
import tb.kg0;
import tb.qj0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/alibaba/ability/callback/IOnCallbackListener;", "", "Ltb/hf0;", "result", "Ltb/wt2;", "onErrorCallback", "Ltb/qj0;", "onCallback", "Ltb/kg0;", "ongoingCallback", "megability_interface_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes9.dex */
public interface IOnCallbackListener {
    void onCallback(@NotNull qj0 qj0Var);

    void onErrorCallback(@NotNull hf0 hf0Var);

    void ongoingCallback(@NotNull kg0 kg0Var);
}
