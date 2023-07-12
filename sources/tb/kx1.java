package tb;

import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class kx1 {
    public static String A = "finishLoadPage page:u4:u1*,duration:f,freeMemory:f,residentMemory:f,virtualMemory:f,cpuUsageOfApp:f,cpuUsageOfDevice:f";
    public static String B = "foreground";
    public static String C = "background";
    public static String D = "cpuUsage cpuUsageOfApp:f,cpuUsageOfDevice:f";
    public static String E = "memoryUsage freeMemory:f,residentMemory:f,virtualMemory:f";
    public static String F = "fps loadFps:f,useFps:f";
    public static String G = "tap x:f,y:f,isLongTouch:z";
    public static String H = "scroll beginX:f,endX:f,beginY:f,endY:f";
    public static String I = "receiveMemoryWarning level:f";
    public static String J = "jank";
    public static String K = "crash";
    public static String L = "gc";
    public static String M = "displayed";
    public static String N = "firstDraw";
    public static String O = "firstInteraction";
    public static String P = "usable duration:f";
    public static String Q = "launcherUsable duration:f";
    public static String R = "fling direction:u1";
    public static short a = 1;
    public static short b = 2;
    public static short c = 3;
    public static short d = 4;
    public static short e = 5;
    public static short f = 6;
    public static short g = 7;
    public static short h = 8;
    public static short i = 9;
    public static short j = 16;
    public static short k = 17;
    public static short l = 18;
    public static short m = 19;
    public static short n = 20;
    public static short o = 21;
    public static short p = 22;
    public static short q = 23;
    public static short r = 24;
    public static short s = 25;
    public static short t = 32;
    public static short u = 33;
    public static short v = 35;
    public static String w = "startupBegin firstInstall:z,isBackgroundLaunch:z,type:u4:u1*";
    public static String x = "startupEnd";
    public static String y = "openApplicationFromUrl url:u4:u1*";
    public static String z = "openPage page:u4:u1*,freeMemory:f,residentMemory:f,virtualMemory:f,cpuUsageOfApp:f,cpuUsageOfDevice:f";

    public static HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(Integer.toString(a), w);
        hashMap.put(Integer.toString(b), x);
        hashMap.put(Integer.toString(c), y);
        hashMap.put(Integer.toString(d), z);
        hashMap.put(Integer.toString(e), A);
        hashMap.put(Integer.toString(f), B);
        hashMap.put(Integer.toString(g), C);
        hashMap.put(Integer.toString(h), D);
        hashMap.put(Integer.toString(i), E);
        hashMap.put(Integer.toString(j), F);
        hashMap.put(Integer.toString(k), G);
        hashMap.put(Integer.toString(l), H);
        hashMap.put(Integer.toString(m), I);
        hashMap.put(Integer.toString(n), J);
        hashMap.put(Integer.toString(o), K);
        hashMap.put(Integer.toString(p), L);
        hashMap.put(Integer.toString(q), M);
        hashMap.put(Integer.toString(r), N);
        hashMap.put(Integer.toString(s), O);
        hashMap.put(Integer.toString(t), P);
        hashMap.put(Integer.toString(u), R);
        hashMap.put(Integer.toString(v), Q);
        return hashMap;
    }
}
