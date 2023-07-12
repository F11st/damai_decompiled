package cn.damai.category.category.ui;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import cn.damai.category.category.bean.CategoryEntity;
import cn.damai.category.category.ui.adapter.CategoryDetailAdapter;
import cn.damai.category.common.bean.CategoryPerformBean;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.homepage.R$anim;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.widget.WrapLinearLayoutManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.bh;
import tb.ch;
import tb.kg2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CategoryDetailActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_CATEGORY_ENTITY = "category_entity";
    private CategoryDetailAdapter mAdapter;
    private CategoryEntity mCategoryEntity;
    private CategoryPerformBean mCategoryPerformBean;
    private View mCloseView;
    private boolean mHasChoice;
    private View.OnClickListener mItemListener = new View$OnClickListenerC0329c();
    private IRecyclerView mRecyclerView;
    private View mTranView;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.category.ui.CategoryDetailActivity$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0327a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0327a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1748678767")) {
                ipChange.ipc$dispatch("-1748678767", new Object[]{this, view});
            } else {
                CategoryDetailActivity.this.close();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.category.ui.CategoryDetailActivity$b */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0328b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0328b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "362611602")) {
                ipChange.ipc$dispatch("362611602", new Object[]{this, view});
            } else {
                CategoryDetailActivity.this.close();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.category.ui.CategoryDetailActivity$c */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0329c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0329c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1821065325")) {
                ipChange.ipc$dispatch("-1821065325", new Object[]{this, view});
                return;
            }
            try {
                CategoryEntity categoryEntity = (CategoryEntity) view.getTag();
                if (categoryEntity != null) {
                    CategoryDetailActivity.this.mHasChoice = true;
                    CategoryDetailActivity.this.mAdapter.a(CategoryDetailActivity.this.mCategoryPerformBean, categoryEntity);
                    CategoryDetailActivity.this.mCategoryEntity = categoryEntity;
                    CategoryDetailActivity.this.close();
                    C0529c e = C0529c.e();
                    bh m = bh.m();
                    int i = categoryEntity.subIndex;
                    e.x(m.n(i, categoryEntity.categoryName + "-" + categoryEntity.subName));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1256681569")) {
            ipChange.ipc$dispatch("-1256681569", new Object[]{this});
            return;
        }
        Intent intent = new Intent();
        if (this.mHasChoice) {
            intent.putExtra(KEY_CATEGORY_ENTITY, this.mCategoryEntity);
        }
        setResult(-1, intent);
        finish();
        overridePendingTransition(R$anim.slide_right_in, R$anim.slide_right_out);
    }

    private void initBundle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1158652065")) {
            ipChange.ipc$dispatch("1158652065", new Object[]{this});
        } else if (getIntent() != null) {
            this.mHasChoice = false;
            this.mCategoryPerformBean = (CategoryPerformBean) getIntent().getSerializableExtra("category");
            if (getIntent().getSerializableExtra(KEY_CATEGORY_ENTITY) != null) {
                this.mCategoryEntity = (CategoryEntity) getIntent().getSerializableExtra(KEY_CATEGORY_ENTITY);
            }
        }
    }

    private void initCategory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1391104219")) {
            ipChange.ipc$dispatch("-1391104219", new Object[]{this});
            return;
        }
        removeHeadTitleView();
        View findViewById = findViewById(R$id.status_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            findViewById.getLayoutParams().height = kg2.a(this);
            findViewById.setVisibility(0);
            kg2.f(this, true, R$color.black);
        } else {
            kg2.f(this, false, R$color.black);
            findViewById.setVisibility(8);
        }
        View findViewById2 = findViewById(R$id.tran_view);
        this.mTranView = findViewById2;
        findViewById2.setOnClickListener(new View$OnClickListenerC0327a());
        View findViewById3 = findViewById(R$id.close_view);
        this.mCloseView = findViewById3;
        findViewById3.setOnClickListener(new View$OnClickListenerC0328b());
        IRecyclerView iRecyclerView = (IRecyclerView) findViewById(R$id.irc);
        this.mRecyclerView = iRecyclerView;
        iRecyclerView.setLayoutManager(new WrapLinearLayoutManager(this));
        CategoryDetailAdapter categoryDetailAdapter = new CategoryDetailAdapter(this, this.mItemListener);
        this.mAdapter = categoryDetailAdapter;
        this.mRecyclerView.setAdapter(categoryDetailAdapter);
        this.mAdapter.a(this.mCategoryPerformBean, this.mCategoryEntity);
        this.mRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setLoadMoreEnabled(false);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        CategoryEntity categoryEntity = this.mCategoryEntity;
        if (categoryEntity == null || !ch.c(this.mCategoryPerformBean, categoryEntity)) {
            return;
        }
        this.mRecyclerView.scrollToPosition(this.mCategoryEntity.index);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "617401807") ? ((Integer) ipChange.ipc$dispatch("617401807", new Object[]{this})).intValue() : R$layout.category_detail_activity;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "36807454")) {
            ipChange.ipc$dispatch("36807454", new Object[]{this});
            return;
        }
        super.initView();
        initBundle();
        initCategory();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "458664763")) {
            ipChange.ipc$dispatch("458664763", new Object[]{this});
        } else {
            close();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1560206851")) {
            return (String) ipChange.ipc$dispatch("1560206851", new Object[]{this});
        }
        return null;
    }
}
