package QdaaStore.utils;

import java.util.Properties;

public class ConfigUtils {
    private final Properties properties;
    private static ConfigUtils configUtils;
    private ConfigUtils(){
        String environment = System.getProperty("environment","ip");
        switch (environment) {
            case "local" ->
                    properties = new PropertiesUtils().propertiesLoad("src\\test\\java\\QdaaStore\\config\\azka.properties");
            case "ip" ->
                    properties = new PropertiesUtils().propertiesLoad("src\\test\\java\\QdaaStore\\config\\azka_ip.properties");
            default -> throw new RuntimeException("the env doesn't exist");
        }
    }
    public static ConfigUtils getInstance(){
        if (configUtils==null){
            configUtils= new ConfigUtils();
        }
        return configUtils;

    }
    public String getUrl(){
            String property = properties.getProperty("BaseUrl");
            if (property!=null){
            return property;}
        throw new RuntimeException("base Url doesn't exist");
    }

    public String getItemsPage(){
        String property=properties.getProperty("Item");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("items Page Url doesn't exist");
    }
    public String getReceiptStmtPage(){
        String property=properties.getProperty("ReceiptStmt");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Receipt Stmt page doesn't exist");
    }
    public String getExaminationPage(){
        String property=properties.getProperty("Examination");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Examination Page doesn't exist");

    }
    public String getReceiptMemoPage(){
        String property=properties.getProperty("ReceiptMemo");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Receipt Memo Page doesn't exist");

    }

    public String getSpendingOrderPage(){
        String property=properties.getProperty("SpendingOrder");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Spending Order Page doesn't exist");

    }
    public String getReturnsDepartmentPage(){
        String property=properties.getProperty("ReturnsDepartment");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Returns Department Page doesn't exist");

    }
    public String getReturnSpendingOrderPage(){
        String property=properties.getProperty("ReturnSpendingOrder");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Return Spending Order Page doesn't exist");

    }
    public String getItemsTransferPage(){
        String property=properties.getProperty("ItemsTransfeer");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Items Transfer Page doesn't exist");

    }
    public String getBalanceAdjustmentPage(){
        String property=properties.getProperty("BalanceAdjustment");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Items Transfer Page doesn't exist");

    }

    public String getPurOrderPage(){
        String property=properties.getProperty("PurOrder");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("PurOrder Page doesn't exist");

    }
    public String getPurQuoteRequestPage(){
        String property=properties.getProperty("PurQuoteRequest");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Pur Quote Request Page doesn't exist");

    }
    public String getPurQuotePage(){
        String property=properties.getProperty("PurQuote");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Pur Quote Page doesn't exist");

    }
    public String getPurQuoteComparisonPage(){
        String property=properties.getProperty("PurQuoteComparison");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Pur Quote Comparison Page doesn't exist");

    }
    public String getContractPage(){
        String property=properties.getProperty("Contract");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Contract Page doesn't exist");

    }
    public String getTransformPage(){
        String property=properties.getProperty("Transform");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Transform Page doesn't exist");

    }
    public String getItemInfoPage(){
        String property=properties.getProperty("ItemInfo");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("ItemInfo Page doesn't exist");

    }
    public String getReceiptNotifyPage(){
        String property=properties.getProperty("ReceiptNotify");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Receipt Notify Page doesn't exist");

    }

    public String getStoresCuratorPage(){
        String property=properties.getProperty("StoresCurator");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("StoresCurator Page doesn't exist");

    }
    public String getSpendingorderRequestPage(){
        String property=properties.getProperty("SpendingorderRequest");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("SpendingorderRequest Page doesn't exist");

    }
    public String getReturnsDepartmentRequestPage(){
        String property=properties.getProperty("ReturnsDepartmentRequest");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("ReturnsDepartmentRequest Page doesn't exist");

    }
    public String getCompetitionReqPage(){
        String property=properties.getProperty("CompetitionReq");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("CompetitionReq Page doesn't exist");

    }
    public String getInventoryPage(){
        String property=properties.getProperty("Inventory");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Inventory Page doesn't exist");

    }
    public String getClosingFinYearPage(){
        String property=properties.getProperty("ClosingFinYear");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("ClosingFinYear Page doesn't exist");

    }
    public String getSupplierPage(){
        String property=properties.getProperty("Supplier");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Supplier Page doesn't exist");

    }
    public String getItemForShowPage(){
        String property=properties.getProperty("ItemForShow");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("ItemForShow Page doesn't exist");

    }
    public String getClassifyItemPage(){
        String property=properties.getProperty("ClassifyItem");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("ClassifyItem Page doesn't exist");

    }
    public String getPurOrderSummaryPage(){
        String property=properties.getProperty("PurOrderSummary");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("PurOrderSummary Page doesn't exist");

    }
    public String getContractQueryPage(){
        String property=properties.getProperty("ContractQuery");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("ContractQuery Page doesn't exist");

    }
    public String getReceiptStmtMonitoringPage(){
        String property=properties.getProperty("ReceiptStmtMonitoring");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("ReceiptStmtMonitoring Page doesn't exist");

    }
    public String getReceiptMemoMonitoringPage(){
        String property=properties.getProperty("ReceiptMemoMonitoring");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("ReceiptMemoMonitoring Page doesn't exist");

    }
    public String getSpendingOrderMonitoringPage(){
        String property=properties.getProperty("SpendingOrderMonitoring");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("SpendingOrderMonitoring Page doesn't exist");

    }
    public String getInventoryMonitoringPage(){
        String property=properties.getProperty("InventoryMonitoring");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("InventoryMonitoring Page doesn't exist");

    }
    public String getInventoryDepartmentPage(){
        String property=properties.getProperty("InventoryDepartment");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("InventoryDepartment Page doesn't exist");

    }
    public String getSolfaClassificationPage(){
        String property=properties.getProperty("SolfaClassification");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("SolfaClassification Page doesn't exist");

    }
    public String getAppAssetsPage(){
        String property=properties.getProperty("AppAssets");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("AppAssets Page doesn't exist");

    }
    public String getAppAssetDepreciationPage(){
        String property=properties.getProperty("AppAssetDepreciation");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("AppAssetDepreciation Page doesn't exist");

    }
    public String getAppAssetMaintenancePage(){
        String property=properties.getProperty("AppAssetMaintenance");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("AppAssetMaintenance Page doesn't exist");

    }
    public String getAppAssetDisposalPage(){
        String property=properties.getProperty("AppAssetDisposal");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("AppAssetDisposal Page doesn't exist");

    }
    public String getAppAssetDaftarPage(){
        String property=properties.getProperty("AppAssetDaftar");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("AppAssetDaftar Page doesn't exist");

    }
    public String getAppAssetGroupsPage(){
        String property=properties.getProperty("AppAssetGroups");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("AppAssetGroups Page doesn't exist");

    }
    public String getAppAssetTypesPage(){
        String property=properties.getProperty("AppAssetTypes");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("AppAssetTypes Page doesn't exist");

    }
    public String getNewAddedAssetsPage(){
        String property=properties.getProperty("NewAddedAssets");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("NewAddedAssets Page doesn't exist");

    }


    public String getReport20Page(){
        String property=properties.getProperty("Report20");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report20 Page doesn't exist");

    }
    public String getReport21Page(){
        String property=properties.getProperty("Report21");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report21 Page doesn't exist");

    }
    public String getReport22Page(){
        String property=properties.getProperty("Report22");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report22 Page doesn't exist");

    }
    public String getReport23Page(){
        String property=properties.getProperty("Report23");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report23 Page doesn't exist");

    }
    public String getReport24Page(){
        String property=properties.getProperty("Report24");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report24 Page doesn't exist");

    }
    public String getReport31Page(){
        String property=properties.getProperty("Report31");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report31 Page doesn't exist");

    }
    public String getReport30Page(){
        String property=properties.getProperty("Report30");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report30 Page doesn't exist");

    }
    public String getReport42Page(){
        String property=properties.getProperty("Report42");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report42 Page doesn't exist");

    }
    public String getReport43Page(){
        String property=properties.getProperty("Report43");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report43 Page doesn't exist");

    }
    public String getReport65Page(){
        String property=properties.getProperty("Report65");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report65 Page doesn't exist");

    }
    public String getReport74Page(){
        String property=properties.getProperty("Report74");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report74 Page doesn't exist");

    }
    public String getReport66Page(){
        String property=properties.getProperty("Report66");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report66 Page doesn't exist");

    }
    public String getReport67Page(){
        String property=properties.getProperty("Report67");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report67 Page doesn't exist");

    }


    public String getReport25Page(){
        String property=properties.getProperty("Report25");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report25 Page doesn't exist");

    }

    public String getReport26Page(){
        String property=properties.getProperty("Report26");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report26 Page doesn't exist");

    }
    public String getReport27Page(){
        String property=properties.getProperty("Report27");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report27 Page doesn't exist");

    }
    public String getReport28Page(){
        String property=properties.getProperty("Report28");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report28 Page doesn't exist");

    }
    public String getReport29Page(){
        String property=properties.getProperty("Report29");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report9 Page doesn't exist");

    }


    public String getReport101Page(){
        String property=properties.getProperty("Report101");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report101 Page doesn't exist");

    }
    public String getReport102Page(){
        String property=properties.getProperty("Report102");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report102 Page doesn't exist");

    }
    public String getReport103Page(){
        String property=properties.getProperty("Report103");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report103 Page doesn't exist");

    }
    public String getReport104Page(){
        String property=properties.getProperty("Report104");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report104 Page doesn't exist");

    }
    public String getReport1Page(){
        String property=properties.getProperty("Report1");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report1 Page doesn't exist");

    }
    public String getReport2Page(){
        String property=properties.getProperty("Report2");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report2 Page doesn't exist");

    }
    public String getReport3Page(){
        String property=properties.getProperty("Report3");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report3 Page doesn't exist");

    }
    public String getReport4Page(){
        String property=properties.getProperty("Report4");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report4 Page doesn't exist");

    }
    public String getReport5Page(){
        String property=properties.getProperty("Report5");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report5 Page doesn't exist");

    }
    public String getReport6Page(){
        String property=properties.getProperty("Report6");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report6 Page doesn't exist");

    }
    public String getReport7Page(){
        String property=properties.getProperty("Report7");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report7 Page doesn't exist");

    }
    public String getReport8Page(){
        String property=properties.getProperty("Report8");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report8 Page doesn't exist");

    }
    public String getReport9Page(){
        String property=properties.getProperty("Report9");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report9 Page doesn't exist");

    }
    public String getReport10Page(){
        String property=properties.getProperty("Report10");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report10 Page doesn't exist");

    }
    public String getReport11Page(){
        String property=properties.getProperty("Report11");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report11 Page doesn't exist");

    }
    public String getReport12Page(){
        String property=properties.getProperty("Report12");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report12 Page doesn't exist");

    }
    public String getReport13Page(){
        String property=properties.getProperty("Report13");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report13 Page doesn't exist");

    }
    public String getReport14Page(){
        String property=properties.getProperty("Report14");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report14 Page doesn't exist");

    }
    public String getReport15Page(){
        String property=properties.getProperty("Report15");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report15 Page doesn't exist");

    }
    public String getReport16Page(){
        String property=properties.getProperty("Report16");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report16 Page doesn't exist");

    }
    public String getReport17Page(){
        String property=properties.getProperty("Report17");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report17 Page doesn't exist");

    }
    public String getReport18Page(){
        String property=properties.getProperty("Report18");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report18 Page doesn't exist");

    }
    public String getReport19Page(){
        String property=properties.getProperty("Report19");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report19 Page doesn't exist");

    }
    public String getReport51Page(){
        String property=properties.getProperty("Report51");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report51 Page doesn't exist");

    }
    public String getReport39Page(){
        String property=properties.getProperty("Report39");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report39 Page doesn't exist");

    }
    public String getReport47Page(){
        String property=properties.getProperty("Report47");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report47 Page doesn't exist");

    }
    public String getReport49Page(){
        String property=properties.getProperty("Report49");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report49 Page doesn't exist");

    }
    public String getReport50Page(){
        String property=properties.getProperty("Report50");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Report50 Page doesn't exist");

    }















}
