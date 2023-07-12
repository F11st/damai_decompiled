package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.ailp;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListRecyclerViewAdapter;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AILPChatListYoukuAdapterNew extends AILPChatListYoukuAdapter {
    private static transient /* synthetic */ IpChange $ipChange;

    public AILPChatListYoukuAdapterNew(@NonNull Context context) {
        super(context);
        setWillNotDraw(false);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.ailp.AILPChatListYoukuAdapter, com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListAdapter
    protected BaseChatListRecyclerViewAdapter createAdapter(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1869620612") ? (BaseChatListRecyclerViewAdapter) ipChange.ipc$dispatch("-1869620612", new Object[]{this, context}) : new AILPChatListRecyclerViewAdapterNew(context);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2078014876")) {
            ipChange.ipc$dispatch("-2078014876", new Object[]{this, canvas});
        } else {
            super.onDraw(canvas);
        }
    }

    public AILPChatListYoukuAdapterNew(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
    }

    public AILPChatListYoukuAdapterNew(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
    }
}
