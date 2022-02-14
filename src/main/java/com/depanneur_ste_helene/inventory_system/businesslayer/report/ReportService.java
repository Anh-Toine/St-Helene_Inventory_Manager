package com.depanneur_ste_helene.inventory_system.businesslayer.report;

import com.depanneur_ste_helene.inventory_system.datalayer.report.BestSellingReport;
import com.depanneur_ste_helene.inventory_system.datalayer.report.ValueReport;
import com.depanneur_ste_helene.inventory_system.datalayer.report.WorstSellingReport;

public interface ReportService {
    ValueReport getInventoryValue();
    BestSellingReport getBestSelling();
    WorstSellingReport getWorstSelling();
    void endOfMonthQtySoldReset();
}
