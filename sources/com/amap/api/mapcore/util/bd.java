package com.amap.api.mapcore.util;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class bd extends Thread {
    private Context a;
    private bp b;

    public bd(Context context) {
        this.a = context;
        this.b = bp.a(context);
    }

    private bk a(File file) {
        String a = eq.a(file);
        bk bkVar = new bk();
        bkVar.b(a);
        return bkVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0087, code lost:
        if (r10 != false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0090 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(java.util.ArrayList<java.lang.String> r14, java.lang.String r15) {
        /*
            r13 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.Context r1 = r13.a
            java.lang.String r1 = com.amap.api.mapcore.util.eq.a(r1)
            r0.append(r1)
            r0.append(r15)
            java.io.File r15 = new java.io.File
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            boolean r0 = r15.exists()
            if (r0 != 0) goto L21
            return
        L21:
            java.io.File[] r15 = r15.listFiles()
            if (r15 != 0) goto L28
            return
        L28:
            int r0 = r15.length
            r1 = 0
            r2 = 0
        L2b:
            if (r2 >= r0) goto L93
            r3 = r15[r2]
            boolean r4 = r3.isDirectory()
            if (r4 == 0) goto L90
            java.lang.String r4 = r3.getName()
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L90
            java.lang.String[] r3 = r3.list()
            if (r3 == 0) goto L90
            int r5 = r3.length
            r6 = 1
            if (r5 >= r6) goto L4a
            goto L90
        L4a:
            boolean r5 = r14.contains(r4)
            if (r5 != 0) goto L90
            java.lang.String r5 = "a0"
            boolean r5 = r4.equals(r5)
            java.lang.String r7 = "m1.ans"
            if (r5 == 0) goto L6a
            int r5 = r3.length
            r8 = 0
        L5c:
            if (r8 >= r5) goto L8a
            r9 = r3[r8]
            boolean r9 = r7.equals(r9)
            if (r9 == 0) goto L67
            goto L8b
        L67:
            int r8 = r8 + 1
            goto L5c
        L6a:
            int r5 = r3.length
            r8 = 0
            r9 = 0
            r10 = 0
        L6e:
            if (r8 >= r5) goto L85
            r11 = r3[r8]
            boolean r12 = r7.equals(r11)
            if (r12 == 0) goto L79
            r9 = 1
        L79:
            java.lang.String r12 = "m3.ans"
            boolean r11 = r12.equals(r11)
            if (r11 == 0) goto L82
            r10 = 1
        L82:
            int r8 = r8 + 1
            goto L6e
        L85:
            if (r9 == 0) goto L8a
            if (r10 == 0) goto L8a
            goto L8b
        L8a:
            r6 = 0
        L8b:
            if (r6 == 0) goto L90
            r14.add(r4)
        L90:
            int r2 = r2 + 1
            goto L2b
        L93:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bd.b(java.util.ArrayList, java.lang.String):void");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a() {
        bk a;
        String c;
        int indexOf;
        String c2;
        int indexOf2;
        String c3;
        int indexOf3;
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<bk> a2 = this.b.a();
        a(arrayList, "vmap/");
        a(arrayList, "map/");
        b(arrayList, "map/");
        ArrayList<String> b = b();
        Iterator<bk> it = a2.iterator();
        while (it.hasNext()) {
            bk next = it.next();
            if (next != null && next.d() != null) {
                int i = next.l;
                boolean z = true;
                if (i == 4 || i == 7) {
                    boolean contains = arrayList.contains(next.i());
                    if (contains || (c = bx.c(next.g())) == null || (indexOf = arrayList.indexOf(c)) == -1) {
                        z = contains;
                    } else {
                        arrayList.set(indexOf, next.i());
                    }
                    if (!z) {
                        this.b.b(next);
                    }
                } else {
                    boolean z2 = false;
                    if (i != 0 && i != 1) {
                        if (i == 3 && next.h() != 0) {
                            z2 = (b.contains(next.f()) || b.contains(next.i())) ? true : true;
                            if (z2 || (c3 = bx.c(next.g())) == null || (indexOf3 = b.indexOf(c3)) == -1) {
                                z = z2;
                            } else {
                                b.set(indexOf3, next.i());
                            }
                            if (!z) {
                                this.b.b(next);
                            }
                        }
                    } else {
                        z2 = (b.contains(next.f()) || b.contains(next.i())) ? true : true;
                        if (z2 || (c2 = bx.c(next.g())) == null || (indexOf2 = b.indexOf(c2)) == -1) {
                            z = z2;
                        } else {
                            b.set(indexOf2, next.i());
                        }
                        if (!z) {
                            this.b.b(next);
                        }
                    }
                }
            }
        }
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            if (!a(next2, a2) && (a = a(next2)) != null) {
                this.b.a(a);
            }
        }
        ba a3 = ba.a(this.a);
        if (a3 != null) {
            a3.a((ArrayList<bk>) null);
        }
    }

    private ArrayList<String> b() {
        File[] listFiles;
        String name;
        int lastIndexOf;
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(eq.c(this.a));
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.getName().endsWith(".zip") && (lastIndexOf = (name = file2.getName()).lastIndexOf(46)) > -1 && lastIndexOf < name.length()) {
                    arrayList.add(name.substring(0, lastIndexOf));
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    private bk a(String str) {
        if (str.equals("quanguo")) {
            str = "quanguogaiyaotu";
        }
        ba a = ba.a(this.a);
        bk bkVar = null;
        if (a != null) {
            String f = a.f(str);
            File[] listFiles = new File(eq.c(this.a)).listFiles();
            if (listFiles == null) {
                return null;
            }
            for (File file : listFiles) {
                if (((file.getName().contains(f) || file.getName().contains(str)) && file.getName().endsWith(".zip.tmp.dt")) && (bkVar = a(file)) != null && bkVar.d() != null) {
                    return bkVar;
                }
            }
        }
        return bkVar;
    }

    private boolean a(String str, ArrayList<bk> arrayList) {
        Iterator<bk> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().i())) {
                return true;
            }
        }
        return false;
    }

    private void a(ArrayList<String> arrayList, String str) {
        File[] listFiles;
        String name;
        int lastIndexOf;
        File file = new File(eq.b(this.a) + str);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.getName().endsWith(".dat") && (lastIndexOf = (name = file2.getName()).lastIndexOf(46)) > -1 && lastIndexOf < name.length()) {
                    String substring = name.substring(0, lastIndexOf);
                    if (!arrayList.contains(substring)) {
                        arrayList.add(substring);
                    }
                }
            }
        }
    }
}
