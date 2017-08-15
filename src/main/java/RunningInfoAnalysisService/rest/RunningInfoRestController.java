package RunningInfoAnalysisService.rest;

import RunningInfoAnalysisService.domain.RunningInfo;
import RunningInfoAnalysisService.service.RunningInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RunningInfoRestController {
    @Autowired
    private RunningInfoService runningInfoService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInfo> runningInfos) {
        runningInfoService.saveRunningInfo(runningInfos);
    }

    @RequestMapping(value = "/info/{page}", method = RequestMethod.GET)
    public Page<RunningInfo> findAll(@PathVariable int page) {
        return runningInfoService.findAllByOrderByHeartRateDesc(new PageRequest(page, 2));
    }

    @RequestMapping(value = "/purge/{runningId}", method = RequestMethod.DELETE)
    public void deleteByRunningId(@PathVariable String runningId) {
        runningInfoService.deleteByRunningId(runningId);
    }

    @RequestMapping(value="/purge", method=RequestMethod.DELETE)
    public void purge() {
        this.runningInfoService.deleteAll();
    }
}
