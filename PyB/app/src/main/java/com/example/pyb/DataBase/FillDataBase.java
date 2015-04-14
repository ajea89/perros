package com.example.pyb.DataBase;

import android.content.Context;
import android.os.AsyncTask;

import com.example.pyb.Beans.Product;
import com.example.pyb.Beans.ProductType;

/**
 * Created by alan on 13/04/15.
 */
public class FillDataBase extends AsyncTask {

    private Context context;

    public FillDataBase(Context context) {
        this.context = context;
    }

    @Override
    protected Object doInBackground(Object[] params) {

        DbPyB db = new DbPyB(context);

        //Insertar Tipos de productos
        ProductType productType = new ProductType();
        productType.setId(1);
        productType.setName("Entradas");
        db.insertUpdateProductType(productType);
        productType=null;

        productType = new ProductType();
        productType.setId(2);
        productType.setName("Burritos");
        db.insertUpdateProductType(productType);
        productType=null;

        productType = new ProductType();
        productType.setId(3);
        productType.setName("Burritos de Cortes");
        db.insertUpdateProductType(productType);
        productType=null;

        productType = new ProductType();
        productType.setId(4);
        productType.setName("HotDogs");
        db.insertUpdateProductType(productType);
        productType=null;

        productType = new ProductType();
        productType.setId(5);
        productType.setName("Postres");
        db.insertUpdateProductType(productType);
        productType=null;

        productType = new ProductType();
        productType.setId(6);
        productType.setName("Cerveza");
        db.insertUpdateProductType(productType);
        productType=null;

        productType = new ProductType();
        productType.setId(7);
        productType.setName("Cerveza de Sabor");
        db.insertUpdateProductType(productType);
        productType=null;

        productType = new ProductType();
        productType.setId(8);
        productType.setName("Bebidas");
        db.insertUpdateProductType(productType);
        productType=null;

        //Insertar Productos
        Product product = new Product();
        product.setId(1);
        product.setName("SALCHICHAS TOREADAS");
        product.setDescription("SALCHICHAS SAZONAS CON CEBOLLA Y CHILE.");
        product.setPrice(50);
        product.setProductType(1);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(2);
        product.setName("FAJITAS ENCHILADAS");
        product.setDescription("FAJITAS DE POLLO BAÑADAS EN SALSA PICANTE A ELEGIR: HOT BÚFALO, TAMARINDO O MANGO HABANERO.ACOMPAÑADA DE BASTONES DE APIO, ZANAHORIA Y ADEREZO BLUECHEESE.");
        product.setPrice(88);
        product.setProductType(1);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(3);
        product.setName("QUESO");
        product.setPrice(12);
        product.setProductType(1);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(4);
        product.setName("PIÑA");
        product.setPrice(9);
        product.setProductType(1);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(5);
        product.setName("TOCINO");
        product.setPrice(9);
        product.setProductType(1);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(6);
        product.setName("CHAMPIÑON");
        product.setPrice(15);
        product.setProductType(1);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(7);
        product.setName("BLUE CHEESE");
        product.setPrice(9);
        product.setProductType(1);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(8);
        product.setName("APIO");
        product.setPrice(9);
        product.setProductType(1);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(9);
        product.setName("ZANAHORIA BABY");
        product.setPrice(9);
        product.setProductType(1);
        db.insertUpdateProduct(product);
        product=null;

        //burritos
        product = new Product();
        product.setId(10);
        product.setName("PASTOR");
        product.setDescription("CECINA ADOBADA, SALSA PASTOR, CEBOLLA Y PIÑA");
        product.setPrice(69);
        product.setProductType(2);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(11);
        product.setName("CECINA ADOBADA");
        product.setPrice(69);
        product.setProductType(2);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(12);
        product.setName("POLLO ADOBADO");
        product.setPrice(69);
        product.setProductType(2);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(13);
        product.setName("FAJITA DE POLLO");
        product.setDescription("POLLO, PIMIENTO MORRON Y CEBOLLA");
        product.setPrice(69);
        product.setProductType(2);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(14);
        product.setName("CHULETA CON TOCINO");
        product.setDescription("CARNE DE CERDO CON TOCINO");
        product.setPrice(65);
        product.setProductType(2);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(15);
        product.setName("CHAMPIBURRO");
        product.setDescription("CHAMPIÑON CON QUESO");
        product.setPrice(65);
        product.setProductType(2);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(16);
        product.setName("BARATERO");
        product.setDescription("FRIJOLES CON QUESO");
        product.setPrice(40);
        product.setProductType(2);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(17);
        product.setName("BISTEC");
        product.setPrice(69);
        product.setProductType(2);
        db.insertUpdateProduct(product);

        product = new Product();
        product.setId(18);
        product.setName("BISTEC PASILLADO");
        product.setDescription("BISTEC EN SALSA PASILLA Y FRIJOLES");
        product.setPrice(69);
        product.setProductType(2);
        db.insertUpdateProduct(product);

        product = new Product();
        product.setId(19);
        product.setName("ALAMBRE");
        product.setDescription("BISTEC, PIMIENTO, CEBOLLA Y TOCINO");
        product.setPrice(73);
        product.setProductType(2);
        db.insertUpdateProduct(product);

        product = new Product();
        product.setId(20);
        product.setName("ARRACHERA");
        product.setPrice(79);
        product.setProductType(2);
        db.insertUpdateProduct(product);

        product = new Product();
        product.setId(21);
        product.setName("QUESO");
        product.setPrice(12);
        product.setProductType(2);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(22);
        product.setName("PIÑA");
        product.setPrice(9);
        product.setProductType(2);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(23);
        product.setName("TOCINO");
        product.setPrice(9);
        product.setProductType(2);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(24);
        product.setName("CHAMPIÑON");
        product.setPrice(15);
        product.setProductType(2);
        db.insertUpdateProduct(product);
        product=null;

        //burritos de cortes
        product = new Product();
        product.setId(25);
        product.setName("T-BONE");
        product.setPrice(94);
        product.setProductType(3);
        db.insertUpdateProduct(product);

        product = new Product();
        product.setId(26);
        product.setName("SIRLOIN");
        product.setPrice(94);
        product.setProductType(3);
        db.insertUpdateProduct(product);

        product = new Product();
        product.setId(27);
        product.setName("RIBEYE");
        product.setPrice(94);
        product.setProductType(3);
        db.insertUpdateProduct(product);

        product = new Product();
        product.setId(28);
        product.setName("CORTES A LA MEXICANA ENCEBOLLADO O TOREADO");
        product.setPrice(98);
        product.setProductType(3);
        db.insertUpdateProduct(product);

        product = new Product();
        product.setId(29);
        product.setName("QUESO");
        product.setPrice(12);
        product.setProductType(2);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(30);
        product.setName("PIÑA");
        product.setPrice(9);
        product.setProductType(2);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(31);
        product.setName("TOCINO");
        product.setPrice(9);
        product.setProductType(2);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(32);
        product.setName("CHAMPIÑON");
        product.setPrice(15);
        product.setProductType(2);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(33);
        product.setName("SALSA PERRO 1/2");
        product.setPrice(15);
        product.setProductType(2);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(34);
        product.setName("SALSA PERRO 1/4");
        product.setPrice(10);
        product.setProductType(2);
        db.insertUpdateProduct(product);
        product=null;

        //hotdogs
        product = new Product();
        product.setId(35);
        product.setName("1 / 2 METRO");
        product.setPrice(72);
        product.setProductType(4);
        db.insertUpdateProduct(product);

        product = new Product();
        product.setId(36);
        product.setName("1 / 4 METRO");
        product.setPrice(51);
        product.setProductType(4);
        db.insertUpdateProduct(product);

        product = new Product();
        product.setId(37);
        product.setName("QUESO");
        product.setPrice(12);
        product.setProductType(4);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(38);
        product.setName("PIÑA");
        product.setPrice(9);
        product.setProductType(4);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(39);
        product.setName("TOCINO");
        product.setPrice(9);
        product.setProductType(4);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(40);
        product.setName("CHAMPIÑON");
        product.setPrice(15);
        product.setProductType(4);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(41);
        product.setName("SALSA PERRO 1/2");
        product.setPrice(15);
        product.setProductType(4);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(42);
        product.setName("SALSA PERRO 1/4");
        product.setPrice(10);
        product.setProductType(4);
        db.insertUpdateProduct(product);
        product=null;

        //postres
        product = new Product();
        product.setId(43);
        product.setName("CHOCOPERRO");
        product.setPrice(42);
        product.setProductType(5);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(44);
        product.setName("ZARNEZO");
        product.setPrice(42);
        product.setProductType(5);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(45);
        product.setName("PASTEL DE BAILEYS");
        product.setPrice(42);
        product.setProductType(5);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(46);
        product.setName("FLAN DE CAJETA");
        product.setPrice(42);
        product.setProductType(5);
        db.insertUpdateProduct(product);
        product=null;

        //cerveza
        product = new Product();
        product.setId(47);
        product.setName("1/2 YARDA");
        product.setDescription("CERVEZA DE BARRIL CLARA, OBSCURA Y CAMPECHANA.");
        product.setPrice(49);
        product.setProductType(6);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(48);
        product.setName("1/4 YARDA");
        product.setDescription("CERVEZA DE BARRIL CLARA, OBSCURA Y CAMPECHANA.");
        product.setPrice(34);
        product.setProductType(6);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(49);
        product.setName("TARRO DE LITRO");
        product.setDescription("CERVEZA DE BARRIL CLARA, OBSCURA Y CAMPECHANA.");
        product.setPrice(65);
        product.setProductType(6);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(50);
        product.setName("BOLA");
        product.setDescription("CERVEZA DE BARRIL CLARA, OBSCURA Y CAMPECHANA.");
        product.setPrice(40);
        product.setProductType(6);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(51);
        product.setName("LITRO EN LITRERA");
        product.setDescription("CERVEZA DE BARRIL CLARA, OBSCURA Y CAMPECHANA.");
        product.setPrice(65);
        product.setProductType(6);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(52);
        product.setName("1/2 YARDA");
        product.setDescription("MICHELDA Y CUBANA");
        product.setPrice(56);
        product.setProductType(6);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(53);
        product.setName("1/4 YARDA");
        product.setDescription("MICHELDA Y CUBANA");
        product.setPrice(41);
        product.setProductType(6);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(54);
        product.setName("TARRO DE LITRO");
        product.setDescription("MICHELDA Y CUBANA");
        product.setPrice(72);
        product.setProductType(6);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(55);
        product.setName("BOLA");
        product.setDescription("MICHELDA Y CUBANA");
        product.setPrice(47);
        product.setProductType(6);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(56);
        product.setName("1/2 YARDA");
        product.setDescription("TECATE Y TECATE LIGHT");
        product.setPrice(49);
        product.setProductType(6);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(57);
        product.setName("1/4 YARDA");
        product.setDescription("TECATE Y TECATE LIGHT");
        product.setPrice(38);
        product.setProductType(6);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(58);
        product.setName("HEINEKEN BOTELLA ");
        product.setDescription("335 ml");
        product.setPrice(44);
        product.setProductType(6);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(59);
        product.setName("MALTA 1/4 YARDA");
        product.setDescription("CERVEZA BAJA EN ALCHOL");
        product.setPrice(29);
        product.setProductType(6);
        db.insertUpdateProduct(product);
        product=null;

        //cerveza de sabor
        product = new Product();
        product.setId(60);
        product.setName("1/2 YARDA");
        product.setDescription("CERVEZA DE SABOR COCO");
        product.setPrice(52);
        product.setProductType(7);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(61);
        product.setName("1/2 YARDA");
        product.setDescription("CERVEZA DE SABOR MARACUYA");
        product.setPrice(52);
        product.setProductType(7);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(62);
        product.setName("1/2 YARDA");
        product.setDescription("CERVEZA DE SABOR TAMARINDO");
        product.setPrice(52);
        product.setProductType(7);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(63);
        product.setName("1/2 YARDA");
        product.setDescription("CERVEZA DE SABOR CHEMATE");
        product.setPrice(52);
        product.setProductType(7);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(64);
        product.setName("1/2 YARDA");
        product.setDescription("CERVEZA DE SABOR CHECOLADA");
        product.setPrice(52);
        product.setProductType(7);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(65);
        product.setName("1/2 YARDA");
        product.setDescription("CERVEZA DE SABOR LEMON BULLDOG");
        product.setPrice(52);
        product.setProductType(7);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(66);
        product.setName("1/2 YARDA");
        product.setDescription("CERVEZA DE SABOR ORANGE BULLDOG");
        product.setPrice(52);
        product.setProductType(7);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(67);
        product.setName("1/4 YARDA");
        product.setDescription("CERVEZA DE SABOR COCO");
        product.setPrice(37);
        product.setProductType(7);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(68);
        product.setName("1/4 YARDA");
        product.setDescription("CERVEZA DE SABOR MARACUYA");
        product.setPrice(37);
        product.setProductType(7);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(69);
        product.setName("1/4 YARDA");
        product.setDescription("CERVEZA DE SABOR TAMARINDO");
        product.setPrice(37);
        product.setProductType(7);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(70);
        product.setName("1/4 YARDA");
        product.setDescription("CERVEZA DE SABOR CHEMATE");
        product.setPrice(37);
        product.setProductType(7);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(71);
        product.setName("1/4 YARDA");
        product.setDescription("CERVEZA DE SABOR CHECOLADA");
        product.setPrice(37);
        product.setProductType(7);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(72);
        product.setName("1/4 YARDA");
        product.setDescription("CERVEZA DE SABOR LEMON BULLDOG");
        product.setPrice(37);
        product.setProductType(7);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(73);
        product.setName("1/4 YARDA");
        product.setDescription("CERVEZA DE SABOR ORANGE BULLDOG");
        product.setPrice(37);
        product.setProductType(7);
        db.insertUpdateProduct(product);
        product=null;

        //Bebidas
        product = new Product();
        product.setId(74);
        product.setName("COCA COLA, COCA LIGHT, FRESCA, LIFT, SPRITE, DELAWERE, PUNCH, AGUA MINERAL");
        product.setDescription("LATA DE 355 ML.");
        product.setPrice(18);
        product.setProductType(8);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(75);
        product.setName("BOING DE MANGO O GUAYABA");
        product.setDescription("LATA DE 340 ML.");
        product.setPrice(18);
        product.setProductType(8);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(76);
        product.setName("AGUA CIEL");
        product.setDescription("BOTELLA DE 600 ML.");
        product.setPrice(18);
        product.setProductType(8);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(77);
        product.setName("LIMONADA O NARANJADA");
        product.setDescription("MINERAL O NATURAL");
        product.setPrice(25);
        product.setProductType(8);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(78);
        product.setName("CLAMATO 1/4 YARDA");
        product.setDescription("PREPARADO");
        product.setPrice(36);
        product.setProductType(8);
        db.insertUpdateProduct(product);
        product=null;

        product = new Product();
        product.setId(79);
        product.setName("CLAMATO 1/2 YARDA");
        product.setDescription("PREPARADO");
        product.setPrice(49);
        product.setProductType(8);
        db.insertUpdateProduct(product);
        product=null;

        return null;
    }
}
