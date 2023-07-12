package cn.damai.tetris.component.online.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.tetris.component.online.bean.ArtistItemBean;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.image.IImageLoader;
import cn.damai.uikit.tag.DMCategroyTagView;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.q60;
import tb.th2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OnLinePosterView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private View borderView;
    private RoundImageView imageView;
    private OnLiveTagView mOnLiveTagView;
    private OnlineStarViewV2 mPicListView;
    private DMCategroyTagView tagLineView;
    private DMCategroyTagView tagView;
    private ImageView videoIcon;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements IImageLoader.IImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
        public void onSuccess(IImageLoader.b bVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1766262949")) {
                ipChange.ipc$dispatch("1766262949", new Object[]{this, bVar});
                return;
            }
            OnLinePosterView.this.imageView.setImageDrawable(bVar.a);
            OnLinePosterView.this.setPlaceholder(0);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements IImageLoader.IImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
        public void onFail(IImageLoader.a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-600020786")) {
                ipChange.ipc$dispatch("-600020786", new Object[]{this, aVar});
                return;
            }
            OnLinePosterView.this.imageView.setImageDrawable(null);
            OnLinePosterView.this.setPlaceholder(R$drawable.uikit_default_image_bg_gradient);
        }
    }

    public OnLinePosterView(@NonNull Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-725652076")) {
            ipChange.ipc$dispatch("-725652076", new Object[]{this, context});
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        RoundImageView roundImageView = new RoundImageView(context);
        this.imageView = roundImageView;
        roundImageView.setType(1);
        this.imageView.setBorderRadius(6);
        this.imageView.setBackgroundResource(R$drawable.uikit_default_image_bg_gradient);
        this.imageView.setGifRoundCornerSupport(true);
        this.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.imageView, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.borderView = new View(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(q60.a(context, 6.0f));
        gradientDrawable.setStroke(q60.a(context, 0.5f), Color.parseColor("#1A000000"));
        if (Build.VERSION.SDK_INT >= 16) {
            this.borderView.setBackground(gradientDrawable);
        } else {
            this.borderView.setBackgroundDrawable(gradientDrawable);
        }
        addView(this.borderView, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.rightMargin = q60.a(context, 3.0f);
        layoutParams3.topMargin = q60.a(context, 3.0f);
        layoutParams3.gravity = 5;
        OnLiveTagView onLiveTagView = new OnLiveTagView(context);
        this.mOnLiveTagView = onLiveTagView;
        onLiveTagView.setVisibility(8);
        addView(this.mOnLiveTagView, layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams4.gravity = 80;
        layoutParams4.leftMargin = q60.a(context, 0.0f);
        layoutParams4.bottomMargin = q60.a(context, 0.0f);
        OnlineStarViewV2 onlineStarViewV2 = new OnlineStarViewV2(context);
        this.mPicListView = onlineStarViewV2;
        onlineStarViewV2.setVisibility(8);
        addView(this.mPicListView, layoutParams4);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(q60.a(context, 24.0f), q60.a(context, 24.0f));
        layoutParams5.gravity = 17;
        ImageView imageView = new ImageView(context);
        this.videoIcon = imageView;
        imageView.setImageResource(R$drawable.dm_poster_video_icon);
        this.videoIcon.setVisibility(8);
        addView(this.videoIcon, layoutParams5);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams6.rightMargin = q60.a(context, 3.0f);
        layoutParams6.topMargin = q60.a(context, 3.0f);
        layoutParams6.gravity = 5;
        DMCategroyTagView dMCategroyTagView = new DMCategroyTagView(context);
        this.tagView = dMCategroyTagView;
        dMCategroyTagView.setVisibility(8);
        addView(this.tagView, layoutParams6);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams7.rightMargin = q60.a(context, 3.0f);
        layoutParams7.bottomMargin = q60.a(context, 3.0f);
        layoutParams7.gravity = 85;
        DMCategroyTagView dMCategroyTagView2 = new DMCategroyTagView(context);
        this.tagLineView = dMCategroyTagView2;
        dMCategroyTagView2.setVisibility(8);
        addView(this.tagLineView, layoutParams7);
    }

    public RoundImageView getImageView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1756586418") ? (RoundImageView) ipChange.ipc$dispatch("1756586418", new Object[]{this}) : this.imageView;
    }

    public void setBorderRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514227518")) {
            ipChange.ipc$dispatch("-1514227518", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        RoundImageView roundImageView = this.imageView;
        if (roundImageView == null) {
            return;
        }
        roundImageView.setBorderRadius(i);
    }

    public void setBorderVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-71557566")) {
            ipChange.ipc$dispatch("-71557566", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        View view = this.borderView;
        if (view == null) {
            return;
        }
        view.setVisibility(i);
    }

    public void setCityName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1614959411")) {
            ipChange.ipc$dispatch("1614959411", new Object[]{this, str});
        } else if (this.tagView == null) {
        } else {
            if (!th2.e(str)) {
                this.tagView.setVisibility(0);
                this.tagView.setTagName(str);
                return;
            }
            this.tagView.setVisibility(8);
        }
    }

    public void setImageUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-369228171")) {
            ipChange.ipc$dispatch("-369228171", new Object[]{this, str});
        } else if (this.imageView == null) {
        } else {
            cn.damai.uikit.image.a.a().loadinto(str, this.imageView);
        }
    }

    public void setImageUrlForWebp(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-846679548")) {
            ipChange.ipc$dispatch("-846679548", new Object[]{this, str});
        } else if (this.imageView == null) {
        } else {
            setImageUrlForWebp(str, -1, -1);
        }
    }

    public void setLineTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1348386248")) {
            ipChange.ipc$dispatch("1348386248", new Object[]{this, str});
        } else if (this.tagLineView == null) {
        } else {
            if (!th2.e(str)) {
                this.tagLineView.setVisibility(0);
                this.tagLineView.setTagName(str);
                return;
            }
            this.tagLineView.setVisibility(8);
        }
    }

    public void setOnliveTag(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1868217128")) {
            ipChange.ipc$dispatch("-1868217128", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mOnLiveTagView.setVisibility(0);
        this.mOnLiveTagView.setLiveType(z);
    }

    public void setPicList(List<ArtistItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "175551060")) {
            ipChange.ipc$dispatch("175551060", new Object[]{this, list});
        } else if (this.mPicListView == null) {
        } else {
            if (wh2.e(list) == 0) {
                this.mPicListView.setVisibility(8);
                return;
            }
            this.mPicListView.setPicList(list);
            this.mPicListView.setVisibility(0);
        }
    }

    public void setPlaceholder(@DrawableRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "50574763")) {
            ipChange.ipc$dispatch("50574763", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        RoundImageView roundImageView = this.imageView;
        if (roundImageView == null) {
            return;
        }
        roundImageView.setBackgroundResource(i);
    }

    public void setVideoIconVisible(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-628913165")) {
            ipChange.ipc$dispatch("-628913165", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.videoIcon.setVisibility(0);
        } else {
            this.videoIcon.setVisibility(8);
        }
    }

    public OnLinePosterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public void setImageUrlForWebp(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1909284508")) {
            ipChange.ipc$dispatch("-1909284508", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (this.imageView == null) {
        } else {
            cn.damai.uikit.image.a.a().load(str, 0, i, i2, new a(), new b());
        }
    }

    public OnLinePosterView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
