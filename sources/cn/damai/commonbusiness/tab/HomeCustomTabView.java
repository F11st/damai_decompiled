package cn.damai.commonbusiness.tab;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HomeCustomTabView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mItemMaxSize;
    private FrameLayout mTabLayout;
    private LottieAnimationView mTabReSelectedImageView;
    private LottieAnimationView mTabSelectedImageView;
    private TextView mTabTextView;

    public HomeCustomTabView(@NonNull Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1292905913")) {
            ipChange.ipc$dispatch("1292905913", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R$layout.home_tabview_custom, this);
        this.mTabLayout = (FrameLayout) findViewById(R$id.custom_frame_layout);
        this.mTabSelectedImageView = (LottieAnimationView) findViewById(R$id.tabbar_selected_img);
        this.mTabReSelectedImageView = (LottieAnimationView) findViewById(R$id.tabbar_reselected_img);
        this.mTabTextView = (TextView) findViewById(R$id.tab_home_text);
        this.mItemMaxSize = DisplayMetrics.getwidthPixels(t60.b(context)) / 5;
    }

    private void setViewSize(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1323940880")) {
            ipChange.ipc$dispatch("1323940880", new Object[]{this, bitmap});
        } else if (this.mTabLayout == null || bitmap == null) {
        } else {
            int a = t60.a(getContext(), bitmap.getWidth() / 3);
            int a2 = t60.a(getContext(), bitmap.getHeight() / 3);
            int i = this.mItemMaxSize;
            if (a > i) {
                a2 *= i / a;
                a = i;
            }
            ViewGroup.LayoutParams layoutParams = this.mTabLayout.getLayoutParams();
            layoutParams.width = a;
            layoutParams.height = a2;
            this.mTabLayout.setLayoutParams(layoutParams);
        }
    }

    public void setHomeTabReSelectedIcon(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-616947355")) {
            ipChange.ipc$dispatch("-616947355", new Object[]{this, bitmap});
            return;
        }
        LottieAnimationView lottieAnimationView = this.mTabReSelectedImageView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setImageBitmap(bitmap);
            setViewSize(bitmap);
        }
    }

    public void setHomeTabSelectedIcon(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-394896558")) {
            ipChange.ipc$dispatch("-394896558", new Object[]{this, bitmap});
            return;
        }
        LottieAnimationView lottieAnimationView = this.mTabSelectedImageView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setImageBitmap(bitmap);
            setViewSize(bitmap);
        }
    }

    public void setTabName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1490509744")) {
            ipChange.ipc$dispatch("1490509744", new Object[]{this, str});
            return;
        }
        TextView textView = this.mTabTextView;
        if (textView != null) {
            textView.setText(str);
            this.mTabTextView.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        }
    }

    public void setTabSelectedTextColor(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "95789352")) {
            ipChange.ipc$dispatch("95789352", new Object[]{this, str});
            return;
        }
        TextView textView = this.mTabTextView;
        if (textView != null) {
            try {
                textView.setTextColor(Color.parseColor(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public HomeCustomTabView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HomeCustomTabView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    public void setHomeTabReSelectedIcon(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1086591174")) {
            ipChange.ipc$dispatch("-1086591174", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        LottieAnimationView lottieAnimationView = this.mTabReSelectedImageView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation(i);
        }
    }

    public void setHomeTabSelectedIcon(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-544153561")) {
            ipChange.ipc$dispatch("-544153561", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        LottieAnimationView lottieAnimationView = this.mTabSelectedImageView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation(i);
        }
    }
}
