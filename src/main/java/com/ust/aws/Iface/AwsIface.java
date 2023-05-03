package com.ust.aws.Iface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.aws.resource.Product;
@Repository
public interface AwsIface extends JpaRepository<Product, Long> {

}
