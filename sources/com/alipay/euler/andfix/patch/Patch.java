package com.alipay.euler.andfix.patch;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Patch implements Comparable<Patch> {
    private final File a;
    private String b;
    private Date c;
    private Map<String, List<String>> d;
    private Map<String, List<String>> e;
    private Map<String, List<String>> f;
    private Map<String, List<String>> g;
    private Map<String, List<String>> h;
    private Map<String, List<String>> i;

    public Patch(File file) throws IOException {
        this.a = file;
        b();
    }

    private String a(String str, String str2) {
        return str.substring(0, str.length() - str2.length());
    }

    private void b() throws IOException {
        InputStream inputStream;
        JarFile jarFile;
        JarFile jarFile2 = null;
        InputStream inputStream2 = null;
        try {
            jarFile = new JarFile(this.a);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            inputStream2 = jarFile.getInputStream(jarFile.getJarEntry("META-INF/PATCH.MF"));
            Attributes mainAttributes = new Manifest(inputStream2).getMainAttributes();
            this.b = mainAttributes.getValue("Patch-Name");
            this.c = new Date(mainAttributes.getValue("Created-Time"));
            this.d = new HashMap();
            this.e = new HashMap();
            this.f = new HashMap();
            this.g = new HashMap();
            this.h = new HashMap();
            this.i = new HashMap();
            Iterator<Object> it = mainAttributes.keySet().iterator();
            while (it.hasNext()) {
                Attributes.Name name = (Attributes.Name) it.next();
                String name2 = name.toString();
                if (name2.endsWith("-Patch-Classes")) {
                    this.d.put(a(name2, "-Patch-Classes"), Arrays.asList(mainAttributes.getValue(name).split(",")));
                } else if (name2.endsWith("-Prepare-Classes")) {
                    this.e.put(a(name2, "-Prepare-Classes"), Arrays.asList(mainAttributes.getValue(name).split(",")));
                } else if (name2.endsWith("-Modified-Classes")) {
                    this.g.put(a(name2, "-Modified-Classes"), Arrays.asList(mainAttributes.getValue(name).split(",")));
                } else if (name2.endsWith("-Used-Classes")) {
                    this.h.put(a(name2, "-Used-Classes"), Arrays.asList(mainAttributes.getValue(name).split(",")));
                } else if (name2.endsWith("-Used-Methods")) {
                    this.f.put(a(name2, "-Used-Methods"), Arrays.asList(mainAttributes.getValue(name).split(",")));
                } else if (name2.endsWith("-add-classes")) {
                    this.i.put(a(name2, "-add-classes"), Arrays.asList(mainAttributes.getValue(name).split(",")));
                }
            }
            jarFile.close();
            if (inputStream2 != null) {
                inputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStream2;
            jarFile2 = jarFile;
            if (jarFile2 != null) {
                jarFile2.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public List<String> getAddClasses(String str) {
        return this.i.get(str);
    }

    public List<String> getClasses(String str) {
        return this.d.get(str);
    }

    public File getFile() {
        return this.a;
    }

    public List<String> getModifiedClasses(String str) {
        return this.g.get(str);
    }

    public Set<String> getPatchNames() {
        return this.d.keySet();
    }

    public List<String> getPrepareClasses(String str) {
        return this.e.get(str);
    }

    public Date getTime() {
        return this.c;
    }

    public List<String> getUsedClasses(String str) {
        return this.h.get(str);
    }

    public List<String> getUsedMethods(String str) {
        return this.f.get(str);
    }

    public String toString() {
        return "Patch{mTime=" + this.c + ", mName='" + this.b + "', mFile=" + this.a + '}';
    }

    @Override // java.lang.Comparable
    public int compareTo(Patch patch) {
        return this.c.compareTo(patch.getTime());
    }
}
