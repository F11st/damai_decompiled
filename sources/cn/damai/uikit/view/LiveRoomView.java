package cn.damai.uikit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.R$raw;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class LiveRoomView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView mLiveName;
    private LottieAnimationView mLiveView;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum DMLiveRoomType {
        TAG_TYPE_INIT,
        TAG_TYPE_DEFAULT,
        TAG_TYPE_LIVE
    }

    public LiveRoomView(@NonNull Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-579869062")) {
            ipChange.ipc$dispatch("-579869062", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R$layout.bricks_uikit_live_room, this);
        this.mLiveView = (LottieAnimationView) findViewById(R$id.uikit_live_icon);
        this.mLiveName = (TextView) findViewById(R$id.uikit_tag_view_name);
    }

    public void setLiveType(DMLiveRoomType dMLiveRoomType) {
        LottieAnimationView lottieAnimationView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1140748642")) {
            ipChange.ipc$dispatch("1140748642", new Object[]{this, dMLiveRoomType});
        } else if (this.mLiveName == null || (lottieAnimationView = this.mLiveView) == null) {
        } else {
            if (dMLiveRoomType == DMLiveRoomType.TAG_TYPE_LIVE) {
                lottieAnimationView.setVisibility(0);
                this.mLiveView.setAnimation(R$raw.lottie_live_sound_wave);
                this.mLiveName.setText("直播中");
            } else if (dMLiveRoomType == DMLiveRoomType.TAG_TYPE_DEFAULT) {
                lottieAnimationView.setVisibility(8);
                this.mLiveName.setText("直播");
            }
        }
    }

    public LiveRoomView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveRoomView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
