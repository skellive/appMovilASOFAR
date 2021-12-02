package ec.com.asofar.asofarinventory.Servicio;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE tb_productoTot(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "codigoBarras TEXT," +
                "nombre TEXT," +
                "descripcion TEXT," +
                "unidades TEXT," +
                "peso TEXT," +
                "tipo TEXT," +
                "medida TEXT," +
                "categoria TEXT," +
                "marca TEXT," +
                "presentacion TEXT," +
                "cantidadMin TEXT," +
                "receta TEXT," +
                "precioBase TEXT," +
                "precioCompra TEXT," +
                "precioUnidadCompra TEXT," +
                "precioVenta TEXT," +
                "precioUnidadVenta TEXT," +
                "descuentoVenta TEXT," +
                "iva TEXT," +
                "unidadProducto TEXT," +
                "observacion TEXT)");


        db.execSQL("CREATE TABLE tb_tipo(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "identificador TEXT," +
                "nombre TEXT," +
                "estao TEXT)");


        db.execSQL("CREATE TABLE tb_medida(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "identificador TEXT," +
                "nombre TEXT," +
                "estao TEXT)");

        db.execSQL("CREATE TABLE tb_categoria(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "identificador TEXT," +
                "nombre TEXT," +
                "estao TEXT)");

        db.execSQL("CREATE TABLE tb_marca(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "identificador TEXT," +
                "nombre TEXT," +
                "estao TEXT)");


        db.execSQL("CREATE TABLE tb_presentacion(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "identificador TEXT," +
                "nombre TEXT," +
                "estao TEXT)");


        db.execSQL("CREATE TABLE tb_usuario(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "usuario TEXT," +
                "nombres TEXT, " +
                "cedula TEXT," +
                "idRol TEXT," +
                "cargo TEXT," +
                "pin TEXT," +
                "login INTEGER," +
                "estado TEXT)");


        db.execSQL("CREATE INDEX index_pro1 ON tb_productoTot(codigoBarras,nombre )");

        db.execSQL("CREATE INDEX index_pro2 ON tb_tipo(identificador,nombre )");

        db.execSQL("CREATE INDEX index_pro3 ON tb_medida(identificador,nombre )");

        db.execSQL("CREATE INDEX index_pro4 ON tb_categoria(identificador,nombre )");

        db.execSQL("CREATE INDEX index_pro5 ON tb_marca(identificador,nombre )");

        db.execSQL("CREATE INDEX index_pro6 ON tb_presentacion(identificador,nombre )");







    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if(newVersion > oldVersion){






        }

    }


    public void borrar_datos(SQLiteDatabase db, String tb){
        db.execSQL("DELETE FROM "+tb);
    }

    public void borar_datos_where(SQLiteDatabase db, String tb, String where){
        db.execSQL("DELETE FROM "+tb + " " + where);
    }


    public void actualizarPinUsuario(SQLiteDatabase db, Integer idusuario,String pin){
        db.execSQL("UPDATE tb_usuario SET pin='"+pin+"' where id="+idusuario);
    }

    public boolean checkColumnExists2(SQLiteDatabase db, String tableName
            , String columnName) {
        boolean result = false ;
        Cursor cursor = null ;

        try{
            cursor = db.rawQuery( "select * from sqlite_master where name = ? and sql like ?"
                    , new String[]{tableName , "%" + columnName + "%"} );
            result = null != cursor && cursor.moveToFirst() ;
        }catch (Exception e){
            System.out.println("Error "+ e.getMessage());
        }finally{
            if(null != cursor && !cursor.isClosed()){
                cursor.close() ;
            }
        }

        return result ;
    }



}
