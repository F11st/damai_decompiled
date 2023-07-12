package cn.damai.commonbusiness.fission.view;

import android.content.Context;
import android.graphics.Bitmap;
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
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.DMAvatar;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.k23;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class FissionContentView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView cb_invite_code;
    private TextView cb_main_message;
    private TextView cb_my_invite_content;
    private TextView cb_sub_message;
    private DMAvatar cb_user_icon;
    private LinearLayout cb_user_layout;
    private TextView cb_user_name;
    private Context context;
    private View fission_content_bg;
    private ImageView fission_image_bg;
    private RelativeLayout layout;
    private View partent;
    private DMIconFontTextView quotation_icon;

    public FissionContentView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-18254792")) {
            ipChange.ipc$dispatch("-18254792", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.fission_content_layout, this);
        this.partent = inflate;
        this.layout = (RelativeLayout) inflate.findViewById(R$id.layout);
        this.fission_image_bg = (ImageView) this.partent.findViewById(R$id.fission_image_bg);
        this.cb_my_invite_content = (TextView) this.partent.findViewById(R$id.cb_my_invite_content);
        this.cb_user_layout = (LinearLayout) this.partent.findViewById(R$id.cb_user_layout);
        this.cb_user_icon = (DMAvatar) this.partent.findViewById(R$id.cb_user_icon);
        this.cb_user_name = (TextView) this.partent.findViewById(R$id.cb_user_name);
        this.quotation_icon = (DMIconFontTextView) this.partent.findViewById(R$id.quotation_icon);
        this.cb_user_icon.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_40x40);
        this.cb_sub_message = (TextView) this.partent.findViewById(R$id.cb_sub_message);
        this.cb_main_message = (TextView) this.partent.findViewById(R$id.cb_main_message);
        this.fission_content_bg = this.partent.findViewById(R$id.fission_content_bg);
    }

    public void update(FissionViewPagerBean fissionViewPagerBean, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-398608325")) {
            ipChange.ipc$dispatch("-398608325", new Object[]{this, fissionViewPagerBean, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else if (fissionViewPagerBean == null) {
        } else {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fission_content_bg.getLayoutParams();
            layoutParams.height = i2 + t60.a(this.context, 20.0f);
            layoutParams.width = i;
            this.fission_content_bg.setLayoutParams(layoutParams);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(fissionViewPagerBean.bgColor);
            gradientDrawable.setCornerRadius(t60.a(this.context, 24.0f));
            if (Build.VERSION.SDK_INT >= 16) {
                this.fission_content_bg.setBackground(gradientDrawable);
            } else {
                this.fission_content_bg.setBackgroundDrawable(gradientDrawable);
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
            Bitmap bitmap = fissionViewPagerBean.bitmap;
            if (bitmap != null) {
                this.fission_image_bg.setImageBitmap(bitmap);
            } else {
                this.fission_image_bg.setImageResource(R$drawable.uikit_default_image_bg_grey);
            }
            if (!TextUtils.isEmpty(fissionViewPagerBean.chickenSoup)) {
                this.cb_my_invite_content.setVisibility(0);
                this.cb_my_invite_content.setText(fissionViewPagerBean.chickenSoup);
            } else {
                this.cb_my_invite_content.setVisibility(8);
            }
            FissionInfoBean.UserInfo userInfo = fissionViewPagerBean.userInfo;
            if (userInfo != null && (!TextUtils.isEmpty(userInfo.nickname) || !TextUtils.isEmpty(fissionViewPagerBean.userInfo.shareCode))) {
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

    public FissionContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FissionContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        initView();
    }
}
