package mtopsdk.mtop.antiattack;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.global.SwitchConfig;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ApiLockHelper {
    private static final long LOCK_PERIOD = 10;
    private static final String TAG = "mtopsdk.ApiLockHelper";
    private static ConcurrentHashMap<String, LockedEntity> lockedMap = new ConcurrentHashMap<>();

    public static boolean iSApiLocked(String str, long j) {
        boolean z = false;
        if (StringUtils.isBlank(str)) {
            return false;
        }
        LockedEntity lockedEntity = lockedMap.get(str);
        if (lockedEntity != null) {
            if (Math.abs(j - lockedEntity.lockStartTime) < lockedEntity.lockInterval) {
                z = true;
            } else {
                lockedMap.remove(str);
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                    TBSdkLog.w(TAG, "[iSApiLocked]remove apiKey=" + str);
                }
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                StringBuilder sb = new StringBuilder();
                sb.append("[iSApiLocked] isLocked=");
                sb.append(z);
                sb.append(AVFSCacheConstants.COMMA_SEP);
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append(", currentTime=");
                sb2.append(j);
                sb2.append(", lockEntity=");
                sb2.append(lockedEntity.toString());
                sb.append((Object) sb2);
                TBSdkLog.w(TAG, sb.toString());
            }
        }
        return z;
    }

    public static void lock(String str, long j, long j2) {
        if (StringUtils.isBlank(str)) {
            return;
        }
        LockedEntity lockedEntity = lockedMap.get(str);
        long individualApiLockInterval = j2 > 0 ? j2 / 1000 : SwitchConfig.getInstance().getIndividualApiLockInterval(str);
        if (individualApiLockInterval <= 0) {
            individualApiLockInterval = SwitchConfig.getInstance().getGlobalApiLockInterval();
            if (individualApiLockInterval <= 0) {
                individualApiLockInterval = 10;
            }
        }
        long j3 = individualApiLockInterval;
        if (lockedEntity == null) {
            lockedEntity = new LockedEntity(str, j, j3);
        } else {
            lockedEntity.lockStartTime = j;
            lockedEntity.lockInterval = j3;
        }
        lockedMap.put(str, lockedEntity);
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[lock]");
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append(", currentTime=");
            sb2.append(j);
            sb2.append(", lockEntity=");
            sb2.append(lockedEntity.toString());
            sb.append((Object) sb2);
            TBSdkLog.w(TAG, sb.toString());
        }
    }
}
