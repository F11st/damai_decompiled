package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cj {
    private static volatile cj a;

    /* renamed from: a  reason: collision with other field name */
    private Context f154a;

    /* renamed from: a  reason: collision with other field name */
    private ci f155a;

    /* renamed from: a  reason: collision with other field name */
    private final HashMap<String, ch> f157a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private ThreadPoolExecutor f158a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<AbstractRunnableC7617a> f156a = new ArrayList<>();

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.cj$a */
    /* loaded from: classes11.dex */
    public static abstract class AbstractRunnableC7617a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        private AbstractRunnableC7617a f160a;

        /* renamed from: a  reason: collision with other field name */
        private String f161a;

        /* renamed from: a  reason: collision with other field name */
        private WeakReference<Context> f162a;
        protected String b;

        /* renamed from: a  reason: collision with other field name */
        protected ch f159a = null;

        /* renamed from: a  reason: collision with other field name */
        private Random f163a = new Random();
        private int a = 0;

        public AbstractRunnableC7617a(String str) {
            this.f161a = str;
        }

        public SQLiteDatabase a() {
            return this.f159a.getWritableDatabase();
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object mo737a() {
            return null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m738a() {
            return this.f161a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Context context) {
            AbstractRunnableC7617a abstractRunnableC7617a = this.f160a;
            if (abstractRunnableC7617a != null) {
                abstractRunnableC7617a.a(context, mo737a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            cj.a(context).a(this);
        }

        void a(ch chVar, Context context) {
            this.f159a = chVar;
            this.b = chVar.a();
            this.f162a = new WeakReference<>(context);
        }

        public void a(AbstractRunnableC7617a abstractRunnableC7617a) {
            this.f160a = abstractRunnableC7617a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m739a() {
            return this.f159a == null || TextUtils.isEmpty(this.b) || this.f162a == null;
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            WeakReference<Context> weakReference = this.f162a;
            if (weakReference == null || (context = weakReference.get()) == null || context.getFilesDir() == null || this.f159a == null || TextUtils.isEmpty(this.f161a)) {
                return;
            }
            File file = new File(this.f161a);
            AbstractRunnableC7790y.a(context, new File(file.getParentFile(), bo.b(file.getAbsolutePath())), new cl(this, context));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.cj$b */
    /* loaded from: classes11.dex */
    public static abstract class AbstractC7618b<T> extends AbstractRunnableC7617a {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        private String f164a;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f165a;

        /* renamed from: a  reason: collision with other field name */
        private String[] f166a;
        private List<T> b;
        private String c;
        private String d;
        private String e;

        public AbstractC7618b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.b = new ArrayList();
            this.f165a = list;
            this.f164a = str2;
            this.f166a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.a = i;
        }

        @Override // com.xiaomi.push.cj.AbstractRunnableC7617a
        public SQLiteDatabase a() {
            return ((AbstractRunnableC7617a) this).f159a.getReadableDatabase();
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.cj.AbstractRunnableC7617a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.b.clear();
            List<String> list = this.f165a;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.f165a.size()];
                this.f165a.toArray(strArr2);
                strArr = strArr2;
            }
            int i = this.a;
            Cursor query = sQLiteDatabase.query(super.b, strArr, this.f164a, this.f166a, this.c, this.d, this.e, i > 0 ? String.valueOf(i) : null);
            if (query != null && query.moveToFirst()) {
                do {
                    T a = a(context, query);
                    if (a != null) {
                        this.b.add(a);
                    }
                } while (query.moveToNext());
                query.close();
            }
            a(context, (List) this.b);
        }

        public abstract void a(Context context, List<T> list);
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.cj$c */
    /* loaded from: classes11.dex */
    public static class C7619c extends AbstractRunnableC7617a {
        private ArrayList<AbstractRunnableC7617a> a;

        public C7619c(String str, ArrayList<AbstractRunnableC7617a> arrayList) {
            super(str);
            ArrayList<AbstractRunnableC7617a> arrayList2 = new ArrayList<>();
            this.a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.cj.AbstractRunnableC7617a
        public final void a(Context context) {
            super.a(context);
            Iterator<AbstractRunnableC7617a> it = this.a.iterator();
            while (it.hasNext()) {
                AbstractRunnableC7617a next = it.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }

        @Override // com.xiaomi.push.cj.AbstractRunnableC7617a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<AbstractRunnableC7617a> it = this.a.iterator();
            while (it.hasNext()) {
                AbstractRunnableC7617a next = it.next();
                if (next != null) {
                    next.a(context, sQLiteDatabase);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.cj$d */
    /* loaded from: classes11.dex */
    public static class C7620d extends AbstractRunnableC7617a {
        private String a;

        /* renamed from: a  reason: collision with other field name */
        protected String[] f167a;

        public C7620d(String str, String str2, String[] strArr) {
            super(str);
            this.a = str2;
            this.f167a = strArr;
        }

        @Override // com.xiaomi.push.cj.AbstractRunnableC7617a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.a, this.f167a);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.cj$e */
    /* loaded from: classes11.dex */
    public static class C7621e extends AbstractRunnableC7617a {
        private ContentValues a;

        public C7621e(String str, ContentValues contentValues) {
            super(str);
            this.a = contentValues;
        }

        @Override // com.xiaomi.push.cj.AbstractRunnableC7617a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.b, null, this.a);
        }
    }

    private cj(Context context) {
        this.f154a = context;
    }

    private ch a(String str) {
        ch chVar = this.f157a.get(str);
        if (chVar == null) {
            synchronized (this.f157a) {
                if (chVar == null) {
                    chVar = this.f155a.a(this.f154a, str);
                    this.f157a.put(str, chVar);
                }
            }
        }
        return chVar;
    }

    public static cj a(Context context) {
        if (a == null) {
            synchronized (cj.class) {
                if (a == null) {
                    a = new cj(context);
                }
            }
        }
        return a;
    }

    private void a() {
        al.a(this.f154a).b(new ck(this), com.xiaomi.push.service.ba.a(this.f154a).a(ho.StatDataProcessFrequency.a(), 5));
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m736a(String str) {
        return a(str).a();
    }

    public void a(AbstractRunnableC7617a abstractRunnableC7617a) {
        ch chVar;
        if (abstractRunnableC7617a == null) {
            return;
        }
        if (this.f155a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m738a = abstractRunnableC7617a.m738a();
        synchronized (this.f157a) {
            chVar = this.f157a.get(m738a);
            if (chVar == null) {
                chVar = this.f155a.a(this.f154a, m738a);
                this.f157a.put(m738a, chVar);
            }
        }
        if (this.f158a.isShutdown()) {
            return;
        }
        abstractRunnableC7617a.a(chVar, this.f154a);
        synchronized (this.f156a) {
            this.f156a.add(abstractRunnableC7617a);
            a();
        }
    }

    public void a(Runnable runnable) {
        if (this.f158a.isShutdown()) {
            return;
        }
        this.f158a.execute(runnable);
    }

    public void a(ArrayList<AbstractRunnableC7617a> arrayList) {
        if (this.f155a == null) {
            throw new IllegalStateException("should exec setDbHelperFactory method first!");
        }
        HashMap hashMap = new HashMap();
        if (this.f158a.isShutdown()) {
            return;
        }
        Iterator<AbstractRunnableC7617a> it = arrayList.iterator();
        while (it.hasNext()) {
            AbstractRunnableC7617a next = it.next();
            if (next.m739a()) {
                next.a(a(next.m738a()), this.f154a);
            }
            ArrayList arrayList2 = (ArrayList) hashMap.get(next.m738a());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                hashMap.put(next.m738a(), arrayList2);
            }
            arrayList2.add(next);
        }
        for (String str : hashMap.keySet()) {
            ArrayList arrayList3 = (ArrayList) hashMap.get(str);
            if (arrayList3 != null && arrayList3.size() > 0) {
                C7619c c7619c = new C7619c(str, arrayList3);
                c7619c.a(((AbstractRunnableC7617a) arrayList3.get(0)).f159a, this.f154a);
                this.f158a.execute(c7619c);
            }
        }
    }

    public void b(AbstractRunnableC7617a abstractRunnableC7617a) {
        ch chVar;
        if (abstractRunnableC7617a == null) {
            return;
        }
        if (this.f155a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m738a = abstractRunnableC7617a.m738a();
        synchronized (this.f157a) {
            chVar = this.f157a.get(m738a);
            if (chVar == null) {
                chVar = this.f155a.a(this.f154a, m738a);
                this.f157a.put(m738a, chVar);
            }
        }
        if (this.f158a.isShutdown()) {
            return;
        }
        abstractRunnableC7617a.a(chVar, this.f154a);
        a((Runnable) abstractRunnableC7617a);
    }
}
