package tb;

import androidx.annotation.NonNull;
import com.taobao.android.tlog.protocol.model.joint.point.StartupJointPoint;
import com.taobao.monitor.procedure.ProcedureImpl;
import com.taobao.weex.annotation.JSMethod;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class xu1 implements ProcedureImpl.IProcedureLifeCycle {
    public static final String DEFAULT_SAVE_DIR = "apm";

    private void a(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length < 10) {
            return;
        }
        e(listFiles, 0, listFiles.length - 1);
        for (int i = 0; i < (listFiles.length - 10) + 1; i++) {
            listFiles[i].delete();
        }
    }

    private void b(File file) {
        if (file.exists()) {
            return;
        }
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String c(com.taobao.monitor.procedure.f fVar) {
        Object obj = fVar.m().get("pageName");
        return obj == null ? "null" : (String) obj;
    }

    @NonNull
    public static File d() {
        StringBuilder sb = new StringBuilder();
        sb.append(uu1.d().a().getCacheDir());
        String str = File.separator;
        sb.append(str);
        sb.append(DEFAULT_SAVE_DIR);
        sb.append(str);
        return new File(sb.toString());
    }

    public static void e(File[] fileArr, int i, int i2) {
        if (i >= i2) {
            return;
        }
        File file = fileArr[i];
        int i3 = i;
        int i4 = i2;
        while (i3 < i4) {
            while (fileArr[i4].lastModified() >= file.lastModified() && i3 < i4) {
                i4--;
            }
            while (fileArr[i3].lastModified() <= file.lastModified() && i3 < i4) {
                i3++;
            }
            File file2 = fileArr[i4];
            fileArr[i4] = fileArr[i3];
            fileArr[i3] = file2;
        }
        fileArr[i] = fileArr[i3];
        fileArr[i3] = file;
        e(fileArr, i, i4 - 1);
        e(fileArr, i4 + 1, i2);
    }

    private void f(com.taobao.monitor.procedure.f fVar) {
        if (fVar.v() == null) {
            return;
        }
        if ("pageLoad".equals(fVar.o()) || StartupJointPoint.TYPE.equals(fVar.o())) {
            File d = d();
            a(d);
            g(d, fVar.o() + JSMethod.NOT_SET + c(fVar) + JSMethod.NOT_SET + fVar.n() + ".json", com.taobao.monitor.network.a.a(fVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.Object[]] */
    private void g(File file, String str, String str2) {
        FileOutputStream fileOutputStream;
        File file2 = new File((File) file, str);
        b(file2);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (FileNotFoundException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
            }
            try {
                do {
                } while (fileOutputStream.getChannel().write(Charset.forName("utf8").encode(str2)) != 0);
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                pb1.a("ProcedureStorage", "存储成功", file.getPath(), str);
            } catch (FileNotFoundException e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                file = file.getPath();
                pb1.a("ProcedureStorage", new Object[]{"存储成功", file, str});
            } catch (IOException e6) {
                e = e6;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                pb1.a("ProcedureStorage", "存储成功", file.getPath(), str);
            } catch (Throwable th) {
                th = th;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                pb1.a("ProcedureStorage", "存储成功", file.getPath(), str);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.taobao.monitor.procedure.ProcedureImpl.IProcedureLifeCycle
    public void begin(com.taobao.monitor.procedure.f fVar) {
    }

    @Override // com.taobao.monitor.procedure.ProcedureImpl.IProcedureLifeCycle
    public void end(com.taobao.monitor.procedure.f fVar) {
        try {
            f(fVar);
        } catch (Exception e) {
            e30.a("ProcedureStorage", e);
        }
    }

    @Override // com.taobao.monitor.procedure.ProcedureImpl.IProcedureLifeCycle
    public void event(com.taobao.monitor.procedure.f fVar, rf0 rf0Var) {
    }

    @Override // com.taobao.monitor.procedure.ProcedureImpl.IProcedureLifeCycle
    public void stage(com.taobao.monitor.procedure.f fVar, qf2 qf2Var) {
    }
}
