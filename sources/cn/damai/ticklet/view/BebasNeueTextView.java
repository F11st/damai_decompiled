package cn.damai.ticklet.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BebasNeueTextView extends AppCompatTextView {
    public BebasNeueTextView(Context context) {
        super(context);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/BebasNeue.otf"));
    }

    public BebasNeueTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/BebasNeue.otf"));
    }

    public BebasNeueTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/BebasNeue.otf"));
    }
}
