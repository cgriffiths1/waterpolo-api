package uk.gov.companieshouse.waterpoloapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uk.gov.companieshouse.waterpoloapi.model.TeamModel;

public interface TeamRepository extends MongoRepository<TeamModel, String> {
}
