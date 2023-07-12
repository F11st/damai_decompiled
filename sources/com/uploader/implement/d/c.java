package com.uploader.implement.d;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.uploader.implement.a.e;
import com.uploader.implement.a.f;
import com.uploader.implement.b.d;
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
/* loaded from: classes11.dex */
public class c implements com.uploader.implement.b.b, d, com.uploader.implement.d.b {
    private static final AtomicInteger i = new AtomicInteger(0);
    private com.uploader.implement.d.a a;
    private com.uploader.implement.b.c e;
    private Handler f;
    private final com.uploader.implement.c h;
    private ArrayList<e> b = new ArrayList<>();
    private ArrayList<b> c = new ArrayList<>();
    private ArrayList<a> d = new ArrayList<>();
    private final int g = hashCode();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a implements Runnable {
        final int a;
        final c b;
        final Object[] c;

        a(int i, @NonNull c cVar, Object... objArr) {
            this.a = i;
            this.b = cVar;
            this.c = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.a) {
                case 1:
                    this.b.n((com.uploader.implement.b.e) this.c[0]);
                    return;
                case 2:
                    this.b.p((com.uploader.implement.b.e) this.c[0]);
                    return;
                case 3:
                    c cVar = this.b;
                    Object[] objArr = this.c;
                    cVar.k((com.uploader.implement.b.e) objArr[0], (k33) objArr[1]);
                    return;
                case 4:
                    c cVar2 = this.b;
                    Object[] objArr2 = this.c;
                    cVar2.l((com.uploader.implement.b.e) objArr2[0], (p73) objArr2[1]);
                    return;
                case 5:
                    c cVar3 = this.b;
                    Object[] objArr3 = this.c;
                    cVar3.f((com.uploader.implement.b.e) objArr3[0], ((Integer) objArr3[1]).intValue(), false);
                    return;
                case 6:
                    c cVar4 = this.b;
                    Object[] objArr4 = this.c;
                    cVar4.f((com.uploader.implement.b.e) objArr4[0], ((Integer) objArr4[1]).intValue(), true);
                    return;
                case 7:
                    c cVar5 = this.b;
                    Object[] objArr5 = this.c;
                    cVar5.m((com.uploader.implement.d.b) objArr5[0], (e) objArr5[1], (com.uploader.implement.b.e) objArr5[2]);
                    return;
                case 8:
                    this.b.j((com.uploader.implement.b.e) this.c[0]);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class b {
        final e a;
        final i83 b;
        final com.uploader.implement.b.e c;
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

        b(@NonNull e eVar, @NonNull com.uploader.implement.b.e eVar2) {
            this.a = eVar;
            i83 b = eVar.b();
            this.b = b;
            this.c = eVar2;
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

    public c(com.uploader.implement.c cVar, com.uploader.implement.b.c cVar2, Looper looper) {
        this.h = cVar;
        this.e = cVar2;
        this.f = new Handler(looper);
    }

    private static int b(com.uploader.implement.b.e eVar, ArrayList<b> arrayList) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (arrayList.get(i2).c.equals(eVar)) {
                return i2;
            }
        }
        return -1;
    }

    private k33 c(b bVar, ByteBuffer byteBuffer) {
        i83 i83Var = bVar.b;
        FileInputStream fileInputStream = null;
        if (i83Var.h != null) {
            long j = i83Var.c;
            int i2 = bVar.g;
            int i3 = (int) (j + i2);
            int min = (int) Math.min(i83Var.d - i2, byteBuffer.remaining());
            if (min >= 0) {
                i83 i83Var2 = bVar.b;
                long j2 = i83Var2.d;
                byte[] bArr = i83Var2.h;
                if (j2 <= bArr.length) {
                    byteBuffer.put(bArr, i3, min);
                    bVar.g += min;
                    if (com.uploader.implement.a.d(4)) {
                        com.uploader.implement.a.a(4, "UploaderSession", this.g + " readFromEntity, from copy:" + min);
                    }
                    return null;
                }
            }
            return new k33("200", "11", "readFromBytes", false);
        }
        File file = i83Var.a;
        if (file != null && file.exists()) {
            long lastModified = file.lastModified();
            if (lastModified != bVar.b.b) {
                if (com.uploader.implement.a.d(8)) {
                    com.uploader.implement.a.a(8, "UploaderSession", this.g + " readFromEntity, file has been modified, origin:" + bVar.b.b + " current:" + lastModified);
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
                        int read = fileInputStream2.getChannel().read(byteBuffer, bVar.b.c + bVar.g);
                        if (read < 0) {
                            k33 k33Var = new k33("200", "3", "file read failed", false);
                            try {
                                fileInputStream2.close();
                            } catch (IOException e) {
                                if (com.uploader.implement.a.d(8)) {
                                    com.uploader.implement.a.b(8, "UploaderSession", this.g + " readFromEntity:", e);
                                }
                            }
                            return k33Var;
                        }
                        int i4 = (int) ((bVar.g + read) - bVar.b.d);
                        if (i4 > 0) {
                            byteBuffer.position(byteBuffer.position() - i4);
                            read -= i4;
                        }
                        if (read > 0) {
                            bVar.g += read;
                        }
                        try {
                            fileInputStream2.close();
                        } catch (IOException e2) {
                            if (com.uploader.implement.a.d(8)) {
                                com.uploader.implement.a.b(8, "UploaderSession", this.g + " readFromEntity:", e2);
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
                                if (com.uploader.implement.a.d(8)) {
                                    com.uploader.implement.a.b(8, "UploaderSession", this.g + " readFromEntity:", e4);
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
                                if (com.uploader.implement.a.d(8)) {
                                    com.uploader.implement.a.b(8, "UploaderSession", this.g + " readFromEntity:", e5);
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
        throw new UnsupportedOperationException("Method not decompiled: com.uploader.implement.d.c.d(int):void");
    }

    private void e(int i2, k33 k33Var) {
        b remove = this.c.remove(i2);
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderSession", this.g + " notifyError, request:" + remove.a.hashCode());
        }
        com.uploader.implement.d.a aVar = this.a;
        if (aVar != null) {
            aVar.b(this, remove.a, k33Var);
        }
    }

    private static void g(b bVar, p73 p73Var) {
        if (bVar.j == null) {
            bVar.j = ByteBuffer.allocate(128);
            bVar.k = p73Var.a;
        }
        int position = bVar.j.position() + p73Var.b.length;
        if (bVar.j.capacity() < position) {
            bVar.j.flip();
            bVar.j = ByteBuffer.allocate(position).put(bVar.j);
        }
        bVar.j.put(p73Var.b);
    }

    private static int h(com.uploader.implement.b.e eVar, ArrayList<a> arrayList) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (arrayList.get(i2).c[0].equals(eVar)) {
                return i2;
            }
        }
        return -1;
    }

    private k33 i(b bVar, ByteBuffer byteBuffer) {
        byte[] bArr = bVar.b.f;
        int min = Math.min(bArr.length - bVar.f, byteBuffer.remaining());
        if (min < 0) {
            return new k33("200", "1", "readFromBytes", false);
        }
        byteBuffer.put(bArr, bVar.f, min);
        bVar.f += min;
        return null;
    }

    private void o(com.uploader.implement.b.e eVar, int i2) {
        a aVar;
        int h = h(eVar, this.d);
        if (h == -1) {
            aVar = new a(8, this, eVar);
            this.d.add(aVar);
        } else {
            aVar = this.d.get(h);
            this.f.removeCallbacks(aVar);
        }
        this.f.postDelayed(aVar, (i2 / 102400) + 30000);
    }

    private void q(com.uploader.implement.b.e eVar) {
        int h = h(eVar, this.d);
        if (h == -1) {
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderSession", this.g + " clearTimeout, NO_POSITION, connection:" + eVar.hashCode());
                return;
            }
            return;
        }
        this.f.removeCallbacks(this.d.remove(h));
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderSession", this.g + " clearTimeout, connection:" + eVar.hashCode());
        }
    }

    @Override // com.uploader.implement.d.b
    public void a(@NonNull e eVar, boolean z) {
        if (this.b.remove(eVar)) {
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderSession", this.g + " cancel, waiting request:" + eVar.hashCode());
                return;
            }
            return;
        }
        int a2 = a(eVar, this.c);
        if (a2 == -1) {
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderSession", this.g + " cancel, no sending request:" + eVar.hashCode());
                return;
            }
            return;
        }
        boolean a3 = this.e.a(this, eVar, z);
        int h = h(this.c.remove(a2).c, this.d);
        if (h != -1) {
            this.f.removeCallbacks(this.d.remove(h));
        }
        if (com.uploader.implement.a.d(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.g);
            sb.append(" cancel, sendingList request");
            sb.append(eVar.hashCode());
            sb.append(" remove timeout:");
            sb.append(h != -1);
            sb.append(" unregister:");
            sb.append(a3);
            com.uploader.implement.a.a(2, "UploaderSession", sb.toString());
        }
    }

    void f(com.uploader.implement.b.e eVar, int i2, boolean z) {
        int b2 = b(eVar, this.c);
        if (b2 == -1) {
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderSession", this.g + " doSend, NO_POSITION, connection:" + eVar.hashCode());
                return;
            }
            return;
        }
        b bVar = this.c.get(b2);
        boolean b3 = bVar.b();
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderSession", this.g + " doSend, begin:" + z + " connection:" + eVar.hashCode() + " sendSequence:" + i2 + " isFinished:" + b3);
        }
        if (z) {
            com.uploader.implement.d.a aVar = this.a;
            if (aVar != null) {
                aVar.a(this, bVar.a, bVar.g);
            }
        } else if (!b3) {
            d(b2);
            return;
        } else {
            com.uploader.implement.d.a aVar2 = this.a;
            if (aVar2 != null) {
                aVar2.b(this, bVar.a);
            }
        }
        o(bVar.c, bVar.i);
    }

    void j(com.uploader.implement.b.e eVar) {
        this.d.remove(this);
        int b2 = b(eVar, this.c);
        if (b2 == -1) {
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderSession", this.g + " timeout, NO_POSITION, connection:" + eVar.hashCode());
                return;
            }
            return;
        }
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderSession", this.g + " timeout, connection:" + eVar.hashCode());
        }
        e(b2, new k33(MessageService.MSG_DB_COMPLETE, "2", "data send or receive timeout", true));
    }

    void k(com.uploader.implement.b.e eVar, k33 k33Var) {
        int b2 = b(eVar, this.c);
        if (b2 == -1) {
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderSession", this.g + " doError, NO_POSITION, connection:" + eVar.hashCode());
                return;
            }
            return;
        }
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderSession", this.g + " doError, connection:" + eVar.hashCode() + " error:" + k33Var.toString() + " sendingList.size:" + this.c.size());
        }
        b bVar = this.c.get(b2);
        bVar.a();
        q(bVar.c);
        e(b2, k33Var);
    }

    void l(com.uploader.implement.b.e eVar, p73 p73Var) {
        int b2 = b(eVar, this.c);
        if (b2 == -1) {
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderSession", this.g + " doReceive, NO_POSITION, connection:" + eVar.hashCode());
                return;
            }
            return;
        }
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderSession", this.g + " doReceive, sendingList.size:" + this.c.size() + " index:" + b2 + " connection:" + eVar.hashCode() + " data:" + p73Var.toString());
        }
        b bVar = this.c.get(b2);
        o(bVar.c, bVar.i);
        g(bVar, p73Var);
        ArrayList arrayList = null;
        do {
            Pair<f, Integer> a2 = bVar.a.a(bVar.k, bVar.j.array(), bVar.j.arrayOffset(), bVar.j.position());
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(a2);
            if (a2.first == null) {
                break;
            }
            bVar.j.flip();
            bVar.j.get(new byte[((Integer) a2.second).intValue()], 0, ((Integer) a2.second).intValue());
            bVar.j.compact();
        } while (bVar.j.position() >= 4);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            Object obj = pair.first;
            if (obj == null) {
                if (((Integer) pair.second).intValue() < 0) {
                    e(b2, new k33("400", "2", "response == null && divide < 0", true));
                    return;
                }
                return;
            }
            com.uploader.implement.d.a aVar = this.a;
            if (aVar != null) {
                aVar.a(this, bVar.a, (f) obj);
            }
        }
    }

    void m(com.uploader.implement.d.b bVar, e eVar, com.uploader.implement.b.e eVar2) {
        boolean z = !this.b.remove(eVar);
        boolean d = eVar2.d();
        if (com.uploader.implement.a.d(4)) {
            com.uploader.implement.a.a(4, "UploaderSession", this.g + " onAvailable.session:" + bVar.hashCode() + " request:" + eVar.hashCode() + " noWaitingRequest:" + z + " connection:" + eVar2.hashCode() + " needConnect:" + d + " target:" + eVar.a());
        }
        if (z) {
            return;
        }
        eVar2.a(this);
        b bVar2 = new b(eVar, eVar2);
        this.c.add(bVar2);
        if (d) {
            com.uploader.implement.d.a aVar = this.a;
            if (aVar != null) {
                aVar.c(this, bVar2.a);
            }
            eVar2.b();
            return;
        }
        com.uploader.implement.d.a aVar2 = this.a;
        if (aVar2 != null) {
            aVar2.e(this, bVar2.a);
        }
        d(this.c.size() - 1);
    }

    void n(com.uploader.implement.b.e eVar) {
        int b2 = b(eVar, this.c);
        if (b2 == -1) {
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderSession", this.g + " doConnect, NO_POSITION, connection:" + eVar.hashCode());
                return;
            }
            return;
        }
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderSession", this.g + " doConnect, connection:" + eVar.hashCode());
        }
        com.uploader.implement.d.a aVar = this.a;
        if (aVar != null) {
            aVar.d(this, this.c.get(b2).a);
        }
        com.uploader.implement.d.a aVar2 = this.a;
        if (aVar2 != null) {
            aVar2.e(this, this.c.get(b2).a);
        }
        d(b2);
    }

    void p(com.uploader.implement.b.e eVar) {
        int b2 = b(eVar, this.c);
        if (b2 == -1) {
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderSession", this.g + " doClose, NO_POSITION, connection:" + eVar.hashCode());
                return;
            }
            return;
        }
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderSession", this.g + " doClose, connection:" + eVar.hashCode());
        }
        eVar.a(null);
        b bVar = this.c.get(b2);
        bVar.a();
        q(bVar.c);
    }

    @Override // com.uploader.implement.b.b
    public void b(com.uploader.implement.b.e eVar, int i2) {
        this.f.post(new a(5, this, eVar, Integer.valueOf(i2)));
    }

    @Override // com.uploader.implement.d.b
    public void a(@NonNull e eVar) {
        this.b.add(eVar);
        boolean a2 = this.e.a(this, eVar, this);
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderSession", this.g + " send, request:" + eVar.hashCode() + " register:" + a2);
        }
    }

    @Override // com.uploader.implement.d.b
    public void a(@NonNull e eVar, @NonNull e eVar2, boolean z) {
        int indexOf = this.b.indexOf(eVar);
        if (indexOf != -1) {
            this.b.set(indexOf, eVar2);
            boolean a2 = this.e.a(this, eVar, eVar2, this, z);
            if (!a2) {
                this.e.a(this, eVar, z);
                this.e.a(this, eVar2, this);
            }
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderSession", this.g + " replace:" + a2 + " waiting request:" + eVar.hashCode());
                return;
            }
            return;
        }
        int a3 = a(eVar, this.c);
        if (a3 == -1) {
            this.b.add(eVar2);
            boolean a4 = this.e.a(this, eVar, eVar2, this, z);
            if (!a4) {
                this.e.a(this, eVar, z);
                this.e.a(this, eVar2, this);
            }
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderSession", this.g + " replace:" + a4 + " request:" + eVar.hashCode() + " newRequest:" + eVar2.hashCode());
                return;
            }
            return;
        }
        b remove = this.c.remove(a3);
        this.b.add(eVar2);
        boolean a5 = this.e.a(this, eVar, eVar2, this, z);
        if (!a5) {
            this.e.a(this, eVar, z);
            this.e.a(this, eVar2, this);
        }
        int h = h(remove.c, this.d);
        if (h != -1) {
            this.f.removeCallbacks(this.d.remove(h));
        }
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderSession", this.g + " replace:" + a5 + " sending request:" + eVar.hashCode() + " newRequest:" + eVar2.hashCode());
        }
    }

    @Override // com.uploader.implement.d.b
    public void a(com.uploader.implement.d.a aVar) {
        this.a = aVar;
    }

    @Override // com.uploader.implement.d.b
    public void a() {
        this.b.clear();
        this.c.clear();
        for (int size = this.d.size() - 1; size >= 0; size--) {
            this.f.removeCallbacks(this.d.remove(size));
        }
        this.e.a(this);
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderSession", this.g + " release");
        }
    }

    @Override // com.uploader.implement.b.b
    public void a(com.uploader.implement.b.e eVar) {
        this.f.post(new a(1, this, eVar));
    }

    @Override // com.uploader.implement.b.b
    public void a(com.uploader.implement.b.e eVar, k33 k33Var) {
        this.f.post(new a(3, this, eVar, k33Var));
    }

    @Override // com.uploader.implement.b.b
    public void a(com.uploader.implement.b.e eVar, p73 p73Var) {
        this.f.post(new a(4, this, eVar, p73Var));
    }

    @Override // com.uploader.implement.b.b
    public void a(com.uploader.implement.b.e eVar, int i2) {
        this.f.postDelayed(new a(6, this, eVar, Integer.valueOf(i2)), this.h.b.enableFlowControl() ? 100L : 0L);
    }

    private static int a(e eVar, ArrayList<b> arrayList) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (arrayList.get(i2).a.equals(eVar)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.uploader.implement.b.d
    public void a(com.uploader.implement.d.b bVar, e eVar, com.uploader.implement.b.e eVar2) {
        this.f.post(new a(7, this, bVar, eVar, eVar2));
    }
}
