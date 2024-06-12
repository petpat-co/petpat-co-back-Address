package com.example.address.Address;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"PROVINCE", "CITY", "TOWN"})})
@Entity(name = "TB_ADDRESS")
@NoArgsConstructor
public class AddressData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private Long addressId;

    @Column(name = "PROVINCE")
    private String province;

    @Column(name = "CITY")
    private String city;

    @Column(name = "DISTRICT")
    private String district;

    @Column(name = "TOWN")
    private String town;

    public AddressData(String province, String city, String district, String town){
        this.province = province;
        this.city = city;
        this.district = district;
        this.town = town;
    }

}