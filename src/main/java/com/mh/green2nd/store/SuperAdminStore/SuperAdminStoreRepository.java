package com.mh.green2nd.store.SuperAdminStore;

import com.mh.green2nd.store.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperAdminStoreRepository extends JpaRepository<Store, Long> {


}