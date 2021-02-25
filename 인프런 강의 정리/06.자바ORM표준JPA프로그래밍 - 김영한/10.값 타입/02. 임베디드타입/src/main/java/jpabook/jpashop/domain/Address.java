package jpabook.jpashop.domain;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Address{

        //주소
        private String city;
        private String street;
        private String zipcode;

        public Address(String city, String street, String s) {
        }

        public String getCity() {
                return city;
        }

        public void setCity(String city) {
                this.city = city;
        }

        public String getStreet() {
                return street;
        }

        public void setStreet(String street) {
                this.street = street;
        }

        public String getZipcode() {
                return zipcode;
        }

        public void setZipcode(String zipcode) {
                this.zipcode = zipcode;
        }
}
