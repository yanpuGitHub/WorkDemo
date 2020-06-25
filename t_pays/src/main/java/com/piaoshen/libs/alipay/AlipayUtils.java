package com.piaoshen.libs.alipay;

import com.piaoshen.libs.pays.IPayCallback;

import android.app.Activity;
import android.os.AsyncTask;
import dc.common.utils.StringUtils;

/**
 * @author senrsl
 * @ClassName: AlipayUtils
 * @Package: com.piaoshen.libs.alipay
 * @CreateTime: 2019/8/15 8:08 PM
 */
public class AlipayUtils {

    private static AlipayAsyncTask task;

    public static void pay(Activity activity, String order, IPayCallback cb) {
        if (StringUtils.isEmpty(order)) {
            cb.onErr(AlipayRetcode.DEFAULT, "empty order string");
            return;
        }
        if (task != null
                && !task.isCancelled()
                && task.getStatus() == AsyncTask.Status.RUNNING) {
            return;
        }

        task = new AlipayAsyncTask(activity, cb);
        task.execute(order);
    }

    public static void destroy() {
        if (task != null) {
            task.cancel(true);
            task = null;
        }
    }


}
