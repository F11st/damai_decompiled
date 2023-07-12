package tb;

import android.annotation.TargetApi;
import android.os.StatFs;
import com.taobao.android.sopatch.storage.FileStorage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class oi0 {
    private static final Map<String, File> b = new HashMap();
    private static final FileStorage a = new ni0(eu0.d().b().getFilesDir());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    @TargetApi(14)
    /* renamed from: tb.oi0$a */
    /* loaded from: classes11.dex */
    public static class C9523a {
        private static final FileStorage a;

        static {
            File externalCacheDir = eu0.d().b().getExternalCacheDir();
            a = externalCacheDir != null ? new ni0(externalCacheDir) : new ee0();
        }
    }

    public static void a() {
        a.deleteInvalidFiles();
        C9523a.a.deleteInvalidFiles();
    }

    public static File b(me2 me2Var) {
        Map<String, File> map = b;
        File file = map.get(h(me2Var));
        if (file != null) {
            return file;
        }
        File soFile = a.getSoFile(me2Var);
        if (g(soFile) && f(soFile, me2Var.d())) {
            return soFile;
        }
        File soFile2 = C9523a.a.getSoFile(me2Var);
        if (g(soFile2)) {
            map.put(h(me2Var), soFile2);
            return soFile2;
        }
        return null;
    }

    public static File c() {
        File soPatchCacheFile = a.getSoPatchCacheFile();
        if (g(soPatchCacheFile)) {
            return soPatchCacheFile;
        }
        return null;
    }

    public static File d(String str, long j) {
        File tmpFile = a.getTmpFile(str);
        return (g(tmpFile) && f(tmpFile, j)) ? tmpFile : j(C9523a.a.getTmpFile(str));
    }

    public static File e(pe2 pe2Var) {
        Map<String, File> map = b;
        File file = map.get(i(pe2Var));
        if (file != null) {
            return file;
        }
        File zipFile = a.getZipFile(pe2Var);
        if (g(zipFile) && f(zipFile, pe2Var.f())) {
            return zipFile;
        }
        File zipFile2 = C9523a.a.getZipFile(pe2Var);
        if (g(zipFile2)) {
            map.put(i(pe2Var), zipFile2);
            return zipFile2;
        }
        return null;
    }

    private static boolean f(File file, long j) {
        if (file.length() >= j) {
            return true;
        }
        try {
            StatFs statFs = new StatFs(file.getParentFile().toString());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > j * 2;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean g(File file) {
        if (file != null) {
            try {
                if (file.exists() && file.canRead() && file.canWrite()) {
                    return file.isFile();
                }
                return false;
            } catch (Throwable th) {
                ob1.e(th);
            }
        }
        return false;
    }

    private static String h(me2 me2Var) {
        return me2Var.a() + me2Var.b();
    }

    private static String i(pe2 pe2Var) {
        return pe2Var.c();
    }

    private static File j(File file) {
        if (g(file)) {
            return file;
        }
        return null;
    }
}
