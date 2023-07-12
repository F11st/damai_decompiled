package cn.damai.ticklet.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.member.R$color;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.ui.activity.TicketDeatilActivity;
import cn.damai.ticklet.ui.observer.Observer;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.kg2;
import tb.py2;
import tb.un2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletDetailHeader extends LinearLayout implements View.OnClickListener, Observer {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int REQUEST_PUSH_OPEN = 100;
    public static final int TEANSFER_PAGE_REQUEST_CODE = 101;
    Context context;
    private TicketDeatilResult deatilResult;
    DMIconFontTextView iftv_back;
    View partent;
    View status_bar_gap;
    TextView title;
    TextView tvRule;

    public TickletDetailHeader(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1499955174")) {
            ipChange.ipc$dispatch("1499955174", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_deatil_header, this);
        this.partent = inflate;
        this.status_bar_gap = inflate.findViewById(R$id.status_bar_gap);
        this.iftv_back = (DMIconFontTextView) this.partent.findViewById(R$id.iftv_back);
        this.title = (TextView) this.partent.findViewById(R$id.ticklet_detail_title);
        this.tvRule = (TextView) this.partent.findViewById(R$id.ticklet_rule_text_url);
        this.iftv_back.setOnClickListener(this);
        this.tvRule.setOnClickListener(this);
        fixStatusBar(false);
    }

    public void fixStatusBar(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-536177275")) {
            ipChange.ipc$dispatch("-536177275", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            View view = this.status_bar_gap;
            if (view != null) {
                view.getLayoutParams().height = kg2.a((Activity) this.context);
                this.status_bar_gap.setVisibility(0);
                Context context = this.context;
                if (context != null && (context instanceof TicketDeatilActivity)) {
                    ((TicketDeatilActivity) context).setBarStatusBarHeight(this.status_bar_gap.getLayoutParams().height);
                }
            }
            kg2.f((Activity) this.context, true, z ? R$color.black : R$color.white);
            kg2.e((Activity) this.context);
        } else {
            kg2.f((Activity) this.context, false, z ? R$color.black : R$color.white);
            View view2 = this.status_bar_gap;
            if (view2 != null) {
                view2.setVisibility(8);
                Context context2 = this.context;
                if (context2 != null && (context2 instanceof TicketDeatilActivity)) {
                    ((TicketDeatilActivity) context2).setBarStatusBarHeight(0);
                }
            }
        }
        if (z) {
            this.title.setTextColor(Color.parseColor("#000000"));
            this.iftv_back.setTextColor(Color.parseColor("#000000"));
            return;
        }
        this.title.setTextColor(Color.parseColor("#ffffff"));
        this.iftv_back.setTextColor(Color.parseColor("#ffffff"));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-633029556")) {
            ipChange.ipc$dispatch("-633029556", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.iftv_back) {
            Context context = this.context;
            if (context == null || !(context instanceof TicketDeatilActivity)) {
                return;
            }
            ((TicketDeatilActivity) context).onBackPresss();
        } else if (id != R$id.ticklet_rule_text_url || this.context == null || this.deatilResult.getPerformNftExtAttr() == null) {
        } else {
            String str = this.deatilResult.getPerformNftExtAttr().nftRuleUrl;
            c.e().x(b.getInstance().e(un2.TICKLET_DETAIL_PAGE, "top", "nft_rule", new HashMap(), Boolean.TRUE));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            DMNav.from(this.context).toUri(str);
        }
    }

    @Override // cn.damai.ticklet.ui.observer.Observer
    public void update(TicketDeatilResult ticketDeatilResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1299355022")) {
            ipChange.ipc$dispatch("1299355022", new Object[]{this, ticketDeatilResult});
        } else if (ticketDeatilResult != null) {
            this.deatilResult = ticketDeatilResult;
            if (!TextUtils.isEmpty(ticketDeatilResult.getPerformDetailTitle())) {
                this.title.setText(ticketDeatilResult.getPerformDetailTitle());
            } else {
                this.title.setText("票详情");
            }
            if (ticketDeatilResult.isNftPerform() && this.deatilResult.getPerformNftExtAttr() != null && !TextUtils.isEmpty(this.deatilResult.getPerformNftExtAttr().nftRuleUrl)) {
                py2.G(this.tvRule);
            } else {
                py2.w(this.tvRule);
            }
        }
    }

    public TickletDetailHeader(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletDetailHeader(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        setOrientation(1);
        initView();
    }
}
