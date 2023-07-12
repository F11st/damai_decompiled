package cn.damai.ticklet.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.util.Utils;
import cn.damai.commonbusiness.view.DmViewPager;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.ILoginListener;
import cn.damai.member.R$color;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.TicketSouvenirBean;
import cn.damai.ticklet.net.TickletESouvenirRequest;
import cn.damai.ticklet.ui.adapter.SounenirViewPagerAdapter;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import cn.damai.uikit.banner.transformer.carousel.ScaleInTransformer;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.kg2;
import tb.py2;
import tb.t60;
import tb.un2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ESouvenirActivity extends DamaiBaseActivity implements ILoginListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView customAction;
    private LinearLayout errorPageView;
    private TextView generateImageShare;
    private LinearLayout icon_action_layout;
    private LinearLayout indicatorLayout;
    private List<ImageView> indicators;
    private SounenirViewPagerAdapter pagerAdapter;
    private String performId;
    private String productSystemId;
    private ScrollView scrollView;
    private View titleBottomLine;
    private TextView titleText;
    private TextView tvStyleType;
    private DMIconFontTextView tvTitleBack;
    private TextView tvrRuleTip;
    private DmViewPager viewPager;
    private int viewPagerCount = 2;
    private TicketSouvenirBean infoBean = new TicketSouvenirBean();
    private ArrayList<TicketSouvenirBean> viewPagerResults = new ArrayList<>();
    int heightImage = 0;
    int height = 0;
    int width = 0;

    private void createPic(View view, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-810847825")) {
            ipChange.ipc$dispatch("-810847825", new Object[]{this, view, activity});
        } else {
            py2.f().a(view, activity, this.infoBean, getViewPagerBmp());
        }
    }

    private void eventEnable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-570920274")) {
            ipChange.ipc$dispatch("-570920274", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.customAction.setClickable(true);
            this.generateImageShare.setClickable(true);
            this.generateImageShare.setBackgroundResource(R$drawable.submit_enable_btn_h44);
            this.customAction.setBackgroundResource(R$drawable.submit_enable_blue_btn_h44);
        } else {
            this.customAction.setClickable(false);
            this.generateImageShare.setClickable(false);
            this.generateImageShare.setBackgroundResource(R$drawable.submit_enable_light_ff3299_btn_h44);
            this.customAction.setBackgroundResource(R$drawable.submit_enable_light_blue_btn_h44);
        }
    }

    private Bitmap getViewPagerBmp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-196301692")) {
            return (Bitmap) ipChange.ipc$dispatch("-196301692", new Object[]{this});
        }
        int measuredWidth = this.viewPager.getMeasuredWidth();
        int measuredHeight = this.viewPager.getMeasuredHeight();
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        this.pagerAdapter.c().draw(new Canvas(createBitmap));
        return Utils.j(createBitmap, measuredWidth * 1.2d, measuredHeight * 1.2d);
    }

    private void initIndicator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1683819516")) {
            ipChange.ipc$dispatch("-1683819516", new Object[]{this});
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.indicators = arrayList;
        arrayList.clear();
        this.indicatorLayout.removeAllViews();
        for (int i = 0; i < this.viewPagerCount; i++) {
            ImageView imageView = new ImageView(this);
            if (i == 0) {
                imageView.setImageResource(R$drawable.cb_pigeonindicator_selected);
            } else {
                imageView.setImageResource(R$drawable.cb_circleindicator_00000_unselected);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(t60.a(this, 6.0f), t60.a(this, 6.0f));
            layoutParams.setMargins(t60.a(this, 5.0f), 0, t60.a(this, 5.0f), 0);
            this.indicatorLayout.addView(imageView, layoutParams);
            this.indicators.add(imageView);
        }
    }

    private void initViewPager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1522933653")) {
            ipChange.ipc$dispatch("1522933653", new Object[]{this});
            return;
        }
        this.viewPager.setPageMargin(t60.a(this, 1.0f));
        this.viewPager.setOffscreenPageLimit(3);
        this.viewPager.setPageTransformer(false, new ScaleInTransformer(0.9f));
        this.pagerAdapter = new SounenirViewPagerAdapter(this);
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: cn.damai.ticklet.ui.activity.ESouvenirActivity.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "723272013")) {
                    ipChange2.ipc$dispatch("723272013", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1773890284")) {
                    ipChange2.ipc$dispatch("1773890284", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2014188328")) {
                    ipChange2.ipc$dispatch("-2014188328", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                c.e().x(un2.k().n(i, ESouvenirActivity.this.performId));
                ESouvenirActivity.this.refreshIndicator(i);
            }
        });
    }

    private void initViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "886470213")) {
            ipChange.ipc$dispatch("886470213", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.scrollView = (ScrollView) findViewById(R$id.cb_souvenir_scrollview);
        this.errorPageView = (LinearLayout) findViewById(R$id.errorPageView);
        this.tvTitleBack = (DMIconFontTextView) findViewById(R$id.ticklet_iv_left_icon);
        this.titleText = (TextView) findViewById(R$id.ticklet_title_text);
        this.tvrRuleTip = (TextView) findViewById(R$id.ticklet_rule_text_url);
        this.titleBottomLine = findViewById(R$id.ticklet_bottom_line);
        this.tvStyleType = (TextView) findViewById(R$id.ticklet_souvenir_type);
        this.viewPager = (DmViewPager) findViewById(R$id.ticklet_souvenir_viewpager);
        this.indicatorLayout = (LinearLayout) findViewById(R$id.indicator_container);
        this.icon_action_layout = (LinearLayout) findViewById(R$id.icon_action_layout);
        this.customAction = (TextView) findViewById(R$id.icon_custom_action);
        this.generateImageShare = (TextView) findViewById(R$id.icon_generate_image);
        setStatusBar();
        initViewPager();
        initIndicator();
        showIndicator(false);
        setListiner();
        this.tvTitleBack.setText(getString(R$string.iconfont_guanbi_));
        this.titleText.setText("官方纪念票");
        this.tvrRuleTip.setVisibility(8);
        this.titleBottomLine.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isShowErrorView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-263276105")) {
            ipChange.ipc$dispatch("-263276105", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.errorPageView.setVisibility(0);
            this.scrollView.setVisibility(8);
            this.icon_action_layout.setVisibility(8);
        } else {
            this.scrollView.setVisibility(0);
            this.icon_action_layout.setVisibility(0);
            this.errorPageView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifAdapter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-555820152")) {
            ipChange.ipc$dispatch("-555820152", new Object[]{this});
            return;
        }
        this.viewPagerResults.clear();
        this.viewPagerResults.add(this.infoBean);
        if (!TextUtils.isEmpty(this.infoBean.nextImageUrl)) {
            this.viewPagerResults.add(this.infoBean);
            showIndicator(true);
        }
        int a = DisplayMetrics.getwidthPixels(t60.b(this)) - (t60.a(this, 43.0f) * 2);
        this.heightImage = r1;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.viewPager.getLayoutParams();
        int a2 = t60.a(this, 123.0f) + r1;
        this.height = a2;
        this.width = a;
        layoutParams.height = a2;
        layoutParams.width = a;
        this.viewPager.setLayoutParams(layoutParams);
        this.pagerAdapter.d(this.viewPagerResults);
        this.viewPager.setAdapter(this.pagerAdapter);
        this.pagerAdapter.f(a);
        this.pagerAdapter.e(r1);
        this.pagerAdapter.notifyDataSetChanged();
        viewPagerType(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshIndicator(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1890093680")) {
            ipChange.ipc$dispatch("1890093680", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = this.viewPagerCount;
            if (i2 >= i3) {
                break;
            }
            if (i % i3 == i2) {
                this.indicators.get(i2).setImageResource(R$drawable.cb_pigeonindicator_selected);
            } else {
                this.indicators.get(i2).setImageResource(R$drawable.cb_circleindicator_00000_unselected);
            }
            i2++;
        }
        viewPagerType(i);
        eventEnable(i == 0);
    }

    private void requestData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1184041290")) {
            ipChange.ipc$dispatch("1184041290", new Object[]{this});
            return;
        }
        startProgressDialog();
        TickletESouvenirRequest tickletESouvenirRequest = new TickletESouvenirRequest();
        tickletESouvenirRequest.performId = this.performId;
        tickletESouvenirRequest.productSystemId = this.productSystemId;
        tickletESouvenirRequest.request(new DMMtopRequestListener<TicketSouvenirBean>(TicketSouvenirBean.class) { // from class: cn.damai.ticklet.ui.activity.ESouvenirActivity.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1482168780")) {
                    ipChange2.ipc$dispatch("1482168780", new Object[]{this, str, str2});
                    return;
                }
                ESouvenirActivity.this.stopProgressDialog();
                ESouvenirActivity.this.errorView(str, str2);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(TicketSouvenirBean ticketSouvenirBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "634425090")) {
                    ipChange2.ipc$dispatch("634425090", new Object[]{this, ticketSouvenirBean});
                    return;
                }
                ESouvenirActivity.this.stopProgressDialog();
                if (ticketSouvenirBean != null) {
                    ESouvenirActivity.this.isShowErrorView(false);
                    ESouvenirActivity.this.infoBean = ticketSouvenirBean;
                    ESouvenirActivity.this.notifAdapter();
                    return;
                }
                ESouvenirActivity.this.showEmptyPage();
            }
        });
    }

    private void setListiner() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-223031087")) {
            ipChange.ipc$dispatch("-223031087", new Object[]{this});
            return;
        }
        this.customAction.setOnClickListener(this);
        this.generateImageShare.setOnClickListener(this);
        this.tvTitleBack.setOnClickListener(this);
    }

    private void setStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2096118024")) {
            ipChange.ipc$dispatch("2096118024", new Object[]{this});
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
    public void showEmptyPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-825168924")) {
            ipChange.ipc$dispatch("-825168924", new Object[]{this});
            return;
        }
        isShowErrorView(true);
        onResponseError(3, getString(R$string.ticklet_venue_error), "", "", this.errorPageView, true);
    }

    private void showErrorPage(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-326489251")) {
            ipChange.ipc$dispatch("-326489251", new Object[]{this, str, str2});
            return;
        }
        isShowErrorView(true);
        onResponseError(str2, str, "mtop.damai.wireless.ticklet.esouvenir.detail.get", this.errorPageView, true);
    }

    private void showIndicator(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1991348867")) {
            ipChange.ipc$dispatch("1991348867", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.indicatorLayout.setVisibility(0);
        } else {
            this.indicatorLayout.setVisibility(8);
        }
    }

    private void viewPagerType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1238812824")) {
            ipChange.ipc$dispatch("1238812824", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 0) {
            this.tvStyleType.setText("经典款");
        } else if (i == 1) {
            this.tvStyleType.setText("惊喜款");
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "840960783")) {
            ipChange.ipc$dispatch("840960783", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void errorView(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1300941930")) {
            ipChange.ipc$dispatch("1300941930", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        showErrorPage(str, str2);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1347454597") ? ((Integer) ipChange.ipc$dispatch("-1347454597", new Object[]{this})).intValue() : R$layout.ticklet_e_souvenir_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-683418272")) {
            ipChange.ipc$dispatch("-683418272", new Object[]{this, Integer.valueOf(i)});
        } else {
            requestData();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1659731147")) {
            ipChange.ipc$dispatch("1659731147", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1634044174")) {
            ipChange.ipc$dispatch("-1634044174", new Object[]{this});
        } else {
            initViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1801507417")) {
            ipChange.ipc$dispatch("1801507417", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
    }

    public void onBackPresss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-488756591")) {
            ipChange.ipc$dispatch("-488756591", new Object[]{this});
            return;
        }
        c.e().z(un2.k().p(un2.TICKLET_SOUNENIR_TICKET, this.performId, "top"));
        finish();
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-12285864")) {
            ipChange.ipc$dispatch("-12285864", new Object[]{this, view});
        } else if (view.getId() == R$id.ticklet_iv_left_icon) {
            onBackPresss();
        } else if (view.getId() == R$id.icon_custom_action) {
            c.e().x(b.getInstance().e(un2.TICKLET_SOUNENIR_TICKET, "bottom", "define", un2.k().s(this.performId), Boolean.TRUE));
            Bundle bundle = new Bundle();
            bundle.putSerializable("souvenirBean", this.infoBean);
            bundle.putInt("heightImage", this.heightImage);
            bundle.putInt("height", this.height);
            bundle.putInt("width", this.width);
            bundle.putString(TicketDetailExtFragment.PERFORM_ID, this.performId);
            DMNav.from(this).withExtras(bundle).toUri(NavUri.b("ticklet_custom_sounenvir"));
        } else if (view.getId() == R$id.icon_generate_image) {
            c.e().x(b.getInstance().e(un2.TICKLET_SOUNENIR_TICKET, "bottom", "share", un2.k().s(this.performId), Boolean.TRUE));
            createPic(view, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "541896712")) {
            ipChange.ipc$dispatch("541896712", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        LoginManager.k().c(this);
        setDamaiUTKeyBuilder(un2.k().b(un2.TICKLET_SOUNENIR_TICKET));
        if (getIntent() != null) {
            this.performId = getIntent().getStringExtra(TicketDetailExtFragment.PERFORM_ID);
            this.productSystemId = getIntent().getStringExtra(TicketDetailExtFragment.PRODUCT_SYSTEM_ID);
            requestData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2071454904")) {
            ipChange.ipc$dispatch("-2071454904", new Object[]{this});
            return;
        }
        super.onDestroy();
        LoginManager.k().C(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-287805026")) {
            return ((Boolean) ipChange.ipc$dispatch("-287805026", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            onBackPresss();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "559132303")) {
            ipChange.ipc$dispatch("559132303", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1869894054")) {
            ipChange.ipc$dispatch("1869894054", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-271866657")) {
            ipChange.ipc$dispatch("-271866657", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2124299589")) {
            ipChange.ipc$dispatch("-2124299589", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1836088046")) {
            ipChange.ipc$dispatch("1836088046", new Object[]{this});
        } else if (TextUtils.isEmpty(z20.E())) {
        } else {
            requestData();
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLogout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-684240386")) {
            ipChange.ipc$dispatch("-684240386", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-963217285")) {
            ipChange.ipc$dispatch("-963217285", new Object[]{this});
        } else {
            super.onResume();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "600157359")) {
            return (String) ipChange.ipc$dispatch("600157359", new Object[]{this});
        }
        return null;
    }
}
