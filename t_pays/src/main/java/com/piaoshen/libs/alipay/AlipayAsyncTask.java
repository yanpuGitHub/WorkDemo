package com.piaoshen.libs.alipay;

import java.lang.ref.WeakReference;
import java.util.Map;

import com.alipay.sdk.app.PayTask;
import com.piaoshen.libs.pays.IPayCallback;

import android.app.Activity;
import android.os.AsyncTask;

/**
 * @author senrsl
 * @ClassName: AlipayAsyncTask
 * @Package: com.piaoshen.libs.alipay
 * @CreateTime: 2019/8/15 7:52 PM
 */
public class AlipayAsyncTask extends AsyncTask<String, Integer, Map<String, String>> {

    private WeakReference<Activity> mHolder;
    private IPayCallback mCallback;

    public AlipayAsyncTask(Activity activity, IPayCallback callback) {
        mHolder = new WeakReference<>(activity);
        mCallback = callback;
    }

    @Override
    protected Map<String, String> doInBackground(String... params) {
        Activity paymentActivity = mHolder.get();
        if (paymentActivity == null) return null;
        if (paymentActivity.isFinishing()) return null;
        PayTask payTask = new PayTask(paymentActivity);
        return payTask.payV2(params[0], true);
    }

    @Override
    protected void onPostExecute(Map<String, String> resultMap) {
        if (isCancelled()) return;
        Activity paymentActivity = mHolder.get();
        if (paymentActivity == null) return;
        if (paymentActivity.isFinishing()) return;
        if (resultMap == null) return;
        String status = resultMap.get(AlipayRetcode.ALIPAY_RESULT_STATUS_KEY);
        String result = resultMap.get(AlipayRetcode.ALIPAY_RESULT_KEY);
//            String memo = resultMap.get(PaymentConstant.ALIPAY_MEMO_KEY);
        switch (status) {
            case AlipayRetcode.ALIPAY_SUCCESS_8000:
            case AlipayRetcode.ALIPAY_SUCCESS_9000:
                if (null != mCallback)
                    mCallback.onSuss();
                break;
            case AlipayRetcode.ALIPAY_CANCEL_6001:
                if (null != mCallback)
                    mCallback.onCancel();
                break;
            default:
                if (null != mCallback)
                    mCallback.onErr(AlipayRetcode.DEFAULT, result);
        }
    }
}
