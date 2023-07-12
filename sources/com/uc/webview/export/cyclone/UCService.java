package com.uc.webview.export.cyclone;

import android.content.Context;
import android.util.Pair;
import com.taobao.weex.ui.component.WXComponent;
import com.uc.webview.export.cyclone.service.UCServiceInterface;
import com.uc.webview.export.cyclone.service.UCUnSevenZip;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: Taobao */
@Constant
/* loaded from: classes11.dex */
public class UCService {
    private static final int MAX_CONFIG_CONTENT_LENGTH = 4096;
    private static final String LOG_TAG = "UCService";
    private static final int VERBOSE_TOKEN = UCLogger.createToken("v", LOG_TAG);
    private static final int DEBUG_TOKEN = UCLogger.createToken("d", LOG_TAG);
    private static final int WARNN_TOKEN = UCLogger.createToken(WXComponent.PROP_FS_WRAP_CONTENT, LOG_TAG);
    private static Context s_ctx = null;
    private static final UCSingleton<ConcurrentHashMap<Class<? extends UCServiceInterface>, UCServiceInterface>> s_serviceImpls = new UCSingleton<>(ConcurrentHashMap.class, new Class[0]);
    private static final UCSingleton<ConcurrentHashMap<String, Class<? extends UCServiceInterface>>> s_services = new UCSingleton<>(ConcurrentHashMap.class, new Class[0]);
    private static final UCSingleton<ConcurrentHashMap<Class<? extends UCServiceInterface>, ConcurrentLinkedQueue<Pair<String, String>>>> s_serviceImplQueues = new UCSingleton<>(ConcurrentHashMap.class, new Class[0]);

    static {
        registerDefaultImpl(UCUnSevenZip.class, "com.uc.webview.export.cyclone.service.UCUnSevenZipMultiThreadImpl");
        registerDefaultImpl(com.uc.webview.export.cyclone.service.UCVmsize.class, "com.uc.webview.export.cyclone.service.UCVmsizeImpl");
    }

    private static String getAsciiContents(File file) throws Exception {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[4096];
            fileInputStream.read(bArr);
            String str = new String(bArr, "US-ASCII");
            UCCyclone.close(fileInputStream);
            return str;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            UCCyclone.close(fileInputStream2);
            throw th;
        }
    }

    private static UCServiceInterface getImpl(Class<? extends UCServiceInterface> cls) {
        UCSingleton<ConcurrentHashMap<Class<? extends UCServiceInterface>, UCServiceInterface>> uCSingleton = s_serviceImpls;
        if (uCSingleton.getInst() == null) {
            return null;
        }
        return uCSingleton.getInst().get(cls);
    }

    private static ConcurrentLinkedQueue<Pair<String, String>> getImplQueue(Class<? extends UCServiceInterface> cls) {
        UCSingleton<ConcurrentHashMap<Class<? extends UCServiceInterface>, ConcurrentLinkedQueue<Pair<String, String>>>> uCSingleton = s_serviceImplQueues;
        if (uCSingleton.getInst() == null) {
            return null;
        }
        return uCSingleton.getInst().get(cls);
    }

    private static Class<? extends UCServiceInterface> getService(String str) {
        UCSingleton<ConcurrentHashMap<String, Class<? extends UCServiceInterface>>> uCSingleton = s_services;
        if (uCSingleton.getInst() == null) {
            return null;
        }
        return uCSingleton.getInst().get(str);
    }

    public static <T extends UCServiceInterface> T initImpl(Class<T> cls) {
        ConcurrentLinkedQueue<Pair<String, String>> implQueue;
        T t = (T) getImpl(cls);
        if (t == null && (implQueue = getImplQueue(cls)) != null) {
            synchronized (cls) {
                while (!implQueue.isEmpty()) {
                    Pair<String, String> poll = implQueue.poll();
                    ClassLoader classLoader = null;
                    if (poll.second == null) {
                        classLoader = cls.getClassLoader();
                    } else if (s_ctx != null) {
                        String parent = new File((String) poll.second).getParent();
                        classLoader = new DexClassLoader((String) poll.second, parent, parent, cls.getClassLoader());
                    }
                    Class<?> cls2 = Class.forName((String) poll.first, true, classLoader);
                    int i = DEBUG_TOKEN;
                    UCLogger.print(i, "initImpl " + cls + "=>" + cls2 + " with " + ((String) poll.first) + "," + ((String) poll.second), new Throwable[0]);
                }
                t = (T) getImpl(cls);
            }
        }
        return t;
    }

    private static void registerDefaultImpl(Class<? extends UCServiceInterface> cls, String str) {
        int i = VERBOSE_TOKEN;
        UCLogger.print(i, "registerDefaultImpl " + cls + "," + str, new Throwable[0]);
        try {
            registerService(cls.getSimpleName(), cls);
            registerImpl(cls, str, null);
        } catch (Throwable th) {
            UCLogger create = UCLogger.create(WXComponent.PROP_FS_WRAP_CONTENT, LOG_TAG);
            if (create != null) {
                create.print("registerDefaultImpl register exception:" + th, new Throwable[0]);
            }
        }
    }

    public static void registerImpl(Class<? extends UCServiceInterface> cls, String str, String str2) throws Exception {
        int i = DEBUG_TOKEN;
        UCLogger.print(i, "registerImpl " + cls + "," + str + "," + str2, new Throwable[0]);
        if (cls != null) {
            if (str != null && str.length() > 0) {
                UCSingleton<ConcurrentHashMap<Class<? extends UCServiceInterface>, ConcurrentLinkedQueue<Pair<String, String>>>> uCSingleton = s_serviceImplQueues;
                ConcurrentLinkedQueue<Pair<String, String>> concurrentLinkedQueue = uCSingleton.initInst(new Object[0]).get(cls);
                if (concurrentLinkedQueue == null) {
                    synchronized (cls) {
                        concurrentLinkedQueue = uCSingleton.initInst(new Object[0]).get(cls);
                        if (concurrentLinkedQueue == null) {
                            concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                            uCSingleton.initInst(new Object[0]).put(cls, concurrentLinkedQueue);
                        }
                    }
                }
                if (getImpl(cls) == null) {
                    concurrentLinkedQueue.add(new Pair<>(str, str2));
                    return;
                }
                throw new UCKnownException(2018, "registerImpl: the service has instanced. Please registers service impl before use it");
            }
            throw new UCKnownException(2016, "registerImpl param null.");
        }
        throw new UCKnownException(2016, "registerImpl param null.");
    }

    public static void registerService(String str, Class<? extends UCServiceInterface> cls) throws Exception {
        int i = DEBUG_TOKEN;
        UCLogger.print(i, "registerService " + str + "," + cls, new Throwable[0]);
        UCSingleton<ConcurrentHashMap<String, Class<? extends UCServiceInterface>>> uCSingleton = s_services;
        Class<? extends UCServiceInterface> cls2 = uCSingleton.initInst(new Object[0]).get(str);
        if (cls2 != null && cls2 != cls) {
            throw new UCKnownException(2017, "registerService service name '" + str + "' is registered by '" + cls2 + "' but now '" + cls + "' requested.");
        }
        uCSingleton.initInst(new Object[0]).put(str, cls);
    }

    public static int search(Context context, File file) {
        File[] listFiles;
        if (file == null || !file.isDirectory()) {
            return 0;
        }
        s_ctx = context.getApplicationContext();
        LinkedList linkedList = new LinkedList();
        do {
            UCLogger.print(DEBUG_TOKEN, "searching " + file, new Throwable[0]);
            for (File file2 : file.listFiles()) {
                if (file2 != null && file2.exists() && file2.getName().replace(".", "").replace("/", "").replace(" ", "").length() != 0) {
                    if (file2.isDirectory()) {
                        linkedList.add(file2);
                    } else if (file2.isFile() && file2.getName().startsWith("cyclone.UCService.") && file2.length() < 4096) {
                        String[] split = file2.getName().split("\\.", 4);
                        if (split.length >= 4) {
                            String str = split[2];
                            String str2 = split[3];
                            int i = DEBUG_TOKEN;
                            UCLogger.print(i, "search config file:" + str + "=>" + str2, new Throwable[0]);
                            File file3 = new File(file, str2);
                            if (file3.isFile()) {
                                try {
                                    Class<? extends UCServiceInterface> service = getService(str);
                                    if (service == null) {
                                        UCLogger.print(WARNN_TOKEN, "search service:" + str + " not registered.", new Throwable[0]);
                                    } else {
                                        String asciiContents = getAsciiContents(file2);
                                        if (asciiContents != null && asciiContents.length() != 0) {
                                            String[] split2 = asciiContents.split(",");
                                            if (split2.length == 0) {
                                                UCLogger.print(WARNN_TOKEN, "search no impl class defined in config.", new Throwable[0]);
                                            } else {
                                                UCLogger.print(i, "search config contents:" + asciiContents, new Throwable[0]);
                                                for (String str3 : split2) {
                                                    String trim = str3.trim();
                                                    if (trim.length() != 0) {
                                                        try {
                                                            registerImpl(service, trim, file3.getAbsolutePath());
                                                        } catch (Exception e) {
                                                            UCLogger.print(WARNN_TOKEN, "search exception", e);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        UCLogger.print(WARNN_TOKEN, "search config contents is null.", new Throwable[0]);
                                    }
                                } catch (Exception e2) {
                                    UCLogger.print(WARNN_TOKEN, "search exception", e2);
                                }
                            }
                        }
                    }
                }
            }
            file = (File) linkedList.poll();
        } while (!linkedList.isEmpty());
        return 0;
    }

    public static boolean registerImpl(Class<? extends UCServiceInterface> cls, UCServiceInterface uCServiceInterface) throws Exception {
        int i = DEBUG_TOKEN;
        UCLogger.print(i, "registerImpl " + cls + "=>" + uCServiceInterface, new Throwable[0]);
        if (cls != null) {
            if (uCServiceInterface == null) {
                s_serviceImpls.initInst(new Object[0]).remove(cls);
                return true;
            }
            UCSingleton<ConcurrentHashMap<Class<? extends UCServiceInterface>, UCServiceInterface>> uCSingleton = s_serviceImpls;
            UCServiceInterface uCServiceInterface2 = uCSingleton.initInst(new Object[0]).get(cls);
            if (uCServiceInterface2 == null || uCServiceInterface2.getServiceVersion() < uCServiceInterface.getServiceVersion()) {
                if (cls.isInstance(uCServiceInterface)) {
                    uCSingleton.initInst(new Object[0]).put(cls, uCServiceInterface);
                    return true;
                }
                throw new UCKnownException(2014, "registerImpl: impl" + uCServiceInterface + " is not compatible with interface " + cls + ".");
            }
            return false;
        }
        throw new UCKnownException(2013, "registerImpl: serviceInterface is null.");
    }
}
