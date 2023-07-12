package cn.damai.ticklet.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.util.Utils;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.ILoginListener;
import cn.damai.member.R$color;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.TicketSouvenirBean;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import cn.damai.ticklet.view.TickletSouvenIrCustomView;
import cn.damai.ticklet.view.TickletSouvenirClassicsView;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.MyScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.cb1;
import tb.kg2;
import tb.py2;
import tb.t60;
import tb.un2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ESouvenirCustomActivity extends DamaiBaseActivity implements ILoginListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView cancel_action;
    private TextView generateImageShare;
    private String performId;
    private MyScrollView scrollView;
    private TickletSouvenirClassicsView souvenir_custom;
    private LinearLayout souvenir_title_bg;
    private RelativeLayout souvenir_title_content_bg;
    private TickletSouvenIrCustomView ticklet_sou_price;
    private TickletSouvenIrCustomView ticklet_sou_seat;
    private TickletSouvenIrCustomView ticklet_sou_user;
    private TextView titleText;
    private DMIconFontTextView tvTitleBack;
    private TicketSouvenirBean infoBean = new TicketSouvenirBean();
    private int heightImage = 0;
    private int height = 0;
    private int width = 0;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements MyScrollView.ScrollYListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.uikit.view.MyScrollView.ScrollYListener
        public void onScroll(View view, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1271149418")) {
                ipChange.ipc$dispatch("1271149418", new Object[]{this, view, Integer.valueOf(i)});
            } else {
                ESouvenirCustomActivity.this.updateTitleAlpha(i / t60.a(ESouvenirCustomActivity.this.mContext, 48.0f));
            }
        }
    }

    private Bitmap getViewPagerBmp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1588587309")) {
            return (Bitmap) ipChange.ipc$dispatch("-1588587309", new Object[]{this});
        }
        int measuredWidth = this.souvenir_custom.getMeasuredWidth();
        int measuredHeight = this.souvenir_custom.getMeasuredHeight();
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        this.souvenir_custom.draw(new Canvas(createBitmap));
        return Utils.j(createBitmap, measuredWidth * 1.2d, measuredHeight * 1.2d);
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2020012706")) {
            ipChange.ipc$dispatch("-2020012706", new Object[]{this});
            return;
        }
        try {
            this.ticklet_sou_price.update("票价", true);
            this.ticklet_sou_seat.update("座位", true);
            this.ticklet_sou_user.update("购票人", true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.souvenir_custom.getLayoutParams();
            layoutParams.height = this.height;
            int i = this.width;
            layoutParams.width = i;
            this.souvenir_custom.update(this.infoBean, i, this.heightImage, 0);
        } catch (Exception e) {
            cb1.c("Souvenir", e.getMessage());
        }
    }

    private void initViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1213137620")) {
            ipChange.ipc$dispatch("1213137620", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.scrollView = (MyScrollView) findViewById(R$id.cb_souvenir_scrollview);
        this.souvenir_title_bg = (LinearLayout) findViewById(R$id.souvenir_title_bg);
        this.souvenir_title_content_bg = (RelativeLayout) findViewById(R$id.souvenir_title_content_bg);
        this.souvenir_custom = (TickletSouvenirClassicsView) findViewById(R$id.souvenir_custom);
        this.ticklet_sou_price = (TickletSouvenIrCustomView) findViewById(R$id.ticklet_sou_price);
        this.ticklet_sou_seat = (TickletSouvenIrCustomView) findViewById(R$id.ticklet_sou_seat);
        this.ticklet_sou_user = (TickletSouvenIrCustomView) findViewById(R$id.ticklet_sou_user);
        this.tvTitleBack = (DMIconFontTextView) findViewById(R$id.ticklet_iv_left_icon);
        this.titleText = (TextView) findViewById(R$id.ticklet_title_text);
        this.cancel_action = (TextView) findViewById(R$id.cancel_action);
        this.generateImageShare = (TextView) findViewById(R$id.icon_generate_image);
        setStatusBar();
        setListiner();
        this.tvTitleBack.setText(getString(R$string.iconfont_guanbi_));
        this.titleText.setText("");
        scrollEvent();
    }

    private void scrollEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-695026523")) {
            ipChange.ipc$dispatch("-695026523", new Object[]{this});
            return;
        }
        MyScrollView myScrollView = this.scrollView;
        if (myScrollView != null) {
            myScrollView.setOnScrollYListener(new a());
        }
    }

    public static int setAlphaComponent(float f, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1873978087") ? ((Integer) ipChange.ipc$dispatch("1873978087", new Object[]{Float.valueOf(f), Integer.valueOf(i)})).intValue() : Color.argb((int) f, (16711680 & i) >> 16, (65280 & i) >> 8, i & 255);
    }

    private void setListiner() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "171734432")) {
            ipChange.ipc$dispatch("171734432", new Object[]{this});
            return;
        }
        this.ticklet_sou_price.setOnClickListener(this);
        this.ticklet_sou_seat.setOnClickListener(this);
        this.ticklet_sou_user.setOnClickListener(this);
        this.cancel_action.setOnClickListener(this);
        this.generateImageShare.setOnClickListener(this);
        this.tvTitleBack.setOnClickListener(this);
    }

    private void setStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448947225")) {
            ipChange.ipc$dispatch("1448947225", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.ticklet_title_bar_space_view);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.setLayoutParams(new LinearLayout.LayoutParams(-1, kg2.a(this)));
                findViewById.setVisibility(0);
            }
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
            return;
        }
        kg2.f(this, false, R$color.black);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTitleAlpha(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-709232297")) {
            ipChange.ipc$dispatch("-709232297", new Object[]{this, Float.valueOf(f)});
        } else if (f <= 0.0f) {
            this.souvenir_title_content_bg.setBackgroundColor(this.mContext.getResources().getColor(R$color.transparent));
        } else if (f >= 1.0f) {
            this.souvenir_title_content_bg.setBackgroundColor(this.mContext.getResources().getColor(R$color.color_ffffff));
        } else {
            this.souvenir_title_content_bg.setBackgroundColor(setAlphaComponent(f * 255.0f, this.mContext.getResources().getColor(R$color.color_ffffff)));
        }
    }

    public void createPic(View view, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2110329344")) {
            ipChange.ipc$dispatch("2110329344", new Object[]{this, view, activity});
        } else {
            py2.f().a(view, activity, this.infoBean, getViewPagerBmp());
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-218493024")) {
            ipChange.ipc$dispatch("-218493024", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-952689078") ? ((Integer) ipChange.ipc$dispatch("-952689078", new Object[]{this})).intValue() : R$layout.ticklet_e_custom_souvenir_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1330589071")) {
            ipChange.ipc$dispatch("-1330589071", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1222694438")) {
            ipChange.ipc$dispatch("-1222694438", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1285987459")) {
            ipChange.ipc$dispatch("1285987459", new Object[]{this});
        } else {
            initViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "719868842")) {
            ipChange.ipc$dispatch("719868842", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
    }

    public void onBackPresss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1135927390")) {
            ipChange.ipc$dispatch("-1135927390", new Object[]{this});
            return;
        }
        c.e().z(un2.k().p(un2.TICKLET_DEFINE_SOUNENIR_TICKET, this.performId, "bottom"));
        finish();
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-537736279")) {
            ipChange.ipc$dispatch("-537736279", new Object[]{this, view});
        } else if (view.getId() == R$id.ticklet_iv_left_icon) {
            onBackPresss();
        } else if (view.getId() == R$id.cancel_action) {
            onBackPresss();
        } else {
            if (view.getId() == R$id.icon_generate_image) {
                HashMap hashMap = new HashMap();
                hashMap.put("price", this.ticklet_sou_price.isCheck() ? "1" : "0");
                hashMap.put("seat", this.ticklet_sou_seat.isCheck() ? "1" : "0");
                hashMap.put("user", this.ticklet_sou_user.isCheck() ? "1" : "0");
                hashMap.put("style", "竖版");
                HashMap hashMap2 = new HashMap();
                hashMap2.put("titlelabel", hashMap.toString());
                hashMap2.put("perform_id", this.performId);
                hashMap2.put("usercode", String.valueOf(z20.E()));
                c.e().x(b.getInstance().e(un2.TICKLET_DEFINE_SOUNENIR_TICKET, "bottom", "share", hashMap2, Boolean.TRUE));
                createPic(view, this);
            } else if (view.getId() == R$id.ticklet_sou_price) {
                if (this.ticklet_sou_price.isCheck()) {
                    this.souvenir_custom.setPriceShow("****", 10, false);
                    this.ticklet_sou_price.setIconStyle(false);
                    return;
                }
                this.souvenir_custom.setPriceShow(TextUtils.isEmpty(this.infoBean.totalPrice) ? this.infoBean.noPriceTxt : this.infoBean.totalPrice, 18, true);
                this.ticklet_sou_price.setIconStyle(true);
            } else if (view.getId() == R$id.ticklet_sou_seat) {
                if (this.ticklet_sou_seat.isCheck()) {
                    this.souvenir_custom.setSeatShow("********");
                    this.ticklet_sou_seat.setIconStyle(false);
                    return;
                }
                this.souvenir_custom.setSeatShow(this.infoBean.allSeatText);
                this.ticklet_sou_seat.setIconStyle(true);
            } else if (view.getId() == R$id.ticklet_sou_user) {
                if (this.ticklet_sou_user.isCheck()) {
                    this.souvenir_custom.setUserInfo("***", true, true, this.infoBean.pfVipMemberLevel);
                    this.ticklet_sou_user.setIconStyle(false);
                    return;
                }
                TickletSouvenirClassicsView tickletSouvenirClassicsView = this.souvenir_custom;
                TicketSouvenirBean ticketSouvenirBean = this.infoBean;
                tickletSouvenirClassicsView.setUserInfo(ticketSouvenirBean.nickname, false, "1".equals(ticketSouvenirBean.vip), this.infoBean.pfVipMemberLevel);
                this.ticklet_sou_user.setIconStyle(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1432803031")) {
            ipChange.ipc$dispatch("1432803031", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        LoginManager.k().c(this);
        setDamaiUTKeyBuilder(un2.k().b(un2.TICKLET_DEFINE_SOUNENIR_TICKET));
        if (getIntent() != null) {
            this.performId = getIntent().getStringExtra(TicketDetailExtFragment.PERFORM_ID);
            this.infoBean = (TicketSouvenirBean) getIntent().getSerializableExtra("souvenirBean");
            this.height = getIntent().getIntExtra("height", t60.a(this, 469.0f));
            this.heightImage = getIntent().getIntExtra("heightImage", t60.a(this, 347.0f));
            this.width = getIntent().getIntExtra("width", t60.a(this, 260.0f));
            if (this.infoBean == null) {
                return;
            }
            initData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1744787497")) {
            ipChange.ipc$dispatch("-1744787497", new Object[]{this});
            return;
        }
        super.onDestroy();
        LoginManager.k().C(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1533542701")) {
            return ((Boolean) ipChange.ipc$dispatch("1533542701", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            onBackPresss();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-88038496")) {
            ipChange.ipc$dispatch("-88038496", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2030307723")) {
            ipChange.ipc$dispatch("-2030307723", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1140675054")) {
            ipChange.ipc$dispatch("1140675054", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1729534070")) {
            ipChange.ipc$dispatch("-1729534070", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1619759169")) {
            ipChange.ipc$dispatch("-1619759169", new Object[]{this});
        } else {
            TextUtils.isEmpty(z20.E());
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLogout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2059176049")) {
            ipChange.ipc$dispatch("-2059176049", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1956814348")) {
            ipChange.ipc$dispatch("1956814348", new Object[]{this});
        } else {
            super.onResume();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "998849342")) {
            return (String) ipChange.ipc$dispatch("998849342", new Object[]{this});
        }
        return null;
    }
}
