package muhanxi.mvpdemo1;

/**
 * Created by muhanxi on 17/11/2.
 */

public interface LoginView {

    // 手机号码为空
    public void phoneEmpty();
//    密码为空
    public void passwordEmpty();
// 登陆成功
    public void loginSuccess(Object object);
//  登陆失败
    public void loginFailed(int code);

}
