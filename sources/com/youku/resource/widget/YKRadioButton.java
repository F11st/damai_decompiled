package com.youku.resource.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.youku.resource.R;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKRadioButton extends AppCompatRadioButton implements YKCustomizedView {
    public YKRadioButton(Context context) {
        super(context);
        init(context, null);
    }

    @Override // com.youku.resource.widget.YKCustomizedView
    public void init(Context context, AttributeSet attributeSet) {
        setButtonDrawable(R.C8072drawable.radiobutton_style);
    }

    public YKRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }
}
