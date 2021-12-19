package usa.sesion15.TuChaqueta.Modelo.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MotorBaseDatosSQLite extends SQLiteOpenHelper {

    public MotorBaseDatosSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //******************************* TABLA FAVORITOS ******************************
        db.execSQL("CREATE TABLE favoritos (img INT, titulo TEXT, descripcion TEXT)");


        //******************************* TABLA PRODUCTOS***************************
        //Creacion de la tabla
        db.execSQL("CREATE TABLE productos (img INT, titulo TEXT, descripcion TEXT)");

        //llenar la tabla con datos
        db.execSQL("INSERT INTO productos VALUES (0,'Chaqueta Deportiva hombre','Tallas desde XS hasta 4XL Precio: $60.000')");
        db.execSQL("INSERT INTO productos VALUES (1,'Chaqueta Deportiva mujer con capota','Tallas desde XS hasta 4XL Precio: $60.000')");
        db.execSQL("INSERT INTO productos VALUES (2,'Chaqueta Deportiva mujer sin capota','Tallas desde XS hasta 4XL Precio: $50.000')");
        db.execSQL("INSERT INTO productos VALUES (3,'Chaqueta Infantil','Desde talla 0 a talla 12 Precio: $40.000')");

        //******************************* TABLA SERVICIOS***************************
        //Creacion de la tabla

        db.execSQL("CREATE TABLE servicios (img INT, titulo TEXT)");

        //llenar la tabla con datos
        db.execSQL("INSERT INTO servicios VALUES (0,'Trae tu diseño y nosotros nos encargamos de hacerlo realidad.')");
        db.execSQL("INSERT INTO servicios VALUES (1,'Elige uno de nuestros diseños y personalizalo.')");
        db.execSQL("INSERT INTO servicios VALUES (2,'Brindamos servicio de lavandería utilizando productos que cuidan todo tipo de tela. Tus prendas se verán como nuevas..')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE productos");
        database.execSQL("DROP TABLE servicios");
        database.execSQL("DROP TABLE favoritos");
        onCreate(database);

    }
}