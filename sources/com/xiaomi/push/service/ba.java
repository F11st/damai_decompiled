package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.xiaomi.push.ho;
import com.xiaomi.push.hp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ba {
    private static volatile ba a;

    /* renamed from: a  reason: collision with other field name */
    protected SharedPreferences f912a;

    /* renamed from: a  reason: collision with other field name */
    private HashSet<a> f913a = new HashSet<>();
    protected SharedPreferences b;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static abstract class a implements Runnable {
        private String mDescription;
        private int mId;

        public a(int i, String str) {
            this.mId = i;
            this.mDescription = str;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.mId == ((a) obj).mId;
        }

        public int hashCode() {
            return this.mId;
        }

        protected abstract void onCallback();

        @Override // java.lang.Runnable
        public final void run() {
            onCallback();
        }
    }

    private ba(Context context) {
        this.f912a = context.getSharedPreferences("mipush_oc_normal", 0);
        this.b = context.getSharedPreferences("mipush_oc_custom", 0);
    }

    public static ba a(Context context) {
        if (a == null) {
            synchronized (ba.class) {
                if (a == null) {
                    a = new ba(context);
                }
            }
        }
        return a;
    }

    private String a(int i) {
        return "oc_" + i;
    }

    private String a(hp hpVar) {
        return "oc_version_" + hpVar.a();
    }

    private void a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        Object obj = pair.second;
        if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
        } else if (!(obj instanceof String)) {
            if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
            }
        } else {
            String str2 = (String) obj;
            if (str.equals(a(ho.AppIsInstalledList.a()))) {
                str2 = com.xiaomi.push.bm.a(str2);
            }
            editor.putString(str, str2);
        }
    }

    public int a(int i, int i2) {
        try {
            String a2 = a(i);
            return this.b.contains(a2) ? this.b.getInt(a2, 0) : this.f912a.contains(a2) ? this.f912a.getInt(a2, 0) : i2;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m586a(i + " oc int error " + e);
            return i2;
        }
    }

    public int a(hp hpVar, int i) {
        try {
            return this.f912a.getInt(a(hpVar), i);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m586a(hpVar + " version error " + e);
            return i;
        }
    }

    public long a(int i, long j) {
        try {
            String a2 = a(i);
            return this.b.contains(a2) ? this.b.getLong(a2, 0L) : this.f912a.contains(a2) ? this.f912a.getLong(a2, 0L) : j;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m586a(i + " oc long error " + e);
            return j;
        }
    }

    public String a(int i, String str) {
        try {
            String a2 = a(i);
            return this.b.contains(a2) ? this.b.getString(a2, null) : this.f912a.contains(a2) ? this.f912a.getString(a2, null) : str;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m586a(i + " oc string error " + e);
            return str;
        }
    }

    public synchronized void a() {
        this.f913a.clear();
    }

    public synchronized void a(a aVar) {
        if (!this.f913a.contains(aVar)) {
            this.f913a.add(aVar);
        }
    }

    public void a(List<Pair<Integer, Object>> list) {
        if (com.xiaomi.push.ag.a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.b.edit();
        for (Pair<Integer, Object> pair : list) {
            Object obj = pair.first;
            if (obj != null) {
                String a2 = a(((Integer) obj).intValue());
                if (pair.second == null) {
                    edit.remove(a2);
                } else {
                    a(edit, pair, a2);
                }
            }
        }
        edit.apply();
    }

    public void a(List<Pair<hp, Integer>> list, List<Pair<Integer, Object>> list2) {
        if (com.xiaomi.push.ag.a(list) || com.xiaomi.push.ag.a(list2)) {
            com.xiaomi.channel.commonutils.logger.b.m586a("not update oc, because versions or configs are empty");
            return;
        }
        SharedPreferences.Editor edit = this.f912a.edit();
        edit.clear();
        for (Pair<hp, Integer> pair : list) {
            Object obj = pair.first;
            if (obj != null && pair.second != null) {
                edit.putInt(a((hp) obj), ((Integer) pair.second).intValue());
            }
        }
        for (Pair<Integer, Object> pair2 : list2) {
            Object obj2 = pair2.first;
            if (obj2 != null && pair2.second != null) {
                a(edit, pair2, a(((Integer) obj2).intValue()));
            }
        }
        edit.apply();
    }

    public boolean a(int i, boolean z) {
        try {
            String a2 = a(i);
            return this.b.contains(a2) ? this.b.getBoolean(a2, false) : this.f912a.contains(a2) ? this.f912a.getBoolean(a2, false) : z;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m586a(i + " oc boolean error " + e);
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        com.xiaomi.channel.commonutils.logger.b.c("OC_Callback : receive new oc data");
        HashSet hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.f913a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.run();
            }
        }
        hashSet.clear();
    }
}
