package tb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.commonbusiness.servicenotice.TicketNote;
import cn.damai.commonbusiness.servicenotice.TicketNoteList;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.projectdetail.bean.ProjectDetailCommentBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.anchor.AnchorManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.BrandAndArtists;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.HighLights;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.InFieldCommentsBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.NoticeMatter;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDynamicExtDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectItemDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectRecommendBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticExtendInfoBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.RichTextModule;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class pv1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private Context b;
    private String c;
    private List<ProjectDataHolder> d;
    private ProjectDataHolder e;
    private ProjectDataHolder f;
    private ProjectDataHolder g;
    private List<ProjectDataHolder> h;
    private ProjectDataHolder i;
    private List<ProjectDataHolder> j;
    private List<ProjectDataHolder> k;
    private List<ProjectDataHolder> l;
    private List<ProjectDataHolder> m;
    private List<ProjectDataHolder> n;
    private List<ProjectDataHolder> o;
    private IRichTextManager p;
    private IRichTextManager q;
    private IRichTextManager r;
    private IRichTextManager s;
    private LinkedHashMap<Integer, IRichTextManager> t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private AnchorManager z;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements AnchorManager.OnGetAnchorName {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.anchor.AnchorManager.OnGetAnchorName
        public String onAnchorName(AnchorManager.AnchorType anchorType) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "217401776")) {
                return (String) ipChange.ipc$dispatch("217401776", new Object[]{this, anchorType});
            }
            int i = b.a[anchorType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return i != 4 ? "" : pv1.this.b.getResources().getString(R$string.str_project_detail_tab_recommend);
                    }
                    return pv1.this.b.getResources().getString(R$string.str_project_detail_tab_comment);
                }
                return pv1.this.b.getResources().getString(R$string.str_project_detail_tab_notice);
            }
            return pv1.this.b.getResources().getString(R$string.str_project_detail_tab_detail);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnchorManager.AnchorType.values().length];
            a = iArr;
            try {
                iArr[AnchorManager.AnchorType.DETAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AnchorManager.AnchorType.NOTICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AnchorManager.AnchorType.COMMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AnchorManager.AnchorType.RECOMMEND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public pv1(Context context) {
        this.b = context;
        T();
        x();
        this.d = new ArrayList();
        this.h = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.l = new ArrayList();
        this.o = new ArrayList();
        yv1.k(this.b);
        IRichTextManager j = p32.j(this.b, true);
        this.p = j;
        j.setRichType(1);
        IRichTextManager j2 = p32.j(this.b, false);
        this.q = j2;
        j2.setRichType(3);
        IRichTextManager j3 = p32.j(this.b, false);
        this.r = j3;
        j3.setRichType(2);
        this.t = new LinkedHashMap<>();
        IRichTextManager j4 = p32.j(this.b, false);
        this.s = j4;
        j4.setRichType(4);
    }

    private void A(ProjectDynamicExtDataBean projectDynamicExtDataBean, String str) {
        String s;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1577400500")) {
            ipChange.ipc$dispatch("1577400500", new Object[]{this, projectDynamicExtDataBean, str});
        } else if (projectDynamicExtDataBean != null && !m91.a(projectDynamicExtDataBean.brandArtists)) {
            int e = wh2.e(projectDynamicExtDataBean.brandArtists);
            if (e == 1) {
                BrandAndArtists brandAndArtists = projectDynamicExtDataBean.brandArtists.get(0);
                if (brandAndArtists == null) {
                    return;
                }
                if (brandAndArtists.type == 1) {
                    this.g = new ProjectDataHolder(32);
                } else {
                    this.g = new ProjectDataHolder(33);
                }
                this.g.brandOrArtists = brandAndArtists;
            } else if (e > 1) {
                boolean z = false;
                boolean z2 = false;
                for (BrandAndArtists brandAndArtists2 : projectDynamicExtDataBean.brandArtists) {
                    if (brandAndArtists2.type == 2) {
                        z = true;
                    } else {
                        z2 = true;
                    }
                    if (z && z2) {
                        break;
                    }
                }
                if (z && z2) {
                    s = s(R$string.project_title_brand_and_artist);
                } else if (z) {
                    s = s(R$string.project_title_brand);
                } else {
                    s = s(R$string.project_item_title_show_lineup);
                }
                ProjectDataHolder projectDataHolder = new ProjectDataHolder(31);
                this.g = projectDataHolder;
                projectDataHolder.brandAndArtistsList = projectDynamicExtDataBean.brandArtists;
                projectDataHolder.brandAndArtistsTitle = s;
            }
            ProjectDataHolder projectDataHolder2 = this.g;
            if (projectDataHolder2 != null) {
                projectDataHolder2.setTheaterValue(str);
                this.g.setProjectId(this.c);
                if (str != null && str.equals("1")) {
                    this.g.isTheater = true;
                } else {
                    this.g.isTheater = false;
                }
            }
        }
    }

    private void B(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2027380056")) {
            ipChange.ipc$dispatch("2027380056", new Object[]{this, list});
            return;
        }
        this.n.clear();
        if (wh2.e(list) > 0) {
            this.n.add(l(6, ""));
            ProjectDataHolder projectDataHolder = new ProjectDataHolder(4);
            projectDataHolder.setCommonProblems(list);
            projectDataHolder.setModuleDataBind(false);
            projectDataHolder.setProjectId(this.c);
            this.n.add(projectDataHolder);
            this.y = true;
        }
    }

    private void C(List<InFieldCommentsBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-839475049")) {
            ipChange.ipc$dispatch("-839475049", new Object[]{this, list});
        } else if (m91.a(list)) {
        } else {
            ProjectDataHolder projectDataHolder = new ProjectDataHolder(30);
            this.i = projectDataHolder;
            projectDataHolder.inFieldComments = list;
            projectDataHolder.setProjectId(this.c);
        }
    }

    private void D(ProjectDetailCommentBean projectDetailCommentBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1792122965")) {
            ipChange.ipc$dispatch("-1792122965", new Object[]{this, projectDetailCommentBean});
            return;
        }
        this.k.clear();
        if (projectDetailCommentBean == null || !projectDetailCommentBean.getConfig().isShowModule()) {
            return;
        }
        String total = projectDetailCommentBean.getTotal();
        if (TextUtils.isEmpty(total)) {
            total = "0";
        }
        ProjectDataHolder projectDataHolder = new ProjectDataHolder(17);
        if (wh2.k(total) <= 0) {
            projectDataHolder.setDiscussionContent(k(R$string.project_title_discussion_area, ""));
            projectDataHolder.setDiscussionTips("去抢沙发");
        } else {
            projectDataHolder.setDiscussionContent(k(R$string.project_title_discussion_area, total));
            projectDataHolder.setDiscussionTips("");
        }
        this.k.add(projectDataHolder);
    }

    private void E(ProjectDetailCommentBean projectDetailCommentBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1924687119")) {
            ipChange.ipc$dispatch("-1924687119", new Object[]{this, projectDetailCommentBean});
            return;
        }
        d();
        if (projectDetailCommentBean == null || projectDetailCommentBean.getConfig() == null || !projectDetailCommentBean.getConfig().isShowModule()) {
            return;
        }
        J(projectDetailCommentBean.getUserComments());
        List<CommentsItemBean> moduleComments = projectDetailCommentBean.getModuleComments();
        if (moduleComments != null && !moduleComments.isEmpty()) {
            this.j.add(l(0, "观众热评"));
        }
        F(moduleComments, projectDetailCommentBean.getTotal());
        if (wh2.e(moduleComments) > 0) {
            G(projectDetailCommentBean.getTotal());
        }
    }

    private void F(List<CommentsItemBean> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1084329732")) {
            ipChange.ipc$dispatch("-1084329732", new Object[]{this, list, str});
            return;
        }
        int e = wh2.e(list);
        if (e > 0) {
            int k = wh2.k(str);
            for (int i = 0; i < e; i++) {
                ProjectDataHolder projectDataHolder = new ProjectDataHolder(9);
                projectDataHolder.setCommentPosition(i);
                projectDataHolder.setModuleComment(list.get(i));
                projectDataHolder.setCommentNum(e);
                projectDataHolder.setCommentTotalNum(k);
                this.j.add(projectDataHolder);
            }
        }
    }

    private void G(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1251808388")) {
            ipChange.ipc$dispatch("1251808388", new Object[]{this, str});
            return;
        }
        ProjectDataHolder projectDataHolder = new ProjectDataHolder(7);
        projectDataHolder.setMoreType(2);
        projectDataHolder.setProjectId(this.c);
        String string = this.b.getResources().getString(R$string.trade_project_detail_show_all_evaluate);
        if (!TextUtils.isEmpty(str)) {
            string = this.b.getResources().getString(R$string.trade_project_detail_show_all_evaluate_num, str);
        }
        projectDataHolder.setMoreContent(string);
        this.j.add(projectDataHolder);
    }

    private void H(HighLights highLights) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1508452612")) {
            ipChange.ipc$dispatch("1508452612", new Object[]{this, highLights});
        } else if (highLights != null && highLights.getContent() != null && !highLights.getContent().isEmpty()) {
            String title = highLights.getTitle();
            ProjectDataHolder l = TextUtils.isEmpty(title) ? null : l(8, title);
            List<String> content = highLights.getContent();
            int e = wh2.e(content);
            if (e > 0) {
                StringBuilder sb = new StringBuilder();
                if (e == 1) {
                    String str2 = content.get(0);
                    if (!TextUtils.isEmpty(str2)) {
                        sb.append(str2);
                        sb.append(StringUtils.LF);
                    }
                } else {
                    for (int i = 0; i < e; i++) {
                        String str3 = content.get(i);
                        if (!TextUtils.isEmpty(str3)) {
                            sb.append("• ");
                            sb.append(str3);
                            sb.append(StringUtils.LF);
                        }
                    }
                }
                str = sb.toString();
                if (!TextUtils.isEmpty(str)) {
                    str = str.substring(0, str.lastIndexOf(StringUtils.LF));
                }
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ProjectDataHolder projectDataHolder = new ProjectDataHolder(13);
            projectDataHolder.setHighLightContent(str);
            if (l != null) {
                this.o.add(l);
            }
            this.o.add(projectDataHolder);
        }
    }

    private void I(RichTextModule richTextModule) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "973385158")) {
            ipChange.ipc$dispatch("973385158", new Object[]{this, richTextModule});
        } else {
            this.p.parseRichText(richTextModule);
        }
    }

    private void J(List<CommentsItemBean> list) {
        CommentsItemBean commentsItemBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-752176721")) {
            ipChange.ipc$dispatch("-752176721", new Object[]{this, list});
        } else if (list == null || list.isEmpty() || (commentsItemBean = list.get(0)) == null) {
        } else {
            ProjectDataHolder projectDataHolder = new ProjectDataHolder(0);
            this.e = projectDataHolder;
            projectDataHolder.setUserCommentItemBean(commentsItemBean);
            this.e.setModuleDataBind(false);
        }
    }

    private void K(NoticeMatter noticeMatter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "370534127")) {
            ipChange.ipc$dispatch("370534127", new Object[]{this, noticeMatter});
            return;
        }
        List<TicketNoteList> noticeList = noticeMatter.getNoticeList();
        for (int i = 0; i < wh2.e(noticeList); i++) {
            TicketNoteList ticketNoteList = noticeList.get(i);
            if (ticketNoteList != null && wh2.e(ticketNoteList.getTicketNoteList()) > 0) {
                h(i, ticketNoteList);
                this.y = true;
            }
        }
    }

    private void L(List<RichTextModule> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-550800099")) {
            ipChange.ipc$dispatch("-550800099", new Object[]{this, list});
        } else if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int i2 = i + 5;
                IRichTextManager iRichTextManager = this.t.get(Integer.valueOf(i2));
                if (iRichTextManager == null) {
                    iRichTextManager = p32.j(this.b, false);
                    iRichTextManager.setRichType(i2);
                    this.t.put(Integer.valueOf(i2), iRichTextManager);
                }
                iRichTextManager.parseRichText(list.get(i));
            }
        }
    }

    private void M(RichTextModule richTextModule) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "282965414")) {
            ipChange.ipc$dispatch("282965414", new Object[]{this, richTextModule});
        } else {
            this.r.parseRichText(richTextModule);
        }
    }

    private void N(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1539384294")) {
            ipChange.ipc$dispatch("1539384294", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str2)) {
        } else {
            this.q.parseRichText(str, str2);
        }
    }

    private void O(ProjectDynamicExtDataBean projectDynamicExtDataBean, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1917615766")) {
            ipChange.ipc$dispatch("-1917615766", new Object[]{this, projectDynamicExtDataBean, str});
            return;
        }
        A(projectDynamicExtDataBean, str);
        y(projectDynamicExtDataBean.getArtistsRichText());
    }

    private void P(ProjectItemDataBean projectItemDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1976319531")) {
            ipChange.ipc$dispatch("-1976319531", new Object[]{this, projectItemDataBean});
        } else if (projectItemDataBean != null) {
            z(projectItemDataBean.getBannerPicUrl(), projectItemDataBean.getBannerRedirectUrl());
        }
    }

    private void Q(ProjectStaticDataBean projectStaticDataBean) {
        NoticeMatter noticeMatter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "770413685")) {
            ipChange.ipc$dispatch("770413685", new Object[]{this, projectStaticDataBean});
            return;
        }
        ProjectStaticExtendInfoBean projectStaticExtendInfoBean = null;
        if (projectStaticDataBean != null) {
            projectStaticExtendInfoBean = projectStaticDataBean.getItemExtendInfo();
            noticeMatter = projectStaticDataBean.getNoticeMatter();
        } else {
            noticeMatter = null;
        }
        if (projectStaticExtendInfoBean != null) {
            I(projectStaticExtendInfoBean.getImportantContent());
            H(projectStaticExtendInfoBean.getHighLightsVO());
            M(projectStaticExtendInfoBean.getOutlineContent());
            N(projectStaticExtendInfoBean.getItemDescTitle(), projectStaticExtendInfoBean.getItemExtend());
            L(projectStaticExtendInfoBean.getOtherContent());
        }
        if (noticeMatter == null || wh2.e(noticeMatter.getNoticeList()) <= 0) {
            return;
        }
        K(noticeMatter);
    }

    private void R(List<ProjectRecommendBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-403889450")) {
            ipChange.ipc$dispatch("-403889450", new Object[]{this, list});
            return;
        }
        int e = wh2.e(list);
        if (e <= 0 || this.x) {
            return;
        }
        this.l.clear();
        this.l.add(l(7, ""));
        for (int i = 0; i < e; i++) {
            ProjectRecommendBean projectRecommendBean = list.get(i);
            if (projectRecommendBean != null) {
                if (projectRecommendBean.project != null) {
                    ProjectDataHolder projectDataHolder = new ProjectDataHolder(5);
                    projectDataHolder.setRecommendItem(projectRecommendBean.project);
                    projectDataHolder.setRecommendItemPosition(i);
                    projectDataHolder.setRecommendListSize(e);
                    this.l.add(projectDataHolder);
                } else if (projectRecommendBean.freeTicket != null) {
                    ProjectDataHolder projectDataHolder2 = new ProjectDataHolder(27);
                    projectDataHolder2.setRecommendFreeTicketItem(projectRecommendBean.freeTicket);
                    projectDataHolder2.setRecommendItemPosition(i);
                    this.l.add(projectDataHolder2);
                }
            }
        }
        this.x = true;
    }

    private void S() {
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2076819270")) {
            ipChange.ipc$dispatch("2076819270", new Object[]{this});
            return;
        }
        this.d.clear();
        ProjectDataHolder projectDataHolder = this.f;
        if (projectDataHolder != null) {
            this.d.add(projectDataHolder);
        }
        ProjectDataHolder projectDataHolder2 = this.g;
        if (projectDataHolder2 != null && projectDataHolder2.isTheater) {
            if (projectDataHolder2.getModuleType() == 31) {
                this.d.add(t(10, this.g.brandAndArtistsTitle));
            } else if (this.g.getModuleType() == 32) {
                this.d.add(l(2, ""));
            } else {
                this.d.add(l(9, ""));
            }
            this.d.add(this.g);
        }
        this.a = 0;
        b(2, this.p);
        if (wh2.e(this.h) > 0) {
            this.d.addAll(this.h);
        }
        if (wh2.e(this.o) > 0) {
            this.p.setStartIndex(this.d.size() + 2);
            this.d.addAll(this.o);
        }
        b(2, this.r);
        b(2, this.q);
        this.d.add(new ProjectDataHolder(26));
        LinkedHashMap<Integer, IRichTextManager> linkedHashMap = this.t;
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            for (Map.Entry<Integer, IRichTextManager> entry : this.t.entrySet()) {
                b(2, entry.getValue());
            }
        }
        ProjectDataHolder projectDataHolder3 = this.g;
        if (projectDataHolder3 == null || projectDataHolder3.isTheater) {
            z = false;
        } else {
            if (projectDataHolder3.getModuleType() == 31) {
                this.d.add(t(10, this.g.brandAndArtistsTitle));
            } else if (this.g.getModuleType() == 32) {
                this.d.add(l(2, ""));
            } else {
                this.d.add(l(9, ""));
            }
            this.d.add(this.g);
            z = true;
        }
        IRichTextManager iRichTextManager = this.s;
        if (iRichTextManager != null && iRichTextManager.getDisplayRichItems() != null && !this.s.getDisplayRichItems().isEmpty()) {
            this.s.setStartIndex(this.d.size() + 2);
            if (this.s.hasExpanded()) {
                this.d.addAll(this.s.getDisplayRichItems());
            } else if (this.s.getShrinkRichItem() != null) {
                this.d.add(this.s.getShrinkRichItem());
            }
        }
        if (z) {
            ProjectDataHolder projectDataHolder4 = new ProjectDataHolder(28);
            projectDataHolder4.setShowLine(false);
            this.d.add(projectDataHolder4);
        }
        this.d.add(new ProjectDataHolder(20));
        int size = this.d.size() + 1;
        if (w()) {
            AnchorManager anchorManager = this.z;
            AnchorManager.AnchorType anchorType = AnchorManager.AnchorType.DETAIL;
            int i = this.a;
            this.a = i + 1;
            anchorManager.a(anchorType, i, 2, size);
        } else if (v()) {
            size += this.k.size() + 1;
            AnchorManager anchorManager2 = this.z;
            AnchorManager.AnchorType anchorType2 = AnchorManager.AnchorType.DETAIL;
            int i2 = this.a;
            this.a = i2 + 1;
            anchorManager2.a(anchorType2, i2, 2, size);
        } else {
            AnchorManager anchorManager3 = this.z;
            AnchorManager.AnchorType anchorType3 = AnchorManager.AnchorType.DETAIL;
            int i3 = this.a;
            this.a = i3 + 1;
            anchorManager3.a(anchorType3, i3, 2, size);
        }
        int i4 = size + 1;
        ProjectDataHolder projectDataHolder5 = this.i;
        if (projectDataHolder5 != null) {
            this.d.add(projectDataHolder5);
        }
        ProjectDataHolder projectDataHolder6 = this.e;
        if (projectDataHolder6 != null) {
            this.d.add(projectDataHolder6);
        }
        List<ProjectDataHolder> list = this.j;
        if (list != null && !list.isEmpty()) {
            this.d.addAll(this.j);
        }
        List<ProjectDataHolder> list2 = this.k;
        if (list2 != null && !list2.isEmpty()) {
            this.d.addAll(this.k);
        }
        if (w() || v()) {
            this.d.add(new ProjectDataHolder(20));
        }
        if (!w() && !u()) {
            this.z.l(AnchorManager.AnchorType.COMMENT);
        } else {
            int size2 = this.d.size() + 1;
            AnchorManager anchorManager4 = this.z;
            AnchorManager.AnchorType anchorType4 = AnchorManager.AnchorType.COMMENT;
            int i5 = this.a;
            this.a = i5 + 1;
            anchorManager4.a(anchorType4, i5, i4, size2);
            i4 = size2 + 1;
        }
        List<ProjectDataHolder> list3 = this.m;
        if (list3 != null && !list3.isEmpty()) {
            this.d.addAll(this.m);
        }
        if (wh2.e(this.n) > 0) {
            this.d.addAll(this.n);
        }
        if (this.y) {
            this.d.add(new ProjectDataHolder(20));
            int size3 = this.d.size() + 1;
            AnchorManager anchorManager5 = this.z;
            AnchorManager.AnchorType anchorType5 = AnchorManager.AnchorType.NOTICE;
            int i6 = this.a;
            this.a = i6 + 1;
            anchorManager5.a(anchorType5, i6, i4, size3);
            i4 = size3 + 1;
        } else {
            this.z.l(AnchorManager.AnchorType.NOTICE);
        }
        if (wh2.e(this.l) > 0) {
            this.d.addAll(this.l);
            this.z.a(AnchorManager.AnchorType.RECOMMEND, this.a, i4, this.d.size() + 1);
            return;
        }
        this.z.l(AnchorManager.AnchorType.RECOMMEND);
    }

    private void b(int i, IRichTextManager iRichTextManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "557602526")) {
            ipChange.ipc$dispatch("557602526", new Object[]{this, Integer.valueOf(i), iRichTextManager});
        } else if (iRichTextManager == null) {
        } else {
            ProjectDataHolder geTitle = iRichTextManager.geTitle();
            if (iRichTextManager.showAllRichText()) {
                if (wh2.e(iRichTextManager.getDisplayRichItems()) > 0) {
                    iRichTextManager.setStartIndex(i + this.d.size());
                    c(geTitle);
                    this.d.addAll(iRichTextManager.getDisplayRichItems());
                }
            } else if (iRichTextManager.hasExpanded()) {
                if (iRichTextManager.getDisplayRichItems() == null || iRichTextManager.getDisplayRichItems().isEmpty()) {
                    return;
                }
                iRichTextManager.setStartIndex(i + this.d.size());
                c(geTitle);
                this.d.addAll(iRichTextManager.getDisplayRichItems());
            } else if (iRichTextManager.getShrinkRichItem() != null) {
                iRichTextManager.setStartIndex(i + this.d.size());
                c(geTitle);
                this.d.add(iRichTextManager.getShrinkRichItem());
            }
        }
    }

    private void c(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-761085446")) {
            ipChange.ipc$dispatch("-761085446", new Object[]{this, projectDataHolder});
        } else if (projectDataHolder != null) {
            this.d.add(projectDataHolder);
        }
    }

    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1548078910")) {
            ipChange.ipc$dispatch("1548078910", new Object[]{this});
            return;
        }
        this.e = null;
        this.j.clear();
    }

    private void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-724307701")) {
            ipChange.ipc$dispatch("-724307701", new Object[]{this});
            return;
        }
        this.g = null;
        this.s.clear();
        this.h.clear();
    }

    private void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1044206153")) {
            ipChange.ipc$dispatch("-1044206153", new Object[]{this});
        } else {
            this.f = null;
        }
    }

    private void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1875342638")) {
            ipChange.ipc$dispatch("-1875342638", new Object[]{this});
            return;
        }
        this.p.clear();
        this.r.clear();
        this.o.clear();
        this.q.clear();
        for (Map.Entry<Integer, IRichTextManager> entry : this.t.entrySet()) {
            entry.getValue().clear();
        }
        this.n.clear();
        this.m.clear();
    }

    private void h(int i, TicketNoteList ticketNoteList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-798461216")) {
            ipChange.ipc$dispatch("-798461216", new Object[]{this, Integer.valueOf(i), ticketNoteList});
            return;
        }
        String noteTitle = ticketNoteList.getNoteTitle();
        ProjectDataHolder projectDataHolder = new ProjectDataHolder(6);
        projectDataHolder.setSectionTitleContent(noteTitle);
        projectDataHolder.setSubTitlePosition(i);
        this.m.add(projectDataHolder);
        int i2 = i == 0 ? 3 : 4;
        List<TicketNote> ticketNoteList2 = ticketNoteList.getTicketNoteList();
        int e = wh2.e(ticketNoteList2);
        int i3 = e <= 8 ? e : 8;
        for (int i4 = 0; i4 < (i3 / 2) + (i3 % 2); i4++) {
            ProjectDataHolder projectDataHolder2 = new ProjectDataHolder(14);
            int i5 = i4 * 2;
            projectDataHolder2.setTicketNote(ticketNoteList2.get(i5));
            projectDataHolder2.setTicketNotePosition(i5 == i3 + (-1) || i5 == i3 + (-2));
            projectDataHolder2.setMoreType(i2);
            int i6 = i5 + 1;
            if (i6 < e) {
                projectDataHolder2.setTicketNote2rd(ticketNoteList2.get(i6));
            }
            this.m.add(projectDataHolder2);
        }
        ProjectDataHolder projectDataHolder3 = new ProjectDataHolder(7);
        projectDataHolder3.setMoreType(i2);
        projectDataHolder3.setProjectId(this.c);
        if (e > 3) {
            projectDataHolder3.setMoreContent(m(i2, String.valueOf(e), noteTitle));
        } else {
            projectDataHolder3.setMoreContent(m(i2, "", ""));
        }
        this.m.add(projectDataHolder3);
        ProjectDataHolder projectDataHolder4 = new ProjectDataHolder(28);
        projectDataHolder4.setShowLine(true);
        this.m.add(projectDataHolder4);
    }

    @SuppressLint({"NewApi"})
    private SpannableString k(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1841841177")) {
            return (SpannableString) ipChange.ipc$dispatch("1841841177", new Object[]{this, Integer.valueOf(i), str});
        }
        String string = this.b.getResources().getString(i);
        if (!TextUtils.isEmpty(str)) {
            String str2 = "（" + str + "条）";
            SpannableString spannableString = new SpannableString(string + str2);
            int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
            int length2 = spannableString.length();
            spannableString.setSpan(new AbsoluteSizeSpan(18, true), length2 - length, length2, 33);
            return spannableString;
        }
        return new SpannableString(string);
    }

    private ProjectDataHolder l(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-207808655")) {
            return (ProjectDataHolder) ipChange.ipc$dispatch("-207808655", new Object[]{this, Integer.valueOf(i), str});
        }
        if (i != 0) {
            if (i == 1) {
                str = s(R$string.project_item_title_moments);
            } else if (i == 2) {
                str = s(R$string.project_item_title_show_lineup);
            } else if (i == 4) {
                str = s(R$string.project_item_title_evaluate);
            } else if (i == 6) {
                str = s(R$string.project_title_common_problems);
            } else if (i == 7) {
                str = s(R$string.project_title_recommend);
            } else if (i == 9) {
                str = s(R$string.project_title_brand);
            } else if (i == 10) {
                str = s(R$string.project_title_brand_and_artist);
            }
        } else if (TextUtils.isEmpty(str)) {
            str = s(R$string.project_title_introduce);
        }
        ProjectDataHolder projectDataHolder = new ProjectDataHolder(6);
        projectDataHolder.setSectionTitleType(i);
        projectDataHolder.setSectionTitleContent(str);
        return projectDataHolder;
    }

    private String m(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1204564144")) {
            return (String) ipChange.ipc$dispatch("1204564144", new Object[]{this, Integer.valueOf(i), str, str2});
        }
        if (i == 0) {
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb.append(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            sb.append(str2);
            return sb.toString();
        } else if (i == 3 || i == 4) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("全部");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb2.append(str);
            sb2.append("条");
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            sb2.append(str2);
            return sb2.toString();
        } else {
            return "";
        }
    }

    private String s(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-257667991") ? (String) ipChange.ipc$dispatch("-257667991", new Object[]{this, Integer.valueOf(i)}) : this.b.getResources().getString(i);
    }

    private ProjectDataHolder t(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1321229016")) {
            return (ProjectDataHolder) ipChange.ipc$dispatch("1321229016", new Object[]{this, Integer.valueOf(i), str});
        }
        ProjectDataHolder projectDataHolder = new ProjectDataHolder(6);
        projectDataHolder.setSectionTitleType(i);
        projectDataHolder.setSectionTitleContent(str);
        return projectDataHolder;
    }

    private boolean u() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1588120950") ? ((Boolean) ipChange.ipc$dispatch("1588120950", new Object[]{this})).booleanValue() : this.i != null;
    }

    private boolean v() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1927620439")) {
            return ((Boolean) ipChange.ipc$dispatch("1927620439", new Object[]{this})).booleanValue();
        }
        List<ProjectDataHolder> list = this.k;
        return (list == null || list.isEmpty()) ? false : true;
    }

    private boolean w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1346364730")) {
            return ((Boolean) ipChange.ipc$dispatch("-1346364730", new Object[]{this})).booleanValue();
        }
        return (this.e != null) || (wh2.e(this.j) > 0);
    }

    private void x() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-68843539")) {
            ipChange.ipc$dispatch("-68843539", new Object[]{this});
        } else {
            this.z = AnchorManager.g(new a());
        }
    }

    private void y(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-228461207")) {
            ipChange.ipc$dispatch("-228461207", new Object[]{this, list});
        } else if (wh2.e(list) > 0) {
            String combineRichText = this.s.combineRichText(list);
            if (TextUtils.isEmpty(combineRichText)) {
                return;
            }
            this.s.parseRichText("", combineRichText);
        }
    }

    private void z(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1605281051")) {
            ipChange.ipc$dispatch("-1605281051", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            ProjectDataHolder projectDataHolder = new ProjectDataHolder(8);
            this.f = projectDataHolder;
            projectDataHolder.setProjectId(this.c);
            this.f.setBannerPicUrl(str);
            this.f.setBannerRedirectUrl(str2);
        }
    }

    public void T() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "135887")) {
            ipChange.ipc$dispatch("135887", new Object[]{this});
            return;
        }
        this.v = false;
        this.u = false;
        this.w = false;
        this.x = false;
        this.y = false;
    }

    public AnchorManager i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "311437389") ? (AnchorManager) ipChange.ipc$dispatch("311437389", new Object[]{this}) : this.z;
    }

    public ProjectDataHolder j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2137228490") ? (ProjectDataHolder) ipChange.ipc$dispatch("-2137228490", new Object[]{this}) : this.g;
    }

    public ProjectDataHolder n() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "642381114") ? (ProjectDataHolder) ipChange.ipc$dispatch("642381114", new Object[]{this}) : new ProjectDataHolder(15);
    }

    public List<ProjectDataHolder> o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "292893006")) {
            return (List) ipChange.ipc$dispatch("292893006", new Object[]{this});
        }
        S();
        return this.d;
    }

    public List<ProjectDataHolder> p(ProjectStaticDataBean projectStaticDataBean, ProjectDynamicExtDataBean projectDynamicExtDataBean, ProjectDetailCommentBean projectDetailCommentBean, ProjectDetailCommentBean projectDetailCommentBean2, List<ProjectRecommendBean> list, ProjectItemDataBean projectItemDataBean, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1994785222")) {
            return (List) ipChange.ipc$dispatch("-1994785222", new Object[]{this, projectStaticDataBean, projectDynamicExtDataBean, projectDetailCommentBean, projectDetailCommentBean2, list, projectItemDataBean, str});
        }
        this.a = 0;
        this.c = str;
        if (!this.v) {
            f();
            if (projectItemDataBean != null) {
                P(projectItemDataBean);
                this.v = true;
            }
        }
        if (!this.w) {
            e();
            if (projectDynamicExtDataBean != null) {
                O(projectDynamicExtDataBean, projectStaticDataBean != null ? projectStaticDataBean.getTheater_status() : "2");
                this.w = true;
            }
        }
        if (!this.u) {
            g();
            if (projectStaticDataBean != null) {
                Q(projectStaticDataBean);
                this.u = true;
            }
        }
        List<String> faqs = projectStaticDataBean != null ? projectStaticDataBean.getFaqs() : null;
        if (wh2.e(faqs) == 0) {
            faqs = ov1.a(this.b);
        }
        B(faqs);
        if (projectDynamicExtDataBean != null) {
            C(projectDynamicExtDataBean.inFieldComments);
        }
        E(projectDetailCommentBean);
        D(projectDetailCommentBean2);
        R(list);
        S();
        return this.d;
    }

    public LinkedHashMap<String, Integer> q(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1440359818")) {
            return (LinkedHashMap) ipChange.ipc$dispatch("1440359818", new Object[]{this, Integer.valueOf(i)});
        }
        if (i == 1) {
            return this.p.getItemImages();
        }
        if (i == 2) {
            return this.r.getItemImages();
        }
        if (i == 3) {
            return this.q.getItemImages();
        }
        if (i == 4) {
            return this.s.getItemImages();
        }
        return this.t.get(Integer.valueOf(i)).getItemImages();
    }

    public IRichTextManager r(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1408416265")) {
            return (IRichTextManager) ipChange.ipc$dispatch("1408416265", new Object[]{this, Integer.valueOf(i)});
        }
        if (i == 1) {
            return this.p;
        }
        if (i == 2) {
            return this.r;
        }
        if (i == 3) {
            return this.q;
        }
        if (i == 4) {
            return this.s;
        }
        LinkedHashMap<Integer, IRichTextManager> linkedHashMap = this.t;
        if (linkedHashMap != null) {
            return linkedHashMap.get(Integer.valueOf(i));
        }
        return null;
    }
}
