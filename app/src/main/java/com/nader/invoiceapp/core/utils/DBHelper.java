package com.nader.invoiceapp.core.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nader.invoiceapp.customer.data.model.CustomerModel;
import com.nader.invoiceapp.home.data.model.MenuModel;
import com.nader.invoiceapp.invoices.data.model.InvoiceModel;
import com.nader.invoiceapp.login.data.model.UserModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private final Context context;
    private static final String DATABASE_NAME = "invoice.db";
    private static final int DATABASE_VERSION = 1;

    //table user
    private static final String USER_TABLE = "user";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_LANGUAGE = "language";

    //menu
    private static final String MENU_TABLE = "menu";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_TYPE = "type";


    //invoice
    private static final String CUSTOMERS_TABLE = "customers";
    private static final String COLUMN_FK_MENU_ID = "menu_id";


    //invoice
    private static final String INVOICE_TABLE = "invoice";
    private static final String COLUMN_QUANTITY = "quantity";
    private static final String COLUMN_UNIT_PRICE = "unit_price";
    private static final String COLUMN_FK_CUSTOMER = "customer_id";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String userTable = "CREATE TABLE " + USER_TABLE +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT, " +
                COLUMN_LANGUAGE + " TEXT);";

        String menuTable = "CREATE TABLE " + MENU_TABLE +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_TYPE + " TEXT);";

        String customersTable = "CREATE TABLE " + CUSTOMERS_TABLE +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_FK_MENU_ID + " INTEGER);";

        String invoiceTable = "CREATE TABLE " + INVOICE_TABLE +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_QUANTITY + " INTEEGER, " +
                COLUMN_UNIT_PRICE + " FLOAT, " +
                COLUMN_FK_CUSTOMER + " INTEGER);";
        db.execSQL(userTable);
        db.execSQL(menuTable);
        db.execSQL(customersTable);
        db.execSQL(invoiceTable);
        initAdmin(db);
        initMenu(db);
    }

    private void initMenu(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USERNAME, "admin");
        cv.put(COLUMN_PASSWORD, GlobalFunctions.digest("SHA-256", "admin"));
        cv.put(COLUMN_LANGUAGE, "en");
        db.insert(USER_TABLE, null, cv);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + MENU_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + INVOICE_TABLE);
        onCreate(db);
    }

    private void initAdmin(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, "Customers");
        cv.put(COLUMN_TYPE, "customer");
        db.insert(MENU_TABLE, null, cv);
    }

    public UserModel getUser(String userName, String password) {
        String query = "SELECT * FROM " + USER_TABLE + " WHERE " + COLUMN_USERNAME + " =? AND " + COLUMN_PASSWORD + " =?";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, new String[]{userName, password});
        if (cursor.moveToFirst()) {
            UserModel userModel = new UserModel(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
            );
            cursor.close();
            db.close();
            return userModel;
        }
        cursor.close();
        db.close();
        return null;
    }


    public ArrayList<MenuModel> getAllMenus() {
        String query = "SELECT * FROM " + MENU_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);
        ArrayList<MenuModel> menuModels = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                menuModels.add(
                        new MenuModel(
                                cursor.getInt(0),
                                cursor.getString(1),
                                cursor.getString(2)
                        )
                );
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return menuModels;
    }

    //customers
    public ArrayList<CustomerModel> getAllCustomers() {
        String query = "SELECT * FROM " + CUSTOMERS_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);
        ArrayList<CustomerModel> menuModels = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                menuModels.add(
                        new CustomerModel(
                                cursor.getInt(0),
                                cursor.getString(1),
                                cursor.getInt(2)
                        )
                );
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return menuModels;
    }

    public ArrayList<CustomerModel> getAllCustomersByMenuId(int menuID) {
        String query = "SELECT * FROM " + CUSTOMERS_TABLE
                + " WHERE " + COLUMN_FK_MENU_ID + " ='" + menuID + "';";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);
        ArrayList<CustomerModel> menuModels = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                menuModels.add(
                        new CustomerModel(
                                cursor.getInt(0),
                                cursor.getString(1),
                                cursor.getInt(2)
                        )
                );
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return menuModels;
    }

    public boolean addCustomer(@NonNull CustomerModel customerModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, customerModel.getName());
        cv.put(COLUMN_FK_MENU_ID, customerModel.getMenuId());
        long result = db.insert(CUSTOMERS_TABLE, null, cv);
        return result != -1;
    }


    public ArrayList<InvoiceModel> getAllInvoices() {
        String query = "SELECT * FROM " + INVOICE_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);
        ArrayList<InvoiceModel> menuModels = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                menuModels.add(
                        new InvoiceModel(
                                cursor.getString(0),
                                cursor.getString(1),
                                cursor.getInt(2),
                                cursor.getFloat(3),
                                cursor.getInt(5)
                        )
                );
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return menuModels;
    }

    public ArrayList<InvoiceModel> getAllInvoicesByCustomerId(int customerId) {
        String query = "SELECT * FROM " + INVOICE_TABLE
                + " WHERE " + COLUMN_FK_CUSTOMER + " = '" + customerId + "';";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);
        ArrayList<InvoiceModel> menuModels = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                menuModels.add(
                        new InvoiceModel(
                                cursor.getString(0),
                                cursor.getString(1),
                                cursor.getInt(2),
                                cursor.getFloat(3),
                                cursor.getInt(4)
                        )
                );
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return menuModels;
    }

    public boolean addInvoice(@NonNull InvoiceModel invoiceModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, invoiceModel.getName());
        cv.put(COLUMN_QUANTITY, invoiceModel.getQuantity());
        cv.put(COLUMN_UNIT_PRICE, invoiceModel.getUnitPrice());
        cv.put(COLUMN_UNIT_PRICE, invoiceModel.getUnitPrice());
        cv.put(COLUMN_FK_CUSTOMER, invoiceModel.getCustomerId());
        long result = db.insert(INVOICE_TABLE, null, cv);
        return result != -1;
    }
//
//    Cursor readAllData() {
//        String query = "SELECT * FROM " + TABLE_NAME;
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = null;
//        if (db != null) {
//            cursor = db.rawQuery(query, null);
//        }
//        return cursor;
//    }
//
//    void updateData(String row_id, String title, String author, String pages) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put(COLUMN_TITLE, title);
//        cv.put(COLUMN_AUTHOR, author);
//        cv.put(COLUMN_PAGES, pages);
//
//        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
//        if (result == -1) {
//            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
//        }
//
//    }
//
//    void deleteOneRow(String row_id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
//        if (result == -1) {
//            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    void deleteAllData() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("DELETE FROM " + TABLE_NAME);
//    }
}
