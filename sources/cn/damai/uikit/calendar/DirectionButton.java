package cn.damai.uikit.calendar;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.TypedValue;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class DirectionButton extends ImageView {
    private static transient /* synthetic */ IpChange $ipChange;

    public DirectionButton(Context context) {
        super(context);
        setBackgroundResource(getThemeSelectableBackgroundId(context));
    }

    private static int getThemeSelectableBackgroundId(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1614486520")) {
            return ((Integer) ipChange.ipc$dispatch("-1614486520", new Object[]{context})).intValue();
        }
        int identifier = context.getResources().getIdentifier("selectableItemBackgroundBorderless", RichTextNode.ATTR, context.getPackageName());
        if (identifier == 0) {
            identifier = Build.VERSION.SDK_INT >= 21 ? 16843868 : 16843534;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(identifier, typedValue, true);
        return typedValue.resourceId;
    }

    public void setColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1135760225")) {
            ipChange.ipc$dispatch("-1135760225", new Object[]{this, Integer.valueOf(i)});
        } else {
            setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1679606322")) {
            ipChange.ipc$dispatch("-1679606322", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setEnabled(z);
        setAlpha(z ? 1.0f : 0.1f);
    }
}
