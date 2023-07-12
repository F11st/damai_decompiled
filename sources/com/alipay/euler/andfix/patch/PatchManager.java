package com.alipay.euler.andfix.patch;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.euler.andfix.AndFix;
import com.alipay.euler.andfix.AndFixManager;
import com.alipay.euler.andfix.Compat;
import com.alipay.euler.andfix.exception.AndFixException;
import com.alipay.euler.andfix.log.Log;
import com.alipay.euler.andfix.log.Logger;
import com.alipay.euler.andfix.util.FileUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class PatchManager {
    public static final String SP_MD5 = "-md5";
    public static final String SP_NAME = "_andfix_";
    private boolean a;
    private String b;
    private String c;
    private final Context d;
    private AndFixManager e;
    private final File f;
    private final SortedSet<Patch> g;
    private final Map<String, ClassLoader> h;

    public PatchManager(Context context) {
        this(context, null);
    }

    private void a(Patch patch, ClassLoader classLoader, List<String> list, String str) {
        if (Compat.isSupport()) {
            Log.i("PatchManager", "fix: " + str);
            if (patch.getAddClasses(str) != null && patch.getAddClasses(str).size() > 0) {
                Log.i("PatchManager", "addClass: preLoadAddClasses");
                this.e.preLoadAddClasses(patch.getFile(), classLoader, patch.getAddClasses(str));
            }
            this.e.prepareClass(patch.getPrepareClasses(str), classLoader);
            Log.i("PatchManager", "makeClassesPublic : modifedClasses");
            this.e.makeClassesPublic(patch.getModifiedClasses(str), classLoader);
            Log.i("PatchManager", "makeClassesPublic : UsedClasses");
            this.e.makeClassesPublic(patch.getUsedClasses(str), classLoader);
            this.e.makeMethodsPublic(patch.getUsedMethods(str), classLoader);
            this.e.fix(patch.getFile(), classLoader, list);
        }
    }

    private boolean b() {
        if (this.f.exists() && this.f.isDirectory()) {
            for (File file : this.f.listFiles()) {
                if (file.getName().endsWith(".jar")) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private void c() {
        for (File file : this.f.listFiles()) {
            addPatch(file);
        }
    }

    private void d(Patch patch) {
        ClassLoader classLoader;
        Log.d("PatchManager", "loadPatch(patch=" + patch + jn1.BRACKET_END_STR);
        for (String str : patch.getPatchNames()) {
            if (this.h.containsKey(jn1.MUL)) {
                classLoader = this.d.getClassLoader();
            } else {
                classLoader = this.h.get(str);
            }
            if (classLoader != null) {
                a(patch, classLoader, patch.getClasses(str), str);
            }
        }
    }

    public Patch addPatch(File file) {
        Log.i("PatchManager", "addPatch(file=" + file + jn1.BRACKET_END_STR);
        if (file.getName().endsWith(".jar")) {
            initAndfixManager();
            try {
                Patch patch = new Patch(file);
                this.g.add(patch);
                return patch;
            } catch (IOException e) {
                throw new AndFixException("Failed to addPath(File=" + file + jn1.BRACKET_END_STR, e);
            }
        }
        return null;
    }

    public void cleanPatches(boolean z) {
        Log.w("PatchManager", "cleanPatches(force=" + z + jn1.BRACKET_END_STR);
        initAndfixManager();
        SharedPreferences.Editor edit = this.d.getSharedPreferences(SP_NAME, 0).edit();
        File[] listFiles = this.f.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                AndFixManager.removeOptFile(this.d, file);
                String name = file.getName();
                if (FileUtil.deleteFile(file)) {
                    Log.e("PatchManager", new RuntimeException(name + " delete success."));
                    edit.remove(name + "-md5");
                } else {
                    throw new AndFixException("File delete failed");
                }
            }
        }
        if (z) {
            edit.clear();
        }
        edit.commit();
    }

    public void clearPatches() {
        this.g.clear();
    }

    public String getPatchDir() {
        return this.f.getAbsolutePath();
    }

    public void init(String str, boolean z) {
        init(str, z, true);
    }

    public void initAndfixManager() {
        if (this.e != null) {
            return;
        }
        synchronized (this) {
            if (this.e != null) {
                return;
            }
            this.e = new AndFixManager(this.d, this.a, this.c);
        }
    }

    public void loadPatch(String str, ClassLoader classLoader) {
        this.h.put(str, classLoader);
        for (Patch patch : this.g) {
            if (patch.getPatchNames().contains(str)) {
                Log.d("PatchManager", "loadPatch().fix(patchName=" + str + ", patch=" + patch.getFile() + ", classLoader=" + classLoader + jn1.BRACKET_END_STR);
                a(patch, classLoader, patch.getClasses(str), str);
            }
        }
    }

    @Deprecated
    public void removeAllPatch() {
        cleanPatches(true);
    }

    public void rollback() {
        if (Compat.isSupport()) {
            this.g.clear();
            try {
                AndFix.rollback();
            } catch (Throwable th) {
                throw new AndFixException("rollback exception", th);
            }
        }
    }

    public PatchManager(Context context, Logger logger) {
        this(context, logger, null);
    }

    public void init(String str, boolean z, boolean z2) {
        this.b = str;
        this.a = z;
        if (!this.f.exists() && !this.f.mkdirs()) {
            Log.e("PatchManager", "patch dir create error.");
        } else if (!this.f.isDirectory()) {
            this.f.delete();
        } else {
            boolean b = b();
            if (b) {
                initAndfixManager();
            }
            SharedPreferences sharedPreferences = this.d.getSharedPreferences(SP_NAME, 0);
            String string = sharedPreferences.getString("version", null);
            Log.d("PatchManager", "PatchManager.init(ver=" + string + jn1.BRACKET_END_STR);
            if (string == null || !string.equalsIgnoreCase(this.b)) {
                if (b) {
                    cleanPatches(false);
                }
                sharedPreferences.edit().putString("version", this.b).commit();
            } else if (b && z2) {
                c();
            }
        }
    }

    public PatchManager(Context context, Logger logger, String str) {
        this.c = null;
        Log.setLogger(logger);
        this.d = context;
        if (TextUtils.isEmpty(str)) {
            this.f = new File(context.getFilesDir(), "apatch");
        } else {
            this.c = str;
            this.f = new File(context.getFilesDir(), this.c);
        }
        this.g = new ConcurrentSkipListSet();
        this.h = new ConcurrentHashMap();
    }

    public void addPatch(String str, boolean z) throws IOException {
        Patch addPatch;
        Log.d("PatchManager", "addPatch(path=" + str + ", immediately=" + z + jn1.BRACKET_END_STR);
        File file = new File(str);
        File file2 = new File(this.f, file.getName());
        if (!file.exists()) {
            Log.w("PatchManager", new FileNotFoundException(str));
            return;
        }
        if (file2.exists()) {
            Log.d("PatchManager", "patch [" + str + "] is already loaded.");
            for (Patch patch : this.g) {
                if (patch.getFile().getAbsoluteFile().equals(str)) {
                    return;
                }
            }
        } else {
            FileUtil.copyFile(file, file2);
        }
        if (!z || (addPatch = addPatch(file2)) == null) {
            return;
        }
        d(addPatch);
    }

    public void loadPatch(String str, Patch patch, ClassLoader classLoader) {
        this.h.put(str, classLoader);
        if (patch == null || !patch.getPatchNames().contains(str)) {
            return;
        }
        Log.d("PatchManager", "loadPatch().fix(patchName=" + str + ", patch=" + patch.getFile() + ", classLoader=" + classLoader + jn1.BRACKET_END_STR);
        a(patch, classLoader, patch.getClasses(str), str);
    }

    public void loadPatch() {
        this.h.put(jn1.MUL, this.d.getClassLoader());
        for (Patch patch : this.g) {
            for (String str : patch.getPatchNames()) {
                List<String> classes = patch.getClasses(str);
                Log.d("PatchManager", "loadPatch().fix(patchName=" + str + ", patch=" + patch.getFile() + jn1.BRACKET_END_STR);
                a(patch, this.d.getClassLoader(), classes, str);
            }
        }
    }

    @Deprecated
    public void addPatch(String str) throws IOException {
        addPatch(str, true);
    }
}
