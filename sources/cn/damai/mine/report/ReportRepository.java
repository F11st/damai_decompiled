package cn.damai.mine.report;

import android.content.Context;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.homepage.R$array;
import cn.damai.mine.report.bean.ReportReason;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.v12;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class ReportRepository {
    private static transient /* synthetic */ IpChange $ipChange;

    public static ReportRepository a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1755007997") ? (ReportRepository) ipChange.ipc$dispatch("-1755007997", new Object[0]) : new ReportRepository();
    }

    public List<ReportReason> b(Context context) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "963579")) {
            return (List) ipChange.ipc$dispatch("963579", new Object[]{this, context});
        }
        ArrayList arrayList = new ArrayList();
        String[] stringArray = context.getResources().getStringArray(R$array.report_type_string);
        while (i < stringArray.length) {
            ReportReason reportReason = new ReportReason();
            reportReason.reasonStr = stringArray[i];
            i++;
            reportReason.reasonType = i;
            arrayList.add(reportReason);
        }
        return arrayList;
    }

    public void c(String str, int i, int i2, int i3, String str2, String str3, final v12 v12Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-239245587")) {
            ipChange.ipc$dispatch("-239245587", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2, str3, v12Var});
            return;
        }
        ReportRequest reportRequest = new ReportRequest();
        reportRequest.extraInfo = str3;
        reportRequest.reason = str2;
        reportRequest.reasonType = i3;
        reportRequest.targetId = str;
        reportRequest.targetType = i2;
        reportRequest.type = i;
        reportRequest.request(new DMMtopRequestListener<ReportResponse>(ReportResponse.class) { // from class: cn.damai.mine.report.ReportRepository.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str4, String str5) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-975303303")) {
                    ipChange2.ipc$dispatch("-975303303", new Object[]{this, str4, str5});
                } else {
                    v12Var.a(str4, str5);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(ReportResponse reportResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2127509454")) {
                    ipChange2.ipc$dispatch("2127509454", new Object[]{this, reportResponse});
                } else {
                    v12Var.b(reportResponse);
                }
            }
        });
    }
}
