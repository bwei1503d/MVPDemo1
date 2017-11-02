package muhanxi.mvpdemo1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity implements LoginView{


    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login)
    Button login;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        presenter = new LoginPresenter(this);







    }

    @OnClick(R.id.login)
    public void onClick() {
        presenter.login(phone.getText().toString(),password.getText().toString());
    }

    @Override
    public void phoneEmpty() {

        Toast.makeText(this, "phone is empty", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void passwordEmpty() {
        Toast.makeText(this, "password is empty", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loginSuccess(Object object) {
        Toast.makeText(this, "loginSuccess", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loginFailed(int code) {
        Toast.makeText(this, "loginFailed", Toast.LENGTH_SHORT).show();

    }
}
