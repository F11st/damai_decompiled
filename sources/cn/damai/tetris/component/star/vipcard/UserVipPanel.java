package cn.damai.tetris.component.star.vipcard;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.core.content.ContextCompat;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.R$anim;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.login.LoginManager;
import cn.damai.tetris.component.star.vipcard.bean.ArtistVIpBtnBean;
import cn.damai.tetris.component.star.vipcard.bean.ArtistVipBean;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.uikit.view.DMAvatar;
import cn.damai.uikit.view.RoundImageView;
import cn.damai.uikit.view.autoScroll.AutoTextSwitcher;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class UserVipPanel {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private View b;
    private RoundImageView c;
    private DMAvatar d;
    private TextView e;
    private AutoTextSwitcher f;
    private TextView g;
    private BasePresenter h;
    View.OnClickListener i = new a();

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArtistVIpBtnBean artistVIpBtnBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-228983936")) {
                ipChange.ipc$dispatch("-228983936", new Object[]{this, view});
            } else if (!UserVipPanel.this.c()) {
                LoginManager.k().x(UserVipPanel.this.a, new Intent(), 1000);
            } else {
                ArtistVipBean artistVipBean = (ArtistVipBean) view.getTag();
                if (artistVipBean == null || (artistVIpBtnBean = artistVipBean.button) == null || TextUtils.isEmpty(artistVIpBtnBean.destination)) {
                    return;
                }
                DMNav.from(UserVipPanel.this.a).toUri(artistVipBean.button.destination);
                UserVipPanel.this.h.userTrackClick("goto_artist_vip", true);
            }
        }
    }

    public UserVipPanel(final Activity activity, ViewGroup viewGroup, BasePresenter basePresenter) {
        if (activity == null) {
            return;
        }
        this.h = basePresenter;
        this.a = activity;
        View findViewById = viewGroup.findViewById(R$id.vip_ui_layout);
        this.b = findViewById;
        findViewById.getLayoutParams().height = q60.a(activity, 75.0f);
        this.c = (RoundImageView) viewGroup.findViewById(R$id.vip_level_bg);
        this.d = (DMAvatar) viewGroup.findViewById(R$id.icon_star_vip);
        this.e = (TextView) viewGroup.findViewById(R$id.vip_text_name);
        this.g = (TextView) viewGroup.findViewById(R$id.vip_ui_btn);
        AutoTextSwitcher autoTextSwitcher = (AutoTextSwitcher) viewGroup.findViewById(R$id.vip_text_switcher);
        this.f = autoTextSwitcher;
        autoTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() { // from class: cn.damai.tetris.component.star.vipcard.UserVipPanel.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.widget.ViewSwitcher.ViewFactory
            public View makeView() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1082252611")) {
                    return (View) ipChange.ipc$dispatch("-1082252611", new Object[]{this});
                }
                TextView textView = new TextView(UserVipPanel.this.a);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setTextColor(ContextCompat.getColor(activity, R$color.color_ccffffff));
                textView.setTextSize(12.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 16;
                textView.setLayoutParams(layoutParams);
                return textView;
            }
        });
        this.f.setInAnimation(this.a, R$anim.translate_y_in);
        this.f.setOutAnimation(this.a, R$anim.translate_y_out);
        this.b.setOnClickListener(this.i);
    }

    public boolean c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1050586450") ? ((Boolean) ipChange.ipc$dispatch("-1050586450", new Object[]{this})).booleanValue() : LoginManager.k().q();
    }

    public void d(ArtistVipBean artistVipBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "616019268")) {
            ipChange.ipc$dispatch("616019268", new Object[]{this, artistVipBean});
        } else if (artistVipBean != null) {
            this.h.userTrackExpose(this.b, "goto_artist_vip");
            this.b.setVisibility(0);
            this.b.setTag(artistVipBean);
            this.e.setText(artistVipBean.name);
            this.f.update(artistVipBean.desc);
            DMImageCreator c = cn.damai.common.image.a.b().c(artistVipBean.bgImage);
            int i = R$drawable.bg_vip_switch;
            c.i(i).c(i).g(this.c);
            if (artistVipBean.artistVip) {
                ArtistVIpBtnBean artistVIpBtnBean = artistVipBean.button;
                if (artistVIpBtnBean != null) {
                    this.g.setText(artistVIpBtnBean.name);
                } else {
                    this.g.setText("去看看");
                }
                this.d.setVisibility(0);
                this.d.setAvatar(artistVipBean.headPic);
                this.d.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_30x30);
                this.d.setAvatarPlaceholder(R$drawable.transparent_bg);
                this.d.setAvatarVTagVisibility(8);
                if (artistVipBean.damaiVip) {
                    this.d.setAvatarCrownVisibility(0);
                    this.d.setAvatarBorderVisibility(0);
                    return;
                }
                this.d.setAvatarCrownVisibility(8);
                this.d.setAvatarBorderVisibility(8);
                return;
            }
            ArtistVIpBtnBean artistVIpBtnBean2 = artistVipBean.button;
            if (artistVIpBtnBean2 != null) {
                this.g.setText(artistVIpBtnBean2.name);
            } else {
                this.g.setText("立即加入");
            }
            this.d.setVisibility(8);
        }
    }
}
