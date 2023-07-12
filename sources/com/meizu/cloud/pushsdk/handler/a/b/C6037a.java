package com.meizu.cloud.pushsdk.handler.a.b;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.c.a.C5950c;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractC6033a;
import com.meizu.cloud.pushsdk.handler.a.AbstractC6034a;
import com.meizu.cloud.pushsdk.handler.a.c.C6041b;
import com.meizu.cloud.pushsdk.handler.a.c.C6048g;
import com.meizu.cloud.pushsdk.notification.InterfaceC6080c;
import com.meizu.cloud.pushsdk.platform.a.C6091b;
import com.meizu.cloud.pushsdk.util.C6101a;
import com.meizu.cloud.pushsdk.util.C6104d;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.taobao.weex.annotation.JSMethod;
import java.io.File;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.handler.a.b.a */
/* loaded from: classes10.dex */
public class C6037a extends AbstractC6034a<C6048g> {
    public C6037a(Context context, AbstractC6033a abstractC6033a) {
        super(context, abstractC6033a);
    }

    @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6069c
    public int a() {
        return 65536;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    /* renamed from: a */
    public void b(C6048g c6048g) {
        C6104d.b(d(), d().getPackageName(), c6048g.d().b().d(), c6048g.d().b().a(), c6048g.d().b().e(), c6048g.d().b().b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    public void a(C6048g c6048g, InterfaceC6080c interfaceC6080c) {
        String str;
        String message;
        String str2;
        DebugLogger.flush();
        String a = c6048g.d().b().a();
        String d = c6048g.d().b().d();
        if (Build.VERSION.SDK_INT >= 29) {
            str = MzSystemUtils.getDocumentsPath(d()) + "/pushSdktmp/" + a + JSMethod.NOT_SET + d + ".zip";
        } else {
            str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdktmp/" + a + JSMethod.NOT_SET + d + ".zip";
        }
        File file = null;
        try {
            new C6038b(str).a(c6048g.c());
            File file2 = new File(str);
            message = null;
            file = file2;
        } catch (Exception e) {
            message = e.getMessage();
            DebugLogger.e("AbstractMessageHandler", "zip error message " + message);
        }
        if (file != null && file.length() / 1024 > c6048g.a()) {
            message = "the upload file exceeds the max size";
        } else if (c6048g.b() && !C6101a.b(d())) {
            message = "current network not allowed upload log file";
        }
        C5950c<String> a2 = C6091b.a(d()).a(c6048g.d().b().a(), c6048g.d().b().d(), message, file);
        if (a2 != null && a2.b()) {
            if (file != null) {
                file.delete();
            }
            DebugLogger.e("AbstractMessageHandler", "upload success " + a2.a());
            return;
        }
        if (a2 != null) {
            str2 = "upload error code " + a2.c() + a2.a();
        } else {
            str2 = "upload error";
        }
        DebugLogger.i("AbstractMessageHandler", str2);
    }

    @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6069c
    public boolean a(Intent intent) {
        int i;
        DebugLogger.i("AbstractMessageHandler", "start LogUploadMessageHandler match");
        String stringExtra = intent.getStringExtra(PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        if (!TextUtils.isEmpty(stringExtra)) {
            C6041b a = C6041b.a(stringExtra);
            if (a.a() != null) {
                i = a.a().a();
                return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && "2".equals(String.valueOf(i));
            }
        }
        i = 0;
        if (PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction())) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    /* renamed from: l */
    public C6048g c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SEQ_ID);
        return new C6048g(intent.getStringExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE), stringExtra, intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY), stringExtra2);
    }
}
