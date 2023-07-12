package cn.damai.uikit.view.avatar;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.R$styleable;
import cn.damai.uikit.image.IImageLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AvatarView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private AvatarConfig mAvatarConfig;
    private AvatarSize mAvatarSize;
    private View mAvatarUi;
    private View mInnerBorderView;
    private View mInnerLayout;
    private View mOutBorderView;
    private View mPlaceHolderView;
    private ImageView mRoundImg;
    private String mShowingAvatarUrl;
    private ImageView mVTag;
    private ImageView mYyTag;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements IImageLoader.IImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
        public void onSuccess(IImageLoader.b bVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1449858881")) {
                ipChange.ipc$dispatch("-1449858881", new Object[]{this, bVar});
                return;
            }
            AvatarView.this.mShowingAvatarUrl = this.a;
            AvatarView.this.mRoundImg.setImageDrawable(bVar.a);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b implements IImageLoader.IImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b(AvatarView avatarView) {
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
        public void onFail(IImageLoader.a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1678959720")) {
                ipChange.ipc$dispatch("1678959720", new Object[]{this, aVar});
            }
        }
    }

    public AvatarView(@NonNull Context context) {
        this(context, null);
    }

    private void findView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "391334689")) {
            ipChange.ipc$dispatch("391334689", new Object[]{this, view});
            return;
        }
        this.mOutBorderView = view.findViewById(R$id.avatar_out_border);
        this.mInnerLayout = view.findViewById(R$id.avatar_inner_layout);
        this.mPlaceHolderView = view.findViewById(R$id.avatar_place_holder);
        this.mRoundImg = (ImageView) view.findViewById(R$id.avatar_round_img);
        this.mInnerBorderView = view.findViewById(R$id.avatar_inner_border);
        this.mVTag = (ImageView) view.findViewById(R$id.avatar_right_bottom_v_tag);
        this.mYyTag = (ImageView) view.findViewById(R$id.avatar_right_bottom_yy_member_tag);
    }

    private void setViewBackGRid(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-985704104")) {
            ipChange.ipc$dispatch("-985704104", new Object[]{this, view, Integer.valueOf(i)});
        } else if (i != -1) {
            view.setBackgroundResource(i);
        } else {
            view.setBackground(null);
        }
    }

    public void setAvatarUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-890762427")) {
            ipChange.ipc$dispatch("-890762427", new Object[]{this, str});
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                this.mShowingAvatarUrl = null;
                this.mRoundImg.setImageDrawable(null);
            } else if (TextUtils.equals(this.mShowingAvatarUrl, str)) {
            } else {
                AvatarConfig avatarConfig = this.mAvatarConfig;
                if (avatarConfig != null && avatarConfig.clearDrawableWhenDiffUrlSet && !TextUtils.isEmpty(this.mShowingAvatarUrl)) {
                    this.mRoundImg.setImageDrawable(null);
                }
                Context context = getContext();
                int viewSizePx = context != null ? this.mAvatarSize.getViewSizePx(context) : 0;
                cn.damai.uikit.image.a.a().load(str, 0, viewSizePx, viewSizePx, new a(str), new b(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setViewSize(AvatarSize avatarSize) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1360005600")) {
            ipChange.ipc$dispatch("-1360005600", new Object[]{this, avatarSize});
            return;
        }
        this.mAvatarSize = avatarSize;
        int viewSizePx = avatarSize.getViewSizePx(getContext());
        int rbTagSizePx = avatarSize.getRbTagSizePx(getContext());
        setViewSize(this.mAvatarUi, viewSizePx, viewSizePx);
        setViewSize(this.mVTag, rbTagSizePx, rbTagSizePx);
        setViewSize(this.mYyTag, rbTagSizePx, rbTagSizePx);
    }

    public void setViewStyle(AvatarConfig avatarConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1274901901")) {
            ipChange.ipc$dispatch("1274901901", new Object[]{this, avatarConfig});
            return;
        }
        this.mAvatarConfig = avatarConfig;
        int outBorderDrawableRid = avatarConfig.getOutBorderDrawableRid();
        int innerBorderDrawableRid = avatarConfig.getInnerBorderDrawableRid();
        int placeHolderDrawableRid = avatarConfig.getPlaceHolderDrawableRid();
        setViewBackGRid(this.mOutBorderView, outBorderDrawableRid);
        setViewBackGRid(this.mInnerBorderView, innerBorderDrawableRid);
        setViewBackGRid(this.mPlaceHolderView, placeHolderDrawableRid);
        if (avatarConfig.isShowOutBorder()) {
            int outBorderSizePx = this.mAvatarSize.getOutBorderSizePx(getContext());
            this.mInnerLayout.setPadding(outBorderSizePx, outBorderSizePx, outBorderSizePx, outBorderSizePx);
        } else {
            this.mInnerLayout.setPadding(0, 0, 0, 0);
        }
        boolean isShowVTag = avatarConfig.isShowVTag();
        int yyTagDrawableRid = avatarConfig.getYyTagDrawableRid();
        if (yyTagDrawableRid != -1) {
            this.mYyTag.setVisibility(0);
            this.mYyTag.setImageResource(yyTagDrawableRid);
            this.mVTag.setVisibility(8);
            return;
        }
        this.mYyTag.setVisibility(8);
        this.mVTag.setVisibility(isShowVTag ? 0 : 8);
    }

    public void update(AvatarConfig avatarConfig, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "221031254")) {
            ipChange.ipc$dispatch("221031254", new Object[]{this, avatarConfig, str});
            return;
        }
        if (avatarConfig != null) {
            setViewStyle(avatarConfig);
        }
        setAvatarUrl(str);
    }

    public AvatarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AvatarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AvatarView);
        AvatarSize avatarSize = AvatarSize.get(obtainStyledAttributes.getInt(R$styleable.AvatarView_avatarViewSize, 0));
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(R$layout.uikit_damai_avatar_v2, (ViewGroup) null);
        this.mAvatarUi = inflate;
        addView(inflate);
        findView(this.mAvatarUi);
        setViewSize(avatarSize);
        setViewStyle(AvatarConfig.defaultConfig());
    }

    private void setViewSize(View view, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-45342593")) {
            ipChange.ipc$dispatch("-45342593", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams.width == i && layoutParams.height == i2) {
                return;
            }
            layoutParams.width = i;
            layoutParams.height = i2;
            view.requestLayout();
            return;
        }
        view.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
    }
}
