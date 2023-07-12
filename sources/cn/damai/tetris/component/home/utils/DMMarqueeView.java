package cn.damai.tetris.component.home.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;
import cn.damai.commonbusiness.R$anim;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class DMMarqueeView extends ViewFlipper {
    private static transient /* synthetic */ IpChange $ipChange;

    public DMMarqueeView(Context context) {
        super(context);
    }

    public void setAnimationDuration(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1477590856")) {
            ipChange.ipc$dispatch("1477590856", new Object[]{this, Long.valueOf(j)});
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R$anim.damai_marquee_in);
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            loadAnimation.setDuration(j);
        }
        setInAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R$anim.damai_marquee_out);
        if (i > 0) {
            loadAnimation2.setDuration(j);
        }
        setOutAnimation(loadAnimation2);
    }

    public void setItems(List<View> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-697641243")) {
            ipChange.ipc$dispatch("-697641243", new Object[]{this, list});
        } else if (list != null && list.size() != 0) {
            removeAllViews();
            for (int i = 0; i < list.size(); i++) {
                ViewGroup viewGroup = (ViewGroup) list.get(i).getParent();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                addView(list.get(i));
            }
            if (isFlipping()) {
                stopFlipping();
            }
            if (list.size() > 1) {
                startFlipping();
            }
        }
    }

    public DMMarqueeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
