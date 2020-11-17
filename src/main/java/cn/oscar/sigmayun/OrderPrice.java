package cn.oscar.sigmayun;

public class OrderPrice {

    public static String geOrderPrice(String price,int number,String type,String quota,String remission,String rate){
        if(type.isEmpty()){
            return "0";}
        if(type.equals("2")) {

            int p = Integer.valueOf(price).intValue();
            int q = Integer.valueOf(quota).intValue();
            int r = Integer.valueOf(remission).intValue();

            int j;
            j = p * number;

            if (j > q)
                j = j - r;
            String s2 = Integer.toString(j);
            System.out.println(s2);
            return s2;
        }else if(type.equals("1")) {
                int p=Integer.valueOf(price).intValue();
                int r=Integer.valueOf(rate).intValue();
                int j;
                j = (p * number * r) / 100;
                String s2 = Integer.toString(j);
                System.out.println(s2);
                return s2;
            }else{
                int p=Integer.valueOf(price).intValue();
                int j;
                j = p * number;

                String s2 = Integer.toString(j);
                System.out.println(s2);
                return s2;

            }
        }









    public static void main(String[] args){

        System.out.println(geOrderPrice("122000",20,"0","0","0","100"));


    }
}
