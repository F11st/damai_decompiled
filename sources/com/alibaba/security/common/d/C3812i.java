package com.alibaba.security.common.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.security.common.c.C3800a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.common.d.i */
/* loaded from: classes8.dex */
public final class C3812i {
    static final int a = 1;
    private static final String b = "LocalBroadcastManager";
    private static final boolean c = false;
    private static final Object i = new Object();
    private static C3812i j;
    private final Context d;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> e = new HashMap<>();
    private final HashMap<String, ArrayList<C3814b>> f = new HashMap<>();
    private final ArrayList<C3813a> g = new ArrayList<>();
    private final HandlerC3815c h = new HandlerC3815c(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.common.d.i$a */
    /* loaded from: classes8.dex */
    public static class C3813a {
        final Intent a;
        final ArrayList<C3814b> b;

        C3813a(Intent intent, ArrayList<C3814b> arrayList) {
            this.a = intent;
            this.b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.common.d.i$b */
    /* loaded from: classes8.dex */
    public static class C3814b {
        final IntentFilter a;
        final BroadcastReceiver b;
        boolean c;

        C3814b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.a = intentFilter;
            this.b = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.a);
            sb.append("}");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.common.d.i$c */
    /* loaded from: classes8.dex */
    public static class HandlerC3815c extends Handler {
        private final C3812i a;

        public HandlerC3815c(C3812i c3812i) {
            super(Looper.getMainLooper());
            this.a = c3812i;
        }

        @Override // android.os.Handler
        public final void dispatchMessage(Message message) {
            super.dispatchMessage(message);
            if (message.what == 1) {
                this.a.b();
            } else {
                super.handleMessage(message);
            }
        }
    }

    private C3812i(Context context) {
        this.d = context;
    }

    private void b(Intent intent) {
        if (a(intent)) {
            b();
        }
    }

    public static C3812i a(Context context) {
        C3812i c3812i;
        synchronized (i) {
            if (j == null) {
                j = new C3812i(context.getApplicationContext());
            }
            c3812i = j;
        }
        return c3812i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int size;
        C3813a[] c3813aArr;
        while (true) {
            synchronized (this.e) {
                size = this.g.size();
                if (size <= 0) {
                    return;
                }
                c3813aArr = new C3813a[size];
                this.g.toArray(c3813aArr);
                this.g.clear();
            }
            for (int i2 = 0; i2 < size; i2++) {
                C3813a c3813a = c3813aArr[i2];
                for (int i3 = 0; i3 < c3813a.b.size(); i3++) {
                    c3813a.b.get(i3).b.onReceive(this.d, c3813a.a);
                }
            }
        }
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.e) {
            C3814b c3814b = new C3814b(intentFilter, broadcastReceiver);
            ArrayList<IntentFilter> arrayList = this.e.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.e.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                String action = intentFilter.getAction(i2);
                ArrayList<C3814b> arrayList2 = this.f.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f.put(action, arrayList2);
                }
                arrayList2.add(c3814b);
            }
        }
    }

    public final void a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.e) {
            ArrayList<IntentFilter> remove = this.e.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int i2 = 0; i2 < remove.size(); i2++) {
                IntentFilter intentFilter = remove.get(i2);
                for (int i3 = 0; i3 < intentFilter.countActions(); i3++) {
                    String action = intentFilter.getAction(i3);
                    ArrayList<C3814b> arrayList = this.f.get(action);
                    if (arrayList != null) {
                        int i4 = 0;
                        while (i4 < arrayList.size()) {
                            if (arrayList.get(i4).b == broadcastReceiver) {
                                arrayList.remove(i4);
                                i4--;
                            }
                            i4++;
                        }
                        if (arrayList.size() <= 0) {
                            this.f.remove(action);
                        }
                    }
                }
            }
        }
    }

    public final boolean a(Intent intent) {
        int i2;
        String str;
        ArrayList arrayList;
        ArrayList<C3814b> arrayList2;
        String str2;
        int match;
        synchronized (this.e) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.d.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                C3800a.f(b, "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<C3814b> arrayList3 = this.f.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    C3800a.f(b, "Action list: ".concat(String.valueOf(arrayList3)));
                }
                ArrayList arrayList4 = null;
                int i3 = 0;
                while (i3 < arrayList3.size()) {
                    C3814b c3814b = arrayList3.get(i3);
                    if (z) {
                        C3800a.f(b, "Matching against filter " + c3814b.a);
                    }
                    if (c3814b.c) {
                        if (z) {
                            C3800a.f(b, "  Filter's target already added");
                        }
                        i2 = i3;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i2 = i3;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        if (c3814b.a.match(action, resolveTypeIfNeeded, scheme, data, categories, b) >= 0) {
                            if (z) {
                                C3800a.f(b, "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(c3814b);
                            c3814b.c = true;
                            i3 = i2 + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        }
                    }
                    arrayList4 = arrayList;
                    i3 = i2 + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i4 = 0; i4 < arrayList5.size(); i4++) {
                        ((C3814b) arrayList5.get(i4)).c = false;
                    }
                    this.g.add(new C3813a(intent, arrayList5));
                    if (!this.h.hasMessages(1)) {
                        this.h.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public static void a() {
        j = null;
    }
}
