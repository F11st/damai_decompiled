package cn.damai.user.userprofile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.user.C0525a;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.view.PagerSlidingTabStrip;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.user.userprofile.bean.IdolSelectRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class IdolSelectActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<IdolSelectFragment> mCategoryListFragments;
    ViewPager myViewpager;
    IdolSelectAdapter pagerAdapter;
    int position = 0;
    PagerSlidingTabStrip tabs;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.userprofile.IdolSelectActivity$a */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2740a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2740a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1731701136")) {
                ipChange.ipc$dispatch("-1731701136", new Object[]{this, view});
                return;
            }
            IdolSelectActivity.this.setResult(0, new Intent());
            IdolSelectActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.userprofile.IdolSelectActivity$b */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2741b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2741b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1804087694")) {
                ipChange.ipc$dispatch("-1804087694", new Object[]{this, view});
            } else {
                IdolSelectActivity.this.finish();
            }
        }
    }

    private void initPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "737898323")) {
            ipChange.ipc$dispatch("737898323", new Object[]{this});
            return;
        }
        findViewById(R$id.select_null).setOnClickListener(new View$OnClickListenerC2740a());
        this.mCategoryListFragments = new ArrayList();
        int size = IdolSelectRequest.tabs.size();
        for (int i = 0; i < size; i++) {
            IdolSelectFragment idolSelectFragment = new IdolSelectFragment();
            idolSelectFragment.setType(IdolSelectRequest.tabIds.get(i));
            this.mCategoryListFragments.add(idolSelectFragment);
        }
        IdolSelectAdapter idolSelectAdapter = new IdolSelectAdapter(getSupportFragmentManager(), this.mCategoryListFragments, IdolSelectRequest.tabs.toArray());
        this.pagerAdapter = idolSelectAdapter;
        this.myViewpager.setAdapter(idolSelectAdapter);
        this.myViewpager.setOffscreenPageLimit(1);
        this.myViewpager.setCurrentItem(0);
        this.tabs.setViewPager(this.myViewpager);
        this.tabs.setFadingEdgeLength(0);
        this.tabs.notifyDataSetChanged();
        this.myViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: cn.damai.user.userprofile.IdolSelectActivity.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1644086977")) {
                    ipChange2.ipc$dispatch("1644086977", new Object[]{this, Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1843700832")) {
                    ipChange2.ipc$dispatch("1843700832", new Object[]{this, Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1547891532")) {
                    ipChange2.ipc$dispatch("1547891532", new Object[]{this, Integer.valueOf(i2)});
                } else {
                    IdolSelectActivity.this.position = i2;
                }
            }
        });
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1333694310")) {
            ipChange.ipc$dispatch("-1333694310", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1535215888") ? ((Integer) ipChange.ipc$dispatch("1535215888", new Object[]{this})).intValue() : R$layout.idol_select;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514946453")) {
            ipChange.ipc$dispatch("-1514946453", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1652161312")) {
            ipChange.ipc$dispatch("1652161312", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1995675517")) {
            ipChange.ipc$dispatch("1995675517", new Object[]{this});
            return;
        }
        this.myViewpager = (ViewPager) findViewById(R$id.vPager);
        this.tabs = (PagerSlidingTabStrip) findViewById(R$id.indicator);
        initPage();
        this.base_header_left.setOnClickListener(new View$OnClickListenerC2741b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-822151779")) {
            ipChange.ipc$dispatch("-822151779", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(new C0525a.C0527b().i("circle_list"));
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-272395878")) {
            ipChange.ipc$dispatch("-272395878", new Object[]{this});
        } else {
            stopProgressDialog();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "457597243")) {
            ipChange.ipc$dispatch("457597243", new Object[]{this});
        } else {
            startProgressDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1628464890")) {
            ipChange.ipc$dispatch("-1628464890", new Object[]{this});
        } else {
            super.onResume();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-536456316") ? (String) ipChange.ipc$dispatch("-536456316", new Object[]{this}) : "选择圈子";
    }
}
