package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class FakeBoldTextView extends AppCompatTextView {
    private static transient /* synthetic */ IpChange $ipChange;

    public FakeBoldTextView(@NonNull Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1913452489")) {
            ipChange.ipc$dispatch("1913452489", new Object[]{this, context});
        } else {
            getPaint().setFakeBoldText(true);
        }
    }

    public FakeBoldTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FakeBoldTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
