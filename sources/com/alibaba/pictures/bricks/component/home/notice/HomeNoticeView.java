package com.alibaba.pictures.bricks.component.home.notice;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.HomeNoticeBean;
import com.alibaba.pictures.bricks.component.home.notice.HomeNoticeContract;
import com.alibaba.pictures.bricks.component.home.notice.HomeNoticeView;
import com.alibaba.pictures.bricks.onearch.AbsView;
import com.alibaba.pictures.bricks.view.BricksIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.middlewareservice.provider.kvdata.SPProviderProxy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HomeNoticeView extends AbsView<GenericItem<ItemValue>, HomeNoticeModel, HomeNoticePresent> implements HomeNoticeContract.View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String HOMEPAGE_ANNOUNCEMENT_CONTENT = "homepage_announcement_content";
    @NotNull
    public static final String LAST_CLICK = "announcement_last_click";
    @NotNull
    public static final String REMOVE_ANNOUNCEMENT = "remove_announcement";
    @NotNull
    private static final String SHAREDPREFERENCE_NAME = "homepage_shared_preferences";
    @NotNull
    private final BricksIconFontTextView arrow;
    @NotNull
    private final TextView content;
    @NotNull
    private final View itemView;
    private final SharedPreferences sp;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        public final void a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1023745217")) {
                ipChange.ipc$dispatch("1023745217", new Object[]{this});
                return;
            }
            SharedPreferences sharedPreferences = SPProviderProxy.getSharedPreferences("homepage_announcement_content");
            if (sharedPreferences == null) {
                return;
            }
            sharedPreferences.edit().putBoolean("remove_announcement", sharedPreferences.getBoolean(HomeNoticeView.LAST_CLICK, false)).apply();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeNoticeView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
        View findViewById = view.findViewById(R$id.home_notice_content);
        b41.h(findViewById, "itemView.findViewById(R.id.home_notice_content)");
        this.content = (TextView) findViewById;
        View findViewById2 = view.findViewById(R$id.home_notice_arrow);
        b41.h(findViewById2, "itemView.findViewById(R.id.home_notice_arrow)");
        this.arrow = (BricksIconFontTextView) findViewById2;
        this.sp = SPProviderProxy.getSharedPreferences("homepage_announcement_content");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-0  reason: not valid java name */
    public static final void m147bindView$lambda0(HomeNoticeView homeNoticeView, HomeNoticeBean homeNoticeBean, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1884563431")) {
            ipChange.ipc$dispatch("-1884563431", new Object[]{homeNoticeView, homeNoticeBean, view});
            return;
        }
        b41.i(homeNoticeView, "this$0");
        b41.i(homeNoticeBean, "$bean");
        ((HomeNoticePresent) homeNoticeView.getPresenter()).onClick(homeNoticeBean);
        homeNoticeView.setLastClick(true);
    }

    private final boolean getFlag() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1935870274")) {
            return ((Boolean) ipChange.ipc$dispatch("-1935870274", new Object[]{this})).booleanValue();
        }
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean("remove_announcement", false);
    }

    private final String getOldContent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1309564876")) {
            return (String) ipChange.ipc$dispatch("1309564876", new Object[]{this});
        }
        SharedPreferences sharedPreferences = this.sp;
        return sharedPreferences == null ? "" : sharedPreferences.getString("homepage_shared_preferences", "");
    }

    private final void setFlag(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "29029478")) {
            ipChange.ipc$dispatch("29029478", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putBoolean("remove_announcement", z).apply();
    }

    private final void setLastClick(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2014133622")) {
            ipChange.ipc$dispatch("2014133622", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putBoolean(LAST_CLICK, z).apply();
    }

    private final void updateContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-57718282")) {
            ipChange.ipc$dispatch("-57718282", new Object[]{this, str});
            return;
        }
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putString("homepage_shared_preferences", str).apply();
    }

    @Override // com.alibaba.pictures.bricks.component.home.notice.HomeNoticeContract.View
    public void bindView(@NotNull final HomeNoticeBean homeNoticeBean, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-83674499")) {
            ipChange.ipc$dispatch("-83674499", new Object[]{this, homeNoticeBean, str});
            return;
        }
        b41.i(homeNoticeBean, "bean");
        this.arrow.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        String oldContent = getOldContent();
        if (b41.d(oldContent, homeNoticeBean.notice) && getFlag()) {
            this.itemView.getLayoutParams().height = 0;
            this.itemView.setVisibility(8);
        } else {
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            s60 s60Var = s60.INSTANCE;
            Context context = this.itemView.getContext();
            b41.h(context, "itemView.context");
            layoutParams.height = s60Var.b(context, 45);
            this.itemView.setVisibility(0);
            this.content.setText(homeNoticeBean.notice);
            if (!b41.d(oldContent, homeNoticeBean.notice)) {
                String str2 = homeNoticeBean.notice;
                b41.h(str2, "bean.notice");
                updateContent(str2);
                setLastClick(false);
                setFlag(false);
            }
            ((HomeNoticePresent) getPresenter()).expose(homeNoticeBean);
        }
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: tb.rx0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeNoticeView.m147bindView$lambda0(HomeNoticeView.this, homeNoticeBean, view);
            }
        });
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-428976496") ? (View) ipChange.ipc$dispatch("-428976496", new Object[]{this}) : this.itemView;
    }
}
