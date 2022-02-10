package com.depanneur_ste_helene.inventory_system.presentationlayer;

import com.depanneur_ste_helene.inventory_system.businesslayer.report.ReportService;
import com.depanneur_ste_helene.inventory_system.datalayer.report.ValueReport;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ReportRESTController {
    @Autowired
    private final ReportService SERVICE;

    ReportRESTController(ReportService service) {this.SERVICE = service;}

    @CrossOrigin
    @GetMapping("/report/value")
    public ValueReport getValueReport() {
        return SERVICE.getInventoryValue();
    }
}
