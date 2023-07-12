package com.meizu.cloud.pushsdk.handler;

import android.content.Context;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.handler.b */
/* loaded from: classes10.dex */
public interface InterfaceC6068b {
    void a(Context context, MzPushMessage mzPushMessage);

    void a(Context context, PushSwitchStatus pushSwitchStatus);

    void a(Context context, RegisterStatus registerStatus);

    void a(Context context, SubAliasStatus subAliasStatus);

    void a(Context context, SubTagsStatus subTagsStatus);

    void a(Context context, UnRegisterStatus unRegisterStatus);

    void a(Context context, String str);

    void a(Context context, String str, String str2);

    void a(Context context, boolean z);

    void a(PushNotificationBuilder pushNotificationBuilder);

    void b(Context context, MzPushMessage mzPushMessage);

    void b(Context context, String str);

    void c(Context context, MzPushMessage mzPushMessage);

    void c(Context context, String str);
}
