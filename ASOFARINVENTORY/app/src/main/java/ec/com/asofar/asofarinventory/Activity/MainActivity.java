package ec.com.asofar.asofarinventory.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import ec.com.asofar.asofarinventory.Activity.ui.LoguinActivity;
import ec.com.asofar.asofarinventory.R;
import ec.com.asofar.asofarinventory.Servicio.AdminSQLiteOpenHelper;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar () != null) {
            getSupportActionBar (). hide ();
        }

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {


                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(MainActivity.this, "dbSistema", null, 1);
                SQLiteDatabase db = admin.getWritableDatabase();

                Cursor c = db.rawQuery("SELECT * FROM tb_usuario where login=1", null);
                if(c.getCount()>0){
                    Cursor d = db.rawQuery("SELECT * FROM tb_usuario where login=1 and pin = null or pin = ''", null);
                    if(d.getCount()!=0){
                        startActivity(new Intent(MainActivity.this, PrincipalAsofar.class));
                        finish();
                    }else{
                        Intent intent = new Intent(MainActivity.this, LoguinActivity.class);
                        startActivity(intent);
                        finish();
                    }


                }else{
                    Intent intent = new Intent(MainActivity.this, LoguinActivity.class);
                    startActivity(intent);

                }


                finish();
            }
        };
        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 3000);

    }




}