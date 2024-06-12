package com.example.address.Address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDataRepository extends JpaRepository<AddressData,Long> {
    Boolean existsByProvinceAndCityAndDistrictAndTown(String province, String city,String district,String town);
}
