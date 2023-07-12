package tb;

import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.videoc.core.IKeyedQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class jz<Data> implements IKeyedQueue<Data> {
    private Set<Integer> a;
    private Set<Integer> b;
    private int[] c;
    private final Map<Integer, Data> d;
    private final Map<Integer, Integer> e;
    private int f;

    public jz() {
        this(10);
    }

    private Data a(int i) {
        while (this.b.contains(Integer.valueOf(i)) && i < this.f) {
            i++;
        }
        Data data = get(i);
        if (data != null) {
            this.b.add(Integer.valueOf(i));
            this.a.add(Integer.valueOf(i));
        }
        return data;
    }

    private void d(int i) {
        if (i - this.c.length > 0) {
            e(i);
        }
    }

    private void e(int i) {
        int length = this.c.length;
        int i2 = length + (length >> 1);
        if (i2 - i < 0) {
            i2 = i;
        }
        if (i2 - 2147483639 > 0) {
            i2 = f(i);
        }
        this.c = Arrays.copyOf(this.c, i2);
    }

    private static int f(int i) {
        if (i >= 0) {
            return i > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        throw new OutOfMemoryError();
    }

    private void g(int i, Data data) {
        this.d.put(Integer.valueOf(c(i, data)), data);
        this.e.put(Integer.valueOf(data.hashCode()), Integer.valueOf(this.f));
        int[] iArr = this.c;
        int i2 = this.f;
        this.f = i2 + 1;
        iArr[i2] = c(i, data);
    }

    private Set<Integer> h(Set<Integer> set, int i) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Integer num : set) {
            int intValue = num.intValue();
            if (intValue > i) {
                intValue--;
            }
            linkedHashSet.add(Integer.valueOf(intValue));
        }
        return linkedHashSet;
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IKeyedQueue
    public void addCurrent(int i) {
        if (i < 0 || i > this.f - 1 || this.b.contains(Integer.valueOf(i))) {
            return;
        }
        this.a.add(Integer.valueOf(i));
        this.b.add(Integer.valueOf(i));
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IKeyedQueue
    public Data addNext(@NonNull Data data) {
        int indexOf = indexOf(data);
        if (indexOf < 0) {
            return null;
        }
        return a(indexOf + 1);
    }

    protected int b(Data data, int i) {
        return (i / data.hashCode()) - 1;
    }

    protected int c(int i, Data data) {
        return data.hashCode() * (i + 1);
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IKeyedQueue
    public boolean contains(@NonNull Data data) {
        return indexOf(data) > -1;
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IKeyedQueue
    public Data get(int i) {
        if (i < 0 || i > this.f - 1) {
            return null;
        }
        return this.d.get(Integer.valueOf(this.c[i]));
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IKeyedQueue
    public int indexOf(@NonNull Data data) {
        Integer num = this.e.get(Integer.valueOf(data.hashCode()));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IKeyedQueue
    public boolean isEmpty() {
        return this.f == 0;
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IKeyedQueue
    public Integer keyOf(Data data) {
        Integer num = this.e.get(Integer.valueOf(data.hashCode()));
        if (num != null && num.intValue() >= 0 && num.intValue() <= this.f - 1) {
            return Integer.valueOf(b(data, this.c[num.intValue()]));
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IKeyedQueue
    public Data last() {
        int[] iArr;
        int size = size() - 1;
        if (size >= 0 && (iArr = this.c) != null) {
            return this.d.get(Integer.valueOf(iArr[size]));
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IKeyedQueue
    public List<Data> peek() {
        ArrayList arrayList = new ArrayList();
        for (Integer num : this.a) {
            Data data = get(num.intValue());
            if (data != null) {
                arrayList.add(data);
            }
        }
        return arrayList;
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IKeyedQueue
    public List<Data> peekShifted() {
        ArrayList arrayList = new ArrayList();
        for (Integer num : this.b) {
            Data data = get(num.intValue());
            if (data != null) {
                arrayList.add(data);
            }
        }
        return arrayList;
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IKeyedQueue
    public void push(int i, @NonNull List<Data> list) {
        d(this.f + list.size());
        for (Data data : list) {
            g(i, data);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IKeyedQueue
    public void reLoop() {
        this.b.clear();
        this.b.addAll(this.a);
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IKeyedQueue
    public Data remove(@NonNull Data data) {
        return remove(indexOf(data));
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IKeyedQueue
    public void reset(List<Integer> list) {
        this.b.clear();
        this.a.clear();
        if (list == null) {
            return;
        }
        for (Integer num : list) {
            Integer valueOf = Integer.valueOf(Math.max(num.intValue(), 0));
            this.a.add(valueOf);
            this.b.add(valueOf);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IKeyedQueue
    public Data shift(@NonNull Data data) {
        int indexOf = indexOf(data);
        if (indexOf < 0) {
            return null;
        }
        this.a.remove(Integer.valueOf(indexOf));
        return a(indexOf + 1);
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IKeyedQueue
    public int size() {
        return this.f;
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IKeyedQueue
    public void skip(Data data) {
        int indexOf = indexOf(data);
        if (indexOf < 0) {
            return;
        }
        this.a.remove(Integer.valueOf(indexOf));
        this.b.add(Integer.valueOf(indexOf));
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IKeyedQueue
    public List<Data> toList() {
        ArrayList arrayList = new ArrayList();
        for (int i : this.c) {
            Data data = this.d.get(Integer.valueOf(i));
            if (data != null) {
                arrayList.add(data);
            }
        }
        return arrayList;
    }

    public jz(int i) {
        this.a = new LinkedHashSet();
        this.b = new LinkedHashSet();
        this.d = new HashMap();
        this.e = new HashMap();
        this.c = new int[i];
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IKeyedQueue
    public Data remove(int i) {
        Data remove;
        if (i < 0 || i > this.f - 1 || (remove = this.d.remove(Integer.valueOf(this.c[i]))) == null) {
            return null;
        }
        int i2 = (this.f - i) - 1;
        this.a.remove(Integer.valueOf(i));
        this.b.remove(Integer.valueOf(i));
        this.e.remove(Integer.valueOf(remove.hashCode()));
        if (i2 > 0) {
            int[] iArr = this.c;
            System.arraycopy(iArr, i + 1, iArr, i, i2);
            for (Map.Entry<Integer, Integer> entry : this.e.entrySet()) {
                if (entry.getValue().intValue() > i) {
                    this.e.put(entry.getKey(), Integer.valueOf(entry.getValue().intValue() - 1));
                }
            }
            this.a = h(this.a, i);
            this.b = h(this.b, i);
        }
        int[] iArr2 = this.c;
        int i3 = this.f - 1;
        this.f = i3;
        iArr2[i3] = 0;
        return remove;
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IKeyedQueue
    public void reset() {
        reset(null);
    }
}
