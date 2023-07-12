package cn.damai.user.bean;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.mtop.BaseResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import tb.cb2;
import tb.j11;
import tb.m61;
import tb.m62;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class ShareBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String ipId;
    public String shareImage;
    public String shareSubTitle;
    public String shareTitle;
    public String shareUrl;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface OnShareListener {
        void openShareView(Bundle bundle, String str);

        void showLoading(boolean z);

        void toast(String str);
    }

    public static void doIpDramaShare(final ShareBean shareBean, final OnShareListener onShareListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1536634624")) {
            ipChange.ipc$dispatch("1536634624", new Object[]{shareBean, onShareListener});
        } else if (shareBean == null || !shareBean.isValid() || onShareListener == null) {
        } else {
            final String str = shareBean.shareImage;
            Application a = mu0.a();
            C0504a.b().f(str, m62.a(a, 111.0f), m62.a(a, 148.0f)).n(new DMImageCreator.DMImageSuccListener() { // from class: cn.damai.user.bean.ShareBean.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                public void onSuccess(DMImageCreator.C0502e c0502e) {
                    Bitmap bitmap;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1615170387")) {
                        ipChange2.ipc$dispatch("1615170387", new Object[]{this, c0502e});
                        return;
                    }
                    OnShareListener.this.showLoading(false);
                    if (c0502e == null || (bitmap = c0502e.b) == null) {
                        return;
                    }
                    try {
                        String d = j11.d(str, bitmap, mu0.a());
                        ShareBean shareBean2 = shareBean;
                        String str2 = shareBean2.shareTitle;
                        String str3 = shareBean2.shareSubTitle;
                        String str4 = shareBean2.shareImage;
                        String str5 = shareBean2.shareUrl;
                        Bundle bundle = new Bundle();
                        bundle.putString("title", str2);
                        bundle.putString("projectName", str2);
                        bundle.putString("message", str3);
                        if (!TextUtils.isEmpty(str4)) {
                            bundle.putString("imageurl", str4);
                            bundle.putString("projectImage", str4);
                        }
                        if (!TextUtils.isEmpty(d)) {
                            bundle.putString("sinaSharePath", d);
                        }
                        if (!TextUtils.isEmpty(str5)) {
                            bundle.putString("producturl", str5);
                        }
                        bundle.putBoolean("showGenerateImage", true);
                        bundle.putString("shareType", "chat_h5");
                        bundle.putString("fromWhere", "ipDramaPage");
                        bundle.putString("shareImageStyle", GenerateImageUtil.STYLE_GENERATE_IP_DRAMA_IMAGE);
                        OnShareListener.this.openShareView(bundle, shareBean.ipId);
                    } catch (Exception unused) {
                        OnShareListener.this.toast("分享失败");
                    }
                }
            }).e(new DMImageCreator.DMImageFailListener() { // from class: cn.damai.user.bean.ShareBean.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
                public void onFail(DMImageCreator.C0501d c0501d) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "147800126")) {
                        ipChange2.ipc$dispatch("147800126", new Object[]{this, c0501d});
                        return;
                    }
                    OnShareListener.this.showLoading(false);
                    OnShareListener.this.toast("分享失败");
                }
            }).f();
        }
    }

    public static ShareBean obtainIpDramaShareBean(BaseResponse baseResponse) {
        NodeData item;
        ShareJsonBean shareJsonBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1449966681")) {
            return (ShareBean) ipChange.ipc$dispatch("-1449966681", new Object[]{baseResponse});
        }
        if (baseResponse != null && !cb2.d(baseResponse.layers)) {
            Iterator<BaseLayer> it = baseResponse.layers.iterator();
            while (it.hasNext()) {
                List<BaseSection> sections = it.next().getSections();
                if (!cb2.d(sections)) {
                    for (BaseSection baseSection : sections) {
                        if (TextUtils.equals("dm_card_ip_info", baseSection.getComponentId()) && (item = baseSection.getItem()) != null && (shareJsonBean = (ShareJsonBean) m61.d(item, ShareJsonBean.class)) != null && shareJsonBean.isValid()) {
                            ShareBean shareBean = new ShareBean();
                            shareBean.shareImage = shareJsonBean.verticalPicList.get(0);
                            String str = TextUtils.isEmpty(shareJsonBean.ipName) ? "" : shareJsonBean.ipName;
                            shareBean.shareTitle = str + "快来看看！";
                            shareBean.shareSubTitle = null;
                            shareBean.ipId = shareJsonBean.id;
                            shareBean.shareUrl = "https://m.damai.cn/app/dmfe/dramas/pages/ip/index.html?ipId=" + shareJsonBean.id;
                            return shareBean;
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1779058290") ? ((Boolean) ipChange.ipc$dispatch("-1779058290", new Object[]{this})).booleanValue() : (TextUtils.isEmpty(this.shareImage) || TextUtils.isEmpty(this.shareUrl)) ? false : true;
    }
}
