package com.shanxinj.common.repository;

import com.shanxinj.common.repository.impl.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * BaseRepositoryFactory
 * Created by kanglg on 2017/3/28.
 */
public class BaseRepositoryFactory extends JpaRepositoryFactory {
    private final EntityManager entityManager;

    public BaseRepositoryFactory(EntityManager entityManager) {
        super(entityManager);
        this.entityManager = entityManager;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(RepositoryInformation information, EntityManager entityManager) {
        JpaEntityInformation<?, Serializable> entityInformation = getEntityInformation(information.getDomainType());
        return new BaseRepositoryImpl(entityInformation, entityManager);
    }

    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        return BaseRepositoryImpl.class;
    }
}
