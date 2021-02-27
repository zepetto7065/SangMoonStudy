package jpabook.jpashop.domain;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Address {

        //주소
        private String city;
        private String street;
        private String zipcode;

        public Address(String city, String street, String zipcode) {
                this.city = city;
                this.street = street;
                this.zipcode = zipcode;
        }

        public Address() {

        }

        public String getCity() {
                return city;
        }


        public String getStreet() {
                return street;
        }


        public String getZipcode() {
                return zipcode;
        }

        private void setCity(String city) {
                this.city = city;
        }

        public void setStreet(String street) {
                this.street = street;
        }

        public void setZipcode(String zipcode) {
                this.zipcode = zipcode;
        }
}

