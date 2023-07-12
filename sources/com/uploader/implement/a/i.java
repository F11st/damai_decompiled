package com.uploader.implement.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.uploader.export.ITaskListener;
import com.uploader.export.ITaskResult;
import com.uploader.export.IUploaderTask;
import com.uploader.implement.a.c.a;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.android.agoo.message.MessageService;
import org.json.JSONException;
import tb.d53;
import tb.h33;
import tb.h43;
import tb.i33;
import tb.i83;
import tb.k33;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class i extends com.uploader.implement.a.a {
    private ArrayList<Pair<Integer, Integer>> e;
    private long f;
    private int g;
    private int h;
    private e i;
    private String j;
    private com.uploader.implement.a.c k;
    private volatile h43 l;
    private final IUploaderTask m;
    private final ITaskListener n;
    private final Handler o;
    private final int p;
    private final com.uploader.implement.c q;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static final class a implements Handler.Callback {
        static final int c = a.class.hashCode();
        private final WeakReference<com.uploader.implement.d.b> a;
        private final WeakReference<com.uploader.implement.a.a> b;

        a(com.uploader.implement.a.a aVar, com.uploader.implement.d.b bVar) {
            this.b = new WeakReference<>(aVar);
            this.a = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            com.uploader.implement.d.b bVar;
            com.uploader.implement.a.a aVar;
            if (message.what != c || (bVar = this.a.get()) == null || (aVar = this.b.get()) == null) {
                return false;
            }
            aVar.i(bVar, (k33) message.obj);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b implements ITaskResult {
        private Map<String, String> a;
        private String b;
        private String c;

        public b(Map<String, String> map, String str, String str2) {
            this.a = map;
            this.c = str;
            this.b = str2;
        }

        @Override // com.uploader.export.ITaskResult
        public String getBizResult() {
            return this.b;
        }

        @Override // com.uploader.export.ITaskResult
        public String getFileUrl() {
            return this.c;
        }

        @Override // com.uploader.export.ITaskResult
        public Map<String, String> getResult() {
            return this.a;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static final class c implements Runnable {
        final Handler.Callback a;
        private final WeakReference<i> b;
        private final WeakReference<Looper> c = new WeakReference<>(Looper.myLooper());

        c(i iVar, Handler.Callback callback) {
            this.b = new WeakReference<>(iVar);
            this.a = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar = this.b.get();
            Looper looper = this.c.get();
            if (looper == null || iVar == null) {
                return;
            }
            new Handler(looper, this.a).obtainMessage(a.c, iVar.E()).sendToTarget();
        }
    }

    public i(com.uploader.implement.c cVar, IUploaderTask iUploaderTask, int i, ITaskListener iTaskListener, Handler handler) {
        super(cVar.c);
        this.e = new ArrayList<>();
        this.q = cVar;
        this.m = iUploaderTask;
        this.n = iTaskListener;
        this.o = handler;
        this.p = i;
    }

    k33 A(com.uploader.implement.d.b bVar, @Nullable e eVar, boolean z) {
        long j;
        long j2;
        long j3 = this.f;
        long j4 = this.l.f - this.f;
        if (j4 < 0) {
            j = this.l.f;
            j2 = 0;
        } else {
            j = j3;
            j2 = j4;
        }
        try {
            d53 d53Var = new d53(this.q, this.l, j == 0 ? "put" : "patch", j, j2, true);
            if (eVar == null) {
                bVar.a(d53Var);
            } else {
                bVar.a(eVar, d53Var, z);
            }
            com.uploader.implement.b.a.f a2 = d53Var.a();
            com.uploader.implement.a.c cVar = new com.uploader.implement.a.c(false, this.k);
            this.k = cVar;
            cVar.d = this.l.e;
            this.k.p = this.l.d;
            this.k.q = (String) this.q.a.a().first;
            com.uploader.implement.a.c cVar2 = this.k;
            cVar2.e = a2.a;
            cVar2.f = a2.b;
            cVar2.k = this.l.f;
            this.k.t = a2.f ? 1 : 0;
            if (com.uploader.implement.a.d(8)) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.a);
                sb.append(" beginFile, request:");
                sb.append(eVar == null ? "" : Integer.valueOf(eVar.hashCode()));
                sb.append(" newRequest:");
                sb.append(Integer.valueOf(d53Var.hashCode()));
                sb.append(" statistics:");
                sb.append(this.k.hashCode());
                com.uploader.implement.a.a(8, "UploaderAction", sb.toString());
                return null;
            }
            return null;
        } catch (UnsupportedEncodingException e) {
            if (com.uploader.implement.a.d(16)) {
                com.uploader.implement.a.b(16, "UploaderAction", this.a + " onActionStartFile", e);
            }
            return new k33("200", "1", e.toString(), false);
        } catch (Exception e2) {
            if (com.uploader.implement.a.d(16)) {
                com.uploader.implement.a.b(16, "UploaderAction", this.a + " onActionStartFile", e2);
            }
            return new k33("200", "5", e2.toString(), false);
        }
    }

    Pair<k33, ? extends Object> B(i33 i33Var) {
        String b2 = i33Var.b("x-arup-process");
        if (com.uploader.implement.a.d(4)) {
            com.uploader.implement.a.a(4, "UploaderAction", this.a + " progress :" + b2);
        }
        int i = 0;
        try {
            i = Integer.parseInt(b2);
        } catch (Exception e) {
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.b(8, "UploaderAction", this.a + "", e);
            }
        }
        return new Pair<>(null, Integer.valueOf(i));
    }

    k33 C(com.uploader.implement.d.b bVar, e eVar, k33 k33Var) {
        if (this.h >= 5) {
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderAction", this.a + " retryFile, retry failed, request:" + eVar.hashCode() + " error:" + k33Var + " fileRetryCounter:" + this.h);
            }
            return k33Var;
        }
        if (MessageService.MSG_DB_COMPLETE.equalsIgnoreCase(k33Var.a)) {
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderAction", this.a + " retryFile, try to connect next, request:" + eVar.hashCode());
            }
            this.q.a.h();
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderAction", this.a + " ConnectionStrategy, after nextUploadTarget:" + this.q.a.toString());
            }
        }
        k33 A = A(bVar, eVar, false);
        if (A == null) {
            this.h++;
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderAction", this.a + " retryFile, request:" + eVar.hashCode() + " fileRetryCounter:" + this.h);
            }
            com.uploader.implement.a.c cVar = this.k;
            if (cVar != null) {
                cVar.r = this.h;
            }
        }
        return A;
    }

    Pair<k33, ? extends Object> D(i33 i33Var) {
        try {
            Object[] objArr = i33Var.c;
            this.q.a.d((String) objArr[0], ((Long) objArr[1]).longValue(), (List) objArr[2], (List) objArr[3]);
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderAction", this.a + " ConnectionStrategy update:" + this.q.a.toString());
            }
            com.uploader.implement.a.c cVar = this.k;
            if (cVar != null) {
                cVar.g = 1;
                cVar.q = (String) this.q.a.a().first;
                this.k.m = System.currentTimeMillis();
                this.j = "Declare" + this.k.a();
                if (com.uploader.implement.a.d(8)) {
                    com.uploader.implement.a.a(8, "UploaderAction", this.a + " retrieveDeclare, statistics:" + this.k.hashCode() + " costTimeMillisEnd:" + this.k.m);
                }
            }
            return new Pair<>(null, null);
        } catch (Exception e) {
            if (com.uploader.implement.a.d(4)) {
                com.uploader.implement.a.a(4, "UploaderAction", e.toString());
            }
            return new Pair<>(new k33("200", "8", e.toString(), true), null);
        }
    }

    k33 E() {
        long currentTimeMillis = System.currentTimeMillis();
        Pair<k33, h43> a2 = com.uploader.implement.a.c.b.a(this.m);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        Object obj = a2.second;
        if (obj != null) {
            ((h43) obj).i = currentTimeMillis2;
            this.l = (h43) obj;
        }
        if (com.uploader.implement.a.d(8)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" createFileDescription, elapsed:");
            sb.append(currentTimeMillis2);
            sb.append(" error:");
            Object obj2 = a2.first;
            sb.append(obj2 == null ? "" : ((k33) obj2).toString());
            com.uploader.implement.a.a(8, "UploaderAction", sb.toString());
        }
        return (k33) a2.first;
    }

    @NonNull
    public final IUploaderTask F() {
        return this.m;
    }

    public final int G() {
        return this.p;
    }

    @Override // com.uploader.implement.d.a
    public void a(com.uploader.implement.d.b bVar, e eVar, int i) {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderAction", this.a + " onUploading, session:" + bVar.hashCode() + " request:" + eVar.hashCode() + " fileSizeSent:" + i + ", sendOffset=" + this.f);
        }
        long j = i + eVar.b().c;
        this.f = j;
        com.uploader.implement.a.c cVar = this.k;
        if (cVar != null) {
            cVar.b = j;
        }
    }

    @Override // com.uploader.implement.a.a
    Pair<k33, ? extends Object> b(com.uploader.implement.d.b bVar, e eVar, i33 i33Var) {
        String b2;
        if (this.k != null && (b2 = i33Var.b("divided_length")) != null) {
            try {
                this.k.c += Integer.parseInt(b2);
            } catch (Exception e) {
                if (com.uploader.implement.a.d(2)) {
                    com.uploader.implement.a.a(2, "UploaderAction", this.a + e.toString());
                }
            }
        }
        switch (i33Var.a()) {
            case 1:
                return D(i33Var);
            case 2:
                return B(i33Var);
            case 3:
                return v(bVar, eVar, i33Var);
            case 4:
                return y(i33Var);
            case 5:
                return w(i33Var);
            case 6:
                return u(i33Var);
            default:
                return null;
        }
    }

    @Override // com.uploader.implement.a.a
    k33 c(com.uploader.implement.d.b bVar, e eVar, Pair<Integer, Integer> pair) {
        if (this.i != null) {
            this.e.add(pair);
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderAction", this.a + " onActionContinue, add offset, session:" + bVar.hashCode());
            }
            return null;
        }
        try {
            d53 d53Var = new d53(this.q, this.l, "patch", ((Integer) pair.first).intValue(), ((Integer) pair.second).intValue(), false);
            bVar.a(eVar, d53Var, true);
            if (com.uploader.implement.a.d(4)) {
                com.uploader.implement.a.a(4, "UploaderAction", this.a + " onActionContinue, session:" + bVar.hashCode() + " send request:" + d53Var.hashCode());
                return null;
            }
            return null;
        } catch (UnsupportedEncodingException e) {
            if (com.uploader.implement.a.d(16)) {
                com.uploader.implement.a.b(16, "UploaderAction", this.a + " onActionContinue", e);
            }
            return new k33("200", "1", e.toString(), false);
        } catch (Exception e2) {
            if (com.uploader.implement.a.d(16)) {
                com.uploader.implement.a.b(16, "UploaderAction", this.a + " onActionContinue", e2);
            }
            return new k33("200", "5", e2.toString(), false);
        }
    }

    @Override // com.uploader.implement.a.a
    k33 d(com.uploader.implement.d.b bVar, e eVar, k33 k33Var) {
        com.uploader.implement.a.c cVar = this.k;
        if (cVar != null) {
            cVar.m = System.currentTimeMillis();
        }
        if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "UploaderAction", this.a + " onActionRetry, session:" + bVar.hashCode() + " request:" + eVar.hashCode());
        }
        if (o() == 2) {
            return C(bVar, eVar, k33Var);
        }
        return z(bVar, eVar, k33Var);
    }

    @Override // com.uploader.implement.a.a
    k33 e(com.uploader.implement.d.b bVar, @Nullable e eVar, boolean z) {
        if (o() == 2) {
            return A(bVar, eVar, z);
        }
        return x(bVar, eVar, z);
    }

    @Override // com.uploader.implement.a.a
    void f() {
        this.i = null;
        this.e.clear();
    }

    @Override // com.uploader.implement.a.a
    void g(int i, Object obj) {
        com.uploader.implement.a.b.a(this.o, i, this.m, this.n, obj);
        if (this.k == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "UploaderAction", this.a + " onActionNotify, notifyType:" + i + " statistics:" + this.k.hashCode() + " costTimeMillisEnd:" + currentTimeMillis);
        }
        if (i == 1) {
            com.uploader.implement.a.c cVar = this.k;
            cVar.g = 2;
            cVar.m = currentTimeMillis;
            cVar.a();
            this.k = null;
        } else if (i != 2) {
            if (i != 7) {
                return;
            }
            this.k.m = currentTimeMillis;
        } else {
            k33 k33Var = (k33) obj;
            com.uploader.implement.a.c cVar2 = this.k;
            cVar2.g = 0;
            cVar2.h = k33Var.a;
            cVar2.i = k33Var.b;
            cVar2.j = k33Var.c;
            cVar2.m = currentTimeMillis;
            cVar2.a();
            this.k = null;
        }
    }

    @Override // com.uploader.implement.a.a
    boolean l(com.uploader.implement.d.b bVar) {
        boolean z = this.l == null;
        if (z) {
            com.uploader.implement.e.b.a(new c(this, new a(this, bVar)));
        }
        return z;
    }

    @Override // com.uploader.implement.a.a
    boolean n() {
        Pair<String, Long> a2 = this.q.a.a();
        return a2 != null && this.q.a.i() + (System.currentTimeMillis() / 1000) < ((Long) a2.second).longValue();
    }

    Pair<k33, ? extends Object> u(i33 i33Var) {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderAction", this.a + " retrieveStatus ,response=" + i33Var);
        }
        String b2 = i33Var.b("x-arup-session-status");
        if (!TextUtils.isEmpty(b2)) {
            return new Pair<>(null, b2);
        }
        return new Pair<>(null, null);
    }

    Pair<k33, ? extends Object> v(com.uploader.implement.d.b bVar, e eVar, i33 i33Var) {
        String b2 = i33Var.b("x-arup-offset");
        if (TextUtils.isEmpty(b2)) {
            return new Pair<>(new k33("200", "7", "onReceiveOffset:1", true), null);
        }
        int indexOf = b2.indexOf("=");
        if (indexOf == -1) {
            return new Pair<>(new k33("200", "7", "onReceiveOffset:2", true), null);
        }
        if (!this.l.d.equals(b2.substring(0, indexOf))) {
            return new Pair<>(new k33("200", "7", "onReceiveOffset:3", true), null);
        }
        int indexOf2 = b2.indexOf(",");
        int i = indexOf + 1;
        if (indexOf2 > i && indexOf2 < b2.length()) {
            try {
                return new Pair<>(null, new Pair(Integer.valueOf(Integer.parseInt(b2.substring(i, indexOf2))), Integer.valueOf(Integer.parseInt(b2.substring(indexOf2 + 1, b2.length())))));
            } catch (Exception e) {
                if (com.uploader.implement.a.d(16)) {
                    com.uploader.implement.a.b(16, "UploaderAction", this.a + " parse offset error.", e);
                }
                return new Pair<>(new k33("200", "7", e.toString(), true), null);
            }
        }
        return new Pair<>(new k33("200", "7", "onReceiveOffset:4", true), null);
    }

    Pair<k33, ? extends Object> w(i33 i33Var) {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderAction", this.a + " onReceiveError ,response=" + i33Var);
        }
        String b2 = i33Var.b("x-arup-error-code");
        String b3 = i33Var.b("x-arup-error-msg");
        String b4 = i33Var.b("x-arup-server-timestamp");
        if (!TextUtils.isEmpty(b4)) {
            try {
                this.q.a.c(Long.parseLong(b4));
            } catch (Exception e) {
                if (com.uploader.implement.a.d(2)) {
                    com.uploader.implement.a.a(2, "UploaderAction", this.a + " retrieveError " + e);
                }
                b3 = b3 + " " + e.toString();
            }
        }
        if (a.InterfaceC0353a.C0354a.a.contains(b2)) {
            return new Pair<>(new k33("300", b2, b3, true), null);
        }
        if (!"20021".equalsIgnoreCase(b2) && !"20022".equalsIgnoreCase(b2) && !"20020".equalsIgnoreCase(b2)) {
            return new Pair<>(new k33("300", b2, b3, false), null);
        }
        return new Pair<>(new k33("300", "2", b3, true), null);
    }

    k33 x(com.uploader.implement.d.b bVar, @Nullable e eVar, boolean z) {
        try {
            h33 h33Var = new h33(this.q);
            if (eVar == null) {
                bVar.a(h33Var);
            } else {
                bVar.a(eVar, h33Var, z);
            }
            com.uploader.implement.b.a.g a2 = h33Var.a();
            com.uploader.implement.a.c cVar = new com.uploader.implement.a.c(true, this.k);
            this.k = cVar;
            cVar.d = this.l.e;
            this.k.p = this.l.d;
            com.uploader.implement.a.c cVar2 = this.k;
            cVar2.e = a2.a;
            cVar2.f = a2.b;
            cVar2.k = this.l.f;
            this.k.s = this.l.i;
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderAction", this.a + " beginDeclare statistics create:" + this.k.hashCode());
                return null;
            }
            return null;
        } catch (JSONException e) {
            if (com.uploader.implement.a.d(16)) {
                com.uploader.implement.a.b(16, "UploaderAction", this.a + " onActionBegin", e);
            }
            return new k33("200", "1", e.toString(), false);
        } catch (Exception e2) {
            if (com.uploader.implement.a.d(16)) {
                com.uploader.implement.a.b(16, "UploaderAction", this.a + " onActionBegin", e2);
            }
            return new k33("200", "5", e2.toString(), false);
        }
    }

    Pair<k33, ? extends Object> y(i33 i33Var) {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderAction", this.a + " onReceiveResult ,response=" + i33Var.c());
        }
        if (!this.l.d.equals(i33Var.b("x-arup-file-id"))) {
            return new Pair<>(new k33("300", "1", "fileId!=", true), null);
        }
        b bVar = new b(i33Var.c(), i33Var.b("x-arup-file-url"), i33Var.b("x-arup-biz-ret"));
        com.uploader.implement.a.c cVar = this.k;
        if (cVar != null) {
            cVar.g = 1;
            cVar.m = System.currentTimeMillis();
            this.j += ", File" + this.k.a();
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderAction", this.a + " retrieveResult, statistics:" + this.k.hashCode() + " costTimeMillisEnd:" + this.k.m);
            }
        }
        Map<String, String> result = bVar.getResult();
        if (result != null) {
            result.put("", this.j);
        }
        return new Pair<>(null, bVar);
    }

    k33 z(com.uploader.implement.d.b bVar, e eVar, k33 k33Var) {
        if (this.g >= 4) {
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderAction", this.a + " retryDeclare, retry failed, request:" + eVar.hashCode() + " error:" + k33Var + " declareRetryCounter:" + this.g);
            }
            return k33Var;
        }
        if (MessageService.MSG_DB_COMPLETE.equalsIgnoreCase(k33Var.a) || "400".equalsIgnoreCase(k33Var.a)) {
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderAction", this.a + " onActionRetry, try to connect next, request:" + eVar.hashCode());
            }
            this.q.a.f();
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderAction", this.a + " ConnectionStrategy, after nextDeclareTarget:" + this.q.a.toString());
            }
        }
        k33 x = x(bVar, eVar, false);
        if (x == null) {
            this.g++;
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderAction", this.a + " onActionRetry, retry, request:" + eVar.hashCode() + " declareRetryCounter:" + this.g);
            }
            com.uploader.implement.a.c cVar = this.k;
            if (cVar != null) {
                cVar.r = this.g;
            }
        }
        return x;
    }

    @Override // com.uploader.implement.d.a
    public void e(com.uploader.implement.d.b bVar, e eVar) {
        long j;
        String str;
        com.uploader.implement.a.c cVar = this.k;
        if (cVar == null || cVar.l != 0) {
            j = 0;
        } else {
            j = System.currentTimeMillis();
            this.k.l = j;
        }
        this.i = eVar;
        if (com.uploader.implement.a.d(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" onSendBegin, session:");
            sb.append(bVar.hashCode());
            sb.append(" request and set current:");
            sb.append(eVar.hashCode());
            if (j == 0) {
                str = "";
            } else {
                str = " statistics:" + this.k.hashCode() + " costTimeMillisStart:" + j;
            }
            sb.append(str);
            com.uploader.implement.a.a(2, "UploaderAction", sb.toString());
        }
    }

    @Override // com.uploader.implement.a.a
    Pair<Integer, Integer> a(com.uploader.implement.d.b bVar, e eVar) {
        if (com.uploader.implement.a.d(4)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" onActionDeliver, session:");
            sb.append(bVar.hashCode());
            sb.append(" request:");
            sb.append(eVar.hashCode());
            sb.append(" currentRequest:");
            e eVar2 = this.i;
            sb.append(eVar2 == null ? "null" : Integer.valueOf(eVar2.hashCode()));
            com.uploader.implement.a.a(4, "UploaderAction", sb.toString());
        }
        if (this.k != null) {
            i83 b2 = eVar.b();
            byte[] bArr = b2.f;
            int length = bArr == null ? 0 : bArr.length;
            byte[] bArr2 = b2.g;
            this.k.b = b2.d + length + (bArr2 == null ? 0 : bArr2.length);
        }
        if (this.i != eVar) {
            return null;
        }
        this.i = null;
        if (this.e.size() > 0) {
            return this.e.remove(0);
        }
        return null;
    }

    @Override // com.uploader.implement.d.a
    public void d(com.uploader.implement.d.b bVar, e eVar) {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderAction", this.a + " onConnect, session:" + bVar.hashCode() + " request:" + eVar.hashCode());
        }
        com.uploader.implement.a.c cVar = this.k;
        if (cVar != null) {
            cVar.o = System.currentTimeMillis();
        }
    }

    @Override // com.uploader.implement.d.a
    public void c(com.uploader.implement.d.b bVar, e eVar) {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderAction", this.a + " onConnectBegin, session:" + bVar.hashCode() + " request:" + eVar.hashCode());
        }
        com.uploader.implement.a.c cVar = this.k;
        if (cVar != null) {
            cVar.n = System.currentTimeMillis();
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderAction", this.a + " onConnectBegin statistics:" + this.k.hashCode() + " connectedTimeMillisStart:" + this.k.n);
            }
        }
    }
}
