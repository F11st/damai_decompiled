package com.alipay.euler.andfix;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.ali.user.mobile.app.constant.UTConstant;
import com.alipay.euler.andfix.annotation.MethodReplace;
import com.alipay.euler.andfix.exception.AndFixException;
import com.alipay.euler.andfix.log.Log;
import com.alipay.euler.andfix.security.SecurityChecker;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.jn1;
import tb.m80;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AndFixManager {
    private static Map<String, Class<?>> e = new ConcurrentHashMap();
    private static String f;
    private final Context a;
    private boolean b;
    private SecurityChecker c;
    private File d;

    public AndFixManager(Context context, boolean z) {
        this(context, z, "apatch_opt");
    }

    private String a(Method method, String str) {
        Class<?>[] parameterTypes;
        String str2;
        String str3;
        if (method == null || str == null || (parameterTypes = method.getParameterTypes()) == null) {
            return null;
        }
        if (parameterTypes.length == 0) {
            str2 = "[]";
        } else {
            String str4 = jn1.ARRAY_START_STR;
            for (Class<?> cls : parameterTypes) {
                String name = cls.getName();
                if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
                    str3 = str4 + "Z";
                } else if (name.equals("char")) {
                    str3 = str4 + "C";
                } else if (name.equals(TypedValues.Custom.S_FLOAT)) {
                    str3 = str4 + UTConstant.Args.UT_SUCCESS_F;
                } else if (name.equals("int")) {
                    str3 = str4 + "I";
                } else if (name.equals("long")) {
                    str3 = str4 + "J";
                } else if (name.equals("short")) {
                    str3 = str4 + ExifInterface.LATITUDE_SOUTH;
                } else if (name.equals("double")) {
                    str3 = str4 + "D";
                } else if (name.equals("byte")) {
                    str3 = str4 + "B";
                } else {
                    if (!name.endsWith(";") && !name.startsWith(jn1.ARRAY_START_STR)) {
                        name = "L" + name + ";";
                    }
                    str3 = str4 + name.replaceAll("\\.", "/");
                }
                str4 = str3 + "|";
            }
            if (str4.endsWith("|")) {
                str4 = str4.substring(0, str4.length() - 1);
            }
            str2 = str4 + jn1.ARRAY_END_STR;
        }
        return str + ":" + method.getName() + ":" + str2;
    }

    private void b(Class<?> cls, ClassLoader classLoader) {
        Method[] declaredMethods;
        Log.d("AndFixManager", "fixClass : " + cls.getName());
        for (Method method : cls.getDeclaredMethods()) {
            MethodReplace methodReplace = (MethodReplace) method.getAnnotation(MethodReplace.class);
            if (methodReplace != null) {
                String clazz = methodReplace.clazz();
                String method2 = methodReplace.method();
                if (!c(clazz) && !c(method2)) {
                    f(classLoader, clazz, method2, method);
                }
            }
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors != null) {
            for (Constructor<?> constructor : declaredConstructors) {
                MethodReplace methodReplace2 = (MethodReplace) constructor.getAnnotation(MethodReplace.class);
                if (methodReplace2 != null) {
                    String clazz2 = methodReplace2.clazz();
                    String method3 = methodReplace2.method();
                    if (!c(clazz2) && !c(method3)) {
                        e(classLoader, clazz2, method3, constructor);
                    }
                }
            }
        }
    }

    private static boolean c(String str) {
        return str == null || str.length() <= 0;
    }

    private void d(Class cls) {
        if ((cls.getModifiers() & 1) == 0) {
            AndFix.makeClassPublic(cls);
        }
    }

    private void e(ClassLoader classLoader, String str, String str2, Constructor<?> constructor) {
        try {
            String str3 = str + m80.DINAMIC_PREFIX_AT + classLoader.toString();
            Class<?> cls = e.get(str3);
            if (cls == null) {
                cls = AndFix.initTargetClass(classLoader.loadClass(str));
            }
            if (cls != null) {
                e.put(str3, cls);
                AndFix.addReplaceConstructor(cls.getDeclaredConstructor(constructor.getParameterTypes()), constructor);
            }
        } catch (Throwable th) {
            throw new AndFixException("replaceMethod failed", th);
        }
    }

    private void f(ClassLoader classLoader, String str, String str2, Method method) {
        try {
            Log.i("AndFixManager", "replaceMathod -> class : " + str + " and method : " + str2);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(m80.DINAMIC_PREFIX_AT);
            sb.append(classLoader.toString());
            String sb2 = sb.toString();
            Class<?> cls = e.get(sb2);
            if (cls == null) {
                Log.i("AndFixManager", "load and init class : " + str);
                cls = AndFix.initTargetClass(classLoader.loadClass(str));
            }
            if (cls != null) {
                e.put(sb2, cls);
                AndFix.addReplaceMethod(cls.getDeclaredMethod(str2, method.getParameterTypes()), method);
            }
        } catch (Throwable th) {
            Log.e("AndFixManager", "replaceMethod failed : " + th.getMessage());
            throw new AndFixException("replaceMethod failed", th);
        }
    }

    public static synchronized void removeOptFile(Context context, File file) {
        File file2;
        synchronized (AndFixManager.class) {
            if (TextUtils.isEmpty(f)) {
                file2 = new File(context.getFilesDir(), "apatch_opt");
            } else {
                File filesDir = context.getFilesDir();
                file2 = new File(filesDir, f + File.separator + "apatch_opt");
            }
            File file3 = new File(file2, file.getName());
            if (file3.exists() && !file3.delete()) {
                Log.e("AndFixManager", file3.getName() + " delete error.");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0069 A[Catch: IOException -> 0x00a1, all -> 0x00c6, TryCatch #2 {IOException -> 0x00a1, blocks: (B:12:0x0018, B:14:0x003a, B:23:0x005b, B:25:0x0069, B:26:0x006e, B:27:0x0077, B:29:0x007d, B:31:0x0085, B:39:0x0097, B:40:0x009e, B:17:0x0044, B:19:0x0051), top: B:52:0x0018, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007d A[Catch: IOException -> 0x00a1, all -> 0x00c6, TryCatch #2 {IOException -> 0x00a1, blocks: (B:12:0x0018, B:14:0x003a, B:23:0x005b, B:25:0x0069, B:26:0x006e, B:27:0x0077, B:29:0x007d, B:31:0x0085, B:39:0x0097, B:40:0x009e, B:17:0x0044, B:19:0x0051), top: B:52:0x0018, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void fix(java.io.File r7, java.lang.ClassLoader r8, java.util.List<java.lang.String> r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.b     // Catch: java.lang.Throwable -> Lc6
            if (r0 != 0) goto L7
            monitor-exit(r6)
            return
        L7:
            com.alipay.euler.andfix.security.SecurityChecker r0 = r6.c     // Catch: java.lang.Throwable -> Lc6
            boolean r0 = r0.verifyApk(r7)     // Catch: java.lang.Throwable -> Lc6
            if (r0 != 0) goto L18
            java.lang.String r7 = "AndFixManager"
            java.lang.String r8 = "AndFixManager.fix() verifyApk: failed, return."
            com.alipay.euler.andfix.log.Log.e(r7, r8)     // Catch: java.lang.Throwable -> Lc6
            monitor-exit(r6)
            return
        L18:
            java.lang.String r0 = "AndFixManager"
            java.lang.String r1 = "start fix classes"
            com.alipay.euler.andfix.log.Log.i(r0, r1)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            java.lang.String r0 = r7.getName()     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            java.lang.String r1 = "jar"
            java.lang.String r2 = "odex"
            java.lang.String r0 = r0.replace(r1, r2)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            java.io.File r1 = new java.io.File     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            java.io.File r2 = r6.d     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            r1.<init>(r2, r0)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            boolean r0 = r1.exists()     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L5a
            com.alipay.euler.andfix.security.SecurityChecker r0 = r6.c     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            boolean r0 = r0.verifyOpt(r1)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            if (r0 == 0) goto L44
            r0 = 0
            goto L5b
        L44:
            java.lang.String r0 = "AndFixManager"
            java.lang.String r4 = "AndFixManager.fix() verifyOpt: failed, try to delete opt file."
            com.alipay.euler.andfix.log.Log.w(r0, r4)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            boolean r0 = r1.delete()     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            if (r0 != 0) goto L5a
            java.lang.String r9 = "AndFixManager"
            java.lang.String r0 = "AndFixManager.fix() verifyOpt: failed to delete opt file. return."
            com.alipay.euler.andfix.log.Log.e(r9, r0)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            monitor-exit(r6)
            return
        L5a:
            r0 = 1
        L5b:
            java.lang.String r4 = r7.getAbsolutePath()     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            java.lang.String r5 = r1.getAbsolutePath()     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            dalvik.system.DexFile r2 = dalvik.system.DexFile.loadDex(r4, r5, r2)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            if (r0 == 0) goto L6e
            com.alipay.euler.andfix.security.SecurityChecker r0 = r6.c     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            r0.saveOptSig(r1)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
        L6e:
            com.alipay.euler.andfix.AndFixManager$1 r0 = new com.alipay.euler.andfix.AndFixManager$1     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            r0.<init>(r6, r8)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            java.util.Enumeration r1 = r2.entries()     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
        L77:
            boolean r2 = r1.hasMoreElements()     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            if (r2 == 0) goto L9f
            java.lang.Object r2 = r1.nextElement()     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            if (r9 == 0) goto L8c
            boolean r4 = r9.contains(r2)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            if (r4 != 0) goto L8c
            goto L77
        L8c:
            java.lang.Class r2 = java.lang.Class.forName(r2, r3, r0)     // Catch: java.lang.Throwable -> L96
            if (r2 == 0) goto L77
            r6.b(r2, r8)     // Catch: java.lang.Throwable -> L96
            goto L77
        L96:
            r9 = move-exception
            com.alipay.euler.andfix.exception.AndFixException r0 = new com.alipay.euler.andfix.exception.AndFixException     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            java.lang.String r1 = "init patch class failed"
            r0.<init>(r1, r9)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
            throw r0     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lc6
        L9f:
            monitor-exit(r6)
            return
        La1:
            r9 = move-exception
            com.alipay.euler.andfix.exception.AndFixException r0 = new com.alipay.euler.andfix.exception.AndFixException     // Catch: java.lang.Throwable -> Lc6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc6
            r1.<init>()     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r2 = "Field to fix (file="
            r1.append(r2)     // Catch: java.lang.Throwable -> Lc6
            r1.append(r7)     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r7 = ", classLoader="
            r1.append(r7)     // Catch: java.lang.Throwable -> Lc6
            r1.append(r8)     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r7 = ")"
            r1.append(r7)     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r7 = r1.toString()     // Catch: java.lang.Throwable -> Lc6
            r0.<init>(r7, r9)     // Catch: java.lang.Throwable -> Lc6
            throw r0     // Catch: java.lang.Throwable -> Lc6
        Lc6:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.euler.andfix.AndFixManager.fix(java.io.File, java.lang.ClassLoader, java.util.List):void");
    }

    public void makeClassesPublic(List<String> list, ClassLoader classLoader) {
        if (list == null) {
            return;
        }
        Log.d("AndFixManager", "makeClassesPublic start");
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    Log.i("AndFixManager", "makeClassesPublic : " + str);
                    Class<?> loadClass = classLoader.loadClass(str);
                    if (loadClass != null) {
                        d(loadClass);
                        AndFix.initFields(loadClass);
                    } else {
                        throw new ClassNotFoundException(str + " can not be found!");
                    }
                } catch (Throwable th) {
                    Log.e("AndFixManager", "makeClassesPublic failed " + str + " " + th.getMessage());
                    throw new AndFixException("makeClassesPublic failed " + str, th);
                }
            }
        }
    }

    public void makeMethodsPublic(List<String> list, ClassLoader classLoader) {
        if (list == null) {
            return;
        }
        Log.d("AndFixManager", "makeMethodsPublic start");
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("\\:");
                if (split.length < 4) {
                    continue;
                } else {
                    String replace = str.replace(" ", "");
                    int i = 0;
                    if (split[1].equalsIgnoreCase("<init>")) {
                        try {
                            Class<?> loadClass = classLoader.loadClass(split[0]);
                            d(loadClass);
                            Constructor<?>[] declaredConstructors = loadClass.getDeclaredConstructors();
                            while (i < declaredConstructors.length) {
                                if ((declaredConstructors[i].getModifiers() & 1) == 0) {
                                    AndFix.makeConstructorPublic(declaredConstructors[i]);
                                }
                                i++;
                            }
                        } catch (Throwable th) {
                            Log.e("AndFixManager", "makeMethodsPublic.construtor failed " + str + " exception : " + th.getMessage());
                            throw new AndFixException("makeMethodsPublic.construtor failed " + str, th);
                        }
                    } else {
                        try {
                            String str2 = split[0];
                            Class<?> loadClass2 = classLoader.loadClass(str2);
                            d(loadClass2);
                            Method[] declaredMethods = loadClass2.getDeclaredMethods();
                            while (true) {
                                if (i >= declaredMethods.length) {
                                    break;
                                }
                                if (TextUtils.equals(split[1], declaredMethods[i].getName()) && (declaredMethods[i].getModifiers() & 1) == 0) {
                                    String a = a(declaredMethods[i], str2);
                                    if (replace.startsWith(a)) {
                                        Log.i("AndFixManager", "make " + a + " public");
                                        AndFix.makeMethodPublic(declaredMethods[i]);
                                        break;
                                    }
                                }
                                i++;
                            }
                        } catch (Throwable th2) {
                            Log.e("AndFixManager", "makeMethodsPublic.method failed : " + th2.getMessage());
                            throw new AndFixException("makeMethodsPublic.method failed", th2);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0060 A[Catch: all -> 0x0090, IOException -> 0x0092, TryCatch #2 {IOException -> 0x0092, blocks: (B:6:0x0007, B:9:0x000f, B:11:0x0031, B:20:0x0052, B:22:0x0060, B:23:0x0065, B:24:0x006e, B:26:0x0074, B:32:0x0086, B:33:0x008d, B:14:0x003b, B:16:0x0048), top: B:48:0x0007, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074 A[Catch: all -> 0x0090, IOException -> 0x0092, TRY_LEAVE, TryCatch #2 {IOException -> 0x0092, blocks: (B:6:0x0007, B:9:0x000f, B:11:0x0031, B:20:0x0052, B:22:0x0060, B:23:0x0065, B:24:0x006e, B:26:0x0074, B:32:0x0086, B:33:0x008d, B:14:0x003b, B:16:0x0048), top: B:48:0x0007, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void preLoadAddClasses(java.io.File r7, java.lang.ClassLoader r8, java.util.List<java.lang.String> r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 == 0) goto Lb9
            if (r8 == 0) goto Lb9
            if (r9 == 0) goto Lb9
            int r0 = r9.size()     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            if (r0 != 0) goto Lf
            goto Lb9
        Lf:
            java.lang.String r0 = "AndFixManager"
            java.lang.String r1 = "start preLoadAddClasses"
            com.alipay.euler.andfix.log.Log.i(r0, r1)     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            java.lang.String r0 = r7.getName()     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            java.lang.String r1 = "jar"
            java.lang.String r2 = "odex"
            java.lang.String r0 = r0.replace(r1, r2)     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            java.io.File r2 = r6.d     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            r1.<init>(r2, r0)     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            boolean r0 = r1.exists()     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L51
            com.alipay.euler.andfix.security.SecurityChecker r0 = r6.c     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            boolean r0 = r0.verifyOpt(r1)     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            if (r0 == 0) goto L3b
            r0 = 0
            goto L52
        L3b:
            java.lang.String r0 = "AndFixManager"
            java.lang.String r4 = "AndFixManager.fix() verifyOpt: failed, try to delete opt file."
            com.alipay.euler.andfix.log.Log.w(r0, r4)     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            boolean r0 = r1.delete()     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            if (r0 != 0) goto L51
            java.lang.String r9 = "AndFixManager"
            java.lang.String r0 = "AndFixManager.fix() verifyOpt: failed to delete opt file. return."
            com.alipay.euler.andfix.log.Log.e(r9, r0)     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            monitor-exit(r6)
            return
        L51:
            r0 = 1
        L52:
            java.lang.String r4 = r7.getAbsolutePath()     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            java.lang.String r5 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            dalvik.system.DexFile r2 = dalvik.system.DexFile.loadDex(r4, r5, r2)     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            if (r0 == 0) goto L65
            com.alipay.euler.andfix.security.SecurityChecker r0 = r6.c     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            r0.saveOptSig(r1)     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
        L65:
            com.alipay.euler.andfix.AndFixManager$2 r0 = new com.alipay.euler.andfix.AndFixManager$2     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            r0.<init>(r6, r8)     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            java.util.Enumeration r1 = r2.entries()     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
        L6e:
            boolean r2 = r1.hasMoreElements()     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            if (r2 == 0) goto L8e
            java.lang.Object r2 = r1.nextElement()     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            boolean r4 = r9.contains(r2)     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            if (r4 != 0) goto L81
            goto L6e
        L81:
            java.lang.Class.forName(r2, r3, r0)     // Catch: java.lang.Throwable -> L85
            goto L6e
        L85:
            r9 = move-exception
            com.alipay.euler.andfix.exception.AndFixException r0 = new com.alipay.euler.andfix.exception.AndFixException     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            java.lang.String r1 = "preLoadAddClasses : init patch class failed"
            r0.<init>(r1, r9)     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
            throw r0     // Catch: java.lang.Throwable -> L90 java.io.IOException -> L92
        L8e:
            monitor-exit(r6)
            return
        L90:
            r7 = move-exception
            goto Lb7
        L92:
            r9 = move-exception
            com.alipay.euler.andfix.exception.AndFixException r0 = new com.alipay.euler.andfix.exception.AndFixException     // Catch: java.lang.Throwable -> L90
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L90
            r1.<init>()     // Catch: java.lang.Throwable -> L90
            java.lang.String r2 = "Field to preLoadAddClasses (file="
            r1.append(r2)     // Catch: java.lang.Throwable -> L90
            r1.append(r7)     // Catch: java.lang.Throwable -> L90
            java.lang.String r7 = ", classLoader="
            r1.append(r7)     // Catch: java.lang.Throwable -> L90
            r1.append(r8)     // Catch: java.lang.Throwable -> L90
            java.lang.String r7 = ")"
            r1.append(r7)     // Catch: java.lang.Throwable -> L90
            java.lang.String r7 = r1.toString()     // Catch: java.lang.Throwable -> L90
            r0.<init>(r7, r9)     // Catch: java.lang.Throwable -> L90
            throw r0     // Catch: java.lang.Throwable -> L90
        Lb7:
            monitor-exit(r6)
            throw r7
        Lb9:
            monitor-exit(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.euler.andfix.AndFixManager.preLoadAddClasses(java.io.File, java.lang.ClassLoader, java.util.List):void");
    }

    public void prepareClass(List<String> list, ClassLoader classLoader) {
        if (list == null) {
            return;
        }
        Log.d("AndFixManager", "prepareClass start");
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    Log.i("AndFixManager", "prepareClass : " + str);
                    Class.forName(str, true, classLoader);
                } catch (Throwable th) {
                    Log.e("AndFixManager", "prepareClass exception " + str + " " + th.getMessage());
                    throw new AndFixException("prepareClass exception " + str, th);
                }
            }
        }
    }

    public AndFixManager(Context context, boolean z, String str) {
        this.b = false;
        this.a = context;
        boolean isSupport = Compat.isSupport();
        this.b = isSupport;
        if (isSupport) {
            this.c = new SecurityChecker(context, z);
            if (TextUtils.isEmpty(str)) {
                this.d = new File(context.getFilesDir(), "apatch_opt");
            } else {
                f = str;
                this.d = new File(context.getFilesDir(), f);
            }
            if (!this.d.exists() && !this.d.mkdirs()) {
                this.b = false;
                Log.e("AndFixManager", "opt dir create error.");
            } else if (this.d.isDirectory()) {
            } else {
                this.d.delete();
                this.b = false;
            }
        }
    }
}
