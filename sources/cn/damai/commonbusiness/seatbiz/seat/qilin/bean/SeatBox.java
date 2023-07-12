package cn.damai.commonbusiness.seatbiz.seat.qilin.bean;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.RegionNewSeatEntity;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.RegionSeatNew;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.seatdecoder.seat_vr.bean.StaticSeat3DVrInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SeatBox {
    private static transient /* synthetic */ IpChange $ipChange;
    public Map<Long, List<SeatNew>> mPackageSeatMap = new HashMap();
    public Map<String, List<Path>> packagePathMap;
    public Map<String, List<StaticSeat3DVrInfo>> seat3DVrInfoMap;
    public ArrayMap<String, List<SeatNew>> seatNewMap;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class TaoPiaoSeatComparator implements Comparator<SeatNew> {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // java.util.Comparator
        public int compare(SeatNew seatNew, SeatNew seatNew2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1615227170")) {
                return ((Integer) ipChange.ipc$dispatch("-1615227170", new Object[]{this, seatNew, seatNew2})).intValue();
            }
            int i = seatNew.x - seatNew2.x;
            return i != 0 ? i : seatNew2.y - seatNew.y;
        }
    }

    private void createTaoPiaoPath(Map<Long, List<SeatNew>> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "837413255")) {
            ipChange.ipc$dispatch("837413255", new Object[]{this, map});
        } else if (cb2.f(map)) {
        } else {
            try {
                if (Build.VERSION.SDK_INT < 19) {
                    createTaoPiaoPathBefore19(map);
                } else {
                    createTaoPiaoPathAfterApi19(map);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @RequiresApi(api = 19)
    private void createTaoPiaoPathAfterApi19(Map<Long, List<SeatNew>> map) {
        HashMap hashMap;
        Iterator<Map.Entry<Long, List<SeatNew>>> it;
        TaoPiaoSeatComparator taoPiaoSeatComparator;
        TaoPiaoSeatComparator taoPiaoSeatComparator2;
        ArrayList arrayList;
        HashMap hashMap2;
        String str;
        int i;
        SeatBox seatBox = this;
        IpChange ipChange = $ipChange;
        int i2 = 2;
        if (AndroidInstantRuntime.support(ipChange, "-382944083")) {
            ipChange.ipc$dispatch("-382944083", new Object[]{seatBox, map});
            return;
        }
        HashMap hashMap3 = new HashMap();
        int i3 = 14;
        Set<Map.Entry<Long, List<SeatNew>>> entrySet = map.entrySet();
        TaoPiaoSeatComparator taoPiaoSeatComparator3 = new TaoPiaoSeatComparator();
        Iterator<Map.Entry<Long, List<SeatNew>>> it2 = entrySet.iterator();
        while (it2.hasNext()) {
            List<SeatNew> value = it2.next().getValue();
            if (cb2.d(value) || value.size() < i2) {
                hashMap = hashMap3;
                it = it2;
                taoPiaoSeatComparator = taoPiaoSeatComparator3;
            } else {
                ArrayList arrayList2 = new ArrayList(value);
                Collections.sort(arrayList2, taoPiaoSeatComparator3);
                Path path = new Path();
                String str2 = null;
                SeatNew seatNew = null;
                int i4 = 0;
                while (i4 < arrayList2.size()) {
                    SeatNew seatNew2 = (SeatNew) arrayList2.get(i4);
                    String str3 = seatNew2.kanTaiId;
                    int i5 = seatNew2.x;
                    int i6 = seatNew2.y;
                    Path path2 = new Path();
                    Iterator<Map.Entry<Long, List<SeatNew>>> it3 = it2;
                    float f = i3;
                    path2.addCircle(i5, i6, f, Path.Direction.CW);
                    if (i4 == 0) {
                        path.op(path2, Path.Op.UNION);
                        hashMap2 = hashMap3;
                        taoPiaoSeatComparator2 = taoPiaoSeatComparator3;
                        arrayList = arrayList2;
                        i = i4;
                        str = str3;
                    } else {
                        int i7 = seatNew2.x;
                        int i8 = seatNew.x;
                        if (i7 == i8 && seatNew2.y == seatNew.y) {
                            hashMap2 = hashMap3;
                            taoPiaoSeatComparator2 = taoPiaoSeatComparator3;
                            arrayList = arrayList2;
                            i = i4;
                            str = str3;
                            i4 = i + 1;
                            i3 = 14;
                            it2 = it3;
                            taoPiaoSeatComparator3 = taoPiaoSeatComparator2;
                            arrayList2 = arrayList;
                            hashMap3 = hashMap2;
                            str2 = str;
                        } else {
                            int i9 = seatNew.y;
                            Path path3 = new Path();
                            int i10 = i5 - i8;
                            int i11 = i6 - i9;
                            taoPiaoSeatComparator2 = taoPiaoSeatComparator3;
                            float f2 = (i10 / 2.0f) + i8;
                            float f3 = (i11 / 2.0f) + i9;
                            int i12 = i10 * i10;
                            int i13 = i11 * i11;
                            arrayList = arrayList2;
                            hashMap2 = hashMap3;
                            float sqrt = (float) (Math.sqrt(i12 + i13) / 2.0d);
                            str = str3;
                            i = i4;
                            RectF rectF = new RectF((int) (f2 - sqrt), (int) (f3 - f), (int) (f2 + sqrt), f + f3);
                            Path path4 = new Path();
                            path4.addRect(rectF, Path.Direction.CW);
                            Matrix matrix = new Matrix();
                            if (seatNew2.x == seatNew.x) {
                                matrix.postRotate(90.0f, f2, f3);
                            } else if (seatNew2.y == seatNew.y) {
                                matrix.postRotate(0.0f, f2, f3);
                            } else {
                                double d = 0.0d;
                                float f4 = 2.0f * sqrt;
                                try {
                                    d = (Math.acos(((i12 + (f4 * f4)) - i13) / (((i10 * 2) * 2) * sqrt)) / 3.141592653589793d) * 180.0d;
                                    if (seatNew2.y < seatNew.y) {
                                        d = -d;
                                    }
                                } catch (Exception unused) {
                                }
                                matrix.postRotate((float) d, f2, f3);
                                path3.addPath(path4, matrix);
                                path.op(path3, Path.Op.UNION);
                                path.op(path2, Path.Op.UNION);
                            }
                            path3.addPath(path4, matrix);
                            path.op(path3, Path.Op.UNION);
                            path.op(path2, Path.Op.UNION);
                        }
                    }
                    seatNew = seatNew2;
                    i4 = i + 1;
                    i3 = 14;
                    it2 = it3;
                    taoPiaoSeatComparator3 = taoPiaoSeatComparator2;
                    arrayList2 = arrayList;
                    hashMap3 = hashMap2;
                    str2 = str;
                }
                HashMap hashMap4 = hashMap3;
                it = it2;
                taoPiaoSeatComparator = taoPiaoSeatComparator3;
                if (TextUtils.isEmpty(str2)) {
                    hashMap = hashMap4;
                } else {
                    hashMap = hashMap4;
                    if (hashMap.get(str2) == null) {
                        hashMap.put(str2, new ArrayList());
                    }
                    ((List) hashMap.get(str2)).add(path);
                }
            }
            i3 = 14;
            i2 = 2;
            it2 = it;
            hashMap3 = hashMap;
            taoPiaoSeatComparator3 = taoPiaoSeatComparator;
            seatBox = this;
        }
        seatBox.packagePathMap = hashMap3;
    }

    private void createTaoPiaoPathBefore19(Map<Long, List<SeatNew>> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2125212466")) {
            ipChange.ipc$dispatch("-2125212466", new Object[]{this, map});
            return;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<Long, List<SeatNew>> entry : map.entrySet()) {
            List<SeatNew> value = entry.getValue();
            if (!cb2.d(value) && value.size() >= 2) {
                Collections.sort(value, new Comparator<SeatNew>() { // from class: cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.util.Comparator
                    public int compare(SeatNew seatNew, SeatNew seatNew2) {
                        IpChange ipChange2 = $ipChange;
                        return AndroidInstantRuntime.support(ipChange2, "1899547569") ? ((Integer) ipChange2.ipc$dispatch("1899547569", new Object[]{this, seatNew, seatNew2})).intValue() : seatNew.x - seatNew2.x;
                    }
                });
                Path path = new Path();
                String str = null;
                int i = 0;
                while (i < value.size()) {
                    SeatNew seatNew = value.get(i);
                    String str2 = seatNew.kanTaiId;
                    if (i == 0) {
                        path.moveTo(seatNew.x, seatNew.y);
                    } else {
                        path.lineTo(seatNew.x, seatNew.y);
                    }
                    i++;
                    str = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    if (hashMap.get(str) == null) {
                        hashMap.put(str, new ArrayList());
                    }
                    ((List) hashMap.get(str)).add(path);
                }
            }
        }
        this.packagePathMap = hashMap;
    }

    public static SeatBox make(@NonNull RegionNewSeatEntity regionNewSeatEntity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1851946468")) {
            return (SeatBox) ipChange.ipc$dispatch("1851946468", new Object[]{regionNewSeatEntity});
        }
        SeatBox seatBox = new SeatBox();
        RegionSeatNew regionSeatNew = regionNewSeatEntity.regionSeatNew;
        if (regionSeatNew != null) {
            seatBox.seatNewMap = regionSeatNew.seatNewMap;
            seatBox.packagePathMap = regionSeatNew.packageTaoPiaoPoints;
        }
        return seatBox;
    }

    public void bindVrData() {
        Map<String, List<StaticSeat3DVrInfo>> map;
        List<StaticSeat3DVrInfo> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-929163785")) {
            ipChange.ipc$dispatch("-929163785", new Object[]{this});
        } else if (!cb2.c(this.seatNewMap) && (map = this.seat3DVrInfoMap) != null && map.size() != 0) {
            for (int i = 0; i < this.seatNewMap.size(); i++) {
                List<SeatNew> valueAt = this.seatNewMap.valueAt(i);
                if (valueAt != null && (list = this.seat3DVrInfoMap.get(this.seatNewMap.keyAt(i))) != null && list.size() != 0) {
                    LongSparseArray longSparseArray = new LongSparseArray();
                    for (StaticSeat3DVrInfo staticSeat3DVrInfo : list) {
                        longSparseArray.put(staticSeat3DVrInfo.getSid().longValue(), staticSeat3DVrInfo);
                    }
                    int size = valueAt.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        SeatNew seatNew = valueAt.get(i2);
                        seatNew.vr3DImg = (StaticSeat3DVrInfo) longSparseArray.get(seatNew.sid);
                    }
                }
            }
        }
    }

    public void collectSeatDataInner() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "693908829")) {
            ipChange.ipc$dispatch("693908829", new Object[]{this});
        } else if (!cb2.c(this.seatNewMap)) {
            for (int i = 0; i < this.seatNewMap.size(); i++) {
                List<SeatNew> valueAt = this.seatNewMap.valueAt(i);
                if (valueAt != null) {
                    int size = valueAt.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        SeatNew seatNew = valueAt.get(i2);
                        long j = seatNew.packageCombinedId;
                        if (j != 0) {
                            if (!this.mPackageSeatMap.containsKey(Long.valueOf(j)) || this.mPackageSeatMap.get(Long.valueOf(seatNew.packageCombinedId)) == null) {
                                this.mPackageSeatMap.put(Long.valueOf(seatNew.packageCombinedId), new ArrayList());
                            }
                            this.mPackageSeatMap.get(Long.valueOf(seatNew.packageCombinedId)).add(seatNew);
                        }
                    }
                }
            }
            createTaoPiaoPath(this.mPackageSeatMap);
        }
    }

    @Nullable
    public List<SeatNew> get(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2030905091")) {
            return (List) ipChange.ipc$dispatch("2030905091", new Object[]{this, str});
        }
        if (cb2.c(this.seatNewMap)) {
            return null;
        }
        return this.seatNewMap.get(str);
    }

    public int getTotalSeatCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1068582311")) {
            return ((Integer) ipChange.ipc$dispatch("1068582311", new Object[]{this})).intValue();
        }
        if (cb2.c(this.seatNewMap)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.seatNewMap.size(); i2++) {
            List<SeatNew> valueAt = this.seatNewMap.valueAt(i2);
            i += valueAt == null ? 0 : valueAt.size();
        }
        return i;
    }
}
