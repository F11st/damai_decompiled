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
import com.uploader.implement.C7364a;
import com.uploader.implement.C7399c;
import com.uploader.implement.a.c.C7371b;
import com.uploader.implement.a.c.InterfaceC7368a;
import com.uploader.implement.b.a.C7393f;
import com.uploader.implement.b.a.C7394g;
import com.uploader.implement.d.InterfaceC7404b;
import com.uploader.implement.e.C7408b;
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
/* renamed from: com.uploader.implement.a.i */
/* loaded from: classes11.dex */
public class C7376i extends AbstractC7365a {
    private ArrayList<Pair<Integer, Integer>> e;
    private long f;
    private int g;
    private int h;
    private InterfaceC7373e i;
    private String j;
    private C7367c k;
    private volatile h43 l;
    private final IUploaderTask m;
    private final ITaskListener n;
    private final Handler o;
    private final int p;
    private final C7399c q;

    /* compiled from: Taobao */
    /* renamed from: com.uploader.implement.a.i$a */
    /* loaded from: classes11.dex */
    static final class C7377a implements Handler.Callback {
        static final int c = C7377a.class.hashCode();
        private final WeakReference<InterfaceC7404b> a;
        private final WeakReference<AbstractC7365a> b;

        C7377a(AbstractC7365a abstractC7365a, InterfaceC7404b interfaceC7404b) {
            this.b = new WeakReference<>(abstractC7365a);
            this.a = new WeakReference<>(interfaceC7404b);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterfaceC7404b interfaceC7404b;
            AbstractC7365a abstractC7365a;
            if (message.what != c || (interfaceC7404b = this.a.get()) == null || (abstractC7365a = this.b.get()) == null) {
                return false;
            }
            abstractC7365a.i(interfaceC7404b, (k33) message.obj);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.uploader.implement.a.i$b */
    /* loaded from: classes11.dex */
    public static class C7378b implements ITaskResult {
        private Map<String, String> a;
        private String b;
        private String c;

        public C7378b(Map<String, String> map, String str, String str2) {
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
    /* renamed from: com.uploader.implement.a.i$c */
    /* loaded from: classes11.dex */
    private static final class RunnableC7379c implements Runnable {
        final Handler.Callback a;
        private final WeakReference<C7376i> b;
        private final WeakReference<Looper> c = new WeakReference<>(Looper.myLooper());

        RunnableC7379c(C7376i c7376i, Handler.Callback callback) {
            this.b = new WeakReference<>(c7376i);
            this.a = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7376i c7376i = this.b.get();
            Looper looper = this.c.get();
            if (looper == null || c7376i == null) {
                return;
            }
            new Handler(looper, this.a).obtainMessage(C7377a.c, c7376i.E()).sendToTarget();
        }
    }

    public C7376i(C7399c c7399c, IUploaderTask iUploaderTask, int i, ITaskListener iTaskListener, Handler handler) {
        super(c7399c.c);
        this.e = new ArrayList<>();
        this.q = c7399c;
        this.m = iUploaderTask;
        this.n = iTaskListener;
        this.o = handler;
        this.p = i;
    }

    k33 A(InterfaceC7404b interfaceC7404b, @Nullable InterfaceC7373e interfaceC7373e, boolean z) {
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
            if (interfaceC7373e == null) {
                interfaceC7404b.a(d53Var);
            } else {
                interfaceC7404b.a(interfaceC7373e, d53Var, z);
            }
            C7393f a = d53Var.a();
            C7367c c7367c = new C7367c(false, this.k);
            this.k = c7367c;
            c7367c.d = this.l.e;
            this.k.p = this.l.d;
            this.k.q = (String) this.q.a.a().first;
            C7367c c7367c2 = this.k;
            c7367c2.e = a.a;
            c7367c2.f = a.b;
            c7367c2.k = this.l.f;
            this.k.t = a.f ? 1 : 0;
            if (C7364a.d(8)) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.a);
                sb.append(" beginFile, request:");
                sb.append(interfaceC7373e == null ? "" : Integer.valueOf(interfaceC7373e.hashCode()));
                sb.append(" newRequest:");
                sb.append(Integer.valueOf(d53Var.hashCode()));
                sb.append(" statistics:");
                sb.append(this.k.hashCode());
                C7364a.a(8, "UploaderAction", sb.toString());
                return null;
            }
            return null;
        } catch (UnsupportedEncodingException e) {
            if (C7364a.d(16)) {
                C7364a.b(16, "UploaderAction", this.a + " onActionStartFile", e);
            }
            return new k33("200", "1", e.toString(), false);
        } catch (Exception e2) {
            if (C7364a.d(16)) {
                C7364a.b(16, "UploaderAction", this.a + " onActionStartFile", e2);
            }
            return new k33("200", "5", e2.toString(), false);
        }
    }

    Pair<k33, ? extends Object> B(i33 i33Var) {
        String b = i33Var.b("x-arup-process");
        if (C7364a.d(4)) {
            C7364a.a(4, "UploaderAction", this.a + " progress :" + b);
        }
        int i = 0;
        try {
            i = Integer.parseInt(b);
        } catch (Exception e) {
            if (C7364a.d(8)) {
                C7364a.b(8, "UploaderAction", this.a + "", e);
            }
        }
        return new Pair<>(null, Integer.valueOf(i));
    }

    k33 C(InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e, k33 k33Var) {
        if (this.h >= 5) {
            if (C7364a.d(2)) {
                C7364a.a(2, "UploaderAction", this.a + " retryFile, retry failed, request:" + interfaceC7373e.hashCode() + " error:" + k33Var + " fileRetryCounter:" + this.h);
            }
            return k33Var;
        }
        if (MessageService.MSG_DB_COMPLETE.equalsIgnoreCase(k33Var.a)) {
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderAction", this.a + " retryFile, try to connect next, request:" + interfaceC7373e.hashCode());
            }
            this.q.a.h();
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderAction", this.a + " ConnectionStrategy, after nextUploadTarget:" + this.q.a.toString());
            }
        }
        k33 A = A(interfaceC7404b, interfaceC7373e, false);
        if (A == null) {
            this.h++;
            if (C7364a.d(2)) {
                C7364a.a(2, "UploaderAction", this.a + " retryFile, request:" + interfaceC7373e.hashCode() + " fileRetryCounter:" + this.h);
            }
            C7367c c7367c = this.k;
            if (c7367c != null) {
                c7367c.r = this.h;
            }
        }
        return A;
    }

    Pair<k33, ? extends Object> D(i33 i33Var) {
        try {
            Object[] objArr = i33Var.c;
            this.q.a.d((String) objArr[0], ((Long) objArr[1]).longValue(), (List) objArr[2], (List) objArr[3]);
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderAction", this.a + " ConnectionStrategy update:" + this.q.a.toString());
            }
            C7367c c7367c = this.k;
            if (c7367c != null) {
                c7367c.g = 1;
                c7367c.q = (String) this.q.a.a().first;
                this.k.m = System.currentTimeMillis();
                this.j = "Declare" + this.k.a();
                if (C7364a.d(8)) {
                    C7364a.a(8, "UploaderAction", this.a + " retrieveDeclare, statistics:" + this.k.hashCode() + " costTimeMillisEnd:" + this.k.m);
                }
            }
            return new Pair<>(null, null);
        } catch (Exception e) {
            if (C7364a.d(4)) {
                C7364a.a(4, "UploaderAction", e.toString());
            }
            return new Pair<>(new k33("200", "8", e.toString(), true), null);
        }
    }

    k33 E() {
        long currentTimeMillis = System.currentTimeMillis();
        Pair<k33, h43> a = C7371b.a(this.m);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        Object obj = a.second;
        if (obj != null) {
            ((h43) obj).i = currentTimeMillis2;
            this.l = (h43) obj;
        }
        if (C7364a.d(8)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" createFileDescription, elapsed:");
            sb.append(currentTimeMillis2);
            sb.append(" error:");
            Object obj2 = a.first;
            sb.append(obj2 == null ? "" : ((k33) obj2).toString());
            C7364a.a(8, "UploaderAction", sb.toString());
        }
        return (k33) a.first;
    }

    @NonNull
    public final IUploaderTask F() {
        return this.m;
    }

    public final int G() {
        return this.p;
    }

    @Override // com.uploader.implement.d.InterfaceC7403a
    public void a(InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e, int i) {
        if (C7364a.d(2)) {
            C7364a.a(2, "UploaderAction", this.a + " onUploading, session:" + interfaceC7404b.hashCode() + " request:" + interfaceC7373e.hashCode() + " fileSizeSent:" + i + ", sendOffset=" + this.f);
        }
        long j = i + interfaceC7373e.b().c;
        this.f = j;
        C7367c c7367c = this.k;
        if (c7367c != null) {
            c7367c.b = j;
        }
    }

    @Override // com.uploader.implement.a.AbstractC7365a
    Pair<k33, ? extends Object> b(InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e, i33 i33Var) {
        String b;
        if (this.k != null && (b = i33Var.b("divided_length")) != null) {
            try {
                this.k.c += Integer.parseInt(b);
            } catch (Exception e) {
                if (C7364a.d(2)) {
                    C7364a.a(2, "UploaderAction", this.a + e.toString());
                }
            }
        }
        switch (i33Var.a()) {
            case 1:
                return D(i33Var);
            case 2:
                return B(i33Var);
            case 3:
                return v(interfaceC7404b, interfaceC7373e, i33Var);
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

    @Override // com.uploader.implement.a.AbstractC7365a
    k33 c(InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e, Pair<Integer, Integer> pair) {
        if (this.i != null) {
            this.e.add(pair);
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderAction", this.a + " onActionContinue, add offset, session:" + interfaceC7404b.hashCode());
            }
            return null;
        }
        try {
            d53 d53Var = new d53(this.q, this.l, "patch", ((Integer) pair.first).intValue(), ((Integer) pair.second).intValue(), false);
            interfaceC7404b.a(interfaceC7373e, d53Var, true);
            if (C7364a.d(4)) {
                C7364a.a(4, "UploaderAction", this.a + " onActionContinue, session:" + interfaceC7404b.hashCode() + " send request:" + d53Var.hashCode());
                return null;
            }
            return null;
        } catch (UnsupportedEncodingException e) {
            if (C7364a.d(16)) {
                C7364a.b(16, "UploaderAction", this.a + " onActionContinue", e);
            }
            return new k33("200", "1", e.toString(), false);
        } catch (Exception e2) {
            if (C7364a.d(16)) {
                C7364a.b(16, "UploaderAction", this.a + " onActionContinue", e2);
            }
            return new k33("200", "5", e2.toString(), false);
        }
    }

    @Override // com.uploader.implement.a.AbstractC7365a
    k33 d(InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e, k33 k33Var) {
        C7367c c7367c = this.k;
        if (c7367c != null) {
            c7367c.m = System.currentTimeMillis();
        }
        if (C7364a.d(8)) {
            C7364a.a(8, "UploaderAction", this.a + " onActionRetry, session:" + interfaceC7404b.hashCode() + " request:" + interfaceC7373e.hashCode());
        }
        if (o() == 2) {
            return C(interfaceC7404b, interfaceC7373e, k33Var);
        }
        return z(interfaceC7404b, interfaceC7373e, k33Var);
    }

    @Override // com.uploader.implement.a.AbstractC7365a
    k33 e(InterfaceC7404b interfaceC7404b, @Nullable InterfaceC7373e interfaceC7373e, boolean z) {
        if (o() == 2) {
            return A(interfaceC7404b, interfaceC7373e, z);
        }
        return x(interfaceC7404b, interfaceC7373e, z);
    }

    @Override // com.uploader.implement.a.AbstractC7365a
    void f() {
        this.i = null;
        this.e.clear();
    }

    @Override // com.uploader.implement.a.AbstractC7365a
    void g(int i, Object obj) {
        RunnableC7366b.a(this.o, i, this.m, this.n, obj);
        if (this.k == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (C7364a.d(8)) {
            C7364a.a(8, "UploaderAction", this.a + " onActionNotify, notifyType:" + i + " statistics:" + this.k.hashCode() + " costTimeMillisEnd:" + currentTimeMillis);
        }
        if (i == 1) {
            C7367c c7367c = this.k;
            c7367c.g = 2;
            c7367c.m = currentTimeMillis;
            c7367c.a();
            this.k = null;
        } else if (i != 2) {
            if (i != 7) {
                return;
            }
            this.k.m = currentTimeMillis;
        } else {
            k33 k33Var = (k33) obj;
            C7367c c7367c2 = this.k;
            c7367c2.g = 0;
            c7367c2.h = k33Var.a;
            c7367c2.i = k33Var.b;
            c7367c2.j = k33Var.c;
            c7367c2.m = currentTimeMillis;
            c7367c2.a();
            this.k = null;
        }
    }

    @Override // com.uploader.implement.a.AbstractC7365a
    boolean l(InterfaceC7404b interfaceC7404b) {
        boolean z = this.l == null;
        if (z) {
            C7408b.a(new RunnableC7379c(this, new C7377a(this, interfaceC7404b)));
        }
        return z;
    }

    @Override // com.uploader.implement.a.AbstractC7365a
    boolean n() {
        Pair<String, Long> a = this.q.a.a();
        return a != null && this.q.a.i() + (System.currentTimeMillis() / 1000) < ((Long) a.second).longValue();
    }

    Pair<k33, ? extends Object> u(i33 i33Var) {
        if (C7364a.d(2)) {
            C7364a.a(2, "UploaderAction", this.a + " retrieveStatus ,response=" + i33Var);
        }
        String b = i33Var.b("x-arup-session-status");
        if (!TextUtils.isEmpty(b)) {
            return new Pair<>(null, b);
        }
        return new Pair<>(null, null);
    }

    Pair<k33, ? extends Object> v(InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e, i33 i33Var) {
        String b = i33Var.b("x-arup-offset");
        if (TextUtils.isEmpty(b)) {
            return new Pair<>(new k33("200", "7", "onReceiveOffset:1", true), null);
        }
        int indexOf = b.indexOf("=");
        if (indexOf == -1) {
            return new Pair<>(new k33("200", "7", "onReceiveOffset:2", true), null);
        }
        if (!this.l.d.equals(b.substring(0, indexOf))) {
            return new Pair<>(new k33("200", "7", "onReceiveOffset:3", true), null);
        }
        int indexOf2 = b.indexOf(",");
        int i = indexOf + 1;
        if (indexOf2 > i && indexOf2 < b.length()) {
            try {
                return new Pair<>(null, new Pair(Integer.valueOf(Integer.parseInt(b.substring(i, indexOf2))), Integer.valueOf(Integer.parseInt(b.substring(indexOf2 + 1, b.length())))));
            } catch (Exception e) {
                if (C7364a.d(16)) {
                    C7364a.b(16, "UploaderAction", this.a + " parse offset error.", e);
                }
                return new Pair<>(new k33("200", "7", e.toString(), true), null);
            }
        }
        return new Pair<>(new k33("200", "7", "onReceiveOffset:4", true), null);
    }

    Pair<k33, ? extends Object> w(i33 i33Var) {
        if (C7364a.d(2)) {
            C7364a.a(2, "UploaderAction", this.a + " onReceiveError ,response=" + i33Var);
        }
        String b = i33Var.b("x-arup-error-code");
        String b2 = i33Var.b("x-arup-error-msg");
        String b3 = i33Var.b("x-arup-server-timestamp");
        if (!TextUtils.isEmpty(b3)) {
            try {
                this.q.a.c(Long.parseLong(b3));
            } catch (Exception e) {
                if (C7364a.d(2)) {
                    C7364a.a(2, "UploaderAction", this.a + " retrieveError " + e);
                }
                b2 = b2 + " " + e.toString();
            }
        }
        if (InterfaceC7368a.InterfaceC7369a.C7370a.a.contains(b)) {
            return new Pair<>(new k33("300", b, b2, true), null);
        }
        if (!"20021".equalsIgnoreCase(b) && !"20022".equalsIgnoreCase(b) && !"20020".equalsIgnoreCase(b)) {
            return new Pair<>(new k33("300", b, b2, false), null);
        }
        return new Pair<>(new k33("300", "2", b2, true), null);
    }

    k33 x(InterfaceC7404b interfaceC7404b, @Nullable InterfaceC7373e interfaceC7373e, boolean z) {
        try {
            h33 h33Var = new h33(this.q);
            if (interfaceC7373e == null) {
                interfaceC7404b.a(h33Var);
            } else {
                interfaceC7404b.a(interfaceC7373e, h33Var, z);
            }
            C7394g a = h33Var.a();
            C7367c c7367c = new C7367c(true, this.k);
            this.k = c7367c;
            c7367c.d = this.l.e;
            this.k.p = this.l.d;
            C7367c c7367c2 = this.k;
            c7367c2.e = a.a;
            c7367c2.f = a.b;
            c7367c2.k = this.l.f;
            this.k.s = this.l.i;
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderAction", this.a + " beginDeclare statistics create:" + this.k.hashCode());
                return null;
            }
            return null;
        } catch (JSONException e) {
            if (C7364a.d(16)) {
                C7364a.b(16, "UploaderAction", this.a + " onActionBegin", e);
            }
            return new k33("200", "1", e.toString(), false);
        } catch (Exception e2) {
            if (C7364a.d(16)) {
                C7364a.b(16, "UploaderAction", this.a + " onActionBegin", e2);
            }
            return new k33("200", "5", e2.toString(), false);
        }
    }

    Pair<k33, ? extends Object> y(i33 i33Var) {
        if (C7364a.d(2)) {
            C7364a.a(2, "UploaderAction", this.a + " onReceiveResult ,response=" + i33Var.c());
        }
        if (!this.l.d.equals(i33Var.b("x-arup-file-id"))) {
            return new Pair<>(new k33("300", "1", "fileId!=", true), null);
        }
        C7378b c7378b = new C7378b(i33Var.c(), i33Var.b("x-arup-file-url"), i33Var.b("x-arup-biz-ret"));
        C7367c c7367c = this.k;
        if (c7367c != null) {
            c7367c.g = 1;
            c7367c.m = System.currentTimeMillis();
            this.j += ", File" + this.k.a();
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderAction", this.a + " retrieveResult, statistics:" + this.k.hashCode() + " costTimeMillisEnd:" + this.k.m);
            }
        }
        Map<String, String> result = c7378b.getResult();
        if (result != null) {
            result.put("", this.j);
        }
        return new Pair<>(null, c7378b);
    }

    k33 z(InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e, k33 k33Var) {
        if (this.g >= 4) {
            if (C7364a.d(2)) {
                C7364a.a(2, "UploaderAction", this.a + " retryDeclare, retry failed, request:" + interfaceC7373e.hashCode() + " error:" + k33Var + " declareRetryCounter:" + this.g);
            }
            return k33Var;
        }
        if (MessageService.MSG_DB_COMPLETE.equalsIgnoreCase(k33Var.a) || "400".equalsIgnoreCase(k33Var.a)) {
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderAction", this.a + " onActionRetry, try to connect next, request:" + interfaceC7373e.hashCode());
            }
            this.q.a.f();
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderAction", this.a + " ConnectionStrategy, after nextDeclareTarget:" + this.q.a.toString());
            }
        }
        k33 x = x(interfaceC7404b, interfaceC7373e, false);
        if (x == null) {
            this.g++;
            if (C7364a.d(2)) {
                C7364a.a(2, "UploaderAction", this.a + " onActionRetry, retry, request:" + interfaceC7373e.hashCode() + " declareRetryCounter:" + this.g);
            }
            C7367c c7367c = this.k;
            if (c7367c != null) {
                c7367c.r = this.g;
            }
        }
        return x;
    }

    @Override // com.uploader.implement.d.InterfaceC7403a
    public void e(InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e) {
        long j;
        String str;
        C7367c c7367c = this.k;
        if (c7367c == null || c7367c.l != 0) {
            j = 0;
        } else {
            j = System.currentTimeMillis();
            this.k.l = j;
        }
        this.i = interfaceC7373e;
        if (C7364a.d(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" onSendBegin, session:");
            sb.append(interfaceC7404b.hashCode());
            sb.append(" request and set current:");
            sb.append(interfaceC7373e.hashCode());
            if (j == 0) {
                str = "";
            } else {
                str = " statistics:" + this.k.hashCode() + " costTimeMillisStart:" + j;
            }
            sb.append(str);
            C7364a.a(2, "UploaderAction", sb.toString());
        }
    }

    @Override // com.uploader.implement.a.AbstractC7365a
    Pair<Integer, Integer> a(InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e) {
        if (C7364a.d(4)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" onActionDeliver, session:");
            sb.append(interfaceC7404b.hashCode());
            sb.append(" request:");
            sb.append(interfaceC7373e.hashCode());
            sb.append(" currentRequest:");
            InterfaceC7373e interfaceC7373e2 = this.i;
            sb.append(interfaceC7373e2 == null ? "null" : Integer.valueOf(interfaceC7373e2.hashCode()));
            C7364a.a(4, "UploaderAction", sb.toString());
        }
        if (this.k != null) {
            i83 b = interfaceC7373e.b();
            byte[] bArr = b.f;
            int length = bArr == null ? 0 : bArr.length;
            byte[] bArr2 = b.g;
            this.k.b = b.d + length + (bArr2 == null ? 0 : bArr2.length);
        }
        if (this.i != interfaceC7373e) {
            return null;
        }
        this.i = null;
        if (this.e.size() > 0) {
            return this.e.remove(0);
        }
        return null;
    }

    @Override // com.uploader.implement.d.InterfaceC7403a
    public void d(InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e) {
        if (C7364a.d(2)) {
            C7364a.a(2, "UploaderAction", this.a + " onConnect, session:" + interfaceC7404b.hashCode() + " request:" + interfaceC7373e.hashCode());
        }
        C7367c c7367c = this.k;
        if (c7367c != null) {
            c7367c.o = System.currentTimeMillis();
        }
    }

    @Override // com.uploader.implement.d.InterfaceC7403a
    public void c(InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e) {
        if (C7364a.d(2)) {
            C7364a.a(2, "UploaderAction", this.a + " onConnectBegin, session:" + interfaceC7404b.hashCode() + " request:" + interfaceC7373e.hashCode());
        }
        C7367c c7367c = this.k;
        if (c7367c != null) {
            c7367c.n = System.currentTimeMillis();
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderAction", this.a + " onConnectBegin statistics:" + this.k.hashCode() + " connectedTimeMillisStart:" + this.k.n);
            }
        }
    }
}
