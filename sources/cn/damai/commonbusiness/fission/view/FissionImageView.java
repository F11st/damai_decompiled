package cn.damai.commonbusiness.fission.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.fission.bean.FissionInfoBean;
import cn.damai.commonbusiness.fission.bean.FissionViewPagerBean;
import cn.damai.commonbusiness.yymember.bean.PerformFilmVipDO;
import cn.damai.uikit.view.DMAvatar;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.k23;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class FissionImageView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView cb_main_message;
    private TextView cb_my_invite_content;
    private TextView cb_sub_message;
    private DMAvatar cb_user_icon;
    private LinearLayout cb_user_layout;
    private TextView cb_user_name;
    private Context context;
    private View fission_content_up_bg;
    private ImageView fission_image;
    private LinearLayout fission_image_bg;
    private RelativeLayout fission_mask_layout;
    private RelativeLayout layout;
    private View maskDownBgView;
    private View partent;

    public FissionImageView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "904349210")) {
            ipChange.ipc$dispatch("904349210", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.fission_image_layout, this);
        this.partent = inflate;
        this.layout = (RelativeLayout) inflate.findViewById(R$id.layout);
        this.fission_image_bg = (LinearLayout) this.partent.findViewById(R$id.fission_image_bg);
        this.fission_image = (ImageView) this.partent.findViewById(R$id.fission_image);
        this.cb_my_invite_content = (TextView) this.partent.findViewById(R$id.cb_my_invite_content);
        this.cb_user_layout = (LinearLayout) this.partent.findViewById(R$id.cb_user_layout);
        this.cb_user_icon = (DMAvatar) this.partent.findViewById(R$id.cb_user_icon);
        this.cb_user_name = (TextView) this.partent.findViewById(R$id.cb_user_name);
        this.cb_user_icon.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_40x40);
        this.fission_mask_layout = (RelativeLayout) this.partent.findViewById(R$id.fission_mask_layout);
        this.cb_sub_message = (TextView) this.partent.findViewById(R$id.cb_sub_message);
        this.cb_main_message = (TextView) this.partent.findViewById(R$id.cb_main_message);
        this.fission_content_up_bg = this.partent.findViewById(R$id.fission_content_up_bg);
        this.maskDownBgView = this.partent.findViewById(R$id.fission_content_down_bg);
    }

    private GradientDrawable setBackGround(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2104782111")) {
            return (GradientDrawable) ipChange.ipc$dispatch("2104782111", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{i, i2});
        gradientDrawable.setCornerRadii(new float[]{t60.a(this.context, 24.0f), t60.a(this.context, 24.0f), t60.a(this.context, 24.0f), t60.a(this.context, 24.0f), 0.0f, 0.0f, 0.0f, 0.0f});
        return gradientDrawable;
    }

    public int getColorWithAlpha(float f, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "824968294") ? ((Integer) ipChange.ipc$dispatch("824968294", new Object[]{this, Float.valueOf(f), Integer.valueOf(i)})).intValue() : (Math.min(255, Math.max(0, (int) (f * 255.0f))) << 24) + (i & 16777215);
    }

    public void update(FissionViewPagerBean fissionViewPagerBean, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1637595933")) {
            ipChange.ipc$dispatch("1637595933", new Object[]{this, fissionViewPagerBean, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else if (fissionViewPagerBean == null) {
        } else {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fission_image_bg.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.maskDownBgView.getLayoutParams();
            int parseColor = Color.parseColor("#00000000");
            int colorWithAlpha = getColorWithAlpha(0.6f, fissionViewPagerBean.bgColor);
            if ("2".equals(fissionViewPagerBean.channel)) {
                parseColor = Color.parseColor("#33000000");
                colorWithAlpha = fissionViewPagerBean.bgColor;
                int i4 = (i * 3) / 4;
                layoutParams2.height = (i2 - i4) + t60.a(this.context, 20.0f);
                i2 = i4;
            } else {
                layoutParams2.height = t60.a(this.context, 100.0f);
            }
            if (!TextUtils.isEmpty(fissionViewPagerBean.mainMessage)) {
                this.cb_main_message.setVisibility(0);
                this.cb_main_message.setText(fissionViewPagerBean.mainMessage);
            } else {
                this.cb_main_message.setVisibility(8);
            }
            if (!TextUtils.isEmpty(fissionViewPagerBean.subMessage)) {
                this.cb_sub_message.setVisibility(0);
                this.cb_sub_message.setText(fissionViewPagerBean.subMessage);
            } else {
                this.cb_sub_message.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fission_image.getLayoutParams();
            layoutParams3.width = i;
            layoutParams3.height = i2;
            Bitmap bitmap = fissionViewPagerBean.bitmap;
            if (bitmap != null) {
                this.fission_image.setImageBitmap(bitmap);
            } else {
                this.fission_image.setBackgroundColor(Color.parseColor("#f5f5f5"));
            }
            if (Build.VERSION.SDK_INT >= 16) {
                this.fission_content_up_bg.setBackground(setBackGround(parseColor, colorWithAlpha));
            } else {
                this.fission_content_up_bg.setBackgroundDrawable(setBackGround(parseColor, colorWithAlpha));
            }
            this.maskDownBgView.setBackgroundColor(colorWithAlpha);
            if (!TextUtils.isEmpty(fissionViewPagerBean.chickenSoup)) {
                this.cb_my_invite_content.setVisibility(0);
                this.cb_my_invite_content.setText(fissionViewPagerBean.chickenSoup);
            } else {
                this.cb_my_invite_content.setVisibility(4);
            }
            FissionInfoBean.UserInfo userInfo = fissionViewPagerBean.userInfo;
            if (userInfo != null && !TextUtils.isEmpty(userInfo.nickname)) {
                if (!TextUtils.isEmpty(fissionViewPagerBean.userInfo.nickname)) {
                    this.cb_user_name.setVisibility(0);
                    this.cb_user_name.setText(fissionViewPagerBean.userInfo.nickname);
                } else {
                    this.cb_user_name.setVisibility(8);
                }
                if (!TextUtils.isEmpty(fissionViewPagerBean.userInfo.portraitUrl)) {
                    this.cb_user_icon.setAvatar(fissionViewPagerBean.userInfo.portraitUrl);
                } else {
                    this.cb_user_icon.setAvatarPlaceholder(R$drawable.uikit_user_default_icon);
                }
                cn.damai.uikit.view.DMAvatar dMAvatar = this.cb_user_icon;
                PerformFilmVipDO performFilmVipDO = fissionViewPagerBean.userInfo.performFilmVipDO;
                dMAvatar.setYYMemberTagView(false, performFilmVipDO != null ? performFilmVipDO.memberFlag : k23.h());
            } else {
                this.cb_user_name.setText("大麦");
                this.cb_user_icon.setAvatar(R$drawable.mine_account_default);
                this.cb_user_icon.setYYMemberTagView(false, k23.h());
            }
            this.cb_user_icon.setAvatarCrownVisibility(8);
            this.cb_user_icon.setAvatarBorderVisibility(8);
        }
    }

    public FissionImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FissionImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        initView();
    }
}
