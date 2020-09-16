package com;

public  class EqualTest {
   public static void main(String[] args) {
      String str =null ;
      String s=new String();
//       空指针异常
//      str.equals(s);
         s.equals(str);
      if(str == null || str.equals(" ")){
         System.out.println("str等于null 或者 “ ”");
      }
   }

}
