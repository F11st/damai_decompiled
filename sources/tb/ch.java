package tb;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.RequiresApi;
import cn.damai.category.category.bean.CategoryEntity;
import cn.damai.category.category.bean.CategoryNewTitleBean;
import cn.damai.category.category.bean.CategoryNewTitleListBean;
import cn.damai.category.common.bean.CategoryBean;
import cn.damai.category.common.bean.CategoryPerformBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ch {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int ALL = 9;
    public static final int BRAND = 8;
    public static final int NEARBY_PROJECT_HEAD = 1;
    public static final int PROJECT = 4;
    public static final int RANK = 5;
    public static final int STAR = 2;
    public static final int TOUR = 12;
    public static final int VIDEOPROJECT = 11;
    private static List<CategoryNewTitleBean> a;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements Animator.AnimatorListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-895547540")) {
                ipChange.ipc$dispatch("-895547540", new Object[]{this, animator});
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "715737923")) {
                ipChange.ipc$dispatch("715737923", new Object[]{this, animator});
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1418028075")) {
                ipChange.ipc$dispatch("1418028075", new Object[]{this, animator});
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-815025188")) {
                ipChange.ipc$dispatch("-815025188", new Object[]{this, animator});
            } else {
                this.a.setVisibility(0);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements Animator.AnimatorListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        b(View view) {
            this.a = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-126377525")) {
                ipChange.ipc$dispatch("-126377525", new Object[]{this, animator});
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "707978564")) {
                ipChange.ipc$dispatch("707978564", new Object[]{this, animator});
            } else {
                this.a.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2107769206")) {
                ipChange.ipc$dispatch("-2107769206", new Object[]{this, animator});
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "318165405")) {
                ipChange.ipc$dispatch("318165405", new Object[]{this, animator});
            }
        }
    }

    public static int a(String str, int i) {
        int i2;
        IpChange ipChange = $ipChange;
        int i3 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1251166917")) {
            return ((Integer) ipChange.ipc$dispatch("-1251166917", new Object[]{str, Integer.valueOf(i)})).intValue();
        }
        if (a == null) {
            return 0;
        }
        if (i == 1) {
            i2 = 0;
            while (i3 < a.size()) {
                CategoryNewTitleBean categoryNewTitleBean = a.get(i3);
                if (categoryNewTitleBean != null && categoryNewTitleBean.type == 1) {
                    i2 = i3;
                }
                i3++;
            }
        } else if (i != 2) {
            if (i != 3) {
                return 0;
            }
            int i4 = 0;
            while (i3 < a.size()) {
                CategoryNewTitleBean categoryNewTitleBean2 = a.get(i3);
                if (categoryNewTitleBean2 != null && categoryNewTitleBean2.type == 3 && categoryNewTitleBean2.categoryId != null && !TextUtils.isEmpty(str) && str.equals(categoryNewTitleBean2.categoryId)) {
                    i4 = i3;
                }
                i3++;
            }
            return i4;
        } else {
            i2 = 0;
            while (i3 < a.size()) {
                CategoryNewTitleBean categoryNewTitleBean3 = a.get(i3);
                if (categoryNewTitleBean3 != null && categoryNewTitleBean3.type == 2) {
                    i2 = i3;
                }
                i3++;
            }
        }
        return i2;
    }

    public static List<CategoryNewTitleBean> b(CategoryNewTitleListBean categoryNewTitleListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-477673453")) {
            return (List) ipChange.ipc$dispatch("-477673453", new Object[]{categoryNewTitleListBean});
        }
        if (categoryNewTitleListBean == null || m91.a(categoryNewTitleListBean.data)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (wh2.e(categoryNewTitleListBean.data) > 0) {
            List<CategoryNewTitleBean> list = categoryNewTitleListBean.data;
            for (int i = 0; i < list.size(); i++) {
                CategoryNewTitleBean categoryNewTitleBean = list.get(i);
                if (categoryNewTitleBean != null) {
                    if (categoryNewTitleBean.getObjArgs() != null && categoryNewTitleBean.getObjArgs().getString("categoryId") != null) {
                        categoryNewTitleBean.categoryId = categoryNewTitleBean.getObjArgs().getString("categoryId");
                    }
                    arrayList.add(categoryNewTitleBean);
                }
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((CategoryNewTitleBean) arrayList.get(i2)).index = i2;
        }
        a = arrayList;
        return arrayList;
    }

    public static boolean c(CategoryPerformBean categoryPerformBean, CategoryEntity categoryEntity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2093606666")) {
            return ((Boolean) ipChange.ipc$dispatch("2093606666", new Object[]{categoryPerformBean, categoryEntity})).booleanValue();
        }
        if (categoryPerformBean != null && wh2.e(categoryPerformBean.statistics) != 0 && categoryEntity != null) {
            for (int i = 0; i < categoryPerformBean.statistics.size(); i++) {
                CategoryBean categoryBean = categoryPerformBean.statistics.get(i);
                if (categoryBean != null && categoryBean.id.equals(categoryEntity.categoryId)) {
                    return true;
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 11)
    public static void d(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1276722125")) {
            ipChange.ipc$dispatch("-1276722125", new Object[]{view, Integer.valueOf(i)});
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", i, -i);
        ofFloat.addListener(new a(view));
        ofFloat.setDuration(1000L);
        ofFloat.start();
    }

    @RequiresApi(api = 11)
    public static void e(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "179024519")) {
            ipChange.ipc$dispatch("179024519", new Object[]{view, Integer.valueOf(i)});
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", -i, i);
        ofFloat.addListener(new b(view));
        ofFloat.setDuration(1000L);
        ofFloat.start();
    }
}
