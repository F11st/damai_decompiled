package com.tencent.connect.emotion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.tencent.connect.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class QQEmotion extends BaseApi {
    private IUiListener a;

    public QQEmotion(QQToken qQToken) {
        super(qQToken);
    }

    private boolean a(Context context, ArrayList<Uri> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        if (arrayList.size() > 9) {
            SLog.i("QQEMOTION", "isLegality -->illegal, file count > 9, count = " + arrayList.size());
            return false;
        }
        long j = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            long a = m.a(context, arrayList.get(i));
            if (a > 1048576) {
                SLog.i("QQEMOTION", "isLegality -->illegal, fileSize: " + a);
                return false;
            }
            j += a;
        }
        if (j > 3145728) {
            SLog.i("QQEMOTION", "isLegality -->illegal, totalSize: " + j);
            return false;
        }
        SLog.i("QQEMOTION", "isLegality -->legal, totalSize: " + j);
        return true;
    }

    public void setEmotions(Activity activity, ArrayList<Uri> arrayList, IUiListener iUiListener) {
        if (a.a("QQEmotion", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.a = iUiListener;
        if (!k.b(activity)) {
            Toast.makeText(activity.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
        } else if (k.c(activity, "8.0.0") < 0) {
            Toast.makeText(activity.getApplicationContext(), "当前手机QQ版本过低，不支持设置表情功能。", 1).show();
        } else if (!a(activity.getApplicationContext(), arrayList)) {
            Toast.makeText(activity.getApplicationContext(), "图片不符合要求，不支持设置表情功能。", 1).show();
        } else {
            String a = m.a(activity);
            StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_face_collection?");
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(a)) {
                if (a.length() > 20) {
                    a = a.substring(0, 20) + "...";
                }
                sb.append(a);
                stringBuffer.append("&app_name=" + Base64.encodeToString(m.j(a), 2));
            }
            String appId = this.c.getAppId();
            String openId = this.c.getOpenId();
            if (!TextUtils.isEmpty(appId)) {
                stringBuffer.append("&share_id=" + appId);
                sb.append(appId);
            }
            if (!TextUtils.isEmpty(openId)) {
                sb.append(openId);
                stringBuffer.append("&open_id=" + Base64.encodeToString(m.j(openId), 2));
            }
            stringBuffer.append("&sdk_version=" + Base64.encodeToString(m.j(Constants.SDK_VERSION), 2));
            sb.append(Constants.SDK_VERSION);
            String a2 = a(activity, arrayList);
            if (!TextUtils.isEmpty(a2)) {
                sb.append(a2);
                stringBuffer.append("&set_uri_list=" + Base64.encodeToString(m.j(a2), 2));
                stringBuffer.append("&");
                stringBuffer.append(Constants.KEY_PPSTS);
                stringBuffer.append("=");
                stringBuffer.append(k.a(activity, sb.toString()));
                SLog.v("QQEMOTION", "-->set avatar, url: " + stringBuffer.toString());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(stringBuffer.toString()));
                intent.setPackage("com.tencent.mobileqq");
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                if (a(intent)) {
                    UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_EDIT_EMOTION, iUiListener);
                    a(activity, Constants.REQUEST_EDIT_EMOTION, intent, false);
                    return;
                }
                return;
            }
            iUiListener.onError(new UiError(-6, Constants.MSG_UNKNOWN_ERROR, "picPathList is null"));
        }
    }

    private String a(Activity activity, ArrayList<Uri> arrayList) {
        StringBuilder sb = new StringBuilder();
        Iterator<Uri> it = arrayList.iterator();
        while (it.hasNext()) {
            Uri a = m.a(activity, this.c.getAppId(), m.b(activity, it.next()));
            if (a == null) {
                SLog.e("QQEmotion", "getFilePathListJson: grantedUri = null");
            } else {
                sb.append(a);
                sb.append(";");
            }
        }
        String sb2 = sb.toString();
        SLog.i("QQEmotion", "-->getFilePathListJson listStr : " + sb2);
        return sb2;
    }
}
