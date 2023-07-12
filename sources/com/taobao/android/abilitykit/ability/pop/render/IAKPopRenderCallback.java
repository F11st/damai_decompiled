package com.taobao.android.abilitykit.ability.pop.render;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import tb.C9292j;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IAKPopRenderCallback {
    void onRenderFailed(@NonNull C9292j c9292j, @Nullable View view);

    void onRenderSuccess(@NonNull View view);
}
