package com.pentasecurity.edge.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pentasecurity.edge.service.EdgeDataService;

@Profile("AutoDataCreator1")
@Component
public class CreateDataJob1 {
    Logger logger = LoggerFactory.getLogger("mainLogger");

    @Value("${edge.data-download-rate}")
    private double dataDownloadRate;
    @Value("${edge.data-delete-rate}")
    private double dataDeleteRate;

    @Autowired
    EdgeDataService edgeDataService;

    /**
     * 1시간마다 실행
     * 초 분 시 일 월 요일
     */
    @Scheduled(cron="0 0 * * * *")
    public void job()
    {
    	edgeDataService.registerUploadTask(10, 10, 100, 200, true);
    }
}
