package com.taobao.accs.net;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import java.util.Calendar;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AlarmHeartBeatMgr extends HeartbeatManager {
    private AlarmManager mAlarmManager;
    private PendingIntent mAlarmPendingIntent;

    public AlarmHeartBeatMgr(Context context) {
        super(context);
        try {
            this.mAlarmManager = (AlarmManager) this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        } catch (Throwable th) {
            ALog.e("AlarmHeartBeatMgr", "AlarmHeartBeatMgr", th, new Object[0]);
        }
    }

    @Override // com.taobao.accs.net.HeartbeatManager
    protected void setInner(int i) {
        if (this.mAlarmManager == null) {
            this.mAlarmManager = (AlarmManager) this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        }
        if (this.mAlarmManager == null) {
            ALog.e("AlarmHeartBeatMgr", "setInner null", new Object[0]);
            return;
        }
        if (this.mAlarmPendingIntent == null) {
            Intent intent = new Intent();
            intent.setPackage(this.mContext.getPackageName());
            intent.addFlags(32);
            intent.setAction(Constants.ACTION_COMMAND);
            intent.putExtra("command", 201);
            this.mAlarmPendingIntent = PendingIntent.getBroadcast(this.mContext, 0, intent, 0);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(13, i);
        this.mAlarmManager.set(0, calendar.getTimeInMillis(), this.mAlarmPendingIntent);
    }
}
