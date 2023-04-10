public class Shops {
    public static String[][] North_Rinlund = new String[][]{{"Used Wood Axe","1","empty","empty","empty","empty","empty","empty","empty","empty","empty","empty","empty","empty","200"},{"North Rinlund Village Map","1","empty","empty","empty","empty","empty","empty","empty","empty","empty","empty","empty","empty","50"}};
    public static String[][] Shop_Locations = new String[][]{{"North_Rinlund_Town_Center","North_Rinlund"}};
    public static Boolean hasShop(String currentmap) {
        Integer i = 0;
        while (i < Shop_Locations.length && Shop_Locations[i][0].equals(currentmap) == false) {
            i++;
        }
        if (i == Shop_Locations.length) {
            return false;
        } else {
            return true;
        }
    }
    public static String locationtoshop(String location) {
        Integer i = 0;
        while (i < Shop_Locations.length && (Shop_Locations[i][0].equals(location) == false)) {
            i++;
        }
        if (i == Shop_Locations.length) {
            System.out.println("Error: there are no shops here!");
            return null;
        } else {
            return Shop_Locations[i][1];
        }
    }
    static MapRouter mapRouter = new MapRouter();
    public static String[] grab_all_shop_locations() {
        Integer i = 0;
        String[] out = new String[Shop_Locations.length];
        while (i < Shop_Locations.length) {
            out[i] = Shop_Locations[i][0];
            i++;
        }
        return out;
    }
    public static void set_shop(String name, String[][] shop_arr) {
        if (name.equals("North_Rinlund")) {
            North_Rinlund = mapRouter.eradicate_nulls(shop_arr);
        } else {
            System.out.println("Shop : \"" + name + "\" not found! - shops.java:41");
        }
    }
    public static String[][] grabshop(String name) {
        if (name.equals("North_Rinlund")) {
            return North_Rinlund;
        } else {
            System.out.println("Shop : \"" + name + "\" not found! - shops.java:48");
            return null;
        }
    }
    public static String[] getitem(String name, String item) {
        Integer i = 0;
        String[][] shop = grabshop(name);
        while (i < shop.length && shop[i][0].equalsIgnoreCase(item) == false) {
            i++;
        }
        if (i == shop.length) {
            System.out.println("Item does not exist!");
        }
        return shop[i];
    }
    public static String[] getshopitemnames(String name) {
        String[][] shop = grabshop(name);
        Integer i = 0;
        Integer arr_len = 0;
        while (i < shop.length) {
//            out[i] = shop[i][0];
//            i++;
            if (shop[i][0].equals("empty") == false) {
                arr_len++;
//                System.out.println("arr_len = " + arr_len);
            }
            i++;
        }
        String[] out = new String[arr_len];
        Integer y = 0;
        i = 0;
        while (i < out.length) {
            if (shop[i][0].equals("empty") == false) {
                out[y++] = shop[i][0];
//                System.out.println("y = " + y);
            }
            i++;
        }
//        i = 0;
//        while (i < out.length) {
//            System.out.println("out[" + i + "] = " + out[i]);
//        }
        return out;
    }
    public static void buy(String name, String item) {
        if (item.equals("empty")) {
            System.out.println("cannot have item called \"empty\"!");
            return;
        }
        String[][] shop = grabshop(name);
        Integer i = 0;
        while (shop[i][0].equalsIgnoreCase(item) == false && i < shop.length) {
            i++;
        }
//        grabshop(name)[i][0] = "empty";
        grabshop(name)[i][1] = "" + (Integer.parseInt(grabshop(name)[i][1]) - 1);
        if (grabshop(name)[i][1].equals("0")) {
            grabshop(name)[i][0] = "empty";
        }
    }
}
