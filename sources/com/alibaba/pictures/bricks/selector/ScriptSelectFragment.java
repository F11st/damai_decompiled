package com.alibaba.pictures.bricks.selector;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.base.BricksBaseFragment;
import com.alibaba.pictures.bricks.orderconfirm.OnEventListener;
import com.alibaba.pictures.bricks.selector.ScriptSelectFragment;
import com.alibaba.pictures.bricks.selector.adapter.ScriptSelectAdapter;
import com.alibaba.pictures.bricks.selector.bean.ScriptSelectMo;
import com.alibaba.pictures.bricks.selector.bean.ScriptSelectResponse;
import com.alibaba.pictures.bricks.selector.request.ScriptSelectRequest;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.youku.arch.v3.util.DensityUtil;
import com.youku.arch.v3.util.DisplayUtils;
import java.util.ArrayList;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.text.C8604o;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.dc0;
import tb.k50;
import tb.rb0;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ScriptSelectFragment extends BricksBaseFragment implements OnEventListener, OnLoadMoreListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C3540a Companion = new C3540a(null);
    @NotNull
    public static final String EVENT_ID_ITEM_SELECT = "scriptItemSelect";
    @NotNull
    public static final String EXTRA_KEY_PAGE_TYPE = "pageType";
    @NotNull
    public static final String EXTRA_KEY_SELECT_ID = "selectedId";
    @NotNull
    public static final String EXTRA_KEY_TARGET_ID = "targetId";
    public static final int PAGE_TYPE_SCRIPT = 1;
    public static final int PAGE_TYPE_SHOP = 0;
    public static final int SCRIPT_SPAN_COUNT = 4;
    private static final int gridItemWidth;
    private static final int midSpace;
    private static final int sideSpace;
    @NotNull
    private final Lazy adapter$delegate;
    private View deleteBtn;
    private ViewGroup errorContainer;
    private EditText inputEditText;
    @NotNull
    private final Lazy inputMethodManager$delegate;
    private int pageNum;
    private int pageType;
    private RecyclerView recycleView;
    private SmartRefreshLayout refreshLayout;
    @NotNull
    private final Lazy selectId$delegate;
    @Nullable
    private String targetId;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.selector.ScriptSelectFragment$a */
    /* loaded from: classes7.dex */
    public static final class C3540a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C3540a() {
        }

        public /* synthetic */ C3540a(k50 k50Var) {
            this();
        }

        public final int a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "771789124") ? ((Integer) ipChange.ipc$dispatch("771789124", new Object[]{this})).intValue() : ScriptSelectFragment.gridItemWidth;
        }

        public final int b() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-773223838") ? ((Integer) ipChange.ipc$dispatch("-773223838", new Object[]{this})).intValue() : ScriptSelectFragment.sideSpace;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.selector.ScriptSelectFragment$b */
    /* loaded from: classes7.dex */
    public static final class C3541b implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        C3541b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "2001669739")) {
                ipChange.ipc$dispatch("2001669739", new Object[]{this, editable});
                return;
            }
            View view = ScriptSelectFragment.this.deleteBtn;
            if (view == null) {
                b41.A("deleteBtn");
                view = null;
            }
            if (editable != null && editable.length() != 0) {
                z = false;
            }
            view.setVisibility(z ? 8 : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "961935544")) {
                ipChange.ipc$dispatch("961935544", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1337407144")) {
                ipChange.ipc$dispatch("-1337407144", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.selector.ScriptSelectFragment$c */
    /* loaded from: classes7.dex */
    public static final class C3542c implements BricksBaseFragment.IClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C3542c() {
        }

        @Override // com.alibaba.pictures.bricks.base.BricksBaseFragment.IClickListener
        public void handleClick(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1918940622")) {
                ipChange.ipc$dispatch("-1918940622", new Object[]{this, Integer.valueOf(i)});
            } else {
                ScriptSelectFragment.this.requestSearch(true);
            }
        }
    }

    static {
        int dp2px = DensityUtil.dp2px(12.0f);
        sideSpace = dp2px;
        int dp2px2 = DensityUtil.dp2px(9.0f);
        midSpace = dp2px2;
        gridItemWidth = ((DisplayUtils.getWidthPixels() - (dp2px2 * 3)) - (dp2px * 2)) / 4;
    }

    public ScriptSelectFragment() {
        Lazy b;
        Lazy b2;
        Lazy b3;
        b = C8177b.b(new Function0<ScriptSelectAdapter>() { // from class: com.alibaba.pictures.bricks.selector.ScriptSelectFragment$adapter$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ScriptSelectAdapter invoke() {
                int i;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2029946600")) {
                    return (ScriptSelectAdapter) ipChange.ipc$dispatch("2029946600", new Object[]{this});
                }
                i = ScriptSelectFragment.this.pageType;
                return new ScriptSelectAdapter(i, ScriptSelectFragment.this);
            }
        });
        this.adapter$delegate = b;
        b2 = C8177b.b(new Function0<InputMethodManager>() { // from class: com.alibaba.pictures.bricks.selector.ScriptSelectFragment$inputMethodManager$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final InputMethodManager invoke() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2098987087")) {
                    return (InputMethodManager) ipChange.ipc$dispatch("2098987087", new Object[]{this});
                }
                Context context = ScriptSelectFragment.this.getContext();
                Object systemService = context != null ? context.getSystemService("input_method") : null;
                if (systemService instanceof InputMethodManager) {
                    return (InputMethodManager) systemService;
                }
                return null;
            }
        });
        this.inputMethodManager$delegate = b2;
        b3 = C8177b.b(new Function0<String>() { // from class: com.alibaba.pictures.bricks.selector.ScriptSelectFragment$selectId$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final String invoke() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-258212963")) {
                    return (String) ipChange.ipc$dispatch("-258212963", new Object[]{this});
                }
                Bundle arguments = ScriptSelectFragment.this.getArguments();
                if (arguments != null) {
                    return arguments.getString(ScriptSelectFragment.EXTRA_KEY_SELECT_ID);
                }
                return null;
            }
        });
        this.selectId$delegate = b3;
        this.pageNum = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScriptSelectAdapter getAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1404588450") ? (ScriptSelectAdapter) ipChange.ipc$dispatch("1404588450", new Object[]{this}) : (ScriptSelectAdapter) this.adapter$delegate.getValue();
    }

    private final InputMethodManager getInputMethodManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "786511987") ? (InputMethodManager) ipChange.ipc$dispatch("786511987", new Object[]{this}) : (InputMethodManager) this.inputMethodManager$delegate.getValue();
    }

    private final String getSelectId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1235437635") ? (String) ipChange.ipc$dispatch("1235437635", new Object[]{this}) : (String) this.selectId$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideSoftInput() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-675834580")) {
            ipChange.ipc$dispatch("-675834580", new Object[]{this});
            return;
        }
        InputMethodManager inputMethodManager = getInputMethodManager();
        if (inputMethodManager != null) {
            EditText editText = this.inputEditText;
            if (editText == null) {
                b41.A("inputEditText");
                editText = null;
            }
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    private final void initView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "190148007")) {
            ipChange.ipc$dispatch("190148007", new Object[]{this, view});
            return;
        }
        View findViewById = view.findViewById(R$id.et_keyword);
        b41.h(findViewById, "root.findViewById(R.id.et_keyword)");
        EditText editText = (EditText) findViewById;
        this.inputEditText = editText;
        SmartRefreshLayout smartRefreshLayout = null;
        if (editText == null) {
            b41.A("inputEditText");
            editText = null;
        }
        editText.setHint(this.pageType == 1 ? "搜索关键词查找关联剧本" : "搜索关键词查找关联店铺");
        View findViewById2 = view.findViewById(R$id.ll_delete);
        b41.h(findViewById2, "root.findViewById<View>(R.id.ll_delete)");
        this.deleteBtn = findViewById2;
        View findViewById3 = view.findViewById(R$id.error_container);
        b41.h(findViewById3, "root.findViewById(R.id.error_container)");
        this.errorContainer = (ViewGroup) findViewById3;
        ((TextView) view.findViewById(R$id.search_title_content)).setText(this.pageType == 1 ? "选择要关联的剧本" : "请选择要关联的店铺");
        view.findViewById(R$id.search_title_close).setOnClickListener(new View.OnClickListener() { // from class: tb.g72
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ScriptSelectFragment.m188initView$lambda0(ScriptSelectFragment.this, view2);
            }
        });
        view.findViewById(R$id.tv_cancel).setOnClickListener(new View.OnClickListener() { // from class: tb.e72
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ScriptSelectFragment.m189initView$lambda1(ScriptSelectFragment.this, view2);
            }
        });
        View view2 = this.deleteBtn;
        if (view2 == null) {
            b41.A("deleteBtn");
            view2 = null;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: tb.f72
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ScriptSelectFragment.m190initView$lambda2(ScriptSelectFragment.this, view3);
            }
        });
        EditText editText2 = this.inputEditText;
        if (editText2 == null) {
            b41.A("inputEditText");
            editText2 = null;
        }
        editText2.addTextChangedListener(new C3541b());
        EditText editText3 = this.inputEditText;
        if (editText3 == null) {
            b41.A("inputEditText");
            editText3 = null;
        }
        editText3.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: tb.h72
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean m191initView$lambda3;
                m191initView$lambda3 = ScriptSelectFragment.m191initView$lambda3(ScriptSelectFragment.this, textView, i, keyEvent);
                return m191initView$lambda3;
            }
        });
        View findViewById4 = view.findViewById(R$id.recyclerView);
        b41.h(findViewById4, "root.findViewById(R.id.recyclerView)");
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        this.recycleView = recyclerView;
        if (this.pageType == 0) {
            if (recyclerView == null) {
                b41.A("recycleView");
                recyclerView = null;
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            RecyclerView recyclerView2 = this.recycleView;
            if (recyclerView2 == null) {
                b41.A("recycleView");
                recyclerView2 = null;
            }
            recyclerView2.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.alibaba.pictures.bricks.selector.ScriptSelectFragment$initView$6
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(@NotNull Rect rect, @NotNull View view3, @NotNull RecyclerView recyclerView3, @NotNull RecyclerView.State state) {
                    ScriptSelectAdapter adapter;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1244794994")) {
                        ipChange2.ipc$dispatch("1244794994", new Object[]{this, rect, view3, recyclerView3, state});
                        return;
                    }
                    b41.i(rect, "outRect");
                    b41.i(view3, "view");
                    b41.i(recyclerView3, "parent");
                    b41.i(state, "state");
                    int childAdapterPosition = recyclerView3.getChildAdapterPosition(view3);
                    adapter = ScriptSelectFragment.this.getAdapter();
                    if (childAdapterPosition == adapter.getItemCount() - 1) {
                        rect.bottom = ScriptSelectFragment.Companion.b();
                    }
                }
            });
        } else {
            if (recyclerView == null) {
                b41.A("recycleView");
                recyclerView = null;
            }
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
            RecyclerView recyclerView3 = this.recycleView;
            if (recyclerView3 == null) {
                b41.A("recycleView");
                recyclerView3 = null;
            }
            int i = sideSpace;
            RecyclerView recyclerView4 = this.recycleView;
            if (recyclerView4 == null) {
                b41.A("recycleView");
                recyclerView4 = null;
            }
            int paddingTop = recyclerView4.getPaddingTop();
            RecyclerView recyclerView5 = this.recycleView;
            if (recyclerView5 == null) {
                b41.A("recycleView");
                recyclerView5 = null;
            }
            recyclerView3.setPadding(i, paddingTop, i, recyclerView5.getPaddingBottom());
            RecyclerView recyclerView6 = this.recycleView;
            if (recyclerView6 == null) {
                b41.A("recycleView");
                recyclerView6 = null;
            }
            recyclerView6.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.alibaba.pictures.bricks.selector.ScriptSelectFragment$initView$7
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(@NotNull Rect rect, @NotNull View view3, @NotNull RecyclerView recyclerView7, @NotNull RecyclerView.State state) {
                    int i2;
                    int i3;
                    int i4;
                    ScriptSelectAdapter adapter;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "360059187")) {
                        ipChange2.ipc$dispatch("360059187", new Object[]{this, rect, view3, recyclerView7, state});
                        return;
                    }
                    b41.i(rect, "outRect");
                    b41.i(view3, "view");
                    b41.i(recyclerView7, "parent");
                    b41.i(state, "state");
                    int childAdapterPosition = recyclerView7.getChildAdapterPosition(view3);
                    int i5 = childAdapterPosition % 4;
                    i2 = ScriptSelectFragment.midSpace;
                    rect.left = (i2 * i5) / 4;
                    i3 = ScriptSelectFragment.midSpace;
                    i4 = ScriptSelectFragment.midSpace;
                    rect.right = i3 - (((i5 + 1) * i4) / 4);
                    adapter = ScriptSelectFragment.this.getAdapter();
                    if (childAdapterPosition == adapter.getItemCount() - 1) {
                        rect.bottom = ScriptSelectFragment.Companion.b();
                    }
                }
            });
        }
        RecyclerView recyclerView7 = this.recycleView;
        if (recyclerView7 == null) {
            b41.A("recycleView");
            recyclerView7 = null;
        }
        recyclerView7.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.alibaba.pictures.bricks.selector.ScriptSelectFragment$initView$8
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView8, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-789870852")) {
                    ipChange2.ipc$dispatch("-789870852", new Object[]{this, recyclerView8, Integer.valueOf(i2)});
                    return;
                }
                b41.i(recyclerView8, "recyclerView");
                super.onScrollStateChanged(recyclerView8, i2);
                ScriptSelectFragment.this.hideSoftInput();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView8, int i2, int i3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "317089187")) {
                    ipChange2.ipc$dispatch("317089187", new Object[]{this, recyclerView8, Integer.valueOf(i2), Integer.valueOf(i3)});
                    return;
                }
                b41.i(recyclerView8, "recyclerView");
                super.onScrolled(recyclerView8, i2, i3);
            }
        });
        RecyclerView recyclerView8 = this.recycleView;
        if (recyclerView8 == null) {
            b41.A("recycleView");
            recyclerView8 = null;
        }
        recyclerView8.setAdapter(getAdapter());
        View findViewById5 = view.findViewById(R$id.refresh_layout);
        b41.h(findViewById5, "root.findViewById(R.id.refresh_layout)");
        SmartRefreshLayout smartRefreshLayout2 = (SmartRefreshLayout) findViewById5;
        this.refreshLayout = smartRefreshLayout2;
        if (smartRefreshLayout2 == null) {
            b41.A("refreshLayout");
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.setEnableLoadMore(false);
        SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
        if (smartRefreshLayout3 == null) {
            b41.A("refreshLayout");
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.setEnableRefresh(false);
        SmartRefreshLayout smartRefreshLayout4 = this.refreshLayout;
        if (smartRefreshLayout4 == null) {
            b41.A("refreshLayout");
            smartRefreshLayout4 = null;
        }
        smartRefreshLayout4.setEnableAutoLoadMore(true);
        SmartRefreshLayout smartRefreshLayout5 = this.refreshLayout;
        if (smartRefreshLayout5 == null) {
            b41.A("refreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout5;
        }
        smartRefreshLayout.setOnLoadMoreListener(this);
        requestSearch(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m188initView$lambda0(ScriptSelectFragment scriptSelectFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1349636603")) {
            ipChange.ipc$dispatch("-1349636603", new Object[]{scriptSelectFragment, view});
            return;
        }
        b41.i(scriptSelectFragment, "this$0");
        scriptSelectFragment.hideSoftInput();
        FragmentActivity activity = scriptSelectFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m189initView$lambda1(ScriptSelectFragment scriptSelectFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-566257628")) {
            ipChange.ipc$dispatch("-566257628", new Object[]{scriptSelectFragment, view});
            return;
        }
        b41.i(scriptSelectFragment, "this$0");
        scriptSelectFragment.hideSoftInput();
        FragmentActivity activity = scriptSelectFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m190initView$lambda2(ScriptSelectFragment scriptSelectFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "217121347")) {
            ipChange.ipc$dispatch("217121347", new Object[]{scriptSelectFragment, view});
            return;
        }
        b41.i(scriptSelectFragment, "this$0");
        EditText editText = scriptSelectFragment.inputEditText;
        if (editText == null) {
            b41.A("inputEditText");
            editText = null;
        }
        editText.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-3  reason: not valid java name */
    public static final boolean m191initView$lambda3(ScriptSelectFragment scriptSelectFragment, TextView textView, int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "345866289")) {
            return ((Boolean) ipChange.ipc$dispatch("345866289", new Object[]{scriptSelectFragment, textView, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        b41.i(scriptSelectFragment, "this$0");
        if (i == 3) {
            scriptSelectFragment.hideSoftInput();
            scriptSelectFragment.requestSearch(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestSearch(final boolean z) {
        CharSequence M0;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "874000673")) {
            ipChange.ipc$dispatch("874000673", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            this.pageNum = 1;
            showLoading("");
        } else {
            this.pageNum++;
        }
        final ScriptSelectRequest scriptSelectRequest = new ScriptSelectRequest();
        scriptSelectRequest.setPageIndex(this.pageNum);
        scriptSelectRequest.setPageSize(20);
        scriptSelectRequest.setQueryType(this.pageType);
        scriptSelectRequest.setSelectedId(getSelectId());
        EditText editText = this.inputEditText;
        String str = null;
        if (editText == null) {
            b41.A("inputEditText");
            editText = null;
        }
        Editable text = editText.getText();
        if (text != null) {
            b41.h(text, "text");
            M0 = StringsKt__StringsKt.M0(text);
            if (M0 != null) {
                str = M0.toString();
            }
        }
        scriptSelectRequest.setKeyword(str);
        scriptSelectRequest.setTargetId(this.targetId);
        rb0.Companion.b(scriptSelectRequest).a().doOnKTSuccess(new Function1<ScriptSelectResponse, wt2>() { // from class: com.alibaba.pictures.bricks.selector.ScriptSelectFragment$requestSearch$1
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(ScriptSelectResponse scriptSelectResponse) {
                invoke2(scriptSelectResponse);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ScriptSelectResponse scriptSelectResponse) {
                ScriptSelectAdapter adapter;
                SmartRefreshLayout smartRefreshLayout;
                SmartRefreshLayout smartRefreshLayout2;
                ViewGroup viewGroup;
                ViewGroup viewGroup2;
                SmartRefreshLayout smartRefreshLayout3;
                ScriptSelectAdapter adapter2;
                ScriptSelectAdapter adapter3;
                boolean z2;
                boolean s;
                ScriptSelectAdapter adapter4;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-483564228")) {
                    ipChange2.ipc$dispatch("-483564228", new Object[]{this, scriptSelectResponse});
                    return;
                }
                b41.i(scriptSelectResponse, "response");
                SmartRefreshLayout smartRefreshLayout4 = null;
                if (z) {
                    viewGroup = this.errorContainer;
                    if (viewGroup == null) {
                        b41.A("errorContainer");
                        viewGroup = null;
                    }
                    viewGroup.setVisibility(8);
                    ScriptSelectFragment scriptSelectFragment = this;
                    viewGroup2 = scriptSelectFragment.errorContainer;
                    if (viewGroup2 == null) {
                        b41.A("errorContainer");
                        viewGroup2 = null;
                    }
                    scriptSelectFragment.removeErrorView(viewGroup2);
                    smartRefreshLayout3 = this.refreshLayout;
                    if (smartRefreshLayout3 == null) {
                        b41.A("refreshLayout");
                        smartRefreshLayout3 = null;
                    }
                    smartRefreshLayout3.finishRefresh();
                    ArrayList<ScriptSelectMo> arrayList = new ArrayList<>();
                    adapter2 = this.getAdapter();
                    adapter2.f(scriptSelectRequest.getKeyword());
                    ScriptSelectMo selected = scriptSelectResponse.getSelected();
                    if (selected != null) {
                        adapter4 = this.getAdapter();
                        adapter4.g(selected.getTargetId());
                        arrayList.add(selected);
                    }
                    ArrayList<ScriptSelectMo> searchResultList = scriptSelectResponse.getSearchResultList();
                    if (searchResultList != null) {
                        arrayList.addAll(searchResultList);
                    }
                    adapter3 = this.getAdapter();
                    adapter3.e(arrayList);
                    if (arrayList.isEmpty()) {
                        ScriptSelectFragment scriptSelectFragment2 = this;
                        String keyword = scriptSelectRequest.getKeyword();
                        if (keyword != null) {
                            s = C8604o.s(keyword);
                            if (!s) {
                                z2 = false;
                                scriptSelectFragment2.showEmpty(true ^ z2);
                            }
                        }
                        z2 = true;
                        scriptSelectFragment2.showEmpty(true ^ z2);
                    }
                } else {
                    adapter = this.getAdapter();
                    adapter.b(scriptSelectResponse.getSearchResultList());
                    smartRefreshLayout = this.refreshLayout;
                    if (smartRefreshLayout == null) {
                        b41.A("refreshLayout");
                        smartRefreshLayout = null;
                    }
                    smartRefreshLayout.finishLoadMore();
                }
                smartRefreshLayout2 = this.refreshLayout;
                if (smartRefreshLayout2 == null) {
                    b41.A("refreshLayout");
                } else {
                    smartRefreshLayout4 = smartRefreshLayout2;
                }
                Boolean hasNext = scriptSelectResponse.getHasNext();
                smartRefreshLayout4.setEnableLoadMore(hasNext != null ? hasNext.booleanValue() : false);
            }
        }).doOnKTFail(new Function1<dc0<ScriptSelectResponse>, wt2>() { // from class: com.alibaba.pictures.bricks.selector.ScriptSelectFragment$requestSearch$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: com.alibaba.pictures.bricks.selector.ScriptSelectFragment$requestSearch$2$a */
            /* loaded from: classes7.dex */
            public static final class C3543a implements BricksBaseFragment.IClickListener {
                private static transient /* synthetic */ IpChange $ipChange;
                final /* synthetic */ ScriptSelectFragment a;

                C3543a(ScriptSelectFragment scriptSelectFragment) {
                    this.a = scriptSelectFragment;
                }

                @Override // com.alibaba.pictures.bricks.base.BricksBaseFragment.IClickListener
                public void handleClick(int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1663331079")) {
                        ipChange.ipc$dispatch("1663331079", new Object[]{this, Integer.valueOf(i)});
                    } else {
                        this.a.requestSearch(true);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(dc0<ScriptSelectResponse> dc0Var) {
                invoke2(dc0Var);
                return wt2.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v3, types: [android.view.ViewGroup] */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull dc0<ScriptSelectResponse> dc0Var) {
                SmartRefreshLayout smartRefreshLayout;
                ViewGroup viewGroup;
                ?? r3;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1578491709")) {
                    ipChange2.ipc$dispatch("1578491709", new Object[]{this, dc0Var});
                    return;
                }
                b41.i(dc0Var, AdvanceSetting.NETWORK_TYPE);
                SmartRefreshLayout smartRefreshLayout2 = null;
                if (z) {
                    viewGroup = this.errorContainer;
                    if (viewGroup == null) {
                        b41.A("errorContainer");
                        viewGroup = null;
                    }
                    viewGroup.setVisibility(0);
                    ScriptSelectFragment scriptSelectFragment = this;
                    String f = dc0Var.f();
                    String str2 = f != null ? f : "请求出错，请稍候重试";
                    String valueOf = String.valueOf(dc0Var.e());
                    r3 = this.errorContainer;
                    if (r3 == 0) {
                        b41.A("errorContainer");
                    } else {
                        smartRefreshLayout2 = r3;
                    }
                    scriptSelectFragment.showErrorView(str2, valueOf, smartRefreshLayout2, new C3543a(this));
                    return;
                }
                smartRefreshLayout = this.refreshLayout;
                if (smartRefreshLayout == null) {
                    b41.A("refreshLayout");
                } else {
                    smartRefreshLayout2 = smartRefreshLayout;
                }
                smartRefreshLayout2.finishLoadMore();
                BricksToastUtil.INSTANCE.b("请求出错，请稍候重试");
            }
        }).doOnKTFinish(new Function0<wt2>() { // from class: com.alibaba.pictures.bricks.selector.ScriptSelectFragment$requestSearch$3
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ wt2 invoke() {
                invoke2();
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1232381238")) {
                    ipChange2.ipc$dispatch("-1232381238", new Object[]{this});
                } else {
                    ScriptSelectFragment.this.hideLoading();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEmpty(boolean z) {
        ViewGroup viewGroup;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "219061594")) {
            ipChange.ipc$dispatch("219061594", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ViewGroup viewGroup2 = this.errorContainer;
        if (viewGroup2 == null) {
            b41.A("errorContainer");
            viewGroup2 = null;
        }
        viewGroup2.setVisibility(0);
        String str = z ? "没有找到符合条件的项目\n您可以减少筛选条件重新重试" : "暂无相关内容";
        ViewGroup viewGroup3 = this.errorContainer;
        if (viewGroup3 == null) {
            b41.A("errorContainer");
            viewGroup = null;
        } else {
            viewGroup = viewGroup3;
        }
        showErrorView(3, str, "", viewGroup, false, false, true, new C3542c());
    }

    private final void showSoftInput() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1461792153")) {
            ipChange.ipc$dispatch("-1461792153", new Object[]{this});
            return;
        }
        InputMethodManager inputMethodManager = getInputMethodManager();
        if (inputMethodManager != null) {
            EditText editText = this.inputEditText;
            if (editText == null) {
                b41.A("inputEditText");
                editText = null;
            }
            inputMethodManager.showSoftInput(editText, 2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1127094268")) {
            ipChange.ipc$dispatch("-1127094268", new Object[]{this, bundle});
        } else {
            super.onActivityCreated(bundle);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:
        r5 = kotlin.text.C8603n.i(r5);
     */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle r5) {
        /*
            r4 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.bricks.selector.ScriptSelectFragment.$ipChange
            java.lang.String r1 = "451998991"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            if (r2 == 0) goto L17
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            super.onCreate(r5)
            android.os.Bundle r5 = r4.getArguments()
            if (r5 == 0) goto L32
            java.lang.String r0 = "pageType"
            java.lang.String r5 = r5.getString(r0)
            if (r5 == 0) goto L32
            java.lang.Integer r5 = kotlin.text.C8596g.i(r5)
            if (r5 == 0) goto L32
            int r3 = r5.intValue()
        L32:
            r4.pageType = r3
            tb.i72 r5 = tb.i72.INSTANCE
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            r5.d(r0)
            android.os.Bundle r5 = r4.getArguments()
            if (r5 == 0) goto L4a
            java.lang.String r0 = "targetId"
            java.lang.String r5 = r5.getString(r0)
            goto L4b
        L4a:
            r5 = 0
        L4b:
            r4.targetId = r5
            if (r5 != 0) goto L5f
            com.alibaba.pictures.bricks.util.toast.BricksToastUtil r5 = com.alibaba.pictures.bricks.util.toast.BricksToastUtil.INSTANCE
            java.lang.String r0 = "必须传入关联店铺Id"
            r5.b(r0)
            androidx.fragment.app.FragmentActivity r5 = r4.getActivity()
            if (r5 == 0) goto L5f
            r5.finish()
        L5f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.selector.ScriptSelectFragment.onCreate(android.os.Bundle):void");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-933248235")) {
            return (View) ipChange.ipc$dispatch("-933248235", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        b41.i(layoutInflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.bricks_script_select_fragment, viewGroup, false);
        b41.h(inflate, "root");
        initView(inflate);
        return inflate;
    }

    @Override // com.alibaba.pictures.bricks.orderconfirm.OnEventListener
    public void onEvent(@NotNull String str, @Nullable View view, @Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "303751509")) {
            ipChange.ipc$dispatch("303751509", new Object[]{this, str, view, obj});
            return;
        }
        b41.i(str, "eventId");
        if (b41.d(str, EVENT_ID_ITEM_SELECT)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                Intent intent = new Intent();
                intent.putExtra("selectResult", obj instanceof ScriptSelectMo ? (ScriptSelectMo) obj : null);
                wt2 wt2Var = wt2.INSTANCE;
                activity.setResult(-1, intent);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
    public void onLoadMore(@NotNull RefreshLayout refreshLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1708126053")) {
            ipChange.ipc$dispatch("-1708126053", new Object[]{this, refreshLayout});
            return;
        }
        b41.i(refreshLayout, "refreshLayout");
        requestSearch(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-687676632")) {
            ipChange.ipc$dispatch("-687676632", new Object[]{this, view, bundle});
            return;
        }
        b41.i(view, "view");
        super.onViewCreated(view, bundle);
    }
}
