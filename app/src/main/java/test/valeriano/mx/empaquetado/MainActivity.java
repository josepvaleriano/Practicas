package test.valeriano.mx.empaquetado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import test.valeriano.mx.empaquetado.util.PreferenceUtil;

public class MainActivity extends AppCompatActivity {

    /*Declaración de variable*/
    private EditText mUser;
    private EditText mPassword;
    private View loading;
    private PreferenceUtil preferenceUtil;

    /* Actividad principal principal onCreate()*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /*Metodo para escuchar el onclick*/
    public void onClick(View v) {
        switch (v.getId())        {
            case R.id.activity_main_btnLogin:
                processData();
                break;
        }
    }

    /* Procesa los datos del login*/
    private void processData(){
        final String user = mUser.getText().toString();
        final String pass = mPassword.getText().toString();
        loading.setVisibility(View.VISIBLE);
    }

    private void processLogin() {

        String user = mUser.getText().toString();
        String password = mPassword.getText().toString();
        if(TextUtils.isEmpty(user))
            showError(R.string.login_empty);
        else if(TextUtils.isEmpty(password))
            showError(R.string.password_empty);
        else
            validateLogin(user,password);
    }

    private void validateLogin(String user, String password) {
        if(user.equals("unam") && password.equals("contraseña")){
            startActivity(new Intent(getApplicationContext(),ActivityContent.class));
        }
        else {
            showError(R.string.wrong_credentials);
        }
    }

    private void showError(int resourceString) {
        Toast.makeText(getApplicationContext(),resourceString,Toast.LENGTH_SHORT).show();
    }


}
