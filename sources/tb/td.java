package tb;

import android.util.Log;
import cn.damai.tool2.bufferkit.BufferListener;
import cn.damai.tool2.bufferkit.BufferRequest;
import cn.damai.tool2.bufferkit.BufferSwitch;
import cn.damai.tool2.bufferkit.MainThreadListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class td {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BUFFER_GROUP_1 = "BUFFER_GROUP_1";
    public static final String BUFFER_GROUP_2 = "BUFFER_GROUP_2";
    public static final String BUFFER_GROUP_3 = "BUFFER_GROUP_3";
    private static BufferSwitch f;
    private static final Map<String, vd> a = new HashMap();
    private static final Map<String, List<BufferListener>> b = new HashMap();
    private static final Map<String, List<BufferListener>> c = new HashMap();
    private static final Map<String, BufferRequest> d = new HashMap();
    private static final List<BufferListener> e = new ArrayList(5);
    private static boolean g = true;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* renamed from: tb.td$a */
    /* loaded from: classes7.dex */
    public static final class C9713a<T> implements BufferListener<T> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        C9713a(String str) {
            this.a = str;
        }

        @Override // cn.damai.tool2.bufferkit.BufferListener
        public void doRequestAsync() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "32959223")) {
                ipChange.ipc$dispatch("32959223", new Object[]{this});
            }
        }

        @Override // cn.damai.tool2.bufferkit.BufferListener
        public void onFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-366702938")) {
                ipChange.ipc$dispatch("-366702938", new Object[]{this, str, str2});
            } else {
                td.e(this.a, new vd(str, str2));
            }
        }

        @Override // cn.damai.tool2.bufferkit.BufferListener
        public void onSuccess(T t) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "951250899")) {
                ipChange.ipc$dispatch("951250899", new Object[]{this, t});
            } else {
                td.e(this.a, new vd(t));
            }
        }
    }

    private static void b(String str, boolean z, BufferListener bufferListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1582502700")) {
            ipChange.ipc$dispatch("-1582502700", new Object[]{str, Boolean.valueOf(z), bufferListener});
        } else if (bufferListener == null) {
        } else {
            Map<String, List<BufferListener>> map = z ? c : b;
            List<BufferListener> list = map.get(str);
            if (list == null) {
                list = new ArrayList<>(2);
                map.put(str, list);
            }
            list.add(new MainThreadListener(bufferListener));
        }
    }

    private static void c(List<BufferListener> list, vd vdVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1449929731")) {
            ipChange.ipc$dispatch("1449929731", new Object[]{list, vdVar});
        } else if (!h(list)) {
            for (BufferListener bufferListener : list) {
                if (vdVar.a) {
                    bufferListener.onSuccess(vdVar.b);
                } else {
                    bufferListener.onFail(vdVar.c, vdVar.d);
                }
            }
        }
    }

    public static synchronized void d(BufferRequest bufferRequest) {
        synchronized (td.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1144425839")) {
                ipChange.ipc$dispatch("-1144425839", new Object[]{bufferRequest});
            } else if (bufferRequest == null) {
            } else {
                String uniKey = bufferRequest.getUniKey();
                d.remove(uniKey);
                a.remove(uniKey);
                b.remove(uniKey);
                c.remove(uniKey);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void e(String str, vd vdVar) {
        synchronized (td.class) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "1564545781")) {
                ipChange.ipc$dispatch("1564545781", new Object[]{str, vdVar});
                return;
            }
            List<BufferListener> remove = c.remove(str);
            List<BufferListener> remove2 = b.remove(str);
            d.remove(str);
            if (!h(remove)) {
                e.addAll(remove);
            }
            if (h(remove2)) {
                a.put(str, vdVar);
            } else {
                z = false;
            }
            c(remove, vdVar);
            c(remove2, vdVar);
            String str2 = z ? "缓存cache" : "不需cache";
            if (remove2 != null) {
                i = remove2.size();
            }
            j("state 5:预加载结果返回 " + str2 + " 移除预加载request : out pool size =" + i + " :" + str);
        }
    }

    public static void f(BufferSwitch bufferSwitch, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1818545634")) {
            ipChange.ipc$dispatch("1818545634", new Object[]{bufferSwitch, Boolean.valueOf(z)});
            return;
        }
        f = bufferSwitch;
        g = z;
    }

    public static boolean g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1805556854")) {
            return ((Boolean) ipChange.ipc$dispatch("1805556854", new Object[]{str})).booleanValue();
        }
        BufferSwitch bufferSwitch = f;
        if (bufferSwitch == null) {
            return true;
        }
        return bufferSwitch.isGroupTypeSupport(str);
    }

    private static boolean h(Collection collection) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1425276034") ? ((Boolean) ipChange.ipc$dispatch("1425276034", new Object[]{collection})).booleanValue() : collection == null || collection.size() == 0;
    }

    public static synchronized <T> nx1<T> i(BufferRequest<T> bufferRequest, BufferListener<T> bufferListener, ud udVar) {
        synchronized (td.class) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "394909067")) {
                return (nx1) ipChange.ipc$dispatch("394909067", new Object[]{bufferRequest, bufferListener, udVar});
            }
            String uniKey = bufferRequest.getUniKey();
            BufferSwitch bufferSwitch = f;
            if (bufferSwitch != null && !bufferSwitch.isGroupTypeSupport(bufferRequest.getGroupType())) {
                if (!udVar.is4Preload()) {
                    bufferRequest.doRequest(bufferListener);
                }
                j("state 0:不支持预加载操作" + uniKey);
                return new nx1<>(bufferRequest);
            }
            Map<String, BufferRequest> map = d;
            BufferRequest bufferRequest2 = map.get(uniKey);
            boolean is4Preload = udVar.is4Preload();
            if (bufferRequest2 != null) {
                j("state 1:有预加载请求正在执行，outListener 入池等待 :" + uniKey);
                b(uniKey, is4Preload, bufferListener);
                bufferRequest = bufferRequest2;
            } else if (is4Preload) {
                map.put(uniKey, bufferRequest);
                j("state 2:无预加载任务 &&当前请求是预加载，预加载request 入池 :" + uniKey);
                bufferRequest.doRequest(new C9713a(uniKey));
            } else {
                MainThreadListener mainThreadListener = new MainThreadListener(bufferListener);
                vd remove = a.remove(uniKey);
                if (remove == null) {
                    z = false;
                }
                if (z) {
                    remove.a(udVar.cacheValidMills());
                }
                if (remove != null && remove.a(udVar.cacheValidMills())) {
                    j("state 3:无预加载任务 &&当前请求是非加载 cache 有效 :" + uniKey);
                    if (remove.a) {
                        mainThreadListener.onSuccess(remove.b);
                    } else {
                        mainThreadListener.onFail(remove.c, remove.d);
                    }
                } else {
                    if (z) {
                        j("state 4:无预加载任务 &&当前请求是非加载 cache 超时 :" + uniKey);
                    } else {
                        j("state 4:无预加载任务 &&当前请求是非加载 No cache :" + uniKey);
                    }
                    mainThreadListener.doRequestAsync();
                    bufferRequest.doRequest(mainThreadListener);
                }
            }
            return new nx1<>(bufferRequest);
        }
    }

    private static void j(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1057160562")) {
            ipChange.ipc$dispatch("-1057160562", new Object[]{str});
        } else if (g) {
            Log.e("BufferKit", str);
        }
    }
}
