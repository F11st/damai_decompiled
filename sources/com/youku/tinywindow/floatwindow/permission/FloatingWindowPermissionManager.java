package com.youku.tinywindow.floatwindow.permission;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import com.youku.tinywindow.TinyWindowManager;
import com.youku.tinywindow.TinyWindowUtils;
import com.youku.tinywindow.floatwindow.FloatingWindowHelper;
import com.youku.tinywindow.floatwindow.permission.rom.HuaweiRomUtils;
import com.youku.tinywindow.floatwindow.permission.rom.MeizuRomUtils;
import com.youku.tinywindow.floatwindow.permission.rom.MiuiRomUtils;
import com.youku.tinywindow.floatwindow.permission.rom.OppoRomUtils;
import com.youku.tinywindow.floatwindow.permission.rom.QikuRomUtils;
import com.youku.tinywindow.floatwindow.permission.rom.RomUtils;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class FloatingWindowPermissionManager {
    private static final String TAG = "FloatingPermission";
    private static int applyPermissionCount;
    private static volatile FloatingWindowPermissionManager mPermissionManager;
    private Dialog applyDialog;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface OnConfirmResult {
        void confirmResult(boolean z);
    }

    private void ROM360PermissionApply(final Context context) {
        showConfirmDialog(context, new OnConfirmResult() { // from class: com.youku.tinywindow.floatwindow.permission.FloatingWindowPermissionManager.1
            @Override // com.youku.tinywindow.floatwindow.permission.FloatingWindowPermissionManager.OnConfirmResult
            public void confirmResult(boolean z) {
                if (z) {
                    QikuRomUtils.applyPermission(context);
                } else {
                    Log.e(FloatingWindowPermissionManager.TAG, "ROM:360, user manually refuse OVERLAY_PERMISSION");
                }
            }
        });
    }

    static /* synthetic */ int access$008() {
        int i = applyPermissionCount;
        applyPermissionCount = i + 1;
        return i;
    }

    private void applyPermission(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            if (RomUtils.checkIsMiuiRom()) {
                miuiROMPermissionApply(context);
            } else if (RomUtils.checkIsMeizuRom()) {
                meizuROMPermissionApply(context);
            } else if (RomUtils.checkIsHuaweiRom()) {
                huaweiROMPermissionApply(context);
            } else if (RomUtils.checkIs360Rom()) {
                ROM360PermissionApply(context);
            } else if (RomUtils.checkIsOppoRom()) {
                oppoROMPermissionApply(context);
            }
        }
        commonROMPermissionApply(context);
    }

    private boolean checkPermission(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            if (RomUtils.checkIsMiuiRom()) {
                return miuiPermissionCheck(context);
            }
            if (RomUtils.checkIsMeizuRom()) {
                return meizuPermissionCheck(context);
            }
            if (RomUtils.checkIsHuaweiRom()) {
                return huaweiPermissionCheck(context);
            }
            if (RomUtils.checkIs360Rom()) {
                return qikuPermissionCheck(context);
            }
        }
        return commonROMPermissionCheck(context);
    }

    private void commonROMPermissionApply(final Context context) {
        if (RomUtils.checkIsMeizuRom()) {
            meizuROMPermissionApply(context);
        } else if (Build.VERSION.SDK_INT >= 23) {
            showConfirmDialog(context, new OnConfirmResult() { // from class: com.youku.tinywindow.floatwindow.permission.FloatingWindowPermissionManager.6
                @Override // com.youku.tinywindow.floatwindow.permission.FloatingWindowPermissionManager.OnConfirmResult
                public void confirmResult(boolean z) {
                    if (z) {
                        try {
                            Intent intent = new Intent(Settings.class.getDeclaredField("ACTION_MANAGE_OVERLAY_PERMISSION").get(null).toString());
                            intent.setFlags(268435456);
                            intent.setData(Uri.parse("package:" + context.getPackageName()));
                            context.startActivity(intent);
                            return;
                        } catch (Exception e) {
                            Log.e(FloatingWindowPermissionManager.TAG, Log.getStackTraceString(e));
                            return;
                        }
                    }
                    Log.d(FloatingWindowPermissionManager.TAG, "user manually refuse OVERLAY_PERMISSION");
                    FloatingWindowPermissionManager.access$008();
                    if (TinyWindowManager.getInstance().getTinyWindowHelper() == null || !(TinyWindowManager.getInstance().getTinyWindowHelper() instanceof FloatingWindowHelper)) {
                        return;
                    }
                    ((FloatingWindowHelper) TinyWindowManager.getInstance().getTinyWindowHelper()).notifyShowTinyWindowFailed(0);
                }
            });
        }
    }

    public static void commonROMPermissionApplyInternal(Context context) throws NoSuchFieldException, IllegalAccessException {
        Intent intent = new Intent(Settings.class.getDeclaredField("ACTION_MANAGE_OVERLAY_PERMISSION").get(null).toString());
        intent.setFlags(268435456);
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        context.startActivity(intent);
    }

    private boolean commonROMPermissionCheck(Context context) {
        if (RomUtils.checkIsMeizuRom()) {
            return meizuPermissionCheck(context);
        }
        Boolean bool = Boolean.TRUE;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                bool = (Boolean) Settings.class.getDeclaredMethod("canDrawOverlays", Context.class).invoke(null, context);
            } catch (Exception e) {
                Log.e(TAG, Log.getStackTraceString(e));
            }
        }
        return bool.booleanValue();
    }

    public static FloatingWindowPermissionManager getInstance() {
        if (mPermissionManager == null) {
            synchronized (FloatingWindowPermissionManager.class) {
                if (mPermissionManager == null) {
                    mPermissionManager = new FloatingWindowPermissionManager();
                }
            }
        }
        return mPermissionManager;
    }

    private boolean huaweiPermissionCheck(Context context) {
        return HuaweiRomUtils.checkFloatWindowPermission(context);
    }

    private void huaweiROMPermissionApply(final Context context) {
        showConfirmDialog(context, new OnConfirmResult() { // from class: com.youku.tinywindow.floatwindow.permission.FloatingWindowPermissionManager.2
            @Override // com.youku.tinywindow.floatwindow.permission.FloatingWindowPermissionManager.OnConfirmResult
            public void confirmResult(boolean z) {
                if (z) {
                    HuaweiRomUtils.applyPermission(context);
                } else {
                    Log.e(FloatingWindowPermissionManager.TAG, "ROM:huawei, user manually refuse OVERLAY_PERMISSION");
                }
            }
        });
    }

    private boolean meizuPermissionCheck(Context context) {
        return MeizuRomUtils.checkFloatWindowPermission(context);
    }

    private void meizuROMPermissionApply(final Context context) {
        showConfirmDialog(context, new OnConfirmResult() { // from class: com.youku.tinywindow.floatwindow.permission.FloatingWindowPermissionManager.3
            @Override // com.youku.tinywindow.floatwindow.permission.FloatingWindowPermissionManager.OnConfirmResult
            public void confirmResult(boolean z) {
                if (z) {
                    MeizuRomUtils.applyPermission(context);
                } else {
                    Log.e(FloatingWindowPermissionManager.TAG, "ROM:meizu, user manually refuse OVERLAY_PERMISSION");
                }
            }
        });
    }

    private boolean miuiPermissionCheck(Context context) {
        return MiuiRomUtils.checkFloatWindowPermission(context);
    }

    private void miuiROMPermissionApply(final Context context) {
        showConfirmDialog(context, new OnConfirmResult() { // from class: com.youku.tinywindow.floatwindow.permission.FloatingWindowPermissionManager.4
            @Override // com.youku.tinywindow.floatwindow.permission.FloatingWindowPermissionManager.OnConfirmResult
            public void confirmResult(boolean z) {
                if (z) {
                    MiuiRomUtils.applyMiuiPermission(context);
                } else {
                    Log.e(FloatingWindowPermissionManager.TAG, "ROM:miui, user manually refuse OVERLAY_PERMISSION");
                }
            }
        });
    }

    private void oppoROMPermissionApply(final Context context) {
        showConfirmDialog(context, new OnConfirmResult() { // from class: com.youku.tinywindow.floatwindow.permission.FloatingWindowPermissionManager.5
            @Override // com.youku.tinywindow.floatwindow.permission.FloatingWindowPermissionManager.OnConfirmResult
            public void confirmResult(boolean z) {
                if (z) {
                    OppoRomUtils.applyOppoPermission(context);
                } else {
                    Log.e(FloatingWindowPermissionManager.TAG, "ROM:miui, user manually refuse OVERLAY_PERMISSION");
                }
            }
        });
    }

    private boolean qikuPermissionCheck(Context context) {
        return QikuRomUtils.checkFloatWindowPermission(context);
    }

    private void showConfirmDialog(Context context, OnConfirmResult onConfirmResult) {
        showConfirmDialog(context, "您的手机没有授予悬浮窗权限，请开启后再试", onConfirmResult);
    }

    public boolean applyFloatingWindowPermission(Context context) {
        if (checkPermission(context)) {
            return true;
        }
        if (applyPermissionCount < TinyWindowUtils.getApplyPermissionCount()) {
            applyPermission(context);
            return false;
        } else if (TinyWindowManager.getInstance().getTinyWindowHelper() == null || !(TinyWindowManager.getInstance().getTinyWindowHelper() instanceof FloatingWindowHelper)) {
            return false;
        } else {
            ((FloatingWindowHelper) TinyWindowManager.getInstance().getTinyWindowHelper()).notifyShowTinyWindowFailed(1);
            return false;
        }
    }

    private void showConfirmDialog(Context context, String str, final OnConfirmResult onConfirmResult) {
        Dialog dialog = this.applyDialog;
        if (dialog != null && dialog.isShowing()) {
            this.applyDialog.dismiss();
        }
        AlertDialog create = new AlertDialog.Builder(context).setCancelable(true).setTitle("").setMessage(str).setPositiveButton("现在去开启", new DialogInterface.OnClickListener() { // from class: com.youku.tinywindow.floatwindow.permission.FloatingWindowPermissionManager.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                onConfirmResult.confirmResult(true);
                dialogInterface.dismiss();
            }
        }).setNegativeButton("暂不开启", new DialogInterface.OnClickListener() { // from class: com.youku.tinywindow.floatwindow.permission.FloatingWindowPermissionManager.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                onConfirmResult.confirmResult(false);
                dialogInterface.dismiss();
            }
        }).create();
        this.applyDialog = create;
        create.show();
    }
}
