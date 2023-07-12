package com.taobao.android.dinamic.tempate;

import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.taobao.android.dinamic.log.DinamicLog;
import com.taobao.weex.annotation.JSMethod;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import tb.rc0;
import tb.ul2;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SerialTaskManager {
    final ArrayDeque<DownLoadTask> a = new ArrayDeque<>();
    private volatile DownLoadTask b;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static final class DownLoadTask extends AsyncTask<Void, rc0, rc0> {
        private final com.taobao.android.dinamic.tempate.manager.a a;
        LayoutFileLoadListener b;
        List<DinamicTemplate> c;
        String d;
        private SerialTaskManager e;
        private Timer f;
        private long g;
        private volatile boolean h;
        private ArrayList<DinamicTemplate> i = new ArrayList<>();
        private ArrayList<DinamicTemplate> j = new ArrayList<>();
        private ArrayList<DinamicTemplate> k = new ArrayList<>();
        private ArrayList<DinamicTemplate> l = new ArrayList<>();
        private ArrayList<DinamicTemplate> m = new ArrayList<>();
        private TimerTask n = new TimerTask() { // from class: com.taobao.android.dinamic.tempate.SerialTaskManager.DownLoadTask.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                synchronized (DownLoadTask.this) {
                    if (DownLoadTask.this.h) {
                        return;
                    }
                    try {
                        if (DownLoadTask.this.i.size() > 0 || DownLoadTask.this.j.size() > 0) {
                            DownLoadTask downLoadTask = DownLoadTask.this;
                            downLoadTask.publishProgress(downLoadTask.g());
                            DownLoadTask.this.i.clear();
                            DownLoadTask.this.j.clear();
                        }
                    } catch (Exception e) {
                        DinamicLog.c("SerialTaskManager", e, "callback onFinished is error");
                    }
                }
            }
        };

        public DownLoadTask(com.taobao.android.dinamic.tempate.manager.a aVar, int i) {
            this.g = 3000L;
            this.a = aVar;
            this.g = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public rc0 g() {
            rc0 rc0Var = new rc0();
            rc0Var.a = (ArrayList) this.i.clone();
            rc0Var.b = (ArrayList) this.j.clone();
            ArrayList arrayList = (ArrayList) this.k.clone();
            ArrayList arrayList2 = (ArrayList) this.l.clone();
            ArrayList arrayList3 = (ArrayList) this.m.clone();
            return rc0Var;
        }

        private a h(@Nullable DinamicTemplate dinamicTemplate) {
            String j = j(dinamicTemplate);
            if (!TextUtils.isEmpty(j) && this.a.f(j) == null) {
                a aVar = new a();
                aVar.a = j;
                aVar.b = dinamicTemplate.templateUrl;
                aVar.c = dinamicTemplate;
                return aVar;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: i */
        public rc0 doInBackground(Void... voidArr) {
            byte[] bArr;
            List<DinamicTemplate> list = this.c;
            if (list != null && !list.isEmpty()) {
                HashSet hashSet = new HashSet();
                for (DinamicTemplate dinamicTemplate : this.c) {
                    if (dinamicTemplate != null && !TextUtils.isEmpty(dinamicTemplate.templateUrl) && !TextUtils.isEmpty(dinamicTemplate.name) && !TextUtils.isEmpty(dinamicTemplate.version)) {
                        a h = h(dinamicTemplate);
                        if (h == null) {
                            this.m.add(dinamicTemplate);
                        } else {
                            hashSet.add(h);
                        }
                    } else {
                        this.j.add(dinamicTemplate);
                        this.l.add(dinamicTemplate);
                    }
                }
                if (!hashSet.isEmpty()) {
                    Timer timer = new Timer();
                    this.f = timer;
                    TimerTask timerTask = this.n;
                    long j = this.g;
                    timer.schedule(timerTask, j, j);
                    ArrayList arrayList = new ArrayList(hashSet);
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        a aVar = (a) arrayList.get(i);
                        try {
                            bArr = this.a.b(aVar.c, aVar.a, aVar.b, new ul2(this.d));
                        } catch (Throwable th) {
                            DinamicLog.b("SerialTaskManager", "remote getTemplate", th);
                            bArr = null;
                        }
                        synchronized (this) {
                            if (bArr == null) {
                                this.l.add(aVar.c);
                                this.j.add(aVar.c);
                            } else {
                                this.k.add(aVar.c);
                                this.i.add(aVar.c);
                            }
                            if (i == size - 1) {
                                this.h = true;
                                this.f.cancel();
                            }
                        }
                    }
                } else {
                    this.h = true;
                }
                return g();
            }
            this.h = true;
            return g();
        }

        String j(DinamicTemplate dinamicTemplate) {
            return dinamicTemplate.name + JSMethod.NOT_SET + dinamicTemplate.version;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: k */
        public void onPostExecute(rc0 rc0Var) {
            try {
                try {
                    this.b.onFinished(rc0Var);
                } catch (Exception e) {
                    DinamicLog.c("SerialTaskManager", e, "callback onFinished is error");
                }
            } finally {
                this.e.c();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: l */
        public void onProgressUpdate(rc0... rc0VarArr) {
            try {
                this.b.onFinished(rc0VarArr[0]);
            } catch (Exception e) {
                DinamicLog.c("SerialTaskManager", e, "callback onFinished is error");
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface LayoutFileLoadListener {
        void onFinished(rc0 rc0Var);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static final class a {
        public String a;
        public String b;
        public DinamicTemplate c;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            return TextUtils.equals(this.a, ((a) obj).a);
        }

        public int hashCode() {
            String str = this.a;
            if (str == null) {
                return -1;
            }
            return str.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        DownLoadTask poll = this.a.poll();
        this.b = poll;
        if (poll != null) {
            this.b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public synchronized void b(DownLoadTask downLoadTask) {
        downLoadTask.e = this;
        this.a.offer(downLoadTask);
        if (this.b == null) {
            c();
        }
    }
}
