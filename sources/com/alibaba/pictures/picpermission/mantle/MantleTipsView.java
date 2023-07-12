package com.alibaba.pictures.picpermission.mantle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.pictures.picpermission.R$drawable;
import com.alibaba.pictures.picpermission.R$id;
import com.alibaba.pictures.picpermission.R$layout;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.ka;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/alibaba/pictures/picpermission/mantle/MantleTipsView;", "Ltb/ka;", "<init>", "()V", "permission_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class MantleTipsView extends ka {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView b;
    private ImageView c;
    private TextView d;

    public static final /* synthetic */ TextView f(MantleTipsView mantleTipsView) {
        TextView textView = mantleTipsView.d;
        if (textView == null) {
            b41.A("tvDescribe");
        }
        return textView;
    }

    public static final /* synthetic */ ImageView g(MantleTipsView mantleTipsView) {
        ImageView imageView = mantleTipsView.c;
        if (imageView == null) {
            b41.A("tvIcon");
        }
        return imageView;
    }

    public static final /* synthetic */ TextView h(MantleTipsView mantleTipsView) {
        TextView textView = mantleTipsView.b;
        if (textView == null) {
            b41.A("tvTitle");
        }
        return textView;
    }

    private final PermissionModel l(PermissionModel permissionModel) {
        boolean r;
        boolean r2;
        String str;
        boolean r3;
        boolean r4;
        boolean r5;
        boolean r6;
        String str2;
        boolean r7;
        boolean r8;
        boolean r9;
        boolean r10;
        boolean r11;
        boolean r12;
        boolean r13;
        boolean r14;
        boolean r15;
        boolean r16;
        boolean r17;
        Integer iconResId;
        Integer iconResId2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1591851477")) {
            return (PermissionModel) ipChange.ipc$dispatch("-1591851477", new Object[]{this, permissionModel});
        }
        String[] permission = permissionModel.getPermission();
        int i = R$drawable.permission_default_icon;
        if (permissionModel.getTitle() != null && permissionModel.getDescribe() != null) {
            if (permissionModel.getIconResId() == null || ((iconResId2 = permissionModel.getIconResId()) != null && iconResId2.intValue() == 0)) {
                permissionModel.setIconResId(Integer.valueOf(i));
            }
            return permissionModel;
        }
        r = ArraysKt___ArraysKt.r(permission, "android.permission.CAMERA");
        String str3 = "";
        if (r) {
            i = R$drawable.permission_store_pic;
            str3 = "相机";
            str = "用于选取、上传、发布及分享图片/视频";
        } else {
            r2 = ArraysKt___ArraysKt.r(permission, "android.permission.ACCESS_FINE_LOCATION");
            if (!r2) {
                r3 = ArraysKt___ArraysKt.r(permission, "android.permission.ACCESS_FINE_LOCATION");
                if (!r3) {
                    r4 = ArraysKt___ArraysKt.r(permission, "android.permission.READ_EXTERNAL_STORAGE");
                    if (!r4) {
                        r5 = ArraysKt___ArraysKt.r(permission, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!r5) {
                            r6 = ArraysKt___ArraysKt.r(permission, "android.permission.READ_CALENDAR");
                            if (!r6) {
                                r7 = ArraysKt___ArraysKt.r(permission, "android.permission.WRITE_CALENDAR");
                                if (!r7) {
                                    r8 = ArraysKt___ArraysKt.r(permission, "android.permission.READ_CONTACTS");
                                    if (!r8) {
                                        r9 = ArraysKt___ArraysKt.r(permission, "android.permission.WRITE_CONTACTS");
                                        if (!r9) {
                                            r10 = ArraysKt___ArraysKt.r(permission, "android.permission.GET_ACCOUNTS");
                                            if (!r10) {
                                                r11 = ArraysKt___ArraysKt.r(permission, "android.permission.BODY_SENSORS");
                                                if (r11) {
                                                    str2 = "传感器";
                                                } else {
                                                    r12 = ArraysKt___ArraysKt.r(permission, "android.permission.RECORD_AUDIO");
                                                    if (r12) {
                                                        str2 = "麦克风";
                                                    } else {
                                                        r13 = ArraysKt___ArraysKt.r(permission, "android.permission.SEND_SMS");
                                                        if (!r13) {
                                                            r14 = ArraysKt___ArraysKt.r(permission, "android.permission.RECEIVE_SMS");
                                                            if (!r14) {
                                                                r15 = ArraysKt___ArraysKt.r(permission, "android.permission.READ_SMS");
                                                                if (!r15) {
                                                                    r16 = ArraysKt___ArraysKt.r(permission, "android.permission.RECEIVE_WAP_PUSH");
                                                                    if (!r16) {
                                                                        r17 = ArraysKt___ArraysKt.r(permission, "android.permission.RECEIVE_MMS");
                                                                        if (!r17) {
                                                                            str = "";
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        str2 = "短信";
                                                    }
                                                }
                                                str3 = str2;
                                                str = "";
                                            }
                                        }
                                    }
                                    str2 = "通讯录";
                                    str3 = str2;
                                    str = "";
                                }
                            }
                            i = R$drawable.pemission_calendar_icon;
                            str2 = "日历";
                            str3 = str2;
                            str = "";
                        }
                    }
                    str3 = "存储";
                    str = "用于为您保存图片至本地";
                }
            }
            i = R$drawable.permission_location_icon;
            str3 = "位置";
            str = "为您提供附近的项目信息";
        }
        if (str3.length() == 0) {
            return permissionModel;
        }
        if (permissionModel.getTitle() == null) {
            permissionModel.setTitle(str3 + "权限使用说明");
        }
        if (permissionModel.getIconResId() == null || ((iconResId = permissionModel.getIconResId()) != null && iconResId.intValue() == 0)) {
            permissionModel.setIconResId(Integer.valueOf(i));
        }
        if (permissionModel.getDescribe() == null) {
            StringBuilder sb = new StringBuilder("授权获取" + str3 + "权限");
            if (str.length() > 0) {
                sb.append(",");
                sb.append(str);
            }
            permissionModel.setDescribe(sb.toString());
        }
        return permissionModel;
    }

    @Override // tb.ka
    public int b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "896715209") ? ((Integer) ipChange.ipc$dispatch("896715209", new Object[]{this})).intValue() : R$layout.mantls_permission_tips_view;
    }

    @Override // tb.ka
    public void c(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2037647477")) {
            ipChange.ipc$dispatch("2037647477", new Object[]{this, view});
            return;
        }
        b41.i(view, "view");
        super.c(view);
        View findViewById = view.findViewById(R$id.tv_title);
        b41.h(findViewById, "view.findViewById(R.id.tv_title)");
        this.b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R$id.iv_icon);
        b41.h(findViewById2, "view.findViewById(R.id.iv_icon)");
        this.c = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R$id.tv_describe);
        b41.h(findViewById3, "view.findViewById(R.id.tv_describe)");
        this.d = (TextView) findViewById3;
    }

    @Override // tb.ka
    public void e(@NotNull PermissionModel permissionModel, boolean z) {
        int i;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "1602130393")) {
            ipChange.ipc$dispatch("1602130393", new Object[]{this, permissionModel, Boolean.valueOf(z)});
            return;
        }
        b41.i(permissionModel, "permissionModel");
        PermissionModel l = l(permissionModel);
        if (this.b == null || this.c == null || this.d == null) {
            return;
        }
        View a = a();
        if (a != null) {
            if (z) {
                String title = l.getTitle();
                if (!(title == null || title.length() == 0)) {
                    i = 0;
                    a.setVisibility(i);
                }
            }
            i = 8;
            a.setVisibility(i);
        }
        String title2 = l.getTitle();
        if (!(title2 == null || title2.length() == 0)) {
            TextView textView = this.b;
            if (textView == null) {
                b41.A("tvTitle");
            }
            textView.setText(l.getTitle());
        }
        if (l.getIconResId() != null) {
            ImageView imageView = this.c;
            if (imageView == null) {
                b41.A("tvIcon");
            }
            Integer iconResId = l.getIconResId();
            b41.f(iconResId);
            imageView.setImageResource(iconResId.intValue());
        }
        String describe = l.getDescribe();
        if (describe != null && describe.length() != 0) {
            z2 = false;
        }
        if (z2) {
            return;
        }
        TextView textView2 = this.d;
        if (textView2 == null) {
            b41.A("tvDescribe");
        }
        textView2.setText(l.getDescribe());
    }
}
