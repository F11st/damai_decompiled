package com.youku.resource.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.youku.resource.R;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKSwitch extends AppCompatCheckBox implements YKCustomizedView {
    public YKSwitch(Context context) {
        super(context);
        init(context, null);
    }

    @Override // com.youku.resource.widget.YKCustomizedView
    public void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.YKSwitch, 0, 0);
            if (obtainStyledAttributes.getInt(R.styleable.YKSwitch_switch_style, 0) == 0) {
                setBackgroundResource(R.drawable.swtich_style_big);
                setButtonDrawable(getResources().getDrawable(17170445));
            } else {
                setBackgroundResource(R.drawable.swtich_style_small);
                setButtonDrawable(getResources().getDrawable(17170445));
            }
            obtainStyledAttributes.recycle();
        }
    }

    public YKSwitch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }
}
