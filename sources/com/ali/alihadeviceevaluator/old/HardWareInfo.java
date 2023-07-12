package com.ali.alihadeviceevaluator.old;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.security.realidentity.a.AbstractC3840a;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import tb.gu0;
import tb.k4;
import tb.qm1;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class HardWareInfo {
    public String d;
    public String e;
    public int f;
    public float g;
    public String h;
    public String i;
    public long j;
    public float k;
    public float[] l;
    public String m;
    String n;
    boolean o;
    private qm1 p = new qm1();
    public float c = k4.d().c().a;
    public int a = k4.d().c().b;
    public int b = k4.d().c().c;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    class OnlineGLSurfaceView extends GLSurfaceView {
        C2939a mRenderer;

        public OnlineGLSurfaceView(Context context) {
            super(context);
            setEGLConfigChooser(8, 8, 8, 8, 0, 0);
            HardWareInfo.this.getClass();
            C2939a c2939a = new C2939a();
            this.mRenderer = c2939a;
            setRenderer(c2939a);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.ali.alihadeviceevaluator.old.HardWareInfo$a */
    /* loaded from: classes17.dex */
    class C2939a implements GLSurfaceView.Renderer {
        C2939a() {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            try {
                HardWareInfo.this.h = gl10.glGetString(7937);
                HardWareInfo.this.i = gl10.glGetString(7936);
                HardWareInfo.this.b();
                try {
                    HardWareInfo hardWareInfo = HardWareInfo.this;
                    hardWareInfo.j = hardWareInfo.f();
                } catch (Throwable unused) {
                }
                HardWareInfo.this.p.a(HardWareInfo.this);
            } catch (Throwable unused2) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0192 -> B:67:0x01a1). Please submit an issue!!! */
    public HardWareInfo(Context context) {
        BufferedReader bufferedReader;
        this.f = 0;
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            this.n = filesDir.getAbsolutePath() + "/deviceInfo";
        } else {
            this.n = "";
        }
        File file = new File(this.n);
        if (file.exists()) {
            this.o = true;
            BufferedReader bufferedReader2 = null;
            BufferedReader bufferedReader3 = null;
            bufferedReader2 = null;
            try {
            } catch (IOException e) {
                e.printStackTrace();
                bufferedReader2 = bufferedReader2;
            }
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    try {
                        this.d = bufferedReader.readLine();
                        this.e = bufferedReader.readLine();
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            this.f = Integer.parseInt(readLine);
                        }
                        String readLine2 = bufferedReader.readLine();
                        if (readLine2 != null) {
                            this.g = Float.parseFloat(readLine2);
                        }
                        String readLine3 = bufferedReader.readLine();
                        if (readLine3 != null) {
                            float parseFloat = Float.parseFloat(readLine3);
                            this.k = parseFloat;
                            if (parseFloat <= 0.0f) {
                                this.k = this.g;
                            }
                        }
                        String readLine4 = bufferedReader.readLine();
                        if (this.l == null) {
                            this.l = new float[d()];
                        }
                        if (readLine4 != null) {
                            try {
                                String[] split = readLine4.split(",");
                                if (split != null && split.length > 0) {
                                    for (int i = 0; i < split.length; i++) {
                                        this.l[i] = Float.parseFloat(split[i]);
                                    }
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        this.h = bufferedReader.readLine();
                        this.i = bufferedReader.readLine();
                        String readLine5 = bufferedReader.readLine();
                        if (readLine5 != null) {
                            this.j = Long.parseLong(readLine5);
                        }
                        try {
                            String readLine6 = bufferedReader.readLine();
                            if (!TextUtils.isEmpty(readLine6)) {
                                this.m = readLine6;
                            } else {
                                this.m = c();
                            }
                        } catch (Throwable unused) {
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("load local file succ: cpuBrand=");
                        sb.append(this.d);
                        sb.append(", cpuName=");
                        sb.append(this.e);
                        sb.append(",cpuCount=");
                        sb.append(this.f);
                        sb.append(",maxFreq=");
                        sb.append(this.g);
                        sb.append(",minFreq=");
                        sb.append(this.k);
                        sb.append(",freqCount");
                        sb.append(this.l.length);
                        sb.append(",GpuName");
                        sb.append(this.h);
                        sb.append(",GpuBrand=");
                        sb.append(this.i);
                        sb.append(",GpuFreq=");
                        sb.append(this.j);
                        sb.append(",CpuArch=");
                        String str = this.m;
                        sb.append(str);
                        Log.d(gu0.TAG, sb.toString());
                        bufferedReader.close();
                        bufferedReader2 = str;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    bufferedReader3 = bufferedReader;
                    Log.e(gu0.TAG, "load local file failed!!");
                    e.printStackTrace();
                    bufferedReader2 = bufferedReader3;
                    if (bufferedReader3 != null) {
                        bufferedReader3.close();
                        bufferedReader2 = bufferedReader3;
                    }
                    d();
                    e();
                    h();
                    c();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        d();
        e();
        h();
        c();
    }

    void b() {
    }

    public String c() {
        String str;
        int lastIndexOf;
        String str2 = "UnKnown";
        if (!TextUtils.isEmpty(this.m)) {
            return this.m;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
            String readLine = bufferedReader.readLine();
            while (true) {
                if (readLine == null) {
                    str = "UnKnown";
                    break;
                } else if (!readLine.contains("AArch") && !readLine.contains("ARM") && !readLine.contains("Intel(R)") && !readLine.contains("model name")) {
                    readLine = bufferedReader.readLine();
                } else {
                    int indexOf = readLine.indexOf(": ");
                    if (indexOf >= 0) {
                        readLine = readLine.substring(indexOf + 2);
                        if (!readLine.contains("Intel(R)")) {
                            lastIndexOf = readLine.indexOf(32);
                        } else {
                            lastIndexOf = readLine.lastIndexOf(41) + 1;
                        }
                        if (lastIndexOf > 0) {
                            str = readLine.substring(0, lastIndexOf);
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            bufferedReader.close();
            str2 = str;
        } catch (Exception unused) {
        }
        this.m = str2;
        return str2;
    }

    public int d() {
        if (this.f == 0) {
            this.f = Runtime.getRuntime().availableProcessors();
        }
        return this.f;
    }

    void e() {
        String str;
        String upperCase = Build.HARDWARE.toUpperCase();
        if (TextUtils.isEmpty(upperCase)) {
            return;
        }
        if (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.d)) {
            if (upperCase.contains("EXYNOS")) {
                str = upperCase.replace("samsung", "");
            } else {
                str = null;
                try {
                    Method declaredMethod = Class.forName("android.os.Build").getDeclaredMethod("getString", String.class);
                    declaredMethod.setAccessible(true);
                    String str2 = (String) declaredMethod.invoke(Build.class, "ro.board.platform");
                    if (str2 != null) {
                        try {
                            if (str2.equals("mtk")) {
                                str2 = upperCase;
                            }
                        } catch (Exception unused) {
                        }
                    }
                    str = str2;
                } catch (Exception unused2) {
                }
                if (upperCase.length() >= 4 && (TextUtils.isEmpty(str) || str.equals("unknown") || str.contains("samsungexynos") || str.contains("mrvl"))) {
                    str = upperCase;
                }
            }
            if (str != null) {
                str = str.toUpperCase();
            }
            if (str == null) {
                return;
            }
            if (!str.contains("EXYNOS") && !str.contains("SMDK") && !str.contains("UNIVERSAL")) {
                if (!str.contains("MSM") && !str.contains("APQ") && !str.contains("QSD") && !str.contains("SDM")) {
                    if (!str.contains("REDHOOKBAY") && !str.contains("MOOREFIELD") && !str.contains("MERRIFIELD")) {
                        if (str.contains("MT")) {
                            this.d = "联发科";
                        } else if (str.contains("OMAP")) {
                            this.d = "德州仪器";
                        } else if (str.contains("PXA")) {
                            this.d = "Marvell";
                        } else if (!str.contains("HI") && !str.contains("K3")) {
                            if (!str.contains("SP") && !str.contains(AbstractC3840a.X)) {
                                if (!str.contains("TEGRA") && !str.contains("NVIDIA")) {
                                    if (str.startsWith("LC")) {
                                        this.d = "联芯科技";
                                    } else {
                                        this.d = upperCase;
                                    }
                                } else {
                                    this.d = "NVIDIA";
                                }
                            } else {
                                this.d = "展讯";
                            }
                        } else {
                            this.d = "华为海思";
                        }
                    } else {
                        this.d = "英特尔";
                    }
                } else {
                    this.d = "高通";
                }
            } else {
                this.d = "三星";
            }
            this.e = str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0071, code lost:
        r8 = new java.io.File(r2[r3].getAbsolutePath() + "/max_freq");
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0091, code lost:
        if (r8.exists() != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0093, code lost:
        r8 = new java.io.File(r2[r3].getAbsolutePath() + "/max_gpuclk");
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b3, code lost:
        if (r8.exists() == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b5, code lost:
        r2 = new java.io.FileReader(r8);
        r3 = new java.io.BufferedReader(r2).readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c3, code lost:
        if (r3 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c5, code lost:
        r6 = java.lang.Long.parseLong(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cb, code lost:
        if (r6 <= 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cd, code lost:
        r6 = (r6 / 1000) / 1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d1, code lost:
        r2.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    long f() {
        /*
            r11 = this;
            r0 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Exception -> Lda
            java.lang.String r3 = "/sys/devices/platform/gpusysfs/gpu_max_clock"
            r2.<init>(r3)     // Catch: java.lang.Exception -> Lda
            boolean r3 = r2.exists()     // Catch: java.lang.Exception -> Lda
            if (r3 != 0) goto L16
            java.io.File r2 = new java.io.File     // Catch: java.lang.Exception -> Lda
            java.lang.String r3 = "/sys/devices/platform/gpusysfs/max_freq"
            r2.<init>(r3)     // Catch: java.lang.Exception -> Lda
        L16:
            boolean r3 = r2.exists()     // Catch: java.lang.Exception -> Lda
            r4 = 1000(0x3e8, double:4.94E-321)
            if (r3 == 0) goto L44
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Exception -> Lda
            r3.<init>(r2)     // Catch: java.lang.Exception -> Lda
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Exception -> Lda
            r2.<init>(r3)     // Catch: java.lang.Exception -> Lda
            java.lang.String r2 = r2.readLine()     // Catch: java.lang.Exception -> Lda
            if (r2 == 0) goto L3b
            long r6 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Exception -> Lda
            int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r2 <= 0) goto L3c
            long r8 = r6 / r4
            long r6 = r8 / r4
            goto L3c
        L3b:
            r6 = r0
        L3c:
            r3.close()     // Catch: java.lang.Exception -> Ld8
            int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r2 <= 0) goto L45
            return r6
        L44:
            r6 = r0
        L45:
            java.io.File r2 = new java.io.File     // Catch: java.lang.Exception -> Ld8
            java.lang.String r3 = "/sys/class/devfreq/"
            r2.<init>(r3)     // Catch: java.lang.Exception -> Ld8
            boolean r3 = r2.exists()     // Catch: java.lang.Exception -> Ld8
            if (r3 == 0) goto Ldb
            boolean r3 = r2.isDirectory()     // Catch: java.lang.Exception -> Ld8
            if (r3 == 0) goto Ldb
            java.io.File[] r2 = r2.listFiles()     // Catch: java.lang.Exception -> Ld8
            if (r2 != 0) goto L5f
            return r0
        L5f:
            r3 = 0
        L60:
            int r8 = r2.length     // Catch: java.lang.Exception -> Ld8
            if (r3 >= r8) goto Ldb
            r8 = r2[r3]     // Catch: java.lang.Exception -> Ld8
            java.lang.String r8 = r8.getName()     // Catch: java.lang.Exception -> Ld8
            java.lang.String r9 = "kgsl"
            boolean r8 = r8.contains(r9)     // Catch: java.lang.Exception -> Ld8
            if (r8 == 0) goto Ld5
            java.io.File r8 = new java.io.File     // Catch: java.lang.Exception -> Ld8
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld8
            r9.<init>()     // Catch: java.lang.Exception -> Ld8
            r10 = r2[r3]     // Catch: java.lang.Exception -> Ld8
            java.lang.String r10 = r10.getAbsolutePath()     // Catch: java.lang.Exception -> Ld8
            r9.append(r10)     // Catch: java.lang.Exception -> Ld8
            java.lang.String r10 = "/max_freq"
            r9.append(r10)     // Catch: java.lang.Exception -> Ld8
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> Ld8
            r8.<init>(r9)     // Catch: java.lang.Exception -> Ld8
            boolean r9 = r8.exists()     // Catch: java.lang.Exception -> Ld8
            if (r9 != 0) goto Laf
            java.io.File r8 = new java.io.File     // Catch: java.lang.Exception -> Ld8
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld8
            r9.<init>()     // Catch: java.lang.Exception -> Ld8
            r2 = r2[r3]     // Catch: java.lang.Exception -> Ld8
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Exception -> Ld8
            r9.append(r2)     // Catch: java.lang.Exception -> Ld8
            java.lang.String r2 = "/max_gpuclk"
            r9.append(r2)     // Catch: java.lang.Exception -> Ld8
            java.lang.String r2 = r9.toString()     // Catch: java.lang.Exception -> Ld8
            r8.<init>(r2)     // Catch: java.lang.Exception -> Ld8
        Laf:
            boolean r2 = r8.exists()     // Catch: java.lang.Exception -> Ld8
            if (r2 == 0) goto Ldb
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Exception -> Ld8
            r2.<init>(r8)     // Catch: java.lang.Exception -> Ld8
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Exception -> Ld8
            r3.<init>(r2)     // Catch: java.lang.Exception -> Ld8
            java.lang.String r3 = r3.readLine()     // Catch: java.lang.Exception -> Ld8
            if (r3 == 0) goto Ld1
            long r6 = java.lang.Long.parseLong(r3)     // Catch: java.lang.Exception -> Ld8
            int r3 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r3 <= 0) goto Ld1
            long r8 = r6 / r4
            long r8 = r8 / r4
            r6 = r8
        Ld1:
            r2.close()     // Catch: java.lang.Exception -> Ld8
            goto Ldb
        Ld5:
            int r3 = r3 + 1
            goto L60
        Ld8:
            goto Ldb
        Lda:
            r6 = r0
        Ldb:
            int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r2 != 0) goto Le5
            java.lang.String r0 = "/sys/devices/"
            long r6 = r11.g(r0)
        Le5:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.alihadeviceevaluator.old.HardWareInfo.f():long");
    }

    long g(String str) {
        long j;
        File file;
        long j2 = 0;
        try {
            File file2 = new File(str);
            if (file2.exists() && file2.isDirectory()) {
                File[] listFiles = file2.listFiles();
                if (listFiles == null) {
                    return 0L;
                }
                j = 0;
                for (File file3 : listFiles) {
                    try {
                        if (file3 != null && file3.getName().contains("kgsl") && file3.isDirectory()) {
                            j = g(file3.getAbsolutePath());
                            if (j > 0) {
                                return j;
                            }
                        }
                    } catch (Exception unused) {
                        j2 = j;
                    }
                }
            } else {
                j = 0;
            }
            file = new File(str + "/max_freq");
            if (!file.exists()) {
                file = new File(str + "/max_gpuclk");
            }
        } catch (Exception unused2) {
        }
        if (file.exists()) {
            FileReader fileReader = new FileReader(file);
            String readLine = new BufferedReader(fileReader).readLine();
            if (readLine != null) {
                long parseLong = Long.parseLong(readLine);
                if (parseLong > 0) {
                    try {
                        j = (parseLong / 1000) / 1000;
                    } catch (Exception unused3) {
                        j2 = parseLong;
                    }
                } else {
                    j2 = parseLong;
                    fileReader.close();
                    return j2;
                }
            }
            j2 = j;
            fileReader.close();
            return j2;
        }
        return j;
    }

    public float h() {
        float f = this.g;
        if (f <= 0.0f || this.l == null) {
            if (this.l == null) {
                this.l = new float[d()];
            }
            for (int i = 0; i < d(); i++) {
                try {
                    File file = new File("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq");
                    if (file.exists()) {
                        FileReader fileReader = new FileReader(file);
                        String readLine = new BufferedReader(fileReader).readLine();
                        fileReader.close();
                        if (readLine != null) {
                            float parseLong = ((float) Long.parseLong(readLine)) / 1000000.0f;
                            this.l[i] = parseLong;
                            if (this.g < parseLong) {
                                this.g = parseLong;
                            }
                            float f2 = this.k;
                            if (f2 == 0.0f) {
                                this.k = parseLong;
                            } else if (f2 > parseLong) {
                                this.k = parseLong;
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (this.k == 0.0f) {
                this.k = this.g;
            }
            if (this.o) {
                this.o = false;
                i();
            }
            return this.g;
        }
        return f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [float[]] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00d3 -> B:45:0x00e5). Please submit an issue!!! */
    public void i() {
        if (this.o || this.h == null) {
            return;
        }
        this.o = true;
        File file = new File(this.n);
        if (file.exists()) {
            file.delete();
        }
        BufferedWriter bufferedWriter = null;
        try {
        } catch (IOException e) {
            e.printStackTrace();
            bufferedWriter = bufferedWriter;
        }
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
                try {
                    bufferedWriter2.write(this.d);
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(this.e);
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(String.valueOf(this.f));
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(String.valueOf(this.g));
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(String.valueOf(this.k));
                    bufferedWriter2.newLine();
                    StringBuilder sb = new StringBuilder(50);
                    ?? r2 = this.l;
                    if (r2 != 0 && (r2 = r2.length) > 0) {
                        r2 = 0;
                        while (true) {
                            float[] fArr = this.l;
                            if (r2 >= fArr.length) {
                                break;
                            }
                            sb.append(fArr[r2]);
                            if (r2 < this.l.length - 1) {
                                sb.append(',');
                            }
                            r2++;
                        }
                    }
                    bufferedWriter2.write(sb.toString());
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(this.h);
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(this.i);
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(String.valueOf(this.j));
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(String.valueOf(this.m));
                    bufferedWriter2.newLine();
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    bufferedWriter = r2;
                } catch (Exception e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    e.printStackTrace();
                    this.o = false;
                    bufferedWriter = bufferedWriter;
                    if (bufferedWriter != null) {
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        bufferedWriter = bufferedWriter;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.flush();
                            bufferedWriter.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
