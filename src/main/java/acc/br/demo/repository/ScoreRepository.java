package acc.br.demo.repository;

import org.springframework.data.repository.CrudRepository;

import acc.br.demo.model.Score;

public interface ScoreRepository extends CrudRepository<Score, Integer> {

}
