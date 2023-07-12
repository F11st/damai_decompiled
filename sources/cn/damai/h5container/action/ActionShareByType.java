package cn.damai.h5container.action;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.qrcode.util.QrcodeUtil;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.h5container.action.ActionShareByType;
import cn.damai.uikit.view.DMAvatar;
import cn.damai.wxapi.ShareUtil;
import com.ali.user.open.core.Site;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.share.ShareMenuHelper;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import org.apache.commons.lang3.StringUtils;
import tb.b21;
import tb.ir1;
import tb.mr1;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionShareByType extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;
    String currentPrice;
    String headUrl;
    String imageFileUrl;
    String imageUrl;
    String message;
    String originPrice;
    String producturl;
    String showtime;
    String title;
    String type;
    public String[] types;
    String userMessage;
    String wxtitle;

    public ActionShareByType(Context context) {
        super(context);
        this.types = new String[]{BQCCameraParam.FOCUS_TYPE_WX, "wxmoments", Site.WEIBO, Site.DING, Site.QQ};
        this.showtime = "";
    }

    private static Bitmap createScaleBitmap(Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "324554867")) {
            return (Bitmap) ipChange.ipc$dispatch("324554867", new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
        if (bitmap != createScaledBitmap) {
            bitmap.recycle();
        }
        return createScaledBitmap;
    }

    private void fakedata() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1739338635")) {
            ipChange.ipc$dispatch("-1739338635", new Object[]{this});
            return;
        }
        this.imageUrl = "https://img.alicdn.com/tps/i4/TB1.WXwV7PoK1RjSZKbSut1IXXa.jpg_q60.jpg";
        this.title = "https://img.alicdn.com/tps/i4/TB1.WXwV7PoK1RjSZKbSut1IXXa.jpg_q60.jpg";
        this.producturl = "https://m.damai.cn/damai/detail/item.html?itemId=594455637701&spm=a2o71.category.itemlist.ditem_1";
        this.currentPrice = "999";
        this.originPrice = "1099";
        this.message = "5月30日 晚8点开奖";
        this.userMessage = "微微说:跟我一起赢门票";
        this.showtime = "2019年5月30日 19：30";
    }

    private void generateImage(Activity activity, DMShareMessage dMShareMessage) {
        View inflate;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1745154974")) {
            ipChange.ipc$dispatch("1745154974", new Object[]{this, activity, dMShareMessage});
            return;
        }
        GenerateImageUtil.H(activity);
        if (this.type.equals(this.types[0])) {
            inflate = LayoutInflater.from(activity).inflate(R$layout.layout_share_wxmini_image, (ViewGroup) null);
        } else {
            inflate = LayoutInflater.from(activity).inflate(R$layout.layout_share_wxmoments_image, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R$id.share_page_qrcode_img);
            if (this.type.equals(this.types[2])) {
                inflate.findViewById(R$id.share_page_qrcode_tip).setVisibility(8);
                imageView.setVisibility(8);
            }
            TextView textView = (TextView) inflate.findViewById(R$id.share_wx_img_showtime);
            if (!TextUtils.isEmpty(dMShareMessage.showtime)) {
                textView.setText(dMShareMessage.showtime);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            TextView textView2 = (TextView) inflate.findViewById(R$id.share_wx_img_usermsg);
            if (!TextUtils.isEmpty(dMShareMessage.userMessage)) {
                textView2.setText(dMShareMessage.userMessage);
            }
            View findViewById = inflate.findViewById(R$id.share_wx_img_userbar);
            if (findViewById != null) {
                if (TextUtils.isEmpty(dMShareMessage.headUrl) && TextUtils.isEmpty(dMShareMessage.userMessage)) {
                    findViewById.setVisibility(8);
                } else {
                    findViewById.setVisibility(0);
                }
            }
        }
        TextView textView3 = (TextView) inflate.findViewById(R$id.share_page_title);
        TextView textView4 = (TextView) inflate.findViewById(R$id.share_wx_img_price);
        TextView textView5 = (TextView) inflate.findViewById(R$id.share_wx_img_originalprice);
        TextView textView6 = (TextView) inflate.findViewById(R$id.share_wx_img_msg);
        if (!TextUtils.isEmpty(dMShareMessage.shareTitle)) {
            textView3.setText(dMShareMessage.shareTitle);
        }
        if (!TextUtils.isEmpty(dMShareMessage.currentPrice)) {
            textView4.setText(dMShareMessage.currentPrice);
        }
        if (!TextUtils.isEmpty(dMShareMessage.originPrice)) {
            textView5.setText(dMShareMessage.originPrice);
        }
        if (!TextUtils.isEmpty(dMShareMessage.shareContent)) {
            textView6.setText(dMShareMessage.shareContent);
        }
        textView5.setPaintFlags(textView5.getPaintFlags() | 16);
        String str = GenerateImageUtil.SHARE_URL + URLEncoder.encode(this.producturl);
        if (!TextUtils.isEmpty(dMShareMessage.headUrl)) {
            if (inflate.findViewById(R$id.share_wx_img_userimg) == null) {
                loadBgImg(activity, dMShareMessage, inflate, str);
                return;
            } else {
                loadHeadImg(activity, dMShareMessage, str, inflate);
                return;
            }
        }
        loadBgImg(activity, dMShareMessage, inflate, str);
    }

    private void generateImage4SHare() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "530880005")) {
            ipChange.ipc$dispatch("530880005", new Object[]{this});
            return;
        }
        final DMShareMessage dMShareMessage = new DMShareMessage();
        dMShareMessage.sharePictureUrl = this.imageUrl;
        dMShareMessage.headUrl = this.headUrl;
        dMShareMessage.shareTitle = this.title;
        dMShareMessage.wxtitle = this.wxtitle;
        dMShareMessage.shareContent = this.message;
        dMShareMessage.shareLink = this.producturl;
        dMShareMessage.currentPrice = this.currentPrice;
        dMShareMessage.originPrice = this.originPrice;
        dMShareMessage.showtime = this.showtime;
        dMShareMessage.userMessage = this.userMessage;
        ir1.b((Activity) this.contextReference, false, mr1.STORAGE, "用于保存、分享图片", new OnGrantListener() { // from class: tb.y2
            @Override // cn.damai.common.askpermission.OnGrantListener
            public final void onGranted() {
                ActionShareByType.this.lambda$generateImage4SHare$0(dMShareMessage);
            }
        });
    }

    private Bitmap getScrollViewBitmap(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-991524196")) {
            return (Bitmap) ipChange.ipc$dispatch("-991524196", new Object[]{this, viewGroup});
        }
        Bitmap createBitmap = Bitmap.createBitmap(viewGroup.getWidth(), viewGroup.getHeight(), Bitmap.Config.RGB_565);
        viewGroup.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$generateImage4SHare$0(DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1880531184")) {
            ipChange.ipc$dispatch("-1880531184", new Object[]{this, dMShareMessage});
        } else {
            generateImage((Activity) this.contextReference, dMShareMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadBgImg$3(Activity activity, ImageView imageView, ImageView imageView2, View view, String str, DMImageCreator.C0502e c0502e) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1231966415")) {
            ipChange.ipc$dispatch("-1231966415", new Object[]{this, activity, imageView, imageView2, view, str, c0502e});
            return;
        }
        Bitmap bitmap = c0502e.b;
        if (bitmap == null) {
            GenerateImageUtil.I(activity);
            return;
        }
        Bitmap createScaleBitmap = createScaleBitmap(bitmap, 500, (bitmap.getHeight() * 500) / bitmap.getWidth());
        imageView.setImageBitmap(createScaleBitmap);
        if (imageView2 != null) {
            imageView2.setImageDrawable(new BitmapDrawable(b21.a(activity, createScaleBitmap)));
        }
        requestQrcode(activity, view, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadBgImg$4(Activity activity, View view, String str, DMImageCreator.C0501d c0501d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1625214527")) {
            ipChange.ipc$dispatch("-1625214527", new Object[]{this, activity, view, str, c0501d});
        } else {
            requestQrcode(activity, view, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadHeadImg$1(View view, Activity activity, DMShareMessage dMShareMessage, String str, DMImageCreator.C0502e c0502e) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-706473222")) {
            ipChange.ipc$dispatch("-706473222", new Object[]{this, view, activity, dMShareMessage, str, c0502e});
            return;
        }
        Bitmap bitmap = c0502e.b;
        if (bitmap == null) {
            return;
        }
        DMAvatar dMAvatar = (DMAvatar) view.findViewById(R$id.share_wx_img_userimg);
        int a = t60.a(this.contextReference, 30.0f);
        dMAvatar.setAvatar(createScaleBitmap(bitmap, a, a));
        dMAvatar.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_30x30);
        loadBgImg(activity, dMShareMessage, view, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadHeadImg$2(Activity activity, DMShareMessage dMShareMessage, View view, String str, DMImageCreator.C0501d c0501d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1051481288")) {
            ipChange.ipc$dispatch("1051481288", new Object[]{this, activity, dMShareMessage, view, str, c0501d});
        } else {
            loadBgImg(activity, dMShareMessage, view, str);
        }
    }

    private void layoutView(Activity activity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-575843429")) {
            ipChange.ipc$dispatch("-575843429", new Object[]{this, activity, view});
            return;
        }
        DisplayMetrics b = t60.b(activity);
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(b);
        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(b);
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    private void loadBgImg(final Activity activity, DMShareMessage dMShareMessage, final View view, final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1640768176")) {
            ipChange.ipc$dispatch("-1640768176", new Object[]{this, activity, dMShareMessage, view, str});
            return;
        }
        final ImageView imageView = (ImageView) view.findViewById(R$id.share_page_projectbg);
        final ImageView imageView2 = (ImageView) view.findViewById(R$id.share_page_bg);
        C0504a.b().h(activity).c(dMShareMessage.sharePictureUrl).n(new DMImageCreator.DMImageSuccListener() { // from class: tb.b3
            @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
            public final void onSuccess(DMImageCreator.C0502e c0502e) {
                ActionShareByType.this.lambda$loadBgImg$3(activity, imageView, imageView2, view, str, c0502e);
            }
        }).e(new DMImageCreator.DMImageFailListener() { // from class: tb.z2
            @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
            public final void onFail(DMImageCreator.C0501d c0501d) {
                ActionShareByType.this.lambda$loadBgImg$4(activity, view, str, c0501d);
            }
        }).f();
    }

    private void loadHeadImg(final Activity activity, final DMShareMessage dMShareMessage, final String str, final View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1730786303")) {
            ipChange.ipc$dispatch("-1730786303", new Object[]{this, activity, dMShareMessage, str, view});
        } else {
            C0504a.b().c(dMShareMessage.headUrl).n(new DMImageCreator.DMImageSuccListener() { // from class: tb.c3
                @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                public final void onSuccess(DMImageCreator.C0502e c0502e) {
                    ActionShareByType.this.lambda$loadHeadImg$1(view, activity, dMShareMessage, str, c0502e);
                }
            }).e(new DMImageCreator.DMImageFailListener() { // from class: tb.a3
                @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
                public final void onFail(DMImageCreator.C0501d c0501d) {
                    ActionShareByType.this.lambda$loadHeadImg$2(activity, dMShareMessage, view, str, c0501d);
                }
            }).f();
        }
    }

    private void requestQrcode(final Activity activity, final View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "204447121")) {
            ipChange.ipc$dispatch("204447121", new Object[]{this, activity, view, str});
            return;
        }
        final ImageView imageView = (ImageView) view.findViewById(R$id.share_page_qrcode_img);
        if (imageView == null) {
            saveImg(activity, view);
        } else {
            QrcodeUtil.c(t60.a(this.contextReference, 120.0f), str, new QrcodeUtil.OnQRcodeCreateListener() { // from class: cn.damai.h5container.action.ActionShareByType.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.commonbusiness.qrcode.util.QrcodeUtil.OnQRcodeCreateListener
                public void onFailure() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-473766530")) {
                        ipChange2.ipc$dispatch("-473766530", new Object[]{this});
                        return;
                    }
                    GenerateImageUtil.I((Activity) ActionShareByType.this.contextReference);
                    ActionShareByType.this.saveImg(activity, view);
                }

                @Override // cn.damai.commonbusiness.qrcode.util.QrcodeUtil.OnQRcodeCreateListener
                public void onSuccess(Bitmap bitmap) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1822634647")) {
                        ipChange2.ipc$dispatch("-1822634647", new Object[]{this, bitmap});
                        return;
                    }
                    imageView.setImageBitmap(bitmap);
                    ActionShareByType.this.saveImg(activity, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImg(Activity activity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2049329328")) {
            ipChange.ipc$dispatch("-2049329328", new Object[]{this, activity, view});
            return;
        }
        layoutView(activity, view);
        saveToSDCard(activity, getScrollViewBitmap((ViewGroup) view));
    }

    private void saveToSDCard(Activity activity, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1702677919")) {
            ipChange.ipc$dispatch("-1702677919", new Object[]{this, activity, bitmap});
            return;
        }
        try {
            String str = b21.d(activity) + File.separator + System.currentTimeMillis() + "dm_share_tmp.png";
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            this.imageFileUrl = str;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str)) {
                if (this.type.equals(this.types[0])) {
                    shareToWx(0);
                } else if (this.type.equals(this.types[1])) {
                    shareToWx(1);
                } else if (this.type.equals(this.types[2])) {
                    shareToWeibo();
                }
            }
            GenerateImageUtil.I(activity);
        } catch (IOException e) {
            e.printStackTrace();
            GenerateImageUtil.I(activity);
            ToastUtil.a().e(activity, "图片生成失败");
        }
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "437685352")) {
            return ((Boolean) ipChange.ipc$dispatch("437685352", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        String param = getParam("type");
        this.type = param;
        if (TextUtils.isEmpty(param)) {
            wVCallBackContext.error("param type is null");
            return true;
        }
        this.title = getParam("title");
        this.wxtitle = getParam("wxtitle");
        this.imageUrl = getParam("imageUrl");
        this.headUrl = getParam("headUrl");
        this.producturl = getParam("url");
        this.currentPrice = getParam("currentPrice");
        this.originPrice = getParam("originPrice");
        this.message = getParam("message");
        this.userMessage = getParam("userMessage");
        JSONArray jSONArray = this.jsonObject.getJSONArray("infoArray");
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.size(); i++) {
                this.showtime += jSONArray.getString(i);
                if (i < jSONArray.size() - 1) {
                    this.showtime += StringUtils.LF;
                }
            }
        }
        if (this.type.equals(this.types[0])) {
            generateImage4SHare();
        } else if (this.type.equals(this.types[1])) {
            generateImage4SHare();
        } else if (this.type.equals(this.types[2])) {
            generateImage4SHare();
        } else if (this.type.equals(this.types[3])) {
            shareToDingDing();
        } else if (this.type.equals(this.types[4])) {
            shareToQq();
        }
        wVCallBackContext.success();
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-859089642") ? (String) ipChange.ipc$dispatch("-859089642", new Object[]{this}) : "shareByType";
    }

    public void shareToDingDing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "954938624")) {
            ipChange.ipc$dispatch("954938624", new Object[]{this});
            return;
        }
        ShareUtil shareUtil = new ShareUtil((Activity) this.contextReference, "");
        shareUtil.initShareData(this.wxtitle, this.title, this.imageUrl, this.producturl, "");
        shareUtil.shareByDing();
    }

    public void shareToQq() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1813061444")) {
            ipChange.ipc$dispatch("-1813061444", new Object[]{this});
            return;
        }
        ShareUtil shareUtil = new ShareUtil((Activity) this.contextReference, "");
        shareUtil.initShareData(this.wxtitle, this.title, this.imageUrl, this.producturl, "");
        shareUtil.shareQQ();
    }

    public void shareToWeibo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1978593082")) {
            ipChange.ipc$dispatch("-1978593082", new Object[]{this});
            return;
        }
        ShareUtil shareUtil = new ShareUtil((Activity) this.contextReference, "bytype");
        if (!TextUtils.isEmpty(this.producturl)) {
            shareUtil.initShareData(this.title, this.wxtitle, this.imageUrl, this.producturl, this.imageFileUrl, "", 0L);
        } else {
            shareUtil.initShareData(this.title, this.wxtitle, this.imageUrl, this.producturl, this.imageFileUrl, "");
        }
        if (!TextUtils.isEmpty(this.imageUrl)) {
            shareUtil.setImageModeUrl(this.imageUrl);
        }
        shareUtil.setProducturl(this.producturl);
        shareUtil.shareByWay("新浪微博");
    }

    public void shareToWx(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-192060920")) {
            ipChange.ipc$dispatch("-192060920", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ShareContent shareContent = new ShareContent();
        shareContent.setTitle(this.wxtitle);
        shareContent.setContent(this.message);
        if (i == 0) {
            shareContent.addImage(this.imageFileUrl);
            shareContent.setShareType(4);
        } else {
            shareContent.addImage(this.imageUrl);
        }
        if (!TextUtils.isEmpty(this.producturl)) {
            shareContent.setUrl(this.producturl);
        }
        if (!TextUtils.isEmpty(this.imageFileUrl) && i == 1) {
            shareContent.getImgUrls().clear();
            shareContent.addImage(this.imageFileUrl);
            shareContent.setShareType(1);
        }
        new ShareMenuHelper(this.contextReference).j(Integer.valueOf((i == 0 ? ShareChannel.WEIXIN : ShareChannel.WEIXIN_FRIEND).value), shareContent, null);
    }
}
