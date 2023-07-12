package cn.damai.h5container;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import androidx.core.content.FileProvider;
import cn.damai.baseview.CustomDialog;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.commonbusiness.R$style;
import cn.damai.wxapi.ShareUtil;
import com.alibaba.security.common.track.model.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.actions.SearchIntents;
import com.tencent.open.SocialConstants;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import tb.cb2;
import tb.hs1;
import tb.ir1;
import tb.m61;
import tb.mr1;
import tb.qw2;
import tb.y13;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class WebViewUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String appendQueryParameter(String str, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-14004060")) {
            return (String) ipChange.ipc$dispatch("-14004060", new Object[]{str, map});
        }
        if (TextUtils.isEmpty(str) || cb2.f(map)) {
            return str;
        }
        try {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    buildUpon.appendQueryParameter(str2, str3);
                }
            }
            return buildUpon.build().toString();
        } catch (Exception e) {
            e.printStackTrace();
            HashMap hashMap = new HashMap();
            hashMap.put("msg", "webViewFragment append url fail");
            hashMap.put("originUrl", str);
            hashMap.put("exceptionMsg", e.getMessage());
            if (!cb2.f(map)) {
                hashMap.put(SearchIntents.EXTRA_QUERY, m61.e(map));
            }
            y13.b("webViewFragment", "-1", m61.e(hashMap));
            return appendQueryParameterManual(str, map);
        }
    }

    private static String appendQueryParameterManual(String str, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1949944062")) {
            return (String) ipChange.ipc$dispatch("1949944062", new Object[]{str, map});
        }
        Set<String> keySet = map.keySet();
        StringBuilder sb = new StringBuilder();
        for (String str2 : keySet) {
            String str3 = map.get(str2);
            if (!TextUtils.isEmpty(str3)) {
                sb.append(str2);
                sb.append("=");
                sb.append(str3);
                sb.append("&");
            }
        }
        if (sb.length() > 0) {
            if (str.contains("?")) {
                return str.replaceFirst("\\?", "?" + sb.toString());
            }
            StringBuilder delete = sb.delete(sb.length() - 1, sb.length());
            if (str.contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                return str.replaceFirst(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX, "?" + delete.toString() + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
            }
            return str + "?" + delete.toString();
        }
        return str;
    }

    public static HashMap<String, String> getPamMap(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1143216551")) {
            return (HashMap) ipChange.ipc$dispatch("1143216551", new Object[]{str});
        }
        String[] split = str.substring(str.indexOf("?") + 1).split("&");
        if (split == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        getparam(split, hashMap);
        return hashMap;
    }

    private static void getparam(String[] strArr, HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1575878313")) {
            ipChange.ipc$dispatch("-1575878313", new Object[]{strArr, hashMap});
            return;
        }
        for (String str : strArr) {
            String[] split = str.split("=");
            if (split != null && split.length >= 2) {
                try {
                    split[1] = URLDecoder.decode(split[1], "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                hashMap.put(split[0], split[1]);
            }
        }
    }

    public static void share(String str, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-244558419")) {
            ipChange.ipc$dispatch("-244558419", new Object[]{str, activity});
            return;
        }
        int i = (!str.contains("weixinshare") && str.contains("weixinfshare")) ? 1 : 0;
        String[] split = str.substring(str.indexOf("?") + 1).split("&");
        if (split == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        getparam(split, hashMap);
        String str2 = (String) hashMap.get("title");
        String str3 = (String) hashMap.get("content");
        String str4 = (String) hashMap.get(SocialConstants.PARAM_IMAGE);
        String str5 = (String) hashMap.get("rurl");
        if (str4.contains(",")) {
            str4 = str4.split(",")[0];
        }
        String str6 = str4;
        qw2.d("aa", "title--" + str2 + "content---" + str3 + "imageurl--" + str6 + "producturl--" + str5);
        shareByWchart(str2, str3, str6, str5, i, activity);
    }

    public static void shareByWchart(String str, String str2, String str3, String str4, int i, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1615167322")) {
            ipChange.ipc$dispatch("1615167322", new Object[]{str, str2, str3, str4, Integer.valueOf(i), activity});
            return;
        }
        qw2.d("aa", "weixin share click");
        ShareUtil shareUtil = new ShareUtil(activity, a.c.d);
        shareUtil.initShareData(str, str2, str3, str4, "");
        shareUtil.shareByWchart(i);
    }

    public static void showPhotoDialog(final Activity activity, final ValueCallback<Uri> valueCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-57944149")) {
            ipChange.ipc$dispatch("-57944149", new Object[]{activity, valueCallback});
            return;
        }
        CustomDialog customDialog = new CustomDialog(activity, R$style.custom_dialog_style);
        customDialog.e(new CustomDialog.OnDialogClickListener() { // from class: cn.damai.h5container.WebViewUtil.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.baseview.CustomDialog.OnDialogClickListener
            public void onAlbum() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1857956461")) {
                    ipChange2.ipc$dispatch("-1857956461", new Object[]{this});
                } else {
                    ir1.b(activity, false, mr1.STORAGE, "用于选取、上传、发布及分享图片/视频", new OnGrantListener() { // from class: cn.damai.h5container.WebViewUtil.1.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // cn.damai.common.askpermission.OnGrantListener
                        public void onGranted() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "883280346")) {
                                ipChange3.ipc$dispatch("883280346", new Object[]{this});
                                return;
                            }
                            Intent intent = new Intent("android.intent.action.PICK", (Uri) null);
                            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                            activity.startActivityForResult(intent, 257);
                        }
                    });
                }
            }

            @Override // cn.damai.baseview.CustomDialog.OnDialogClickListener
            public void onDismiss() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1537056680")) {
                    ipChange2.ipc$dispatch("-1537056680", new Object[]{this});
                } else {
                    valueCallback.onReceiveValue(null);
                }
            }

            @Override // cn.damai.baseview.CustomDialog.OnDialogClickListener
            public void onPhoto() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-369337616")) {
                    ipChange2.ipc$dispatch("-369337616", new Object[]{this});
                } else {
                    ir1.b(activity, false, mr1.CAMERA, "用于拍照、拍摄、扫码服务", new OnGrantListener() { // from class: cn.damai.h5container.WebViewUtil.1.2
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // cn.damai.common.askpermission.OnGrantListener
                        public void onGranted() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "372746169")) {
                                ipChange3.ipc$dispatch("372746169", new Object[]{this});
                                return;
                            }
                            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                            if (Build.VERSION.SDK_INT >= 24) {
                                Uri uriForFile = FileProvider.getUriForFile(activity, "cn.damai.interactProvider", new File(hs1.a(activity)));
                                intent.addFlags(1);
                                intent.putExtra("output", uriForFile);
                            } else {
                                intent.putExtra("output", Uri.fromFile(new File(hs1.a(activity))));
                            }
                            activity.startActivityForResult(intent, 258);
                        }
                    });
                }
            }
        });
        customDialog.show();
        customDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: cn.damai.h5container.WebViewUtil.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-210050921")) {
                    ipChange2.ipc$dispatch("-210050921", new Object[]{this, dialogInterface});
                } else {
                    valueCallback.onReceiveValue(null);
                }
            }
        });
    }

    public static String subStr(String str, int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-999982512")) {
            return (String) ipChange.ipc$dispatch("-999982512", new Object[]{str, Integer.valueOf(i)});
        }
        int i3 = i * 2;
        if (str.length() < i3 / 2) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        String[] split = str.split("");
        for (int i4 = 1; i4 < split.length; i4++) {
            i2 += split[i4].getBytes().length > 1 ? 2 : 1;
            stringBuffer.append(split[i4]);
            if (i2 >= i3) {
                break;
            }
        }
        if (stringBuffer.toString().length() < str.length()) {
            stringBuffer.append("...");
            return stringBuffer.toString();
        }
        return str;
    }

    public void startPhotoCapture(Uri uri, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2119070401")) {
            ipChange.ipc$dispatch("-2119070401", new Object[]{this, uri, activity});
            return;
        }
        Intent intent = new Intent();
        intent.setClass(activity, CaptureActivity.class);
        intent.setData(uri);
        activity.startActivityForResult(intent, H5MainActivity.REQUEST_CORP);
    }
}
