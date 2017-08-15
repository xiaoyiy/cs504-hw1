package RunningInfoAnalysisService.service.impl;

import RunningInfoAnalysisService.domain.RunningInfo;
import RunningInfoAnalysisService.domain.RunningInfoRepository;
import RunningInfoAnalysisService.service.RunningInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Service
public class RunningInfoServiceImpl implements RunningInfoService {
    @Autowired
    private RunningInfoRepository runningInfoRepository;

    @Override
    public List<RunningInfo> saveRunningInfo(List<RunningInfo> runningInfos) {
        Random rand = new Random();
        for (int i = 0; i < runningInfos.size(); i++) {
            int value = rand.nextInt(141) + 60;
            runningInfos.get(i).setHeartRate(value);
        }
        return runningInfoRepository.save(runningInfos);
    }

    @Override
    @Transactional
    public void deleteByRunningId(String runningId) {
        runningInfoRepository.deleteByRunningId(runningId);
    }

    @Override
    public Page<RunningInfo> findAllByOrderByHeartRateDesc(Pageable pageable) {
        return runningInfoRepository.findAllByOrderByHeartRateDesc(pageable);
    }

    @Override
    public void deleteAll() {
        runningInfoRepository.deleteAll();
    }
}
