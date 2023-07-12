package tb;

import android.text.TextUtils;
import cn.damai.push.DaMaiPushAgent;
import cn.damai.push.model.AckMessageDO;
import cn.damai.push.model.RecModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.pictures.accs.IAccsServiceDelegate;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class u2 implements IAccsServiceDelegate {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String ACCS_DATA_ILLEGAL_STATUS = "2";
    @NotNull
    public static final String ACCS_ERROR_STATUS = "1";
    @NotNull
    public static final String ACCS_SUCCESSS_STATUS = "0";
    @NotNull
    public static final String ACCS_TICKLET_TYPE = "ticklet_download_v2";
    @NotNull
    public static final String ACCS_TICKLET_USED = "ticklet_used_v2";
    @NotNull
    public static final String ACCS_TYPE_NOT_USED = "accs_type_not_used";
    @NotNull
    public static final String ACCS_TYPE_POPCORN_CONFIG = "maisync_test01";
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String EVENT_PAGE_NAME = "dm_sync_accs";
    @NotNull
    public static final String TAG = "AccsServiceDelegate";

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    public final void a(@Nullable String str, @Nullable String str2, long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1692149787")) {
            ipChange.ipc$dispatch("1692149787", new Object[]{this, str, str2, Long.valueOf(j), Long.valueOf(j2)});
        } else {
            r2.a(str, str2, System.currentTimeMillis() - j, j2);
        }
    }

    @Override // com.alibaba.pictures.accs.IAccsServiceDelegate
    public void onAntiBrush(boolean z, @Nullable TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2126008756")) {
            ipChange.ipc$dispatch("2126008756", new Object[]{this, Boolean.valueOf(z), extraInfo});
            return;
        }
        cb1.b(TAG, "anti brush result:" + z);
    }

    @Override // com.alibaba.pictures.accs.IAccsServiceDelegate
    public void onBind(@Nullable String str, int i, @Nullable TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "990591254")) {
            ipChange.ipc$dispatch("990591254", new Object[]{this, str, Integer.valueOf(i), extraInfo});
            return;
        }
        cb1.a("Service " + str + " onBind, errcode:" + i);
    }

    @Override // com.alibaba.pictures.accs.IAccsServiceDelegate
    public void onConnected(@Nullable TaoBaseService.ConnectInfo connectInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1545638769")) {
            ipChange.ipc$dispatch("1545638769", new Object[]{this, connectInfo});
        } else if (connectInfo != null) {
            cb1.b(TAG, connectInfo.host + " isInapp:" + connectInfo.isInapp + " isCenterHost:" + connectInfo.isCenterHost);
        }
    }

    @Override // com.alibaba.pictures.accs.IAccsServiceDelegate
    public void onDataReceive(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, @Nullable TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1489581555")) {
            ipChange.ipc$dispatch("1489581555", new Object[]{this, str, str2, str3, str4, extraInfo});
            return;
        }
        b41.i(str4, "payLoadData");
        RecModel recModel = (RecModel) yh0.INSTANCE.c(str4, RecModel.class);
        AckMessageDO ackMessageDO = new AckMessageDO();
        ackMessageDO.setBizType(recModel.getBizType());
        ackMessageDO.setDataId(str3);
        ackMessageDO.setProcessTime(String.valueOf(System.currentTimeMillis()));
        HashMap hashMap = new HashMap();
        String data = recModel.getData();
        b41.h(data, "model.data");
        hashMap.put("data", data);
        hashMap.put("time", String.valueOf(System.currentTimeMillis()));
        String E = z20.E();
        b41.h(E, "getUserCode()");
        hashMap.put("usercode", E);
        if (recModel.getData() == null) {
            ackMessageDO.setResultCode("1");
            DaMaiPushAgent.i(str3, JSON.toJSONBytes(ackMessageDO, new SerializerFeature[0]));
            cn.damai.common.user.c.e().A(hashMap, "model_error", EVENT_PAGE_NAME);
            a("1", "ACCS_ERROR_STATUS", 0L, 0L);
        } else if (b41.d(ACCS_TICKLET_TYPE, recModel.getBizType())) {
            ackMessageDO.setResultCode("0");
            DaMaiPushAgent.i(str3, JSON.toJSONBytes(ackMessageDO, new SerializerFeature[0]));
            DaMaiPushAgent.k(recModel.getBizType(), recModel.getDataId(), recModel.getData());
            cn.damai.common.user.c.e().A(hashMap, recModel.getBizType(), EVENT_PAGE_NAME);
            if (recModel.getSendTime() == null || str2 == null) {
                return;
            }
            String sendTime = recModel.getSendTime();
            b41.h(sendTime, "model.sendTime");
            a("0", ACCS_TICKLET_TYPE, Long.parseLong(sendTime), Long.parseLong(str2));
        } else if (b41.d(ACCS_TICKLET_USED, recModel.getBizType())) {
            ackMessageDO.setResultCode("0");
            DaMaiPushAgent.i(str3, JSON.toJSONBytes(ackMessageDO, new SerializerFeature[0]));
            DaMaiPushAgent.l(recModel.getData());
            cn.damai.common.user.c.e().A(hashMap, recModel.getBizType(), EVENT_PAGE_NAME);
            if (recModel.getSendTime() == null || str2 == null) {
                return;
            }
            String sendTime2 = recModel.getSendTime();
            b41.h(sendTime2, "model.sendTime");
            a("0", ACCS_TICKLET_USED, Long.parseLong(sendTime2), Long.parseLong(str2));
        } else if (b41.d(ACCS_TYPE_POPCORN_CONFIG, recModel.getBizType())) {
            ackMessageDO.setResultCode("0");
            DaMaiPushAgent.i(str3, JSON.toJSONBytes(ackMessageDO, new SerializerFeature[0]));
            DaMaiPushAgent.j(recModel.getData());
        } else {
            ackMessageDO.setResultCode("2");
            DaMaiPushAgent.i(str3, JSON.toJSONBytes(ackMessageDO, new SerializerFeature[0]));
            if (!TextUtils.isEmpty(recModel.getBizType())) {
                cn.damai.common.user.c.e().A(hashMap, recModel.getBizType(), EVENT_PAGE_NAME);
            } else {
                cn.damai.common.user.c.e().A(hashMap, ACCS_TYPE_NOT_USED, EVENT_PAGE_NAME);
            }
            if (recModel.getSendTime() == null || str2 == null) {
                return;
            }
            String sendTime3 = recModel.getSendTime();
            b41.h(sendTime3, "model.sendTime");
            a("2", ACCS_TYPE_NOT_USED, Long.parseLong(sendTime3), Long.parseLong(str2));
        }
    }

    @Override // com.alibaba.pictures.accs.IAccsServiceDelegate
    public void onDisconnected(@Nullable TaoBaseService.ConnectInfo connectInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "22381719")) {
            ipChange.ipc$dispatch("22381719", new Object[]{this, connectInfo});
        } else if (connectInfo != null) {
            cb1.b(TAG, connectInfo.host + " isInapp:" + connectInfo.isInapp + " isCenterHost:" + connectInfo.isCenterHost + "errorCode:" + connectInfo.errorCode + " detail:" + connectInfo.errordetail);
            HashMap hashMap = new HashMap();
            hashMap.put("data", "onDisconnected");
            StringBuilder sb = new StringBuilder();
            sb.append("errorCode = ");
            sb.append(connectInfo.errorCode);
            sb.append(" & errorDesc = ");
            sb.append(connectInfo.errordetail);
            hashMap.put("error", sb.toString());
            hashMap.put("time", String.valueOf(System.currentTimeMillis()));
            String E = z20.E();
            b41.h(E, "getUserCode()");
            hashMap.put("usercode", E);
            cn.damai.common.user.c.e().A(hashMap, "model_error", EVENT_PAGE_NAME);
        }
    }

    @Override // com.alibaba.pictures.accs.IAccsServiceDelegate
    public void onResponse(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable byte[] bArr, @Nullable TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1617032833")) {
            ipChange.ipc$dispatch("1617032833", new Object[]{this, str, str2, num, bArr, extraInfo});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Service ");
        sb.append(str);
        sb.append(" onResponse:");
        sb.append(bArr != null ? new String(bArr, hi.UTF_8) : "null");
        sb.append("errorCode:");
        sb.append(num);
        cb1.b(TAG, sb.toString());
    }

    @Override // com.alibaba.pictures.accs.IAccsServiceDelegate
    public void onSendData(@NotNull String str, @NotNull String str2, int i, @NotNull TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-220739797")) {
            ipChange.ipc$dispatch("-220739797", new Object[]{this, str, str2, Integer.valueOf(i), extraInfo});
            return;
        }
        b41.i(str, "serviceId");
        b41.i(str2, Constants.KEY_DATA_ID);
        b41.i(extraInfo, "info");
        cb1.b(TAG, "Service " + str + " onSendData:" + i + " dataId:" + str2);
    }

    @Override // com.alibaba.pictures.accs.IAccsServiceDelegate
    public void onUnbind(@Nullable String str, int i, @Nullable TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "353058077")) {
            ipChange.ipc$dispatch("353058077", new Object[]{this, str, Integer.valueOf(i), extraInfo});
            return;
        }
        cb1.b(TAG, "Service " + str + " onUnbind, errcode:" + i);
    }
}
