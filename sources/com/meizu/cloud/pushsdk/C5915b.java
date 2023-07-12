package com.meizu.cloud.pushsdk;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractC6033a;
import com.meizu.cloud.pushsdk.handler.InterfaceC6069c;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.handler.a.C6036b;
import com.meizu.cloud.pushsdk.handler.a.C6039c;
import com.meizu.cloud.pushsdk.handler.a.C6050d;
import com.meizu.cloud.pushsdk.handler.a.C6057e;
import com.meizu.cloud.pushsdk.handler.a.C6064f;
import com.meizu.cloud.pushsdk.handler.a.a.C6035a;
import com.meizu.cloud.pushsdk.handler.a.b.C6037a;
import com.meizu.cloud.pushsdk.handler.a.d.C6051a;
import com.meizu.cloud.pushsdk.handler.a.d.C6052b;
import com.meizu.cloud.pushsdk.handler.a.d.C6053c;
import com.meizu.cloud.pushsdk.handler.a.d.C6054d;
import com.meizu.cloud.pushsdk.handler.a.d.C6055e;
import com.meizu.cloud.pushsdk.handler.a.d.C6056f;
import com.meizu.cloud.pushsdk.handler.a.e.C6058a;
import com.meizu.cloud.pushsdk.handler.a.e.C6059b;
import com.meizu.cloud.pushsdk.handler.a.e.C6060c;
import com.meizu.cloud.pushsdk.handler.a.e.C6061d;
import com.meizu.cloud.pushsdk.handler.a.e.C6062e;
import com.meizu.cloud.pushsdk.handler.a.e.C6063f;
import com.meizu.cloud.pushsdk.handler.a.f.C6065a;
import com.meizu.cloud.pushsdk.handler.a.f.C6066b;
import com.meizu.cloud.pushsdk.handler.a.f.C6067c;
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
/* renamed from: com.meizu.cloud.pushsdk.b */
/* loaded from: classes10.dex */
public class C5915b {
    private static volatile C5915b b;
    private final SparseArray<InterfaceC6069c> a;
    private Map<String, AbstractC6033a> c;
    private C6065a d;
    private C6035a e;

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.b$a */
    /* loaded from: classes10.dex */
    public class C5916a extends AbstractC6033a {
        public C5916a() {
        }

        @Override // com.meizu.cloud.pushsdk.handler.AbstractC6033a
        public void a(Context context, Intent intent) {
            for (Map.Entry entry : C5915b.this.c.entrySet()) {
                AbstractC6033a abstractC6033a = (AbstractC6033a) entry.getValue();
                if (abstractC6033a != null) {
                    abstractC6033a.a(context, intent);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6068b
        public void a(Context context, MzPushMessage mzPushMessage) {
            for (Map.Entry entry : C5915b.this.c.entrySet()) {
                AbstractC6033a abstractC6033a = (AbstractC6033a) entry.getValue();
                if (abstractC6033a != null) {
                    abstractC6033a.a(context, mzPushMessage);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6068b
        public void a(Context context, PushSwitchStatus pushSwitchStatus) {
            for (Map.Entry entry : C5915b.this.c.entrySet()) {
                AbstractC6033a abstractC6033a = (AbstractC6033a) entry.getValue();
                if (abstractC6033a != null) {
                    abstractC6033a.a(context, pushSwitchStatus);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6068b
        public void a(Context context, RegisterStatus registerStatus) {
            for (Map.Entry entry : C5915b.this.c.entrySet()) {
                AbstractC6033a abstractC6033a = (AbstractC6033a) entry.getValue();
                if (abstractC6033a != null) {
                    abstractC6033a.a(context, registerStatus);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6068b
        public void a(Context context, SubAliasStatus subAliasStatus) {
            for (Map.Entry entry : C5915b.this.c.entrySet()) {
                AbstractC6033a abstractC6033a = (AbstractC6033a) entry.getValue();
                if (abstractC6033a != null) {
                    abstractC6033a.a(context, subAliasStatus);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6068b
        public void a(Context context, SubTagsStatus subTagsStatus) {
            for (Map.Entry entry : C5915b.this.c.entrySet()) {
                AbstractC6033a abstractC6033a = (AbstractC6033a) entry.getValue();
                if (abstractC6033a != null) {
                    abstractC6033a.a(context, subTagsStatus);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6068b
        public void a(Context context, UnRegisterStatus unRegisterStatus) {
            for (Map.Entry entry : C5915b.this.c.entrySet()) {
                AbstractC6033a abstractC6033a = (AbstractC6033a) entry.getValue();
                if (abstractC6033a != null) {
                    abstractC6033a.a(context, unRegisterStatus);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6068b
        public void a(Context context, String str) {
            for (Map.Entry entry : C5915b.this.c.entrySet()) {
                AbstractC6033a abstractC6033a = (AbstractC6033a) entry.getValue();
                if (abstractC6033a != null) {
                    abstractC6033a.a(context, str);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6068b
        public void a(Context context, String str, String str2) {
            for (Map.Entry entry : C5915b.this.c.entrySet()) {
                AbstractC6033a abstractC6033a = (AbstractC6033a) entry.getValue();
                if (abstractC6033a != null) {
                    abstractC6033a.a(context, str, str2);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6068b
        public void a(Context context, boolean z) {
            for (Map.Entry entry : C5915b.this.c.entrySet()) {
                AbstractC6033a abstractC6033a = (AbstractC6033a) entry.getValue();
                if (abstractC6033a != null) {
                    abstractC6033a.a(context, z);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6068b
        public void a(PushNotificationBuilder pushNotificationBuilder) {
            for (Map.Entry entry : C5915b.this.c.entrySet()) {
                AbstractC6033a abstractC6033a = (AbstractC6033a) entry.getValue();
                if (abstractC6033a != null) {
                    abstractC6033a.a(pushNotificationBuilder);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6068b
        public void b(Context context, MzPushMessage mzPushMessage) {
            for (Map.Entry entry : C5915b.this.c.entrySet()) {
                AbstractC6033a abstractC6033a = (AbstractC6033a) entry.getValue();
                if (abstractC6033a != null) {
                    abstractC6033a.b(context, mzPushMessage);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6068b
        public void b(Context context, String str) {
            for (Map.Entry entry : C5915b.this.c.entrySet()) {
                AbstractC6033a abstractC6033a = (AbstractC6033a) entry.getValue();
                if (abstractC6033a != null) {
                    abstractC6033a.b(context, str);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6068b
        public void c(Context context, MzPushMessage mzPushMessage) {
            for (Map.Entry entry : C5915b.this.c.entrySet()) {
                AbstractC6033a abstractC6033a = (AbstractC6033a) entry.getValue();
                if (abstractC6033a != null) {
                    abstractC6033a.c(context, mzPushMessage);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6068b
        public void c(Context context, String str) {
            for (Map.Entry entry : C5915b.this.c.entrySet()) {
                AbstractC6033a abstractC6033a = (AbstractC6033a) entry.getValue();
                if (abstractC6033a != null) {
                    abstractC6033a.c(context, str);
                }
            }
        }
    }

    public C5915b(Context context) {
        this(context, null);
    }

    public C5915b(Context context, List<InterfaceC6069c> list) {
        this(context, list, null);
    }

    public C5915b(Context context, List<InterfaceC6069c> list, AbstractC6033a abstractC6033a) {
        this.a = new SparseArray<>();
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        Context applicationContext = context.getApplicationContext();
        this.c = new HashMap();
        C5916a c5916a = new C5916a();
        if (PushConstants.PUSH_PACKAGE_NAME.equalsIgnoreCase(applicationContext.getPackageName())) {
            this.d = new C6065a(applicationContext);
            if (MinSdkChecker.isSupportNotificationSort()) {
                this.e = new C6035a(applicationContext);
            }
        }
        if (list != null) {
            a(list);
            return;
        }
        a(new C6039c(applicationContext, c5916a));
        a(new C6036b(applicationContext, c5916a));
        a(new C6057e(applicationContext, c5916a));
        a(new C6052b(applicationContext, c5916a));
        a(new C6050d(applicationContext, c5916a));
        a(new C6064f(applicationContext, c5916a));
        a(new C6054d(applicationContext, c5916a));
        a(new C6058a(applicationContext, c5916a));
        a(new C6060c(applicationContext, c5916a));
        a(new C6063f(applicationContext, c5916a));
        a(new C6061d(applicationContext, c5916a));
        a(new C6062e(applicationContext, c5916a));
        a(new C6067c(applicationContext, c5916a));
        a(new C6059b(applicationContext, c5916a));
        a(new C6055e(applicationContext, c5916a));
        a(new C6037a(applicationContext, c5916a));
        a(new C6051a(applicationContext, c5916a));
        a(new C6056f(applicationContext, c5916a));
        a(new C6066b(applicationContext, c5916a));
        a(new C6053c(applicationContext, c5916a));
    }

    public static C5915b a(Context context) {
        if (b == null) {
            synchronized (C5915b.class) {
                if (b == null) {
                    DebugLogger.i("PushMessageProxy", "PushMessageProxy init");
                    b = new C5915b(context);
                }
            }
        }
        return b;
    }

    public C5915b a(InterfaceC6069c interfaceC6069c) {
        this.a.put(interfaceC6069c.a(), interfaceC6069c);
        return this;
    }

    public C5915b a(String str, AbstractC6033a abstractC6033a) {
        this.c.put(str, abstractC6033a);
        return this;
    }

    public C5915b a(List<InterfaceC6069c> list) {
        if (list != null) {
            for (InterfaceC6069c interfaceC6069c : list) {
                a(interfaceC6069c);
            }
            return this;
        }
        throw new IllegalArgumentException("messageManagerList must not be null.");
    }

    public C6065a a() {
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

    public C6035a b() {
        return this.e;
    }
}
