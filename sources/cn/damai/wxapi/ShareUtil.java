package cn.damai.wxapi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import cn.damai.common.AppConfig;
import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.commonbusiness.util.Utils;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.share.ShareMenuHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.open.SocialConstants;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import tb.cb1;
import tb.cm2;
import tb.ir1;
import tb.iu0;
import tb.mm2;
import tb.mr1;
import tb.v20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ShareUtil implements OnSinaShare {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity activity;
    public String cityName;
    String fromWhere;
    private String image;
    private Bitmap imageBitmap;
    private String imageModeUrl;
    String imageurl;
    String message;
    public OnSinaOauthLintener onSinaOauthLintener;
    public String price;
    String producturl;
    Long projectId;
    String shareType;
    public String showDate;
    String starwxshareurl;
    String title;
    public String venueName;
    String[] shareItem = {"微信", "新浪微博"};
    String[] item1 = {"朋友圈", "微信", "新浪微博"};
    String[] item2 = {"微信", "新浪微博"};
    String sinaSharePath = "";
    public boolean miniprogram = true;
    String paihao = "";
    public IWXAPI api = WXAgent.createWxApi();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.wxapi.ShareUtil$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass1 implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;

        AnonymousClass1() {
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1084703780")) {
                ipChange.ipc$dispatch("-1084703780", new Object[]{this});
            } else {
                iu0.b().a(new Runnable() { // from class: cn.damai.wxapi.ShareUtil.1.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "2120566112")) {
                            ipChange2.ipc$dispatch("2120566112", new Object[]{this});
                        } else if (ShareUtil.this.imageBitmap == null) {
                        } else {
                            String saveBitmapToDcimDir = ShareUtil.saveBitmapToDcimDir(ShareUtil.this.activity, ShareUtil.this.imageBitmap);
                            if (!TextUtils.isEmpty(saveBitmapToDcimDir)) {
                                ShareUtil.this.activity.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(saveBitmapToDcimDir))));
                                ShareUtil.this.activity.runOnUiThread(new Runnable() { // from class: cn.damai.wxapi.ShareUtil.1.1.1
                                    private static transient /* synthetic */ IpChange $ipChange;

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IpChange ipChange3 = $ipChange;
                                        if (AndroidInstantRuntime.support(ipChange3, "-604164877")) {
                                            ipChange3.ipc$dispatch("-604164877", new Object[]{this});
                                        } else {
                                            ToastUtil.a().e(ShareUtil.this.activity, "保存成功");
                                        }
                                    }
                                });
                                return;
                            }
                            ShareUtil.this.saveImageFailToast();
                        }
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class AlertListener implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        AlertListener() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-923450291")) {
                ipChange.ipc$dispatch("-923450291", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            ShareUtil shareUtil = ShareUtil.this;
            shareUtil.shareByWay(shareUtil.shareItem[i]);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface OnSinaOauthLintener {
        void onComplete();

        void onError(String str);
    }

    public ShareUtil(Activity activity, String str) {
        this.fromWhere = "";
        this.activity = activity;
        if (AppConfig.v()) {
            this.api.registerApp(v20.a(WXAgent.APP_ID_DEBUG_CRYPT));
        } else {
            this.api.registerApp(v20.a(WXAgent.APP_ID_CRYPT));
        }
        this.fromWhere = str;
        if (AppConfig.v()) {
            mm2.b = "dingoaesuqtseep9fabz7p";
        } else {
            mm2.b = "dingoabomemo9ad1hqjwwo";
        }
    }

    public static String DDID() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1962907946") ? (String) ipChange.ipc$dispatch("-1962907946", new Object[0]) : AppConfig.v() ? "dingoaesuqtseep9fabz7p" : "dingoabomemo9ad1hqjwwo";
    }

    public static Bitmap compressImageBySize(Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1636276025")) {
            return (Bitmap) ipChange.ipc$dispatch("-1636276025", new Object[]{bitmap, Integer.valueOf(i)});
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        int i2 = i * 1024;
        if (byteArrayOutputStream.toByteArray().length < i2) {
            return bitmap;
        }
        while (byteArrayOutputStream.toByteArray().length > i2) {
            float length = (i * 1024.0f) / byteArrayOutputStream.toByteArray().length;
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * length), (int) (bitmap.getHeight() * length), false);
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public static String saveBitmapToDcimDir(Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "813386804")) {
            return (String) ipChange.ipc$dispatch("813386804", new Object[]{bitmap});
        }
        FileOutputStream fileOutputStream2 = null;
        if (bitmap == null) {
            return null;
        }
        try {
            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), System.currentTimeMillis() + ".jpg");
            fileOutputStream = new FileOutputStream(file);
        } catch (Exception unused) {
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)) {
                String absolutePath = file.getAbsolutePath();
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return absolutePath;
            }
            try {
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return null;
        } catch (Exception unused2) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImageFailToast() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2006366522")) {
            ipChange.ipc$dispatch("2006366522", new Object[]{this});
        } else {
            this.activity.runOnUiThread(new Runnable() { // from class: cn.damai.wxapi.ShareUtil.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1059849772")) {
                        ipChange2.ipc$dispatch("1059849772", new Object[]{this});
                    } else {
                        ToastUtil.a().e(ShareUtil.this.activity, "保存失败");
                    }
                }
            });
        }
    }

    private void sinaFromBytypeContent(ShareContent shareContent, String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "920266020")) {
            ipChange.ipc$dispatch("920266020", new Object[]{this, shareContent, str});
            return;
        }
        String content = shareContent.getContent();
        try {
            if (TextUtils.isEmpty(content) || "bytype".equals(str)) {
                return;
            }
            String url = shareContent.getUrl();
            if (!TextUtils.isEmpty(url) && content.contains(url)) {
                content = content.substring(0, content.indexOf(url));
            }
            if (content.length() > 140) {
                if (content.contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                    int indexOf = content.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                    String substring = content.substring(indexOf);
                    content = content.substring(0, indexOf).substring(0, 140 - content.substring(indexOf).length()) + substring;
                } else {
                    content = ("大麦#去现场为所爱#" + content).substring(0, 140);
                }
            } else if (!content.contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                content = "大麦#去现场为所爱#" + content;
            }
            if (content.length() + 10 > 140) {
                str2 = content.substring(0, content.length() - 10) + "（@大麦官博 发布）";
            } else {
                str2 = content + "（@大麦官博 发布）";
            }
            shareContent.setContent(str2);
        } catch (Exception e) {
            cb1.g("share", e.getMessage());
        }
    }

    public boolean checkSharetype() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-423588488") ? ((Boolean) ipChange.ipc$dispatch("-423588488", new Object[]{this})).booleanValue() : this.api.getWXAppSupportAPI() >= 553779201;
    }

    public void initShareData(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-658162754")) {
            ipChange.ipc$dispatch("-658162754", new Object[]{this, str, str2, str3, str4, str5});
            return;
        }
        this.title = str;
        this.message = str2;
        this.imageurl = str3;
        this.producturl = str4;
        this.sinaSharePath = str5;
    }

    public boolean isMiniProgramSupport(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1377073383")) {
            return ((Boolean) ipChange.ipc$dispatch("1377073383", new Object[]{this, str})).booleanValue();
        }
        if (!TextUtils.isEmpty(str) && str.startsWith("https://")) {
            if (str.contains("x.damai.cn") || str.contains("p.damai.cn") || str.contains("m.damai.cn") || str.contains("t.damai.cn")) {
                return true;
            }
            if (str.contains("market.wapa.damai.cn") && AppConfig.v()) {
                return true;
            }
        }
        return false;
    }

    @Override // cn.damai.wxapi.OnSinaShare
    public void onSinaShare() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "217754446")) {
            ipChange.ipc$dispatch("217754446", new Object[]{this});
        } else {
            startSinaShare();
        }
    }

    public void saveToLocal() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "459970578")) {
            ipChange.ipc$dispatch("459970578", new Object[]{this});
        } else if (this.imageBitmap == null) {
            saveImageFailToast();
        } else {
            ir1.b(this.activity, false, mr1.STORAGE, "用于为您保存图片至本地", new AnonymousClass1());
        }
    }

    public void setCityName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-893475113")) {
            ipChange.ipc$dispatch("-893475113", new Object[]{this, str});
        } else {
            this.cityName = str;
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "213304305")) {
            ipChange.ipc$dispatch("213304305", new Object[]{this, bitmap});
        } else {
            this.imageBitmap = bitmap;
        }
    }

    public void setImageModeUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1356692900")) {
            ipChange.ipc$dispatch("-1356692900", new Object[]{this, str});
        } else {
            this.imageModeUrl = str;
        }
    }

    public void setPrice(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-562679448")) {
            ipChange.ipc$dispatch("-562679448", new Object[]{this, str});
        } else {
            this.price = str;
        }
    }

    public void setProducturl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-386127347")) {
            ipChange.ipc$dispatch("-386127347", new Object[]{this, str});
        } else {
            this.producturl = str;
        }
    }

    public void setShare2MiniProgram(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1580958553")) {
            ipChange.ipc$dispatch("-1580958553", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.miniprogram = z;
        }
    }

    public void setShareType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2146393096")) {
            ipChange.ipc$dispatch("-2146393096", new Object[]{this, str});
        } else {
            this.shareType = str;
        }
    }

    public void setShowDate(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "706485314")) {
            ipChange.ipc$dispatch("706485314", new Object[]{this, str});
        } else {
            this.showDate = str;
        }
    }

    public void setVenueName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1423674551")) {
            ipChange.ipc$dispatch("1423674551", new Object[]{this, str});
        } else {
            this.venueName = str;
        }
    }

    public void setpaihao(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "225575695")) {
            ipChange.ipc$dispatch("225575695", new Object[]{this, str});
        } else {
            this.paihao = str;
        }
    }

    public void share(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-959175602")) {
            ipChange.ipc$dispatch("-959175602", new Object[]{this, str, str2, str3, str4});
            return;
        }
        this.title = str;
        this.message = str2;
        this.imageurl = str3;
        this.producturl = str4;
        if (checkSharetype()) {
            this.shareItem = this.item1;
        } else {
            this.shareItem = this.item2;
        }
        new AlertDialog.Builder(this.activity).setTitle(cm2.b(this.activity, R$string.damai_filmdetail_share_text)).setItems(this.shareItem, new AlertListener()).show();
    }

    public void shareByDing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "582891313")) {
            ipChange.ipc$dispatch("582891313", new Object[]{this});
            return;
        }
        ShareContent shareContent = new ShareContent();
        shareContent.setTitle(this.title);
        shareContent.setContent(this.message);
        shareContent.setUrl(!TextUtils.isEmpty(this.starwxshareurl) ? this.starwxshareurl : this.producturl);
        shareContent.addImage(this.imageurl);
        if (this.imageModeUrl != null) {
            shareContent.getImgUrls().clear();
            shareContent.addImage(this.imageModeUrl);
            shareContent.setShareType(1);
        }
        new ShareMenuHelper(this.activity).j(Integer.valueOf(ShareChannel.DD.value), shareContent, null);
    }

    public void shareBySina(OnSinaOauthLintener onSinaOauthLintener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2135877535")) {
            ipChange.ipc$dispatch("-2135877535", new Object[]{this, onSinaOauthLintener});
            return;
        }
        cb1.g("aa", "xinlang share click");
        this.onSinaOauthLintener = onSinaOauthLintener;
        startSinaShare();
    }

    public void shareByWay(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2121886666")) {
            ipChange.ipc$dispatch("-2121886666", new Object[]{this, str});
        } else if (str.equals("新浪微博")) {
            if (GenerateImageUtil.TYPE_FROMWHERE_PEOJECT_DETAIL.equals(this.fromWhere) || TextUtils.equals("ipDramaPage", this.fromWhere)) {
                this.message = cm2.c(this.activity, R$string.data_string_016, this.title, this.producturl);
            } else if (ShareperfenceConstants.ORDER_DETAIL.equals(this.fromWhere)) {
                this.message = cm2.c(this.activity, R$string.data_string_017, this.title, this.producturl);
            } else if (!"viewseat".equals(this.fromWhere)) {
                if ("FilmDetailActivity".equals(this.fromWhere)) {
                    this.message = cm2.c(this.activity, R$string.data_string_018, this.title, this.producturl);
                } else if ("EventContentActivity".equals(this.fromWhere)) {
                    this.message = cm2.c(this.activity, R$string.data_string_019, this.title.substring(3));
                } else if (!"TopicPageActivity".equals(this.fromWhere)) {
                    "orderDetail2".equals(this.fromWhere);
                }
            }
            shareBySina(null);
        } else if (str.equals(cm2.b(this.activity, R$string.damai_share_micro_channel_friends))) {
            if (!GenerateImageUtil.TYPE_FROMWHERE_PEOJECT_DETAIL.equals(this.fromWhere)) {
                if (ShareperfenceConstants.ORDER_DETAIL.equals(this.fromWhere)) {
                    String str2 = this.title;
                    this.message = str2;
                    this.title = cm2.c(this.activity, R$string.data_string_021, str2);
                } else if ("viewseat".equals(this.fromWhere)) {
                    String str3 = this.title;
                    this.message = str3;
                    this.title = cm2.c(this.activity, R$string.data_string_022, str3, this.paihao);
                } else if (!"TopicPageActivity".equals(this.fromWhere)) {
                    "orderDetail2".equals(this.fromWhere);
                }
            }
            shareByWchart(0);
        } else if (str.equals(cm2.b(this.activity, R$string.damai_share_circle_friends))) {
            if (!GenerateImageUtil.TYPE_FROMWHERE_PEOJECT_DETAIL.equals(this.fromWhere) && !ShareperfenceConstants.ORDER_DETAIL.equals(this.fromWhere) && !"viewseat".equals(this.fromWhere)) {
                if ("FilmDetailActivity".equals(this.fromWhere)) {
                    String str4 = this.title;
                    this.title = this.message;
                    this.message = str4;
                } else if ("EventContentActivity".equals(this.fromWhere)) {
                    String str5 = this.title;
                    this.title = this.message;
                    this.message = str5;
                } else if (!"TopicPageActivity".equals(this.fromWhere)) {
                    "orderDetail2".equals(this.fromWhere);
                }
            }
            shareByWchart(1);
        } else if (str.equals(cm2.b(this.activity, R$string.damai_share_qq_friends))) {
            if (GenerateImageUtil.TYPE_FROMWHERE_PEOJECT_DETAIL.equals(this.fromWhere)) {
                this.message = this.title;
                this.title = cm2.b(this.activity, R$string.data_string_020);
            } else if (ShareperfenceConstants.ORDER_DETAIL.equals(this.fromWhere)) {
                String str6 = this.title;
                this.message = str6;
                this.title = cm2.c(this.activity, R$string.data_string_021, str6);
            } else if ("viewseat".equals(this.fromWhere)) {
                String str7 = this.title;
                this.message = str7;
                this.title = cm2.c(this.activity, R$string.data_string_022, str7, this.paihao);
            } else if (!"TopicPageActivity".equals(this.fromWhere)) {
                "orderDetail2".equals(this.fromWhere);
            }
            shareQQ();
        } else if (str.equals(cm2.b(this.activity, R$string.damai_share_dingding))) {
            shareByDing();
        }
    }

    public void shareByWchart(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1827096389")) {
            ipChange.ipc$dispatch("-1827096389", new Object[]{this, Integer.valueOf(i)});
        } else if (Utils.b(this.activity, false)) {
            if (i == 1 && !checkSharetype()) {
                ToastUtil a = ToastUtil.a();
                Activity activity = this.activity;
                a.e(activity, cm2.b(activity, R$string.damai_share_circle_load_toast));
                return;
            }
            ShareContent shareContent = new ShareContent();
            shareContent.setTitle(this.title);
            shareContent.setContent(this.message);
            shareContent.setUrl(!TextUtils.isEmpty(this.starwxshareurl) ? this.starwxshareurl : this.producturl);
            shareContent.addImage(this.imageurl);
            shareContent.setImageMaxSizeKb(10000);
            if (!TextUtils.isEmpty(this.imageModeUrl)) {
                shareContent.getImgUrls().clear();
                shareContent.addImage(this.imageModeUrl);
                shareContent.setShareType(1);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("from", this.fromWhere);
            hashMap.put("way", i + "");
            hashMap.put("projectId", this.projectId + "");
            shareContent.setExtraInfo(hashMap);
            if (this.miniprogram && i == 0 && isMiniProgramSupport(shareContent.getUrl()) && TextUtils.isEmpty(this.imageModeUrl)) {
                shareContent.setShareType(4);
                shareContent.setMiniUrl("gh_8f607e128043");
            }
            new ShareMenuHelper(this.activity).j(Integer.valueOf((i == 0 ? ShareChannel.WEIXIN : ShareChannel.WEIXIN_FRIEND).value), shareContent, null);
        }
    }

    public void shareQQ() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1210137658")) {
            ipChange.ipc$dispatch("-1210137658", new Object[]{this});
            return;
        }
        ShareContent shareContent = new ShareContent();
        shareContent.setTitle(this.title);
        shareContent.setContent(this.message);
        shareContent.setUrl(this.producturl);
        shareContent.addImage(this.imageurl);
        shareContent.setImageMaxSizeKb(5000);
        if (!TextUtils.isEmpty(this.imageModeUrl)) {
            shareContent.getImgUrls().clear();
            shareContent.addImage(this.imageModeUrl);
            shareContent.setShareType(1);
        }
        new ShareMenuHelper(this.activity).j(Integer.valueOf(ShareChannel.QQ.value), shareContent, null);
    }

    public void startSinaShare() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-302171791")) {
            ipChange.ipc$dispatch("-302171791", new Object[]{this});
            return;
        }
        ShareContent shareContent = new ShareContent();
        shareContent.setTitle(this.title);
        shareContent.setContent(this.message);
        shareContent.setUrl(this.producturl);
        shareContent.addImage(this.imageurl);
        if (!TextUtils.isEmpty(this.imageModeUrl)) {
            shareContent.getImgUrls().clear();
            shareContent.addImage(this.imageModeUrl);
            if ("H5".equals(this.fromWhere)) {
                shareContent.setShareType(2);
            } else {
                shareContent.setShareType(1);
            }
        }
        if (!TextUtils.isEmpty(this.sinaSharePath)) {
            shareContent.addImage(this.sinaSharePath);
            shareContent.setShareType(1);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("from", this.fromWhere);
        hashMap.put("projectId", this.projectId + "");
        shareContent.setExtraInfo(hashMap);
        sinaFromBytypeContent(shareContent, this.fromWhere);
        new ShareMenuHelper(this.activity).j(Integer.valueOf(ShareChannel.WEIBO.value), shareContent, null);
    }

    public void initShareData(String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2101752328")) {
            ipChange.ipc$dispatch("2101752328", new Object[]{this, str, str2, str3, str4, str5, str6});
            return;
        }
        initShareData(str, str2, str3, str4, str5, this.projectId.longValue());
        this.starwxshareurl = str6;
    }

    public void initShareData(String str, String str2, String str3, String str4, String str5, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1071821510")) {
            ipChange.ipc$dispatch("1071821510", new Object[]{this, str, str2, str3, str4, str5, Long.valueOf(j)});
            return;
        }
        this.title = str;
        this.message = str2;
        this.imageurl = str3;
        this.producturl = str4;
        this.sinaSharePath = str5;
        this.projectId = Long.valueOf(j);
    }

    public void initShareData(String str, String str2, String str3, String str4, String str5, String str6, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "729843132")) {
            ipChange.ipc$dispatch("729843132", new Object[]{this, str, str2, str3, str4, str5, str6, Long.valueOf(j)});
            return;
        }
        initShareData(str, str2, str3, str4, str5, j);
        this.starwxshareurl = str6;
    }

    public static String saveBitmapToDcimDir(Activity activity, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-804016250")) {
            return (String) ipChange.ipc$dispatch("-804016250", new Object[]{activity, bitmap});
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 29) {
            return saveBitmapToDcimDir(bitmap);
        }
        ContentResolver contentResolver = activity.getContentResolver();
        ContentValues contentValues = new ContentValues();
        String str = System.currentTimeMillis() + ".jpg";
        contentValues.put("_display_name", str);
        contentValues.put(SocialConstants.PARAM_COMMENT, str);
        if (i >= 29) {
            contentValues.put("relative_path", "DCIM");
        } else {
            contentValues.put("_data", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath());
        }
        contentValues.put("mime_type", "image/jpeg");
        OutputStream outputStream = null;
        try {
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            try {
                outputStream = activity.getContentResolver().openOutputStream(contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues));
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            }
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
            return str;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }
}
