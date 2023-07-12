package cn.damai.ticklet.view;

import android.animation.Animator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.app.widget.ProtocolDialog;
import cn.damai.common.image.C0504a;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.common.util.toastutil.C0537a;
import cn.damai.member.R$color;
import cn.damai.member.R$dimen;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$raw;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.PerformNftExtAttr;
import cn.damai.ticklet.bean.TicketExtAttr;
import cn.damai.ticklet.bean.TicketNftExtAttr;
import cn.damai.ticklet.bean.TickletExtraInfo;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.net.PrepareIssueRequest;
import cn.damai.ticklet.view.TickletNFTTicketItemView;
import cn.damai.uikit.view.HoleCardView;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.text.C8604o;
import org.android.agoo.message.MessageService;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.e80;
import tb.k50;
import tb.py2;
import tb.qn2;
import tb.un2;
import tb.wt2;
import tb.xn2;
import tb.xr;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class TickletNFTTicketItemView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C2107a Companion = new C2107a(null);
    @NotNull
    public static final String NFT_LOADING_ACTION = "NFT_LOADING_ACTION";
    @NotNull
    public static final String NFT_RECEIVE_ACTION = "NFT_RECEIVE_ACTION";
    @JvmField
    public static boolean jumpToAuth;
    @Nullable
    private ImageView backRimIv;
    @Nullable
    private ImageView bottomIconIv;
    @Nullable
    private ImageView coverIv;
    @Nullable
    private HoleCardView holeCardView;
    @Nullable
    private View line;
    @Nullable
    private TicketNftExtAttr mNftData;
    @Nullable
    private PerformNftExtAttr mPerformData;
    @Nullable
    private String mPerformId;
    private int mPosition;
    @Nullable
    private String mProjectId;
    @Nullable
    private String mTicketStatus;
    @Nullable
    private String mVoucherUniqueKey;
    @Nullable
    private ImageView mainIconIv;
    @Nullable
    private TextView receiveBtnTv;
    @Nullable
    private ImageView sourceTypeIv;
    @Nullable
    private TextView statusDesTv;
    @Nullable
    private TextView statusTv;
    @Nullable
    private TextView titleTv;
    @Nullable
    private RelativeLayout unityContainerRl;
    @Nullable
    private TextView ycCodeTv;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.view.TickletNFTTicketItemView$a */
    /* loaded from: classes7.dex */
    public static final class C2107a {
        private C2107a() {
        }

        public /* synthetic */ C2107a(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TickletNFTTicketItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TickletNFTTicketItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ TickletNFTTicketItemView(Context context, AttributeSet attributeSet, int i, int i2, k50 k50Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void decideShowDialog(final Function0<wt2> function0) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-142259601")) {
            ipChange.ipc$dispatch("-142259601", new Object[]{this, function0});
            return;
        }
        final String str2 = "ticketNFT_" + z20.i() + '_' + this.mPerformId;
        if (!b41.d(z20.B(str2), "true")) {
            SpannableString spannableString = new SpannableString(getResources().getString(R$string.ticklet_nft_rule_content));
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R$color.color_ff2d79)), 7, spannableString.length(), 33);
            Context context = getContext();
            String string = getResources().getString(R$string.ticklet_nft_rule_tip);
            PerformNftExtAttr performNftExtAttr = this.mPerformData;
            ProtocolDialog.C(context, string, Html.fromHtml((performNftExtAttr == null || (str = performNftExtAttr.nftIssueTips) == null) ? null : C8604o.z(str, StringUtils.LF, "<br/>", false, 4, null)), spannableString, getResources().getString(R$string.ticklet_transfer_cancel_button_thought), -16777216, new DialogInterface.OnClickListener() { // from class: tb.ln2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    TickletNFTTicketItemView.m82decideShowDialog$lambda3(dialogInterface, i);
                }
            }, getResources().getString(R$string.ticklet_nft_accept), Color.parseColor("#ff2d79"), new ProtocolDialog.OnConfirmListener() { // from class: tb.pn2
                @Override // cn.damai.common.app.widget.ProtocolDialog.OnConfirmListener
                public final void onConfirmClick(boolean z, DialogInterface dialogInterface) {
                    TickletNFTTicketItemView.m83decideShowDialog$lambda5(str2, this, function0, z, dialogInterface);
                }
            }, new View.OnClickListener() { // from class: tb.mn2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TickletNFTTicketItemView.m84decideShowDialog$lambda6(TickletNFTTicketItemView.this, view);
                }
            }).show();
            return;
        }
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: decideShowDialog$lambda-3  reason: not valid java name */
    public static final void m82decideShowDialog$lambda3(DialogInterface dialogInterface, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2029653266")) {
            ipChange.ipc$dispatch("-2029653266", new Object[]{dialogInterface, Integer.valueOf(i)});
        } else {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: decideShowDialog$lambda-5  reason: not valid java name */
    public static final void m83decideShowDialog$lambda5(String str, TickletNFTTicketItemView tickletNFTTicketItemView, Function0 function0, boolean z, DialogInterface dialogInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-123802687")) {
            ipChange.ipc$dispatch("-123802687", new Object[]{str, tickletNFTTicketItemView, function0, Boolean.valueOf(z), dialogInterface});
            return;
        }
        b41.i(str, "$key");
        b41.i(tickletNFTTicketItemView, "this$0");
        b41.i(function0, "$function");
        if (z) {
            dialogInterface.dismiss();
            z20.T(str, "true");
            if (tickletNFTTicketItemView.mPerformData != null) {
                function0.invoke();
                return;
            }
            return;
        }
        ToastUtil.a().j(AppInfoProviderProxy.getApplication(), tickletNFTTicketItemView.getResources().getString(R$string.ticklet_nft_rule_toast));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: decideShowDialog$lambda-6  reason: not valid java name */
    public static final void m84decideShowDialog$lambda6(TickletNFTTicketItemView tickletNFTTicketItemView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1158543531")) {
            ipChange.ipc$dispatch("-1158543531", new Object[]{tickletNFTTicketItemView, view});
            return;
        }
        b41.i(tickletNFTTicketItemView, "this$0");
        PerformNftExtAttr performNftExtAttr = tickletNFTTicketItemView.mPerformData;
        py2.f().n(tickletNFTTicketItemView.getContext(), performNftExtAttr != null ? performNftExtAttr.nftRuleUrl : null);
    }

    private final NFTTicketStatus getStatues(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1984296297")) {
            return (NFTTicketStatus) ipChange.ipc$dispatch("1984296297", new Object[]{this, str});
        }
        NFTTicketStatus nFTTicketStatus = NFTTicketStatus.NULL;
        if (b41.d(str, nFTTicketStatus.getCode())) {
            return nFTTicketStatus;
        }
        NFTTicketStatus nFTTicketStatus2 = NFTTicketStatus.UNCLAIMED;
        if (!b41.d(str, nFTTicketStatus2.getCode())) {
            nFTTicketStatus2 = NFTTicketStatus.UNAUTHENTIC;
            if (!b41.d(str, nFTTicketStatus2.getCode())) {
                nFTTicketStatus2 = NFTTicketStatus.AUTHENTIC;
                if (!b41.d(str, nFTTicketStatus2.getCode())) {
                    nFTTicketStatus2 = NFTTicketStatus.ROLLOUTING;
                    if (!b41.d(str, nFTTicketStatus2.getCode())) {
                        nFTTicketStatus2 = NFTTicketStatus.ROLLOUT;
                        if (!b41.d(str, nFTTicketStatus2.getCode())) {
                            nFTTicketStatus2 = NFTTicketStatus.INVALID;
                            if (!b41.d(str, nFTTicketStatus2.getCode())) {
                                nFTTicketStatus2 = NFTTicketStatus.DESTROYED;
                                if (!b41.d(str, nFTTicketStatus2.getCode())) {
                                    nFTTicketStatus2 = NFTTicketStatus.EXPIRED;
                                    if (!b41.d(str, nFTTicketStatus2.getCode())) {
                                        return nFTTicketStatus;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return nFTTicketStatus2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleNFTAction(final View view, final PerformNftExtAttr performNftExtAttr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1068368822")) {
            ipChange.ipc$dispatch("1068368822", new Object[]{this, view, performNftExtAttr});
            return;
        }
        String str = performNftExtAttr.nftUserValidateStatus;
        if (str != null) {
            qn2.b(str, new Function0<wt2>() { // from class: cn.damai.ticklet.view.TickletNFTTicketItemView$handleNFTAction$1
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    String str2;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "670154128")) {
                        ipChange2.ipc$dispatch("670154128", new Object[]{this});
                        return;
                    }
                    PrepareIssueRequest prepareIssueRequest = new PrepareIssueRequest();
                    str2 = TickletNFTTicketItemView.this.mVoucherUniqueKey;
                    prepareIssueRequest.voucherUniqueKey = str2;
                    final View view2 = view;
                    final TickletNFTTicketItemView tickletNFTTicketItemView = TickletNFTTicketItemView.this;
                    prepareIssueRequest.request(new DMMtopRequestListener<TicketNftExtAttr>(TicketNftExtAttr.class) { // from class: cn.damai.ticklet.view.TickletNFTTicketItemView$handleNFTAction$1$listener$1
                        private static transient /* synthetic */ IpChange $ipChange;

                        /* compiled from: Taobao */
                        /* renamed from: cn.damai.ticklet.view.TickletNFTTicketItemView$handleNFTAction$1$listener$1$a */
                        /* loaded from: classes7.dex */
                        public static final class C2108a implements Animator.AnimatorListener {
                            private static transient /* synthetic */ IpChange $ipChange;
                            final /* synthetic */ LottieAnimationView a;
                            final /* synthetic */ TicketNftExtAttr b;
                            final /* synthetic */ TickletNFTTicketItemView c;

                            C2108a(LottieAnimationView lottieAnimationView, TicketNftExtAttr ticketNftExtAttr, TickletNFTTicketItemView tickletNFTTicketItemView) {
                                this.a = lottieAnimationView;
                                this.b = ticketNftExtAttr;
                                this.c = tickletNFTTicketItemView;
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(@Nullable Animator animator) {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "-795011604")) {
                                    ipChange.ipc$dispatch("-795011604", new Object[]{this, animator});
                                }
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(@Nullable Animator animator) {
                                int i;
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "864668867")) {
                                    ipChange.ipc$dispatch("864668867", new Object[]{this, animator});
                                    return;
                                }
                                this.a.setVisibility(8);
                                TicketNftExtAttr ticketNftExtAttr = this.b;
                                i = this.c.mPosition;
                                ticketNftExtAttr.position = i;
                                xr.c(TickletNFTTicketItemView.NFT_RECEIVE_ACTION, this.b);
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(@Nullable Animator animator) {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "1518564011")) {
                                    ipChange.ipc$dispatch("1518564011", new Object[]{this, animator});
                                }
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(@Nullable Animator animator) {
                                TicketNftExtAttr ticketNftExtAttr;
                                String str;
                                String str2;
                                IpChange ipChange = $ipChange;
                                boolean z = true;
                                if (AndroidInstantRuntime.support(ipChange, "573691228")) {
                                    ipChange.ipc$dispatch("573691228", new Object[]{this, animator});
                                    return;
                                }
                                this.a.setVisibility(0);
                                this.b.nftStatus = TickletNFTTicketItemView.NFTTicketStatus.UNAUTHENTIC.getCode();
                                TicketNftExtAttr ticketNftExtAttr2 = this.b;
                                ticketNftExtAttr = this.c.mNftData;
                                ticketNftExtAttr2.title = ticketNftExtAttr != null ? ticketNftExtAttr.title : null;
                                this.c.updateNftData(this.b);
                                if (b41.d(this.b.subContentType, "audio") || b41.d(this.b.subContentType, "video")) {
                                    String str3 = this.b.vid;
                                    if (str3 != null && str3.length() != 0) {
                                        z = false;
                                    }
                                    if (z) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(" performId:");
                                        str = this.c.mPerformId;
                                        sb.append(str);
                                        sb.append(" , voucherUniqueKey:");
                                        str2 = this.c.mVoucherUniqueKey;
                                        sb.append(str2);
                                        sb.append(" , nftYcCode:");
                                        sb.append(this.b.acSn);
                                        sb.append(" ，subContentType：");
                                        sb.append(this.b.subContentType);
                                        sb.append(' ');
                                        xn2.c(xn2.f(xn2.TICKLET_NFT_RECEIVE_SOURCE_ERROR_MSG, "mtop.damai.wireless.ticklet2.nft.prepareIssue", "", "", sb.toString()), xn2.TICKLET_NFT_RECEIVE_SOURCE_ERROR_CODE, xn2.TICKLET_NFT_RECEIVE_SOURCE_ERROR_MSG);
                                    }
                                }
                            }
                        }

                        @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                        public void onFail(@NotNull String str3, @NotNull String str4) {
                            String str5;
                            String str6;
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "1544090214")) {
                                ipChange3.ipc$dispatch("1544090214", new Object[]{this, str3, str4});
                                return;
                            }
                            b41.i(str3, "code");
                            b41.i(str4, "msg");
                            xr.c(TickletNFTTicketItemView.NFT_LOADING_ACTION, Boolean.FALSE);
                            C0537a.i(tickletNFTTicketItemView.getContext(), str4);
                            StringBuilder sb = new StringBuilder();
                            sb.append(" performId:");
                            str5 = tickletNFTTicketItemView.mPerformId;
                            sb.append(str5);
                            sb.append(" , voucherUniqueKey:");
                            str6 = tickletNFTTicketItemView.mVoucherUniqueKey;
                            sb.append(str6);
                            xn2.c(xn2.f(xn2.TICKLET_NFT_RECEIVE_ERROR_MSG, "mtop.damai.wireless.ticklet2.nft.prepareIssue", str3, str4, sb.toString()), xn2.TICKLET_NFT_RECEIVE_ERROR_CODE, xn2.TICKLET_NFT_RECEIVE_ERROR_MSG);
                        }

                        @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                        public void onSuccess(@NotNull TicketNftExtAttr ticketNftExtAttr) {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "-1747783407")) {
                                ipChange3.ipc$dispatch("-1747783407", new Object[]{this, ticketNftExtAttr});
                                return;
                            }
                            b41.i(ticketNftExtAttr, "s");
                            xr.c(TickletNFTTicketItemView.NFT_LOADING_ACTION, Boolean.FALSE);
                            LottieAnimationView lottieAnimationView = (LottieAnimationView) view2.findViewById(R$id.lav_receiver_lottie);
                            lottieAnimationView.setAnimation(R$raw.ticket_receive_lottie);
                            lottieAnimationView.addAnimatorListener(new C2108a(lottieAnimationView, ticketNftExtAttr, tickletNFTTicketItemView));
                            lottieAnimationView.playAnimation();
                        }
                    });
                    xr.c(TickletNFTTicketItemView.NFT_LOADING_ACTION, Boolean.TRUE);
                }
            }, new Function0<wt2>() { // from class: cn.damai.ticklet.view.TickletNFTTicketItemView$handleNFTAction$2
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    if (AndroidInstantRuntime.support(ipChange2, "376751121")) {
                        ipChange2.ipc$dispatch("376751121", new Object[]{this});
                        return;
                    }
                    TickletNFTTicketItemView.C2107a c2107a = TickletNFTTicketItemView.Companion;
                    TickletNFTTicketItemView.jumpToAuth = true;
                    DMNav.from(TickletNFTTicketItemView.this.getContext()).toUri(performNftExtAttr.nftAuthUrl);
                }
            }, new Function0<wt2>() { // from class: cn.damai.ticklet.view.TickletNFTTicketItemView$handleNFTAction$3
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    if (AndroidInstantRuntime.support(ipChange2, "83348114")) {
                        ipChange2.ipc$dispatch("83348114", new Object[]{this});
                    } else {
                        C0537a.i(TickletNFTTicketItemView.this.getContext(), performNftExtAttr.nftUserValidateMessage);
                    }
                }
            });
        }
    }

    private final void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2028366944")) {
            ipChange.ipc$dispatch("2028366944", new Object[]{this});
            return;
        }
        final View inflate = LayoutInflater.from(getContext()).inflate(R$layout.ticklet_ticket_nft_item, this);
        this.holeCardView = (HoleCardView) inflate.findViewById(R$id.hv_container);
        this.unityContainerRl = (RelativeLayout) inflate.findViewById(R$id.rl_unity_container);
        this.mainIconIv = (ImageView) inflate.findViewById(R$id.iv_nft_main_icon);
        this.statusTv = (TextView) inflate.findViewById(R$id.tv_nft_status);
        this.statusDesTv = (TextView) inflate.findViewById(R$id.tv_nft_status_des);
        this.receiveBtnTv = (TextView) inflate.findViewById(R$id.tv_receive_btn);
        this.coverIv = (ImageView) inflate.findViewById(R$id.iv_cover);
        this.line = inflate.findViewById(R$id.v_line);
        this.sourceTypeIv = (ImageView) inflate.findViewById(R$id.iv_source_type);
        this.ycCodeTv = (TextView) inflate.findViewById(R$id.tv_yc_code);
        this.titleTv = (TextView) inflate.findViewById(R$id.tv_title);
        this.bottomIconIv = (ImageView) inflate.findViewById(R$id.iv_bottom_icon);
        this.backRimIv = (ImageView) inflate.findViewById(R$id.iv_nft_back_rim);
        TextView textView = this.statusTv;
        TextPaint paint = textView != null ? textView.getPaint() : null;
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
        int d = e80.d() - ((int) getResources().getDimension(R$dimen.ticklet_nft_hole_site));
        ImageView imageView = this.coverIv;
        ViewGroup.LayoutParams layoutParams = imageView != null ? imageView.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = d;
        }
        HoleCardView holeCardView = this.holeCardView;
        if (holeCardView != null) {
            holeCardView.setmScallopPositionPx(d);
        }
        TextView textView2 = this.receiveBtnTv;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: tb.on2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TickletNFTTicketItemView.m85initView$lambda0(TickletNFTTicketItemView.this, inflate, view);
                }
            });
        }
        ImageView imageView2 = this.sourceTypeIv;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: tb.nn2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TickletNFTTicketItemView.m86initView$lambda2(TickletNFTTicketItemView.this, view);
                }
            });
        }
        controlVisibleByBits(NFTTicketStatus.NULL.getControlBits());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m85initView$lambda0(final TickletNFTTicketItemView tickletNFTTicketItemView, final View view, View view2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-234269109")) {
            ipChange.ipc$dispatch("-234269109", new Object[]{tickletNFTTicketItemView, view, view2});
            return;
        }
        b41.i(tickletNFTTicketItemView, "this$0");
        C0529c.e().x(un2.k().K(tickletNFTTicketItemView.mPerformId, tickletNFTTicketItemView.mProjectId, tickletNFTTicketItemView.mPosition, tickletNFTTicketItemView.mTicketStatus));
        tickletNFTTicketItemView.decideShowDialog(new Function0<wt2>() { // from class: cn.damai.ticklet.view.TickletNFTTicketItemView$initView$1$1
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                PerformNftExtAttr performNftExtAttr;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1852693528")) {
                    ipChange2.ipc$dispatch("1852693528", new Object[]{this});
                    return;
                }
                performNftExtAttr = TickletNFTTicketItemView.this.mPerformData;
                if (performNftExtAttr != null) {
                    TickletNFTTicketItemView tickletNFTTicketItemView2 = TickletNFTTicketItemView.this;
                    View view3 = view;
                    b41.h(view3, "partent");
                    tickletNFTTicketItemView2.handleNFTAction(view3, performNftExtAttr);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m86initView$lambda2(TickletNFTTicketItemView tickletNFTTicketItemView, View view) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "542544297")) {
            ipChange.ipc$dispatch("542544297", new Object[]{tickletNFTTicketItemView, view});
            return;
        }
        b41.i(tickletNFTTicketItemView, "this$0");
        TicketNftExtAttr ticketNftExtAttr = tickletNFTTicketItemView.mNftData;
        if (ticketNftExtAttr != null) {
            C0529c e = C0529c.e();
            un2 k = un2.k();
            TicketNftExtAttr ticketNftExtAttr2 = tickletNFTTicketItemView.mNftData;
            e.x(k.J(ticketNftExtAttr2 != null ? ticketNftExtAttr2.subContentType : null, tickletNFTTicketItemView.mPosition));
            String str = ticketNftExtAttr.nftContentUrl;
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (z) {
                return;
            }
            DMNav.from(tickletNFTTicketItemView.getContext()).toUri(ticketNftExtAttr.nftContentUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateNftData(TicketNftExtAttr ticketNftExtAttr) {
        boolean s;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "301170450")) {
            ipChange.ipc$dispatch("301170450", new Object[]{this, ticketNftExtAttr});
            return;
        }
        this.mNftData = ticketNftExtAttr;
        String str = ticketNftExtAttr.nftStatus;
        if (str != null) {
            s = C8604o.s(str);
            if (!s) {
                z = false;
            }
        }
        if (z) {
            str = NFTTicketStatus.NULL.getCode();
        }
        b41.h(str, "nftStatus");
        controlVisibleByBits(getStatues(str).getControlBits());
        validShow(this.statusTv, ticketNftExtAttr.issueTips);
        validShow(this.statusDesTv, ticketNftExtAttr.issueLimitTime);
        TextView textView = this.receiveBtnTv;
        if (textView != null) {
            PerformNftExtAttr performNftExtAttr = this.mPerformData;
            textView.setText(b41.d(performNftExtAttr != null ? performNftExtAttr.nftUserValidateStatus : null, "300") ? "授权实名" : "立即领取");
        }
        ImageView imageView = this.coverIv;
        if (imageView != null) {
            C0504a.b().loadinto(ticketNftExtAttr.coverURL, imageView);
        }
        validShow(this.ycCodeTv, ticketNftExtAttr.acSn);
        validShow(this.titleTv, ticketNftExtAttr.title);
        String str2 = ticketNftExtAttr.subContentType;
        if (str2 != null) {
            switch (str2.hashCode()) {
                case 92944:
                    if (str2.equals("_3D")) {
                        ImageView imageView2 = this.sourceTypeIv;
                        if (imageView2 != null) {
                            imageView2.setImageResource(R$drawable.ticket_nft_source_3d);
                            return;
                        }
                        return;
                    }
                    break;
                case 93166550:
                    if (str2.equals("audio")) {
                        ImageView imageView3 = this.sourceTypeIv;
                        if (imageView3 != null) {
                            imageView3.setImageResource(R$drawable.ticket_nft_source_sound);
                            return;
                        }
                        return;
                    }
                    break;
                case 100313435:
                    if (str2.equals("image")) {
                        ImageView imageView4 = this.sourceTypeIv;
                        if (imageView4 != null) {
                            imageView4.setImageResource(R$drawable.ticket_nft_source_pic);
                            return;
                        }
                        return;
                    }
                    break;
                case 112202875:
                    if (str2.equals("video")) {
                        ImageView imageView5 = this.sourceTypeIv;
                        if (imageView5 != null) {
                            imageView5.setImageResource(R$drawable.ticket_nft_source_video);
                            return;
                        }
                        return;
                    }
                    break;
            }
        }
        ImageView imageView6 = this.sourceTypeIv;
        if (imageView6 == null) {
            return;
        }
        imageView6.setVisibility(8);
    }

    private final void validShow(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1315719858")) {
            ipChange.ipc$dispatch("1315719858", new Object[]{this, textView, str});
            return;
        }
        if ((textView != null && textView.getVisibility() == 8) || textView == null) {
            return;
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(str);
    }

    public final void controlVisibleByBits(@NotNull byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2043888534")) {
            ipChange.ipc$dispatch("-2043888534", new Object[]{this, bArr});
            return;
        }
        b41.i(bArr, "controlBits");
        if (bArr.length != 9) {
            return;
        }
        ImageView imageView = this.mainIconIv;
        if (imageView != null) {
            imageView.setVisibility(bArr[0] == 1 ? 0 : 8);
        }
        TextView textView = this.statusTv;
        if (textView != null) {
            textView.setVisibility(bArr[1] == 1 ? 0 : 8);
        }
        TextView textView2 = this.statusDesTv;
        if (textView2 != null) {
            textView2.setVisibility(bArr[2] == 1 ? 0 : 8);
        }
        TextView textView3 = this.receiveBtnTv;
        if (textView3 != null) {
            textView3.setVisibility(bArr[3] == 1 ? 0 : 8);
        }
        ImageView imageView2 = this.coverIv;
        if (imageView2 != null) {
            imageView2.setVisibility(bArr[4] == 1 ? 0 : 8);
        }
        View view = this.line;
        if (view != null) {
            view.setVisibility(bArr[4] == 1 ? 0 : 8);
        }
        ImageView imageView3 = this.sourceTypeIv;
        if (imageView3 != null) {
            imageView3.setVisibility(bArr[5] == 1 ? 0 : 8);
        }
        TextView textView4 = this.ycCodeTv;
        if (textView4 != null) {
            textView4.setVisibility(bArr[6] == 1 ? 0 : 8);
        }
        TextView textView5 = this.titleTv;
        if (textView5 != null) {
            textView5.setVisibility(bArr[7] == 1 ? 0 : 8);
        }
        ImageView imageView4 = this.bottomIconIv;
        if (imageView4 == null) {
            return;
        }
        imageView4.setVisibility(bArr[8] != 1 ? 8 : 0);
    }

    public final void setData(@Nullable UserTicketTable userTicketTable, @Nullable TickletExtraInfo tickletExtraInfo, int i) {
        PerformNftExtAttr performNftExtAttr;
        TicketExtAttr extAttr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-633785389")) {
            ipChange.ipc$dispatch("-633785389", new Object[]{this, userTicketTable, tickletExtraInfo, Integer.valueOf(i)});
            return;
        }
        TicketNftExtAttr ticketNftExtAttr = (userTicketTable == null || (extAttr = userTicketTable.getExtAttr()) == null) ? null : extAttr.nftAttr;
        if (ticketNftExtAttr == null || tickletExtraInfo == null || (performNftExtAttr = tickletExtraInfo.extAttr) == null) {
            return;
        }
        this.mPerformData = performNftExtAttr;
        this.mTicketStatus = userTicketTable.voucherState;
        this.mPosition = i;
        this.mNftData = ticketNftExtAttr;
        this.mVoucherUniqueKey = userTicketTable.voucherUniqueKey;
        this.mPerformId = userTicketTable.performId;
        this.mProjectId = tickletExtraInfo.projectId;
        TextView textView = this.receiveBtnTv;
        if (textView != null) {
            un2.k().L(textView, this.mPosition);
        }
        if (tickletExtraInfo.isTMNormalMember()) {
            ImageView imageView = this.backRimIv;
            if (imageView != null) {
                imageView.setImageResource(R$drawable.ticket_nft_back_rim_vip);
            }
        } else {
            ImageView imageView2 = this.backRimIv;
            if (imageView2 != null) {
                imageView2.setImageResource(R$drawable.ticket_nft_back_rim);
            }
        }
        updateNftData(ticketNftExtAttr);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TickletNFTTicketItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        initView();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public enum NFTTicketStatus {
        NULL(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0}, "000"),
        UNCLAIMED(new byte[]{1, 1, 1, 1, 0, 0, 0, 0, 0}, MessageService.MSG_DB_COMPLETE),
        UNAUTHENTIC(new byte[]{0, 0, 0, 0, 1, 1, 1, 1, 1}, "200"),
        AUTHENTIC(new byte[]{0, 0, 0, 0, 1, 1, 1, 1, 1}, "300"),
        ROLLOUTING(new byte[]{1, 1, 1, 0, 0, 0, 0, 0, 0}, "401"),
        ROLLOUT(new byte[]{1, 1, 1, 0, 0, 0, 0, 0, 0}, "400"),
        INVALID(new byte[]{1, 1, 1, 0, 0, 0, 0, 0, 0}, "500"),
        DESTROYED(new byte[]{1, 1, 1, 0, 0, 0, 0, 0, 0}, "600"),
        EXPIRED(new byte[]{1, 1, 1, 0, 0, 0, 0, 0, 0}, "700");
        
        @NotNull
        private final String code;
        @NotNull
        private final byte[] controlBits;

        NFTTicketStatus(byte[] bArr, String str) {
            this.controlBits = bArr;
            this.code = str;
        }

        @NotNull
        public final String getCode() {
            return this.code;
        }

        @NotNull
        public final byte[] getControlBits() {
            return this.controlBits;
        }

        /* synthetic */ NFTTicketStatus(byte[] bArr, String str, int i, k50 k50Var) {
            this(bArr, (i & 2) != 0 ? "000" : str);
        }
    }
}
