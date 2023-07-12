package cn.damai.uikit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.uikit.image.C2497a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.th2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DMHeaderBackground extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private ImageView backgroundImage;

    public DMHeaderBackground(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "348532614")) {
            ipChange.ipc$dispatch("348532614", new Object[]{this});
            return;
        }
        removeAllViews();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(getContext());
        this.backgroundImage = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.backgroundImage, layoutParams);
    }

    public void setBackgroundImage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "360407514")) {
            ipChange.ipc$dispatch("360407514", new Object[]{this, str});
        } else if (this.backgroundImage == null || th2.e(str)) {
        } else {
            C2497a.a().loadinto(str, this.backgroundImage);
        }
    }

    public void setBgColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1345165884")) {
            ipChange.ipc$dispatch("-1345165884", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ImageView imageView = this.backgroundImage;
        if (imageView == null) {
            return;
        }
        imageView.setBackgroundColor(i);
    }

    public DMHeaderBackground(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public void setBackgroundImage(@DrawableRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-456861453")) {
            ipChange.ipc$dispatch("-456861453", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ImageView imageView = this.backgroundImage;
        if (imageView == null) {
            return;
        }
        imageView.setImageResource(i);
    }

    public DMHeaderBackground(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
