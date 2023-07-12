package cn.damai.mine.relationship;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.homepage.R$array;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.mine.mycollect.ui.adapter.MyCollectTitleAdapter;
import cn.damai.mine.relationship.fragment.RelationBaseFragment;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.snake.EqualLinearView;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.cm2;
import tb.kg2;
import tb.vf1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RelationShipActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private RelationBaseFragment fansFragment;
    private MyCollectTitleAdapter mPagerAdapter;
    private String mTargetId;
    private String mTargetType;
    private EqualLinearView mTitleScroll;
    private String[] mTitles;
    private TextView mTvTitle;
    private DMIconFontTextView mTvTitleBack;
    private TextView mTvTitleRight;
    private ViewPager mViewPager;
    private View mViewStatusBarSpace;
    private RelationBaseFragment relationBrandFragment;
    private RelationBaseFragment relationCustomerFragment;
    private RelationBaseFragment relationStarFragment;
    private View relation_line;
    private String userId = "";
    private boolean self = false;
    private String relationType = "1";

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-610344968")) {
                ipChange.ipc$dispatch("-610344968", new Object[]{this, view});
            } else {
                RelationShipActivity.this.onBackPressed();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1500945401")) {
                ipChange.ipc$dispatch("1500945401", new Object[]{this, view});
                return;
            }
            ScrollTitleBean scrollTitleBean = (ScrollTitleBean) view.getTag();
            if (scrollTitleBean == null || RelationShipActivity.this.mViewPager == null) {
                return;
            }
            RelationShipActivity.this.mViewPager.setCurrentItem(scrollTitleBean.index);
        }
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "518694368")) {
            ipChange.ipc$dispatch("518694368", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.relationType = intent.getStringExtra("relationType");
            this.userId = intent.getStringExtra("userId");
            this.mTargetType = intent.getStringExtra("targetType");
            this.mTargetId = intent.getStringExtra("targetId");
            this.self = intent.getBooleanExtra("self", false);
        }
        if (TextUtils.isEmpty(this.relationType)) {
            this.relationType = "1";
        }
        if (isFollowType()) {
            setDamaiUTKeyBuilder(new a.b().i(vf1.FOLLOW_LIST_PAGE));
        } else {
            setDamaiUTKeyBuilder(new a.b().i(vf1.FANS_LIST_PAGE));
        }
    }

    private void initPageHeadView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-205724682")) {
            ipChange.ipc$dispatch("-205724682", new Object[]{this});
            return;
        }
        this.relation_line = findViewById(R$id.relation_line);
        this.mTitleScroll = (EqualLinearView) findViewById(R$id.scroll_title);
        if (isFollowType()) {
            this.relation_line.setVisibility(0);
            this.mTitleScroll.setVisibility(0);
        } else {
            this.relation_line.setVisibility(8);
            this.mTitleScroll.setVisibility(8);
        }
        this.mTitles = cm2.a(this, R$array.relation_title);
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        int length = this.mTitles.length;
        for (int i = 0; i < length; i++) {
            ScrollTitleBean scrollTitleBean = new ScrollTitleBean();
            scrollTitleBean.index = i;
            scrollTitleBean.name = this.mTitles[i];
            arrayList.add(scrollTitleBean);
        }
        this.mTitleScroll.setFontColor(R$color.color_000000, R$color.color_333333).setFontSize(16, 16).setTitle(arrayList).setHeight(46).setOnTitleClickListener(new b()).commit();
    }

    private void initTitleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1706352643")) {
            ipChange.ipc$dispatch("1706352643", new Object[]{this});
            return;
        }
        removeHeadTitleView();
        View findViewById = findViewById(R$id.mine_relation_ship_title);
        this.mViewStatusBarSpace = findViewById.findViewById(R$id.title_bar_space);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) findViewById.findViewById(R$id.mine_title_left_icon_font_tv);
        this.mTvTitleBack = dMIconFontTextView;
        dMIconFontTextView.setOnClickListener(new a());
        this.mTvTitle = (TextView) findViewById.findViewById(R$id.mine_title_tv);
        String str = !this.self ? "TA的" : "我的";
        if (isFollowType()) {
            TextView textView = this.mTvTitle;
            textView.setText(str + "关注");
        } else {
            TextView textView2 = this.mTvTitle;
            textView2.setText(str + "粉丝");
        }
        TextView textView3 = (TextView) findViewById.findViewById(R$id.mine_title_right_tv);
        this.mTvTitleRight = textView3;
        textView3.setVisibility(8);
        setTitleImmersiveStyle();
    }

    private void initViewPager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1086010722")) {
            ipChange.ipc$dispatch("1086010722", new Object[]{this});
            return;
        }
        this.mViewPager = (ViewPager) findViewById(R$id.relation_pager);
        ArrayList arrayList = new ArrayList();
        if (isFollowType()) {
            this.relationBrandFragment = RelationBaseFragment.getInstance(this.relationType, this.userId, this.mTargetType, this.mTargetId, "brand", this.self);
            this.relationStarFragment = RelationBaseFragment.getInstance(this.relationType, this.userId, this.mTargetType, this.mTargetId, "star", this.self);
            this.relationCustomerFragment = RelationBaseFragment.getInstance(this.relationType, this.userId, this.mTargetType, this.mTargetId, RelationBaseFragment.RELATION_TYPE_KIND_COSTOMER, this.self);
            arrayList.add(this.relationBrandFragment);
            arrayList.add(this.relationStarFragment);
            arrayList.add(this.relationCustomerFragment);
        } else {
            RelationBaseFragment relationBaseFragment = RelationBaseFragment.getInstance(this.relationType, this.userId, this.mTargetType, this.mTargetId, "", this.self);
            this.fansFragment = relationBaseFragment;
            arrayList.add(relationBaseFragment);
        }
        MyCollectTitleAdapter myCollectTitleAdapter = new MyCollectTitleAdapter(getSupportFragmentManager(), arrayList);
        this.mPagerAdapter = myCollectTitleAdapter;
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            viewPager.setAdapter(myCollectTitleAdapter);
            this.mTitleScroll.selectTitle(0);
            this.mViewPager.setCurrentItem(0);
            this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: cn.damai.mine.relationship.RelationShipActivity.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "85797912")) {
                        ipChange2.ipc$dispatch("85797912", new Object[]{this, Integer.valueOf(i)});
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2066567351")) {
                        ipChange2.ipc$dispatch("2066567351", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1415001757")) {
                        ipChange2.ipc$dispatch("-1415001757", new Object[]{this, Integer.valueOf(i)});
                    } else {
                        RelationShipActivity.this.mTitleScroll.selectTitle(i);
                    }
                }
            });
            this.mViewPager.setOffscreenPageLimit(2);
        }
    }

    private boolean isFollowType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-823014647") ? ((Boolean) ipChange.ipc$dispatch("-823014647", new Object[]{this})).booleanValue() : "1".equals(this.relationType);
    }

    private void setTitleImmersiveStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-288536498")) {
            ipChange.ipc$dispatch("-288536498", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            View view = this.mViewStatusBarSpace;
            if (view != null) {
                view.getLayoutParams().height = kg2.a(this);
                this.mViewStatusBarSpace.setVisibility(0);
            }
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
        } else {
            kg2.f(this, false, R$color.black);
            View view2 = this.mViewStatusBarSpace;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1779169758")) {
            ipChange.ipc$dispatch("-1779169758", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-409362808") ? ((Integer) ipChange.ipc$dispatch("-409362808", new Object[]{this})).intValue() : R$layout.relation_info_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1667343885")) {
            ipChange.ipc$dispatch("-1667343885", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void initContentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193253378")) {
            ipChange.ipc$dispatch("193253378", new Object[]{this});
            return;
        }
        initPageHeadView();
        initViewPager();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1222808216")) {
            ipChange.ipc$dispatch("1222808216", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-470272763")) {
            ipChange.ipc$dispatch("-470272763", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-370337003")) {
            ipChange.ipc$dispatch("-370337003", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        initData();
        initTitleView();
        initContentView();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-424793310")) {
            ipChange.ipc$dispatch("-424793310", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1486981453")) {
            ipChange.ipc$dispatch("-1486981453", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2135984388") ? (String) ipChange.ipc$dispatch("-2135984388", new Object[]{this}) : "";
    }
}
