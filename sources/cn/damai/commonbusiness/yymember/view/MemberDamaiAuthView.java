package cn.damai.commonbusiness.yymember.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.yymember.bean.MemberAuthBean;
import cn.damai.commonbusiness.yymember.view.MemberDamaiAuthView;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmOverloads;
import kotlin.text.C8604o;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cs;
import tb.j23;
import tb.jn1;
import tb.k50;
import tb.t60;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class MemberDamaiAuthView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C0992a Companion = new C0992a(null);
    @NotNull
    public static final String DM_AUTH = "dm_auth";
    @NotNull
    public static final String DM_AUTH_UT_MODULE = "popdamai";
    @NotNull
    public static final String PP_AUTH = "pp_auth";
    @NotNull
    public static final String PP_AUTH_UT_MODULE = "poptpp";
    private CheckBox cbMemberAuth;
    private DMIconFontTextView close;
    @NotNull
    private View.OnClickListener listener;
    private LinearLayout llMemberAuthProtocol;
    private LinearLayout llTppTip;
    private TextView memberAuthTip;
    @NotNull
    private String pageSource;
    @Nullable
    private IMemberPopEventListener popEventListener;
    private LinearLayout protocolInstruction;
    private RelativeLayout relativeLayout;
    private TextView tvCheckboxTip;
    private TextView tvProAgree;
    private TextView tvProCancel;
    private TextView tvProContent;
    private TextView tvTitle;
    @NotNull
    private String viewType;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface IMemberPopEventListener {
        void dmAgree();

        void popDismiss();

        void tppAgree();
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.yymember.view.MemberDamaiAuthView$a */
    /* loaded from: classes.dex */
    public static final class C0992a {
        private C0992a() {
        }

        public /* synthetic */ C0992a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.yymember.view.MemberDamaiAuthView$b */
    /* loaded from: classes.dex */
    public static final class C0993b extends ClickableSpan {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ MemberDamaiAuthView b;

        C0993b(String str, MemberDamaiAuthView memberDamaiAuthView) {
            this.a = str;
            this.b = memberDamaiAuthView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "495926579")) {
                ipChange.ipc$dispatch("495926579", new Object[]{this, view});
                return;
            }
            b41.i(view, "widget");
            Bundle bundle = new Bundle();
            bundle.putString("url", this.a);
            DMNav.from(this.b.getContext()).withExtras(bundle).toUri(NavUri.b(cs.t));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint textPaint) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2105067676")) {
                ipChange.ipc$dispatch("-2105067676", new Object[]{this, textPaint});
                return;
            }
            b41.i(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setColor(Color.parseColor("#DD7F60"));
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MemberDamaiAuthView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MemberDamaiAuthView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ MemberDamaiAuthView(Context context, AttributeSet attributeSet, int i, int i2, k50 k50Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1600892555")) {
            ipChange.ipc$dispatch("-1600892555", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.commonbusiness_member_auth_pop_view, this);
        View findViewById = inflate.findViewById(R$id.tv_member_auth_title);
        b41.g(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.tvTitle = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R$id.member_auth_right_close);
        b41.g(findViewById2, "null cannot be cast to non-null type cn.damai.uikit.iconfont.DMIconFontTextView");
        this.close = (DMIconFontTextView) findViewById2;
        View findViewById3 = inflate.findViewById(R$id.ll_member_auth_layout);
        b41.g(findViewById3, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.relativeLayout = (RelativeLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R$id.ll_tiaopiaopiao_tip);
        b41.g(findViewById4, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.llTppTip = (LinearLayout) findViewById4;
        View findViewById5 = inflate.findViewById(R$id.ll_member_auth_protocol_instruction);
        b41.g(findViewById5, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.protocolInstruction = (LinearLayout) findViewById5;
        View findViewById6 = inflate.findViewById(R$id.ll_member_auth_protocol);
        b41.g(findViewById6, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.llMemberAuthProtocol = (LinearLayout) findViewById6;
        View findViewById7 = inflate.findViewById(R$id.member_auth_tip);
        b41.g(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.memberAuthTip = (TextView) findViewById7;
        View findViewById8 = inflate.findViewById(R$id.tv_member_auth_checkbox_tip);
        b41.g(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.tvCheckboxTip = (TextView) findViewById8;
        View findViewById9 = inflate.findViewById(R$id.cb_ll_member_auth);
        b41.g(findViewById9, "null cannot be cast to non-null type android.widget.CheckBox");
        this.cbMemberAuth = (CheckBox) findViewById9;
        View findViewById10 = inflate.findViewById(R$id.tv_ll_member_pro_content);
        b41.g(findViewById10, "null cannot be cast to non-null type android.widget.TextView");
        this.tvProContent = (TextView) findViewById10;
        View findViewById11 = inflate.findViewById(R$id.tv_ll_member_pro_cancel);
        b41.g(findViewById11, "null cannot be cast to non-null type android.widget.TextView");
        this.tvProCancel = (TextView) findViewById11;
        View findViewById12 = inflate.findViewById(R$id.tv_ll_member_pro_agree);
        b41.g(findViewById12, "null cannot be cast to non-null type android.widget.TextView");
        this.tvProAgree = (TextView) findViewById12;
        CheckBox checkBox = this.cbMemberAuth;
        CheckBox checkBox2 = null;
        if (checkBox == null) {
            b41.A("cbMemberAuth");
            checkBox = null;
        }
        checkBox.setChecked(false);
        LinearLayout linearLayout = this.llMemberAuthProtocol;
        if (linearLayout == null) {
            b41.A("llMemberAuthProtocol");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: tb.ie1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemberDamaiAuthView.m29initView$lambda0(MemberDamaiAuthView.this, view);
            }
        });
        CheckBox checkBox3 = this.cbMemberAuth;
        if (checkBox3 == null) {
            b41.A("cbMemberAuth");
        } else {
            checkBox2 = checkBox3;
        }
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tb.je1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MemberDamaiAuthView.m30initView$lambda1(MemberDamaiAuthView.this, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.widget.TextView] */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m29initView$lambda0(MemberDamaiAuthView memberDamaiAuthView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1492179771")) {
            ipChange.ipc$dispatch("-1492179771", new Object[]{memberDamaiAuthView, view});
            return;
        }
        b41.i(memberDamaiAuthView, "this$0");
        CheckBox checkBox = memberDamaiAuthView.cbMemberAuth;
        CheckBox checkBox2 = null;
        if (checkBox == null) {
            b41.A("cbMemberAuth");
            checkBox = null;
        }
        if (checkBox.isChecked()) {
            CheckBox checkBox3 = memberDamaiAuthView.cbMemberAuth;
            if (checkBox3 == null) {
                b41.A("cbMemberAuth");
            } else {
                checkBox2 = checkBox3;
            }
            checkBox2.setChecked(false);
            return;
        }
        CheckBox checkBox4 = memberDamaiAuthView.cbMemberAuth;
        if (checkBox4 == null) {
            b41.A("cbMemberAuth");
            checkBox4 = null;
        }
        checkBox4.setChecked(true);
        ?? r5 = memberDamaiAuthView.tvCheckboxTip;
        if (r5 == 0) {
            b41.A("tvCheckboxTip");
        } else {
            checkBox2 = r5;
        }
        checkBox2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m30initView$lambda1(MemberDamaiAuthView memberDamaiAuthView, CompoundButton compoundButton, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "635778185")) {
            ipChange.ipc$dispatch("635778185", new Object[]{memberDamaiAuthView, compoundButton, Boolean.valueOf(z)});
            return;
        }
        b41.i(memberDamaiAuthView, "this$0");
        if (z) {
            TextView textView = memberDamaiAuthView.tvCheckboxTip;
            if (textView == null) {
                b41.A("tvCheckboxTip");
                textView = null;
            }
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listener$lambda-6  reason: not valid java name */
    public static final void m31listener$lambda6(MemberDamaiAuthView memberDamaiAuthView, View view) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1257604706")) {
            ipChange.ipc$dispatch("-1257604706", new Object[]{memberDamaiAuthView, view});
            return;
        }
        b41.i(memberDamaiAuthView, "this$0");
        int id = view.getId();
        int i = R$id.member_auth_right_close;
        if (id != i && view.getId() != R$id.tv_ll_member_pro_cancel) {
            if (view.getId() == R$id.tv_ll_member_pro_agree) {
                CheckBox checkBox = memberDamaiAuthView.cbMemberAuth;
                TextView textView = null;
                if (checkBox == null) {
                    b41.A("cbMemberAuth");
                    checkBox = null;
                }
                if (checkBox.isChecked()) {
                    if (b41.d(DM_AUTH, view.getTag())) {
                        IMemberPopEventListener iMemberPopEventListener = memberDamaiAuthView.popEventListener;
                        if (iMemberPopEventListener != null) {
                            iMemberPopEventListener.dmAgree();
                            return;
                        }
                        return;
                    }
                    IMemberPopEventListener iMemberPopEventListener2 = memberDamaiAuthView.popEventListener;
                    if (iMemberPopEventListener2 != null) {
                        iMemberPopEventListener2.tppAgree();
                        return;
                    }
                    return;
                }
                TextView textView2 = memberDamaiAuthView.tvCheckboxTip;
                if (textView2 == null) {
                    b41.A("tvCheckboxTip");
                } else {
                    textView = textView2;
                }
                textView.setVisibility(memberDamaiAuthView.getVisibility());
                return;
            }
            return;
        }
        IMemberPopEventListener iMemberPopEventListener3 = memberDamaiAuthView.popEventListener;
        if (iMemberPopEventListener3 != null) {
            iMemberPopEventListener3.popDismiss();
        }
        int id2 = view.getId();
        String str2 = PP_AUTH_UT_MODULE;
        if (id2 == i) {
            if (!b41.d(PP_AUTH, memberDamaiAuthView.viewType)) {
                str2 = DM_AUTH_UT_MODULE;
            }
            C0529c.e().x(j23.Companion.a().h(memberDamaiAuthView.pageSource, str2, "close"));
        } else if (view.getId() == R$id.tv_ll_member_pro_cancel) {
            if (b41.d(PP_AUTH, memberDamaiAuthView.viewType)) {
                str = "refuse";
            } else {
                str = "cancel";
                str2 = DM_AUTH_UT_MODULE;
            }
            C0529c.e().x(j23.Companion.a().h(memberDamaiAuthView.pageSource, str2, str));
        }
    }

    @NotNull
    public final View.OnClickListener getListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-603694881") ? (View.OnClickListener) ipChange.ipc$dispatch("-603694881", new Object[]{this}) : this.listener;
    }

    @Nullable
    public final IMemberPopEventListener getPopEventListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-230621323") ? (IMemberPopEventListener) ipChange.ipc$dispatch("-230621323", new Object[]{this}) : this.popEventListener;
    }

    public final void setListener(@NotNull View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-158531185")) {
            ipChange.ipc$dispatch("-158531185", new Object[]{this, onClickListener});
            return;
        }
        b41.i(onClickListener, "<set-?>");
        this.listener = onClickListener;
    }

    public final void setPopEventListener(@Nullable IMemberPopEventListener iMemberPopEventListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1596107817")) {
            ipChange.ipc$dispatch("-1596107817", new Object[]{this, iMemberPopEventListener});
        } else {
            this.popEventListener = iMemberPopEventListener;
        }
    }

    public final void updateData(@NotNull MemberAuthBean.AuthProtocol authProtocol) {
        boolean K;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1023620843")) {
            ipChange.ipc$dispatch("1023620843", new Object[]{this, authProtocol});
            return;
        }
        b41.i(authProtocol, "authProtocol");
        String str = authProtocol.type;
        b41.h(str, "authProtocol.type");
        this.viewType = str;
        String str2 = authProtocol.pageSource;
        b41.h(str2, "authProtocol.pageSource");
        this.pageSource = str2;
        DMIconFontTextView dMIconFontTextView = null;
        if (b41.d(DM_AUTH, this.viewType)) {
            SpannableString spannableString = new SpannableString("完成授权 (1/2）");
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#DD7F60")), 6, 7, 33);
            TextView textView = this.tvTitle;
            if (textView == null) {
                b41.A("tvTitle");
                textView = null;
            }
            textView.setText(spannableString);
            LinearLayout linearLayout = this.llTppTip;
            if (linearLayout == null) {
                b41.A("llTppTip");
                linearLayout = null;
            }
            linearLayout.setVisibility(8);
            TextView textView2 = this.tvProCancel;
            if (textView2 == null) {
                b41.A("tvProCancel");
                textView2 = null;
            }
            textView2.setText("取消");
            TextView textView3 = this.tvProAgree;
            if (textView3 == null) {
                b41.A("tvProAgree");
                textView3 = null;
            }
            textView3.setText("同意");
        } else {
            SpannableString spannableString2 = new SpannableString("完成授权 (2/2）本页面由淘票票提供");
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#DD7F60")), 6, 7, 33);
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#9c9ca5")), 10, 19, 33);
            spannableString2.setSpan(new AbsoluteSizeSpan(t60.a(getContext(), 12.0f)), spannableString2.length(), spannableString2.length(), 33);
            TextView textView4 = this.tvTitle;
            if (textView4 == null) {
                b41.A("tvTitle");
                textView4 = null;
            }
            textView4.setText(spannableString2);
            LinearLayout linearLayout2 = this.llTppTip;
            if (linearLayout2 == null) {
                b41.A("llTppTip");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(0);
            TextView textView5 = this.tvProCancel;
            if (textView5 == null) {
                b41.A("tvProCancel");
                textView5 = null;
            }
            textView5.setText("拒绝");
            TextView textView6 = this.tvProAgree;
            if (textView6 == null) {
                b41.A("tvProAgree");
                textView6 = null;
            }
            textView6.setText("确认授权");
        }
        String str3 = authProtocol.title;
        if (str3 != null) {
            K = StringsKt__StringsKt.K(str3, jn1.MUL, false, 2, null);
            if (K) {
                str3 = C8604o.z(str3, jn1.MUL, "", false, 4, null);
            }
            TextView textView7 = this.memberAuthTip;
            if (textView7 == null) {
                b41.A("memberAuthTip");
                textView7 = null;
            }
            textView7.setText(str3);
        }
        if (wh2.e(authProtocol.desc) > 0) {
            LinearLayout linearLayout3 = this.protocolInstruction;
            if (linearLayout3 == null) {
                b41.A("protocolInstruction");
                linearLayout3 = null;
            }
            linearLayout3.setVisibility(0);
            LinearLayout linearLayout4 = this.protocolInstruction;
            if (linearLayout4 == null) {
                b41.A("protocolInstruction");
                linearLayout4 = null;
            }
            linearLayout4.removeAllViews();
            int size = authProtocol.desc.size();
            for (int i = 0; i < size; i++) {
                View inflate = LayoutInflater.from(getContext()).inflate(R$layout.commonbusiness_member_auth_protocol_line, (ViewGroup) null);
                b41.h(inflate, "from(context)\n          …auth_protocol_line, null)");
                ((TextView) inflate.findViewById(R$id.tv_member_auth_protocol_desc)).setText(authProtocol.desc.get(i));
                LinearLayout linearLayout5 = this.protocolInstruction;
                if (linearLayout5 == null) {
                    b41.A("protocolInstruction");
                    linearLayout5 = null;
                }
                linearLayout5.addView(inflate);
            }
        } else {
            LinearLayout linearLayout6 = this.protocolInstruction;
            if (linearLayout6 == null) {
                b41.A("protocolInstruction");
                linearLayout6 = null;
            }
            linearLayout6.setVisibility(8);
        }
        if (wh2.e(authProtocol.protocol) > 0) {
            TextView textView8 = this.tvProContent;
            if (textView8 == null) {
                b41.A("tvProContent");
                textView8 = null;
            }
            textView8.setVisibility(0);
            StringBuilder sb = new StringBuilder();
            int size2 = authProtocol.protocol.size();
            for (int i2 = 0; i2 < size2; i2++) {
                MemberAuthBean.Protocol protocol = authProtocol.protocol.get(i2);
                if (protocol != null) {
                    if (!TextUtils.isEmpty(protocol.protocolTitle)) {
                        sb.append(protocol.protocolTitle);
                    }
                    if (!TextUtils.isEmpty(protocol.protocolName)) {
                        sb.append(protocol.protocolName);
                    }
                }
            }
            String sb2 = sb.toString();
            b41.h(sb2, "with(StringBuilder()) {\n… toString()\n            }");
            SpannableString spannableString3 = new SpannableString(sb2);
            StringBuilder sb3 = new StringBuilder();
            int size3 = authProtocol.protocol.size();
            for (int i3 = 0; i3 < size3; i3++) {
                MemberAuthBean.Protocol protocol2 = authProtocol.protocol.get(i3);
                if (protocol2 != null) {
                    if (!TextUtils.isEmpty(protocol2.protocolTitle)) {
                        sb3.append(protocol2.protocolTitle);
                    }
                    int length = sb3.length();
                    if (!TextUtils.isEmpty(protocol2.protocolName)) {
                        sb3.append(protocol2.protocolName);
                    }
                    int length2 = sb3.length();
                    C0993b c0993b = new C0993b(protocol2.protocolUrl, this);
                    spannableString3.setSpan(new StyleSpan(0), length, length2, 17);
                    spannableString3.setSpan(c0993b, length, length2, 17);
                }
            }
            TextView textView9 = this.tvProContent;
            if (textView9 == null) {
                b41.A("tvProContent");
                textView9 = null;
            }
            textView9.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView10 = this.tvProContent;
            if (textView10 == null) {
                b41.A("tvProContent");
                textView10 = null;
            }
            textView10.setHighlightColor(0);
            TextView textView11 = this.tvProContent;
            if (textView11 == null) {
                b41.A("tvProContent");
                textView11 = null;
            }
            textView11.setText(spannableString3);
        } else {
            TextView textView12 = this.tvProContent;
            if (textView12 == null) {
                b41.A("tvProContent");
                textView12 = null;
            }
            textView12.setVisibility(8);
        }
        TextView textView13 = this.tvProCancel;
        if (textView13 == null) {
            b41.A("tvProCancel");
            textView13 = null;
        }
        textView13.setOnClickListener(this.listener);
        TextView textView14 = this.tvProAgree;
        if (textView14 == null) {
            b41.A("tvProAgree");
            textView14 = null;
        }
        textView14.setOnClickListener(this.listener);
        TextView textView15 = this.tvProAgree;
        if (textView15 == null) {
            b41.A("tvProAgree");
            textView15 = null;
        }
        textView15.setTag(this.viewType);
        DMIconFontTextView dMIconFontTextView2 = this.close;
        if (dMIconFontTextView2 == null) {
            b41.A("close");
        } else {
            dMIconFontTextView = dMIconFontTextView2;
        }
        dMIconFontTextView.setOnClickListener(this.listener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MemberDamaiAuthView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.viewType = DM_AUTH;
        this.pageSource = "";
        initView();
        this.listener = new View.OnClickListener() { // from class: tb.he1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemberDamaiAuthView.m31listener$lambda6(MemberDamaiAuthView.this, view);
            }
        };
    }
}
