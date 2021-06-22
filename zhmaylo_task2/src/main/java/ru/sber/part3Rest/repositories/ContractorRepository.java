package ru.sber.part3Rest.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.sber.part3Rest.entity.Contractor;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "contractor", path = "contractor" )
public interface ContractorRepository extends PagingAndSortingRepository<Contractor, Long> {

}
