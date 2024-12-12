package acc.br.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acc.br.demo.model.Score;
import acc.br.demo.repository.ScoreRepository;

@Service
public class ScoreService {

	 @Autowired
	    public ScoreRepository scoreRepo;

	    
	    public ScoreService(ScoreRepository scoreRepo) {
	            this.scoreRepo = scoreRepo;
	    }

	    public Score resetScore() {
	        Score score = getScore();
	        scoreRepo.save(score);	        
	        return score;
	    }

	    public Score getScore() {
	        Score score;
	        try {
	            score = scoreRepo.findById(new Integer(1)).get();
	        }
	        catch(Exception e) {
	            score = new Score(0,0,0);
	            scoreRepo.save(score);
	        }
	        return score;
	    }

	    public String verificaEscolha(String escolha) {
	        String saida;
	        Score score = this.getScore();

	        switch(escolha.toLowerCase()) {
	            case "papel":
	                saida = "ganhou";
	                score.setVitorias(score.getVitorias() + 1);
	                break;
	            case "tesoura":
	                saida = "perdeu";
	                score.setDerrotas(score.getDerrotas() + 1);
	                break;
	            default:
	                saida = "empate";
	                score.setEmpates(score.getEmpates() + 1);
	                break;
	        }
	        scoreRepo.save(score);
	        return saida;
	    }

}