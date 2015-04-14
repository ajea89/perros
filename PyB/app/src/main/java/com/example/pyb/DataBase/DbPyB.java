package com.example.pyb.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pyb.Beans.Client;
import com.example.pyb.Beans.Order;
import com.example.pyb.Beans.Product;
import com.example.pyb.Beans.ProductType;

import java.util.ArrayList;

/**
 * Created by alan on 10/04/15.
 */
public class DbPyB extends SQLiteOpenHelper{

    private Context context;
    private String productQuery= "";
    private String clientQuery= "";
    private String orderQuery= "";
    private String productTypeQuery= "";
    private static String databaseName = "dbpyb";


    public DbPyB(Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        productQuery = "CREATE TABLE IF NOT EXISTS product (id_product TEXT PRIMARY KEY, product_name TEXT, product_description TEXT, product_price TEXT, product_type TEXT)";
        clientQuery = "CREATE TABLE IF NOT EXISTS client (id_client TEXT PRIMARY KEY, client_name TEXT, client_address TEXT, client_phone TEXT, client_mail TEXT)";
        orderQuery = "CREATE TABLE IF NOT EXISTS orden (id_order TEXT PRIMARY KEY, product_id TEXT, client_id TEXT)";
        productTypeQuery = "CREATE TABLE IF NOT EXISTS product_type (id_type TEXT PRIMARY KEY, type_name TEXT)";

        try {
            db.execSQL(productQuery);
            db.execSQL(clientQuery);
            db.execSQL(productTypeQuery);
            db.execSQL(orderQuery);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean insertUpdateProduct(Product product){
        boolean flag = false;
        SQLiteDatabase db = getWritableDatabase();
        String query = "INSERT OR REPLACE INTO product VALUES('"+product.getId()+"','"+product.getName()+"','"+product.getDescription()+"','"+product.getPrice()+"','"+product.getProductType()+"')";

        if (db != null){
            try {
                db.execSQL(query);
                flag = true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        db.close();

        return flag;
    }

    public boolean insertUpdateClient(Client client){
        boolean flag = false;
        SQLiteDatabase db = getWritableDatabase();
        String query = "INSERT OR REPLACE INTO client VALUES('"+client.getId()+"','"+client.getName()+"','"+client.getAddress()+"','"+client.getNumberPhone()+"','"+client.getMail()+"')";

        if (db != null){
            try {
                db.execSQL(query);
                flag = true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        db.close();

        return flag;
    }

    public boolean insertUpdateOrder(Order order){
        boolean flag = false;
        SQLiteDatabase db = getWritableDatabase();
        String query = "INSERT OR REPLACE INTO order VALUES('"+order.getId()+"','"+order.getProductId()+"','"+order.getClientId()+"')";

        if (db != null){
            try {
                db.execSQL(query);
                flag = true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        db.close();

        return flag;
    }

    public boolean insertUpdateProductType(ProductType productType){
        boolean flag = false;
        SQLiteDatabase db = getWritableDatabase();
        String query = "INSERT OR REPLACE INTO product_type VALUES('"+productType.getId()+"','"+productType.getName()+"')";

        if (db != null){
            try {
                db.execSQL(query);
                flag = true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        db.close();

        return flag;
    }

    public boolean deleteProduct(Product product){
        boolean flag = false;
        SQLiteDatabase db = getWritableDatabase();
        String query = "DELETE FROM product WHERE id_product LIKE '"+product.getId()+"'";

        if (db != null){
            try {
                db.execSQL(query);
                flag = true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        db.close();

        return flag;
    }

    public boolean deleteClient(Client client){
        boolean flag = false;
        SQLiteDatabase db = getWritableDatabase();
        String query = "DELETE FROM client WHERE id_client LIKE '"+client.getId()+"'";

        if (db != null){
            try {
                db.execSQL(query);
                flag = true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        db.close();

        return flag;
    }

    public boolean deleteOrder(Order order){
        boolean flag = false;
        SQLiteDatabase db = getWritableDatabase();
        String query = "DELETE FROM order WHERE id_order LIKE '"+order.getId()+"'";

        if (db != null){
            try {
                db.execSQL(query);
                flag = true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        db.close();

        return flag;
    }

    public boolean deleteProductType(ProductType productType){
        boolean flag = false;
        SQLiteDatabase db = getWritableDatabase();
        String query = "DELETE FROM product_type WHERE id_type LIKE '"+productType.getId()+"'";

        if (db != null){
            try {
                db.execSQL(query);
                flag = true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        db.close();

        return flag;
    }

    public ArrayList<Product> readProducts(int productId, int productType){

        SQLiteDatabase db = getReadableDatabase();
        String query;
        ArrayList<Product> products = null;

        if (productId>0){
            query = "SELECT * FROM product WHERE id_product LIKE '"+productId+"'";
            if (db != null){
                Cursor cursor = db.rawQuery(query,null);

                if (cursor.moveToFirst()){
                    products = new ArrayList<>();

                    do {
                        Product product = new Product();

                        product.setId(Integer.parseInt(cursor.getString(0)));
                        product.setName(cursor.getString(1));
                        product.setDescription(cursor.getString(2));
                        product.setPrice(Double.parseDouble(cursor.getString(3)));

                        products.add(product);

                    }while ((cursor.moveToNext()));
                }
            }
        }else if (productType >0){

            query = "SELECT * FROM product WHERE product_type LIKE '"+productType+"'";
            if (db != null){
                Cursor cursor = db.rawQuery(query,null);

                if (cursor.moveToFirst()){
                    products = new ArrayList<>();

                    do {
                        Product product = new Product();

                        product.setId(Integer.parseInt(cursor.getString(0)));
                        product.setName(cursor.getString(1));
                        product.setDescription(cursor.getString(2));
                        product.setPrice(Double.parseDouble(cursor.getString(3)));

                        products.add(product);

                    }while ((cursor.moveToNext()));
                }
            }
        }
        db.close();

        return products;
    }

    public ArrayList<Client> readClients(int clientId){

        SQLiteDatabase db = getReadableDatabase();
        String query;
        ArrayList<Client> clients = null;

        if (clientId>0){
            query = "SELECT * FROM client WHERE id_client LIKE '"+clientId+"'";
            if (db != null){
                Cursor cursor = db.rawQuery(query,null);

                if (cursor.moveToFirst()){
                    clients = new ArrayList<>();

                    do {
                        Client client = new Client();

                        client.setId(Integer.parseInt(cursor.getString(0)));
                        client.setName(cursor.getString(1));
                        client.setAddress(cursor.getString(2));
                        client.setNumberPhone(cursor.getString(3));
                        client.setMail(cursor.getString(4));

                        clients.add(client);

                    }while ((cursor.moveToNext()));
                }
            }
        }

        db.close();

        return clients;
    }

    public ArrayList<ProductType> readProductTypes(int productTypeId, boolean allProductTypes){

        SQLiteDatabase db = getReadableDatabase();
        String query;
        ArrayList<ProductType> productTypes = null;

        if (productTypeId>0 && allProductTypes == false){
            query = "SELECT * FROM product_type WHERE id_type LIKE '"+productTypeId+"'";
            if (db != null){
                Cursor cursor = db.rawQuery(query,null);

                if (cursor.moveToFirst()){
                    productTypes = new ArrayList<>();

                    do {
                        ProductType productType = new ProductType();

                        productType.setId(Integer.parseInt(cursor.getString(0)));
                        productType.setName(cursor.getString(1));

                        productTypes.add(productType);

                    }while ((cursor.moveToNext()));
                }
            }
        }else if (allProductTypes == true){
            query = "SELECT * FROM product_type";
            if (db != null){
                Cursor cursor = db.rawQuery(query,null);

                if (cursor.moveToFirst()){
                    productTypes = new ArrayList<>();

                    do {
                        ProductType productType = new ProductType();

                        productType.setId(Integer.parseInt(cursor.getString(0)));
                        productType.setName(cursor.getString(1));

                        productTypes.add(productType);

                    }while ((cursor.moveToNext()));
                }
            }
        }

        db.close();

        return productTypes;
    }

    public ArrayList<Order> readOrders(int orderId, int clientId){

        SQLiteDatabase db = getReadableDatabase();
        String query;
        ArrayList<Order> orders = null;

        if (orderId>0){
            query = "SELECT * FROM order WHERE id_order LIKE '"+orderId+"'";
            if (db != null){
                Cursor cursor = db.rawQuery(query,null);

                if (cursor.moveToFirst()){
                    orders = new ArrayList<>();

                    do {
                        Order order = new Order();

                        order.setId(Integer.parseInt(cursor.getString(0)));
                        order.setProductId(Integer.parseInt(cursor.getString(1)));
                        order.setClientId(Integer.parseInt(cursor.getString(2)));

                        orders.add(order);

                    }while ((cursor.moveToNext()));
                }
            }
        }else if (clientId >0){

            query = "SELECT * FROM order WHERE client_id LIKE '"+clientId+"'";
            if (db != null){
                Cursor cursor = db.rawQuery(query,null);

                if (cursor.moveToFirst()){
                    orders = new ArrayList<>();

                    do {
                        Order order = new Order();

                        order.setId(Integer.parseInt(cursor.getString(0)));
                        order.setProductId(Integer.parseInt(cursor.getString(1)));
                        order.setClientId(Integer.parseInt(cursor.getString(2)));

                        orders.add(order);

                    }while ((cursor.moveToNext()));
                }
            }
        }

        db.close();

        return orders;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}