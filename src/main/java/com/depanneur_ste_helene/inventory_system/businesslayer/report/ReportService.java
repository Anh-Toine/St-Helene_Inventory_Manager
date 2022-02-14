package com.depanneur_ste_helene.inventory_system.businesslayer.report;

import com.depanneur_ste_helene.inventory_system.datalayer.report.BestSellingReport;
import com.depanneur_ste_helene.inventory_system.datalayer.report.ValueReport;

public interface ReportService {
    ValueReport getInventoryValue();
    BestSellingReport getBestSelling();
}
