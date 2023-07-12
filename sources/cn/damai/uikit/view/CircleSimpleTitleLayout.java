package cn.damai.uikit.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import cn.damai.uikit.R$color;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.image.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.uplayer.AliMediaPlayer;
import tb.kg2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class CircleSimpleTitleLayout extends FrameLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private float curAlpha;
    private String endColor;
    private boolean isSetAlphaFirstTime;
    private boolean isWhiteBgNow;
    private LinearLayout llJoin;
    private Activity mActivity;
    private TextView mBackBtn;
    private View mDivider;
    private ImageView mImgIv;
    private DMIconFontTextView mJoinIcon;
    private TextView mJoinTv;
    private View mLayout;
    private OnBtnClickListener mListener;
    private DMIconFontTextView mShareBtn;
    private View mSpaceView;
    private TextView mTitleTv;
    private String startColor;
    private boolean supportImmersive;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnBtnClickListener {
        void onAddClick();

        void onBackClick();

        void onShareClick();
    }

    public CircleSimpleTitleLayout(@NonNull Context context) {
        this(context, null);
    }

    public void enableDivider(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1353459525")) {
            ipChange.ipc$dispatch("-1353459525", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mDivider.setVisibility(0);
        } else {
            this.mDivider.setVisibility(4);
        }
    }

    public void enableImmersiveMode(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1633231302")) {
            ipChange.ipc$dispatch("1633231302", new Object[]{this, activity});
        } else if (activity == null) {
        } else {
            this.mActivity = activity;
            this.supportImmersive = true;
            if (Build.VERSION.SDK_INT >= 23) {
                this.mSpaceView.getLayoutParams().height = kg2.a(activity);
                this.mSpaceView.setVisibility(0);
                kg2.f(activity, true, R$color.black);
                return;
            }
            kg2.f(activity, false, R$color.black);
            this.mSpaceView.setVisibility(8);
        }
    }

    public void joinBtnStyleView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "700252125")) {
            ipChange.ipc$dispatch("700252125", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        String str = this.startColor;
        this.mJoinTv.setTextColor(Color.parseColor(str));
        this.mJoinIcon.setTextColor(Color.parseColor(str));
        GradientDrawable gradientDrawable = (GradientDrawable) ContextCompat.getDrawable(getContext(), R$drawable.circle_title_add_bg);
        if (gradientDrawable != null) {
            gradientDrawable.setAlpha(z ? AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_FIXED_GEAR_INDEX : 255);
            this.llJoin.setBackground(gradientDrawable);
        }
        this.mJoinIcon.setVisibility(z ? 8 : 0);
        this.mJoinTv.setText(z ? "已加入" : "加入");
        this.isSetAlphaFirstTime = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1482099188")) {
            ipChange.ipc$dispatch("-1482099188", new Object[]{this, view});
        } else if (this.mListener == null) {
        } else {
            int id = view.getId();
            if (id == this.mBackBtn.getId()) {
                this.mListener.onBackClick();
            } else if (id == this.mShareBtn.getId()) {
                this.mListener.onShareClick();
            } else if (id == this.mJoinTv.getId()) {
                this.mListener.onAddClick();
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-276496403")) {
            ipChange.ipc$dispatch("-276496403", new Object[]{this, canvas});
            return;
        }
        int i = (int) (this.curAlpha * 255.0f);
        int i2 = i >= 0 ? i : 0;
        if (i2 > 255) {
            i2 = 255;
        }
        canvas.drawColor(Color.argb(i2, 255, 255, 255));
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "691330465")) {
            ipChange.ipc$dispatch("691330465", new Object[]{this, Float.valueOf(f)});
            return;
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        boolean z2 = this.isSetAlphaFirstTime;
        if (z2 || this.curAlpha != f) {
            this.curAlpha = f;
            boolean z3 = ((double) f) > 0.5d;
            if (!z2 && this.isWhiteBgNow == z3) {
                z = false;
            }
            if (z2) {
                this.isSetAlphaFirstTime = false;
            }
            if (z) {
                switchMode(z3);
            }
            invalidate();
        }
    }

    public void setColor(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-999710226")) {
            ipChange.ipc$dispatch("-999710226", new Object[]{this, str, str2});
            return;
        }
        this.startColor = str;
        this.endColor = str2;
    }

    public void setImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "885135044")) {
            ipChange.ipc$dispatch("885135044", new Object[]{this, str});
        } else if (str == null) {
            this.mImgIv.setVisibility(8);
        } else {
            this.mImgIv.setVisibility(0);
            a.a().loadinto(str, this.mImgIv);
        }
    }

    public void setListener(OnBtnClickListener onBtnClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "560523619")) {
            ipChange.ipc$dispatch("560523619", new Object[]{this, onBtnClickListener});
        } else {
            this.mListener = onBtnClickListener;
        }
    }

    public void setShareVisibility(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1234877480")) {
            ipChange.ipc$dispatch("1234877480", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mShareBtn.setVisibility(z ? 0 : 8);
        }
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1575689905")) {
            ipChange.ipc$dispatch("-1575689905", new Object[]{this, str});
        } else {
            this.mTitleTv.setText(str);
        }
    }

    public void setTitleGravity(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1950573396")) {
            ipChange.ipc$dispatch("-1950573396", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mTitleTv.setGravity(i);
        }
    }

    public void showShareBtn(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-944352589")) {
            ipChange.ipc$dispatch("-944352589", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mShareBtn.setVisibility(z ? 0 : 8);
        }
    }

    public void switchMode(boolean z) {
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-389137008")) {
            ipChange.ipc$dispatch("-389137008", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isWhiteBgNow = z;
        if (z) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor(this.startColor), Color.parseColor(this.endColor)});
            gradientDrawable.setCornerRadius(0.0f);
            this.mLayout.setBackground(gradientDrawable);
            this.mDivider.setVisibility(0);
            this.mTitleTv.setVisibility(0);
        } else {
            this.mBackBtn.setTextColor(-1);
            this.mShareBtn.setTextColor(-1);
            this.mDivider.setVisibility(4);
            this.mTitleTv.setVisibility(4);
        }
        if (!this.supportImmersive || (activity = this.mActivity) == null) {
            return;
        }
        if (z) {
            kg2.f(activity, true, R$color.black);
            kg2.d(true, this.mActivity);
            return;
        }
        kg2.e(activity);
    }

    public CircleSimpleTitleLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleSimpleTitleLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.supportImmersive = false;
        this.isSetAlphaFirstTime = true;
        this.startColor = "#8F8FFF";
        this.endColor = "#AAC4FF";
        View inflate = LayoutInflater.from(context).inflate(R$layout.item_circle_title, (ViewGroup) this, false);
        addView(inflate, -1, -2);
        this.mLayout = inflate.findViewById(R$id.title_layout);
        this.mSpaceView = inflate.findViewById(R$id.status_bar_space);
        this.mBackBtn = (TextView) inflate.findViewById(R$id.back_btn);
        this.mShareBtn = (DMIconFontTextView) inflate.findViewById(R$id.share_btn);
        this.mDivider = inflate.findViewById(R$id.divider);
        this.mTitleTv = (TextView) inflate.findViewById(R$id.title_tv);
        this.llJoin = (LinearLayout) inflate.findViewById(R$id.join_layout);
        this.mJoinTv = (TextView) inflate.findViewById(R$id.join_tv);
        this.mJoinIcon = (DMIconFontTextView) inflate.findViewById(R$id.theme_circle_join_icon);
        this.mImgIv = (ImageView) inflate.findViewById(R$id.img_iv);
        this.mBackBtn.setOnClickListener(this);
        this.mShareBtn.setOnClickListener(this);
        this.mJoinTv.setOnClickListener(this);
        setWillNotDraw(false);
    }
}
