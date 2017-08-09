import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/** Courtesy of Ashley**/
public class TestReport {

    private ExtentReports report;
    private ExtentTest test;
    private String reportFilePath = "report.html";

    @BeforeClass
    public static void init(){

    }

    @Before
    public void setUp(String a){
        report = new ExtentReports();
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentHtmlReporter.config().setReportName("ReportName");
        extentHtmlReporter.config().setDocumentTitle("DocumentTitle");
        report.attachReporter(extentHtmlReporter);
        test = report.createTest(a);
    }



    public ExtentReports getReport() {

        return report;
    }

    public ExtentTest getExtentTest() {

        return test;
    }




}
