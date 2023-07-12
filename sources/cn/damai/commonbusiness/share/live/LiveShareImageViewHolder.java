package cn.damai.commonbusiness.share.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.bean.StoreInfo;
import cn.damai.comment.view.DMTagView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$dimen;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.qrcode.util.QrcodeUtil;
import cn.damai.commonbusiness.share.evaluate.EvaluateScriptMurderShopView;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.commonbusiness.share.live.LiveShareImageViewHolder;
import cn.damai.uikit.view.DMAvatar;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import tb.m91;
import tb.q60;
import tb.wh2;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class LiveShareImageViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    public ScrollView b;
    private View c;
    private ImageView d;
    private TextView e;
    private ImageView f;
    private ConstraintLayout g;
    private DMAvatar h;
    private TextView i;
    private TextView j;
    private TextView k;
    private ImageView l;
    private View m;
    private TextView n;
    private TextView o;
    private ImageView p;
    private ImageView q;
    private ImageView r;
    private ImageView s;
    private ConstraintLayout t;
    private View u;
    private View v;
    private LiveArtistView[] w;
    private EvaluateScriptMurderShopView x;
    private DMTagView y;
    private int z;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface IFinishCallBack {
        void onFinish();
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.share.live.LiveShareImageViewHolder$a */
    /* loaded from: classes.dex */
    public class C0921a implements DMAvatar.OnImageLoadListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ AtomicInteger a;
        final /* synthetic */ IFinishCallBack b;

        C0921a(AtomicInteger atomicInteger, IFinishCallBack iFinishCallBack) {
            this.a = atomicInteger;
            this.b = iFinishCallBack;
        }

        @Override // com.alibaba.pictures.bricks.view.DMAvatar.OnImageLoadListener
        public void onImageLoadFailure() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "583507749")) {
                ipChange.ipc$dispatch("583507749", new Object[]{this});
            } else {
                LiveShareImageViewHolder.this.i(this.a.incrementAndGet(), this.b);
            }
        }

        @Override // com.alibaba.pictures.bricks.view.DMAvatar.OnImageLoadListener
        public void onImageLoadSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1186803188")) {
                ipChange.ipc$dispatch("-1186803188", new Object[]{this});
            } else {
                LiveShareImageViewHolder.this.i(this.a.incrementAndGet(), this.b);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.share.live.LiveShareImageViewHolder$b */
    /* loaded from: classes.dex */
    public class C0922b implements Function0<wt2> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ AtomicInteger a;
        final /* synthetic */ IFinishCallBack b;

        C0922b(AtomicInteger atomicInteger, IFinishCallBack iFinishCallBack) {
            this.a = atomicInteger;
            this.b = iFinishCallBack;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public wt2 invoke() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1881156373")) {
                return (wt2) ipChange.ipc$dispatch("1881156373", new Object[]{this});
            }
            LiveShareImageViewHolder.this.i(this.a.incrementAndGet(), this.b);
            return null;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.share.live.LiveShareImageViewHolder$c */
    /* loaded from: classes.dex */
    public class C0923c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ AtomicInteger a;
        final /* synthetic */ IFinishCallBack b;

        C0923c(AtomicInteger atomicInteger, IFinishCallBack iFinishCallBack) {
            this.a = atomicInteger;
            this.b = iFinishCallBack;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2089033990")) {
                ipChange.ipc$dispatch("2089033990", new Object[]{this, c0502e});
            } else {
                LiveShareImageViewHolder.this.i(this.a.incrementAndGet(), this.b);
            }
        }
    }

    public LiveShareImageViewHolder(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_generate_live_share_image, (ViewGroup) null);
        this.a = context;
        this.t = (ConstraintLayout) inflate.findViewById(R$id.multi_image_container);
        this.s = (ImageView) inflate.findViewById(R$id.multi_image_three);
        this.r = (ImageView) inflate.findViewById(R$id.multi_image_two);
        this.q = (ImageView) inflate.findViewById(R$id.multi_image_one);
        this.p = (ImageView) inflate.findViewById(R$id.share_qrcode);
        this.o = (TextView) inflate.findViewById(R$id.project_info);
        this.n = (TextView) inflate.findViewById(R$id.project_title);
        this.l = (ImageView) inflate.findViewById(R$id.project_image);
        this.m = inflate.findViewById(R$id.project_image_container);
        this.k = (TextView) inflate.findViewById(R$id.note_text);
        this.j = (TextView) inflate.findViewById(R$id.user_title_sub);
        this.i = (TextView) inflate.findViewById(R$id.user_title);
        this.h = (cn.damai.uikit.view.DMAvatar) inflate.findViewById(R$id.iv_account_image);
        this.g = (ConstraintLayout) inflate.findViewById(R$id.note_container);
        this.f = (ImageView) inflate.findViewById(R$id.image_count_label_icon);
        this.e = (TextView) inflate.findViewById(R$id.image_count);
        this.d = (ImageView) inflate.findViewById(R$id.single_image);
        this.c = inflate.findViewById(R$id.image_container);
        this.b = (ScrollView) inflate.findViewById(R$id.share_page);
        this.u = inflate.findViewById(R$id.dm_line_5);
        this.v = inflate.findViewById(R$id.live_share_artist_container);
        this.w = new LiveArtistView[]{(LiveArtistView) inflate.findViewById(R$id.live_share_artist_left), (LiveArtistView) inflate.findViewById(R$id.live_share_artist_right)};
        this.x = (EvaluateScriptMurderShopView) inflate.findViewById(R$id.script_murder_shop);
        this.y = (DMTagView) inflate.findViewById(R$id.dm_info);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i(int i, IFinishCallBack iFinishCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-369245038")) {
            ipChange.ipc$dispatch("-369245038", new Object[]{this, Integer.valueOf(i), iFinishCallBack});
            return;
        }
        if (i == this.z) {
            iFinishCallBack.onFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(AtomicInteger atomicInteger, IFinishCallBack iFinishCallBack, DMImageCreator.C0501d c0501d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1226719105")) {
            ipChange.ipc$dispatch("-1226719105", new Object[]{this, atomicInteger, iFinishCallBack, c0501d});
        } else {
            i(atomicInteger.incrementAndGet(), iFinishCallBack);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(AtomicInteger atomicInteger, IFinishCallBack iFinishCallBack, DMImageCreator.C0502e c0502e) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1886847775")) {
            ipChange.ipc$dispatch("1886847775", new Object[]{this, atomicInteger, iFinishCallBack, c0502e});
            return;
        }
        this.d.setImageBitmap(c0502e.b);
        i(atomicInteger.incrementAndGet(), iFinishCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(AtomicInteger atomicInteger, IFinishCallBack iFinishCallBack, DMImageCreator.C0502e c0502e) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1896618336")) {
            ipChange.ipc$dispatch("1896618336", new Object[]{this, atomicInteger, iFinishCallBack, c0502e});
            return;
        }
        this.q.setImageBitmap(c0502e.b);
        i(atomicInteger.incrementAndGet(), iFinishCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(AtomicInteger atomicInteger, IFinishCallBack iFinishCallBack, DMImageCreator.C0502e c0502e) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1906388897")) {
            ipChange.ipc$dispatch("1906388897", new Object[]{this, atomicInteger, iFinishCallBack, c0502e});
            return;
        }
        this.r.setImageBitmap(c0502e.b);
        i(atomicInteger.incrementAndGet(), iFinishCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(AtomicInteger atomicInteger, IFinishCallBack iFinishCallBack, DMImageCreator.C0502e c0502e) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1916159458")) {
            ipChange.ipc$dispatch("1916159458", new Object[]{this, atomicInteger, iFinishCallBack, c0502e});
            return;
        }
        this.s.setImageBitmap(c0502e.b);
        i(atomicInteger.incrementAndGet(), iFinishCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ wt2 o(AtomicInteger atomicInteger, IFinishCallBack iFinishCallBack, Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1610649373")) {
            return (wt2) ipChange.ipc$dispatch("1610649373", new Object[]{this, atomicInteger, iFinishCallBack, drawable});
        }
        i(atomicInteger.incrementAndGet(), iFinishCallBack);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(AtomicInteger atomicInteger, IFinishCallBack iFinishCallBack, DMImageCreator.C0502e c0502e) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1935700580")) {
            ipChange.ipc$dispatch("1935700580", new Object[]{this, atomicInteger, iFinishCallBack, c0502e});
            return;
        }
        this.l.setImageBitmap(c0502e.b);
        i(atomicInteger.incrementAndGet(), iFinishCallBack);
    }

    public void q(LiveShareImageBean liveShareImageBean, final IFinishCallBack iFinishCallBack) {
        int i;
        StoreInfo storeInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471894375")) {
            ipChange.ipc$dispatch("-471894375", new Object[]{this, liveShareImageBean, iFinishCallBack});
        } else if (liveShareImageBean != null) {
            C0504a h = C0504a.b().h(this.a);
            final AtomicInteger atomicInteger = new AtomicInteger(0);
            int imageCount = liveShareImageBean.getImageCount();
            DMImageCreator.DMImageFailListener dMImageFailListener = new DMImageCreator.DMImageFailListener() { // from class: tb.r91
                @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
                public final void onFail(DMImageCreator.C0501d c0501d) {
                    LiveShareImageViewHolder.this.j(atomicInteger, iFinishCallBack, c0501d);
                }
            };
            if (!wh2.j(liveShareImageBean.mProjectImage) || (liveShareImageBean.itemType == 1 && (storeInfo = liveShareImageBean.storeInfo) != null && !TextUtils.isEmpty(storeInfo.getStoreImgUrl()))) {
                i = 1;
            } else if (m91.a(liveShareImageBean.mArtistList)) {
                i = 0;
            } else {
                i = liveShareImageBean.mArtistList.size() > 2 ? 2 : liveShareImageBean.mArtistList.size();
            }
            if (liveShareImageBean.itemType == 1 && liveShareImageBean.dmInfo != null) {
                i++;
            }
            if (imageCount == 0) {
                this.z = i + 1;
                this.f.setVisibility(8);
                this.e.setVisibility(8);
                this.c.setVisibility(8);
                this.g.setBackgroundResource(R$drawable.bg_generate_live_share_image_note_full_corner);
                ConstraintLayout constraintLayout = this.g;
                constraintLayout.setPadding(constraintLayout.getPaddingLeft(), this.a.getResources().getDimensionPixelOffset(R$dimen.live_share_image_note_padding_top), this.g.getPaddingRight(), this.g.getPaddingBottom());
            } else {
                this.f.setVisibility(0);
                this.e.setVisibility(0);
                TextView textView = this.e;
                textView.setText("" + imageCount);
                this.c.setVisibility(0);
                if (imageCount < 3) {
                    this.z = i + 2;
                    h.c(liveShareImageBean.mLivePicList.get(0)).n(new DMImageCreator.DMImageSuccListener() { // from class: tb.u91
                        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                        public final void onSuccess(DMImageCreator.C0502e c0502e) {
                            LiveShareImageViewHolder.this.k(atomicInteger, iFinishCallBack, c0502e);
                        }
                    }).e(dMImageFailListener).f();
                    this.d.setVisibility(0);
                    this.t.setVisibility(8);
                } else {
                    this.z = i + 4;
                    h.c(liveShareImageBean.mLivePicList.get(0)).n(new DMImageCreator.DMImageSuccListener() { // from class: tb.w91
                        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                        public final void onSuccess(DMImageCreator.C0502e c0502e) {
                            LiveShareImageViewHolder.this.l(atomicInteger, iFinishCallBack, c0502e);
                        }
                    }).e(dMImageFailListener).f();
                    h.c(liveShareImageBean.mLivePicList.get(1)).n(new DMImageCreator.DMImageSuccListener() { // from class: tb.v91
                        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                        public final void onSuccess(DMImageCreator.C0502e c0502e) {
                            LiveShareImageViewHolder.this.m(atomicInteger, iFinishCallBack, c0502e);
                        }
                    }).e(dMImageFailListener).f();
                    h.c(liveShareImageBean.mLivePicList.get(2)).n(new DMImageCreator.DMImageSuccListener() { // from class: tb.s91
                        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                        public final void onSuccess(DMImageCreator.C0502e c0502e) {
                            LiveShareImageViewHolder.this.n(atomicInteger, iFinishCallBack, c0502e);
                        }
                    }).e(dMImageFailListener).f();
                    this.d.setVisibility(8);
                    this.t.setVisibility(0);
                }
            }
            if (!TextUtils.isEmpty(liveShareImageBean.mShareQrcode)) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.a.getResources(), R$drawable.damai_small_logo);
                this.p.setImageBitmap(QrcodeUtil.b(q60.a(this.a, 70.0f), GenerateImageUtil.SHARE_URL + URLEncoder.encode(liveShareImageBean.mShareQrcode), decodeResource));
                this.p.setVisibility(0);
            } else {
                this.p.setVisibility(8);
            }
            this.i.setText(liveShareImageBean.mUserTitle);
            this.j.setText(liveShareImageBean.mUserTitleSub);
            this.k.setText(liveShareImageBean.mNoteText);
            this.h.setAvatarBorderVisibility(liveShareImageBean.mIsVip ? 0 : 8);
            this.h.setAvatarCrownVisibility(liveShareImageBean.mIsVip ? 0 : 8);
            this.h.setOnImageLoadListener(new C0921a(atomicInteger, iFinishCallBack));
            this.h.setAvatar(liveShareImageBean.mIvAccountImage);
            if (liveShareImageBean.itemType == 1 && liveShareImageBean.storeInfo != null) {
                DmInfo dmInfo = liveShareImageBean.dmInfo;
                if (dmInfo != null) {
                    this.y.setDmBaseData(dmInfo.dmHeadImageUrl, dmInfo.dmName, new C0922b(atomicInteger, iFinishCallBack));
                    this.y.setDmTagData(liveShareImageBean.dmInfo.dmTags);
                    this.y.setVisibility(0);
                } else {
                    this.y.setVisibility(8);
                }
                this.x.setVisibility(0);
                this.u.setVisibility(0);
                this.m.setVisibility(8);
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                this.x.getShopNameTv().setTextColor(-16777216);
                this.x.getShopNameTv().setTextSize(1, 14.0f);
                this.x.getShopSubTitleTv().setTextColor(this.a.getResources().getColor(R$color.color_9C9CA5));
                this.x.bindData(liveShareImageBean.storeInfo, new Function1() { // from class: tb.x91
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        wt2 o;
                        o = LiveShareImageViewHolder.this.o(atomicInteger, iFinishCallBack, (Drawable) obj);
                        return o;
                    }
                });
                return;
            }
            this.y.setVisibility(8);
            if (!wh2.j(liveShareImageBean.mProjectImage)) {
                this.x.setVisibility(8);
                this.u.setVisibility(0);
                this.m.setVisibility(0);
                this.n.setVisibility(0);
                this.o.setVisibility(0);
                this.n.setText(liveShareImageBean.mProjectTitle);
                this.o.setText(liveShareImageBean.mProjectInfo);
                h.c(liveShareImageBean.mProjectImage).n(new DMImageCreator.DMImageSuccListener() { // from class: tb.t91
                    @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                    public final void onSuccess(DMImageCreator.C0502e c0502e) {
                        LiveShareImageViewHolder.this.p(atomicInteger, iFinishCallBack, c0502e);
                    }
                }).e(dMImageFailListener).f();
            }
            if (m91.a(liveShareImageBean.mArtistList)) {
                return;
            }
            this.u.setVisibility(0);
            this.v.setVisibility(0);
            int size = liveShareImageBean.mArtistList.size();
            if (size > 2) {
                size = 2;
            }
            if (size < 2) {
                this.w[1].setVisibility(8);
            }
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    this.w[i2].setVisibility(0);
                    this.w[i2].handleView(liveShareImageBean.mArtistList.get(i2), new C0923c(atomicInteger, iFinishCallBack), dMImageFailListener);
                } catch (IndexOutOfBoundsException unused) {
                    this.w[i2].setVisibility(8);
                }
            }
        }
    }
}
