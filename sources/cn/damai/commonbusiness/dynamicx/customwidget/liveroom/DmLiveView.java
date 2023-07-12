package cn.damai.commonbusiness.dynamicx.customwidget.liveroom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$raw;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DmLiveView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String LIVE_ROOM_VALUE;
    LottieAnimationView mLiveAnimView;
    TextView mLiveName;

    public DmLiveView(@NonNull Context context) {
        super(context);
        this.LIVE_ROOM_VALUE = "2";
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "29769821")) {
            ipChange.ipc$dispatch("29769821", new Object[]{this});
            return;
        }
        setOrientation(0);
        removeAllViews();
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_live_room, (ViewGroup) null, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.mLiveAnimView = (LottieAnimationView) inflate.findViewById(R$id.live_icon);
        this.mLiveName = (TextView) inflate.findViewById(R$id.tag_view_name);
        addView(inflate, layoutParams);
    }

    public void updateLiveType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-841987827")) {
            ipChange.ipc$dispatch("-841987827", new Object[]{this, str});
        } else if (this.mLiveName == null || this.mLiveAnimView == null) {
        } else {
            if ("2".equals(str)) {
                this.mLiveAnimView.setVisibility(0);
                this.mLiveAnimView.setAnimation(R$raw.lottie_live_sound_wave);
                this.mLiveAnimView.playAnimation();
                this.mLiveName.setText("直播中");
                return;
            }
            this.mLiveAnimView.setVisibility(8);
            this.mLiveName.setText("直播");
        }
    }

    public DmLiveView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.LIVE_ROOM_VALUE = "2";
        initView();
    }
}
