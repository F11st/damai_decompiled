package cn.damai.commonbusiness.discover.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.image.C0504a;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.lazyimg.ImgLoader;
import cn.damai.commonbusiness.lazyimg.view.GifCareImageView;
import cn.damai.commonbusiness.search.bean.MarketTagBean;
import cn.damai.commonbusiness.yymember.bean.PerformFilmVipDO;
import cn.damai.tetris.component.discover.bean.Label;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.bean.ProjectInNote;
import cn.damai.tetris.component.discover.bean.PublishUser;
import cn.damai.tetris.component.discover.bean.VideoInfo;
import cn.damai.tetris.component.girl.mvp.HWRatioLayout;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.tag.DMCommonTagView;
import cn.damai.uikit.view.RoundImageView;
import cn.damai.uikit.view.StrokeLinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.c21;
import tb.di0;
import tb.mu0;
import tb.t60;
import tb.vu0;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class NoteViewHolder extends BaseViewHolder<NoteBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private ImgLoader A;
    private ViewGroup B;
    private di0 C;
    private GifCareImageView a;
    private TextView b;
    private HWRatioLayout c;
    private ImageView d;
    private View e;
    private TextView f;
    private RoundImageView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private View l;
    private View m;
    private View n;
    private TextView o;
    private View p;
    private StrokeLinearLayout q;
    private LinearLayout r;
    private ImageView s;
    private DMDigitTextView t;
    private OnItemClickListener<NoteBean> u;
    public NoteBean v;
    public int w;
    private int x;
    private int y;
    private int z;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.discover.viewholder.NoteViewHolder$a */
    /* loaded from: classes14.dex */
    public class View$OnAttachStateChangeListenerC0647a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnAttachStateChangeListenerC0647a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-662624417")) {
                ipChange.ipc$dispatch("-662624417", new Object[]{this, view});
                return;
            }
            NoteViewHolder.this.A = c21.a(view);
            NoteViewHolder.this.i();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1003401188")) {
                ipChange.ipc$dispatch("-1003401188", new Object[]{this, view});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.discover.viewholder.NoteViewHolder$b */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0648b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0648b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-643782088")) {
                ipChange.ipc$dispatch("-643782088", new Object[]{this, view});
            } else if (NoteViewHolder.this.u != null) {
                NoteViewHolder noteViewHolder = NoteViewHolder.this;
                if (noteViewHolder.v != null) {
                    OnItemClickListener onItemClickListener = noteViewHolder.u;
                    NoteViewHolder noteViewHolder2 = NoteViewHolder.this;
                    onItemClickListener.onEditClick(noteViewHolder2.v, noteViewHolder2.w);
                }
            }
        }
    }

    public NoteViewHolder(Context context, ViewGroup viewGroup, OnItemClickListener<NoteBean> onItemClickListener) {
        this(BaseViewHolder.b(context, viewGroup, R$layout.item_discover_feed_note), onItemClickListener);
    }

    private void f(NoteBean noteBean) {
        ProjectInNote projectInNote;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-539979410")) {
            ipChange.ipc$dispatch("-539979410", new Object[]{this, noteBean});
        } else if (noteBean != null && (projectInNote = noteBean.project) != null) {
            if (!TextUtils.isEmpty(projectInNote.name)) {
                View view = this.itemView;
                int i = R$id.ll_card_note_proj;
                view.findViewById(i).setVisibility(0);
                this.itemView.findViewById(i).setOnClickListener(new View$OnClickListenerC0648b());
                C0504a.b().c(projectInNote.verticalPic).c(R$drawable.uikit_default_image_bg_gradient).g((ImageView) this.itemView.findViewById(R$id.ll_card_note_proj_img));
                ((TextView) this.itemView.findViewById(R$id.ll_card_note_proj_name)).setText(projectInNote.name);
                this.B.removeAllViews();
                this.B.setVisibility(8);
                if (TextUtils.isEmpty(projectInNote.priceLow)) {
                    this.itemView.findViewById(R$id.dfp_price_prefix).setVisibility(8);
                    this.itemView.findViewById(R$id.dfp_price_postfix).setVisibility(8);
                    this.itemView.findViewById(R$id.dfp_price).setVisibility(8);
                    this.itemView.findViewById(R$id.dfp_price_pending).setVisibility(0);
                } else {
                    this.itemView.findViewById(R$id.dfp_price_prefix).setVisibility(0);
                    this.itemView.findViewById(R$id.dfp_price_postfix).setVisibility(0);
                    View view2 = this.itemView;
                    int i2 = R$id.dfp_price;
                    view2.findViewById(i2).setVisibility(0);
                    ((TextView) this.itemView.findViewById(i2)).setText(projectInNote.priceLow);
                    this.itemView.findViewById(R$id.dfp_price_pending).setVisibility(8);
                    MarketTagBean gotTopTag = projectInNote.gotTopTag(true);
                    if (gotTopTag != null && !TextUtils.isEmpty(gotTopTag.shortTag)) {
                        this.B.setVisibility(0);
                        DMCommonTagView addMarketTagView = gotTopTag.addMarketTagView(this.B, true);
                        addMarketTagView.setHasPandding(false);
                        addMarketTagView.setImgHeight(t60.a(this.B.getContext(), 29.333334f), t60.a(this.B.getContext(), 12.0f));
                        if (addMarketTagView.getTagView() != null) {
                            addMarketTagView.getTagView().setTextSize(1, 8.0f);
                            addMarketTagView.getTagView().getLayoutParams().height = t60.a(this.B.getContext(), 12.0f);
                        }
                    } else {
                        this.B.setVisibility(8);
                    }
                }
                if (!TextUtils.isEmpty(projectInNote.itemScore)) {
                    View view3 = this.itemView;
                    int i3 = R$id.ll_card_note_proj_score;
                    view3.findViewById(i3).setVisibility(0);
                    ((TextView) this.itemView.findViewById(i3)).setText(projectInNote.itemScore);
                } else {
                    this.itemView.findViewById(R$id.ll_card_note_proj_score).setVisibility(8);
                }
            } else {
                this.itemView.findViewById(R$id.ll_card_note_proj).setVisibility(8);
            }
            if (noteBean.project.attractiveLabel != null && !TextUtils.isEmpty(projectInNote.attractiveLabel.title)) {
                this.itemView.findViewById(R$id.note_card_bottom_ll).setVisibility(0);
                if (TextUtils.isEmpty(projectInNote.attractiveLabel.icon)) {
                    ((ImageView) this.itemView.findViewById(R$id.note_card_bottom_icon)).setImageResource(R$drawable.home_card_note_tipicon);
                } else {
                    C0504a.b().c(projectInNote.attractiveLabel.icon).g((ImageView) this.itemView.findViewById(R$id.note_card_bottom_icon));
                }
                ((TextView) this.itemView.findViewById(R$id.note_card_bottom_desc)).setText(projectInNote.attractiveLabel.title);
                return;
            }
            this.itemView.findViewById(R$id.note_card_bottom_ll).setVisibility(8);
        } else {
            this.itemView.findViewById(R$id.ll_card_note_proj).setVisibility(8);
            this.itemView.findViewById(R$id.note_card_bottom_ll).setVisibility(8);
        }
    }

    public static int h(Context context, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1290435979")) {
            return ((Integer) ipChange.ipc$dispatch("-1290435979", new Object[]{context, Float.valueOf(f)})).intValue();
        }
        try {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        di0 di0Var;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1902285027")) {
            ipChange.ipc$dispatch("1902285027", new Object[]{this});
            return;
        }
        ImgLoader imgLoader = this.A;
        if (imgLoader == null || (di0Var = this.C) == null) {
            return;
        }
        imgLoader.a(di0Var);
        this.C = null;
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolder
    /* renamed from: g */
    public void a(NoteBean noteBean, int i) {
        int parseColor;
        int i2;
        int i3;
        PerformFilmVipDO performFilmVipDO;
        Label label;
        vu0 vu0Var;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-420506907")) {
            ipChange.ipc$dispatch("-420506907", new Object[]{this, noteBean, Integer.valueOf(i)});
            return;
        }
        this.v = noteBean;
        this.w = i;
        int i4 = -1;
        if (noteBean.highLight) {
            i3 = Color.parseColor("#66FFFFFF");
            parseColor = Color.parseColor("#99FFFFFF");
            this.p.setBackgroundResource(R$drawable.bg_note_high_light);
            StrokeLinearLayout strokeLinearLayout = this.q;
            int i5 = this.x;
            strokeLinearLayout.setPadding(i5, i5, i5, i5);
            this.q.setCornerAndStroke(this.z, this.y, new int[]{Color.parseColor("#FF4E6E"), Color.parseColor("#FF833C")});
            i2 = -1;
        } else {
            this.p.setBackgroundResource(R$drawable.bg_note_none_hight_light);
            this.q.setPadding(0, 0, 0, 0);
            this.q.setCornerAndStroke(this.z, 1, Color.parseColor("#0D000000"));
            i4 = -16777216;
            int parseColor2 = Color.parseColor("#666666");
            int parseColor3 = Color.parseColor("#663C3F44");
            parseColor = Color.parseColor("#9C9CA5");
            i2 = parseColor2;
            i3 = parseColor3;
        }
        this.b.setTextColor(i4);
        this.h.setTextColor(i2);
        this.i.setTextColor(parseColor);
        this.j.setTextColor(i3);
        boolean isShowVideoIcon = noteBean.isShowVideoIcon();
        if (isShowVideoIcon) {
            VideoInfo videoInfo = noteBean.videoInfo;
            if (videoInfo != null && !TextUtils.isEmpty(videoInfo.formatVideoTime())) {
                this.m.setVisibility(0);
                this.n.setVisibility(8);
                this.o.setText(noteBean.videoInfo.formatVideoTime());
            } else {
                this.m.setVisibility(8);
                this.n.setVisibility(0);
            }
        } else {
            this.n.setVisibility(8);
            this.m.setVisibility(8);
        }
        boolean isHasVideoUnderReviewStatus = noteBean.isHasVideoUnderReviewStatus();
        if (!noteBean.isPicNote() && !isShowVideoIcon && !isHasVideoUnderReviewStatus) {
            this.e.setVisibility(0);
            this.c.setVisibility(8);
            this.b.setVisibility(8);
            int i6 = noteBean.colorIndex;
            if (i6 < 0) {
                vu0Var = new vu0();
                noteBean.colorIndex = vu0Var.a();
            } else {
                vu0Var = new vu0(i6);
            }
            GradientDrawable c = vu0Var.c(GradientDrawable.Orientation.TL_BR);
            if (Build.VERSION.SDK_INT >= 16) {
                this.e.setBackground(c);
            } else {
                this.e.setBackgroundDrawable(c);
            }
            this.f.setText(noteBean.content);
        } else {
            this.e.setVisibility(8);
            this.c.setVisibility(0);
            this.b.setVisibility(0);
            this.b.setText(noteBean.content);
            float f = noteBean.hwRatio;
            if (f > 0.0f) {
                this.c.setHwRatio(f);
            } else {
                this.c.setHwRatio(1.0f);
            }
            String str = noteBean.pic;
            if (isShowVideoIcon) {
                str = noteBean.getVideoCoverUrl();
            }
            if (isHasVideoUnderReviewStatus) {
                str = "VIDEO_UNDER_REVIEW_URL";
            }
            this.C = new di0(this.a, str);
            i();
        }
        if (noteBean.containsStrategy()) {
            this.d.setVisibility(0);
            this.d.setImageResource(R$drawable.feed_note_card_stragety);
        } else if (noteBean.isFeature()) {
            this.d.setVisibility(0);
            this.d.setImageResource(R$drawable.feed_note_card_feature);
        } else {
            this.d.setVisibility(8);
        }
        PublishUser publishUser = noteBean.publishUser;
        if (publishUser != null && !TextUtils.isEmpty(publishUser.nickname)) {
            noteBean.nickname = noteBean.publishUser.nickname;
        }
        PublishUser publishUser2 = noteBean.publishUser;
        if (publishUser2 != null && !TextUtils.isEmpty(publishUser2.headImg)) {
            noteBean.headImg = noteBean.publishUser.headImg;
        }
        this.h.setText(noteBean.nickname);
        PublishUser publishUser3 = noteBean.publishUser;
        if (publishUser3 != null && (label = publishUser3.label) != null) {
            if ("RELATION".equals(label.labelType)) {
                this.l.setVisibility(8);
                this.r.setVisibility(8);
                this.k.setVisibility(0);
                this.k.setText(noteBean.publishUser.label.labelTitle);
                this.k.setTextColor(Color.parseColor("#9C9CA5"));
            } else if ("ACHIEVEMENT".equals(noteBean.publishUser.label.labelType)) {
                this.r.setVisibility(0);
                this.l.setVisibility(8);
                this.k.setVisibility(8);
                this.t.setText(noteBean.publishUser.label.labelTitle);
                this.t.setTextColor(Color.parseColor("#FF903C"));
                this.s.setImageResource(R$drawable.card_note_tag_pub);
            } else if ("DNA".equals(noteBean.publishUser.label.labelType)) {
                this.r.setVisibility(0);
                this.l.setVisibility(8);
                this.k.setVisibility(8);
                String str2 = noteBean.publishUser.label.labelTitle;
                DMDigitTextView dMDigitTextView = this.t;
                dMDigitTextView.setText(str2 + "%");
                this.t.setTextColor(Color.parseColor("#af8cfc"));
                this.s.setImageResource(R$drawable.icon_discover_content_detail_dna_mini);
            }
        } else if (TextUtils.isEmpty(noteBean.ipvuv)) {
            this.l.setVisibility(8);
            if (TextUtils.isEmpty(noteBean.similarity)) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
                this.t.setText(noteBean.similarity + "%");
                this.s.setImageResource(R$drawable.icon_discover_content_detail_dna_mini);
            }
        } else {
            this.l.setVisibility(0);
            this.i.setText(noteBean.ipvuv);
            this.r.setVisibility(8);
        }
        this.g.setBorder(1, Color.parseColor("#1A000000"));
        ImgTicketWrap.c(this.g, noteBean.headImg, R$drawable.uikit_account_place_holder_default, null);
        PublishUser publishUser4 = noteBean.publishUser;
        if (publishUser4 != null && (performFilmVipDO = publishUser4.performFilmVipDO) != null && !TextUtils.isEmpty(performFilmVipDO.memberFlag)) {
            String str3 = noteBean.publishUser.performFilmVipDO.memberFlag;
            ImageView imageView = (ImageView) this.itemView.findViewById(R$id.user_head_tag);
            if ("1".equals(str3)) {
                imageView.setVisibility(0);
                imageView.setImageResource(R$drawable.dm_yy_member_icon);
            } else if ("10".equals(str3)) {
                imageView.setVisibility(0);
                imageView.setImageResource(R$drawable.dm_yy_black_member_icon);
            } else {
                imageView.setVisibility(8);
            }
        } else {
            ((ImageView) this.itemView.findViewById(R$id.user_head_tag)).setVisibility(8);
        }
        this.itemView.setTag(noteBean);
        this.itemView.setOnClickListener(this);
        k(this.itemView, this.v, i);
        if (this.r.getVisibility() == 0) {
            j(this.r, this.v, i);
        }
        f(noteBean);
    }

    public void j(View view, NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1585674360")) {
            ipChange.ipc$dispatch("1585674360", new Object[]{this, view, noteBean, Integer.valueOf(i)});
        }
    }

    public void k(View view, NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-175385367")) {
            ipChange.ipc$dispatch("-175385367", new Object[]{this, view, noteBean, Integer.valueOf(i)});
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NoteBean noteBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2028299862")) {
            ipChange.ipc$dispatch("-2028299862", new Object[]{this, view});
            return;
        }
        NoteBean noteBean2 = this.v;
        if (noteBean2 == null) {
            return;
        }
        if (noteBean2.isHasVideoUnderReviewStatus()) {
            ToastUtil.a().j(mu0.a(), "该视频还在处理中哦~");
            return;
        }
        OnItemClickListener<NoteBean> onItemClickListener = this.u;
        if (onItemClickListener == null || (noteBean = this.v) == null) {
            return;
        }
        onItemClickListener.onItemClick(noteBean, this.w);
    }

    public NoteViewHolder(View view, OnItemClickListener<NoteBean> onItemClickListener) {
        super(view);
        view.addOnAttachStateChangeListener(new View$OnAttachStateChangeListenerC0647a());
        Context context = view.getContext();
        if (context != null) {
            this.z = h(context, 6.0f);
            this.x = h(context, 3.0f);
            this.y = h(context, 3.0f);
        }
        this.u = onItemClickListener;
        this.q = (StrokeLinearLayout) view.findViewById(R$id.note_stroke_layout);
        this.c = (HWRatioLayout) view.findViewById(R$id.note_s1_hw_layout);
        this.a = (GifCareImageView) view.findViewById(R$id.note_s1_img);
        this.b = (TextView) view.findViewById(R$id.note_s1_title);
        this.d = (ImageView) view.findViewById(R$id.note_si_feature);
        this.e = view.findViewById(R$id.note_s2_ui);
        this.f = (TextView) view.findViewById(R$id.note_s2_text);
        this.p = view.findViewById(R$id.bottom_layout);
        this.g = (RoundImageView) view.findViewById(R$id.user_head);
        this.h = (TextView) view.findViewById(R$id.user_name);
        this.l = view.findViewById(R$id.watch_count_ui);
        this.i = (TextView) view.findViewById(R$id.watch_count);
        this.j = (TextView) view.findViewById(R$id.watch_count_icon);
        this.k = (TextView) view.findViewById(R$id.new_common_text);
        this.m = view.findViewById(R$id.video_icon);
        this.n = view.findViewById(R$id.video_icon_old);
        this.o = (TextView) view.findViewById(R$id.icon_play_mini_tv);
        this.r = (LinearLayout) view.findViewById(R$id.ll_dna);
        this.s = (ImageView) view.findViewById(R$id.iv_dna_pic);
        this.t = (DMDigitTextView) view.findViewById(R$id.tv_dna_similarity);
        this.B = (ViewGroup) view.findViewById(R$id.market_tag_container);
    }
}
