package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.span;

import android.content.Context;
import android.text.SpannableStringBuilder;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface YTBaseSpan {
    YTBaseSpan fetch(Context context);

    YTBaseSpan format(SpannableStringBuilder spannableStringBuilder);

    YTBaseSpan into(SpannableStringBuilder spannableStringBuilder);
}
