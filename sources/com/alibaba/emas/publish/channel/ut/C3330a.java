package com.alibaba.emas.publish.channel.ut;

import android.annotation.SuppressLint;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alipay.sdk.m.k.C4226b;
import com.taobao.tao.log.statistics.TLogEventConst;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import tb.gn;

/* compiled from: Taobao */
/* renamed from: com.alibaba.emas.publish.channel.ut.a */
/* loaded from: classes15.dex */
public class C3330a {
    protected static String g = "yyyy-MM-dd HH:mm:ss";
    public String a = "source";
    public String b = "productId";
    public String c = "applicationId";
    public String d = "batchId";
    private Boolean e = Boolean.FALSE;
    @SuppressLint({"SimpleDateFormat"})
    protected SimpleDateFormat f = new SimpleDateFormat(g);

    public void a() throws Exception {
        HashSet hashSet = new HashSet();
        hashSet.add("updateCount");
        MeasureSet create = MeasureSet.create(hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add(this.a);
        hashSet2.add(this.b);
        hashSet2.add(this.c);
        hashSet2.add(this.d);
        hashSet2.add(C4226b.l);
        hashSet2.add("noticeType");
        hashSet2.add(TLogEventConst.PARAM_UPLOAD_STAGE);
        hashSet2.add("action");
        hashSet2.add("uploadTime");
        hashSet2.add("hashCode");
        hashSet2.add("hitHashBatch");
        hashSet2.add("isSuccess");
        hashSet2.add("errorCode");
        hashSet2.add("errorMsg");
        AppMonitor.register(gn.q, gn.r, create, DimensionSet.create(hashSet2), true);
        this.e = Boolean.TRUE;
    }

    public void b(PublishUtRequest publishUtRequest) throws Exception {
        if (this.e.booleanValue()) {
            MeasureValueSet create = MeasureValueSet.create();
            create.setValue("updateCount", 1.0d);
            DimensionValueSet create2 = DimensionValueSet.create();
            create2.setValue(this.a, publishUtRequest.dimSourceValue);
            String str = publishUtRequest.dimProductIdValue;
            if (str != null) {
                create2.setValue(this.b, str);
            } else {
                create2.setValue(this.b, "-");
            }
            String str2 = publishUtRequest.dimApplicationIdValue;
            if (str2 != null) {
                create2.setValue(this.c, str2);
            } else {
                create2.setValue(this.c, "-");
            }
            String str3 = publishUtRequest.dimBatchIdValue;
            if (str3 != null) {
                create2.setValue(this.d, str3);
            } else {
                create2.setValue(this.d, "-");
            }
            String str4 = publishUtRequest.dimBizValue;
            if (str4 != null) {
                create2.setValue(C4226b.l, str4);
            } else {
                create2.setValue(C4226b.l, "-");
            }
            String str5 = publishUtRequest.dimNoticeTypeValue;
            if (str5 != null) {
                create2.setValue("noticeType", str5);
            } else {
                create2.setValue("noticeType", "-");
            }
            String str6 = publishUtRequest.dimStageValue;
            if (str6 != null) {
                create2.setValue(TLogEventConst.PARAM_UPLOAD_STAGE, str6);
            } else {
                create2.setValue(TLogEventConst.PARAM_UPLOAD_STAGE, "-");
            }
            String str7 = publishUtRequest.dimActionValue;
            if (str7 != null) {
                create2.setValue("action", str7);
            } else {
                create2.setValue("action", "-");
            }
            String str8 = null;
            try {
                str8 = this.f.format(new Date());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (str8 != null && str8.length() > 0) {
                create2.setValue("uploadTime", str8);
            } else {
                create2.setValue("uploadTime", "-");
            }
            String str9 = publishUtRequest.dimHashCodeValue;
            if (str9 != null) {
                create2.setValue("hashCode", str9);
            } else {
                create2.setValue("hashCode", "-");
            }
            String str10 = publishUtRequest.dimHitHashBatchValue;
            if (str10 != null) {
                create2.setValue("hitHashBatch", str10);
            } else {
                create2.setValue("hitHashBatch", "-");
            }
            String str11 = publishUtRequest.dimSuccessValue;
            if (str11 != null) {
                create2.setValue("isSuccess", str11);
            } else {
                create2.setValue("isSuccess", "-");
            }
            String str12 = publishUtRequest.dimErrorCodeValue;
            if (str12 != null) {
                create2.setValue("errorCode", str12);
            } else {
                create2.setValue("errorCode", "-");
            }
            String str13 = publishUtRequest.dimErrorMsgValue;
            if (str13 != null) {
                create2.setValue("errorMsg", str13);
            } else {
                create2.setValue("errorMsg", "-");
            }
            AppMonitor.Stat.commit(gn.q, gn.r, create2, create);
        }
    }
}
