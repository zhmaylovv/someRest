package ru.sber.part3Rest.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import ru.sber.part3Rest.entity.Contractor;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "contractor", path = "contractor" )
public interface ContractorRepository extends PagingAndSortingRepository<Contractor, Long> {

    Optional<Contractor> findByName(@Param("name") String name);

    @Override
    <S extends Contractor> S save(S entity);

    @Override
    Optional<Contractor> findById(Long aLong);

    @Override
    Iterable<Contractor> findAll();

    @Override
    long count();

    @Override
    void deleteById(Long aLong);
}
