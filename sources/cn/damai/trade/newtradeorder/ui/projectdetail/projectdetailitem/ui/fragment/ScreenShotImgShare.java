package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.image.luban.Luban;
import cn.damai.common.image.luban.OnCompressListener;
import cn.damai.common.image.luban.OnRenameListener;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.qrcode.util.QrcodeUtil;
import cn.damai.commonbusiness.rank.RankInfo;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.login.LoginManager;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlParserManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDetailDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.adapter.ProjectItemDetailAdapter;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectHeaderPanel;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectBrandAndArtistMultiViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectBrandSingleViewHolder;
import cn.damai.wxapi.ShareUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import tb.b21;
import tb.gb;
import tb.gw1;
import tb.ir1;
import tb.iu0;
import tb.kg2;
import tb.m62;
import tb.m91;
import tb.mr1;
import tb.t60;
import tb.z20;
import tb.zx2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ScreenShotImgShare {
    private static transient /* synthetic */ IpChange $ipChange;
    long a;
    private Activity b;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare$12  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass12 implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Bitmap a;

        AnonymousClass12(Bitmap bitmap) {
            this.a = bitmap;
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1143528505")) {
                ipChange.ipc$dispatch("1143528505", new Object[]{this});
            } else {
                iu0.b().a(new Runnable() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare.12.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1352262595")) {
                            ipChange2.ipc$dispatch("-1352262595", new Object[]{this});
                            return;
                        }
                        AnonymousClass12 anonymousClass12 = AnonymousClass12.this;
                        if (anonymousClass12.a == null) {
                            return;
                        }
                        String saveBitmapToDcimDir = ShareUtil.saveBitmapToDcimDir(ScreenShotImgShare.this.g(), AnonymousClass12.this.a);
                        if (!TextUtils.isEmpty(saveBitmapToDcimDir)) {
                            ScreenShotImgShare.this.g().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(saveBitmapToDcimDir))));
                            ScreenShotImgShare.this.g().runOnUiThread(new Runnable() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare.12.1.1
                                private static transient /* synthetic */ IpChange $ipChange;

                                @Override // java.lang.Runnable
                                public void run() {
                                    IpChange ipChange3 = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange3, "-802963312")) {
                                        ipChange3.ipc$dispatch("-802963312", new Object[]{this});
                                    } else {
                                        ToastUtil.a().e(ScreenShotImgShare.this.g(), "保存成功");
                                    }
                                }
                            });
                            return;
                        }
                        ScreenShotImgShare.this.g().runOnUiThread(new Runnable() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare.12.1.2
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "-999476817")) {
                                    ipChange3.ipc$dispatch("-999476817", new Object[]{this});
                                } else {
                                    ToastUtil.a().e(ScreenShotImgShare.this.g(), "保存失败");
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare$7  reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass7 implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ long val$mProjectId;
        final /* synthetic */ ScrollView val$scroll;
        final /* synthetic */ View val$shareView;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare$7$a */
        /* loaded from: classes16.dex */
        public class View$OnClickListenerC2334a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare$7$a$a */
            /* loaded from: classes8.dex */
            public class C2335a implements OnGrantListener {
                private static transient /* synthetic */ IpChange $ipChange;

                C2335a() {
                }

                @Override // cn.damai.common.askpermission.OnGrantListener
                public void onGranted() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "405390143")) {
                        ipChange.ipc$dispatch("405390143", new Object[]{this});
                        return;
                    }
                    AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                    ScreenShotImgShare.this.i(ScreenShotImgShare.this.f(anonymousClass7.val$scroll, anonymousClass7.val$shareView));
                    HashMap hashMap = new HashMap();
                    hashMap.put("usercode", z20.E());
                    hashMap.put("item_id", AnonymousClass7.this.val$mProjectId + "");
                    C0529c.e().x(new C0525a.C0527b().i(gb.PROJECT_PAGE).f("screenshot").l("save").g(false).j(hashMap));
                }
            }

            View$OnClickListenerC2334a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1189786957")) {
                    ipChange.ipc$dispatch("-1189786957", new Object[]{this, view});
                } else {
                    ir1.b(ScreenShotImgShare.this.g(), false, mr1.STORAGE, "用于为您保存图片至本地", new C2335a());
                }
            }
        }

        AnonymousClass7(ScrollView scrollView, View view, long j) {
            this.val$scroll = scrollView;
            this.val$shareView = view;
            this.val$mProjectId = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1615761078")) {
                ipChange.ipc$dispatch("-1615761078", new Object[]{this});
                return;
            }
            View$OnClickListenerC2334a view$OnClickListenerC2334a = new View$OnClickListenerC2334a();
            this.val$shareView.findViewById(R$id.detail_screenshot_content_save1).setOnClickListener(view$OnClickListenerC2334a);
            this.val$shareView.findViewById(R$id.detail_screenshot_content_save2).setOnClickListener(view$OnClickListenerC2334a);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare$a */
    /* loaded from: classes8.dex */
    public class C2336a implements OnCompressListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ View b;
        final /* synthetic */ Activity c;

        C2336a(String str, View view, Activity activity) {
            this.a = str;
            this.b = view;
            this.c = activity;
        }

        @Override // cn.damai.common.image.luban.OnCompressListener
        public void onError(Throwable th) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1333311079")) {
                ipChange.ipc$dispatch("1333311079", new Object[]{this, th});
            } else {
                ToastUtil.a().e(this.c, "图片生成失败");
            }
        }

        @Override // cn.damai.common.image.luban.OnCompressListener
        public void onStart() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1528819276")) {
                ipChange.ipc$dispatch("-1528819276", new Object[]{this});
            }
        }

        @Override // cn.damai.common.image.luban.OnCompressListener
        public void onSuccess(File file) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "816883306")) {
                ipChange.ipc$dispatch("816883306", new Object[]{this, file});
                return;
            }
            String absolutePath = file.getAbsolutePath();
            Bundle bundle = new Bundle();
            bundle.putString("imageModeUrl", absolutePath);
            bundle.putString("producturl", this.a);
            ShareManager.E().P(ScreenShotImgShare.this.g(), bundle, this.b);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare$b */
    /* loaded from: classes8.dex */
    public class C2337b implements OnRenameListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2337b(ScreenShotImgShare screenShotImgShare) {
        }

        @Override // cn.damai.common.image.luban.OnRenameListener
        public String rename(String str) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1614802304") ? (String) ipChange.ipc$dispatch("1614802304", new Object[]{this, str}) : "dm_share_tmp.png";
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare$c */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2338c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PopupWindow a;

        View$OnClickListenerC2338c(ScreenShotImgShare screenShotImgShare, PopupWindow popupWindow) {
            this.a = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-967493343")) {
                ipChange.ipc$dispatch("-967493343", new Object[]{this, view});
            } else {
                this.a.dismiss();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare$d */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2339d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ScrollView a;
        final /* synthetic */ View b;
        final /* synthetic */ FrameLayout c;
        final /* synthetic */ String d;
        final /* synthetic */ long e;

        View$OnClickListenerC2339d(ScrollView scrollView, View view, FrameLayout frameLayout, String str, long j) {
            this.a = scrollView;
            this.b = view;
            this.c = frameLayout;
            this.d = str;
            this.e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1184653017")) {
                ipChange.ipc$dispatch("-1184653017", new Object[]{this, view});
                return;
            }
            Bitmap f = ScreenShotImgShare.this.f(this.a, this.b);
            ScreenShotImgShare screenShotImgShare = ScreenShotImgShare.this;
            screenShotImgShare.k(screenShotImgShare.g(), f, this.c, this.d);
            HashMap hashMap = new HashMap();
            hashMap.put("usercode", z20.E());
            hashMap.put("item_id", this.e + "");
            C0529c.e().x(new C0525a.C0527b().i(gb.PROJECT_PAGE).f("screenshot").l("share").g(false).j(hashMap));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare$e */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2340e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2340e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "926637352")) {
                ipChange.ipc$dispatch("926637352", new Object[]{this, view});
            } else if (!LoginManager.k().q()) {
                LoginManager.k().x(ScreenShotImgShare.this.g(), new Intent(), 10001);
            } else {
                Bundle bundle = new Bundle();
                bundle.putSerializable("screenshot_info", ScreenShotDetector.k().l());
                DMNav.from(ScreenShotImgShare.this.g()).withExtras(bundle).toUri(NavUri.b("feedback_list"));
            }
        }
    }

    private Bitmap d(Bitmap bitmap, Bitmap bitmap2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-341905450")) {
            return (Bitmap) ipChange.ipc$dispatch("-341905450", new Object[]{this, bitmap, bitmap2});
        }
        Bitmap createBitmap = Bitmap.createBitmap(Math.max(bitmap.getWidth(), bitmap2.getWidth()), bitmap.getHeight() + bitmap2.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, 0.0f, bitmap.getHeight(), (Paint) null);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(LinearLayout linearLayout, int i, View view, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-493519534")) {
            ipChange.ipc$dispatch("-493519534", new Object[]{this, linearLayout, Integer.valueOf(i), view, Integer.valueOf(i2)});
            return;
        }
        DisplayMetrics b = m62.b(g());
        Bitmap createBitmap = Bitmap.createBitmap(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(b), i, Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        ImageView imageView = (ImageView) linearLayout.findViewById(i2);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = (int) (((com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(b) - m62.a(g(), 94.0f)) / createBitmap.getWidth()) * createBitmap.getHeight());
        imageView.setLayoutParams(layoutParams);
        imageView.setImageBitmap(createBitmap);
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap f(ScrollView scrollView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-34938699")) {
            return (Bitmap) ipChange.ipc$dispatch("-34938699", new Object[]{this, scrollView, view});
        }
        Bitmap s = GenerateImageUtil.s(scrollView);
        int i = R$id.detail_screenshot_conent_top;
        Bitmap createBitmap = Bitmap.createBitmap(view.findViewById(i).getWidth(), m62.a(g(), 66.0f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        view.findViewById(i).setBackground(h().getDrawable(R$drawable.detail_screenshot_title_bg_noradius));
        view.findViewById(i).draw(canvas);
        view.findViewById(i).setBackground(h().getDrawable(R$drawable.detail_screenshot_title_bg));
        return d(createBitmap, s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2081625989") ? (Activity) ipChange.ipc$dispatch("2081625989", new Object[]{this}) : this.b;
    }

    private Resources h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "463762340") ? (Resources) ipChange.ipc$dispatch("463762340", new Object[]{this}) : g().getResources();
    }

    public void i(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1679936391")) {
            ipChange.ipc$dispatch("-1679936391", new Object[]{this, bitmap});
        } else {
            ir1.b(g(), false, mr1.STORAGE, "用于为您保存图片至本地", new AnonymousClass12(bitmap));
        }
    }

    public PopupWindow j(final long j, ProjectDetailDataBean projectDetailDataBean, RankInfo rankInfo, FrameLayout frameLayout, ProjectItemDetailAdapter projectItemDetailAdapter, zx2 zx2Var, Activity activity) {
        View view;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1733533254")) {
            return (PopupWindow) ipChange.ipc$dispatch("1733533254", new Object[]{this, Long.valueOf(j), projectDetailDataBean, rankInfo, frameLayout, projectItemDetailAdapter, zx2Var, activity});
        }
        this.b = activity;
        PopupWindow popupWindow = new PopupWindow(g());
        View inflate = LayoutInflater.from(g()).inflate(R$layout.layout_detail_screenshot_parent, (ViewGroup) null);
        DisplayMetrics b = m62.b(g());
        popupWindow.setWidth(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(b));
        final int a = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(b) + kg2.a(g());
        popupWindow.setHeight(a);
        popupWindow.setClippingEnabled(false);
        popupWindow.setContentView(inflate);
        popupWindow.setBackgroundDrawable(new ColorDrawable(1711276032));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-508231440")) {
                    ipChange2.ipc$dispatch("-508231440", new Object[]{this});
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("usercode", z20.E());
                hashMap.put("item_id", j + "");
                C0529c.e().C("share", "screenshot", gb.PROJECT_PAGE, "1.0", System.currentTimeMillis() - ScreenShotImgShare.this.a, hashMap, 2201);
            }
        });
        inflate.setOnClickListener(new View$OnClickListenerC2338c(this, popupWindow));
        int i = R$id.detail_screenshot_conent;
        ViewGroup.LayoutParams layoutParams = inflate.findViewById(i).getLayoutParams();
        layoutParams.height = a - m62.a(g(), 154.0f);
        inflate.findViewById(i).setLayoutParams(layoutParams);
        inflate.postInvalidate();
        ScrollView scrollView = (ScrollView) inflate.findViewById(R$id.screenshot_share_content_scroll);
        final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.screenshot_share_content_ll);
        final View findViewById = popupWindow.getContentView().findViewById(R$id.project_header);
        findViewById.setClickable(false);
        View view2 = inflate;
        ProjectHeaderPanel projectHeaderPanel = new ProjectHeaderPanel(g(), j, popupWindow.getContentView(), null);
        projectHeaderPanel.w(false);
        projectHeaderPanel.o(projectDetailDataBean, rankInfo);
        findViewById.findViewById(R$id.header_base_uill).setBackground(h().getDrawable(R$drawable.bg_white));
        findViewById.setPadding(findViewById.getPaddingLeft(), 0, findViewById.getPaddingRight(), findViewById.getPaddingBottom());
        findViewById.findViewById(R$id.header_service_etc_ui).setVisibility(8);
        findViewById.findViewById(R$id.project_header_video).setVisibility(8);
        findViewById.findViewById(R$id.irc_tour).setVisibility(8);
        popupWindow.showAtLocation(frameLayout, 17, 0, 0);
        findViewById.post(new Runnable() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-829707058")) {
                    ipChange2.ipc$dispatch("-829707058", new Object[]{this});
                    return;
                }
                ScreenShotImgShare.this.a = System.currentTimeMillis();
                ScreenShotImgShare.this.e(linearLayout, findViewById.getHeight() == 0 ? m62.a(ScreenShotImgShare.this.g(), 460.0f) : findViewById.getHeight(), findViewById, R$id.screenshot_share_content_img);
            }
        });
        if (projectItemDetailAdapter != null && projectItemDetailAdapter.getItemCount() > 0) {
            int i2 = 0;
            while (i2 < projectItemDetailAdapter.getItemCount()) {
                int itemViewType = projectItemDetailAdapter.getItemViewType(i2);
                ProjectDataHolder projectDataHolder = projectItemDetailAdapter.b().get(i2);
                if (itemViewType == 11) {
                    view = view2;
                    List<HtmlParserManager.C2244a> shrinkConvertedItem = projectDataHolder.getShrinkConvertedItem();
                    if (shrinkConvertedItem != null && shrinkConvertedItem.size() != 0) {
                        for (HtmlParserManager.C2244a c2244a : shrinkConvertedItem) {
                            if (c2244a != null && c2244a.e() == 1) {
                                linearLayout.findViewById(R$id.screenshot_share_content_gap).setVisibility(0);
                                linearLayout.findViewById(R$id.screenshot_share_content_title_info).setVisibility(0);
                                int i3 = R$id.screenshot_share_content_info;
                                ((TextView) linearLayout.findViewById(i3)).setVisibility(0);
                                ((TextView) linearLayout.findViewById(i3)).setText(c2244a.a());
                                break;
                            }
                        }
                    } else {
                        return popupWindow;
                    }
                } else if (itemViewType == 31) {
                    view = view2;
                    final ProjectBrandAndArtistMultiViewHolder projectBrandAndArtistMultiViewHolder = new ProjectBrandAndArtistMultiViewHolder(g(), linearLayout);
                    ((ViewGroup) view).addView(projectBrandAndArtistMultiViewHolder.itemView);
                    projectBrandAndArtistMultiViewHolder.b(projectDataHolder);
                    if (projectDataHolder != null && !m91.a(projectDataHolder.brandAndArtistsList)) {
                        projectBrandAndArtistMultiViewHolder.itemView.postDelayed(new Runnable() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare.5
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange2 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange2, "-1222734068")) {
                                    ipChange2.ipc$dispatch("-1222734068", new Object[]{this});
                                    return;
                                }
                                linearLayout.findViewById(R$id.screenshot_share_content_gap).setVisibility(0);
                                linearLayout.findViewById(R$id.screenshot_share_content_title_artisit).setVisibility(0);
                                ScreenShotImgShare screenShotImgShare = ScreenShotImgShare.this;
                                screenShotImgShare.e(linearLayout, m62.a(screenShotImgShare.g(), 98.0f), projectBrandAndArtistMultiViewHolder.itemView, R$id.screenshot_share_content_img_artisit);
                            }
                        }, 200L);
                    }
                } else if (itemViewType != 33) {
                    view = view2;
                } else {
                    final ProjectBrandSingleViewHolder projectBrandSingleViewHolder = new ProjectBrandSingleViewHolder(g(), linearLayout);
                    view = view2;
                    ((ViewGroup) view).addView(projectBrandSingleViewHolder.itemView);
                    if (projectDataHolder != null && projectDataHolder.brandOrArtists != null && zx2Var != null) {
                        projectBrandSingleViewHolder.a(projectDataHolder, zx2Var);
                        projectBrandSingleViewHolder.itemView.postDelayed(new Runnable() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare.4
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange2 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange2, "-1026220563")) {
                                    ipChange2.ipc$dispatch("-1026220563", new Object[]{this});
                                    return;
                                }
                                ImageView imageView = (ImageView) projectBrandSingleViewHolder.itemView.findViewById(R$id.brandip_top_imgbg_cover);
                                if (imageView != null) {
                                    imageView.setImageDrawable(new ColorDrawable(-31940));
                                }
                                linearLayout.findViewById(R$id.screenshot_share_content_gap).setVisibility(0);
                                linearLayout.findViewById(R$id.screenshot_share_content_title_brand).setVisibility(0);
                                ScreenShotImgShare screenShotImgShare = ScreenShotImgShare.this;
                                screenShotImgShare.e(linearLayout, m62.a(screenShotImgShare.g(), 98.0f), projectBrandSingleViewHolder.itemView, R$id.screenshot_share_content_imgbrand);
                            }
                        }, 100L);
                    }
                }
                i2++;
                view2 = view;
            }
        }
        final View view3 = view2;
        linearLayout.postDelayed(new Runnable() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ScreenShotImgShare.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1419247573")) {
                    ipChange2.ipc$dispatch("-1419247573", new Object[]{this});
                    return;
                }
                int a2 = a - m62.a(ScreenShotImgShare.this.g(), 344.0f);
                int height = view3.findViewById(R$id.screenshot_share_content_ll).getHeight();
                if (height <= a2) {
                    a2 = height;
                }
                View view4 = view3;
                int i4 = R$id.screenshot_share_content_scroll_parent;
                ViewGroup.LayoutParams layoutParams2 = view4.findViewById(i4).getLayoutParams();
                layoutParams2.height = a2;
                view3.findViewById(i4).setLayoutParams(layoutParams2);
                view3.postInvalidate();
            }
        }, 200L);
        String str = gw1.productUrl + j + "&from=appshare";
        ((ImageView) linearLayout.findViewById(R$id.screenshot_share_content_qrcode_img)).setImageBitmap(QrcodeUtil.a(t60.a(g(), 40.0f), str));
        view3.postDelayed(new AnonymousClass7(scrollView, view3, j), 100L);
        view3.findViewById(R$id.screenshot_share_action).setOnClickListener(new View$OnClickListenerC2339d(scrollView, view3, frameLayout, str, j));
        view3.findViewById(R$id.screenshot_feedback_action).setOnClickListener(new View$OnClickListenerC2340e());
        return popupWindow;
    }

    public void k(Activity activity, Bitmap bitmap, View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1146330337")) {
            ipChange.ipc$dispatch("1146330337", new Object[]{this, activity, bitmap, view, str});
            return;
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(b21.e(activity)));
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            Luban.l(activity).k(b21.e(activity)).n(b21.d(activity)).m(new C2337b(this)).l(new C2336a(str, view, activity)).j();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
