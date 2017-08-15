package RunningInfoAnalysisService.service;

import RunningInfoAnalysisService.domain.RunningInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RunningInfoService {
    List<RunningInfo> saveRunningInfo(List<RunningInfo> runningInfos);
    void deleteByRunningId(String runningId);
    Page<RunningInfo> findAllByOrderByHeartRateDesc(Pageable pageable);
    void deleteAll();
}
