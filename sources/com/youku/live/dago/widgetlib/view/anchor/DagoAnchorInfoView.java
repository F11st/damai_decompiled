package com.youku.live.dago.widgetlib.view.anchor;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uikit.extend.feature.features.PhenixOptions;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dago.widgetlib.interactive.utils.ThemeUtils;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dago.widgets.RoomInfoWidget;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.List;
import tb.cq;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoAnchorInfoView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView mAnchorDescView;
    private TUrlImageView mAnchorImageView;
    private TextView mAnchorNameView;
    private AttentionBtn mAttentionBtn;
    private AnchorCallback mCallback;
    private ImageView mSubtitleIconView;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface AnchorCallback {
        void onAttentionClick();

        void onAvatarClick();
    }

    public DagoAnchorInfoView(@NonNull Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1662455458")) {
            ipChange.ipc$dispatch("1662455458", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R.C7942layout.dago_pgc_anchor_info_layout, this);
        this.mAnchorNameView = (TextView) findViewById(R.id.id_anchor_name);
        this.mSubtitleIconView = (ImageView) findViewById(R.id.id_subtitle_icon);
        this.mAnchorDescView = (TextView) findViewById(R.id.id_anchor_desc);
        this.mAttentionBtn = (AttentionBtn) findViewById(R.id.id_an_attention);
        TUrlImageView tUrlImageView = (TUrlImageView) findViewById(R.id.id_anchor_avatar);
        this.mAnchorImageView = tUrlImageView;
        tUrlImageView.setFadeIn(true);
        UIUtil.setViewRoundedCorner(this.mAnchorImageView, UIUtil.dip2px(15));
        setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.view.anchor.DagoAnchorInfoView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "365558873")) {
                    ipChange2.ipc$dispatch("365558873", new Object[]{this, view});
                } else if (DagoAnchorInfoView.this.mCallback != null) {
                    DagoAnchorInfoView.this.mCallback.onAvatarClick();
                }
            }
        });
        this.mAttentionBtn.setAttentionBtnVisiblityStatus(false, false);
        this.mAttentionBtn.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.view.anchor.DagoAnchorInfoView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1818118054")) {
                    ipChange2.ipc$dispatch("-1818118054", new Object[]{this, view});
                } else if (DagoAnchorInfoView.this.mCallback != null) {
                    DagoAnchorInfoView.this.mCallback.onAttentionClick();
                }
            }
        });
    }

    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "309889312")) {
            ipChange.ipc$dispatch("309889312", new Object[]{this});
            return;
        }
        Log.d(RoomInfoWidget.TAG, "reset");
        this.mAttentionBtn.release();
        this.mAnchorImageView.setImageUrl("", new PhenixOptions().bitmapProcessors(new cq()));
        this.mAnchorImageView.setImageResource(R.C7941drawable.dago_pgc_header_default);
        this.mSubtitleIconView.setImageDrawable(null);
        this.mAnchorNameView.setText("");
        this.mAnchorDescView.setText("");
        this.mCallback = null;
    }

    public void setAnchorCallback(AnchorCallback anchorCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "991196822")) {
            ipChange.ipc$dispatch("991196822", new Object[]{this, anchorCallback});
        } else {
            this.mCallback = anchorCallback;
        }
    }

    public void setAttentionVisibility(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1655442739")) {
            ipChange.ipc$dispatch("-1655442739", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        Log.d(RoomInfoWidget.TAG, "setAttentionVisibility " + z);
        AttentionBtn attentionBtn = this.mAttentionBtn;
        if (attentionBtn != null) {
            attentionBtn.setAttentionVisibility(z, z2);
        }
    }

    public void setBizType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "722589363")) {
            ipChange.ipc$dispatch("722589363", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        AttentionBtn attentionBtn = this.mAttentionBtn;
        if (attentionBtn != null) {
            attentionBtn.setBizType(i);
        }
    }

    public void setBtnBackground(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1345837847")) {
            ipChange.ipc$dispatch("1345837847", new Object[]{this, drawable});
        }
    }

    public void setBtnBg(List<String> list) {
        int i;
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-889039891")) {
            ipChange.ipc$dispatch("-889039891", new Object[]{this, list});
        } else if (list == null || list.size() <= 0) {
        } else {
            if (TextUtils.isEmpty(list.get(0))) {
                i = 0;
            } else {
                i = Color.parseColor(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + list.get(0));
            }
            if (list.size() > 1 && !TextUtils.isEmpty(list.get(1))) {
                i2 = Color.parseColor(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + list.get(1));
            }
            if (i == 0 && i2 == 0) {
                return;
            }
            int i3 = i == 0 ? i2 : i;
            setBtnBackground(ThemeUtils.getGradientDrawable(i3, i2 == 0 ? i3 : i2, GradientDrawable.Orientation.LEFT_RIGHT, 0, 0, DensityUtil.dip2px(getContext(), 15.0f)));
        }
    }

    public void setSubtitleIcon(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1278670854")) {
            ipChange.ipc$dispatch("1278670854", new Object[]{this, str});
            return;
        }
        Log.d(RoomInfoWidget.TAG, "setSubtitleIcon " + str);
        if (TextUtils.isEmpty(str)) {
            this.mSubtitleIconView.setVisibility(8);
            return;
        }
        DagoImageLoader.getInstance().showDefault(getContext(), str, this.mSubtitleIconView);
        this.mSubtitleIconView.setVisibility(0);
    }

    public void setSupportAnim(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "550551703")) {
            ipChange.ipc$dispatch("550551703", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        AttentionBtn attentionBtn = this.mAttentionBtn;
        if (attentionBtn != null) {
            attentionBtn.setSupportAnim(z);
        }
    }

    public void updateAnchorAttentionState(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "667634154")) {
            ipChange.ipc$dispatch("667634154", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    public void updateAnchorAvatar(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "178316782")) {
            ipChange.ipc$dispatch("178316782", new Object[]{this, str});
            return;
        }
        Log.d(RoomInfoWidget.TAG, "updateAnchorAvatar : url :" + str);
        TUrlImageView tUrlImageView = this.mAnchorImageView;
        int i = R.C7941drawable.dago_pgc_header_default;
        tUrlImageView.setPlaceHoldImageResId(i);
        this.mAnchorImageView.setErrorImageResId(i);
        this.mAnchorImageView.setImageUrl(str, new PhenixOptions().bitmapProcessors(new cq()));
    }

    public void updateAnchorDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-537500234")) {
            ipChange.ipc$dispatch("-537500234", new Object[]{this, str});
            return;
        }
        Log.d(RoomInfoWidget.TAG, "updateAnchorDesc : desc :" + str);
        this.mAnchorDescView.setText(str);
    }

    public void updateAnchorName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1773472252")) {
            ipChange.ipc$dispatch("1773472252", new Object[]{this, str});
            return;
        }
        Log.d(RoomInfoWidget.TAG, "updateAnchorName " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mAnchorNameView.setText(str);
    }

    public DagoAnchorInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DagoAnchorInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
