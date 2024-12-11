package acc.br.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import acc.br.demo.model.Score;
import acc.br.demo.repository.ScoreRepository;

@Controller
public class WebController {

	@Autowired
	public ScoreRepository scoreRepo;

	@ResponseBody
	@GetMapping("/score")
	public Score getScore() {
		Score score;
		try {
			score = scoreRepo.findById(1).get();
		} catch (Exception e) {
			score = new Score(0, 0, 0);
			scoreRepo.save(score);
		}
		return score;
	}
	
	@ResponseBody
    @PostMapping("/score/{id}/vitorias")
    public Score countVitorias(@PathVariable Integer id) {
            var score = scoreRepo.findById(id).orElseThrow();
            score.setVitorias(score.getVitorias()+1);
            scoreRepo.save(score);

        return score;
    }
	
	@ResponseBody
    @PostMapping("/score/{id}/derrotas")
    public Score countDerrotas(@PathVariable Integer id) {
            var score = scoreRepo.findById(id).orElseThrow();
            score.setDerrotas(score.getDerrotas()+1);
            scoreRepo.save(score);

        return score;
    }
	@ResponseBody
    @PostMapping("/score/{id}/empates")
    public Score countEmpates(@PathVariable Integer id) {
            var score = scoreRepo.findById(id).orElseThrow();
            score.setEmpates(score.getEmpates()+1);
            scoreRepo.save(score);

        return score;
    }
	@ResponseBody
    @PostMapping("/score/{id}/zerar")
    public Score countZerar(@PathVariable Integer id) {
            var score = scoreRepo.findById(id).orElseThrow();
            score.setVitorias(0);
            score.setDerrotas(0);
            score.setEmpates(0);            
            scoreRepo.save(score);

        return score;
    }
	
}