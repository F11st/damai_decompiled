package cn.damai.issue.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.common.nav.DMNav;
import cn.damai.issue.view.CorrelationView;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public final class CorrelationView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String correlationId;
    @Nullable
    private String currentItemId;
    @Nullable
    private String name;
    @Nullable
    private String num;
    @Nullable
    private TextView tvCorrelationDes;
    @Nullable
    private TextView tvCorrelationRequired;
    @Nullable
    private TextView tvCorrelationTitle;
    @Nullable
    private DMIconFontTextView tvIcon;
    @NotNull
    private CorrelationType type;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CorrelationView(@NotNull Context context) {
        this(context, null, 2, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ CorrelationView(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-953342314")) {
            ipChange.ipc$dispatch("-953342314", new Object[]{this});
            return;
        }
        this.tvCorrelationDes = (TextView) findViewById(R$id.tv_correlation_des);
        this.tvCorrelationTitle = (TextView) findViewById(R$id.tv_correlation_title);
        this.tvCorrelationRequired = (TextView) findViewById(R$id.tv_correlation_required);
        this.tvIcon = (DMIconFontTextView) findViewById(R$id.tv_arrow);
    }

    private final void setClickListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1127878351")) {
            ipChange.ipc$dispatch("-1127878351", new Object[]{this});
        } else {
            setOnClickListener(new View.OnClickListener() { // from class: tb.to
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CorrelationView.m60setClickListener$lambda0(CorrelationView.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setClickListener$lambda-0  reason: not valid java name */
    public static final void m60setClickListener$lambda0(CorrelationView correlationView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2008977450")) {
            ipChange.ipc$dispatch("2008977450", new Object[]{correlationView, view});
            return;
        }
        b41.i(correlationView, "this$0");
        StringBuilder sb = new StringBuilder();
        sb.append("damai://V1/ScriptSelect");
        CorrelationType correlationType = correlationView.type;
        CorrelationType correlationType2 = CorrelationType.STORE;
        if (correlationType == correlationType2) {
            sb.append("?pageType=" + correlationType2.getType());
        } else {
            CorrelationType correlationType3 = CorrelationType.SCRIPT;
            if (correlationType == correlationType3) {
                sb.append("?pageType=" + correlationType3.getType());
            }
        }
        sb.append("&targetId=" + correlationView.currentItemId);
        if (correlationView.correlationId != null) {
            sb.append("&selectedId=" + correlationView.correlationId);
        }
        DMNav.from(correlationView.getContext()).forResult(105).toUri(sb.toString());
    }

    public static /* synthetic */ void setDefaultData$default(CorrelationView correlationView, String str, CorrelationType correlationType, String str2, Boolean bool, int i, Object obj) {
        if ((i & 8) != 0) {
            bool = null;
        }
        correlationView.setDefaultData(str, correlationType, str2, bool);
    }

    @Nullable
    public final String getCorrelationId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "223898748") ? (String) ipChange.ipc$dispatch("223898748", new Object[]{this}) : this.correlationId;
    }

    @Nullable
    public final String getCurrentItemId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1653513306") ? (String) ipChange.ipc$dispatch("-1653513306", new Object[]{this}) : this.currentItemId;
    }

    @Nullable
    public final String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1694179682") ? (String) ipChange.ipc$dispatch("1694179682", new Object[]{this}) : this.name;
    }

    @Nullable
    public final String getNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-582994875") ? (String) ipChange.ipc$dispatch("-582994875", new Object[]{this}) : this.num;
    }

    @Nullable
    public final TextView getTvCorrelationDes() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "858081099") ? (TextView) ipChange.ipc$dispatch("858081099", new Object[]{this}) : this.tvCorrelationDes;
    }

    @Nullable
    public final TextView getTvCorrelationRequired() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "732077238") ? (TextView) ipChange.ipc$dispatch("732077238", new Object[]{this}) : this.tvCorrelationRequired;
    }

    @Nullable
    public final TextView getTvCorrelationTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-948285371") ? (TextView) ipChange.ipc$dispatch("-948285371", new Object[]{this}) : this.tvCorrelationTitle;
    }

    @Nullable
    public final DMIconFontTextView getTvIcon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1645684437") ? (DMIconFontTextView) ipChange.ipc$dispatch("1645684437", new Object[]{this}) : this.tvIcon;
    }

    @NotNull
    public final CorrelationType getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "254697565") ? (CorrelationType) ipChange.ipc$dispatch("254697565", new Object[]{this}) : this.type;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void restore() {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.issue.view.CorrelationView.$ipChange
            java.lang.String r1 = "-1047218095"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L14
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r5
            r0.ipc$dispatch(r1, r2)
            return
        L14:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r5.num
            r0.append(r1)
            cn.damai.issue.view.CorrelationType r1 = r5.type
            java.lang.String r1 = r1.getDes()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = r5.num
            java.lang.String r2 = "0"
            boolean r1 = tb.b41.d(r1, r2)
            if (r1 != 0) goto L4a
            java.lang.String r1 = r5.num
            if (r1 == 0) goto L42
            int r1 = r1.length()
            if (r1 != 0) goto L40
            goto L42
        L40:
            r1 = 0
            goto L43
        L42:
            r1 = 1
        L43:
            if (r1 == 0) goto L46
            goto L4a
        L46:
            r5.setClickable(r3)
            goto L53
        L4a:
            cn.damai.issue.view.CorrelationType r0 = r5.type
            java.lang.String r0 = r0.getNullDes()
            r5.setClickable(r4)
        L53:
            cn.damai.uikit.iconfont.DMIconFontTextView r1 = r5.tvIcon
            if (r1 != 0) goto L58
            goto L64
        L58:
            boolean r2 = r5.isClickable()
            if (r2 == 0) goto L5f
            goto L61
        L5f:
            r4 = 8
        L61:
            r1.setVisibility(r4)
        L64:
            android.widget.TextView r1 = r5.tvCorrelationDes
            if (r1 != 0) goto L69
            goto L6c
        L69:
            r1.setText(r0)
        L6c:
            android.widget.TextView r0 = r5.tvCorrelationDes
            if (r0 == 0) goto L79
            java.lang.String r1 = "#9C9CA5"
            int r1 = android.graphics.Color.parseColor(r1)
            r0.setTextColor(r1)
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.issue.view.CorrelationView.restore():void");
    }

    public final void setCorrelationId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "777230202")) {
            ipChange.ipc$dispatch("777230202", new Object[]{this, str});
        } else {
            this.correlationId = str;
        }
    }

    public final void setCurrentItemId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1587968624")) {
            ipChange.ipc$dispatch("-1587968624", new Object[]{this, str});
        } else {
            this.currentItemId = str;
        }
    }

    public final void setDefaultData(@Nullable String str, @NotNull CorrelationType correlationType, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-332428132")) {
            ipChange.ipc$dispatch("-332428132", new Object[]{this, str, correlationType, str2});
            return;
        }
        b41.i(correlationType, "type");
        setDefaultData(str, correlationType, str2, null);
    }

    public final void setName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "687205820")) {
            ipChange.ipc$dispatch("687205820", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    public final void setNum(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "525576145")) {
            ipChange.ipc$dispatch("525576145", new Object[]{this, str});
        } else {
            this.num = str;
        }
    }

    public final void setSelectData(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1459729899")) {
            ipChange.ipc$dispatch("1459729899", new Object[]{this, str, str2});
            return;
        }
        this.correlationId = str;
        this.name = str2;
        if (str == null || str.length() == 0) {
            return;
        }
        if (str2 != null && str2.length() != 0) {
            z = false;
        }
        if (z) {
            return;
        }
        TextView textView = this.tvCorrelationDes;
        if (textView != null) {
            textView.setText(str2);
        }
        TextView textView2 = this.tvCorrelationDes;
        if (textView2 != null) {
            textView2.setTextColor(Color.parseColor(isClickable() ? "#111111" : "#9C9CA5"));
        }
    }

    public final void setTvCorrelationDes(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1492086105")) {
            ipChange.ipc$dispatch("1492086105", new Object[]{this, textView});
        } else {
            this.tvCorrelationDes = textView;
        }
    }

    public final void setTvCorrelationRequired(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "344602294")) {
            ipChange.ipc$dispatch("344602294", new Object[]{this, textView});
        } else {
            this.tvCorrelationRequired = textView;
        }
    }

    public final void setTvCorrelationTitle(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-940248929")) {
            ipChange.ipc$dispatch("-940248929", new Object[]{this, textView});
        } else {
            this.tvCorrelationTitle = textView;
        }
    }

    public final void setTvIcon(@Nullable DMIconFontTextView dMIconFontTextView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1773845519")) {
            ipChange.ipc$dispatch("1773845519", new Object[]{this, dMIconFontTextView});
        } else {
            this.tvIcon = dMIconFontTextView;
        }
    }

    public final void setType(@NotNull CorrelationType correlationType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-713450693")) {
            ipChange.ipc$dispatch("-713450693", new Object[]{this, correlationType});
            return;
        }
        b41.i(correlationType, "<set-?>");
        this.type = correlationType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CorrelationView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.type = CorrelationType.STORE;
        LayoutInflater.from(context).inflate(R$layout.correlation_view_layout, (ViewGroup) this, true);
        initView();
        setClickListener();
    }

    public final void setDefaultData(@Nullable String str, @NotNull CorrelationType correlationType, @Nullable String str2, @Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1502911183")) {
            ipChange.ipc$dispatch("-1502911183", new Object[]{this, str, correlationType, str2, bool});
            return;
        }
        b41.i(correlationType, "type");
        if (str2 == null || str2.length() == 0) {
            setVisibility(8);
        }
        this.num = str;
        this.type = correlationType;
        this.currentItemId = str2;
        String str3 = str + correlationType.getDes();
        if (bool != null) {
            setClickable(bool.booleanValue());
        } else {
            if (!b41.d(str, "0")) {
                if (!(str == null || str.length() == 0)) {
                    setClickable(true);
                }
            }
            str3 = correlationType.getNullDes();
            setClickable(false);
        }
        TextView textView = this.tvCorrelationTitle;
        if (textView != null) {
            textView.setText(correlationType.getTitle());
        }
        TextView textView2 = this.tvCorrelationTitle;
        if (textView2 != null) {
            textView2.setTextColor(isClickable() ? Color.parseColor("#111111") : Color.parseColor("#9C9CA5"));
        }
        TextView textView3 = this.tvCorrelationRequired;
        if (textView3 != null) {
            textView3.setVisibility(correlationType.getRequired() ? 8 : 0);
        }
        TextView textView4 = this.tvCorrelationDes;
        if (textView4 != null) {
            textView4.setText(str3);
        }
        TextView textView5 = this.tvCorrelationDes;
        if (textView5 != null) {
            textView5.setTextColor(Color.parseColor("#9C9CA5"));
        }
        DMIconFontTextView dMIconFontTextView = this.tvIcon;
        if (dMIconFontTextView != null) {
            dMIconFontTextView.setVisibility(isClickable() ? 0 : 8);
        }
        setVisibility(0);
    }
}
