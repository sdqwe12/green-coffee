package com.mh.green2nd.store.AdminStore;

import com.mh.green2nd.store.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminStoreRepository extends JpaRepository<Store, Long> {


}