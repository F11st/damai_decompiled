package tb;

import cn.damai.common.db.db.converter.ColumnConverter;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class tk {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final ConcurrentHashMap<String, ColumnConverter> a;

    static {
        ConcurrentHashMap<String, ColumnConverter> concurrentHashMap = new ConcurrentHashMap<>();
        a = concurrentHashMap;
        cd cdVar = new cd();
        concurrentHashMap.put(Boolean.TYPE.getName(), cdVar);
        concurrentHashMap.put(Boolean.class.getName(), cdVar);
        concurrentHashMap.put(byte[].class.getName(), new ie());
        le leVar = new le();
        concurrentHashMap.put(Byte.TYPE.getName(), leVar);
        concurrentHashMap.put(Byte.class.getName(), leVar);
        zh zhVar = new zh();
        concurrentHashMap.put(Character.TYPE.getName(), zhVar);
        concurrentHashMap.put(Character.class.getName(), zhVar);
        concurrentHashMap.put(Date.class.getName(), new s30());
        gc0 gc0Var = new gc0();
        concurrentHashMap.put(Double.TYPE.getName(), gc0Var);
        concurrentHashMap.put(Double.class.getName(), gc0Var);
        fk0 fk0Var = new fk0();
        concurrentHashMap.put(Float.TYPE.getName(), fk0Var);
        concurrentHashMap.put(Float.class.getName(), fk0Var);
        r31 r31Var = new r31();
        concurrentHashMap.put(Integer.TYPE.getName(), r31Var);
        concurrentHashMap.put(Integer.class.getName(), r31Var);
        ac1 ac1Var = new ac1();
        concurrentHashMap.put(Long.TYPE.getName(), ac1Var);
        concurrentHashMap.put(Long.class.getName(), ac1Var);
        lc2 lc2Var = new lc2();
        concurrentHashMap.put(Short.TYPE.getName(), lc2Var);
        concurrentHashMap.put(Short.class.getName(), lc2Var);
        concurrentHashMap.put(java.sql.Date.class.getName(), new mf2());
        concurrentHashMap.put(String.class.getName(), new dh2());
    }

    public static ColumnConverter a(Class cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-653412285")) {
            return (ColumnConverter) ipChange.ipc$dispatch("-653412285", new Object[]{cls});
        }
        ColumnConverter columnConverter = null;
        ConcurrentHashMap<String, ColumnConverter> concurrentHashMap = a;
        if (concurrentHashMap.containsKey(cls.getName())) {
            columnConverter = concurrentHashMap.get(cls.getName());
        } else if (ColumnConverter.class.isAssignableFrom(cls)) {
            try {
                ColumnConverter columnConverter2 = (ColumnConverter) cls.newInstance();
                if (columnConverter2 != null) {
                    concurrentHashMap.put(cls.getName(), columnConverter2);
                }
                columnConverter = columnConverter2;
            } catch (Throwable th) {
                gb1.c(th.getMessage(), th);
            }
        }
        if (columnConverter != null) {
            return columnConverter;
        }
        throw new RuntimeException("Database Column Not Support: " + cls.getName() + ", please impl ColumnConverter or use ColumnConverterFactory#registerColumnConverter(...)");
    }

    public static ColumnDbType b(Class cls) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1420429747") ? (ColumnDbType) ipChange.ipc$dispatch("-1420429747", new Object[]{cls}) : a(cls).getColumnDbType();
    }

    public static boolean c(Class cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1264527175")) {
            return ((Boolean) ipChange.ipc$dispatch("-1264527175", new Object[]{cls})).booleanValue();
        }
        ConcurrentHashMap<String, ColumnConverter> concurrentHashMap = a;
        if (concurrentHashMap.containsKey(cls.getName())) {
            return true;
        }
        if (ColumnConverter.class.isAssignableFrom(cls)) {
            try {
                ColumnConverter columnConverter = (ColumnConverter) cls.newInstance();
                if (columnConverter != null) {
                    concurrentHashMap.put(cls.getName(), columnConverter);
                }
                return columnConverter == null;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }
}
