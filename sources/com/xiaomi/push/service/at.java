package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.push.hw;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class at {
    private static final boolean a = Log.isLoggable("NCHelper", 3);

    private static int a(NotificationChannel notificationChannel) {
        int i = 0;
        try {
            i = ((Integer) com.xiaomi.push.bk.b((Object) notificationChannel, "getUserLockedFields", new Object[0])).intValue();
            if (a) {
                a("isUserLockedChannel:" + i + " " + notificationChannel);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m587a("NCHelper", "is user locked error" + e);
        }
        return i;
    }

    @TargetApi(26)
    private static NotificationChannel a(String str, NotificationChannel notificationChannel) {
        NotificationChannel notificationChannel2 = new NotificationChannel(str, notificationChannel.getName(), notificationChannel.getImportance());
        notificationChannel2.setDescription(notificationChannel.getDescription());
        notificationChannel2.enableVibration(notificationChannel.shouldVibrate());
        notificationChannel2.enableLights(notificationChannel.shouldShowLights());
        notificationChannel2.setSound(notificationChannel.getSound(), notificationChannel.getAudioAttributes());
        notificationChannel2.setLockscreenVisibility(notificationChannel.getLockscreenVisibility());
        return notificationChannel2;
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush_channel_copy_sp", 0);
    }

    @TargetApi(26)
    public static String a(ax axVar, String str, CharSequence charSequence, String str2, int i, int i2, String str3, String str4) {
        String m1186a = axVar.m1186a(str);
        boolean z = a;
        if (z) {
            a("createChannel: appChannelId:" + m1186a + " serverChannelId:" + str + " serverChannelName:" + ((Object) charSequence) + " serverChannelDesc:" + str2 + " serverChannelNotifyType:" + i + " serverChannelName:" + ((Object) charSequence) + " serverChannelImportance:" + i2 + " channelSoundStr:" + str3 + " channelPermissions:" + str4);
        }
        NotificationChannel notificationChannel = new NotificationChannel(m1186a, charSequence, i2);
        notificationChannel.setDescription(str2);
        notificationChannel.enableVibration((i & 2) != 0);
        notificationChannel.enableLights((i & 4) != 0);
        if ((i & 1) == 0) {
            notificationChannel.setSound(null, null);
        } else if (!TextUtils.isEmpty(str3)) {
            if (str3.startsWith("android.resource://" + axVar.m1185a())) {
                notificationChannel.setSound(Uri.parse(str3), Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
        }
        if (z) {
            a("create channel:" + notificationChannel);
        }
        a(axVar, notificationChannel, str4);
        return m1186a;
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(26)
    static void a(Context context, ax axVar, NotificationChannel notificationChannel, int i, String str) {
        if (i <= 0) {
            axVar.a(notificationChannel);
            return;
        }
        int a2 = com.xiaomi.push.h.a(context) >= 2 ? e.a(context.getPackageName(), str) : 0;
        NotificationChannel a3 = a(notificationChannel.getId(), notificationChannel);
        if ((i & 32) != 0) {
            if (notificationChannel.getSound() != null) {
                a3.setSound(null, null);
            } else {
                a3.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
        }
        if ((i & 16) != 0) {
            if (notificationChannel.shouldVibrate()) {
                a3.enableVibration(false);
            } else {
                a3.enableVibration(true);
            }
        }
        if ((i & 8) != 0) {
            if (notificationChannel.shouldShowLights()) {
                a3.enableLights(false);
            } else {
                a3.enableLights(true);
            }
        }
        if ((i & 4) != 0) {
            int importance = notificationChannel.getImportance() - 1;
            if (importance <= 0) {
                importance = 2;
            }
            a3.setImportance(importance);
        }
        if ((i & 2) != 0) {
            a3.setLockscreenVisibility(notificationChannel.getLockscreenVisibility() - 1);
        }
        axVar.a(a3);
        axVar.a(notificationChannel, true);
        e.a(axVar.m1185a(), notificationChannel.getId(), a2, 0);
    }

    public static void a(Context context, String str) {
        if (!com.xiaomi.push.m.m1119a(context) || TextUtils.isEmpty(str)) {
            return;
        }
        c(context, str);
        e.a(context, str);
    }

    private static void a(Context context, List<String> list) {
        if (a) {
            a("deleteCopiedChannelRecord:" + list);
        }
        if (list.isEmpty()) {
            return;
        }
        SharedPreferences.Editor edit = a(context).edit();
        for (String str : list) {
            edit.remove(str);
        }
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(hw hwVar) {
        Map<String, String> map;
        if (hwVar == null || (map = hwVar.f532a) == null || !map.containsKey("REMOVE_CHANNEL_MARK")) {
            return;
        }
        hwVar.f528a = 0;
        hwVar.f532a.remove("channel_id");
        hwVar.f532a.remove("channel_importance");
        hwVar.f532a.remove("channel_name");
        hwVar.f532a.remove("channel_description");
        hwVar.f532a.remove("channel_perm");
        com.xiaomi.channel.commonutils.logger.b.m586a("delete channel info by:" + hwVar.f532a.get("REMOVE_CHANNEL_MARK"));
        hwVar.f532a.remove("REMOVE_CHANNEL_MARK");
    }

    @TargetApi(26)
    private static void a(ax axVar, NotificationChannel notificationChannel, String str) {
        int i;
        char c;
        int i2;
        Context m1184a = axVar.m1184a();
        String id = notificationChannel.getId();
        String a2 = ax.a(id, axVar.m1185a());
        boolean z = a;
        if (z) {
            a("appChannelId:" + id + " oldChannelId:" + a2);
        }
        if (!com.xiaomi.push.m.m1119a(m1184a) || TextUtils.equals(id, a2)) {
            NotificationChannel m1183a = axVar.m1183a(id);
            if (z) {
                a("elseLogic getNotificationChannel:" + m1183a);
            }
            if (m1183a == null) {
                axVar.a(notificationChannel);
            }
            i = 0;
            c = 0;
        } else {
            NotificationManager notificationManager = (NotificationManager) m1184a.getSystemService("notification");
            NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(a2);
            NotificationChannel m1183a2 = axVar.m1183a(id);
            if (z) {
                a("xmsfChannel:" + notificationChannel2);
                a("appChannel:" + m1183a2);
            }
            if (notificationChannel2 != null) {
                NotificationChannel a3 = a(id, notificationChannel2);
                if (z) {
                    a("copyXmsf copyXmsfChannel:" + a3);
                }
                if (m1183a2 != null) {
                    i2 = a(m1183a2);
                    axVar.a(a3, i2 == 0);
                    c = 3;
                } else {
                    i2 = a(notificationChannel2);
                    a(m1184a, axVar, a3, i2, notificationChannel2.getId());
                    c = 4;
                }
                b(m1184a, id);
                notificationManager.deleteNotificationChannel(a2);
            } else if (m1183a2 == null) {
                if (z) {
                    a("appHack createNotificationChannel:" + notificationChannel);
                }
                axVar.a(notificationChannel);
                i2 = 0;
                c = 1;
            } else if (m1175a(m1184a, id) || !a(notificationChannel, m1183a2)) {
                i2 = 0;
                c = 0;
            } else {
                if (z) {
                    a("appHack updateNotificationChannel:" + notificationChannel);
                }
                i2 = a(m1183a2);
                axVar.a(notificationChannel, i2 == 0);
                c = 2;
            }
            i = i2;
        }
        e.a(axVar.m1184a(), axVar.m1185a(), id, notificationChannel.getImportance(), str, c == 1 || c == 4 || c == 3, i);
    }

    private static void a(String str) {
        com.xiaomi.channel.commonutils.logger.b.m587a("NCHelper", str);
    }

    @TargetApi(26)
    private static boolean a(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        boolean z;
        if (notificationChannel == null || notificationChannel2 == null) {
            return false;
        }
        boolean z2 = true;
        if (TextUtils.equals(notificationChannel.getName(), notificationChannel2.getName())) {
            z = false;
        } else {
            if (a) {
                a("appHack channelConfigLowerCompare:getName");
            }
            z = true;
        }
        if (!TextUtils.equals(notificationChannel.getDescription(), notificationChannel2.getDescription())) {
            if (a) {
                a("appHack channelConfigLowerCompare:getDescription");
            }
            z = true;
        }
        if (notificationChannel.getImportance() != notificationChannel2.getImportance()) {
            notificationChannel.setImportance(Math.min(notificationChannel.getImportance(), notificationChannel2.getImportance()));
            if (a) {
                a("appHack channelConfigLowerCompare:getImportance  " + notificationChannel.getImportance() + " " + notificationChannel2.getImportance());
            }
            z = true;
        }
        if (notificationChannel.shouldVibrate() != notificationChannel2.shouldVibrate()) {
            notificationChannel.enableVibration(false);
            if (a) {
                a("appHack channelConfigLowerCompare:enableVibration");
            }
            z = true;
        }
        if (notificationChannel.shouldShowLights() != notificationChannel2.shouldShowLights()) {
            notificationChannel.enableLights(false);
            if (a) {
                a("appHack channelConfigLowerCompare:enableLights");
            }
            z = true;
        }
        if ((notificationChannel.getSound() != null) != (notificationChannel2.getSound() != null)) {
            notificationChannel.setSound(null, null);
            if (a) {
                a("appHack channelConfigLowerCompare:setSound");
            }
        } else {
            z2 = z;
        }
        if (a) {
            a("appHack channelConfigLowerCompare:isDifferent:" + z2);
        }
        return z2;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m1175a(Context context, String str) {
        if (a) {
            a("checkCopeidChannel:newFullChannelId:" + str + AltriaXLaunchTime.SPACE + a(context).getBoolean(str, false));
        }
        return a(context).getBoolean(str, false);
    }

    private static void b(Context context, String str) {
        if (a) {
            a("recordCopiedChannel:" + str);
        }
        a(context).edit().putBoolean(str, true).apply();
    }

    private static void c(Context context, String str) {
        try {
            ax a2 = ax.a(context, str);
            Set<String> keySet = a(context).getAll().keySet();
            ArrayList arrayList = new ArrayList();
            for (String str2 : keySet) {
                if (a2.m1188a(str2)) {
                    arrayList.add(str2);
                    if (a) {
                        a("delete channel copy record:" + str2);
                    }
                }
            }
            a(context, arrayList);
        } catch (Exception unused) {
        }
    }
}
