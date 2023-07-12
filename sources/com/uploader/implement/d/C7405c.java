package com.uploader.implement.d;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.uploader.implement.C7364a;
import com.uploader.implement.C7399c;
import com.uploader.implement.a.InterfaceC7373e;
import com.uploader.implement.a.InterfaceC7374f;
import com.uploader.implement.b.InterfaceC7395b;
import com.uploader.implement.b.InterfaceC7396c;
import com.uploader.implement.b.InterfaceC7397d;
import com.uploader.implement.b.InterfaceC7398e;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.agoo.message.MessageService;
import tb.i83;
import tb.k33;
import tb.p73;

/* compiled from: Taobao */
/* renamed from: com.uploader.implement.d.c */
/* loaded from: classes11.dex */
public class C7405c implements InterfaceC7395b, InterfaceC7397d, InterfaceC7404b {
    private static final AtomicInteger i = new AtomicInteger(0);
    private InterfaceC7403a a;
    private InterfaceC7396c e;
    private Handler f;
    private final C7399c h;
    private ArrayList<InterfaceC7373e> b = new ArrayList<>();
    private ArrayList<C7407b> c = new ArrayList<>();
    private ArrayList<RunnableC7406a> d = new ArrayList<>();
    private final int g = hashCode();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.uploader.implement.d.c$a */
    /* loaded from: classes11.dex */
    public static class RunnableC7406a implements Runnable {
        final int a;
        final C7405c b;
        final Object[] c;

        RunnableC7406a(int i, @NonNull C7405c c7405c, Object... objArr) {
            this.a = i;
            this.b = c7405c;
            this.c = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.a) {
                case 1:
                    this.b.n((InterfaceC7398e) this.c[0]);
                    return;
                case 2:
                    this.b.p((InterfaceC7398e) this.c[0]);
                    return;
                case 3:
                    C7405c c7405c = this.b;
                    Object[] objArr = this.c;
                    c7405c.k((InterfaceC7398e) objArr[0], (k33) objArr[1]);
                    return;
                case 4:
                    C7405c c7405c2 = this.b;
                    Object[] objArr2 = this.c;
                    c7405c2.l((InterfaceC7398e) objArr2[0], (p73) objArr2[1]);
                    return;
                case 5:
                    C7405c c7405c3 = this.b;
                    Object[] objArr3 = this.c;
                    c7405c3.f((InterfaceC7398e) objArr3[0], ((Integer) objArr3[1]).intValue(), false);
                    return;
                case 6:
                    C7405c c7405c4 = this.b;
                    Object[] objArr4 = this.c;
                    c7405c4.f((InterfaceC7398e) objArr4[0], ((Integer) objArr4[1]).intValue(), true);
                    return;
                case 7:
                    C7405c c7405c5 = this.b;
                    Object[] objArr5 = this.c;
                    c7405c5.m((InterfaceC7404b) objArr5[0], (InterfaceC7373e) objArr5[1], (InterfaceC7398e) objArr5[2]);
                    return;
                case 8:
                    this.b.j((InterfaceC7398e) this.c[0]);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.uploader.implement.d.c$b */
    /* loaded from: classes11.dex */
    public static final class C7407b {
        final InterfaceC7373e a;
        final i83 b;
        final InterfaceC7398e c;
        boolean d;
        boolean e;
        int f;
        int g;
        int h;
        int i;
        ByteBuffer j;
        Map<String, String> k;
        p73 l;
        ByteBuffer m;

        C7407b(@NonNull InterfaceC7373e interfaceC7373e, @NonNull InterfaceC7398e interfaceC7398e) {
            this.a = interfaceC7373e;
            i83 b = interfaceC7373e.b();
            this.b = b;
            this.c = interfaceC7398e;
            Map<String, String> map = b.e;
            boolean z = false;
            this.d = map == null || map.size() == 0;
            byte[] bArr = b.g;
            this.e = (bArr == null || bArr.length == 0) ? true : true;
        }

        void a() {
            Map<String, String> map = this.b.e;
            boolean z = true;
            this.d = map == null || map.size() == 0;
            byte[] bArr = this.b.g;
            if (bArr != null && bArr.length != 0) {
                z = false;
            }
            this.e = z;
            this.g = 0;
            this.f = 0;
            this.h = 0;
            this.j = null;
            this.k = null;
        }

        boolean b() {
            i83 i83Var = this.b;
            byte[] bArr = i83Var.f;
            return this.e && this.d && (bArr == null || this.f == bArr.length) && (i83Var.a == null || (((long) this.g) > i83Var.d ? 1 : (((long) this.g) == i83Var.d ? 0 : -1)) == 0);
        }
    }

    public C7405c(C7399c c7399c, InterfaceC7396c interfaceC7396c, Looper looper) {
        this.h = c7399c;
        this.e = interfaceC7396c;
        this.f = new Handler(looper);
    }

    private static int b(InterfaceC7398e interfaceC7398e, ArrayList<C7407b> arrayList) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (arrayList.get(i2).c.equals(interfaceC7398e)) {
                return i2;
            }
        }
        return -1;
    }

    private k33 c(C7407b c7407b, ByteBuffer byteBuffer) {
        i83 i83Var = c7407b.b;
        FileInputStream fileInputStream = null;
        if (i83Var.h != null) {
            long j = i83Var.c;
            int i2 = c7407b.g;
            int i3 = (int) (j + i2);
            int min = (int) Math.min(i83Var.d - i2, byteBuffer.remaining());
            if (min >= 0) {
                i83 i83Var2 = c7407b.b;
                long j2 = i83Var2.d;
                byte[] bArr = i83Var2.h;
                if (j2 <= bArr.length) {
                    byteBuffer.put(bArr, i3, min);
                    c7407b.g += min;
                    if (C7364a.d(4)) {
                        C7364a.a(4, "UploaderSession", this.g + " readFromEntity, from copy:" + min);
                    }
                    return null;
                }
            }
            return new k33("200", "11", "readFromBytes", false);
        }
        File file = i83Var.a;
        if (file != null && file.exists()) {
            long lastModified = file.lastModified();
            if (lastModified != c7407b.b.b) {
                if (C7364a.d(8)) {
                    C7364a.a(8, "UploaderSession", this.g + " readFromEntity, file has been modified, origin:" + c7407b.b.b + " current:" + lastModified);
                }
                if (0 == lastModified) {
                    return new k33("200", "10", "file.lastModified()==0", false);
                }
                return new k33("200", "6", "file has been modified", false);
            }
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        int read = fileInputStream2.getChannel().read(byteBuffer, c7407b.b.c + c7407b.g);
                        if (read < 0) {
                            k33 k33Var = new k33("200", "3", "file read failed", false);
                            try {
                                fileInputStream2.close();
                            } catch (IOException e) {
                                if (C7364a.d(8)) {
                                    C7364a.b(8, "UploaderSession", this.g + " readFromEntity:", e);
                                }
                            }
                            return k33Var;
                        }
                        int i4 = (int) ((c7407b.g + read) - c7407b.b.d);
                        if (i4 > 0) {
                            byteBuffer.position(byteBuffer.position() - i4);
                            read -= i4;
                        }
                        if (read > 0) {
                            c7407b.g += read;
                        }
                        try {
                            fileInputStream2.close();
                        } catch (IOException e2) {
                            if (C7364a.d(8)) {
                                C7364a.b(8, "UploaderSession", this.g + " readFromEntity:", e2);
                            }
                        }
                        return null;
                    } catch (Exception e3) {
                        e = e3;
                        fileInputStream = fileInputStream2;
                        k33 k33Var2 = new k33("200", "3", e.toString(), false);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                if (C7364a.d(8)) {
                                    C7364a.b(8, "UploaderSession", this.g + " readFromEntity:", e4);
                                }
                            }
                        }
                        return k33Var2;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                                if (C7364a.d(8)) {
                                    C7364a.b(8, "UploaderSession", this.g + " readFromEntity:", e5);
                                }
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } else {
            return new k33("200", "3", "file == null || !file.exists()", false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (r3 > 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(int r13) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uploader.implement.d.C7405c.d(int):void");
    }

    private void e(int i2, k33 k33Var) {
        C7407b remove = this.c.remove(i2);
        if (C7364a.d(2)) {
            C7364a.a(2, "UploaderSession", this.g + " notifyError, request:" + remove.a.hashCode());
        }
        InterfaceC7403a interfaceC7403a = this.a;
        if (interfaceC7403a != null) {
            interfaceC7403a.b(this, remove.a, k33Var);
        }
    }

    private static void g(C7407b c7407b, p73 p73Var) {
        if (c7407b.j == null) {
            c7407b.j = ByteBuffer.allocate(128);
            c7407b.k = p73Var.a;
        }
        int position = c7407b.j.position() + p73Var.b.length;
        if (c7407b.j.capacity() < position) {
            c7407b.j.flip();
            c7407b.j = ByteBuffer.allocate(position).put(c7407b.j);
        }
        c7407b.j.put(p73Var.b);
    }

    private static int h(InterfaceC7398e interfaceC7398e, ArrayList<RunnableC7406a> arrayList) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (arrayList.get(i2).c[0].equals(interfaceC7398e)) {
                return i2;
            }
        }
        return -1;
    }

    private k33 i(C7407b c7407b, ByteBuffer byteBuffer) {
        byte[] bArr = c7407b.b.f;
        int min = Math.min(bArr.length - c7407b.f, byteBuffer.remaining());
        if (min < 0) {
            return new k33("200", "1", "readFromBytes", false);
        }
        byteBuffer.put(bArr, c7407b.f, min);
        c7407b.f += min;
        return null;
    }

    private void o(InterfaceC7398e interfaceC7398e, int i2) {
        RunnableC7406a runnableC7406a;
        int h = h(interfaceC7398e, this.d);
        if (h == -1) {
            runnableC7406a = new RunnableC7406a(8, this, interfaceC7398e);
            this.d.add(runnableC7406a);
        } else {
            runnableC7406a = this.d.get(h);
            this.f.removeCallbacks(runnableC7406a);
        }
        this.f.postDelayed(runnableC7406a, (i2 / 102400) + 30000);
    }

    private void q(InterfaceC7398e interfaceC7398e) {
        int h = h(interfaceC7398e, this.d);
        if (h == -1) {
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderSession", this.g + " clearTimeout, NO_POSITION, connection:" + interfaceC7398e.hashCode());
                return;
            }
            return;
        }
        this.f.removeCallbacks(this.d.remove(h));
        if (C7364a.d(2)) {
            C7364a.a(2, "UploaderSession", this.g + " clearTimeout, connection:" + interfaceC7398e.hashCode());
        }
    }

    @Override // com.uploader.implement.d.InterfaceC7404b
    public void a(@NonNull InterfaceC7373e interfaceC7373e, boolean z) {
        if (this.b.remove(interfaceC7373e)) {
            if (C7364a.d(2)) {
                C7364a.a(2, "UploaderSession", this.g + " cancel, waiting request:" + interfaceC7373e.hashCode());
                return;
            }
            return;
        }
        int a = a(interfaceC7373e, this.c);
        if (a == -1) {
            if (C7364a.d(2)) {
                C7364a.a(2, "UploaderSession", this.g + " cancel, no sending request:" + interfaceC7373e.hashCode());
                return;
            }
            return;
        }
        boolean a2 = this.e.a(this, interfaceC7373e, z);
        int h = h(this.c.remove(a).c, this.d);
        if (h != -1) {
            this.f.removeCallbacks(this.d.remove(h));
        }
        if (C7364a.d(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.g);
            sb.append(" cancel, sendingList request");
            sb.append(interfaceC7373e.hashCode());
            sb.append(" remove timeout:");
            sb.append(h != -1);
            sb.append(" unregister:");
            sb.append(a2);
            C7364a.a(2, "UploaderSession", sb.toString());
        }
    }

    void f(InterfaceC7398e interfaceC7398e, int i2, boolean z) {
        int b = b(interfaceC7398e, this.c);
        if (b == -1) {
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderSession", this.g + " doSend, NO_POSITION, connection:" + interfaceC7398e.hashCode());
                return;
            }
            return;
        }
        C7407b c7407b = this.c.get(b);
        boolean b2 = c7407b.b();
        if (C7364a.d(2)) {
            C7364a.a(2, "UploaderSession", this.g + " doSend, begin:" + z + " connection:" + interfaceC7398e.hashCode() + " sendSequence:" + i2 + " isFinished:" + b2);
        }
        if (z) {
            InterfaceC7403a interfaceC7403a = this.a;
            if (interfaceC7403a != null) {
                interfaceC7403a.a(this, c7407b.a, c7407b.g);
            }
        } else if (!b2) {
            d(b);
            return;
        } else {
            InterfaceC7403a interfaceC7403a2 = this.a;
            if (interfaceC7403a2 != null) {
                interfaceC7403a2.b(this, c7407b.a);
            }
        }
        o(c7407b.c, c7407b.i);
    }

    void j(InterfaceC7398e interfaceC7398e) {
        this.d.remove(this);
        int b = b(interfaceC7398e, this.c);
        if (b == -1) {
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderSession", this.g + " timeout, NO_POSITION, connection:" + interfaceC7398e.hashCode());
                return;
            }
            return;
        }
        if (C7364a.d(2)) {
            C7364a.a(2, "UploaderSession", this.g + " timeout, connection:" + interfaceC7398e.hashCode());
        }
        e(b, new k33(MessageService.MSG_DB_COMPLETE, "2", "data send or receive timeout", true));
    }

    void k(InterfaceC7398e interfaceC7398e, k33 k33Var) {
        int b = b(interfaceC7398e, this.c);
        if (b == -1) {
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderSession", this.g + " doError, NO_POSITION, connection:" + interfaceC7398e.hashCode());
                return;
            }
            return;
        }
        if (C7364a.d(2)) {
            C7364a.a(2, "UploaderSession", this.g + " doError, connection:" + interfaceC7398e.hashCode() + " error:" + k33Var.toString() + " sendingList.size:" + this.c.size());
        }
        C7407b c7407b = this.c.get(b);
        c7407b.a();
        q(c7407b.c);
        e(b, k33Var);
    }

    void l(InterfaceC7398e interfaceC7398e, p73 p73Var) {
        int b = b(interfaceC7398e, this.c);
        if (b == -1) {
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderSession", this.g + " doReceive, NO_POSITION, connection:" + interfaceC7398e.hashCode());
                return;
            }
            return;
        }
        if (C7364a.d(2)) {
            C7364a.a(2, "UploaderSession", this.g + " doReceive, sendingList.size:" + this.c.size() + " index:" + b + " connection:" + interfaceC7398e.hashCode() + " data:" + p73Var.toString());
        }
        C7407b c7407b = this.c.get(b);
        o(c7407b.c, c7407b.i);
        g(c7407b, p73Var);
        ArrayList arrayList = null;
        do {
            Pair<InterfaceC7374f, Integer> a = c7407b.a.a(c7407b.k, c7407b.j.array(), c7407b.j.arrayOffset(), c7407b.j.position());
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(a);
            if (a.first == null) {
                break;
            }
            c7407b.j.flip();
            c7407b.j.get(new byte[((Integer) a.second).intValue()], 0, ((Integer) a.second).intValue());
            c7407b.j.compact();
        } while (c7407b.j.position() >= 4);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            Object obj = pair.first;
            if (obj == null) {
                if (((Integer) pair.second).intValue() < 0) {
                    e(b, new k33("400", "2", "response == null && divide < 0", true));
                    return;
                }
                return;
            }
            InterfaceC7403a interfaceC7403a = this.a;
            if (interfaceC7403a != null) {
                interfaceC7403a.a(this, c7407b.a, (InterfaceC7374f) obj);
            }
        }
    }

    void m(InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e, InterfaceC7398e interfaceC7398e) {
        boolean z = !this.b.remove(interfaceC7373e);
        boolean d = interfaceC7398e.d();
        if (C7364a.d(4)) {
            C7364a.a(4, "UploaderSession", this.g + " onAvailable.session:" + interfaceC7404b.hashCode() + " request:" + interfaceC7373e.hashCode() + " noWaitingRequest:" + z + " connection:" + interfaceC7398e.hashCode() + " needConnect:" + d + " target:" + interfaceC7373e.a());
        }
        if (z) {
            return;
        }
        interfaceC7398e.a(this);
        C7407b c7407b = new C7407b(interfaceC7373e, interfaceC7398e);
        this.c.add(c7407b);
        if (d) {
            InterfaceC7403a interfaceC7403a = this.a;
            if (interfaceC7403a != null) {
                interfaceC7403a.c(this, c7407b.a);
            }
            interfaceC7398e.b();
            return;
        }
        InterfaceC7403a interfaceC7403a2 = this.a;
        if (interfaceC7403a2 != null) {
            interfaceC7403a2.e(this, c7407b.a);
        }
        d(this.c.size() - 1);
    }

    void n(InterfaceC7398e interfaceC7398e) {
        int b = b(interfaceC7398e, this.c);
        if (b == -1) {
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderSession", this.g + " doConnect, NO_POSITION, connection:" + interfaceC7398e.hashCode());
                return;
            }
            return;
        }
        if (C7364a.d(2)) {
            C7364a.a(2, "UploaderSession", this.g + " doConnect, connection:" + interfaceC7398e.hashCode());
        }
        InterfaceC7403a interfaceC7403a = this.a;
        if (interfaceC7403a != null) {
            interfaceC7403a.d(this, this.c.get(b).a);
        }
        InterfaceC7403a interfaceC7403a2 = this.a;
        if (interfaceC7403a2 != null) {
            interfaceC7403a2.e(this, this.c.get(b).a);
        }
        d(b);
    }

    void p(InterfaceC7398e interfaceC7398e) {
        int b = b(interfaceC7398e, this.c);
        if (b == -1) {
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderSession", this.g + " doClose, NO_POSITION, connection:" + interfaceC7398e.hashCode());
                return;
            }
            return;
        }
        if (C7364a.d(2)) {
            C7364a.a(2, "UploaderSession", this.g + " doClose, connection:" + interfaceC7398e.hashCode());
        }
        interfaceC7398e.a(null);
        C7407b c7407b = this.c.get(b);
        c7407b.a();
        q(c7407b.c);
    }

    @Override // com.uploader.implement.b.InterfaceC7395b
    public void b(InterfaceC7398e interfaceC7398e, int i2) {
        this.f.post(new RunnableC7406a(5, this, interfaceC7398e, Integer.valueOf(i2)));
    }

    @Override // com.uploader.implement.d.InterfaceC7404b
    public void a(@NonNull InterfaceC7373e interfaceC7373e) {
        this.b.add(interfaceC7373e);
        boolean a = this.e.a(this, interfaceC7373e, this);
        if (C7364a.d(2)) {
            C7364a.a(2, "UploaderSession", this.g + " send, request:" + interfaceC7373e.hashCode() + " register:" + a);
        }
    }

    @Override // com.uploader.implement.d.InterfaceC7404b
    public void a(@NonNull InterfaceC7373e interfaceC7373e, @NonNull InterfaceC7373e interfaceC7373e2, boolean z) {
        int indexOf = this.b.indexOf(interfaceC7373e);
        if (indexOf != -1) {
            this.b.set(indexOf, interfaceC7373e2);
            boolean a = this.e.a(this, interfaceC7373e, interfaceC7373e2, this, z);
            if (!a) {
                this.e.a(this, interfaceC7373e, z);
                this.e.a(this, interfaceC7373e2, this);
            }
            if (C7364a.d(2)) {
                C7364a.a(2, "UploaderSession", this.g + " replace:" + a + " waiting request:" + interfaceC7373e.hashCode());
                return;
            }
            return;
        }
        int a2 = a(interfaceC7373e, this.c);
        if (a2 == -1) {
            this.b.add(interfaceC7373e2);
            boolean a3 = this.e.a(this, interfaceC7373e, interfaceC7373e2, this, z);
            if (!a3) {
                this.e.a(this, interfaceC7373e, z);
                this.e.a(this, interfaceC7373e2, this);
            }
            if (C7364a.d(2)) {
                C7364a.a(2, "UploaderSession", this.g + " replace:" + a3 + " request:" + interfaceC7373e.hashCode() + " newRequest:" + interfaceC7373e2.hashCode());
                return;
            }
            return;
        }
        C7407b remove = this.c.remove(a2);
        this.b.add(interfaceC7373e2);
        boolean a4 = this.e.a(this, interfaceC7373e, interfaceC7373e2, this, z);
        if (!a4) {
            this.e.a(this, interfaceC7373e, z);
            this.e.a(this, interfaceC7373e2, this);
        }
        int h = h(remove.c, this.d);
        if (h != -1) {
            this.f.removeCallbacks(this.d.remove(h));
        }
        if (C7364a.d(2)) {
            C7364a.a(2, "UploaderSession", this.g + " replace:" + a4 + " sending request:" + interfaceC7373e.hashCode() + " newRequest:" + interfaceC7373e2.hashCode());
        }
    }

    @Override // com.uploader.implement.d.InterfaceC7404b
    public void a(InterfaceC7403a interfaceC7403a) {
        this.a = interfaceC7403a;
    }

    @Override // com.uploader.implement.d.InterfaceC7404b
    public void a() {
        this.b.clear();
        this.c.clear();
        for (int size = this.d.size() - 1; size >= 0; size--) {
            this.f.removeCallbacks(this.d.remove(size));
        }
        this.e.a(this);
        if (C7364a.d(2)) {
            C7364a.a(2, "UploaderSession", this.g + " release");
        }
    }

    @Override // com.uploader.implement.b.InterfaceC7395b
    public void a(InterfaceC7398e interfaceC7398e) {
        this.f.post(new RunnableC7406a(1, this, interfaceC7398e));
    }

    @Override // com.uploader.implement.b.InterfaceC7395b
    public void a(InterfaceC7398e interfaceC7398e, k33 k33Var) {
        this.f.post(new RunnableC7406a(3, this, interfaceC7398e, k33Var));
    }

    @Override // com.uploader.implement.b.InterfaceC7395b
    public void a(InterfaceC7398e interfaceC7398e, p73 p73Var) {
        this.f.post(new RunnableC7406a(4, this, interfaceC7398e, p73Var));
    }

    @Override // com.uploader.implement.b.InterfaceC7395b
    public void a(InterfaceC7398e interfaceC7398e, int i2) {
        this.f.postDelayed(new RunnableC7406a(6, this, interfaceC7398e, Integer.valueOf(i2)), this.h.b.enableFlowControl() ? 100L : 0L);
    }

    private static int a(InterfaceC7373e interfaceC7373e, ArrayList<C7407b> arrayList) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (arrayList.get(i2).a.equals(interfaceC7373e)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.uploader.implement.b.InterfaceC7397d
    public void a(InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e, InterfaceC7398e interfaceC7398e) {
        this.f.post(new RunnableC7406a(7, this, interfaceC7404b, interfaceC7373e, interfaceC7398e));
    }
}
