package com.taobao.android.abilitykit.ability.pop.render;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import tb.C9586q;
import tb.C9833w;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IAKPopRender<PARAMS extends C9833w, ABILITY_CONTEXT extends C9586q> {
    public static final String BLOCK_CLOSE_EVENT_KEY = "std_pop_should_close";
    public static final String BLOCK_CLOSE_TYPE = "type";

    boolean canContentViewScrollVertically(@NonNull View view, int i);

    void onBlockClose(JSONObject jSONObject);

    void onCreateView(@NonNull ABILITY_CONTEXT ability_context, @NonNull PARAMS params, @Nullable View view, @NonNull IAKPopRenderCallback iAKPopRenderCallback);

    void onSizeChanged(int i, int i2);

    void onViewDetached(@Nullable View view);
}
