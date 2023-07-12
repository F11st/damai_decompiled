package com.youku.live.widgets.model.template;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.arch.CloneUtils;
import com.youku.live.widgets.protocol.IDeepClonable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class WidgetAttributesModel implements IDeepClonable<WidgetAttributesModel> {
    private static transient /* synthetic */ IpChange $ipChange;
    public Map<String, String> extra;
    public OrientationModel landscape;
    public OrientationModel portrait;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class DimensionsModel implements IDeepClonable<DimensionsModel> {
        public Integer h;
        public Integer w;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.youku.live.widgets.protocol.IDeepClonable
        public DimensionsModel deepClone() {
            DimensionsModel dimensionsModel = new DimensionsModel();
            dimensionsModel.w = CloneUtils.clone(this.w);
            dimensionsModel.h = CloneUtils.clone(this.h);
            return dimensionsModel;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class MarginModel implements IDeepClonable<MarginModel> {
        public Integer b;
        public boolean hasAppendSafeArea = false;
        public Integer l;
        public Integer r;
        public Integer t;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.youku.live.widgets.protocol.IDeepClonable
        public MarginModel deepClone() {
            MarginModel marginModel = new MarginModel();
            marginModel.t = CloneUtils.clone(this.t);
            marginModel.l = CloneUtils.clone(this.l);
            marginModel.b = CloneUtils.clone(this.b);
            marginModel.r = CloneUtils.clone(this.r);
            return marginModel;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class OrientationModel implements IDeepClonable<OrientationModel> {
        public static final String UNIT_DP = "pt";
        public Double aspectRatio;
        public DimensionsModel dimensions;
        public MarginModel margin;
        public Boolean safeArea;
        public String unit;
        public Boolean visible = Boolean.TRUE;

        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x00d7  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x00de  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x00e4 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x00f4  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x011f  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0129  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.youku.live.widgets.model.template.WidgetAttributesModel.RectModel compute(int r13, int r14, float r15) {
            /*
                Method dump skipped, instructions count: 304
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.youku.live.widgets.model.template.WidgetAttributesModel.OrientationModel.compute(int, int, float):com.youku.live.widgets.model.template.WidgetAttributesModel$RectModel");
        }

        public boolean useDp() {
            return TextUtils.equals(this.unit, "pt");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.youku.live.widgets.protocol.IDeepClonable
        public OrientationModel deepClone() {
            OrientationModel orientationModel = new OrientationModel();
            MarginModel marginModel = this.margin;
            orientationModel.margin = marginModel != null ? marginModel.deepClone() : null;
            DimensionsModel dimensionsModel = this.dimensions;
            orientationModel.dimensions = dimensionsModel != null ? dimensionsModel.deepClone() : null;
            orientationModel.aspectRatio = CloneUtils.clone(this.aspectRatio);
            orientationModel.visible = CloneUtils.clone(this.visible);
            orientationModel.safeArea = CloneUtils.clone(this.safeArea);
            orientationModel.unit = (String) CloneUtils.clone(this.unit);
            return orientationModel;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public static class RectModel {
        public int h;
        public int l;
        public int ph;
        public int pw;
        public boolean sa;
        public int sath;
        public int t;
        public boolean v;
        public int w;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.youku.live.widgets.protocol.IDeepClonable
    public WidgetAttributesModel deepClone() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1435075665")) {
            return (WidgetAttributesModel) ipChange.ipc$dispatch("1435075665", new Object[]{this});
        }
        WidgetAttributesModel widgetAttributesModel = new WidgetAttributesModel();
        widgetAttributesModel.portrait = (OrientationModel) CloneUtils.clone(this.portrait);
        widgetAttributesModel.landscape = (OrientationModel) CloneUtils.clone(this.landscape);
        if (this.extra != null) {
            HashMap hashMap = new HashMap();
            widgetAttributesModel.extra = hashMap;
            hashMap.putAll(this.extra);
        }
        return widgetAttributesModel;
    }
}
