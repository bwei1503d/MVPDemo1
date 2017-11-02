package muhanxi.mvpdemo1;

/**
 * Created by muhanxi on 17/11/2.
 */

public interface LoginView {


    public void phoneEmpty();
    public void passwordEmpty();

    public void loginSuccess(Object object);
    public void loginFailed(int code);

}
