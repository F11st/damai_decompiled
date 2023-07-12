package cn.damai.homepage.util;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes14.dex */
public class RandomUtils implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long addend = 11;
    private static final long mask = 281474976710655L;
    private static final long multiplier = 25214903917L;
    private static final AtomicLong seedUniquifier = new AtomicLong(8682522807148012L);
    private static final long serialVersionUID = -4487864136271863030L;
    private final AtomicLong seed;

    public RandomUtils() {
        this(seedUniquifier() ^ System.nanoTime());
    }

    private static long initialScramble(long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "281623483") ? ((Long) ipChange.ipc$dispatch("281623483", new Object[]{Long.valueOf(j)})).longValue() : (j ^ multiplier) & mask;
    }

    private static long seedUniquifier() {
        AtomicLong atomicLong;
        long j;
        long j2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2070106682")) {
            return ((Long) ipChange.ipc$dispatch("2070106682", new Object[0])).longValue();
        }
        do {
            atomicLong = seedUniquifier;
            j = atomicLong.get();
            j2 = 181783497276652981L * j;
        } while (!atomicLong.compareAndSet(j, j2));
        return j2;
    }

    public synchronized void setSeed(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1268847223")) {
            ipChange.ipc$dispatch("-1268847223", new Object[]{this, Long.valueOf(j)});
        } else {
            this.seed.set(initialScramble(j));
        }
    }

    public RandomUtils(long j) {
        if (getClass() == RandomUtils.class) {
            this.seed = new AtomicLong(initialScramble(j));
            return;
        }
        this.seed = new AtomicLong();
        setSeed(j);
    }
}
