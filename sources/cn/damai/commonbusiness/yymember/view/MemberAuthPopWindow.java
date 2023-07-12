package cn.damai.commonbusiness.yymember.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$anim;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.yymember.bean.AuthOnekeybindInfo;
import cn.damai.commonbusiness.yymember.bean.MemberAuthBean;
import cn.damai.commonbusiness.yymember.request.YYMemberAuthRequest;
import cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow;
import cn.damai.commonbusiness.yymember.view.MemberDamaiAuthView;
import cn.damai.tetris.page.CdnRequestUtil;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.C9796v;
import tb.b23;
import tb.b41;
import tb.j23;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class MemberAuthPopWindow extends PopupWindow {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity activity;
    @NotNull
    private final String authPPDmOnline;
    @NotNull
    private final String authPPDmPre;
    private long damaiShowEndTime;
    private long damaiShowStartTime;
    private MemberDamaiAuthView dmAuth;
    @Nullable
    private ICustomDialogEventListener eventListener;
    @NotNull
    private HandlerC0989a handler;
    private Context mContext;
    @NotNull
    private String pageSource;
    @NotNull
    private MemberDamaiAuthView.IMemberPopEventListener popEventListener;
    private View popView;
    private MemberDamaiAuthView ppAuth;
    private long tppShowEndTime;
    private long tppShowStartTime;
    private View viewParent;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface ICustomDialogEventListener {
        void dialogItemEvent(@Nullable String str);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow$a */
    /* loaded from: classes.dex */
    public final class HandlerC0989a extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        public HandlerC0989a() {
        }

        @Override // android.os.Handler
        public void dispatchMessage(@NotNull Message message) {
            String str;
            MemberAuthBean memberAuthBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-301249068")) {
                ipChange.ipc$dispatch("-301249068", new Object[]{this, message});
                return;
            }
            b41.i(message, "msg");
            super.dispatchMessage(message);
            Activity activity = MemberAuthPopWindow.this.activity;
            MemberDamaiAuthView memberDamaiAuthView = null;
            if (activity == null) {
                b41.A("activity");
                activity = null;
            }
            DamaiBaseActivity damaiBaseActivity = activity instanceof DamaiBaseActivity ? (DamaiBaseActivity) activity : null;
            if (damaiBaseActivity != null) {
                damaiBaseActivity.stopProgressDialog();
            }
            if (message.what == 1) {
                Object obj = message.obj;
                if (obj != null) {
                    b41.g(obj, "null cannot be cast to non-null type kotlin.String");
                    str = (String) obj;
                } else {
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    ToastUtil.i("麦麦开小差了，请稍后重试哦");
                    MemberAuthPopWindow.this.dismiss();
                    b23.a("", "-7103", "会员授权请求cdn失败-返回null");
                    return;
                }
                try {
                    memberAuthBean = (MemberAuthBean) JSON.parseObject(str, MemberAuthBean.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    memberAuthBean = null;
                }
                if ((memberAuthBean != null ? memberAuthBean.quickAuthModal : null) != null) {
                    MemberAuthBean.QuickAuthModel quickAuthModel = memberAuthBean.quickAuthModal;
                    if (quickAuthModel.dmToTpp != null && quickAuthModel.tppToDm != null) {
                        MemberDamaiAuthView memberDamaiAuthView2 = MemberAuthPopWindow.this.dmAuth;
                        if (memberDamaiAuthView2 == null) {
                            b41.A("dmAuth");
                            memberDamaiAuthView2 = null;
                        }
                        memberDamaiAuthView2.setVisibility(0);
                        MemberAuthPopWindow.this.damaiShowStartTime = System.currentTimeMillis();
                        MemberAuthBean.AuthProtocol authProtocol = memberAuthBean.quickAuthModal.dmToTpp;
                        authProtocol.type = MemberDamaiAuthView.DM_AUTH;
                        authProtocol.pageSource = MemberAuthPopWindow.this.pageSource;
                        MemberAuthBean.AuthProtocol authProtocol2 = memberAuthBean.quickAuthModal.tppToDm;
                        authProtocol2.type = MemberDamaiAuthView.PP_AUTH;
                        authProtocol2.pageSource = MemberAuthPopWindow.this.pageSource;
                        MemberDamaiAuthView memberDamaiAuthView3 = MemberAuthPopWindow.this.dmAuth;
                        if (memberDamaiAuthView3 == null) {
                            b41.A("dmAuth");
                            memberDamaiAuthView3 = null;
                        }
                        MemberAuthBean.AuthProtocol authProtocol3 = memberAuthBean.quickAuthModal.dmToTpp;
                        b41.h(authProtocol3, "response.quickAuthModal.dmToTpp");
                        memberDamaiAuthView3.updateData(authProtocol3);
                        MemberDamaiAuthView memberDamaiAuthView4 = MemberAuthPopWindow.this.ppAuth;
                        if (memberDamaiAuthView4 == null) {
                            b41.A("ppAuth");
                        } else {
                            memberDamaiAuthView = memberDamaiAuthView4;
                        }
                        MemberAuthBean.AuthProtocol authProtocol4 = memberAuthBean.quickAuthModal.tppToDm;
                        b41.h(authProtocol4, "response.quickAuthModal.tppToDm");
                        memberDamaiAuthView.updateData(authProtocol4);
                        return;
                    }
                }
                ToastUtil.i("麦麦开小差了，请稍后重试哦");
                MemberAuthPopWindow.this.dismiss();
                b23.a(str, "-7103", "会员授权请求cdn失败-json解析失败");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow$b  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class animationAnimation$AnimationListenerC0990b implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;

        animationAnimation$AnimationListenerC0990b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "72133308")) {
                ipChange.ipc$dispatch("72133308", new Object[]{this, animation});
                return;
            }
            b41.i(animation, C9796v.TAK_ABILITY_SHOW_POP_ANIMATION);
            MemberAuthPopWindow.this.callSuperDismiss();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "927124280")) {
                ipChange.ipc$dispatch("927124280", new Object[]{this, animation});
            } else {
                b41.i(animation, C9796v.TAK_ABILITY_SHOW_POP_ANIMATION);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-904167659")) {
                ipChange.ipc$dispatch("-904167659", new Object[]{this, animation});
            } else {
                b41.i(animation, C9796v.TAK_ABILITY_SHOW_POP_ANIMATION);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow$c */
    /* loaded from: classes.dex */
    public static final class C0991c implements MemberDamaiAuthView.IMemberPopEventListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0991c() {
        }

        @Override // cn.damai.commonbusiness.yymember.view.MemberDamaiAuthView.IMemberPopEventListener
        public void dmAgree() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "814206917")) {
                ipChange.ipc$dispatch("814206917", new Object[]{this});
                return;
            }
            MemberAuthPopWindow.this.damaiShowEndTime = System.currentTimeMillis();
            MemberDamaiAuthView memberDamaiAuthView = MemberAuthPopWindow.this.dmAuth;
            MemberDamaiAuthView memberDamaiAuthView2 = null;
            if (memberDamaiAuthView == null) {
                b41.A("dmAuth");
                memberDamaiAuthView = null;
            }
            memberDamaiAuthView.setVisibility(8);
            MemberAuthPopWindow.this.tppShowStartTime = System.currentTimeMillis();
            MemberDamaiAuthView memberDamaiAuthView3 = MemberAuthPopWindow.this.ppAuth;
            if (memberDamaiAuthView3 == null) {
                b41.A("ppAuth");
            } else {
                memberDamaiAuthView2 = memberDamaiAuthView3;
            }
            memberDamaiAuthView2.setVisibility(0);
            C0529c.e().x(j23.Companion.a().h(MemberAuthPopWindow.this.pageSource, MemberDamaiAuthView.DM_AUTH_UT_MODULE, "agree"));
        }

        @Override // cn.damai.commonbusiness.yymember.view.MemberDamaiAuthView.IMemberPopEventListener
        public void popDismiss() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1277906473")) {
                ipChange.ipc$dispatch("1277906473", new Object[]{this});
            } else {
                MemberAuthPopWindow.this.dismiss();
            }
        }

        @Override // cn.damai.commonbusiness.yymember.view.MemberDamaiAuthView.IMemberPopEventListener
        public void tppAgree() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1457289622")) {
                ipChange.ipc$dispatch("-1457289622", new Object[]{this});
                return;
            }
            C0529c.e().x(j23.Companion.a().h(MemberAuthPopWindow.this.pageSource, MemberDamaiAuthView.PP_AUTH_UT_MODULE, "confirm"));
            MemberAuthPopWindow.this.oneKeyAuthRequest();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberAuthPopWindow(@NotNull Context context, @NotNull View view, @NotNull Activity activity) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(view, "viewParent");
        b41.i(activity, "activity");
        this.authPPDmPre = "https://pre-wormhole.tmall.com/wh/fragment/taopiaopiao/default/mdmas";
        this.authPPDmOnline = "https://pages.taopiaopiao.com/wh/fragment/taopiaopiao/default/mdmas?wh_biz=tm&wh_ttid=pc";
        this.handler = new HandlerC0989a();
        this.pageSource = "AuthPopWindow";
        this.popEventListener = new C0991c();
        init(context, view, activity);
        initData();
        View view2 = this.popView;
        if (view2 == null) {
            b41.A("popView");
            view2 = null;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: tb.ee1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                MemberAuthPopWindow.m27_init_$lambda0(MemberAuthPopWindow.this, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m27_init_$lambda0(MemberAuthPopWindow memberAuthPopWindow, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "624286912")) {
            ipChange.ipc$dispatch("624286912", new Object[]{memberAuthPopWindow, view});
            return;
        }
        b41.i(memberAuthPopWindow, "this$0");
        memberAuthPopWindow.dismiss();
    }

    private final void init(Context context, View view, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1122470710")) {
            ipChange.ipc$dispatch("-1122470710", new Object[]{this, context, view, activity});
            return;
        }
        this.mContext = context;
        this.activity = activity;
        this.viewParent = view;
        View view2 = null;
        View inflate = LayoutInflater.from(context).inflate(R$layout.commonbusiness_member_auth_pop_layout, (ViewGroup) null);
        b41.h(inflate, "from(context)\n          …er_auth_pop_layout, null)");
        this.popView = inflate;
        View findViewById = inflate.findViewById(R$id.member_damai_auth);
        b41.h(findViewById, "customView.findViewById(R.id.member_damai_auth)");
        this.dmAuth = (MemberDamaiAuthView) findViewById;
        View findViewById2 = inflate.findViewById(R$id.member_taopiaopiao_auth);
        b41.h(findViewById2, "customView.findViewById(….member_taopiaopiao_auth)");
        this.ppAuth = (MemberDamaiAuthView) findViewById2;
        MemberDamaiAuthView memberDamaiAuthView = this.dmAuth;
        if (memberDamaiAuthView == null) {
            b41.A("dmAuth");
            memberDamaiAuthView = null;
        }
        memberDamaiAuthView.setPopEventListener(this.popEventListener);
        MemberDamaiAuthView memberDamaiAuthView2 = this.ppAuth;
        if (memberDamaiAuthView2 == null) {
            b41.A("ppAuth");
            memberDamaiAuthView2 = null;
        }
        memberDamaiAuthView2.setPopEventListener(this.popEventListener);
        setBackgroundDrawable(new ColorDrawable(Color.parseColor("#99000000")));
        View view3 = this.popView;
        if (view3 == null) {
            b41.A("popView");
        } else {
            view2 = view3;
        }
        setContentView(view2);
        setFocusable(true);
        setOutsideTouchable(true);
        update();
        setWidth(-1);
        setHeight(-1);
    }

    private final void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1098811420")) {
            ipChange.ipc$dispatch("-1098811420", new Object[]{this});
            return;
        }
        Activity activity = this.activity;
        if (activity == null) {
            b41.A("activity");
            activity = null;
        }
        DamaiBaseActivity damaiBaseActivity = activity instanceof DamaiBaseActivity ? (DamaiBaseActivity) activity : null;
        if (damaiBaseActivity != null) {
            damaiBaseActivity.startProgressDialog();
        }
        final String str = AppConfig.g() == AppConfig.EnvMode.prepare ? this.authPPDmPre : this.authPPDmOnline;
        final CdnRequestUtil cdnRequestUtil = new CdnRequestUtil();
        new Thread(new Runnable() { // from class: tb.fe1
            @Override // java.lang.Runnable
            public final void run() {
                MemberAuthPopWindow.m28initData$lambda2(CdnRequestUtil.this, str, this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initData$lambda-2  reason: not valid java name */
    public static final void m28initData$lambda2(CdnRequestUtil cdnRequestUtil, String str, MemberAuthPopWindow memberAuthPopWindow) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1289105580")) {
            ipChange.ipc$dispatch("-1289105580", new Object[]{cdnRequestUtil, str, memberAuthPopWindow});
            return;
        }
        b41.i(cdnRequestUtil, "$cdnRequestUtil");
        b41.i(str, "$url");
        b41.i(memberAuthPopWindow, "this$0");
        Message message = new Message();
        message.what = 1;
        message.obj = cdnRequestUtil.b(str);
        memberAuthPopWindow.handler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oneKeyAuthRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1598465186")) {
            ipChange.ipc$dispatch("-1598465186", new Object[]{this});
            return;
        }
        YYMemberAuthRequest yYMemberAuthRequest = new YYMemberAuthRequest();
        Activity activity = this.activity;
        if (activity == null) {
            b41.A("activity");
            activity = null;
        }
        DamaiBaseActivity damaiBaseActivity = activity instanceof DamaiBaseActivity ? (DamaiBaseActivity) activity : null;
        if (damaiBaseActivity != null) {
            damaiBaseActivity.startProgressDialog();
        }
        yYMemberAuthRequest.request(new DMMtopRequestListener<AuthOnekeybindInfo>(AuthOnekeybindInfo.class) { // from class: cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow$oneKeyAuthRequest$2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(@NotNull String str, @NotNull String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2007178003")) {
                    ipChange2.ipc$dispatch("-2007178003", new Object[]{this, str, str2});
                    return;
                }
                b41.i(str, "s");
                b41.i(str2, "s1");
                Activity activity2 = MemberAuthPopWindow.this.activity;
                if (activity2 == null) {
                    b41.A("activity");
                    activity2 = null;
                }
                DamaiBaseActivity damaiBaseActivity2 = activity2 instanceof DamaiBaseActivity ? (DamaiBaseActivity) activity2 : null;
                if (damaiBaseActivity2 != null) {
                    damaiBaseActivity2.stopProgressDialog();
                }
                ToastUtil.f(str2);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(@Nullable AuthOnekeybindInfo authOnekeybindInfo) {
                MemberAuthPopWindow.ICustomDialogEventListener iCustomDialogEventListener;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "884819232")) {
                    ipChange2.ipc$dispatch("884819232", new Object[]{this, authOnekeybindInfo});
                    return;
                }
                Activity activity2 = MemberAuthPopWindow.this.activity;
                if (activity2 == null) {
                    b41.A("activity");
                    activity2 = null;
                }
                DamaiBaseActivity damaiBaseActivity2 = activity2 instanceof DamaiBaseActivity ? (DamaiBaseActivity) activity2 : null;
                if (damaiBaseActivity2 != null) {
                    damaiBaseActivity2.stopProgressDialog();
                }
                if (authOnekeybindInfo != null) {
                    if (b41.d("0", authOnekeybindInfo.returnCode)) {
                        MemberAuthPopWindow.this.dismiss();
                        iCustomDialogEventListener = MemberAuthPopWindow.this.eventListener;
                        if (iCustomDialogEventListener != null) {
                            iCustomDialogEventListener.dialogItemEvent("success");
                        }
                        ToastUtil.f("授权成功");
                        return;
                    }
                    String str = authOnekeybindInfo.returnMessage;
                    if (str != null) {
                        ToastUtil.f(str);
                        return;
                    }
                    return;
                }
                ToastUtil.f("麦麦开小差了，请稍后重试哦");
            }
        });
    }

    public final void callSuperDismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1462619439")) {
            ipChange.ipc$dispatch("-1462619439", new Object[]{this});
        } else {
            super.dismiss();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-861615102")) {
            ipChange.ipc$dispatch("-861615102", new Object[]{this});
            return;
        }
        MemberDamaiAuthView memberDamaiAuthView = this.ppAuth;
        View view = null;
        if (memberDamaiAuthView == null) {
            b41.A("ppAuth");
            memberDamaiAuthView = null;
        }
        if (memberDamaiAuthView.getVisibility() == 0) {
            this.tppShowEndTime = System.currentTimeMillis();
            j23.C9296a c9296a = j23.Companion;
            c9296a.a().g(this.pageSource, this.damaiShowStartTime, this.damaiShowEndTime, MemberDamaiAuthView.DM_AUTH_UT_MODULE, "agree");
            c9296a.a().g(this.pageSource, this.tppShowStartTime, this.tppShowEndTime, MemberDamaiAuthView.PP_AUTH_UT_MODULE, "confirm");
        } else {
            this.damaiShowEndTime = System.currentTimeMillis();
            j23.Companion.a().g(this.pageSource, this.damaiShowStartTime, this.damaiShowEndTime, MemberDamaiAuthView.DM_AUTH_UT_MODULE, "agree");
        }
        ICustomDialogEventListener iCustomDialogEventListener = this.eventListener;
        if (iCustomDialogEventListener != null) {
            iCustomDialogEventListener.dialogItemEvent("dismiss");
        }
        if (Build.VERSION.SDK_INT == 16) {
            callSuperDismiss();
            return;
        }
        Context context = this.mContext;
        if (context == null) {
            b41.A("mContext");
            context = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R$anim.push_top_out_500);
        loadAnimation.setAnimationListener(new animationAnimation$AnimationListenerC0990b());
        View view2 = this.popView;
        if (view2 == null) {
            b41.A("popView");
        } else {
            view = view2;
        }
        view.startAnimation(loadAnimation);
    }

    public final void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1042648593")) {
            ipChange.ipc$dispatch("1042648593", new Object[]{this});
        } else {
            this.handler.removeCallbacksAndMessages(null);
        }
    }

    public final void setEventListener(@Nullable ICustomDialogEventListener iCustomDialogEventListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1964405650")) {
            ipChange.ipc$dispatch("1964405650", new Object[]{this, iCustomDialogEventListener});
        } else {
            this.eventListener = iCustomDialogEventListener;
        }
    }

    public final void setPageSource(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "410525258")) {
            ipChange.ipc$dispatch("410525258", new Object[]{this, str});
            return;
        }
        b41.i(str, "pageSourceName");
        this.pageSource = str;
    }

    public final void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1881197727")) {
            ipChange.ipc$dispatch("-1881197727", new Object[]{this});
            return;
        }
        View view = this.viewParent;
        View view2 = null;
        if (view == null) {
            b41.A("viewParent");
            view = null;
        }
        showAtLocation(view, 80, 0, 0);
        Context context = this.mContext;
        if (context == null) {
            b41.A("mContext");
            context = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R$anim.push_bottom_out_500);
        View view3 = this.popView;
        if (view3 == null) {
            b41.A("popView");
        } else {
            view2 = view3;
        }
        view2.startAnimation(loadAnimation);
    }
}
