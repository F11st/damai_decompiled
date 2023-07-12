package com.alibaba.security.common.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class i {
    static final int a = 1;
    private static final String b = "LocalBroadcastManager";
    private static final boolean c = false;
    private static final Object i = new Object();
    private static i j;
    private final Context d;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> e = new HashMap<>();
    private final HashMap<String, ArrayList<b>> f = new HashMap<>();
    private final ArrayList<a> g = new ArrayList<>();
    private final c h = new c(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class a {
        final Intent a;
        final ArrayList<b> b;

        a(Intent intent, ArrayList<b> arrayList) {
            this.a = intent;
            this.b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class b {
        final IntentFilter a;
        final BroadcastReceiver b;
        boolean c;

        b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
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
    /* loaded from: classes8.dex */
    public static class c extends Handler {
        private final i a;

        public c(i iVar) {
            super(Looper.getMainLooper());
            this.a = iVar;
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

    private i(Context context) {
        this.d = context;
    }

    private void b(Intent intent) {
        if (a(intent)) {
            b();
        }
    }

    public static i a(Context context) {
        i iVar;
        synchronized (i) {
            if (j == null) {
                j = new i(context.getApplicationContext());
            }
            iVar = j;
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int size;
        a[] aVarArr;
        while (true) {
            synchronized (this.e) {
                size = this.g.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new a[size];
                this.g.toArray(aVarArr);
                this.g.clear();
            }
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = aVarArr[i2];
                for (int i3 = 0; i3 < aVar.b.size(); i3++) {
                    aVar.b.get(i3).b.onReceive(this.d, aVar.a);
                }
            }
        }
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.e) {
            b bVar = new b(intentFilter, broadcastReceiver);
            ArrayList<IntentFilter> arrayList = this.e.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.e.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                String action = intentFilter.getAction(i2);
                ArrayList<b> arrayList2 = this.f.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f.put(action, arrayList2);
                }
                arrayList2.add(bVar);
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
                    ArrayList<b> arrayList = this.f.get(action);
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
        ArrayList<b> arrayList2;
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
                com.alibaba.security.common.c.a.f(b, "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<b> arrayList3 = this.f.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    com.alibaba.security.common.c.a.f(b, "Action list: ".concat(String.valueOf(arrayList3)));
                }
                ArrayList arrayList4 = null;
                int i3 = 0;
                while (i3 < arrayList3.size()) {
                    b bVar = arrayList3.get(i3);
                    if (z) {
                        com.alibaba.security.common.c.a.f(b, "Matching against filter " + bVar.a);
                    }
                    if (bVar.c) {
                        if (z) {
                            com.alibaba.security.common.c.a.f(b, "  Filter's target already added");
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
                        if (bVar.a.match(action, resolveTypeIfNeeded, scheme, data, categories, b) >= 0) {
                            if (z) {
                                com.alibaba.security.common.c.a.f(b, "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(bVar);
                            bVar.c = true;
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
                        ((b) arrayList5.get(i4)).c = false;
                    }
                    this.g.add(new a(intent, arrayList5));
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
