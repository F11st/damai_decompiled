package cn.damai.h5container;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.bean.ShareParams;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.h5container.DMH5Activity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taomai.android.h5container.ui.TaoMaiH5Activity;
import com.taomai.android.h5container.ui.TaoMaiUCH5Fragment;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.g41;
import tb.ir1;
import tb.k50;
import tb.mr1;
import tb.nb2;
import tb.pp2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class DMH5Activity extends TaoMaiH5Activity {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final Companion Companion = new Companion(null);
    private boolean forceBack;
    private boolean rotate = true;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ArrayList<String> getEvaluateImageList(ArrayList<ShareParams.EditImgJson> arrayList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1921699282")) {
                return (ArrayList) ipChange.ipc$dispatch("-1921699282", new Object[]{this, arrayList});
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            try {
                int e = wh2.e(arrayList);
                for (int i = 0; i < e; i++) {
                    ShareParams.EditImgJson editImgJson = arrayList.get(i);
                    b41.h(editImgJson, "images[i]");
                    arrayList2.add(editImgJson.url);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return arrayList2;
        }
    }

    private final View getCopyLinkView(ShareParams.TypeInfo typeInfo) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-262386322") ? (View) ipChange.ipc$dispatch("-262386322", new Object[]{this, typeInfo}) : nb2.c(this, typeInfo.url);
    }

    private final View getEditView(final ShareParams.TypeInfo typeInfo) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-428196311") ? (View) ipChange.ipc$dispatch("-428196311", new Object[]{this, typeInfo}) : nb2.e(this, new View.OnClickListener() { // from class: tb.mr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DMH5Activity.m32getEditView$lambda2(ShareParams.TypeInfo.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getEditView$lambda-2  reason: not valid java name */
    public static final void m32getEditView$lambda2(ShareParams.TypeInfo typeInfo, DMH5Activity dMH5Activity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1557566131")) {
            ipChange.ipc$dispatch("1557566131", new Object[]{typeInfo, dMH5Activity, view});
            return;
        }
        b41.i(typeInfo, "$typeInfo");
        b41.i(dMH5Activity, "this$0");
        try {
            try {
                Bundle bundle = new Bundle();
                bundle.putString(g41.ISSUE_TYPE, g41.ISSUE_TYPE_EDIT);
                bundle.putString(g41.ISSUE_PARAM_COMMENT_ID, typeInfo.commentId);
                bundle.putString("projectName", typeInfo.projectName);
                bundle.putInt(g41.ISSUE_PARAM_GRADES, typeInfo.currentScore);
                bundle.putString("text", typeInfo.content);
                Companion companion = Companion;
                ArrayList<ShareParams.EditImgJson> arrayList = typeInfo.editImgJson;
                b41.h(arrayList, "typeInfo.editImgJson");
                bundle.putStringArrayList("images", companion.getEvaluateImageList(arrayList));
                bundle.putString("circleId", typeInfo.circleId);
                bundle.putString("circleName", typeInfo.circleName);
                DMNav.from(dMH5Activity).withExtras(bundle).toUri(NavUri.b("issue"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            ShareManager.E().C();
        }
    }

    private final View getGenerateImageView(final ShareParams.TypeInfo typeInfo) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2089649267") ? (View) ipChange.ipc$dispatch("2089649267", new Object[]{this, typeInfo}) : nb2.f(this, new View.OnClickListener() { // from class: tb.nr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DMH5Activity.m33getGenerateImageView$lambda4(ShareParams.TypeInfo.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getGenerateImageView$lambda-4  reason: not valid java name */
    public static final void m33getGenerateImageView$lambda4(ShareParams.TypeInfo typeInfo, final DMH5Activity dMH5Activity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-907728853")) {
            ipChange.ipc$dispatch("-907728853", new Object[]{typeInfo, dMH5Activity, view});
            return;
        }
        b41.i(typeInfo, "$typeInfo");
        b41.i(dMH5Activity, "this$0");
        try {
            try {
                final DMShareMessage dMShareMessage = new DMShareMessage();
                dMShareMessage.shareImageStyle = GenerateImageUtil.STYLE_GENERATE_EVALUATE_IMAGE;
                dMShareMessage.sharePictureUrl = typeInfo.imageUrl;
                dMShareMessage.shareTitle = typeInfo.title;
                dMShareMessage.shareContent = typeInfo.content;
                dMShareMessage.shareLink = typeInfo.url;
                dMShareMessage.fromWhere = pp2.PROJECT_EVALUATE;
                dMShareMessage.userNick = typeInfo.userNick;
                dMShareMessage.userHeaderIcon = typeInfo.userIcon;
                dMShareMessage.evaluateGrade = typeInfo.currentScore;
                dMShareMessage.evaluateTime = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault()).format(Long.valueOf(typeInfo.evaluateTime));
                ir1.b(dMH5Activity, false, mr1.STORAGE, "用于分享图片", new OnGrantListener() { // from class: tb.pr
                    @Override // cn.damai.common.askpermission.OnGrantListener
                    public final void onGranted() {
                        DMH5Activity.m34getGenerateImageView$lambda4$lambda3(DMH5Activity.this, dMShareMessage);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            ShareManager.E().C();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getGenerateImageView$lambda-4$lambda-3  reason: not valid java name */
    public static final void m34getGenerateImageView$lambda4$lambda3(DMH5Activity dMH5Activity, DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1324013986")) {
            ipChange.ipc$dispatch("-1324013986", new Object[]{dMH5Activity, dMShareMessage});
            return;
        }
        b41.i(dMH5Activity, "this$0");
        b41.i(dMShareMessage, "$message");
        GenerateImageUtil.p(dMH5Activity, dMShareMessage);
    }

    private final View getReportIcon(ShareParams.TypeInfo typeInfo) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-512922777") ? (View) ipChange.ipc$dispatch("-512922777", new Object[]{this, typeInfo}) : ShareManager.E().F(this, 0, typeInfo.id, typeInfo.type);
    }

    private final View getToolsView(ShareParams.Plugin plugin) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1554586461")) {
            return (View) ipChange.ipc$dispatch("1554586461", new Object[]{this, plugin});
        }
        View view = null;
        if (plugin != null) {
            try {
                if (plugin.typeInfo != null) {
                    if (b41.d("report", plugin.type)) {
                        ShareParams.TypeInfo typeInfo = plugin.typeInfo;
                        b41.h(typeInfo, "plugin.typeInfo");
                        view = getReportIcon(typeInfo);
                    } else if (b41.d("evaluateEdit", plugin.type)) {
                        ShareParams.TypeInfo typeInfo2 = plugin.typeInfo;
                        b41.h(typeInfo2, "plugin.typeInfo");
                        view = getEditView(typeInfo2);
                    } else if (b41.d("copyUrl", plugin.type)) {
                        ShareParams.TypeInfo typeInfo3 = plugin.typeInfo;
                        b41.h(typeInfo3, "plugin.typeInfo");
                        view = getCopyLinkView(typeInfo3);
                    } else if (b41.d("generateImage", plugin.type)) {
                        ShareParams.TypeInfo typeInfo4 = plugin.typeInfo;
                        b41.h(typeInfo4, "plugin.typeInfo");
                        view = getGenerateImageView(typeInfo4);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return view;
    }

    private final void hideNavBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2017593658")) {
            ipChange.ipc$dispatch("-2017593658", new Object[]{this});
            return;
        }
        Fragment fragment = getFragment();
        TaoMaiUCH5Fragment taoMaiUCH5Fragment = fragment instanceof TaoMaiUCH5Fragment ? (TaoMaiUCH5Fragment) fragment : null;
        if (taoMaiUCH5Fragment != null) {
            taoMaiUCH5Fragment.hideWebTitle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showShareMenu$lambda-1  reason: not valid java name */
    public static final void m35showShareMenu$lambda1(ShareParams shareParams, DMH5Activity dMH5Activity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1071402362")) {
            ipChange.ipc$dispatch("-1071402362", new Object[]{shareParams, dMH5Activity, view});
            return;
        }
        b41.i(shareParams, "$shareParams");
        b41.i(dMH5Activity, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString("title", shareParams.share.title);
        bundle.putString("message", shareParams.share.description);
        bundle.putString("imageurl", shareParams.share.image);
        bundle.putString("producturl", shareParams.share.url);
        bundle.putString("fromWhere", "H5");
        bundle.putBoolean("hideCopyLink", true);
        ShareManager.E().T(dMH5Activity, bundle, dMH5Activity.getWindow().getDecorView());
        ArrayList<ShareParams.Plugin> arrayList = shareParams.plugins;
        int e = wh2.e(arrayList);
        if (e > 0) {
            LinearLayout linearLayout = new LinearLayout(dMH5Activity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            linearLayout.setOrientation(0);
            linearLayout.setLayoutParams(layoutParams);
            for (int i = 0; i < e; i++) {
                View toolsView = dMH5Activity.getToolsView(arrayList.get(i));
                if (toolsView != null) {
                    linearLayout.addView(toolsView);
                }
            }
            if (linearLayout.getChildCount() > 0) {
                ShareManager.E().e0(linearLayout);
            }
        }
        ShareManager.E().l0();
    }

    @Override // com.taomai.android.h5container.ui.TaoMaiH5Activity
    @NotNull
    public Fragment createFragment() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1043184930") ? (Fragment) ipChange.ipc$dispatch("1043184930", new Object[]{this}) : new DMH5Fragment();
    }

    public final void hideShareMenu() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-720847882")) {
            ipChange.ipc$dispatch("-720847882", new Object[]{this});
            return;
        }
        Fragment fragment = getFragment();
        TaoMaiUCH5Fragment taoMaiUCH5Fragment = fragment instanceof TaoMaiUCH5Fragment ? (TaoMaiUCH5Fragment) fragment : null;
        if (taoMaiUCH5Fragment != null) {
            taoMaiUCH5Fragment.hideWebOptionMenu();
        }
    }

    @Override // com.taomai.android.h5container.ui.TaoMaiH5Activity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-96468778")) {
            ipChange.ipc$dispatch("-96468778", new Object[]{this});
        } else if (this.forceBack) {
            finish();
        } else {
            setResult(-1);
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0082, code lost:
        if (r7 == false) goto L31;
     */
    @Override // com.taomai.android.h5container.ui.TaoMaiH5Activity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle r7) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.h5container.DMH5Activity.$ipChange
            java.lang.String r1 = "1162397367"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L17
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r5] = r6
            r2[r3] = r7
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            android.content.Intent r0 = r6.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L36
            java.lang.String r1 = "hideback"
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto L36
            boolean r1 = r0.getBoolean(r1)
            if (r1 == 0) goto L36
            java.lang.String r1 = "hidenavbar"
            java.lang.String r2 = "1"
            r0.putString(r1, r2)
        L36:
            super.onCreate(r7)
            java.lang.String r7 = "url"
            if (r0 == 0) goto L5e
            boolean r1 = r0.containsKey(r7)
            if (r1 == 0) goto L5e
            java.lang.String r1 = r0.getString(r7)
            if (r1 == 0) goto L5e
            java.lang.String r1 = r0.getString(r7)
            android.net.Uri r1 = android.net.Uri.parse(r1)
            java.lang.String r2 = "forceBack"
            boolean r1 = r1.getBooleanQueryParameter(r2, r5)     // Catch: java.lang.Exception -> L5a
            r6.forceBack = r1     // Catch: java.lang.Exception -> L5a
            goto L5e
        L5a:
            r1 = move-exception
            r1.printStackTrace()
        L5e:
            if (r0 == 0) goto L86
            java.lang.String r1 = "rotate"
            java.lang.String r2 = "true"
            java.lang.String r1 = r0.getString(r1, r2)
            java.lang.String r2 = "false"
            boolean r1 = tb.b41.d(r2, r1)
            if (r1 != 0) goto L85
            java.lang.String r1 = ""
            java.lang.String r7 = r0.getString(r7, r1)
            java.lang.String r0 = "bundle.getString(\"url\", \"\")"
            tb.b41.h(r7, r0)
            r0 = 0
            java.lang.String r1 = "rotate=false"
            boolean r7 = kotlin.text.C8596g.K(r7, r1, r5, r4, r0)
            if (r7 != 0) goto L85
            goto L86
        L85:
            r3 = 0
        L86:
            r6.rotate = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.h5container.DMH5Activity.onCreate(android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-941043785")) {
            ipChange.ipc$dispatch("-941043785", new Object[]{this});
        } else {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1382782037")) {
            ipChange.ipc$dispatch("1382782037", new Object[]{this, Integer.valueOf(i)});
        } else if (this.rotate) {
            super.setRequestedOrientation(i);
        }
    }

    public final void setTitleContent(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2074006937")) {
            ipChange.ipc$dispatch("2074006937", new Object[]{this, str});
        } else if (str == null) {
        } else {
            Fragment fragment = getFragment();
            TaoMaiUCH5Fragment taoMaiUCH5Fragment = fragment instanceof TaoMaiUCH5Fragment ? (TaoMaiUCH5Fragment) fragment : null;
            if (taoMaiUCH5Fragment != null) {
                taoMaiUCH5Fragment.setWebTitle(str);
            }
        }
    }

    public final void showShareMenu(@Nullable JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "590736351")) {
            ipChange.ipc$dispatch("590736351", new Object[]{this, jSONObject});
        } else if (jSONObject == null) {
        } else {
            try {
                final ShareParams shareParams = (ShareParams) JSON.parseObject(jSONObject.toString(), ShareParams.class);
                if (shareParams != null && shareParams.share == null) {
                    Fragment fragment = getFragment();
                    TaoMaiUCH5Fragment taoMaiUCH5Fragment = fragment instanceof TaoMaiUCH5Fragment ? (TaoMaiUCH5Fragment) fragment : null;
                    if (taoMaiUCH5Fragment != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("icontype", (Object) "share");
                        taoMaiUCH5Fragment.setWebOptionMenu(jSONObject2, new View.OnClickListener() { // from class: tb.or
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                DMH5Activity.m35showShareMenu$lambda1(ShareParams.this, this, view);
                            }
                        });
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
