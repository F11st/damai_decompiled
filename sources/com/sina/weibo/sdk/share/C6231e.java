package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.MediaObject;
import com.sina.weibo.sdk.api.MultiImageObject;
import com.sina.weibo.sdk.api.SuperGroupObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.VideoSourceObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.b.C6209a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.sina.weibo.sdk.share.e */
/* loaded from: classes7.dex */
public final class C6231e {
    public long D;

    public static void a(Activity activity, WeiboMultiMessage weiboMultiMessage) {
        if (activity != null && a((Context) activity, weiboMultiMessage)) {
            Bundle bundle = new Bundle();
            bundle.putInt("_weibo_command_type", 1);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            bundle.putString("_weibo_transaction", sb.toString());
            bundle.putAll(weiboMultiMessage.writeToBundle(bundle));
            Intent intent = new Intent(activity, ShareTransActivity.class);
            intent.putExtra("start_flag", 1001);
            intent.putExtras(bundle);
            activity.startActivityForResult(intent, 10001);
        }
    }

    private static List<Object> b(WeiboMultiMessage weiboMultiMessage) {
        ArrayList arrayList = new ArrayList();
        TextObject textObject = weiboMultiMessage.textObject;
        if (textObject != null) {
            arrayList.add(textObject);
        }
        ImageObject imageObject = weiboMultiMessage.imageObject;
        if (imageObject != null) {
            arrayList.add(imageObject);
        }
        MediaObject mediaObject = weiboMultiMessage.mediaObject;
        if (mediaObject != null) {
            arrayList.add(mediaObject);
        }
        MultiImageObject multiImageObject = weiboMultiMessage.multiImageObject;
        if (multiImageObject != null) {
            arrayList.add(multiImageObject);
        }
        VideoSourceObject videoSourceObject = weiboMultiMessage.videoSourceObject;
        if (videoSourceObject != null) {
            arrayList.add(videoSourceObject);
        }
        SuperGroupObject superGroupObject = weiboMultiMessage.superGroupObject;
        if (superGroupObject != null) {
            arrayList.add(superGroupObject);
        }
        return arrayList;
    }

    private static boolean a(Context context, WeiboMultiMessage weiboMultiMessage) {
        if (weiboMultiMessage != null) {
            List<Object> b = b(weiboMultiMessage);
            if (weiboMultiMessage.superGroupObject == null || C6209a.d(context)) {
                return true;
            }
            if (a(b, weiboMultiMessage.superGroupObject)) {
                Toast.makeText(context, "微博版本过低，不支持超话分享", 0).show();
                return false;
            }
            weiboMultiMessage.superGroupObject = null;
            return true;
        }
        return true;
    }

    private static boolean a(List<Object> list, Object obj) {
        return (list == null || list.isEmpty() || obj == null || !list.contains(obj) || list.size() != 1) ? false : true;
    }
}
