package cn.damai.tetris.component.star.content.base;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.login.LoginManager;
import cn.damai.player.DMVideoPlayer;
import cn.damai.tetris.component.star.content.base.bean.ContentItemBean;
import cn.damai.tetris.component.star.content.base.bean.ContentVideoBean;
import cn.damai.tetris.component.star.content.common.ContentPraiseRequest;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.view.ClickGrayImageView;
import cn.damai.uikit.view.NineGridlayout;
import cn.damai.uikit.view.RoundImageView;
import cn.damai.uikit.view.StrokeLinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.android.utils.OPRUtils;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONObject;
import tb.ao;
import tb.cs;
import tb.lf2;
import tb.t60;
import tb.wh2;
import tb.yr2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ContentBaseViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private BasePresenter b;
    private String c;
    private boolean d;
    private int e;
    private TextView f;
    private TextView g;
    private TextView h;
    private StrokeLinearLayout i;
    private FrameLayout j;
    private RoundImageView k;
    private ImageView l;
    private TextView m;
    private DMVideoPlayer n;
    private NineGridlayout o;
    private TextView p;
    private TextView q;
    private TextView r;
    private boolean s;
    private View t;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.star.content.base.ContentBaseViewHolder$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1963a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ContentItemBean a;
        final /* synthetic */ int b;

        View$OnClickListenerC1963a(ContentItemBean contentItemBean, int i) {
            this.a = contentItemBean;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "807092062")) {
                ipChange.ipc$dispatch("807092062", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("contentId", this.a.getContentId());
            DMNav.from(ContentBaseViewHolder.this.a).withExtras(bundle).toUri(NavUri.b(cs.DISCOVER_CONTENT_DETAIL));
            Map<String, String> a = ao.a(ContentBaseViewHolder.this.b.getModel().getTrackInfo().getArgsMap(), this.a.getContentId(), this.a.getCard());
            BasePresenter basePresenter = ContentBaseViewHolder.this.b;
            basePresenter.userTrackClick("card_" + this.b, a, true);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.star.content.base.ContentBaseViewHolder$b */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1964b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ContentItemBean a;
        final /* synthetic */ int b;

        View$OnClickListenerC1964b(ContentItemBean contentItemBean, int i) {
            this.a = contentItemBean;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "734705504")) {
                ipChange.ipc$dispatch("734705504", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("contentId", this.a.getContentId());
            DMNav.from(ContentBaseViewHolder.this.a).withExtras(bundle).toUri(NavUri.b(cs.DISCOVER_CONTENT_DETAIL));
            Map<String, String> a = ao.a(ContentBaseViewHolder.this.b.getModel().getTrackInfo().getArgsMap(), this.a.getContentId(), this.a.getCard());
            BasePresenter basePresenter = ContentBaseViewHolder.this.b;
            basePresenter.userTrackClick("card_" + this.b, a, true);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.star.content.base.ContentBaseViewHolder$c */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1965c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ List a;
        final /* synthetic */ ContentItemBean b;
        final /* synthetic */ int c;

        View$OnClickListenerC1965c(List list, ContentItemBean contentItemBean, int i) {
            this.a = list;
            this.b = contentItemBean;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View view2;
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "-1448971423")) {
                ipChange.ipc$dispatch("-1448971423", new Object[]{this, view});
                return;
            }
            if (view instanceof NineGridlayout) {
                view2 = (NineGridlayout) view;
            } else if (!(view instanceof ClickGrayImageView)) {
                return;
            } else {
                view2 = (ClickGrayImageView) view;
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("images", (ArrayList) this.a);
            if (view2.getTag() != null) {
                try {
                    i = Integer.parseInt(view2.getTag() + "");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            bundle.putInt("location", i);
            DMNav.from(ContentBaseViewHolder.this.a).withExtras(bundle).toUri(NavUri.b("gallery_images"));
            Map<String, String> a = ao.a(ContentBaseViewHolder.this.b.getModel().getTrackInfo().getArgsMap(), this.b.getContentId(), this.b.getCard());
            BasePresenter basePresenter = ContentBaseViewHolder.this.b;
            basePresenter.userTrackClick("card_" + this.c, a, true);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.star.content.base.ContentBaseViewHolder$d */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1966d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ContentItemBean a;
        final /* synthetic */ int b;

        View$OnClickListenerC1966d(ContentItemBean contentItemBean, int i) {
            this.a = contentItemBean;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "662318946")) {
                ipChange.ipc$dispatch("662318946", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("contentId", this.a.getContentId());
            DMNav.from(ContentBaseViewHolder.this.a).withExtras(bundle).toUri(NavUri.b(cs.DISCOVER_CONTENT_DETAIL));
            Map<String, String> a = ao.a(ContentBaseViewHolder.this.b.getModel().getTrackInfo().getArgsMap(), this.a.getContentId(), this.a.getCard());
            BasePresenter basePresenter = ContentBaseViewHolder.this.b;
            basePresenter.userTrackClick("card_" + this.b, a, true);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.star.content.base.ContentBaseViewHolder$e */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1967e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ContentItemBean a;
        final /* synthetic */ int b;

        View$OnClickListenerC1967e(ContentItemBean contentItemBean, int i) {
            this.a = contentItemBean;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1521357981")) {
                ipChange.ipc$dispatch("-1521357981", new Object[]{this, view});
                return;
            }
            ContentVideoBean video = this.a.getVideo();
            if (video != null) {
                Bundle bundle = new Bundle();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                VideoInfo videoInfo = new VideoInfo();
                videoInfo.setPicUrl(video.getPicUrl());
                if (!TextUtils.isEmpty(video.getVid())) {
                    videoInfo.setVid(video.getVid());
                    videoInfo.setType(VideoInfo.VideoType.VIDEO_VID);
                } else if (!TextUtils.isEmpty(video.getVideoUrl())) {
                    videoInfo.setVideoUrl(video.getVideoUrl());
                    videoInfo.setType(VideoInfo.VideoType.VIDEO_URL);
                }
                arrayList.add(videoInfo);
                bundle.putParcelableArrayList("video_info", arrayList);
                bundle.putInt("position", 0);
                DMNav.from(ContentBaseViewHolder.this.a).withExtras(bundle).toUri(NavUri.b("videobrowse"));
                Map<String, String> a = ao.a(ContentBaseViewHolder.this.b.getModel().getTrackInfo().getArgsMap(), this.a.getContentId(), this.a.getCard());
                BasePresenter basePresenter = ContentBaseViewHolder.this.b;
                basePresenter.userTrackClick("card_" + this.b, a, true);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.star.content.base.ContentBaseViewHolder$f */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1968f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1968f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1593744539")) {
                ipChange.ipc$dispatch("-1593744539", new Object[]{this, view});
            } else {
                ContentBaseViewHolder.this.D();
            }
        }
    }

    public ContentBaseViewHolder(Context context, LayoutInflater layoutInflater, BasePresenter basePresenter) {
        super(layoutInflater.inflate(R$layout.tetris_dm_base_content_list_item, (ViewGroup) null));
        this.d = false;
        this.e = 0;
        this.s = true;
        this.a = context;
        this.b = basePresenter;
        this.q = (TextView) this.itemView.findViewById(R$id.content_item_text_main);
        this.r = (TextView) this.itemView.findViewById(R$id.content_item_text_quanwen);
        this.p = (TextView) this.itemView.findViewById(R$id.content_item_title);
        this.f = (TextView) this.itemView.findViewById(R$id.artist_club_item_date);
        this.h = (TextView) this.itemView.findViewById(R$id.tv_content_free_item_praise_num);
        this.g = (TextView) this.itemView.findViewById(R$id.content_free_praise_icon);
        this.i = (StrokeLinearLayout) this.itemView.findViewById(R$id.sll_content_item_main_container);
        this.j = (FrameLayout) this.itemView.findViewById(R$id.fl_content_item_poster_container);
        this.k = (RoundImageView) this.itemView.findViewById(R$id.image_content_item_poster);
        this.j.setVisibility(8);
        this.l = (ImageView) this.itemView.findViewById(R$id.content_item_poster_video_play_icon);
        this.m = (TextView) this.itemView.findViewById(R$id.content_item_video_time);
        NineGridlayout nineGridlayout = (NineGridlayout) this.itemView.findViewById(R$id.content_item_ninelayout);
        this.o = nineGridlayout;
        nineGridlayout.setVisibility(8);
        this.t = this.itemView.findViewById(R$id.content_item_divide_line);
    }

    private boolean A(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1185594581") ? ((Boolean) ipChange.ipc$dispatch("-1185594581", new Object[]{this, str})).booleanValue() : "1001".equals(str) || OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM.equals(str);
    }

    private boolean B() {
        Layout layout;
        int lineCount;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "449844806")) {
            return ((Boolean) ipChange.ipc$dispatch("449844806", new Object[]{this})).booleanValue();
        }
        if (!"2003".equals(this.c) ? !((layout = this.q.getLayout()) == null || (lineCount = layout.getLineCount()) <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) : this.q.getText().length() > 140) {
            z = true;
        }
        this.s = z;
        return z;
    }

    private void C(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-259169534")) {
            ipChange.ipc$dispatch("-259169534", new Object[]{this, str, str2, str3});
        } else {
            E(this.f, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-902709222")) {
            ipChange.ipc$dispatch("-902709222", new Object[]{this});
        } else if (this.s) {
            this.r.setText("收起");
            this.q.setMaxLines(10000);
            this.s = false;
        } else {
            this.r.setText("全文");
            this.q.setMaxLines(5);
            this.s = true;
        }
    }

    private void E(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1381857555")) {
            ipChange.ipc$dispatch("1381857555", new Object[]{this, textView, str});
        } else if (wh2.j(str)) {
        } else {
            textView.setText(str);
        }
    }

    private static String F(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "675384480")) {
            return (String) ipChange.ipc$dispatch("675384480", new Object[]{Long.valueOf(j)});
        }
        String str = "";
        long j2 = j / DateUtils.MILLIS_PER_MINUTE;
        long round = Math.round(((float) (j % DateUtils.MILLIS_PER_MINUTE)) / 1000.0f);
        if (j2 < 10) {
            str = "0";
        }
        String str2 = str + j2 + ":";
        if (round < 10) {
            str2 = str2 + "0";
        }
        return str2 + round;
    }

    static /* synthetic */ int g(ContentBaseViewHolder contentBaseViewHolder) {
        int i = contentBaseViewHolder.e;
        contentBaseViewHolder.e = i + 1;
        return i;
    }

    static /* synthetic */ int h(ContentBaseViewHolder contentBaseViewHolder) {
        int i = contentBaseViewHolder.e;
        contentBaseViewHolder.e = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2006525588")) {
            ipChange.ipc$dispatch("2006525588", new Object[]{this, str});
            return;
        }
        this.r.setText("全文");
        this.r.setVisibility(8);
        if (B()) {
            this.r.setVisibility(0);
        }
        this.r.setOnClickListener(new View$OnClickListenerC1968f());
    }

    private static String p(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "497406068")) {
            return (String) ipChange.ipc$dispatch("497406068", new Object[]{Integer.valueOf(i)});
        }
        if (i <= 999) {
            return String.valueOf(i);
        }
        if (i <= 9999) {
            DecimalFormat decimalFormat = new DecimalFormat();
            decimalFormat.setMaximumFractionDigits(1);
            decimalFormat.setGroupingSize(0);
            decimalFormat.setRoundingMode(RoundingMode.FLOOR);
            return decimalFormat.format(i / 1000.0d) + "k+";
        }
        DecimalFormat decimalFormat2 = new DecimalFormat();
        decimalFormat2.setMaximumFractionDigits(1);
        decimalFormat2.setGroupingSize(0);
        decimalFormat2.setRoundingMode(RoundingMode.FLOOR);
        return decimalFormat2.format(i / 10000.0d) + "w+";
    }

    private String r(ContentItemBean contentItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-557324462")) {
            return (String) ipChange.ipc$dispatch("-557324462", new Object[]{this, contentItemBean});
        }
        if (contentItemBean == null) {
            return null;
        }
        if (contentItemBean.getCoverImage() != null) {
            return contentItemBean.getCoverImage();
        }
        if (contentItemBean.getVideo() != null) {
            return contentItemBean.getVideo().getPicUrl();
        }
        if (contentItemBean.getImages() == null || contentItemBean.getImages().size() <= 0) {
            return null;
        }
        return contentItemBean.getImages().get(0);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r7.equals("2001") == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void s(cn.damai.tetris.component.star.content.base.bean.ContentItemBean r7) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.tetris.component.star.content.base.ContentBaseViewHolder.$ipChange
            java.lang.String r1 = "-485701178"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L17
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r5] = r6
            r2[r4] = r7
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            if (r7 == 0) goto L82
            java.lang.String r0 = r7.getCard()
            if (r0 != 0) goto L20
            goto L82
        L20:
            java.lang.String r7 = r7.getCard()
            r7.hashCode()
            int r0 = r7.hashCode()
            r1 = -1
            switch(r0) {
                case 1507424: goto L5b;
                case 1507425: goto L50;
                case 1537215: goto L47;
                case 1537216: goto L3c;
                case 1537217: goto L31;
                default: goto L2f;
            }
        L2f:
            r3 = -1
            goto L65
        L31:
            java.lang.String r0 = "2003"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L3a
            goto L2f
        L3a:
            r3 = 4
            goto L65
        L3c:
            java.lang.String r0 = "2002"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L45
            goto L2f
        L45:
            r3 = 3
            goto L65
        L47:
            java.lang.String r0 = "2001"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L65
            goto L2f
        L50:
            java.lang.String r0 = "1002"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L59
            goto L2f
        L59:
            r3 = 1
            goto L65
        L5b:
            java.lang.String r0 = "1001"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L64
            goto L2f
        L64:
            r3 = 0
        L65:
            switch(r3) {
                case 0: goto L6f;
                case 1: goto L6f;
                case 2: goto L69;
                case 3: goto L6f;
                case 4: goto L69;
                default: goto L68;
            }
        L68:
            goto L82
        L69:
            cn.damai.uikit.view.StrokeLinearLayout r7 = r6.i
            r7.setCornerAndStroke(r5, r5, r1)
            goto L82
        L6f:
            cn.damai.uikit.view.StrokeLinearLayout r7 = r6.i
            android.content.Context r0 = r6.a
            r1 = 1094713344(0x41400000, float:12.0)
            int r0 = tb.t60.a(r0, r1)
            java.lang.String r1 = "#26000000"
            int r1 = android.graphics.Color.parseColor(r1)
            r7.setCornerAndStroke(r0, r4, r1)
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.tetris.component.star.content.base.ContentBaseViewHolder.s(cn.damai.tetris.component.star.content.base.bean.ContentItemBean):void");
    }

    private void t(ContentItemBean contentItemBean, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "237179995")) {
            ipChange.ipc$dispatch("237179995", new Object[]{this, contentItemBean, Boolean.valueOf(z)});
        } else if (!z) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
    }

    private void u(ContentItemBean contentItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1885380288")) {
            ipChange.ipc$dispatch("1885380288", new Object[]{this, contentItemBean, Integer.valueOf(i)});
        } else if (this.o == null || contentItemBean == null || contentItemBean.getImages() == null || contentItemBean.getImages().size() <= 0 || this.o.getVisibility() != 0) {
        } else {
            List<String> images = contentItemBean.getImages();
            ArrayList arrayList = new ArrayList();
            if (wh2.e(images) > 0) {
                Iterator<String> it = images.iterator();
                while (it.hasNext()) {
                    arrayList.add(new NineGridlayout.Image(it.next() + "?x-oss-process=image/resize,m_fill,h_400,w_400,limit_0"));
                }
                this.o.setRadius(t60.a(this.a, 6.0f));
                this.o.setGap(t60.a(this.a, 3.0f));
                int d = ((int) yr2.d(this.a)) - yr2.a(this.a, 42.0f);
                if (images.size() == 1) {
                    d = (d * 2) / 3;
                }
                this.o.setTotalWidth(d);
                this.o.updateImages(arrayList);
                if (A(contentItemBean.getCard())) {
                    this.o.setListener(new View$OnClickListenerC1964b(contentItemBean, i));
                    return;
                } else {
                    this.o.setListener(new View$OnClickListenerC1965c(images, contentItemBean, i));
                    return;
                }
            }
            this.o.setVisibility(8);
        }
    }

    private void v(ContentItemBean contentItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1572186811")) {
            ipChange.ipc$dispatch("-1572186811", new Object[]{this, contentItemBean});
            return;
        }
        DMImageCreator c = C0504a.b().c(r(contentItemBean));
        int i = R$drawable.uikit_default_image_bg_gradient;
        c.i(i).c(i).g(this.k);
        if (contentItemBean != null && contentItemBean.getVideo() != null) {
            long videoTime = contentItemBean.getVideo().getVideoTime();
            if (videoTime > 0) {
                this.m.setText(F(videoTime));
                return;
            } else {
                this.m.setVisibility(8);
                return;
            }
        }
        this.m.setVisibility(8);
    }

    private void w(ContentItemBean contentItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "34517826")) {
            ipChange.ipc$dispatch("34517826", new Object[]{this, contentItemBean, Integer.valueOf(i)});
            return;
        }
        String card = contentItemBean.getCard();
        char c = 65535;
        switch (card.hashCode()) {
            case 1507424:
                if (card.equals("1001")) {
                    c = 0;
                    break;
                }
                break;
            case 1507425:
                if (card.equals(OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM)) {
                    c = 2;
                    break;
                }
                break;
            case 1537215:
                if (card.equals("2001")) {
                    c = 1;
                    break;
                }
                break;
            case 1537216:
                if (card.equals("2002")) {
                    c = 3;
                    break;
                }
                break;
            case 1537217:
                if (card.equals("2003")) {
                    c = 4;
                    break;
                }
                break;
        }
        if (c == 0) {
            this.j.setVisibility(0);
            this.o.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
        } else if (c == 1) {
            this.j.setVisibility(8);
            this.o.setVisibility(0);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
        } else if (c != 2 && c != 3) {
            this.j.setVisibility(8);
            this.o.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
        } else {
            this.j.setVisibility(0);
            this.l.setVisibility(0);
            this.o.setVisibility(8);
            this.m.setVisibility(0);
        }
        if (this.j.getVisibility() == 0) {
            v(contentItemBean);
        }
        if (this.o.getVisibility() == 0) {
            u(contentItemBean, i);
        }
    }

    private void x(final ContentItemBean contentItemBean, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1869913933")) {
            ipChange.ipc$dispatch("1869913933", new Object[]{this, contentItemBean, Integer.valueOf(i)});
        } else if (contentItemBean.getPraiseInfo() == null) {
            TextView textView = this.g;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.h;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else {
            this.d = contentItemBean.getPraiseInfo().getHasPraised();
            this.e = contentItemBean.getPraiseInfo().getPraiseCount();
            this.g.setVisibility(0);
            this.h.setVisibility(0);
            int i2 = this.e;
            if (i2 == 0) {
                this.h.setText("点赞");
                this.h.setTextColor(Color.parseColor("#9c9ca5"));
            } else {
                this.h.setText(p(i2));
                this.h.setTextColor(this.a.getResources().getColor(R$color.text_color_black));
            }
            if (this.d) {
                this.g.setTextColor(Color.parseColor("#FF983A"));
                this.g.setText(this.a.getResources().getString(R$string.iconfont_dianzanmian_));
            } else {
                this.g.setTextColor(this.a.getResources().getColor(R$color.color_nozan));
                this.g.setText(this.a.getResources().getString(R$string.iconfont_dianzan_));
            }
            if (this.g.getVisibility() == 0) {
                BasePresenter basePresenter = this.b;
                TextView textView3 = this.g;
                basePresenter.userTrackExpose(textView3, "favourite_" + i);
            }
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: cn.damai.tetris.component.star.content.base.ContentBaseViewHolder.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1376584865")) {
                        ipChange2.ipc$dispatch("-1376584865", new Object[]{this, view});
                    } else if (TextUtils.isEmpty(contentItemBean.getContentId())) {
                    } else {
                        if (!LoginManager.k().q()) {
                            DMNav.from(ContentBaseViewHolder.this.a).forResult(100).toUri(NavUri.b("login"));
                            return;
                        }
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 0.3f, 1.0f);
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 0.3f, 1.0f);
                        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 0.5f, 1.0f);
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.setDuration(1000L);
                        animatorSet.setInterpolator(new lf2(0.3f));
                        animatorSet.playTogether(ofFloat3, ofFloat, ofFloat2);
                        animatorSet.start();
                        ContentPraiseRequest contentPraiseRequest = new ContentPraiseRequest();
                        contentPraiseRequest.targetId = contentItemBean.getSourceId();
                        contentPraiseRequest.targetType = "1";
                        contentPraiseRequest.operate = ContentBaseViewHolder.this.d ? "1" : "0";
                        if (ContentBaseViewHolder.this.e == 0 && ContentBaseViewHolder.this.d) {
                            return;
                        }
                        contentPraiseRequest.request(new DMMtopRequestListener<JSONObject>(JSONObject.class) { // from class: cn.damai.tetris.component.star.content.base.ContentBaseViewHolder.2.1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                            public void onFail(String str, String str2) {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "563011346")) {
                                    ipChange3.ipc$dispatch("563011346", new Object[]{this, str, str2});
                                } else {
                                    ContentBaseViewHolder.this.d = false;
                                }
                            }

                            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                            public void onSuccess(JSONObject jSONObject) {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "1895738579")) {
                                    ipChange3.ipc$dispatch("1895738579", new Object[]{this, jSONObject});
                                } else if (jSONObject != null) {
                                    if (ContentBaseViewHolder.this.d) {
                                        ContentBaseViewHolder.h(ContentBaseViewHolder.this);
                                        if (ContentBaseViewHolder.this.e < 0) {
                                            ContentBaseViewHolder.this.e = 0;
                                        }
                                        if (ContentBaseViewHolder.this.e == 0) {
                                            ContentBaseViewHolder.this.h.setText("赞");
                                        } else {
                                            TextView textView4 = ContentBaseViewHolder.this.h;
                                            textView4.setText(ContentBaseViewHolder.this.e + "");
                                        }
                                        ContentBaseViewHolder.this.h.setTextColor(ContentBaseViewHolder.this.a.getResources().getColor(R$color.text_color_black));
                                        ContentBaseViewHolder.this.g.setTextColor(ContentBaseViewHolder.this.a.getResources().getColor(R$color.color_nozan));
                                        ContentBaseViewHolder.this.g.setText(ContentBaseViewHolder.this.a.getResources().getString(R$string.iconfont_dianzan_));
                                    } else {
                                        ContentBaseViewHolder.g(ContentBaseViewHolder.this);
                                        TextView textView5 = ContentBaseViewHolder.this.h;
                                        textView5.setText(ContentBaseViewHolder.this.e + "");
                                        ContentBaseViewHolder.this.h.setTextColor(ContentBaseViewHolder.this.a.getResources().getColor(R$color.text_color_black));
                                        ContentBaseViewHolder.this.g.setTextColor(Color.parseColor("#FF983A"));
                                        ContentBaseViewHolder.this.g.setText(ContentBaseViewHolder.this.a.getResources().getString(R$string.iconfont_dianzanmian_));
                                    }
                                    ContentBaseViewHolder contentBaseViewHolder = ContentBaseViewHolder.this;
                                    contentBaseViewHolder.d = !contentBaseViewHolder.d;
                                    Map<String, String> a = ao.a(ContentBaseViewHolder.this.b.getModel().getTrackInfo().getArgsMap(), contentItemBean.getContentId(), contentItemBean.getCard());
                                    BasePresenter basePresenter2 = ContentBaseViewHolder.this.b;
                                    basePresenter2.userTrackClick("favorite_" + i, a, true);
                                }
                            }
                        });
                    }
                }
            };
            this.g.setOnClickListener(onClickListener);
            this.h.setOnClickListener(onClickListener);
        }
    }

    private void y(ContentItemBean contentItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1336429019")) {
            ipChange.ipc$dispatch("-1336429019", new Object[]{this, contentItemBean});
            return;
        }
        final String card = contentItemBean.getCard();
        if (!TextUtils.isEmpty(contentItemBean.getContent())) {
            this.q.setVisibility(0);
            this.q.setText(contentItemBean.getContent());
            this.q.post(new Runnable() { // from class: cn.damai.tetris.component.star.content.base.ContentBaseViewHolder.7
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1192615116")) {
                        ipChange2.ipc$dispatch("1192615116", new Object[]{this});
                    } else {
                        ContentBaseViewHolder.this.o(card);
                    }
                }
            });
        } else {
            this.q.setVisibility(8);
        }
        if (!TextUtils.isEmpty(contentItemBean.getTitle())) {
            this.p.setVisibility(0);
            this.p.setText(contentItemBean.getTitle());
            return;
        }
        this.p.setVisibility(8);
    }

    private void z(ContentItemBean contentItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1915645754")) {
            ipChange.ipc$dispatch("-1915645754", new Object[]{this, contentItemBean, Integer.valueOf(i)});
        } else if (contentItemBean == null || contentItemBean.getVideo() == null) {
        } else {
            if (A(contentItemBean.getCard())) {
                this.j.setOnClickListener(new View$OnClickListenerC1966d(contentItemBean, i));
            } else {
                this.j.setOnClickListener(new View$OnClickListenerC1967e(contentItemBean, i));
            }
        }
    }

    public void G() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2039051286")) {
            ipChange.ipc$dispatch("-2039051286", new Object[]{this});
            return;
        }
        DMVideoPlayer dMVideoPlayer = this.n;
        if (dMVideoPlayer == null || !dMVideoPlayer.isPlaying()) {
            return;
        }
        this.n.stop();
    }

    public void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1217850000")) {
            ipChange.ipc$dispatch("-1217850000", new Object[]{this});
            return;
        }
        DMVideoPlayer dMVideoPlayer = this.n;
        if (dMVideoPlayer == null || !dMVideoPlayer.isPause()) {
            return;
        }
        this.n.start();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x003e, code lost:
        if (r0.equals("2003") == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void n(cn.damai.tetris.component.star.content.base.bean.ContentItemBean r9, int r10, boolean r11) {
        /*
            r8 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.tetris.component.star.content.base.ContentBaseViewHolder.$ipChange
            java.lang.String r1 = "-1787937906"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L25
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r7] = r8
            r2[r6] = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r10)
            r2[r5] = r9
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r11)
            r2[r4] = r9
            r0.ipc$dispatch(r1, r2)
            return
        L25:
            java.lang.String r0 = r9.getCard()
            r8.c = r0
            r0.hashCode()
            r1 = -1
            int r2 = r0.hashCode()
            switch(r2) {
                case 1507424: goto L62;
                case 1507425: goto L57;
                case 1537215: goto L4c;
                case 1537216: goto L41;
                case 1537217: goto L38;
                default: goto L36;
            }
        L36:
            r3 = -1
            goto L6c
        L38:
            java.lang.String r2 = "2003"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L6c
            goto L36
        L41:
            java.lang.String r2 = "2002"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L4a
            goto L36
        L4a:
            r3 = 3
            goto L6c
        L4c:
            java.lang.String r2 = "2001"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L55
            goto L36
        L55:
            r3 = 2
            goto L6c
        L57:
            java.lang.String r2 = "1002"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L60
            goto L36
        L60:
            r3 = 1
            goto L6c
        L62:
            java.lang.String r2 = "1001"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L6b
            goto L36
        L6b:
            r3 = 0
        L6c:
            r0 = 8
            switch(r3) {
                case 0: goto L90;
                case 1: goto L81;
                case 2: goto L90;
                case 3: goto L81;
                case 4: goto L72;
                default: goto L71;
            }
        L71:
            goto L9e
        L72:
            android.widget.FrameLayout r1 = r8.j
            if (r1 == 0) goto L79
            r1.setVisibility(r0)
        L79:
            cn.damai.uikit.view.NineGridlayout r1 = r8.o
            if (r1 == 0) goto L9e
            r1.setVisibility(r0)
            goto L9e
        L81:
            android.widget.FrameLayout r1 = r8.j
            if (r1 == 0) goto L88
            r1.setVisibility(r7)
        L88:
            cn.damai.uikit.view.NineGridlayout r1 = r8.o
            if (r1 == 0) goto L9e
            r1.setVisibility(r0)
            goto L9e
        L90:
            android.widget.FrameLayout r1 = r8.j
            if (r1 == 0) goto L97
            r1.setVisibility(r0)
        L97:
            cn.damai.uikit.view.NineGridlayout r0 = r8.o
            if (r0 == 0) goto L9e
            r0.setVisibility(r7)
        L9e:
            java.lang.String r0 = r9.getContent()
            java.lang.String r1 = r9.getReleaseTime()
            java.lang.String r2 = r8.r(r9)
            r8.C(r0, r1, r2)
            r8.y(r9)
            r8.x(r9, r10)
            r8.t(r9, r11)
            r8.s(r9)
            r8.w(r9, r10)
            r8.z(r9, r10)
            cn.damai.uikit.view.StrokeLinearLayout r11 = r8.i
            cn.damai.tetris.component.star.content.base.ContentBaseViewHolder$a r0 = new cn.damai.tetris.component.star.content.base.ContentBaseViewHolder$a
            r0.<init>(r9, r10)
            r11.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.tetris.component.star.content.base.ContentBaseViewHolder.n(cn.damai.tetris.component.star.content.base.bean.ContentItemBean, int, boolean):void");
    }

    public void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1910157154")) {
            ipChange.ipc$dispatch("1910157154", new Object[]{this});
            return;
        }
        DMVideoPlayer dMVideoPlayer = this.n;
        if (dMVideoPlayer == null || !dMVideoPlayer.isPlaying()) {
            return;
        }
        this.n.stop();
    }
}
