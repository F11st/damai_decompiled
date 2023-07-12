package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoClickableSpan extends ClickableSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    private int colorId;

    public DagoClickableSpan(int i) {
        this.colorId = i;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NonNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1530783616")) {
            ipChange.ipc$dispatch("1530783616", new Object[]{this, view});
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1489866185")) {
            ipChange.ipc$dispatch("-1489866185", new Object[]{this, textPaint});
            return;
        }
        textPaint.setColor(this.colorId);
        textPaint.setUnderlineText(false);
    }
}
