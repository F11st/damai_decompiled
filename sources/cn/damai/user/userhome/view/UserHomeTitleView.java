package cn.damai.user.userhome.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.DMAvatar;
import cn.damai.user.repertoite.view.AttentionView;
import cn.damai.user.userhome.bean.UserInfoBean;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.kg2;
import tb.l62;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class UserHomeTitleView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private int followWidth;
    private boolean isDarkModeNow;
    private boolean isSetAlphaFirstTime;
    private AttentionView mAttention;
    private Context mContext;
    private int mTitleStatusBarHeight;
    private DMIconFontTextView mTvUserGoBack;
    private TextView mTvUserNickName;
    private DMAvatar mUserAvatar;
    private LinearLayout mUserInfoLayout;
    private int twoFollowWidth;
    private ImageView userTagView;
    private View user_tag_view_oldvip;

    public UserHomeTitleView(Context context) {
        super(context);
        this.isSetAlphaFirstTime = true;
        this.mContext = context;
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1793184242")) {
            ipChange.ipc$dispatch("1793184242", new Object[]{this});
            return;
        }
        LayoutInflater.from(getContext()).inflate(R$layout.layout_user_center_title, this);
        initData();
        initHeadUserInfo();
        initImmersionStyle();
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-881534104")) {
            ipChange.ipc$dispatch("-881534104", new Object[]{this});
            return;
        }
        this.twoFollowWidth = l62.a(this.mContext, 65.0f);
        this.followWidth = l62.a(this.mContext, 57.0f);
    }

    private void initHeadUserInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1017496935")) {
            ipChange.ipc$dispatch("-1017496935", new Object[]{this});
            return;
        }
        this.mTvUserGoBack = (DMIconFontTextView) findViewById(R$id.tv_goback);
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.ll_user_info);
        this.mUserInfoLayout = linearLayout;
        this.mUserAvatar = (DMAvatar) linearLayout.findViewById(R$id.fl_user_avatar);
        this.mTvUserNickName = (TextView) this.mUserInfoLayout.findViewById(R$id.tv_nick_name);
        this.userTagView = (ImageView) this.mUserInfoLayout.findViewById(R$id.user_tag_view);
        this.user_tag_view_oldvip = findViewById(R$id.user_tag_view_oldvip);
        resetAvatar();
        this.mUserInfoLayout.setVisibility(4);
        AttentionView attentionView = (AttentionView) findViewById(R$id.tv_attention);
        this.mAttention = attentionView;
        attentionView.setBackGroundState(R$drawable.uikit_attention_btn_followed, R$drawable.uikit_attention_btn_un_follow);
        this.mAttention.setTextColorState(R$color.color_9C9CA5, R$color.white);
        this.mAttention.setVisibility(8);
    }

    private void initImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1186423092")) {
            ipChange.ipc$dispatch("-1186423092", new Object[]{this});
            return;
        }
        this.mTitleStatusBarHeight = t60.a(this.mContext, 45.0f);
        View findViewById = findViewById(R$id.mine_title_bar_space);
        Activity activity = (Activity) getContext();
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                int a = kg2.a(activity);
                findViewById.getLayoutParams().height = a;
                findViewById.setVisibility(0);
                this.mTitleStatusBarHeight += a;
            }
            kg2.f(activity, true, R$color.black);
            kg2.d(true, activity);
            kg2.e(activity);
            return;
        }
        kg2.f(activity, false, R$color.black);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    private void resetAvatar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "793763008")) {
            ipChange.ipc$dispatch("793763008", new Object[]{this});
            return;
        }
        this.mUserAvatar.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_30x30);
        cn.damai.uikit.view.DMAvatar dMAvatar = this.mUserAvatar;
        int i = R$drawable.mine_account_default;
        dMAvatar.setAvatarPlaceholder(i);
        this.mUserAvatar.setAvatar(i);
        this.mUserAvatar.setAvatarBorderVisibility(8);
        this.mUserAvatar.setAvatarCrownVisibility(8);
        this.mUserAvatar.setAvatarVTagVisibility(8);
    }

    private void setYYMemberTag(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1368643878")) {
            ipChange.ipc$dispatch("-1368643878", new Object[]{this, Boolean.valueOf(z), str});
        } else {
            this.mUserAvatar.setYYMemberTagView(z, str);
        }
    }

    public AttentionView getAttentionView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-22241316") ? (AttentionView) ipChange.ipc$dispatch("-22241316", new Object[]{this}) : this.mAttention;
    }

    public int getTitleHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1591166036") ? ((Integer) ipChange.ipc$dispatch("-1591166036", new Object[]{this})).intValue() : this.mTitleStatusBarHeight;
    }

    public void setBackGroundAlpha(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-133611860")) {
            ipChange.ipc$dispatch("-133611860", new Object[]{this, Float.valueOf(f)});
            return;
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        boolean z = f > 0.5f;
        boolean z2 = this.isSetAlphaFirstTime || this.isDarkModeNow != z;
        this.isSetAlphaFirstTime = false;
        this.isDarkModeNow = z;
        setBackgroundColor(z ? Color.argb(Math.round(f * 255.0f), 255, 255, 255) : 0);
        if (z2) {
            Context context = getContext();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (z) {
                    kg2.f(activity, true, -16777216);
                    kg2.d(true, activity);
                    this.mUserInfoLayout.setVisibility(0);
                    this.mTvUserGoBack.setTextColor(-16777216);
                    return;
                }
                kg2.e(activity);
                this.mUserInfoLayout.setVisibility(4);
                this.mTvUserGoBack.setTextColor(-1);
            }
        }
    }

    public void setBackListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "182296046")) {
            ipChange.ipc$dispatch("182296046", new Object[]{this, onClickListener});
            return;
        }
        DMIconFontTextView dMIconFontTextView = this.mTvUserGoBack;
        if (dMIconFontTextView != null) {
            dMIconFontTextView.setOnClickListener(onClickListener);
        }
    }

    public void updateUserInfo(UserInfoBean userInfoBean, boolean z, int i, String str) {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-889726596")) {
            ipChange.ipc$dispatch("-889726596", new Object[]{this, userInfoBean, Boolean.valueOf(z), Integer.valueOf(i), str});
        } else if (userInfoBean == null) {
            resetAvatar();
            this.mTvUserNickName.setText("");
            this.mAttention.setVisibility(8);
        } else {
            this.mTvUserNickName.setText(userInfoBean.getUserNick());
            this.mUserAvatar.setAvatar(userInfoBean.getImgUrl());
            boolean isVip = userInfoBean.isVip();
            this.mUserAvatar.setAvatarCrownVisibility(8);
            this.mUserAvatar.setAvatarBorderVisibility(8);
            if (userInfoBean.userTypeCode == 2) {
                this.mUserAvatar.setAvatarVTagVisibility(0);
            } else {
                this.mUserAvatar.setAvatarVTagVisibility(8);
                setYYMemberTag(false, userInfoBean.getMemberFlag());
            }
            int i3 = userInfoBean.userTypeCode;
            if (i3 > 0) {
                if (i3 == 1) {
                    i2 = R$drawable.uikit_user_tag_editor_mai;
                    this.userTagView.setVisibility(0);
                } else if (i3 == 3) {
                    i2 = R$drawable.uikit_user_tag_city_amusement;
                    this.userTagView.setVisibility(0);
                } else {
                    i2 = 0;
                }
                this.userTagView.setImageResource(i2);
            } else {
                this.userTagView.setVisibility(8);
            }
            if (isVip) {
                this.user_tag_view_oldvip.setVisibility(0);
            } else {
                this.user_tag_view_oldvip.setVisibility(8);
            }
            if (z) {
                this.mAttention.setVisibility(8);
                return;
            }
            this.mAttention.setVisibility(0);
            this.mAttention.setInitParams(str, "1");
            this.mAttention.setState(i);
        }
    }

    public UserHomeTitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isSetAlphaFirstTime = true;
        this.mContext = context;
        init();
    }

    public UserHomeTitleView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isSetAlphaFirstTime = true;
        this.mContext = context;
        init();
    }
}
