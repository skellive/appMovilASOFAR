package ec.com.asofar.asofarinventory.Servicio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

public class RegistroBase {

    private Context context;
    private SQLiteDatabase db;
    byte[] employeeAsBytesreg;
    Date fecha;
    private final int SECONDS_IN_ONE_DAY = 86_400;
    private final int SECONDS_IN_ONE_HOUR = 3_600;
    private final int SECONDS_IN_ONE_MINUTE = 60;
    private static final SecureRandom secureRandom = new SecureRandom();
    @SuppressLint("NewApi")
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();
    public RegistroBase(Context context){

        this.context = context;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this.getContext(), "dbSistemaFace", null, 1);
        db = admin.getReadableDatabase();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }





}
