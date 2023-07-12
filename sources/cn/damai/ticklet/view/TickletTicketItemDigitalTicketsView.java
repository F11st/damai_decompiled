package cn.damai.ticklet.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.user.c;
import cn.damai.member.R$color;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.bean.TickletExtraInfo;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.inteface.TickletTicketCallback;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.py2;
import tb.un2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletTicketItemDigitalTicketsView extends LinearLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static int ANIM_DURATION = 500;
    public static final int SHOW_DEFAULT = -1;
    public static final int SHOW_NFT = 0;
    public static final int SHOW_TICKET = 1;
    public static int SHOW_TYPE = -1;
    private Animation backAnim;
    private TickletTicketCallback callback;
    Context context;
    TickletDetailEventCodeView eventCodeView;
    private TickletExtraInfo extraInfo;
    private Animation frontAnim;
    private int index;
    private boolean isAnim;
    ImageView ivTranslateBed;
    private int mPosition;
    private UserTicketTable mTicketTable;
    private int mTotal;
    TickletNFTTicketItemView nftAreaLayout;
    DMIconFontTextView nftLeftArrow;
    DMIconFontTextView nftRightArrow;
    View partent;
    TickletTicketItemNftNormalTicketView ticketAreaLayout;
    TickletTicketHeadView ticketHeadView;
    TickletTicketActionView ticklet_ll_action;
    LinearLayout ticklet_ticket_item_layout;
    LinearLayout translateLayout;
    TextView tvtTranslate;
    private View[] views;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-961783417")) {
                ipChange.ipc$dispatch("-961783417", new Object[]{this, animation});
                return;
            }
            TickletTicketItemDigitalTicketsView.this.views[TickletTicketItemDigitalTicketsView.this.index].setVisibility(4);
            TickletTicketItemDigitalTicketsView.this.views[TickletTicketItemDigitalTicketsView.this.index].clearAnimation();
            TickletTicketItemDigitalTicketsView tickletTicketItemDigitalTicketsView = TickletTicketItemDigitalTicketsView.this;
            tickletTicketItemDigitalTicketsView.index = (tickletTicketItemDigitalTicketsView.index + 1) % 2;
            TickletTicketItemDigitalTicketsView.SHOW_TYPE = TickletTicketItemDigitalTicketsView.this.index;
            TickletTicketItemDigitalTicketsView.this.views[TickletTicketItemDigitalTicketsView.this.index].setVisibility(0);
            TickletTicketItemDigitalTicketsView.this.views[TickletTicketItemDigitalTicketsView.this.index].startAnimation(TickletTicketItemDigitalTicketsView.this.backAnim);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1275550579")) {
                ipChange.ipc$dispatch("-1275550579", new Object[]{this, animation});
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1934272288")) {
                ipChange.ipc$dispatch("1934272288", new Object[]{this, animation});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-268390712")) {
                ipChange.ipc$dispatch("-268390712", new Object[]{this, animation});
                return;
            }
            TickletTicketItemDigitalTicketsView.this.isAnim = false;
            TickletTicketItemDigitalTicketsView.this.views[TickletTicketItemDigitalTicketsView.this.index].clearAnimation();
            TickletTicketItemDigitalTicketsView tickletTicketItemDigitalTicketsView = TickletTicketItemDigitalTicketsView.this;
            tickletTicketItemDigitalTicketsView.upTranslateView(tickletTicketItemDigitalTicketsView.index);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1088797612")) {
                ipChange.ipc$dispatch("1088797612", new Object[]{this, animation});
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1730236383")) {
                ipChange.ipc$dispatch("-1730236383", new Object[]{this, animation});
            }
        }
    }

    public TickletTicketItemDigitalTicketsView(Context context) {
        this(context, null);
    }

    private void arrowShow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1833365132")) {
            ipChange.ipc$dispatch("-1833365132", new Object[]{this});
        } else if (this.mTotal < 2) {
            this.nftLeftArrow.setVisibility(8);
            this.nftRightArrow.setVisibility(8);
        } else {
            this.nftLeftArrow.setVisibility(0);
            this.nftRightArrow.setVisibility(0);
            int i = this.mTotal - 1;
            int i2 = this.mPosition;
            if (i == i2) {
                this.nftLeftArrow.setTextColor(this.context.getResources().getColor(R$color.white));
                this.nftRightArrow.setTextColor(this.context.getResources().getColor(R$color.ticklet_color_66ffffff));
            } else if (i2 == 0) {
                this.nftLeftArrow.setTextColor(this.context.getResources().getColor(R$color.ticklet_color_66ffffff));
                this.nftRightArrow.setTextColor(this.context.getResources().getColor(R$color.white));
            } else {
                DMIconFontTextView dMIconFontTextView = this.nftLeftArrow;
                Resources resources = this.context.getResources();
                int i3 = R$color.white;
                dMIconFontTextView.setTextColor(resources.getColor(i3));
                this.nftRightArrow.setTextColor(this.context.getResources().getColor(i3));
            }
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-702264197")) {
            ipChange.ipc$dispatch("-702264197", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_ticket_detail_digital_tickets_item, this);
        this.partent = inflate;
        this.ticklet_ticket_item_layout = (LinearLayout) inflate.findViewById(R$id.ticklet_ticket_item_layout);
        this.ticketHeadView = (TickletTicketHeadView) this.partent.findViewById(R$id.ticklet_ticket_rl_header_view);
        this.ticklet_ll_action = (TickletTicketActionView) this.partent.findViewById(R$id.ticklet_ll_action);
        this.eventCodeView = (TickletDetailEventCodeView) this.partent.findViewById(R$id.ticklet_per_tic_event_code);
        this.translateLayout = (LinearLayout) this.partent.findViewById(R$id.ticklet_ticket_rl_translate);
        this.tvtTranslate = (TextView) this.partent.findViewById(R$id.ticklet_ticket_rl_translate_text);
        this.ivTranslateBed = (ImageView) this.partent.findViewById(R$id.ticket_nft_translate_bed);
        this.ticketAreaLayout = (TickletTicketItemNftNormalTicketView) this.partent.findViewById(R$id.ticklet_ticket_nft_border_bg);
        this.nftAreaLayout = (TickletNFTTicketItemView) this.partent.findViewById(R$id.ticklet_ticket_nft_layout);
        this.nftLeftArrow = (DMIconFontTextView) this.partent.findViewById(R$id.ticklet_ticket_nft_left_arrow);
        this.nftRightArrow = (DMIconFontTextView) this.partent.findViewById(R$id.ticklet_ticket_ntf_right_arrow);
        View[] viewArr = this.views;
        viewArr[0] = this.nftAreaLayout;
        viewArr[1] = this.ticketAreaLayout;
        this.translateLayout.setOnClickListener(this);
        this.nftLeftArrow.setOnClickListener(this);
        this.nftRightArrow.setOnClickListener(this);
    }

    private void startAnimation(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1361507940")) {
            ipChange.ipc$dispatch("1361507940", new Object[]{this, view});
        } else if (this.isAnim) {
        } else {
            this.isAnim = true;
            if (this.frontAnim == null) {
                float width = this.views[0].getWidth() / 2.0f;
                float height = this.views[0].getHeight() / 2.0f;
                Rotate3dAnimation rotate3dAnimation = new Rotate3dAnimation(this.context, 0.0f, 90.0f, width, height, 0.0f, true, 0, 25.0f);
                this.frontAnim = rotate3dAnimation;
                rotate3dAnimation.setDuration(ANIM_DURATION);
                this.frontAnim.setFillAfter(true);
                this.frontAnim.setInterpolator(new LinearInterpolator());
                Rotate3dAnimation rotate3dAnimation2 = new Rotate3dAnimation(this.context, -90.0f, 0.0f, width, height, 0.0f, true, 0, 25.0f);
                this.backAnim = rotate3dAnimation2;
                rotate3dAnimation2.setDuration(ANIM_DURATION);
                this.backAnim.setFillAfter(true);
                this.backAnim.setInterpolator(new LinearInterpolator());
                this.frontAnim.setAnimationListener(new a());
                this.backAnim.setAnimationListener(new b());
            }
            this.views[this.index].startAnimation(this.frontAnim);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upTranslateView(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2077312609")) {
            ipChange.ipc$dispatch("2077312609", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 0) {
            this.tvtTranslate.setText("翻转验票");
        } else {
            this.tvtTranslate.setText("翻转查看藏品");
        }
    }

    public TextView getTipTv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "244056509") ? (TextView) ipChange.ipc$dispatch("244056509", new Object[]{this}) : this.ticketAreaLayout.getTipTv();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1710133855")) {
            ipChange.ipc$dispatch("-1710133855", new Object[]{this, view});
        } else if (view.getId() == R$id.ticklet_ticket_nft_left_arrow) {
            TickletTicketCallback tickletTicketCallback = this.callback;
            if (tickletTicketCallback == null || (i = this.mPosition) <= 0) {
                return;
            }
            tickletTicketCallback.viewPageSlide(i - 1);
            this.callback.viewPageViewType(this.index);
        } else if (view.getId() == R$id.ticklet_ticket_ntf_right_arrow) {
            TickletTicketCallback tickletTicketCallback2 = this.callback;
            if (tickletTicketCallback2 != null) {
                int i2 = this.mTotal - 1;
                int i3 = this.mPosition;
                if (i2 > i3) {
                    tickletTicketCallback2.viewPageSlide(i3 + 1);
                    this.callback.viewPageViewType(this.index);
                }
            }
        } else if (view.getId() == R$id.ticklet_ticket_rl_translate) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", this.index + "");
            c e = c.e();
            cn.damai.common.user.b bVar = cn.damai.common.user.b.getInstance();
            e.x(bVar.e(un2.TICKLET_DETAIL_PAGE, "nft", "reverse_" + this.mPosition, hashMap, Boolean.FALSE));
            startAnimation(view);
        }
    }

    public void setCallback(TickletTicketCallback tickletTicketCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "217095215")) {
            ipChange.ipc$dispatch("217095215", new Object[]{this, tickletTicketCallback});
        } else {
            this.callback = tickletTicketCallback;
        }
    }

    public void setShowType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-819987582")) {
            ipChange.ipc$dispatch("-819987582", new Object[]{this, Integer.valueOf(i)});
        } else if (i != -1) {
            if (i == 0 && this.mTicketTable.isNftTicket()) {
                py2.G(this.nftAreaLayout);
                py2.x(this.ticketAreaLayout);
            } else {
                py2.G(this.ticketAreaLayout);
                py2.x(this.nftAreaLayout);
            }
            this.index = i;
            SHOW_TYPE = i;
            upTranslateView(i);
        }
    }

    public void update(UserTicketTable userTicketTable, TickletExtraInfo tickletExtraInfo, TicketDeatilResult ticketDeatilResult, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-217128434")) {
            ipChange.ipc$dispatch("-217128434", new Object[]{this, userTicketTable, tickletExtraInfo, ticketDeatilResult, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (userTicketTable == null) {
        } else {
            this.mTotal = i2;
            this.mPosition = i;
            this.mTicketTable = userTicketTable;
            this.extraInfo = tickletExtraInfo;
            this.ticketHeadView.update(userTicketTable, i2, i);
            this.ticketHeadView.setTicketCallback(this.callback);
            this.ticklet_ll_action.addAction(userTicketTable, tickletExtraInfo, ticketDeatilResult, i);
            this.ticklet_ll_action.setTicketCallback(this.callback);
            this.eventCodeView.update(userTicketTable.activityCodeInfoVO, userTicketTable.voucherState);
            this.ticketAreaLayout.setCallback(this.callback);
            this.ticketAreaLayout.update(userTicketTable, tickletExtraInfo, ticketDeatilResult, i, i2);
            if (this.mTicketTable.isNftTicket()) {
                py2.G(this.nftAreaLayout);
                py2.x(this.ticketAreaLayout);
                this.nftAreaLayout.setData(userTicketTable, tickletExtraInfo, i);
                py2.G(this.translateLayout);
            } else {
                py2.G(this.ticketAreaLayout);
                py2.x(this.nftAreaLayout);
                py2.x(this.translateLayout);
            }
            setShowType(SHOW_TYPE);
            if (tickletExtraInfo.isTMNormalMember()) {
                this.translateLayout.setBackgroundResource(R$drawable.ticket_nft_translate_border_tm);
                this.ivTranslateBed.setBackgroundResource(R$drawable.ticket_nft_translate_bed_tm_normal);
            } else if (tickletExtraInfo.isTMVipMember()) {
                this.translateLayout.setBackgroundResource(R$drawable.ticket_nft_translate_border_tm_vip);
                this.ivTranslateBed.setBackgroundResource(R$drawable.ticket_nft_translate_bed_tm_vip);
            } else {
                this.translateLayout.setBackgroundResource(R$drawable.ticket_nft_translate_border_tm_vip);
                this.ivTranslateBed.setBackgroundResource(R$drawable.ticket_nft_translate_bed_not_tm);
            }
            arrowShow();
        }
    }

    public TickletTicketItemDigitalTicketsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletTicketItemDigitalTicketsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.views = new View[2];
        this.index = 0;
        this.isAnim = false;
        this.context = context;
        initView();
    }
}
