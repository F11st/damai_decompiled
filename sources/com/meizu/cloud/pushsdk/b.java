package com.meizu.cloud.pushsdk;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.handler.a.d;
import com.meizu.cloud.pushsdk.handler.a.e;
import com.meizu.cloud.pushsdk.handler.a.f;
import com.meizu.cloud.pushsdk.handler.c;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b {
    private static volatile b b;
    private final SparseArray<c> a;
    private Map<String, com.meizu.cloud.pushsdk.handler.a> c;
    private com.meizu.cloud.pushsdk.handler.a.f.a d;
    private com.meizu.cloud.pushsdk.handler.a.a.a e;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class a extends com.meizu.cloud.pushsdk.handler.a {
        public a() {
        }

        @Override // com.meizu.cloud.pushsdk.handler.a
        public void a(Context context, Intent intent) {
            for (Map.Entry entry : b.this.c.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(context, intent);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(Context context, MzPushMessage mzPushMessage) {
            for (Map.Entry entry : b.this.c.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(context, mzPushMessage);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(Context context, PushSwitchStatus pushSwitchStatus) {
            for (Map.Entry entry : b.this.c.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(context, pushSwitchStatus);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(Context context, RegisterStatus registerStatus) {
            for (Map.Entry entry : b.this.c.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(context, registerStatus);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(Context context, SubAliasStatus subAliasStatus) {
            for (Map.Entry entry : b.this.c.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(context, subAliasStatus);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(Context context, SubTagsStatus subTagsStatus) {
            for (Map.Entry entry : b.this.c.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(context, subTagsStatus);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(Context context, UnRegisterStatus unRegisterStatus) {
            for (Map.Entry entry : b.this.c.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(context, unRegisterStatus);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(Context context, String str) {
            for (Map.Entry entry : b.this.c.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(context, str);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(Context context, String str, String str2) {
            for (Map.Entry entry : b.this.c.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(context, str, str2);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(Context context, boolean z) {
            for (Map.Entry entry : b.this.c.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(context, z);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(PushNotificationBuilder pushNotificationBuilder) {
            for (Map.Entry entry : b.this.c.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(pushNotificationBuilder);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void b(Context context, MzPushMessage mzPushMessage) {
            for (Map.Entry entry : b.this.c.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.b(context, mzPushMessage);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void b(Context context, String str) {
            for (Map.Entry entry : b.this.c.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.b(context, str);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void c(Context context, MzPushMessage mzPushMessage) {
            for (Map.Entry entry : b.this.c.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.c(context, mzPushMessage);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void c(Context context, String str) {
            for (Map.Entry entry : b.this.c.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.c(context, str);
                }
            }
        }
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, List<c> list) {
        this(context, list, null);
    }

    public b(Context context, List<c> list, com.meizu.cloud.pushsdk.handler.a aVar) {
        this.a = new SparseArray<>();
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        Context applicationContext = context.getApplicationContext();
        this.c = new HashMap();
        a aVar2 = new a();
        if (PushConstants.PUSH_PACKAGE_NAME.equalsIgnoreCase(applicationContext.getPackageName())) {
            this.d = new com.meizu.cloud.pushsdk.handler.a.f.a(applicationContext);
            if (MinSdkChecker.isSupportNotificationSort()) {
                this.e = new com.meizu.cloud.pushsdk.handler.a.a.a(applicationContext);
            }
        }
        if (list != null) {
            a(list);
            return;
        }
        a(new com.meizu.cloud.pushsdk.handler.a.c(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.b(applicationContext, aVar2));
        a(new e(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.d.b(applicationContext, aVar2));
        a(new d(applicationContext, aVar2));
        a(new f(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.d.d(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.e.a(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.e.c(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.e.f(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.e.d(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.e.e(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.f.c(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.e.b(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.d.e(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.b.a(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.d.a(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.d.f(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.f.b(applicationContext, aVar2));
        a(new com.meizu.cloud.pushsdk.handler.a.d.c(applicationContext, aVar2));
    }

    public static b a(Context context) {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    DebugLogger.i("PushMessageProxy", "PushMessageProxy init");
                    b = new b(context);
                }
            }
        }
        return b;
    }

    public b a(c cVar) {
        this.a.put(cVar.a(), cVar);
        return this;
    }

    public b a(String str, com.meizu.cloud.pushsdk.handler.a aVar) {
        this.c.put(str, aVar);
        return this;
    }

    public b a(List<c> list) {
        if (list != null) {
            for (c cVar : list) {
                a(cVar);
            }
            return this;
        }
        throw new IllegalArgumentException("messageManagerList must not be null.");
    }

    public com.meizu.cloud.pushsdk.handler.a.f.a a() {
        return this.d;
    }

    public void a(Intent intent) {
        DebugLogger.e("PushMessageProxy", "process message start");
        try {
            String stringExtra = intent.getStringExtra("method");
            DebugLogger.i("PushMessageProxy", "receive action " + intent.getAction() + " method " + stringExtra);
            for (int i = 0; i < this.a.size() && !this.a.valueAt(i).b(intent); i++) {
            }
        } catch (Exception e) {
            DebugLogger.e("PushMessageProxy", "process message error " + e.getMessage());
        }
    }

    public com.meizu.cloud.pushsdk.handler.a.a.a b() {
        return this.e;
    }
}
