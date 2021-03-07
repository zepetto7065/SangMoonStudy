package jpabook.jpashop;

import jpabook.jpashop.domain.Address;

public class main
{
    public static void main(String[] args) {
        Address address1 = new Address("city", "street", "100000");
        Address address2 = new Address("city", "street", "100000");

        System.out.println("address1 == address 2 :: " + (address1 == address2));
        System.out.println("address1 == address 2 :: " + (address1.equals(address2))); //값타입의 비교는 항상 equals로 비교
        //실제 비교할일이 많이는 없다.
    }
}
