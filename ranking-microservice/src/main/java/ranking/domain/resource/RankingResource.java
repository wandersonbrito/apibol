package ranking.domain.resource;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ranking.domain.RankingElement;
import ranking.domain.repository.model.RankingTO;
import ranking.domain.service.RankingService;

import java.util.List;

/**
 * Ranking Resource expose the ranking operations
 * @author Claudio E. de Oliveira on on 03/04/16.
 */
@RestController
@RequestMapping(value = "/")
@Api(value = "/ranking", description = "Operations about rankings")
public class RankingResource {

    private final RankingService rankingService;

    @Autowired
    public RankingResource(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @RequestMapping(value = "/{predctorId}", method = RequestMethod.GET)
    public ResponseEntity<List<RankingTO>> findByPredictor(@PathVariable("predictorId") String predictorId) {
        return new ResponseEntity<>(this.rankingService.findRanking(predictorId), HttpStatus.OK);
    }

}
