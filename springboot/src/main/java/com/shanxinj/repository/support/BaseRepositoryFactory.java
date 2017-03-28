package com.shanxinj.repository.support;

import com.shanxinj.repository.BaseRepository;
import com.shanxinj.repository.impl.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by kanglg on 2017/3/28.
 */
public class BaseRepositoryFactory extends JpaRepositoryFactory {
    public BaseRepositoryFactory(EntityManager entityManager) {
        super(entityManager);
    }

    @SuppressWarnings({ "rawtypes", "unchecked", "hiding" })
    @Override
    protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(RepositoryInformation information, EntityManager entityManager) {
        return new BaseRepositoryImpl(information.getDomainType(), entityManager);
    }

    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        return BaseRepository.class;
    }
}
