package cn.damai.ticklet.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.evaluate.ui.EvaluateListFragment;
import cn.damai.evaluate.ui.TickletToCommentFragment;
import cn.damai.evaluate.ui.item.EvaluateItemDataBinder;
import cn.damai.member.R$color;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.ui.adapter.TickletMyCommentAdapter;
import cn.damai.uikit.snake.HorScrollView;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tb.in2;
import tb.kg2;
import tb.un2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TicketMyCommentActivity extends DamaiBaseActivity implements EvaluateItemDataBinder.EvaluateItemUTReportListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private TickletMyCommentAdapter mAdapter;
    private HorScrollView mScrollView;
    private ViewPager mViewPager;
    private int selectedTab;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.ui.activity.TicketMyCommentActivity$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2025a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2025a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-580903879")) {
                ipChange.ipc$dispatch("-580903879", new Object[]{this, view});
            } else {
                TicketMyCommentActivity.this.mViewPager.setCurrentItem(((ScrollTitleBean) view.getTag()).index);
            }
        }
    }

    private List<Fragment> getFragments() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1712258170")) {
            return (List) ipChange.ipc$dispatch("1712258170", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(TickletToCommentFragment.getInstance("", ""));
        EvaluateListFragment evaluateListFragment = new EvaluateListFragment();
        evaluateListFragment.setEvalutateItemClickUTData(this);
        Bundle bundle = new Bundle();
        bundle.putInt("fromWhere", EvaluateListFragment.EVALUATELIST_ALLREADY);
        evaluateListFragment.setArguments(bundle);
        arrayList.add(evaluateListFragment);
        return arrayList;
    }

    private void initExtra() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-225710736")) {
            ipChange.ipc$dispatch("-225710736", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.selectedTab = intent.getIntExtra("tab", 0);
        }
    }

    private void initListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1252259242")) {
            ipChange.ipc$dispatch("-1252259242", new Object[]{this});
        } else {
            findViewById(R$id.icon_left_icon).setOnClickListener(this);
        }
    }

    private void initScrollTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-259976235")) {
            ipChange.ipc$dispatch("-259976235", new Object[]{this});
            return;
        }
        this.mScrollView = (HorScrollView) findViewById(R$id.scroll_title);
        ArrayList arrayList = new ArrayList();
        ScrollTitleBean scrollTitleBean = new ScrollTitleBean();
        scrollTitleBean.id = "0";
        scrollTitleBean.index = 0;
        scrollTitleBean.name = in2.TO_COMMENT;
        ScrollTitleBean scrollTitleBean2 = new ScrollTitleBean();
        scrollTitleBean2.id = "1";
        scrollTitleBean2.index = 1;
        scrollTitleBean2.name = in2.FINISH_COMMENT;
        arrayList.add(scrollTitleBean);
        arrayList.add(scrollTitleBean2);
        this.mScrollView.setTitle(arrayList);
        this.mScrollView.setFontColor(R$color.black, R$color.color_9C9CA5);
        this.mScrollView.setFontSize(16, 20);
        this.mScrollView.setSpace(36);
        this.mScrollView.setOnTitleClickListener(new View$OnClickListenerC2025a());
        this.mScrollView.commit();
    }

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-286434776")) {
            ipChange.ipc$dispatch("-286434776", new Object[]{this});
            return;
        }
        hideBaseLayout();
        ((TextView) findViewById(R$id.tv_header_title)).setText("我的评价");
        View findViewById = findViewById(R$id.status_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            findViewById.getLayoutParams().height = kg2.a(this);
            findViewById.setVisibility(0);
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
            return;
        }
        kg2.f(this, false, R$color.black);
        findViewById.setVisibility(8);
    }

    private void initViewPager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1904819490")) {
            ipChange.ipc$dispatch("1904819490", new Object[]{this});
            return;
        }
        this.mViewPager = (ViewPager) findViewById(R$id.ticklet_mycomment_viewpager);
        TickletMyCommentAdapter tickletMyCommentAdapter = new TickletMyCommentAdapter(getSupportFragmentManager(), getFragments());
        this.mAdapter = tickletMyCommentAdapter;
        this.mViewPager.setAdapter(tickletMyCommentAdapter);
        this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: cn.damai.ticklet.ui.activity.TicketMyCommentActivity.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "159523866")) {
                    ipChange2.ipc$dispatch("159523866", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1505979065")) {
                    ipChange2.ipc$dispatch("1505979065", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "631340005")) {
                    ipChange2.ipc$dispatch("631340005", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                TicketMyCommentActivity.this.mScrollView.selectTitle(i);
                C0529c.e().x(un2.k().w(i, i == 0 ? in2.TO_COMMENT : in2.FINISH_COMMENT));
            }
        });
        this.mViewPager.setCurrentItem(this.selectedTab);
        this.mScrollView.selectTitle(this.selectedTab);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "233563746")) {
            ipChange.ipc$dispatch("233563746", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1875285576") ? ((Integer) ipChange.ipc$dispatch("1875285576", new Object[]{this})).intValue() : R$layout.ticklet_mycomment_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "437279283")) {
            ipChange.ipc$dispatch("437279283", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2041616984")) {
            ipChange.ipc$dispatch("2041616984", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2029278533")) {
            ipChange.ipc$dispatch("2029278533", new Object[]{this});
            return;
        }
        initTitle();
        initExtra();
        initScrollTitle();
        initViewPager();
        initListener();
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1000302613")) {
            ipChange.ipc$dispatch("-1000302613", new Object[]{this, view});
            return;
        }
        if (view.getId() == R$id.icon_left_icon) {
            finish();
        }
        super.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-21851435")) {
            ipChange.ipc$dispatch("-21851435", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(un2.k().m(un2.TICKLET_MYCOMMENT_LIST_PAGE));
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportImageInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2084885680")) {
            ipChange.ipc$dispatch("-2084885680", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (commentsItemBean == null) {
        } else {
            String videoId = (i2 != 0 || commentsItemBean.getVideoDO() == null) ? "" : commentsItemBean.getVideoDO().getVideoId();
            Map<String, String> T = un2.k().T(in2.FINISH_COMMENT);
            T.put("video_id", videoId);
            C0529c.e().x(un2.k().A(un2.TICKLET_MYCOMMENT_LIST_PAGE, "evaluateed_" + i, "pic_" + i2, T, Boolean.TRUE));
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportItemClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1145317683")) {
            ipChange.ipc$dispatch("-1145317683", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        } else if (commentsItemBean == null) {
        } else {
            C0529c e = C0529c.e();
            un2 k = un2.k();
            e.x(k.A(un2.TICKLET_MYCOMMENT_LIST_PAGE, "evaluateed_" + String.valueOf(i), "card", un2.k().T(in2.FINISH_COMMENT), Boolean.TRUE));
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportMoreInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1248914115")) {
            ipChange.ipc$dispatch("-1248914115", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            return;
        }
        C0529c e = C0529c.e();
        un2 k = un2.k();
        e.x(k.A(un2.TICKLET_MYCOMMENT_LIST_PAGE, "evaluateed_" + String.valueOf(i), "share", un2.k().T(in2.FINISH_COMMENT), Boolean.FALSE));
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportPraiseViewClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "438334047")) {
            ipChange.ipc$dispatch("438334047", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            return;
        }
        C0529c e = C0529c.e();
        un2 k = un2.k();
        e.x(k.A(un2.TICKLET_MYCOMMENT_LIST_PAGE, "evaluateed_" + String.valueOf(i), "likes", un2.k().T(in2.FINISH_COMMENT), Boolean.FALSE));
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportReplyClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1060996530")) {
            ipChange.ipc$dispatch("1060996530", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            return;
        }
        C0529c e = C0529c.e();
        un2 k = un2.k();
        e.x(k.A(un2.TICKLET_MYCOMMENT_LIST_PAGE, "evaluateed_" + String.valueOf(i), "reply_btn", un2.k().T(in2.FINISH_COMMENT), Boolean.TRUE));
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportSyncCircleClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-160929259")) {
            ipChange.ipc$dispatch("-160929259", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportTransferClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "604196341")) {
            ipChange.ipc$dispatch("604196341", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
            return;
        }
        C0529c e = C0529c.e();
        un2 k = un2.k();
        e.x(k.A(un2.TICKLET_MYCOMMENT_LIST_PAGE, "evaluateed_" + String.valueOf(i), "item", un2.k().T(in2.FINISH_COMMENT), Boolean.TRUE));
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportUserInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2034049799")) {
            ipChange.ipc$dispatch("2034049799", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1676664508") ? (String) ipChange.ipc$dispatch("1676664508", new Object[]{this}) : "我的评价";
    }
}
