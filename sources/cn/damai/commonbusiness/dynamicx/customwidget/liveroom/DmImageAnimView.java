package cn.damai.commonbusiness.dynamicx.customwidget.liveroom;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DmImageAnimView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    LottieAnimationView mLiveAnimView;

    public DmImageAnimView(@NonNull Context context) {
        super(context);
        initView(context);
    }

    private int getRawId(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-86916112")) {
            return ((Integer) ipChange.ipc$dispatch("-86916112", new Object[]{this, context, str})).intValue();
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return context.getResources().getIdentifier(str, "raw", context.getPackageName());
        } catch (Exception e) {
            Log.e("DmImageAnimView", "getRawId exception", e);
            return 0;
        }
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "814715675")) {
            ipChange.ipc$dispatch("814715675", new Object[]{this, context});
            return;
        }
        setOrientation(0);
        setGravity(1);
        removeAllViews();
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_lottie_image, (ViewGroup) null, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.mLiveAnimView = (LottieAnimationView) inflate.findViewById(R$id.live_icon);
        addView(inflate, layoutParams);
    }

    public void updateImageAnim(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "680484749")) {
            ipChange.ipc$dispatch("680484749", new Object[]{this, context, str});
        } else if (this.mLiveAnimView == null || TextUtils.isEmpty(str)) {
        } else {
            this.mLiveAnimView.setVisibility(0);
            this.mLiveAnimView.setAnimation(getRawId(context, str));
        }
    }

    public DmImageAnimView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }
}
