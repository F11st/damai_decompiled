package cn.damai.commonbusiness.share.generateimage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.damai.common.app.widget.DMProgressDialog;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.common.image.luban.Luban;
import cn.damai.common.image.luban.OnCompressListener;
import cn.damai.common.image.luban.OnRenameListener;
import cn.damai.common.nav.DMNav;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.qrcode.util.QrcodeUtil;
import cn.damai.commonbusiness.share.IImageShareInfoProvider;
import cn.damai.commonbusiness.share.evaluate.EvaluateShareViewHolder;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.commonbusiness.share.inf.OnFinishListener;
import cn.damai.commonbusiness.share.live.LiveShareImageBean;
import cn.damai.commonbusiness.share.live.LiveShareImageViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import tb.b21;
import tb.cb1;
import tb.e80;
import tb.mi1;
import tb.t60;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class GenerateImageUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String SHARE_URL = "https://m.damai.cn/damai/cyclops/scan.html?url=";
    public static final String STYLE_GENERATE_ARTIST_IMAGE = "artistImage";
    public static final String STYLE_GENERATE_DISCOUNT_TICKET = "discountImage";
    public static final String STYLE_GENERATE_EVALUATE_IMAGE = "evaluateImage";
    public static final String STYLE_GENERATE_IP_DRAMA_IMAGE = "ipDrama";
    public static final String STYLE_GENERATE_LIVE_IMAGE = "liveImage";
    public static final String STYLE_GENERATE_MUSIC_IMAGE = "musicImage";
    public static final String STYLE_GENERATE_NEW_SHARE = "newStyle";
    public static final String STYLE_GENERATE_NEW_SHARE_UPGRADE = "newGradeStyle";
    public static final String STYLE_GENERATE_NFT_CARD_SHARE = "NFTCardStyle";
    public static final String STYLE_GENERATE_PROJECT_IMAGE = "projectImage";
    public static final String STYLE_GENERATE_RANKING_IMAGE = "rankingImage";
    public static final String STYLE_GENERATE_THEME_IMAGE = "themeImage";
    public static final String TYPE_FROMWHERE_DETAILCOMMENT = "detailComment";
    public static final String TYPE_FROMWHERE_H5 = "H5";
    public static final String TYPE_FROMWHERE_PEOJECT_DETAIL = "projectDetail";
    public static final String TYPE_FROMWHERE_USERPROFILE = "UserProfile";
    private static DMProgressDialog a = null;
    private static OnImageGenerateListener b = null;
    private static boolean c = false;
    private static int d = 2;
    private static int e;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnImageGenerateListener {
        void onFailure();

        void onSuccess();
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnQrcodeGenerateCompleteListener {
        void onComplete();
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;

        a(Activity activity) {
            this.a = activity;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "901790613")) {
                ipChange.ipc$dispatch("901790613", new Object[]{this, dVar});
                return;
            }
            GenerateImageUtil.I(this.a);
            ToastUtil.a().e(this.a, "图片生成失败");
            if (GenerateImageUtil.b != null) {
                GenerateImageUtil.b.onFailure();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ ImageView b;
        final /* synthetic */ DMShareMessage c;
        final /* synthetic */ ImageView d;
        final /* synthetic */ View e;
        final /* synthetic */ ScrollView f;

        b(Activity activity, ImageView imageView, DMShareMessage dMShareMessage, ImageView imageView2, View view, ScrollView scrollView) {
            this.a = activity;
            this.b = imageView;
            this.c = dMShareMessage;
            this.d = imageView2;
            this.e = view;
            this.f = scrollView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-812881558")) {
                ipChange.ipc$dispatch("-812881558", new Object[]{this, eVar});
                return;
            }
            Bitmap bitmap = eVar.b;
            if (bitmap == null) {
                GenerateImageUtil.I(this.a);
                cb1.a("bitmap is null");
                ToastUtil.a().e(this.a, "图片生成失败");
                if (GenerateImageUtil.b != null) {
                    GenerateImageUtil.b.onFailure();
                    return;
                }
                return;
            }
            this.b.setImageDrawable(new BitmapDrawable(b21.a(this.a, bitmap)));
            int d = e80.d() - t60.a(this.a, 36.0f);
            int height = (bitmap.getHeight() * d) / bitmap.getWidth();
            if (GenerateImageUtil.STYLE_GENERATE_ARTIST_IMAGE == this.c.shareImageStyle) {
                this.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
                height = d;
            }
            this.d.setLayoutParams(new RelativeLayout.LayoutParams(d, height));
            this.d.setImageBitmap(bitmap);
            GenerateImageUtil.v(this.a, this.e);
            GenerateImageUtil.B(this.a, GenerateImageUtil.s(this.f), this.c.fromWhere);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class c implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;

        c(Activity activity) {
            this.a = activity;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1431602025")) {
                ipChange.ipc$dispatch("-1431602025", new Object[]{this, dVar});
                return;
            }
            GenerateImageUtil.I(this.a);
            ToastUtil.a().e(this.a, "图片生成失败");
            if (GenerateImageUtil.b != null) {
                GenerateImageUtil.b.onFailure();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class d implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ ImageView b;
        final /* synthetic */ ImageView c;
        final /* synthetic */ View d;
        final /* synthetic */ ScrollView e;
        final /* synthetic */ DMShareMessage f;

        d(Activity activity, ImageView imageView, ImageView imageView2, View view, ScrollView scrollView, DMShareMessage dMShareMessage) {
            this.a = activity;
            this.b = imageView;
            this.c = imageView2;
            this.d = view;
            this.e = scrollView;
            this.f = dMShareMessage;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2029035284")) {
                ipChange.ipc$dispatch("-2029035284", new Object[]{this, eVar});
                return;
            }
            Bitmap bitmap = eVar.b;
            if (bitmap == null) {
                GenerateImageUtil.I(this.a);
                cb1.a("bitmap is null");
                ToastUtil.a().e(this.a, "图片生成失败");
                if (GenerateImageUtil.b != null) {
                    GenerateImageUtil.b.onFailure();
                    return;
                }
                return;
            }
            this.b.setImageDrawable(new BitmapDrawable(b21.a(this.a, bitmap)));
            int d = e80.d() - t60.a(this.a, 36.0f);
            this.c.setLayoutParams(new RelativeLayout.LayoutParams(d, (bitmap.getHeight() * d) / bitmap.getWidth()));
            this.c.setImageBitmap(bitmap);
            GenerateImageUtil.v(this.a, this.d);
            GenerateImageUtil.B(this.a, GenerateImageUtil.s(this.e), this.f.fromWhere);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class e implements OnFinishListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ mi1 b;
        final /* synthetic */ DMShareMessage c;

        e(Activity activity, mi1 mi1Var, DMShareMessage dMShareMessage) {
            this.a = activity;
            this.b = mi1Var;
            this.c = dMShareMessage;
        }

        @Override // cn.damai.commonbusiness.share.inf.OnFinishListener
        public void onViewUpdateFailure() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1346576329")) {
                ipChange.ipc$dispatch("-1346576329", new Object[]{this});
                return;
            }
            GenerateImageUtil.I(this.a);
            if (GenerateImageUtil.b != null) {
                GenerateImageUtil.b.onFailure();
            }
        }

        @Override // cn.damai.commonbusiness.share.inf.OnFinishListener
        public void onViewUpdateSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1178080030")) {
                ipChange.ipc$dispatch("1178080030", new Object[]{this});
            } else {
                GenerateImageUtil.o(this.a, this.b.c(), this.b.d(), this.c);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class f implements OnFinishListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ EvaluateShareViewHolder b;
        final /* synthetic */ DMShareMessage c;

        f(Activity activity, EvaluateShareViewHolder evaluateShareViewHolder, DMShareMessage dMShareMessage) {
            this.a = activity;
            this.b = evaluateShareViewHolder;
            this.c = dMShareMessage;
        }

        @Override // cn.damai.commonbusiness.share.inf.OnFinishListener
        public void onViewUpdateFailure() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1315556522")) {
                ipChange.ipc$dispatch("-1315556522", new Object[]{this});
                return;
            }
            GenerateImageUtil.I(this.a);
            if (GenerateImageUtil.b != null) {
                GenerateImageUtil.b.onFailure();
            }
        }

        @Override // cn.damai.commonbusiness.share.inf.OnFinishListener
        public void onViewUpdateSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1209099837")) {
                ipChange.ipc$dispatch("1209099837", new Object[]{this});
            } else {
                GenerateImageUtil.m(this.a, this.b.i(), this.b.j(), this.c);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class g implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ RelativeLayout b;
        final /* synthetic */ View c;
        final /* synthetic */ ScrollView d;
        final /* synthetic */ DMShareMessage e;

        g(Activity activity, RelativeLayout relativeLayout, View view, ScrollView scrollView, DMShareMessage dMShareMessage) {
            this.a = activity;
            this.b = relativeLayout;
            this.c = view;
            this.d = scrollView;
            this.e = dMShareMessage;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1008541666")) {
                ipChange.ipc$dispatch("-1008541666", new Object[]{this, dVar});
                return;
            }
            GenerateImageUtil.I(this.a);
            this.b.setBackgroundResource(R$drawable.fassion_share_bg);
            GenerateImageUtil.n(this.a, this.c, this.d, this.e);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class h implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;

        h(Activity activity) {
            this.a = activity;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "676602195")) {
                ipChange.ipc$dispatch("676602195", new Object[]{this, dVar});
                return;
            }
            GenerateImageUtil.I(this.a);
            ToastUtil.a().e(this.a, "图片生成失败");
            if (GenerateImageUtil.b != null) {
                GenerateImageUtil.b.onFailure();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class i implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ RelativeLayout b;
        final /* synthetic */ View c;
        final /* synthetic */ ScrollView d;
        final /* synthetic */ DMShareMessage e;

        i(Activity activity, RelativeLayout relativeLayout, View view, ScrollView scrollView, DMShareMessage dMShareMessage) {
            this.a = activity;
            this.b = relativeLayout;
            this.c = view;
            this.d = scrollView;
            this.e = dMShareMessage;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1875318264")) {
                ipChange.ipc$dispatch("-1875318264", new Object[]{this, eVar});
                return;
            }
            Bitmap bitmap = eVar.b;
            if (bitmap == null) {
                GenerateImageUtil.I(this.a);
                this.b.setBackgroundResource(R$drawable.fassion_share_bg);
            } else {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (Build.VERSION.SDK_INT >= 16) {
                    this.b.setBackground(bitmapDrawable);
                } else {
                    this.b.setBackgroundDrawable(bitmapDrawable);
                }
            }
            GenerateImageUtil.n(this.a, this.c, this.d, this.e);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class j implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;

        j(Activity activity) {
            this.a = activity;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2072753227")) {
                ipChange.ipc$dispatch("-2072753227", new Object[]{this, dVar});
                return;
            }
            GenerateImageUtil.I(this.a);
            ToastUtil.a().e(this.a, "图片生成失败");
            if (GenerateImageUtil.b != null) {
                GenerateImageUtil.b.onFailure();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class k implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ ImageView b;
        final /* synthetic */ DMShareMessage c;
        final /* synthetic */ ImageView d;
        final /* synthetic */ View e;
        final /* synthetic */ ScrollView f;

        k(Activity activity, ImageView imageView, DMShareMessage dMShareMessage, ImageView imageView2, View view, ScrollView scrollView) {
            this.a = activity;
            this.b = imageView;
            this.c = dMShareMessage;
            this.d = imageView2;
            this.e = view;
            this.f = scrollView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1203495306")) {
                ipChange.ipc$dispatch("1203495306", new Object[]{this, eVar});
                return;
            }
            Bitmap bitmap = eVar.b;
            if (bitmap == null) {
                GenerateImageUtil.I(this.a);
                cb1.a("bitmap is null");
                ToastUtil.a().e(this.a, "图片生成失败");
                if (GenerateImageUtil.b != null) {
                    GenerateImageUtil.b.onFailure();
                    return;
                }
                return;
            }
            this.b.setImageDrawable(new BitmapDrawable(b21.a(this.a, bitmap)));
            int d = e80.d() - t60.a(this.a, 36.0f);
            int height = (bitmap.getHeight() * d) / bitmap.getWidth();
            if (GenerateImageUtil.STYLE_GENERATE_ARTIST_IMAGE == this.c.shareImageStyle) {
                this.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
                height = d;
            }
            this.d.setLayoutParams(new RelativeLayout.LayoutParams(d, height));
            this.d.setImageBitmap(bitmap);
            GenerateImageUtil.v(this.a, this.e);
            GenerateImageUtil.B(this.a, GenerateImageUtil.s(this.f), this.c.fromWhere);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class l implements OnCompressListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DMShareMessage a;
        final /* synthetic */ String b;
        final /* synthetic */ Activity c;

        l(DMShareMessage dMShareMessage, String str, Activity activity) {
            this.a = dMShareMessage;
            this.b = str;
            this.c = activity;
        }

        @Override // cn.damai.common.image.luban.OnCompressListener
        public void onError(Throwable th) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "60235752")) {
                ipChange.ipc$dispatch("60235752", new Object[]{this, th});
                return;
            }
            GenerateImageUtil.I(this.c);
            ToastUtil.a().e(this.c, "图片生成失败");
            if (GenerateImageUtil.b != null) {
                GenerateImageUtil.b.onFailure();
            }
        }

        @Override // cn.damai.common.image.luban.OnCompressListener
        public void onStart() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "273258899")) {
                ipChange.ipc$dispatch("273258899", new Object[]{this});
            }
        }

        @Override // cn.damai.common.image.luban.OnCompressListener
        public void onSuccess(File file) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2111532983")) {
                ipChange.ipc$dispatch("-2111532983", new Object[]{this, file});
                return;
            }
            String absolutePath = file.getAbsolutePath();
            if (!TextUtils.isEmpty(absolutePath) && !TextUtils.isEmpty(absolutePath)) {
                Bundle bundle = new Bundle();
                DMShareMessage dMShareMessage = this.a;
                bundle.putString("imageTitle", (dMShareMessage == null || wh2.j(dMShareMessage.windowTitle)) ? "分享" : this.a.windowTitle);
                bundle.putString("imageModeUrl", absolutePath);
                if (!TextUtils.isEmpty(this.b)) {
                    bundle.putString("fromWhere", this.b);
                }
                DMShareMessage dMShareMessage2 = this.a;
                if (dMShareMessage2 != null) {
                    if (!TextUtils.isEmpty(dMShareMessage2.projectId)) {
                        try {
                            bundle.putLong("projectId", Long.parseLong(this.a.projectId));
                        } catch (Exception unused) {
                        }
                    }
                    DMShareMessage.AdsBanner adsBanner = this.a.adsBanner;
                    if (adsBanner != null) {
                        bundle.putSerializable(DMShareMessage.KEY_ADS_BANNER, adsBanner);
                    }
                    DMShareMessage.YYMemberIntegrate yYMemberIntegrate = this.a.vipScore;
                    if (yYMemberIntegrate != null) {
                        bundle.putSerializable(DMShareMessage.KEY_YYMEMBER_INTEGRATE, yYMemberIntegrate);
                    }
                }
                if (!GenerateImageUtil.c) {
                    DMNav from = DMNav.from(this.c);
                    if (GenerateImageUtil.e > 0) {
                        from.forResult(GenerateImageUtil.e);
                    }
                    from.withExtras(bundle).toUri("damai://share_main");
                }
                if (GenerateImageUtil.b != null) {
                    GenerateImageUtil.b.onSuccess();
                }
            }
            GenerateImageUtil.I(this.c);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class m implements OnRenameListener {
        private static transient /* synthetic */ IpChange $ipChange;

        m() {
        }

        @Override // cn.damai.common.image.luban.OnRenameListener
        public String rename(String str) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1789477473") ? (String) ipChange.ipc$dispatch("-1789477473", new Object[]{this, str}) : "dm_share_tmp.png";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class n implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ ImageView b;
        final /* synthetic */ DMShareMessage c;
        final /* synthetic */ ImageView d;
        final /* synthetic */ View e;
        final /* synthetic */ ScrollView f;

        n(Activity activity, ImageView imageView, DMShareMessage dMShareMessage, ImageView imageView2, View view, ScrollView scrollView) {
            this.a = activity;
            this.b = imageView;
            this.c = dMShareMessage;
            this.d = imageView2;
            this.e = view;
            this.f = scrollView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2109769896")) {
                ipChange.ipc$dispatch("2109769896", new Object[]{this, eVar});
                return;
            }
            Bitmap bitmap = eVar.b;
            if (bitmap == null) {
                GenerateImageUtil.I(this.a);
                cb1.a("bitmap is null");
                ToastUtil.a().e(this.a, "图片生成失败");
                if (GenerateImageUtil.b != null) {
                    GenerateImageUtil.b.onFailure();
                    return;
                }
                return;
            }
            this.b.setImageDrawable(new BitmapDrawable(b21.a(this.a, bitmap)));
            int d = e80.d() - t60.a(this.a, 36.0f);
            int height = (bitmap.getHeight() * d) / bitmap.getWidth();
            if (GenerateImageUtil.STYLE_GENERATE_ARTIST_IMAGE == this.c.shareImageStyle) {
                this.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
                height = d;
            }
            this.d.setLayoutParams(new RelativeLayout.LayoutParams(d, height));
            this.d.setImageBitmap(bitmap);
            GenerateImageUtil.v(this.a, this.e);
            GenerateImageUtil.C(this.a, GenerateImageUtil.t(this.f, Bitmap.Config.ARGB_8888), this.c.fromWhere, true);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class o implements LiveShareImageViewHolder.IFinishCallBack {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ LiveShareImageViewHolder b;
        final /* synthetic */ DMShareMessage c;

        o(Activity activity, LiveShareImageViewHolder liveShareImageViewHolder, DMShareMessage dMShareMessage) {
            this.a = activity;
            this.b = liveShareImageViewHolder;
            this.c = dMShareMessage;
        }

        @Override // cn.damai.commonbusiness.share.live.LiveShareImageViewHolder.IFinishCallBack
        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "254033504")) {
                ipChange.ipc$dispatch("254033504", new Object[]{this});
                return;
            }
            GenerateImageUtil.v(this.a, this.b.b);
            GenerateImageUtil.C(this.a, GenerateImageUtil.s(this.b.b), this.c.fromWhere, true);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class p implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;

        p(Activity activity) {
            this.a = activity;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1471480534")) {
                ipChange.ipc$dispatch("1471480534", new Object[]{this, dVar});
                return;
            }
            GenerateImageUtil.I(this.a);
            ToastUtil.a().e(this.a, "图片生成失败");
            if (GenerateImageUtil.b != null) {
                GenerateImageUtil.b.onFailure();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class q implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ ImageView b;
        final /* synthetic */ DMShareMessage c;
        final /* synthetic */ ImageView d;
        final /* synthetic */ View e;
        final /* synthetic */ ScrollView f;

        q(Activity activity, ImageView imageView, DMShareMessage dMShareMessage, ImageView imageView2, View view, ScrollView scrollView) {
            this.a = activity;
            this.b = imageView;
            this.c = dMShareMessage;
            this.d = imageView2;
            this.e = view;
            this.f = scrollView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "285539307")) {
                ipChange.ipc$dispatch("285539307", new Object[]{this, eVar});
                return;
            }
            Bitmap bitmap = eVar.b;
            if (bitmap == null) {
                GenerateImageUtil.I(this.a);
                cb1.a("bitmap is null");
                ToastUtil.a().e(this.a, "图片生成失败");
                if (GenerateImageUtil.b != null) {
                    GenerateImageUtil.b.onFailure();
                    return;
                }
                return;
            }
            this.b.setImageDrawable(new BitmapDrawable(b21.a(this.a, bitmap)));
            int d = e80.d() - t60.a(this.a, 36.0f);
            int height = (bitmap.getHeight() * d) / bitmap.getWidth();
            if (GenerateImageUtil.STYLE_GENERATE_ARTIST_IMAGE == this.c.shareImageStyle) {
                this.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
                height = d;
            }
            this.d.setLayoutParams(new RelativeLayout.LayoutParams(d, height));
            this.d.setImageBitmap(bitmap);
            GenerateImageUtil.v(this.a, this.e);
            GenerateImageUtil.B(this.a, GenerateImageUtil.s(this.f), this.c.fromWhere);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class r implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;

        r(Activity activity) {
            this.a = activity;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-861912104")) {
                ipChange.ipc$dispatch("-861912104", new Object[]{this, dVar});
                return;
            }
            GenerateImageUtil.I(this.a);
            ToastUtil.a().e(this.a, "图片生成失败");
            if (GenerateImageUtil.b != null) {
                GenerateImageUtil.b.onFailure();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class s implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ ImageView b;
        final /* synthetic */ DMShareMessage c;
        final /* synthetic */ ImageView d;
        final /* synthetic */ View e;
        final /* synthetic */ ScrollView f;

        s(Activity activity, ImageView imageView, DMShareMessage dMShareMessage, ImageView imageView2, View view, ScrollView scrollView) {
            this.a = activity;
            this.b = imageView;
            this.c = dMShareMessage;
            this.d = imageView2;
            this.e = view;
            this.f = scrollView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-930614419")) {
                ipChange.ipc$dispatch("-930614419", new Object[]{this, eVar});
                return;
            }
            Bitmap bitmap = eVar.b;
            if (bitmap == null) {
                GenerateImageUtil.I(this.a);
                cb1.a("bitmap is null");
                ToastUtil.a().e(this.a, "图片生成失败");
                if (GenerateImageUtil.b != null) {
                    GenerateImageUtil.b.onFailure();
                    return;
                }
                return;
            }
            this.b.setImageDrawable(new BitmapDrawable(b21.a(this.a, bitmap)));
            int d = e80.d() - t60.a(this.a, 36.0f);
            int height = (bitmap.getHeight() * d) / bitmap.getWidth();
            if (GenerateImageUtil.STYLE_GENERATE_ARTIST_IMAGE == this.c.shareImageStyle) {
                this.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
                height = d;
            }
            this.d.setLayoutParams(new RelativeLayout.LayoutParams(d, height));
            this.d.setImageBitmap(bitmap);
            GenerateImageUtil.v(this.a, this.e);
            GenerateImageUtil.B(this.a, GenerateImageUtil.s(this.f), this.c.fromWhere);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class t implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;

        t(Activity activity) {
            this.a = activity;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1099662554")) {
                ipChange.ipc$dispatch("1099662554", new Object[]{this, dVar});
                return;
            }
            GenerateImageUtil.I(this.a);
            ToastUtil.a().e(this.a, "图片生成失败");
            if (GenerateImageUtil.b != null) {
                GenerateImageUtil.b.onFailure();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class u implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ ImageView b;
        final /* synthetic */ DMShareMessage c;
        final /* synthetic */ ImageView d;
        final /* synthetic */ View e;
        final /* synthetic */ ScrollView f;

        u(Activity activity, ImageView imageView, DMShareMessage dMShareMessage, ImageView imageView2, View view, ScrollView scrollView) {
            this.a = activity;
            this.b = imageView;
            this.c = dMShareMessage;
            this.d = imageView2;
            this.e = view;
            this.f = scrollView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2146768145")) {
                ipChange.ipc$dispatch("-2146768145", new Object[]{this, eVar});
                return;
            }
            Bitmap bitmap = eVar.b;
            if (bitmap == null) {
                GenerateImageUtil.I(this.a);
                cb1.a("bitmap is null");
                ToastUtil.a().e(this.a, "图片生成失败");
                if (GenerateImageUtil.b != null) {
                    GenerateImageUtil.b.onFailure();
                    return;
                }
                return;
            }
            this.b.setImageDrawable(new BitmapDrawable(b21.a(this.a, bitmap)));
            int d = e80.d() - t60.a(this.a, 36.0f);
            int height = (bitmap.getHeight() * d) / bitmap.getWidth();
            if (GenerateImageUtil.STYLE_GENERATE_ARTIST_IMAGE == this.c.shareImageStyle) {
                this.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
                height = d;
            }
            this.d.setLayoutParams(new RelativeLayout.LayoutParams(d, height));
            this.d.setImageBitmap(bitmap);
            GenerateImageUtil.v(this.a, this.e);
            GenerateImageUtil.B(this.a, GenerateImageUtil.s(this.f), this.c.fromWhere);
        }
    }

    private static void A(Activity activity, DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "247097612")) {
            ipChange.ipc$dispatch("247097612", new Object[]{activity, dMShareMessage});
            return;
        }
        H(activity);
        View inflate = LayoutInflater.from(activity).inflate(R$layout.layout_generate_project_image, (ViewGroup) null);
        ScrollView scrollView = (ScrollView) inflate.findViewById(R$id.share_page);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.share_page_bg);
        ImageView imageView2 = (ImageView) inflate.findViewById(R$id.share_page_poster);
        ((TextView) inflate.findViewById(R$id.share_page_title)).setText(dMShareMessage.shareTitle);
        ((TextView) inflate.findViewById(R$id.share_page_subtitle)).setText(dMShareMessage.shareContent);
        ((ImageView) inflate.findViewById(R$id.share_page_qrcode_img)).setImageBitmap(QrcodeUtil.a(t60.a(activity, 60.0f), dMShareMessage.shareLink));
        ((TextView) inflate.findViewById(R$id.share_page_qrcode_tip)).setText("长按识别二维码，查看精彩演出");
        cn.damai.common.image.a.b().h(activity).c(dMShareMessage.sharePictureUrl).n(new k(activity, imageView, dMShareMessage, imageView2, inflate, scrollView)).e(new j(activity)).f();
    }

    public static void B(Activity activity, Bitmap bitmap, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1237544313")) {
            ipChange.ipc$dispatch("1237544313", new Object[]{activity, bitmap, str});
        } else {
            C(activity, bitmap, str, false);
        }
    }

    public static void C(Activity activity, Bitmap bitmap, String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-290786181")) {
            ipChange.ipc$dispatch("-290786181", new Object[]{activity, bitmap, str, Boolean.valueOf(z)});
        } else {
            D(activity, bitmap, str, z, 70);
        }
    }

    public static void D(Activity activity, Bitmap bitmap, String str, boolean z, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-424407576")) {
            ipChange.ipc$dispatch("-424407576", new Object[]{activity, bitmap, str, Boolean.valueOf(z), Integer.valueOf(i2)});
        } else {
            E(activity, bitmap, str, z, i2, null);
        }
    }

    public static void E(Activity activity, Bitmap bitmap, String str, boolean z, int i2, DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "998824676")) {
            ipChange.ipc$dispatch("998824676", new Object[]{activity, bitmap, str, Boolean.valueOf(z), Integer.valueOf(i2), dMShareMessage});
            return;
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(b21.e(activity)));
            bitmap.compress(Bitmap.CompressFormat.PNG, i2, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            h(activity, str, z, dMShareMessage);
        } catch (IOException e2) {
            e2.printStackTrace();
            I(activity);
            ToastUtil.a().e(activity, "图片生成失败");
            OnImageGenerateListener onImageGenerateListener = b;
            if (onImageGenerateListener != null) {
                onImageGenerateListener.onFailure();
            }
        }
    }

    private static GradientDrawable F(String str, int i2, String str2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "181696947")) {
            return (GradientDrawable) ipChange.ipc$dispatch("181696947", new Object[]{str, Integer.valueOf(i2), str2, Integer.valueOf(i3)});
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius(i2);
        gradientDrawable.setStroke(i3, Color.parseColor(str2));
        return gradientDrawable;
    }

    public static void G(OnImageGenerateListener onImageGenerateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-229887942")) {
            ipChange.ipc$dispatch("-229887942", new Object[]{onImageGenerateListener});
        } else {
            b = onImageGenerateListener;
        }
    }

    public static void H(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-565848030")) {
            ipChange.ipc$dispatch("-565848030", new Object[]{activity});
            return;
        }
        try {
            if (activity.isFinishing()) {
                return;
            }
            if (a == null) {
                a = new DMProgressDialog(activity).a();
            }
            a.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void I(Activity activity) {
        DMProgressDialog dMProgressDialog;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1619707362")) {
            ipChange.ipc$dispatch("-1619707362", new Object[]{activity});
            return;
        }
        try {
            if (activity.isFinishing() || (dMProgressDialog = a) == null) {
                return;
            }
            dMProgressDialog.dismiss();
            a = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void J(Activity activity, DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "312003679")) {
            ipChange.ipc$dispatch("312003679", new Object[]{activity, dMShareMessage});
            return;
        }
        H(activity);
        View inflate = LayoutInflater.from(activity).inflate(R$layout.layout_generate_project_image, (ViewGroup) null);
        ScrollView scrollView = (ScrollView) inflate.findViewById(R$id.share_page);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.share_page_bg);
        ImageView imageView2 = (ImageView) inflate.findViewById(R$id.share_page_poster);
        ((TextView) inflate.findViewById(R$id.share_page_title)).setText(dMShareMessage.shareTitle);
        ((TextView) inflate.findViewById(R$id.share_page_subtitle)).setText(dMShareMessage.shareContent);
        ((ImageView) inflate.findViewById(R$id.share_page_qrcode_img)).setImageBitmap(QrcodeUtil.a(t60.a(activity, 60.0f), dMShareMessage.shareLink));
        ((TextView) inflate.findViewById(R$id.share_page_qrcode_tip)).setText("长按二维码跟着我一起感受现场");
        cn.damai.common.image.a.b().h(activity).c(dMShareMessage.sharePictureUrl).n(new s(activity, imageView, dMShareMessage, imageView2, inflate, scrollView)).e(new r(activity)).f();
    }

    public static boolean K(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1317957251") ? ((Boolean) ipChange.ipc$dispatch("-1317957251", new Object[]{str})).booleanValue() : STYLE_GENERATE_LIVE_IMAGE.equals(str);
    }

    private static void g(Activity activity, DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1588273345")) {
            ipChange.ipc$dispatch("1588273345", new Object[]{activity, dMShareMessage});
            return;
        }
        H(activity);
        View inflate = LayoutInflater.from(activity).inflate(R$layout.layout_generate_project_image, (ViewGroup) null);
        ScrollView scrollView = (ScrollView) inflate.findViewById(R$id.share_page);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.share_page_bg);
        ImageView imageView2 = (ImageView) inflate.findViewById(R$id.share_page_poster);
        ((TextView) inflate.findViewById(R$id.share_page_title)).setText(dMShareMessage.shareTitle);
        ((TextView) inflate.findViewById(R$id.share_page_subtitle)).setText(dMShareMessage.shareContent);
        ((ImageView) inflate.findViewById(R$id.share_page_qrcode_img)).setImageBitmap(QrcodeUtil.a(t60.a(activity, 60.0f), dMShareMessage.shareLink));
        ((TextView) inflate.findViewById(R$id.share_page_qrcode_tip)).setText("长按二维码关注TA");
        cn.damai.common.image.a.b().h(activity).c(dMShareMessage.sharePictureUrl).n(new d(activity, imageView, imageView2, inflate, scrollView, dMShareMessage)).e(new c(activity)).f();
    }

    public static void h(Activity activity, String str, boolean z, DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1952156973")) {
            ipChange.ipc$dispatch("-1952156973", new Object[]{activity, str, Boolean.valueOf(z), dMShareMessage});
            return;
        }
        Luban.a l2 = Luban.l(activity);
        if (z) {
            l2.i(512000);
        }
        l2.k(b21.e(activity)).n(b21.d(activity)).m(new m()).l(new l(dMShareMessage, str, activity)).j();
    }

    private static void i(Activity activity, DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1302857147")) {
            ipChange.ipc$dispatch("1302857147", new Object[]{activity, dMShareMessage});
            return;
        }
        H(activity);
        View inflate = LayoutInflater.from(activity).inflate(R$layout.layout_generate_project_image, (ViewGroup) null);
        ScrollView scrollView = (ScrollView) inflate.findViewById(R$id.share_page);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.share_page_bg);
        ImageView imageView2 = (ImageView) inflate.findViewById(R$id.share_page_poster);
        ((TextView) inflate.findViewById(R$id.share_page_title)).setText(dMShareMessage.shareTitle);
        ((TextView) inflate.findViewById(R$id.share_page_subtitle)).setText(dMShareMessage.shareContent);
        ((ImageView) inflate.findViewById(R$id.share_page_qrcode_img)).setImageBitmap(QrcodeUtil.a(t60.a(activity, 60.0f), dMShareMessage.shareLink));
        ((TextView) inflate.findViewById(R$id.share_page_qrcode_tip)).setText("长按识别二维码，查看精彩演出");
        cn.damai.common.image.a.b().h(activity).c(dMShareMessage.sharePictureUrl).n(new u(activity, imageView, dMShareMessage, imageView2, inflate, scrollView)).e(new t(activity)).f();
    }

    private static void j(Activity activity, DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1065363959")) {
            ipChange.ipc$dispatch("1065363959", new Object[]{activity, dMShareMessage});
            return;
        }
        H(activity);
        EvaluateShareViewHolder evaluateShareViewHolder = new EvaluateShareViewHolder(activity);
        evaluateShareViewHolder.l(dMShareMessage, new f(activity, evaluateShareViewHolder, dMShareMessage));
    }

    private static void k(Activity activity, DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2015141157")) {
            ipChange.ipc$dispatch("-2015141157", new Object[]{activity, dMShareMessage});
            return;
        }
        H(activity);
        View inflate = LayoutInflater.from(activity).inflate(R$layout.layout_generate_fission_share_image, (ViewGroup) null);
        ScrollView scrollView = (ScrollView) inflate.findViewById(R$id.share_page);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R$id.share_page_bg_layout);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.share_page_qrcode_img);
        TextView textView = (TextView) inflate.findViewById(R$id.share_page_reward_tip);
        ((ImageView) inflate.findViewById(R$id.share_page_poster)).setImageBitmap(dMShareMessage.businessBitmap);
        int a2 = t60.a(activity, 70.0f);
        if (!TextUtils.isEmpty(dMShareMessage.shareLink)) {
            textView.setVisibility(0);
            imageView.setVisibility(0);
            Bitmap decodeResource = BitmapFactory.decodeResource(activity.getResources(), R$drawable.damai_small_logo);
            imageView.setImageBitmap(QrcodeUtil.b(a2, SHARE_URL + URLEncoder.encode(dMShareMessage.shareLink), decodeResource));
            textView.setText("长按识别二维码 " + dMShareMessage.tip);
            DMShareMessage.QRCodeColor qRCodeColor = dMShareMessage.qrCodeColor;
            if (qRCodeColor != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    imageView.setBackground(F(qRCodeColor.solidColor, qRCodeColor.radius, qRCodeColor.strokeColor, qRCodeColor.strokeWidth));
                } else {
                    imageView.setBackgroundDrawable(F(qRCodeColor.solidColor, qRCodeColor.radius, qRCodeColor.strokeColor, qRCodeColor.strokeWidth));
                }
                textView.setTextColor(Color.parseColor(dMShareMessage.qrCodeColor.strokeColor));
            } else {
                textView.setTextColor(Color.parseColor("#ffffff"));
                imageView.setBackgroundResource(R$drawable.bg_corner_6_white);
            }
        } else {
            textView.setVisibility(8);
            imageView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(dMShareMessage.bgImageUrl)) {
            cn.damai.common.image.a.b().h(activity).c(dMShareMessage.bgImageUrl).k(new DMRoundedCornersBitmapProcessor(t60.a(activity, 6.0f), 0)).n(new i(activity, relativeLayout, inflate, scrollView, dMShareMessage)).e(new g(activity, relativeLayout, inflate, scrollView, dMShareMessage)).f();
            return;
        }
        relativeLayout.setBackgroundResource(R$drawable.fassion_share_bg);
        n(activity, inflate, scrollView, dMShareMessage);
    }

    private static void l(Activity activity, DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-848862447")) {
            ipChange.ipc$dispatch("-848862447", new Object[]{activity, dMShareMessage});
            return;
        }
        View inflate = LayoutInflater.from(activity).inflate(R$layout.layout_generate_fission_upgrade_share_image, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R$id.share_page_poster)).setImageBitmap(dMShareMessage.businessBitmap);
        d = 2;
        n(activity, inflate, (ScrollView) inflate.findViewById(R$id.share_page), dMShareMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(Activity activity, View view, ScrollView scrollView, DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-16543503")) {
            ipChange.ipc$dispatch("-16543503", new Object[]{activity, view, scrollView, dMShareMessage});
            return;
        }
        v(activity, view);
        E(activity, s(scrollView), dMShareMessage.fromWhere, true, 70, dMShareMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(Activity activity, View view, ScrollView scrollView, DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1906526408")) {
            ipChange.ipc$dispatch("-1906526408", new Object[]{activity, view, scrollView, dMShareMessage});
        } else if (d == 2) {
            v(activity, view);
            B(activity, s(scrollView), dMShareMessage.fromWhere);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(Activity activity, View view, ScrollView scrollView, DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-321899836")) {
            ipChange.ipc$dispatch("-321899836", new Object[]{activity, view, scrollView, dMShareMessage});
            return;
        }
        v(activity, view);
        E(activity, s(scrollView), dMShareMessage.fromWhere, true, 70, dMShareMessage);
    }

    public static void p(Activity activity, DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1365021457")) {
            ipChange.ipc$dispatch("-1365021457", new Object[]{activity, dMShareMessage});
            return;
        }
        e = -1;
        int i2 = dMShareMessage.requestCode;
        if (i2 > 0) {
            e = i2;
        }
        if ("projectImage".equals(dMShareMessage.shareImageStyle)) {
            z(activity, dMShareMessage);
        } else if (STYLE_GENERATE_ARTIST_IMAGE.equals(dMShareMessage.shareImageStyle)) {
            g(activity, dMShareMessage);
        } else if (STYLE_GENERATE_EVALUATE_IMAGE.equals(dMShareMessage.shareImageStyle)) {
            j(activity, dMShareMessage);
        } else if (STYLE_GENERATE_RANKING_IMAGE.equals(dMShareMessage.shareImageStyle)) {
            A(activity, dMShareMessage);
        } else if (STYLE_GENERATE_DISCOUNT_TICKET.equals(dMShareMessage.shareImageStyle)) {
            i(activity, dMShareMessage);
        } else if (STYLE_GENERATE_NEW_SHARE.equals(dMShareMessage.shareImageStyle)) {
            k(activity, dMShareMessage);
        } else if (STYLE_GENERATE_NEW_SHARE_UPGRADE.equals(dMShareMessage.shareImageStyle)) {
            l(activity, dMShareMessage);
        } else if (STYLE_GENERATE_THEME_IMAGE.equals(dMShareMessage.shareImageStyle)) {
            J(activity, dMShareMessage);
        } else if (STYLE_GENERATE_MUSIC_IMAGE.equals(dMShareMessage.shareImageStyle)) {
            x(activity, dMShareMessage);
        } else if (STYLE_GENERATE_IP_DRAMA_IMAGE.equals(dMShareMessage.shareImageStyle)) {
            u(activity, dMShareMessage);
        } else if (STYLE_GENERATE_NFT_CARD_SHARE.equals(dMShareMessage.shareImageStyle)) {
            y(activity, dMShareMessage);
        }
    }

    public static void q(Activity activity, DMShareMessage dMShareMessage, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "634053573")) {
            ipChange.ipc$dispatch("634053573", new Object[]{activity, dMShareMessage, Boolean.valueOf(z)});
            return;
        }
        c = z;
        p(activity, dMShareMessage);
    }

    public static void r(Activity activity, DMShareMessage dMShareMessage, boolean z, IImageShareInfoProvider iImageShareInfoProvider) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2147063703")) {
            ipChange.ipc$dispatch("-2147063703", new Object[]{activity, dMShareMessage, Boolean.valueOf(z), iImageShareInfoProvider});
            return;
        }
        c = z;
        w(activity, dMShareMessage, iImageShareInfoProvider);
    }

    public static Bitmap s(ScrollView scrollView) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "823473330") ? (Bitmap) ipChange.ipc$dispatch("823473330", new Object[]{scrollView}) : t(scrollView, Bitmap.Config.ARGB_4444);
    }

    public static Bitmap t(ScrollView scrollView, Bitmap.Config config) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2108416782")) {
            return (Bitmap) ipChange.ipc$dispatch("2108416782", new Object[]{scrollView, config});
        }
        int i2 = 0;
        for (int i3 = 0; i3 < scrollView.getChildCount(); i3++) {
            i2 = scrollView.getChildAt(i3).getHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(scrollView.getWidth(), i2, config);
        scrollView.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private static void u(Activity activity, DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-903970346")) {
            ipChange.ipc$dispatch("-903970346", new Object[]{activity, dMShareMessage});
            return;
        }
        H(activity);
        View inflate = LayoutInflater.from(activity).inflate(R$layout.layout_generate_project_image, (ViewGroup) null);
        ScrollView scrollView = (ScrollView) inflate.findViewById(R$id.share_page);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.share_page_bg);
        ImageView imageView2 = (ImageView) inflate.findViewById(R$id.share_page_poster);
        TextView textView = (TextView) inflate.findViewById(R$id.share_page_subtitle);
        ((TextView) inflate.findViewById(R$id.share_page_title)).setText(dMShareMessage.shareTitle);
        textView.setText(dMShareMessage.shareContent);
        textView.setVisibility(8);
        ((ImageView) inflate.findViewById(R$id.share_page_qrcode_img)).setImageBitmap(QrcodeUtil.a(t60.a(activity, 60.0f), dMShareMessage.shareLink));
        ((TextView) inflate.findViewById(R$id.share_page_qrcode_tip)).setText("长按二维码跟着我一起感受现场");
        cn.damai.common.image.a.b().h(activity).c(dMShareMessage.sharePictureUrl).n(new q(activity, imageView, dMShareMessage, imageView2, inflate, scrollView)).e(new p(activity)).f();
    }

    public static void v(Activity activity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1260780948")) {
            ipChange.ipc$dispatch("-1260780948", new Object[]{activity, view});
            return;
        }
        DisplayMetrics b2 = t60.b(activity);
        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(b2);
        int i3 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(b2);
        view.layout(0, 0, i2, i3);
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    private static void w(Activity activity, DMShareMessage dMShareMessage, IImageShareInfoProvider iImageShareInfoProvider) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "279933032")) {
            ipChange.ipc$dispatch("279933032", new Object[]{activity, dMShareMessage, iImageShareInfoProvider});
            return;
        }
        H(activity);
        LiveShareImageViewHolder liveShareImageViewHolder = new LiveShareImageViewHolder(activity);
        liveShareImageViewHolder.q((LiveShareImageBean) iImageShareInfoProvider.getImageShareInfo(), new o(activity, liveShareImageViewHolder, dMShareMessage));
    }

    private static void x(Activity activity, DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1948292677")) {
            ipChange.ipc$dispatch("-1948292677", new Object[]{activity, dMShareMessage});
            return;
        }
        H(activity);
        View inflate = LayoutInflater.from(activity).inflate(R$layout.layout_generate_project_image, (ViewGroup) null);
        ScrollView scrollView = (ScrollView) inflate.findViewById(R$id.share_page);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.share_page_bg);
        ImageView imageView2 = (ImageView) inflate.findViewById(R$id.share_page_poster);
        ((TextView) inflate.findViewById(R$id.share_page_title)).setText(dMShareMessage.shareTitle);
        ((TextView) inflate.findViewById(R$id.share_page_subtitle)).setText(dMShareMessage.shareContent);
        ((ImageView) inflate.findViewById(R$id.share_page_qrcode_img)).setImageBitmap(QrcodeUtil.a(t60.a(activity, 60.0f), dMShareMessage.shareLink));
        ((TextView) inflate.findViewById(R$id.share_page_qrcode_tip)).setText("长按识别二维码，查看精彩演出");
        cn.damai.common.image.a.b().h(activity).c(dMShareMessage.sharePictureUrl).m().n(new n(activity, imageView, dMShareMessage, imageView2, inflate, scrollView)).e(new h(activity)).f();
    }

    private static void y(Activity activity, DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1430015934")) {
            ipChange.ipc$dispatch("-1430015934", new Object[]{activity, dMShareMessage});
            return;
        }
        H(activity);
        mi1 mi1Var = new mi1(activity);
        mi1Var.e(dMShareMessage, new e(activity, mi1Var, dMShareMessage));
    }

    private static void z(Activity activity, DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1933814319")) {
            ipChange.ipc$dispatch("1933814319", new Object[]{activity, dMShareMessage});
            return;
        }
        H(activity);
        View inflate = LayoutInflater.from(activity).inflate(R$layout.layout_generate_project_image, (ViewGroup) null);
        ScrollView scrollView = (ScrollView) inflate.findViewById(R$id.share_page);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.share_page_bg);
        ImageView imageView2 = (ImageView) inflate.findViewById(R$id.share_page_poster);
        ImageView imageView3 = (ImageView) inflate.findViewById(R$id.share_page_qrcode_img);
        ((TextView) inflate.findViewById(R$id.share_page_title)).setText(dMShareMessage.shareTitle);
        ((TextView) inflate.findViewById(R$id.share_page_subtitle)).setText(dMShareMessage.shareContent);
        ((TextView) inflate.findViewById(R$id.share_page_qrcode_tip)).setText("长按二维码查看演出详情");
        int a2 = t60.a(activity, 150.0f);
        Bitmap a3 = QrcodeUtil.a(a2, SHARE_URL + URLEncoder.encode(dMShareMessage.shareLink));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView3.getLayoutParams();
        layoutParams.height = a2;
        layoutParams.width = a2;
        imageView3.setImageBitmap(a3);
        cn.damai.common.image.a.b().h(activity).c(dMShareMessage.sharePictureUrl).n(new b(activity, imageView, dMShareMessage, imageView2, inflate, scrollView)).e(new a(activity)).f();
    }
}
