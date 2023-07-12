package com.youku.danmaku.engine.controller;

import android.text.TextUtils;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuTimer;
import com.youku.danmaku.engine.danmaku.model.IDanmakuIterator;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuContext;
import com.youku.danmaku.engine.danmaku.model.android.Danmakus;
import com.youku.danmaku.engine.danmaku.util.Log;
import com.youku.danmaku.engine.danmaku.util.SystemClock;
import com.youku.danmaku.plugin.IDanmakuFilterPlugin;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DanmakuFilters {
    public static final int FILTER_TYPE_DUPLICATE_MERGE = 128;
    public static final int FILTER_TYPE_ELAPSED_TIME = 4;
    public static final int FILTER_TYPE_MAXIMUM_LINES = 256;
    public static final int FILTER_TYPE_OVERLAPPING = 512;
    public static final int FILTER_TYPE_QUANTITY = 2;
    public static final int FILTER_TYPE_TEXT_COLOR = 8;
    public static final int FILTER_TYPE_TYPE = 1;
    public static final int FILTER_TYPE_USER_GUEST = 64;
    public static final int FILTER_TYPE_USER_HASH = 32;
    public static final int FILTER_TYPE_USER_ID = 16;
    public static final String TAG_DUPLICATE_FILTER = "1017_Filter";
    public static final String TAG_ELAPSED_TIME_FILTER = "1012_Filter";
    public static final String TAG_GUEST_FILTER = "1016_Filter";
    public static final String TAG_MAXIMUN_LINES_FILTER = "1018_Filter";
    public static final String TAG_OVERLAPPING_FILTER = "1019_Filter";
    public static final String TAG_QUANTITY_DANMAKU_FILTER = "1011_Filter";
    public static final String TAG_TEXT_COLOR_DANMAKU_FILTER = "1013_Filter";
    public static final String TAG_TYPE_DANMAKU_FILTER = "1010_Filter";
    public static final String TAG_USER_HASH_FILTER = "1015_Filter";
    public static final String TAG_USER_ID_FILTER = "1014_Filter";
    private IDanmakuFilterPlugin mDanmakuFilterPlugin;
    public final Exception filterException = new Exception("not suuport this filter tag");
    private final Map<String, IDanmakuFilter<?>> filters = Collections.synchronizedSortedMap(new TreeMap());
    private final Map<String, IDanmakuFilter<?>> filtersSecondary = Collections.synchronizedSortedMap(new TreeMap());
    private IDanmakuFilter<?>[] mFilterArray = new IDanmakuFilter[0];
    private IDanmakuFilter<?>[] mFilterArraySecondary = new IDanmakuFilter[0];

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static abstract class BaseDanmakuFilter<T> implements IDanmakuFilter<T> {
        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public void clear() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class ElapsedTimeFilter extends BaseDanmakuFilter<Object> {
        long mMaxTime = 20;

        private synchronized boolean needFilter(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z) {
            if (danmakuTimer != null) {
                if (baseDanmaku.isOutside()) {
                    return SystemClock.uptimeMillis() - danmakuTimer.currMillisecond >= this.mMaxTime;
                }
            }
            return false;
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.BaseDanmakuFilter, com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public void clear() {
            reset();
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public boolean filter(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            boolean needFilter = needFilter(baseDanmaku, i, i2, danmakuTimer, z);
            if (needFilter) {
                baseDanmaku.mFilterParam |= 4;
            }
            return needFilter;
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public synchronized void reset() {
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public void setData(Object obj) {
            reset();
        }

        public String toString() {
            return "ElapsedTimeFilter";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class GuestFilter extends BaseDanmakuFilter<Boolean> {
        private Boolean mBlock = Boolean.FALSE;

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public boolean filter(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = this.mBlock.booleanValue() && baseDanmaku.isGuest;
            if (z2) {
                baseDanmaku.mFilterParam |= 64;
            }
            return z2;
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public void reset() {
            this.mBlock = Boolean.FALSE;
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public void setData(Boolean bool) {
            this.mBlock = bool;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface IDanmakuFilter<T> {
        void clear();

        boolean filter(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext);

        void reset();

        void setData(T t);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class MaximumLinesFilter extends BaseDanmakuFilter<Map<Integer, Integer>> {
        private Map<Integer, Integer> mMaximumLinesPairs;

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public boolean filter(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            Map<Integer, Integer> map = this.mMaximumLinesPairs;
            boolean z2 = false;
            if (map != null) {
                Integer num = map.get(Integer.valueOf(baseDanmaku.getType()));
                if (num != null && i >= num.intValue()) {
                    z2 = true;
                }
                if (z2) {
                    baseDanmaku.mFilterParam |= 256;
                }
            }
            return z2;
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public void reset() {
            this.mMaximumLinesPairs = null;
        }

        public String toString() {
            return "MaximumLinesFilter";
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public void setData(Map<Integer, Integer> map) {
            this.mMaximumLinesPairs = map;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class OverlappingFilter extends BaseDanmakuFilter<Map<Integer, Boolean>> {
        private Map<Integer, Boolean> mEnabledPairs;

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public boolean filter(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            Map<Integer, Boolean> map = this.mEnabledPairs;
            boolean z2 = false;
            if (map != null) {
                Boolean bool = map.get(Integer.valueOf(baseDanmaku.getType()));
                if (bool != null && bool.booleanValue() && z) {
                    z2 = true;
                }
                if (z2) {
                    baseDanmaku.mFilterParam |= 512;
                }
            }
            return z2;
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public void reset() {
            this.mEnabledPairs = null;
        }

        public String toString() {
            return "OverlappingFilter";
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public void setData(Map<Integer, Boolean> map) {
            this.mEnabledPairs = map;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class QuantityDanmakuFilter extends BaseDanmakuFilter<Integer> {
        private static final int START_EXPAND_VALUE = 20;
        protected int mMaximumSize = -1;
        protected int mRealMaximumSize = -1;
        protected BaseDanmaku mLastSkipped = null;
        private float mFilterFactor = 1.0f;
        private double mTopSkippedProbability = -1.0d;
        private double mBottomSkippedProbability = -1.0d;

        private boolean needFilter(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            int i3 = this.mMaximumSize;
            if (i3 < 0) {
                return false;
            }
            if (i3 == 0) {
                return true;
            }
            this.mTopSkippedProbability = -1.0d;
            this.mBottomSkippedProbability = -1.0d;
            if (baseDanmaku.getType() == 5) {
                return this.mTopSkippedProbability != -1.0d && Math.random() >= this.mTopSkippedProbability;
            } else if (baseDanmaku.getType() == 4) {
                double d = this.mBottomSkippedProbability;
                if (d == -1.0d) {
                    return false;
                }
                return d == 0.0d || Math.random() >= this.mBottomSkippedProbability;
            } else if (baseDanmaku.getType() != 1) {
                return false;
            } else {
                BaseDanmaku baseDanmaku2 = this.mLastSkipped;
                if (baseDanmaku2 != null && !baseDanmaku2.isTimeOut()) {
                    long j = baseDanmaku.time - this.mLastSkipped.time;
                    if ((j < 0 || ((float) j) >= ((float) danmakuContext.mDanmakuFactory.mMaxDurationScrollDanmaku.value) * this.mFilterFactor) && i <= this.mMaximumSize) {
                        this.mLastSkipped = baseDanmaku;
                        return false;
                    }
                    return true;
                }
                this.mLastSkipped = baseDanmaku;
                return false;
            }
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.BaseDanmakuFilter, com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public void clear() {
            reset();
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public synchronized boolean filter(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            boolean needFilter;
            needFilter = needFilter(baseDanmaku, i, i2, danmakuTimer, z, danmakuContext);
            if (needFilter) {
                baseDanmaku.mFilterParam |= 2;
            }
            return needFilter;
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public synchronized void reset() {
            this.mLastSkipped = null;
        }

        public String toString() {
            return "QuantityDanmakuFilter";
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public void setData(Integer num) {
            reset();
            if (num == null || num.intValue() == this.mRealMaximumSize) {
                return;
            }
            this.mRealMaximumSize = num.intValue();
            int intValue = num.intValue() + (num.intValue() / 5);
            this.mMaximumSize = intValue;
            if (intValue > 0 && intValue <= 20) {
                this.mFilterFactor = 1.0f / intValue;
            } else if (intValue > 20) {
                this.mFilterFactor = 1.0f / ((float) (Math.pow(intValue - 20, 1.3d) + 20.0d));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class TextColorFilter extends BaseDanmakuFilter<List<Integer>> {
        public List<Integer> mWhiteList = new ArrayList();

        private void addToWhiteList(Integer num) {
            if (this.mWhiteList.contains(num)) {
                return;
            }
            this.mWhiteList.add(num);
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public boolean filter(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = (baseDanmaku == null || this.mWhiteList.contains(Integer.valueOf(baseDanmaku.textColor))) ? false : true;
            if (z2) {
                if (Log.isDebug()) {
                    Log.e("TextColorFilter,", ",text" + baseDanmaku.text.toString());
                }
                baseDanmaku.mFilterParam |= 8;
            }
            return z2;
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public void reset() {
            this.mWhiteList.clear();
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public void setData(List<Integer> list) {
            reset();
            if (list != null) {
                for (Integer num : list) {
                    addToWhiteList(num);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class TypeDanmakuFilter extends BaseDanmakuFilter<List<Integer>> {
        final List<Integer> mFilterTypes = Collections.synchronizedList(new ArrayList());

        public void disableType(Integer num) {
            if (this.mFilterTypes.contains(num)) {
                this.mFilterTypes.remove(num);
            }
        }

        public void enableType(Integer num) {
            if (this.mFilterTypes.contains(num)) {
                return;
            }
            this.mFilterTypes.add(num);
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public boolean filter(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = baseDanmaku != null && this.mFilterTypes.contains(Integer.valueOf(baseDanmaku.getType()));
            if (baseDanmaku != null && baseDanmaku.getType() == 5 && this.mFilterTypes.contains(Integer.valueOf(baseDanmaku.getType()))) {
                z2 = baseDanmaku.priority != 1;
            }
            if (z2) {
                baseDanmaku.mFilterParam |= 1;
            }
            return z2;
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public void reset() {
            this.mFilterTypes.clear();
        }

        public String toString() {
            return "TypeDanmakuFilter";
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public void setData(List<Integer> list) {
            reset();
            if (list != null) {
                for (Integer num : list) {
                    enableType(num);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static abstract class UserFilter<T> extends BaseDanmakuFilter<List<T>> {
        public List<T> mBlackList = new ArrayList();

        private void addToBlackList(T t) {
            if (this.mBlackList.contains(t)) {
                return;
            }
            this.mBlackList.add(t);
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public abstract boolean filter(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext);

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public void reset() {
            this.mBlackList.clear();
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public /* bridge */ /* synthetic */ void setData(Object obj) {
            setData((List) ((List) obj));
        }

        public void setData(List<T> list) {
            reset();
            if (list != null) {
                for (T t : list) {
                    addToBlackList(t);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class UserHashFilter extends UserFilter<String> {
        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.UserFilter, com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public boolean filter(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = baseDanmaku != null && this.mBlackList.contains(baseDanmaku.userHash);
            if (z2) {
                baseDanmaku.mFilterParam |= 32;
            }
            return z2;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class UserIdFilter extends UserFilter<Integer> {
        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.UserFilter, com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public boolean filter(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = baseDanmaku != null && this.mBlackList.contains(baseDanmaku.userId);
            if (z2) {
                baseDanmaku.mFilterParam |= 16;
            }
            return z2;
        }
    }

    private void throwFilterException() {
        try {
            throw this.filterException;
        } catch (Exception unused) {
        }
    }

    public void clear() {
        IDanmakuFilter<?>[] iDanmakuFilterArr;
        IDanmakuFilter<?>[] iDanmakuFilterArr2;
        for (IDanmakuFilter<?> iDanmakuFilter : this.mFilterArray) {
            if (iDanmakuFilter != null) {
                iDanmakuFilter.clear();
            }
        }
        for (IDanmakuFilter<?> iDanmakuFilter2 : this.mFilterArraySecondary) {
            if (iDanmakuFilter2 != null) {
                iDanmakuFilter2.clear();
            }
        }
    }

    public void filter(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
        IDanmakuFilter<?>[] iDanmakuFilterArr;
        for (IDanmakuFilter<?> iDanmakuFilter : this.mFilterArray) {
            if (iDanmakuFilter != null) {
                boolean filter = iDanmakuFilter.filter(baseDanmaku, i, i2, danmakuTimer, z, danmakuContext);
                baseDanmaku.filterResetFlag = danmakuContext.mGlobalFlagValues.FILTER_RESET_FLAG;
                if (filter) {
                    return;
                }
            }
        }
    }

    public boolean filterSecondary(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
        IDanmakuFilter<?>[] iDanmakuFilterArr;
        for (IDanmakuFilter<?> iDanmakuFilter : this.mFilterArraySecondary) {
            if (iDanmakuFilter != null) {
                boolean filter = iDanmakuFilter.filter(baseDanmaku, i, i2, danmakuTimer, z, danmakuContext);
                baseDanmaku.filterResetFlag = danmakuContext.mGlobalFlagValues.FILTER_RESET_FLAG;
                if (filter) {
                    return true;
                }
            }
        }
        return false;
    }

    public IDanmakuFilter<?> get(String str) {
        return get(str, true);
    }

    public IDanmakuFilter<?> registerFilter(String str) {
        return registerFilter(str, true);
    }

    public void release() {
        clear();
        this.filters.clear();
        this.mFilterArray = new IDanmakuFilter[0];
        this.filtersSecondary.clear();
        this.mFilterArraySecondary = new IDanmakuFilter[0];
    }

    public void reset() {
        IDanmakuFilter<?>[] iDanmakuFilterArr;
        IDanmakuFilter<?>[] iDanmakuFilterArr2;
        for (IDanmakuFilter<?> iDanmakuFilter : this.mFilterArray) {
            if (iDanmakuFilter != null) {
                iDanmakuFilter.reset();
            }
        }
        for (IDanmakuFilter<?> iDanmakuFilter2 : this.mFilterArraySecondary) {
            if (iDanmakuFilter2 != null) {
                iDanmakuFilter2.reset();
            }
        }
    }

    public void setDanmakuFilterPlugin(IDanmakuFilterPlugin iDanmakuFilterPlugin) {
        this.mDanmakuFilterPlugin = iDanmakuFilterPlugin;
    }

    public void unregisterFilter(String str) {
        unregisterFilter(str, true);
    }

    public IDanmakuFilter<?> get(String str, boolean z) {
        IDanmakuFilter<?> iDanmakuFilter = (z ? this.filters : this.filtersSecondary).get(str);
        return iDanmakuFilter == null ? registerFilter(str, z) : iDanmakuFilter;
    }

    public IDanmakuFilter<?> registerFilter(String str, boolean z) {
        if (str == null) {
            throwFilterException();
            return null;
        }
        IDanmakuFilter<?> iDanmakuFilter = this.filters.get(str);
        if (iDanmakuFilter == null) {
            if (TAG_TYPE_DANMAKU_FILTER.equals(str)) {
                iDanmakuFilter = new TypeDanmakuFilter();
            } else if (TAG_QUANTITY_DANMAKU_FILTER.equals(str)) {
                iDanmakuFilter = new QuantityDanmakuFilter();
            } else if (TAG_ELAPSED_TIME_FILTER.equals(str)) {
                iDanmakuFilter = new ElapsedTimeFilter();
            } else if (TAG_TEXT_COLOR_DANMAKU_FILTER.equals(str)) {
                iDanmakuFilter = new TextColorFilter();
            } else if (TAG_USER_ID_FILTER.equals(str)) {
                iDanmakuFilter = new UserIdFilter();
            } else if (TAG_USER_HASH_FILTER.equals(str)) {
                iDanmakuFilter = new UserHashFilter();
            } else if (TAG_GUEST_FILTER.equals(str)) {
                iDanmakuFilter = new GuestFilter();
            } else if (TAG_DUPLICATE_FILTER.equals(str)) {
                iDanmakuFilter = new DuplicateMergingFilter();
            } else if (TAG_MAXIMUN_LINES_FILTER.equals(str)) {
                iDanmakuFilter = new MaximumLinesFilter();
            } else if (TAG_OVERLAPPING_FILTER.equals(str)) {
                iDanmakuFilter = new OverlappingFilter();
            } else {
                IDanmakuFilterPlugin iDanmakuFilterPlugin = this.mDanmakuFilterPlugin;
                if (iDanmakuFilterPlugin != null) {
                    iDanmakuFilter = iDanmakuFilterPlugin.getFilter(str);
                }
            }
        }
        if (iDanmakuFilter == null) {
            throwFilterException();
            return null;
        }
        iDanmakuFilter.setData(null);
        if (z) {
            this.filters.put(str, iDanmakuFilter);
            this.mFilterArray = (IDanmakuFilter[]) this.filters.values().toArray(this.mFilterArray);
        } else {
            this.filtersSecondary.put(str, iDanmakuFilter);
            this.mFilterArraySecondary = (IDanmakuFilter[]) this.filtersSecondary.values().toArray(this.mFilterArraySecondary);
        }
        return iDanmakuFilter;
    }

    public void unregisterFilter(String str, boolean z) {
        IDanmakuFilter<?> remove = (z ? this.filters : this.filtersSecondary).remove(str);
        if (remove != null) {
            remove.clear();
            if (z) {
                this.mFilterArray = (IDanmakuFilter[]) this.filters.values().toArray(this.mFilterArray);
            } else {
                this.mFilterArraySecondary = (IDanmakuFilter[]) this.filtersSecondary.values().toArray(this.mFilterArraySecondary);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class DuplicateMergingFilter extends BaseDanmakuFilter<Void> {
        protected final IDanmakus blockedDanmakus = new Danmakus(4);
        protected final LinkedHashMap<String, BaseDanmaku> currentDanmakus = new LinkedHashMap<>();
        private final IDanmakus passedDanmakus = new Danmakus(4);

        private final void removeTimeoutDanmakus(IDanmakus iDanmakus, long j) {
            IDanmakuIterator it = iDanmakus.iterator();
            long uptimeMillis = SystemClock.uptimeMillis();
            while (it.hasNext()) {
                try {
                    if (!it.next().isTimeOut()) {
                        return;
                    }
                    it.remove();
                    if (SystemClock.uptimeMillis() - uptimeMillis > j) {
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.BaseDanmakuFilter, com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public void clear() {
            reset();
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public boolean filter(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            boolean needFilter = needFilter(baseDanmaku, i, i2, danmakuTimer, z);
            if (needFilter) {
                baseDanmaku.mFilterParam |= 128;
            }
            return needFilter;
        }

        public synchronized boolean needFilter(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z) {
            removeTimeoutDanmakus(this.blockedDanmakus, 2L);
            removeTimeoutDanmakus(this.passedDanmakus, 2L);
            removeTimeoutDanmakus(this.currentDanmakus, 3);
            if (!this.blockedDanmakus.contains(baseDanmaku) || baseDanmaku.isOutside()) {
                if (this.passedDanmakus.contains(baseDanmaku)) {
                    return false;
                }
                if (this.currentDanmakus.containsKey(baseDanmaku.text)) {
                    this.currentDanmakus.put(String.valueOf(baseDanmaku.text), baseDanmaku);
                    this.blockedDanmakus.removeItem(baseDanmaku);
                    this.blockedDanmakus.addItem(baseDanmaku);
                    return true;
                }
                this.currentDanmakus.put(String.valueOf(baseDanmaku.text), baseDanmaku);
                this.passedDanmakus.addItem(baseDanmaku);
                return false;
            }
            return true;
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public synchronized void reset() {
            this.passedDanmakus.clear();
            this.blockedDanmakus.clear();
            this.currentDanmakus.clear();
        }

        @Override // com.youku.danmaku.engine.controller.DanmakuFilters.IDanmakuFilter
        public void setData(Void r1) {
        }

        public String toString() {
            return "DuplicateMergingFilter";
        }

        private void removeTimeoutDanmakus(LinkedHashMap<String, BaseDanmaku> linkedHashMap, int i) {
            Iterator<Map.Entry<String, BaseDanmaku>> it = linkedHashMap.entrySet().iterator();
            long uptimeMillis = SystemClock.uptimeMillis();
            while (it.hasNext()) {
                try {
                    if (!it.next().getValue().isTimeOut()) {
                        return;
                    }
                    it.remove();
                    if (SystemClock.uptimeMillis() - uptimeMillis > i) {
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    public void registerFilter(String str, IDanmakuFilter iDanmakuFilter) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.filters.put(str, iDanmakuFilter);
        this.mFilterArray = (IDanmakuFilter[]) this.filters.values().toArray(this.mFilterArray);
    }
}
