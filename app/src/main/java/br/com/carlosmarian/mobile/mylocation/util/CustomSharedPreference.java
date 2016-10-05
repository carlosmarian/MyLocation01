package br.com.carlosmarian.mobile.mylocation.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by des on 05/10/16.
 */

public class CustomSharedPreference {

    private static final String KEY_STATUS_SERVICO = "mylocation.status.servico";
    private static CustomSharedPreference instance;

    private Context contexto;
    private SharedPreferences sharedPreferences;
    private final String PREFS_PRIVATE = "PREFS_PRIVATE_MY_LOCATION";

    private CustomSharedPreference(Context contexto) {
        this.contexto = contexto;
        sharedPreferences = this.contexto.getSharedPreferences(PREFS_PRIVATE,
                Context.MODE_PRIVATE);
    }

    public synchronized static CustomSharedPreference getInstance(Context contexto) {
        if (instance == null) {
            instance = new CustomSharedPreference(contexto);
        }
        return instance;
    }


    public void gravaParametro(String chaveRegistro, Object valor) {
        SharedPreferences.Editor prefsPrivateEditor = sharedPreferences.edit();

        if (valor instanceof String) {
            prefsPrivateEditor.putString(chaveRegistro, (String) valor);
        } else if (valor instanceof Integer) {
            prefsPrivateEditor.putInt(chaveRegistro, (Integer) valor);
        } else if (valor instanceof Boolean) {
            prefsPrivateEditor.putBoolean(chaveRegistro, (Boolean) valor);
        } else if (valor instanceof Float) {
            prefsPrivateEditor.putFloat(chaveRegistro, (Float) valor);
        }
        prefsPrivateEditor.apply();
        prefsPrivateEditor.commit();

    }

    public boolean getServiceState(){
      return sharedPreferences.getBoolean(KEY_STATUS_SERVICO,false);
    }

    public void setServiceState(Boolean statusServico) {
        gravaParametro(KEY_STATUS_SERVICO, statusServico);
    }
}
