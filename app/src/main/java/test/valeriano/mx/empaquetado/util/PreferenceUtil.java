package test.valeriano.mx.empaquetado.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import test.valeriano.mx.empaquetado.model.ModelUser;

/**
 * Created by luis.valeriano on 18/06/2016.
 */
public class PreferenceUtil {

    private final SharedPreferences sp;
    private static final String FILE_NAME ="unam_pref";
    private static final String user_name ="user_name";
    private static final String user_pasword ="user_pasword";

    /*Para manejar el contexto de la aplicación*/
    public PreferenceUtil(Context context)   {
        sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);

    }

    /*Método par obtener los datos del usuario*/
    public ModelUser getUser() {
        String mUser =  sp.getString(user_name, null);
        String mPassword = sp.getString(user_pasword,null);
        if(TextUtils.isEmpty(mUser) || TextUtils.isEmpty(mPassword))
            return null;
        return new ModelUser(mUser,mPassword);
    }

    /*Método para salvar el usuario*/
    public void saveUser(ModelUser modelUser){
        String mUser = modelUser.userName;
        String mPassword = modelUser.password;
        if(!TextUtils.isEmpty(mUser) || !TextUtils.isEmpty(mPassword)) {
            sp.edit().putString(user_name,modelUser.userName).apply();
            sp.edit().putString(user_pasword,modelUser.password).apply();
        }

    }

}
