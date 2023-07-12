package cn.damai.commonbusiness.discover.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.category.category.ui.StarFragment;
import cn.damai.comment.bean.CommentPraiseInfoBean;
import cn.damai.comment.bean.FollowStateBean;
import cn.damai.comment.listener.OnPraiseViewClickListenerNew;
import cn.damai.comment.request.FollowRequest;
import cn.damai.comment.util.NineImgUtil;
import cn.damai.comment.view.PraiseView;
import cn.damai.common.AppConfig;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.discover.bean.ContentShareInfo;
import cn.damai.commonbusiness.discover.bean.GridBean;
import cn.damai.commonbusiness.discover.bean.NineJumpBean;
import cn.damai.commonbusiness.yymember.bean.PerformFilmVipDO;
import cn.damai.discover.content.view.UserInfoView;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.bean.RelatedInfo;
import cn.damai.tetris.component.discover.bean.VideoInfo;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.component.ip.bean.BaseUserDO;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.util.DialogUtil;
import cn.damai.uikit.view.BottomActionDialog;
import cn.damai.uikit.view.NineGridView;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.math.BigDecimal;
import java.util.List;
import tb.cb2;
import tb.cs;
import tb.k23;
import tb.mu0;
import tb.q60;
import tb.qk1;
import tb.rh2;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class BigNoteViewHolder extends BaseViewHolder<NoteBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private View A;
    private UserInfoView a;
    private ImageView b;
    private TextView c;
    private NineGridView d;
    private qk1 e;
    private View f;
    private TextView g;
    private DMIconFontTextView h;
    private PraiseView i;
    private View j;
    private ImageView k;
    private TextView l;
    private View m;
    private View n;
    private OnItemClickListener<NoteBean> o;
    public NoteBean p;
    public int q;
    private Context r;
    boolean s;
    protected int t;
    protected boolean u;
    private NineJumpBean v;
    private View w;
    private View x;
    private TextView y;
    private View z;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a implements OnItemBindListener<GridBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
        /* renamed from: a */
        public void exposeItem(View view, GridBean gridBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1222978927")) {
                ipChange.ipc$dispatch("1222978927", new Object[]{this, view, gridBean, Integer.valueOf(i)});
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(GridBean gridBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "302704868")) {
                ipChange.ipc$dispatch("302704868", new Object[]{this, gridBean, Integer.valueOf(i)});
            } else {
                BigNoteViewHolder.this.i(gridBean, i);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class b implements OnPraiseViewClickListenerNew {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        @Override // cn.damai.comment.listener.OnPraiseViewClickListenerNew
        public void OnPraiseViewClick(boolean z, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "481382345")) {
                ipChange.ipc$dispatch("481382345", new Object[]{this, Boolean.valueOf(z), str});
            } else {
                BigNoteViewHolder.this.c(z, str, this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class c implements UserInfoView.DnaClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // cn.damai.discover.content.view.UserInfoView.DnaClickListener
        public void onDnaClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "608835007")) {
                ipChange.ipc$dispatch("608835007", new Object[]{this});
                return;
            }
            BigNoteViewHolder bigNoteViewHolder = BigNoteViewHolder.this;
            NoteBean noteBean = bigNoteViewHolder.p;
            bigNoteViewHolder.dnaOnClickReport(noteBean.contentInfo.id, noteBean.baseUserDO.havanaIdStr, bigNoteViewHolder.q);
            if (TextUtils.isEmpty(this.a)) {
                DialogUtil.b(BigNoteViewHolder.this.r).show();
            } else {
                DMNav.from(BigNoteViewHolder.this.r).toUri(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class d implements BottomActionDialog.OnActionListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.uikit.view.BottomActionDialog.OnActionListener
        public void onItemClick(BottomActionDialog.Action action, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-456432875")) {
                ipChange.ipc$dispatch("-456432875", new Object[]{this, action, Integer.valueOf(i)});
                return;
            }
            BigNoteViewHolder bigNoteViewHolder = BigNoteViewHolder.this;
            bigNoteViewHolder.l(bigNoteViewHolder.p, action, i);
        }
    }

    public BigNoteViewHolder(View view, OnItemClickListener<NoteBean> onItemClickListener) {
        super(view);
        this.s = false;
        this.t = 5;
        this.u = false;
        this.r = view.getContext();
        this.o = onItemClickListener;
        this.a = (UserInfoView) view.findViewById(R$id.content_detail_user_info);
        this.b = (ImageView) view.findViewById(R$id.iv_selected);
        this.c = (TextView) view.findViewById(R$id.note_s1_title);
        this.d = (NineGridView) view.findViewById(R$id.comment_hl_content_pics_v2);
        qk1 qk1Var = new qk1(mu0.a(), new a());
        this.e = qk1Var;
        this.d.setAdapter(qk1Var);
        this.d.enableLog(AppConfig.v());
        this.f = view.findViewById(R$id.note_relate_ui);
        this.g = (TextView) view.findViewById(R$id.note_relate_tv);
        this.h = (DMIconFontTextView) view.findViewById(R$id.tv_share);
        this.i = (PraiseView) view.findViewById(R$id.comment_hl_praise_layout);
        this.j = view.findViewById(R$id.comment_like_layout);
        this.k = (ImageView) view.findViewById(R$id.comment_like_numicon);
        this.l = (TextView) view.findViewById(R$id.comment_like_num);
        this.m = view.findViewById(R$id.comment_reply_layout);
        TextView textView = (TextView) view.findViewById(R$id.comment_num_reply);
        this.n = view.findViewById(R$id.note_stroke_layout);
        this.A = view.findViewById(R$id.note_more_action);
        this.w = view.findViewById(R$id.item_discover_big_note_head_1);
        View findViewById = view.findViewById(R$id.item_discover_big_note_head_2);
        this.x = findViewById;
        this.y = (TextView) findViewById.findViewById(R$id.note_s1_title_2);
        this.z = this.x.findViewById(R$id.iv_selected_2);
    }

    private void n(String str, TextView textView) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-632980110")) {
            ipChange.ipc$dispatch("-632980110", new Object[]{this, str, textView});
        } else if (TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            if (str.length() >= this.t * 24) {
                String str2 = str.substring(0, (i * 24) - 6) + "...  更多";
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.r.getResources().getColor(R$color.color_9C9CA5)), str2.length() - 4, str2.length(), 17);
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(q60.a(this.r, 12.0f)), str2.length() - 4, str2.length(), 33);
                textView.setText(spannableStringBuilder);
                return;
            }
            textView.setText(str);
        }
    }

    private void o(List<String> list, VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1499295117")) {
            ipChange.ipc$dispatch("1499295117", new Object[]{this, list, videoInfo});
            return;
        }
        NineJumpBean nineJumpBean = new NineJumpBean(list, videoInfo);
        this.v = nineJumpBean;
        List<GridBean> gridList = nineJumpBean.getGridList(this.u);
        if (cb2.d(gridList)) {
            this.d.setVisibility(8);
            return;
        }
        this.d.setVisibility(0);
        this.e.j(gridList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(TextView textView, int i, String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1319773445")) {
            ipChange.ipc$dispatch("-1319773445", new Object[]{this, textView, Integer.valueOf(i), str});
            return;
        }
        if (i > 10000) {
            str2 = new BigDecimal(i / 10000).setScale(1, 4).doubleValue() + "万";
        } else {
            str2 = i + "";
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (i == 0) {
            textView.setText(str);
        } else {
            textView.setText(str2);
        }
    }

    private void r(NoteBean noteBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "725210359")) {
            ipChange.ipc$dispatch("725210359", new Object[]{this, noteBean});
            return;
        }
        this.a.setOnClickListener(this);
        BaseUserDO baseUserDO = noteBean.baseUserDO;
        if (baseUserDO != null) {
            this.a.setAvatarUrl(baseUserDO.headImg);
            this.a.setUserName(baseUserDO.nickName);
            this.a.setIsOldVip(baseUserDO.vip);
            String str = baseUserDO.userTypeCode;
            if (str != null) {
                this.a.setVip(false, baseUserDO.performFilmVipDO != null ? Integer.parseInt(str) == 2 ? String.valueOf(baseUserDO.userTypeCode) : baseUserDO.performFilmVipDO.memberFlag : k23.h());
                this.a.setTagName(baseUserDO.userTypeText);
                if (2 != Integer.parseInt(baseUserDO.userTypeCode)) {
                    this.a.setUserTagType(Integer.parseInt(baseUserDO.userTypeCode));
                } else {
                    this.a.showUserTagType(false);
                }
            } else {
                UserInfoView userInfoView = this.a;
                PerformFilmVipDO performFilmVipDO = baseUserDO.performFilmVipDO;
                userInfoView.setVip(false, performFilmVipDO != null ? performFilmVipDO.memberFlag : k23.h());
                this.a.showUserTagType(false);
            }
            this.a.setTag(baseUserDO);
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
        }
        t(!TextUtils.isEmpty(noteBean.similarity), noteBean.similarity, noteBean.goDnaUrl, "");
    }

    private void t(boolean z, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1087148011")) {
            ipChange.ipc$dispatch("-1087148011", new Object[]{this, Boolean.valueOf(z), str, str2, str3});
        } else if (z) {
            this.a.setDna(true, str + "%");
            this.a.setDnaClickListener(new c(str2));
        } else {
            this.a.setDna(false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1367653339")) {
            ipChange.ipc$dispatch("-1367653339", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            i = R$drawable.dm_icon_like_select;
        } else {
            i = R$drawable.dm_icon_like_unselect;
        }
        this.k.setImageResource(i);
    }

    public void c(boolean z, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1668436524")) {
            ipChange.ipc$dispatch("-1668436524", new Object[]{this, Boolean.valueOf(z), str, Integer.valueOf(i)});
        }
    }

    public void dnaOnClickReport(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-806595434")) {
            ipChange.ipc$dispatch("-806595434", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolder
    /* renamed from: h */
    public void a(NoteBean noteBean, int i) {
        TextView textView;
        String contentInfoText;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "701191423")) {
            ipChange.ipc$dispatch("701191423", new Object[]{this, noteBean, Integer.valueOf(i)});
            return;
        }
        this.p = noteBean;
        this.q = i;
        if (this.u) {
            this.w.setVisibility(8);
            this.x.setVisibility(0);
            textView = this.y;
            this.z.setVisibility(noteBean.isFeature() ? 0 : 8);
        } else {
            r(noteBean);
            this.w.setVisibility(0);
            this.x.setVisibility(8);
            textView = this.c;
            this.b.setVisibility(noteBean.isFeature() ? 0 : 8);
        }
        if (this.u) {
            contentInfoText = noteBean.content;
        } else {
            contentInfoText = noteBean.getContentInfoText();
        }
        n(rh2.a(contentInfoText), textView);
        o(noteBean.imgList, noteBean.videoInfo);
        CommentPraiseInfoBean commentPraiseInfoBean = new CommentPraiseInfoBean();
        commentPraiseInfoBean.setPraiseCount(noteBean.praiseInfo.praiseCount + "");
        commentPraiseInfoBean.setHasPraised(noteBean.praiseInfo.hasPraised);
        this.i.setData(commentPraiseInfoBean, noteBean.sourceId);
        this.i.setOnPraiseLayoutClickListenerCommon(new b(i));
        if (this.u) {
            this.j.setVisibility(8);
        } else {
            q(this.l, noteBean.focusCount, "想看");
            this.j.setOnClickListener(this);
            boolean z = noteBean.focus;
            this.s = z;
            u(z);
            this.j.setVisibility(0);
        }
        if (this.u) {
            this.h.setVisibility(8);
        } else {
            this.h.setTag(noteBean.shareDO);
            this.h.setOnClickListener(this);
            this.h.setVisibility(noteBean.shareDO == null ? 8 : 0);
        }
        this.itemView.setTag(noteBean);
        this.itemView.setOnClickListener(this);
        k(this.itemView, noteBean, i);
        if (this.u && !this.p.prohibitEditing) {
            this.A.setVisibility(0);
            this.A.setOnClickListener(this);
        } else {
            this.A.setVisibility(8);
        }
        this.f.setVisibility(noteBean.relatedInfo == null ? 8 : 0);
        RelatedInfo relatedInfo = noteBean.relatedInfo;
        if (relatedInfo != null) {
            TextView textView2 = this.g;
            String str = relatedInfo.value;
            textView2.setText(str != null ? str : "");
        }
    }

    public void i(GridBean gridBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1421436764")) {
            ipChange.ipc$dispatch("-1421436764", new Object[]{this, gridBean, Integer.valueOf(i)});
            return;
        }
        NineJumpBean nineJumpBean = this.v;
        if (nineJumpBean == null || this.r == null) {
            return;
        }
        int computePosition2NextPage = nineJumpBean.computePosition2NextPage(i);
        NineImgUtil a2 = NineImgUtil.a();
        Context context = this.r;
        NineJumpBean nineJumpBean2 = this.v;
        a2.d(context, 0L, nineJumpBean2.videoInfoList, nineJumpBean2.picInfoList, computePosition2NextPage);
    }

    public List<BottomActionDialog.Action> j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1913106118")) {
            return (List) ipChange.ipc$dispatch("-1913106118", new Object[]{this});
        }
        return null;
    }

    public void k(View view, NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-266288113")) {
            ipChange.ipc$dispatch("-266288113", new Object[]{this, view, noteBean, Integer.valueOf(i)});
        }
    }

    public void l(NoteBean noteBean, BottomActionDialog.Action action, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2054631045")) {
            ipChange.ipc$dispatch("2054631045", new Object[]{this, noteBean, action, Integer.valueOf(i)});
        }
    }

    public void likeOnClickReport(boolean z, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1801808118")) {
            ipChange.ipc$dispatch("-1801808118", new Object[]{this, Boolean.valueOf(z), str, Integer.valueOf(i)});
        }
    }

    public void m(String str, final View view, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-255043823")) {
            ipChange.ipc$dispatch("-255043823", new Object[]{this, str, view, str2, str3});
        } else if (str == null) {
        } else {
            boolean z = this.s;
            String str4 = "19:" + str;
            if (!z && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                str4 = str4 + "," + str2 + ":" + str3;
            }
            FollowRequest followRequest = new FollowRequest(!z, str4);
            view.setClickable(false);
            followRequest.request(new DMMtopRequestListener<FollowStateBean>(FollowStateBean.class) { // from class: cn.damai.commonbusiness.discover.viewholder.BigNoteViewHolder.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str5, String str6) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1251450427")) {
                        ipChange2.ipc$dispatch("-1251450427", new Object[]{this, str5, str6});
                        return;
                    }
                    Log.d(StarFragment.KEY_FOLLOW, "follow onfail : " + str5 + " , " + str6);
                    view.setClickable(true);
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(FollowStateBean followStateBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1342494643")) {
                        ipChange2.ipc$dispatch("-1342494643", new Object[]{this, followStateBean});
                        return;
                    }
                    boolean isFollowed = followStateBean.isFollowed();
                    BigNoteViewHolder bigNoteViewHolder = BigNoteViewHolder.this;
                    bigNoteViewHolder.s = isFollowed;
                    bigNoteViewHolder.u(isFollowed);
                    try {
                        NoteBean noteBean = BigNoteViewHolder.this.p;
                        if (noteBean != null) {
                            int i = noteBean.focusCount;
                            if (followStateBean.status.equals("0")) {
                                String str5 = ((Object) BigNoteViewHolder.this.l.getText()) + "";
                                if (str5 != null) {
                                    try {
                                        i = Integer.parseInt(str5);
                                    } catch (NumberFormatException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (i > 0) {
                                    i--;
                                }
                            } else {
                                i++;
                            }
                            BigNoteViewHolder bigNoteViewHolder2 = BigNoteViewHolder.this;
                            bigNoteViewHolder2.q(bigNoteViewHolder2.l, i, "想看");
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    view.setClickable(true);
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NoteBean noteBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1314210896")) {
            ipChange.ipc$dispatch("1314210896", new Object[]{this, view});
        } else if (this.p == null) {
        } else {
            if (view.getId() == R$id.content_detail_user_info) {
                NoteBean noteBean2 = this.p;
                userOnClickReport(noteBean2.contentInfo.id, noteBean2.baseUserDO.havanaIdStr, this.q);
                BaseUserDO baseUserDO = (BaseUserDO) view.getTag();
                Bundle bundle = new Bundle();
                String str = baseUserDO.havanaIdStr;
                if (str == null) {
                    str = baseUserDO.havanaId;
                }
                bundle.putString("userId", str);
                bundle.putString(RepertoireDetailFragment.USERTYPE, "1");
                DMNav.from(this.r).withExtras(bundle).toUri(NavUri.b(cs.Y));
            } else if (view.getId() == R$id.comment_like_layout) {
                NoteBean noteBean3 = this.p;
                if (noteBean3 != null) {
                    String str2 = noteBean3.contentInfo.id;
                    BaseUserDO baseUserDO2 = noteBean3.baseUserDO;
                    m(str2, view, baseUserDO2.havanaIdStr, baseUserDO2.targetType);
                    likeOnClickReport(this.s, this.p.contentInfo.id, this.q);
                }
            } else if (view.getId() == R$id.tv_share) {
                ContentShareInfo contentShareInfo = (ContentShareInfo) view.getTag();
                if (contentShareInfo == null) {
                    return;
                }
                s(this.p, contentShareInfo, this.q);
            } else if (view.getId() == R$id.note_more_action) {
                List<BottomActionDialog.Action> j = j();
                if (cb2.d(j) || this.r == null) {
                    return;
                }
                new BottomActionDialog(this.r, new d(), j).show();
            } else {
                OnItemClickListener<NoteBean> onItemClickListener = this.o;
                if (onItemClickListener == null || (noteBean = this.p) == null) {
                    return;
                }
                onItemClickListener.onItemClick(noteBean, this.q);
            }
        }
    }

    public void p(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-241909301")) {
            ipChange.ipc$dispatch("-241909301", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        View view = this.n;
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i;
            this.n.requestLayout();
        }
    }

    public void s(NoteBean noteBean, ContentShareInfo contentShareInfo, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1330543955")) {
            ipChange.ipc$dispatch("-1330543955", new Object[]{this, noteBean, contentShareInfo, Integer.valueOf(i)});
        }
    }

    public void userOnClickReport(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2037808266")) {
            ipChange.ipc$dispatch("-2037808266", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
    }
}
