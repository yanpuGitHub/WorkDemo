package com.piaoshen.libs.pays;

/**
 * @author senrsl
 * @ClassName: IPayCallback
 * @Package: com.piaoshen.libs.pays
 * @CreateTime: 2019/8/15 7:55 PM
 */
public interface IPayCallback {

    void onSuss();

    void onCancel();

    void onErr(int code, String msg);

}
